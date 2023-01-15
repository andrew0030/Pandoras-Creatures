package andrews.pandoras_creatures.entities;

import andrews.pandoras_creatures.animation.system.core.AdvancedAnimationState;
import andrews.pandoras_creatures.animation.system.core.util.InterpolationType;
import andrews.pandoras_creatures.entities.animations.HellhoundAnimation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class Hellhound extends Wolf
{
    public final AdvancedAnimationState walkState = new AdvancedAnimationState(HellhoundAnimation.HELLHOUND_WALK);
    public final AdvancedAnimationState angleState = new AdvancedAnimationState(HellhoundAnimation.HELLHOUND_ANGEL);

    public Hellhound(EntityType<? extends Wolf> entityType, Level level)
    {
        super(entityType, level);
    }

    @Override
    protected void registerGoals()
    {
//        this.goalSelector.addGoal(1, new RandomLookAroundGoal(this));
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand)
    {
        if(!player.isShiftKeyDown()) {
            if(player.getItemInHand(hand).is(Items.STICK))
                if(this.walkState.isStarted())
                {
                    this.walkState.interpolateAndStop(3.5F, InterpolationType.OUT);
                } else {
                    this.walkState.interpolateAndStart(3.5F, this.tickCount, InterpolationType.IN);
                }
            if(player.getItemInHand(hand).is(Items.BLAZE_ROD))
                if(this.angleState.isStarted())
                {
                    this.angleState.interpolateAndStop(2.0F, InterpolationType.OUT);
                } else {
                    this.angleState.interpolateAndStart(2.0F, this.tickCount, InterpolationType.IN);
                }
        } else {
            this.walkState.stop();
            this.angleState.stop();
        }
        return InteractionResult.PASS;
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return null;
    }
}