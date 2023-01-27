package andrews.pandoras_creatures.block_entities.model;

import andrews.pandoras_creatures.animation.model.AdvancedMeshDefinition;
import andrews.pandoras_creatures.animation.model.AdvancedModelPart;
import andrews.pandoras_creatures.animation.model.AdvancedPartDefinition;
import andrews.pandoras_creatures.animation.model.AnimatedBlockEntityModel;
import andrews.pandoras_creatures.animation.system.base.AnimatedBlockEntity;
import andrews.pandoras_creatures.block_entities.TestAnimationBlockEntity;
import andrews.pandoras_creatures.util.Reference;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class TestAnimationModel extends AnimatedBlockEntityModel
{
    public static final ModelLayerLocation LAYER = new ModelLayerLocation(new ResourceLocation(Reference.MODID, "test_animation"), "main");
    public final AdvancedModelPart base;
    public final AdvancedModelPart top;

    public TestAnimationModel(ModelPart root)
    {
        super(RenderType::entityCutoutNoCull);
        this.base = (AdvancedModelPart) root.getChild("base");
        this.top = base.getChild("plate").getChild("arm_bottom").getChild("arm_top").getChild("top");
    }

    public static LayerDefinition createBodyLayer()
    {
        AdvancedMeshDefinition meshdefinition = new AdvancedMeshDefinition();
        AdvancedPartDefinition partdefinition = meshdefinition.getAdvancedRoot();
        AdvancedPartDefinition base = partdefinition.addOrReplaceChild("base", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -2.0F, -8.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
        AdvancedPartDefinition plate = base.addOrReplaceChild("plate", CubeListBuilder.create().texOffs(0, 18).addBox(-4.0F, -6.0F, -4.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        AdvancedPartDefinition arm_bottom = plate.addOrReplaceChild("arm_bottom", CubeListBuilder.create().texOffs(0, 30).addBox(-1.0F, -11.0F, -1.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, -0.7854F, 0.0F, 0.0F));
        AdvancedPartDefinition arm_top = arm_bottom.addOrReplaceChild("arm_top", CubeListBuilder.create().texOffs(8, 30).addBox(-0.5F, -8.0F, -1.0F, 1.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, 1.7453F, -0.0436F, 0.0F));
        AdvancedPartDefinition top = arm_top.addOrReplaceChild("top", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        AdvancedPartDefinition cube_r1 = top.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, 0.0F, 0.6545F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition.overwriteRootChildren(partdefinition), 64, 64);
    }

    @Override
    public void updateAnimations(AnimatedBlockEntity blockEntity, float partialTick)
    {
        if(blockEntity instanceof TestAnimationBlockEntity animated)
        {
            this.base.getAllParts().forEach(ModelPart::resetPose);
            animated.lingeringStates.removeIf(state -> !state.isStarted());
            animated.lingeringStates.forEach(state -> this.animate(state, animated.getTicksExisted() + partialTick, 1.0F));
            this.animate(animated.testAnimationState, animated.getTicksExisted() + partialTick, 1.0F);
            this.animate(animated.altAnimationState, animated.getTicksExisted() + partialTick, 1.0F);
        }
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
    {
        base.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public AdvancedModelPart root()
    {
        return this.base;
    }
}