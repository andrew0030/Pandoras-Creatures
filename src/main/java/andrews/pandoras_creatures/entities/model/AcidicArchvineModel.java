package andrews.pandoras_creatures.entities.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import andrews.pandoras_creatures.entities.AcidicArchvineEntity;
import andrews.pandoras_creatures.util.animation.PCEntityModel;
import andrews.pandoras_creatures.util.animation.PCModelRenderer;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * AcidicArchvineModel - andrew0030
 * Created using Tabula 7.0.0
 */
@OnlyIn(Dist.CLIENT)
public class AcidicArchvineModel<T extends AcidicArchvineEntity> extends PCEntityModel<T>
{
    public PCModelRenderer base;
    public PCModelRenderer acid_blob_holder;
    public PCModelRenderer tongue_1;
    public PCModelRenderer root_front;
    public PCModelRenderer root_back;
    public PCModelRenderer root_right;
    public PCModelRenderer root_left;
    public PCModelRenderer rotation_point_front_right;
    public PCModelRenderer rotation_point_front_left;
    public PCModelRenderer rotation_point_back_right;
    public PCModelRenderer rotation_point_back_left;
    public PCModelRenderer leaf_right;
    public PCModelRenderer leaf_left;
    public PCModelRenderer leaf_front;
    public PCModelRenderer leaf_back;
    public PCModelRenderer base_top;
    public PCModelRenderer root_front_right;
    public PCModelRenderer leaf_front_right;
    public PCModelRenderer leaf_front_right_top;
    public PCModelRenderer root_front_left;
    public PCModelRenderer leaf_front_left;
    public PCModelRenderer leaf_front_left_top;
    public PCModelRenderer root_back_right;
    public PCModelRenderer leaf_back_right;
    public PCModelRenderer leaf_back_right_top;
    public PCModelRenderer root_back_left;
    public PCModelRenderer leaft_back_left;
    public PCModelRenderer leaft_back_left_top;
    public PCModelRenderer leaf_right_top;
    public PCModelRenderer leaf_left_top;
    public PCModelRenderer leaf_front_top;
    public PCModelRenderer leaf_back_top;
    public PCModelRenderer top_front_base;
    public PCModelRenderer top_back_base;
    public PCModelRenderer top_left_base;
    public PCModelRenderer top_right_base;
    public PCModelRenderer top_front_1;
    public PCModelRenderer top_front_2;
    public PCModelRenderer top_front_1_right;
    public PCModelRenderer top_front_1_left;
    public PCModelRenderer tooth_front_1;
    public PCModelRenderer top_front_3;
    public PCModelRenderer tooth_front_2;
    public PCModelRenderer top_front_3_right;
    public PCModelRenderer top_front_3_left;
    public PCModelRenderer top_front_4;
    public PCModelRenderer tooth_front_3;
    public PCModelRenderer top_front_4_left;
    public PCModelRenderer top_front_4_right;
    public PCModelRenderer top_front_4_top;
    public PCModelRenderer top_back_1;
    public PCModelRenderer top_back_2;
    public PCModelRenderer top_back_1_right;
    public PCModelRenderer top_back_1_left;
    public PCModelRenderer tooth_back_1;
    public PCModelRenderer top_back_3;
    public PCModelRenderer tooth_back_2;
    public PCModelRenderer top_back_3_right;
    public PCModelRenderer top_back_3_left;
    public PCModelRenderer top_back_4;
    public PCModelRenderer tooth_back_3;
    public PCModelRenderer top_back_4_left;
    public PCModelRenderer top_back_4_right;
    public PCModelRenderer top_back_4_top;
    public PCModelRenderer top_left_1;
    public PCModelRenderer top_left_2;
    public PCModelRenderer top_left_1_right;
    public PCModelRenderer top_left_1_left;
    public PCModelRenderer tooth_left_1;
    public PCModelRenderer top_left_3;
    public PCModelRenderer tooth_left_2;
    public PCModelRenderer top_left_3_right;
    public PCModelRenderer top_left_3_left;
    public PCModelRenderer top_left_4;
    public PCModelRenderer tooth_left_3;
    public PCModelRenderer top_left_4_left;
    public PCModelRenderer top_left_4_right;
    public PCModelRenderer top_left_4_top;
    public PCModelRenderer top_right_1;
    public PCModelRenderer top_right_2;
    public PCModelRenderer top_right_1_right;
    public PCModelRenderer top_right_1_left;
    public PCModelRenderer tooth_right_1;
    public PCModelRenderer top_right_3;
    public PCModelRenderer tooth_right_2;
    public PCModelRenderer top_right_3_right;
    public PCModelRenderer top_right_3_left;
    public PCModelRenderer top_right_4;
    public PCModelRenderer tooth_right_3;
    public PCModelRenderer top_right_4_left;
    public PCModelRenderer top_right_4_right;
    public PCModelRenderer top_right_4_top;
    public PCModelRenderer acid_blob;
    public PCModelRenderer tongue_2;
    public PCModelRenderer tongue_3;
    public PCModelRenderer tongue_4;
    
    private float partialTicks;

