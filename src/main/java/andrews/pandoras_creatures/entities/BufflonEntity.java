package andrews.pandoras_creatures.entities;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import javax.annotation.Nullable;

import andrews.pandoras_creatures.container.BufflonContainer;
import andrews.pandoras_creatures.entities.bases.AnimatedCreatureEntity;
import andrews.pandoras_creatures.entities.goals.BufflonFollowOwnerGoal;
import andrews.pandoras_creatures.entities.goals.BufflonNonTamedTargetGoal;
import andrews.pandoras_creatures.entities.goals.BufflonOwnerHurtByTargetGoal;
import andrews.pandoras_creatures.entities.goals.BufflonOwnerHurtTargetGoal;
import andrews.pandoras_creatures.entities.goals.BufflonSitGoal;
import andrews.pandoras_creatures.registry.PCEntities;
import andrews.pandoras_creatures.registry.PCItems;
import andrews.pandoras_creatures.registry.PCSounds;
import andrews.pandoras_creatures.util.animation.Animation;
import andrews.pandoras_creatures.util.network.NetworkUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.GhastEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.passive.IFlyingAnimal;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.IInventoryChangedListener;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.scoreboard.Team;
import net.minecraft.server.management.PreYggdrasilConverter;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.GameRules;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.Constants.NBT;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.registries.ForgeRegistries;

public class BufflonEntity extends AnimatedCreatureEntity implements IInventoryChangedListener
{
	private static Biome[] biomes = new Biome[] {Biomes.SNOWY_TUNDRA, Biomes.FROZEN_RIVER, Biomes.SNOWY_MOUNTAINS};
	
