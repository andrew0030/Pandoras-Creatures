package andrews.pandoras_creatures.block_entities.model;

import andrews.pandoras_creatures.animation.model.AdvancedMeshDefinition;
import andrews.pandoras_creatures.animation.model.AdvancedModelPart;
import andrews.pandoras_creatures.animation.model.AdvancedPartDefinition;
import andrews.pandoras_creatures.animation.system.wrap.AdvancedKeyframeAnimations;
import andrews.pandoras_creatures.block_entities.TestAnimationBlockEntity;
import andrews.pandoras_creatures.util.Reference;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.joml.Vector3f;

import java.util.Optional;

public class TestAnimationModel extends Model
{
    public static final Vector3f ANIMATION_VECTOR_CACHE = new Vector3f();
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

    public void setupAnim(TestAnimationBlockEntity blockEntity, float partialTick)
    {
        this.base.getAllParts().forEach(ModelPart::resetPose);
        this.animate(blockEntity.testAnimationState, blockEntity.testAnimationState.getAnimation(), blockEntity.getTicksExisted() + partialTick);
        this.animate(blockEntity.testAnimationState, blockEntity.testAnimationState.getAnimation(), blockEntity.getTicksExisted() + partialTick);
    }

    protected void animate(AnimationState state, AnimationDefinition definition, float ageInTicks)
    {
        this.animate(state, definition, ageInTicks, 1.0F);
    }

    protected void animate(AnimationState state, AnimationDefinition definition, float ageInTicks, float speed)
    {
        // Not sure why vanilla has a call to this above the if check, as this method also checks for
        // AnimationState#isStarted, but we need it because we run logic that happens before the super call,
        // and that needs to be updated at all times.
        state.updateTime(ageInTicks, speed);
        if(state.isStarted())
        {
            AdvancedKeyframeAnimations.animate(this, definition, state.getAccumulatedTime(), 1.0F, ANIMATION_VECTOR_CACHE);
        }
    }

    public Optional<ModelPart> getAnyDescendantWithName(String p_233394_) {
        return p_233394_.equals("root") ? Optional.of(this.base) : this.base.getAllParts().filter((p_233400_) -> p_233400_.hasChild(p_233394_)).findFirst().map((p_233397_) -> p_233397_.getChild(p_233394_));
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
    {
        base.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}