package andrews.pandoras_creatures.tile_entities.model.pandoric_shard;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * SmallPandoricShardBase - andrew0030
 * Created using Tabula 7.1.0
 */
@OnlyIn(Dist.CLIENT)
public class PandoricShardSmallBaseModel
{
    public ModelRenderer base;
    public ModelRenderer center;
    public ModelRenderer solid_box;
    public ModelRenderer rod;
    public ModelRenderer plate;
    public ModelRenderer decoration;
    public ModelRenderer decoration_1;
    public ModelRenderer decoration_2;
    public ModelRenderer decoration_3;
    public ModelRenderer pipe;
    public ModelRenderer pipe_1;
    public ModelRenderer pipe_2;
    public ModelRenderer pipe_3;
    public ModelRenderer rod_1;
    public ModelRenderer plate_top;

    public PandoricShardSmallBaseModel()
    {
    	int[] textureSize = {64, 64};
        this.plate_top = new ModelRenderer(textureSize[0], textureSize[1], 0, 29);
        this.plate_top.setRotationPoint(1.0F, -6.0F, -1.0F);
        this.plate_top.addBox(0.0F, -2.0F, 0.0F, 3, 2, 1, 0.0F);
        this.setRotateAngle(plate_top, -0.22759093446006054F, 0.0F, 0.0F);
        this.center = new ModelRenderer(textureSize[0], textureSize[1], 0, 17);
        this.center.setRotationPoint(0.0F, -3.0F, 0.0F);
        this.center.addBox(-2.5F, -2.0F, -2.5F, 5, 2, 5, 0.0F);
        this.base = new ModelRenderer(textureSize[0], textureSize[1], 0, 0);
        this.base.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.base.addBox(-8.0F, 0.0F, -8.0F, 16, 1, 16, 0.0F);
        this.pipe_1 = new ModelRenderer(textureSize[0], textureSize[1], 54, 18);
        this.pipe_1.setRotationPoint(1.0F, 1.0F, 0.5F);
        this.pipe_1.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 1, 0.0F);
        this.decoration_2 = new ModelRenderer(textureSize[0], textureSize[1], 7, 0);
        this.decoration_2.setRotationPoint(0.0F, 0.0F, -2.0F);
        this.decoration_2.addBox(-1.0F, -4.0F, -0.5F, 2, 4, 1, 0.0F);
        this.setRotateAngle(decoration_2, 0.4886921905584123F, 0.0F, 0.0F);
        this.rod_1 = new ModelRenderer(textureSize[0], textureSize[1], 22, 34);
        this.rod_1.setRotationPoint(0.01F, -6.0F, -1.0F);
        this.rod_1.addBox(-1.0F, -5.0F, 0.0F, 1, 5, 1, 0.0F);
        this.setRotateAngle(rod_1, -0.24626595745639987F, 0.0F, 0.0F);
        this.decoration_3 = new ModelRenderer(textureSize[0], textureSize[1], 7, 6);
        this.decoration_3.setRotationPoint(0.0F, 0.0F, 2.5F);
        this.decoration_3.addBox(-1.0F, -4.0F, -1.0F, 2, 4, 1, 0.0F);
        this.setRotateAngle(decoration_3, -0.4886921905584123F, 0.0F, 0.0F);
        this.pipe = new ModelRenderer(textureSize[0], textureSize[1], 38, 22);
        this.pipe.setRotationPoint(-4.5F, 0.5F, -1.0F);
        this.pipe.addBox(0.0F, 0.0F, 0.0F, 2, 2, 11, 0.0F);
        this.solid_box = new ModelRenderer(textureSize[0], textureSize[1], 9, 18);
        this.solid_box.setRotationPoint(-2.0F, -3.0F, -4.1F);
        this.solid_box.addBox(0.0F, 0.0F, 0.0F, 9, 3, 11, 0.0F);
        this.plate = new ModelRenderer(textureSize[0], textureSize[1], 0, 33);
        this.plate.setRotationPoint(-5.0F, 0.0F, 8.0F);
        this.plate.addBox(0.0F, -6.0F, -1.0F, 7, 6, 1, 0.0F);
        this.setRotateAngle(plate, 0.08203047484373349F, 0.045553093477052F, 0.0F);
        this.decoration = new ModelRenderer(textureSize[0], textureSize[1], 0, 0);
        this.decoration.setRotationPoint(-2.5F, 0.0F, 0.0F);
        this.decoration.addBox(0.0F, -4.0F, -1.0F, 1, 4, 2, 0.0F);
        this.setRotateAngle(decoration, 0.0F, 0.0F, -0.4886921905584123F);
        this.decoration_1 = new ModelRenderer(textureSize[0], textureSize[1], 0, 7);
        this.decoration_1.setRotationPoint(2.5F, 0.0F, 0.0F);
        this.decoration_1.addBox(-1.0F, -4.0F, -1.0F, 1, 4, 2, 0.0F);
        this.setRotateAngle(decoration_1, 0.0F, 0.0F, 0.4886921905584123F);
        this.rod = new ModelRenderer(textureSize[0], textureSize[1], 17, 33);
        this.rod.setRotationPoint(7.9F, 0.0F, 7.9F);
        this.rod.addBox(-1.0F, -6.0F, -1.0F, 1, 6, 1, 0.0F);
        this.setRotateAngle(rod, 0.08726646259971647F, 0.0F, 0.0F);
        this.pipe_2 = new ModelRenderer(textureSize[0], textureSize[1], 54, 27);
        this.pipe_2.setRotationPoint(0.0F, 0.0F, 6.5F);
        this.pipe_2.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 1, 0.0F);
        this.pipe_3 = new ModelRenderer(textureSize[0], textureSize[1], 39, 18);
        this.pipe_3.setRotationPoint(1.0F, -1.0F, 3.0F);
        this.pipe_3.addBox(0.0F, 0.0F, -1.0F, 3, 2, 2, 0.0F);
        this.plate.addChild(this.plate_top);
        this.base.addChild(this.center);
        this.pipe.addChild(this.pipe_1);
        this.center.addChild(this.decoration_2);
        this.rod.addChild(this.rod_1);
        this.center.addChild(this.decoration_3);
        this.solid_box.addChild(this.pipe);
        this.base.addChild(this.solid_box);
        this.base.addChild(this.plate);
        this.center.addChild(this.decoration);
        this.center.addChild(this.decoration_1);
        this.base.addChild(this.rod);
        this.pipe_1.addChild(this.pipe_2);
        this.pipe_2.addChild(this.pipe_3);
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