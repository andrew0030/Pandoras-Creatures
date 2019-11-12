package andrews.pandoras_creatures.entities.bases;

import javax.annotation.Nullable;

import andrews.pandoras_creatures.util.animation.Animation;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;

/**
 * Copied Library Functions and Classes from Endergetic
 * see {@link <a href="https://www.curseforge.com/minecraft/mc-mods/endergetic"> Mod Page</a>}.
 * @author SmellyModder(Luke Tonon)
 */
public class AnimatedCreatureEntity extends CreatureEntity
{
	private static final DataParameter<Integer> ANIMATION_TICK = EntityDataManager.createKey(AnimatedCreatureEntity.class, DataSerializers.VARINT);
	public static final Animation BLANK_ANIMATION = new Animation();
	private Animation animation = BLANK_ANIMATION;
	public int frame;

	public AnimatedCreatureEntity(EntityType<? extends CreatureEntity> type, World worldIn)
	{
		super(type, worldIn);
	}
	
	/**
	 * Used to register the DataParameter values
	 */
	@Override
	protected void registerData()
	{
		super.registerData();
		this.dataManager.register(ANIMATION_TICK, 0);
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
			this.setAnimationTick(this.getAnimationTick() + 1);
			if(this.getEntityWorld().isRemote)
			{
				if(this.getAnimationTick() >= this.getPlayingAnimation().getAnimationTickDuration())
				{
					this.setAnimationToBlank();
				}
			}
		}
	}
	
	/**
	 * Checks if the given Animation is currently playing
	 * @param animation - The animation to check
	 * @return - Is the animation playing
	 */
	public boolean isAnimationPlaying(Animation animation)
	{
		return this.getPlayingAnimation() == animation;
	}
	
	/**
	 * @return - Gets the Animation that is currently playing
	 */
	public Animation getPlayingAnimation()
	{
		return this.animation;
	}
	
	/**
	 * Starts playing the given Animation
	 * @param animationToPlay - The Animation that will be played
	 */
	public void setPlayingAnimation(Animation animationToPlay)
	{
		this.animation = animationToPlay;
		this.setAnimationTick(0);
	}
	
	/**
	 * @return - An array list of Animations this entity has
	 */
	@Nullable
	public Animation[] getAnimations()
	{
		return null;
	}
	
	/**
	 * Sets the current Animation back to the blank one
	 */
	public void setAnimationToBlank()
	{
		this.animation = BLANK_ANIMATION;
	}
	
	/**
	 * @return  - The current tick of the playing Animation
	 */
	public int getAnimationTick()
	{
		return this.dataManager.get(ANIMATION_TICK);
	}
	
	/**
	 * Sets the progress of the currently playing Animation to the given tick
	 * @param animationTick - The tick the Animation progress will be set to
	 */
	public void setAnimationTick(int animationTick)
	{
		this.dataManager.set(ANIMATION_TICK, animationTick);
	}
}