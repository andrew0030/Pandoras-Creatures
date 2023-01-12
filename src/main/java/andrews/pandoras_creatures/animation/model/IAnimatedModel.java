package andrews.pandoras_creatures.animation.model;

import andrews.pandoras_creatures.animation.system.core.AdvancedAnimationState;
import net.minecraft.client.model.geom.ModelPart;

import java.util.Optional;

public interface IAnimatedModel
{
    void animate(AdvancedAnimationState state, float ageInTicks, float speed);

    Optional<ModelPart> getAnyDescendantWithName(String name);

    AdvancedModelPart root();
}
