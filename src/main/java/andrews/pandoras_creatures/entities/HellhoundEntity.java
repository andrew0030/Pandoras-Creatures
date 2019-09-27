package andrews.pandoras_creatures.entities;

import java.util.Arrays;
import java.util.Random;

import andrews.pandoras_creatures.entities.goals.HellHoundAttack;
import andrews.pandoras_creatures.registry.PCEntities;
import andrews.pandoras_creatures.registry.PCSounds;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.ZombiePigmanEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.ForgeRegistries;

public class HellhoundEntity extends MonsterEntity
{
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
        this.goalSelector.addGoal(4, new WaterAvoidingRandomWalkingGoal(this, 0.4D));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setCallsForHelp());
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    protected void registerAttributes()
    {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(14.0D);
    }
    
    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id)
    {
    	System.out.println(id);
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
        		this.world.addParticle(ParticleTypes.FLAME, this.posX, this.posY + 0.8D, this.posZ, (rand.nextDouble() - 0.5D) / 10, (rand.nextDouble() - 0.5D) / 10, (rand.nextDouble() - 0.5D) / 10);
        		this.world.addParticle(ParticleTypes.SMOKE, this.posX, this.posY + 0.8D, this.posZ, (rand.nextDouble() - 0.5D) / 10, (rand.nextDouble() - 0.5D) / 10, (rand.nextDouble() - 0.5D) / 10);
        	}
        }
     }
    
    @Override
    public boolean attackEntityAsMob(Entity entityIn)
    {
    	boolean flag;
    	if(entityIn instanceof ZombiePigmanEntity)
    	{
    		flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)(10 + this.rand.nextInt(7)));
    	}
    	else
    	{
    		flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)(2 + this.rand.nextInt(3)));
    	}
        return flag;
    }
    
    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn)
    {
        return sizeIn.height * 0.8F;
    }
    
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