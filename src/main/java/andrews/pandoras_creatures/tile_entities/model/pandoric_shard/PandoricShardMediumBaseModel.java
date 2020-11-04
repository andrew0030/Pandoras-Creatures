package andrews.pandoras_creatures.tile_entities.model.pandoric_shard;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * CoreModel - andrew0030
 * Created using Tabula 7.1.0
 */
@OnlyIn(Dist.CLIENT)
public class PandoricShardMediumBaseModel
{
    public ModelRenderer base;
    public ModelRenderer wall_back;
    public ModelRenderer wall_side;
    public ModelRenderer rod;
    public ModelRenderer thing;
    public ModelRenderer thing_1;
    public ModelRenderer pipe;
    public ModelRenderer pipe_1;
    public ModelRenderer rod_1;
    public ModelRenderer wall_side2;
    public ModelRenderer rod_2;
    public ModelRenderer thing_2;
    public ModelRenderer socket;
    public ModelRenderer thing_back;
    public ModelRenderer pipe_2;
    public ModelRenderer pipe_3;
    public ModelRenderer pipe_4;
    public ModelRenderer pipe_5;

    public PandoricShardMediumBaseModel()
    {
    	int[] textureSize = {128, 64};
        this.pipe_1 = new ModelRenderer(textureSize[0], textureSize[1], 39, 18);
        this.pipe_1.setRotationPoint(-1.0F, -10.5F, 5.5F);
        this.pipe_1.addBox(0.0F, 0.0F, -1.0F, 7, 2, 2, 0.0F);
        this.setRotateAngle(pipe_1, 0.0F, 0.0F, 0.9105382707654417F);
        this.rod_2 = new ModelRenderer(textureSize[0], textureSize[1], 22, 34);
        this.rod_2.setRotationPoint(0.01F, -6.0F, -1.0F);
        this.rod_2.addBox(-1.0F, -5.0F, 0.0F, 1, 5, 1, 0.0F);
        this.setRotateAngle(rod_2, -0.24626595745639987F, 0.0F, 0.0F);
        this.pipe_4 = new ModelRenderer(textureSize[0], textureSize[1], 54, 22);
        this.pipe_4.setRotationPoint(2.0F, -0.5F, -1.5F);
        this.pipe_4.addBox(-0.5F, 0.0F, 0.0F, 1, 3, 3, 0.0F);
        this.rod = new ModelRenderer(textureSize[0], textureSize[1], 17, 33);
        this.rod.setRotationPoint(7.5F, 0.0F, -6.5F);
        this.rod.addBox(-1.0F, -6.0F, -1.0F, 1, 6, 1, 0.0F);
        this.setRotateAngle(rod, 0.09389871375729493F, -0.14067353771074295F, 0.0F);
        this.wall_side2 = new ModelRenderer(textureSize[0], textureSize[1], 24, 17);
        this.wall_side2.setRotationPoint(9.0F, -6.0F, -1.0F);
        this.wall_side2.addBox(0.0F, -8.0F, 0.0F, 6, 8, 1, 0.0F);
        this.setRotateAngle(wall_side2, -0.034033920413889425F, 0.0F, 0.0F);
        this.wall_side = new ModelRenderer(textureSize[0], textureSize[1], 63, 16);
        this.wall_side.setRotationPoint(-8.0F, 0.0F, -8.0F);
        this.wall_side.addBox(0.0F, -10.0F, -1.0F, 9, 10, 1, 0.0F);
        this.setRotateAngle(wall_side, 0.025481807079117208F, -1.5707963267948966F, 0.0F);
        this.thing_back = new ModelRenderer(textureSize[0], textureSize[1], 0, 17);
        this.thing_back.setRotationPoint(-1.0F, 0.0F, 5.5F);
        this.thing_back.addBox(0.0F, -5.0F, -2.0F, 8, 5, 4, 0.0F);
        this.rod_1 = new ModelRenderer(textureSize[0], textureSize[1], 27, 34);
        this.rod_1.setRotationPoint(3.4F, 0.0F, -7.9F);
        this.rod_1.addBox(0.0F, -5.0F, 0.0F, 1, 5, 1, 0.0F);
        this.setRotateAngle(rod_1, -0.10995574287564275F, 0.0F, 0.054977871437821374F);
        this.pipe_3 = new ModelRenderer(textureSize[0], textureSize[1], 45, 22);
        this.pipe_3.setRotationPoint(5.0F, 0.0F, 0.0F);
        this.pipe_3.addBox(0.5F, -0.5F, -1.5F, 1, 3, 3, 0.0F);
        this.thing_1 = new ModelRenderer(textureSize[0], textureSize[1], 21, 30);
        this.thing_1.setRotationPoint(-7.0F, -13.0F, -3.0F);
        this.thing_1.addBox(0.0F, 0.0F, 0.0F, 6, 4, 10, 0.0F);
        this.wall_back = new ModelRenderer(textureSize[0], textureSize[1], 48, 0);
        this.wall_back.setRotationPoint(0.0F, 0.0F, 7.0F);
        this.wall_back.addBox(-8.0F, -15.0F, 0.0F, 16, 15, 1, 0.0F);
        this.base = new ModelRenderer(textureSize[0], textureSize[1], 0, 0);
        this.base.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.base.addBox(-8.0F, 0.0F, -8.0F, 16, 1, 16, 0.0F);
        this.thing_2 = new ModelRenderer(textureSize[0], textureSize[1], 0, 26);
        this.thing_2.setRotationPoint(7.0F, 0.0F, 3.5F);
        this.thing_2.addBox(0.0F, -7.0F, 2.5F, 8, 7, 1, 0.0F);
        this.pipe = new ModelRenderer(textureSize[0], textureSize[1], 39, 18);
        this.pipe.setRotationPoint(-8.0F, -2.5F, 5.0F);
        this.pipe.addBox(0.0F, 0.0F, -1.1F, 7, 2, 2, 0.0F);
        this.pipe_2 = new ModelRenderer(textureSize[0], textureSize[1], 54, 22);
        this.pipe_2.setRotationPoint(2.0F, -0.5F, -1.5F);
        this.pipe_2.addBox(-0.5F, 0.0F, 0.0F, 1, 3, 3, 0.0F);
        this.pipe_5 = new ModelRenderer(textureSize[0], textureSize[1], 45, 22);
        this.pipe_5.setRotationPoint(5.0F, 0.0F, 0.0F);
        this.pipe_5.addBox(-0.5F, -0.5F, -1.5F, 1, 3, 3, 0.0F);
        this.thing = new ModelRenderer(textureSize[0], textureSize[1], 0, 41);
        this.thing.setRotationPoint(-7.0F, 0.0F, -4.0F);
        this.thing.addBox(0.0F, -3.0F, 0.0F, 7, 3, 7, 0.0F);
        this.socket = new ModelRenderer(textureSize[0], textureSize[1], 0, 34);
        this.socket.setRotationPoint(1.5F, -6.0F, -1.0F);
        this.socket.addBox(0.0F, 0.0F, 2.4F, 5, 5, 1, 0.0F);
        this.base.addChild(this.pipe_1);
        this.rod.addChild(this.rod_2);
        this.pipe_1.addChild(this.pipe_4);
        this.base.addChild(this.rod);
        this.wall_side.addChild(this.wall_side2);
        this.base.addChild(this.wall_side);
        this.thing_2.addChild(this.thing_back);
        this.base.addChild(this.rod_1);
        this.pipe.addChild(this.pipe_3);
        this.base.addChild(this.thing_1);
        this.base.addChild(this.wall_back);
        this.thing.addChild(this.thing_2);
        this.base.addChild(this.pipe);
        this.pipe.addChild(this.pipe_2);
        this.pipe_1.addChild(this.pipe_5);
        this.base.addChild(this.thing);
        this.thing_2.addChild(this.socket);
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
