package andrews.pandoras_creatures.entities.bases;

import andrews.pandoras_creatures.util.animation.Animation;

/**
 * Copied Library Functions and Classes from Endergetic
 * see {@link <a href="https://www.curseforge.com/minecraft/mc-mods/endergetic"> Mod Page</a>}.
 * @author SmellyModder(Luke Tonon)
 */
public interface IAnimatedEntity
{
	public static final Animation BLANK_ANIMATION = new Animation();
	
	/**
	 * @return - The entity's animations
	 */
	Animation[] getAnimations();
	
	/**
	 * @return - The animation currently being played
	 */
	Animation getPlayingAnimation();
	
	/**
	 * @return - The progress(in ticks) of the current playing animation
	 */
	int getAnimationTick();
	
	/**
	 * Sets the progress of the current playing animation
	 * @param animationTick - progress(in ticks)
	 */
	void setAnimationTick(int animationTick);
	
	/**
	 * @param animationToPlay - The animation to play
	 */
	void setPlayingAnimation(Animation animationToPlay);
	
	default void onAnimationStart(Animation animation) {};
	
	default void onAnimationEnd(Animation animation) {};
	
	default void resetAnimation()
	{
		this.setPlayingAnimation(BLANK_ANIMATION);
	}
	
	default void animateTick()
	{
		if(!this.isNoAnimationPlaying())
		{
			if(this.getAnimationTick() == 0)
			{
				this.onAnimationStart(this.getPlayingAnimation());
			}
			this.setAnimationTick(this.getAnimationTick() + 1);
			if(this.getAnimationTick() >= this.getPlayingAnimation().getAnimationTickDuration())
			{
				this.onAnimationEnd(this.getPlayingAnimation());
				this.resetAnimation();
			}
		}
	}
	
	default boolean isNoAnimationPlaying()
	{
		return this.getPlayingAnimation() == BLANK_ANIMATION;
	}
	
	default boolean isAnimationPlaying(Animation animation)
	{
		return this.getPlayingAnimation() == animation;
	}
}
