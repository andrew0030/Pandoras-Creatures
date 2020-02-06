package andrews.pandoras_creatures.entities.bases;

import javax.annotation.Nullable;

import andrews.pandoras_creatures.util.animation.Animation;
import andrews.pandoras_creatures.util.network.NetworkUtil;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

/**
 * Copied Library Functions and Classes from Endergetic
 * see {@link <a href="https://www.curseforge.com/minecraft/mc-mods/endergetic"> Mod Page</a>}.
 * @author SmellyModder(Luke Tonon)
 */
public class AnimatedCreatureEntity extends CreatureEntity
{
	public int frame;
	private int animationTick;
	public static final Animation BLANK_ANIMATION = new Animation();
	private Animation animation = BLANK_ANIMATION;

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
		this.frame++;
		if(!this.isAnimationPlaying(BLANK_ANIMATION))
		{
			if(this.getAnimationTick() == 0)
			{
				this.onAnimationStart(this.animation);
			}
			this.setAnimationTick(this.getAnimationTick() + 1);
			if(this.getAnimationTick() >= this.getPlayingAnimation().getAnimationTickDuration())
			{
				this.onAnimationEnd(this.animation);
				this.resetPlayingAnimationToDefault();
			}
		}
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource source, float amount)
	{
		if(!this.isWorldRemote() && this.getHurtAnimation() != null && this.isAnimationPlaying(BLANK_ANIMATION))
		{
			NetworkUtil.setPlayingAnimationMessage(this, this.getHurtAnimation());
		}
		return super.attackEntityFrom(source, amount);
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
	 * @return - Gets the playing animation
	 */
	public Animation getPlayingAnimation()
	{
		return this.animation;
	}
	
	/**
	 * @return - Gets this entity's animations
	 */
	@Nullable
	public Animation[] getAnimations()
	{
		return null;
	}
	
	/**
	 * @return  - The progress; measured in ticks, of the current playing animation
	 */
	public int getAnimationTick()
	{
		return this.animationTick;
	}
	
	/**
	 * Sets the progress of the current playing animation
	 * @param animationTick - Progress; measured in ticks
	 */
	public void setAnimationTick(int animationTick)
	{
		this.animationTick = animationTick;
	}
	
	/**
	 * Sets an animation to play
	 * @param animationToPlay - The animation to play
	 */
	public void setPlayingAnimation(Animation animationToPlay)
	{
		this.onAnimationEnd(this.animation);
		this.animation = animationToPlay;
		this.setAnimationTick(0);
	}
	
	/**
	 * Resets the current animation to a blank one
	 */
	public void resetPlayingAnimationToDefault()
	{
		this.setPlayingAnimation(BLANK_ANIMATION);
	}
	
	protected void onAnimationStart(Animation animation) {}
	
	protected void onAnimationEnd(Animation animation) {}
	
	@Nullable
	public Animation getHurtAnimation()
	{
		return null;
	}
	
	/**
	 * Used in movement controllers to get the distance between the entity's desired path location and its current position
	 * @param pathX - x location of the path
	 * @param pathY - y location of the path
	 * @param pathZ - z location of the path
	 * @return - A vector containing the mid-position of the entity's path end location and its current location
	 */
	public Vec3d getMoveControllerPathDistance(double pathX, double pathY, double pathZ)
	{
		return new Vec3d(pathX - this.posX, pathY - this.posY, pathY - this.posY);
	}
	
	/**
	 * Used for rotationYaw in movement controllers
	 * @param vec3d - The distance vector
	 * @return - A vector that gets the target angle for a path's distance
	 */
	public float getTargetAngleForPathDistance(Vec3d vec3d)
	{
		return (float) (MathHelper.atan2(vec3d.z, vec3d.x) * (double) (180F / (float) Math.PI)) - 90F;
	}
}