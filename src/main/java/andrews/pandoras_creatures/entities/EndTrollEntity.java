package andrews.pandoras_creatures.entities;

import java.util.Arrays;

import andrews.pandoras_creatures.entities.bases.AnimatedCreatureEntity;
import andrews.pandoras_creatures.entities.goals.end_troll.EndTrollAttackGoal;
import andrews.pandoras_creatures.entities.goals.end_troll.EndTrollTransformGoal;
import andrews.pandoras_creatures.registry.PCEntities;
import andrews.pandoras_creatures.registry.PCItems;
import andrews.pandoras_creatures.util.animation.Animation;
import andrews.pandoras_creatures.util.network.NetworkUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.registries.ForgeRegistries;

public class EndTrollEntity extends AnimatedCreatureEntity
{
//	private static Biome[] biomes = new Biome[] {Biomes.NETHER};
	
	private static final DataParameter<Boolean> IS_STANDING = EntityDataManager.createKey(EndTrollEntity.class, DataSerializers.BOOLEAN);
	
	public static final Animation TRANSFORM_ANIMATION = new Animation(20);
	
    public EndTrollEntity(EntityType<? extends EndTrollEntity> type, World worldIn)
    {
        super(type, worldIn);
    }

    public EndTrollEntity(World world, double posX, double posY, double posZ)
    {
        this(PCEntities.END_TROLL.get(), world);
        this.setPosition(posX, posY, posZ);
    }
    
    @Override
    protected void registerGoals()
    {
    	//AI Goals
    	this.goalSelector.addGoal(1, new SwimGoal(this));
    	this.goalSelector.addGoal(2, new EndTrollTransformGoal(this));
    	this.goalSelector.addGoal(3, new EndTrollAttackGoal(this, 0.3D, false));
    	this.goalSelector.addGoal(4, new WaterAvoidingRandomWalkingGoal(this, 0.3D));
    	this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 10.0F));
    	this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
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
	}
	
	@Override
	public void readAdditional(CompoundNBT compound)
	{
		super.readAdditional(compound);
		this.setEntityStanding(compound.getBoolean("IsStanding"));
	}
	
	@Override
	public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, ILivingEntityData spawnDataIn, CompoundNBT dataTag)
	{
		spawnDataIn = super.onInitialSpawn(world, difficultyIn, reason, spawnDataIn, dataTag);
		
		if(dataTag != null && dataTag.contains("IsStanding"))
		{
			this.setEntityStanding(dataTag.getBoolean("IsStanding"));
			return spawnDataIn;
		}
		return spawnDataIn;
	}
	
	@Override
	protected void onAnimationEnd(Animation animation)
	{
		super.onAnimationEnd(animation);
		
		if(animation == TRANSFORM_ANIMATION)
		{
			this.setEntityStanding(true);
		}
	}
	
    @Override
   	public Animation[] getAnimations()
    {
   		return new Animation[] {TRANSFORM_ANIMATION};
   	}
    
    @Override
    protected boolean processInteract(PlayerEntity player, Hand hand)
    {
    	ItemStack itemstack = player.getHeldItem(hand);
        if(itemstack.getItem() == Items.BLAZE_ROD)
        {	
        	if(this.isAnimationPlaying(BLANK_ANIMATION) && !this.getEntityWorld().isRemote())
        	{
        		NetworkUtil.setPlayingAnimationMessage(this, TRANSFORM_ANIMATION); //TODO REMOVE
        	}
        }
        if(itemstack.getItem() == Items.STICK)
        {	
        	if(this.isEntityStanding())
        	{
        		this.setEntityStanding(false);//TODO REMOVE
        	}
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
    
//    public static void addSpawn()
//    {
//		ForgeRegistries.BIOMES.getValues().stream().forEach(EndTrollEntity::processSpawning);
//	}
//	
//    private static void processSpawning(Biome biome)
//    {
//		if(Arrays.asList(biomes).contains(biome))
//		{
//			biome.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(PCEntities.END_TROLL.get(), 30, 1, 1));
//        }
//	}
}