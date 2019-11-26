package andrews.pandoras_creatures.entities.goals;

import andrews.pandoras_creatures.entities.BufflonEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;

public class BufflonNonTamedTargetGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T>
{
	private final BufflonEntity bufflonEntity;

	public BufflonNonTamedTargetGoal(BufflonEntity bufflonEntity, Class<T> target, boolean longTerm)
	{
		super(bufflonEntity, target, 10, longTerm, false, null);
		this.bufflonEntity = bufflonEntity;
	}

	/**
	 * Returns whether the EntityAIBase should begin execution.
	 */
	public boolean shouldExecute()
	{
		return !this.bufflonEntity.isTamed() && !this.bufflonEntity.isBeingRidden() && super.shouldExecute();
	}

	/**
	 * Returns whether an in-progress EntityAIBase should continue executing
	 */
	public boolean shouldContinueExecuting()
	{
		if(this.targetEntitySelector != null)
		{
			if(this.goalOwner.isBeingRidden())
			{
				return false;
			}
			else
			{
				return this.targetEntitySelector.canTarget(this.goalOwner, this.nearestTarget);
			}
		}
		else
		{
			return super.shouldContinueExecuting();
		}
	}
}