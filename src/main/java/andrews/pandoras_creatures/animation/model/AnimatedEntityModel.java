package andrews.pandoras_creatures.animation.model;

import andrews.pandoras_creatures.animation.system.core.AdvancedAnimationState;
import andrews.pandoras_creatures.animation.system.core.AnimationHandler;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

import java.util.Optional;
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

    protected void animate(AdvancedAnimationState state, float ageInTicks, float speed)
    {
        // We need this because we run logic that happens before the super call,
        // and that needs to be updated at all times.
        state.updateTime(ageInTicks, speed);
        if(state.isStarted())
        {
            AnimationHandler.animate(this, state, ANIMATION_VECTOR_CACHE);
        }
    }

    public Optional<ModelPart> getAnyDescendantWithName(String name)
    {
        return name.equals(this.root().getName()) ? Optional.of(this.root()) : this.root().getAllParts().filter(
                (part) -> part.hasChild(name)).findFirst().map(
                (part1) -> part1.getChild(name));
    }

    public abstract AdvancedModelPart root();
}