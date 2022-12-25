package andrews.pandoras_creatures.util.animation;

import net.minecraft.client.model.geom.builders.MeshDefinition;

public class AdvancedMeshDefinition extends MeshDefinition
{
    private final AdvancedPartDefinition advancedRoot = new AdvancedPartDefinition(this.getRoot());

    public AdvancedPartDefinition getAdvancedRoot()
    {
        return this.advancedRoot;
    }
//    @Override
//    public AdvancedPartDefinition getRoot()
//    {
//        return new AdvancedPartDefinition(super.getRoot());
//    }

    
}