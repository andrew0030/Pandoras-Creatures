package andrews.pandoras_creatures.entities;

import andrews.pandoras_creatures.entities.bases.AnimatedMonsterEntity;
import andrews.pandoras_creatures.entities.goals.arachnon.MeleeAttackGoalWithRange;
import andrews.pandoras_creatures.registry.PCEntities;
import andrews.pandoras_creatures.registry.PCItems;
import andrews.pandoras_creatures.registry.PCSounds;
import andrews.pandoras_creatures.util.animation.Animation;
import net.minecraft.block.BlockState;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Pose;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ArachnonEntity extends AnimatedMonsterEntity
{
	private int attackTimer;
	
    public ArachnonEntity(EntityType<? extends ArachnonEntity> type, World worldIn)
    {
        super(type, worldIn);
    }

    public ArachnonEntity(World world, double posX, double posY, double posZ)
    {
        this(PCEntities.ARACHNON.get(), world);
        this.setPosition(posX, posY, posZ);
    }
    
    @Override
    protected void registerGoals()
    {
    	this.goalSelector.addGoal(1, new SwimGoal(this));
    	this.goalSelector.addGoal(2, new MeleeAttackGoalWithRange(this, 0.48D, false, 10.0F));
        this.goalSelector.addGoal(2, new MeleeAttackGoalWithRange(this, 0.48D, false, 10.0F));
        this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 0.48D));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
    	return new ItemStack(PCItems.ARACHNON_SPAWN_EGG.get());
    }
    
    @Override
	public Animation[] getAnimations()
    {
		return null;
	}
    
    @Override
    protected int getExperiencePoints(PlayerEntity player)
    {
    	this.experienceValue = (int)((float)this.experienceValue * 5.0F);
    	return super.getExperiencePoints(player);
    }
    
    @Override
    public void livingTick()
    {
    	super.livingTick();
        if(this.attackTimer > 0)
        {
           --this.attackTimer;
        }
    }
    
    @Override
    public boolean attackEntityAsMob(Entity entityIn)
    {
        this.attackTimer = 10;
        this.world.setEntityState(this, (byte)4);
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)(6 + this.rand.nextInt(5)));
        return flag;
    }
    
    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id)
    {
    	if(id == 4)
    	{
    		this.attackTimer = 10;
//        	this.playSound(SoundEvents.ENTITY_IRON_GOLEM_ATTACK, 1.0F, 1.0F);
    	}
    	else
    	{
    		super.handleStatusUpdate(id);
    	}
    }
    
    @OnlyIn(Dist.CLIENT)
    public int getAttackTimer()
    {
       return this.attackTimer;
    }
    
    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn)
    {
        return sizeIn.height * 0.8F;
    }

    @Override
    public int getMaxSpawnedInChunk()
    {
        return 1;
    }
    
    @Override
    protected SoundEvent getAmbientSound()
    {
    	return PCSounds.ARACHNON_AMBIENT.get();
    }
    
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
    	return PCSounds.ARACHNON_HURT.get();
    }
    
    @Override
    protected SoundEvent getDeathSound()
    {
    	return PCSounds.ARACHNON_DEATH.get();
    }
    
    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn)
    {
        this.playSound(SoundEvents.ENTITY_IRON_GOLEM_STEP, 1.5F, 0.4F);
    }
    
    @Override
    public CreatureAttribute getCreatureAttribute()
    {
        return CreatureAttribute.ARTHROPOD;
    }
}