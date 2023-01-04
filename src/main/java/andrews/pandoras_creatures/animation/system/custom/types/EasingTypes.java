package andrews.pandoras_creatures.animation.system.custom.types;

import andrews.pandoras_creatures.animation.system.custom.AdvancedKeyframe;
import andrews.pandoras_creatures.animation.system.custom.types.builder.EasingBuilder;
import andrews.pandoras_creatures.animation.system.custom.types.builder.EasingType;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Mth;
import org.joml.Vector3f;

import java.util.Optional;

public class EasingTypes
{
    private final EasingType easingType;
    // Easing Types
    public static final EasingTypes LINEAR = EasingBuilder.type(EasingType.LINEAR).build();
    public static final EasingTypes CATMULLROM = EasingBuilder.type(EasingType.CATMULLROM).build();
    public static final EasingTypes EASE_IN_SINE = EasingBuilder.type(EasingType.EASE_IN_SINE).build();
    // Optional values modified by the EasingBuilder if needed
    private final int steps;

    public void storeEasedValues(Vector3f animationVecCache, float keyframeDelta, AdvancedKeyframe[] keyframes, Vector3f last, int currentKeyframeIdx, float scale)
    {
        switch (easingType)
        {
            case LINEAR -> {
//                Vector3f last = keyframes[last].target();
                Vector3f current = keyframes[currentKeyframeIdx].target();
                if(last!=null)
                last.lerp(current, keyframeDelta, animationVecCache).mul(scale);
            }
            case CATMULLROM -> {
//                Vector3f old = keyframes[Math.max(0, currentKeyframeIdx - 1)].target();
//                Vector3f current = keyframes[currentKeyframeIdx].target();
//                Vector3f next = keyframes[nextKeyframeIdx].target();
//                Vector3f future = keyframes[Math.min(keyframes.length - 1, nextKeyframeIdx + 1)].target();
//                animationVecCache.set(Mth.catmullrom(keyframeDelta, old.x(), current.x(), next.x(), future.x()) * scale,
//                        Mth.catmullrom(keyframeDelta, old.y(), current.y(), next.y(), future.y()) * scale,
//                        Mth.catmullrom(keyframeDelta, old.z(), current.z(), next.z(), future.z()) * scale);
            }
            case EASE_IN_SINE -> {
//                Vector3f current = keyframes[currentKeyframeIdx].target();
//                Vector3f next = keyframes[nextKeyframeIdx].target();
//                current.lerp(next, easeInSine(keyframeDelta), animationVecCache).mul(scale);
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