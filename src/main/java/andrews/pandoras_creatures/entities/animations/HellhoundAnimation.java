package andrews.pandoras_creatures.entities.animations;

import andrews.pandoras_creatures.animation.system.core.Animation;
import andrews.pandoras_creatures.animation.system.core.KeyframeGroup;
import andrews.pandoras_creatures.animation.system.core.MolangKeyframe;
import andrews.pandoras_creatures.animation.system.core.bulders.AnimationBuilder;
import andrews.pandoras_creatures.animation.system.core.types.EasingTypes;
import andrews.pandoras_creatures.animation.system.core.types.TransformTypes;

public class HellhoundAnimation
{
    public static final Animation HELLHOUND_ANGEL = AnimationBuilder.withLength(0F)
            .addAnimation("leftbacklegtop", new KeyframeGroup(TransformTypes.ROTATION,
                    new MolangKeyframe(0F, 'r', "dsin(anim_time * 300) * 50", "0", "-60", EasingTypes.LINEAR)))
            .addAnimation("leftbacklegmid", new KeyframeGroup(TransformTypes.ROTATION,
                    new MolangKeyframe(0F, 'r', "dsin(anim_time * 300 + 100) * 30", "0", "0", EasingTypes.LINEAR)))
            .addAnimation("rightbacklegtop", new KeyframeGroup(TransformTypes.ROTATION,
                    new MolangKeyframe(0F, 'r', "dsin(anim_time * 300) * 50", "0", "60", EasingTypes.LINEAR)))
            .addAnimation("rightbacklegmid", new KeyframeGroup(TransformTypes.ROTATION,
                    new MolangKeyframe(0F, 'r', "dsin(anim_time * 300 + 100) * 30", "0", "0", EasingTypes.LINEAR)))
            .addAnimation("leftfrontlegtop", new KeyframeGroup(TransformTypes.ROTATION,
                    new MolangKeyframe(0F, 'r', "dsin(anim_time * 300) * -50", "0", "-60", EasingTypes.LINEAR)))
            .addAnimation("rightfrontlegtop", new KeyframeGroup(TransformTypes.ROTATION,
                    new MolangKeyframe(0F, 'r', "dsin(anim_time * 300) * -50", "0", "60", EasingTypes.LINEAR))).build();

