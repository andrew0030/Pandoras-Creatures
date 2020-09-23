package andrews.pandoras_creatures.entities.goals.arachnon;

import andrews.pandoras_creatures.entities.goals.bases.PCMeleeAttackGoal;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.LivingEntity;

public class MeleeAttackGoalWithRange extends PCMeleeAttackGoal
{
	private double attackRange;
	
	public MeleeAttackGoalWithRange(CreatureEntity creature, double speedIn, boolean useLongMemory, double attackRange)
	{
		super(creature, speedIn, useLongMemory);
		this.attackRange = attackRange;
	}
	
	@Override
	protected double getAttackReachSqr(LivingEntity attackTarget)
	{
	    return attackRange + attackTarget.getWidth();
	}
	
	@Override
	protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr)
	{
		double d0 = this.getAttackReachSqr(enemy);
		if(distToEnemySqr <= d0 && this.attackTick <= 0)
		{
			this.attackTick = 40;
			this.attacker.attackEntityAsMob(enemy);
		}
	}
}
