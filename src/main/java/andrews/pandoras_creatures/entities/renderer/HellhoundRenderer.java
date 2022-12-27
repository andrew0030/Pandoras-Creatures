package andrews.pandoras_creatures.entities.renderer;

import andrews.pandoras_creatures.entities.Hellhound;
import andrews.pandoras_creatures.entities.model.HellhoundModel;
import andrews.pandoras_creatures.util.PCRenderUtil;
import andrews.pandoras_creatures.util.Reference;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class HellhoundRenderer<E extends Hellhound> extends MobRenderer<E, HellhoundModel<E>>
{
    private final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID, "textures/entity/hellhound.png");

    public HellhoundRenderer(EntityRendererProvider.Context context)
    {
        super(context, new HellhoundModel<>(context.bakeLayer(HellhoundModel.LAYER)), 0.5F);//TODO shadow radius
    }

    @Override
    public void render(E entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight)
    {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);

//        float headX = (1/16F) * this.getModel().body.getChild("neck").getChild("head").x;
//        float headY = (1/16F) * this.getModel().body.getChild("neck").getChild("head").y;
//        float headZ = (1/16F) * this.getModel().body.getChild("neck").getChild("head").z;
//
//        float neckX = (1/16F) * this.getModel().body.getChild("neck").x;
//        float neckY = (1/16F) * this.getModel().body.getChild("neck").y;
//        float neckZ = (1/16F) * this.getModel().body.getChild("neck").z;
//
//        float xPos = (1/16F) * this.getModel().body.x - neckX - headX;
//        float yPos = (1/16F) * (24.0F - this.getModel().body.y) - neckY - headY;
//        float zPos = (1/16F) * (-this.getModel().body.z) - neckZ - headZ;
//
//        drawCross()...
//        renderText(Component.literal("head"), xPos, yPos, zPos, 0.3F, poseStack, buffer, packedLight);

        PCRenderUtil.renderCross(buffer, poseStack, 0, 255, 0, 0.0F, 1.0F, 0.0F, 0.2F);
        PCRenderUtil.renderQuad(buffer, poseStack, 255, 0, 0, 0.0F, 1.0F, 0.0F, 0.04F);
        PCRenderUtil.renderText(Component.literal("body"), 0.0F, 1.05F, 0.0F, 0.3F, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(E entity)
    {
        return TEXTURE;
    }
}