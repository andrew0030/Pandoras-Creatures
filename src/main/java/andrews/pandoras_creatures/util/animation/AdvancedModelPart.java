package andrews.pandoras_creatures.util.animation;

import net.minecraft.client.model.geom.ModelPart;

import java.util.List;
import java.util.Map;

public class AdvancedModelPart extends ModelPart
{
    public AdvancedModelPart parent;
    private final String name;

    public AdvancedModelPart(List<Cube> cubes, Map<String, ModelPart> children, String name)
    {
        super(cubes, children);
        this.name = name;
        for(ModelPart childModel : children.values())
        {
            if(childModel instanceof AdvancedModelPart advancedModelPart)
                advancedModelPart.parent = this;
        }
    }

    public String getName()
    {
        return this.name;
    }

    public boolean hasParent()
    {
        return parent != null;
    }

    public AdvancedModelPart getParent()
    {
        return parent;
    }
}