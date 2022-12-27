package andrews.pandoras_creatures.util.animation;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.PartDefinition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AdvancedPartDefinition extends PartDefinition
{
    private final AdvancedPartDefinition parent;
    private AdvancedModelPart bakedParent;
    private final String name;

    private AdvancedPartDefinition(List<CubeDefinition> cubes, PartPose partPose, AdvancedPartDefinition parent, String name)
    {
        super(cubes, partPose);
        this.parent = parent;
        this.name = name;
    }

    /**
     * This constructor can be used to initialize a chain of AdvancedPartDefinition's.
     * @param partDefinition The PartDefinition that will be converted.
     */
    public AdvancedPartDefinition(PartDefinition partDefinition)
    {
        this(partDefinition.cubes, partDefinition.partPose, null, null);
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

    @Override
    public AdvancedModelPart bake(int texWidth, int texHeight)
    {
        // Takes all the cubeDefinition's, bakes them and stores them in an ImmutableList as Cube's
        List<ModelPart.Cube> list = this.cubes.stream().map((cubeDefinition) -> cubeDefinition.bake(texWidth, texHeight)).collect(ImmutableList.toImmutableList());
        // A more readable approach of baking the values in children. TODO if this causes issues use the old method
        Map<String, ModelPart> map = Maps.newHashMap();
        for(String key : this.children.keySet())
            map.put(key, this.children.get(key).bake(texWidth, texHeight));

        AdvancedModelPart modelPart = new AdvancedModelPart(list, map, this.name);
        modelPart.setInitialPose(this.partPose);
        modelPart.loadPose(this.partPose);
        return modelPart;
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
     * @return Whether this Advanced Part Definition has a name
     */
    public boolean hasName()
    {
        return this.name != null;
    }

    /**
     * @return The name of this Advanced Part Definition
     */
    public String getName()
    {
        return this.name;
    }
}