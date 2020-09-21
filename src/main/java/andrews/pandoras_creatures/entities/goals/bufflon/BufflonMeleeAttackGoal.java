package andrews.pandoras_creatures.entities.goals.bufflon;

import andrews.pandoras_creatures.entities.BufflonEntity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.Difficulty;

public class BufflonMeleeAttackGoal extends MeleeAttackGoal
{
	public BufflonMeleeAttackGoal(CreatureEntity creature, double speedIn, boolean useLongMemory)
	{
		super(creature, speedIn, useLongMemory);
	}

	@Override
	public boolean shouldExecute()
	{
		if(attacker.getEntity() instanceof BufflonEntity)
		{
			if(attacker.getEntityWorld().getDifficulty() == Difficulty.PEACEFUL && attacker.getAttackTarget() != null && attacker.getAttackTarget() instanceof PlayerEntity)
			{
				return false;
			}
		}
		return super.shouldExecute();
	}
}
