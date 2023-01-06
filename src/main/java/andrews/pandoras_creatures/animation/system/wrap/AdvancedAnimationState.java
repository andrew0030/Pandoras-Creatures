package andrews.pandoras_creatures.animation.system.wrap;

import andrews.pandoras_creatures.animation.system.custom.Animation;
import andrews.pandoras_creatures.animation.system.custom.KeyframeGroup;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.AnimationState;
import org.joml.Vector3f;

import java.util.List;
import java.util.Map;

public class AdvancedAnimationState extends AnimationState
{
    private final Animation animation;
    private float tickDelay = 0;
    public Map<String, Vector3f> rotationCache;
    public Map<KeyframeGroup, Integer> cachedKeyframeIdx;
    public String cachedLastPart;

    public AdvancedAnimationState(Animation animation, Map<String, Vector3f> rotationCache, Map<KeyframeGroup, Integer> cachedKeyframeIdx, String cachedLastPart)
    {
        this.animation = animation;
        this.rotationCache = rotationCache;
        this.cachedKeyframeIdx = cachedKeyframeIdx;
        this.cachedLastPart = cachedLastPart;
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
        this.cachedKeyframeIdx.clear();
        this.rotationCache.clear();//TODO add position and scale
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