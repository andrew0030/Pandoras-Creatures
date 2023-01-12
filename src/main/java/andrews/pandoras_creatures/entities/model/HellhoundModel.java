package andrews.pandoras_creatures.entities.model;

import andrews.pandoras_creatures.animation.model.AdvancedMeshDefinition;
import andrews.pandoras_creatures.animation.model.AdvancedModelPart;
import andrews.pandoras_creatures.animation.model.AdvancedPartDefinition;
import andrews.pandoras_creatures.animation.model.AnimatedEntityModel;
import andrews.pandoras_creatures.entities.Hellhound;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.ResourceLocation;

public class HellhoundModel<T extends Hellhound> extends AnimatedEntityModel<T>
{
    public static final ModelLayerLocation LAYER = new ModelLayerLocation(new ResourceLocation(Reference.MODID, "hellhound"), "main");
    public final AdvancedModelPart body;
    public final AdvancedModelPart neck;
    public final AdvancedModelPart head;
    public final AdvancedModelPart leftfrontlegtop;

    public HellhoundModel(ModelPart root)
    {
        // This should always be an AdvancedModelPart, if it isn't there are bigger issues than this cast!
        this.body = (AdvancedModelPart) root.getChild("body");
        this.neck = body.getChild("neck");
        this.head = neck.getChild("head");
        this.leftfrontlegtop = body.getChild("leftfrontlegtop");
    }

