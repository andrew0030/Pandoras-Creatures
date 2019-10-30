package andrews.pandoras_creatures.util.animation;

/**
 * The Animation Class
 */
public class Animation
{
	private int duration; //The duration for an Animation (measured in ticks)
	
	/**
	 * Simple constructor for creating an Animation with a given duration
	 * @param duration - The duration of the Animation (measured in ticks)
	 */
	public Animation(int duration)
	{
		this.duration = duration;
	}
	
	/**
	 * Empty constructor, used to make blank Animations (Animations that do nothing)
	 */
	public Animation()
	{
		this(0);
	}
	
	/**
	 * @return - The duration of this Animation (measured in ticks)
	 */
	public int getDuration()
	{
		return this.duration;
	}
}