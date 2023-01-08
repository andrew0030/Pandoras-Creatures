package andrews.pandoras_creatures.animation.system.core;

import andrews.pandoras_creatures.animation.system.core.types.EasingTypes;
import org.joml.Vector3f;

public class BasicKeyframe
{
    private final float timestamp;
    private final Vector3f target;
    private final EasingTypes easingType;

    public BasicKeyframe(float timestamp, Vector3f target, EasingTypes easingType)
    {
        this.timestamp = timestamp;
        this.target = target;
        this.easingType = easingType;
    }

    /**
     * This constructor is used by {@link MolangKeyframe} to skip setting the EasingType every time, as they all use the same
     */
    protected BasicKeyframe(float timestamp, Vector3f target)
    {//TODO maybe set target to empty vector?
        this(timestamp, target, EasingTypes.MOLANG);
    }

    public float timestamp()
    {
        return this.timestamp;
    }

    public Vector3f target()
    {
        return this.target;
    }

    public EasingTypes getEasingType()
    {
        return this.easingType;
    }
}