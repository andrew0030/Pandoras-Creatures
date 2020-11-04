package andrews.pandoras_creatures.tile_entities.model.pandoric_shard;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * CoreModel - andrew0030
 * Created using Tabula 7.1.0
 */
@OnlyIn(Dist.CLIENT)
public class PandoricShardMediumBase2Model
{
	public ModelRenderer base;
    public ModelRenderer solid_box;
    public ModelRenderer wall_side;
    public ModelRenderer center;
    public ModelRenderer wall_back;
    public ModelRenderer box;
    public ModelRenderer rod;
    public ModelRenderer pipe;
    public ModelRenderer pipe_1;
    public ModelRenderer pipe_2;
    public ModelRenderer pipe_3;
    public ModelRenderer decoration;
    public ModelRenderer decoration_1;
    public ModelRenderer decoration_2;
    public ModelRenderer decoration_3;
    public ModelRenderer wall_back2;
    public ModelRenderer pipe_4;
    public ModelRenderer rod_1;

    public PandoricShardMediumBase2Model()
    {
    	int[] textureSize = {128, 64};
        this.solid_box = new ModelRenderer(textureSize[0], textureSize[1], 9, 18);
        this.solid_box.setRotationPoint(-2.0F, -3.0F, -7.0F);
        this.solid_box.addBox(0.0F, 0.0F, 0.0F, 9, 3, 11, 0.0F);
        this.center = new ModelRenderer(textureSize[0], textureSize[1], 0, 17);
        this.center.setRotationPoint(1.0F, -3.0F, -3.0F);
        this.center.addBox(-2.5F, -2.0F, -2.5F, 5, 2, 5, 0.0F);
        this.decoration_1 = new ModelRenderer(textureSize[0], textureSize[1], 0, 7);
        this.decoration_1.setRotationPoint(2.5F, 0.0F, 0.0F);
        this.decoration_1.addBox(-1.0F, -4.0F, -1.0F, 1, 4, 2, 0.0F);
        this.setRotateAngle(decoration_1, 0.0F, 0.0F, 0.4886921905584123F);
        this.rod = new ModelRenderer(textureSize[0], textureSize[1], 27, 34);
        this.rod.setRotationPoint(-6.7F, 0.0F, 2.0F);
        this.rod.addBox(-1.0F, -5.0F, -1.0F, 1, 5, 1, 0.0F);
        this.setRotateAngle(rod, 0.15978369557171598F, 0.0F, -0.09832842804413294F);
        this.pipe_2 = new ModelRenderer(textureSize[0], textureSize[1], 54, 27);
        this.pipe_2.setRotationPoint(0.0F, 0.0F, 6.5F);
        this.pipe_2.addBox(-1.8F, -1.5F, 0.0F, 3, 3, 1, 0.0F);
        this.pipe_3 = new ModelRenderer(textureSize[0], textureSize[1], 39, 18);
        this.pipe_3.setRotationPoint(1.0F, -1.0F, 3.0F);
        this.pipe_3.addBox(-0.3F, 0.0F, -1.0F, 3, 2, 2, 0.0F);
        this.wall_back = new ModelRenderer(textureSize[0], textureSize[1], 66, 0);
        this.wall_back.setRotationPoint(0.0F, 0.0F, 7.0F);
        this.wall_back.addBox(0.0F, -12.0F, 0.0F, 7, 6, 1, 0.0F);
        this.setRotateAngle(wall_back, 0.024609142453120045F, -0.012217304763960306F, 0.0F);
        this.pipe = new ModelRenderer(textureSize[0], textureSize[1], 38, 22);
        this.pipe.setRotationPoint(-4.5F, 0.5F, -1.0F);
        this.pipe.addBox(-0.3F, 0.0F, 0.0F, 2, 2, 11, 0.0F);
        this.decoration_2 = new ModelRenderer(textureSize[0], textureSize[1], 7, 0);
        this.decoration_2.setRotationPoint(0.0F, 0.0F, -2.0F);
        this.decoration_2.addBox(-1.0F, -4.0F, -0.5F, 2, 4, 1, 0.0F);
        this.setRotateAngle(decoration_2, 0.4886921905584123F, 0.0F, 0.0F);
        this.pipe_4 = new ModelRenderer(textureSize[0], textureSize[1], 39, 22);
        this.pipe_4.setRotationPoint(0.9F, 5.0F, 0.0F);
        this.pipe_4.addBox(0.5F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(pipe_4, -0.4363323129985824F, 0.0F, 0.0F);
        this.wall_side = new ModelRenderer(textureSize[0], textureSize[1], 0, 32);
        this.wall_side.setRotationPoint(7.0F, -15.0F, 0.0F);
        this.wall_side.addBox(0.0F, 0.0F, -8.0F, 1, 15, 16, 0.0F);
        this.decoration = new ModelRenderer(textureSize[0], textureSize[1], 0, 0);
        this.decoration.setRotationPoint(-2.5F, 0.0F, 0.0F);
        this.decoration.addBox(0.0F, -4.0F, -1.0F, 1, 4, 2, 0.0F);
        this.setRotateAngle(decoration, 0.0F, 0.0F, -0.4886921905584123F);
        this.pipe_1 = new ModelRenderer(textureSize[0], textureSize[1], 54, 18);
        this.pipe_1.setRotationPoint(1.0F, 1.0F, 0.5F);
        this.pipe_1.addBox(-1.8F, -1.5F, 0.0F, 3, 3, 1, 0.0F);
        this.rod_1 = new ModelRenderer(textureSize[0], textureSize[1], 22, 34);
        this.rod_1.setRotationPoint(-1.1F, 0.3F, 0.4F);
        this.rod_1.addBox(0.0F, -3.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(rod_1, -0.27035150113392165F, 0.0F, 0.0F);
        this.base = new ModelRenderer(textureSize[0], textureSize[1], 0, 0);
        this.base.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.base.addBox(-8.0F, 0.0F, -8.0F, 16, 1, 16, 0.0F);
        this.decoration_3 = new ModelRenderer(textureSize[0], textureSize[1], 7, 6);
        this.decoration_3.setRotationPoint(0.0F, 0.0F, 2.5F);
        this.decoration_3.addBox(-1.0F, -4.0F, -1.0F, 2, 4, 1, 0.0F);
        this.setRotateAngle(decoration_3, -0.4886921905584123F, 0.0F, 0.0F);
        this.box = new ModelRenderer(textureSize[0], textureSize[1], 26, 35);
        this.box.setRotationPoint(-3.0F, -11.0F, 2.0F);
        this.box.addBox(0.0F, 0.0F, 0.0F, 10, 6, 5, 0.0F);
        this.wall_back2 = new ModelRenderer(textureSize[0], textureSize[1], 48, 0);
        this.wall_back2.setRotationPoint(-8.0F, 0.0F, 0.0F);
        this.wall_back2.addBox(0.0F, -15.0F, 0.0F, 8, 15, 1, 0.0F);
        this.setRotateAngle(wall_back2, 0.0F, 0.036826447217080345F, 0.0F);
        this.base.addChild(this.solid_box);
        this.base.addChild(this.center);
        this.center.addChild(this.decoration_1);
        this.base.addChild(this.rod);
        this.pipe_1.addChild(this.pipe_2);
        this.pipe_2.addChild(this.pipe_3);
        this.base.addChild(this.wall_back);
        this.solid_box.addChild(this.pipe);
        this.center.addChild(this.decoration_2);
        this.box.addChild(this.pipe_4);
        this.base.addChild(this.wall_side);
        this.center.addChild(this.decoration);
        this.pipe.addChild(this.pipe_1);
        this.rod.addChild(this.rod_1);
        this.center.addChild(this.decoration_3);
        this.base.addChild(this.box);
        this.wall_back.addChild(this.wall_back2);
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
