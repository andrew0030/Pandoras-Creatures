package andrews.pandoras_creatures.util.animation;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.PartDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

//    @Override
//    public AdvancedModelPart bake(int texWidth, int texHeight)
//    {
//        System.out.println("Calling Advanced Baking for: " + this.name);
//
//        // Creates an Immutable List of all the Cubes
//        List<ModelPart.Cube> list = new ArrayList<>();
//        for(CubeDefinition cube : this.cubes)
//            list.add(cube.bake(texWidth, texHeight));
//        List<ModelPart.Cube> lockedList = ImmutableList.copyOf(list);
//        // Gets all the Model Definitions of children and stores them after baking them
//        Map<String, ModelPart> postBakeMap = Maps.newHashMap();
//        for(String key : this.children.keySet())
//        {
//            //TODO figure out if this nukes everything
//            if(this.children.get(key) instanceof AdvancedPartDefinition advancedPartDefinition)
//            {
//                postBakeMap.put(key, advancedPartDefinition.bake(texWidth, texHeight));
//            }
//            else
//            {
//                System.out.println("OMG TACTICAL NUKE BOOOOM");
//            }
//        }
//
//        AdvancedModelPart modelpart = new AdvancedModelPart(lockedList, postBakeMap);
//        modelpart.setInitialPose(this.partPose);
//        modelpart.loadPose(this.partPose);
//        return modelpart;
//    }

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