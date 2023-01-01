package andrews.pandoras_creatures.animation.system.wrap;

import andrews.pandoras_creatures.animation.model.AnimatedBlockEntityModel;
import andrews.pandoras_creatures.animation.model.AnimatedEntityModel;
import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.util.Mth;
import org.joml.Vector3f;

import java.util.List;
import java.util.Map;

public class AdvancedKeyframeAnimations extends KeyframeAnimations
{
    //TODO maybe get rid of all of this?

    public static void animate(AnimatedEntityModel<?> model, AnimationDefinition definition, long accumulatedTime, float scale, Vector3f animationVecCache)
    {
        // The elapsed time since the Animation started playing
        float elapsedSeconds = KeyframeAnimations.getElapsedSeconds(definition, accumulatedTime);
        // A Map of all the body parts and Lists containing their AnimationChanel's
        for(Map.Entry<String, List<AnimationChannel>> map : definition.boneAnimations().entrySet())
        {
            // A List of the present AnimationChannel's (POSITION-ROTATION-SCALE) of the current body part
            List<AnimationChannel> animationChannelList = map.getValue();
            // We check the model for a matching ModelPart, and if it
            // exists we continue, and run the code bellow
            model.getAnyDescendantWithName(map.getKey()).ifPresent((modelPart) -> {
                // We go through all the present AnimationChannel's (POSITION-ROTATION-SCALE)
                for(AnimationChannel animationChannel : animationChannelList)
                {
                    // An Array of all the Keyframes in the current AnimationChannel
                    Keyframe[] keyframes = animationChannel.keyframes();
                    // The current and next Keyframe index                                      //TODO replace binary search with something less :wth:
                    int currentKeyframeIdx = Math.max(0, Mth.binarySearch(0, keyframes.length, (index) -> elapsedSeconds <= keyframes[index].timestamp()) - 1);
                    int nextKeyframeIdx = Math.min(keyframes.length - 1, currentKeyframeIdx + 1);
                    // The current and next Keyframe
                    Keyframe currentKeyframe = keyframes[currentKeyframeIdx];
                    Keyframe nextKeyframe = keyframes[nextKeyframeIdx];

                    float elapsedDelta = elapsedSeconds - currentKeyframe.timestamp();
                    float keyframeDelta = Mth.clamp(elapsedDelta / (nextKeyframe.timestamp() - currentKeyframe.timestamp()), 0.0F, 1.0F);

                    nextKeyframe.interpolation().apply(animationVecCache, keyframeDelta, keyframes, currentKeyframeIdx, nextKeyframeIdx, scale);
                    // This applies the transformations to the current modelPart
                    // It gets the current target (position/rotation/scale) of the
                    // current animationChanel and applies the values
                    animationChannel.target().apply(modelPart, animationVecCache);
                }
            });
        }
    }

    public static void animate(AnimatedBlockEntityModel model, AnimationDefinition definition, long accumulatedTime, float scale, Vector3f animationVecCache)
    {
        // The elapsed time since the Animation started playing
        float elapsedSeconds = KeyframeAnimations.getElapsedSeconds(definition, accumulatedTime);
        // A Map of all the body parts and Lists containing their AnimationChanel's
        for(Map.Entry<String, List<AnimationChannel>> map : definition.boneAnimations().entrySet())
        {
            // A List of the present AnimationChannel's (POSITION-ROTATION-SCALE) of the current body part
            List<AnimationChannel> animationChannelList = map.getValue();
            // We check the model for a matching ModelPart, and if it
            // exists we continue, and run the code bellow
            model.getAnyDescendantWithName(map.getKey()).ifPresent((modelPart) -> {
                // We go through all the present AnimationChannel's (POSITION-ROTATION-SCALE)
                for(AnimationChannel animationChannel : animationChannelList)
                {
                    // An Array of all the Keyframes in the current AnimationChannel
                    Keyframe[] keyframes = animationChannel.keyframes();
                    // The current and next Keyframe index                                      //TODO replace binary search with something less :wth:
                    int currentKeyframeIdx = Math.max(0, Mth.binarySearch(0, keyframes.length, (index) -> elapsedSeconds <= keyframes[index].timestamp()) - 1);
                    int nextKeyframeIdx = Math.min(keyframes.length - 1, currentKeyframeIdx + 1);
                    // The current and next Keyframe
                    Keyframe currentKeyframe = keyframes[currentKeyframeIdx];
                    Keyframe nextKeyframe = keyframes[nextKeyframeIdx];

                    float elapsedDelta = elapsedSeconds - currentKeyframe.timestamp();
                    float keyframeDelta = Mth.clamp(elapsedDelta / (nextKeyframe.timestamp() - currentKeyframe.timestamp()), 0.0F, 1.0F);

                    nextKeyframe.interpolation().apply(animationVecCache, keyframeDelta, keyframes, currentKeyframeIdx, nextKeyframeIdx, scale);
                    // This applies the transformations to the current modelPart
                    // It gets the current target (position/rotation/scale) of the
                    // current animationChanel and applies the values
                    animationChannel.target().apply(modelPart, animationVecCache);
                }
            });
        }
    }
}