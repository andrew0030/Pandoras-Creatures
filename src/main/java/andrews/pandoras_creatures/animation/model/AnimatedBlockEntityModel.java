package andrews.pandoras_creatures.animation.model;

import andrews.pandoras_creatures.animation.system.base.AnimatedBlockEntity;
import andrews.pandoras_creatures.animation.system.custom.Animation;
import andrews.pandoras_creatures.animation.system.wrap.AdvancedAnimationState;
import andrews.pandoras_creatures.animation.system.wrap.AdvancedKeyframeAnimations;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.AnimationState;
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

    protected void animate(AnimationState state, AnimationDefinition definition, float ageInTicks)
    {
        this.animate(state, definition, ageInTicks, 1.0F);
    }

    protected void animate(AnimationState state, AnimationDefinition definition, float ageInTicks, float speed)
    {
        // Not sure why vanilla has a call to this above the if check, as this method also checks for
        // AnimationState#isStarted, but we need it because we run logic that happens before the super call,
        // and that needs to be updated at all times.
        state.updateTime(ageInTicks, speed);
        if(state.isStarted())
        {
            AdvancedKeyframeAnimations.animate(this, definition, state.getAccumulatedTime(), 1.0F, ANIMATION_VECTOR_CACHE);
        }
    }

    // TODO remove this
    protected void animate(AdvancedAnimationState state, Animation animation, float ageInTicks, float speed)
    {
        // Not sure why vanilla has a call to this above the if check, as this method also checks for
        // AnimationState#isStarted, but we need it because we run logic that happens before the super call,
        // and that needs to be updated at all times.
        state.updateTime(ageInTicks, speed);
        if(state.isStarted())
        {
            AdvancedKeyframeAnimations.animate(this, animation, state, 1.0F, ANIMATION_VECTOR_CACHE);
        }
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