package andrews.pandoras_creatures.animation.system.core.types;

import andrews.pandoras_creatures.animation.system.core.BasicKeyframe;
import andrews.pandoras_creatures.animation.system.core.bulders.EasingBuilder;
import andrews.pandoras_creatures.animation.system.core.types.util.EasingType;
import net.minecraft.util.Mth;
import org.joml.Vector3f;

public class EasingTypes
{
    private final EasingType easingType;
    // Easing Types
    public static final EasingTypes LINEAR = EasingBuilder.type(EasingType.LINEAR).build();
    public static final EasingTypes CATMULLROM = EasingBuilder.type(EasingType.CATMULLROM).build();
    public static final EasingTypes EASE_IN_SINE = EasingBuilder.type(EasingType.EASE_IN_SINE).build();
    // Optional values modified by the EasingBuilder if needed
    private final int steps;

    public void storeEasedValues(Vector3f animationVecCache, float keyframeDelta, BasicKeyframe[] keyframes, Vector3f cachedLastVec, int currentKeyframeIdx, float elapsedSeconds)
    {
        switch (easingType)
        {
            case LINEAR -> {
                Vector3f current = keyframes[currentKeyframeIdx].target(elapsedSeconds);
                cachedLastVec.lerp(current, keyframeDelta, animationVecCache);
            }
            case CATMULLROM -> {
                Vector3f old = keyframes[Math.max(0, currentKeyframeIdx - 2)].target(0.0F);//TODO deal with this
                // Last is retrieved from the cache
                Vector3f current = keyframes[currentKeyframeIdx].target(0.0F);
                Vector3f future = keyframes[Math.min(keyframes.length - 1, currentKeyframeIdx + 1)].target(0.0F);
                animationVecCache.set(
                        Mth.catmullrom(keyframeDelta, old.x(), cachedLastVec.x(), current.x(), future.x()),
                        Mth.catmullrom(keyframeDelta, old.y(), cachedLastVec.y(), current.y(), future.y()),
                        Mth.catmullrom(keyframeDelta, old.z(), cachedLastVec.z(), current.z(), future.z()));
            }
            case EASE_IN_SINE -> {
                Vector3f current = keyframes[currentKeyframeIdx].target(elapsedSeconds);
                cachedLastVec.lerp(current, easeInSine(keyframeDelta), animationVecCache);
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