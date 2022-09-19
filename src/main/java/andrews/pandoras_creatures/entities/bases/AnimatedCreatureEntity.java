package andrews.pandoras_creatures.entities.bases;

import andrews.pandoras_creatures.util.animation.Animation;
import andrews.pandoras_creatures.util.network.NetworkUtil;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.ForgeEventFactory;

import javax.annotation.Nullable;

/**
 * Copied Library Functions and Classes from Endergetic
 * see {@link <a href="https://www.curseforge.com/minecraft/mc-mods/endergetic"> Mod Page</a>}.
 * @author SmellyModder(Luke Tonon)
 */
public abstract class AnimatedCreatureEntity extends PathfinderMob implements IAnimatedEntity
{
	private Animation animation = BLANK_ANIMATION;
	private int animationTick;
	private int animationDeathTime;

	public AnimatedCreatureEntity(EntityType<? extends PathfinderMob> type, Level worldIn)
	{
		super(type, worldIn);
	}
	
	/**
	 * Called to update the entity's position/logic. Also used by {@link AnimatedCreatureEntity} to handle some Animation logic
	 */
	@Override
	public void tick()
	{
		super.tick();
		this.animateTick();
		
		//Handles the Death Animation logic
		if(this.getHealth() <= 0.0F && this.getDeathAnimation() != null)
		{
			this.onPCDeathUpdate(this.getDeathAnimation().getAnimationTickDuration());
		}
	}
	
	@Override
	protected void tickDeath()
	{
		if(this.getDeathAnimation() != null)
    	{
			if(!this.isAnimationPlaying(this.getDeathAnimation()) && !this.getCommandSenderWorld().isClientSide())
			{
				NetworkUtil.setPlayingAnimationMessage(this, this.getDeathAnimation());
			}
    	}
		else
		{
			super.tickDeath();
		}
	}
	
	@Override
	public boolean hurt(DamageSource source, float amount)
	{
		if(!this.isWorldRemote() && this.getHurtAnimation() != null && this.isNoAnimationPlaying())
		{
			NetworkUtil.setPlayingAnimationMessage(this, this.getHurtAnimation());
		}
		return super.hurt(source, amount);
	}
	
	/**
	 * Sets an animation to play
	 * @param animationToPlay - The animation to play
	 */
	@Override
	public void setPlayingAnimation(Animation animationToPlay)
	{
		this.onAnimationEnd(this.animation);
		this.animation = animationToPlay;
		this.setAnimationTick(0);
	}
	
	/**
	 * @return - Gets the playing animation
	 */
	public Animation getPlayingAnimation()
	{
		return this.animation;
	}
	
	/**
	 * @param animation - The animation to check
	 * @return - Is the animation playing
	 */
	public boolean isAnimationPlaying(Animation animation)
	{
		return this.getPlayingAnimation() == animation;
	}
	
	/**
	 * @return - Is the world remote; if true: client
	 */
	public boolean isWorldRemote()
	{
		return this.getCommandSenderWorld().isClientSide;
	}
	
	/**
	 * @return - The progress; measured in ticks, of the current playing animation
	 */
	@Override
	public int getAnimationTick()
	{
		return this.animationTick;
	}
	
	/**
	 * Sets the progress of the current playing animation
	 * @param animationTick - Progress; measured in ticks
	 */
	@Override
	public void setAnimationTick(int animationTick)
	{
		this.animationTick = animationTick;
	}

	/**
	 * Resets the current animation to a blank one
	 */
	public void resetAnimation()
	{
		this.setPlayingAnimation(BLANK_ANIMATION);
	}
	
	/**
	 * The hurt animation if the creature has one
	 */
	@Nullable
	public Animation getHurtAnimation()
	{
		return null;
	}
	
	/**
	 * The death animation if the creature has one
	 */
	@Nullable
	public Animation getDeathAnimation()
	{
		return null;
	}
	
	private void onPCDeathUpdate(int deathTime)
	{
		++this.animationDeathTime;
		if(this.animationDeathTime == deathTime)
		{
			if(!this.level.isClientSide && (this.isAlwaysExperienceDropper() || this.lastHurtByPlayerTime > 0 && this.shouldDropExperience() && this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)))
			{
				int i = this.getExperienceReward(this.lastHurtByPlayer);

				i = ForgeEventFactory.getExperienceDrop(this, this.lastHurtByPlayer, i);
				while(i > 0)
				{
					int j = ExperienceOrb.getExperienceValue(i);
					i -= j;
					this.level.addFreshEntity(new ExperienceOrb(this.level, this.getX(), this.getY(), this.getZ(), j));
				}
			}
			
			this.remove(RemovalReason.KILLED);

			for(int k = 0; k < 20; ++k)
			{
				double d2 = this.random.nextGaussian() * 0.02D;
				double d0 = this.random.nextGaussian() * 0.02D;
				double d1 = this.random.nextGaussian() * 0.02D;
				this.level.addParticle(ParticleTypes.POOF,
						this.getX() + (double) (this.random.nextFloat() * this.getBbWidth() * 2.0F) - (double) this.getBbWidth(),
						this.getY() + (double) (this.random.nextFloat() * this.getBbHeight()), this.getZ()
								  + (double) (this.random.nextFloat() * this.getBbWidth() * 2.0F) - (double) this.getBbWidth(), d2, d0, d1);
			}
		}
	}
	
	/**
	 * @return - Returns true if the entity is moving on any axis
	 */
	public boolean isEntityMoving()
	{
		if(this.xo != this.getX() || this.yo != this.getY() || this.zo != this.getZ())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * @return - Returns true if the entity is moving ignoring y axis movement
	 */
	public boolean isEntityMovingHorizontaly()
	{
		if(this.xo != this.getX() || this.zo != this.getZ())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Used in movement controllers to get the distance between the entity's desired path location and its current position
	 * @param pathX - x location of the path
	 * @param pathY - y location of the path
	 * @param pathZ - z location of the path
	 * @return - A vector containing the mid-position of the entity's path end location and its current location
	 */
	public Vec3 getMoveControllerPathDistance(double pathX, double pathY, double pathZ)
	{
		return new Vec3(pathX - this.getX(), pathY - this.getY(), pathY - this.getY());
	}
	
	/**
	 * Used for rotationYaw in movement controllers
	 * @param vec3d - The distance vector
	 * @return - A vector that gets the target angle for a path's distance
	 */
	public float getTargetAngleForPathDistance(Vec3 vec3d)
	{
		return (float) (Mth.atan2(vec3d.z, vec3d.x) * (double) (180F / (float) Math.PI)) - 90F;
	}
}
