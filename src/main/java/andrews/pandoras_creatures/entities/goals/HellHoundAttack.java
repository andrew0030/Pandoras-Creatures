package andrews.pandoras_creatures.entities.goals;

import andrews.pandoras_creatures.entities.HellhoundEntity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;

public class HellHoundAttack extends MeleeAttackGoal
{	
	public HellHoundAttack(CreatureEntity creature, double speedIn, boolean useLongMemory)
	{
		super(creature, speedIn, useLongMemory);
	}
	
	@Override
	protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr)
	{
		double d0 = this.getAttackReachSqr(enemy);
		if(distToEnemySqr <= d0 && this.attackTick <= 0)
		{
			this.attackTick = 10;
			this.attacker.attackEntityAsMob(enemy);
		}
	}
	
	@Override
	public void startExecuting()
	{
		super.startExecuting();
		attacker.world.setEntityState(attacker, (byte)4);
		((HellhoundEntity) this.attacker).setIsCharging(1);
	}
	
	@Override
	public void resetTask()
	{
		super.resetTask();
		((HellhoundEntity) this.attacker).setIsCharging(0);
		attacker.world.setEntityState(attacker, (byte)5);
	}
}