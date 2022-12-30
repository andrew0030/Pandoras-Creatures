package andrews.pandoras_creatures.animation;

import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import org.joml.Vector3f;

import java.util.function.Function;

public abstract class AdvancedHierarchicalModel<E extends Entity> extends HierarchicalModel<E>
{
    private static final Vector3f ANIMATION_VECTOR_CACHE = new Vector3f();//TODO Access Transform this

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
        state.updateTime(ageInTicks, speed);
        if(state.isStarted())
        {
            AdvancedKeyframeAnimations.animate(this, definition, state.getAccumulatedTime(), 1.0F, ANIMATION_VECTOR_CACHE);
        }
    }
}