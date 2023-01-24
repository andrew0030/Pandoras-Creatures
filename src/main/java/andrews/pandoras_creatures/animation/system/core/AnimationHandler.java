package andrews.pandoras_creatures.animation.system.core;

import andrews.pandoras_creatures.animation.model.AdvancedModelPart;
import andrews.pandoras_creatures.animation.model.IAnimatedModel;
import andrews.pandoras_creatures.animation.system.core.types.util.EasingMath;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import org.joml.Vector3f;

import java.util.*;

public class AnimationHandler
{
    public static void animate(IAnimatedModel model, AdvancedAnimationState state, Vector3f animationVecCache)
    {
        Animation animation = state.getAnimation();
        float elapsedSeconds = AnimationHandler.getElapsedSeconds(state);
        if(state.getOutTime() != 0)
            elapsedSeconds = state.getPrevElapsedTime();

        // We need to keep track of the size of the map, so we can perform logic on its last iteration
        int entries = animation.getKeyframeGroups().entrySet().size();
        for(Map.Entry<String, List<KeyframeGroup>> map : animation.getKeyframeGroups().entrySet())
        {
            entries--;
            List<KeyframeGroup> keyframeGroupList = map.getValue();
            Optional<ModelPart> modelPartOptional = model.getAnyDescendantWithName(map.getKey());
            if(modelPartOptional.isPresent() && modelPartOptional.get() instanceof AdvancedModelPart modelPart)//TODO yeet this and use mixin to add a better performing check
            {
                for(KeyframeGroup keyframeGroup : keyframeGroupList)
                {
                    BasicKeyframe[] keyframes = keyframeGroup.getKeyframes();

                    if(state.getOutTime() == 0)
                        AnimationHandler.processIdxCache(state, keyframeGroupList, keyframeGroup, keyframes, entries, elapsedSeconds);

                    int currentKeyframeIdx = state.cachedIndex.get(keyframeGroup);
                    int lastKeyframeIdx = Math.max(0, currentKeyframeIdx - 1);

                    BasicKeyframe currentKeyframe = keyframes[currentKeyframeIdx];
                    BasicKeyframe lastKeyframe = keyframes[lastKeyframeIdx];
                    float timeStampMod = state.getInTime(); // We need this to shift timestamps
                    float elapsedDelta = elapsedSeconds - (lastKeyframe.timestamp() + timeStampMod);
                    float keyframeDelta = Mth.clamp(elapsedDelta / ((currentKeyframe.timestamp() + timeStampMod) - (lastKeyframe.timestamp() + timeStampMod)), 0.0F, 1.0F);

                    currentKeyframe.getEasingType().storeEasedValues(animationVecCache, keyframeDelta, keyframes, lastKeyframe.target(state.getInTime()), currentKeyframeIdx, elapsedSeconds);

                    float interpolFactor = 1.0F;
                    if(state.getInTime() != 0) {
                        float time = state.getInTime();
                        interpolFactor = time != 0 ? 1 - (1 - Math.min(time, elapsedSeconds) / time) : 1.0F;
                    }
                    if(state.getOutTime() != 0) {
                        float time = state.getOutTime();
                        interpolFactor *= 1 - (1 - (1 - Math.min(time, AnimationHandler.getElapsedSeconds(state) - elapsedSeconds) / time));
                    }

                    keyframeGroup.getTransformType().applyValues(modelPart, animationVecCache.mul(interpolFactor));

                    // Handles stopping animations after easing out is finished
                    if(state.getOutTime() != 0)
                        if(interpolFactor == 0)
                            if(entries <= 0)
                                if(isLastTransformType(keyframeGroup, keyframeGroupList))
                                    state.stop();
                }
            }
        }
    }

    public static float getElapsedSeconds(AdvancedAnimationState state)
    {
        float accumulatedSeconds = (float)state.getAccumulatedTime() / 1000.0F;
        float animLength = state.getAnimation().getLengthInSeconds() + state.getInTime() + state.getOutTime();
        return state.getAnimation().isLooping() ? accumulatedSeconds % animLength : accumulatedSeconds;
    }

    private static void processIdxCache(AdvancedAnimationState state, List<KeyframeGroup> keyframeGroupList, KeyframeGroup keyframeGroup, BasicKeyframe[] keyframes, int entries, float elapsedSeconds)
    {
//        float elapsedSeconds = AnimationHandler.getElapsedSeconds(state);
        Animation animation = state.getAnimation();
        float animLength = animation.getLengthInSeconds() + state.getInTime() + state.getOutTime(); // We need this shift animation length

        if(!state.cachedIndex.containsKey(keyframeGroup))
            state.cachedIndex.put(keyframeGroup, 0);
        if(state.getAccumulatedTime() >= animLength * 1000.0F && animation.isLooping())
        {
            state.cachedIndex.put(keyframeGroup, 0);
            if(entries <= 0)
                //On loop if there are multiple Transform Types we need to do this on last, otherwise later don't get to reset
                if(isLastTransformType(keyframeGroup, keyframeGroupList))
                    state.accumulatedTime -= animLength * 1000.0F;
        }
        // If enough time passed we increase the current Idx and cache the last Vec
        float timeStampMod = state.getInTime(); // We need this shift timestamps
        if(keyframes[state.cachedIndex.get(keyframeGroup)].timestamp() + timeStampMod <= elapsedSeconds)//TODO maybe optimize this by preventing its execution after executing once on last iteration
            state.cachedIndex.put(keyframeGroup, Math.min(keyframes.length - 1, state.cachedIndex.get(keyframeGroup) + 1));
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
}