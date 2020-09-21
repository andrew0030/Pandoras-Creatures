package andrews.pandoras_creatures.entities.goals.bases;

import java.util.EnumSet;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.pathfinding.Path;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.Hand;

public class PCMeleeAttackGoal extends Goal
{
	protected final CreatureEntity attacker;
	private final double speedTowardsTarget;
	private final boolean longMemory;
	private Path path;
	private double targetX;
	private double targetY;
	private double targetZ;
	private int delayCounter;
	protected int attackTick;
	private long field_220720_k;
	private int failedPathFindingPenalty = 0;
	private boolean canPenalize = false;

	public PCMeleeAttackGoal(CreatureEntity creature, double speed, boolean useLongMemory)
	{
		this.attacker = creature;
		this.speedTowardsTarget = speed;
		this.longMemory = useLongMemory;
		this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
	}

	@Override
	public boolean shouldExecute()
	{
		long i = this.attacker.world.getGameTime();
		if(i - this.field_220720_k < 20L)
		{
			return false;
		}
		else
		{
			this.field_220720_k = i;
			LivingEntity livingentity = this.attacker.getAttackTarget();
			if(livingentity == null)
			{
				return false;
			}
			else if(!livingentity.isAlive())
			{
				return false;
			}
			else
			{
				if(canPenalize)
				{
					if(--this.delayCounter <= 0)
					{
						this.path = this.attacker.getNavigator().getPathToEntity(livingentity, 0);
						this.delayCounter = 4 + this.attacker.getRNG().nextInt(7);
						return this.path != null;
					}
					else
					{
						return true;
					}
				}
				this.path = this.attacker.getNavigator().getPathToEntity(livingentity, 0);
				if(this.path != null)
				{
					return true;
				}
				else
				{
					return this.getAttackReachSqr(livingentity) >= this.attacker.getDistanceSq(livingentity.getPosX(), livingentity.getPosY(), livingentity.getPosZ());
				}
			}
		}
	}

	@Override
	public boolean shouldContinueExecuting()
	{
		LivingEntity livingentity = this.attacker.getAttackTarget();
		if(livingentity == null)
		{
			return false;
		}
		else if(!livingentity.isAlive())
		{
			return false;
		}
		else if(!this.longMemory)
		{
			return !this.attacker.getNavigator().noPath();
		}
		else if(!this.attacker.isWithinHomeDistanceFromPosition(livingentity.getPosition()))
		{
			return false;
		}
		else
		{
			return !(livingentity instanceof PlayerEntity) || !livingentity.isSpectator() && !((PlayerEntity) livingentity).isCreative();
		}
	}

	@Override
	public void startExecuting()
	{
		this.attacker.getNavigator().setPath(this.path, this.speedTowardsTarget);
		this.attacker.setAggroed(true);
		this.delayCounter = 0;
		this.attackTick = 0;
	}

	@Override
	public void resetTask()
	{
		LivingEntity livingentity = this.attacker.getAttackTarget();
		if(!EntityPredicates.CAN_AI_TARGET.test(livingentity))
		{
			this.attacker.setAttackTarget((LivingEntity) null);
		}

		this.attacker.setAggroed(false);
		this.attacker.getNavigator().clearPath();
	}

	@Override
	public void tick()
	{
		LivingEntity livingentity = this.attacker.getAttackTarget();
		this.attacker.getLookController().setLookPositionWithEntity(livingentity, 30.0F, 30.0F);
		double d0 = this.attacker.getDistanceSq(livingentity.getPosX(), livingentity.getPosY(), livingentity.getPosZ());
		this.delayCounter = Math.max(this.delayCounter - 1, 0);
		if((this.longMemory || this.attacker.getEntitySenses().canSee(livingentity)) && this.delayCounter <= 0
			&& (this.targetX == 0.0D && this.targetY == 0.0D && this.targetZ == 0.0D
			|| livingentity.getDistanceSq(this.targetX, this.targetY, this.targetZ) >= 1.0D
			|| this.attacker.getRNG().nextFloat() < 0.05F)) {
			this.targetX = livingentity.getPosX();
			this.targetY = livingentity.getPosY();
			this.targetZ = livingentity.getPosZ();
			this.delayCounter = 4 + this.attacker.getRNG().nextInt(7);
			if(this.canPenalize)
			{
				this.delayCounter += failedPathFindingPenalty;
				if(this.attacker.getNavigator().getPath() != null)
				{
					PathPoint finalPathPoint = this.attacker.getNavigator().getPath().getFinalPathPoint();
					if(finalPathPoint != null && livingentity.getDistanceSq(finalPathPoint.x, finalPathPoint.y, finalPathPoint.z) < 1)
						failedPathFindingPenalty = 0;
					else
						failedPathFindingPenalty += 10;
				}
				else
				{
					failedPathFindingPenalty += 10;
				}
			}
			if(d0 > 1024.0D)
			{
				this.delayCounter += 10;
			}
			else if(d0 > 256.0D)
			{
				this.delayCounter += 5;
			}

			if(!this.attacker.getNavigator().tryMoveToEntityLiving(livingentity, this.speedTowardsTarget))
			{
				this.delayCounter += 15;
			}
		}

		this.attackTick = Math.max(this.attackTick - 1, 0);
		this.checkAndPerformAttack(livingentity, d0);
	}

	protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr)
	{
		double d0 = this.getAttackReachSqr(enemy);
		if(distToEnemySqr <= d0 && this.attackTick <= 0)
		{
			this.func_234039_g_();
			this.attacker.swingArm(Hand.MAIN_HAND);
			this.attacker.attackEntityAsMob(enemy);
		}
	}

	protected void func_234039_g_()
	{
		this.attackTick = 20;
	}

	protected boolean func_234040_h_()
	{
		return this.attackTick <= 0;
	}

	protected int func_234041_j_()
	{
		return this.attackTick;
	}

	protected int func_234042_k_()
	{
		return 20;
	}

	protected double getAttackReachSqr(LivingEntity attackTarget)
	{
		return (double) (this.attacker.getWidth() * 2.0F * this.attacker.getWidth() * 2.0F + attackTarget.getWidth());
	}
}