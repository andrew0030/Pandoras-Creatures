package andrews.pandoras_creatures.entities.goals;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;

public class MeleeAttackGoalWithRange extends MeleeAttackGoal
{
	private double attackRange;
//	private LivingEntity enemy;
	
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
	
//	@Override
//	public void tick()
//	{	
//		super.tick();
//		if(attacker instanceof ArachnonEntity)
//		{
//			ArachnonEntity arachnon = (ArachnonEntity) attacker;
//			//Updates the Ticks
//			if(arachnon.getDataManager().get(ArachnonEntity.ATTACKING) == true)
//		    {
//				this.attacker.getNavigator().setSpeed(0);//Makes it so The entity Does not Move while Attacking
//		    }
//			
//			if(arachnon.getDataManager().get(ArachnonEntity.ATTACK_TICKS) == 8)
//			{
//				if(this.enemy != null)
//				{
//					this.attacker.attackEntityAsMob(this.enemy);
//				}
//			}
//		}
//	}
	
//	@Override
//	protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr)
//	{
//		double reachDistance = this.getAttackReachSqr(enemy);
//		
//		if(distToEnemySqr <= reachDistance && this.attackTick <= 0)
//		{
//			this.attackTick = 20;
//			if(attacker instanceof ArachnonEntity)
//			{
//				ArachnonEntity arachnon = (ArachnonEntity) attacker;
//				
//				if(arachnon.getDataManager().get(ArachnonEntity.ATTACKING) == false)
//				{
//					this.enemy = enemy;
//					arachnon.getDataManager().set(ArachnonEntity.ATTACKING, true);
//				}
//			}
//		}
//	}
}
