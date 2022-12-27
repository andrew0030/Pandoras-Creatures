package andrews.pandoras_creatures.util.animation;

import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class AdvancedModelPart extends ModelPart
{
    private final String name;
    private AdvancedModelPart parent;

    public AdvancedModelPart(List<Cube> cubes, Map<String, ModelPart> children, String name)
    {
        super(cubes, children);
        this.name = name;
        for(ModelPart childModel : children.values())
            if(childModel instanceof AdvancedModelPart advancedModelPart)
                advancedModelPart.parent = this;
    }

    public AdvancedModelPart(ModelPart modelPart)
    {
        this(modelPart.cubes, modelPart.children, null);
    }

    @Override
    public AdvancedModelPart getChild(String pName)
    {
        ModelPart modelpart = this.children.get(pName);
        if (modelpart != null)
        {
            return modelpart instanceof AdvancedModelPart ? (AdvancedModelPart) modelpart : new AdvancedModelPart(modelpart);
        }
        throw new NoSuchElementException("Can't find part " + pName);
    }

    public String getName()
    {
        return this.name;
    }

    public boolean hasParent()
    {
        return this.parent != null;
    }

    public AdvancedModelPart getParent()
    {
        return this.parent;
    }
}