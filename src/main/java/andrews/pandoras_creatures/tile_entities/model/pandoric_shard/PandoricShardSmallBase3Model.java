package andrews.pandoras_creatures.tile_entities.model.pandoric_shard;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * CoreModel - andrew0030
 * Created using Tabula 7.1.0
 */
@OnlyIn(Dist.CLIENT)
public class PandoricShardSmallBase3Model
{
	public ModelRenderer base;
    public ModelRenderer box;
    public ModelRenderer box_1;
    public ModelRenderer rod;
    public ModelRenderer plate;
    public ModelRenderer holder;
    public ModelRenderer box_2;
    public ModelRenderer pipe;
    public ModelRenderer pipe_1;
    public ModelRenderer pipe_2;
    public ModelRenderer pipe_3;
    public ModelRenderer pipe_4;
    public ModelRenderer rod_1;
    public ModelRenderer plate_top;

    public PandoricShardSmallBase3Model()
    {
    	int[] textureSize = {64, 64};
        this.box = new ModelRenderer(textureSize[0], textureSize[1], 0, 17);
        this.box.setRotationPoint(-7.0F, -3.0F, -3.0F);
        this.box.addBox(0.0F, 0.0F, 0.0F, 7, 3, 10, 0.0F);
        this.pipe = new ModelRenderer(textureSize[0], textureSize[1], 38, 22);
        this.pipe.setRotationPoint(-7.7F, 3.5F, -5.0F);
        this.pipe.addBox(0.0F, 0.0F, 0.0F, 2, 2, 11, 0.0F);
        this.setRotateAngle(pipe, 0.0F, 1.5707963267948966F, 0.0F);
        this.plate_top = new ModelRenderer(textureSize[0], textureSize[1], 0, 30);
        this.plate_top.setRotationPoint(1.0F, -6.0F, -1.0F);
        this.plate_top.addBox(0.0F, -2.0F, 0.0F, 3, 2, 1, 0.0F);
        this.setRotateAngle(plate_top, -0.22759093446006054F, 0.0F, 0.0F);
        this.holder = new ModelRenderer(textureSize[0], textureSize[1], 0, 41);
        this.holder.setRotationPoint(1.0F, -1.0F, 4.0F);
        this.holder.addBox(0.0F, 0.0F, 0.0F, 5, 1, 5, 0.0F);
        this.rod_1 = new ModelRenderer(textureSize[0], textureSize[1], 22, 34);
        this.rod_1.setRotationPoint(0.01F, -6.0F, -1.0F);
        this.rod_1.addBox(-1.0F, -5.0F, 0.0F, 1, 5, 1, 0.0F);
        this.setRotateAngle(rod_1, -0.24626595745639987F, 0.0F, -0.136659280431156F);
        this.base = new ModelRenderer(textureSize[0], textureSize[1], 0, 0);
        this.base.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.base.addBox(-8.0F, 0.0F, -8.0F, 16, 1, 16, 0.0F);
        this.pipe_1 = new ModelRenderer(textureSize[0], textureSize[1], 54, 18);
        this.pipe_1.setRotationPoint(1.0F, 1.0F, 0.5F);
        this.pipe_1.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 1, 0.0F);
        this.rod = new ModelRenderer(textureSize[0], textureSize[1], 17, 33);
        this.rod.setRotationPoint(7.5F, 0.0F, -6.1F);
        this.rod.addBox(-1.0F, -6.0F, -1.0F, 1, 6, 1, 0.0F);
        this.setRotateAngle(rod, 0.091106186954104F, 0.045553093477052F, -0.045553093477052F);
        this.box_2 = new ModelRenderer(textureSize[0], textureSize[1], 0, 0);
        this.box_2.setRotationPoint(0.0F, 2.0F, 4.0F);
        this.box_2.addBox(0.0F, 0.0F, 0.0F, 6, 4, 2, 0.0F);
        this.pipe_4 = new ModelRenderer(textureSize[0], textureSize[1], 54, 22);
        this.pipe_4.setRotationPoint(2.0F, -0.5F, -1.5F);
        this.pipe_4.addBox(0.0F, 0.0F, 0.0F, 1, 3, 3, 0.0F);
        this.box_1 = new ModelRenderer(textureSize[0], textureSize[1], 0, 48);
        this.box_1.setRotationPoint(1.0F, -6.0F, 0.0F);
        this.box_1.addBox(0.0F, 0.0F, 0.0F, 4, 6, 4, 0.0F);
        this.plate = new ModelRenderer(textureSize[0], textureSize[1], 0, 33);
        this.plate.setRotationPoint(6.5F, 0.0F, -5.7F);
        this.plate.addBox(0.0F, -6.0F, -1.0F, 7, 6, 1, 0.0F);
        this.setRotateAngle(plate, 0.05235987755982988F, -1.6144295580947547F, 0.0F);
        this.pipe_2 = new ModelRenderer(textureSize[0], textureSize[1], 54, 28);
        this.pipe_2.setRotationPoint(0.0F, 0.0F, 6.5F);
        this.pipe_2.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 1, 0.0F);
        this.pipe_3 = new ModelRenderer(textureSize[0], textureSize[1], 39, 18);
        this.pipe_3.setRotationPoint(-6.0F, -1.0F, 3.0F);
        this.pipe_3.addBox(0.0F, 0.0F, -1.0F, 5, 2, 2, 0.0F);
        this.base.addChild(this.box);
        this.box_1.addChild(this.pipe);
        this.plate.addChild(this.plate_top);
        this.box.addChild(this.holder);
        this.rod.addChild(this.rod_1);
        this.pipe.addChild(this.pipe_1);
        this.base.addChild(this.rod);
        this.box_1.addChild(this.box_2);
        this.pipe_3.addChild(this.pipe_4);
        this.base.addChild(this.box_1);
        this.base.addChild(this.plate);
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
