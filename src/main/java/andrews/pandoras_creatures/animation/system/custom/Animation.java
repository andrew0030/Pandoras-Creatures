package andrews.pandoras_creatures.animation.system.custom;

import com.google.common.collect.Maps;
import org.apache.commons.compress.utils.Lists;

import java.util.List;
import java.util.Map;

public class Animation
{
    private final float lengthInSeconds;
    private final boolean looping;
    private final Map<String, List<KeyframeGroup>> keyframeGroups;

    public Animation(float lengthInSeconds, boolean looping, Map<String, List<KeyframeGroup>> keyframeGroups)
    {
        this.lengthInSeconds = lengthInSeconds;
        this.looping = looping;
        this.keyframeGroups = keyframeGroups;
    }

    public float getLengthInSeconds()
    {
        return this.lengthInSeconds;
    }

    public boolean isLooping()
    {
        return this.looping;
    }

    public Map<String, List<KeyframeGroup>> getKeyframeGroups()
    {
        return this.keyframeGroups;
    }

    public static class Builder
    {
        private final float lengthInSeconds;
        private boolean looping;
        private final Map<String, List<KeyframeGroup>> keyframeGroups = Maps.newHashMap();

        private Builder(float lengthInSeconds)
        {
            this.lengthInSeconds = lengthInSeconds;
        }

        public static Animation.Builder withLength(float lengthInSeconds)
        {
            return new Animation.Builder(lengthInSeconds);
        }

        public Animation.Builder looping()
        {
            this.looping = true;
            return this;
        }

        public Animation.Builder addAnimation(String boneName, KeyframeGroup keyframeGroup)
        {
            this.keyframeGroups.computeIfAbsent(boneName, (name) -> Lists.newArrayList()).add(keyframeGroup);
            return this;
        }

        public Animation build()
        {
            return new Animation(this.lengthInSeconds, this.looping, this.keyframeGroups);
        }
    }
}