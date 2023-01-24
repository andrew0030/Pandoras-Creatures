package andrews.pandoras_creatures.animation.system.core;

import andrews.pandoras_creatures.animation.system.core.types.TransformTypes;

public class KeyframeGroup
{
    private final TransformTypes transformType;
    private final BasicKeyframe[] keyframes;

    public KeyframeGroup(TransformTypes transformType, BasicKeyframe... keyframes)
    {
        this.transformType = transformType;
        this.keyframes = keyframes;
    }

    public TransformTypes getTransformType()
    {
        return this.transformType;
    }

    public BasicKeyframe[] getKeyframes()
    {
        return this.keyframes;
    }
}