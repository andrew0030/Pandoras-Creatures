package andrews.pandoras_creatures.entities.bases;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.shapes.Shapes;

public abstract class AnimatedWaterMobEntity extends AnimatedCreatureEntity
{
	protected AnimatedWaterMobEntity(EntityType<? extends AnimatedWaterMobEntity> type, Level world)
	{
		super(type, world);
		this.getPathfindingMalus(BlockPathTypes.WATER);
	}

	@Override
	public boolean canBreatheUnderwater()
	{
		return true;
	}

	@Override
	public MobType getMobType()
	{
		return MobType.WATER;
	}

	@Override
	public boolean checkSpawnObstruction(LevelReader worldIn)
	{
		return worldIn.isUnobstructed(this, Shapes.create(this.getBoundingBox()));
	}

	/**
	 * Get number of ticks, at least during which the living entity will be silent.
	 */
	@Override
	public int getAmbientSoundInterval()
	{
		return 120;
	}

	/**
	 * Get the experience points the entity currently has.
	 */
	@Override
	protected int getExperienceReward(Player player)
	{
		return 1 + this.level.random.nextInt(3);
	}

	protected void updateAir(int air)
	{
		if(this.isAlive() && !this.isInWaterOrBubble())
		{
			this.setAirSupply(air - 1);
			if(this.getAirSupply() == -20)
			{
				this.setAirSupply(0);
				this.hurt(DamageSource.DROWN, 2.0F);
			}
		}
		else
		{
			this.setAirSupply(300);
		}
	}

	/**
	 * Gets called every tick from main Entity class
	 */
	@Override
	public void baseTick()
	{
		int i = this.getAirSupply();
	    super.baseTick();
	    this.updateAir(i);
	}

	@Override
	public boolean isPushedByFluid()
	{
		return false;
	}

	@Override
	public boolean canBeLeashed(Player player)
	{
		return false;
	}
}
