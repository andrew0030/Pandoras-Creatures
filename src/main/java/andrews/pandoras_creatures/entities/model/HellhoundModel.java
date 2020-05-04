package andrews.pandoras_creatures.entities.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import andrews.pandoras_creatures.entities.HellhoundEntity;
import andrews.pandoras_creatures.util.animation.PCEntityModel;
import andrews.pandoras_creatures.util.animation.PCModelRenderer;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * Hellhound - andrew0030
 * Created using Tabula 7.0.0
 */
@OnlyIn(Dist.CLIENT)
public class HellhoundModel<T extends HellhoundEntity> extends PCEntityModel<T>
{	
    public PCModelRenderer body;
    public PCModelRenderer body2;
    public PCModelRenderer rib_1;
    public PCModelRenderer rib_1_1;
    public PCModelRenderer spike;
    public PCModelRenderer spike_1;
    public PCModelRenderer spike_2;
    public PCModelRenderer spike_3;
    public PCModelRenderer neck;
    public PCModelRenderer rotation_point_right_front;
    public PCModelRenderer rotation_point_left_front;
    public PCModelRenderer shoulder_left;
    public PCModelRenderer shoulder_right;
    public PCModelRenderer body3;
    public PCModelRenderer spike_4;
    public PCModelRenderer spike_5;
    public PCModelRenderer hip;
    public PCModelRenderer spike_6;
    public PCModelRenderer spike_7;
    public PCModelRenderer hip_front;
    public PCModelRenderer hip_left;
    public PCModelRenderer hip_right;
    public PCModelRenderer spike_8;
    public PCModelRenderer spike_9;
    public PCModelRenderer rotation_point_left_back;
    public PCModelRenderer rotation_point_right_back;
    public PCModelRenderer tail;
    public PCModelRenderer leg_left_back;
    public PCModelRenderer leg_left_back_2;
    public PCModelRenderer leg_left_back_3;
    public PCModelRenderer leg_left_back_dec;
    public PCModelRenderer leg_left_back_toe;
    public PCModelRenderer leg_right_back;
    public PCModelRenderer leg_right_back_2;
    public PCModelRenderer leg_right_back_dec;
    public PCModelRenderer leg_right_back_3;
    public PCModelRenderer leg_right_back_toe;
    public PCModelRenderer tail_1;
    public PCModelRenderer rib_2;
    public PCModelRenderer rib_1_2;
    public PCModelRenderer rib_3;
    public PCModelRenderer rib_2_1;
    public PCModelRenderer rib_1_3;
    public PCModelRenderer rib_3_1;
    public PCModelRenderer rib_2_2;
    public PCModelRenderer rib_1_4;
    public PCModelRenderer rib_3_2;
    public PCModelRenderer rib_2_3;
    public PCModelRenderer rib_3_3;
    public PCModelRenderer rib_2_4;
    public PCModelRenderer rib_1_5;
    public PCModelRenderer rib_3_4;
    public PCModelRenderer rib_2_5;
    public PCModelRenderer rib_1_6;
    public PCModelRenderer rib_3_5;
    public PCModelRenderer rib_2_6;
    public PCModelRenderer rib_1_7;
    public PCModelRenderer rib_3_6;
    public PCModelRenderer rib_2_7;
    public PCModelRenderer rib_3_7;
    public PCModelRenderer head;
    public PCModelRenderer mouth_top;
    public PCModelRenderer head_top;
    public PCModelRenderer head_bottom;
    public PCModelRenderer ear_right;
    public PCModelRenderer ear_left;
    public PCModelRenderer mouth_top_2;
    public PCModelRenderer tooth;
    public PCModelRenderer tooth_1;
    public PCModelRenderer tooth_2;
    public PCModelRenderer tooth_3;
    public PCModelRenderer tooth_4;
    public PCModelRenderer mouth_bottom;
    public PCModelRenderer leg_right_front;
    public PCModelRenderer leg_right_front_2;
    public PCModelRenderer leg_right_front_dec;
    public PCModelRenderer leg_right_front_3;
    public PCModelRenderer leg_right_front_toe;
    public PCModelRenderer leg_left_front;
    public PCModelRenderer leg_left_front_2;
    public PCModelRenderer leg_left_front_3;
    public PCModelRenderer leg_left_front_dec;
    public PCModelRenderer leg_left_front_toe;