    public AcidicArchvineModel() {
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.rotation_point_front_left = new PCModelRenderer(this, 247, 21);
        this.rotation_point_front_left.setRotationPoint(3.0F, 6.2F, -3.0F);
        this.rotation_point_front_left.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotateAngle(rotation_point_front_left, 0.0F, 0.7853981633974483F, 0.0F);
        this.top_front_1 = new PCModelRenderer(this, 124, 119);
        this.top_front_1.setRotationPoint(0.0F, -1.0F, -2.0F);
        this.top_front_1.addBox(-2.0F, -4.0F, -2.0F, 4, 4, 2, 0.0F);
        this.setRotateAngle(top_front_1, 0.7853981633974483F, 0.0F, 0.0F);
        this.tongue_4 = new PCModelRenderer(this, 187, 89);
        this.tongue_4.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.tongue_4.addBox(-0.5F, -8.0F, -0.5F, 1, 8, 1, 0.0F);
        this.tongue_1 = new PCModelRenderer(this, 187, 119);
        this.tongue_1.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.tongue_1.addBox(-0.5F, -8.0F, -0.5F, 1, 8, 1, 0.0F);
        this.leaf_front_left_top = new PCModelRenderer(this, 157, 32);
        this.leaf_front_left_top.setRotationPoint(-1.0F, -0.8F, 0.0F);
        this.leaf_front_left_top.addBox(0.0F, 0.0F, -2.5F, 7, 1, 5, 0.0F);
        this.setRotateAngle(leaf_front_left_top, 0.0F, 0.2792526803190927F, -0.08726646259971647F);
        this.top_front_3 = new PCModelRenderer(this, 124, 102);
        this.top_front_3.setRotationPoint(0.0F, -6.0F, 0.0F);
        this.top_front_3.addBox(-2.0F, -5.0F, 0.0F, 4, 5, 2, 0.0F);
        this.setRotateAngle(top_front_3, -0.6108652381980153F, 0.0F, 0.0F);
        this.tooth_back_2 = new PCModelRenderer(this, 10, 5);
        this.tooth_back_2.setRotationPoint(0.0F, -2.0F, 2.0F);
        this.tooth_back_2.addBox(-0.5F, -2.2F, -1.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(tooth_back_2, -0.9599310885968813F, 0.0F, 0.0F);
        this.leaf_front_right_top = new PCModelRenderer(this, 182, 32);
        this.leaf_front_right_top.setRotationPoint(1.0F, -0.8F, 0.0F);
        this.leaf_front_right_top.addBox(-7.0F, 0.0F, -2.5F, 7, 1, 5, 0.0F);
        this.setRotateAngle(leaf_front_right_top, 0.0F, 0.2792526803190927F, 0.08726646259971647F);
        this.leaf_back = new PCModelRenderer(this, 207, 46);
        this.leaf_back.setRotationPoint(0.0F, 5.7F, 3.0F);
        this.leaf_back.addBox(-2.5F, -0.5F, 0.0F, 5, 1, 7, 0.0F);
        this.setRotateAngle(leaf_back, -0.17453292519943295F, -0.13962634015954636F, 0.0F);
        this.tooth_back_3 = new PCModelRenderer(this, 10, 10);
        this.tooth_back_3.setRotationPoint(0.0F, -1.0F, 2.0F);
        this.tooth_back_3.addBox(-0.5F, -2.6F, -1.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(tooth_back_3, -0.5235987755982988F, 0.0F, 0.0F);
        this.top_left_3_right = new PCModelRenderer(this, 69, 102);
        this.top_left_3_right.setRotationPoint(2.0F, -5.0F, 0.01F);
        this.top_left_3_right.addBox(-2.0F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(top_left_3_right, 0.0F, 0.0F, -0.296705972839036F);
        this.top_front_4_left = new PCModelRenderer(this, 121, 97);
        this.top_front_4_left.setRotationPoint(1.5F, -1.0F, 0.02F);
        this.top_front_4_left.addBox(-1.0F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(top_front_4_left, 0.0F, 0.0F, -0.3490658503988659F);
        this.leaf_front_left = new PCModelRenderer(this, 207, 32);
        this.leaf_front_left.setRotationPoint(0.0F, -0.5F, 0.0F);
        this.leaf_front_left.addBox(0.0F, 0.0F, -2.5F, 7, 1, 5, 0.0F);
        this.setRotateAngle(leaf_front_left, 0.0F, -0.13962634015954636F, 0.17453292519943295F);
        this.leaf_front_top = new PCModelRenderer(this, 182, 46);
        this.leaf_front_top.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leaf_front_top.addBox(-2.5F, -1.1F, -7.0F, 5, 1, 7, 0.0F);
        this.setRotateAngle(leaf_front_top, -0.17453292519943295F, 0.2792526803190927F, 0.0F);
        this.root_front_right = new PCModelRenderer(this, 244, 24);
        this.root_front_right.setRotationPoint(-0.5F, 0.0F, 0.0F);
        this.root_front_right.addBox(-4.0F, 0.0F, -1.0F, 4, 1, 2, 0.0F);
        this.setRotateAngle(root_front_right, 0.0F, 0.0F, -0.47123889803846897F);
        this.leaf_right_top = new PCModelRenderer(this, 182, 55);
        this.leaf_right_top.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leaf_right_top.addBox(0.0F, -1.1F, -2.5F, 7, 1, 5, 0.0F);
        this.setRotateAngle(leaf_right_top, 0.0F, 0.2792526803190927F, -0.17453292519943295F);
        this.top_left_2 = new PCModelRenderer(this, 53, 110);
        this.top_left_2.setRotationPoint(0.0F, -4.0F, -2.0F);
        this.top_left_2.addBox(-3.5F, -6.0F, 0.0F, 7, 6, 2, 0.0F);
        this.setRotateAngle(top_left_2, -0.5235987755982988F, 0.0F, 0.0F);
        this.top_right_4_top = new PCModelRenderer(this, 25, 93);
        this.top_right_4_top.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.top_right_4_top.addBox(-0.5F, -3.0F, -1.0F, 1, 3, 2, 0.0F);
        this.setRotateAngle(top_right_4_top, -0.17453292519943295F, 0.0F, 0.0F);
        this.top_front_1_right = new PCModelRenderer(this, 137, 119);
        this.top_front_1_right.setRotationPoint(-2.0F, 0.0F, 0.01F);
        this.top_front_1_right.addBox(0.0F, -4.0F, -2.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(top_front_1_right, 0.0F, 0.0F, -0.40142572795869574F);
        this.top_back_2 = new PCModelRenderer(this, 87, 110);
        this.top_back_2.setRotationPoint(0.0F, -4.0F, -2.0F);
        this.top_back_2.addBox(-3.5F, -6.0F, 0.0F, 7, 6, 2, 0.0F);
        this.setRotateAngle(top_back_2, -0.5235987755982988F, 0.0F, 0.0F);
        this.leaf_left = new PCModelRenderer(this, 207, 55);
        this.leaf_left.setRotationPoint(-3.0F, 5.7F, 0.0F);
        this.leaf_left.addBox(-7.0F, -0.5F, -2.5F, 7, 1, 5, 0.0F);
        this.setRotateAngle(leaf_left, 0.0F, -0.13962634015954636F, -0.17453292519943295F);
        this.top_right_base = new PCModelRenderer(this, 23, 126);
        this.top_right_base.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.top_right_base.addBox(-2.0F, -1.0F, -3.0F, 4, 1, 1, 0.0F);
        this.setRotateAngle(top_right_base, 0.0F, 1.5707963267948966F, 0.0F);
        this.top_left_3_left = new PCModelRenderer(this, 47, 102);
        this.top_left_3_left.setRotationPoint(-2.0F, -5.0F, 0.01F);
        this.top_left_3_left.addBox(0.0F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(top_left_3_left, 0.0F, 0.0F, 0.296705972839036F);
        this.top_left_3 = new PCModelRenderer(this, 56, 102);
        this.top_left_3.setRotationPoint(0.0F, -6.0F, 0.0F);
        this.top_left_3.addBox(-2.0F, -5.0F, 0.0F, 4, 5, 2, 0.0F);
        this.setRotateAngle(top_left_3, -0.6108652381980153F, 0.0F, 0.0F);
        this.top_right_4 = new PCModelRenderer(this, 24, 99);
        this.top_right_4.setRotationPoint(0.0F, -4.7F, 1.0F);
        this.top_right_4.addBox(-1.5F, -1.0F, -0.5F, 3, 1, 1, 0.0F);
        this.setRotateAngle(top_right_4, -0.3141592653589793F, 0.0F, 0.0F);
        this.rotation_point_front_right = new PCModelRenderer(this, 252, 21);
        this.rotation_point_front_right.setRotationPoint(-3.0F, 6.2F, -3.0F);
        this.rotation_point_front_right.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotateAngle(rotation_point_front_right, 0.0F, -0.7853981633974483F, 0.0F);
        this.top_left_4 = new PCModelRenderer(this, 58, 99);
        this.top_left_4.setRotationPoint(0.0F, -4.7F, 1.0F);
        this.top_left_4.addBox(-1.5F, -1.0F, -0.5F, 3, 1, 1, 0.0F);
        this.setRotateAngle(top_left_4, -0.3141592653589793F, 0.0F, 0.0F);
        this.tongue_3 = new PCModelRenderer(this, 187, 99);
        this.tongue_3.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.tongue_3.addBox(-0.5F, -8.0F, -0.5F, 1, 8, 1, 0.0F);
        this.top_right_1_right = new PCModelRenderer(this, 35, 119);
        this.top_right_1_right.setRotationPoint(-2.0F, 0.0F, 0.01F);
        this.top_right_1_right.addBox(0.0F, -4.0F, -2.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(top_right_1_right, 0.0F, 0.0F, -0.40142572795869574F);
        this.tooth_front_2 = new PCModelRenderer(this, 15, 5);
        this.tooth_front_2.setRotationPoint(0.0F, -2.0F, 2.0F);
        this.tooth_front_2.addBox(-0.5F, -2.2F, -1.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(tooth_front_2, -0.9599310885968813F, 0.0F, 0.0F);
        this.tooth_front_3 = new PCModelRenderer(this, 15, 10);
        this.tooth_front_3.setRotationPoint(0.0F, -1.0F, 2.0F);
        this.tooth_front_3.addBox(-0.5F, -2.6F, -1.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(tooth_front_3, -0.5235987755982988F, 0.0F, 0.0F);
        this.leaft_back_left_top = new PCModelRenderer(this, 157, 39);
        this.leaft_back_left_top.setRotationPoint(-1.0F, -0.8F, 0.0F);
        this.leaft_back_left_top.addBox(0.0F, 0.0F, -2.5F, 7, 1, 5, 0.0F);
        this.setRotateAngle(leaft_back_left_top, 0.0F, 0.2792526803190927F, -0.08726646259971647F);
        this.leaf_front_right = new PCModelRenderer(this, 232, 32);
        this.leaf_front_right.setRotationPoint(0.0F, -0.5F, 0.0F);
        this.leaf_front_right.addBox(-7.0F, 0.0F, -2.5F, 7, 1, 5, 0.0F);
        this.setRotateAngle(leaf_front_right, 0.0F, -0.13962634015954636F, -0.17453292519943295F);
        this.top_front_4_top = new PCModelRenderer(this, 127, 93);
        this.top_front_4_top.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.top_front_4_top.addBox(-0.5F, -3.0F, -1.0F, 1, 3, 2, 0.0F);
        this.setRotateAngle(top_front_4_top, -0.17453292519943295F, 0.0F, 0.0F);
        this.tooth_left_2 = new PCModelRenderer(this, 5, 5);
        this.tooth_left_2.setRotationPoint(0.0F, -2.0F, 2.0F);
        this.tooth_left_2.addBox(-0.5F, -2.2F, -1.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(tooth_left_2, -0.9599310885968813F, 0.0F, 0.0F);
        this.root_right = new PCModelRenderer(this, 244, 17);
        this.root_right.setRotationPoint(-4.0F, 6.2F, 0.0F);
        this.root_right.addBox(-4.0F, 0.0F, -1.0F, 4, 1, 2, 0.0F);
        this.setRotateAngle(root_right, 0.0F, 0.0F, -0.47123889803846897F);
        this.top_front_4 = new PCModelRenderer(this, 126, 99);
        this.top_front_4.setRotationPoint(0.0F, -4.7F, 1.0F);
        this.top_front_4.addBox(-1.5F, -1.0F, -0.5F, 3, 1, 1, 0.0F);
        this.setRotateAngle(top_front_4, -0.3141592653589793F, 0.0F, 0.0F);
        this.leaf_back_top = new PCModelRenderer(this, 157, 46);
        this.leaf_back_top.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leaf_back_top.addBox(-2.5F, -1.1F, 0.0F, 5, 1, 7, 0.0F);
        this.setRotateAngle(leaf_back_top, 0.17453292519943295F, 0.2792526803190927F, 0.0F);
        this.top_back_3 = new PCModelRenderer(this, 90, 102);
        this.top_back_3.setRotationPoint(0.0F, -6.0F, 0.0F);
        this.top_back_3.addBox(-2.0F, -5.0F, 0.0F, 4, 5, 2, 0.0F);
        this.setRotateAngle(top_back_3, -0.6108652381980153F, 0.0F, 0.0F);
        this.root_front = new PCModelRenderer(this, 244, 11);
        this.root_front.setRotationPoint(0.0F, 6.2F, -4.0F);
        this.root_front.addBox(-1.0F, 0.0F, -4.0F, 2, 1, 4, 0.0F);
        this.setRotateAngle(root_front, 0.47123889803846897F, 0.0F, 0.0F);
        this.top_back_base = new PCModelRenderer(this, 91, 126);
        this.top_back_base.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.top_back_base.addBox(-2.0F, -1.0F, -3.0F, 4, 1, 1, 0.0F);
        this.setRotateAngle(top_back_base, 0.0F, 3.141592653589793F, 0.0F);
        this.top_back_3_right = new PCModelRenderer(this, 103, 102);
        this.top_back_3_right.setRotationPoint(2.0F, -5.0F, 0.01F);
        this.top_back_3_right.addBox(-2.0F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(top_back_3_right, 0.0F, 0.0F, -0.296705972839036F);
        this.top_back_3_left = new PCModelRenderer(this, 81, 102);
        this.top_back_3_left.setRotationPoint(-2.0F, -5.0F, 0.01F);
        this.top_back_3_left.addBox(0.0F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(top_back_3_left, 0.0F, 0.0F, 0.296705972839036F);
        this.tooth_left_3 = new PCModelRenderer(this, 5, 10);
        this.tooth_left_3.setRotationPoint(0.0F, -1.0F, 2.0F);
        this.tooth_left_3.addBox(-0.5F, -2.6F, -1.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(tooth_left_3, -0.5235987755982988F, 0.0F, 0.0F);
        this.leaft_back_left = new PCModelRenderer(this, 207, 39);
        this.leaft_back_left.setRotationPoint(0.0F, -0.5F, 0.0F);
        this.leaft_back_left.addBox(0.0F, 0.0F, -2.5F, 7, 1, 5, 0.0F);
        this.setRotateAngle(leaft_back_left, 0.0F, -0.13962634015954636F, 0.17453292519943295F);
        this.leaf_left_top = new PCModelRenderer(this, 157, 55);
        this.leaf_left_top.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leaf_left_top.addBox(-7.0F, -1.1F, -2.5F, 7, 1, 5, 0.0F);
        this.setRotateAngle(leaf_left_top, 0.0F, 0.2792526803190927F, 0.17453292519943295F);
        this.top_left_1_right = new PCModelRenderer(this, 69, 119);
        this.top_left_1_right.setRotationPoint(-2.0F, 0.0F, 0.01F);
        this.top_left_1_right.addBox(0.0F, -4.0F, -2.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(top_left_1_right, 0.0F, 0.0F, -0.40142572795869574F);
        this.leaf_front = new PCModelRenderer(this, 232, 46);
        this.leaf_front.setRotationPoint(0.0F, 5.7F, -3.0F);
        this.leaf_front.addBox(-2.5F, -0.5F, -7.0F, 5, 1, 7, 0.0F);
        this.setRotateAngle(leaf_front, 0.17453292519943295F, -0.13962634015954636F, 0.0F);
        this.top_back_4_left = new PCModelRenderer(this, 87, 97);
        this.top_back_4_left.setRotationPoint(1.5F, -1.0F, 0.02F);
        this.top_back_4_left.addBox(-1.0F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(top_back_4_left, 0.0F, 0.0F, -0.3490658503988659F);
        this.root_left = new PCModelRenderer(this, 231, 17);
        this.root_left.setRotationPoint(4.0F, 6.2F, 0.0F);
        this.root_left.addBox(0.0F, 0.0F, -1.0F, 4, 1, 2, 0.0F);
        this.setRotateAngle(root_left, 0.0F, 0.0F, 0.47123889803846897F);
        this.tooth_back_1 = new PCModelRenderer(this, 10, 0);
        this.tooth_back_1.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.tooth_back_1.addBox(-0.5F, -1.4F, -1.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(tooth_back_1, -1.1344640137963142F, 0.0F, 0.0F);
        this.root_back = new PCModelRenderer(this, 231, 11);
        this.root_back.setRotationPoint(0.0F, 6.2F, 4.0F);
        this.root_back.addBox(-1.0F, 0.0F, 0.0F, 2, 1, 4, 0.0F);
        this.setRotateAngle(root_back, -0.47123889803846897F, 0.0F, 0.0F);
        this.top_right_3 = new PCModelRenderer(this, 22, 102);
        this.top_right_3.setRotationPoint(0.0F, -6.0F, 0.0F);
        this.top_right_3.addBox(-2.0F, -5.0F, 0.0F, 4, 5, 2, 0.0F);
        this.setRotateAngle(top_right_3, -0.6108652381980153F, 0.0F, 0.0F);
        this.top_back_4_top = new PCModelRenderer(this, 93, 93);
        this.top_back_4_top.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.top_back_4_top.addBox(-0.5F, -3.0F, -1.0F, 1, 3, 2, 0.0F);
        this.setRotateAngle(top_back_4_top, -0.17453292519943295F, 0.0F, 0.0F);
        this.tooth_left_1 = new PCModelRenderer(this, 5, 0);
        this.tooth_left_1.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.tooth_left_1.addBox(-0.5F, -1.4F, -1.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(tooth_left_1, -1.1344640137963142F, 0.0F, 0.0F);
        this.top_right_3_right = new PCModelRenderer(this, 35, 102);
        this.top_right_3_right.setRotationPoint(2.0F, -5.0F, 0.01F);
        this.top_right_3_right.addBox(-2.0F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(top_right_3_right, 0.0F, 0.0F, -0.296705972839036F);
        this.top_back_4_right = new PCModelRenderer(this, 101, 97);
        this.top_back_4_right.setRotationPoint(-1.5F, -1.0F, 0.01F);
        this.top_back_4_right.addBox(0.0F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(top_back_4_right, 0.0F, 0.0F, 0.3490658503988659F);
        this.top_back_1 = new PCModelRenderer(this, 90, 119);
        this.top_back_1.setRotationPoint(0.0F, -1.0F, -2.0F);
        this.top_back_1.addBox(-2.0F, -4.0F, -2.0F, 4, 4, 2, 0.0F);
        this.setRotateAngle(top_back_1, 0.7853981633974483F, 0.0F, 0.0F);
        this.top_right_4_right = new PCModelRenderer(this, 33, 97);
        this.top_right_4_right.setRotationPoint(-1.5F, -1.0F, 0.01F);
        this.top_right_4_right.addBox(0.0F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(top_right_4_right, 0.0F, 0.0F, 0.3490658503988659F);
        this.top_front_1_left = new PCModelRenderer(this, 115, 119);
        this.top_front_1_left.setRotationPoint(2.0F, 0.0F, 0.01F);
        this.top_front_1_left.addBox(-2.0F, -4.0F, -2.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(top_front_1_left, 0.0F, 0.0F, 0.40142572795869574F);
        this.base = new PCModelRenderer(this, 224, 0);
        this.base.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.base.addBox(-4.0F, 6.0F, -4.0F, 8, 2, 8, 0.0F);
        this.top_left_base = new PCModelRenderer(this, 57, 126);
        this.top_left_base.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.top_left_base.addBox(-2.0F, -1.0F, -3.0F, 4, 1, 1, 0.0F);
        this.setRotateAngle(top_left_base, 0.0F, -1.5707963267948966F, 0.0F);
        this.top_back_1_left = new PCModelRenderer(this, 81, 119);
        this.top_back_1_left.setRotationPoint(2.0F, 0.0F, 0.01F);
        this.top_back_1_left.addBox(-2.0F, -4.0F, -2.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(top_back_1_left, 0.0F, 0.0F, 0.40142572795869574F);
        this.top_right_2 = new PCModelRenderer(this, 19, 110);
        this.top_right_2.setRotationPoint(0.0F, -4.0F, -2.0F);
        this.top_right_2.addBox(-3.5F, -6.0F, 0.0F, 7, 6, 2, 0.0F);
        this.setRotateAngle(top_right_2, -0.5235987755982988F, 0.0F, 0.0F);
        this.rotation_point_back_left = new PCModelRenderer(this, 237, 21);
        this.rotation_point_back_left.setRotationPoint(3.0F, 6.2F, 3.0F);
        this.rotation_point_back_left.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotateAngle(rotation_point_back_left, 0.0F, -0.7853981633974483F, 0.0F);
        this.leaf_right = new PCModelRenderer(this, 232, 55);
        this.leaf_right.setRotationPoint(3.0F, 5.7F, 0.0F);
        this.leaf_right.addBox(0.0F, -0.5F, -2.5F, 7, 1, 5, 0.0F);
        this.setRotateAngle(leaf_right, 0.0F, -0.13962634015954636F, 0.17453292519943295F);
        this.top_left_4_left = new PCModelRenderer(this, 53, 97);
        this.top_left_4_left.setRotationPoint(1.5F, -1.0F, 0.02F);
        this.top_left_4_left.addBox(-1.0F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(top_left_4_left, 0.0F, 0.0F, -0.3490658503988659F);
        this.leaf_back_right = new PCModelRenderer(this, 232, 39);
        this.leaf_back_right.setRotationPoint(0.0F, -0.5F, 0.0F);
        this.leaf_back_right.addBox(-7.0F, 0.0F, -2.5F, 7, 1, 5, 0.0F);
        this.setRotateAngle(leaf_back_right, 0.0F, -0.13962634015954636F, -0.17453292519943295F);
        this.top_front_3_left = new PCModelRenderer(this, 115, 102);
        this.top_front_3_left.setRotationPoint(-2.0F, -5.0F, 0.01F);
        this.top_front_3_left.addBox(0.0F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(top_front_3_left, 0.0F, 0.0F, 0.296705972839036F);
        this.tooth_right_1 = new PCModelRenderer(this, 0, 0);
        this.tooth_right_1.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.tooth_right_1.addBox(-0.5F, -1.4F, -1.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(tooth_right_1, -1.1344640137963142F, 0.0F, 0.0F);
        this.tooth_right_3 = new PCModelRenderer(this, 0, 10);
        this.tooth_right_3.setRotationPoint(0.0F, -1.0F, 2.0F);
        this.tooth_right_3.addBox(-0.5F, -2.6F, -1.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(tooth_right_3, -0.5235987755982988F, 0.0F, 0.0F);
        this.root_front_left = new PCModelRenderer(this, 231, 24);
        this.root_front_left.setRotationPoint(0.5F, 0.0F, 0.0F);
        this.root_front_left.addBox(0.0F, 0.0F, -1.0F, 4, 1, 2, 0.0F);
        this.setRotateAngle(root_front_left, 0.0F, 0.0F, 0.47123889803846897F);
        this.top_front_2 = new PCModelRenderer(this, 121, 110);
        this.top_front_2.setRotationPoint(0.0F, -4.0F, -2.0F);
        this.top_front_2.addBox(-3.5F, -6.0F, 0.0F, 7, 6, 2, 0.0F);
        this.setRotateAngle(top_front_2, -0.5235987755982988F, 0.0F, 0.0F);
        this.tongue_2 = new PCModelRenderer(this, 187, 109);
        this.tongue_2.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.tongue_2.addBox(-0.5F, -8.0F, -0.5F, 1, 8, 1, 0.0F);
        this.acid_blob_holder = new PCModelRenderer(this, 232, 86);
        this.acid_blob_holder.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.acid_blob_holder.addBox(-3.0F, 1.0F, -3.0F, 6, 3, 6, 0.0F);
        this.tooth_front_1 = new PCModelRenderer(this, 15, 0);
        this.tooth_front_1.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.tooth_front_1.addBox(-0.5F, -1.4F, -1.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(tooth_front_1, -1.1344640137963142F, 0.0F, 0.0F);
        this.top_back_4 = new PCModelRenderer(this, 92, 99);
        this.top_back_4.setRotationPoint(0.0F, -4.7F, 1.0F);
        this.top_back_4.addBox(-1.5F, -1.0F, -0.5F, 3, 1, 1, 0.0F);
        this.setRotateAngle(top_back_4, -0.3141592653589793F, 0.0F, 0.0F);
        this.top_left_4_top = new PCModelRenderer(this, 59, 93);
        this.top_left_4_top.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.top_left_4_top.addBox(-0.5F, -3.0F, -1.0F, 1, 3, 2, 0.0F);
        this.setRotateAngle(top_left_4_top, -0.17453292519943295F, 0.0F, 0.0F);
        this.top_right_3_left = new PCModelRenderer(this, 13, 102);
        this.top_right_3_left.setRotationPoint(-2.0F, -5.0F, 0.01F);
        this.top_right_3_left.addBox(0.0F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(top_right_3_left, 0.0F, 0.0F, 0.296705972839036F);
        this.acid_blob = new PCModelRenderer(this, 192, 96);
        this.acid_blob.setRotationPoint(0.0F, 0.01F, 0.0F);
        this.acid_blob.addBox(-8.0F, -15.0F, -8.0F, 16, 16, 16, 0.0F);
        this.top_left_1 = new PCModelRenderer(this, 56, 119);
        this.top_left_1.setRotationPoint(0.0F, -1.0F, -2.0F);
        this.top_left_1.addBox(-2.0F, -4.0F, -2.0F, 4, 4, 2, 0.0F);
        this.setRotateAngle(top_left_1, 0.7853981633974483F, 0.0F, 0.0F);
        this.top_left_1_left = new PCModelRenderer(this, 47, 119);
        this.top_left_1_left.setRotationPoint(2.0F, 0.0F, 0.01F);
        this.top_left_1_left.addBox(-2.0F, -4.0F, -2.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(top_left_1_left, 0.0F, 0.0F, 0.40142572795869574F);
        this.root_back_right = new PCModelRenderer(this, 244, 28);
        this.root_back_right.setRotationPoint(-0.5F, 0.0F, 0.0F);
        this.root_back_right.addBox(-4.0F, 0.0F, -1.0F, 4, 1, 2, 0.0F);
        this.setRotateAngle(root_back_right, 0.0F, 0.0F, -0.47123889803846897F);
        this.tooth_right_2 = new PCModelRenderer(this, 0, 5);
        this.tooth_right_2.setRotationPoint(0.0F, -2.0F, 2.0F);
        this.tooth_right_2.addBox(-0.5F, -2.2F, -1.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(tooth_right_2, -0.9599310885968813F, 0.0F, 0.0F);
        this.top_front_4_right = new PCModelRenderer(this, 135, 97);
        this.top_front_4_right.setRotationPoint(-1.5F, -1.0F, 0.01F);
        this.top_front_4_right.addBox(0.0F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(top_front_4_right, 0.0F, 0.0F, 0.3490658503988659F);
        this.top_left_4_right = new PCModelRenderer(this, 67, 97);
        this.top_left_4_right.setRotationPoint(-1.5F, -1.0F, 0.01F);
        this.top_left_4_right.addBox(0.0F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(top_left_4_right, 0.0F, 0.0F, 0.3490658503988659F);
        this.root_back_left = new PCModelRenderer(this, 231, 28);
        this.root_back_left.setRotationPoint(0.5F, 0.0F, 0.0F);
        this.root_back_left.addBox(0.0F, 0.0F, -1.0F, 4, 1, 2, 0.0F);
        this.setRotateAngle(root_back_left, 0.0F, 0.0F, 0.47123889803846897F);
        this.top_right_4_left = new PCModelRenderer(this, 19, 97);
        this.top_right_4_left.setRotationPoint(1.5F, -1.0F, 0.02F);
        this.top_right_4_left.addBox(-1.0F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(top_right_4_left, 0.0F, 0.0F, -0.3490658503988659F);
        this.base_top = new PCModelRenderer(this, 199, 0);
        this.base_top.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.base_top.addBox(-3.0F, 4.5F, -3.0F, 6, 2, 6, 0.0F);
        this.leaf_back_right_top = new PCModelRenderer(this, 182, 39);
        this.leaf_back_right_top.setRotationPoint(1.0F, -0.8F, 0.0F);
        this.leaf_back_right_top.addBox(-7.0F, 0.0F, -2.5F, 7, 1, 5, 0.0F);
        this.setRotateAngle(leaf_back_right_top, 0.0F, 0.2792526803190927F, 0.08726646259971647F);
        this.rotation_point_back_right = new PCModelRenderer(this, 242, 21);
        this.rotation_point_back_right.setRotationPoint(-3.0F, 6.2F, 3.0F);
        this.rotation_point_back_right.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotateAngle(rotation_point_back_right, 0.0F, 0.7853981633974483F, 0.0F);
        this.top_right_1_left = new PCModelRenderer(this, 13, 119);
        this.top_right_1_left.setRotationPoint(2.0F, 0.0F, 0.01F);
        this.top_right_1_left.addBox(-2.0F, -4.0F, -2.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(top_right_1_left, 0.0F, 0.0F, 0.40142572795869574F);
        this.top_front_base = new PCModelRenderer(this, 125, 126);
        this.top_front_base.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.top_front_base.addBox(-2.0F, -1.0F, -3.0F, 4, 1, 1, 0.0F);
        this.top_front_3_right = new PCModelRenderer(this, 137, 102);
        this.top_front_3_right.setRotationPoint(2.0F, -5.0F, 0.01F);
        this.top_front_3_right.addBox(-2.0F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(top_front_3_right, 0.0F, 0.0F, -0.296705972839036F);
        this.top_right_1 = new PCModelRenderer(this, 22, 119);
        this.top_right_1.setRotationPoint(0.0F, -1.0F, -2.0F);
        this.top_right_1.addBox(-2.0F, -4.0F, -2.0F, 4, 4, 2, 0.0F);
        this.setRotateAngle(top_right_1, 0.7853981633974483F, 0.0F, 0.0F);
        this.top_back_1_right = new PCModelRenderer(this, 103, 119);
        this.top_back_1_right.setRotationPoint(-2.0F, 0.0F, 0.01F);
        this.top_back_1_right.addBox(0.0F, -4.0F, -2.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(top_back_1_right, 0.0F, 0.0F, -0.40142572795869574F);
        this.base.addChild(this.rotation_point_front_left);
        this.top_front_base.addChild(this.top_front_1);
        this.tongue_3.addChild(this.tongue_4);
        this.leaf_front_left.addChild(this.leaf_front_left_top);
        this.top_front_2.addChild(this.top_front_3);
        this.top_back_2.addChild(this.tooth_back_2);
        this.leaf_front_right.addChild(this.leaf_front_right_top);
        this.base.addChild(this.leaf_back);
        this.top_back_3.addChild(this.tooth_back_3);
        this.top_left_3.addChild(this.top_left_3_right);
        this.top_front_4.addChild(this.top_front_4_left);
        this.rotation_point_front_left.addChild(this.leaf_front_left);
        this.leaf_front.addChild(this.leaf_front_top);
        this.rotation_point_front_right.addChild(this.root_front_right);
        this.leaf_right.addChild(this.leaf_right_top);
        this.top_left_1.addChild(this.top_left_2);
        this.top_right_4.addChild(this.top_right_4_top);
        this.top_front_1.addChild(this.top_front_1_right);
        this.top_back_1.addChild(this.top_back_2);
        this.base.addChild(this.leaf_left);
        this.base_top.addChild(this.top_right_base);
        this.top_left_3.addChild(this.top_left_3_left);
        this.top_left_2.addChild(this.top_left_3);
        this.top_right_3.addChild(this.top_right_4);
        this.base.addChild(this.rotation_point_front_right);
        this.top_left_3.addChild(this.top_left_4);
        this.tongue_2.addChild(this.tongue_3);
        this.top_right_1.addChild(this.top_right_1_right);
        this.top_front_2.addChild(this.tooth_front_2);
        this.top_front_3.addChild(this.tooth_front_3);
        this.leaft_back_left.addChild(this.leaft_back_left_top);
        this.rotation_point_front_right.addChild(this.leaf_front_right);
        this.top_front_4.addChild(this.top_front_4_top);
        this.top_left_2.addChild(this.tooth_left_2);
        this.base.addChild(this.root_right);
        this.top_front_3.addChild(this.top_front_4);
        this.leaf_back.addChild(this.leaf_back_top);
        this.top_back_2.addChild(this.top_back_3);
        this.base.addChild(this.root_front);
        this.base_top.addChild(this.top_back_base);
        this.top_back_3.addChild(this.top_back_3_right);
        this.top_back_3.addChild(this.top_back_3_left);
        this.top_left_3.addChild(this.tooth_left_3);
        this.rotation_point_back_left.addChild(this.leaft_back_left);
        this.leaf_left.addChild(this.leaf_left_top);
        this.top_left_1.addChild(this.top_left_1_right);
        this.base.addChild(this.leaf_front);
        this.top_back_4.addChild(this.top_back_4_left);
        this.base.addChild(this.root_left);
        this.top_back_1.addChild(this.tooth_back_1);
        this.base.addChild(this.root_back);
        this.top_right_2.addChild(this.top_right_3);
        this.top_back_4.addChild(this.top_back_4_top);
        this.top_left_1.addChild(this.tooth_left_1);
        this.top_right_3.addChild(this.top_right_3_right);
        this.top_back_4.addChild(this.top_back_4_right);
        this.top_back_base.addChild(this.top_back_1);
        this.top_right_4.addChild(this.top_right_4_right);
        this.top_front_1.addChild(this.top_front_1_left);
        this.base_top.addChild(this.top_left_base);
        this.top_back_1.addChild(this.top_back_1_left);
        this.top_right_1.addChild(this.top_right_2);
        this.base.addChild(this.rotation_point_back_left);
        this.base.addChild(this.leaf_right);
        this.top_left_4.addChild(this.top_left_4_left);
        this.rotation_point_back_right.addChild(this.leaf_back_right);
        this.top_front_3.addChild(this.top_front_3_left);
        this.top_right_1.addChild(this.tooth_right_1);
        this.top_right_3.addChild(this.tooth_right_3);
        this.rotation_point_front_left.addChild(this.root_front_left);
        this.top_front_1.addChild(this.top_front_2);
        this.tongue_1.addChild(this.tongue_2);
        this.top_front_1.addChild(this.tooth_front_1);
        this.top_back_3.addChild(this.top_back_4);
        this.top_left_4.addChild(this.top_left_4_top);
        this.top_right_3.addChild(this.top_right_3_left);
        this.acid_blob_holder.addChild(this.acid_blob);
        this.top_left_base.addChild(this.top_left_1);
        this.top_left_1.addChild(this.top_left_1_left);
        this.rotation_point_back_right.addChild(this.root_back_right);
        this.top_right_2.addChild(this.tooth_right_2);
        this.top_front_4.addChild(this.top_front_4_right);
        this.top_left_4.addChild(this.top_left_4_right);
        this.rotation_point_back_left.addChild(this.root_back_left);
        this.top_right_4.addChild(this.top_right_4_left);
        this.base.addChild(this.base_top);
        this.leaf_back_right.addChild(this.leaf_back_right_top);
        this.base.addChild(this.rotation_point_back_right);
        this.top_right_1.addChild(this.top_right_1_left);
        this.base_top.addChild(this.top_front_base);
        this.top_front_3.addChild(this.top_front_3_right);
        this.top_right_base.addChild(this.top_right_1);
        this.top_back_1.addChild(this.top_back_1_right);
        
//      bodyParts = new PCModelRenderer[] {base,acid_blob_holder,root_front,root_back,root_right,root_left,rotation_point_front_right,rotation_point_front_left,rotation_point_back_right,rotation_point_back_left,leaf_right,leaf_left,leaf_front,leaf_back,base_top,root_front_right,leaf_front_right,leaf_front_right_top,root_front_left,leaf_front_left,leaf_front_left_top,root_back_right,leaf_back_right,leaf_back_right_top,root_back_left,leaft_back_left,leaft_back_left_top,leaf_right_top,leaf_left_top,leaf_front_top,leaf_back_top,top_front_base,top_back_base,top_left_base,top_right_base,tongue_1,top_front_1,top_front_2,top_front_1_right,top_front_1_left,tooth_front_1,top_front_3,tooth_front_2,top_front_3_right,top_front_3_left,top_front_4,tooth_front_3,top_front_4_left,top_front_4_right,top_front_4_top,top_back_1,top_back_2,top_back_1_right,top_back_1_left,tooth_back_1,top_back_3,tooth_back_2,top_back_3_right,top_back_3_left,top_back_4,tooth_back_3,top_back_4_left,top_back_4_right,top_back_4_top,top_left_1,top_left_2,top_left_1_right,top_left_1_left,tooth_left_1,top_left_3,tooth_left_2,top_left_3_right,top_left_3_left,top_left_4,tooth_left_3,top_left_4_left,top_left_4_right,top_left_4_top,top_right_1,top_right_2,top_right_1_right,top_right_1_left,tooth_right_1,top_right_3,tooth_right_2,top_right_3_right,top_right_3_left,top_right_4,tooth_right_3,top_right_4_left,top_right_4_right,top_right_4_top,tongue_2,tongue_3,tongue_4,acid_blob};
        saveAllDefaultValues();//TODO Maybe replace with a different save method
    }
    
    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha)
    {
    	matrixStackIn.push();
    	matrixStackIn.translate(0, 1.5F, 0);
    	matrixStackIn.rotate(Vector3f.XP.rotationDegrees(180.0F));
    	
    	this.base.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    	this.tongue_1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    	
    	matrixStackIn.pop();
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
    
    @Override
    public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick)
    {
    	this.partialTicks = partialTick;
    }
    
    @Override
    public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
    {
    	super.setRotationAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
    	
    	this.tongue_1.showModel = !this.entity.hasTargetedEntity();
    	
    	if(entity.getAttackState() == 0)
    	{
	    	float globalSpeed = 0.8F;
	    	float globalDegree = 0.8F;
	    	
	    	limbSwing = entity.ticksExisted;
	    	limbSwingAmount = 1;
	    	
	    	loadAllDefaultValues(); //TODO Maybe replace with a different load method
	    	
	    	float entityRotation = (float) (this.base.rotateAngleY - this.base.rotateAngleY + Math.toRadians(netHeadYaw) - Math.toRadians(entity.getYaw(this.partialTicks)));
	    	base.rotateAngleY = 0 + entityRotation;
	    	
	    	swing(leaf_front, 0.2F * globalSpeed, 0.05F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_front, 0.2F * globalSpeed, 0.05F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaf_front_top, 0.2F * globalSpeed, 0.1F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_front_top, 0.2F * globalSpeed, 0.1F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaf_back, 0.2F * globalSpeed, 0.05F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_back, 0.2F * globalSpeed, 0.05F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaf_back_top, 0.2F * globalSpeed, 0.1F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_back_top, 0.2F * globalSpeed, 0.1F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaf_left, 0.2F * globalSpeed, 0.05F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_left, 0.2F * globalSpeed, 0.05F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaf_left_top, 0.2F * globalSpeed, 0.1F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_left_top, 0.2F * globalSpeed, 0.1F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaf_right, 0.2F * globalSpeed, 0.05F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_right, 0.2F * globalSpeed, 0.05F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaf_right_top, 0.2F * globalSpeed, 0.1F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_right_top, 0.2F * globalSpeed, 0.1F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	
	    	swing(leaf_front_left, 0.2F * globalSpeed, 0.05F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_front_left, 0.2F * globalSpeed, 0.05F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaf_front_left_top, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_front_left_top, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaf_front_right, 0.2F * globalSpeed, 0.05F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_front_right, 0.2F * globalSpeed, 0.05F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaf_front_right_top, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_front_right_top, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaft_back_left, 0.2F * globalSpeed, 0.05F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaft_back_left, 0.2F * globalSpeed, 0.05F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaft_back_left_top, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaft_back_left_top, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaf_back_right, 0.2F * globalSpeed, 0.05F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_back_right, 0.2F * globalSpeed, 0.05F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaf_back_right_top, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_back_right_top, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	
	    	swing(tongue_1, 0.1F * globalSpeed, 0.1F * globalDegree, false, -1.2F, 0.0F, limbSwing, limbSwingAmount);
	    	flap(tongue_1, 0.1F * globalSpeed, 0.1F * globalDegree, false, 1.2F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(tongue_2, 0.1F * globalSpeed, 0.1F * globalDegree, true, -1.2F, 0.0F, limbSwing, limbSwingAmount);
	    	flap(tongue_2, 0.1F * globalSpeed, 0.1F * globalDegree, true, 1.2F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(tongue_3, 0.1F * globalSpeed, 0.1F * globalDegree, true, -1.2F, 0.0F, limbSwing, limbSwingAmount);
	    	flap(tongue_3, 0.1F * globalSpeed, 0.1F * globalDegree, true, 1.2F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(tongue_4, 0.1F * globalSpeed, 0.1F * globalDegree, true, -1.2F, 0.0F, limbSwing, limbSwingAmount);
	    	flap(tongue_4, 0.1F * globalSpeed, 0.1F * globalDegree, true, 1.2F, 0.0F, limbSwing, limbSwingAmount);
	    	
	    	swing(top_front_1, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(top_front_2, 0.2F * globalSpeed, 0.1F * globalDegree, true, 1.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(top_front_3, 0.2F * globalSpeed, 0.1F * globalDegree, false, 1.0F, 0.1F, limbSwing, limbSwingAmount);
	    	swing(top_front_4, 0.2F * globalSpeed, 0.1F * globalDegree, true, -1.0F, 0.0F, limbSwing, limbSwingAmount);
	    	
	    	swing(top_back_1, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(top_back_2, 0.2F * globalSpeed, 0.1F * globalDegree, true, 1.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(top_back_3, 0.2F * globalSpeed, 0.1F * globalDegree, false, 1.0F, 0.1F, limbSwing, limbSwingAmount);
	    	swing(top_back_4, 0.2F * globalSpeed, 0.1F * globalDegree, true, -1.0F, 0.0F, limbSwing, limbSwingAmount);
	    	
	    	swing(top_left_1, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(top_left_2, 0.2F * globalSpeed, 0.1F * globalDegree, true, 1.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(top_left_3, 0.2F * globalSpeed, 0.1F * globalDegree, false, 1.0F, 0.1F, limbSwing, limbSwingAmount);
	    	swing(top_left_4, 0.2F * globalSpeed, 0.1F * globalDegree, true, -1.0F, 0.0F, limbSwing, limbSwingAmount);
	    	
	    	swing(top_right_1, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(top_right_2, 0.2F * globalSpeed, 0.1F * globalDegree, true, 1.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(top_right_3, 0.2F * globalSpeed, 0.1F * globalDegree, false, 1.0F, 0.1F, limbSwing, limbSwingAmount);
	    	swing(top_right_4, 0.2F * globalSpeed, 0.1F * globalDegree, true, -1.0F, 0.0F, limbSwing, limbSwingAmount);
    	}
    	else if(entity.getAttackState() == 1)
    	{
    		float globalSpeed = 0.8F;
	    	float globalDegree = 0.8F;
	    	
	    	limbSwing = entity.ticksExisted;
	    	limbSwingAmount = 1;
	    	
	    	loadAllDefaultValues(); //TODO Maybe replace with a different load method
	    	
	    	float entityRotation = (float) (this.base.rotateAngleY - this.base.rotateAngleY + Math.toRadians(netHeadYaw) - Math.toRadians(entity.getYaw(this.partialTicks)));
	    	base.rotateAngleY = 0 + entityRotation;
	    	
	    	this.top_front_1.rotateAngleX = (float) Math.toRadians(96);
	    	this.top_front_2.rotateAngleX = (float) Math.toRadians(-20);
	    	this.top_front_3.rotateAngleX = (float) Math.toRadians(-30);
	    	this.top_back_1.rotateAngleX = (float) Math.toRadians(96);
	    	this.top_back_2.rotateAngleX = (float) Math.toRadians(-20);
	    	this.top_back_3.rotateAngleX = (float) Math.toRadians(-30);
	    	this.top_left_1.rotateAngleX = (float) Math.toRadians(96);
	    	this.top_left_2.rotateAngleX = (float) Math.toRadians(-20);
	    	this.top_left_3.rotateAngleX = (float) Math.toRadians(-30);
	    	this.top_right_1.rotateAngleX = (float) Math.toRadians(96);
	    	this.top_right_2.rotateAngleX = (float) Math.toRadians(-20);
	    	this.top_right_3.rotateAngleX = (float) Math.toRadians(-30);
	    	
	    	swing(top_front_1, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, -0.1F, limbSwing, limbSwingAmount);
	    	swing(top_front_2, 0.2F * globalSpeed, 0.1F * globalDegree, true, 1.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(top_front_3, 0.2F * globalSpeed, 0.1F * globalDegree, false, 1.0F, 0.1F, limbSwing, limbSwingAmount);
	    	swing(top_front_4, 0.2F * globalSpeed, 0.1F * globalDegree, true, -1.0F, 0.0F, limbSwing, limbSwingAmount);
	    	
	    	swing(top_back_1, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, -0.1F, limbSwing, limbSwingAmount);
	    	swing(top_back_2, 0.2F * globalSpeed, 0.1F * globalDegree, true, 1.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(top_back_3, 0.2F * globalSpeed, 0.1F * globalDegree, false, 1.0F, 0.1F, limbSwing, limbSwingAmount);
	    	swing(top_back_4, 0.2F * globalSpeed, 0.1F * globalDegree, true, -1.0F, 0.0F, limbSwing, limbSwingAmount);
	    	
	    	swing(top_left_1, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, -0.1F, limbSwing, limbSwingAmount);
	    	swing(top_left_2, 0.2F * globalSpeed, 0.1F * globalDegree, true, 1.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(top_left_3, 0.2F * globalSpeed, 0.1F * globalDegree, false, 1.0F, 0.1F, limbSwing, limbSwingAmount);
	    	swing(top_left_4, 0.2F * globalSpeed, 0.1F * globalDegree, true, -1.0F, 0.0F, limbSwing, limbSwingAmount);
	    	
	    	swing(top_right_1, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, -0.1F, limbSwing, limbSwingAmount);
	    	swing(top_right_2, 0.2F * globalSpeed, 0.1F * globalDegree, true, 1.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(top_right_3, 0.2F * globalSpeed, 0.1F * globalDegree, false, 1.0F, 0.1F, limbSwing, limbSwingAmount);
	    	swing(top_right_4, 0.2F * globalSpeed, 0.1F * globalDegree, true, -1.0F, 0.0F, limbSwing, limbSwingAmount);
	    	
	    	swing(leaf_front, 0.2F * globalSpeed, 0.05F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_front, 0.2F * globalSpeed, 0.05F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaf_front_top, 0.2F * globalSpeed, 0.1F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_front_top, 0.2F * globalSpeed, 0.1F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaf_back, 0.2F * globalSpeed, 0.05F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_back, 0.2F * globalSpeed, 0.05F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaf_back_top, 0.2F * globalSpeed, 0.1F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_back_top, 0.2F * globalSpeed, 0.1F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaf_left, 0.2F * globalSpeed, 0.05F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_left, 0.2F * globalSpeed, 0.05F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaf_left_top, 0.2F * globalSpeed, 0.1F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_left_top, 0.2F * globalSpeed, 0.1F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaf_right, 0.2F * globalSpeed, 0.05F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_right, 0.2F * globalSpeed, 0.05F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaf_right_top, 0.2F * globalSpeed, 0.1F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_right_top, 0.2F * globalSpeed, 0.1F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);    	
	    	swing(leaf_front_left, 0.2F * globalSpeed, 0.05F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_front_left, 0.2F * globalSpeed, 0.05F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaf_front_left_top, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_front_left_top, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaf_front_right, 0.2F * globalSpeed, 0.05F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_front_right, 0.2F * globalSpeed, 0.05F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaf_front_right_top, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_front_right_top, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaft_back_left, 0.2F * globalSpeed, 0.05F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaft_back_left, 0.2F * globalSpeed, 0.05F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaft_back_left_top, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaft_back_left_top, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaf_back_right, 0.2F * globalSpeed, 0.05F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_back_right, 0.2F * globalSpeed, 0.05F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaf_back_right_top, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_back_right_top, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	
	    	swing(tongue_1, 0.1F * globalSpeed, 0.1F * globalDegree, false, -1.2F, 0.0F, limbSwing, limbSwingAmount);
	    	flap(tongue_1, 0.1F * globalSpeed, 0.1F * globalDegree, false, 1.2F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(tongue_2, 0.1F * globalSpeed, 0.1F * globalDegree, true, -1.2F, 0.0F, limbSwing, limbSwingAmount);
	    	flap(tongue_2, 0.1F * globalSpeed, 0.1F * globalDegree, true, 1.2F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(tongue_3, 0.1F * globalSpeed, 0.1F * globalDegree, true, -1.2F, 0.0F, limbSwing, limbSwingAmount);
	    	flap(tongue_3, 0.1F * globalSpeed, 0.1F * globalDegree, true, 1.2F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(tongue_4, 0.1F * globalSpeed, 0.1F * globalDegree, true, -1.2F, 0.0F, limbSwing, limbSwingAmount);
	    	flap(tongue_4, 0.1F * globalSpeed, 0.1F * globalDegree, true, 1.2F, 0.0F, limbSwing, limbSwingAmount);
    	}
    	else if(entity.getAttackState() == 2)
    	{
    		float globalSpeed = 1.6F;
	    	float globalDegree = 0.8F;
	    	
	    	limbSwing = entity.ticksExisted;
	    	limbSwingAmount = 1;
	    	
	    	loadAllDefaultValues(); //TODO Maybe replace with a different load method
    		
    		swing(top_front_1, 0.2F * globalSpeed, 0.5F * globalDegree, false, 0.0F, 0.1F, limbSwing, limbSwingAmount);
	    	swing(top_front_2, 0.2F * globalSpeed, 0.3F * globalDegree, false, -1.0F, 0.1F, limbSwing, limbSwingAmount);
	    	swing(top_front_3, 0.2F * globalSpeed, 0.3F * globalDegree, false, -1.0F, 0.1F, limbSwing, limbSwingAmount);
	    	swing(top_front_4, 0.2F * globalSpeed, 0.3F * globalDegree, false, 1.0F, 0.1F, limbSwing, limbSwingAmount);
	    	
	    	swing(top_back_1, 0.2F * globalSpeed, 0.5F * globalDegree, false, 0.0F, 0.1F, limbSwing, limbSwingAmount);
	    	swing(top_back_2, 0.2F * globalSpeed, 0.3F * globalDegree, false, -1.0F, 0.1F, limbSwing, limbSwingAmount);
	    	swing(top_back_3, 0.2F * globalSpeed, 0.3F * globalDegree, false, -1.0F, 0.1F, limbSwing, limbSwingAmount);
	    	swing(top_back_4, 0.2F * globalSpeed, 0.3F * globalDegree, false, 1.0F, 0.1F, limbSwing, limbSwingAmount);
	    	
	    	swing(top_left_1, 0.2F * globalSpeed, 0.5F * globalDegree, false, 0.0F, 0.1F, limbSwing, limbSwingAmount);
	    	swing(top_left_2, 0.2F * globalSpeed, 0.3F * globalDegree, false, -1.0F, 0.1F, limbSwing, limbSwingAmount);
	    	swing(top_left_3, 0.2F * globalSpeed, 0.3F * globalDegree, false, -1.0F, 0.1F, limbSwing, limbSwingAmount);
	    	swing(top_left_4, 0.2F * globalSpeed, 0.3F * globalDegree, false, 1.0F, 0.1F, limbSwing, limbSwingAmount);
	    	
	    	swing(top_right_1, 0.2F * globalSpeed, 0.5F * globalDegree, false, 0.0F, 0.1F, limbSwing, limbSwingAmount);
	    	swing(top_right_2, 0.2F * globalSpeed, 0.3F * globalDegree, false, -1.0F, 0.1F, limbSwing, limbSwingAmount);
	    	swing(top_right_3, 0.2F * globalSpeed, 0.3F * globalDegree, false, -1.0F, 0.1F, limbSwing, limbSwingAmount);
	    	swing(top_right_4, 0.2F * globalSpeed, 0.3F * globalDegree, false, 1.0F, 0.1F, limbSwing, limbSwingAmount);
	    	
	    	swing(leaf_front, 0.2F * globalSpeed, 0.05F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_front, 0.2F * globalSpeed, 0.05F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaf_front_top, 0.2F * globalSpeed, 0.1F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_front_top, 0.2F * globalSpeed, 0.1F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaf_back, 0.2F * globalSpeed, 0.05F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_back, 0.2F * globalSpeed, 0.05F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaf_back_top, 0.2F * globalSpeed, 0.1F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_back_top, 0.2F * globalSpeed, 0.1F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaf_left, 0.2F * globalSpeed, 0.05F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_left, 0.2F * globalSpeed, 0.05F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaf_left_top, 0.2F * globalSpeed, 0.1F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_left_top, 0.2F * globalSpeed, 0.1F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaf_right, 0.2F * globalSpeed, 0.05F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_right, 0.2F * globalSpeed, 0.05F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaf_right_top, 0.2F * globalSpeed, 0.1F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_right_top, 0.2F * globalSpeed, 0.1F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);    	
	    	swing(leaf_front_left, 0.2F * globalSpeed, 0.05F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_front_left, 0.2F * globalSpeed, 0.05F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaf_front_left_top, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_front_left_top, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaf_front_right, 0.2F * globalSpeed, 0.05F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_front_right, 0.2F * globalSpeed, 0.05F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaf_front_right_top, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_front_right_top, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaft_back_left, 0.2F * globalSpeed, 0.05F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaft_back_left, 0.2F * globalSpeed, 0.05F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaft_back_left_top, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaft_back_left_top, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaf_back_right, 0.2F * globalSpeed, 0.05F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_back_right, 0.2F * globalSpeed, 0.05F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	swing(leaf_back_right_top, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	    	shake(leaf_back_right_top, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
    	}
//    	else if(entity.getAttackState() == 3)
//    	{
//    		float globalSpeed = 0.8F;
//	    	float globalDegree = 0.8F;
//	    	
//	    	limbSwing = entity.ticksExisted;
//	    	limbSwingAmount = 1;
//	    	
//	    	loadDefaultPose();
//	    	
//	    	float entityRotation = (float) (this.base.rotateAngleY - this.base.rotateAngleY + Math.toRadians(netHeadYaw) - Math.toRadians(entity.getYaw(this.partialTicks)));
//	    	base.rotateAngleY = 0 + entityRotation;
//	    	acid_blob_holder.rotateAngleY = 0 + entityRotation;
//	    	
//	    	this.top_front_1.rotateAngleX = (float) Math.toRadians(96);
//	    	this.top_front_2.rotateAngleX = (float) Math.toRadians(-20);
//	    	this.top_front_3.rotateAngleX = (float) Math.toRadians(-30);
//	    	this.top_back_1.rotateAngleX = (float) Math.toRadians(96);
//	    	this.top_back_2.rotateAngleX = (float) Math.toRadians(-20);
//	    	this.top_back_3.rotateAngleX = (float) Math.toRadians(-30);
//	    	this.top_left_1.rotateAngleX = (float) Math.toRadians(96);
//	    	this.top_left_2.rotateAngleX = (float) Math.toRadians(-20);
//	    	this.top_left_3.rotateAngleX = (float) Math.toRadians(-30);
//	    	this.top_right_1.rotateAngleX = (float) Math.toRadians(96);
//	    	this.top_right_2.rotateAngleX = (float) Math.toRadians(-20);
//	    	this.top_right_3.rotateAngleX = (float) Math.toRadians(-30);
//	    	
//	    	swing(top_front_1, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, -0.1F, limbSwing, limbSwingAmount);
//	    	swing(top_front_2, 0.2F * globalSpeed, 0.1F * globalDegree, true, 1.0F, 0.0F, limbSwing, limbSwingAmount);
//	    	swing(top_front_3, 0.2F * globalSpeed, 0.1F * globalDegree, false, 1.0F, 0.1F, limbSwing, limbSwingAmount);
//	    	swing(top_front_4, 0.2F * globalSpeed, 0.1F * globalDegree, true, -1.0F, 0.0F, limbSwing, limbSwingAmount);
//	    	
//	    	swing(top_back_1, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, -0.1F, limbSwing, limbSwingAmount);
//	    	swing(top_back_2, 0.2F * globalSpeed, 0.1F * globalDegree, true, 1.0F, 0.0F, limbSwing, limbSwingAmount);
//	    	swing(top_back_3, 0.2F * globalSpeed, 0.1F * globalDegree, false, 1.0F, 0.1F, limbSwing, limbSwingAmount);
//	    	swing(top_back_4, 0.2F * globalSpeed, 0.1F * globalDegree, true, -1.0F, 0.0F, limbSwing, limbSwingAmount);
//	    	
//	    	swing(top_left_1, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, -0.1F, limbSwing, limbSwingAmount);
//	    	swing(top_left_2, 0.2F * globalSpeed, 0.1F * globalDegree, true, 1.0F, 0.0F, limbSwing, limbSwingAmount);
//	    	swing(top_left_3, 0.2F * globalSpeed, 0.1F * globalDegree, false, 1.0F, 0.1F, limbSwing, limbSwingAmount);
//	    	swing(top_left_4, 0.2F * globalSpeed, 0.1F * globalDegree, true, -1.0F, 0.0F, limbSwing, limbSwingAmount);
//	    	
//	    	swing(top_right_1, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, -0.1F, limbSwing, limbSwingAmount);
//	    	swing(top_right_2, 0.2F * globalSpeed, 0.1F * globalDegree, true, 1.0F, 0.0F, limbSwing, limbSwingAmount);
//	    	swing(top_right_3, 0.2F * globalSpeed, 0.1F * globalDegree, false, 1.0F, 0.1F, limbSwing, limbSwingAmount);
//	    	swing(top_right_4, 0.2F * globalSpeed, 0.1F * globalDegree, true, -1.0F, 0.0F, limbSwing, limbSwingAmount);
//	    	
//	    	swing(leaf_front, 0.2F * globalSpeed, 0.05F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
//	    	shake(leaf_front, 0.2F * globalSpeed, 0.05F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
//	    	swing(leaf_front_top, 0.2F * globalSpeed, 0.1F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
//	    	shake(leaf_front_top, 0.2F * globalSpeed, 0.1F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
//	    	swing(leaf_back, 0.2F * globalSpeed, 0.05F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
//	    	shake(leaf_back, 0.2F * globalSpeed, 0.05F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
//	    	swing(leaf_back_top, 0.2F * globalSpeed, 0.1F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
//	    	shake(leaf_back_top, 0.2F * globalSpeed, 0.1F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
//	    	swing(leaf_left, 0.2F * globalSpeed, 0.05F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
//	    	shake(leaf_left, 0.2F * globalSpeed, 0.05F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
//	    	swing(leaf_left_top, 0.2F * globalSpeed, 0.1F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
//	    	shake(leaf_left_top, 0.2F * globalSpeed, 0.1F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
//	    	swing(leaf_right, 0.2F * globalSpeed, 0.05F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
//	    	shake(leaf_right, 0.2F * globalSpeed, 0.05F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
//	    	swing(leaf_right_top, 0.2F * globalSpeed, 0.1F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
//	    	shake(leaf_right_top, 0.2F * globalSpeed, 0.1F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);    	
//	    	swing(leaf_front_left, 0.2F * globalSpeed, 0.05F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
//	    	shake(leaf_front_left, 0.2F * globalSpeed, 0.05F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
//	    	swing(leaf_front_left_top, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
//	    	shake(leaf_front_left_top, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
//	    	swing(leaf_front_right, 0.2F * globalSpeed, 0.05F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
//	    	shake(leaf_front_right, 0.2F * globalSpeed, 0.05F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
//	    	swing(leaf_front_right_top, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
//	    	shake(leaf_front_right_top, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
//	    	swing(leaft_back_left, 0.2F * globalSpeed, 0.05F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
//	    	shake(leaft_back_left, 0.2F * globalSpeed, 0.05F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
//	    	swing(leaft_back_left_top, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
//	    	shake(leaft_back_left_top, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
//	    	swing(leaf_back_right, 0.2F * globalSpeed, 0.05F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
//	    	shake(leaf_back_right, 0.2F * globalSpeed, 0.05F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
//	    	swing(leaf_back_right_top, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
//	    	shake(leaf_back_right_top, 0.2F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
//	    	
//	    	swing(tongue_1, 0.1F * globalSpeed, 0.1F * globalDegree, false, -1.2F, 0.0F, limbSwing, limbSwingAmount);
//	    	flap(tongue_1, 0.1F * globalSpeed, 0.1F * globalDegree, false, 1.2F, 0.0F, limbSwing, limbSwingAmount);
//	    	swing(tongue_2, 0.1F * globalSpeed, 0.1F * globalDegree, true, -1.2F, 0.0F, limbSwing, limbSwingAmount);
//	    	flap(tongue_2, 0.1F * globalSpeed, 0.1F * globalDegree, true, 1.2F, 0.0F, limbSwing, limbSwingAmount);
//	    	swing(tongue_3, 0.1F * globalSpeed, 0.1F * globalDegree, true, -1.2F, 0.0F, limbSwing, limbSwingAmount);
//	    	flap(tongue_3, 0.1F * globalSpeed, 0.1F * globalDegree, true, 1.2F, 0.0F, limbSwing, limbSwingAmount);
//	    	swing(tongue_4, 0.1F * globalSpeed, 0.1F * globalDegree, true, -1.2F, 0.0F, limbSwing, limbSwingAmount);
//	    	flap(tongue_4, 0.1F * globalSpeed, 0.1F * globalDegree, true, 1.2F, 0.0F, limbSwing, limbSwingAmount);
//    	}
    }
}
