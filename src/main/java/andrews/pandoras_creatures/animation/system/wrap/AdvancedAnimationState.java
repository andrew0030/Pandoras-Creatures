package andrews.pandoras_creatures.animation.system.wrap;

import andrews.pandoras_creatures.animation.system.core.Animation;
import andrews.pandoras_creatures.animation.system.core.KeyframeGroup;
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

    @Override
    public void stop()
    {
        super.stop();
        // When we stop an Animation we need to clear the caches
        this.cachedIndex.clear();
        this.cachedLastVec.clear();
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
    public boolean isFinished()//TODO fix this
    {
//        if(!this.isStarted() || this.animation.isLooping())
            return false;
//        float deltaTime = this.animation.getLengthInSeconds() - KeyframeAnimations.getElapsedSeconds(this.animation, this.getAccumulatedTime());
//        return deltaTime <= 0.0F;
    }
}