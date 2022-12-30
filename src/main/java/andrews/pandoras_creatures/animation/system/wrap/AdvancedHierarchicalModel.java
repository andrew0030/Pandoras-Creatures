package andrews.pandoras_creatures.animation.system.wrap;

import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;

import java.util.function.Function;

public abstract class AdvancedHierarchicalModel<E extends Entity> extends HierarchicalModel<E>
{
    public AdvancedHierarchicalModel()
    {
        this(RenderType::entityCutoutNoCull);
    }

    public AdvancedHierarchicalModel(Function<ResourceLocation, RenderType> renderType)
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
            //TODO maybe use this place to do interpolating by switching to a different animate method?
            AdvancedKeyframeAnimations.animate(this, definition, state.getAccumulatedTime(), 1.0F, ANIMATION_VECTOR_CACHE);
        }
    }
}