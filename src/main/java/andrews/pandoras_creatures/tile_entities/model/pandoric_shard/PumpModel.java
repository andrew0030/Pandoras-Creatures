package andrews.pandoras_creatures.tile_entities.model.pandoric_shard;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * Pump - andrew0030
 * Created using Tabula 7.1.0
 */
@OnlyIn(Dist.CLIENT)
public class PumpModel
{
    public ModelRenderer base;
    public ModelRenderer center;
    public ModelRenderer top;
    public ModelRenderer wall_right;
    public ModelRenderer wall_left;
    public ModelRenderer wall_back;
    public ModelRenderer piston;

    public PumpModel()
    {
    	int[] textureSize = {32, 32};
        this.top = new ModelRenderer(textureSize[0], textureSize[1], 0, 7);
        this.top.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.top.addBox(-3.0F, -1.0F, -3.0F, 6, 1, 6, 0.0F);
        this.wall_right = new ModelRenderer(textureSize[0], textureSize[1], 12, 14);
        this.wall_right.setRotationPoint(1.5F, -1.0F, -2.5F);
        this.wall_right.addBox(0.0F, -4.0F, 0.0F, 1, 4, 5, 0.0F);
        this.wall_left = new ModelRenderer(textureSize[0], textureSize[1], 0, 14);
        this.wall_left.setRotationPoint(-2.5F, -1.0F, -2.5F);
        this.wall_left.addBox(0.0F, -4.0F, 0.0F, 1, 4, 5, 0.0F);
        this.wall_back = new ModelRenderer(textureSize[0], textureSize[1], 0, 23);
        this.wall_back.setRotationPoint(0.5F, -1.0F, 1.5F);
        this.wall_back.addBox(-2.0F, -4.0F, 0.0F, 3, 4, 1, 0.0F);
        this.center = new ModelRenderer(textureSize[0], textureSize[1], 8, 23);
        this.center.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.center.addBox(-2.0F, 0.0F, -2.0F, 4, 4, 4, 0.0F);
        this.setRotateAngle(center, 3.141592653589793F, 0.0F, 0.0F);
        this.piston = new ModelRenderer(textureSize[0], textureSize[1], 0, 0);
        this.piston.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.piston.addBox(-0.5F, -1.0F, -0.5F, 1, 4, 1, 0.0F);
        this.base = new ModelRenderer(textureSize[0], textureSize[1], 0, 0);
        this.base.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.base.addBox(-3.0F, -1.0F, -3.0F, 6, 1, 6, 0.0F);
        this.base.addChild(this.wall_right);
        this.base.addChild(this.wall_left);
        this.base.addChild(this.wall_back);
        this.base.addChild(this.piston);
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