package andrews.pandoras_creatures.entities.renderer;

import andrews.pandoras_creatures.entities.Hellhound;
import andrews.pandoras_creatures.entities.model.HellhoundModel;
import andrews.pandoras_creatures.util.PCRenderTypes;
import andrews.pandoras_creatures.util.Reference;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.gui.Font;
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

        // Rendering lines as a test
        VertexConsumer builder = buffer.getBuffer(PCRenderTypes.skeletonDebugLines());
        drawLine(builder, poseStack, 255, 0, 0, 0F, 0F, 0F, 0F, 0.5F, 0F);
        drawLine(builder, poseStack, 0, 255, 0, 0F, 0.5F, 0F, 0F, 1.0F, 0.5F);
        drawLine(builder, poseStack, 0, 0, 255, 0F, 1.0F, 0.5F, 0F, 1.0F, 1.0F);

        renderText(Component.literal("start"), 0.0F, 0.0F, 0.0F, 0.3F, poseStack, buffer, packedLight);
        renderText(Component.literal("segment_1"), 0.0F, 0.5F, 0.0F, 0.3F, poseStack, buffer, packedLight);
        renderText(Component.literal("segment_2"), 0.0F, 1.0F, 0.5F, 0.3F, poseStack, buffer, packedLight);
        renderText(Component.literal("end"), 0.0F, 1.0F, 1.0F, 0.3F, poseStack, buffer, packedLight);
    }

    private void drawLine(VertexConsumer builder, PoseStack poseStack, int red, int green, int blue, float startX, float startY, float startZ, float endX, float endY, float endZ)
    {
        // Start Vertex
        builder.vertex(poseStack.last().pose(), startX, startY, startZ);
        builder.color(red, green, blue, 255);
        builder.endVertex();
        // End Vertex
        builder.vertex(poseStack.last().pose(), endX, endY, endZ);
        builder.color(red, green, blue, 255);
        builder.endVertex();
    }

    private void renderText(Component text, float posX, float posY, float posZ, float scale, PoseStack poseStack, MultiBufferSource buffer, int packedLight)
    {
        poseStack.pushPose();

        poseStack.translate(posX, posY, posZ);
        poseStack.mulPose(this.entityRenderDispatcher.cameraOrientation());
        poseStack.scale(-0.025F, -0.025F, 0.025F);
        poseStack.scale(scale, scale, scale);
        Font font = this.getFont();
        float centerOffset = (float)(-font.width(text) / 2);
        font.drawInBatch(text, centerOffset, -9, -1, false, poseStack.last().pose(), buffer, true, 0, packedLight);

        poseStack.popPose();
    }

    @Override
    public ResourceLocation getTextureLocation(E entity)
    {
        return TEXTURE;
    }
}