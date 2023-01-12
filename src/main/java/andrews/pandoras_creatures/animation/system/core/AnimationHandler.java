package andrews.pandoras_creatures.animation.system.core;

import andrews.pandoras_creatures.animation.model.AdvancedModelPart;
import andrews.pandoras_creatures.animation.model.IAnimatedModel;
import andrews.pandoras_creatures.animation.system.core.types.EasingTypes;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import org.joml.Vector3f;

import java.util.*;

public class AnimationHandler
{
    public static void animate(IAnimatedModel model, AdvancedAnimationState state, Vector3f animationVecCache)
    {
        Animation animation = state.getAnimation();
        float elapsedSeconds = getElapsedSeconds(state);
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
                    //TODO clean this up and add support for external frame retrieval also move to method
                    BasicKeyframe[] keyframes = getKeyframeArray(state, keyframeGroup, elapsedSeconds);
                    // We turn the Idx back to 0 on a loop of the Animation
                    if(state.getAccumulatedTime() >= (animation.getLengthInSeconds() + state.getInterpolTime()) * 1000.0F && animation.isLooping())
                    {
                        state.cachedIndex.put(keyframeGroup, 0);
                        state.cachedLastVec.put(keyframeGroup, new Vector3f());
                        if(entries <= 0)
                            //On loop if there are multiple Transform Types we need to do this on last, otherwise later don't get to reset
                            if(isLastTransformType(keyframeGroup, keyframeGroupList))
                            {
                                state.accumulatedTime -= (animation.getLengthInSeconds() + state.getInterpolTime()) * 1000.0F;
                                state.resetInterpolTime();
                            }
                    }
                    // If enough time passed we increase the current Idx and cache the last Vec
                    if(keyframes[state.cachedIndex.get(keyframeGroup)].timestamp() + state.getInterpolTime() <= elapsedSeconds)//TODO maybe optimize this by preventing its execution after executing once on last iteration
                    {
                        state.cachedLastVec.put(keyframeGroup, keyframes[state.cachedIndex.get(keyframeGroup)].target());
                        state.cachedIndex.put(keyframeGroup, Math.min(keyframes.length - 1, state.cachedIndex.get(keyframeGroup) + 1));
                    }

                    int currentKeyframeIdx = state.cachedIndex.get(keyframeGroup);
                    int lastKeyframeIdx = Math.max(0, currentKeyframeIdx - 1);
                    BasicKeyframe currentKeyframe = keyframes[currentKeyframeIdx];
                    BasicKeyframe lastKeyframe = keyframes[lastKeyframeIdx];

                    float elapsedDelta = elapsedSeconds - (lastKeyframe.timestamp() + state.getInterpolTime());
                    float keyframeDelta = Mth.clamp(elapsedDelta / ((currentKeyframe.timestamp() + state.getInterpolTime()) - (lastKeyframe.timestamp() + state.getInterpolTime())), 0.0F, 1.0F);

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

    private static BasicKeyframe[] getKeyframeArray(AdvancedAnimationState state, KeyframeGroup keyframeGroup, float elapsedSeconds)
    {
        BasicKeyframe[] keyframes = keyframeGroup.getKeyframes();
        if(state.getInterpolTime() != 0)
        {
            // Test that just handles no animation -> animation
            List<BasicKeyframe> keyframeList = new ArrayList<>(Arrays.asList(keyframes));
            keyframeList.add(0, new BasicKeyframe(-state.getInterpolTime(), new Vector3f(0, 0, 0), EasingTypes.LINEAR));
            if(keyframes[0] instanceof MolangKeyframe molang)
                keyframeList.add(1, new BasicKeyframe(-0.01F, molang.target(elapsedSeconds), EasingTypes.LINEAR));
            keyframes = keyframeList.toArray(new BasicKeyframe[0]);
        }
        // If there isn't any interpolation time we just return the Array
        return keyframes;
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

    public static float getElapsedSeconds(AdvancedAnimationState state)
    {
        float accumulatedSeconds = (float)state.accumulatedTime / 1000.0F;
        return state.getAnimation().isLooping() ? accumulatedSeconds % (state.getAnimation().getLengthInSeconds() + state.getInterpolTime()) : accumulatedSeconds;
    }
}