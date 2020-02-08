package andrews.pandoras_creatures.entities;

import java.util.Random;

import javax.annotation.Nullable;

import andrews.pandoras_creatures.entities.bases.BucketableMobEntity;
import andrews.pandoras_creatures.registry.PCEntities;
import andrews.pandoras_creatures.registry.PCItems;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.pathfinding.SwimmerPathNavigator;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class SeahorseEntity extends BucketableMobEntity
{
	private static final DataParameter<Integer> SEAHORSE_TYPE = EntityDataManager.createKey(SeahorseEntity.class, DataSerializers.VARINT);
	private static final DataParameter<Integer> SEAHORSE_SIZE = EntityDataManager.createKey(SeahorseEntity.class, DataSerializers.VARINT);
	
    public SeahorseEntity(EntityType<? extends SeahorseEntity> type, World worldIn)
    {
        super(type, worldIn);
        this.moveController = new SeahorseEntity.MoveHelperController(this);
    }

    public SeahorseEntity(World world, double posX, double posY, double posZ)
    {
        this(PCEntities.SEAHORSE.get(), world);
        this.setPosition(posX, posY, posZ);
    }
    
    @Override
    protected void registerGoals()
    {
    	this.goalSelector.addGoal(1, new PanicGoal(this, 1.5D));
        this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, PlayerEntity.class, 8.0F, 1.6D, 1.4D, EntityPredicates.NOT_SPECTATING::test));
        this.goalSelector.addGoal(3, new SeahorseEntity.SwimGoal(this));
        this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
    }

    @Override
    protected void registerAttributes()
    {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(3.0D);
    }
    
    @Override
	protected void registerData()
    {
		super.registerData();
		this.dataManager.register(SEAHORSE_TYPE, 0);
		this.dataManager.register(SEAHORSE_SIZE, 0);
	}
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
    	return new ItemStack(PCItems.SEAHORSE_SPAWN_EGG.get());
    }
    
    /**
     * Returns new PathNavigateGround instance
     */
    protected PathNavigator createNavigator(World world)
    {
    	return new SwimmerPathNavigator(this, world);
    }

    @Override
    public void travel(Vec3d p_213352_1_)
    {
    	if(this.isServerWorld() && this.isInWater())
    	{
    		this.moveRelative(0.01F, p_213352_1_);
    		this.move(MoverType.SELF, this.getMotion());
    		this.setMotion(this.getMotion().scale(0.9D));
    		if(this.getAttackTarget() == null)
    		{
            	this.setMotion(this.getMotion().add(0.0D, -0.005D, 0.0D));
    		}
    	}
    	else
    	{
    		super.travel(p_213352_1_);
    	}
    }
    
    @Override
    public int getMaxSpawnedInChunk()
    {
    	return 8;
    }
    
    @Override
    public void onDeath(DamageSource cause)
    {
    	super.onDeath(cause);
    	if(this.getName().getString().equals("Mr.Sparkles"))
        {
	        if(this.world.isRemote)
	        {  
	        	for(int i = 0; i < 40; i++)
	        	{
	        		Random rand = new Random();
	        		
	        		this.world.addParticle(new RedstoneParticleData(148, 0, 211, 1.0F), this.posX + ((rand.nextInt(31) - 15) / 5), this.posY + ((rand.nextInt(31) - 15) / 5), this.posZ + ((rand.nextInt(31) - 15) / 5), 0, 0, 0);
	        		this.world.addParticle(new RedstoneParticleData(75, 0, 130, 1.0F), this.posX + ((rand.nextInt(31) - 15) / 5), this.posY + ((rand.nextInt(31) - 15) / 5), this.posZ + ((rand.nextInt(31) - 15) / 5), 0, 0, 0);
	        		this.world.addParticle(new RedstoneParticleData(0, 0, 255, 1.0F), this.posX + ((rand.nextInt(31) - 15) / 5), this.posY + ((rand.nextInt(31) - 15) / 5), this.posZ + ((rand.nextInt(31) - 15) / 5), 0, 0, 0);
	        		this.world.addParticle(new RedstoneParticleData(0, 255, 0, 1.0F), this.posX + ((rand.nextInt(31) - 15) / 5), this.posY + ((rand.nextInt(31) - 15) / 5), this.posZ + ((rand.nextInt(31) - 15) / 5), 0, 0, 0);
	        		this.world.addParticle(new RedstoneParticleData(255, 255, 0, 1.0F), this.posX + ((rand.nextInt(31) - 15) / 5), this.posY + ((rand.nextInt(31) - 15) / 5), this.posZ + ((rand.nextInt(31) - 15) / 5), 0, 0, 0);
	        		this.world.addParticle(new RedstoneParticleData(255, 127, 0, 1.0F), this.posX + ((rand.nextInt(31) - 15) / 5), this.posY + ((rand.nextInt(31) - 15) / 5), this.posZ + ((rand.nextInt(31) - 15) / 5), 0, 0, 0);
	        		this.world.addParticle(new RedstoneParticleData(255, 0 , 0, 1.0F), this.posX + ((rand.nextInt(31) - 15) / 5), this.posY + ((rand.nextInt(31) - 15) / 5), this.posZ + ((rand.nextInt(31) - 15) / 5), 0, 0, 0);
	        	}
	        }
        }
    }
    
    @Override
    public void tick()
    {
        super.tick();
        if(this.getName().getString().equals("Mr.Sparkles"))
        {
	        if(this.world.isRemote)
	        {   
	        	if((this.ticksExisted % 8) == 0)
	        	{
	        		Random rand = new Random();
	        		float unit = (this.getHeight() - 0.2F - (this.getSeahorseSize() - 3) * -0.1F) / 7F;
	        		
	        		this.world.addParticle(new RedstoneParticleData(148, 0, 211, 1.0F), this.posX + (0.1F * (rand.nextInt(5) - 3)), this.posY + unit * 7, this.posZ + (0.1F * (rand.nextInt(5) - 3)), 0, 0, 0);
	        		this.world.addParticle(new RedstoneParticleData(75, 0, 130, 1.0F), this.posX + (0.1F * (rand.nextInt(5) - 3)), this.posY + unit * 6, this.posZ + (0.1F * (rand.nextInt(5) - 3)), 0, 0, 0);
	        		this.world.addParticle(new RedstoneParticleData(0, 0, 255, 1.0F), this.posX + (0.1F * (rand.nextInt(5) - 3)), this.posY + unit * 5, this.posZ + (0.1F * (rand.nextInt(5) - 3)), 0, 0, 0);
	        		this.world.addParticle(new RedstoneParticleData(0, 255, 0, 1.0F), this.posX + (0.1F * (rand.nextInt(5) - 3)), this.posY + unit * 4, this.posZ + (0.1F * (rand.nextInt(5) - 3)), 0, 0, 0);
	        		this.world.addParticle(new RedstoneParticleData(255, 255, 0, 1.0F), this.posX + (0.1F * (rand.nextInt(5) - 3)), this.posY + unit * 3, this.posZ + (0.1F * (rand.nextInt(5) - 3)), 0, 0, 0);
	        		this.world.addParticle(new RedstoneParticleData(255, 127, 0, 1.0F), this.posX + (0.1F * (rand.nextInt(5) - 3)), this.posY + unit * 2, this.posZ + (0.1F * (rand.nextInt(5) - 3)), 0, 0, 0);
	        		this.world.addParticle(new RedstoneParticleData(255, 0 , 0, 1.0F), this.posX + (0.1F * (rand.nextInt(5) - 3)), this.posY + unit, this.posZ + (0.1F * (rand.nextInt(5) - 3)), 0, 0, 0);
	        	}
	        }
        }
    }
    
    @Override
    public void livingTick()
    {
        if(!this.isInWater() && this.onGround && this.collidedVertically)
        {
           this.setMotion(this.getMotion().add((double)((this.rand.nextFloat() * 2.0F - 1.0F) * 0.05F), (double)0.4F, (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 0.05F)));
           this.onGround = false;
           this.isAirBorne = true;
           this.playSound(SoundEvents.ENTITY_COD_FLOP, this.getSoundVolume(), 1.2F);
        }

        super.livingTick();
    }
    
    @Override
    protected SoundEvent getSwimSound()
    {
    	return SoundEvents.ENTITY_FISH_SWIM;
    }
    
    @Override
	protected void setBucketData(ItemStack bucket)
    {
    	if(this.hasCustomName())
    	{
			bucket.setDisplayName(this.getCustomName());
		}
		CompoundNBT compoundnbt = bucket.getOrCreateTag();
		compoundnbt.putInt("BucketVariantTag", this.getSeahorseType());
		compoundnbt.putInt("BucketSizeTag", this.getSeahorseSize());
    }
    
    @Override
	public void writeAdditional(CompoundNBT compound)
    {
		super.writeAdditional(compound);
		compound.putInt("SeahorseType", this.getSeahorseType());
		compound.putInt("SeahorseSize", this.getSeahorseSize());
	}
	
	@Override
	public void readAdditional(CompoundNBT compound)
	{
		super.readAdditional(compound);
		this.setSeahorseType(compound.getInt("SeahorseType"));
		this.setSeahorseSize(compound.getInt("SeahorseSize"));
	}
	
	@Nullable
	@Override
	public ILivingEntityData onInitialSpawn(IWorld world, DifficultyInstance difficulty, SpawnReason reason, ILivingEntityData spawnData, CompoundNBT dataTag)
	{	
		spawnData = super.onInitialSpawn(world, difficulty, reason, spawnData, dataTag);
		Random rand = new Random();
		int type = rand.nextInt(10) + 1;
		int size = rand.nextInt(5) + 1;
		if(dataTag != null && dataTag.contains("BucketVariantTag", 3) && dataTag.contains("BucketSizeTag", 3))
		{
			this.setSeahorseType(dataTag.getInt("BucketVariantTag"));
			this.setSeahorseSize(dataTag.getInt("BucketSizeTag"));
			return spawnData;
		}
		this.setSeahorseType(type);
		this.setSeahorseSize(size);
		return spawnData;
	}
    
    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn)
    {
        return sizeIn.height * 0.8F;
    }
    
    @Override
	public ItemStack getBucket()
    {
		return new ItemStack(PCItems.SEAHORSE_BUCKET.get());
	}
    
    protected boolean func_212800_dy()
    {
        return true;
    }
    
    public static String getNameById(int id)
    {
		switch(id)
		{
			case 1:
				return "chat.pandoras_creatures.seahorseBucketTooltip.orange";
			case 2:
				return "chat.pandoras_creatures.seahorseBucketTooltip.green";
			case 3:
				return "chat.pandoras_creatures.seahorseBucketTooltip.red";
			case 4:
				return "chat.pandoras_creatures.seahorseBucketTooltip.yellow";
			case 5:
				return "chat.pandoras_creatures.seahorseBucketTooltip.chromatic";
			case 6:
				return "chat.pandoras_creatures.seahorseBucketTooltip.cyan";
			case 7:
				return "chat.pandoras_creatures.seahorseBucketTooltip.purple";
			case 8:
				return "chat.pandoras_creatures.seahorseBucketTooltip.pink";
			case 9:
				return "chat.pandoras_creatures.seahorseBucketTooltip.lime";
			case 10:
				return "chat.pandoras_creatures.seahorseBucketTooltip.ghost";
		}
		return "";
	}
    
    public static String getSizeById(int id)
    {
		switch(id)
		{
			case 1:
				return "chat.pandoras_creatures.seahorseBucketTooltip.verySmall";
			case 2:
				return "chat.pandoras_creatures.seahorseBucketTooltip.small";
			case 3:
				return "chat.pandoras_creatures.seahorseBucketTooltip.normal";
			case 4:
				return "chat.pandoras_creatures.seahorseBucketTooltip.big";
			case 5:
				return "chat.pandoras_creatures.seahorseBucketTooltip.veryBig";
		}
		return "";
	}
    
    public int getSeahorseType()
    {
    	if(this.dataManager.get(SEAHORSE_TYPE) == 0)
    	{
    		Random rand = new Random();
    		this.dataManager.set(SEAHORSE_TYPE, rand.nextInt(10) + 1);
    		return this.dataManager.get(SEAHORSE_TYPE);
    	}
    	else
    	{
    		return this.dataManager.get(SEAHORSE_TYPE);
    	}
	}
    
    public int getSeahorseSize()
    {
    	if(this.dataManager.get(SEAHORSE_SIZE) == 0)
    	{
    		Random rand = new Random();
    		this.dataManager.set(SEAHORSE_SIZE, rand.nextInt(5) + 1);
    		return this.dataManager.get(SEAHORSE_SIZE);
    	}
    	else
    	{
    		return this.dataManager.get(SEAHORSE_SIZE);
    	}
	}
	
	public void setSeahorseType(int typeId)
	{
		this.dataManager.set(SEAHORSE_TYPE, typeId);
	}
	
	public void setSeahorseSize(int typeId)
	{
		this.dataManager.set(SEAHORSE_SIZE, typeId);
	}
    
    /**
     * The Movement Controller.
     */
    static class MoveHelperController extends MovementController
    {
    	private final SeahorseEntity seahorse;

        MoveHelperController(SeahorseEntity seahorse)
        {
        	super(seahorse);
        	this.seahorse = seahorse;
        }

        public void tick()
        {
        	if(this.seahorse.areEyesInFluid(FluidTags.WATER))
            {
               this.seahorse.setMotion(this.seahorse.getMotion().add(0.0D, 0.005D, 0.0D));
            }

            if(this.action == MovementController.Action.MOVE_TO && !this.seahorse.getNavigator().noPath())
            {
            	double d0 = this.posX - this.seahorse.posX;
            	double d1 = this.posY - this.seahorse.posY;
            	double d2 = this.posZ - this.seahorse.posZ;
            	double d3 = (double)MathHelper.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
            	d1 = d1 / d3;
            	float f = (float)(MathHelper.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
            	this.seahorse.rotationYaw = this.limitAngle(this.seahorse.rotationYaw, f, 90.0F);
            	this.seahorse.renderYawOffset = this.seahorse.rotationYaw;
            	float f1 = (float)(this.speed * this.seahorse.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue());
            	this.seahorse.setAIMoveSpeed(MathHelper.lerp(0.125F, this.seahorse.getAIMoveSpeed(), f1));
            	this.seahorse.setMotion(this.seahorse.getMotion().add(0.0D, (double)this.seahorse.getAIMoveSpeed() * d1 * 0.1D, 0.0D));
            }
            else
            {
            	this.seahorse.setAIMoveSpeed(0.0F);
            }
        }
    }
    
    /**
     * The Swim Goal.
     */
    static class SwimGoal extends RandomSwimmingGoal
    {
    	private final SeahorseEntity seahorse;

        public SwimGoal(SeahorseEntity seahorse)
        {
           super(seahorse, 1.25D, 40);
           this.seahorse = seahorse;
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
           return this.seahorse.func_212800_dy() && super.shouldExecute();
        }
     }
}