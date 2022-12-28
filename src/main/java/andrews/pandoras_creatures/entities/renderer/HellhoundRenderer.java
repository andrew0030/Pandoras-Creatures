package andrews.pandoras_creatures.entities.renderer;

import andrews.pandoras_creatures.entities.Hellhound;
import andrews.pandoras_creatures.entities.model.HellhoundModel;
import andrews.pandoras_creatures.entities.renderer.layers.HellhoundGlowLayer;
import andrews.pandoras_creatures.util.PCRenderUtil;
import andrews.pandoras_creatures.util.Reference;
import andrews.pandoras_creatures.util.animation.AdvancedModelPart;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.joml.Vector3f;

public class HellhoundRenderer<E extends Hellhound> extends MobRenderer<E, HellhoundModel<E>>
{
    private final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID, "textures/entity/hellhound.png");

    public HellhoundRenderer(EntityRendererProvider.Context context)
    {
        super(context, new HellhoundModel<>(context.bakeLayer(HellhoundModel.LAYER)), 0.5F);//TODO shadow radius
        this.addLayer(new HellhoundGlowLayer<>(this));
    }

    @Override
    public void render(E entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight)
    {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);

        AdvancedModelPart bodyPart = this.getModel().body;
        Vector3f bodyPartPos = bodyPart.getModelSpace(entity);
        PCRenderUtil.renderCross(entity, buffer, poseStack, bodyPartPos.x, bodyPartPos.y, bodyPartPos.z, bodyPart.xRot, bodyPart.yRot, bodyPart.zRot, 0.4F);
        AdvancedModelPart neckPart = this.getModel().neck;
        Vector3f neckPartPos = neckPart.getModelSpace(entity);
        Vector3f neckRotation = neckPart.getTotalRotation();
        PCRenderUtil.renderCross(entity, buffer, poseStack, neckPartPos.x, neckPartPos.y, neckPartPos.z, neckRotation.x, neckRotation.y, neckRotation.z, 0.4F);

//        boolean showNames = false;
//        AdvancedModelPart part = this.getModel().leftfrontlegtop.getChild("leftfrontlegmid").getChild("leftfrontlegpaw");
//        PCRenderUtil.renderChainFromModelPart(entity, buffer, poseStack, part, packedLight, showNames);
//        part = this.getModel().body.getChild("rightfrontlegtop").getChild("rightfrontlegmid").getChild("rightfrontlegpaw");
//        PCRenderUtil.renderChainFromModelPart(entity, buffer, poseStack, part, packedLight, showNames);
//        part = this.getModel().body.getChild("rightbacklegtop").getChild("rightbacklegmid").getChild("rightbacklegpaw");
//        PCRenderUtil.renderChainFromModelPart(entity, buffer, poseStack, part, packedLight, showNames);
//        part = this.getModel().body.getChild("leftbacklegtop").getChild("leftbacklegmid").getChild("leftbacklegpaw");
//        PCRenderUtil.renderChainFromModelPart(entity, buffer, poseStack, part, packedLight, showNames);
//        part = this.getModel().head;
//        PCRenderUtil.renderChainFromModelPart(entity, buffer, poseStack, part, packedLight, showNames);
    }

    @Override
    public ResourceLocation getTextureLocation(E entity)
    {
        return TEXTURE;
    }
}