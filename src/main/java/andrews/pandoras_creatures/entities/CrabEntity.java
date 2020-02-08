package andrews.pandoras_creatures.entities;

import java.util.Random;

import javax.annotation.Nullable;

import andrews.pandoras_creatures.entities.bases.BucketableMobEntity;
import andrews.pandoras_creatures.registry.PCEntities;
import andrews.pandoras_creatures.registry.PCItems;
import andrews.pandoras_creatures.registry.PCSounds;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CrabEntity extends BucketableMobEntity
{
	private static final DataParameter<Integer> CRAB_TYPE = EntityDataManager.createKey(CrabEntity.class, DataSerializers.VARINT);
	private boolean partyCrab;
	private boolean underWater = false;
	private BlockPos jukeboxPosition;
	
    public CrabEntity(EntityType<? extends CrabEntity> type, World worldIn)
    {
        super(type, worldIn);
    }

    public CrabEntity(World world, double posX, double posY, double posZ)
    {
        this(PCEntities.CRAB.get(), world);
        this.setPosition(posX, posY, posZ);
    }
    
    @Override
    protected void registerGoals()
    {
    	this.goalSelector.addGoal(1, new PanicGoal(this, 0.3D));
    	this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 0.3D, 240));
    	this.goalSelector.addGoal(3, new LookRandomlyGoal(this));
    }

    @Override
    protected void registerAttributes()
    {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.0D);
    }
    
    @Override
	protected void registerData()
    {
		super.registerData();
		this.dataManager.register(CRAB_TYPE, 0);
	}
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
    	return new ItemStack(PCItems.CRAB_SPAWN_EGG.get());
    }
    
    @Override
	protected void setBucketData(ItemStack bucket)
    {
    	if(this.hasCustomName())
    	{
			bucket.setDisplayName(this.getCustomName());
		}
		CompoundNBT compoundnbt = bucket.getOrCreateTag();
		compoundnbt.putInt("BucketVariantTag", this.getCrabType());
    }
    
    @Override
	public void writeAdditional(CompoundNBT compound)
    {
		super.writeAdditional(compound);
		compound.putInt("CrabType", this.getCrabType());
	}
	
	@Override
	public void readAdditional(CompoundNBT compound)
	{
		super.readAdditional(compound);
		this.setCrabType(compound.getInt("CrabType"));
	}
	
	@Nullable
	@Override
	public ILivingEntityData onInitialSpawn(IWorld world, DifficultyInstance difficulty, SpawnReason reason, ILivingEntityData spawnData, CompoundNBT dataTag)
	{
		spawnData = super.onInitialSpawn(world, difficulty, reason, spawnData, dataTag);
		Random rand = new Random();
		int type = rand.nextInt(2) + 1;
		if(dataTag != null && dataTag.contains("BucketVariantTag", 3))
		{
			this.setCrabType(dataTag.getInt("BucketVariantTag"));
			return spawnData;
		}
		this.setCrabType(type);
		return spawnData;
	}
	
	@Override
	protected void updateAir(int air) {}
    
    @Override
    public boolean handleWaterMovement()
    {
    	if(this.underWater)
    	{
    		this.fallDistance = 0.0F;
    	    this.extinguish();
    	}
    	return false;
    }
    
    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn)
    {
        return sizeIn.height * 0.8F;
    }
    
    @Override
	public ItemStack getBucket()
    {
		return new ItemStack(PCItems.CRAB_BUCKET.get());
	}
    
    @Override
    public void livingTick()
    {
    	if(this.getEntity() instanceof CrabEntity)
    	{
    		CrabEntity entity = (CrabEntity) this.getEntity();
    		
    		if(!entity.getEntityWorld().isRemote)
    		{
	    		if(this.world.getBlockState(new BlockPos(entity)).getBlock().equals(Blocks.WATER) && this.underWater == false)
	    		{
	    			this.underWater = true;
	    		}
	    		else if(!this.world.getBlockState(new BlockPos(entity)).getBlock().equals(Blocks.WATER) && this.underWater == true)
	    		{
	    			this.underWater = false;
	    		}
    		}
    	}
    	
    	if(this.jukeboxPosition == null || !this.jukeboxPosition.withinDistance(this.getPositionVec(), 4 * 3.46D) || this.world.getBlockState(this.jukeboxPosition).getBlock() != Blocks.JUKEBOX)
        {
           this.partyCrab = false;
           this.jukeboxPosition = null;
        }
        super.livingTick();
    }
    
    /**
     * Called when a record starts or stops playing. Used to make crabs start or stop partying.
     */
    @OnlyIn(Dist.CLIENT)
    public void setPartying(BlockPos pos, boolean isPartying)
    {
       this.jukeboxPosition = pos;
       this.partyCrab = isPartying;
    }

    @OnlyIn(Dist.CLIENT)
    public boolean isPartying()
    {
       return this.partyCrab;
    }
    
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
    	return PCSounds.CRAB_HURT.get();
    }
    
    @Override
    protected SoundEvent getDeathSound()
    {
    	return PCSounds.CRAB_DEATH.get();
    }
    
    public static String getNameById(int id)
    {
		switch(id)
		{
			case 1:
				return "chat.pandoras_creatures.crabBucketTooltip.sea";
			case 2:
				return "chat.pandoras_creatures.crabBucketTooltip.tropical";
		}
		return "";
	}
    
    public int getCrabType()
    {
    	if(this.dataManager.get(CRAB_TYPE) == 0)
    	{
    		Random rand = new Random();
    		this.dataManager.set(CRAB_TYPE, rand.nextInt(2) + 1);
    		return this.dataManager.get(CRAB_TYPE);
    	}
    	else
    	{
    		return this.dataManager.get(CRAB_TYPE);
    	}
	}
	
	public void setCrabType(int typeId)
	{
		this.dataManager.set(CRAB_TYPE, typeId);
	}
    
//    public static void addSpawn()
//    {
//		ForgeRegistries.BIOMES.getValues().stream().forEach(CrabEntity::processSpawning);
//	}
//	
//    private static void processSpawning(Biome biome)
//    {
//		if(Arrays.asList(biomes).contains(biome))
//		{
//			biome.addSpawn(EntityClassification.AMBIENT, new Biome.SpawnListEntry(PCEntities.CRAB.get(), 40, 2, 5));
//		}
//    }
}