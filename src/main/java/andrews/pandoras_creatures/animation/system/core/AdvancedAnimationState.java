package andrews.pandoras_creatures.animation.system.core;

import com.google.common.collect.Maps;
import net.minecraft.world.entity.AnimationState;

import java.util.Map;

public class AdvancedAnimationState extends AnimationState
{
    public Map<KeyframeGroup, Integer> cachedIndex = Maps.newHashMap();
    private final Animation animation;
    // Interpolation
    private float easeInTime = 0;
    private float easeOutTime = 0;
    private float prevElapsedTime = 0;

    public AdvancedAnimationState(Animation animation)
    {
        this.animation = animation;
    }

    /**
     * @return The AnimationDefinition connected to this AnimationState
     */
    public Animation getAnimation()
    {
        return this.animation;
    }

    @Override
    public void stop()
    {
        super.stop();
        // When we stop an Animation we need to clear the caches
        this.cachedIndex.clear();
        this.easeInTime = 0;
        this.easeOutTime = 0;
        this.prevElapsedTime = 0;
    }

    public float getInTime()
    {
        return this.easeInTime;
    }

    public float getOutTime()
    {
        return this.easeOutTime;
    }

    public void interpolateAndStart(float easeInTime, int ageInTicks)
    {
        this.easeInTime = easeInTime;
        this.startIfStopped(ageInTicks);
    }

    public void interpolateAndStop(float easeOutTime)
    {
        if(this.isStarted())
        {
            this.prevElapsedTime = AnimationHandler.getElapsedSeconds(this);
            this.easeOutTime = easeOutTime;
        }
    }

    public float getPrevElapsedTime()
    {
        return this.prevElapsedTime;
    }
}