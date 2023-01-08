package andrews.pandoras_creatures.animation.system.core.types;

import andrews.pandoras_creatures.animation.system.core.BasicKeyframe;
import andrews.pandoras_creatures.animation.system.core.bulders.EasingBuilder;
import andrews.pandoras_creatures.animation.system.core.types.util.EasingType;
import net.minecraft.util.Mth;
import org.joml.Vector3f;

public class EasingTypes
{
    private final EasingType easingType;
    // Molang easing does nothing. Its simply a placeholder to prevent Null pointers
    public static final EasingTypes MOLANG = EasingBuilder.type(EasingType.MOLANG).build();
    // Easing Types
    public static final EasingTypes LINEAR = EasingBuilder.type(EasingType.LINEAR).build();
    public static final EasingTypes CATMULLROM = EasingBuilder.type(EasingType.CATMULLROM).build();
    public static final EasingTypes EASE_IN_SINE = EasingBuilder.type(EasingType.EASE_IN_SINE).build();
    // Optional values modified by the EasingBuilder if needed
    private final int steps;

    public void storeEasedValues(Vector3f animationVecCache, float keyframeDelta, BasicKeyframe[] keyframes, Vector3f cachedLastVec, int currentKeyframeIdx, float scale)
    {
        switch (easingType)
        {
            case MOLANG -> {}
            case LINEAR -> {
                Vector3f current = keyframes[currentKeyframeIdx].target();
                cachedLastVec.lerp(current, keyframeDelta, animationVecCache).mul(scale);
            }
            case CATMULLROM -> {
                Vector3f old = keyframes[Math.max(0, currentKeyframeIdx - 2)].target();
                // Last is retrieved from the cache
                Vector3f current = keyframes[currentKeyframeIdx].target();
                Vector3f future = keyframes[Math.min(keyframes.length - 1, currentKeyframeIdx + 1)].target();
                animationVecCache.set(
                        Mth.catmullrom(keyframeDelta, old.x(), cachedLastVec.x(), current.x(), future.x()) * scale,
                        Mth.catmullrom(keyframeDelta, old.y(), cachedLastVec.y(), current.y(), future.y()) * scale,
                        Mth.catmullrom(keyframeDelta, old.z(), cachedLastVec.z(), current.z(), future.z()) * scale);
            }
            case EASE_IN_SINE -> {
                Vector3f current = keyframes[currentKeyframeIdx].target();
                cachedLastVec.lerp(current, easeInSine(keyframeDelta), animationVecCache).mul(scale);
            }
        }
    }

    public EasingTypes(EasingType easingType, int steps)
    {
        this.easingType = easingType;
        this.steps = steps;
    }

    private float easeInSine(float value)
    {
        return 1 - Mth.cos((value * Mth.PI) / 2);
    }
}