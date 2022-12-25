package andrews.pandoras_creatures.util.animation;

import net.minecraft.client.model.geom.ModelPart;

import java.util.List;
import java.util.Map;

public class AdvancedModelPart extends ModelPart
{
    public AdvancedModelPart(List<Cube> cubes, Map<String, ModelPart> children)
    {
        super(cubes, children);
    }
}