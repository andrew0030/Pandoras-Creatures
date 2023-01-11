package andrews.pandoras_creatures.animation.system.core;

import andrews.pandoras_creatures.animation.model.AdvancedModelPart;
import andrews.pandoras_creatures.animation.model.AnimatedBlockEntityModel;
import andrews.pandoras_creatures.animation.model.AnimatedEntityModel;
import andrews.pandoras_creatures.animation.system.core.types.TransformTypes;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import org.joml.Vector3f;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class AnimationHandler
{
    public static void animate(AnimatedBlockEntityModel model, AdvancedAnimationState state, Vector3f animationVecCache)
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
            if(modelPartOptional.isPresent() && modelPartOptional.get() instanceof AdvancedModelPart modelPart)//TODO yeet this and use mixin to add a better performing check
            {
                for(KeyframeGroup keyframeGroup : keyframeGroupList)
                {
                    // We add the keyframeGroup to the caches if it hasn't been added
                    AnimationHandler.preventNullPointer(keyframeGroup, state);
                    BasicKeyframe[] keyframes = keyframeGroup.getKeyframes();
                    // We turn the Idx back to 0 on a loop of the Animation
                    if(state.getAccumulatedTime() >= animation.getLengthInSeconds() * 1000.0F && animation.isLooping())
                    {
                        state.cachedIndex.put(keyframeGroup, 0);
                        state.cachedLastVec.put(keyframeGroup, new Vector3f());
                        if(entries <= 0)
                            //On loop if there are multiple Transform Types we need to do this on last, otherwise later don't get to reset
                            if(isLastTransformType(keyframeGroup, keyframeGroupList))
                                state.accumulatedTime -= animation.getLengthInSeconds() * 1000.0F;
                    }
                    // If enough time passed we increase the current Idx and cache the last Vec
                    if(keyframes[state.cachedIndex.get(keyframeGroup)].timestamp() <= elapsedSeconds)//TODO maybe optimize this by preventing its execution after executing once on last iteration
                    {
                        state.cachedLastVec.put(keyframeGroup, keyframes[state.cachedIndex.get(keyframeGroup)].target());
                        state.cachedIndex.put(keyframeGroup, Math.min(keyframes.length - 1, state.cachedIndex.get(keyframeGroup) + 1));
                    }

                    int currentKeyframeIdx = state.cachedIndex.get(keyframeGroup);
                    int lastKeyframeIdx = Math.max(0, currentKeyframeIdx - 1);
                    BasicKeyframe currentKeyframe = keyframes[currentKeyframeIdx];
                    BasicKeyframe lastKeyframe = keyframes[lastKeyframeIdx];

                    float elapsedDelta = elapsedSeconds - lastKeyframe.timestamp();
                    float keyframeDelta = Mth.clamp(elapsedDelta / (currentKeyframe.timestamp() - lastKeyframe.timestamp()), 0.0F, 1.0F);

                    Vector3f lastValue = lastKeyframe.isBasic() ? state.cachedLastVec.get(keyframeGroup) : lastKeyframe.target(elapsedSeconds);

                    currentKeyframe.getEasingType().storeEasedValues(animationVecCache, keyframeDelta, keyframes, lastValue, currentKeyframeIdx, elapsedSeconds);
                    keyframeGroup.getTransformType().applyValues(modelPart, animationVecCache);
                }
            }
        }
    }

    private static void preventNullPointer(KeyframeGroup keyframeGroup, AdvancedAnimationState state)
    {
        if(!state.cachedIndex.containsKey(keyframeGroup))
            state.cachedIndex.put(keyframeGroup, 0);
        if(!state.cachedLastVec.containsKey(keyframeGroup))
            state.cachedLastVec.put(keyframeGroup, new Vector3f());
    }

    private static boolean isLastTransformType(KeyframeGroup keyframeGroup, List<KeyframeGroup> keyframeGroupList)
    {
        // If there is only a single Transform Type assigned, it's automatically the last.
        if(keyframeGroupList.size() == 1) return true;
        int maxPriority = keyframeGroupList.stream()
                .mapToInt(kg -> kg.getTransformType().getPriority())
                .max()
                .orElse(0);
        return keyframeGroup.getTransformType().getPriority() == maxPriority;
    }

    private static float getElapsedSeconds(Animation animation, long accumulatedTime)
    {
        float accumulatedSeconds = (float)accumulatedTime / 1000.0F;
        return animation.isLooping() ? accumulatedSeconds % animation.getLengthInSeconds() : accumulatedSeconds;
    }

    //TODO make 1 method for all models basically remove this
    public static void animate(AnimatedEntityModel<?> model, AdvancedAnimationState state, Vector3f animationVecCache)
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
            if(modelPartOptional.isPresent() && modelPartOptional.get() instanceof AdvancedModelPart modelPart)//TODO yeet this and use mixin to add a better performing check
            {
                for(KeyframeGroup keyframeGroup : keyframeGroupList)
                {
                    // We add the keyframeGroup to the caches if it hasn't been added
                    AnimationHandler.preventNullPointer(keyframeGroup, state);
                    BasicKeyframe[] keyframes = keyframeGroup.getKeyframes();
                    // We turn the Idx back to 0 on a loop of the Animation
                    if(state.getAccumulatedTime() >= animation.getLengthInSeconds() * 1000.0F && animation.isLooping())
                    {
                        state.cachedIndex.put(keyframeGroup, 0);
                        state.cachedLastVec.put(keyframeGroup, new Vector3f());
                        if(entries <= 0)
                            //On loop if there are multiple Transform Types we need to do this on last, otherwise later don't get to reset
                            if(isLastTransformType(keyframeGroup, keyframeGroupList))
                                state.accumulatedTime -= animation.getLengthInSeconds() * 1000.0F;
                    }
                    // If enough time passed we increase the current Idx and cache the last Vec
                    if(keyframes[state.cachedIndex.get(keyframeGroup)].timestamp() <= elapsedSeconds)//TODO maybe optimize this by preventing its execution after executing once on last iteration
                    {
                        state.cachedLastVec.put(keyframeGroup, keyframes[state.cachedIndex.get(keyframeGroup)].target());
                        state.cachedIndex.put(keyframeGroup, Math.min(keyframes.length - 1, state.cachedIndex.get(keyframeGroup) + 1));
                    }

                    int currentKeyframeIdx = state.cachedIndex.get(keyframeGroup);
                    int lastKeyframeIdx = Math.max(0, currentKeyframeIdx - 1);
                    BasicKeyframe currentKeyframe = keyframes[currentKeyframeIdx];
                    BasicKeyframe lastKeyframe = keyframes[lastKeyframeIdx];

                    float elapsedDelta = elapsedSeconds - lastKeyframe.timestamp();
                    float keyframeDelta = Mth.clamp(elapsedDelta / (currentKeyframe.timestamp() - lastKeyframe.timestamp()), 0.0F, 1.0F);

                    Vector3f lastValue = lastKeyframe.isBasic() ? state.cachedLastVec.get(keyframeGroup) : lastKeyframe.target(elapsedSeconds);

                    currentKeyframe.getEasingType().storeEasedValues(animationVecCache, keyframeDelta, keyframes, lastValue, currentKeyframeIdx, elapsedSeconds);
                    keyframeGroup.getTransformType().applyValues(modelPart, animationVecCache);
                }
            }
        }
    }
}