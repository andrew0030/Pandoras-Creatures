package andrews.pandoras_creatures.block_entities.animations;

import andrews.pandoras_creatures.animation.system.core.*;
import andrews.pandoras_creatures.animation.system.core.bulders.AnimationBuilder;
import andrews.pandoras_creatures.animation.system.core.types.EasingTypes;
import andrews.pandoras_creatures.animation.system.core.types.TransformTypes;
import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class TestAnimationAnimations
{
    public static final AnimationDefinition TEST_ANIMATION = AnimationDefinition.Builder.withLength(2f).looping()
            .addAnimation("arm_bottom",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(1f, KeyframeAnimations.degreeVec(-15f, 0f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("arm_top",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(1f, KeyframeAnimations.degreeVec(30f, 0f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("top",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(1f, KeyframeAnimations.degreeVec(0f, -42.5f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM))).build();

//    public static final Animation MY_ANIMATION = Animation.Builder.withLength(3f).looping()
//            .addAnimation("arm_bottom", new KeyframeGroup(TransformTypes.ROTATION,
//                    new BasicKeyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), EasingTypes.LINEAR),
//                    new BasicKeyframe(1f, KeyframeAnimations.degreeVec(-30f, 0f, 0f), EasingTypes.LINEAR),
//                    new BasicKeyframe(2f, KeyframeAnimations.degreeVec(30f, 0f, 0f), EasingTypes.LINEAR),
//                    new BasicKeyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, 0f), EasingTypes.LINEAR)))
//            .addAnimation("arm_top", new KeyframeGroup(TransformTypes.ROTATION,
//                    new BasicKeyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), EasingTypes.LINEAR),
//                    new BasicKeyframe(1f, KeyframeAnimations.degreeVec(60f, 0f, 0f), EasingTypes.LINEAR),
//                    new BasicKeyframe(2f, KeyframeAnimations.degreeVec(-60f, 0f, 0f), EasingTypes.LINEAR),
//                    new BasicKeyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, 0f), EasingTypes.LINEAR)))
//            .addAnimation("top", new KeyframeGroup(TransformTypes.ROTATION,
//                    new BasicKeyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), EasingTypes.LINEAR),
//                    new BasicKeyframe(1f, KeyframeAnimations.degreeVec(0f, -80f, 0f), EasingTypes.LINEAR),
//                    new BasicKeyframe(2.5f, KeyframeAnimations.degreeVec(0f, 80f, 0f), EasingTypes.LINEAR),
//                    new BasicKeyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, 0f), EasingTypes.LINEAR))).build();

    public static final Animation MY_ANIMATION = AnimationBuilder.withLength(3f).looping()
            .addAnimation("arm_bottom", new KeyframeGroup(TransformTypes.ROTATION,
                    new BasicKeyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), EasingTypes.LINEAR),
                    new BasicKeyframe(1f, KeyframeAnimations.degreeVec(-30f, 0f, 0f), EasingTypes.LINEAR),
                    new BasicKeyframe(2f, KeyframeAnimations.degreeVec(30f, 0f, 0f), EasingTypes.LINEAR),
                    new BasicKeyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, 0f), EasingTypes.LINEAR)))
            .addAnimation("arm_top", new KeyframeGroup(TransformTypes.ROTATION,
                    new BasicKeyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), EasingTypes.LINEAR),
                    new BasicKeyframe(1f, KeyframeAnimations.degreeVec(60f, 0f, 0f), EasingTypes.LINEAR),
                    new BasicKeyframe(2f, KeyframeAnimations.degreeVec(-60f, 0f, 0f), EasingTypes.LINEAR),
                    new BasicKeyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, 0f), EasingTypes.LINEAR)))
            .addAnimation("top", new KeyframeGroup(TransformTypes.ROTATION,
                    new BasicKeyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), EasingTypes.LINEAR),
                    new BasicKeyframe(1f, KeyframeAnimations.degreeVec(0f, -80f, 0f), EasingTypes.LINEAR),
                    new BasicKeyframe(2.5f, KeyframeAnimations.degreeVec(0f, 80f, 0f), EasingTypes.LINEAR),
                    new BasicKeyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, 0f), EasingTypes.LINEAR))).build();

    public static final Animation MY_ALT_ANIMATION = AnimationBuilder.withLength(3f).looping()
            .addAnimation("arm_bottom", new KeyframeGroup(TransformTypes.ROTATION,
                    new MolangKeyframe(1.96f, "3*8"),
                    new BasicKeyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f), EasingTypes.LINEAR)))
            .addAnimation("arm_top", new KeyframeGroup(TransformTypes.ROTATION,
                    new BasicKeyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), EasingTypes.LINEAR),
                    new BasicKeyframe(1f, KeyframeAnimations.degreeVec(0f, 20f, 0f), EasingTypes.LINEAR),
                    new BasicKeyframe(2f, KeyframeAnimations.degreeVec(0f, -30f, 0f), EasingTypes.LINEAR),
                    new BasicKeyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, 0f), EasingTypes.LINEAR)))
            .addAnimation("top", new KeyframeGroup(TransformTypes.ROTATION,
                    new BasicKeyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), EasingTypes.LINEAR),
                    new BasicKeyframe(1f, KeyframeAnimations.degreeVec(0f, -50f, 0f), EasingTypes.LINEAR),
                    new BasicKeyframe(2.5f, KeyframeAnimations.degreeVec(0f, 30f, 0f), EasingTypes.LINEAR),
                    new BasicKeyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, 0f), EasingTypes.LINEAR))).build();
}