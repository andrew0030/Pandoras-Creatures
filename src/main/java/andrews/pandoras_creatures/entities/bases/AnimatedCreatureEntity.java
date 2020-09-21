package andrews.pandoras_creatures.entities.bases;

import javax.annotation.Nullable;

import andrews.pandoras_creatures.util.animation.Animation;
import andrews.pandoras_creatures.util.network.NetworkUtil;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;

/**
 * Copied Library Functions and Classes from Endergetic
 * see {@link <a href="https://www.curseforge.com/minecraft/mc-mods/endergetic"> Mod Page</a>}.
 * @author SmellyModder(Luke Tonon)
 */
public abstract class AnimatedCreatureEntity extends CreatureEntity implements IAnimatedEntity
{
	private Animation animation = BLANK_ANIMATION;
	private int animationTick;
	private int animationDeathTime;

	public AnimatedCreatureEntity(EntityType<? extends CreatureEntity> type, World worldIn)
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
	protected void onDeathUpdate()
	{
		if(this.getDeathAnimation() != null)
    	{
			if(!this.isAnimationPlaying(this.getDeathAnimation()) && !this.getEntityWorld().isRemote())
			{
				NetworkUtil.setPlayingAnimationMessage(this, this.getDeathAnimation());
			}
    	}
		else
		{
			super.onDeathUpdate();
		}
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource source, float amount)
	{
		if(!this.isWorldRemote() && this.getHurtAnimation() != null && this.isNoAnimationPlaying())
		{
			NetworkUtil.setPlayingAnimationMessage(this, this.getHurtAnimation());
		}
		return super.attackEntityFrom(source, amount);
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
		return this.getEntityWorld().isRemote;
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
			if(!this.world.isRemote && (this.isPlayer() || this.recentlyHit > 0 && this.canDropLoot() && this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)))
			{
				int i = this.getExperiencePoints(this.attackingPlayer);

				i = ForgeEventFactory.getExperienceDrop(this, this.attackingPlayer, i);
				while(i > 0)
				{
					int j = ExperienceOrbEntity.getXPSplit(i);
					i -= j;
					this.world.addEntity(new ExperienceOrbEntity(this.world, this.getPosX(), this.getPosY(), this.getPosZ(), j));
				}
			}
			
			this.remove();

			for(int k = 0; k < 20; ++k)
			{
				double d2 = this.rand.nextGaussian() * 0.02D;
				double d0 = this.rand.nextGaussian() * 0.02D;
				double d1 = this.rand.nextGaussian() * 0.02D;
				this.world.addParticle(ParticleTypes.POOF,
						this.getPosX() + (double) (this.rand.nextFloat() * this.getWidth() * 2.0F) - (double) this.getWidth(),
						this.getPosY() + (double) (this.rand.nextFloat() * this.getHeight()), this.getPosZ()
								  + (double) (this.rand.nextFloat() * this.getWidth() * 2.0F) - (double) this.getWidth(), d2, d0, d1);
			}
		}
	}
	
	/**
	 * @return - Returns true if the entity is moving on any axis
	 */
	public boolean isEntityMoving()
	{
		if(this.prevPosX != this.getPosX() || this.prevPosY != this.getPosY() || this.prevPosZ != this.getPosZ())
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
		if(this.prevPosX != this.getPosX() || this.prevPosZ != this.getPosZ())
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
	public Vector3d getMoveControllerPathDistance(double pathX, double pathY, double pathZ)
	{
		return new Vector3d(pathX - this.getPosX(), pathY - this.getPosY(), pathY - this.getPosY());
	}
	
	/**
	 * Used for rotationYaw in movement controllers
	 * @param vec3d - The distance vector
	 * @return - A vector that gets the target angle for a path's distance
	 */
	public float getTargetAngleForPathDistance(Vector3d vec3d)
	{
		return (float) (MathHelper.atan2(vec3d.z, vec3d.x) * (double) (180F / (float) Math.PI)) - 90F;
	}
}