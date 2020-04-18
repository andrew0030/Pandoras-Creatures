package andrews.pandoras_creatures.entities.goals.end_troll;

import java.util.EnumSet;

import andrews.pandoras_creatures.entities.EndTrollEntity;
import andrews.pandoras_creatures.util.network.NetworkUtil;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.world.Difficulty;

public class EndTrollScreamGoal extends Goal
{
	private EndTrollEntity goalOwner;
	
	public EndTrollScreamGoal(EndTrollEntity goalOwner)
	{
		this.goalOwner = goalOwner;
		this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
	}

	/**
	 * Returns whether the EntityAIBase should begin execution.
     */
	public boolean shouldExecute()
	{
		if(goalOwner.getEntityWorld().getDifficulty() == Difficulty.PEACEFUL)
		{
			return false;
		}
		LivingEntity livingentity =  goalOwner.getAttackTarget();
		if(livingentity != null && livingentity.isAlive() && goalOwner.isAnimationPlaying(EndTrollEntity.BLANK_ANIMATION) && !goalOwner.isWorldRemote())
		{
			if(!this.goalOwner.getNavigator().noPath() && this.goalOwner.getDistance(livingentity) < 10)
			{
				return goalOwner.screamCooldown == 0;
			}
		}
		return false;
	}
	
	@Override
	public void startExecuting()
	{
		super.startExecuting();
		this.goalOwner.getNavigator().clearPath();
	}
	
	@Override
	public void tick()
	{
		super.tick();
		if(this.goalOwner.getAttackTarget() != null)
		{
			if(this.goalOwner.isAnimationPlaying(EndTrollEntity.BLANK_ANIMATION) && !this.goalOwner.isWorldRemote())
        	{
        		NetworkUtil.setPlayingAnimationMessage(this.goalOwner, EndTrollEntity.SCREAM_ANIMATION);
        		goalOwner.screamCooldown = 600;
        	}
		}
	}
}
