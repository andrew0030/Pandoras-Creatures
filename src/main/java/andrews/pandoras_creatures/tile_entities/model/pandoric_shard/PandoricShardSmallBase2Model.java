package andrews.pandoras_creatures.tile_entities.model.pandoric_shard;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * CoreModel - andrew0030
 * Created using Tabula 7.1.0
 */
@OnlyIn(Dist.CLIENT)
public class PandoricShardSmallBase2Model
{
	public ModelRenderer base;
    public ModelRenderer thing;
    public ModelRenderer pipe;
    public ModelRenderer rod;
    public ModelRenderer rod_1;
    public ModelRenderer thing_1;
    public ModelRenderer socket;
    public ModelRenderer thing_back;
    public ModelRenderer pipe_1;
    public ModelRenderer pipe_2;
    public ModelRenderer pipe_3;
    public ModelRenderer pipe_4;
    public ModelRenderer rod_2;

    public PandoricShardSmallBase2Model()
    {
    	int[] textureSize = {64, 64};
        this.pipe_2 = new ModelRenderer(textureSize[0], textureSize[1], 54, 28);
        this.pipe_2.setRotationPoint(0.0F, 0.0F, 6.5F);
        this.pipe_2.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 1, 0.0F);
        this.pipe_4 = new ModelRenderer(textureSize[0], textureSize[1], 54, 22);
        this.pipe_4.setRotationPoint(2.0F, -0.5F, -1.5F);
        this.pipe_4.addBox(0.0F, 0.0F, 0.0F, 1, 3, 3, 0.0F);
        this.rod_1 = new ModelRenderer(textureSize[0], textureSize[1], 27, 34);
        this.rod_1.setRotationPoint(-6.2F, 0.3F, -6.5F);
        this.rod_1.addBox(0.0F, -5.0F, -1.1F, 1, 5, 1, 0.0F);
        this.setRotateAngle(rod_1, 0.06527531402458793F, 0.0F, -0.27942721324429215F);
        this.thing_back = new ModelRenderer(textureSize[0], textureSize[1], 0, 18);
        this.thing_back.setRotationPoint(0.0F, 0.0F, 3.0F);
        this.thing_back.addBox(0.0F, -5.0F, -2.0F, 8, 5, 3, 0.0F);
        this.rod = new ModelRenderer(textureSize[0], textureSize[1], 17, 33);
        this.rod.setRotationPoint(-1.3F, 0.0F, -6.5F);
        this.rod.addBox(-1.0F, -6.0F, -1.0F, 1, 6, 1, 0.0F);
        this.setRotateAngle(rod, 0.08383609881604738F, 0.0F, 0.0F);
        this.pipe_3 = new ModelRenderer(textureSize[0], textureSize[1], 39, 18);
        this.pipe_3.setRotationPoint(1.0F, -1.0F, 3.0F);
        this.pipe_3.addBox(0.0F, 0.0F, -1.0F, 5, 2, 2, 0.0F);
        this.socket = new ModelRenderer(textureSize[0], textureSize[1], 0, 34);
        this.socket.setRotationPoint(1.5F, -6.0F, -1.0F);
        this.socket.addBox(0.0F, 0.0F, 0.0F, 5, 5, 1, 0.0F);
        this.pipe_1 = new ModelRenderer(textureSize[0], textureSize[1], 54, 18);
        this.pipe_1.setRotationPoint(1.0F, 1.0F, 0.5F);
        this.pipe_1.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 1, 0.0F);
        this.pipe = new ModelRenderer(textureSize[0], textureSize[1], 38, 22);
        this.pipe.setRotationPoint(4.0F, -2.5F, -6.5F);
        this.pipe.addBox(0.0F, 0.0F, 0.0F, 2, 2, 11, 0.0F);
        this.setRotateAngle(pipe, 0.0F, -1.5707963267948966F, 0.0F);
        this.thing_1 = new ModelRenderer(textureSize[0], textureSize[1], 0, 26);
        this.thing_1.setRotationPoint(7.0F, 0.0F, 3.5F);
        this.thing_1.addBox(0.0F, -7.0F, 0.0F, 8, 7, 1, 0.0F);
        this.rod_2 = new ModelRenderer(textureSize[0], textureSize[1], 22, 34);
        this.rod_2.setRotationPoint(0.01F, -6.0F, -1.0F);
        this.rod_2.addBox(-1.0F, -5.0F, 0.0F, 1, 5, 1, 0.0F);
        this.setRotateAngle(rod_2, -0.24626595745639987F, 0.0F, 0.0F);
        this.thing = new ModelRenderer(textureSize[0], textureSize[1], 0, 41);
        this.thing.setRotationPoint(-7.5F, 0.0F, 0.0F);
        this.thing.addBox(0.0F, -3.0F, 0.0F, 7, 3, 7, 0.0F);
        this.base = new ModelRenderer(textureSize[0], textureSize[1], 0, 0);
        this.base.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.base.addBox(-8.0F, 0.0F, -8.0F, 16, 1, 16, 0.0F);
        this.pipe_1.addChild(this.pipe_2);
        this.pipe_3.addChild(this.pipe_4);
        this.base.addChild(this.rod_1);
        this.thing_1.addChild(this.thing_back);
        this.base.addChild(this.rod);
        this.pipe_2.addChild(this.pipe_3);
        this.thing_1.addChild(this.socket);
        this.pipe.addChild(this.pipe_1);
        this.base.addChild(this.pipe);
        this.thing.addChild(this.thing_1);
        this.rod.addChild(this.rod_2);
        this.base.addChild(this.thing);
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
