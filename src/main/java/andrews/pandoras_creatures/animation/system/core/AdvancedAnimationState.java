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
    private boolean keepEasingIn = true;

    public AdvancedAnimationState(Animation animation)
    {
        this.animation = animation;
    }

    public AdvancedAnimationState(AdvancedAnimationState state)
    {
        this.lastTime = state.lastTime;
        this.accumulatedTime = state.accumulatedTime;
        this.cachedIndex.putAll(state.cachedIndex);
        this.animation = state.getAnimation();
        this.easeInTime = state.getInTime();
        this.easeOutTime = state.getOutTime();
        this.prevElapsedTime = state.getPrevElapsedTime();
        this.keepEasingIn = state.keepEasingIn();
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

    public void resetInTime()
    {
        this.easeInTime = 0.0F;
    }

    public float getOutTime()
    {
        return this.easeOutTime;
    }

    public boolean keepEasingIn()
    {
        return this.keepEasingIn;
    }

    public void interpolateAndStart(float easeInTime, int ageInTicks)
    {
        keepEasingIn = true;
        this.easeInTime = easeInTime;
        this.startIfStopped(ageInTicks);
    }

    public void interpolateAndStart(float easeInTime, int ageInTicks, boolean keepEasingIn)
    {
        this.keepEasingIn = keepEasingIn;
        this.easeInTime = easeInTime;
        this.startIfStopped(ageInTicks);
    }

    public void interpolateAndStop(float easeOutTime)
    {
        if(this.isStarted())
        {
            // If the Animation is easing in, the ease out time is set to the elapsed time
            float elapsedSeconds = AnimationHandler.getElapsedSeconds(this);
            if (this.getInTime() != 0 && elapsedSeconds < this.getInTime() && easeOutTime >= this.getInTime())
                easeOutTime = elapsedSeconds;

            this.prevElapsedTime = elapsedSeconds;
            this.easeOutTime = easeOutTime;
        }
    }

    public float getPrevElapsedTime()
    {
        return this.prevElapsedTime;
    }
}