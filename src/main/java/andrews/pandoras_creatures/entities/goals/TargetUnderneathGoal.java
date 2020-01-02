package andrews.pandoras_creatures.entities.goals;

import java.util.EnumSet;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import andrews.pandoras_creatures.entities.AcidicArchvineEntity;
import andrews.pandoras_creatures.registry.PCItems;
import andrews.pandoras_creatures.registry.PCSounds;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.TargetGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.AxisAlignedBB;

public class TargetUnderneathGoal<T extends LivingEntity> extends TargetGoal
{
	private final AcidicArchvineEntity acidicArchvine;
	protected final Class<T> targetClass;
	protected final int targetChance;
	protected LivingEntity nearestTarget;
	/** This filter is applied to the Entity search. Only matching entities will be targeted. */
	protected EntityPredicate targetEntitySelector;

	public TargetUnderneathGoal(MobEntity entity, Class<T> target, boolean p_i50313_3_)
	{
		this(entity, target, p_i50313_3_, false);
	}

	public TargetUnderneathGoal(MobEntity entity, Class<T> target, boolean p_i50314_3_, boolean p_i50314_4_)
	{
		this(entity, target, 10, p_i50314_3_, p_i50314_4_, (Predicate<LivingEntity>)null);
	}

	public TargetUnderneathGoal(MobEntity entity, Class<T> target, int chance, boolean p_i50315_4_, boolean p_i50315_5_, @Nullable Predicate<LivingEntity> predicate)
	{
		super(entity, p_i50315_4_, p_i50315_5_);
		this.acidicArchvine = (AcidicArchvineEntity) entity;
		this.targetClass = target;
		this.targetChance = chance;
		this.setMutexFlags(EnumSet.of(Goal.Flag.TARGET));
		this.targetEntitySelector = (new EntityPredicate()).setDistance(this.getTargetDistance()).setCustomPredicate(predicate);
	}

	/**
    * Returns whether the EntityAIBase should begin execution.
    */
	public boolean shouldExecute()
	{
		if(this.targetChance > 0 && this.goalOwner.getRNG().nextInt(this.targetChance) != 0)
		{
			return false;
		}
		else
		{
			this.findNearestTarget();
			
			//Checks if the targeted entity is instance of PlayerEntity
			if(this.nearestTarget != null && this.nearestTarget instanceof PlayerEntity)
			{
				PlayerEntity player = (PlayerEntity) this.nearestTarget;
				
				//If the player wears the plant helmet the plant will not be able to start attacking him
				if(player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() == PCItems.PLANT_HAT)
				{
					return false;
				}
			}
			
			return this.nearestTarget != null;
		}
	}

	protected AxisAlignedBB getTargetableArea(double targetDistance)
	{
		return this.goalOwner.getBoundingBox().grow(targetDistance / 3, targetDistance, targetDistance / 3).offset(0, -targetDistance, 0);
	}

	protected void findNearestTarget()
	{
		this.nearestTarget = this.goalOwner.world.<T>func_225318_b(this.targetClass, this.targetEntitySelector, this.goalOwner, this.goalOwner.posX, this.goalOwner.posY + (double)this.goalOwner.getEyeHeight(), this.goalOwner.posZ, this.getTargetableArea(this.getTargetDistance()));
	}

	/**
    * Execute a one shot task or start executing a continuous task
    */
	public void startExecuting()
	{
		this.goalOwner.setAttackTarget(this.nearestTarget);
		if(this.acidicArchvine.getAttackTarget() != null)
		{
			this.acidicArchvine.setTargetedEntity(this.acidicArchvine.getAttackTarget().getEntityId());
			this.goalOwner.world.setEntityState(this.goalOwner, (byte)5);
			((AcidicArchvineEntity) this.goalOwner).setAttackState(1);
		}
		super.startExecuting();
	}
	
	@Override
	public void resetTask()
	{
		super.resetTask();
		this.acidicArchvine.setTargetedEntity(0);
		this.goalOwner.world.setEntityState(this.goalOwner, (byte)4);
		((AcidicArchvineEntity) this.goalOwner).setAttackState(0);
		this.nearestTarget.setNoGravity(false);
		if(this.nearestTarget instanceof PlayerEntity)
		{
			PlayerEntity player = (PlayerEntity) this.nearestTarget;
			if(!player.isCreative())
			{
				player.abilities.allowFlying = false;
			}
		}
	}
	
	@Override
	public void tick()
	{
		super.tick();
		if(this.nearestTarget != null)
		{
			double mult = 0.2 / ((this.goalOwner.getPositionVec().distanceTo(this.nearestTarget.getPositionVec())) + 1);
			double dist = this.goalOwner.getPositionVec().distanceTo(this.nearestTarget.getPositionVec());
			
			if(dist > 1.0)
			{
				//Velocity of Player
				this.nearestTarget.setMotion(this.nearestTarget.getMotion().add(this.goalOwner.getPositionVec().subtract(this.nearestTarget.getPositionVec()).mul(mult / 2, mult, mult / 2)));
			}
			else
			{
				if(dist > 0.55)
				{
					this.goalOwner.world.setEntityState(this.goalOwner, (byte)6);
					((AcidicArchvineEntity) this.goalOwner).setAttackState(2);
					this.nearestTarget.setPositionAndUpdate(this.goalOwner.posX, this.goalOwner.posY - 0.5, this.goalOwner.posZ);
					this.nearestTarget.setNoGravity(true);
					if(this.nearestTarget instanceof PlayerEntity)
					{
						PlayerEntity player = (PlayerEntity) this.nearestTarget;
						player.abilities.allowFlying = true;
					}
				}
				
				//Attacks Target every 20 Ticks
				if((this.goalOwner.ticksExisted % 20) == 0)
				{
					this.goalOwner.attackEntityAsMob(this.nearestTarget);
					this.goalOwner.playSound(PCSounds.ACIDIC_ARCHVINE_ATTACK, 1.0F, 1.0F);
				}
			}
			this.nearestTarget.velocityChanged = true;
		}
	}
}