package andrews.pandoras_creatures.animation.system.custom;

import net.minecraft.client.animation.AnimationChannel;
import org.joml.Vector3f;

public class AdvancedKeyframe
{
    private final float timestamp;
    private final Vector3f target;
    private final AnimationChannel.Interpolation interpolationType;

    public AdvancedKeyframe(float timestamp, Vector3f target, AnimationChannel.Interpolation interpolationType)
    {
        this.timestamp = timestamp;
        this.target = target;
        this.interpolationType = interpolationType;
    }

    /**
     * @return The timestamp of this Keyframe, basically where on the timeline of the animation it is
     */
    public float timestamp()
    {
        return this.timestamp;
    }

    /**
     * @return A Vector holding XYZ values this Keyframe should have at the given timestamp
     */
    public Vector3f target()
    {
        return this.target;
    }

    /**
     * @return The interpolation type used to transition TODO from or to this keyframe???
     */
    public AnimationChannel.Interpolation interpolationType()
    {
        return this.interpolationType;
    }
}