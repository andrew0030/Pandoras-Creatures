package andrews.pandoras_creatures.util.animation;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

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

    public Vector3f getModelSPace(Entity entity, float entityYaw)
    {
        float scale = 1.0F / 16.0F;
        PoseStack poseStack = new PoseStack();


        poseStack.mulPose(Axis.YN.rotationDegrees(Mth.lerp(Minecraft.getInstance().getPartialTick(), ((LivingEntity) entity).yBodyRotO, ((LivingEntity) entity).yBodyRot)));
        poseStack.translate(0, scale * 24, 0);
        poseStack.scale(1, -1, -1);
        poseStack.translate(scale * this.getParent().x, scale * this.getParent().y, scale * this.getParent().z);
        poseStack.mulPose(Axis.XP.rotation(this.getParent().xRot));

        poseStack.translate(scale * this.x, scale * this.y, scale * this.z);

        Matrix4f matrix4f = poseStack.last().pose();
        Vector4f vec = new Vector4f(0, 0, 0, 1);
        vec.mul(matrix4f);

        return new Vector3f(vec.x(), vec.y(), vec.z());
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