	//Stores the Bufflon type
	private static final DataParameter<Integer> BUFFLON_TYPE = EntityDataManager.createKey(BufflonEntity.class, DataSerializers.VARINT);
	//Stores whether or not the Bufflon is tamed and the UUID of the owner
	private static final DataParameter<Byte> TAMED = EntityDataManager.createKey(BufflonEntity.class, DataSerializers.BYTE);
	private static final DataParameter<Optional<UUID>> OWNER_UNIQUE_ID = EntityDataManager.createKey(BufflonEntity.class, DataSerializers.OPTIONAL_UNIQUE_ID);
	//Store the information of the attachments
	private static final DataParameter<Boolean> IS_SADDLED = EntityDataManager.createKey(BufflonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Integer> BACK_ATTACHMENT_TYPE = EntityDataManager.createKey(BufflonEntity.class, DataSerializers.VARINT);
	//Stores whether or not the Bufflon is sitting
	private static final DataParameter<Boolean> IS_SITTING = EntityDataManager.createKey(BufflonEntity.class, DataSerializers.BOOLEAN);
	//Stores whether or not the Bufflon is following
	private static final DataParameter<Boolean> IS_FOLLOWING = EntityDataManager.createKey(BufflonEntity.class, DataSerializers.BOOLEAN);
	//Stores whether or not the Bufflon is in combat mode
	private static final DataParameter<Boolean> COMBAT_MODE = EntityDataManager.createKey(BufflonEntity.class, DataSerializers.BOOLEAN);
	
	//The Items that can be used in given slots;
	public static final Item SADDLE_ITEM = PCItems.BUFFLON_SADDLE;
	public static final Item[] VALID_BACK_ATTACHMENTS = {PCItems.BUFFLON_PLAYER_SEATS, PCItems.BUFFLON_SMALL_STORAGE, PCItems.BUFFLON_LARGE_STORAGE};
	
	private int thinkTime;
	private int feedingCooldown;
	public Inventory bufflonStorage;
	public BufflonSitGoal bufflonSitGoal;
	
	public static final Animation THROW_ANIMATION = new Animation(12);
	public static final Animation ATTACK_HEAD_ANIMATION = new Animation(12);
	
    public BufflonEntity(EntityType<? extends BufflonEntity> type, World worldIn)
    {
        super(type, worldIn);
        this.stepHeight = 1.0F;
        this.initBufflonStorage();
    }

    public BufflonEntity(World world, double posX, double posY, double posZ)
    {
        this(PCEntities.BUFFLON, world);
        this.setPosition(posX, posY, posZ);
    }
    
    @Override
    protected void registerGoals()
    {
    	//Goal Selector
    	this.bufflonSitGoal = new BufflonSitGoal(this);
    	this.goalSelector.addGoal(1, new SwimGoal(this));
    	this.goalSelector.addGoal(2, this.bufflonSitGoal);
    	this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 0.5D));
    	this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 0.55D, true));
    	this.goalSelector.addGoal(5, new BufflonFollowOwnerGoal(this, 0.55D, 10.0F, 2.0F));
    	this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
    	this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
    	//Target Selector
    	this.targetSelector.addGoal(1, new BufflonOwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new BufflonOwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setCallsForHelp());
        this.targetSelector.addGoal(4, new BufflonNonTamedTargetGoal<>(this, PlayerEntity.class, false));
    }

    @Override
    protected void registerAttributes()
    {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.55D);
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(60.0D);
        this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10.0D);
    }
    
    @Override
	protected void registerData()
    {
		super.registerData();
		this.dataManager.register(BUFFLON_TYPE, 0);
		this.dataManager.register(TAMED, (byte)0);
		this.dataManager.register(OWNER_UNIQUE_ID, Optional.empty());
		this.dataManager.register(IS_SADDLED, false);
		this.dataManager.register(BACK_ATTACHMENT_TYPE, 0);
		this.dataManager.register(IS_SITTING, false);
		this.dataManager.register(IS_FOLLOWING, false);
		this.dataManager.register(COMBAT_MODE, false);
    }
    
    @Override
	public void writeAdditional(CompoundNBT compound)
    {
		super.writeAdditional(compound);
		//The Bufflon Variant
		compound.putInt("BufflonType", this.getBufflonType());
		//If this entity is saddled
		compound.putBoolean("IsSaddled", this.isSaddled());
		//If this entity is sitting
		compound.putBoolean("IsSitting", this.isSitting());
		//If this entity is following
		compound.putBoolean("IsFollowing", this.isFollowingOwner());
		//If this entity is in combat mode
		compound.putBoolean("IsInCombatMode", this.isInCombatMode());
		//The back attachment type this Entity has
		compound.putInt("BackAttachmentType", this.getBackAttachmentType());
		//The Owner of the Bufflon
		if(this.getOwnerId() == null)
		{
			compound.putString("OwnerUUID", "");
	   	}
		else
		{
			compound.putString("OwnerUUID", this.getOwnerId().toString());
	   	}
		
		//Storing the Items inside the Bufflons Inventory
		if(this.isTamed())
		{
			ListNBT listnbt = new ListNBT();
			for(int i = 0; i < this.bufflonStorage.getSizeInventory(); ++i)
			{
				ItemStack itemstack = this.bufflonStorage.getStackInSlot(i);
				if(!itemstack.isEmpty())
				{
					CompoundNBT compoundnbt = new CompoundNBT();
					compoundnbt.putByte("Slot", (byte)i);
					itemstack.write(compoundnbt);
					listnbt.add(compoundnbt);
				}
			}
			compound.put("Items", listnbt);
		}
	}
	
	@Override
	public void readAdditional(CompoundNBT compound)
	{
		super.readAdditional(compound);
		//The Bufflon Variant
		this.setBufflonType(compound.getInt("BufflonType"));
		//If this entity is saddled
		this.setSaddled(compound.getBoolean("IsSaddled"));
		//If this entity is sitting
		if(this.bufflonSitGoal != null)
		{
			this.bufflonSitGoal.setSitting(compound.getBoolean("IsSitting"));
		}
		this.setSitting(compound.getBoolean("IsSitting"));
		//If this entity is following
		this.setFollowingOwner(compound.getBoolean("IsFollowing"));
		//If this entity is in combat mode
		this.setIsInCombatMode(compound.getBoolean("IsInCombatMode"));
		//The back attachment type this Entity has
		this.setBackAttachment(compound.getInt("BackAttachmentType"));
		//The Owner of the Bufflon
		String s;
	    if(compound.contains("OwnerUUID", NBT.TAG_STRING))
	    {
	    	s = compound.getString("OwnerUUID");
	  	}
	    else
	    {
	    	String s1 = compound.getString("Owner");
	    	s = PreYggdrasilConverter.convertMobOwnerIfNeeded(this.getServer(), s1);
		}
	    //Attempts to set the Bufflon as tamed 
		if(!s.isEmpty())
		{
			try
			{
	        	this.setOwnerId(UUID.fromString(s));
	            this.setTamed(true);
	        }
			catch(Throwable var4)
			{
				this.setTamed(false);
	        }
		}
		
		//Loading the stored Items inside the Bufflons Inventory
		if(this.isTamed())
		{
			ListNBT listnbt = compound.getList("Items", 10);
	     	this.initBufflonStorage();
	     	for(int i = 0; i < listnbt.size(); ++i)
	     	{
	     		CompoundNBT compoundnbt = listnbt.getCompound(i);
	            int j = compoundnbt.getByte("Slot") & 255;
	            if(j >= 0 && j < this.bufflonStorage.getSizeInventory())
	            {
	            	this.bufflonStorage.setInventorySlotContents(j, ItemStack.read(compoundnbt));
	            }
	     	}
		}
		
		this.updateBufflonSlots();
	}
	
	@Nullable
	@Override
	public ILivingEntityData onInitialSpawn(IWorld world, DifficultyInstance difficulty, SpawnReason reason, ILivingEntityData spawnData, CompoundNBT dataTag)
	{
		spawnData = super.onInitialSpawn(world, difficulty, reason, spawnData, dataTag);
		Random rand = new Random();
		int type = rand.nextInt(7) + 1;
		if(dataTag != null && dataTag.contains("BufflonType", NBT.TAG_INT))
		{
			this.setBufflonType(dataTag.getInt("BufflonType"));
			return spawnData;
		}
		this.setBufflonType(type);
		return spawnData;
	}
	
	@Override
	public boolean canBeLeashedTo(PlayerEntity player)
	{
		return false;
	}
	
	@Override
	protected int getExperiencePoints(PlayerEntity player)
	{
		return 1 + this.world.rand.nextInt(3);
	}
    
    @Override
    protected boolean processInteract(PlayerEntity player, Hand hand)
    {
    	ItemStack itemstack = player.getHeldItem(hand);
        if(itemstack.getItem() == PCItems.HERB_BUNDLE)
        {
        	//Is Not Tamed
        	if(!this.world.isRemote && !this.isTamed())
        	{
        		if(feedingCooldown <= 0)
        		{
        			feedingCooldown = 10;
        			this.world.playSound((PlayerEntity)null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_HORSE_EAT, this.getSoundCategory(), 1.0F, 1.0F);
		    		if(!player.abilities.isCreativeMode)
		    		{
		                itemstack.shrink(1);
		            }
		    		
		    		if(this.rand.nextInt(3) == 0)
		    		{
		    			mountTo(player);
		    		}
		    		else
		    		{
		    			this.playTameEffect(false);
		    			this.world.setEntityState(this, (byte)6);
		            }
        		}
        	}
        	//Is Tamed
        	else if(!this.world.isRemote && this.isTamed())
        	{
        		if(this.getHealth() < this.getMaxHealth())
        		{
        			this.heal(2.0F);
        			this.world.playSound((PlayerEntity)null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_HORSE_EAT, this.getSoundCategory(), 1.0F, 1.0F);
        			if(!player.abilities.isCreativeMode)
		    		{
		                itemstack.shrink(1);
		            }
        		}
        		else
        		{
        			if(player.isSneaking())
            		{
            			this.openGUI(player);
            		}
            		else
            		{
            			mountTo(player);
            		}
        		}
        	}
        	return true;
        }
        else if(this.isTamed() && !this.isSaddled() && itemstack.getItem() == SADDLE_ITEM)
        {
        	this.openGUI(player);
            return true;
        }
        else if(this.isTamed() && !this.hasBackAttachment() && Arrays.asList(VALID_BACK_ATTACHMENTS).contains(itemstack.getItem()))
        {
        	this.openGUI(player);
            return true;
        }
        else if(itemstack.getItem() == Items.AIR)
        {
        	if(this.isTamed() && player.isSneaking())
        	{
                this.openGUI(player);
        	}
        	else if(this.isTamed() && !player.isSneaking())
        	{
        		mountTo(player);
        	}
        	return true;
        }
        else
        {
        	return super.processInteract(player, hand);
        }
    }
    
    @Override
    public boolean attackEntityAsMob(Entity entityIn)
    {
    	boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)((int)this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue()));
    	//The attack sound
    	this.world.playSound((PlayerEntity)null, this.posX, this.posY, this.posZ, PCSounds.BUFFLON_ATTACK, this.getSoundCategory(), 0.6F, 0.8F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F);
    	//The attack animation
    	if(this.isAnimationPlaying(BLANK_ANIMATION) && !this.getEntityWorld().isRemote())
    	{
    		NetworkUtil.setPlayingAnimationMessage(this, ATTACK_HEAD_ANIMATION);
    	}
    	
        if(flag)
        {
        	entityIn.setMotion(entityIn.getMotion().add(this.getPositionVec().subtract(entityIn.getPositionVec()).mul(-0.15D, 0.0D, -0.15D)));
        	entityIn.velocityChanged = true;
        	this.applyEnchantments(this, entityIn);
        }
        return flag;
    }
    
    /**
     * Used in Goals to avoid fighting of tamed entities
     */
    public boolean shouldAttackEntity(LivingEntity target, LivingEntity owner)
    {
    	if(!(target instanceof CreeperEntity) && !(target instanceof GhastEntity))
    	{
    		//Protects Tamed Dog Entities
    		if(target instanceof WolfEntity)
    		{
    			WolfEntity wolfentity = (WolfEntity)target;
    			if(wolfentity.isTamed() && wolfentity.getOwner() == owner)
    			{
    				return false;
    			}
    		}
    		
    		//Protects Tamed Bufflon Entities
    		if(target instanceof BufflonEntity)
    		{
    			BufflonEntity bufflonEntity = (BufflonEntity)target;
    			if(bufflonEntity.isTamed() && bufflonEntity.getOwner() == owner)
    			{
    				return false;
    			}
    		}

    		//Protects none attackable Players
    		if(target instanceof PlayerEntity && owner instanceof PlayerEntity && !((PlayerEntity)owner).canAttackPlayer((PlayerEntity)target))
    		{
    			return false;
    		}
    		//Protects tamed Horses
    		else if(target instanceof AbstractHorseEntity && ((AbstractHorseEntity)target).isTame())
    		{
    			return false;
    		}
    		//Protects tamed Cats
    		else
    		{
    			return !(target instanceof CatEntity) || !((CatEntity)target).isTamed();
    		}
    	}
    	else
    	{
    		return false;
    	}
	}
    
	/**
    * Called when the entity is attacked.
    */
	@Override
	public boolean attackEntityFrom(DamageSource source, float amount)
	{
		if(this.isInvulnerableTo(source))
		{
			return false;
		}
		else
		{
			Entity entity = source.getTrueSource();
			if(this.bufflonSitGoal != null && this.isInCombatMode())
			{
				this.bufflonSitGoal.setSitting(false);
			}

			if(entity != null && !(entity instanceof PlayerEntity) && !(entity instanceof AbstractArrowEntity))
			{
				amount = (amount + 1.0F) / 2.0F;
			}

			return super.attackEntityFrom(source, amount);
		}
	}
    
    @Override
    public void livingTick()
    {
    	super.livingTick();
    	
    	//Makes it so the Bufflon gains health slowly "regeneration"
    	if(!this.world.isRemote && this.isAlive())
    	{
    		if(this.rand.nextInt(900) == 0 && this.deathTime == 0)
    		{
               this.heal(1.0F);
            }
    	}
    	
    	if(feedingCooldown > 0)
    	{
    		feedingCooldown--;
    	}
    	
    	if(!world.isRemote && !this.isTamed() && this.isBeingRidden())
    	{
    		if(thinkTime > 0)
    		{
    			thinkTime--;
    		}
    		else
    		{
    			if(this.rand.nextInt(4) == 0)
        		{
        			this.setTamedBy((PlayerEntity) this.getPassengers().get(0));
        			this.navigator.clearPath();
        			this.setAttackTarget((LivingEntity)null);
        			this.playTameEffect(true);
        			this.world.setEntityState(this, (byte)7);
        		}
        		else
        		{
        			this.world.playSound((PlayerEntity)null, this.posX, this.posY, this.posZ, PCSounds.BUFFLON_ATTACK, this.getSoundCategory(), 0.6F, 0.8F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F);
        			//Removes the Passengers
        			for(int i = this.getPassengers().size() - 1; i >= 0; --i)
        			{
        				Entity entity = this.getPassengers().get(i);
        				entity.stopRiding();
        				entity.setMotion(entity.getMotion().add((rand.nextInt(3) - 1) * 0.3D, (double)1.2F, (rand.nextInt(3) - 1) * 0.3D));
        				entity.velocityChanged = true;
        				NetworkUtil.setPlayingAnimationMessage(this, THROW_ANIMATION);
        		   	}
        			this.playTameEffect(false);
        			this.world.setEntityState(this, (byte)6);
                }
    		}
    	}
    }
    
    @Override
	public Animation[] getAnimations()
    {
		return new Animation[] {THROW_ANIMATION, ATTACK_HEAD_ANIMATION};
	}
    
    @Override
    protected SoundEvent getAmbientSound()
    {
    	return PCSounds.BUFFLON_AMBIENT;
    }
    
    @Override
    protected SoundEvent getDeathSound()
    {
    	return PCSounds.BUFFLON_DEATH;
    }
    
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
    	return PCSounds.BUFFLON_HURT;
    }
    
    @Override
    protected float getSoundVolume()
    {
    	return 0.6F;
    }
    
    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn)
    {
        return sizeIn.height * 0.5F;
    }
    
    /**
     * Gets called when passengers get updated
     */
    @Override
    public void updatePassenger(Entity passenger)
    {
    	super.updatePassenger(passenger);
    	if(this.isPassenger(passenger))//Makes sure the passenger entity is actually an passenger
    	{
    		float offsetX = 0F;
    		float offsetY = 0F;
            if(this.getPassengers().size() > 0)
            {
            	int i = this.getPassengers().indexOf(passenger);
            	if(i == 0) //The first passenger
            	{
            		if(!this.isSaddled())
            		{
            			offsetY = -0.08F;
            		}
            		offsetX = 0.95F;
            		offsetY += 2.3F - getPassengerMovement();
            	}
            	else if(i == 1) //The second passenger
            	{
            		offsetX = -0.9F;
            		if(this.isMoving())
            		{
            			offsetY += 2.1F - (getPassengerMovement() * 1.4F);
            		}
            		else
            		{
            			offsetY += 2.1F - getPassengerMovement();
            		}
            		//Locks the player head rotation to a certain amount of degrees so he cant rotate his head 360 degrees
                    passenger.setRotationYawHead(passenger.getRotationYawHead());
                    this.applyYawToEntity(passenger);
            	}
            	else //The third passenger
            	{
            		offsetX = -1.59F;
            		if(this.isMoving())
            		{
            			offsetY += 2.0F - (getPassengerMovement() * 1.4F);
            		}
            		else
            		{
            			offsetY += 2.0F - getPassengerMovement();
            		}
            		//Locks the player head rotation to a certain amount of degrees so he cant rotate his head 360 degrees
                    passenger.setRotationYawHead(passenger.getRotationYawHead());
                    this.applyYawToEntity(passenger);
            	}
            }

            Vec3d vec3d = (new Vec3d((double)offsetX, 0.0D, 0.0D)).rotateYaw(-this.rotationYaw * ((float)Math.PI / 180F) - ((float)Math.PI / 2F));
            passenger.setPosition(this.posX + vec3d.x, this.posY + (double)offsetY, this.posZ + vec3d.z);
         }
    }
    
    /**
     * Applies this Bufflons's yaw to the given entity. Used to update the orientation of its passenger.
     */
    private void applyYawToEntity(Entity entityToUpdate)
    {
    	entityToUpdate.setRenderYawOffset(this.rotationYaw);
    	float f = MathHelper.wrapDegrees(entityToUpdate.rotationYaw - this.rotationYaw);
    	float f1 = MathHelper.clamp(f, -105.0F, 105.0F);
    	entityToUpdate.prevRotationYaw += f1 - f;
    	entityToUpdate.rotationYaw += f1 - f;
    	entityToUpdate.setRotationYawHead(entityToUpdate.rotationYaw);
    }
    
    /**
     * Checks whether or not this entity can despawn
     * @param distanceToClosestPlayer - The distance to the closest player
     * @return - Returns if this entity can despawn
     */
    @Override
    public boolean canDespawn(double distanceToClosestPlayer)
    {
    	return false;
    }

    /**
     * Prevents this entity from despawning
     * @return - True if this entity is prevented from despawning
     */
    @Override
    public boolean preventDespawn()
    {
    	return this.isTamed();
    } 
    
    
    //======================================================================================================================================================
    
    protected void initBufflonStorage()
    {
    	Inventory inventory = this.bufflonStorage;
    	this.bufflonStorage = new Inventory(this.getInventorySize());
        if(inventory != null)
        {
        	inventory.removeListener(this);
        	int i = Math.min(inventory.getSizeInventory(), this.bufflonStorage.getSizeInventory());

        	for(int j = 0; j < i; ++j)
        	{
        		ItemStack itemstack = inventory.getStackInSlot(j);
        		if(!itemstack.isEmpty())
        		{
        			this.bufflonStorage.setInventorySlotContents(j, itemstack.copy());
        		}
        	}
        }
        this.bufflonStorage.addListener(this);
        this.updateBufflonSlots();
        this.itemHandler = net.minecraftforge.common.util.LazyOptional.of(() -> new net.minecraftforge.items.wrapper.InvWrapper(this.bufflonStorage));
	}
    
    /**
     * @return - The size of the inventory this Entity has
     */
    protected int getInventorySize()
    {
    	return 56;
	}
    
    /**
     * Updates the items in the slots of the Bufflon's inventory.
     */
    protected void updateBufflonSlots()
    {
    	if (!this.world.isRemote)
    	{
    		//Sets the Bufflon to being Saddled
    		this.setSaddled(!this.bufflonStorage.getStackInSlot(0).isEmpty());
    		
    		//Sets the Bufflon back attachments
    		if(!this.bufflonStorage.getStackInSlot(1).isEmpty())
    		{
    			Item itemInSlot = this.bufflonStorage.getStackInSlot(1).getItem();
    			if(Arrays.asList(VALID_BACK_ATTACHMENTS).contains(itemInSlot))
    			{
    				this.setBackAttachment(this.getItemBackAttachmentType(itemInSlot));
    			}
    		}
    		else
    		{
    			//If no Saddle item is in the slot it updates the value to match it
    			if(this.getBackAttachmentType() != 0)
    			{
    				this.setBackAttachment(0);
    			}
    		}
    	}
	}
    
	/**
     * Called by InventoryBasic.onInventoryChanged() on a array that is never filled.
     */
    public void onInventoryChanged(IInventory invBasic)
    {
    	//The Bufflon Gear Slots Flags
    	boolean flagIsSaddled = this.isSaddled();
    	boolean flagHasBackAttachment = this.hasBackAttachment();
    	
    	this.updateBufflonSlots();
    	
    	//The Bufflon Saddle Sound
    	if(this.ticksExisted > 20 && !flagIsSaddled && this.isSaddled())
    	{
    		this.playSound(SoundEvents.ENTITY_HORSE_SADDLE, 0.5F, 1.0F);
    	}
    	//The Bufflon Back Attachments Sound
    	if(this.ticksExisted > 20 && !flagHasBackAttachment && this.hasBackAttachment())
    	{
    		this.playSound(SoundEvents.ENTITY_HORSE_SADDLE, 0.5F, 1.0F);
    	}
	}
    
    @Override
    protected void dropInventory()
    {
    	super.dropInventory();
        if(this.bufflonStorage != null)
        {
        	for(int i = 0; i < this.bufflonStorage.getSizeInventory(); ++i)
        	{
        		ItemStack itemstack = this.bufflonStorage.getStackInSlot(i);
        		if(!itemstack.isEmpty())
        		{
        			this.entityDropItem(itemstack);
        		}
        	}
        }
	}
    
    //======================================================================================================================================================
    
    @Override
    public void travel(Vec3d p_213352_1_)
    {
    	if(this.isAlive())
    	{
    		if(this.isBeingRidden())
    		{
	    		LivingEntity livingentity = (LivingEntity)this.getControllingPassenger();
				this.rotationYaw = livingentity.rotationYaw;
				this.prevRotationYaw = this.rotationYaw;
				this.rotationPitch = livingentity.rotationPitch * 0.5F;
				this.setRotation(this.rotationYaw, this.rotationPitch);
				this.renderYawOffset = this.rotationYaw;
				this.rotationYawHead = this.renderYawOffset;
				
	    		if(this.canBeSteered() && this.isSaddled())
	    		{
	    			float f = livingentity.moveStrafing * 0.5F;
	    			float f1 = livingentity.moveForward;
	    			if(f1 <= 0.0F)
	    			{
	    				f1 *= 0.25F;;
	    			}
	    			
	    			if(this.canPassengerSteer())
	    			{
	    				this.setAIMoveSpeed(0.2F);
	    				super.travel(new Vec3d((double)f, p_213352_1_.y, (double)f1));
	    			}
	    			else if(livingentity instanceof PlayerEntity)
	    			{
	    				this.setMotion(Vec3d.ZERO);
	    			}
	    			
	    			//Some code so other people see the walk animation
	    			this.prevLimbSwingAmount = this.limbSwingAmount;
	    		  	double finalPosX = this.posX - this.prevPosX;
	    			double finalPosZ = this.posZ - this.prevPosZ;
	    			double finalPosY = this instanceof IFlyingAnimal ? this.posY - this.prevPosY : 0.0D;
	    			float swingAmountModifier = MathHelper.sqrt(finalPosX * finalPosX + finalPosY * finalPosY + finalPosZ * finalPosZ) * 4.0F;
	    		   	if(swingAmountModifier > 1.0F)
	    		   	{
	    		   		swingAmountModifier = 1.0F;
	    			}
	    		   	
	    		   	this.limbSwingAmount += (swingAmountModifier - this.limbSwingAmount) * 0.4F;
	    		   	this.limbSwing += this.limbSwingAmount;
	    		}
    		}
	    	else
    		{
    			super.travel(p_213352_1_);
            }
    	}
    }
    
    /**
     * Wether or not this entity can be riden in water
     */
    @Override
    public boolean canBeRiddenInWater()
    {
    	return false;
    }
    
    /**
     * returns true if all the conditions for steering the entity are met. For pigs, this is true if it is being ridden
     * by a player and the player is holding a carrot-on-a-stick
     */
    @Override
    public boolean canBeSteered()
    {
    	return this.getControllingPassenger() instanceof LivingEntity;
    }
    
    /**
     * For vehicles, the first passenger is generally considered the controller and "drives" the vehicle. For example,
     * Pigs, Horses, and Boats are generally "steered" by the controlling passenger.
     */
    @Override
    public Entity getControllingPassenger()
    {
    	return this.getPassengers().isEmpty() ? null : this.getPassengers().get(0);
    }
    
    /**
     * Used by the entity to determine how many passengers it can have
     */
    @Override
    protected boolean canFitPassenger(Entity passenger)
    {
    	//Makes sure the Entity is not under water
    	if(!this.areEyesInFluid(FluidTags.WATER))
    	{
    		if(this.hasBackAttachment() && this.getBackAttachmentType() == 1) //The Bufflon Player Seats attachment
    		{
    			return this.getPassengers().size() < 3;
    		}
    		else if(this.hasBackAttachment() && this.getBackAttachmentType() == 2) //The Bufflon Small Storage attachment
    		{
    			return this.getPassengers().size() < 2;
    		}
    		else
    		{
    			return this.getPassengers().size() < 1;
    		}
    	}
    	else
    	{
    		return false;
    	}
    }
    
    //======================================================================================================================================================
    
    public float getPassengerMovement()
    {
        float height = 0.06F;
        float bounce = 0;
        if(!isMoving())
        {
        	height = 0.03F;
        	float speed = 0.24F;
        	bounce = (float) (Math.sin(this.ticksExisted * speed) * 1 * height - 1 * height);
        }
        else
        {
        	height = 0.05F;
        	float speed = 0.45F;
        	bounce = (float) (Math.sin(limbSwing * speed - 0.04F) * limbSwingAmount * height - limbSwingAmount * height);
        }
        
        return bounce + 0.08F;
    }
    
    public boolean isMoving()
    {
    	if(this.posX != prevPosX || this.posZ != this.prevPosZ)
    	{
    		return true;
    	}
    	return false;
    }
    
    /**
     * Play the taming effect, will either be hearts or smoke depending on status
     */
    protected void playTameEffect(boolean play)
    {
    	IParticleData iparticledata = ParticleTypes.HEART;
    	if(!play)
    	{
    		iparticledata = ParticleTypes.SMOKE;
    	}

    	for(int i = 0; i < 7; ++i)
    	{
    		double d0 = this.rand.nextGaussian() * 0.02D;
    		double d1 = this.rand.nextGaussian() * 0.02D;
    		double d2 = this.rand.nextGaussian() * 0.02D;
    		this.world.addParticle(iparticledata, this.posX + (double)(this.rand.nextFloat() * this.getWidth() * 2.0F) - (double)this.getWidth(), this.posY + 0.5D + (double)(this.rand.nextFloat() * this.getHeight()), this.posZ + (double)(this.rand.nextFloat() * this.getWidth() * 2.0F) - (double)this.getWidth(), d0, d1, d2);
    	}
    }

    /**
     * Handler for {@link World#setEntityState}
     */
    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id)
    {
    	if(id == 7)
    	{
    		this.playTameEffect(true);
    	}
    	else if(id == 6)
    	{
    		this.playTameEffect(false);
    	}
    	else
    	{
    		super.handleStatusUpdate(id);
    	}
	}
    
    /**
     * Mounts the given player to this entity
     */
    private void mountTo(PlayerEntity player)
    {
    	if(!this.world.isRemote)
        {
        	player.rotationYaw = this.rotationYaw;
        	player.rotationPitch = this.rotationPitch;
        	player.startRiding(this);
        	this.thinkTime = 40;
        }
    }
    
    /**
     * @return - Wether or not this Entity is in Combat Mode
     */
    public boolean isInCombatMode()
    {
       return this.dataManager.get(COMBAT_MODE);
    }
    
    /**
     * Sets the combat mode of the entity to true or false
     * @param value - Should be sitting
     */
    public void setIsInCombatMode(boolean value)
    {
    	this.dataManager.set(COMBAT_MODE, value);
    }
    
    /**
     * @return - Wether or not this Entity is Following its owner
     */
    public boolean isFollowingOwner()
    {
       return this.dataManager.get(IS_FOLLOWING);
    }
    
    /**
     * Sets the entity to Follow the owner true or false
     * @param value - Should be sitting
     */
    public void setFollowingOwner(boolean value)
    {
    	this.dataManager.set(IS_FOLLOWING, value);
    }
    
    /**
     * @return - Wether or not this Entity is Sitting
     */
    public boolean isSitting()
    {
       return this.dataManager.get(IS_SITTING);
    }
    
    /**
     * Sets the entity to Sitting true or false
     * @param value - Should be sitting
     */
    public void setSitting(boolean value)
    {
    	this.dataManager.set(IS_SITTING, value);
    }
    
    /**
     * @return - Wether or not this Entity has a Saddle
     */
    public boolean isSaddled()
    {
       return this.dataManager.get(IS_SADDLED);
    }
    
    /**
     * Sets the entity to Saddled true or false
     * @param value - Should be saddled
     */
    public void setSaddled(boolean value)
    {
    	this.dataManager.set(IS_SADDLED, value);
    }
    
    /**
     * @return - Wether or not this Entity has a back attachment
     */
    public boolean hasBackAttachment()
    {
       return (this.dataManager.get(BACK_ATTACHMENT_TYPE) != 0);
    }
    
    /**
     * [0] = Nothing.
     * [1] = Player Seats.
     * [2] = Small Storage.
     * [3] = Large Storage.
     * @return - The attachment type the given item is
     */
    public int getItemBackAttachmentType(Item item)
    {
    	if(!Arrays.asList(VALID_BACK_ATTACHMENTS).contains(item))
    	{
    		return 0;
    	}
    	else
    	{
    		if(item == PCItems.BUFFLON_PLAYER_SEATS)
    		{
    			return 1;
    		}
    		else if(item == PCItems.BUFFLON_SMALL_STORAGE)
    		{
    			return 2;
    		}
    		else if(item == PCItems.BUFFLON_LARGE_STORAGE)
    		{
    			return 3;
    		}
    		else
    		{
    			//In case all checks fail it returns nothing
    			return 0;
    		}
    	}
    }
    
    /**
     * [0] = Nothing.
     * [1] = Player Seats.
     * [2] = Small Storage.
     * [3] = Large Storage.
     * @return - The attachment type this Entity has on its back
     */
    public int getBackAttachmentType()
    {
    	return this.dataManager.get(BACK_ATTACHMENT_TYPE);
    }
    
    /**
     * Set the back attachment to given type
     * @param value - Back attachment type
     */
    public void setBackAttachment(int backAttachmentType)
    {
    	this.dataManager.set(BACK_ATTACHMENT_TYPE, backAttachmentType);
    }
    
    public void openGUI(PlayerEntity playerEntity)
    {
        if(!this.world.isRemote && (!this.isBeingRidden() || this.isPassenger(playerEntity)) && this.isTamed())
        {
        	if(playerEntity instanceof ServerPlayerEntity)
        	{
        		ITextComponent bufflonDisplayName = this.getName();
        		int id = this.getEntityId();
                NetworkHooks.openGui((ServerPlayerEntity) playerEntity, new INamedContainerProvider()
                {
                	@Override
                    public ITextComponent getDisplayName()
                	{
                        return bufflonDisplayName;
                    }

                    @Nullable
                    @Override
                    public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity)
                    {
                    	return new BufflonContainer(i, playerInventory, id);
                    }
                }, buf -> buf.writeInt(id));
        	}
        }
	}
    
    /**
     * @return - Wether or not the Bufflon it is tamed
     */
    public boolean isTamed()
    {
    	return (this.dataManager.get(TAMED) & 4) != 0;
	}

    /**
     * Set wether or not this Bufflon entity should be tamed
     * @param tamed - The tame status the entity should be in afterwards
     */
 	public void setTamed(boolean tamed)
 	{
        byte b0 = this.dataManager.get(TAMED);
        if(tamed)
        {
        	this.dataManager.set(TAMED, (byte)(b0 | 4));
        }
        else
        {
        	this.dataManager.set(TAMED, (byte)(b0 & -5));
        }
//      this.setupTamedAI();
 	}
 	
 	/**
 	 * @return - The UUID of the owning entity, if entity is null this will return null
 	 */
 	@Nullable
    public UUID getOwnerId()
 	{
       return this.dataManager.get(OWNER_UNIQUE_ID).orElse((UUID)null);
    }

 	/**
 	 * Used to set the owner UUID of the entity
 	 * @param uuid - The UUID the owning entity has
 	 */
    public void setOwnerId(@Nullable UUID uuid)
    {
       this.dataManager.set(OWNER_UNIQUE_ID, Optional.ofNullable(uuid));
    }

    /**
     * Handles the taming and sets the given Player as the owner of the Entity
     * @param player - The Player that will be the owner of the tamed Entity
     */
    public void setTamedBy(PlayerEntity player)
    {
    	this.setTamed(true);
    	this.setOwnerId(player.getUniqueID());
//    	if(player instanceof ServerPlayerEntity)
//    	{
//    		CriteriaTriggers.TAME_ANIMAL.trigger((ServerPlayerEntity)player, this);
//    	}
    }

    /**
     * @return - The Entity that owns the Bufflon
     */
    @Nullable
    public LivingEntity getOwner()
    {
    	try
    	{
    		UUID uuid = this.getOwnerId();
    		return uuid == null ? null : this.world.getPlayerByUuid(uuid);
    	}
    	catch(IllegalArgumentException var2)
    	{
    		return null;
    	}
    }
    
    /**
     * Wether or not this entity can attack
     */
    public boolean canAttack(LivingEntity target)
    {
    	return this.isOwner(target) ? false : super.canAttack(target);
    }

    /**
     * @param entityIn - The entity that will be checked as a possible owner
     * @return - Wether or not the given entity is the owner of this Entity
     */
   	public boolean isOwner(LivingEntity entityIn)
   	{
   		return entityIn == this.getOwner();
   	}
   	
   	/**
   	 * @return - The team of the Entity
   	 */
   	public Team getTeam()
   	{
   		if(this.isTamed())
   		{
   			LivingEntity livingentity = this.getOwner();
   			if(livingentity != null)
   			{
   				return livingentity.getTeam();
   			}
   		}
        return super.getTeam();
   	}

   	/**
   	 * Returns whether this Entity is on the same team as the given Entity.
   	 */
   	public boolean isOnSameTeam(Entity entityIn)
   	{
   		if(this.isTamed())
   		{
   			LivingEntity livingentity = this.getOwner();
           if(entityIn == livingentity)
           {
        	   return true;
           }

           if(livingentity != null)
           {
        	   return livingentity.isOnSameTeam(entityIn);
           }
   		}
        return super.isOnSameTeam(entityIn);
	}

	/**
	 * Called when the mob's health reaches 0.
	 */
	public void onDeath(DamageSource cause)
	{
		if(!this.world.isRemote && this.world.getGameRules().getBoolean(GameRules.SHOW_DEATH_MESSAGES) && this.getOwner() instanceof ServerPlayerEntity)
		{
			this.getOwner().sendMessage(this.getCombatTracker().getDeathMessage());
        }
        super.onDeath(cause);
	}
    
    /**
     * Used to get the current Bufflon type, if there is none a random type will be generated
     * @return - The Bufflon type Id
     */
    public int getBufflonType()
    {
    	if(this.dataManager.get(BUFFLON_TYPE) == 0)
    	{
    		Random rand = new Random();
    		this.dataManager.set(BUFFLON_TYPE, rand.nextInt(7) + 1);
    		return this.dataManager.get(BUFFLON_TYPE);
    	}
    	else
    	{
    		return this.dataManager.get(BUFFLON_TYPE);
    	}
	}
	
    /**
     * Used to set the Bufflon type, different bufflon types use different textures
     * @param typeId - the Bufflon type the entity should become
     */
	public void setBufflonType(int typeId)
	{
		this.dataManager.set(BUFFLON_TYPE, typeId);
	}
	
    @Override
    public int getMaxSpawnedInChunk()
    {
    	return 1;
    }
    
    public static void addSpawn()
    {
		ForgeRegistries.BIOMES.getValues().stream().forEach(BufflonEntity::processSpawning);
	}
	
    private static void processSpawning(Biome biome)
    {
		if(Arrays.asList(biomes).contains(biome))
		{
			biome.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(PCEntities.BUFFLON, 3, 1, 1));
		}
    }
    
    private net.minecraftforge.common.util.LazyOptional<?> itemHandler = null;

    @Override
    public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, @Nullable net.minecraft.util.Direction facing)
    {
    	if(this.isAlive() && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY && itemHandler != null)
    	{
    		return itemHandler.cast();
    	}
    	return super.getCapability(capability, facing);
    }

    @Override
    public void remove(boolean keepData)
    {
    	super.remove(keepData);
    	if(!keepData && itemHandler != null)
    	{
    		itemHandler.invalidate();
    		itemHandler = null;
    	}
    }
}
