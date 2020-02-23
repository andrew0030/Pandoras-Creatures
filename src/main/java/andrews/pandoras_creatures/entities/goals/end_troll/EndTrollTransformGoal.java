package andrews.pandoras_creatures.entities.goals.end_troll;

import java.util.EnumSet;

import andrews.pandoras_creatures.entities.EndTrollEntity;
import andrews.pandoras_creatures.util.network.NetworkUtil;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;

public class EndTrollTransformGoal extends Goal
{
	private final EndTrollEntity endTroll;
	private LivingEntity target;
	
	public EndTrollTransformGoal(EndTrollEntity endTroll)
	{
		this.endTroll = endTroll;
	    this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
	}
	
	@Override
	public boolean shouldExecute()
	{
		LivingEntity livingentity = this.endTroll.getAttackTarget();
	    return !this.endTroll.isEntityStanding() && livingentity != null && this.endTroll.getDistanceSq(livingentity) < 150.0D;
	}

	@Override
	public void startExecuting()
	{
		super.startExecuting();
		this.endTroll.getNavigator().clearPath();
	    this.target = this.endTroll.getAttackTarget();
	}
	
	@Override
	public void resetTask()
	{
		super.resetTask();
		this.target = null;
	}
	
	@Override
	public void tick()
	{
		super.tick();
		if(this.target != null)
		{
			if(this.endTroll.isAnimationPlaying(EndTrollEntity.BLANK_ANIMATION) && !this.endTroll.isWorldRemote())
        	{
        		NetworkUtil.setPlayingAnimationMessage(this.endTroll, EndTrollEntity.TRANSFORM_ANIMATION);
        	}
		}
	}
}
