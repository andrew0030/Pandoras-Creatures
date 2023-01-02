package andrews.pandoras_creatures.animation.system.custom.types.builder;

import andrews.pandoras_creatures.animation.system.custom.types.EasingTypes;

public class EasingBuilder
{
    private final EasingType easingType;
    private int steps;//TODO maybe add other "optional" values once I add more easing types, or replace step with something more generic

    private EasingBuilder(EasingType easingType)
    {
        this.easingType = easingType;
    }

    public static EasingBuilder type(EasingType easingType)
    {
        return new EasingBuilder(easingType);
    }

    public EasingBuilder steps(int steps)
    {
        this.steps = steps;
        return this;
    }

    public EasingTypes build()
    {
        return new EasingTypes(this.easingType, this.steps);
    }
}