    public HellhoundModel()
    {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.rib_3_4 = new PCModelRenderer(this, 57, 48);
        this.rib_3_4.setRotationPoint(0.0F, 4.0F, 0.01F);
        this.rib_3_4.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(rib_3_4, 0.0F, 0.0F, -0.6108652381980153F);
        this.tooth_1 = new PCModelRenderer(this, 11, 26);
        this.tooth_1.setRotationPoint(1.9F, 0.5F, 0.1F);
        this.tooth_1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.rotation_point_right_back = new PCModelRenderer(this, 54, 0);
        this.rotation_point_right_back.setRotationPoint(-2.0F, 2.0F, 1.0F);
        this.rotation_point_right_back.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotateAngle(rotation_point_right_back, 0.5235987755982988F, 0.0F, 0.0F);
        this.body = new PCModelRenderer(this, 105, 0);
        this.body.setRotationPoint(0.0F, 6.4F, 0.3F);
        this.body.addBox(-1.0F, 0.0F, -8.0F, 2, 2, 9, 0.0F);
        this.tooth_3 = new PCModelRenderer(this, 1, 35);
        this.tooth_3.setRotationPoint(0.2F, 0.5F, 1.0F);
        this.tooth_3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
        this.ear_left = new PCModelRenderer(this, 8, 41);
        this.ear_left.setRotationPoint(2.0F, -2.0F, 1.0F);
        this.ear_left.addBox(-1.0F, -2.0F, -1.0F, 2, 2, 1, 0.0F);
        this.setRotateAngle(ear_left, 0.17453292519943295F, 0.08726646259971647F, 0.6981317007977318F);
        this.mouth_bottom = new PCModelRenderer(this, 20, 57);
        this.mouth_bottom.setRotationPoint(0.5F, 0.9F, 0.0F);
        this.mouth_bottom.addBox(0.0F, 0.0F, -4.0F, 3, 1, 5, 0.0F);
        this.rib_1_5 = new PCModelRenderer(this, 62, 59);
        this.rib_1_5.setRotationPoint(0.0F, 0.0F, 2.0F);
        this.rib_1_5.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.head_top = new PCModelRenderer(this, 1, 45);
        this.head_top.setRotationPoint(-1.5F, -3.0F, -1.5F);
        this.head_top.addBox(0.0F, 0.0F, 0.0F, 3, 1, 3, 0.0F);
        this.rib_1_1 = new PCModelRenderer(this, 57, 59);
        this.rib_1_1.setRotationPoint(-1.0F, 0.2F, -7.0F);
        this.rib_1_1.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(rib_1_1, 0.0F, 0.0F, 1.1344640137963142F);
        this.leg_right_back_2 = new PCModelRenderer(this, 50, 13);
        this.leg_right_back_2.setRotationPoint(-0.5F, 6.5F, -1.0F);
        this.leg_right_back_2.addBox(-1.0F, 0.0F, 0.0F, 1, 6, 1, 0.0F);
        this.setRotateAngle(leg_right_back_2, 0.6108652381980153F, 0.0F, -0.17453292519943295F);
        this.rotation_point_right_front = new PCModelRenderer(this, 75, 0);
        this.rotation_point_right_front.setRotationPoint(-3.0F, 5.0F, -4.0F);
        this.rotation_point_right_front.addBox(-1.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.hip_left = new PCModelRenderer(this, 111, 19);
        this.hip_left.setRotationPoint(2.5F, 0.0F, 3.5F);
        this.hip_left.addBox(0.0F, 0.0F, -4.5F, 3, 1, 5, 0.0F);
        this.setRotateAngle(hip_left, -0.2617993877991494F, -0.2617993877991494F, 0.6981317007977318F);
        this.rib_3_3 = new PCModelRenderer(this, 52, 49);
        this.rib_3_3.setRotationPoint(0.0F, 4.0F, 0.01F);
        this.rib_3_3.addBox(-1.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(rib_3_3, 0.0F, 0.0F, 0.6108652381980153F);
        this.spike_7 = new PCModelRenderer(this, 35, 0);
        this.spike_7.setRotationPoint(-0.5F, 0.0F, 0.0F);
        this.spike_7.addBox(0.0F, -1.0F, 3.0F, 1, 1, 1, 0.0F);
        this.rib_1_4 = new PCModelRenderer(this, 52, 59);
        this.rib_1_4.setRotationPoint(0.0F, 0.0F, 2.0F);
        this.rib_1_4.addBox(-1.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.rib_2_7 = new PCModelRenderer(this, 72, 53);
        this.rib_2_7.setRotationPoint(0.0F, 3.0F, 0.01F);
        this.rib_2_7.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.setRotateAngle(rib_2_7, 0.0F, 0.0F, -0.8726646259971648F);
        this.spike_1 = new PCModelRenderer(this, 5, 0);
        this.spike_1.setRotationPoint(-0.5F, 0.0F, -5.0F);
        this.spike_1.addBox(0.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F);
        this.rib_3_6 = new PCModelRenderer(this, 67, 49);
        this.rib_3_6.setRotationPoint(0.0F, 4.0F, 0.01F);
        this.rib_3_6.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(rib_3_6, 0.0F, 0.0F, -0.6108652381980153F);
        this.rib_1_6 = new PCModelRenderer(this, 67, 59);
        this.rib_1_6.setRotationPoint(0.0F, 0.0F, 2.0F);
        this.rib_1_6.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.tail_1 = new PCModelRenderer(this, 118, 33);
        this.tail_1.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.tail_1.addBox(-0.5F, 0.0F, -1.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(tail_1, -0.2617993877991494F, 0.0F, 0.0F);
        this.leg_left_front_2 = new PCModelRenderer(this, 81, 13);
        this.leg_left_front_2.setRotationPoint(0.5F, 5.5F, -0.5F);
        this.leg_left_front_2.addBox(0.0F, 0.0F, 0.0F, 1, 6, 1, 0.0F);
        this.setRotateAngle(leg_left_front_2, -0.6108652381980153F, 0.0F, 0.0F);
        this.leg_right_front_toe = new PCModelRenderer(this, 70, 26);
        this.leg_right_front_toe.setRotationPoint(-1.0F, 1.0F, -2.0F);
        this.leg_right_front_toe.addBox(0.0F, -1.0F, -1.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(leg_right_front_toe, -0.2617993877991494F, 0.0F, 0.0F);
        this.leg_left_front_toe = new PCModelRenderer(this, 81, 26);
        this.leg_left_front_toe.setRotationPoint(0.0F, 1.0F, -2.0F);
        this.leg_left_front_toe.addBox(0.0F, -1.0F, -1.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(leg_left_front_toe, -0.2617993877991494F, 0.0F, 0.0F);
        this.rib_2_3 = new PCModelRenderer(this, 52, 53);
        this.rib_2_3.setRotationPoint(0.0F, 3.0F, 0.01F);
        this.rib_2_3.addBox(-1.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.setRotateAngle(rib_2_3, 0.0F, 0.0F, 0.8726646259971648F);
        this.hip_right = new PCModelRenderer(this, 111, 26);
        this.hip_right.setRotationPoint(-2.5F, 0.0F, 3.5F);
        this.hip_right.addBox(-3.0F, 0.0F, -4.5F, 3, 1, 5, 0.0F);
        this.setRotateAngle(hip_right, -0.2617993877991494F, 0.2617993877991494F, -0.6981317007977318F);
        this.leg_left_front_dec = new PCModelRenderer(this, 86, 13);
        this.leg_left_front_dec.setRotationPoint(-0.01F, 4.0F, 0.0F);
        this.leg_left_front_dec.addBox(0.0F, -4.0F, 0.0F, 1, 4, 1, 0.0F);
        this.setRotateAngle(leg_left_front_dec, -0.2617993877991494F, 0.0F, 0.0F);
        this.rib_1_3 = new PCModelRenderer(this, 47, 59);
        this.rib_1_3.setRotationPoint(0.0F, 0.0F, 2.0F);
        this.rib_1_3.addBox(-1.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.rotation_point_left_back = new PCModelRenderer(this, 65, 0);
        this.rotation_point_left_back.setRotationPoint(2.0F, 2.0F, 1.0F);
        this.rotation_point_left_back.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotateAngle(rotation_point_left_back, 0.5235987755982988F, 0.0F, 0.0F);
        this.leg_left_back_3 = new PCModelRenderer(this, 59, 21);
        this.leg_left_back_3.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.leg_left_back_3.addBox(-0.5F, 0.0F, -2.0F, 2, 1, 3, 0.0F);
        this.rib_3_5 = new PCModelRenderer(this, 62, 48);
        this.rib_3_5.setRotationPoint(0.0F, 4.0F, 0.01F);
        this.rib_3_5.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(rib_3_5, 0.0F, 0.0F, -0.6108652381980153F);
        this.ear_right = new PCModelRenderer(this, 1, 41);
        this.ear_right.setRotationPoint(-2.0F, -2.0F, 1.0F);
        this.ear_right.addBox(-1.0F, -2.0F, -1.0F, 2, 2, 1, 0.0F);
        this.setRotateAngle(ear_right, 0.17453292519943295F, -0.08726646259971647F, -0.6981317007977318F);
        this.leg_right_back_3 = new PCModelRenderer(this, 48, 21);
        this.leg_right_back_3.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.leg_right_back_3.addBox(-1.5F, 0.0F, -2.0F, 2, 1, 3, 0.0F);
        this.rib_2 = new PCModelRenderer(this, 37, 53);
        this.rib_2.setRotationPoint(0.0F, 3.0F, 0.01F);
        this.rib_2.addBox(-1.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.setRotateAngle(rib_2, 0.0F, 0.0F, 0.8726646259971648F);
        this.leg_right_front_dec = new PCModelRenderer(this, 76, 13);
        this.leg_right_front_dec.setRotationPoint(0.01F, 4.0F, 0.0F);
        this.leg_right_front_dec.addBox(-1.0F, -4.0F, 0.0F, 1, 4, 1, 0.0F);
        this.setRotateAngle(leg_right_front_dec, -0.2617993877991494F, 0.0F, 0.0F);
        this.hip_front = new PCModelRenderer(this, 118, 0);
        this.hip_front.setRotationPoint(0.0F, 1.0F, 3.0F);
        this.hip_front.addBox(-1.5F, -1.0F, 0.0F, 3, 1, 2, 0.0F);
        this.setRotateAngle(hip_front, -0.5235987755982988F, 0.0F, 0.0F);
        this.tail = new PCModelRenderer(this, 123, 33);
        this.tail.setRotationPoint(0.0F, 0.5F, 3.0F);
        this.tail.addBox(-0.5F, 0.0F, -1.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(tail, 1.0471975511965976F, 0.0F, 0.0F);
        this.mouth_top = new PCModelRenderer(this, 18, 51);
        this.mouth_top.setRotationPoint(-1.5F, 0.2F, -6.0F);
        this.mouth_top.addBox(0.0F, 0.0F, 0.0F, 3, 1, 4, 0.0F);
        this.spike_8 = new PCModelRenderer(this, 40, 0);
        this.spike_8.setRotationPoint(-0.5F, 0.0F, 0.0F);
        this.spike_8.addBox(0.0F, -0.6F, 0.0F, 1, 1, 1, 0.0F);
        this.spike_4 = new PCModelRenderer(this, 20, 0);
        this.spike_4.setRotationPoint(-0.5F, 0.0F, 1.0F);
        this.spike_4.addBox(0.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F);
        this.shoulder_right = new PCModelRenderer(this, 109, 50);
        this.shoulder_right.setRotationPoint(-3.5F, 2.0F, -5.5F);
        this.shoulder_right.addBox(-4.0F, -1.0F, 0.0F, 4, 1, 5, 0.0F);
        this.setRotateAngle(shoulder_right, 0.0F, -0.17453292519943295F, -1.0471975511965976F);
        this.leg_left_back = new PCModelRenderer(this, 61, 3);
        this.leg_left_back.setRotationPoint(0.5F, 0.0F, 0.0F);
        this.leg_left_back.addBox(0.0F, -0.5F, -1.0F, 2, 7, 2, 0.0F);
        this.setRotateAngle(leg_left_back, -0.3490658503988659F, 0.0F, -0.17453292519943295F);
        this.tooth_2 = new PCModelRenderer(this, 1, 26);
        this.tooth_2.setRotationPoint(1.0F, 0.5F, 0.3F);
        this.tooth_2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.shoulder_left = new PCModelRenderer(this, 109, 57);
        this.shoulder_left.setRotationPoint(3.5F, 2.0F, -5.5F);
        this.shoulder_left.addBox(0.0F, -1.0F, 0.0F, 4, 1, 5, 0.0F);
        this.setRotateAngle(shoulder_left, 0.0F, 0.17453292519943295F, 1.0471975511965976F);
        this.spike = new PCModelRenderer(this, 0, 0);
        this.spike.setRotationPoint(-0.5F, 0.0F, -7.0F);
        this.spike.addBox(0.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F);
        this.head_bottom = new PCModelRenderer(this, 1, 50);
        this.head_bottom.setRotationPoint(-2.0F, 1.0F, -2.0F);
        this.head_bottom.addBox(0.0F, 0.0F, 0.0F, 4, 2, 4, 0.0F);
        this.setRotateAngle(head_bottom, 0.2617993877991494F, 0.0F, 0.0F);
        this.leg_left_back_2 = new PCModelRenderer(this, 61, 13);
        this.leg_left_back_2.setRotationPoint(0.5F, 6.5F, -1.0F);
        this.leg_left_back_2.addBox(0.0F, 0.0F, 0.0F, 1, 6, 1, 0.0F);
        this.setRotateAngle(leg_left_back_2, 0.6108652381980153F, 0.0F, 0.17453292519943295F);
        this.spike_5 = new PCModelRenderer(this, 25, 0);
        this.spike_5.setRotationPoint(-0.5F, 0.0F, 3.0F);
        this.spike_5.addBox(0.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F);
        this.mouth_top_2 = new PCModelRenderer(this, 14, 44);
        this.mouth_top_2.setRotationPoint(0.5F, 0.0F, 0.5F);
        this.mouth_top_2.addBox(0.0F, 0.0F, 0.0F, 2, 1, 5, 0.0F);
        this.setRotateAngle(mouth_top_2, 0.08726646259971647F, 0.0F, 0.0F);
        this.tooth = new PCModelRenderer(this, 6, 26);
        this.tooth.setRotationPoint(0.1F, 0.5F, 0.1F);
        this.tooth.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.leg_right_front_3 = new PCModelRenderer(this, 70, 21);
        this.leg_right_front_3.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.leg_right_front_3.addBox(-1.5F, 0.0F, -2.0F, 2, 1, 3, 0.0F);
        this.setRotateAngle(leg_right_front_3, 0.6108652381980153F, 0.0F, 0.0F);
        this.body3 = new PCModelRenderer(this, 90, 0);
        this.body3.setRotationPoint(0.0F, 0.0F, 4.0F);
        this.body3.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 5, 0.0F);
        this.setRotateAngle(body3, -0.17453292519943295F, 0.0F, 0.0F);
        this.spike_9 = new PCModelRenderer(this, 45, 0);
        this.spike_9.setRotationPoint(-0.5F, -0.3F, 2.0F);
        this.spike_9.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.rib_3_1 = new PCModelRenderer(this, 42, 48);
        this.rib_3_1.setRotationPoint(0.0F, 4.0F, 0.01F);
        this.rib_3_1.addBox(-1.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(rib_3_1, 0.0F, 0.0F, 0.6108652381980153F);
        this.leg_left_back_dec = new PCModelRenderer(this, 66, 13);
        this.leg_left_back_dec.setRotationPoint(-0.01F, 4.0F, 0.0F);
        this.leg_left_back_dec.addBox(0.0F, -4.0F, 0.0F, 1, 4, 1, 0.0F);
        this.setRotateAngle(leg_left_back_dec, -0.2617993877991494F, 0.0F, 0.0F);
        this.rib_1 = new PCModelRenderer(this, 37, 59);
        this.rib_1.setRotationPoint(1.0F, 0.2F, -7.0F);
        this.rib_1.addBox(-1.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(rib_1, 0.0F, 0.0F, -1.1344640137963142F);
        this.rib_3 = new PCModelRenderer(this, 37, 48);
        this.rib_3.setRotationPoint(0.0F, 4.0F, 0.01F);
        this.rib_3.addBox(-1.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(rib_3, 0.0F, 0.0F, 0.6108652381980153F);
        this.leg_right_back = new PCModelRenderer(this, 50, 3);
        this.leg_right_back.setRotationPoint(-0.5F, 0.0F, 0.0F);
        this.leg_right_back.addBox(-2.0F, -0.5F, -1.0F, 2, 7, 2, 0.0F);
        this.setRotateAngle(leg_right_back, -0.3490658503988659F, 0.0F, 0.17453292519943295F);
        this.leg_right_back_toe = new PCModelRenderer(this, 48, 26);
        this.leg_right_back_toe.setRotationPoint(-1.0F, 1.0F, -2.0F);
        this.leg_right_back_toe.addBox(0.0F, -1.0F, -1.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(leg_right_back_toe, -0.2617993877991494F, 0.0F, 0.0F);
        this.rib_2_4 = new PCModelRenderer(this, 57, 53);
        this.rib_2_4.setRotationPoint(0.0F, 3.0F, 0.01F);
        this.rib_2_4.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.setRotateAngle(rib_2_4, 0.0F, 0.0F, -0.8726646259971648F);
        this.rotation_point_left_front = new PCModelRenderer(this, 85, 0);
        this.rotation_point_left_front.setRotationPoint(3.0F, 5.0F, -4.0F);
        this.rotation_point_left_front.addBox(1.0F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.spike_6 = new PCModelRenderer(this, 30, 0);
        this.spike_6.setRotationPoint(-0.5F, 0.0F, 1.0F);
        this.spike_6.addBox(0.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F);
        this.leg_left_front = new PCModelRenderer(this, 81, 3);
        this.leg_left_front.setRotationPoint(0.5F, 0.0F, 0.0F);
        this.leg_left_front.addBox(0.0F, -0.5F, -1.0F, 2, 7, 2, 0.0F);
        this.setRotateAngle(leg_left_front, 0.2617993877991494F, 0.0F, 0.0F);
        this.leg_right_back_dec = new PCModelRenderer(this, 55, 13);
        this.leg_right_back_dec.setRotationPoint(0.01F, 4.0F, 0.0F);
        this.leg_right_back_dec.addBox(-1.0F, -4.0F, 0.0F, 1, 4, 1, 0.0F);
        this.setRotateAngle(leg_right_back_dec, -0.2617993877991494F, 0.0F, 0.0F);
        this.spike_3 = new PCModelRenderer(this, 15, 0);
        this.spike_3.setRotationPoint(-0.5F, 0.0F, -1.0F);
        this.spike_3.addBox(0.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F);
        this.leg_right_front = new PCModelRenderer(this, 71, 3);
        this.leg_right_front.setRotationPoint(-0.5F, 0.0F, 0.0F);
        this.leg_right_front.addBox(-2.0F, -0.5F, -1.0F, 2, 7, 2, 0.0F);
        this.setRotateAngle(leg_right_front, 0.2617993877991494F, 0.0F, 0.0F);
        this.rib_2_6 = new PCModelRenderer(this, 67, 53);
        this.rib_2_6.setRotationPoint(0.0F, 3.0F, 0.01F);
        this.rib_2_6.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.setRotateAngle(rib_2_6, 0.0F, 0.0F, -0.8726646259971648F);
        this.neck = new PCModelRenderer(this, 109, 33);
        this.neck.setRotationPoint(0.0F, 1.0F, -8.0F);
        this.neck.addBox(-0.5F, -1.0F, -3.0F, 1, 2, 3, 0.0F);
        this.setRotateAngle(neck, -0.3490658503988659F, 0.0F, 0.0F);
        this.rib_1_2 = new PCModelRenderer(this, 42, 59);
        this.rib_1_2.setRotationPoint(0.0F, 0.0F, 2.0F);
        this.rib_1_2.addBox(-1.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.body2 = new PCModelRenderer(this, 103, 0);
        this.body2.setRotationPoint(0.0F, 0.2F, 1.0F);
        this.body2.addBox(-0.5F, 0.0F, 0.0F, 1, 2, 4, 0.0F);
        this.setRotateAngle(body2, -0.17453292519943295F, 0.0F, 0.0F);
        this.hip = new PCModelRenderer(this, 111, 12);
        this.hip.setRotationPoint(0.0F, -0.1F, 5.0F);
        this.hip.addBox(-2.5F, 0.0F, 0.0F, 5, 3, 3, 0.0F);
        this.setRotateAngle(hip, -0.17453292519943295F, 0.0F, 0.0F);
        this.rib_2_1 = new PCModelRenderer(this, 42, 53);
        this.rib_2_1.setRotationPoint(0.0F, 3.0F, 0.01F);
        this.rib_2_1.addBox(-1.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.setRotateAngle(rib_2_1, 0.0F, 0.0F, 0.8726646259971648F);
        this.rib_2_5 = new PCModelRenderer(this, 62, 53);
        this.rib_2_5.setRotationPoint(0.0F, 3.0F, 0.01F);
        this.rib_2_5.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.setRotateAngle(rib_2_5, 0.0F, 0.0F, -0.8726646259971648F);
        this.leg_left_front_3 = new PCModelRenderer(this, 81, 21);
        this.leg_left_front_3.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.leg_left_front_3.addBox(-0.5F, 0.0F, -2.0F, 2, 1, 3, 0.0F);
        this.setRotateAngle(leg_left_front_3, 0.6108652381980153F, 0.0F, 0.0F);
        this.leg_left_back_toe = new PCModelRenderer(this, 59, 26);
        this.leg_left_back_toe.setRotationPoint(0.0F, 1.0F, -2.0F);
        this.leg_left_back_toe.addBox(0.0F, -1.0F, -1.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(leg_left_back_toe, -0.2617993877991494F, 0.0F, 0.0F);
        this.head = new PCModelRenderer(this, 1, 57);
        this.head.setRotationPoint(0.0F, -0.5F, -4.0F);
        this.head.addBox(-2.5F, -2.0F, -2.0F, 5, 3, 4, 0.0F);
        this.setRotateAngle(head, 0.3490658503988659F, 0.0F, 0.0F);
        this.tooth_4 = new PCModelRenderer(this, 1, 29);
        this.tooth_4.setRotationPoint(1.8F, 0.5F, 1.0F);
        this.tooth_4.addBox(0.0F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
        this.spike_2 = new PCModelRenderer(this, 10, 0);
        this.spike_2.setRotationPoint(-0.5F, 0.0F, -3.0F);
        this.spike_2.addBox(0.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F);
        this.rib_3_2 = new PCModelRenderer(this, 47, 49);
        this.rib_3_2.setRotationPoint(0.0F, 4.0F, 0.01F);
        this.rib_3_2.addBox(-1.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(rib_3_2, 0.0F, 0.0F, 0.6108652381980153F);
        this.rib_2_2 = new PCModelRenderer(this, 47, 53);
        this.rib_2_2.setRotationPoint(0.0F, 3.0F, 0.01F);
        this.rib_2_2.addBox(-1.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.setRotateAngle(rib_2_2, 0.0F, 0.0F, 0.8726646259971648F);
        this.leg_right_front_2 = new PCModelRenderer(this, 71, 13);
        this.leg_right_front_2.setRotationPoint(-0.5F, 5.5F, -1.0F);
        this.leg_right_front_2.addBox(-1.0F, 0.0F, 0.0F, 1, 6, 1, 0.0F);
        this.setRotateAngle(leg_right_front_2, -0.6108652381980153F, 0.0F, 0.0F);
        this.rib_1_7 = new PCModelRenderer(this, 72, 59);
        this.rib_1_7.setRotationPoint(0.0F, 0.0F, 2.0F);
        this.rib_1_7.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.rib_3_7 = new PCModelRenderer(this, 72, 49);
        this.rib_3_7.setRotationPoint(0.0F, 4.0F, 0.01F);
        this.rib_3_7.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(rib_3_7, 0.0F, 0.0F, -0.6108652381980153F);
        this.rib_2_4.addChild(this.rib_3_4);
        this.mouth_top.addChild(this.tooth_1);
        this.hip.addChild(this.rotation_point_right_back);
        this.mouth_top.addChild(this.tooth_3);
        this.head.addChild(this.ear_left);
        this.head_bottom.addChild(this.mouth_bottom);
        this.rib_1_1.addChild(this.rib_1_5);
        this.head.addChild(this.head_top);
        this.body.addChild(this.rib_1_1);
        this.leg_right_back.addChild(this.leg_right_back_2);
        this.body.addChild(this.rotation_point_right_front);
        this.hip.addChild(this.hip_left);
        this.rib_2_3.addChild(this.rib_3_3);
        this.body3.addChild(this.spike_7);
        this.rib_1_3.addChild(this.rib_1_4);
        this.rib_1_7.addChild(this.rib_2_7);
        this.body.addChild(this.spike_1);
        this.rib_2_6.addChild(this.rib_3_6);
        this.rib_1_5.addChild(this.rib_1_6);
        this.tail.addChild(this.tail_1);
        this.leg_left_front.addChild(this.leg_left_front_2);
        this.leg_right_front_3.addChild(this.leg_right_front_toe);
        this.leg_left_front_3.addChild(this.leg_left_front_toe);
        this.rib_1_4.addChild(this.rib_2_3);
        this.hip.addChild(this.hip_right);
        this.leg_left_front_2.addChild(this.leg_left_front_dec);
        this.rib_1_2.addChild(this.rib_1_3);
        this.hip.addChild(this.rotation_point_left_back);
        this.leg_left_back_2.addChild(this.leg_left_back_3);
        this.rib_2_5.addChild(this.rib_3_5);
        this.head.addChild(this.ear_right);
        this.leg_right_back_2.addChild(this.leg_right_back_3);
        this.rib_1.addChild(this.rib_2);
        this.leg_right_front_2.addChild(this.leg_right_front_dec);
        this.body3.addChild(this.hip_front);
        this.hip.addChild(this.tail);
        this.head.addChild(this.mouth_top);
        this.hip.addChild(this.spike_8);
        this.body2.addChild(this.spike_4);
        this.body.addChild(this.shoulder_right);
        this.rotation_point_left_back.addChild(this.leg_left_back);
        this.mouth_top.addChild(this.tooth_2);
        this.body.addChild(this.shoulder_left);
        this.body.addChild(this.spike);
        this.head.addChild(this.head_bottom);
        this.leg_left_back.addChild(this.leg_left_back_2);
        this.body2.addChild(this.spike_5);
        this.mouth_top.addChild(this.mouth_top_2);
        this.mouth_top.addChild(this.tooth);
        this.leg_right_front_2.addChild(this.leg_right_front_3);
        this.body2.addChild(this.body3);
        this.hip.addChild(this.spike_9);
        this.rib_2_1.addChild(this.rib_3_1);
        this.leg_left_back_2.addChild(this.leg_left_back_dec);
        this.body.addChild(this.rib_1);
        this.rib_2.addChild(this.rib_3);
        this.rotation_point_right_back.addChild(this.leg_right_back);
        this.leg_right_back_3.addChild(this.leg_right_back_toe);
        this.rib_1_1.addChild(this.rib_2_4);
        this.body.addChild(this.rotation_point_left_front);
        this.body3.addChild(this.spike_6);
        this.rotation_point_left_front.addChild(this.leg_left_front);
        this.leg_right_back_2.addChild(this.leg_right_back_dec);
        this.body.addChild(this.spike_3);
        this.rotation_point_right_front.addChild(this.leg_right_front);
        this.rib_1_6.addChild(this.rib_2_6);
        this.body.addChild(this.neck);
        this.rib_1.addChild(this.rib_1_2);
        this.body.addChild(this.body2);
        this.body3.addChild(this.hip);
        this.rib_1_2.addChild(this.rib_2_1);
        this.rib_1_5.addChild(this.rib_2_5);
        this.leg_left_front_2.addChild(this.leg_left_front_3);
        this.leg_left_back_3.addChild(this.leg_left_back_toe);
        this.neck.addChild(this.head);
        this.mouth_top.addChild(this.tooth_4);
        this.body.addChild(this.spike_2);
        this.rib_2_2.addChild(this.rib_3_2);
        this.rib_1_3.addChild(this.rib_2_2);
        this.leg_right_front.addChild(this.leg_right_front_2);
        this.rib_1_6.addChild(this.rib_1_7);
        this.rib_2_7.addChild(this.rib_3_7);
        
//        bodyParts = new PCModelRenderer[] {body,body2,rib_1,rib_1_1,spike,spike_1,spike_2,spike_3,neck,rotation_point_right_front,rotation_point_left_front,shoulder_left,shoulder_right,body3,spike_4,spike_5,hip,spike_6,spike_7,hip_front,hip_left,hip_right,spike_8,spike_9,rotation_point_left_back,rotation_point_right_back,tail,leg_left_back,leg_left_back_2,leg_left_back_3,leg_left_back_dec,leg_left_back_toe,leg_right_back,leg_right_back_2,leg_right_back_dec,leg_right_back_3,leg_right_back_toe,tail_1,rib_2,rib_1_2,rib_3,rib_2_1,rib_1_3,rib_3_1,rib_2_2,rib_1_4,rib_3_2,rib_2_3,rib_3_3,rib_2_4,rib_1_5,rib_3_4,rib_2_5,rib_1_6,rib_3_5,rib_2_6,rib_1_7,rib_3_6,rib_2_7,rib_3_7,head,mouth_top,head_top,head_bottom,ear_right,ear_left,mouth_top_2,tooth,tooth_1,tooth_2,tooth_3,tooth_4,mouth_bottom,leg_right_front,leg_right_front_2,leg_right_front_dec,leg_right_front_3,leg_right_front_toe,leg_left_front,leg_left_front_2,leg_left_front_3,leg_left_front_dec,leg_left_front_toe};
        saveAllDefaultValues();//TODO Maybe replace with a different save method
    }
    
    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha)
    {
    	matrixStackIn.push();
    	if(entity.getHellhoundType() != 1)
    	{
    		float hellhoundScale = 1.2F;
    		matrixStackIn.translate(0, -0.3F, 0);
    		matrixStackIn.scale(hellhoundScale, hellhoundScale, hellhoundScale);
    	}
    	this.body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
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
    public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
    {
    	super.setRotationAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		
		if(entity.prevPosX != entity.getPosX() || entity.prevPosY != entity.getPosY() || entity.prevPosZ != entity.getPosZ()) //Walk Animation
    	{
			if(entity.getIsCharging() != 0)
			{
				float globalHeight = 1;
				float globalSpeed = 0.7F;
				float globalDegree = 1;
				
				loadAllDefaultValues(); //TODO Maybe replace with a different load method
				
				//Makes the Head Rotate where the Entity is Looking
	    		this.neck.rotateAngleY = (netHeadYaw * ((float)Math.PI / 180) / 2);
	    		this.head.rotateAngleY = (netHeadYaw * ((float)Math.PI / 180) / 2);
	    		this.head.rotateAngleZ = (netHeadYaw * ((float)Math.PI / 180) / 4);
	    		this.neck.rotateAngleX = (headPitch * ((float)Math.PI / 180F) / 2);
	    		this.head.rotateAngleX = (headPitch * ((float)Math.PI / 180F) / 2);
				
				bounce(body, 1F * globalSpeed, 0.7F * globalHeight, false, limbSwing, limbSwingAmount);
		    	swing(body, 1F * globalSpeed, 0.15F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
		    	swing(body2, 1F * globalSpeed, 0.08F * globalDegree, true, 0.0F, 0.02F, limbSwing, limbSwingAmount);
		    	swing(body3, 1F * globalSpeed, 0.08F * globalDegree, true, 0.0F, 0.02F, limbSwing, limbSwingAmount);
		    	swing(hip, 1F * globalSpeed, 0.08F * globalDegree, false, 0.0F, 0.02F, limbSwing, limbSwingAmount);
				
		    	swing(tail, 1F * globalSpeed, 0.2F * globalDegree, false, 1.0F, 0.0F, limbSwing, limbSwingAmount);
		    	swing(tail_1, 1F * globalSpeed, 0.5F * globalDegree, false, 1.0F, 0.0F, limbSwing, limbSwingAmount);
		    	
		    	swing(leg_left_front, 1F * globalSpeed, 1F * globalDegree, false, 2.0F, -0.1F, limbSwing, limbSwingAmount);
		    	swing(leg_left_front_2, 1F * globalSpeed, 1F * globalDegree, false, -2.0F, -0.5F, limbSwing, limbSwingAmount);
		    	swing(leg_left_front_3, 1F * globalSpeed, 0.6F * globalDegree, false, -1.5F, 0.0F, limbSwing, limbSwingAmount);
		    	
		    	swing(leg_right_front, 1F * globalSpeed, 1F * globalDegree, false, 2.5F, -0.1F, limbSwing, limbSwingAmount);
		    	swing(leg_right_front_2, 1F * globalSpeed, 1F * globalDegree, false, -1.5F, -0.5F, limbSwing, limbSwingAmount);
		    	swing(leg_right_front_3, 1F * globalSpeed, 0.6F * globalDegree, false, -1.0F, 0.0F, limbSwing, limbSwingAmount);
		    	
		    	swing(leg_left_back, 1F * globalSpeed, 0.8F * globalDegree, false, -0.5F, 0.0F, limbSwing, limbSwingAmount);
		    	swing(leg_left_back_2, 1F * globalSpeed, 0.8F * globalDegree, false, -1.9F, 0.6F, limbSwing, limbSwingAmount);
		    	swing(leg_left_back_3, 1F * globalSpeed, 0.6F * globalDegree, false, -0.5F, 0.1F, limbSwing, limbSwingAmount);
		    	
		    	swing(leg_right_back, 1F * globalSpeed, 0.8F * globalDegree, false, -1.0F, 0.0F, limbSwing, limbSwingAmount);
		    	swing(leg_right_back_2, 1F * globalSpeed, 0.8F * globalDegree, false, -2.4F, 0.6F, limbSwing, limbSwingAmount);
		    	swing(leg_right_back_3, 1F * globalSpeed, 0.6F * globalDegree, false, -1.0F, 0.1F, limbSwing, limbSwingAmount);
		    	
				flap(shoulder_left, 1F * globalSpeed, 0.2F * globalDegree, false, 0.0F, -0.1F, limbSwing, limbSwingAmount);
				flap(shoulder_right, 1F * globalSpeed, 0.2F * globalDegree, true, 0.0F, -0.1F, limbSwing, limbSwingAmount);
				shake(shoulder_left, 1F * globalSpeed, 0.2F * globalDegree, true, 1.2F, 0.0F, limbSwing, limbSwingAmount);
				shake(shoulder_right, 1F * globalSpeed, 0.2F * globalDegree, false, 1.2F, 0.0F, limbSwing, limbSwingAmount);
		    	
				flap(hip_left, 1F * globalSpeed, 0.2F * globalDegree, false, 2.0F, -0.1F, limbSwing, limbSwingAmount);
				flap(hip_right, 1F * globalSpeed, 0.2F * globalDegree, true, 2.0F, 0.1F, limbSwing, limbSwingAmount);
				
				swing(neck, 1F * globalSpeed, 0.4F * globalDegree, true, 0.0F, 0.1F, limbSwing, limbSwingAmount);
				swing(head, 1F * globalSpeed, 0.4F * globalDegree, false, 0.2F, -0.1F, limbSwing, limbSwingAmount);
				swing(mouth_bottom, 1F * globalSpeed, 0.4F * globalDegree, true, 1.4F, 0.15F, limbSwing, limbSwingAmount);
				
				swing(ear_left, 1F * globalSpeed, 0.2F * globalDegree, false, 2.0F, 0.0F, limbSwing, limbSwingAmount);
				swing(ear_right, 1F * globalSpeed, 0.2F * globalDegree, false, 2.0F, 0.0F, limbSwing, limbSwingAmount);
			}
			else
			{
				float globalHeight = 1;
				float globalSpeed = 2.0F;
				float globalDegree = 1;
				
				loadAllDefaultValues(); //TODO Maybe replace with a different load method
				
				//Makes the Head Rotate where the Entity is Looking
	    		this.neck.rotateAngleY = (netHeadYaw * ((float)Math.PI / 180)) / 2;
	    		this.head.rotateAngleY = (netHeadYaw * ((float)Math.PI / 180)) / 4;
	    		this.head.rotateAngleZ = (netHeadYaw * ((float)Math.PI / 180)) / 4;
				
				bounce(body, 0.6F * globalSpeed, 0.8F * globalHeight, false, limbSwing, limbSwingAmount);
				
				swing(rotation_point_left_front, 0.3F * globalSpeed, 0.6F * globalDegree, false, -0.6F, 0.0F, limbSwing, limbSwingAmount);
				swing(leg_left_front_2, 0.3F * globalSpeed, 1.0F * globalDegree, false, 1.5F, -0.1F, limbSwing, limbSwingAmount);
				swing(leg_left_front_3, 0.3F * globalSpeed, 0.8F * globalDegree, false, 1.0F, 0.0F, limbSwing, limbSwingAmount);
				
				swing(rotation_point_right_front, 0.3F * globalSpeed, 0.6F * globalDegree, true, -0.6F, 0.0F, limbSwing, limbSwingAmount);
				swing(leg_right_front_2, 0.3F * globalSpeed, 1.0F * globalDegree, true, 1.5F, -0.1F, limbSwing, limbSwingAmount);
				swing(leg_right_front_3, 0.3F * globalSpeed, 0.8F * globalDegree, true, 1.0F, 0.0F, limbSwing, limbSwingAmount);
				
				swing(rotation_point_left_back, 0.3F * globalSpeed, 0.6F * globalDegree, true, 0.6F, 0.3F, limbSwing, limbSwingAmount);
				swing(leg_left_back_2, 0.3F * globalSpeed, 1.0F * globalDegree, true, -1.5F, 0.2F, limbSwing, limbSwingAmount);
				swing(leg_left_back_3, 0.3F * globalSpeed, 1.0F * globalDegree, false, -1.6F, -0.3F, limbSwing, limbSwingAmount);
				
				swing(rotation_point_right_back, 0.3F * globalSpeed, 0.6F * globalDegree, false, 0.6F, 0.3F, limbSwing, limbSwingAmount);
				swing(leg_right_back_2, 0.3F * globalSpeed, 1.0F * globalDegree, false, -1.5F, 0.2F, limbSwing, limbSwingAmount);
				swing(leg_right_back_3, 0.3F * globalSpeed, 1.0F * globalDegree, true, -1.6F, -0.3F, limbSwing, limbSwingAmount);
				
				//head
				swing(neck, 0.6F * globalSpeed, 0.1F * globalDegree, false, 1.5F, 0.0F, limbSwing, limbSwingAmount);
				swing(head, 0.6F * globalSpeed, 0.1F * globalDegree, false, -2.2F, 0.0F, limbSwing, limbSwingAmount);
				swing(mouth_bottom, 0.6F * globalSpeed, 0.1F * globalDegree, false, 2.0F, -0.2F, limbSwing, limbSwingAmount);
				swing(ear_left, 0.6F * globalSpeed, 0.1F * globalDegree, false, 2.2F, 0.0F, limbSwing, limbSwingAmount);
				swing(ear_right, 0.6F * globalSpeed, 0.1F * globalDegree, false, 2.2F, 0.0F, limbSwing, limbSwingAmount);
				//shoulder bones
				flap(shoulder_left, 0.6F * globalSpeed, 0.1F * globalDegree, false, 1.0F, 0.0F, limbSwing, limbSwingAmount);
				flap(shoulder_right, 0.6F * globalSpeed, 0.1F * globalDegree, true, 1.0F, 0.0F, limbSwing, limbSwingAmount);
				shake(shoulder_left, 0.3F * globalSpeed, 0.2F * globalDegree, true, 0.3F, 0.0F, limbSwing, limbSwingAmount);
				shake(shoulder_right, 0.3F * globalSpeed, 0.2F * globalDegree, false, 0.3F, 0.0F, limbSwing, limbSwingAmount);
				//hip bones
				flap(hip_left, 0.6F * globalSpeed, 0.1F * globalDegree, false, 1.0F, 0.0F, limbSwing, limbSwingAmount);
				flap(hip_right, 0.6F * globalSpeed, 0.1F * globalDegree, true, 1.0F, 0.0F, limbSwing, limbSwingAmount);
				//spine
				swing(body, 0.6F * globalSpeed, 0.02F * globalDegree, true, 1.0F, 0.0F, limbSwing, limbSwingAmount);
				swing(body2, 0.6F * globalSpeed, 0.05F * globalDegree, false, 2.0F, 0.0F, limbSwing, limbSwingAmount);
				swing(body3, 0.6F * globalSpeed, 0.05F * globalDegree, false, 2.0F, 0.0F, limbSwing, limbSwingAmount);
				swing(hip, 0.6F * globalSpeed, 0.05F * globalDegree, true, 2.0F, 0.0F, limbSwing, limbSwingAmount);
				//tail
				swing(tail, 0.6F * globalSpeed, 0.2F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
				swing(tail_1, 0.6F * globalSpeed, 0.2F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
			}
    	}
		else
		{
			float globalHeight = 1;
			float globalSpeed = 0.5F;
			float globalDegree = 1;
			
			limbSwing = entity.ticksExisted;
			limbSwingAmount = 1;
			
			loadAllDefaultValues(); //TODO Maybe replace with a different load method
			
			//Makes the Head Rotate where the Entity is Looking
    		this.neck.rotateAngleY = (netHeadYaw * ((float)Math.PI / 180) / 2);
    		this.head.rotateAngleY = (netHeadYaw * ((float)Math.PI / 180) / 2);
    		this.head.rotateAngleZ = (netHeadYaw * ((float)Math.PI / 180) / 4);
    		this.neck.rotateAngleX = (headPitch * ((float)Math.PI / 180F) / 2);
    		this.head.rotateAngleX = (headPitch * ((float)Math.PI / 180F) / 2);
			
			bounce(body, 0.4F * globalSpeed, 0.3F * globalHeight, false, limbSwing, limbSwingAmount);
			
			swing(rotation_point_left_front, 0.4F * globalSpeed, 0.05F * globalDegree, false, -2.2F, 0.1F, limbSwing, limbSwingAmount);
			swing(rotation_point_right_front, 0.4F * globalSpeed, 0.05F * globalDegree, false, -2.2F, 0.1F, limbSwing, limbSwingAmount);
			swing(leg_left_front_2, 0.4F * globalSpeed, 0.05F * globalDegree, true, -2.2F, 0.0F, limbSwing, limbSwingAmount);
			swing(leg_right_front_2, 0.4F * globalSpeed, 0.05F * globalDegree, true, -2.2F, 0.0F, limbSwing, limbSwingAmount);
			swing(leg_left_front_3, 0.4F * globalSpeed, 0.1F * globalDegree, true, -2.2F, 0.1F, limbSwing, limbSwingAmount);
			swing(leg_right_front_3, 0.4F * globalSpeed, 0.1F * globalDegree, true, -2.2F, 0.1F, limbSwing, limbSwingAmount);
			
			swing(rotation_point_left_back, 0.4F * globalSpeed, 0.05F * globalDegree, false, -2.2F, 0.1F, limbSwing, limbSwingAmount);
			swing(rotation_point_right_back, 0.4F * globalSpeed, 0.05F * globalDegree, false, -2.2F, 0.1F, limbSwing, limbSwingAmount);
			swing(leg_left_back_2, 0.4F * globalSpeed, 0.05F * globalDegree, true, -2.2F, 0.0F, limbSwing, limbSwingAmount);
			swing(leg_right_back_2, 0.4F * globalSpeed, 0.05F * globalDegree, true, -2.2F, 0.0F, limbSwing, limbSwingAmount);
			swing(leg_left_back_3, 0.4F * globalSpeed, 0.1F * globalDegree, true, -2.2F, 0.1F, limbSwing, limbSwingAmount);
			swing(leg_right_back_3, 0.4F * globalSpeed, 0.1F * globalDegree, true, -2.2F, 0.1F, limbSwing, limbSwingAmount);
			
			swing(body, 0.4F * globalSpeed, 0.01F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
			swing(body2, 0.4F * globalSpeed, 0.01F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
			swing(body3, 0.4F * globalSpeed, 0.01F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
			swing(hip, 0.4F * globalSpeed, 0.01F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
			
			swing(neck, 0.4F * globalSpeed, 0.1F * globalDegree, false, 1.0F, 0.0F, limbSwing, limbSwingAmount);
			swing(head, 0.4F * globalSpeed, 0.05F * globalDegree, true, 1.0F, 0.0F, limbSwing, limbSwingAmount);
			swing(mouth_bottom, 0.4F * globalSpeed, 0.15F * globalDegree, false, 1.0F, -0.1F, limbSwing, limbSwingAmount);
			swing(ear_left, 0.4F * globalSpeed, 0.1F * globalDegree, false, 1.2F, 0.0F, limbSwing, limbSwingAmount);
			swing(ear_right, 0.4F * globalSpeed, 0.1F * globalDegree, false, 1.2F, 0.0F, limbSwing, limbSwingAmount);
			
			flap(shoulder_left, 0.4F * globalSpeed, 0.1F * globalDegree, false, 1.0F, 0.0F, limbSwing, limbSwingAmount);
			flap(shoulder_right, 0.4F * globalSpeed, 0.1F * globalDegree, true, 1.0F, 0.0F, limbSwing, limbSwingAmount);
			shake(shoulder_left, 0.4F * globalSpeed, 0.05F * globalDegree, true, 0.3F, 0.0F, limbSwing, limbSwingAmount);
			shake(shoulder_right, 0.4F * globalSpeed, 0.05F * globalDegree, false, 0.3F, 0.0F, limbSwing, limbSwingAmount);
			
			flap(hip_left, 0.4F * globalSpeed, 0.1F * globalDegree, false, 1.0F, 0.0F, limbSwing, limbSwingAmount);
			flap(hip_right, 0.4F * globalSpeed, 0.1F * globalDegree, true, 1.0F, 0.0F, limbSwing, limbSwingAmount);
			
			swing(tail, 0.4F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
			swing(tail_1, 0.4F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
		}
    }
}
