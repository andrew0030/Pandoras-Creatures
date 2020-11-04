package andrews.pandoras_creatures.tile_entities.model.pandoric_shard;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * CoreModel - andrew0030
 * Created using Tabula 7.1.0
 */
@OnlyIn(Dist.CLIENT)
public class PandoricShardMediumBase3Model
{
	public ModelRenderer base;
    public ModelRenderer box_thing;
    public ModelRenderer wall_back_rod;
    public ModelRenderer wall_back_mid;
    public ModelRenderer wall_back_side;
    public ModelRenderer pipe;
    public ModelRenderer wall_side;
    public ModelRenderer wall_side_1;
    public ModelRenderer shape18;
    public ModelRenderer rod;
    public ModelRenderer plate;
    public ModelRenderer socket;
    public ModelRenderer pipe_1;
    public ModelRenderer pipe_2;
    public ModelRenderer pipe_3;
    public ModelRenderer pipe_4;
    public ModelRenderer rod_1;
    public ModelRenderer plate_top;

    public PandoricShardMediumBase3Model()
    {
    	int[] textureSize = {128, 64};
        this.box_thing = new ModelRenderer(textureSize[0], textureSize[1], 0, 17);
        this.box_thing.setRotationPoint(-3.0F, 0.0F, -2.0F);
        this.box_thing.addBox(0.0F, -4.0F, 0.0F, 7, 4, 9, 0.0F);
        this.wall_side_1 = new ModelRenderer(textureSize[0], textureSize[1], 50, 35);
        this.wall_side_1.setRotationPoint(-7.4F, -9.0F, -7.0F);
        this.wall_side_1.addBox(0.0F, 0.0F, 0.0F, 1, 9, 6, 0.0F);
        this.setRotateAngle(wall_side_1, 0.0F, 0.0F, 0.054105206811824215F);
        this.rod = new ModelRenderer(textureSize[0], textureSize[1], 17, 33);
        this.rod.setRotationPoint(7.9F, 0.0F, -6.9F);
        this.rod.addBox(-1.0F, -6.0F, -1.0F, 1, 6, 1, 0.0F);
        this.setRotateAngle(rod, 0.0F, -0.09721483933608416F, -0.04325009215374905F);
        this.wall_back_rod = new ModelRenderer(textureSize[0], textureSize[1], 0, 47);
        this.wall_back_rod.setRotationPoint(8.0F, 0.0F, 8.0F);
        this.wall_back_rod.addBox(-1.0F, -15.0F, -1.0F, 1, 15, 1, 0.0F);
        this.shape18 = new ModelRenderer(textureSize[0], textureSize[1], 49, 0);
        this.shape18.setRotationPoint(-7.0F, -4.0F, 2.0F);
        this.shape18.addBox(0.0F, -7.0F, 0.0F, 5, 7, 5, 0.0F);
        this.base = new ModelRenderer(textureSize[0], textureSize[1], 0, 0);
        this.base.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.base.addBox(-8.0F, 0.0F, -8.0F, 16, 1, 16, 0.0F);
        this.socket = new ModelRenderer(textureSize[0], textureSize[1], 0, 40);
        this.socket.setRotationPoint(2.0F, -5.0F, 6.0F);
        this.socket.addBox(0.0F, 0.0F, 0.0F, 5, 5, 1, 0.0F);
        this.setRotateAngle(socket, -1.5707963267948966F, 0.0F, 0.0F);
        this.pipe_1 = new ModelRenderer(textureSize[0], textureSize[1], 54, 18);
        this.pipe_1.setRotationPoint(1.0F, 1.0F, 0.5F);
        this.pipe_1.addBox(-1.8F, -1.5F, 0.0F, 3, 3, 1, 0.0F);
        this.pipe_2 = new ModelRenderer(textureSize[0], textureSize[1], 54, 27);
        this.pipe_2.setRotationPoint(0.0F, 0.0F, 6.5F);
        this.pipe_2.addBox(-1.8F, -1.5F, 0.0F, 3, 3, 1, 0.0F);
        this.plate_top = new ModelRenderer(textureSize[0], textureSize[1], 0, 30);
        this.plate_top.setRotationPoint(1.0F, -6.0F, -1.0F);
        this.plate_top.addBox(0.0F, -2.0F, 0.0F, 3, 2, 1, 0.0F);
        this.setRotateAngle(plate_top, -0.22759093446006054F, 0.0F, 0.0F);
        this.pipe = new ModelRenderer(textureSize[0], textureSize[1], 38, 22);
        this.pipe.setRotationPoint(-6.0F, -2.5F, -7.5F);
        this.pipe.addBox(-0.25F, 0.0F, 0.0F, 2, 2, 11, 0.0F);
        this.plate = new ModelRenderer(textureSize[0], textureSize[1], 0, 33);
        this.plate.setRotationPoint(6.6F, 0.0F, -6.3F);
        this.plate.addBox(0.0F, -6.0F, -1.0F, 7, 6, 1, 0.0F);
        this.setRotateAngle(plate, 0.05637413483941684F, -1.5144221919554797F, 0.0F);
        this.wall_back_side = new ModelRenderer(textureSize[0], textureSize[1], 5, 47);
        this.wall_back_side.setRotationPoint(-8.0F, 0.0F, 7.0F);
        this.wall_back_side.addBox(0.0F, -14.0F, 0.0F, 8, 14, 1, 0.0F);
        this.setRotateAngle(wall_back_side, 0.0F, 0.01884955592153876F, 0.0F);
        this.wall_side = new ModelRenderer(textureSize[0], textureSize[1], 32, 41);
        this.wall_side.setRotationPoint(-8.0F, -5.96F, -1.0F);
        this.wall_side.addBox(0.3F, -7.0F, 0.0F, 1, 9, 8, 0.0F);
        this.setRotateAngle(wall_side, 0.0F, 0.0F, -0.04328416544945937F);
        this.rod_1 = new ModelRenderer(textureSize[0], textureSize[1], 22, 34);
        this.rod_1.setRotationPoint(0.01F, -6.0F, -1.0F);
        this.rod_1.addBox(-1.0F, -5.0F, 0.0F, 1, 5, 1, 0.0F);
        this.setRotateAngle(rod_1, -0.24626595745639987F, 0.0F, 0.0F);
        this.pipe_4 = new ModelRenderer(textureSize[0], textureSize[1], 39, 18);
        this.pipe_4.setRotationPoint(0.0F, 0.0F, 2.5F);
        this.pipe_4.addBox(0.0F, -2.0F, 0.0F, 5, 2, 2, 0.0F);
        this.setRotateAngle(pipe_4, 0.0F, 0.0F, 0.6981317007977318F);
        this.pipe_3 = new ModelRenderer(textureSize[0], textureSize[1], 39, 18);
        this.pipe_3.setRotationPoint(1.35F, -1.0F, 3.0F);
        this.pipe_3.addBox(-0.6F, 0.0F, -1.0F, 2, 2, 2, 0.0F);
        this.wall_back_mid = new ModelRenderer(textureSize[0], textureSize[1], 23, 41);
        this.wall_back_mid.setRotationPoint(0.0F, -6.0F, 7.0F);
        this.wall_back_mid.addBox(0.0F, -6.0F, 0.0F, 7, 6, 1, 0.0F);
        this.setRotateAngle(wall_back_mid, 0.056723200689815706F, 0.0F, 0.0F);
        this.base.addChild(this.box_thing);
        this.base.addChild(this.wall_side_1);
        this.base.addChild(this.rod);
        this.base.addChild(this.wall_back_rod);
        this.base.addChild(this.shape18);
        this.box_thing.addChild(this.socket);
        this.pipe.addChild(this.pipe_1);
        this.pipe_1.addChild(this.pipe_2);
        this.plate.addChild(this.plate_top);
        this.base.addChild(this.pipe);
        this.base.addChild(this.plate);
        this.base.addChild(this.wall_back_side);
        this.base.addChild(this.wall_side);
        this.rod.addChild(this.rod_1);
        this.shape18.addChild(this.pipe_4);
        this.pipe_2.addChild(this.pipe_3);
        this.base.addChild(this.wall_back_mid);
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
