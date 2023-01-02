package andrews.pandoras_creatures.animation.system.custom;

import andrews.pandoras_creatures.animation.system.custom.types.TransformTypes;

public class KeyframeGroup
{
    private final TransformTypes transformType;
    private final AdvancedKeyframe[] keyframes;

    public KeyframeGroup(TransformTypes transformType, AdvancedKeyframe... keyframes)
    {
        this.transformType = transformType;
        this.keyframes = keyframes;
    }

    public TransformTypes getTransformType()
    {
        return this.transformType;
    }

    public AdvancedKeyframe[] getKeyframes() {
        return this.keyframes;
    }
}