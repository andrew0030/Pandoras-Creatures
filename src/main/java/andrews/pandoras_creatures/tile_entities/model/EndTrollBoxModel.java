package andrews.pandoras_creatures.tile_entities.model;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.Model;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * ModelEndTrollShulker - andrew0030
 * Created using Tabula 7.1.0
 */
@OnlyIn(Dist.CLIENT)
public class EndTrollBoxModel extends Model
{
	public RendererModel base;
    public RendererModel bottom_front_left;
    public RendererModel bottom_back_left;
    public RendererModel bottom_front_right;
    public RendererModel bottom_back_right;
    public RendererModel top_front_left;
    public RendererModel top_back_left;
    public RendererModel top_back_right;
    public RendererModel top_front_left_1;
    public RendererModel lid_top_left;
    public RendererModel lid_top_right;
    public RendererModel lid_front;
    public RendererModel lid_left;
    public RendererModel lid_back;
    public RendererModel lid_right;
    public RendererModel decoration_front_right;
    public RendererModel decoration_front_left;
    public RendererModel decoration_back_left;
    public RendererModel decoration_back_right;

    public EndTrollBoxModel()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.bottom_front_left = new RendererModel(this, 0, 23);
        this.bottom_front_left.setRotationPoint(6.5F, 24.0F, -6.5F);
        this.bottom_front_left.addBox(-3.0F, -3.0F, 0.0F, 3, 3, 3, 0.0F);
        this.decoration_back_left = new RendererModel(this, 0, 3);
        this.decoration_back_left.setRotationPoint(6.0F, 13.5F, 6.0F);
        this.decoration_back_left.addBox(-1.0F, -1.0F, -1.0F, 1, 1, 1, 0.0F);
        this.base = new RendererModel(this, 0, 0);
        this.base.setRotationPoint(0.0F, 23.5F, 0.0F);
        this.base.addBox(-6.0F, -10.0F, -6.0F, 12, 10, 12, 0.0F);
        this.top_front_left_1 = new RendererModel(this, 26, 23);
        this.top_front_left_1.setRotationPoint(6.5F, 11.0F, -6.5F);
        this.top_front_left_1.addBox(-3.0F, 0.0F, 0.0F, 3, 3, 3, 0.0F);
        this.lid_front = new RendererModel(this, 0, 37);
        this.lid_front.setRotationPoint(0.0F, 13.5F, -6.0F);
        this.lid_front.addBox(-5.0F, -2.0F, 0.0F, 10, 2, 1, 0.0F);
        this.bottom_back_right = new RendererModel(this, 13, 30);
        this.bottom_back_right.setRotationPoint(-6.5F, 24.0F, 6.5F);
        this.bottom_back_right.addBox(0.0F, -3.0F, -3.0F, 3, 3, 3, 0.0F);
        this.top_back_left = new RendererModel(this, 26, 30);
        this.top_back_left.setRotationPoint(6.5F, 11.0F, 6.5F);
        this.top_back_left.addBox(-3.0F, 0.0F, -3.0F, 3, 3, 3, 0.0F);
        this.decoration_front_right = new RendererModel(this, 0, 0);
        this.decoration_front_right.setRotationPoint(-6.0F, 13.5F, -6.0F);
        this.decoration_front_right.addBox(0.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F);
        this.top_front_left = new RendererModel(this, 39, 23);
        this.top_front_left.setRotationPoint(-6.5F, 11.0F, -6.5F);
        this.top_front_left.addBox(0.0F, 0.0F, 0.0F, 3, 3, 3, 0.0F);
        this.bottom_front_right = new RendererModel(this, 13, 23);
        this.bottom_front_right.setRotationPoint(-6.5F, 24.0F, -6.5F);
        this.bottom_front_right.addBox(0.0F, -3.0F, 0.0F, 3, 3, 3, 0.0F);
        this.bottom_back_left = new RendererModel(this, 0, 30);
        this.bottom_back_left.setRotationPoint(6.5F, 24.0F, 6.5F);
        this.bottom_back_left.addBox(-3.0F, -3.0F, -3.0F, 3, 3, 3, 0.0F);
        this.top_back_right = new RendererModel(this, 39, 30);
        this.top_back_right.setRotationPoint(-6.5F, 11.0F, 6.5F);
        this.top_back_right.addBox(0.0F, 0.0F, -3.0F, 3, 3, 3, 0.0F);
        this.lid_top_right = new RendererModel(this, 31, 41);
        this.lid_top_right.setRotationPoint(-6.0F, 11.5F, 0.0F);
        this.lid_top_right.addBox(0.0F, 0.0F, -5.0F, 6, 1, 10, 0.0F);
        this.lid_top_left = new RendererModel(this, 0, 53);
        this.lid_top_left.setRotationPoint(6.0F, 11.5F, 0.0F);
        this.lid_top_left.addBox(-6.0F, 0.0F, -5.0F, 6, 1, 10, 0.0F);
        this.decoration_front_left = new RendererModel(this, 5, 0);
        this.decoration_front_left.setRotationPoint(6.0F, 13.5F, -6.0F);
        this.decoration_front_left.addBox(-1.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F);
        this.lid_left = new RendererModel(this, 0, 41);
        this.lid_left.setRotationPoint(6.0F, 13.5F, 0.0F);
        this.lid_left.addBox(-1.0F, -2.0F, -5.0F, 1, 2, 10, 0.0F);
        this.lid_back = new RendererModel(this, 23, 37);
        this.lid_back.setRotationPoint(0.0F, 13.5F, 6.0F);
        this.lid_back.addBox(-5.0F, -2.0F, -1.0F, 10, 2, 1, 0.0F);
        this.lid_right = new RendererModel(this, 42, 0);
        this.lid_right.setRotationPoint(-6.0F, 13.5F, 0.0F);
        this.lid_right.addBox(0.0F, -2.0F, -5.0F, 1, 2, 10, 0.0F);
        this.decoration_back_right = new RendererModel(this, 5, 3);
        this.decoration_back_right.setRotationPoint(-6.0F, 13.5F, 6.0F);
        this.decoration_back_right.addBox(0.0F, -1.0F, -1.0F, 1, 1, 1, 0.0F);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(RendererModel RendererModel, float x, float y, float z)
    {
        RendererModel.rotateAngleX = x;
        RendererModel.rotateAngleY = y;
        RendererModel.rotateAngleZ = z;
    }
}