package andrews.pandoras_creatures.animation.model;

import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;

import java.util.function.Function;

public abstract class AnimatedEntityModel<E extends Entity> extends HierarchicalModel<E>
{
    public AnimatedEntityModel()
    {
        this(RenderType::entityCutoutNoCull);
    }

    public AnimatedEntityModel(Function<ResourceLocation, RenderType> renderType)
    {
        super(renderType);
    }

    @Override
    protected void animate(AnimationState state, AnimationDefinition definition, float ageInTicks)
    {
        this.animate(state, definition, ageInTicks, 1.0F);
    }

    @Override
    protected void animate(AnimationState state, AnimationDefinition definition, float ageInTicks, float speed)
    {
        // Not sure why vanilla has a call to this above the if check, as this method also checks for
        // AnimationState#isStarted, but we need it because we run logic that happens before the super call,
        // and that needs to be updated at all times.
        state.updateTime(ageInTicks, speed);
        if(state.isStarted())
        {
//            AnimationHandler.animate(this, definition, state.getAccumulatedTime(), 1.0F, ANIMATION_VECTOR_CACHE);//TODO replace this
        }
    }
}