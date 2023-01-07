package andrews.pandoras_creatures.animation.system.custom;

import andrews.pandoras_creatures.animation.model.AdvancedModelPart;
import andrews.pandoras_creatures.animation.model.AnimatedBlockEntityModel;
import andrews.pandoras_creatures.animation.system.custom.AdvancedKeyframe;
import andrews.pandoras_creatures.animation.system.custom.Animation;
import andrews.pandoras_creatures.animation.system.custom.KeyframeGroup;
import andrews.pandoras_creatures.animation.system.wrap.AdvancedAnimationState;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import org.joml.Vector3f;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class AnimationHandler
{
    public static void animate(AnimatedBlockEntityModel model, AdvancedAnimationState state, float scale, Vector3f animationVecCache)
    {
        Animation animation = state.getAnimation();
        float elapsedSeconds = getElapsedSeconds(animation, state.accumulatedTime);
        // We need to keep track of the size of the map, so we can perform logic on its last iteration
        int entries = animation.getKeyframeGroups().entrySet().size();
        for(Map.Entry<String, List<KeyframeGroup>> map : animation.getKeyframeGroups().entrySet())
        {
            entries--; // We reduce entries by 1 for every loop iteration
            List<KeyframeGroup> keyframeGroupList = map.getValue();
            Optional<ModelPart> modelPartOptional = model.getAnyDescendantWithName(map.getKey());
            if(modelPartOptional.isPresent() && modelPartOptional.get() instanceof AdvancedModelPart modelPart)
            {
                for(KeyframeGroup keyframeGroup : keyframeGroupList)
                {
                    AdvancedKeyframe[] keyframes = keyframeGroup.getKeyframes();
                    if(!state.cachedIndex.containsKey(keyframeGroup))
                        state.cachedIndex.put(keyframeGroup, 0);
                    // We turn the Idx back to 0 on a loop of the Animation
                    if(state.getAccumulatedTime() >= animation.getLengthInSeconds() * 1000.0F && animation.isLooping())
                    {
                        state.cachedIndex.put(keyframeGroup, 0);
                        if(entries <= 0)
                            state.accumulatedTime -= animation.getLengthInSeconds() * 1000.0F;
                    }
                    // If enough time passed we increase the current Idx and cache the last Vec
                    if(keyframes[state.cachedIndex.get(keyframeGroup)].timestamp() <= elapsedSeconds)
                    {
                        state.cachedLastVec.put(keyframeGroup, keyframes[state.cachedIndex.get(keyframeGroup)].target());
                        state.cachedIndex.put(keyframeGroup, Math.min(keyframes.length - 1, state.cachedIndex.get(keyframeGroup) + 1));
                    }

                    int currentKeyframeIdx = state.cachedIndex.get(keyframeGroup);
                    int lastKeyframeIdx = Math.max(0, currentKeyframeIdx - 1);
                    AdvancedKeyframe currentKeyframe = keyframes[currentKeyframeIdx];
                    AdvancedKeyframe lastKeyframe = keyframes[lastKeyframeIdx];

                    float elapsedDelta = elapsedSeconds - lastKeyframe.timestamp();
                    float keyframeDelta = Mth.clamp(elapsedDelta / (currentKeyframe.timestamp() - lastKeyframe.timestamp()), 0.0F, 1.0F);
                    currentKeyframe.getEasingType().storeEasedValues(animationVecCache, keyframeDelta, keyframes, state.cachedLastVec.get(keyframeGroup), currentKeyframeIdx, scale);
                    keyframeGroup.getTransformType().applyValues(modelPart, animationVecCache);
                }
            }
        }
    }

    public static float getElapsedSeconds(Animation animation, long accumulatedTime)
    {
        float accumulatedSeconds = (float)accumulatedTime / 1000.0F;
        return animation.isLooping() ? accumulatedSeconds % animation.getLengthInSeconds() : accumulatedSeconds;
    }
}