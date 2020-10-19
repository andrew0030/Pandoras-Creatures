package andrews.pandoras_creatures.tile_entities.model.pandoric_shard;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * SmallPandoricShard4 - andrew0030
 * Created using Tabula 7.1.0
 */
@OnlyIn(Dist.CLIENT)
public class PandoricShardSmallBase4Model
{
    public ModelRenderer base;
    public ModelRenderer box;
    public ModelRenderer box_1;
    public ModelRenderer pipe;
    public ModelRenderer center;
    public ModelRenderer decoration;
    public ModelRenderer decoration_1;
    public ModelRenderer decoration_2;
    public ModelRenderer decoration_3;
    public ModelRenderer pipe_1;
    public ModelRenderer pipe_2;

    public PandoricShardSmallBase4Model()
    {
    	int[] textureSize = {64, 64};
        this.box = new ModelRenderer(textureSize[0], textureSize[1], 0, 17);
        this.box.setRotationPoint(0.0F, -3.0F, -2.0F);
        this.box.addBox(0.0F, 0.0F, 0.0F, 7, 3, 9, 0.0F);
        this.box_1 = new ModelRenderer(textureSize[0], textureSize[1], 0, 29);
        this.box_1.setRotationPoint(-7.0F, -5.0F, 3.0F);
        this.box_1.addBox(0.0F, 0.0F, 0.0F, 7, 5, 3, 0.0F);
        this.pipe = new ModelRenderer(textureSize[0], textureSize[1], 42, 17);
        this.pipe.setRotationPoint(0.0F, -2.5F, 0.0F);
        this.pipe.addBox(0.0F, 0.0F, -0.6F, 2, 2, 8, 0.0F);
        this.setRotateAngle(pipe, 0.0F, -1.5707963267948966F, 0.0F);
        this.center = new ModelRenderer(textureSize[0], textureSize[1], 0, 37);
        this.center.setRotationPoint(3.5F, 0.0F, 3.5F);
        this.center.addBox(-2.5F, -2.0F, -2.5F, 5, 2, 5, 0.0F);
        this.decoration_2 = new ModelRenderer(textureSize[0], textureSize[1], 7, 0);
        this.decoration_2.setRotationPoint(0.0F, 0.0F, -2.0F);
        this.decoration_2.addBox(-1.0F, -4.0F, -0.5F, 2, 4, 1, 0.0F);
        this.setRotateAngle(decoration_2, 0.4886921905584123F, 0.0F, 0.0F);
        this.pipe_2 = new ModelRenderer(textureSize[0], textureSize[1], 54, 21);
        this.pipe_2.setRotationPoint(0.0F, 0.0F, 4.0F);
        this.pipe_2.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 1, 0.0F);
        this.decoration_3 = new ModelRenderer(textureSize[0], textureSize[1], 7, 6);
        this.decoration_3.setRotationPoint(0.0F, 0.0F, 2.5F);
        this.decoration_3.addBox(-1.0F, -4.0F, -1.0F, 2, 4, 1, 0.0F);
        this.setRotateAngle(decoration_3, -0.4886921905584123F, 0.0F, 0.0F);
        this.base = new ModelRenderer(textureSize[0], textureSize[1], 0, 0);
        this.base.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.base.addBox(-8.0F, 0.0F, -8.0F, 16, 1, 16, 0.0F);
        this.decoration = new ModelRenderer(textureSize[0], textureSize[1], 0, 0);
        this.decoration.setRotationPoint(-2.5F, 0.0F, 0.0F);
        this.decoration.addBox(0.0F, -4.0F, -1.0F, 1, 4, 2, 0.0F);
        this.setRotateAngle(decoration, 0.0F, 0.0F, -0.4886921905584123F);
        this.decoration_1 = new ModelRenderer(textureSize[0], textureSize[1], 0, 7);
        this.decoration_1.setRotationPoint(2.5F, 0.0F, 0.0F);
        this.decoration_1.addBox(-1.0F, -4.0F, -1.0F, 1, 4, 2, 0.0F);
        this.setRotateAngle(decoration_1, 0.0F, 0.0F, 0.4886921905584123F);
        this.pipe_1 = new ModelRenderer(textureSize[0], textureSize[1], 54, 17);
        this.pipe_1.setRotationPoint(1.0F, 1.0F, 1.5F);
        this.pipe_1.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 1, 0.0F);
        this.base.addChild(this.box);
        this.base.addChild(this.box_1);
        this.base.addChild(this.pipe);
        this.box.addChild(this.center);
        this.center.addChild(this.decoration_2);
        this.pipe_1.addChild(this.pipe_2);
        this.center.addChild(this.decoration_3);
        this.center.addChild(this.decoration);
        this.center.addChild(this.decoration_1);
        this.pipe.addChild(this.pipe_1);
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