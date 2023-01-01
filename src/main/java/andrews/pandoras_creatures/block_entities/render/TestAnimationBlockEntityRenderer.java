package andrews.pandoras_creatures.block_entities.render;

import andrews.pandoras_creatures.animation.model.AnimatedBlockEntityModel;
import andrews.pandoras_creatures.animation.system.base.AnimatedBlockEntity;
import andrews.pandoras_creatures.block_entities.TestAnimationBlockEntity;
import andrews.pandoras_creatures.block_entities.model.TestAnimationModel;
import andrews.pandoras_creatures.util.PCRenderUtil;
import andrews.pandoras_creatures.util.Reference;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class TestAnimationBlockEntityRenderer implements BlockEntityRenderer<TestAnimationBlockEntity>
{
    public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID, "textures/entity/test_animation.png");
    private final TestAnimationModel model;

    public TestAnimationBlockEntityRenderer(BlockEntityRendererProvider.Context context)
    {
        model = new TestAnimationModel(context.bakeLayer(TestAnimationModel.LAYER));
    }

    @Override
    public void render(TestAnimationBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay)
    {
        model.updateAnimations(blockEntity, partialTick);
//        PCRenderUtil.renderLine(bufferSource, poseStack, 0, 255, 200, 0.5F, 1.0F, 0.5F, 0.5F, 2.0F, 0.5F);

        poseStack.pushPose();
        poseStack.translate(0.5D, 1.5D, 0.5D);
        poseStack.scale(1.0F, -1.0F, -1.0F);
        poseStack.translate(0, -1, 0);
        VertexConsumer vertexconsumer = bufferSource.getBuffer(RenderType.entityCutout(TEXTURE));
        model.renderToBuffer(poseStack, vertexconsumer, packedLight, packedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
        poseStack.popPose();

        PCRenderUtil.renderLine(bufferSource, poseStack, 255, 20, 20, 0, 1 ,0, 1, 1, 0);
        PCRenderUtil.renderLine(bufferSource, poseStack, 255, 20, 20, 0, 1 ,0, 0, 1, 1);
        PCRenderUtil.renderLine(bufferSource, poseStack, 255, 20, 20, 1, 1 ,1, 1, 1, 0);
        PCRenderUtil.renderLine(bufferSource, poseStack, 255, 20, 20, 1, 1 ,1, 0, 1, 1);
        PCRenderUtil.renderLine(bufferSource, poseStack, 255, 20, 20, 0, 1 ,0, 1, 1, 1);
        PCRenderUtil.renderLine(bufferSource, poseStack, 255, 20, 20, 0, 1 ,1 , 1, 1, 0);

        poseStack.pushPose();
        poseStack.translate(0.5D, 1.0D, 0.5D);
        PCRenderUtil.renderChainFromModelPart(null, bufferSource, poseStack, this.model.top.getChild("cube_r1"), packedLight, false);
        poseStack.popPose();
    }
}