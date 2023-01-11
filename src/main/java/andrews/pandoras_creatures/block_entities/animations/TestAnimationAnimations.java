package andrews.pandoras_creatures.block_entities.animations;

import andrews.pandoras_creatures.animation.system.core.Animation;
import andrews.pandoras_creatures.animation.system.core.BasicKeyframe;
import andrews.pandoras_creatures.animation.system.core.KeyframeGroup;
import andrews.pandoras_creatures.animation.system.core.MolangKeyframe;
import andrews.pandoras_creatures.animation.system.core.bulders.AnimationBuilder;
import andrews.pandoras_creatures.animation.system.core.bulders.EasingBuilder;
import andrews.pandoras_creatures.animation.system.core.types.EasingTypes;
import andrews.pandoras_creatures.animation.system.core.types.TransformTypes;
import andrews.pandoras_creatures.animation.system.core.types.util.EasingType;
import net.minecraft.client.animation.KeyframeAnimations;

public class TestAnimationAnimations
{
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
                    new BasicKeyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), EasingBuilder.type(EasingType.STEPS).argument(2).build()),
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

    public static final Animation MY_ALT_ANIMATION = AnimationBuilder.withLength(3F).looping()
            .addAnimation("arm_bottom", new KeyframeGroup(TransformTypes.ROTATION,
                    new BasicKeyframe(1F, KeyframeAnimations.degreeVec(0F, 0F, 0F), EasingTypes.LINEAR),
                    new MolangKeyframe(0.32F, 'r', "dcos(anim_time * 400) * 15", "0", "0", EasingTypes.LINEAR),
                    new BasicKeyframe(2F, KeyframeAnimations.degreeVec(0F, 0F, 0F), EasingTypes.LINEAR)))
            .addAnimation("arm_top", new KeyframeGroup(TransformTypes.ROTATION,
                    new BasicKeyframe(0F, KeyframeAnimations.degreeVec(0F, 0F, 0F), EasingTypes.LINEAR),
                    new BasicKeyframe(1F, KeyframeAnimations.degreeVec(0F, 20F, 0F), EasingTypes.LINEAR),
                    new BasicKeyframe(2F, KeyframeAnimations.degreeVec(0F, -30F, 0F), EasingTypes.LINEAR),
                    new BasicKeyframe(3F, KeyframeAnimations.degreeVec(0F, 0F, 0F), EasingTypes.LINEAR)))
            .addAnimation("top", new KeyframeGroup(TransformTypes.POSITION,
                    new BasicKeyframe(0.52F, KeyframeAnimations.posVec(0F, 0F, 0F), EasingTypes.LINEAR),
                    new BasicKeyframe(1F, KeyframeAnimations.posVec(15F, 0F, 0F), EasingTypes.LINEAR),
                    new BasicKeyframe(1.52F, KeyframeAnimations.posVec(0F, 0F, 0F), EasingTypes.LINEAR)))
            .addAnimation("top", new KeyframeGroup(TransformTypes.ROTATION,
                    new BasicKeyframe(0F, KeyframeAnimations.degreeVec(0F, 0F, 0F), EasingTypes.LINEAR),
                    new BasicKeyframe(1F, KeyframeAnimations.degreeVec(0F, -50F, 0F), EasingTypes.LINEAR),
                    new BasicKeyframe(2F, KeyframeAnimations.degreeVec(0F, 30F, 0F), EasingTypes.LINEAR),
                    new BasicKeyframe(3F, KeyframeAnimations.degreeVec(0F, 0F, 0F), EasingTypes.LINEAR)))
            .addAnimation("top", new KeyframeGroup(TransformTypes.SCALE,
                    new BasicKeyframe(0F, KeyframeAnimations.scaleVec(1F, 1F, 1F), EasingTypes.LINEAR),
                    new MolangKeyframe(1.52F, 's', "2", "2", "2", EasingTypes.LINEAR),
                    new BasicKeyframe(3F, KeyframeAnimations.scaleVec(1F, 1F, 1F), EasingTypes.LINEAR)))
            .addAnimation("base", new KeyframeGroup(TransformTypes.POSITION,
                    new BasicKeyframe(0F, KeyframeAnimations.posVec(0F, 0F, 0F), EasingTypes.LINEAR),
                    new MolangKeyframe(2.28F, 'p', "dsin(anim_time * 400) * 2", "2", "2", EasingTypes.LINEAR),
                    new BasicKeyframe(3F, KeyframeAnimations.posVec(0F, 0F, 0F), EasingTypes.LINEAR)))
            .addAnimation("base", new KeyframeGroup(TransformTypes.ROTATION,
                    new BasicKeyframe(1F, KeyframeAnimations.degreeVec(0F, 0F, 0F), EasingTypes.LINEAR),
                    new BasicKeyframe(1.52F, KeyframeAnimations.degreeVec(45F, 0F, 4F), EasingTypes.LINEAR),
                    new BasicKeyframe(2F, KeyframeAnimations.degreeVec(10F, 0F, 0F), EasingTypes.LINEAR)))
            .addAnimation("plate", new KeyframeGroup(TransformTypes.POSITION,
                    new BasicKeyframe(0F, KeyframeAnimations.posVec(0F, 0F, 0F), EasingTypes.LINEAR),
                    new BasicKeyframe(1.56F, KeyframeAnimations.posVec(0F, 4F, 0F), EasingTypes.LINEAR),
                    new BasicKeyframe(3F, KeyframeAnimations.posVec(0F, 0F, 0F), EasingTypes.LINEAR))).build();
}