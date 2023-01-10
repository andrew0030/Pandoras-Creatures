package andrews.pandoras_creatures.animation.model;

import andrews.pandoras_creatures.animation.system.base.AnimatedBlockEntity;
import andrews.pandoras_creatures.animation.system.core.AnimationHandler;
import andrews.pandoras_creatures.animation.system.core.AdvancedAnimationState;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.joml.Vector3f;

import java.util.Optional;
import java.util.function.Function;

public abstract class AnimatedBlockEntityModel extends Model
{
    public static final Vector3f ANIMATION_VECTOR_CACHE = new Vector3f();

    public AnimatedBlockEntityModel(Function<ResourceLocation, RenderType> renderType)
    {
        super(renderType);
    }

    protected void animate(AdvancedAnimationState state, float ageInTicks, float speed)
    {
        // We need this because we run logic that happens before the super call,
        // and that needs to be updated at all times.
        state.updateTime(ageInTicks, speed);
        if(state.isStarted())
            AnimationHandler.animate(this, state, ANIMATION_VECTOR_CACHE);
    }

    public Optional<ModelPart> getAnyDescendantWithName(String name)
    {
        return name.equals("root") ? Optional.of(this.root()) : this.root().getAllParts().filter(
                (part) -> part.hasChild(name)).findFirst().map(
                        (part1) -> part1.getChild(name));
    }

    /**
     * Call this inside the render() method inside the Renderer class
     * @param blockEntity The AnimatedBlockEntity
     * @param partialTick The partial ticks
     */
    public abstract void updateAnimations(AnimatedBlockEntity blockEntity, float partialTick);

    public abstract ModelPart root();
}