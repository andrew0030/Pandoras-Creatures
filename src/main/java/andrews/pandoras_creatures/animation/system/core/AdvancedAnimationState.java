package andrews.pandoras_creatures.animation.system.core;

import andrews.pandoras_creatures.animation.system.core.util.InterpolationType;
import com.google.common.collect.Maps;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.AnimationState;
import org.joml.Vector3f;

import java.util.Map;

public class AdvancedAnimationState extends AnimationState
{
    public Map<KeyframeGroup, Integer> cachedIndex = Maps.newHashMap();
    public Map<KeyframeGroup, Vector3f> cachedLastVec = Maps.newHashMap();
    private final Animation animation;
    private float tickDelay = 0;
    // Interpolation
    private float interpolTime = 0;
    private InterpolationType interpolType;
    private float prevElapsedTime = 0;

    public AdvancedAnimationState(Animation animation)
    {
        this.animation = animation;
    }

    @Override
    public void updateTime(float ageInTicks, float speed)
    {
        if(tickDelay != 0) {
            // If the tickDelay is negative, we reverse it and add the ageInTicks
            if(tickDelay < 0)
                tickDelay = -tickDelay + ageInTicks;
            // Once the ageInTicks is greater than the delay + ageInTicks,
            // we start the animation and reset the delay back to 0
            if((tickDelay - Mth.floor(ageInTicks)) <= 0) {
                this.startIfStopped(Mth.floor(ageInTicks));
                tickDelay = 0;
            }
        }
        super.updateTime(ageInTicks, speed);
    }

    /**
     * Starts this animation after a certain tick delay
     * @param tickDelay How many ticks to wait before starting this animation
     */
    public void startLater(int tickDelay)
    {
        this.tickDelay = -tickDelay;
    }

    /**
     * @return The AnimationDefinition connected to this AnimationState
     */
    public Animation getAnimation()
    {
        return this.animation;
    }

    /**
     * @return Whether this animation has been running longer than its duration. Returns false if the animation is looping or hasn't started
     */
    public boolean isFinished()
    {
        if(!this.isStarted() || this.animation.isLooping())
            return false;
        float deltaTime = this.animation.getLengthInSeconds() - AnimationHandler.getElapsedSeconds(this);
        return deltaTime <= 0.0F;
    }

    @Override
    public void stop()
    {
        super.stop();
        // When we stop an Animation we need to clear the caches
        this.cachedIndex.clear();
        this.cachedLastVec.clear();
        this.interpolTime = 0;
        this.prevElapsedTime = 0;
        this.interpolType = null;
    }

    public void resetInterpolTime()
    {
        this.interpolTime = 0F;
    }

    public float getInterpolTime()
    {
        return this.interpolTime;
    }

    public void interpolateAndStart(float interpolationLength, int ageInTicks, InterpolationType type)
    {
        this.interpolTime = interpolationLength;
        this.interpolType = type;
        this.startIfStopped(ageInTicks);
    }

    public void interpolateAndStop(float interpolationLength, InterpolationType type)
    {
        if(this.isStarted())
        {
            this.prevElapsedTime = AnimationHandler.getElapsedSeconds(this);
            this.interpolTime = interpolationLength;
            this.interpolType = type;
        }
    }

    public InterpolationType getInterpolType()
    {
        return this.interpolType;
    }

    public float getPrevElapsedTime()
    {
        return this.prevElapsedTime;
    }
}