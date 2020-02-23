package andrews.pandoras_creatures.entities;

import java.util.EnumSet;

import andrews.pandoras_creatures.entities.bases.AnimatedCreatureEntity;
import andrews.pandoras_creatures.entities.goals.end_troll.EndTrollTransformGoal;
import andrews.pandoras_creatures.registry.PCEntities;
import andrews.pandoras_creatures.registry.PCItems;
import andrews.pandoras_creatures.util.animation.Animation;
import andrews.pandoras_creatures.util.network.NetworkUtil;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class EndTrollEntity extends AnimatedCreatureEntity
{	
	private static final DataParameter<Boolean> IS_STANDING = EntityDataManager.createKey(EndTrollEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> HAS_SCREAMED = EntityDataManager.createKey(EndTrollEntity.class, DataSerializers.BOOLEAN);
	
	private static final EntitySize STANDING_SIZE = EntitySize.fixed(3.0F, 5.0F);
	
	public static final Animation TRANSFORM_ANIMATION = new Animation(20);
	public static final Animation SCREAM_ANIMATION = new Animation(32);
	public static final Animation SHOOT_ANIMATION = new Animation(20);
	
    public EndTrollEntity(EntityType<? extends EndTrollEntity> type, World worldIn)
    {
        super(type, worldIn);
    }

    public EndTrollEntity(World world, double posX, double posY, double posZ)
    {
        this(PCEntities.END_TROLL.get(), world);
        this.stepHeight = 1.0F;
        this.setPosition(posX, posY, posZ);
    }
    
    @Override
    protected void registerGoals()
    {
    	//AI Goals
    	this.goalSelector.addGoal(1, new SwimGoal(this));
    	this.goalSelector.addGoal(2, new EndTrollTransformGoal(this));
    	this.goalSelector.addGoal(3, new EndTrollEntity.BulletAttackGoal());
//    	this.goalSelector.addGoal(3, new EndTrollAttackGoal(this, 0.3D, false));
//    	this.goalSelector.addGoal(4, new WaterAvoidingRandomWalkingGoal(this, 0.3D));
//    	this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 10.0F));
//    	this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
    	//Target Selector
    	this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
    }

    @Override
    protected void registerAttributes()
    {
        super.registerAttributes();
//      this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(14.0D); //TODO
        this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.0D);
        this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(30.0D);
    }
    
    @Override
    protected void registerData()
    {
    	super.registerData();
    	this.dataManager.register(IS_STANDING, false);
    	this.dataManager.register(HAS_SCREAMED, false);
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
    	return new ItemStack(PCItems.END_TROLL_SPAWN_EGG.get());
    }
    
    @Override
	public void writeAdditional(CompoundNBT compound)
    {
		super.writeAdditional(compound);
		compound.putBoolean("IsStanding", this.isEntityStanding());
		compound.putBoolean("HasScreamed", this.hasScreamed());
	}
	
	@Override
	public void readAdditional(CompoundNBT compound)
	{
		super.readAdditional(compound);
		this.setEntityStanding(compound.getBoolean("IsStanding"));
		this.setHasScreamed(compound.getBoolean("HasScreamed"));
	}
	
	@Override
	public void notifyDataManagerChange(DataParameter<?> key)
	{
		super.notifyDataManagerChange(key);
		
		if(IS_STANDING.equals(key))
		{
			this.recalculateSize();
		}
	}
	
	@Override
	public EntitySize getSize(Pose poseIn)
	{
		return this.isEntityStanding() ? STANDING_SIZE : super.getSize(poseIn);
	}
	
	@Override
	public void livingTick()
	{
		super.livingTick();
		
		//Plays the Scream Animation
		if(!this.hasScreamed())
		{
			if(this.isEntityStanding())
			{	
				if(this.isAnimationPlaying(BLANK_ANIMATION) && !this.getEntityWorld().isRemote())
		    	{
		    		NetworkUtil.setPlayingAnimationMessage(this, SCREAM_ANIMATION); //TODO REMOVE
		    	}
			}
			
			//Breaks the Blocks during the Scream
			if(this.isAnimationPlaying(SCREAM_ANIMATION))
			{
				if(this.getAnimationTick() == 16)
				{
					screamBlockBreaking(this.getBoundingBox().grow(5, 2, 5).offset(0, 2, 0), this.getEntityWorld());
				}
				else if(this.getAnimationTick() == 12)
				{
					this.getEntityWorld().addOptionalParticle(ParticleTypes.EXPLOSION_EMITTER, this.getPosition().getX(), this.getPosition().getY() + this.getEyeHeight() / 2, this.getPosition().getZ(), 0, 0, 0);
				}
				else if(this.getAnimationTick() == 10)
				{
					this.getEntityWorld().playSound(this.getPosition().getX(), this.getPosition().getY() + this.getEyeHeight(), this.getPosition().getZ(), SoundEvents.ENTITY_WITHER_HURT, SoundCategory.HOSTILE, 1.0F, -3.0F, false);
				}
			}
		}
		
		//Breaks Chorus Plants
		if((this.ticksExisted % 10) == 0)//TODO MOVE THIS SHIT INTO WALKING TICK SOMETHING SO IT ONLY GETS CALLED WHILE WALKING
		{
			breakChorusBlocks(this.getBoundingBox().grow(2, 0, 2), this.getEntityWorld());
		}
	}
	
	/**
	 * Used by the EndTroll to break Chorus Plants and Flowers that are around it
	 * @param aabb - The Bounding Box in which the game looks for Blocks to break
	 * @param world - The Entities World
	 */
	private void breakChorusBlocks(AxisAlignedBB aabb, World world)//TODO MAKE BETER CAUSE WHY 2 METHODS
    {
        for(int x = MathHelper.floor(aabb.minX); x < MathHelper.floor(aabb.maxX); ++x)
        {
            for(int y = MathHelper.ceil(aabb.minY); y < MathHelper.floor(aabb.maxY); ++y)
            {
                for (int z = MathHelper.floor(aabb.minZ); z < MathHelper.floor(aabb.maxZ); ++z)
                {
                	Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();
                	
                    if(block == Blocks.CHORUS_PLANT || block == Blocks.CHORUS_FLOWER)
                    {
                    	world.destroyBlock(new BlockPos(x, y, z), true);
                    }
                }
            }
        }
    }
	
	@Override
	public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, ILivingEntityData spawnDataIn, CompoundNBT dataTag)
	{
		spawnDataIn = super.onInitialSpawn(world, difficultyIn, reason, spawnDataIn, dataTag);
		
		if(dataTag != null && dataTag.contains("IsStanding"))
		{
			this.setEntityStanding(dataTag.getBoolean("IsStanding"));
		}
		if(dataTag != null && dataTag.contains("HasScreamed"))
		{
			this.setHasScreamed(dataTag.getBoolean("HasScreamed"));
		}
		return spawnDataIn;
	}
	
	@Override
	protected void onAnimationEnd(Animation animation)
	{
		if(animation == TRANSFORM_ANIMATION)
		{
			this.setEntityStanding(true);
			recalculateSize();
		}
		
		if(animation == SCREAM_ANIMATION)
		{
			this.setHasScreamed(true);
		}
	}
	
    @Override
   	public Animation[] getAnimations()
    {
   		return new Animation[] {TRANSFORM_ANIMATION, SCREAM_ANIMATION, SHOOT_ANIMATION};
   	}
    
    @Override
    protected boolean processInteract(PlayerEntity player, Hand hand)
    {
    	ItemStack itemstack = player.getHeldItem(hand);
        if(itemstack.getItem() == Items.BLAZE_ROD)
        {	
        	this.setHasScreamed(false);//TODO REMOVE
        	if(this.isAnimationPlaying(BLANK_ANIMATION) && !this.getEntityWorld().isRemote())
        	{
        		NetworkUtil.setPlayingAnimationMessage(this, TRANSFORM_ANIMATION); //TODO REMOVE
        	}
        }
        if(itemstack.getItem() == Items.GUNPOWDER)
        {	
        	if(this.isAnimationPlaying(BLANK_ANIMATION) && !this.getEntityWorld().isRemote())
        	{
        		NetworkUtil.setPlayingAnimationMessage(this, SHOOT_ANIMATION); //TODO REMOVE
        	}
        }
        if(itemstack.getItem() == Items.BLAZE_POWDER)
        {	
        	if(this.isAnimationPlaying(BLANK_ANIMATION) && !this.getEntityWorld().isRemote())
        	{
        		NetworkUtil.setPlayingAnimationMessage(this, SCREAM_ANIMATION); //TODO REMOVE
        	}
        }
        if(itemstack.getItem() == Items.STICK)//TODO REMOVE
        {	
        	if(this.isEntityStanding())
        	{
        		this.setEntityStanding(false);//TODO REMOVE
        		this.setHasScreamed(false);//TODO REMOVE
        	}
        }
        if(itemstack.getItem() == Items.APPLE)//TODO REMOVE
        {	
        	this.getEntityWorld().addEntity(new EndTrollBulletPoisonEntity(world, this, null, null));
        }
        return true;
    }
    
    @Override
    protected int getExperiencePoints(PlayerEntity player)  //TODO
    {
    	this.experienceValue = (int)((float)this.experienceValue * 2.0F);
    	return super.getExperiencePoints(player);
    }
    
    @Override
    public boolean canBeLeashedTo(PlayerEntity player)
    {
    	return false;
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
    
    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn)
    {
    	return sizeIn.height * 0.7F;
    }
    
    /**
     * Used to handle the EndTroll Attacks
     */
    @Override
    public boolean attackEntityAsMob(Entity entityIn)
    {
    	boolean flag;
    	flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)(2 + this.rand.nextInt(3)));
        return flag;
    }
    
    /**
	 * Used by the EndTroll to break the Blocks around it when screaming
	 * @param aabb - The Bounding Box in which the game looks for Blocks to break
	 * @param world - The Entities World
	 */
	private void screamBlockBreaking(AxisAlignedBB aabb, World world)
    {
		if(!this.getEntityWorld().isRemote)
		{
	        for(int x = MathHelper.floor(aabb.minX); x < MathHelper.floor(aabb.maxX); ++x)
	        {
	            for(int y = MathHelper.ceil(aabb.minY); y < MathHelper.floor(aabb.maxY); ++y)
	            {
	                for (int z = MathHelper.floor(aabb.minZ); z < MathHelper.floor(aabb.maxZ); ++z)
	                {
	                	Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();
	                	
	                    if(block != Blocks.AIR && !BlockTags.WITHER_IMMUNE.contains(block))
	                    {
	                    	if(rand.nextInt(4) + 1 == 4)
	                    	{
	                    		FallingBlockEntity fallingBlockEntity = new FallingBlockEntity(world, x + 0.5D, y + 0.5D, z + 0.5D, block.getDefaultState());
		                    	fallingBlockEntity.setMotion(fallingBlockEntity.getMotion().add(this.getPositionVec().subtract(fallingBlockEntity.getPositionVec()).mul((-1.2D + rand.nextDouble()) / 3, (-1.1D + rand.nextDouble()) / 3, (-1.2D + rand.nextDouble()) / 3)));
		                    	world.addEntity(fallingBlockEntity);
	                    	}
	                    	else
	                    	{
	                    		world.destroyBlock(new BlockPos(x, y, z), rand.nextInt(3) + 1 == 3);
	                    	}
	                    }
	                }
	            }
	        }
		}
    }
    
    /**
     * @return - Wether or not this Entity is standing
     */
    public boolean isEntityStanding()
    {
       return this.dataManager.get(IS_STANDING);
    }
    
    /**
     * Sets wether or not the Entity is standing
     * @param value - should the entity be standing
     */
    public void setEntityStanding(boolean value)
    {
    	this.dataManager.set(IS_STANDING, value);
    }
    
    /**
     * @return - Wether or not this Entity has screamed
     */
    public boolean hasScreamed()
    {
       return this.dataManager.get(HAS_SCREAMED);
    }
    
    /**
     * Sets wether or not the Entity has screamed
     * @param value - has screamed
     */
    public void setHasScreamed(boolean value)
    {
    	this.dataManager.set(HAS_SCREAMED, value);
    }
    
    class BulletAttackGoal extends Goal
    {
    	private int attackTime;

    	public BulletAttackGoal()
    	{
    		this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    	}

    	/**
    	 * Returns whether the EntityAIBase should begin execution.
         */
    	public boolean shouldExecute()
    	{
    		LivingEntity livingentity = EndTrollEntity.this.getAttackTarget();
    		if(livingentity != null && livingentity.isAlive())
    		{
    			return EndTrollEntity.this.world.getDifficulty() != Difficulty.PEACEFUL;
    		}
    		else
    		{
    			return false;
    		}
    	}

    	/**
    	 * Keep ticking a continuous task that has already been started
    	 */
        public void tick()
        {	
        	if(EndTrollEntity.this.world.getDifficulty() != Difficulty.PEACEFUL)
        	{
        		--this.attackTime;
        		LivingEntity livingentity = EndTrollEntity.this.getAttackTarget();
        		EndTrollEntity.this.getLookController().setLookPositionWithEntity(livingentity, 180.0F, 180.0F);
        		double d0 = EndTrollEntity.this.getDistanceSq(livingentity);
        		if(d0 < 400.0D)
        		{
        			if(this.attackTime <= 0)
        			{
        				if(EndTrollEntity.this.isAnimationPlaying(BLANK_ANIMATION) && !EndTrollEntity.this.getEntityWorld().isRemote())
        	        	{
        	        		NetworkUtil.setPlayingAnimationMessage(EndTrollEntity.this, SHOOT_ANIMATION);
        	        	}
        				
        				if(EndTrollEntity.this.isAnimationPlaying(SHOOT_ANIMATION) && EndTrollEntity.this.getAnimationTick() == 9)
        				{
        					this.attackTime = 20 + EndTrollEntity.this.rand.nextInt(10) * 20 / 2;
        					for(int i = 0; i < 5; i++)
        					{
        						EndTrollEntity.this.world.addEntity(getRandomEndTrollBullet(EndTrollEntity.this.world, EndTrollEntity.this, livingentity, getAxis()));
        					}
        					EndTrollEntity.this.playSound(SoundEvents.ENTITY_SHULKER_SHOOT, 2.0F, (EndTrollEntity.this.rand.nextFloat() - EndTrollEntity.this.rand.nextFloat()) * 0.2F + 1.0F);
        				}
        			}
        		}
        		else
        		{
        			EndTrollEntity.this.setAttackTarget((LivingEntity)null);
        		}
        		
        		super.tick();
        	}
        }
        
        private Entity getRandomEndTrollBullet(World world, EndTrollEntity owner, LivingEntity targetEntity, Direction.Axis directionAxis)
        {
    		switch(rand.nextInt(3) + 1)
    		{
			case 1:
				return new EndTrollBulletPoisonEntity(world, owner, targetEntity, directionAxis);
			case 2:
				return new EndTrollBulletWitherEntity(world, owner, targetEntity, directionAxis);
			case 3:
				return new EndTrollBulletDamageEntity(world, owner, targetEntity, directionAxis);
			default:
				return new EndTrollBulletPoisonEntity(world, owner, targetEntity, directionAxis);
			}
        }
        
        /**
         * return - Returns a Random Axis
         */
        private Direction.Axis getAxis()
        {
        	if(rand.nextInt(3) + 1 == 1)
        	{
        		return Direction.Axis.X;
        	}
        	if(rand.nextInt(3) + 1 == 2)
        	{
        		return Direction.Axis.Y;
        	}
        	if(rand.nextInt(3) + 1 == 3)
        	{
        		return Direction.Axis.Z;
        	}
        	
        	return Direction.Axis.X;
        }
    }
}