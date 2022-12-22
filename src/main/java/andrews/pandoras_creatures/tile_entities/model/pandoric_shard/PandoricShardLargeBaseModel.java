package andrews.pandoras_creatures.tile_entities.model.pandoric_shard;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * LargePandoricShard1 - andrew0030
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class PandoricShardLargeBaseModel
{
    public ModelRenderer base;
    public ModelRenderer box_thing2;
    public ModelRenderer box_thing;
    public ModelRenderer wall_back_rod;
    public ModelRenderer wall_back_mid;
    public ModelRenderer wall_back_side;
    public ModelRenderer pipe;
    public ModelRenderer rod;
    public ModelRenderer plate;
    public ModelRenderer wall_left_bottom;
    public ModelRenderer wall_front_bottom;
    public ModelRenderer socket;
    public ModelRenderer wall_top;
    public ModelRenderer part7;
    public ModelRenderer pipe_1;
    public ModelRenderer pipe_2;
    public ModelRenderer pipe_3;
    public ModelRenderer rod_1;
    public ModelRenderer wall_left_top;
    public ModelRenderer wall_front_top;

    public PandoricShardLargeBaseModel()
    {
    	int[] textureSize = {128, 64};
        this.pipe_1 = new ModelRenderer(textureSize[0], textureSize[1], 54, 18);
        this.pipe_1.setRotationPoint(1.0F, 1.0F, 0.5F);
        this.pipe_1.addBox(-1.8F, -1.5F, 0.0F, 3.0F, 3.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.box_thing2 = new ModelRenderer(textureSize[0], textureSize[1], 65, 29);
        this.box_thing2.setRotationPoint(-7.0F, -14.0F, 0.0F);
        this.box_thing2.addBox(0.0F, 0.0F, 0.0F, 5.0F, 6.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.wall_left_bottom = new ModelRenderer(textureSize[0], textureSize[1], 25, 38);
        this.wall_left_bottom.setRotationPoint(-8.0F, 0.0F, -8.0F);
        this.wall_left_bottom.addBox(0.0F, -5.0F, 0.0F, 1.0F, 5.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(wall_left_bottom, 0.0F, 0.008726646259971648F, -0.020943951856169794F);
        this.pipe = new ModelRenderer(textureSize[0], textureSize[1], 38, 22);
        this.pipe.setRotationPoint(-5.8F, -2.5F, -7.5F);
        this.pipe.addBox(-0.25F, 0.0F, 0.0F, 2.0F, 2.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.rod_1 = new ModelRenderer(textureSize[0], textureSize[1], 22, 34);
        this.rod_1.setRotationPoint(0.01F, -6.0F, -1.0F);
        this.rod_1.addBox(-1.0F, -5.0F, 0.0F, 1.0F, 5.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rod_1, -0.24626595146428745F, 0.0F, 0.0F);
        this.part7 = new ModelRenderer(textureSize[0], textureSize[1], 63, 18);
        this.part7.setRotationPoint(7.5F, 1.0F, -13.0F);
        this.part7.addBox(0.0F, 0.0F, 0.0F, 6.0F, 6.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.wall_back_rod = new ModelRenderer(textureSize[0], textureSize[1], 0, 47);
        this.wall_back_rod.setRotationPoint(8.0F, 0.0F, 8.0F);
        this.wall_back_rod.addBox(-1.0F, -14.0F, -1.0F, 1.0F, 14.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.wall_front_bottom = new ModelRenderer(textureSize[0], textureSize[1], 68, 0);
        this.wall_front_bottom.setRotationPoint(-2.0F, 0.0F, -8.0F);
        this.wall_front_bottom.addBox(-1.0F, -5.0F, 0.0F, 2.0F, 5.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(wall_front_bottom, -0.06981317007977318F, 0.0F, 0.0F);
        this.pipe_3 = new ModelRenderer(textureSize[0], textureSize[1], 39, 18);
        this.pipe_3.setRotationPoint(1.35F, -1.0F, 3.0F);
        this.pipe_3.addBox(-0.6F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.rod = new ModelRenderer(textureSize[0], textureSize[1], 17, 33);
        this.rod.setRotationPoint(7.9F, 0.0F, -6.9F);
        this.rod.addBox(-1.0F, -6.0F, -1.0F, 1.0F, 6.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rod, 0.0F, -0.09721484233214038F, -0.043250093965158304F);
        this.socket = new ModelRenderer(textureSize[0], textureSize[1], 0, 40);
        this.socket.setRotationPoint(2.0F, -5.0F, 6.0F);
        this.socket.addBox(0.0F, 0.0F, 0.0F, 5.0F, 5.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(socket, -1.5707963267948966F, 0.0F, 0.0F);
        this.pipe_2 = new ModelRenderer(textureSize[0], textureSize[1], 54, 27);
        this.pipe_2.setRotationPoint(0.0F, 0.0F, 6.5F);
        this.pipe_2.addBox(-1.8F, -1.5F, 0.0F, 3.0F, 3.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.plate = new ModelRenderer(textureSize[0], textureSize[1], 0, 33);
        this.plate.setRotationPoint(6.6F, 0.0F, -6.3F);
        this.plate.addBox(0.0F, -6.0F, -1.0F, 7.0F, 6.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(plate, 0.05637413517231198F, -1.5144221333659356F, 0.0F);
        this.wall_top = new ModelRenderer(textureSize[0], textureSize[1], 64, 0);
        this.wall_top.setRotationPoint(0.0F, -15.0F, 0.0F);
        this.wall_top.addBox(0.0F, 0.0F, -15.0F, 16.0F, 1.0F, 16.0F, 0.0F, 0.0F, 0.0F);
        this.base = new ModelRenderer(textureSize[0], textureSize[1], 0, 0);
        this.base.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.base.addBox(-8.0F, 0.0F, -8.0F, 16.0F, 1.0F, 16.0F, 0.0F, 0.0F, 0.0F);
        this.wall_back_mid = new ModelRenderer(textureSize[0], textureSize[1], 23, 41);
        this.wall_back_mid.setRotationPoint(0.0F, -6.0F, 7.0F);
        this.wall_back_mid.addBox(0.0F, -6.0F, 0.0F, 7.0F, 6.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(wall_back_mid, 0.056723200689815706F, 0.0F, 0.0F);
        this.box_thing = new ModelRenderer(textureSize[0], textureSize[1], 0, 17);
        this.box_thing.setRotationPoint(-2.0F, 0.0F, -2.0F);
        this.box_thing.addBox(0.0F, -4.0F, -1.0F, 7.0F, 4.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.wall_back_side = new ModelRenderer(textureSize[0], textureSize[1], 5, 47);
        this.wall_back_side.setRotationPoint(-8.0F, 0.0F, 7.0F);
        this.wall_back_side.addBox(0.0F, -14.0F, 0.0F, 8.0F, 14.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(wall_back_side, 0.0F, 0.018849556670552815F, 0.0F);
        this.wall_left_top = new ModelRenderer(textureSize[0], textureSize[1], 43, 36);
        this.wall_left_top.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.wall_left_top.addBox(0.0F, -9.0F, 0.0F, 1.0F, 9.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(wall_left_top, 0.0F, -0.008726646259971648F, 0.02617993877991494F);
        this.wall_front_top = new ModelRenderer(textureSize[0], textureSize[1], 49, 0);
        this.wall_front_top.setRotationPoint(0.0F, -5.0F, 1.0F);
        this.wall_front_top.addBox(-5.0F, -9.0F, -1.0F, 8.0F, 9.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(wall_front_top, 0.10821041029469708F, 0.0F, 0.0F);
        this.pipe.addChild(this.pipe_1);
        this.base.addChild(this.box_thing2);
        this.base.addChild(this.wall_left_bottom);
        this.base.addChild(this.pipe);
        this.rod.addChild(this.rod_1);
        this.wall_top.addChild(this.part7);
        this.base.addChild(this.wall_back_rod);
        this.base.addChild(this.wall_front_bottom);
        this.pipe_2.addChild(this.pipe_3);
        this.base.addChild(this.rod);
        this.box_thing.addChild(this.socket);
        this.pipe_1.addChild(this.pipe_2);
        this.base.addChild(this.plate);
        this.wall_back_side.addChild(this.wall_top);
        this.base.addChild(this.wall_back_mid);
        this.base.addChild(this.box_thing);
        this.base.addChild(this.wall_back_side);
        this.wall_left_bottom.addChild(this.wall_left_top);
        this.wall_front_bottom.addChild(this.wall_front_top);
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