    public static final Animation HELLHOUND_WALK = AnimationBuilder.withLength(0F)
            .addAnimation("leftfrontlegtop", new KeyframeGroup(TransformTypes.POSITION,
                    new MolangKeyframe(0F, 'p', "0", "dsin(anim_time * 250 - 10) * 0.7", "0", EasingTypes.LINEAR)))
            .addAnimation("leftfrontlegtop", new KeyframeGroup(TransformTypes.ROTATION,
                    new MolangKeyframe(0F, 'r', "dsin(anim_time * 250) * 16", "0", "0", EasingTypes.LINEAR)))
            .addAnimation("leftfrontlegmid", new KeyframeGroup(TransformTypes.POSITION,
                    new MolangKeyframe(0F, 'p', "0", "dsin(anim_time * 250 - 80) + 1", "0", EasingTypes.LINEAR)))
            .addAnimation("leftfrontlegmid", new KeyframeGroup(TransformTypes.ROTATION,
                    new MolangKeyframe(0F, 'r', "dsin(anim_time * 250 + 50) * 10", "0", "0", EasingTypes.LINEAR)))
            .addAnimation("leftfrontlegpaw", new KeyframeGroup(TransformTypes.ROTATION,
                    new MolangKeyframe(0F, 'r', "dsin(anim_time * 250) * 12", "0", "0", EasingTypes.LINEAR)))
            .addAnimation("rightfrontlegtop", new KeyframeGroup(TransformTypes.POSITION,
                    new MolangKeyframe(0F, 'p', "0", "-dsin(anim_time * 250 - 10) * 0.7", "0", EasingTypes.LINEAR)))
            .addAnimation("rightfrontlegtop", new KeyframeGroup(TransformTypes.ROTATION,
                    new MolangKeyframe(0F, 'r', "-dsin(anim_time * 250) * 16", "0", "0", EasingTypes.LINEAR)))
            .addAnimation("rightfrontlegmid", new KeyframeGroup(TransformTypes.POSITION,
                    new MolangKeyframe(0F, 'p', "0", "-dsin(anim_time * 250 - 80) + 1", "0", EasingTypes.LINEAR)))
            .addAnimation("rightfrontlegmid", new KeyframeGroup(TransformTypes.ROTATION,
                    new MolangKeyframe(0F, 'r', "-dsin(anim_time * 250 + 50) * 10", "0", "0", EasingTypes.LINEAR)))
            .addAnimation("rightfrontlegpaw", new KeyframeGroup(TransformTypes.ROTATION,
                    new MolangKeyframe(0F, 'r', "-dsin(anim_time * 250) * 12", "0", "0", EasingTypes.LINEAR)))
            .addAnimation("body", new KeyframeGroup(TransformTypes.POSITION,
                    new MolangKeyframe(0F, 'p', "0", "dsin(anim_time * 500 + 30) * 0.8 + 0.4", "0", EasingTypes.LINEAR)))
            .addAnimation("body", new KeyframeGroup(TransformTypes.ROTATION,
                    new MolangKeyframe(0F, 'r', "dsin(anim_time * 500) * 0.8 + 2", "0", "0", EasingTypes.LINEAR)))
            .addAnimation("neck", new KeyframeGroup(TransformTypes.ROTATION,
                    new MolangKeyframe(0F, 'r', "dsin(anim_time * 500 + 50) * 1.5", "0", "0", EasingTypes.LINEAR)))
            .addAnimation("head", new KeyframeGroup(TransformTypes.ROTATION,
                    new MolangKeyframe(0F, 'r', "dsin(anim_time * 500 + 180) * 2", "0", "0", EasingTypes.LINEAR)))
            .addAnimation("tail1", new KeyframeGroup(TransformTypes.ROTATION,
                    new MolangKeyframe(0F, 'r', "-dsin(anim_time * 500 - 50) * 3", "0", "0", EasingTypes.LINEAR)))
            .addAnimation("tail2", new KeyframeGroup(TransformTypes.ROTATION,
                    new MolangKeyframe(0F, 'r', "-dsin(anim_time * 500 - 100) * 6", "0", "0", EasingTypes.LINEAR)))
            .addAnimation("leftbacklegtop", new KeyframeGroup(TransformTypes.ROTATION,
                    new MolangKeyframe(0F, 'r', "-dsin(anim_time * 250) * 16", "0", "0", EasingTypes.LINEAR)))
            .addAnimation("leftbacklegmid", new KeyframeGroup(TransformTypes.POSITION,
                    new MolangKeyframe(0F, 'p', "0", "-dsin(anim_time * 250 - 80) * 0.9", "0", EasingTypes.LINEAR)))
            .addAnimation("leftbacklegmid", new KeyframeGroup(TransformTypes.ROTATION,
                    new MolangKeyframe(0F, 'r', "-dsin(anim_time * 250) * 10 + 10", "0", "0", EasingTypes.LINEAR)))
            .addAnimation("leftbacklegpaw", new KeyframeGroup(TransformTypes.ROTATION,
                    new MolangKeyframe(0F, 'r', "-dsin(anim_time * 250) * 12 - 4", "0", "0", EasingTypes.LINEAR)))
            .addAnimation("rightbacklegtop", new KeyframeGroup(TransformTypes.ROTATION,
                    new MolangKeyframe(0F, 'r', "dsin(anim_time * 250) * 16", "0", "0", EasingTypes.LINEAR)))
            .addAnimation("rightbacklegmid", new KeyframeGroup(TransformTypes.POSITION,
                    new MolangKeyframe(0F, 'p', "0", "dsin(anim_time * 250 - 80) * 0.9", "0", EasingTypes.LINEAR)))
            .addAnimation("rightbacklegmid", new KeyframeGroup(TransformTypes.ROTATION,
                    new MolangKeyframe(0F, 'r', "dsin(anim_time * 250) * 10 + 10", "0", "0", EasingTypes.LINEAR)))
            .addAnimation("rightbacklegpaw", new KeyframeGroup(TransformTypes.ROTATION,
                    new MolangKeyframe(0F, 'r', "dsin(anim_time * 250) * 12 - 4", "0", "0", EasingTypes.LINEAR)))
            .addAnimation("jaw", new KeyframeGroup(TransformTypes.ROTATION,
                    new MolangKeyframe(0F, 'r', "dsin(anim_time * 500 + 180) * 1.2 + 3", "0", "0", EasingTypes.LINEAR))).build();
}