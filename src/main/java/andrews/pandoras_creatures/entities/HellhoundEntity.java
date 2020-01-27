package andrews.pandoras_creatures.entities;

import java.util.Arrays;
import java.util.Random;

import javax.annotation.Nullable;

import andrews.pandoras_creatures.entities.goals.HellHoundAttack;
import andrews.pandoras_creatures.registry.PCEntities;
import andrews.pandoras_creatures.registry.PCSounds;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.Constants.NBT;
import net.minecraftforge.registries.ForgeRegistries;

public class HellhoundEntity extends MonsterEntity
{
	private static final DataParameter<Integer> HELLHOUND_TYPE = EntityDataManager.createKey(HellhoundEntity.class, DataSerializers.VARINT);
	private static Biome[] biomes = new Biome[] {Biomes.NETHER};
	private int isCharging;
	
    public HellhoundEntity(EntityType<? extends HellhoundEntity> type, World worldIn)
    {
        super(type, worldIn);
    }

    public HellhoundEntity(World world, double posX, double posY, double posZ)
    {
        this(PCEntities.HELLHOUND, world);
        this.setPosition(posX, posY, posZ);
    }
    
    @Override
    protected void registerGoals()
    {
    	this.goalSelector.addGoal(1, new HellHoundAttack(this, 0.7D, false));
        this.goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(3, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomWalkingGoal(this, 0.4D, 0.01F));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setCallsForHelp());
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    protected void registerAttributes()
    {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(14.0D);
    }
    
    @Override
	protected void registerData()
    {
		super.registerData();
		this.dataManager.register(HELLHOUND_TYPE, 0);
	}
    
    @Override
	public void writeAdditional(CompoundNBT compound)
    {
		super.writeAdditional(compound);
		compound.putInt("HellhoundType", this.getHellhoundType());
	}
	
	@Override
	public void readAdditional(CompoundNBT compound)
	{
		super.readAdditional(compound);
		this.setHellhoundType(compound.getInt("HellhoundType"));
	}
    
	@Nullable
	@Override
	public ILivingEntityData onInitialSpawn(IWorld world, DifficultyInstance difficulty, SpawnReason reason, ILivingEntityData spawnData, CompoundNBT dataTag)
	{
		spawnData = super.onInitialSpawn(world, difficulty, reason, spawnData, dataTag);
		Random rand = new Random();
		int type = 1;
		if((rand.nextInt(12) + 1) == 12)
		{
			type = 2;
		}
		
		if(dataTag != null && dataTag.contains("HellhoundType", NBT.TAG_INT))
		{
			this.setHellhoundType(dataTag.getInt("HellhoundType"));
			return spawnData;
		}
		this.setHellhoundType(type);
		return spawnData;
	}
	
	/**
	 * Used to drop additional items on the entities death
	 */
	@Override
	protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn)
	{
		super.dropSpecialItems(source, looting, recentlyHitIn);
		if(this.getHellhoundType() == 2)
		{
			this.entityDropItem(new ItemStack(Items.COAL, rand.nextInt(4) + 1));
		}
	}
	
    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id)
    {
    	if(id == 4)
    	{
    		this.isCharging = 1;
    	}
    	else if(id == 5)
    	{
    		this.isCharging = 0;
    	}
    	else
    	{
    		super.handleStatusUpdate(id);
    	}
    }
    
    @OnlyIn(Dist.CLIENT)
    public int getIsCharging()
    {
       return this.isCharging;
    }
    
    public void setIsCharging(int value)
    {
       this.isCharging = value;
    }
    
    @Override
    public void tick()
    {
        super.tick();
        if(this.world.isRemote)
        {
        	Random rand = new Random();
            
        	if((this.ticksExisted % 5) == 0)
        	{
        		double particleY = this.posY + 0.8D;
        		if(this.getHellhoundType() == 2)
        		{
        			particleY += 0.2D;
        		}
        		
        		this.world.addParticle(ParticleTypes.FLAME, this.posX, particleY, this.posZ, (rand.nextDouble() - 0.5D) / 10, (rand.nextDouble() - 0.5D) / 10, (rand.nextDouble() - 0.5D) / 10);
        		this.world.addParticle(ParticleTypes.SMOKE, this.posX, particleY, this.posZ, (rand.nextDouble() - 0.5D) / 10, (rand.nextDouble() - 0.5D) / 10, (rand.nextDouble() - 0.5D) / 10);
        	}
        }
     }
    
    @Override
    public boolean attackEntityAsMob(Entity entityIn)
    {
    	boolean flag;
    	if(this.getHellhoundType() == 2)
    	{
    		flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)(4 + this.rand.nextInt(5)));
    		if(entityIn instanceof LivingEntity)
    		{
    			((LivingEntity)entityIn).addPotionEffect(new EffectInstance(Effects.WITHER, 60));
    		}
    	}
    	else
    	{
    		flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)(2 + this.rand.nextInt(3)));
    	}
        return flag;
    }
    
//    @Override
//    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn)
//    {
//        return sizeIn.height * 0.7F;
//    }
    
    @Override
    public CreatureAttribute getCreatureAttribute()
    {
        return CreatureAttribute.UNDEAD;
    }
    
    @Override
    protected int getExperiencePoints(PlayerEntity player)
    {
    	this.experienceValue = (int)((float)this.experienceValue * 2.0F);
    	return super.getExperiencePoints(player);
    }
    
    @Override
    protected SoundEvent getAmbientSound()
    {
    	return PCSounds.HELLHOUND_AMBIENT;
    }
    
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
    	return PCSounds.HELLHOUND_HURT;
    }
    
    @Override
    protected SoundEvent getDeathSound()
    {
    	return PCSounds.HELLHOUND_DEATH;
    }
    
    @Override
    protected float getSoundVolume()
    {
    	return 0.6F;
    }
    
    /**
     * Used to get the current Hellhound type, if there is none a random type will be generated
     * @return - The Hellhound type Id
     */
    public int getHellhoundType()
    {
    	if(this.dataManager.get(HELLHOUND_TYPE) == 0)
    	{
    		Random rand = new Random();
    		if((rand.nextInt(12) + 1) == 12)
    		{
    			this.dataManager.set(HELLHOUND_TYPE, 2);
    		}
    		else
    		{
    			this.dataManager.set(HELLHOUND_TYPE, 1);
    		}
    		return this.dataManager.get(HELLHOUND_TYPE);
    	}
    	else
    	{
    		return this.dataManager.get(HELLHOUND_TYPE);
    	}
	}
	
    /**
     * Used to set the Hellhound type, different hellhound types use different textures
     * @param typeId - the Hellhound type the entity should become
     */
	public void setHellhoundType(int typeId)
	{
		this.dataManager.set(HELLHOUND_TYPE, typeId);
	}
    
    public static void addSpawn()
    {
		ForgeRegistries.BIOMES.getValues().stream().forEach(HellhoundEntity::processSpawning);
	}
	
    private static void processSpawning(Biome biome)
    {
		if(Arrays.asList(biomes).contains(biome))
		{
			biome.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(PCEntities.HELLHOUND, 30, 3, 6));
        }
	}
}