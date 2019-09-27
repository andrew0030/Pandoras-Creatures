package andrews.pandoras_creatures.entities;

import java.util.Arrays;
import java.util.Random;

import javax.annotation.Nullable;

import andrews.pandoras_creatures.registry.PCEntities;
import andrews.pandoras_creatures.registry.PCItems;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.registries.ForgeRegistries;

public class SeahorseEntity extends BucketableMobEntity
{
	private static final DataParameter<Integer> SEAHORSE_TYPE = EntityDataManager.createKey(SeahorseEntity.class, DataSerializers.VARINT);
	private static final DataParameter<Integer> SEAHORSE_SIZE = EntityDataManager.createKey(SeahorseEntity.class, DataSerializers.VARINT);
	private static Biome[] biomes = new Biome[] {Biomes.WARM_OCEAN, Biomes.OCEAN, Biomes.LUKEWARM_OCEAN};
	
    public SeahorseEntity(EntityType<? extends SeahorseEntity> type, World worldIn)
    {
        super(type, worldIn);
    }

    public SeahorseEntity(World world, double posX, double posY, double posZ)
    {
        this(PCEntities.SEAHORSE, world);
        this.setPosition(posX, posY, posZ);
    }
    
    @Override
    protected void registerGoals()
    {
    	
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
    public void baseTick()
    {
    	int i = this.getAir();
        super.baseTick();
        this.updateAir(i);
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
		int type = rand.nextInt(2) + 1;
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
    public boolean canBreatheUnderwater()
    {
    	return true;
    }
    
    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn)
    {
        return sizeIn.height * 0.8F;
    }
    
    @Override
	public ItemStack getBucket()
    {
		return new ItemStack(PCItems.SEAHORSE_BUCKET);
	}
    
    @Override
    public CreatureAttribute getCreatureAttribute()
    {
    	return CreatureAttribute.WATER;
    }
    
    protected void updateAir(int air)
    {
        if(this.isAlive() && !this.isInWaterOrBubbleColumn())
        {
           this.setAir(air - 1);
           if(this.getAir() == -20)
           {
              this.setAir(0);
              this.attackEntityFrom(DamageSource.DROWN, 2.0F);
           }
        }
        else
        {
           this.setAir(300);
        }
    }
    
    public static String getNameById(int id)
    {
		switch(id)
		{
			case 1:
				return "Orange Seahorse";
			case 2:
				return "Green Seahorse";
		}
		return "";
	}
    
    public static String getSizeById(int id)
    {
		switch(id)
		{
			case 1:
				return "Very Small";
			case 2:
				return "Small";
			case 3:
				return "Normal";
			case 4:
				return "Big";
			case 5:
				return "Very Big";
		}
		return "";
	}
    
    public int getSeahorseType()
    {
    	if(this.dataManager.get(SEAHORSE_TYPE) == 0)
    	{
    		Random rand = new Random();
    		this.dataManager.set(SEAHORSE_TYPE, rand.nextInt(2) + 1);
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
    
    public static void addSpawn()
    {
		ForgeRegistries.BIOMES.getValues().stream().forEach(SeahorseEntity::processSpawning);
	}
	
    private static void processSpawning(Biome biome)
    {
		if(Arrays.asList(biomes).contains(biome))
		{
			biome.addSpawn(EntityClassification.AMBIENT, new Biome.SpawnListEntry(PCEntities.SEAHORSE, 40, 2, 5));
		}
    }
}