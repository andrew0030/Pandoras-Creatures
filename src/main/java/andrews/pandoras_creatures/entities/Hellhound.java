package andrews.pandoras_creatures.entities;

import andrews.pandoras_creatures.animation.system.core.AdvancedAnimationState;
import andrews.pandoras_creatures.animation.system.core.AnimationHandler;
import andrews.pandoras_creatures.animation.system.core.bulders.EasingBuilder;
import andrews.pandoras_creatures.animation.system.core.types.EasingTypes;
import andrews.pandoras_creatures.animation.system.core.types.util.EasingType;
import andrews.pandoras_creatures.block_entities.animations.TestAnimationAnimations;
import andrews.pandoras_creatures.entities.animations.HellhoundAnimation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Hellhound extends Wolf
{
    public final List<AdvancedAnimationState> lingeringStates = new ArrayList<>();
    public final AdvancedAnimationState walkState = new AdvancedAnimationState(new AtomicReference<>());
    public final AdvancedAnimationState angleState = new AdvancedAnimationState(new AtomicReference<>());

    public Hellhound(EntityType<? extends Wolf> entityType, Level level)
    {
        super(entityType, level);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
            walkState.setAnimation(HellhoundAnimation.HELLHOUND_WALK);
            angleState.setAnimation(HellhoundAnimation.HELLHOUND_ANGEL);
        });
    }

    @Override
    protected void registerGoals()
    {
//        this.goalSelector.addGoal(1, new RandomLookAroundGoal(this));
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand)
    {
        if(player.getItemInHand(hand).is(Items.STICK))
            if(this.walkState.isStarted() && this.walkState.getOutTime() == 0)
            {
                this.walkState.interpolateAndStop(0.2F, EasingTypes.LINEAR, false);
                this.lingeringStates.add(new AdvancedAnimationState(this.walkState));
                this.walkState.stop();
            } else {
                this.walkState.interpolateAndStart(0.5F, EasingTypes.LINEAR, false, this.tickCount);
            }
        if(player.getItemInHand(hand).is(Items.BLAZE_ROD))
            if(this.angleState.isStarted())
            {
                this.angleState.interpolateAndStop(2.0F, EasingTypes.LINEAR, player.isShiftKeyDown());
                this.lingeringStates.add(new AdvancedAnimationState(this.angleState));
                this.angleState.stop();
            } else {
                this.angleState.interpolateAndStart(2.0F, EasingTypes.LINEAR, player.isShiftKeyDown(), this.tickCount);
            }
        return InteractionResult.PASS;
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return null;
    }
}