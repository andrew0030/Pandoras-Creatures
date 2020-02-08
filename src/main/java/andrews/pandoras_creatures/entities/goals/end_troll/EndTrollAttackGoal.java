package andrews.pandoras_creatures.entities.goals.end_troll;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;

public class EndTrollAttackGoal extends MeleeAttackGoal
{

	public EndTrollAttackGoal(CreatureEntity creature, double speedIn, boolean useLongMemory)
	{
		super(creature, speedIn, useLongMemory);
	}

	@Override
	protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr)
	{
		super.checkAndPerformAttack(enemy, distToEnemySqr);
	}
}
