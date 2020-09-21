package andrews.pandoras_creatures.entities.goals.end_troll;

import java.nio.file.Path;
import java.util.EnumSet;
import java.util.Random;

import andrews.pandoras_creatures.entities.EndTrollEntity;
import andrews.pandoras_creatures.util.network.NetworkUtil;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;

public class EndTrollAttackGoal extends Goal
{
	protected final EndTrollEntity attacker;
	protected int attackTick;
	private final double speedTowardsTarget;
	private final boolean longMemory;
	private Path path;
	private int delayCounter;
	private double targetX;
	private double targetY;
	private double targetZ;
	protected final int attackInterval = 20;
	private long field_220720_k;
	private int failedPathFindingPenalty = 0;
	private boolean canPenalize = false;
	private boolean hasPerformedAttackLogic = false;
	private Random rand = new Random();

	public EndTrollAttackGoal(EndTrollEntity creature, double speedIn, boolean useLongMemory)
	{
		this.attacker = creature;
		this.speedTowardsTarget = speedIn;
		this.longMemory = useLongMemory;
		this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
	}

	/**
	 * Returns whether the EntityAIBase should begin execution.
	 */
	@Override
	public boolean shouldExecute()
	{
		if(attacker.getEntityWorld().getDifficulty() == Difficulty.PEACEFUL)
		{
			return false;
		}
		long i = this.attacker.world.getGameTime();
		if (i - this.field_220720_k < 20L)
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
					return this.getAttackReachSqr(livingentity) >= this.attacker.getDistanceSq(livingentity.getPosX(), livingentity.getBoundingBox().minY, livingentity.getPosZ());
				}
			}
		}
	}

	/**
	 * Returns whether an in-progress EntityAIBase should continue executing
	 */
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
		else if(!this.attacker.isWithinHomeDistanceFromPosition(new BlockPos(livingentity)))
		{
			return false;
		}
		else
		{
			return !(livingentity instanceof PlayerEntity) || !livingentity.isSpectator() && !((PlayerEntity) livingentity).isCreative();
		}
	}

	/**
	 * Execute a one shot task or start executing a continuous task
	 */
	@Override
	public void startExecuting()
	{
		this.attacker.getNavigator().setPath(this.path, this.speedTowardsTarget);
		this.attacker.setAggroed(true);
		this.delayCounter = 0;
	}

	/**
	 * Reset the task's internal state. Called when this task is interrupted by
	 * another one
	 */
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

	/**
	 * Keep ticking a continuous task that has already been started
	 */
	@Override
	public void tick()
	{	
		if(!this.attacker.isAnimationPlaying(EndTrollEntity.RIGHT_PUNCH_ANIMATION) && !this.attacker.isAnimationPlaying(EndTrollEntity.LEFT_PUNCH_ANIMATION) && !this.attacker.isAnimationPlaying(EndTrollEntity.DOUBLE_PUNCH_ANIMATION))
		{
			//We need this because Minecraft is Minecraft and it skips ticks some times :/
			if(this.hasPerformedAttackLogic)
			{
				this.hasPerformedAttackLogic = false;
			}
			
			LivingEntity livingentity = this.attacker.getAttackTarget();
			this.attacker.getLookController().setLookPositionWithEntity(livingentity, 30.0F, 30.0F);
			double d0 = this.attacker.getDistanceSq(livingentity.getPosX(), livingentity.getBoundingBox().minY, livingentity.getPosZ());
			--this.delayCounter;
			if((this.longMemory || this.attacker.getEntitySenses().canSee(livingentity)) && this.delayCounter <= 0 && (this.targetX == 0.0D && this.targetY == 0.0D && this.targetZ == 0.0D || livingentity.getDistanceSq(this.targetX, this.targetY, this.targetZ) >= 1.0D || this.attacker.getRNG().nextFloat() < 0.05F))
			{
				this.targetX = livingentity.getPosX();
				this.targetY = livingentity.getBoundingBox().minY;
			 	this.targetZ = livingentity.getPosZ();
			 	this.delayCounter = 4 + this.attacker.getRNG().nextInt(7);
			 	if(this.canPenalize)
			 	{
			 		this.delayCounter += failedPathFindingPenalty;
			 		if(this.attacker.getNavigator().getPath() != null)
			 		{
			 			net.minecraft.pathfinding.PathPoint finalPathPoint = this.attacker.getNavigator().getPath().getFinalPathPoint();
					 	if(finalPathPoint != null && livingentity.getDistanceSq(finalPathPoint.x, finalPathPoint.y, finalPathPoint.z) < 1)
					 	{
					 		failedPathFindingPenalty = 0;
					 	}
					 	else
					 	{
					 		failedPathFindingPenalty += 10;
					 	}
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
			this.checkAndPlayAnimation(livingentity, d0);
		}
		else
		{	
			if((attacker.isAnimationPlaying(EndTrollEntity.RIGHT_PUNCH_ANIMATION) || attacker.isAnimationPlaying(EndTrollEntity.LEFT_PUNCH_ANIMATION) || attacker.isAnimationPlaying(EndTrollEntity.DOUBLE_PUNCH_ANIMATION)) && attacker.getAnimationTick() >= 10)
			{
				if(!this.hasPerformedAttackLogic)
				{
					LivingEntity livingentity = this.attacker.getAttackTarget();
					this.attackTick = 20;
					if(attacker.isAnimationPlaying(EndTrollEntity.DOUBLE_PUNCH_ANIMATION))
					{
						this.attacker.attackEntityAsMob(livingentity, true);
					}
					else
					{
						this.attacker.attackEntityAsMob(livingentity, false);
					}
					this.hasPerformedAttackLogic = true;
				}
			}
		}
	}

	protected void checkAndPlayAnimation(LivingEntity enemy, double distToEnemySqr)
	{
		double reachDistance = this.getAttackReachSqr(enemy);
		if (distToEnemySqr <= reachDistance && this.attackTick <= 0)
		{
			if(attacker.isAnimationPlaying(EndTrollEntity.BLANK_ANIMATION) && !attacker.getEntityWorld().isRemote())
        	{
				switch(rand.nextInt(3))
				{
				case 0:
					NetworkUtil.setPlayingAnimationMessage(attacker, EndTrollEntity.RIGHT_PUNCH_ANIMATION);
					break;
				case 1:
					NetworkUtil.setPlayingAnimationMessage(attacker, EndTrollEntity.LEFT_PUNCH_ANIMATION);
					break;
				case 2:
					NetworkUtil.setPlayingAnimationMessage(attacker, EndTrollEntity.DOUBLE_PUNCH_ANIMATION);
					break;
				default:
					break;
				}
        	}
		}
	}

	protected double getAttackReachSqr(LivingEntity attackTarget)
	{
		return (double)(this.attacker.getWidth() * 2.0F * this.attacker.getWidth() * 2.0F + attackTarget.getWidth());
	}
}