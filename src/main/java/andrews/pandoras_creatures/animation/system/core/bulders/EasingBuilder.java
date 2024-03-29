package andrews.pandoras_creatures.animation.system.core.bulders;

import andrews.pandoras_creatures.animation.system.core.types.EasingTypes;
import andrews.pandoras_creatures.animation.system.core.types.util.EasingType;

public class EasingBuilder
{
    private final EasingType easingType;
    private float value;

    private EasingBuilder(EasingType easingType)
    {
        this.easingType = easingType;
    }

    public static EasingBuilder type(EasingType easingType)
    {
        return new EasingBuilder(easingType);
    }

    public EasingBuilder argument(float value)
    {
        this.value = value;
        return this;
    }

    public EasingTypes build()
    {
        return new EasingTypes(this.easingType, this.value);
    }
}