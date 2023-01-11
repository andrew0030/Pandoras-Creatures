package andrews.pandoras_creatures.entities;

import andrews.pandoras_creatures.animation.system.core.AdvancedAnimationState;
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
    public final AdvancedAnimationState walkKeyFrameState = new AdvancedAnimationState(HellhoundAnimation.HELLHOUND_WALK);//TODO replace null
    public final AdvancedAnimationState angleKeyFrameState = new AdvancedAnimationState(null);

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
                if(this.walkKeyFrameState.isStarted())
                {
                    this.walkKeyFrameState.stop();
                } else {
                    this.walkKeyFrameState.startIfStopped(tickCount);
                }
            if(player.getItemInHand(hand).is(Items.BLAZE_ROD))
                if(this.angleKeyFrameState.isStarted())
                {
                    this.angleKeyFrameState.stop();
                } else {
                    this.angleKeyFrameState.startLater(20);
                }
        } else {
            this.walkKeyFrameState.stop();
            this.angleKeyFrameState.stop();
        }
        return InteractionResult.PASS;
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return null;
    }
}