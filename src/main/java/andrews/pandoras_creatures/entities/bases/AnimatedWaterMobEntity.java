package andrews.pandoras_creatures.entities.bases;

import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public abstract class AnimatedWaterMobEntity extends AnimatedCreatureEntity
{
	protected AnimatedWaterMobEntity(EntityType<? extends AnimatedWaterMobEntity> type, World world)
	{
		super(type, world);
		this.setPathPriority(PathNodeType.WATER, 0.0F);
	}

	@Override
	public boolean canBreatheUnderwater()
	{
		return true;
	}

	@Override
	public CreatureAttribute getCreatureAttribute()
	{
		return CreatureAttribute.WATER;
	}

	@Override
	public boolean isNotColliding(IWorldReader worldIn)
	{
		return worldIn.checkNoEntityCollision(this, VoxelShapes.create(this.getBoundingBox()));
	}

	/**
	 * Get number of ticks, at least during which the living entity will be silent.
	 */
	@Override
	public int getTalkInterval()
	{
		return 120;
	}

	/**
	 * Get the experience points the entity currently has.
	 */
	@Override
	protected int getExperiencePoints(PlayerEntity player)
	{
		return 1 + this.world.rand.nextInt(3);
	}

	protected void updateAir(int air)
	{
		if(this.isAlive() && !this.isInWaterOrBubbleColumn())
		{
			this.setAir(air - 1);
			if(this.getAir() == -20)
			{
				this.setAir(0);
				this.attackEntityFrom(DamageSource.DROWN, 2.0F);
			}
		}
		else
		{
			this.setAir(300);
		}
	}

	/**
	 * Gets called every tick from main Entity class
	 */
	@Override
	public void baseTick()
	{
		int i = this.getAir();
	    super.baseTick();
	    this.updateAir(i);
	}

	@Override
	public boolean isPushedByWater()
	{
		return false;
	}

	@Override
	public boolean canBeLeashedTo(PlayerEntity player)
	{
		return false;
	}
}