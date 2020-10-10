package andrews.pandoras_creatures.tile_entities.model.pandoric_shard.gears;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * GearModel - andrew0030
 * Created using Tabula 7.1.0
 */
@OnlyIn(Dist.CLIENT)
public class BigGearModel
{
    public ModelRenderer center;
    public ModelRenderer rim;
    public ModelRenderer center_detail;
    public ModelRenderer center_detail_1;
    public ModelRenderer center_detail_2;
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

    public BigGearModel()
    {
    	int[] textureSize = {32, 32};
        this.rim_7 = new ModelRenderer(textureSize[0], textureSize[1], 0, 8);
        this.rim_7.setRotationPoint(3.0F, 0.0F, -0.01F);
        this.rim_7.addBox(0.0F, -1.0F, 0.0F, 3, 1, 2, 0.0F);
        this.setRotateAngle(rim_7, 0.0F, 0.0F, -0.7853981633974483F);
        this.tooth_1 = new ModelRenderer(textureSize[0], textureSize[1], 11, 26);
        this.tooth_1.setRotationPoint(1.0F, 0.0F, 0.0F);
        this.tooth_1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.tooth_6 = new ModelRenderer(textureSize[0], textureSize[1], 11, 11);
        this.tooth_6.setRotationPoint(1.0F, 0.0F, 0.0F);
        this.tooth_6.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.center_detail = new ModelRenderer(textureSize[0], textureSize[1], 20, 23);
        this.center_detail.setRotationPoint(0.0F, 0.0F, -0.3F);
        this.center_detail.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 1, 0.0F);
        this.setRotateAngle(center_detail, 0.0F, 0.0F, 0.7853981633974483F);
        this.rim_1 = new ModelRenderer(textureSize[0], textureSize[1], 0, 26);
        this.rim_1.setRotationPoint(3.0F, 1.0F, 0.01F);
        this.rim_1.addBox(0.0F, -1.0F, 0.0F, 3, 1, 2, 0.0F);
        this.setRotateAngle(rim_1, 0.0F, 0.0F, -0.7853981633974483F);
        this.tooth = new ModelRenderer(textureSize[0], textureSize[1], 11, 29);
        this.tooth.setRotationPoint(1.0F, 1.0F, 0.0F);
        this.tooth.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.center = new ModelRenderer(textureSize[0], textureSize[1], 20, 26);
        this.center.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.center.addBox(-2.5F, -2.5F, -0.5F, 5, 5, 1, 0.0F);
        this.tooth_7 = new ModelRenderer(textureSize[0], textureSize[1], 11, 8);
        this.tooth_7.setRotationPoint(1.0F, 0.0F, 0.0F);
        this.tooth_7.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.center_detail_1 = new ModelRenderer(textureSize[0], textureSize[1], 26, 23);
        this.center_detail_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.center_detail_1.addBox(-1.0F, -1.0F, -0.7F, 2, 2, 1, 0.0F);
        this.setRotateAngle(center_detail_1, 0.0F, 0.0F, 0.7853981633974483F);
        this.rim_3 = new ModelRenderer(textureSize[0], textureSize[1], 0, 20);
        this.rim_3.setRotationPoint(3.0F, 0.0F, 0.01F);
        this.rim_3.addBox(0.0F, -1.0F, 0.0F, 3, 1, 2, 0.0F);
        this.setRotateAngle(rim_3, 0.0F, 0.0F, -0.7853981633974483F);
        this.tooth_4 = new ModelRenderer(textureSize[0], textureSize[1], 11, 17);
        this.tooth_4.setRotationPoint(1.0F, 0.0F, 0.0F);
        this.tooth_4.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.tooth_3 = new ModelRenderer(textureSize[0], textureSize[1], 11, 20);
        this.tooth_3.setRotationPoint(1.0F, 0.0F, 0.0F);
        this.tooth_3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.rim_6 = new ModelRenderer(textureSize[0], textureSize[1], 0, 11);
        this.rim_6.setRotationPoint(3.0F, 0.0F, -0.01F);
        this.rim_6.addBox(0.0F, -1.0F, 0.0F, 3, 1, 2, 0.0F);
        this.setRotateAngle(rim_6, 0.0F, 0.0F, -0.7853981633974483F);
        this.rim_2 = new ModelRenderer(textureSize[0], textureSize[1], 0, 23);
        this.rim_2.setRotationPoint(3.0F, 0.0F, 0.01F);
        this.rim_2.addBox(0.0F, -1.0F, 0.0F, 3, 1, 2, 0.0F);
        this.setRotateAngle(rim_2, 0.0F, 0.0F, -0.7853981633974483F);
        this.center_detail_2 = new ModelRenderer(textureSize[0], textureSize[1], 23, 20);
        this.center_detail_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.center_detail_2.addBox(-0.5F, -0.5F, -1.0F, 1, 1, 2, 0.0F);
        this.rim_5 = new ModelRenderer(textureSize[0], textureSize[1], 0, 14);
        this.rim_5.setRotationPoint(3.0F, 0.0F, -0.01F);
        this.rim_5.addBox(0.0F, -1.0F, 0.0F, 3, 1, 2, 0.0F);
        this.setRotateAngle(rim_5, 0.0F, 0.0F, -0.7853981633974483F);
        this.tooth_2 = new ModelRenderer(textureSize[0], textureSize[1], 11, 23);
        this.tooth_2.setRotationPoint(1.0F, 0.0F, 0.0F);
        this.tooth_2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.rim = new ModelRenderer(textureSize[0], textureSize[1], 0, 29);
        this.rim.setRotationPoint(-1.5F, 2.6F, -1.0F);
        this.rim.addBox(0.0F, 0.0F, 0.0F, 3, 1, 2, 0.0F);
        this.rim_4 = new ModelRenderer(textureSize[0], textureSize[1], 0, 17);
        this.rim_4.setRotationPoint(3.0F, 0.0F, 0.01F);
        this.rim_4.addBox(0.0F, -1.0F, 0.0F, 3, 1, 2, 0.0F);
        this.setRotateAngle(rim_4, 0.0F, 0.0F, -0.7853981633974483F);
        this.tooth_5 = new ModelRenderer(textureSize[0], textureSize[1], 11, 14);
        this.tooth_5.setRotationPoint(1.0F, 0.0F, 0.0F);
        this.tooth_5.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.rim_6.addChild(this.rim_7);
        this.rim_1.addChild(this.tooth_1);
        this.rim_6.addChild(this.tooth_6);
        this.center.addChild(this.center_detail);
        this.rim.addChild(this.rim_1);
        this.rim.addChild(this.tooth);
        this.rim_7.addChild(this.tooth_7);
        this.center.addChild(this.center_detail_1);
        this.rim_2.addChild(this.rim_3);
        this.rim_4.addChild(this.tooth_4);
        this.rim_3.addChild(this.tooth_3);
        this.rim_5.addChild(this.rim_6);
        this.rim_1.addChild(this.rim_2);
        this.center.addChild(this.center_detail_2);
        this.rim_4.addChild(this.rim_5);
        this.rim_2.addChild(this.tooth_2);
        this.center.addChild(this.rim);
        this.rim_3.addChild(this.rim_4);
        this.rim_5.addChild(this.tooth_5);
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