package andrews.pandoras_creatures.entities.goals.bufflon;

import java.util.EnumSet;

import andrews.pandoras_creatures.entities.BufflonEntity;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.pathfinding.GroundPathNavigator;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorldReader;

public class BufflonFollowOwnerGoal extends Goal
{
	protected final BufflonEntity bufflonEntity;
	private LivingEntity owner;
	protected final IWorldReader world;
	private final double followSpeed;
	private final PathNavigator navigator;
	private int timeToRecalcPath;
	private final float maxDist;
	private final float minDist;
	private float oldWaterCost;

	public BufflonFollowOwnerGoal(BufflonEntity bufflonEntity, double followSpeedIn, float minDistIn, float maxDistIn)
	{
		this.bufflonEntity = bufflonEntity;
		this.world = bufflonEntity.world;
		this.followSpeed = followSpeedIn;
		this.navigator = bufflonEntity.getNavigator();
		this.minDist = minDistIn;
		this.maxDist = maxDistIn;
		this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
		if(!(bufflonEntity.getNavigator() instanceof GroundPathNavigator) && !(bufflonEntity.getNavigator() instanceof FlyingPathNavigator))
		{
			throw new IllegalArgumentException("Unsupported mob type for FollowOwnerGoal");
		}
	}

	/**
	 * Returns whether the EntityAIBase should begin execution.
	 */
	public boolean shouldExecute()
	{
		LivingEntity livingentity = this.bufflonEntity.getOwner();
		if(livingentity == null)
		{
			return false;
		}
		else if(livingentity instanceof PlayerEntity && ((PlayerEntity) livingentity).isSpectator())
		{
			return false;
		}
		else if(this.bufflonEntity.isSitting())
		{
			return false;
		}
		else if(!this.bufflonEntity.isFollowingOwner())
		{
			return false;
		}
		else if(this.bufflonEntity.getDistanceSq(livingentity) < (double) (this.minDist * this.minDist))
		{
			return false;
		}
		else
		{
			this.owner = livingentity;
			return true;
		}
	}

	/**
	 * Returns whether an in-progress EntityAIBase should continue executing
	 */
	public boolean shouldContinueExecuting()
	{
		return !this.navigator.noPath()
				&& this.bufflonEntity.getDistanceSq(this.owner) > (double) (this.maxDist * this.maxDist)
				&& !this.bufflonEntity.isSitting()
				&& this.bufflonEntity.isFollowingOwner();
	}

	/**
	 * Execute a one shot task or start executing a continuous task
	 */
	public void startExecuting()
	{
		this.timeToRecalcPath = 0;
		this.oldWaterCost = this.bufflonEntity.getPathPriority(PathNodeType.WATER);
		this.bufflonEntity.setPathPriority(PathNodeType.WATER, 0.0F);
	}

	/**
	 * Reset the task's internal state. Called when this task is interrupted by
	 * another one
	 */
	public void resetTask()
	{
		this.owner = null;
		this.navigator.clearPath();
		this.bufflonEntity.setPathPriority(PathNodeType.WATER, this.oldWaterCost);
	}

	/**
	 * Keep ticking a continuous task that has already been started
	 */
	public void tick()
	{
		this.bufflonEntity.getLookController().setLookPositionWithEntity(this.owner, 10.0F, (float) this.bufflonEntity.getVerticalFaceSpeed());
		if(!this.bufflonEntity.isSitting() && this.bufflonEntity.isFollowingOwner())
		{
			if(--this.timeToRecalcPath <= 0)
			{
				this.timeToRecalcPath = 10;
				if(!this.navigator.tryMoveToEntityLiving(this.owner, this.followSpeed))
				{
					if(!this.bufflonEntity.getLeashed() && !this.bufflonEntity.isPassenger())
					{
						if(!(this.bufflonEntity.getDistanceSq(this.owner) < 144.0D))
						{
							int i = MathHelper.floor(this.owner.getPosX()) - 2;
							int j = MathHelper.floor(this.owner.getPosZ()) - 2;
							int k = MathHelper.floor(this.owner.getBoundingBox().minY);

							for(int l = 0; l <= 4; ++l)
							{
								for(int i1 = 0; i1 <= 4; ++i1)
								{
									if((l < 1 || i1 < 1 || l > 3 || i1 > 3) && this.canTeleportToBlock(new BlockPos(i + l, k - 1, j + i1)))
									{
										this.bufflonEntity.setLocationAndAngles((double) ((float) (i + l) + 0.5F), (double) k, (double) ((float) (j + i1) + 0.5F), this.bufflonEntity.rotationYaw, this.bufflonEntity.rotationPitch);
										this.navigator.clearPath();
										return;
									}
								}
							}

						}
					}
				}
			}
		}
	}

	protected boolean canTeleportToBlock(BlockPos pos)
	{
		BlockState blockstate = this.world.getBlockState(pos);
		return blockstate.canEntitySpawn(this.world, pos, this.bufflonEntity.getType()) && this.world.isAirBlock(pos.up()) && this.world.isAirBlock(pos.up(2));
	}
}