    public static LayerDefinition createBodyLayer()
    {
        AdvancedMeshDefinition meshdefinition = new AdvancedMeshDefinition();
        AdvancedPartDefinition partdefinition = meshdefinition.getAdvancedRoot();
        AdvancedPartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 7.5F, 0.25F, -0.1745F, 0.0F, 0.0F));
        AdvancedPartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -6.4771F, -0.0228F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, -5.0F, -1.4835F, 0.0F, 0.0F));
        AdvancedPartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(45, 40).addBox(0.0F, -4.0F, 0.0F, 0.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.75F, 2.0F, -0.4363F, 0.0F, 0.0F));
        AdvancedPartDefinition cube_r3 = body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(57, 39).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -0.75F, -1.0F, -0.4363F, 0.0F, 0.0F));
        AdvancedPartDefinition cube_r4 = body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(57, 33).addBox(-1.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -0.75F, -4.0F, -0.3491F, 0.0F, 0.0F));
        AdvancedPartDefinition cube_r5 = body.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(57, 27).addBox(-1.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -0.75F, -7.0F, -0.2618F, 0.0F, 0.0F));
        AdvancedPartDefinition hip_r1 = body.addOrReplaceChild("hip_r1", CubeListBuilder.create().texOffs(32, 0).addBox(-3.0F, -3.25F, -4.75F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 3.25F, 9.5F, -0.3491F, 0.0F, 0.0F));
        AdvancedPartDefinition chest_r1 = body.addOrReplaceChild("chest_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 0.0F, -7.0F, 8.0F, 8.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0873F, 0.0F, 0.0F));
        AdvancedPartDefinition cube_r6 = body.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(44, 25).addBox(-2.0F, -16.0F, -7.0F, 3.0F, 18.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 6.25F, -5.0F, -1.5708F, 0.0F, 0.0F));
        AdvancedPartDefinition heart = body.addOrReplaceChild("heart", CubeListBuilder.create().texOffs(21, 43).addBox(-1.0F, -1.0F, 0.0F, 4.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 4.0F, -4.0F));
        AdvancedPartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(1, 8).addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.75F, -7.0F, 0.3491F, 0.0F, 0.0F));
        AdvancedPartDefinition cube_r7 = neck.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(8, 2).addBox(0.0F, -5.0F, 1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.0F, -4.5F, -0.5236F, 0.0F, 0.0F));
        AdvancedPartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 24).addBox(-2.5F, -2.6F, -5.35F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(19, 24).addBox(-1.5F, -2.5F, -5.25F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.001F))
                .texOffs(2, 44).addBox(-2.5F, -2.6F, -1.35F, 5.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(16, 36).addBox(-2.0F, -1.5F, -5.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.25F, -3.75F));
        AdvancedPartDefinition cube_r8 = head.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(31, 30).addBox(-1.0F, -1.0F, 0.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(-0.001F)), PartPose.offsetAndRotation(-0.5F, 2.6179F, -8.5412F, 0.3054F, 0.0F, 0.0F));
        AdvancedPartDefinition cube_r9 = head.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(24, 36).addBox(-2.0F, 0.0F, -4.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -1.0F, -5.25F, 0.1745F, 0.0F, 0.0F));
        AdvancedPartDefinition leftear = head.addOrReplaceChild("leftear", CubeListBuilder.create(), PartPose.offset(0.8F, -2.6F, -1.75F));
        AdvancedPartDefinition cube_r10 = leftear.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(17, 24).addBox(-1.0F, -3.0F, 0.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7F, 0.5F, 0.4F, -0.0618F, -0.4671F, 0.4609F));
        AdvancedPartDefinition rightear = head.addOrReplaceChild("rightear", CubeListBuilder.create(), PartPose.offset(-0.8F, -2.6F, -1.75F));
        AdvancedPartDefinition cube_r11 = rightear.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(17, 24).mirror().addBox(-1.0F, -3.0F, 0.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.7F, 0.5F, 0.4F, -0.0618F, 0.4671F, -0.4609F));
        AdvancedPartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(0, 33).addBox(-2.0F, -1.0F, -6.0F, 4.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.75F, -2.85F));
        AdvancedPartDefinition tail1 = body.addOrReplaceChild("tail1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.3F, 10.9F, -0.8727F, 0.0F, 0.0F));
        AdvancedPartDefinition cube_r12 = tail1.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(55, 14).addBox(-1.0F, -7.0F, 0.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.5F, -0.5F, -0.5F, -1.5708F, 0.0F, 0.0F));
        AdvancedPartDefinition tail2 = tail1.addOrReplaceChild("tail2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 6.4F, -0.2618F, 0.0F, 0.0F));
        AdvancedPartDefinition cube_r13 = tail2.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(50, 14).addBox(-0.5F, -5.0F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));
        AdvancedPartDefinition leftbacklegtop = body.addOrReplaceChild("leftbacklegtop", CubeListBuilder.create().texOffs(35, 54).addBox(-1.0154F, -0.9631F, -1.171F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 1.5F, 10.0F, -0.0873F, -0.1745F, -0.0218F));
        AdvancedPartDefinition leftbacklegmid = leftbacklegtop.addOrReplaceChild("leftbacklegmid", CubeListBuilder.create().texOffs(43, 55).addBox(-1.0F, -0.75F, 0.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.2654F, 6.2869F, 0.329F));
        AdvancedPartDefinition leftbacklegpaw = leftbacklegmid.addOrReplaceChild("leftbacklegpaw", CubeListBuilder.create().texOffs(22, 59).addBox(-1.5F, -1.035F, -2.035F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.075F, 0.95F, 0.2618F, 0.0F, 0.0F));
        AdvancedPartDefinition rightbacklegtop = body.addOrReplaceChild("rightbacklegtop", CubeListBuilder.create().texOffs(35, 54).mirror().addBox(-0.9846F, -0.9631F, -1.171F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.5F, 1.5F, 10.0F, -0.0873F, 0.1745F, 0.0218F));
        AdvancedPartDefinition rightbacklegmid = rightbacklegtop.addOrReplaceChild("rightbacklegmid", CubeListBuilder.create().texOffs(43, 55).mirror().addBox(-1.0F, -0.75F, 0.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.2654F, 6.2869F, 0.329F));
        AdvancedPartDefinition rightbacklegpaw = rightbacklegmid.addOrReplaceChild("rightbacklegpaw", CubeListBuilder.create().texOffs(22, 59).mirror().addBox(-1.5F, -1.035F, -2.035F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 6.075F, 0.95F, 0.2618F, 0.0F, 0.0F));
        AdvancedPartDefinition leftfrontlegtop = body.addOrReplaceChild("leftfrontlegtop", CubeListBuilder.create().texOffs(0, 52).addBox(-0.9137F, -2.4941F, -1.8879F, 2.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 4.0F, -3.0F, -0.2618F, 0.0436F, 0.0F));
        AdvancedPartDefinition leftfrontlegmid = leftfrontlegtop.addOrReplaceChild("leftfrontlegmid", CubeListBuilder.create().texOffs(13, 53).addBox(-1.1F, -1.0F, 0.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0863F, 4.5059F, 1.1121F, 0.1745F, 0.0F, 0.0F));
        AdvancedPartDefinition leftfrontlegpaw = leftfrontlegmid.addOrReplaceChild("leftfrontlegpaw", CubeListBuilder.create().texOffs(22, 59).addBox(-1.5872F, -1.1761F, -1.9962F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, 7.7F, 0.95F, 0.2618F, 0.0F, 0.0F));
        AdvancedPartDefinition rightfrontlegtop = body.addOrReplaceChild("rightfrontlegtop", CubeListBuilder.create().texOffs(0, 52).mirror().addBox(-1.0863F, -2.4941F, -1.8879F, 2.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 4.0F, -3.0F, -0.2618F, -0.0436F, 0.0F));
        AdvancedPartDefinition rightfrontlegmid = rightfrontlegtop.addOrReplaceChild("rightfrontlegmid", CubeListBuilder.create().texOffs(13, 53).mirror().addBox(-0.9F, -1.0F, 0.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.0863F, 4.5059F, 1.1121F, 0.1745F, 0.0F, 0.0F));
        AdvancedPartDefinition rightfrontlegpaw = rightfrontlegmid.addOrReplaceChild("rightfrontlegpaw", CubeListBuilder.create().texOffs(22, 59).mirror().addBox(-1.4128F, -1.1761F, -1.9962F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.1F, 7.7F, 0.95F, 0.2618F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition.overwriteRootChildren(partdefinition), 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
    {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.animate(entity.walkState, ageInTicks, 1.0F);
        this.animate(entity.angleState, ageInTicks, 1.0F);
    }

    @Override
    public AdvancedModelPart root()
    {
        return this.body;
    }
}