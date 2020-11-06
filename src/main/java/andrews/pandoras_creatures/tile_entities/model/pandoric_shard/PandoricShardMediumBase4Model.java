package andrews.pandoras_creatures.tile_entities.model.pandoric_shard;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * CoreModel - andrew0030
 * Created using Tabula 7.1.0
 */
@OnlyIn(Dist.CLIENT)
public class PandoricShardMediumBase4Model
{
	public ModelRenderer base;
    public ModelRenderer wall_left;
    public ModelRenderer wall_back;
    public ModelRenderer wall_back_long;
    public ModelRenderer shape5;
    public ModelRenderer box;
    public ModelRenderer box_1;
    public ModelRenderer pump_holder;
    public ModelRenderer pipe;
    public ModelRenderer pipe_1;
    public ModelRenderer pipe_2;
    public ModelRenderer center;
    public ModelRenderer decoration;
    public ModelRenderer decoration_1;
    public ModelRenderer decoration_2;
    public ModelRenderer decoration_3;
    public ModelRenderer pipe_3;
    public ModelRenderer pipe_4;
    public ModelRenderer pipe_5;

    public PandoricShardMediumBase4Model()
    {
    	int[] textureSize = {128, 64};
        this.decoration_1 = new ModelRenderer(textureSize[0], textureSize[1], 0, 7);
        this.decoration_1.setRotationPoint(2.5F, 0.0F, 0.0F);
        this.decoration_1.addBox(-1.0F, -4.0F, -1.0F, 1, 4, 2, 0.0F);
        this.setRotateAngle(decoration_1, 0.0F, 0.0F, 0.4886921905584123F);
        this.pipe_5 = new ModelRenderer(textureSize[0], textureSize[1], 39, 18);
        this.pipe_5.setRotationPoint(-4.0F, -1.0F, 3.0F);
        this.pipe_5.addBox(-0.3F, 0.0F, -1.0F, 3, 2, 2, 0.0F);
        this.decoration_2 = new ModelRenderer(textureSize[0], textureSize[1], 7, 0);
        this.decoration_2.setRotationPoint(0.0F, 0.0F, -2.5F);
        this.decoration_2.addBox(-1.0F, -4.0F, 0.0F, 2, 4, 1, 0.0F);
        this.setRotateAngle(decoration_2, 0.4886921905584123F, 0.0F, 0.0F);
        this.pump_holder = new ModelRenderer(textureSize[0], textureSize[1], 0, 24);
        this.pump_holder.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.pump_holder.addBox(-2.0F, 0.0F, 0.0F, 9, 2, 7, 0.0F);
        this.pipe = new ModelRenderer(textureSize[0], textureSize[1], 38, 22);
        this.pipe.setRotationPoint(-2.0F, -2.5F, 4.3F);
        this.pipe.addBox(-0.3F, 0.0F, 0.0F, 2, 2, 8, 0.0F);
        this.setRotateAngle(pipe, 0.0F, 1.5707963267948966F, 0.0F);
        this.decoration = new ModelRenderer(textureSize[0], textureSize[1], 0, 0);
        this.decoration.setRotationPoint(-2.5F, 0.0F, 0.0F);
        this.decoration.addBox(0.0F, -4.0F, -1.0F, 1, 4, 2, 0.0F);
        this.setRotateAngle(decoration, 0.0F, 0.0F, -0.4886921905584123F);
        this.decoration_3 = new ModelRenderer(textureSize[0], textureSize[1], 7, 6);
        this.decoration_3.setRotationPoint(0.0F, 0.0F, 2.5F);
        this.decoration_3.addBox(-1.0F, -4.0F, -1.0F, 2, 4, 1, 0.0F);
        this.setRotateAngle(decoration_3, -0.4886921905584123F, 0.0F, 0.0F);
        this.shape5 = new ModelRenderer(textureSize[0], textureSize[1], 21, 44);
        this.shape5.setRotationPoint(7.0F, 0.0F, 1.0F);
        this.shape5.addBox(0.0F, -13.0F, 0.0F, 1, 13, 7, 0.0F);
        this.pipe_4 = new ModelRenderer(textureSize[0], textureSize[1], 54, 26);
        this.pipe_4.setRotationPoint(0.0F, 0.0F, 3.5F);
        this.pipe_4.addBox(-1.8F, -1.5F, 0.0F, 3, 3, 1, 0.0F);
        this.pipe_1 = new ModelRenderer(textureSize[0], textureSize[1], 38, 22);
        this.pipe_1.setRotationPoint(-6.0F, -2.0F, -1.0F);
        this.pipe_1.addBox(0.0F, -1.3F, 0.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(pipe_1, 2.0943951023931953F, 0.0F, 0.0F);
        this.pipe_3 = new ModelRenderer(textureSize[0], textureSize[1], 54, 18);
        this.pipe_3.setRotationPoint(1.0F, 1.0F, 0.5F);
        this.pipe_3.addBox(-1.8F, -1.5F, 0.0F, 3, 3, 1, 0.0F);
        this.base = new ModelRenderer(textureSize[0], textureSize[1], 0, 0);
        this.base.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.base.addBox(-8.0F, 0.0F, -8.0F, 16, 1, 16, 0.0F);
        this.wall_back = new ModelRenderer(textureSize[0], textureSize[1], 0, 40);
        this.wall_back.setRotationPoint(-7.0F, 0.0F, 8.0F);
        this.wall_back.addBox(0.0F, -5.0F, -1.0F, 9, 5, 1, 0.0F);
        this.setRotateAngle(wall_back, 0.04468042885105484F, 0.0F, 0.0F);
        this.wall_back_long = new ModelRenderer(textureSize[0], textureSize[1], 0, 33);
        this.wall_back_long.setRotationPoint(2.0F, 0.0F, 7.0F);
        this.wall_back_long.addBox(0.0F, -10.0F, 0.0F, 5, 6, 1, 0.0F);
        this.setRotateAngle(wall_back_long, 0.0F, 0.07452555906015787F, 0.0F);
        this.box_1 = new ModelRenderer(textureSize[0], textureSize[1], 0, 46);
        this.box_1.setRotationPoint(-7.0F, 0.0F, 2.0F);
        this.box_1.addBox(0.0F, -13.0F, 0.0F, 5, 13, 5, 0.0F);
        this.wall_left = new ModelRenderer(textureSize[0], textureSize[1], 48, 33);
        this.wall_left.setRotationPoint(-8.0F, -1.0F, -8.0F);
        this.wall_left.addBox(0.0F, -14.0F, 0.0F, 1, 15, 16, 0.0F);
        this.center = new ModelRenderer(textureSize[0], textureSize[1], 0, 17);
        this.center.setRotationPoint(5.5F, -3.0F, 3.5F);
        this.center.addBox(-2.5F, -2.0F, -2.5F, 5, 2, 5, 0.0F);
        this.box = new ModelRenderer(textureSize[0], textureSize[1], 24, 35);
        this.box.setRotationPoint(-7.0F, 0.0F, -7.0F);
        this.box.addBox(0.0F, -3.0F, 0.0F, 12, 3, 6, 0.0F);
        this.pipe_2 = new ModelRenderer(textureSize[0], textureSize[1], 38, 22);
        this.pipe_2.setRotationPoint(2.0F, -5.0F, 0.0F);
        this.pipe_2.addBox(0.0F, 0.0F, 0.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(pipe_2, -0.9424777960769379F, 0.0F, 0.0F);
        this.center.addChild(this.decoration_1);
        this.pipe_4.addChild(this.pipe_5);
        this.center.addChild(this.decoration_2);
        this.base.addChild(this.pump_holder);
        this.base.addChild(this.pipe);
        this.center.addChild(this.decoration);
        this.center.addChild(this.decoration_3);
        this.base.addChild(this.shape5);
        this.pipe_3.addChild(this.pipe_4);
        this.base.addChild(this.pipe_1);
        this.pipe.addChild(this.pipe_3);
        this.base.addChild(this.wall_back);
        this.base.addChild(this.wall_back_long);
        this.base.addChild(this.box_1);
        this.base.addChild(this.wall_left);
        this.box.addChild(this.center);
        this.base.addChild(this.box);
        this.base.addChild(this.pipe_2);
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
