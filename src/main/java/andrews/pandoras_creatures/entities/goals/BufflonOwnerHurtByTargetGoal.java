package andrews.pandoras_creatures.entities.goals;

import java.util.EnumSet;

import andrews.pandoras_creatures.entities.BufflonEntity;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.TargetGoal;

public class BufflonOwnerHurtByTargetGoal extends TargetGoal
{
	private final BufflonEntity bufflonEntity;
	private LivingEntity attacker;
	private int timestamp;

	public BufflonOwnerHurtByTargetGoal(BufflonEntity bufflonEntity)
	{
		super(bufflonEntity, false);
		this.bufflonEntity = bufflonEntity;
		this.setMutexFlags(EnumSet.of(Goal.Flag.TARGET));
	}

	/**
	 * Returns whether the EntityAIBase should begin execution.
	 */
	public boolean shouldExecute()
	{
		if(this.bufflonEntity.isTamed() && !this.bufflonEntity.isSitting() && this.bufflonEntity.isInCombatMode())
		{
			LivingEntity livingentity = this.bufflonEntity.getOwner();
			if(livingentity == null)
			{
				return false;
			}
			else
			{
				this.attacker = livingentity.getRevengeTarget();
				int i = livingentity.getRevengeTimer();
				return i != this.timestamp && this.isSuitableTarget(this.attacker, EntityPredicate.DEFAULT);
			}
		}
		else
		{
			return false;
		}
	}

	/**
	 * Execute a one shot task or start executing a continuous task
	 */
	public void startExecuting()
	{
		this.goalOwner.setAttackTarget(this.attacker);
		LivingEntity livingentity = this.bufflonEntity.getOwner();
		if(livingentity != null)
		{
			this.timestamp = livingentity.getRevengeTimer();
		}

		super.startExecuting();
	}
}