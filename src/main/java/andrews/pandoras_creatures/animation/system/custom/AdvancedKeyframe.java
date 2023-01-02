package andrews.pandoras_creatures.animation.system.custom;

import andrews.pandoras_creatures.animation.system.custom.types.EasingTypes;
import org.joml.Vector3f;

public class AdvancedKeyframe
{
    private final float timestamp;
    private final Vector3f target;
    private final EasingTypes easingType;

    public AdvancedKeyframe(float timestamp, Vector3f target, EasingTypes easingType)
    {
        this.timestamp = timestamp;
        this.target = target;
        this.easingType = easingType;
    }

    public float timestamp() {
        return this.timestamp;
    }

    public Vector3f target() {
        return this.target;
    }

    public EasingTypes getEasingType()
    {
        return this.easingType;
    }
}