package andrews.pandoras_creatures.util.animation;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.PartDefinition;

import java.util.List;

public class AdvancedPartDefinition extends PartDefinition
{
    private final AdvancedPartDefinition parent;
    private final String name;

    private AdvancedPartDefinition(List<CubeDefinition> cubes, PartPose partPose, AdvancedPartDefinition parent, String name)
    {
        super(cubes, partPose);
        this.parent = parent;
        this.name = name;
    }

    /**
     * This constructor can be used to initialize a chain of AdvancedPartDefinition's.
     * It sets the name of the current AdvancedPartDefinition to the given one, and sets the
     * parent to null, as the first AdvancedPartDefinition can not have a parent.
     * @param name The name the newly created AdvancedPartDefinition should use.
     * @param partDefinition The PartDefinition that will be converted.
     */
    public AdvancedPartDefinition(String name, PartDefinition partDefinition)
    {
        this(partDefinition.cubes, partDefinition.partPose, null, name);
    }

    @Override
    public AdvancedPartDefinition addOrReplaceChild(String name, CubeListBuilder cubes, PartPose partPose)
    {
        AdvancedPartDefinition newPart = new AdvancedPartDefinition(cubes.getCubes(), partPose, this, name);
        PartDefinition replacedPart = this.children.put(name, newPart);
        if (replacedPart != null)
            newPart.children.putAll(replacedPart.children);
        return newPart;
    }

    /**
     * @return Whether this Advanced Part Definition has a parent
     */
    public boolean hasParent()
    {
        return this.parent != null;
    }

    /**
     * @return The parent of this Advanced Part Definition
     */
    public AdvancedPartDefinition getParent()
    {
        return this.parent;
    }

    /**
     * @return The name of this Advanced Part Definition
     */
    public String getName()
    {
        return this.name;
    }
}