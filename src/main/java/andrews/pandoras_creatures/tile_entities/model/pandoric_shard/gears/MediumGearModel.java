package andrews.pandoras_creatures.tile_entities.model.pandoric_shard.gears;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * MediumGear - andrew0030
 * Created using Tabula 7.1.0
 */
@OnlyIn(Dist.CLIENT)
public class MediumGearModel
{
    public ModelRenderer base;
    public ModelRenderer rim;
    public ModelRenderer base_2;
    public ModelRenderer center;
    public ModelRenderer rim_1;
    public ModelRenderer tooth;
    public ModelRenderer rim_2;
    public ModelRenderer tooth_1;
    public ModelRenderer rim_3;
    public ModelRenderer tooth_2;
    public ModelRenderer rim_4;
    public ModelRenderer tooth_3;
    public ModelRenderer rim_5;
    public ModelRenderer tooth_4;
    public ModelRenderer rim_6;
    public ModelRenderer tooth_5;
    public ModelRenderer rim_7;
    public ModelRenderer tooth_6;
    public ModelRenderer tooth_7;

    public MediumGearModel()
    {
    	int[] textureSize = {16, 16};
        this.rim_3 = new ModelRenderer(textureSize[0], textureSize[1], 0, 8);
        this.rim_3.setRotationPoint(2.0F, 0.0F, 0.01F);
        this.rim_3.addBox(0.0F, -1.0F, -0.5F, 2, 1, 1, 0.0F);
        this.setRotateAngle(rim_3, 0.0F, 0.0F, -0.7853981633974483F);
        this.tooth_3 = new ModelRenderer(textureSize[0], textureSize[1], 6, 8);
        this.tooth_3.setRotationPoint(0.5F, 0.0F, -0.5F);
        this.tooth_3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.tooth = new ModelRenderer(textureSize[0], textureSize[1], 6, 14);
        this.tooth.setRotationPoint(0.5F, 0.0F, -0.5F);
        this.tooth.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.base_2 = new ModelRenderer(textureSize[0], textureSize[1], 10, 13);
        this.base_2.setRotationPoint(0.0F, 0.0F, -0.2F);
        this.base_2.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 0, 0.0F);
        this.rim_6 = new ModelRenderer(textureSize[0], textureSize[1], 0, 2);
        this.rim_6.setRotationPoint(2.0F, 0.0F, -0.01F);
        this.rim_6.addBox(0.0F, -1.0F, -0.5F, 2, 1, 1, 0.0F);
        this.setRotateAngle(rim_6, 0.0F, 0.0F, -0.7853981633974483F);
        this.rim = new ModelRenderer(textureSize[0], textureSize[1], 0, 14);
        this.rim.setRotationPoint(-1.0F, 2.4F, 0.0F);
        this.rim.addBox(0.0F, -1.0F, -0.5F, 2, 1, 1, 0.0F);
        this.rim_1 = new ModelRenderer(textureSize[0], textureSize[1], 0, 12);
        this.rim_1.setRotationPoint(2.0F, 0.0F, 0.01F);
        this.rim_1.addBox(0.0F, -1.0F, -0.5F, 2, 1, 1, 0.0F);
        this.setRotateAngle(rim_1, 0.0F, 0.0F, -0.7853981633974483F);
        this.tooth_4 = new ModelRenderer(textureSize[0], textureSize[1], 6, 6);
        this.tooth_4.setRotationPoint(0.5F, 0.0F, 0.0F);
        this.tooth_4.addBox(0.0F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rim_5 = new ModelRenderer(textureSize[0], textureSize[1], 0, 4);
        this.rim_5.setRotationPoint(2.0F, 0.0F, -0.01F);
        this.rim_5.addBox(0.0F, -1.0F, -0.5F, 2, 1, 1, 0.0F);
        this.setRotateAngle(rim_5, 0.0F, 0.0F, -0.7853981633974483F);
        this.center = new ModelRenderer(textureSize[0], textureSize[1], 12, 8);
        this.center.setRotationPoint(0.0F, 0.0F, 0.5F);
        this.center.addBox(-0.5F, -0.5F, -1.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(center, 0.0F, 0.0F, 0.7853981633974483F);
        this.tooth_2 = new ModelRenderer(textureSize[0], textureSize[1], 6, 10);
        this.tooth_2.setRotationPoint(0.5F, 0.0F, 0.0F);
        this.tooth_2.addBox(0.0F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rim_7 = new ModelRenderer(textureSize[0], textureSize[1], 0, 0);
        this.rim_7.setRotationPoint(2.0F, 0.0F, -0.01F);
        this.rim_7.addBox(0.0F, -1.0F, -0.5F, 2, 1, 1, 0.0F);
        this.setRotateAngle(rim_7, 0.0F, 0.0F, -0.7853981633974483F);
        this.tooth_6 = new ModelRenderer(textureSize[0], textureSize[1], 6, 2);
        this.tooth_6.setRotationPoint(0.5F, 0.0F, 0.0F);
        this.tooth_6.addBox(0.0F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
        this.tooth_1 = new ModelRenderer(textureSize[0], textureSize[1], 6, 12);
        this.tooth_1.setRotationPoint(0.5F, 0.0F, 0.0F);
        this.tooth_1.addBox(0.0F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
        this.base = new ModelRenderer(textureSize[0], textureSize[1], 10, 10);
        this.base.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.base.addBox(-1.5F, -1.5F, 0.3F, 3, 3, 0, 0.0F);
        this.tooth_5 = new ModelRenderer(textureSize[0], textureSize[1], 6, 4);
        this.tooth_5.setRotationPoint(0.5F, 0.0F, 0.0F);
        this.tooth_5.addBox(0.0F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
        this.tooth_7 = new ModelRenderer(textureSize[0], textureSize[1], 0, 0);
        this.tooth_7.setRotationPoint(0.5F, 0.0F, 0.0F);
        this.tooth_7.addBox(0.0F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rim_2 = new ModelRenderer(textureSize[0], textureSize[1], 0, 10);
        this.rim_2.setRotationPoint(2.0F, 0.0F, 0.01F);
        this.rim_2.addBox(0.0F, -1.0F, -0.5F, 2, 1, 1, 0.0F);
        this.setRotateAngle(rim_2, 0.0F, 0.0F, -0.7853981633974483F);
        this.rim_4 = new ModelRenderer(textureSize[0], textureSize[1], 0, 6);
        this.rim_4.setRotationPoint(2.0F, 0.0F, 0.01F);
        this.rim_4.addBox(0.0F, -1.0F, -0.5F, 2, 1, 1, 0.0F);
        this.setRotateAngle(rim_4, 0.0F, 0.0F, -0.7853981633974483F);
        this.rim_2.addChild(this.rim_3);
        this.rim_3.addChild(this.tooth_3);
        this.rim.addChild(this.tooth);
        this.base.addChild(this.base_2);
        this.rim_5.addChild(this.rim_6);
        this.base.addChild(this.rim);
        this.rim.addChild(this.rim_1);
        this.rim_4.addChild(this.tooth_4);
        this.rim_4.addChild(this.rim_5);
        this.base.addChild(this.center);
        this.rim_2.addChild(this.tooth_2);
        this.rim_6.addChild(this.rim_7);
        this.rim_6.addChild(this.tooth_6);
        this.rim_1.addChild(this.tooth_1);
        this.rim_5.addChild(this.tooth_5);
        this.rim_7.addChild(this.tooth_7);
        this.rim_1.addChild(this.rim_2);
        this.rim_3.addChild(this.rim_4);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}