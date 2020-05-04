package andrews.pandoras_creatures.entities.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import andrews.pandoras_creatures.entities.EndTrollEntity;
import andrews.pandoras_creatures.util.animation.Animator;
import andrews.pandoras_creatures.util.animation.PCEntityModel;
import andrews.pandoras_creatures.util.animation.PCModelRenderer;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * EnderTroll - andrew0030
 * Created using Tabula 7.1.0
 */
@OnlyIn(Dist.CLIENT)
public class EndTrollModel<T extends EndTrollEntity> extends PCEntityModel<T>
{
    public PCModelRenderer movement_base;
    public PCModelRenderer bottom_body;
    public PCModelRenderer stomach;
    public PCModelRenderer leg_left_1;
    public PCModelRenderer leg_right_1;
    public PCModelRenderer torso;
    public PCModelRenderer body_abs;
    public PCModelRenderer right_eyelid_base;
    public PCModelRenderer left_eyelid_base;
    public PCModelRenderer eye;
    public PCModelRenderer eye_details_top;
    public PCModelRenderer eye_details_top_1;
    public PCModelRenderer eye_details_bottom;
    public PCModelRenderer eye_details_bottom_1;
    public PCModelRenderer neck_bottom_front;
    public PCModelRenderer yaw_right;
    public PCModelRenderer yaw_left;
    public PCModelRenderer mouth_cheeck_left;
    public PCModelRenderer back;
    public PCModelRenderer head_top;
    public PCModelRenderer mouth_cheeck_right;
    public PCModelRenderer meat_left;
    public PCModelRenderer meat_right;
    public PCModelRenderer shoulder_main_left;
    public PCModelRenderer shoulder_main_right;
    public PCModelRenderer arm_left_connection;
    public PCModelRenderer arm_right_connection;
    public PCModelRenderer shoulder_bone_left;
    public PCModelRenderer shoulder_bone_left_1;
    public PCModelRenderer right_eyelid_side;
    public PCModelRenderer right_eyelid_top;
    public PCModelRenderer right_eyelid_bottom;
    public PCModelRenderer right_eyelid_side_top;
    public PCModelRenderer right_eyelid_side_bottom;
    public PCModelRenderer left_eyelid_side;
    public PCModelRenderer left_eyelid_top;
    public PCModelRenderer left_eyelid_bottom;
    public PCModelRenderer left_eyelid_side_top;
    public PCModelRenderer left_eyelid_side_bottom;
    public PCModelRenderer mouth_bottom_front;
    public PCModelRenderer mouth_bottom_left;
    public PCModelRenderer mouth_bottom_right;
    public PCModelRenderer tooth;
    public PCModelRenderer tooth_1;
    public PCModelRenderer neck_bottom_left;
    public PCModelRenderer tooth_2;
    public PCModelRenderer neck_bottom_right;
    public PCModelRenderer tooth_3;
    public PCModelRenderer tooth_4;
    public PCModelRenderer mouth_top_lip;
    public PCModelRenderer head_back;
    public PCModelRenderer head_parts;
    public PCModelRenderer head_parts_1;
    public PCModelRenderer nose_main;
    public PCModelRenderer mouth_top_front;
    public PCModelRenderer mouth_top_left;
    public PCModelRenderer mouth_top_right;
    public PCModelRenderer tooth_5;
    public PCModelRenderer tooth_6;
    public PCModelRenderer mouth_top_lips_left;
    public PCModelRenderer mouth_top_left_back;
    public PCModelRenderer tooth_7;
    public PCModelRenderer mouth_skin_left;
    public PCModelRenderer shape62;
    public PCModelRenderer mouth_top_lips_right;
    public PCModelRenderer mouth_top_right_back;
    public PCModelRenderer tooth_8;
    public PCModelRenderer mouth_skin_right;
    public PCModelRenderer shape72;
    public PCModelRenderer head_left;
    public PCModelRenderer head_right;
    public PCModelRenderer head_back_cover;
    public PCModelRenderer head_parts_2;
    public PCModelRenderer head_parts_3;
    public PCModelRenderer head_parts_4;
    public PCModelRenderer head_parts_5;
    public PCModelRenderer nose_bottom;
    public PCModelRenderer nose_left;
    public PCModelRenderer nose_right;
    public PCModelRenderer nose_top;
    public PCModelRenderer nose_front;
    public PCModelRenderer nose_left_2;
    public PCModelRenderer nose_left_3;
    public PCModelRenderer nose_right_2;
    public PCModelRenderer nose_right_3;
    public PCModelRenderer nose_tip;
    public PCModelRenderer shape90;
    public PCModelRenderer shape91;
    public PCModelRenderer shape92;
    public PCModelRenderer shape95;
    public PCModelRenderer shape97;
    public PCModelRenderer shape93;
    public PCModelRenderer shape96;
    public PCModelRenderer shape90_1;
    public PCModelRenderer shape91_1;
    public PCModelRenderer shape92_1;
    public PCModelRenderer shape95_1;
    public PCModelRenderer shape97_1;
    public PCModelRenderer shape93_1;
    public PCModelRenderer shape96_1;
    public PCModelRenderer arm_left_rotation_point;
    public PCModelRenderer arm_left_main;
    public PCModelRenderer arm_left_1;
    public PCModelRenderer spike;
    public PCModelRenderer arm_left_2;
    public PCModelRenderer arm_left_1_decoration;
    public PCModelRenderer arm_left_1_decoration_1;
    public PCModelRenderer hand_left_main;
    public PCModelRenderer hand_left_back;
    public PCModelRenderer hand_left_finger_right_1;
    public PCModelRenderer hand_left_finger_left_1;
    public PCModelRenderer hand_left_2;
    public PCModelRenderer hand_left_finger_right_2;
    public PCModelRenderer hand_left_finger_right_3;
    public PCModelRenderer hand_left_finger_left_2;
    public PCModelRenderer hand_left_finger_left_3;
    public PCModelRenderer hand_left_thumb_1;
    public PCModelRenderer hand_left_thumb_2;
    public PCModelRenderer spike_1;
    public PCModelRenderer spike_2;
    public PCModelRenderer arm_right_rotation_point;
    public PCModelRenderer arm_right_main;
    public PCModelRenderer arm_right_1;
    public PCModelRenderer spike_3;
    public PCModelRenderer arm_right_2;
    public PCModelRenderer arm_right_1_decoration;
    public PCModelRenderer arm_right_1_decoration_1;
    public PCModelRenderer hand_right_main;
    public PCModelRenderer hand_right_back;
    public PCModelRenderer hand_right_finger_right_1;
    public PCModelRenderer hand_right_finger_left_1;
    public PCModelRenderer hand_right_2;
    public PCModelRenderer hand_right_finger_right_2;
    public PCModelRenderer hand_right_finger_right_3;
    public PCModelRenderer hand_right_finger_left_2;
    public PCModelRenderer hand_right_finger_left_3;
    public PCModelRenderer hand_right_thumb_1;
    public PCModelRenderer hand_right_thumb_2;
    public PCModelRenderer spike_4;
    public PCModelRenderer spike_5;
    public PCModelRenderer spike_6;
    public PCModelRenderer spike_7;
    public PCModelRenderer spike_8;
    public PCModelRenderer spike_9;
    public PCModelRenderer spike_10;
    public PCModelRenderer spike_11;
    public PCModelRenderer body_abs_bottom;
    public PCModelRenderer leg_left_2;
    public PCModelRenderer leg_left_top_decoration;
    public PCModelRenderer leg_left_3;
    public PCModelRenderer leg_left_calf_muscle;
    public PCModelRenderer leg_left_4;
    public PCModelRenderer foot_left_front_slope;
    public PCModelRenderer foot_left_back;
    public PCModelRenderer foot_left_back_slope;
    public PCModelRenderer leg_right_2;
    public PCModelRenderer leg_right_top_decoration;
    public PCModelRenderer leg_right_3;
    public PCModelRenderer leg_right_calf_muscle;
    public PCModelRenderer leg_right_4;
    public PCModelRenderer foot_right_front_slope;
    public PCModelRenderer foot_right_back;
    public PCModelRenderer foot_right_back_slope;
    
    public Animator animator = new Animator();

