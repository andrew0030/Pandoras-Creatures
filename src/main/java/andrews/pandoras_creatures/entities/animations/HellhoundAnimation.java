package andrews.pandoras_creatures.entities.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class HellhoundAnimation
{
    public static final AnimationDefinition WALK_KEYFRAME = AnimationDefinition.Builder.withLength(1f).looping()
            .addAnimation("leftfrontlegtop",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.25f, KeyframeAnimations.degreeVec(-45f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.75f, KeyframeAnimations.degreeVec(45f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("rightfrontlegtop",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.25f, KeyframeAnimations.degreeVec(45f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.75f, KeyframeAnimations.degreeVec(-45f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR))).build();

    public static final AnimationDefinition ANGEL_KEYFRAME = AnimationDefinition.Builder.withLength(0.75f)//.looping()
            .addAnimation("leftfrontlegtop",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(45f, 0f, -60f),
                                    AnimationChannel.Interpolations.LINEAR),
//                            new Keyframe(0.25f, KeyframeAnimations.degreeVec(47.5f, 0f, -60f),
//                                    AnimationChannel.Interpolations.LINEAR),
//                            new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, -60f),
//                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.75f, KeyframeAnimations.degreeVec(-45f, 0f, -60f),
                                    AnimationChannel.Interpolations.LINEAR)))//,
//                            new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, -60f),
//                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("rightfrontlegtop",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(45f, 0f, 60f),
                                    AnimationChannel.Interpolations.LINEAR),
//                            new Keyframe(0.25f, KeyframeAnimations.degreeVec(47.5f, 0f, 60f),
//                                    AnimationChannel.Interpolations.LINEAR),
//                            new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 60f),
//                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.75f, KeyframeAnimations.degreeVec(-45f, 0f, 60f),
                                    AnimationChannel.Interpolations.LINEAR)//,
//                            new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 60f),
//                                    AnimationChannel.Interpolations.LINEAR)))
                    )).build();
}