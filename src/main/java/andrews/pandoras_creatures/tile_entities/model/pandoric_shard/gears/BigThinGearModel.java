package andrews.pandoras_creatures.tile_entities.model.pandoric_shard.gears;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * GearModel - andrew0030
 * Created using Tabula 7.1.0
 */
@OnlyIn(Dist.CLIENT)
public class BigThinGearModel
{
	public ModelRenderer base;
    public ModelRenderer rim;
    public ModelRenderer base_1;
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
    public ModelRenderer detail;
    public ModelRenderer detail_1;
    public ModelRenderer detail_2;

    public BigThinGearModel()
    {
    	int[] textureSize = {32, 32};
        this.base = new ModelRenderer(textureSize[0], textureSize[1], 22, 22);
        this.base.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.base.addBox(-2.5F, -2.5F, 0.2F, 5, 5, 0, 0.0F);
        this.tooth_2 = new ModelRenderer(textureSize[0], textureSize[1], 9, 26);
        this.tooth_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tooth_2.addBox(1.0F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rim_7 = new ModelRenderer(textureSize[0], textureSize[1], 0, 16);
        this.rim_7.setRotationPoint(3.0F, 0.0F, 0.01F);
        this.rim_7.addBox(0.0F, -1.0F, -0.5F, 3, 1, 1, 0.0F);
        this.setRotateAngle(rim_7, 0.0F, 0.0F, -0.7853981633974483F);
        this.tooth_1 = new ModelRenderer(textureSize[0], textureSize[1], 9, 28);
        this.tooth_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tooth_1.addBox(1.0F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
        this.tooth_5 = new ModelRenderer(textureSize[0], textureSize[1], 9, 20);
        this.tooth_5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tooth_5.addBox(1.0F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
        this.detail = new ModelRenderer(textureSize[0], textureSize[1], 26, 19);
        this.detail.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.detail.addBox(-1.0F, -1.0F, -0.5F, 2, 2, 1, 0.0F);
        this.setRotateAngle(detail, 3.141592653589793F, 0.0F, 0.7853981633974483F);
        this.rim_3 = new ModelRenderer(textureSize[0], textureSize[1], 0, 24);
        this.rim_3.setRotationPoint(3.0F, 0.0F, -0.01F);
        this.rim_3.addBox(0.0F, -1.0F, -0.5F, 3, 1, 1, 0.0F);
        this.setRotateAngle(rim_3, 0.0F, 0.0F, -0.7853981633974483F);
        this.detail_1 = new ModelRenderer(textureSize[0], textureSize[1], 22, 18);
        this.detail_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.detail_1.addBox(-0.5F, -0.5F, -0.4F, 1, 1, 1, 0.0F);
        this.setRotateAngle(detail_1, 0.0F, 0.0F, 0.7853981633974483F);
        this.rim_1 = new ModelRenderer(textureSize[0], textureSize[1], 0, 28);
        this.rim_1.setRotationPoint(1.5F, 0.5F, -0.01F);
        this.rim_1.addBox(0.0F, -1.0F, -0.5F, 3, 1, 1, 0.0F);
        this.setRotateAngle(rim_1, 0.0F, 0.0F, -0.7853981633974483F);
        this.tooth = new ModelRenderer(textureSize[0], textureSize[1], 9, 30);
        this.tooth.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tooth.addBox(-0.5F, 0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.tooth_3 = new ModelRenderer(textureSize[0], textureSize[1], 9, 24);
        this.tooth_3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tooth_3.addBox(1.0F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rim_6 = new ModelRenderer(textureSize[0], textureSize[1], 0, 18);
        this.rim_6.setRotationPoint(3.0F, 0.0F, 0.01F);
        this.rim_6.addBox(0.0F, -1.0F, -0.5F, 3, 1, 1, 0.0F);
        this.setRotateAngle(rim_6, 0.0F, 0.0F, -0.7853981633974483F);
        this.tooth_7 = new ModelRenderer(textureSize[0], textureSize[1], 9, 16);
        this.tooth_7.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tooth_7.addBox(1.0F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rim_2 = new ModelRenderer(textureSize[0], textureSize[1], 0, 26);
        this.rim_2.setRotationPoint(3.0F, 0.0F, -0.01F);
        this.rim_2.addBox(0.0F, -1.0F, -0.5F, 3, 1, 1, 0.0F);
        this.setRotateAngle(rim_2, 0.0F, 0.0F, -0.7853981633974483F);
        this.tooth_4 = new ModelRenderer(textureSize[0], textureSize[1], 9, 22);
        this.tooth_4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tooth_4.addBox(1.0F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
        this.tooth_6 = new ModelRenderer(textureSize[0], textureSize[1], 9, 18);
        this.tooth_6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tooth_6.addBox(1.0F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
        this.base_1 = new ModelRenderer(textureSize[0], textureSize[1], 22, 27);
        this.base_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.base_1.addBox(-2.5F, -2.5F, 0.2F, 5, 5, 0, 0.0F);
        this.setRotateAngle(base_1, 0.0F, 3.141592653589793F, 0.0F);
        this.rim_4 = new ModelRenderer(textureSize[0], textureSize[1], 0, 22);
        this.rim_4.setRotationPoint(3.0F, 0.0F, -0.01F);
        this.rim_4.addBox(0.0F, -1.0F, -0.5F, 3, 1, 1, 0.0F);
        this.setRotateAngle(rim_4, 0.0F, 0.0F, -0.7853981633974483F);
        this.rim = new ModelRenderer(textureSize[0], textureSize[1], 0, 30);
        this.rim.setRotationPoint(0.0F, 3.1F, 0.0F);
        this.rim.addBox(-1.5F, -0.5F, -0.5F, 3, 1, 1, 0.0F);
        this.rim_5 = new ModelRenderer(textureSize[0], textureSize[1], 0, 20);
        this.rim_5.setRotationPoint(3.0F, 0.0F, 0.01F);
        this.rim_5.addBox(0.0F, -1.0F, -0.5F, 3, 1, 1, 0.0F);
        this.setRotateAngle(rim_5, 0.0F, 0.0F, -0.7853981633974483F);
        this.detail_2 = new ModelRenderer(textureSize[0], textureSize[1], 22, 20);
        this.detail_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.detail_2.addBox(-0.5F, -0.5F, -0.6F, 1, 1, 1, 0.0F);
        this.setRotateAngle(detail_2, 0.0F, 0.0F, 0.7853981633974483F);
        this.rim_2.addChild(this.tooth_2);
        this.rim_6.addChild(this.rim_7);
        this.rim_1.addChild(this.tooth_1);
        this.rim_5.addChild(this.tooth_5);
        this.base_1.addChild(this.detail);
        this.rim_2.addChild(this.rim_3);
        this.detail.addChild(this.detail_1);
        this.rim.addChild(this.rim_1);
        this.rim.addChild(this.tooth);
        this.rim_3.addChild(this.tooth_3);
        this.rim_5.addChild(this.rim_6);
        this.rim_7.addChild(this.tooth_7);
        this.rim_1.addChild(this.rim_2);
        this.rim_4.addChild(this.tooth_4);
        this.rim_6.addChild(this.tooth_6);
        this.base.addChild(this.base_1);
        this.rim_3.addChild(this.rim_4);
        this.base.addChild(this.rim);
        this.rim_4.addChild(this.rim_5);
        this.detail.addChild(this.detail_2);
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
