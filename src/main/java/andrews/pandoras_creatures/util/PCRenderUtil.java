package andrews.pandoras_creatures.util;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.network.chat.Component;

public class PCRenderUtil
{
    public static void renderLine(MultiBufferSource buffer, PoseStack poseStack, int red, int green, int blue, float startX, float startY, float startZ, float endX, float endY, float endZ)
    {
        VertexConsumer builder = buffer.getBuffer(PCRenderTypes.skeletonDebugLines());
        // Start Vertex
        builder.vertex(poseStack.last().pose(), startX, startY, startZ);
        builder.color(red, green, blue, 255);
        builder.endVertex();
        // End Vertex
        builder.vertex(poseStack.last().pose(), endX, endY, endZ);
        builder.color(red, green, blue, 255);
        builder.endVertex();
    }

    public static void renderText(Component text, float posX, float posY, float posZ, float scale, PoseStack poseStack, MultiBufferSource buffer, int packedLight)
    {
        poseStack.pushPose();
        poseStack.translate(posX, posY, posZ);
        poseStack.mulPose(Minecraft.getInstance().getEntityRenderDispatcher().cameraOrientation());
        poseStack.scale(-0.025F, -0.025F, 0.025F);
        poseStack.scale(scale, scale, scale);
        Font font = Minecraft.getInstance().font;
        float centerOffset = (float)(-font.width(text) / 2);
        font.drawInBatch(text, centerOffset, -9, -1, false, poseStack.last().pose(), buffer, true, 0, packedLight);
        poseStack.popPose();
    }

    public static void renderQuad(MultiBufferSource buffer, PoseStack poseStack, int red, int green, int blue, float posX, float posY, float posZ, float size)
    {
        float scale = size / 2F;
        VertexConsumer builder = buffer.getBuffer(PCRenderTypes.skeletonDebugQuad());
        poseStack.pushPose();
        poseStack.translate(posX, posY, posZ);
        poseStack.mulPose(Minecraft.getInstance().getEntityRenderDispatcher().cameraOrientation());
        builder.vertex(poseStack.last().pose(), -scale, scale, 0);
        builder.color(red, green, blue, 255);
        builder.endVertex();
        builder.vertex(poseStack.last().pose(), scale, scale, 0);
        builder.color(red, green, blue, 255);
        builder.endVertex();
        builder.vertex(poseStack.last().pose(), scale, -scale, 0);
        builder.color(red, green, blue, 255);
        builder.endVertex();
        builder.vertex(poseStack.last().pose(), -scale, -scale, 0);
        builder.color(red, green, blue, 255);
        builder.endVertex();
        poseStack.popPose();
    }

    public static void renderCross(MultiBufferSource buffer, PoseStack poseStack, int red, int green, int blue, float xPos, float yPos, float zPos, float size)
    {
        PCRenderUtil.renderLine(buffer, poseStack, red, green, blue, xPos - (size / 2F), yPos, zPos, xPos + (size / 2F), yPos, zPos);
        PCRenderUtil.renderLine(buffer, poseStack, red, green, blue, xPos, yPos - (size / 2F), zPos, xPos, yPos + (size / 2F), zPos);
        PCRenderUtil.renderLine(buffer, poseStack, red, green, blue, xPos, yPos, zPos - (size / 2F), xPos, yPos, zPos + (size / 2F));
    }
}