package andrews.pandoras_creatures.util.animation;

/**
 * Copied Library Functions and Classes from Endergetic
 * see {@link <a href="https://www.curseforge.com/minecraft/mc-mods/endergetic"> Mod Page</a>}.
 * @author SmellyModder(Luke Tonon)
 */
public class Animation
{
	private int tickDuration;
	
	/**
	 * Simple constructor for an Animation
	 * @param tickDuration - Duration of how long the animation plays for; measured in ticks
	 */
	public Animation(int tickDuration)
	{
		this.tickDuration = tickDuration;
	}
	
	/**
	 * Empty constructor; used for making animations that do nothing
	 */
	public Animation()
	{
		this(0);
	}
	
	/**
	 * @return - The duration of this animation; measured in ticks
	 */
	public int getAnimationTickDuration()
	{
		return this.tickDuration;
	}
}