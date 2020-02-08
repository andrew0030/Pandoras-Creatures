package andrews.pandoras_creatures.entities.goals.bufflon;

import java.util.EnumSet;

import andrews.pandoras_creatures.entities.BufflonEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;

public class BufflonSitGoal extends Goal
{
	private final BufflonEntity bufflonEntity;
	private boolean isSitting;

	public BufflonSitGoal(BufflonEntity bufflonEntity)
	{
		this.bufflonEntity = bufflonEntity;
		this.setMutexFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
	}

	/**
	 * Returns whether an in-progress EntityAIBase should continue executing
	 */
	public boolean shouldContinueExecuting()
	{
		return this.isSitting;
	}

	/**
	 * Returns whether the EntityAIBase should begin execution.
	 */
	public boolean shouldExecute()
	{
		if(!this.bufflonEntity.isTamed())
		{
			return false;
		}
		else if(this.bufflonEntity.isInWaterOrBubbleColumn())
		{
			return false;
		}
		else if(!this.bufflonEntity.onGround)
		{
			return false;
		}
		else
		{
			LivingEntity livingentity = this.bufflonEntity.getOwner();
			if(livingentity == null)
			{
				return true;
			}
			else
			{
				return this.bufflonEntity.getDistanceSq(livingentity) < 144.0D && livingentity.getRevengeTarget() != null ? false : this.isSitting;
			}
		}
	}

	/**
	 * Execute a one shot task or start executing a continuous task
	 */
	public void startExecuting()
	{
		this.bufflonEntity.getNavigator().clearPath();
		this.bufflonEntity.setSitting(true);
	}

	/**
	 * Reset the task's internal state. Called when this task is interrupted by another one
	 */
	public void resetTask()
	{
		this.bufflonEntity.setSitting(false);
	}

	/**
	 * Sets the sitting flag.
	 */
	public void setSitting(boolean sitting)
	{
		this.isSitting = sitting;
	}
}