    public EndTrollModel()
    {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.neck_bottom_right = new PCModelRenderer(this, 184, 217);
        this.neck_bottom_right.setRotationPoint(-0.3F, 3.1F, 0.0F);
        this.neck_bottom_right.addBox(-7.0F, 0.0F, 0.0F, 7, 6, 3, 0.0F);
        this.setRotateAngle(neck_bottom_right, 0.3839724354387525F, 0.023212879051524582F, 0.28797932657906433F);
        this.mouth_top_front = new PCModelRenderer(this, 205, 209);
        this.mouth_top_front.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.mouth_top_front.addBox(-5.0F, 0.0F, 0.0F, 10, 3, 3, 0.0F);
        this.setRotateAngle(mouth_top_front, 0.5153957281139255F, 0.0F, 0.0F);
        this.shape96_1 = new PCModelRenderer(this, 16, 26);
        this.shape96_1.setRotationPoint(0.01F, 0.0F, 9.0F);
        this.shape96_1.addBox(0.0F, 0.0F, 0.0F, 5, 5, 6, 0.0F);
        this.setRotateAngle(shape96_1, -0.9075712110370513F, 0.0F, 0.0F);
        this.spike_6 = new PCModelRenderer(this, 225, 82);
        this.spike_6.setRotationPoint(2.0F, 6.0F, -0.5F);
        this.spike_6.addBox(0.0F, -4.0F, 0.0F, 4, 4, 5, 0.0F);
        this.setRotateAngle(spike_6, 0.22689280275926282F, -0.06981317007977318F, 0.0F);
        this.meat_left = new PCModelRenderer(this, 227, 149);
        this.meat_left.setRotationPoint(13.0F, -16.0F, 6.0F);
        this.meat_left.addBox(-4.0F, -12.0F, 0.0F, 4, 12, 8, 0.0F);
        this.setRotateAngle(meat_left, 0.0F, -0.6806784082777886F, 0.025132741228718346F);
        this.mouth_top_right_back = new PCModelRenderer(this, 184, 202);
        this.mouth_top_right_back.setRotationPoint(-7.0F, 0.0F, 0.0F);
        this.mouth_top_right_back.addBox(-10.0F, 0.0F, 0.0F, 10, 3, 3, 0.0F);
        this.setRotateAngle(mouth_top_right_back, 0.0F, 0.6370451769779303F, 0.0F);
        this.hand_left_thumb_2 = new PCModelRenderer(this, 118, 249);
        this.hand_left_thumb_2.setRotationPoint(1.0F, 4.0F, 0.01F);
        this.hand_left_thumb_2.addBox(-3.0F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
        this.setRotateAngle(hand_left_thumb_2, 0.0F, 0.0F, 0.7686430025783028F);
        this.foot_right_front_slope = new PCModelRenderer(this, 46, 213);
        this.foot_right_front_slope.setRotationPoint(0.0F, 7.0F, 8.0F);
        this.foot_right_front_slope.addBox(-2.0F, -2.0F, -7.0F, 4, 2, 7, 0.0F);
        this.setRotateAngle(foot_right_front_slope, 0.3143337982841788F, 0.0F, 0.0F);
        this.shape96 = new PCModelRenderer(this, 155, 26);
        this.shape96.setRotationPoint(0.01F, 0.0F, 9.0F);
        this.shape96.addBox(0.0F, 0.0F, 0.0F, 5, 5, 6, 0.0F);
        this.setRotateAngle(shape96, -0.9075712110370513F, 0.0F, 0.0F);
        this.hand_left_back = new PCModelRenderer(this, 92, 217);
        this.hand_left_back.setRotationPoint(2.0F, -0.1F, 0.0F);
        this.hand_left_back.addBox(-1.0F, 0.0F, -4.5F, 2, 6, 9, 0.0F);
        this.setRotateAngle(hand_left_back, 0.0F, 0.0F, -0.24434609527920614F);
        this.spike_11 = new PCModelRenderer(this, 238, 57);
        this.spike_11.setRotationPoint(-4.0F, 12.0F, -0.5F);
        this.spike_11.addBox(-4.0F, 0.0F, 0.0F, 4, 4, 5, 0.0F);
        this.setRotateAngle(spike_11, -0.40142572795869574F, 0.0F, 0.0F);
        this.leg_left_4 = new PCModelRenderer(this, 0, 243);
        this.leg_left_4.setRotationPoint(0.0F, 7.0F, 10.5F);
        this.leg_left_4.addBox(-4.5F, -8.3F, 0.0F, 9, 10, 3, 0.0F);
        this.setRotateAngle(leg_left_4, 0.41887902047863906F, 0.0F, 0.0F);
        this.nose_left_3 = new PCModelRenderer(this, 242, 0);
        this.nose_left_3.setRotationPoint(3.0F, 0.0F, -0.01F);
        this.nose_left_3.addBox(0.0F, 0.0F, -2.0F, 5, 3, 2, 0.0F);
        this.setRotateAngle(nose_left_3, 0.0F, 0.0F, 0.8203047484373349F);
        this.tooth_3 = new PCModelRenderer(this, 236, 252);
        this.tooth_3.setRotationPoint(4.0F, 0.0F, 0.5F);
        this.tooth_3.addBox(-0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(tooth_3, 0.0F, -0.4363323129985824F, 0.13962634015954636F);
        this.tooth_5 = new PCModelRenderer(this, 246, 249);
        this.tooth_5.setRotationPoint(-2.4F, 3.0F, 1.5F);
        this.tooth_5.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
        this.tooth_8 = new PCModelRenderer(this, 251, 249);
        this.tooth_8.setRotationPoint(-3.0F, 3.0F, 1.5F);
        this.tooth_8.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
        this.body_abs = new PCModelRenderer(this, 0, 57);
        this.body_abs.setRotationPoint(0.0F, 16.4F, -20.0F);
        this.body_abs.addBox(-9.0F, -5.0F, 0.0F, 18, 5, 7, 0.0F);
        this.setRotateAngle(body_abs, -0.14800392056911915F, 0.0F, 0.0F);
        this.back = new PCModelRenderer(this, 184, 144);
        this.back.setRotationPoint(0.0F, 1.2F, 11.1F);
        this.back.addBox(-8.0F, -29.0F, -5.0F, 16, 14, 5, 0.0F);
        this.setRotateAngle(back, -0.05811946409141117F, 0.0F, 0.0F);
        this.spike_8 = new PCModelRenderer(this, 225, 62);
        this.spike_8.setRotationPoint(4.0F, 12.0F, -0.5F);
        this.spike_8.addBox(0.0F, 0.0F, 0.0F, 4, 4, 5, 0.0F);
        this.setRotateAngle(spike_8, -0.40142572795869574F, 0.0F, 0.0F);
        this.right_eyelid_side = new PCModelRenderer(this, 188, 27);
        this.right_eyelid_side.setRotationPoint(-4.0F, 0.01F, -19.0F);
        this.right_eyelid_side.addBox(-6.0F, -7.0F, 0.0F, 6, 7, 3, 0.0F);
        this.setRotateAngle(right_eyelid_side, 0.0F, 0.5410520681182421F, 0.0F);
        this.arm_left_2 = new PCModelRenderer(this, 92, 178);
        this.arm_left_2.setRotationPoint(0.0F, 15.5F, 0.0F);
        this.arm_left_2.addBox(-4.5F, 0.0F, -6.0F, 9, 18, 12, 0.0F);
        this.setRotateAngle(arm_left_2, -0.4553564018453205F, 0.0F, 0.0F);
        this.tooth_1 = new PCModelRenderer(this, 231, 253);
        this.tooth_1.setRotationPoint(4.0F, 0.1F, 1.4F);
        this.tooth_1.addBox(-0.5F, -1.0F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotateAngle(tooth_1, -0.17453292519943295F, 0.0F, 0.0F);
        this.left_eyelid_side_bottom = new PCModelRenderer(this, 241, 38);
        this.left_eyelid_side_bottom.setRotationPoint(4.0F, 0.1F, 0.0F);
        this.left_eyelid_side_bottom.addBox(0.0F, 0.0F, 0.0F, 6, 5, 1, 0.0F);
        this.setRotateAngle(left_eyelid_side_bottom, 0.024434609527920613F, -0.41887902047863906F, 0.2792526803190927F);
        this.spike = new PCModelRenderer(this, 119, 132);
        this.spike.setRotationPoint(6.4F, -3.0F, -3.0F);
        this.spike.addBox(0.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(spike, -0.6283185307179586F, 0.3490658503988659F, -0.3490658503988659F);
        this.arm_right_rotation_point = new PCModelRenderer(this, 0, 0);
        this.arm_right_rotation_point.setRotationPoint(-2.0F, 0.0F, 0.0F);
        this.arm_right_rotation_point.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(arm_right_rotation_point, -0.7155849933176751F, 0.0F, 0.0F);
        this.eye_details_bottom = new PCModelRenderer(this, 133, 64);
        this.eye_details_bottom.setRotationPoint(0.0F, -8.6F, -7.4F);
        this.eye_details_bottom.addBox(0.0F, -2.0F, -1.0F, 7, 2, 2, 0.0F);
        this.setRotateAngle(eye_details_bottom, 0.0F, 0.1361356816555577F, -0.17453292519943295F);
        this.nose_main = new PCModelRenderer(this, 199, 0);
        this.nose_main.setRotationPoint(0.0F, -14.2F, -17.9F);
        this.nose_main.addBox(-1.0F, 0.0F, 0.0F, 2, 7, 7, 0.0F);
        this.setRotateAngle(nose_main, 0.7682939367279039F, 0.0F, 0.0F);
        this.leg_left_3 = new PCModelRenderer(this, 0, 223);
        this.leg_left_3.setRotationPoint(0.0F, -4.0F, 11.0F);
        this.leg_left_3.addBox(-3.0F, 0.0F, -0.5F, 6, 7, 11, 0.0F);
        this.setRotateAngle(leg_left_3, -1.1215485773315563F, 0.0F, 0.0F);
        this.mouth_cheeck_left = new PCModelRenderer(this, 206, 164);
        this.mouth_cheeck_left.setRotationPoint(12.0F, -16.0F, 0.0F);
        this.mouth_cheeck_left.addBox(-4.0F, -12.0F, 0.0F, 4, 12, 6, 0.0F);
        this.setRotateAngle(mouth_cheeck_left, 0.0F, 0.3385938748868999F, -0.08726646259971647F);
        this.shape91_1 = new PCModelRenderer(this, 29, 0);
        this.shape91_1.setRotationPoint(0.01F, -7.0F, 7.0F);
        this.shape91_1.addBox(0.0F, 0.0F, 0.0F, 5, 5, 6, 0.0F);
        this.setRotateAngle(shape91_1, -0.9075712110370513F, 0.0F, 0.0F);
        this.hand_right_finger_right_1 = new PCModelRenderer(this, 154, 233);
        this.hand_right_finger_right_1.setRotationPoint(3.2F, 5.0F, -2.9F);
        this.hand_right_finger_right_1.addBox(-2.0F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
        this.setRotateAngle(hand_right_finger_right_1, 0.0F, 0.0F, -0.10471975511965977F);
        this.spike_9 = new PCModelRenderer(this, 238, 77);
        this.spike_9.setRotationPoint(-2.0F, 6.0F, -0.5F);
        this.spike_9.addBox(-4.0F, -4.0F, 0.0F, 4, 4, 5, 0.0F);
        this.setRotateAngle(spike_9, 0.22689280275926282F, -0.06981317007977318F, 0.0F);
        this.shape95_1 = new PCModelRenderer(this, 74, 26);
        this.shape95_1.setRotationPoint(0.01F, 0.0F, -9.0F);
        this.shape95_1.addBox(0.0F, 0.0F, -6.0F, 5, 5, 6, 0.0F);
        this.setRotateAngle(shape95_1, 0.9075712110370513F, 0.0F, 0.0F);
        this.mouth_bottom_front = new PCModelRenderer(this, 204, 227);
        this.mouth_bottom_front.setRotationPoint(0.0F, -10.0F, 0.0F);
        this.mouth_bottom_front.addBox(-5.0F, -3.0F, 0.0F, 10, 3, 3, 0.0F);
        this.setRotateAngle(mouth_bottom_front, -0.589397688398485F, 0.0F, 0.0F);
        this.leg_right_calf_muscle = new PCModelRenderer(this, 69, 213);
        this.leg_right_calf_muscle.setRotationPoint(0.0F, -4.0F, 6.0F);
        this.leg_right_calf_muscle.addBox(-1.5F, 0.0F, -7.0F, 3, 2, 7, 0.0F);
        this.setRotateAngle(leg_right_calf_muscle, -0.4052654523130833F, 0.0F, 0.0F);
        this.hand_right_thumb_1 = new PCModelRenderer(this, 167, 241);
        this.hand_right_thumb_1.setRotationPoint(-1.5F, 4.5F, 0.0F);
        this.hand_right_thumb_1.addBox(-2.0F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
        this.setRotateAngle(hand_right_thumb_1, 0.0F, 3.141592653589793F, 1.0618583169133502F);
        this.arm_right_connection = new PCModelRenderer(this, 141, 110);
        this.arm_right_connection.setRotationPoint(-16.0F, -12.3F, 2.0F);
        this.arm_right_connection.addBox(-3.0F, -3.5F, -3.5F, 3, 7, 7, 0.0F);
        this.shape93 = new PCModelRenderer(this, 148, 11);
        this.shape93.setRotationPoint(0.01F, 0.0F, 6.0F);
        this.shape93.addBox(0.0F, 0.0F, 0.0F, 5, 5, 9, 0.0F);
        this.setRotateAngle(shape93, -0.6632251157578453F, 0.0F, 0.0F);
        this.head_left = new PCModelRenderer(this, 205, 92);
        this.head_left.setRotationPoint(4.3F, -0.8F, 0.0F);
        this.head_left.addBox(1.1F, -0.2F, 0.0F, 9, 2, 9, 0.0F);
        this.setRotateAngle(head_left, -0.05480333851262195F, 0.0F, 0.8604473212332043F);
        this.foot_right_back_slope = new PCModelRenderer(this, 71, 242);
        this.foot_right_back_slope.setRotationPoint(0.0F, -1.5F, 0.0F);
        this.foot_right_back_slope.addBox(-1.5F, 0.0F, -7.0F, 3, 2, 7, 0.0F);
        this.setRotateAngle(foot_right_back_slope, 0.25569073541716925F, 0.0F, 0.0F);
        this.arm_right_1 = new PCModelRenderer(this, 141, 150);
        this.arm_right_1.setRotationPoint(-3.5F, 0.0F, 0.0F);
        this.arm_right_1.addBox(-3.0F, 0.0F, -4.5F, 6, 18, 9, 0.0F);
        this.setRotateAngle(arm_right_1, 0.7853981633974483F, 0.0F, 0.0F);
        this.shape97_1 = new PCModelRenderer(this, 39, 20);
        this.shape97_1.setRotationPoint(0.0F, 0.0F, -6.0F);
        this.shape97_1.addBox(0.0F, 0.0F, -12.0F, 5, 5, 12, 0.0F);
        this.setRotateAngle(shape97_1, 0.6632251157578453F, 0.0F, 0.0F);
        this.hand_left_finger_right_2 = new PCModelRenderer(this, 92, 241);
        this.hand_left_finger_right_2.setRotationPoint(1.0F, 4.0F, 0.01F);
        this.hand_left_finger_right_2.addBox(-3.0F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
        this.setRotateAngle(hand_left_finger_right_2, 0.0F, 0.0F, 0.4886921905584123F);
        this.arm_right_main = new PCModelRenderer(this, 141, 125);
        this.arm_right_main.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.arm_right_main.addBox(-7.0F, -6.0F, -6.0F, 7, 12, 12, 0.0F);
        this.setRotateAngle(arm_right_main, -1.0016444577195458F, 0.0F, 0.0F);
        this.left_eyelid_side = new PCModelRenderer(this, 237, 27);
        this.left_eyelid_side.setRotationPoint(4.0F, 0.01F, -19.0F);
        this.left_eyelid_side.addBox(0.0F, -7.0F, 0.0F, 6, 7, 3, 0.0F);
        this.setRotateAngle(left_eyelid_side, 0.0F, -0.5410520681182421F, 0.0F);
        this.nose_right_3 = new PCModelRenderer(this, 160, 0);
        this.nose_right_3.setRotationPoint(-3.0F, 0.0F, -0.01F);
        this.nose_right_3.addBox(-5.0F, 0.0F, -2.0F, 5, 3, 2, 0.0F);
        this.setRotateAngle(nose_right_3, 0.0F, 0.0F, -0.8203047484373349F);
        this.hand_left_2 = new PCModelRenderer(this, 118, 227);
        this.hand_left_2.setRotationPoint(-1.0F, -0.2F, 0.0F);
        this.hand_left_2.addBox(-2.7F, 0.0F, -3.5F, 4, 6, 7, 0.0F);
        this.setRotateAngle(hand_left_2, 0.0F, 0.0F, 0.19268434942017396F);
        this.spike_4 = new PCModelRenderer(this, 168, 127);
        this.spike_4.setRotationPoint(2.0F, 2.8F, 3.4F);
        this.spike_4.addBox(-2.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(spike_4, 0.0F, -0.17453292519943295F, -0.41887902047863906F);
        this.nose_left_2 = new PCModelRenderer(this, 231, 0);
        this.nose_left_2.setRotationPoint(4.0F, 0.01F, 1.0F);
        this.nose_left_2.addBox(0.0F, 0.0F, -2.0F, 3, 6, 2, 0.0F);
        this.setRotateAngle(nose_left_2, 0.0F, 1.0821041362364843F, 0.0F);
        this.shape92 = new PCModelRenderer(this, 98, 11);
        this.shape92.setRotationPoint(0.01F, 0.0F, -6.0F);
        this.shape92.addBox(0.0F, 0.0F, -9.0F, 5, 5, 9, 0.0F);
        this.setRotateAngle(shape92, 0.6632251157578453F, 0.0F, 0.0F);
        this.shoulder_bone_left_1 = new PCModelRenderer(this, 186, 64);
        this.shoulder_bone_left_1.setRotationPoint(0.0F, -20.21F, 15.0F);
        this.shoulder_bone_left_1.addBox(-14.0F, 0.0F, -5.0F, 14, 20, 5, 0.0F);
        this.setRotateAngle(shoulder_bone_left_1, 0.0F, -0.22689280275926282F, 0.0F);
        this.tooth_6 = new PCModelRenderer(this, 241, 249);
        this.tooth_6.setRotationPoint(2.4F, 3.0F, 1.5F);
        this.tooth_6.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
        this.shape90 = new PCModelRenderer(this, 109, 0);
        this.shape90.setRotationPoint(0.01F, -7.0F, -7.0F);
        this.shape90.addBox(0.0F, 0.0F, -6.0F, 5, 5, 6, 0.0F);
        this.setRotateAngle(shape90, 0.9075712110370513F, 0.0F, 0.0F);
        this.nose_right_2 = new PCModelRenderer(this, 175, 0);
        this.nose_right_2.setRotationPoint(-4.0F, 0.01F, 1.01F);
        this.nose_right_2.addBox(-3.0F, 0.0F, -2.0F, 3, 6, 2, 0.0F);
        this.setRotateAngle(nose_right_2, 0.0F, -1.0821041362364843F, 0.0F);
        this.spike_7 = new PCModelRenderer(this, 225, 73);
        this.spike_7.setRotationPoint(8.0F, 6.0F, 0.0F);
        this.spike_7.addBox(0.0F, 0.0F, 0.0F, 4, 4, 4, 0.0F);
        this.setRotateAngle(spike_7, 0.0F, 0.10471975511965977F, 0.0F);
        this.hand_left_thumb_1 = new PCModelRenderer(this, 118, 241);
        this.hand_left_thumb_1.setRotationPoint(-1.5F, 4.5F, 0.0F);
        this.hand_left_thumb_1.addBox(-2.0F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
        this.setRotateAngle(hand_left_thumb_1, 0.0F, 3.141592653589793F, 1.0618583169133502F);
        this.foot_left_front_slope = new PCModelRenderer(this, 0, 213);
        this.foot_left_front_slope.setRotationPoint(0.0F, 7.0F, 8.0F);
        this.foot_left_front_slope.addBox(-2.0F, -2.0F, -7.0F, 4, 2, 7, 0.0F);
        this.setRotateAngle(foot_left_front_slope, 0.3143337982841788F, 0.0F, 0.0F);
        this.yaw_right = new PCModelRenderer(this, 182, 239);
        this.yaw_right.setRotationPoint(12.2F, -14.7F, -5.9F);
        this.yaw_right.addBox(-3.0F, -8.0F, 0.0F, 3, 8, 8, 0.0F);
        this.setRotateAngle(yaw_right, 0.0F, 0.1884955592153876F, -0.23561944901923448F);
        this.foot_right_back = new PCModelRenderer(this, 71, 252);
        this.foot_right_back.setRotationPoint(0.0F, -8.3F, 2.0F);
        this.foot_right_back.addBox(-2.0F, -2.0F, -1.0F, 4, 2, 2, 0.0F);
        this.hand_left_finger_right_3 = new PCModelRenderer(this, 92, 249);
        this.hand_left_finger_right_3.setRotationPoint(0.0F, 4.0F, 0.01F);
        this.hand_left_finger_right_3.addBox(-3.0F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
        this.setRotateAngle(hand_left_finger_right_3, 0.0F, 0.0F, 0.2792526803190927F);
        this.head_top = new PCModelRenderer(this, 180, 130);
        this.head_top.setRotationPoint(0.0F, -20.2F, 7.9F);
        this.head_top.addBox(-5.0F, -14.0F, -12.6F, 10, 3, 10, 0.0F);
        this.setRotateAngle(head_top, -0.40980330836826856F, 0.0F, 0.0F);
        this.head_parts_5 = new PCModelRenderer(this, 167, 112);
        this.head_parts_5.setRotationPoint(-2.0F, 0.0F, -0.4F);
        this.head_parts_5.addBox(-3.0F, 0.0F, -4.0F, 3, 1, 4, 0.0F);
        this.hand_left_finger_right_1 = new PCModelRenderer(this, 92, 233);
        this.hand_left_finger_right_1.setRotationPoint(3.2F, 5.0F, -2.9F);
        this.hand_left_finger_right_1.addBox(-2.0F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
        this.setRotateAngle(hand_left_finger_right_1, 0.0F, 0.0F, -0.10471975511965977F);
        this.eye = new PCModelRenderer(this, 112, 59);
        this.eye.setRotationPoint(0.0F, -13.0F, -7.5F);
        this.eye.addBox(-2.5F, -2.5F, -2.5F, 5, 5, 5, 0.0F);
        this.mouth_bottom_right = new PCModelRenderer(this, 183, 227);
        this.mouth_bottom_right.setRotationPoint(-5.0F, -2.8F, 0.0F);
        this.mouth_bottom_right.addBox(-7.0F, 0.0F, 0.0F, 7, 3, 3, 0.0F);
        this.setRotateAngle(mouth_bottom_right, 0.0F, 0.6981317007977318F, -0.08726646259971647F);
        this.hand_right_back = new PCModelRenderer(this, 141, 217);
        this.hand_right_back.setRotationPoint(2.0F, -0.1F, 0.0F);
        this.hand_right_back.addBox(-1.0F, 0.0F, -4.5F, 2, 6, 9, 0.0F);
        this.setRotateAngle(hand_right_back, 0.0F, 0.0F, -0.24434609527920614F);
        this.arm_right_2 = new PCModelRenderer(this, 141, 178);
        this.arm_right_2.setRotationPoint(0.0F, 15.5F, 0.0F);
        this.arm_right_2.addBox(-4.5F, 0.0F, -6.0F, 9, 18, 12, 0.0F);
        this.setRotateAngle(arm_right_2, -0.4553564018453205F, 0.0F, 0.0F);
        this.leg_left_top_decoration = new PCModelRenderer(this, 0, 157);
        this.leg_left_top_decoration.setRotationPoint(5.0F, -1.8F, 0.0F);
        this.leg_left_top_decoration.addBox(-7.0F, 0.0F, -4.0F, 7, 4, 8, 0.0F);
        this.setRotateAngle(leg_left_top_decoration, 0.0F, 0.0F, 0.7089527421600966F);
        this.leg_right_2 = new PCModelRenderer(this, 46, 195);
        this.leg_right_2.setRotationPoint(-3.0F, 10.0F, 2.5F);
        this.leg_right_2.addBox(-2.5F, -3.9F, 0.0F, 5, 6, 11, 0.0F);
        this.setRotateAngle(leg_right_2, -0.27314402793711257F, 0.0F, -0.019198621771937624F);
        this.spike_1 = new PCModelRenderer(this, 119, 127);
        this.spike_1.setRotationPoint(-2.0F, 2.8F, 3.4F);
        this.spike_1.addBox(0.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(spike_1, 0.0F, -0.17453292519943295F, 0.41887902047863906F);
        this.tooth_2 = new PCModelRenderer(this, 251, 253);
        this.tooth_2.setRotationPoint(-4.0F, 0.1F, 1.4F);
        this.tooth_2.addBox(-0.5F, -1.0F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotateAngle(tooth_2, -0.17453292519943295F, 0.0F, 0.0F);
        this.mouth_top_left = new PCModelRenderer(this, 232, 209);
        this.mouth_top_left.setRotationPoint(5.0F, -0.1F, 0.0F);
        this.mouth_top_left.addBox(0.0F, 0.0F, 0.0F, 7, 3, 3, 0.0F);
        this.setRotateAngle(mouth_top_left, 0.0F, -0.6981317007977318F, 0.08726646259971647F);
        this.right_eyelid_base = new PCModelRenderer(this, 207, 27);
        this.right_eyelid_base.setRotationPoint(0.0F, -9.5F, 8.0F);
        this.right_eyelid_base.addBox(-4.0F, -7.0F, -19.0F, 4, 7, 3, 0.0F);
        this.setRotateAngle(right_eyelid_base, 0.0F, 0.3141592653589793F, 0.0F);
        this.nose_front = new PCModelRenderer(this, 223, 8);
        this.nose_front.setRotationPoint(0.01F, 0.0F, 0.0F);
        this.nose_front.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 7, 0.0F);
        this.setRotateAngle(nose_front, 0.2734930937875114F, 0.0F, 0.0F);
        this.head_parts_1 = new PCModelRenderer(this, 182, 111);
        this.head_parts_1.setRotationPoint(-4.9F, -14.3F, -7.0F);
        this.head_parts_1.addBox(-7.0F, 0.0F, 0.0F, 7, 2, 4, 0.0F);
        this.setRotateAngle(head_parts_1, 0.008726646259971648F, -0.43458698374658805F, -0.7609635538695276F);
        this.body_abs_bottom = new PCModelRenderer(this, 0, 70);
        this.body_abs_bottom.setRotationPoint(0.0F, 0.0F, 7.0F);
        this.body_abs_bottom.addBox(-8.0F, -5.0F, 0.0F, 16, 5, 14, 0.0F);
        this.setRotateAngle(body_abs_bottom, 0.3410373358396919F, 0.0F, 0.0F);
        this.meat_right = new PCModelRenderer(this, 227, 170);
        this.meat_right.setRotationPoint(-13.0F, -16.0F, 6.0F);
        this.meat_right.addBox(0.0F, -12.0F, 0.0F, 4, 12, 8, 0.0F);
        this.setRotateAngle(meat_right, 0.0F, 0.6806784082777886F, -0.025132741228718346F);
        this.leg_left_2 = new PCModelRenderer(this, 0, 195);
        this.leg_left_2.setRotationPoint(3.0F, 10.0F, 2.5F);
        this.leg_left_2.addBox(-2.5F, -3.9F, 0.0F, 5, 6, 11, 0.0F);
        this.setRotateAngle(leg_left_2, -0.27314402793711257F, 0.0F, -0.019198621771937624F);
        this.shoulder_bone_left = new PCModelRenderer(this, 147, 64);
        this.shoulder_bone_left.setRotationPoint(0.0F, -20.2F, 15.0F);
        this.shoulder_bone_left.addBox(0.0F, 0.0F, -5.0F, 14, 20, 5, 0.0F);
        this.setRotateAngle(shoulder_bone_left, 0.0F, 0.22689280275926282F, 0.0F);
        this.head_parts_3 = new PCModelRenderer(this, 167, 98);
        this.head_parts_3.setRotationPoint(2.0F, 0.0F, -0.4F);
        this.head_parts_3.addBox(0.0F, 0.0F, -4.0F, 3, 1, 4, 0.0F);
        this.nose_right = new PCModelRenderer(this, 186, 0);
        this.nose_right.setRotationPoint(-0.4F, 0.2F, 6.0F);
        this.nose_right.addBox(-4.0F, 0.0F, -1.0F, 4, 7, 2, 0.0F);
        this.setRotateAngle(nose_right, 0.0F, -0.3839724354387525F, 0.0F);
        this.arm_right_1_decoration = new PCModelRenderer(this, 172, 177);
        this.arm_right_1_decoration.setRotationPoint(0.0F, 10.2F, -4.5F);
        this.arm_right_1_decoration.addBox(-2.0F, -10.0F, 0.0F, 4, 10, 2, 0.0F);
        this.setRotateAngle(arm_right_1_decoration, 0.317649923862968F, 0.0F, 0.0F);
        this.left_eyelid_bottom = new PCModelRenderer(this, 226, 38);
        this.left_eyelid_bottom.setRotationPoint(0.0F, 0.0F, -19.0F);
        this.left_eyelid_bottom.addBox(0.0F, 0.0F, 0.0F, 4, 5, 3, 0.0F);
        this.setRotateAngle(left_eyelid_bottom, 0.6632251157578453F, 0.0F, 0.0F);
        this.mouth_top_right = new PCModelRenderer(this, 184, 209);
        this.mouth_top_right.setRotationPoint(-5.0F, -0.1F, 0.0F);
        this.mouth_top_right.addBox(-7.0F, 0.0F, 0.0F, 7, 3, 3, 0.0F);
        this.setRotateAngle(mouth_top_right, 0.0F, 0.6981317007977318F, -0.08726646259971647F);
        this.shape62 = new PCModelRenderer(this, 206, 183);
        this.shape62.setRotationPoint(0.7F, 0.0F, 0.5F);
        this.shape62.addBox(0.0F, -5.0F, 0.0F, 8, 5, 2, 0.0F);
        this.setRotateAngle(shape62, -0.0715584993317675F, 0.0F, 0.41015237421866746F);
        this.arm_right_1_decoration_1 = new PCModelRenderer(this, 172, 164);
        this.arm_right_1_decoration_1.setRotationPoint(0.0F, 10.2F, 4.5F);
        this.arm_right_1_decoration_1.addBox(-2.0F, -10.0F, -2.0F, 4, 10, 2, 0.0F);
        this.setRotateAngle(arm_right_1_decoration_1, -0.317649923862968F, 0.0F, 0.0F);
        this.neck_bottom_front = new PCModelRenderer(this, 205, 216);
        this.neck_bottom_front.setRotationPoint(0.0F, -11.8F, -5.4F);
        this.neck_bottom_front.addBox(-5.0F, -10.0F, 0.0F, 10, 7, 3, 0.0F);
        this.setRotateAngle(neck_bottom_front, 0.4974188368183839F, 0.0F, 0.0F);
        this.left_eyelid_top = new PCModelRenderer(this, 220, 18);
        this.left_eyelid_top.setRotationPoint(-0.01F, -7.0F, -19.0F);
        this.left_eyelid_top.addBox(0.0F, -5.0F, 0.0F, 4, 5, 3, 0.0F);
        this.setRotateAngle(left_eyelid_top, -0.6632251157578453F, 0.0F, 0.0F);
        this.head_right = new PCModelRenderer(this, 205, 106);
        this.head_right.setRotationPoint(-4.3F, -0.8F, 0.0F);
        this.head_right.addBox(-10.1F, -0.2F, 0.0F, 9, 2, 9, 0.0F);
        this.setRotateAngle(head_right, -0.05480333851262195F, 0.0F, -0.8604473212332043F);
        this.head_parts_2 = new PCModelRenderer(this, 167, 90);
        this.head_parts_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head_parts_2.addBox(0.0F, 0.0F, -5.5F, 2, 1, 6, 0.0F);
        this.setRotateAngle(head_parts_2, 0.0F, -0.48520153205442357F, 0.03822271061867581F);
        this.right_eyelid_top = new PCModelRenderer(this, 205, 18);
        this.right_eyelid_top.setRotationPoint(0.01F, -7.0F, -19.0F);
        this.right_eyelid_top.addBox(-4.0F, -5.0F, 0.0F, 4, 5, 3, 0.0F);
        this.setRotateAngle(right_eyelid_top, -0.6632251157578453F, 0.0F, -0.0F);
        this.leg_left_1 = new PCModelRenderer(this, 0, 170);
        this.leg_left_1.setRotationPoint(13.0F, 0.0F, 0.0F);
        this.leg_left_1.addBox(0.0F, -1.8F, -5.0F, 6, 14, 10, 0.0F);
        this.setRotateAngle(leg_left_1, -0.593411945678072F, 0.0F, 0.0F);
        this.tooth_4 = new PCModelRenderer(this, 246, 252);
        this.tooth_4.setRotationPoint(-4.0F, 0.0F, 0.5F);
        this.tooth_4.addBox(-0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(tooth_4, 0.0F, 0.4363323129985824F, -0.13962634015954636F);
        this.right_eyelid_side_top = new PCModelRenderer(this, 184, 20);
        this.right_eyelid_side_top.setRotationPoint(-4.0F, -0.1F, 0.0F);
        this.right_eyelid_side_top.addBox(-9.0F, -5.0F, 0.0F, 9, 5, 1, 0.0F);
        this.setRotateAngle(right_eyelid_side_top, -0.024434609527920613F, 0.41887902047863906F, 0.2792526803190927F);
        this.neck_bottom_left = new PCModelRenderer(this, 232, 217);
        this.neck_bottom_left.setRotationPoint(0.3F, 3.1F, 0.0F);
        this.neck_bottom_left.addBox(0.0F, 0.0F, 0.0F, 7, 6, 3, 0.0F);
        this.setRotateAngle(neck_bottom_left, 0.3839724354387525F, -0.023212879051524582F, -0.28797932657906433F);
        this.movement_base = new PCModelRenderer(this, 0, 0);
        this.movement_base.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.movement_base.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.eye_details_top = new PCModelRenderer(this, 93, 59);
        this.eye_details_top.setRotationPoint(0.0F, -17.4F, -7.4F);
        this.eye_details_top.addBox(-7.0F, 0.0F, -1.0F, 7, 2, 2, 0.0F);
        this.setRotateAngle(eye_details_top, 0.0F, -0.1361356816555577F, -0.17453292519943295F);
        this.spike_2 = new PCModelRenderer(this, 119, 122);
        this.spike_2.setRotationPoint(-2.0F, -1.7F, 3.2F);
        this.spike_2.addBox(0.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(spike_2, -0.4886921905584123F, -0.3490658503988659F, -0.20943951023931953F);
        this.left_eyelid_base = new PCModelRenderer(this, 222, 27);
        this.left_eyelid_base.setRotationPoint(0.0F, -9.5F, 8.0F);
        this.left_eyelid_base.addBox(0.0F, -7.0F, -19.0F, 4, 7, 3, 0.0F);
        this.setRotateAngle(left_eyelid_base, 0.0F, -0.3141592653589793F, 0.0F);
        this.hand_right_finger_left_3 = new PCModelRenderer(this, 141, 249);
        this.hand_right_finger_left_3.setRotationPoint(0.0F, 4.0F, -0.01F);
        this.hand_right_finger_left_3.addBox(-3.0F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
        this.setRotateAngle(hand_right_finger_left_3, 0.0F, 0.0F, 0.2792526803190927F);
        this.mouth_top_lips_right = new PCModelRenderer(this, 184, 191);
        this.mouth_top_lips_right.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.mouth_top_lips_right.addBox(-7.0F, -7.0F, 0.0F, 7, 7, 3, 0.0F);
        this.setRotateAngle(mouth_top_lips_right, -0.3839724354387525F, 0.003490658503988659F, -0.26354471705114374F);
        this.nose_top = new PCModelRenderer(this, 190, 10);
        this.nose_top.setRotationPoint(0.0F, 2.81F, 7.0F);
        this.nose_top.addBox(-1.0F, 0.0F, -2.0F, 2, 7, 2, 0.0F);
        this.setRotateAngle(nose_top, 0.3270747018237373F, 0.0F, 0.0F);
        this.hand_right_main = new PCModelRenderer(this, 155, 209);
        this.hand_right_main.setRotationPoint(0.0F, 18.0F, 0.0F);
        this.hand_right_main.addBox(-1.0F, 0.0F, -5.0F, 4, 6, 10, 0.0F);
        this.setRotateAngle(hand_right_main, 0.0F, 1.5707963267948966F, 0.0F);
        this.spike_3 = new PCModelRenderer(this, 168, 132);
        this.spike_3.setRotationPoint(-6.4F, -3.0F, -3.0F);
        this.spike_3.addBox(-2.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(spike_3, -0.6283185307179586F, -0.3490658503988659F, 0.3490658503988659F);
        this.head_back_cover = new PCModelRenderer(this, 181, 118);
        this.head_back_cover.setRotationPoint(0.0F, 0.0F, 9.0F);
        this.head_back_cover.addBox(-5.0F, 0.0F, 0.0F, 10, 3, 8, 0.0F);
        this.setRotateAngle(head_back_cover, -0.9395107363485474F, 0.0F, 0.0F);
        this.shape95 = new PCModelRenderer(this, 97, 26);
        this.shape95.setRotationPoint(0.01F, 0.0F, -9.0F);
        this.shape95.addBox(0.0F, 0.0F, -6.0F, 5, 5, 6, 0.0F);
        this.setRotateAngle(shape95, 0.9075712110370513F, 0.0F, 0.0F);
        this.nose_bottom = new PCModelRenderer(this, 242, 6);
        this.nose_bottom.setRotationPoint(0.0F, 0.0F, 0.01F);
        this.nose_bottom.addBox(-1.0F, 0.0F, -5.0F, 2, 2, 5, 0.0F);
        this.setRotateAngle(nose_bottom, 1.128355361414334F, 0.0F, 0.0F);
        this.hand_left_finger_left_2 = new PCModelRenderer(this, 105, 241);
        this.hand_left_finger_left_2.setRotationPoint(1.0F, 4.0F, -0.01F);
        this.hand_left_finger_left_2.addBox(-3.0F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
        this.setRotateAngle(hand_left_finger_left_2, 0.0F, 0.0F, 0.4886921905584123F);
        this.hand_right_finger_right_2 = new PCModelRenderer(this, 154, 241);
        this.hand_right_finger_right_2.setRotationPoint(1.0F, 4.0F, 0.01F);
        this.hand_right_finger_right_2.addBox(-3.0F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
        this.setRotateAngle(hand_right_finger_right_2, 0.0F, 0.0F, 0.4886921905584123F);
        this.leg_right_top_decoration = new PCModelRenderer(this, 46, 157);
        this.leg_right_top_decoration.setRotationPoint(-5.0F, -1.8F, 0.0F);
        this.leg_right_top_decoration.addBox(-7.0F, 0.0F, -4.0F, 7, 4, 8, 0.0F);
        this.setRotateAngle(leg_right_top_decoration, 0.0F, 3.141592653589793F, -0.7089527421600966F);
        this.hand_right_2 = new PCModelRenderer(this, 167, 227);
        this.hand_right_2.setRotationPoint(-1.0F, -0.2F, 0.0F);
        this.hand_right_2.addBox(-2.7F, 0.0F, -3.5F, 4, 6, 7, 0.0F);
        this.setRotateAngle(hand_right_2, 0.0F, 0.0F, 0.19268434942017396F);
        this.arm_left_1_decoration_1 = new PCModelRenderer(this, 123, 164);
        this.arm_left_1_decoration_1.setRotationPoint(0.0F, 10.2F, 4.5F);
        this.arm_left_1_decoration_1.addBox(-2.0F, -10.0F, -2.0F, 4, 10, 2, 0.0F);
        this.setRotateAngle(arm_left_1_decoration_1, -0.317649923862968F, 0.0F, 0.0F);
        this.mouth_cheeck_right = new PCModelRenderer(this, 185, 164);
        this.mouth_cheeck_right.setRotationPoint(-12.0F, -16.0F, 0.0F);
        this.mouth_cheeck_right.addBox(0.0F, -12.0F, 0.0F, 4, 12, 6, 0.0F);
        this.setRotateAngle(mouth_cheeck_right, 0.0F, -0.3385938748868999F, 0.08726646259971647F);
        this.leg_right_1 = new PCModelRenderer(this, 46, 170);
        this.leg_right_1.setRotationPoint(-13.0F, 0.0F, 0.0F);
        this.leg_right_1.addBox(-6.0F, -1.8F, -5.0F, 6, 14, 10, 0.0F);
        this.setRotateAngle(leg_right_1, -0.5756095873077298F, 0.0F, 0.0F);
        this.right_eyelid_bottom = new PCModelRenderer(this, 211, 38);
        this.right_eyelid_bottom.setRotationPoint(0.01F, 0.0F, -19.0F);
        this.right_eyelid_bottom.addBox(-4.0F, 0.0F, 0.0F, 4, 5, 3, 0.0F);
        this.setRotateAngle(right_eyelid_bottom, 0.6632251157578453F, 0.0F, 0.0F);
        this.foot_left_back = new PCModelRenderer(this, 25, 252);
        this.foot_left_back.setRotationPoint(0.0F, -8.3F, 2.0F);
        this.foot_left_back.addBox(-2.0F, -2.0F, -1.0F, 4, 2, 2, 0.0F);
        this.yaw_left = new PCModelRenderer(this, 205, 239);
        this.yaw_left.setRotationPoint(-12.2F, -14.7F, -5.9F);
        this.yaw_left.addBox(0.0F, -8.0F, 0.0F, 3, 8, 8, 0.0F);
        this.setRotateAngle(yaw_left, 0.0F, -0.1884955592153876F, 0.23561944901923448F);
        this.hand_left_main = new PCModelRenderer(this, 106, 209);
        this.hand_left_main.setRotationPoint(0.0F, 18.0F, 0.0F);
        this.hand_left_main.addBox(-1.0F, 0.0F, -5.0F, 4, 6, 10, 0.0F);
        this.setRotateAngle(hand_left_main, 0.0F, 1.5707963267948966F, 0.0F);
        this.hand_right_finger_left_1 = new PCModelRenderer(this, 141, 233);
        this.hand_right_finger_left_1.setRotationPoint(3.2F, 5.0F, 2.8F);
        this.hand_right_finger_left_1.addBox(-2.0F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
        this.setRotateAngle(hand_right_finger_left_1, 0.0F, 0.0F, -0.10471975511965977F);
        this.mouth_top_lips_left = new PCModelRenderer(this, 232, 191);
        this.mouth_top_lips_left.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.mouth_top_lips_left.addBox(0.0F, -7.0F, 0.0F, 7, 7, 3, 0.0F);
        this.setRotateAngle(mouth_top_lips_left, -0.3839724354387525F, -0.003490658503988659F, 0.26354471705114374F);
        this.shape92_1 = new PCModelRenderer(this, 68, 11);
        this.shape92_1.setRotationPoint(0.01F, 0.0F, -6.0F);
        this.shape92_1.addBox(0.0F, 0.0F, -9.0F, 5, 5, 9, 0.0F);
        this.setRotateAngle(shape92_1, 0.6632251157578453F, 0.0F, 0.0F);
        this.shape93_1 = new PCModelRenderer(this, 16, 11);
        this.shape93_1.setRotationPoint(0.01F, 0.0F, 6.0F);
        this.shape93_1.addBox(0.0F, 0.0F, 0.0F, 5, 5, 9, 0.0F);
        this.setRotateAngle(shape93_1, -0.6632251157578453F, 0.0F, 0.0F);
        this.shape97 = new PCModelRenderer(this, 120, 20);
        this.shape97.setRotationPoint(0.0F, 0.0F, -6.0F);
        this.shape97.addBox(0.0F, 0.0F, -12.0F, 5, 5, 12, 0.0F);
        this.setRotateAngle(shape97, 0.6632251157578453F, 0.0F, 0.0F);
        this.arm_left_1_decoration = new PCModelRenderer(this, 123, 177);
        this.arm_left_1_decoration.setRotationPoint(0.0F, 10.2F, -4.5F);
        this.arm_left_1_decoration.addBox(-2.0F, -10.0F, 0.0F, 4, 10, 2, 0.0F);
        this.setRotateAngle(arm_left_1_decoration, 0.317649923862968F, 0.0F, 0.0F);
        this.spike_10 = new PCModelRenderer(this, 240, 68);
        this.spike_10.setRotationPoint(-8.0F, 6.0F, 0.0F);
        this.spike_10.addBox(-4.0F, 0.0F, 0.0F, 4, 4, 4, 0.0F);
        this.setRotateAngle(spike_10, 0.0F, -0.10471975511965977F, 0.0F);
        this.shoulder_main_left = new PCModelRenderer(this, 118, 0);
        this.shoulder_main_left.setRotationPoint(12.0F, -14.0F, 2.0F);
        this.shoulder_main_left.addBox(0.0F, -7.0F, -7.0F, 5, 5, 14, 0.0F);
        this.mouth_skin_left = new PCModelRenderer(this, 228, 241);
        this.mouth_skin_left.setRotationPoint(0.0F, 3.0F, 1.5F);
        this.mouth_skin_left.addBox(0.0F, -2.0F, 0.0F, 7, 2, 1, 0.0F);
        this.setRotateAngle(mouth_skin_left, 0.0F, 0.04537856055185257F, 0.4293509959906051F);
        this.nose_left = new PCModelRenderer(this, 218, 0);
        this.nose_left.setRotationPoint(0.4F, 0.2F, 6.0F);
        this.nose_left.addBox(0.0F, 0.0F, -1.0F, 4, 7, 2, 0.0F);
        this.setRotateAngle(nose_left, 0.0F, 0.3839724354387525F, 0.0F);
        this.torso = new PCModelRenderer(this, 62, 70);
        this.torso.setRotationPoint(0.0F, 10.0F, -18.0F);
        this.torso.addBox(-16.0F, -16.0F, -8.0F, 32, 19, 20, 0.0F);
        this.setRotateAngle(torso, 1.2304571226560024F, 0.0F, 0.0F);
        this.shape91 = new PCModelRenderer(this, 143, 0);
        this.shape91.setRotationPoint(0.01F, -7.0F, 7.0F);
        this.shape91.addBox(0.0F, 0.0F, 0.0F, 5, 5, 6, 0.0F);
        this.setRotateAngle(shape91, -0.9075712110370513F, 0.0F, 0.0F);
        this.hand_right_finger_right_3 = new PCModelRenderer(this, 154, 249);
        this.hand_right_finger_right_3.setRotationPoint(0.0F, 4.0F, 0.01F);
        this.hand_right_finger_right_3.addBox(-3.0F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
        this.setRotateAngle(hand_right_finger_right_3, 0.0F, 0.0F, 0.2792526803190927F);
        this.head_parts_4 = new PCModelRenderer(this, 167, 104);
        this.head_parts_4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head_parts_4.addBox(-2.0F, 0.0F, -5.5F, 2, 1, 6, 0.0F);
        this.setRotateAngle(head_parts_4, 0.0F, 0.48520153205442357F, -0.03822271061867581F);
        this.leg_right_4 = new PCModelRenderer(this, 46, 243);
        this.leg_right_4.setRotationPoint(0.0F, 7.0F, 10.5F);
        this.leg_right_4.addBox(-4.5F, -8.3F, 0.0F, 9, 10, 3, 0.0F);
        this.setRotateAngle(leg_right_4, 0.41887902047863906F, 0.0F, 0.0F);
        this.eye_details_bottom_1 = new PCModelRenderer(this, 93, 64);
        this.eye_details_bottom_1.setRotationPoint(0.0F, -8.6F, -7.4F);
        this.eye_details_bottom_1.addBox(-7.0F, -2.0F, -1.0F, 7, 2, 2, 0.0F);
        this.setRotateAngle(eye_details_bottom_1, 0.0F, -0.1361356816555577F, 0.17453292519943295F);
        this.arm_left_rotation_point = new PCModelRenderer(this, 0, 0);
        this.arm_left_rotation_point.setRotationPoint(2.0F, 0.0F, 0.0F);
        this.arm_left_rotation_point.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.setRotateAngle(arm_left_rotation_point, -0.7155849933176751F, 0.0F, 0.0F);
        this.shoulder_main_right = new PCModelRenderer(this, 38, 0);
        this.shoulder_main_right.setRotationPoint(-17.0F, -14.0F, 2.0F);
        this.shoulder_main_right.addBox(0.0F, -7.0F, -7.0F, 5, 5, 14, 0.0F);
        this.arm_left_connection = new PCModelRenderer(this, 92, 110);
        this.arm_left_connection.setRotationPoint(16.0F, -12.3F, 2.0F);
        this.arm_left_connection.addBox(0.0F, -3.5F, -3.5F, 3, 7, 7, 0.0F);
        this.arm_left_main = new PCModelRenderer(this, 92, 125);
        this.arm_left_main.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.arm_left_main.addBox(0.0F, -6.0F, -6.0F, 7, 12, 12, 0.0F);
        this.setRotateAngle(arm_left_main, -1.0016444577195458F, 0.0F, 0.0F);
        this.arm_left_1 = new PCModelRenderer(this, 92, 150);
        this.arm_left_1.setRotationPoint(3.5F, 0.0F, 0.0F);
        this.arm_left_1.addBox(-3.0F, 0.0F, -4.5F, 6, 18, 9, 0.0F);
        this.setRotateAngle(arm_left_1, 0.7853981633974483F, 0.0F, 0.0F);
        this.eye_details_top_1 = new PCModelRenderer(this, 133, 59);
        this.eye_details_top_1.setRotationPoint(0.0F, -17.4F, -7.4F);
        this.eye_details_top_1.addBox(0.0F, 0.0F, -1.0F, 7, 2, 2, 0.0F);
        this.setRotateAngle(eye_details_top_1, 0.0F, 0.1361356816555577F, 0.17453292519943295F);
        this.tooth_7 = new PCModelRenderer(this, 236, 249);
        this.tooth_7.setRotationPoint(3.0F, 3.0F, 1.5F);
        this.tooth_7.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
        this.mouth_skin_right = new PCModelRenderer(this, 228, 245);
        this.mouth_skin_right.setRotationPoint(0.0F, 3.0F, 1.5F);
        this.mouth_skin_right.addBox(-7.0F, -2.0F, 0.0F, 7, 2, 1, 0.0F);
        this.setRotateAngle(mouth_skin_right, 0.0F, -0.04537856055185257F, -0.4642575810304917F);
        this.hand_left_finger_left_1 = new PCModelRenderer(this, 105, 233);
        this.hand_left_finger_left_1.setRotationPoint(3.2F, 5.0F, 2.8F);
        this.hand_left_finger_left_1.addBox(-2.0F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
        this.setRotateAngle(hand_left_finger_left_1, 0.0F, 0.0F, -0.10471975511965977F);
        this.mouth_top_left_back = new PCModelRenderer(this, 211, 202);
        this.mouth_top_left_back.setRotationPoint(7.0F, 0.0F, 0.0F);
        this.mouth_top_left_back.addBox(0.0F, 0.0F, 0.0F, 10, 3, 3, 0.0F);
        this.setRotateAngle(mouth_top_left_back, 0.0F, -0.6370451769779303F, 0.0F);
        this.hand_right_finger_left_2 = new PCModelRenderer(this, 141, 241);
        this.hand_right_finger_left_2.setRotationPoint(1.0F, 4.0F, -0.01F);
        this.hand_right_finger_left_2.addBox(-3.0F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
        this.setRotateAngle(hand_right_finger_left_2, 0.0F, 0.0F, 0.4886921905584123F);
        this.tooth = new PCModelRenderer(this, 241, 253);
        this.tooth.setRotationPoint(0.0F, -2.9F, 0.9F);
        this.tooth.addBox(-0.5F, -1.0F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotateAngle(tooth, -0.2617993877991494F, 0.0F, 0.0F);
        this.leg_left_calf_muscle = new PCModelRenderer(this, 23, 213);
        this.leg_left_calf_muscle.setRotationPoint(0.0F, -4.0F, 6.0F);
        this.leg_left_calf_muscle.addBox(-1.5F, 0.0F, -7.0F, 3, 2, 7, 0.0F);
        this.setRotateAngle(leg_left_calf_muscle, -0.4052654523130833F, 0.0F, 0.0F);
        this.mouth_top_lip = new PCModelRenderer(this, 205, 191);
        this.mouth_top_lip.setRotationPoint(0.0F, -8.8F, -17.3F);
        this.mouth_top_lip.addBox(-5.0F, -7.0F, 0.0F, 10, 7, 3, 0.0F);
        this.setRotateAngle(mouth_top_lip, -0.7285004297824331F, 0.0F, 0.0F);
        this.head_back = new PCModelRenderer(this, 211, 127);
        this.head_back.setRotationPoint(0.01F, -14.0F, -2.6F);
        this.head_back.addBox(-5.0F, 0.0F, 0.0F, 10, 3, 9, 0.0F);
        this.setRotateAngle(head_back, -0.665144977935039F, 0.0F, 0.0F);
        this.shape72 = new PCModelRenderer(this, 185, 183);
        this.shape72.setRotationPoint(-0.7F, 0.0F, 0.5F);
        this.shape72.addBox(-8.0F, -5.0F, 0.0F, 8, 5, 2, 0.0F);
        this.setRotateAngle(shape72, -0.0715584993317675F, 0.0F, -0.41015237421866746F);
        this.hand_left_finger_left_3 = new PCModelRenderer(this, 105, 249);
        this.hand_left_finger_left_3.setRotationPoint(0.0F, 4.0F, -0.01F);
        this.hand_left_finger_left_3.addBox(-3.0F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
        this.setRotateAngle(hand_left_finger_left_3, 0.0F, 0.0F, 0.2792526803190927F);
        this.nose_tip = new PCModelRenderer(this, 218, 10);
        this.nose_tip.setRotationPoint(0.01F, 0.0F, 7.0F);
        this.nose_tip.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(nose_tip, -0.2848377339254746F, 0.0F, 0.0F);
        this.left_eyelid_side_top = new PCModelRenderer(this, 235, 20);
        this.left_eyelid_side_top.setRotationPoint(4.0F, -0.1F, 0.0F);
        this.left_eyelid_side_top.addBox(0.0F, -5.0F, 0.0F, 9, 5, 1, 0.0F);
        this.setRotateAngle(left_eyelid_side_top, -0.024434609527920613F, -0.41887902047863906F, -0.2792526803190927F);
        this.head_parts = new PCModelRenderer(this, 182, 97);
        this.head_parts.setRotationPoint(4.9F, -14.3F, -7.0F);
        this.head_parts.addBox(0.0F, 0.0F, 0.0F, 7, 2, 4, 0.0F);
        this.setRotateAngle(head_parts, 0.008726646259971648F, 0.43458698374658805F, 0.7609635538695276F);
        this.shape90_1 = new PCModelRenderer(this, 63, 0);
        this.shape90_1.setRotationPoint(0.01F, -7.0F, -7.0F);
        this.shape90_1.addBox(0.0F, 0.0F, -6.0F, 5, 5, 6, 0.0F);
        this.setRotateAngle(shape90_1, 0.9075712110370513F, 0.0F, 0.0F);
        this.right_eyelid_side_bottom = new PCModelRenderer(this, 196, 38);
        this.right_eyelid_side_bottom.setRotationPoint(-4.0F, 0.1F, 0.0F);
        this.right_eyelid_side_bottom.addBox(-6.0F, 0.0F, 0.0F, 6, 5, 1, 0.0F);
        this.setRotateAngle(right_eyelid_side_bottom, 0.024434609527920613F, 0.41887902047863906F, -0.2792526803190927F);
        this.leg_right_3 = new PCModelRenderer(this, 46, 223);
        this.leg_right_3.setRotationPoint(0.0F, -4.0F, 11.0F);
        this.leg_right_3.addBox(-3.0F, 0.0F, -0.5F, 6, 7, 11, 0.0F);
        this.setRotateAngle(leg_right_3, -1.1215485773315563F, 0.0F, 0.0F);
        this.mouth_bottom_left = new PCModelRenderer(this, 231, 227);
        this.mouth_bottom_left.setRotationPoint(5.0F, -2.8F, 0.0F);
        this.mouth_bottom_left.addBox(0.0F, 0.0F, 0.0F, 7, 3, 3, 0.0F);
        this.setRotateAngle(mouth_bottom_left, 0.0F, -0.6981317007977318F, 0.08726646259971647F);
        this.bottom_body = new PCModelRenderer(this, 0, 125);
        this.bottom_body.setRotationPoint(0.0F, -25.0F, 19.0F);
        this.bottom_body.addBox(-13.0F, -7.5F, -8.0F, 26, 15, 16, 0.0F);
        this.stomach = new PCModelRenderer(this, 0, 90);
        this.stomach.setRotationPoint(0.0F, -5.5F, 0.0F);
        this.stomach.addBox(-10.0F, 0.0F, -21.0F, 20, 13, 21, 0.0F);
        this.setRotateAngle(stomach, -0.5009094953223726F, 0.0F, 0.0F);
        this.hand_right_thumb_2 = new PCModelRenderer(this, 167, 249);
        this.hand_right_thumb_2.setRotationPoint(1.0F, 4.0F, 0.01F);
        this.hand_right_thumb_2.addBox(-3.0F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
        this.setRotateAngle(hand_right_thumb_2, 0.0F, 0.0F, 0.7686430025783028F);
        this.spike_5 = new PCModelRenderer(this, 168, 122);
        this.spike_5.setRotationPoint(1.2F, -1.7F, 3.2F);
        this.spike_5.addBox(-2.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(spike_5, 0.4886921905584123F, 0.7890633548266364F, -0.20943951023931953F);
        this.foot_left_back_slope = new PCModelRenderer(this, 25, 242);
        this.foot_left_back_slope.setRotationPoint(0.0F, -1.5F, 0.0F);
        this.foot_left_back_slope.addBox(-1.5F, 0.0F, -7.0F, 3, 2, 7, 0.0F);
        this.setRotateAngle(foot_left_back_slope, 0.25569073541716925F, 0.0F, 0.0F);
        this.mouth_bottom_right.addChild(this.neck_bottom_right);
        this.mouth_top_lip.addChild(this.mouth_top_front);
        this.shape93_1.addChild(this.shape96_1);
        this.shoulder_bone_left.addChild(this.spike_6);
        this.torso.addChild(this.meat_left);
        this.mouth_top_right.addChild(this.mouth_top_right_back);
        this.hand_left_thumb_1.addChild(this.hand_left_thumb_2);
        this.leg_right_3.addChild(this.foot_right_front_slope);
        this.shape93.addChild(this.shape96);
        this.hand_left_main.addChild(this.hand_left_back);
        this.shoulder_bone_left_1.addChild(this.spike_11);
        this.leg_left_3.addChild(this.leg_left_4);
        this.nose_left_2.addChild(this.nose_left_3);
        this.tooth.addChild(this.tooth_3);
        this.mouth_top_front.addChild(this.tooth_5);
        this.mouth_top_right.addChild(this.tooth_8);
        this.stomach.addChild(this.body_abs);
        this.torso.addChild(this.back);
        this.shoulder_bone_left.addChild(this.spike_8);
        this.right_eyelid_base.addChild(this.right_eyelid_side);
        this.arm_left_1.addChild(this.arm_left_2);
        this.mouth_bottom_left.addChild(this.tooth_1);
        this.left_eyelid_bottom.addChild(this.left_eyelid_side_bottom);
        this.arm_left_main.addChild(this.spike);
        this.arm_right_connection.addChild(this.arm_right_rotation_point);
        this.torso.addChild(this.eye_details_bottom);
        this.head_top.addChild(this.nose_main);
        this.leg_left_2.addChild(this.leg_left_3);
        this.torso.addChild(this.mouth_cheeck_left);
        this.shoulder_main_right.addChild(this.shape91_1);
        this.hand_right_main.addChild(this.hand_right_finger_right_1);
        this.shoulder_bone_left_1.addChild(this.spike_9);
        this.shape92_1.addChild(this.shape95_1);
        this.neck_bottom_front.addChild(this.mouth_bottom_front);
        this.leg_right_2.addChild(this.leg_right_calf_muscle);
        this.hand_right_2.addChild(this.hand_right_thumb_1);
        this.torso.addChild(this.arm_right_connection);
        this.shape91.addChild(this.shape93);
        this.head_back.addChild(this.head_left);
        this.foot_right_back.addChild(this.foot_right_back_slope);
        this.arm_right_main.addChild(this.arm_right_1);
        this.shape95_1.addChild(this.shape97_1);
        this.hand_left_finger_right_1.addChild(this.hand_left_finger_right_2);
        this.arm_right_rotation_point.addChild(this.arm_right_main);
        this.left_eyelid_base.addChild(this.left_eyelid_side);
        this.nose_right_2.addChild(this.nose_right_3);
        this.hand_left_main.addChild(this.hand_left_2);
        this.spike_3.addChild(this.spike_4);
        this.nose_left.addChild(this.nose_left_2);
        this.shape90.addChild(this.shape92);
        this.torso.addChild(this.shoulder_bone_left_1);
        this.mouth_top_front.addChild(this.tooth_6);
        this.shoulder_main_left.addChild(this.shape90);
        this.nose_right.addChild(this.nose_right_2);
        this.shoulder_bone_left.addChild(this.spike_7);
        this.hand_left_2.addChild(this.hand_left_thumb_1);
        this.leg_left_3.addChild(this.foot_left_front_slope);
        this.torso.addChild(this.yaw_right);
        this.leg_right_4.addChild(this.foot_right_back);
        this.hand_left_finger_right_2.addChild(this.hand_left_finger_right_3);
        this.torso.addChild(this.head_top);
        this.head_parts_4.addChild(this.head_parts_5);
        this.hand_left_main.addChild(this.hand_left_finger_right_1);
        this.torso.addChild(this.eye);
        this.mouth_bottom_front.addChild(this.mouth_bottom_right);
        this.hand_right_main.addChild(this.hand_right_back);
        this.arm_right_1.addChild(this.arm_right_2);
        this.leg_left_1.addChild(this.leg_left_top_decoration);
        this.leg_right_1.addChild(this.leg_right_2);
        this.spike.addChild(this.spike_1);
        this.mouth_bottom_right.addChild(this.tooth_2);
        this.mouth_top_front.addChild(this.mouth_top_left);
        this.torso.addChild(this.right_eyelid_base);
        this.nose_main.addChild(this.nose_front);
        this.head_top.addChild(this.head_parts_1);
        this.body_abs.addChild(this.body_abs_bottom);
        this.torso.addChild(this.meat_right);
        this.leg_left_1.addChild(this.leg_left_2);
        this.torso.addChild(this.shoulder_bone_left);
        this.head_parts_2.addChild(this.head_parts_3);
        this.nose_main.addChild(this.nose_right);
        this.arm_right_1.addChild(this.arm_right_1_decoration);
        this.left_eyelid_base.addChild(this.left_eyelid_bottom);
        this.mouth_top_front.addChild(this.mouth_top_right);
        this.mouth_top_left_back.addChild(this.shape62);
        this.arm_right_1.addChild(this.arm_right_1_decoration_1);
        this.torso.addChild(this.neck_bottom_front);
        this.left_eyelid_base.addChild(this.left_eyelid_top);
        this.head_back.addChild(this.head_right);
        this.head_parts.addChild(this.head_parts_2);
        this.right_eyelid_base.addChild(this.right_eyelid_top);
        this.bottom_body.addChild(this.leg_left_1);
        this.tooth.addChild(this.tooth_4);
        this.right_eyelid_top.addChild(this.right_eyelid_side_top);
        this.mouth_bottom_left.addChild(this.neck_bottom_left);
        this.torso.addChild(this.eye_details_top);
        this.spike.addChild(this.spike_2);
        this.torso.addChild(this.left_eyelid_base);
        this.hand_right_finger_left_2.addChild(this.hand_right_finger_left_3);
        this.mouth_top_right.addChild(this.mouth_top_lips_right);
        this.nose_main.addChild(this.nose_top);
        this.arm_right_2.addChild(this.hand_right_main);
        this.arm_right_main.addChild(this.spike_3);
        this.head_back.addChild(this.head_back_cover);
        this.shape92.addChild(this.shape95);
        this.nose_main.addChild(this.nose_bottom);
        this.hand_left_finger_left_1.addChild(this.hand_left_finger_left_2);
        this.hand_right_finger_right_1.addChild(this.hand_right_finger_right_2);
        this.leg_right_1.addChild(this.leg_right_top_decoration);
        this.hand_right_main.addChild(this.hand_right_2);
        this.arm_left_1.addChild(this.arm_left_1_decoration_1);
        this.torso.addChild(this.mouth_cheeck_right);
        this.bottom_body.addChild(this.leg_right_1);
        this.right_eyelid_base.addChild(this.right_eyelid_bottom);
        this.leg_left_4.addChild(this.foot_left_back);
        this.torso.addChild(this.yaw_left);
        this.arm_left_2.addChild(this.hand_left_main);
        this.hand_right_main.addChild(this.hand_right_finger_left_1);
        this.mouth_top_left.addChild(this.mouth_top_lips_left);
        this.shape90_1.addChild(this.shape92_1);
        this.shape91_1.addChild(this.shape93_1);
        this.shape95.addChild(this.shape97);
        this.arm_left_1.addChild(this.arm_left_1_decoration);
        this.shoulder_bone_left_1.addChild(this.spike_10);
        this.torso.addChild(this.shoulder_main_left);
        this.mouth_top_left_back.addChild(this.mouth_skin_left);
        this.nose_main.addChild(this.nose_left);
        this.stomach.addChild(this.torso);
        this.shoulder_main_left.addChild(this.shape91);
        this.hand_right_finger_right_2.addChild(this.hand_right_finger_right_3);
        this.head_parts_1.addChild(this.head_parts_4);
        this.leg_right_3.addChild(this.leg_right_4);
        this.torso.addChild(this.eye_details_bottom_1);
        this.arm_left_connection.addChild(this.arm_left_rotation_point);
        this.torso.addChild(this.shoulder_main_right);
        this.torso.addChild(this.arm_left_connection);
        this.arm_left_rotation_point.addChild(this.arm_left_main);
        this.arm_left_main.addChild(this.arm_left_1);
        this.torso.addChild(this.eye_details_top_1);
        this.mouth_top_left.addChild(this.tooth_7);
        this.mouth_top_right_back.addChild(this.mouth_skin_right);
        this.hand_left_main.addChild(this.hand_left_finger_left_1);
        this.mouth_top_left.addChild(this.mouth_top_left_back);
        this.hand_right_finger_left_1.addChild(this.hand_right_finger_left_2);
        this.mouth_bottom_front.addChild(this.tooth);
        this.leg_left_2.addChild(this.leg_left_calf_muscle);
        this.head_top.addChild(this.mouth_top_lip);
        this.head_top.addChild(this.head_back);
        this.mouth_top_right_back.addChild(this.shape72);
        this.hand_left_finger_left_2.addChild(this.hand_left_finger_left_3);
        this.nose_front.addChild(this.nose_tip);
        this.left_eyelid_top.addChild(this.left_eyelid_side_top);
        this.head_top.addChild(this.head_parts);
        this.shoulder_main_right.addChild(this.shape90_1);
        this.right_eyelid_bottom.addChild(this.right_eyelid_side_bottom);
        this.leg_right_2.addChild(this.leg_right_3);
        this.mouth_bottom_front.addChild(this.mouth_bottom_left);
        this.movement_base.addChild(this.bottom_body);
        this.bottom_body.addChild(this.stomach);
        this.hand_right_thumb_1.addChild(this.hand_right_thumb_2);
        this.spike_3.addChild(this.spike_5);
        this.foot_left_back.addChild(this.foot_left_back_slope);
        
        //Rotation Fixes For Default Position
        //Mouth
        this.head_top.rotateAngleX = (float) Math.toRadians(8.0F);
    	//Eye Lids
    	this.left_eyelid_base.rotateAngleY = (float) Math.toRadians(0.0F);
    	this.right_eyelid_base.rotateAngleY = (float) Math.toRadians(0.0F);
    	
//    	bodyParts = new PCModelRenderer[] {movement_base,bottom_body,stomach,leg_left_1,leg_right_1,torso,body_abs,right_eyelid_base,left_eyelid_base,eye,eye_details_top,eye_details_top_1,eye_details_bottom,
//		eye_details_bottom_1,neck_bottom_front,yaw_right,yaw_left,mouth_cheeck_left,back,head_top,mouth_cheeck_right,meat_left,meat_right,shoulder_main_left,shoulder_main_right,
//		arm_left_connection,arm_right_connection,shoulder_bone_left,shoulder_bone_left_1,right_eyelid_side,right_eyelid_top,right_eyelid_bottom,right_eyelid_side_top,right_eyelid_side_bottom,
//		left_eyelid_side,left_eyelid_top,left_eyelid_bottom,left_eyelid_side_top,left_eyelid_side_bottom,mouth_bottom_front,mouth_bottom_left,mouth_bottom_right,tooth,tooth_1,
//		neck_bottom_left,tooth_2,neck_bottom_right,tooth_3,tooth_4,mouth_top_lip,head_back,head_parts,head_parts_1,nose_main,mouth_top_front,mouth_top_left,mouth_top_right,tooth_5,
//		tooth_6,mouth_top_lips_left,mouth_top_left_back,tooth_7,mouth_skin_left,shape62,mouth_top_lips_right,mouth_top_right_back,tooth_8,mouth_skin_right,shape72,head_left,head_right,
//		head_back_cover,head_parts_2,head_parts_3,head_parts_4,head_parts_5,nose_bottom,nose_left,nose_right,nose_top,nose_front,nose_left_2,nose_left_3,nose_right_2,nose_right_3,
//		nose_tip,shape90,shape91,shape92,shape95,shape97,shape93,shape96,shape90_1,shape91_1,shape92_1,shape95_1,shape97_1,shape93_1,shape96_1,arm_left_rotation_point,arm_left_main,
//		arm_left_1,spike,arm_left_2,arm_left_1_decoration,arm_left_1_decoration_1,hand_left_main,hand_left_back,hand_left_finger_right_1,hand_left_finger_left_1,hand_left_2,hand_left_finger_right_2,
//		hand_left_finger_right_3,hand_left_finger_left_2,hand_left_finger_left_3,hand_left_thumb_1,hand_left_thumb_2,spike_1,spike_2,arm_right_rotation_point,arm_right_main,arm_right_1,
//		spike_3,arm_right_2,arm_right_1_decoration,arm_right_1_decoration_1,hand_right_main,hand_right_back,hand_right_finger_right_1,hand_right_finger_left_1,hand_right_2,hand_right_finger_right_2,
//		hand_right_finger_right_3,hand_right_finger_left_2,hand_right_finger_left_3,hand_right_thumb_1,hand_right_thumb_2,spike_4,spike_5,spike_6,spike_7,spike_8,spike_9,spike_10,
//		spike_11,body_abs_bottom,leg_left_2,leg_left_top_decoration,leg_left_3,leg_left_calf_muscle,leg_left_4,foot_left_front_slope,foot_left_back,foot_left_back_slope,leg_right_2,
//		leg_right_top_decoration,leg_right_3,leg_right_calf_muscle,leg_right_4,foot_right_front_slope,foot_right_back,foot_right_back_slope};
    	        		
    	saveAllDefaultValues();
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha)
    {
    	this.animateModel(this.entity);
    	
    	matrixStackIn.push();
    	
    	if(this.entity.isEntityStanding())
    	{
    		matrixStackIn.translate(0.0F, 0.0F, -1.26F);
    		this.leg_right_1.showModel = true;
    		this.leg_left_1.showModel = true;
    	}
    	else
    	{
    		this.leg_right_1.showModel = true;
    		this.leg_left_1.showModel = true;
    		matrixStackIn.push();
    		matrixStackIn.translate(0.0F, -0.15F, 1.26F);
    		this.leg_right_1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    		this.leg_left_1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    		this.leg_right_1.showModel = false;
    		this.leg_left_1.showModel = false;
    		matrixStackIn.pop();
    	}
        this.movement_base.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
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
    	loadAllDefaultValues();
    	
    	if(entity.isAnimationPlaying(EndTrollEntity.BLANK_ANIMATION) || entity.isAnimationPlaying(EndTrollEntity.SHOOT_ANIMATION) || entity.isAnimationPlaying(EndTrollEntity.RIGHT_PUNCH_ANIMATION) || entity.isAnimationPlaying(EndTrollEntity.LEFT_PUNCH_ANIMATION) || entity.isAnimationPlaying(EndTrollEntity.DOUBLE_PUNCH_ANIMATION))
    	{
    		if(!entity.isEntityStanding())
    		{
				if(entity.prevPosX != entity.getPosX() || entity.prevPosZ != entity.getPosZ())
				{
		    		float globalSpeed = 4.0F;
		        	float globalHeight = 1.0F;
		        	float globalDegree = 1.6F;
		        	
		        	bounce(bottom_body, globalSpeed * 0.4F, globalHeight * 0.8F, false, limbSwing, limbSwingAmount);
		        	//Left Leg
		        	swing(leg_left_1, globalSpeed * 0.2F, globalDegree * 0.22F, false, 2.2F, 0.0F, limbSwing, limbSwingAmount);
		        	swing(leg_left_2, globalSpeed * 0.2F, globalDegree * 0.25F, false, 2.7F, 0.0F, limbSwing, limbSwingAmount);
		        	swing(leg_left_3, globalSpeed * 0.2F, globalDegree * 0.2F, true, 1.3F, 0.1F, limbSwing, limbSwingAmount);
		        	swing(leg_left_4, globalSpeed * 0.2F, globalDegree * 0.28F, true, 3.3F, -0.03F, limbSwing, limbSwingAmount);
		        	swing(foot_left_front_slope, globalSpeed * 0.2F, globalDegree * 0.2F, false, 1.0F, -0.12F, limbSwing, limbSwingAmount);
		        	//Right Leg
		        	swing(leg_right_1, globalSpeed * 0.2F, globalDegree * 0.22F, true, 2.2F, 0.0F, limbSwing, limbSwingAmount);
		        	swing(leg_right_2, globalSpeed * 0.2F, globalDegree * 0.25F, true, 2.7F, 0.0F, limbSwing, limbSwingAmount);
		        	swing(leg_right_3, globalSpeed * 0.2F, globalDegree * 0.2F, false, 1.3F, 0.1F, limbSwing, limbSwingAmount);
		        	swing(leg_right_4, globalSpeed * 0.2F, globalDegree * 0.28F, false, 3.3F, -0.03F, limbSwing, limbSwingAmount);
		        	swing(foot_right_front_slope, globalSpeed * 0.2F, globalDegree * 0.2F, true, 1.0F, -0.12F, limbSwing, limbSwingAmount);
		        	//Torso
		        	shake(torso, globalSpeed * 0.2F, globalDegree * 0.04F, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
		        	swing(torso, globalSpeed * 0.4F, globalDegree * 0.02F, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
		        	swing(stomach, globalSpeed * 0.4F, globalDegree * 0.02F, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
		        	
		        	//Left Arm
		        	swing(arm_left_main, globalSpeed * 0.2F, globalDegree * 0.35F, false, -0.4F, 0.1F, limbSwing, limbSwingAmount);
		        	swing(arm_left_2, globalSpeed * 0.2F, globalDegree * 0.35F, false, 2.0F, -0.08F, limbSwing, limbSwingAmount);
		        	//Left Thumb
		        	flap(hand_left_thumb_1, globalSpeed * 0.2F, globalDegree * 0.4F, true, 1.0F, -0.2F, limbSwing, limbSwingAmount);
		        	flap(hand_left_thumb_2, globalSpeed * 0.2F, globalDegree * 0.4F, false, 1.0F, 0.1F, limbSwing, limbSwingAmount);
		        	//Left Fingers
		        	flap(hand_left_finger_left_1, globalSpeed * 0.2F, globalDegree * 0.2F, false, 1.7F, 0.0F, limbSwing, limbSwingAmount);
		        	flap(hand_left_finger_left_2, globalSpeed * 0.2F, globalDegree * 0.35F, false, 1.0F, 0.2F, limbSwing, limbSwingAmount);
		        	flap(hand_left_finger_left_3, globalSpeed * 0.2F, globalDegree * 0.3F, false, 1.0F, 0.2F, limbSwing, limbSwingAmount);
		        	
		        	flap(hand_left_finger_right_1, globalSpeed * 0.2F, globalDegree * 0.2F, false, 1.2F, 0.0F, limbSwing, limbSwingAmount);
		        	flap(hand_left_finger_right_2, globalSpeed * 0.2F, globalDegree * 0.35F, false, 0.5F, 0.2F, limbSwing, limbSwingAmount);
		        	flap(hand_left_finger_right_3, globalSpeed * 0.2F, globalDegree * 0.3F, false, 0.5F, 0.2F, limbSwing, limbSwingAmount);
		        	
		        	//Right Arm
		        	swing(arm_right_main, globalSpeed * 0.2F, globalDegree * 0.35F, true, -0.4F, 0.1F, limbSwing, limbSwingAmount);
		        	swing(arm_right_2, globalSpeed * 0.2F, globalDegree * 0.35F, true, 2.0F, -0.08F, limbSwing, limbSwingAmount);
		        	//Right Thumb
		        	flap(hand_right_thumb_1, globalSpeed * 0.2F, globalDegree * 0.4F, false, 1.0F, -0.2F, limbSwing, limbSwingAmount);
		        	flap(hand_right_thumb_2, globalSpeed * 0.2F, globalDegree * 0.4F, true, 1.0F, 0.1F, limbSwing, limbSwingAmount);
		        	//Right Fingers
		        	flap(hand_right_finger_left_1, globalSpeed * 0.2F, globalDegree * 0.2F, true, 1.5F, 0.0F, limbSwing, limbSwingAmount);
		        	flap(hand_right_finger_left_2, globalSpeed * 0.2F, globalDegree * 0.35F, true, 0.5F, 0.2F, limbSwing, limbSwingAmount);
		        	flap(hand_right_finger_left_3, globalSpeed * 0.2F, globalDegree * 0.3F, true, 0.5F, 0.2F, limbSwing, limbSwingAmount);
		        	
		        	flap(hand_right_finger_right_1, globalSpeed * 0.2F, globalDegree * 0.2F, true, 1.7F, 0.0F, limbSwing, limbSwingAmount);
		        	flap(hand_right_finger_right_2, globalSpeed * 0.2F, globalDegree * 0.35F, true, 1.0F, 0.2F, limbSwing, limbSwingAmount);
		        	flap(hand_right_finger_right_3, globalSpeed * 0.2F, globalDegree * 0.3F, true, 1.0F, 0.2F, limbSwing, limbSwingAmount);
		        	
		        	//Head
		        	swing(head_top, globalSpeed * 0.4F, globalDegree * 0.05F, false, 0.0F, -0.08F, limbSwing, limbSwingAmount);
				}
				else
				{
					limbSwing = entity.ticksExisted;
		    		limbSwingAmount = 1;
		    		
		    		float globalSpeed = 1.0F;
		        	float globalHeight = 1.0F;
		        	float globalDegree = 0.8F;
		        	
		        	bounce(bottom_body, globalSpeed * 0.3F, globalHeight * 0.56F, false, limbSwing, limbSwingAmount);
		        	swing(torso, globalSpeed * 0.3F, globalDegree * 0.006F, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
		        	swing(stomach, globalSpeed * 0.3F, globalDegree * 0.006F, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
		        	
		        	bounce(leg_left_1, globalSpeed * 0.3F, globalHeight * -0.56F, false, limbSwing, limbSwingAmount);
		        	flap(leg_left_top_decoration, globalSpeed * 0.3F, globalDegree * 0.14F, false, 1.4F, -0.1F, limbSwing, limbSwingAmount);
		        	
		        	bounce(leg_right_1, globalSpeed * 0.3F, globalHeight * -0.56F, false, limbSwing, limbSwingAmount);
		        	flap(leg_right_top_decoration, globalSpeed * 0.3F, globalDegree * 0.14F, true, 1.4F, 0.1F, limbSwing, limbSwingAmount);
		        	
		        	swing(leg_left_1, globalSpeed * 0.3F, globalDegree * 0.05F, false, 1.2F, 0.0F, limbSwing, limbSwingAmount);
		        	swing(leg_left_2, globalSpeed * 0.3F, globalDegree * 0.05F, true, 1.2F, -0.1F, limbSwing, limbSwingAmount);
		        	swing(leg_left_3, globalSpeed * 0.3F, globalDegree * 0.03F, true, 1.2F, 0.105F, limbSwing, limbSwingAmount);
		        	swing(leg_left_4, globalSpeed * 0.3F, globalDegree * 0.03F, false, 1.2F, 0.0F, limbSwing, limbSwingAmount);
		        	swing(leg_left_calf_muscle, globalSpeed * 0.3F, globalDegree * 0.08F, false, 1.2F, 0.05F, limbSwing, limbSwingAmount);
		        	swing(foot_left_front_slope, globalSpeed * 0.3F, globalDegree * 0.04F, true, 1.2F, -0.03F, limbSwing, limbSwingAmount);
		        	
		        	swing(leg_right_1, globalSpeed * 0.3F, globalDegree * 0.05F, false, 1.2F, 0.0F, limbSwing, limbSwingAmount);
		        	swing(leg_right_2, globalSpeed * 0.3F, globalDegree * 0.05F, true, 1.2F, -0.1F, limbSwing, limbSwingAmount);
		        	swing(leg_right_3, globalSpeed * 0.3F, globalDegree * 0.03F, true, 1.2F, 0.105F, limbSwing, limbSwingAmount);
		        	swing(leg_right_4, globalSpeed * 0.3F, globalDegree * 0.03F, false, 1.2F, 0.0F, limbSwing, limbSwingAmount);
		        	swing(leg_right_calf_muscle, globalSpeed * 0.3F, globalDegree * 0.08F, false, 1.2F, 0.05F, limbSwing, limbSwingAmount);
		        	swing(foot_right_front_slope, globalSpeed * 0.3F, globalDegree * 0.04F, true, 1.2F, -0.03F, limbSwing, limbSwingAmount);
		    		
		    		swing(arm_left_main, globalSpeed * 0.3F, globalDegree * 0.02F, true, 1.2F, 0.02F, limbSwing, limbSwingAmount);
		    		swing(arm_left_2, globalSpeed * 0.3F, globalDegree * 0.05F, false, 1.2F, 0.02F, limbSwing, limbSwingAmount);
		    		
		    		swing(arm_right_main, globalSpeed * 0.3F, globalDegree * 0.02F, true, 1.2F, 0.02F, limbSwing, limbSwingAmount);
		    		swing(arm_right_2, globalSpeed * 0.3F, globalDegree * 0.05F, false, 1.2F, 0.02F, limbSwing, limbSwingAmount);
		    		
		    		flap(hand_left_finger_left_1, globalSpeed * 0.3F, globalDegree * 0.05F, false, 1.2F, -0.25F, limbSwing, limbSwingAmount);
		        	flap(hand_left_finger_left_2, globalSpeed * 0.3F, globalDegree * 0.04F, true, 1.2F, 0.1F, limbSwing, limbSwingAmount);
		        	flap(hand_left_finger_left_3, globalSpeed * 0.3F, globalDegree * 0.04F, true, 1.2F, 0.1F, limbSwing, limbSwingAmount);
		    		
		        	flap(hand_left_finger_right_1, globalSpeed * 0.3F, globalDegree * 0.05F, false, 1.2F, -0.25F, limbSwing, limbSwingAmount);
		        	flap(hand_left_finger_right_2, globalSpeed * 0.3F, globalDegree * 0.04F, true, 1.2F, 0.1F, limbSwing, limbSwingAmount);
		        	flap(hand_left_finger_right_3, globalSpeed * 0.3F, globalDegree * 0.04F, true, 1.2F, 0.1F, limbSwing, limbSwingAmount);
		    		
		        	flap(hand_left_thumb_1, globalSpeed * 0.3F, globalDegree * 0.1F, true, 1.2F, 0.0F, limbSwing, limbSwingAmount);
		        	flap(hand_left_thumb_2, globalSpeed * 0.3F, globalDegree * 0.1F, true, 1.2F, 0.0F, limbSwing, limbSwingAmount);
		    		
		        	flap(hand_right_finger_left_1, globalSpeed * 0.3F, globalDegree * 0.05F, false, 1.2F, -0.25F, limbSwing, limbSwingAmount);
		        	flap(hand_right_finger_left_2, globalSpeed * 0.3F, globalDegree * 0.04F, true, 1.2F, 0.1F, limbSwing, limbSwingAmount);
		        	flap(hand_right_finger_left_3, globalSpeed * 0.3F, globalDegree * 0.04F, true, 1.2F, 0.1F, limbSwing, limbSwingAmount);
		    		
		        	flap(hand_right_finger_right_1, globalSpeed * 0.3F, globalDegree * 0.05F, false, 1.2F, -0.25F, limbSwing, limbSwingAmount);
		        	flap(hand_right_finger_right_2, globalSpeed * 0.3F, globalDegree * 0.04F, true, 1.2F, 0.1F, limbSwing, limbSwingAmount);
		        	flap(hand_right_finger_right_3, globalSpeed * 0.3F, globalDegree * 0.04F, true, 1.2F, 0.1F, limbSwing, limbSwingAmount);
		    		
		        	flap(hand_right_thumb_1, globalSpeed * 0.3F, globalDegree * 0.1F, true, 1.2F, 0.0F, limbSwing, limbSwingAmount);
		        	flap(hand_right_thumb_2, globalSpeed * 0.3F, globalDegree * 0.1F, true, 1.2F, 0.0F, limbSwing, limbSwingAmount);
		    		
		        	swing(body_abs, globalSpeed * 0.3F, globalDegree * 0.08F, true, 1.6F, 0.0F, limbSwing, limbSwingAmount);
		        	swing(body_abs_bottom, globalSpeed * 0.3F, globalDegree * 0.08F, false, 2.0F, 0.1F, limbSwing, limbSwingAmount);
		    		
		    		swing(head_top, globalSpeed * 0.3F, globalDegree * 0.03F, false, 1.2F, -0.05F, limbSwing, limbSwingAmount);
				}
    		}
    		else //Standing Entity
    		{
    			//Adjustments to the rotations of the body parts when the entity is Standing
    			this.bottom_body.rotateAngleX = (float) Math.toRadians(-90F);
    			this.leg_left_1.rotateAngleX = (float) Math.toRadians(56.5F);
    			this.leg_right_1.rotateAngleX = (float) Math.toRadians(56.5F);
    			this.stomach.rotateAngleX = (float) Math.toRadians(-8.0F);
    			this.torso.rotateAngleX = (float) Math.toRadians(105.5F);
    			this.hand_left_main.rotateAngleY = (float) Math.toRadians(0.0F);
    			this.hand_right_main.rotateAngleY = (float) Math.toRadians(180.0F);
    			this.left_eyelid_base.rotateAngleY = (float) Math.toRadians(-14.0F);
    			this.right_eyelid_base.rotateAngleY = (float) Math.toRadians(14.0F);
    			this.arm_left_main.rotateAngleX = (float) Math.toRadians(0.0F);
    			this.arm_left_main.rotateAngleZ = (float) Math.toRadians(-6.8F);
    			this.arm_left_main.rotateAngleY = (float) Math.toRadians(6.8F);
    			this.arm_right_main.rotateAngleX = (float) Math.toRadians(0.0F);
    			this.arm_right_main.rotateAngleZ = (float) Math.toRadians(6.8F);
    			this.arm_right_main.rotateAngleY = (float) Math.toRadians(-6.8F);
    			
    			this.hand_left_thumb_1.rotateAngleZ = (float) Math.toRadians(14.0F);
    			this.hand_left_thumb_2.rotateAngleZ = (float) Math.toRadians(18.0F);
    			
    			this.hand_right_thumb_1.rotateAngleZ = (float) Math.toRadians(14.0F);
    			this.hand_right_thumb_2.rotateAngleZ = (float) Math.toRadians(18.0F);
    			
    			if(entity.prevPosX != entity.getPosX() || entity.prevPosZ != entity.getPosZ())
    			{
    				if(entity.isEntityStanding())
		    		{
			    		this.eye.rotateAngleY += (netHeadYaw * ((float)Math.PI / 180) / 1.2F);
			    		this.eye.rotateAngleX += (headPitch * ((float)Math.PI / 180) / 1.2F);
		    		}
		    		
		    		float globalSpeed = 4.8F;
		        	float globalHeight = 1.0F;
		        	float globalDegree = 2.0F;
		        	
		        	bounce(bottom_body, globalSpeed * 0.3F, globalHeight * 0.8F, false, limbSwing, limbSwingAmount);
		        	swing(head_top, globalSpeed * 0.3F, globalDegree * 0.03F, false, 1.2F, -0.05F, limbSwing, limbSwingAmount);
		        	
		        	shake(bottom_body, globalSpeed * 0.15F, globalHeight * 0.14F, true, 2.0F, 0.0F, limbSwing, limbSwingAmount);
		        	flap(stomach, globalSpeed * 0.15F, globalHeight * 0.05F, false, 1.2F, 0.0F, limbSwing, limbSwingAmount);
		        	flap(torso, globalSpeed * 0.15F, globalHeight * 0.05F, false, 1.2F, 0.0F, limbSwing, limbSwingAmount);
		        	
		        	//Left Leg
		        	swing(leg_left_1, globalSpeed * 0.15F, globalDegree * 0.22F, false, 2.2F, 0.0F, limbSwing, limbSwingAmount);
		        	swing(leg_left_2, globalSpeed * 0.15F, globalDegree * 0.25F, false, 2.7F, 0.0F, limbSwing, limbSwingAmount);
		        	swing(leg_left_3, globalSpeed * 0.15F, globalDegree * 0.2F, true, 1.3F, 0.1F, limbSwing, limbSwingAmount);
		        	swing(leg_left_4, globalSpeed * 0.15F, globalDegree * 0.28F, true, 3.3F, -0.03F, limbSwing, limbSwingAmount);
		        	swing(foot_left_front_slope, globalSpeed * 0.15F, globalDegree * 0.2F, false, 1.0F, -0.11F, limbSwing, limbSwingAmount);
		        	//Right Leg
		        	swing(leg_right_1, globalSpeed * 0.15F, globalDegree * 0.22F, true, 2.2F, 0.0F, limbSwing, limbSwingAmount);
		        	swing(leg_right_2, globalSpeed * 0.15F, globalDegree * 0.25F, true, 2.7F, 0.0F, limbSwing, limbSwingAmount);
		        	swing(leg_right_3, globalSpeed * 0.15F, globalDegree * 0.2F, false, 1.3F, 0.1F, limbSwing, limbSwingAmount);
		        	swing(leg_right_4, globalSpeed * 0.15F, globalDegree * 0.28F, false, 3.3F, -0.03F, limbSwing, limbSwingAmount);
		        	swing(foot_right_front_slope, globalSpeed * 0.15F, globalDegree * 0.2F, true, 1.0F, -0.11F, limbSwing, limbSwingAmount);
		        	
		        	swing(stomach, globalSpeed * 0.3F, globalDegree * 0.02F, true, 1.2F, 0.0F, limbSwing, limbSwingAmount);
		        	swing(torso, globalSpeed * 0.3F, globalDegree * 0.02F, true, 1.2F, 0.0F, limbSwing, limbSwingAmount);
		        	
		        	swing(arm_left_main, globalSpeed * 0.15F, globalDegree * 0.1F, false, -0.5F, 0.0F, limbSwing, limbSwingAmount);
		        	swing(arm_left_2, globalSpeed * 0.15F, globalDegree * 0.1F, false, -0.5F, 0.0F, limbSwing, limbSwingAmount);
		        	
		        	swing(arm_right_main, globalSpeed * 0.15F, globalDegree * 0.1F, true, -0.5F, 0.0F, limbSwing, limbSwingAmount);
		        	swing(arm_right_2, globalSpeed * 0.15F, globalDegree * 0.1F, true, -0.5F, 0.0F, limbSwing, limbSwingAmount);
    			}
    			else
    			{
    				limbSwing = entity.ticksExisted;
		    		limbSwingAmount = 1;

		    		if(entity.isEntityStanding())
		    		{
			    		this.eye.rotateAngleY += (netHeadYaw * ((float)Math.PI / 180) / 1.2F);
			    		this.eye.rotateAngleX += (headPitch * ((float)Math.PI / 180) / 1.2F);
		    		}
		    		
		    		float globalSpeed = 1.0F;
		        	float globalHeight = 1.0F;
		        	float globalDegree = 1.0F;
		    		
		        	bounce(bottom_body, globalSpeed * 0.3F, globalHeight * 0.51F, false, limbSwing, limbSwingAmount);
		        	swing(head_top, globalSpeed * 0.3F, globalDegree * 0.03F, false, 1.2F, -0.05F, limbSwing, limbSwingAmount);
		        	
		        	bounce(leg_left_1, globalSpeed * 0.3F, globalHeight * -0.2F, false, limbSwing, limbSwingAmount);
		        	swing(leg_left_1, globalSpeed * 0.3F, globalDegree * 0.03F, true, 1.3F, -0.01F, limbSwing, limbSwingAmount);
		        	swing(leg_left_2, globalSpeed * 0.3F, globalDegree * 0.03F, false, 1.3F, -0.01F, limbSwing, limbSwingAmount);
		        	swing(leg_left_3, globalSpeed * 0.3F, globalDegree * 0.03F, false, 1.3F, 0.00F, limbSwing, limbSwingAmount);
		        	swing(leg_left_4, globalSpeed * 0.3F, globalDegree * 0.03F, true, 1.3F, 0.00F, limbSwing, limbSwingAmount);
		        	
		        	bounce(leg_right_1, globalSpeed * 0.3F, globalHeight * -0.2F, false, limbSwing, limbSwingAmount);
		        	swing(leg_right_1, globalSpeed * 0.3F, globalDegree * 0.03F, true, 1.3F, -0.01F, limbSwing, limbSwingAmount);
		        	swing(leg_right_2, globalSpeed * 0.3F, globalDegree * 0.03F, false, 1.3F, -0.01F, limbSwing, limbSwingAmount);
		        	swing(leg_right_3, globalSpeed * 0.3F, globalDegree * 0.03F, false, 1.3F, 0.00F, limbSwing, limbSwingAmount);
		        	swing(leg_right_4, globalSpeed * 0.3F, globalDegree * 0.03F, true, 1.3F, 0.00F, limbSwing, limbSwingAmount);
		        	
		        	swing(stomach, globalSpeed * 0.3F, globalDegree * 0.01F, true, 1.2F, 0.0F, limbSwing, limbSwingAmount);
		        	swing(torso, globalSpeed * 0.3F, globalDegree * 0.02F, false, 1.2F, 0.0F, limbSwing, limbSwingAmount);
		        	
		        	swing(body_abs_bottom, globalSpeed * 0.3F, globalDegree * 0.04F, true, 1.2F, 0.05F, limbSwing, limbSwingAmount);
		        	
		        	swing(arm_left_main, globalSpeed * 0.3F, globalDegree * 0.01F, false, 1.2F, 0.0F, limbSwing, limbSwingAmount);
		        	swing(arm_left_2, globalSpeed * 0.3F, globalDegree * 0.01F, false, 1.0F, 0.0F, limbSwing, limbSwingAmount);
		        	swing(arm_right_main, globalSpeed * 0.3F, globalDegree * 0.01F, false, 1.2F, 0.0F, limbSwing, limbSwingAmount);
		        	swing(arm_right_2, globalSpeed * 0.3F, globalDegree * 0.01F, false, 1.0F, 0.0F, limbSwing, limbSwingAmount);
    			}
    		}
    	}
    	
    	if(entity.isAnimationPlaying(EndTrollEntity.TRANSFORM_ANIMATION))
    	{
    		limbSwing = entity.ticksExisted;
    		limbSwingAmount = 1;
    		
    		swing(head_top, 0.3F, 0.03F, false, 1.2F, -0.05F, limbSwing, limbSwingAmount);
    		
    		if(entity.getAnimationTick() > 0 && entity.getAnimationTick() <= 19)
    		{	
    			shake(left_eyelid_base, 2.0F, 0.005F, false, 0.0F, 0.02F, limbSwing, limbSwingAmount);
    			shake(right_eyelid_base, 2.0F, 0.005F, true, 0.0F, -0.02F, limbSwing, limbSwingAmount);
    		}
    	}
    	if(entity.isAnimationPlaying(EndTrollEntity.SCREAM_ANIMATION))
    	{
    		limbSwing = entity.ticksExisted;
    		limbSwingAmount = 1;
    		
    		swing(head_top, 0.3F, 0.03F, false, 1.2F, -0.05F, limbSwing, limbSwingAmount);
    	}
    }
    
    @Override
    public void animateModel(T animatedEntity)
    {
    	this.animator.updateAnimations(animatedEntity);
    	
    	if(animatedEntity.isAnimationPlaying(EndTrollEntity.TRANSFORM_ANIMATION))
    	{
    		this.animator.setAnimationToPlay(EndTrollEntity.TRANSFORM_ANIMATION);
    		
    		this.animator.startKeyframe(6);
    		this.animator.move(movement_base, 0, 4.0F, 0);
    		this.animator.rotate(leg_left_2, 0.4F, 0, 0);
    		this.animator.rotate(leg_right_2, 0.4F, 0, 0);
    		this.animator.rotate(leg_left_3, -0.4F, 0, 0);
    		this.animator.rotate(leg_right_3, -0.4F, 0, 0);
    		this.animator.rotate(arm_left_2, -0.2F, 0, 0);
    		this.animator.rotate(arm_right_2, -0.2F, 0, 0);
    		this.animator.endKeyframe();
    		
    		this.animator.startKeyframe(10);
    		this.animator.move(movement_base, 0, -4, -20.0F);
    		this.animator.rotate(bottom_body, -1.6F, 0, 0);
    		this.animator.rotate(leg_left_1, 1.6F, 0, 0);
    		this.animator.rotate(leg_right_1, 1.6F, 0, 0);
    		this.animator.rotate(leg_left_2, 0.4F, 0, 0);
    		this.animator.rotate(leg_right_2, 0.4F, 0, 0);
    		this.animator.rotate(leg_left_3, -0.4F, 0, 0);
    		this.animator.rotate(leg_right_3, -0.4F, 0, 0);
    		this.animator.rotate(stomach, 0.4F, 0, 0);
    		this.animator.rotate(torso, 0.6F, 0, 0);
    		this.animator.rotate(hand_left_main, 0, -1.6F, 0);
    		this.animator.rotate(hand_right_main, 0, 1.6F, 0);
    		this.animator.rotate(arm_left_main, 1.0F, 0.12F, -0.12F);
    		this.animator.rotate(arm_right_main, 1.0F, -0.12F, 0.12F);
    		this.animator.rotate(arm_left_2, -0.2F, 0, 0);
    		this.animator.rotate(arm_right_2, -0.2F, 0, 0);
    		
    		this.animator.rotate(hand_left_thumb_1, 0, 0, -0.8F);
    		this.animator.rotate(hand_left_thumb_2, 0, 0, -0.4F);
    		this.animator.rotate(hand_right_thumb_1, 0, 0, -0.8F);
    		this.animator.rotate(hand_right_thumb_2, 0, 0, -0.4F);
    		this.animator.endKeyframe();
    		
    		this.animator.startKeyframe(3);
    		this.animator.move(movement_base, 0, 0, -20.0F);
    		this.animator.rotate(bottom_body, -1.6F, 0, 0);
    		this.animator.rotate(leg_left_1, 1.6F, 0, 0);
    		this.animator.rotate(leg_right_1, 1.6F, 0, 0);
    		this.animator.rotate(leg_left_2, 0.0F, 0, 0);
    		this.animator.rotate(leg_right_2, 0.0F, 0, 0);
    		this.animator.rotate(leg_left_3, 0.0F, 0, 0);
    		this.animator.rotate(leg_right_3, 0.0F, 0, 0);
    		this.animator.rotate(stomach, 0.4F, 0, 0);
    		this.animator.rotate(torso, 0.6F, 0, 0);
    		this.animator.rotate(hand_left_main, 0, -1.6F, 0);
    		this.animator.rotate(hand_right_main, 0, 1.6F, 0);
    		this.animator.rotate(arm_left_main, 1.0F, 0.12F, -0.12F);
    		this.animator.rotate(arm_right_main, 1.0F, -0.12F, 0.12F);
    		this.animator.rotate(arm_left_2, 0.0F, 0, 0);
    		this.animator.rotate(arm_right_2, 0.0F, 0, 0);
    		
    		this.animator.rotate(hand_left_thumb_1, 0, 0, -0.8F);
    		this.animator.rotate(hand_left_thumb_2, 0, 0, -0.4F);
    		this.animator.rotate(hand_right_thumb_1, 0, 0, -0.8F);
    		this.animator.rotate(hand_right_thumb_2, 0, 0, -0.4F);
    		this.animator.endKeyframe();
    		
    		this.animator.startKeyframe(1);
    		this.animator.move(movement_base, 0, 0, -20.0F);
    		this.animator.rotate(bottom_body, -1.6F, 0, 0);
    		this.animator.rotate(leg_left_1, 1.6F, 0, 0);
    		this.animator.rotate(leg_right_1, 1.6F, 0, 0);
    		this.animator.rotate(leg_left_2, 0.0F, 0, 0);
    		this.animator.rotate(leg_right_2, 0.0F, 0, 0);
    		this.animator.rotate(leg_left_3, 0.0F, 0, 0);
    		this.animator.rotate(leg_right_3, 0.0F, 0, 0);
    		this.animator.rotate(stomach, 0.4F, 0, 0);
    		this.animator.rotate(torso, 0.6F, 0, 0);
    		this.animator.rotate(hand_left_main, 0, -1.6F, 0);
    		this.animator.rotate(hand_right_main, 0, 1.6F, 0);
    		this.animator.rotate(arm_left_main, 1.0F, 0.12F, -0.12F);
    		this.animator.rotate(arm_right_main, 1.0F, -0.12F, 0.12F);
    		this.animator.rotate(left_eyelid_base, 0, -0.3F, 0);
    		this.animator.rotate(right_eyelid_base, 0, 0.3F, 0);
    		this.animator.rotate(arm_left_2, 0.0F, 0, 0);
    		this.animator.rotate(arm_right_2, 0.0F, 0, 0);
    		
    		this.animator.rotate(hand_left_thumb_1, 0, 0, -0.8F);
    		this.animator.rotate(hand_left_thumb_2, 0, 0, -0.4F);
    		this.animator.rotate(hand_right_thumb_1, 0, 0, -0.8F);
    		this.animator.rotate(hand_right_thumb_2, 0, 0, -0.4F);
    		this.animator.endKeyframe();
    	}
    	if(animatedEntity.isAnimationPlaying(EndTrollEntity.SCREAM_ANIMATION))
    	{
    		this.animator.setAnimationToPlay(EndTrollEntity.SCREAM_ANIMATION);
    		
    		this.animator.startKeyframe(0);
    		this.animator.move(movement_base, 0, 0, -20.0F);
    		this.animator.rotate(bottom_body, -1.6F, 0, 0);
    		this.animator.rotate(leg_left_1, 1.6F, 0, 0);
    		this.animator.rotate(leg_right_1, 1.6F, 0, 0);
    		this.animator.rotate(leg_left_2, 0.0F, 0, 0);
    		this.animator.rotate(leg_right_2, 0.0F, 0, 0);
    		this.animator.rotate(leg_left_3, 0.0F, 0, 0);
    		this.animator.rotate(leg_right_3, 0.0F, 0, 0);
    		this.animator.rotate(stomach, 0.4F, 0, 0);
    		this.animator.rotate(torso, 0.6F, 0, 0);
    		this.animator.rotate(hand_left_main, 0, -1.6F, 0);
    		this.animator.rotate(hand_right_main, 0, 1.6F, 0);
    		this.animator.rotate(arm_left_main, 1.0F, 0.12F, -0.12F);
    		this.animator.rotate(arm_right_main, 1.0F, -0.12F, 0.12F);
    		this.animator.rotate(left_eyelid_base, 0, -0.3F, 0);
    		this.animator.rotate(right_eyelid_base, 0, 0.3F, 0);
    		this.animator.rotate(arm_left_2, 0.0F, 0, 0);
    		this.animator.rotate(arm_right_2, 0.0F, 0, 0);
    		this.animator.rotate(hand_left_thumb_1, 0, 0, -0.8F);
    		this.animator.rotate(hand_left_thumb_2, 0, 0, -0.4F);
    		this.animator.rotate(hand_right_thumb_1, 0, 0, -0.8F);
    		this.animator.rotate(hand_right_thumb_2, 0, 0, -0.4F);
    		this.animator.endKeyframe();
    		
    		this.animator.setStaticKeyframe(4);
    		
    		this.animator.startKeyframe(6);
    		this.animator.move(movement_base, 0, 0, -20.0F);
    		this.animator.rotate(bottom_body, -1.6F, 0, 0);
    		this.animator.rotate(leg_left_1, 1.6F, 0, 0);
    		this.animator.rotate(leg_right_1, 1.6F, 0, 0);
    		this.animator.rotate(leg_left_2, 0.0F, 0, 0);
    		this.animator.rotate(leg_right_2, 0.0F, 0, 0);
    		this.animator.rotate(leg_left_3, 0.0F, 0, 0);
    		this.animator.rotate(leg_right_3, 0.0F, 0, 0);
    		this.animator.rotate(stomach, 0.6F, 0, 0);
    		this.animator.rotate(torso, 0.9F, 0, 0);
    		this.animator.rotate(hand_left_main, 0, -1.6F, 0);
    		this.animator.rotate(hand_right_main, 0, 1.6F, 0);
    		
    		this.animator.rotate(arm_left_main, -0.1F, 0.12F, -0.12F);
    		this.animator.rotate(arm_right_main, 0.1F, -0.12F, 0.12F);
    		
    		this.animator.rotate(arm_left_2, -0.9F, 0.7F, 0.8F);
    		this.animator.rotate(arm_right_2, -0.9F, -0.7F, -0.7F);
    		
    		this.animator.rotate(left_eyelid_base, 0, -0.3F, 0);
    		this.animator.rotate(right_eyelid_base, 0, 0.3F, 0);
    		
    		this.animator.rotate(hand_left_thumb_1, 0, 0, -0.8F);
    		this.animator.rotate(hand_left_thumb_2, 0, 0, -0.4F);
    		this.animator.rotate(hand_right_thumb_1, 0, 0, -0.8F);
    		this.animator.rotate(hand_right_thumb_2, 0, 0, -0.4F);
    		this.animator.endKeyframe();
    		
    		this.animator.startKeyframe(7);
    		this.animator.move(movement_base, 0, 0, -20.0F);
    		this.animator.rotate(bottom_body, -1.6F, 0, 0);
    		this.animator.rotate(leg_left_1, 1.6F, 0, 0);
    		this.animator.rotate(leg_right_1, 1.6F, 0, 0);
    		this.animator.rotate(leg_left_2, 0.0F, 0, 0);
    		this.animator.rotate(leg_right_2, 0.0F, 0, 0);
    		this.animator.rotate(leg_left_3, 0.0F, 0, 0);
    		this.animator.rotate(leg_right_3, 0.0F, 0, 0);
    		this.animator.rotate(stomach, 0.2F, 0, 0);
    		this.animator.rotate(torso, 0.2F, 0, 0);
    		this.animator.rotate(hand_left_main, 0, -1.6F, 0);
    		this.animator.rotate(hand_right_main, 0, 1.6F, 0);
    		
    		this.animator.rotate(arm_left_main, 1.5F, 0.6F, -0.6F);
    		this.animator.rotate(arm_right_main, 1.5F, -0.6F, 0.6F);
    		
    		this.animator.rotate(arm_left_2, -0.8F, -0.4F, 0.4F);
    		this.animator.rotate(arm_right_2, -0.8F, 0.4F, -0.4F);
    		
    		this.animator.rotate(head_top, -0.5F, 0, 0);
    		
    		this.animator.rotate(left_eyelid_base, 0, -0.3F, 0);
    		this.animator.rotate(right_eyelid_base, 0, 0.3F, 0);
    		
    		this.animator.rotate(hand_left_thumb_1, 0, 0, -0.8F);
    		this.animator.rotate(hand_left_thumb_2, 0, 0, -0.4F);
    		this.animator.rotate(hand_right_thumb_1, 0, 0, -0.8F);
    		this.animator.rotate(hand_right_thumb_2, 0, 0, -0.4F);
    		this.animator.endKeyframe();
    		
    		this.animator.setStaticKeyframe(3);
    		
    		this.animator.startKeyframe(12);
    		this.animator.move(movement_base, 0, 0, -20.0F);
    		this.animator.rotate(bottom_body, -1.6F, 0, 0);
    		this.animator.rotate(leg_left_1, 1.6F, 0, 0);
    		this.animator.rotate(leg_right_1, 1.6F, 0, 0);
    		this.animator.rotate(leg_left_2, 0.0F, 0, 0);
    		this.animator.rotate(leg_right_2, 0.0F, 0, 0);
    		this.animator.rotate(leg_left_3, 0.0F, 0, 0);
    		this.animator.rotate(leg_right_3, 0.0F, 0, 0);
    		this.animator.rotate(stomach, 0.4F, 0, 0);
    		this.animator.rotate(torso, 0.6F, 0, 0);
    		this.animator.rotate(hand_left_main, 0, -1.6F, 0);
    		this.animator.rotate(hand_right_main, 0, 1.6F, 0);
    		this.animator.rotate(arm_left_main, 1.0F, 0.12F, -0.12F);
    		this.animator.rotate(arm_right_main, 1.0F, -0.12F, 0.12F);
    		this.animator.rotate(left_eyelid_base, 0, -0.3F, 0);
    		this.animator.rotate(right_eyelid_base, 0, 0.3F, 0);
    		this.animator.rotate(arm_left_2, 0.0F, 0, 0);
    		this.animator.rotate(arm_right_2, 0.0F, 0, 0);
    		this.animator.rotate(hand_left_thumb_1, 0, 0, -0.8F);
    		this.animator.rotate(hand_left_thumb_2, 0, 0, -0.4F);
    		this.animator.rotate(hand_right_thumb_1, 0, 0, -0.8F);
    		this.animator.rotate(hand_right_thumb_2, 0, 0, -0.4F);
    		this.animator.endKeyframe();
    	}
    	if(animatedEntity.isAnimationPlaying(EndTrollEntity.SHOOT_ANIMATION))
    	{
    		this.animator.setAnimationToPlay(EndTrollEntity.SHOOT_ANIMATION);
    		
    		this.animator.startKeyframe(6);
    		this.animator.rotate(stomach, -0.2F, 0, 0);
    		this.animator.move(torso, 0, 0, -2);
    		this.animator.rotate(torso, 0.1F, 0, 0);
    		this.animator.rotate(arm_left_main, 0.3F, 0.12F, -0.12F);
    		this.animator.rotate(arm_right_main, 0.3F, -0.12F, 0.12F);
    		this.animator.rotate(arm_left_2, -0.8F, 0, 0);
    		this.animator.rotate(arm_right_2, -0.8F, 0, 0);
    		this.animator.endKeyframe();
    		
    		this.animator.setStaticKeyframe(1);
    		
    		this.animator.startKeyframe(5);
    		this.animator.rotate(head_top, -0.5F, 0, 0);
    		this.animator.move(stomach, 0, 0, -1);
    		this.animator.rotate(stomach, 0.3F, 0, 0);
    		this.animator.move(torso, 0, 0, -1);
    		this.animator.rotate(torso, -0.2F, 0, 0);
    		this.animator.rotate(arm_left_main, 0.8F, 0.12F, -0.12F);
    		this.animator.rotate(arm_right_main, 0.8F, -0.12F, 0.12F);
    		this.animator.rotate(arm_left_2, -0.1F, 0, 0);
    		this.animator.rotate(arm_right_2, -0.1F, 0, 0);
    		this.animator.endKeyframe();
    		
    		this.animator.setStaticKeyframe(1);
    		this.animator.resetKeyframe(7);
    	}
    	if(animatedEntity.isAnimationPlaying(EndTrollEntity.RIGHT_PUNCH_ANIMATION))
    	{
    		this.animator.setAnimationToPlay(EndTrollEntity.RIGHT_PUNCH_ANIMATION);
    		
    		this.animator.startKeyframe(9);
    		this.animator.rotate(torso, 0.2F, -0.2F, 0.3F);
    		this.animator.rotate(stomach, -0.1F, 0, 0);
    		this.animator.rotate(arm_right_main, 0.5F, -0.7F, 0.7F);
    		this.animator.rotate(arm_right_2, -1.5F, 0, 0);
    		
    		this.animator.rotate(arm_left_main, -0.1F, 0.4F, -0.2F);
    		this.animator.rotate(arm_left_2, -0.5F, 0, 0);
    		
    		this.animator.rotate(hand_right_finger_right_1, 0, 0, 0.2F);
    		this.animator.rotate(hand_right_finger_right_2, 0, 0, 0.4F);
    		this.animator.rotate(hand_right_finger_right_3, 0, 0, 0.4F);
    		this.animator.rotate(hand_right_finger_left_1, 0, 0, 0.2F);
    		this.animator.rotate(hand_right_finger_left_2, 0, 0, 0.4F);
    		this.animator.rotate(hand_right_finger_left_3, 0, 0, 0.4F);
    		this.animator.rotate(hand_right_thumb_1, 0, 0, -0.2F);
    		this.animator.rotate(hand_right_thumb_2, 0, 0, 0.8F);
    		this.animator.endKeyframe();
    		
    		this.animator.setStaticKeyframe(1);
    		
    		this.animator.startKeyframe(5);
    		this.animator.rotate(torso, 0.2F, 0.4F, -0.4F);
    		this.animator.rotate(stomach, 0.0F, 0, 0);
    		
    		this.animator.rotate(arm_right_main, -1.2F, -0.7F, 0.7F);
    		this.animator.rotate(arm_right_2, 0.1F, 0, 0);
    		
    		this.animator.rotate(arm_left_main, 0.5F, 0.1F, -0.1F);
    		this.animator.rotate(arm_left_2, -1.1F, 0.2F, -0.2F);
    		
    		this.animator.rotate(hand_right_finger_right_1, 0, 0, 0.2F);
    		this.animator.rotate(hand_right_finger_right_2, 0, 0, 0.4F);
    		this.animator.rotate(hand_right_finger_right_3, 0, 0, 0.4F);
    		this.animator.rotate(hand_right_finger_left_1, 0, 0, 0.2F);
    		this.animator.rotate(hand_right_finger_left_2, 0, 0, 0.4F);
    		this.animator.rotate(hand_right_finger_left_3, 0, 0, 0.4F);
    		this.animator.rotate(hand_right_thumb_1, 0, 0, -0.2F);
    		this.animator.rotate(hand_right_thumb_2, 0, 0, 0.8F);
    		this.animator.endKeyframe();
    		
    		this.animator.setStaticKeyframe(1);
    		
    		this.animator.resetKeyframe(12);
    	}
    	if(animatedEntity.isAnimationPlaying(EndTrollEntity.LEFT_PUNCH_ANIMATION))
    	{
    		this.animator.setAnimationToPlay(EndTrollEntity.LEFT_PUNCH_ANIMATION);
    		
    		this.animator.startKeyframe(9);
    		this.animator.rotate(torso, 0.2F, 0.2F, -0.3F);
    		this.animator.rotate(stomach, -0.1F, 0, 0);
    		this.animator.rotate(arm_left_main, 0.5F, 0.7F, -0.7F);
    		this.animator.rotate(arm_left_2, -1.5F, 0, 0);
    		
    		this.animator.rotate(arm_right_main, -0.1F, -0.4F, 0.2F);
    		this.animator.rotate(arm_right_2, -0.5F, 0, 0);
    		
    		this.animator.rotate(hand_left_finger_right_1, 0, 0, 0.2F);
    		this.animator.rotate(hand_left_finger_right_2, 0, 0, 0.4F);
    		this.animator.rotate(hand_left_finger_right_3, 0, 0, 0.4F);
    		this.animator.rotate(hand_left_finger_left_1, 0, 0, 0.2F);
    		this.animator.rotate(hand_left_finger_left_2, 0, 0, 0.4F);
    		this.animator.rotate(hand_left_finger_left_3, 0, 0, 0.4F);
    		this.animator.rotate(hand_left_thumb_1, 0, 0, -0.2F);
    		this.animator.rotate(hand_left_thumb_2, 0, 0, 0.8F);
    		this.animator.endKeyframe();
    		
    		this.animator.setStaticKeyframe(1);
    		
    		this.animator.startKeyframe(5);
    		this.animator.rotate(torso, 0.2F, -0.4F, 0.4F);
    		this.animator.rotate(stomach, 0.0F, 0, 0);
    		
    		this.animator.rotate(arm_left_main, -1.2F, 0.7F, -0.7F);
    		this.animator.rotate(arm_left_2, 0.1F, 0, 0);
    		
    		this.animator.rotate(arm_right_main, 0.5F, -0.1F, 0.1F);
    		this.animator.rotate(arm_right_2, -1.1F, -0.2F, 0.2F);
    		
    		this.animator.rotate(hand_left_finger_right_1, 0, 0, 0.2F);
    		this.animator.rotate(hand_left_finger_right_2, 0, 0, 0.4F);
    		this.animator.rotate(hand_left_finger_right_3, 0, 0, 0.4F);
    		this.animator.rotate(hand_left_finger_left_1, 0, 0, 0.2F);
    		this.animator.rotate(hand_left_finger_left_2, 0, 0, 0.4F);
    		this.animator.rotate(hand_left_finger_left_3, 0, 0, 0.4F);
    		this.animator.rotate(hand_left_thumb_1, 0, 0, -0.2F);
    		this.animator.rotate(hand_left_thumb_2, 0, 0, 0.8F);
    		this.animator.endKeyframe();
    		
    		this.animator.setStaticKeyframe(1);
    		
    		this.animator.resetKeyframe(12);
    	}
    	if(animatedEntity.isAnimationPlaying(EndTrollEntity.DOUBLE_PUNCH_ANIMATION))
    	{
    		this.animator.setAnimationToPlay(EndTrollEntity.DOUBLE_PUNCH_ANIMATION);
    		
    		this.animator.startKeyframe(9);
    		this.animator.rotate(torso, 0.3F, 0, 0);
    		this.animator.rotate(stomach, -0.3F, 0, 0);
    		this.animator.rotate(arm_left_main, 0.5F, 0.7F, -0.7F);
    		this.animator.rotate(arm_left_2, -1.5F, 0, 0);
    		this.animator.rotate(arm_right_main, 0.5F, -0.7F, 0.7F);
    		this.animator.rotate(arm_right_2, -1.5F, 0, 0);
    		
    		this.animator.rotate(hand_left_finger_right_1, 0, 0, 0.2F);
    		this.animator.rotate(hand_left_finger_right_2, 0, 0, 0.4F);
    		this.animator.rotate(hand_left_finger_right_3, 0, 0, 0.4F);
    		this.animator.rotate(hand_left_finger_left_1, 0, 0, 0.2F);
    		this.animator.rotate(hand_left_finger_left_2, 0, 0, 0.4F);
    		this.animator.rotate(hand_left_finger_left_3, 0, 0, 0.4F);
    		this.animator.rotate(hand_left_thumb_1, 0, 0, -0.2F);
    		this.animator.rotate(hand_left_thumb_2, 0, 0, 0.8F);
    		this.animator.rotate(hand_right_finger_right_1, 0, 0, 0.2F);
    		this.animator.rotate(hand_right_finger_right_2, 0, 0, 0.4F);
    		this.animator.rotate(hand_right_finger_right_3, 0, 0, 0.4F);
    		this.animator.rotate(hand_right_finger_left_1, 0, 0, 0.2F);
    		this.animator.rotate(hand_right_finger_left_2, 0, 0, 0.4F);
    		this.animator.rotate(hand_right_finger_left_3, 0, 0, 0.4F);
    		this.animator.rotate(hand_right_thumb_1, 0, 0, -0.2F);
    		this.animator.rotate(hand_right_thumb_2, 0, 0, 0.8F);
    		this.animator.endKeyframe();
    		
    		this.animator.setStaticKeyframe(1);
    		
    		this.animator.startKeyframe(5);
    		this.animator.rotate(torso, 0.2F, 0, 0);
    		this.animator.rotate(stomach, 0.2F, 0, 0);
    		
    		this.animator.rotate(arm_left_main, -1.6F, 0.7F, -0.7F);
    		this.animator.rotate(arm_left_2, 0.1F, 0, 0.4F);
    		this.animator.rotate(arm_right_main, -1.6F, -0.7F, 0.7F);
    		this.animator.rotate(arm_right_2, 0.1F, 0, -0.4F);
    		
    		this.animator.rotate(hand_left_finger_right_1, 0, 0, 0.2F);
    		this.animator.rotate(hand_left_finger_right_2, 0, 0, 0.4F);
    		this.animator.rotate(hand_left_finger_right_3, 0, 0, 0.4F);
    		this.animator.rotate(hand_left_finger_left_1, 0, 0, 0.2F);
    		this.animator.rotate(hand_left_finger_left_2, 0, 0, 0.4F);
    		this.animator.rotate(hand_left_finger_left_3, 0, 0, 0.4F);
    		this.animator.rotate(hand_left_thumb_1, 0, 0, -0.2F);
    		this.animator.rotate(hand_left_thumb_2, 0, 0, 0.8F);
    		this.animator.rotate(hand_right_finger_right_1, 0, 0, 0.2F);
    		this.animator.rotate(hand_right_finger_right_2, 0, 0, 0.4F);
    		this.animator.rotate(hand_right_finger_right_3, 0, 0, 0.4F);
    		this.animator.rotate(hand_right_finger_left_1, 0, 0, 0.2F);
    		this.animator.rotate(hand_right_finger_left_2, 0, 0, 0.4F);
    		this.animator.rotate(hand_right_finger_left_3, 0, 0, 0.4F);
    		this.animator.rotate(hand_right_thumb_1, 0, 0, -0.2F);
    		this.animator.rotate(hand_right_thumb_2, 0, 0, 0.8F);
    		this.animator.endKeyframe();
    		
    		this.animator.setStaticKeyframe(1);
    		
    		this.animator.resetKeyframe(12);
    	}
    	if(animatedEntity.isAnimationPlaying(EndTrollEntity.DEATH_ANIMATION))
    	{
    		this.animator.setAnimationToPlay(EndTrollEntity.DEATH_ANIMATION);
    		
    		this.animator.startKeyframe(0);
    		this.animator.move(movement_base, 0, 0, -20.0F);
    		this.animator.rotate(bottom_body, -1.6F, 0, 0);
    		this.animator.rotate(leg_left_1, 1.6F, 0, 0);
    		this.animator.rotate(leg_right_1, 1.6F, 0, 0);
    		this.animator.rotate(leg_left_2, 0.0F, 0, 0);
    		this.animator.rotate(leg_right_2, 0.0F, 0, 0);
    		this.animator.rotate(leg_left_3, 0.0F, 0, 0);
    		this.animator.rotate(leg_right_3, 0.0F, 0, 0);
    		this.animator.rotate(stomach, 0.4F, 0, 0);
    		this.animator.rotate(torso, 0.6F, 0, 0);
    		this.animator.rotate(hand_left_main, 0, -1.6F, 0);
    		this.animator.rotate(hand_right_main, 0, 1.6F, 0);
    		this.animator.rotate(arm_left_main, 1.0F, 0.12F, -0.12F);
    		this.animator.rotate(arm_right_main, 1.0F, -0.12F, 0.12F);
    		this.animator.rotate(left_eyelid_base, 0, -0.3F, 0);
    		this.animator.rotate(right_eyelid_base, 0, 0.3F, 0);
    		this.animator.rotate(arm_left_2, 0.0F, 0, 0);
    		this.animator.rotate(arm_right_2, 0.0F, 0, 0);
    		this.animator.rotate(hand_left_thumb_1, 0, 0, -0.8F);
    		this.animator.rotate(hand_left_thumb_2, 0, 0, -0.4F);
    		this.animator.rotate(hand_right_thumb_1, 0, 0, -0.8F);
    		this.animator.rotate(hand_right_thumb_2, 0, 0, -0.4F);
    		this.animator.endKeyframe();
    		
    		//Legs Move Up
    		this.animator.startKeyframe(6);
    		this.animator.move(movement_base, 0, 0, -20.0F);
    		this.animator.rotate(bottom_body, -1.5F, 0, 0);
    		this.animator.move(bottom_body, 0, 6, 0);
    		this.animator.rotate(leg_left_1, 1.5F, 0, 0);
    		this.animator.rotate(leg_right_1, 1.5F, 0, 0);
    		this.animator.rotate(leg_left_2, 0.6F, 0, 0);
    		this.animator.rotate(leg_right_2, 0.6F, 0, 0);
    		this.animator.rotate(leg_left_3, -0.6F, 0, 0);
    		this.animator.rotate(leg_right_3, -0.6F, 0, 0);
    		this.animator.rotate(stomach, 0.4F, 0, 0);
    		this.animator.rotate(torso, 0.6F, 0, 0);
    		this.animator.rotate(hand_left_main, 0, -1.6F, 0);
    		this.animator.rotate(hand_right_main, 0, 1.6F, 0);
    		this.animator.rotate(arm_left_main, 0.8F, 0.12F, -0.12F);
    		this.animator.rotate(arm_right_main, 0.8F, -0.12F, 0.12F);
    		this.animator.rotate(left_eyelid_base, 0, -0.3F, 0);
    		this.animator.rotate(right_eyelid_base, 0, 0.3F, 0);
    		this.animator.rotate(arm_left_2, -0.1F, 0, 0);
    		this.animator.rotate(arm_right_2, -0.1F, 0, 0);
    		this.animator.rotate(hand_left_thumb_1, 0, 0, -0.8F);
    		this.animator.rotate(hand_left_thumb_2, 0, 0, -0.4F);
    		this.animator.rotate(hand_right_thumb_1, 0, 0, -0.8F);
    		this.animator.rotate(hand_right_thumb_2, 0, 0, -0.4F);
    		this.animator.rotate(hand_left_finger_right_1, 0, 0, 0.2F);
    		this.animator.rotate(hand_left_finger_right_2, 0, 0, 0.4F);
    		this.animator.rotate(hand_left_finger_right_3, 0, 0, 0.4F);
    		this.animator.rotate(hand_left_finger_left_1, 0, 0, 0.2F);
    		this.animator.rotate(hand_left_finger_left_2, 0, 0, 0.4F);
    		this.animator.rotate(hand_left_finger_left_3, 0, 0, 0.4F);
    		this.animator.rotate(hand_left_thumb_1, 0, 0, -0.2F);
    		this.animator.rotate(hand_left_thumb_2, 0, 0, 0.8F);
    		this.animator.rotate(hand_right_finger_right_1, 0, 0, 0.2F);
    		this.animator.rotate(hand_right_finger_right_2, 0, 0, 0.4F);
    		this.animator.rotate(hand_right_finger_right_3, 0, 0, 0.4F);
    		this.animator.rotate(hand_right_finger_left_1, 0, 0, 0.2F);
    		this.animator.rotate(hand_right_finger_left_2, 0, 0, 0.4F);
    		this.animator.rotate(hand_right_finger_left_3, 0, 0, 0.4F);
    		this.animator.rotate(hand_right_thumb_1, 0, 0, -0.2F);
    		this.animator.rotate(hand_right_thumb_2, 0, 0, 0.8F);
    		this.animator.endKeyframe();
    		
    		//Fall Forwards
    		this.animator.startKeyframe(8);
    		this.animator.move(movement_base, 0, 0, -20.0F);
    		this.animator.rotate(bottom_body, -0.7F, 0, 0);
    		this.animator.move(bottom_body, 0, 6, 0);
    		this.animator.rotate(leg_left_1, 0.7F, 0, 0);
    		this.animator.rotate(leg_right_1, 0.7F, 0, 0);
    		this.animator.rotate(leg_left_2, 0.6F, 0, 0);
    		this.animator.rotate(leg_right_2, 0.6F, 0, 0);
    		this.animator.rotate(leg_left_3, -0.6F, 0, 0);
    		this.animator.rotate(leg_right_3, -0.6F, 0, 0);
    		this.animator.rotate(stomach, 0.4F, 0, 0);
    		this.animator.rotate(torso, 0.6F, 0, 0);
    		this.animator.rotate(hand_left_main, 0, -1.6F, 0);
    		this.animator.rotate(hand_right_main, 0, 1.6F, 0);
    		this.animator.rotate(arm_left_main, 0.1F, 0.12F, -0.12F);
    		this.animator.rotate(arm_right_main, 0.1F, -0.12F, 0.12F);
    		this.animator.rotate(arm_left_2, -0.4F, 0, 0);
    		this.animator.rotate(arm_right_2, -0.4F, 0, 0);
    		this.animator.rotate(left_eyelid_base, 0, 0.0F, 0);
    		this.animator.rotate(right_eyelid_base, 0, 0.0F, 0);
    		this.animator.rotate(hand_left_thumb_1, 0, 0, -0.8F);
    		this.animator.rotate(hand_left_thumb_2, 0, 0, -0.4F);
    		this.animator.rotate(hand_right_thumb_1, 0, 0, -0.8F);
    		this.animator.rotate(hand_right_thumb_2, 0, 0, -0.4F);
    		this.animator.rotate(hand_left_finger_right_1, 0, 0, 0.2F);
    		this.animator.rotate(hand_left_finger_right_2, 0, 0, 0.4F);
    		this.animator.rotate(hand_left_finger_right_3, 0, 0, 0.4F);
    		this.animator.rotate(hand_left_finger_left_1, 0, 0, 0.2F);
    		this.animator.rotate(hand_left_finger_left_2, 0, 0, 0.4F);
    		this.animator.rotate(hand_left_finger_left_3, 0, 0, 0.4F);
    		this.animator.rotate(hand_left_thumb_1, 0, 0, -0.2F);
    		this.animator.rotate(hand_left_thumb_2, 0, 0, 0.8F);
    		this.animator.rotate(hand_right_finger_right_1, 0, 0, 0.2F);
    		this.animator.rotate(hand_right_finger_right_2, 0, 0, 0.4F);
    		this.animator.rotate(hand_right_finger_right_3, 0, 0, 0.4F);
    		this.animator.rotate(hand_right_finger_left_1, 0, 0, 0.2F);
    		this.animator.rotate(hand_right_finger_left_2, 0, 0, 0.4F);
    		this.animator.rotate(hand_right_finger_left_3, 0, 0, 0.4F);
    		this.animator.rotate(hand_right_thumb_1, 0, 0, -0.2F);
    		this.animator.rotate(hand_right_thumb_2, 0, 0, 0.8F);
    		this.animator.endKeyframe();
    		
    		this.animator.setStaticKeyframe(4);
    		
    		//Final Death Part
    		this.animator.startKeyframe(16);
    		this.animator.move(movement_base, 0, 0, -20.0F);
    		this.animator.rotate(bottom_body, 0.1F, 0, 0);
    		this.animator.move(bottom_body, 0, 6, 0);
    		this.animator.rotate(leg_left_1, -0.1F, 0, 0);
    		this.animator.rotate(leg_right_1, -0.1F, 0, 0);
    		this.animator.rotate(leg_left_2, 0.6F, 0, 0);
    		this.animator.rotate(leg_right_2, 0.6F, 0, 0);
    		this.animator.rotate(leg_left_3, -0.6F, 0, 0);
    		this.animator.rotate(leg_right_3, -0.6F, 0, 0);
    		this.animator.rotate(stomach, 0.4F, 0, 0);
    		this.animator.rotate(torso, 0.4F, 0, 0);
    		this.animator.rotate(hand_left_main, 0, -1.6F, 0);
    		this.animator.rotate(hand_right_main, 0, 1.6F, 0);
    		
    		this.animator.rotate(arm_left_main, -0.7F, -0.7F, -0.7F);
    		this.animator.rotate(arm_right_main, -0.7F, 0.7F, 0.7F);
    		this.animator.rotate(arm_left_2, -0.4F, 0, 0);
    		this.animator.rotate(arm_right_2, -0.4F, 0, 0);
    		
    		this.animator.rotate(left_eyelid_base, 0, 0.0F, 0);
    		this.animator.rotate(right_eyelid_base, 0, 0.0F, 0);
    		this.animator.rotate(hand_left_thumb_1, 0, 0, -0.8F);
    		this.animator.rotate(hand_left_thumb_2, 0, 0, -0.4F);
    		this.animator.rotate(hand_right_thumb_1, 0, 0, -0.8F);
    		this.animator.rotate(hand_right_thumb_2, 0, 0, -0.4F);
    		this.animator.rotate(hand_left_finger_right_1, 0, 0, 0.2F);
    		this.animator.rotate(hand_left_finger_right_2, 0, 0, 0.4F);
    		this.animator.rotate(hand_left_finger_right_3, 0, 0, 0.4F);
    		this.animator.rotate(hand_left_finger_left_1, 0, 0, 0.2F);
    		this.animator.rotate(hand_left_finger_left_2, 0, 0, 0.4F);
    		this.animator.rotate(hand_left_finger_left_3, 0, 0, 0.4F);
    		this.animator.rotate(hand_left_thumb_1, 0, 0, -0.2F);
    		this.animator.rotate(hand_left_thumb_2, 0, 0, 0.8F);
    		this.animator.rotate(hand_right_finger_right_1, 0, 0, 0.2F);
    		this.animator.rotate(hand_right_finger_right_2, 0, 0, 0.4F);
    		this.animator.rotate(hand_right_finger_right_3, 0, 0, 0.4F);
    		this.animator.rotate(hand_right_finger_left_1, 0, 0, 0.2F);
    		this.animator.rotate(hand_right_finger_left_2, 0, 0, 0.4F);
    		this.animator.rotate(hand_right_finger_left_3, 0, 0, 0.4F);
    		this.animator.rotate(hand_right_thumb_1, 0, 0, -0.2F);
    		this.animator.rotate(hand_right_thumb_2, 0, 0, 0.8F);
    		this.animator.endKeyframe();

    		this.animator.setStaticKeyframe(16);
    	}
    }
}