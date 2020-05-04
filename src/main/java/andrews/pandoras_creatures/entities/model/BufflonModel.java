package andrews.pandoras_creatures.entities.model;

import java.util.List;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import andrews.pandoras_creatures.entities.BufflonEntity;
import andrews.pandoras_creatures.registry.PCItems;
import andrews.pandoras_creatures.util.animation.Animator;
import andrews.pandoras_creatures.util.animation.PCEntityModel;
import andrews.pandoras_creatures.util.animation.PCModelRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * TestModel - andrew0030
 * Created using Tabula 7.0.0
 */
@OnlyIn(Dist.CLIENT)
public class BufflonModel<T extends BufflonEntity> extends PCEntityModel<T>
{
	public PCModelRenderer body;
    public PCModelRenderer body_top;
    public PCModelRenderer body_right;
    public PCModelRenderer body_left;
    public PCModelRenderer body_back;
    public PCModelRenderer leg_front_left_1;
    public PCModelRenderer leg_front_right_1;
    public PCModelRenderer body_bottom;
    public PCModelRenderer front_top;
    public PCModelRenderer front_seat_base;
    public PCModelRenderer back_top;
    public PCModelRenderer leg_back_right_1;
    public PCModelRenderer leg_back_left_1;
    public PCModelRenderer back_bottom;
    public PCModelRenderer storage_base;
    public PCModelRenderer back_bottom_1;
    public PCModelRenderer tail_base;
    public PCModelRenderer tail_1;
    public PCModelRenderer tail_2;
    public PCModelRenderer tail_3;
    public PCModelRenderer tail_4;
    public PCModelRenderer leg_back_right_top;
    public PCModelRenderer leg_back_right_2;
    public PCModelRenderer leg_back_right_decoration;
    public PCModelRenderer foot_back_right_base;
    public PCModelRenderer nail_back_right;
    public PCModelRenderer nail_back_right_top;
    public PCModelRenderer leg_back_left_top;
    public PCModelRenderer leg_back_left_2;
    public PCModelRenderer leg_back_right_decoration_1;
    public PCModelRenderer foot_back_left_base;
    public PCModelRenderer nail_back_left;
    public PCModelRenderer nail_back_left_top;
    public PCModelRenderer storage_holder_front_left;
    public PCModelRenderer storage_holder_back_left;
    public PCModelRenderer storage_holder_mid_left;
    public PCModelRenderer storage_holder_front_right;
    public PCModelRenderer storage_holder_back_right;
    public PCModelRenderer storage_holder_mid_right;
    public PCModelRenderer storage_base_holder_bottom;
    public PCModelRenderer seats_base;
    public PCModelRenderer smallstorage_base;
    public PCModelRenderer largestorage_base;
    public PCModelRenderer storage_strap_front_left;
    public PCModelRenderer storage_strap_back_left;
    public PCModelRenderer storage_strap_left_1;
    public PCModelRenderer storage_strap_left_holder;
    public PCModelRenderer storage_strap_left_2;
    public PCModelRenderer storage_strap_left_3;
    public PCModelRenderer storage_strap_front_right;
    public PCModelRenderer storage_strap_back_right;
    public PCModelRenderer storage_strap_right_1;
    public PCModelRenderer storage_strap_right_holder;
    public PCModelRenderer storage_strap_right_2;
    public PCModelRenderer storage_strap_right_3;
    public PCModelRenderer seats_metal_plate;
    public PCModelRenderer seats_mid_metal;
    public PCModelRenderer seats_mid_metal_back;
    public PCModelRenderer seats_main_part;
    public PCModelRenderer seats_backpart_front;
    public PCModelRenderer seats_backpart_back;
    public PCModelRenderer seats_backpart_back_front;
    public PCModelRenderer smallstorage_metal_front_left;
    public PCModelRenderer smallstorage_metal_front_right;
    public PCModelRenderer smallstorage_seat_metal;
    public PCModelRenderer smallstorage_back_support;
    public PCModelRenderer smallstorage_rod;
    public PCModelRenderer smallstorage_rod_1;
    public PCModelRenderer smallstorage_rod_2;
    public PCModelRenderer smallstorage_box_1;
    public PCModelRenderer smallstorage_box_2;
    public PCModelRenderer smallstorage_box_3;
    public PCModelRenderer smallstorage_seat_main;
    public PCModelRenderer smallstorage_back_dec;
    public PCModelRenderer smallstorage_rod_3;
    public PCModelRenderer smallstorage_rod_4;
    public PCModelRenderer smallstorage_rod_5;
    public PCModelRenderer smallstorage_rod_6;
    public PCModelRenderer smallstorage_rod_7;
    public PCModelRenderer smallstorage_rod_8;
    public PCModelRenderer smallstorage_rod_9;
    public PCModelRenderer smallstorage_rod_10;
    public PCModelRenderer smallstorage_rod_11;
    public PCModelRenderer smallstorage_box_1_dec;
    public PCModelRenderer smallstorage_box_2_dec;
    public PCModelRenderer smallstorage_box_2_dec_1;
    public PCModelRenderer smallstorage_box_2_dec_2;
    public PCModelRenderer smallstorage_box_3_dec;
    public PCModelRenderer storage_metal_front_left;
    public PCModelRenderer storage_metal_front_right;
    public PCModelRenderer storage_rod;
    public PCModelRenderer storage_rod_1;
    public PCModelRenderer storage_rod_2;
    public PCModelRenderer storage_box_1;
    public PCModelRenderer storage_box_2;
    public PCModelRenderer storage_box_3;
    public PCModelRenderer storage_metal_back_left;
    public PCModelRenderer storage_metal_back_right;
    public PCModelRenderer storage_box_4;
    public PCModelRenderer storage_box_5;
    public PCModelRenderer storage_box_6;
    public PCModelRenderer storage_rod_3;
    public PCModelRenderer storage_rod_4;
    public PCModelRenderer storage_rod_5;
    public PCModelRenderer storage_rod_6;
    public PCModelRenderer storage_rod_7;
    public PCModelRenderer storage_rod_8;
    public PCModelRenderer storage_rod_9;
    public PCModelRenderer storage_rod_10;
    public PCModelRenderer storage_rod_11;
    public PCModelRenderer storage_rod_12;
    public PCModelRenderer storage_rod_13;
    public PCModelRenderer storage_rod_14;
    public PCModelRenderer storage_rod_15;
    public PCModelRenderer storage_rod_16;
    public PCModelRenderer storage_rod_17;
    public PCModelRenderer storage_rod_18;
    public PCModelRenderer storage_rod_19;
    public PCModelRenderer storage_box_1_dec;
    public PCModelRenderer storage_box_2_dec;
    public PCModelRenderer storage_box_2_dec_1;
    public PCModelRenderer storage_box_2_dec_2;
    public PCModelRenderer storage_box_3_dec;
    public PCModelRenderer storage_box_4_dec;
    public PCModelRenderer storage_box_5_dec;
    public PCModelRenderer storage_box_5_dec_1;
    public PCModelRenderer storage_box_5_dec_2;
    public PCModelRenderer storage_box_6_dec;
    public PCModelRenderer leg_front_left_top;
    public PCModelRenderer leg_front_left_2;
    public PCModelRenderer leg_front_left_decoration;
    public PCModelRenderer foot_front_left_base;
    public PCModelRenderer nail_front_left;
    public PCModelRenderer nail_front_left_top;
    public PCModelRenderer leg_front_right_top;
    public PCModelRenderer leg_front_right_2;
    public PCModelRenderer leg_front_right_decoration;
    public PCModelRenderer foot_front_right_base;
    public PCModelRenderer nail_front_right;
    public PCModelRenderer nail_front_right_top;
    public PCModelRenderer front_bottom;
    public PCModelRenderer neck;
    public PCModelRenderer head_base;
    public PCModelRenderer head_front;
    public PCModelRenderer head_bottom;
    public PCModelRenderer horn_base_left;
    public PCModelRenderer horn_base_right;
    public PCModelRenderer head_front_decoration;
    public PCModelRenderer head_main;
    public PCModelRenderer head_main_left;
    public PCModelRenderer head_main_right;
    public PCModelRenderer head_bottom_decoration;
    public PCModelRenderer horn_left_1;
    public PCModelRenderer horn_left_2;
    public PCModelRenderer horn_right_1;
    public PCModelRenderer horn_right_2;
    public PCModelRenderer front_strap_left_1;
    public PCModelRenderer front_strap_right_1;
    public PCModelRenderer front_strap_bottom;
    public PCModelRenderer head_strap_base;
    public PCModelRenderer seat_bottom;
    public PCModelRenderer shoulder_strap_base;
    public PCModelRenderer front_strap_left_2;
    public PCModelRenderer front_holder_left;
    public PCModelRenderer front_strap_left_3;
    public PCModelRenderer front_strap_right_2;
    public PCModelRenderer front_holder_right;
    public PCModelRenderer front_strap_right_3;
    public PCModelRenderer head_strap_left_1;
    public PCModelRenderer head_strap_right_1;
    public PCModelRenderer seat_top;
    public PCModelRenderer seat_front;
    public PCModelRenderer seat_back;
    public PCModelRenderer shoulder_strap_left_1;
    public PCModelRenderer shoulder_strap_right_1;
    public PCModelRenderer shoulder_holder;
    public PCModelRenderer shoulder_strap_mid;
    
    public Animator animator = new Animator();

    public BufflonModel()
    {
    	this.textureWidth = 256;
        this.textureHeight = 256;
        this.storage_rod_6 = new PCModelRenderer(this, 46, 230);
        this.storage_rod_6.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.storage_rod_6.addBox(0.0F, -1.0F, -0.5F, 1, 1, 11, 0.0F);
        this.tail_2 = new PCModelRenderer(this, 209, 112);
        this.tail_2.setRotationPoint(0.01F, 5.0F, 0.0F);
        this.tail_2.addBox(-0.5F, 0.0F, -1.0F, 1, 5, 1, 0.0F);
        this.setRotateAngle(tail_2, -0.27314402793711257F, 0.0F, 0.0F);
        this.storage_holder_mid_right = new PCModelRenderer(this, 60, 82);
        this.storage_holder_mid_right.setRotationPoint(-7.6F, 0.5F, -12.0F);
        this.storage_holder_mid_right.addBox(-2.0F, -2.0F, -2.0F, 2, 4, 4, 0.0F);
        this.leg_front_left_decoration = new PCModelRenderer(this, 64, 40);
        this.leg_front_left_decoration.setRotationPoint(0.5F, 12.0F, -5.0F);
        this.leg_front_left_decoration.addBox(0.0F, -9.0F, 0.0F, 3, 9, 3, 0.0F);
        this.setRotateAngle(leg_front_left_decoration, 0.3490658503988659F, 0.0F, 0.0F);
        this.front_strap_right_1 = new PCModelRenderer(this, 7, 106);
        this.front_strap_right_1.setRotationPoint(-13.0F, 0.0F, 0.0F);
        this.front_strap_right_1.addBox(-1.0F, 0.0F, -1.0F, 1, 26, 2, 0.0F);
        this.storage_rod_14 = new PCModelRenderer(this, 59, 194);
        this.storage_rod_14.setRotationPoint(-3.5F, 1.0F, 11.5F);
        this.storage_rod_14.addBox(0.0F, 0.0F, -0.5F, 1, 5, 1, 0.0F);
        this.setRotateAngle(storage_rod_14, 0.0F, 3.141592653589793F, 0.0F);
        this.back_bottom_1 = new PCModelRenderer(this, 158, 106);
        this.back_bottom_1.setRotationPoint(0.01F, 10.0F, 0.0F);
        this.back_bottom_1.addBox(-7.0F, 0.0F, -3.0F, 14, 10, 3, 0.0F);
        this.setRotateAngle(back_bottom_1, -0.4886921905584123F, 0.0F, 0.0F);
        this.leg_front_right_top = new PCModelRenderer(this, 39, 0);
        this.leg_front_right_top.setRotationPoint(-4.0F, -5.0F, 0.0F);
        this.leg_front_right_top.addBox(0.0F, -6.0F, -4.0F, 4, 6, 8, 0.0F);
        this.setRotateAngle(leg_front_right_top, 0.0F, 0.0F, 0.8203047484373349F);
        this.front_holder_right = new PCModelRenderer(this, 42, 115);
        this.front_holder_right.setRotationPoint(0.4F, 9.6F, 0.0F);
        this.front_holder_right.addBox(-2.0F, -2.0F, -2.0F, 2, 4, 4, 0.0F);
        this.seats_mid_metal_back = new PCModelRenderer(this, 0, 138);
        this.seats_mid_metal_back.setRotationPoint(0.0F, -2.0F, -0.8F);
        this.seats_mid_metal_back.addBox(-4.5F, -5.0F, -1.0F, 9, 5, 1, 0.0F);
        this.storage_rod_10 = new PCModelRenderer(this, 44, 201);
        this.storage_rod_10.setRotationPoint(-17.0F, 0.0F, 0.0F);
        this.storage_rod_10.addBox(0.0F, -5.0F, -0.5F, 1, 5, 1, 0.0F);
        this.head_main_right = new PCModelRenderer(this, 133, 193);
        this.head_main_right.setRotationPoint(-4.5F, 1.0F, 0.0F);
        this.head_main_right.addBox(0.0F, 0.0F, 0.0F, 3, 4, 7, 0.0F);
        this.setRotateAngle(head_main_right, 0.0F, 0.0F, -0.8639379797371932F);
        this.storage_strap_back_left = new PCModelRenderer(this, 130, 59);
        this.storage_strap_back_left.setRotationPoint(0.0F, 2.0F, 1.6F);
        this.storage_strap_back_left.addBox(0.4F, 0.0F, -2.0F, 1, 11, 2, 0.0F);
        this.setRotateAngle(storage_strap_back_left, -0.9075712110370513F, 0.0F, 0.0F);
        this.horn_left_2 = new PCModelRenderer(this, 235, 240);
        this.horn_left_2.setRotationPoint(6.0F, 0.01F, 0.0F);
        this.horn_left_2.addBox(0.0F, -1.5F, -3.0F, 7, 3, 3, 0.0F);
        this.setRotateAngle(horn_left_2, 0.0F, 0.6370451769779303F, 0.0F);
        this.tail_1 = new PCModelRenderer(this, 204, 112);
        this.tail_1.setRotationPoint(0.0F, 0.5F, 1.0F);
        this.tail_1.addBox(-0.5F, 0.0F, -1.0F, 1, 5, 1, 0.0F);
        this.setRotateAngle(tail_1, 0.40142572795869574F, 0.0F, 0.0F);
        this.leg_back_left_top = new PCModelRenderer(this, 103, 0);
        this.leg_back_left_top.setRotationPoint(-3.0F, -4.0F, 0.0F);
        this.leg_back_left_top.addBox(0.0F, -5.0F, -3.0F, 3, 5, 6, 0.0F);
        this.setRotateAngle(leg_back_left_top, 0.0F, 0.0F, 0.6981317007977318F);
        this.back_bottom = new PCModelRenderer(this, 175, 169);
        this.back_bottom.setRotationPoint(0.0F, 20.8F, 30.0F);
        this.back_bottom.addBox(-6.0F, 0.0F, -30.0F, 12, 5, 28, 0.0F);
        this.storage_metal_front_left = new PCModelRenderer(this, 0, 194);
        this.storage_metal_front_left.setRotationPoint(4.0F, 0.7F, -23.2F);
        this.storage_metal_front_left.addBox(-1.5F, -2.0F, -1.0F, 3, 2, 2, 0.0F);
        this.storage_holder_mid_left = new PCModelRenderer(this, 60, 73);
        this.storage_holder_mid_left.setRotationPoint(7.6F, 0.5F, -12.0F);
        this.storage_holder_mid_left.addBox(0.0F, -2.0F, -2.0F, 2, 4, 4, 0.0F);
        this.front_strap_bottom = new PCModelRenderer(this, 20, 125);
        this.front_strap_bottom.setRotationPoint(0.0F, 30.4F, 0.0F);
        this.front_strap_bottom.addBox(-2.0F, 0.0F, -2.0F, 4, 2, 4, 0.0F);
        this.head_strap_base = new PCModelRenderer(this, 0, 98);
        this.head_strap_base.setRotationPoint(0.0F, 0.9F, -15.0F);
        this.head_strap_base.addBox(-14.0F, 0.0F, -1.0F, 28, 2, 1, 0.0F);
        this.setRotateAngle(head_strap_base, -0.5235987755982988F, 0.0F, 0.0F);
        this.seat_top = new PCModelRenderer(this, 0, 77);
        this.seat_top.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.seat_top.addBox(-4.0F, -1.0F, -15.0F, 8, 1, 15, 0.0F);
        this.nail_back_left_top = new PCModelRenderer(this, 98, 42);
        this.nail_back_left_top.setRotationPoint(-0.01F, 0.0F, -1.0F);
        this.nail_back_left_top.addBox(-1.5F, -2.0F, 0.0F, 3, 2, 1, 0.0F);
        this.setRotateAngle(nail_back_left_top, -0.5009094953223726F, 0.0F, 0.0F);
        this.storage_box_4_dec = new PCModelRenderer(this, 25, 222);
        this.storage_box_4_dec.setRotationPoint(1.5F, -2.8F, 0.0F);
        this.storage_box_4_dec.addBox(0.0F, -1.5F, -0.5F, 1, 2, 1, 0.0F);
        this.smallstorage_rod = new PCModelRenderer(this, 141, 100);
        this.smallstorage_rod.setRotationPoint(8.0F, -0.5F, -12.0F);
        this.smallstorage_rod.addBox(0.0F, -5.0F, -0.5F, 1, 5, 1, 0.0F);
        this.smallstorage_box_2_dec = new PCModelRenderer(this, 0, 178);
        this.smallstorage_box_2_dec.setRotationPoint(0.01F, -2.3F, 0.0F);
        this.smallstorage_box_2_dec.addBox(-2.5F, -1.0F, -2.0F, 5, 1, 4, 0.0F);
        this.head_main = new PCModelRenderer(this, 194, 203);
        this.head_main.setRotationPoint(0.0F, 8.0F, 5.0F);
        this.head_main.addBox(-4.5F, -8.0F, 0.0F, 9, 9, 7, 0.0F);
        this.horn_base_left = new PCModelRenderer(this, 245, 224);
        this.horn_base_left.setRotationPoint(7.0F, 4.0F, -1.0F);
        this.horn_base_left.addBox(0.0F, -2.0F, -2.0F, 1, 4, 4, 0.0F);
        this.setRotateAngle(horn_base_left, 0.6283185307179586F, 0.0F, 0.0F);
        this.front_strap_left_1 = new PCModelRenderer(this, 0, 106);
        this.front_strap_left_1.setRotationPoint(13.0F, 0.0F, 0.0F);
        this.front_strap_left_1.addBox(0.0F, 0.0F, -1.0F, 1, 26, 2, 0.0F);
        this.smallstorage_rod_6 = new PCModelRenderer(this, 112, 111);
        this.smallstorage_rod_6.setRotationPoint(4.5F, 0.0F, -11.0F);
        this.smallstorage_rod_6.addBox(0.0F, 0.0F, -0.5F, 1, 5, 1, 0.0F);
        this.storage_box_6 = new PCModelRenderer(this, 19, 246);
        this.storage_box_6.setRotationPoint(-2.0F, -1.0F, -4.0F);
        this.storage_box_6.addBox(-1.5F, -4.0F, -3.0F, 3, 4, 6, 0.0F);
        this.setRotateAngle(storage_box_6, 0.0F, 1.3658946726107624F, 0.0F);
        this.storage_strap_front_left = new PCModelRenderer(this, 123, 59);
        this.storage_strap_front_left.setRotationPoint(0.0F, 2.0F, -1.6F);
        this.storage_strap_front_left.addBox(0.4F, 0.0F, 0.0F, 1, 11, 2, 0.0F);
        this.setRotateAngle(storage_strap_front_left, 0.9075712110370513F, 0.0F, 0.0F);
        this.front_strap_left_2 = new PCModelRenderer(this, 14, 106);
        this.front_strap_left_2.setRotationPoint(1.0F, 26.0F, 0.01F);
        this.front_strap_left_2.addBox(-1.0F, 0.0F, -1.0F, 1, 7, 2, 0.0F);
        this.setRotateAngle(front_strap_left_2, 0.0F, 0.0F, 0.5759586531581287F);
        this.foot_back_right_base = new PCModelRenderer(this, 129, 50);
        this.foot_back_right_base.setRotationPoint(1.5F, 11.0F, 0.0F);
        this.foot_back_right_base.addBox(-2.0F, 0.0F, -0.5F, 4, 3, 5, 0.0F);
        this.setRotateAngle(foot_back_right_base, -0.17453292519943295F, 0.0F, 0.0F);
        this.storage_base = new PCModelRenderer(this, 62, 73);
        this.storage_base.setRotationPoint(0.0F, 0.0F, 29.0F);
        this.storage_base.addBox(-9.0F, -1.0F, -24.0F, 18, 1, 24, 0.0F);
        this.storage_strap_left_holder = new PCModelRenderer(this, 96, 64);
        this.storage_strap_left_holder.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.storage_strap_left_holder.addBox(0.0F, -2.0F, -2.0F, 2, 4, 4, 0.0F);
        this.body_right = new PCModelRenderer(this, 214, 110);
        this.body_right.setRotationPoint(-12.0F, 15.0F, 0.0F);
        this.body_right.addBox(0.0F, -9.0F, 0.0F, 5, 18, 10, 0.0F);
        this.setRotateAngle(body_right, 0.0F, 0.45378560551852565F, 0.0F);
        this.largestorage_base = new PCModelRenderer(this, 0, 144);
        this.largestorage_base.setRotationPoint(0.0F, -0.3F, 0.0F);
        this.largestorage_base.addBox(-8.5F, -1.0F, -23.5F, 17, 1, 23, 0.0F);
        this.storage_box_2_dec_1 = new PCModelRenderer(this, 16, 240);
        this.storage_box_2_dec_1.setRotationPoint(1.8F, -3.0F, -2.1F);
        this.storage_box_2_dec_1.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.shoulder_strap_left_1 = new PCModelRenderer(this, 22, 123);
        this.shoulder_strap_left_1.setRotationPoint(14.0F, 1.0F, 0.0F);
        this.shoulder_strap_left_1.addBox(-1.0F, -1.0F, 0.0F, 1, 2, 15, 0.0F);
        this.body = new PCModelRenderer(this, 151, 0);
        this.body.setRotationPoint(0.0F, -19.6F, 0.0F);
        this.body.addBox(-13.0F, 0.0F, -26.0F, 26, 26, 26, 0.0F);
        this.front_bottom = new PCModelRenderer(this, 125, 138);
        this.front_bottom.setRotationPoint(0.01F, 10.0F, 0.0F);
        this.front_bottom.addBox(-12.5F, 0.0F, 0.0F, 25, 16, 7, 0.0F);
        this.setRotateAngle(front_bottom, 0.9075712110370513F, 0.0F, 0.0F);
        this.storage_strap_right_3 = new PCModelRenderer(this, 65, 121);
        this.storage_strap_right_3.setRotationPoint(0.0F, 6.0F, 0.01F);
        this.storage_strap_right_3.addBox(0.0F, 0.0F, -1.0F, 1, 6, 2, 0.0F);
        this.setRotateAngle(storage_strap_right_3, 0.0F, 0.0F, -1.1693705988362009F);
        this.seats_metal_plate = new PCModelRenderer(this, 0, 169);
        this.seats_metal_plate.setRotationPoint(0.0F, -1.0F, -0.5F);
        this.seats_metal_plate.addBox(-5.0F, -1.0F, -23.0F, 10, 1, 23, 0.0F);
        this.smallstorage_box_3 = new PCModelRenderer(this, 140, 86);
        this.smallstorage_box_3.setRotationPoint(1.9F, -1.0F, -15.3F);
        this.smallstorage_box_3.addBox(-2.0F, -4.0F, -3.0F, 3, 4, 6, 0.0F);
        this.setRotateAngle(smallstorage_box_3, 0.0F, 1.6580627893946132F, 0.0F);
        this.storage_box_6_dec = new PCModelRenderer(this, 32, 249);
        this.storage_box_6_dec.setRotationPoint(0.9F, -2.1F, 0.0F);
        this.storage_box_6_dec.addBox(0.0F, -1.5F, -0.5F, 1, 1, 1, 0.0F);
        this.storage_rod_4 = new PCModelRenderer(this, 44, 194);
        this.storage_rod_4.setRotationPoint(0.0F, 0.0F, -9.0F);
        this.storage_rod_4.addBox(0.0F, -5.0F, -0.5F, 1, 5, 1, 0.0F);
        this.leg_back_right_decoration = new PCModelRenderer(this, 122, 32);
        this.leg_back_right_decoration.setRotationPoint(0.5F, 8.0F, 4.0F);
        this.leg_back_right_decoration.addBox(0.0F, -6.0F, -3.0F, 2, 6, 3, 0.0F);
        this.setRotateAngle(leg_back_right_decoration, -0.3141592653589793F, 0.0F, 0.0F);
        this.nail_back_right_top = new PCModelRenderer(this, 124, 42);
        this.nail_back_right_top.setRotationPoint(-0.01F, 0.0F, -1.0F);
        this.nail_back_right_top.addBox(-1.5F, -2.0F, 0.0F, 3, 2, 1, 0.0F);
        this.setRotateAngle(nail_back_right_top, -0.5009094953223726F, 0.0F, 0.0F);
        this.smallstorage_metal_front_right = new PCModelRenderer(this, 107, 104);
        this.smallstorage_metal_front_right.setRotationPoint(-4.0F, 0.7F, -23.2F);
        this.smallstorage_metal_front_right.addBox(-1.5F, -2.0F, -1.0F, 3, 2, 2, 0.0F);
        this.seats_main_part = new PCModelRenderer(this, 0, 194);
        this.seats_main_part.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.seats_main_part.addBox(-4.0F, -1.0F, -22.5F, 8, 1, 22, 0.0F);
        this.storage_strap_right_1 = new PCModelRenderer(this, 66, 99);
        this.storage_strap_right_1.setRotationPoint(0.0F, 1.5F, 0.0F);
        this.storage_strap_right_1.addBox(-1.4F, 0.0F, -1.0F, 1, 19, 2, 0.0F);
        this.smallstorage_rod_9 = new PCModelRenderer(this, 78, 132);
        this.smallstorage_rod_9.setRotationPoint(17.0F, 0.0F, -0.5F);
        this.smallstorage_rod_9.addBox(0.0F, 0.0F, 0.0F, 1, 1, 10, 0.0F);
        this.seats_backpart_back = new PCModelRenderer(this, 0, 151);
        this.seats_backpart_back.setRotationPoint(0.0F, -4.5F, 0.3F);
        this.seats_backpart_back.addBox(-3.5F, 0.0F, -1.0F, 7, 4, 1, 0.0F);
        this.setRotateAngle(seats_backpart_back, 0.20943951023931953F, 0.0F, 0.0F);
        this.smallstorage_rod_11 = new PCModelRenderer(this, 73, 123);
        this.smallstorage_rod_11.setRotationPoint(0.0F, -5.0F, -2.0F);
        this.smallstorage_rod_11.addBox(0.0F, -1.0F, -0.5F, 18, 1, 1, 0.0F);
        this.front_strap_left_3 = new PCModelRenderer(this, 28, 106);
        this.front_strap_left_3.setRotationPoint(0.0F, 7.0F, 0.01F);
        this.front_strap_left_3.addBox(-1.0F, 0.0F, -1.0F, 1, 9, 2, 0.0F);
        this.setRotateAngle(front_strap_left_3, 0.0F, 0.0F, 0.9948376736367678F);
        this.shoulder_strap_right_1 = new PCModelRenderer(this, 60, 129);
        this.shoulder_strap_right_1.setRotationPoint(-14.0F, 1.0F, 0.0F);
        this.shoulder_strap_right_1.addBox(0.0F, -1.0F, 0.0F, 1, 2, 15, 0.0F);
        this.storage_rod_13 = new PCModelRenderer(this, 44, 172);
        this.storage_rod_13.setRotationPoint(-11.5F, 1.0F, 22.0F);
        this.storage_rod_13.addBox(-12.5F, -1.0F, 0.0F, 18, 1, 1, 0.0F);
        this.setRotateAngle(storage_rod_13, 0.0F, 3.141592653589793F, 0.0F);
        this.storage_strap_left_2 = new PCModelRenderer(this, 73, 99);
        this.storage_strap_left_2.setRotationPoint(1.4F, 19.0F, 0.01F);
        this.storage_strap_left_2.addBox(-1.0F, 0.0F, -1.0F, 1, 6, 2, 0.0F);
        this.setRotateAngle(storage_strap_left_2, 0.0F, 0.0F, 0.40142572795869574F);
        this.storage_box_3 = new PCModelRenderer(this, 0, 246);
        this.storage_box_3.setRotationPoint(1.9F, -1.0F, -14.1F);
        this.storage_box_3.addBox(-2.0F, -4.0F, -3.0F, 3, 4, 6, 0.0F);
        this.setRotateAngle(storage_box_3, 0.0F, -1.6580627893946132F, 0.0F);
        this.head_front_decoration = new PCModelRenderer(this, 228, 169);
        this.head_front_decoration.setRotationPoint(0.0F, 8.0F, 1.0F);
        this.head_front_decoration.addBox(-2.5F, 0.0F, 0.0F, 5, 9, 2, 0.0F);
        this.setRotateAngle(head_front_decoration, 0.8377580409572781F, 0.0F, 0.0F);
        this.storage_holder_front_right = new PCModelRenderer(this, 73, 82);
        this.storage_holder_front_right.setRotationPoint(-7.6F, 0.5F, -21.0F);
        this.storage_holder_front_right.addBox(-2.0F, -2.0F, -2.0F, 2, 4, 4, 0.0F);
        this.neck = new PCModelRenderer(this, 166, 169);
        this.neck.setRotationPoint(0.0F, 14.0F, 0.0F);
        this.neck.addBox(-5.0F, -12.0F, -8.0F, 10, 12, 8, 0.0F);
        this.setRotateAngle(neck, -0.391826417072727F, 0.0F, 0.0F);
        this.nail_front_left_top = new PCModelRenderer(this, 66, 53);
        this.nail_front_left_top.setRotationPoint(-0.01F, 0.0F, -1.0F);
        this.nail_front_left_top.addBox(-1.5F, -2.0F, 0.0F, 4, 2, 1, 0.0F);
        this.setRotateAngle(nail_front_left_top, -0.5009094953223726F, 0.0F, 0.0F);
        this.storage_rod_7 = new PCModelRenderer(this, 39, 201);
        this.storage_rod_7.setRotationPoint(4.5F, 0.0F, -11.0F);
        this.storage_rod_7.addBox(0.0F, 0.0F, -0.5F, 1, 5, 1, 0.0F);
        this.body_bottom = new PCModelRenderer(this, 167, 139);
        this.body_bottom.setRotationPoint(0.0F, 26.0F, 0.0F);
        this.body_bottom.addBox(-10.0F, 0.0F, -24.0F, 20, 5, 24, 0.0F);
        this.storage_box_5_dec_1 = new PCModelRenderer(this, 40, 242);
        this.storage_box_5_dec_1.setRotationPoint(1.8F, -3.0F, -2.1F);
        this.storage_box_5_dec_1.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.head_base = new PCModelRenderer(this, 121, 162);
        this.head_base.setRotationPoint(0.0F, -12.4F, -5.0F);
        this.head_base.addBox(-7.0F, 0.0F, -5.0F, 14, 8, 8, 0.0F);
        this.setRotateAngle(head_base, -0.33283428835531864F, 0.0F, 0.0F);
        this.storage_box_2_dec_2 = new PCModelRenderer(this, 15, 233);
        this.storage_box_2_dec_2.setRotationPoint(-1.8F, -3.0F, -2.1F);
        this.storage_box_2_dec_2.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.smallstorage_base = new PCModelRenderer(this, 0, 144);
        this.smallstorage_base.setRotationPoint(0.0F, -0.3F, -24.0F);
        this.smallstorage_base.addBox(-8.5F, -1.0F, -23.5F, 17, 1, 23, 0.0F);
        this.setRotateAngle(smallstorage_base, 0.0F, 3.141592653589793F, 0.0F);
        this.smallstorage_rod_8 = new PCModelRenderer(this, 91, 130);
        this.smallstorage_rod_8.setRotationPoint(-4.5F, -1.0F, 1.0F);
        this.smallstorage_rod_8.addBox(0.0F, 0.0F, -0.5F, 1, 1, 10, 0.0F);
        this.smallstorage_box_2_dec_1 = new PCModelRenderer(this, 0, 184);
        this.smallstorage_box_2_dec_1.setRotationPoint(1.8F, -3.0F, -2.1F);
        this.smallstorage_box_2_dec_1.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.storage_holder_back_left = new PCModelRenderer(this, 47, 73);
        this.storage_holder_back_left.setRotationPoint(7.6F, 0.5F, -3.0F);
        this.storage_holder_back_left.addBox(0.0F, -2.0F, -2.0F, 2, 4, 4, 0.0F);
        this.storage_rod = new PCModelRenderer(this, 49, 194);
        this.storage_rod.setRotationPoint(8.0F, -0.5F, -12.0F);
        this.storage_rod.addBox(0.0F, -5.0F, -0.5F, 1, 5, 1, 0.0F);
        this.storage_box_5 = new PCModelRenderer(this, 25, 232);
        this.storage_box_5.setRotationPoint(-4.0F, -1.0F, -10.0F);
        this.storage_box_5.addBox(-2.5F, -3.0F, -2.5F, 5, 3, 5, 0.0F);
        this.setRotateAngle(storage_box_5, 0.0F, 1.7756979809790308F, 0.0F);
        this.seats_mid_metal = new PCModelRenderer(this, 0, 138);
        this.seats_mid_metal.setRotationPoint(0.0F, -2.0F, -12.0F);
        this.seats_mid_metal.addBox(-4.5F, -5.0F, -1.0F, 9, 5, 1, 0.0F);
        this.smallstorage_rod_3 = new PCModelRenderer(this, 151, 100);
        this.smallstorage_rod_3.setRotationPoint(-17.0F, 0.0F, 0.0F);
        this.smallstorage_rod_3.addBox(0.0F, -5.0F, -0.5F, 1, 5, 1, 0.0F);
        this.front_holder_left = new PCModelRenderer(this, 42, 106);
        this.front_holder_left.setRotationPoint(-0.4F, 9.6F, 0.0F);
        this.front_holder_left.addBox(0.0F, -2.0F, -2.0F, 2, 4, 4, 0.0F);
        this.head_strap_right_1 = new PCModelRenderer(this, 38, 124);
        this.head_strap_right_1.setRotationPoint(-14.0F, 1.0F, 0.0F);
        this.head_strap_right_1.addBox(0.0F, -1.0F, 0.0F, 1, 2, 17, 0.0F);
        this.smallstorage_box_1_dec = new PCModelRenderer(this, 47, 182);
        this.smallstorage_box_1_dec.setRotationPoint(1.5F, -2.8F, 0.0F);
        this.smallstorage_box_1_dec.addBox(0.0F, -1.5F, -0.5F, 1, 2, 1, 0.0F);
        this.head_bottom = new PCModelRenderer(this, 227, 203);
        this.head_bottom.setRotationPoint(0.0F, 8.0F, 0.0F);
        this.head_bottom.addBox(-3.0F, 0.0F, -6.0F, 6, 12, 8, 0.0F);
        this.storage_metal_front_right = new PCModelRenderer(this, 0, 199);
        this.storage_metal_front_right.setRotationPoint(-4.0F, 0.7F, -23.2F);
        this.storage_metal_front_right.addBox(-1.5F, -2.0F, -1.0F, 3, 2, 2, 0.0F);
        this.smallstorage_seat_metal = new PCModelRenderer(this, 115, 107);
        this.smallstorage_seat_metal.setRotationPoint(0.0F, -1.0F, -1.0F);
        this.smallstorage_seat_metal.addBox(-5.0F, -1.0F, -11.0F, 10, 1, 11, 0.0F);
        this.storage_rod_17 = new PCModelRenderer(this, 54, 194);
        this.storage_rod_17.setRotationPoint(-17.0F, 0.0F, 0.0F);
        this.storage_rod_17.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1, 0.0F);
        this.tail_3 = new PCModelRenderer(this, 213, 106);
        this.tail_3.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.tail_3.addBox(-0.5F, 0.0F, -1.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(tail_3, -0.18430676901060122F, 0.0F, 0.0F);
        this.smallstorage_rod_10 = new PCModelRenderer(this, 146, 100);
        this.smallstorage_rod_10.setRotationPoint(-17.0F, 0.0F, 0.0F);
        this.smallstorage_rod_10.addBox(0.0F, -5.0F, -0.5F, 1, 5, 1, 0.0F);
        this.storage_box_4 = new PCModelRenderer(this, 25, 218);
        this.storage_box_4.setRotationPoint(4.4F, -1.0F, -8.0F);
        this.storage_box_4.addBox(-2.0F, -5.0F, -4.0F, 4, 5, 8, 0.0F);
        this.setRotateAngle(storage_box_4, 0.0F, 3.050486466635689F, 0.0F);
        this.storage_rod_18 = new PCModelRenderer(this, 64, 245);
        this.storage_rod_18.setRotationPoint(0.02F, 0.0F, 9.0F);
        this.storage_rod_18.addBox(0.0F, 0.0F, -9.5F, 1, 1, 10, 0.0F);
        this.setRotateAngle(storage_rod_18, 0.41015237421866746F, 0.0F, 0.0F);
        this.horn_right_1 = new PCModelRenderer(this, 216, 233);
        this.horn_right_1.setRotationPoint(-0.8F, 0.0F, 2.0F);
        this.horn_right_1.addBox(-6.0F, -1.5F, -3.0F, 6, 3, 3, 0.0F);
        this.setRotateAngle(horn_right_1, 0.0F, -0.6370451769779303F, 0.0F);
        this.smallstorage_back_dec = new PCModelRenderer(this, 126, 101);
        this.smallstorage_back_dec.setRotationPoint(0.0F, -5.0F, 2.3F);
        this.smallstorage_back_dec.addBox(-3.0F, 0.0F, -1.0F, 6, 4, 1, 0.0F);
        this.setRotateAngle(smallstorage_back_dec, 0.20943951023931953F, 0.0F, 0.0F);
        this.nail_front_right = new PCModelRenderer(this, 34, 57);
        this.nail_front_right.setRotationPoint(-0.5F, 2.0F, -6.0F);
        this.nail_front_right.addBox(-1.5F, 0.0F, -1.0F, 4, 1, 1, 0.0F);
        this.front_strap_right_3 = new PCModelRenderer(this, 35, 106);
        this.front_strap_right_3.setRotationPoint(0.0F, 7.0F, 0.01F);
        this.front_strap_right_3.addBox(0.0F, 0.0F, -1.0F, 1, 9, 2, 0.0F);
        this.setRotateAngle(front_strap_right_3, 0.0F, 0.0F, -0.9948376736367678F);
        this.leg_back_right_top = new PCModelRenderer(this, 126, 0);
        this.leg_back_right_top.setRotationPoint(3.0F, -4.0F, 0.0F);
        this.leg_back_right_top.addBox(-3.0F, -5.0F, -3.0F, 3, 5, 6, 0.0F);
        this.setRotateAngle(leg_back_right_top, 0.0F, 0.0F, -0.6981317007977318F);
        this.leg_front_left_2 = new PCModelRenderer(this, 77, 40);
        this.leg_front_left_2.setRotationPoint(0.5F, 9.0F, 4.0F);
        this.leg_front_left_2.addBox(0.0F, 0.0F, -5.0F, 4, 16, 5, 0.0F);
        this.setRotateAngle(leg_front_left_2, -0.8726646259971648F, 0.0F, 0.0F);
        this.seats_base = new PCModelRenderer(this, 0, 144);
        this.seats_base.setRotationPoint(0.0F, -0.3F, 0.0F);
        this.seats_base.addBox(-8.5F, -1.0F, -23.5F, 17, 1, 23, 0.0F);
        this.leg_front_left_1 = new PCModelRenderer(this, 65, 15);
        this.leg_front_left_1.setRotationPoint(13.0F, 22.0F, -18.0F);
        this.leg_front_left_1.addBox(0.0F, -5.0F, -5.0F, 5, 14, 10, 0.0F);
        this.setRotateAngle(leg_front_left_1, 0.5061454830783556F, 0.0F, 0.0F);
        this.storage_holder_front_left = new PCModelRenderer(this, 73, 73);
        this.storage_holder_front_left.setRotationPoint(7.6F, 0.5F, -21.0F);
        this.storage_holder_front_left.addBox(0.0F, -2.0F, -2.0F, 2, 4, 4, 0.0F);
        this.storage_rod_2 = new PCModelRenderer(this, 51, 243);
        this.storage_rod_2.setRotationPoint(-7.99F, -5.5F, -12.5F);
        this.storage_rod_2.addBox(-1.0F, 0.0F, -9.5F, 1, 1, 10, 0.0F);
        this.setRotateAngle(storage_rod_2, 0.41015237421866746F, 0.0F, 0.0F);
        this.storage_rod_5 = new PCModelRenderer(this, 50, 218);
        this.storage_rod_5.setRotationPoint(0.0F, -6.0F, -10.5F);
        this.storage_rod_5.addBox(0.0F, 0.0F, 0.0F, 1, 1, 10, 0.0F);
        this.storage_box_2_dec = new PCModelRenderer(this, 0, 232);
        this.storage_box_2_dec.setRotationPoint(0.01F, -2.3F, 0.0F);
        this.storage_box_2_dec.addBox(-2.5F, -1.0F, -2.0F, 5, 1, 4, 0.0F);
        this.storage_box_2 = new PCModelRenderer(this, 0, 238);
        this.storage_box_2.setRotationPoint(2.5F, -1.0F, -19.5F);
        this.storage_box_2.addBox(-2.5F, -3.0F, -2.5F, 5, 3, 5, 0.0F);
        this.setRotateAngle(storage_box_2, 0.0F, 0.08726646259971647F, 0.0F);
        this.storage_strap_right_2 = new PCModelRenderer(this, 73, 108);
        this.storage_strap_right_2.setRotationPoint(-1.4F, 19.0F, 0.01F);
        this.storage_strap_right_2.addBox(0.0F, 0.0F, -1.0F, 1, 6, 2, 0.0F);
        this.setRotateAngle(storage_strap_right_2, 0.0F, 0.0F, -0.40142572795869574F);
        this.horn_left_1 = new PCModelRenderer(this, 237, 233);
        this.horn_left_1.setRotationPoint(0.8F, 0.0F, 2.0F);
        this.horn_left_1.addBox(0.0F, -1.5F, -3.0F, 6, 3, 3, 0.0F);
        this.setRotateAngle(horn_left_1, 0.0F, 0.6370451769779303F, 0.0F);
        this.head_main_left = new PCModelRenderer(this, 154, 193);
        this.head_main_left.setRotationPoint(4.5F, 1.0F, 0.0F);
        this.head_main_left.addBox(-3.0F, 0.0F, 0.0F, 3, 4, 7, 0.0F);
        this.setRotateAngle(head_main_left, 0.0F, 0.0F, 0.8639379797371932F);
        this.leg_back_right_1 = new PCModelRenderer(this, 123, 12);
        this.leg_back_right_1.setRotationPoint(8.0F, 18.0F, 24.0F);
        this.leg_back_right_1.addBox(0.0F, -4.0F, -4.0F, 4, 11, 8, 0.0F);
        this.setRotateAngle(leg_back_right_1, -0.17453292519943295F, 0.0F, 0.0F);
        this.smallstorage_rod_2 = new PCModelRenderer(this, 81, 147);
        this.smallstorage_rod_2.setRotationPoint(-7.99F, -5.5F, -12.5F);
        this.smallstorage_rod_2.addBox(-1.0F, 0.0F, -9.5F, 1, 1, 10, 0.0F);
        this.setRotateAngle(smallstorage_rod_2, 0.41015237421866746F, 0.0F, 0.0F);
        this.storage_rod_8 = new PCModelRenderer(this, 39, 194);
        this.storage_rod_8.setRotationPoint(8.0F, 0.0F, -0.5F);
        this.storage_rod_8.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1, 0.0F);
        this.nail_back_right = new PCModelRenderer(this, 124, 46);
        this.nail_back_right.setRotationPoint(0.0F, 2.0F, -0.5F);
        this.nail_back_right.addBox(-1.5F, 0.0F, -1.0F, 3, 1, 1, 0.0F);
        this.smallstorage_metal_front_left = new PCModelRenderer(this, 107, 99);
        this.smallstorage_metal_front_left.setRotationPoint(4.0F, 0.7F, -23.2F);
        this.smallstorage_metal_front_left.addBox(-1.5F, -2.0F, -1.0F, 3, 2, 2, 0.0F);
        this.storage_box_3_dec = new PCModelRenderer(this, 0, 249);
        this.storage_box_3_dec.setRotationPoint(0.4F, -2.1F, 0.0F);
        this.storage_box_3_dec.addBox(0.0F, -1.5F, -0.5F, 1, 1, 1, 0.0F);
        this.storage_strap_left_3 = new PCModelRenderer(this, 58, 121);
        this.storage_strap_left_3.setRotationPoint(0.0F, 6.0F, 0.01F);
        this.storage_strap_left_3.addBox(-1.0F, 0.0F, -1.0F, 1, 6, 2, 0.0F);
        this.setRotateAngle(storage_strap_left_3, 0.0F, 0.0F, 1.1693705988362009F);
        this.storage_rod_16 = new PCModelRenderer(this, 54, 201);
        this.storage_rod_16.setRotationPoint(4.5F, 0.0F, 2.0F);
        this.storage_rod_16.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1, 0.0F);
        this.front_seat_base = new PCModelRenderer(this, 0, 94);
        this.front_seat_base.setRotationPoint(0.0F, 0.0F, -11.0F);
        this.front_seat_base.addBox(-14.0F, -1.0F, -1.0F, 28, 1, 2, 0.0F);
        this.foot_front_left_base = new PCModelRenderer(this, 71, 62);
        this.foot_front_left_base.setRotationPoint(2.0F, 13.5F, 0.0F);
        this.foot_front_left_base.addBox(-2.5F, 0.0F, -6.0F, 5, 3, 7, 0.0F);
        this.setRotateAngle(foot_front_left_base, 0.33161255787892263F, 0.0F, 0.0F);
        this.smallstorage_box_1 = new PCModelRenderer(this, 44, 178);
        this.smallstorage_box_1.setRotationPoint(-4.5F, -1.0F, -17.5F);
        this.smallstorage_box_1.addBox(-2.0F, -5.0F, -4.0F, 4, 5, 8, 0.0F);
        this.setRotateAngle(smallstorage_box_1, 0.0F, -0.18203784098300857F, 0.0F);
        this.body_back = new PCModelRenderer(this, 163, 54);
        this.body_back.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.body_back.addBox(-8.0F, 0.0F, 0.0F, 16, 21, 30, 0.0F);
        this.setRotateAngle(body_back, -0.08726646259971647F, 0.0F, 0.0F);
        this.smallstorage_box_2 = new PCModelRenderer(this, 0, 169);
        this.smallstorage_box_2.setRotationPoint(2.5F, -1.0F, -19.5F);
        this.smallstorage_box_2.addBox(-2.5F, -3.0F, -2.5F, 5, 3, 5, 0.0F);
        this.setRotateAngle(smallstorage_box_2, 0.0F, 0.08726646259971647F, 0.0F);
        this.storage_rod_1 = new PCModelRenderer(this, 38, 245);
        this.storage_rod_1.setRotationPoint(7.99F, -5.5F, -12.5F);
        this.storage_rod_1.addBox(0.0F, 0.0F, -9.5F, 1, 1, 10, 0.0F);
        this.setRotateAngle(storage_rod_1, 0.41015237421866746F, 0.0F, 0.0F);
        this.storage_rod_3 = new PCModelRenderer(this, 49, 201);
        this.storage_rod_3.setRotationPoint(-17.0F, 0.0F, 0.0F);
        this.storage_rod_3.addBox(0.0F, -5.0F, -0.5F, 1, 5, 1, 0.0F);
        this.leg_front_left_top = new PCModelRenderer(this, 71, 0);
        this.leg_front_left_top.setRotationPoint(4.0F, -5.0F, 0.0F);
        this.leg_front_left_top.addBox(-4.0F, -6.0F, -4.0F, 4, 6, 8, 0.0F);
        this.setRotateAngle(leg_front_left_top, 0.0F, 0.0F, -0.8203047484373349F);
        this.storage_base_holder_bottom = new PCModelRenderer(this, 123, 90);
        this.storage_base_holder_bottom.setRotationPoint(0.0F, 25.1F, -12.0F);
        this.storage_base_holder_bottom.addBox(-2.0F, 0.0F, -2.0F, 4, 2, 4, 0.0F);
        this.leg_front_right_2 = new PCModelRenderer(this, 45, 40);
        this.leg_front_right_2.setRotationPoint(-0.5F, 9.0F, 4.0F);
        this.leg_front_right_2.addBox(-4.0F, 0.0F, -5.0F, 4, 16, 5, 0.0F);
        this.setRotateAngle(leg_front_right_2, -0.8726646259971648F, 0.0F, 0.0F);
        this.foot_front_right_base = new PCModelRenderer(this, 39, 62);
        this.foot_front_right_base.setRotationPoint(-2.0F, 13.5F, 0.0F);
        this.foot_front_right_base.addBox(-2.5F, 0.0F, -6.0F, 5, 3, 7, 0.0F);
        this.setRotateAngle(foot_front_right_base, 0.33161255787892263F, 0.0F, 0.0F);
        this.smallstorage_rod_1 = new PCModelRenderer(this, 58, 147);
        this.smallstorage_rod_1.setRotationPoint(7.99F, -5.5F, -12.5F);
        this.smallstorage_rod_1.addBox(0.0F, 0.0F, -9.5F, 1, 1, 10, 0.0F);
        this.setRotateAngle(smallstorage_rod_1, 0.41015237421866746F, 0.0F, 0.0F);
        this.storage_metal_back_left = new PCModelRenderer(this, 0, 204);
        this.storage_metal_back_left.setRotationPoint(4.0F, 0.7F, -0.8F);
        this.storage_metal_back_left.addBox(-1.5F, -2.0F, -1.0F, 3, 2, 2, 0.0F);
        this.leg_front_right_decoration = new PCModelRenderer(this, 32, 40);
        this.leg_front_right_decoration.setRotationPoint(-0.5F, 12.0F, -5.0F);
        this.leg_front_right_decoration.addBox(-3.0F, -9.0F, 0.0F, 3, 9, 3, 0.0F);
        this.setRotateAngle(leg_front_right_decoration, 0.3490658503988659F, 0.0F, 0.0F);
        this.seat_bottom = new PCModelRenderer(this, 0, 60);
        this.seat_bottom.setRotationPoint(0.0F, 0.0F, -1.0F);
        this.seat_bottom.addBox(-5.0F, -1.0F, -15.0F, 10, 1, 15, 0.0F);
        this.leg_back_left_2 = new PCModelRenderer(this, 107, 32);
        this.leg_back_left_2.setRotationPoint(-0.5F, 7.0F, -3.0F);
        this.leg_back_left_2.addBox(-3.0F, 0.0F, 0.0F, 3, 13, 4, 0.0F);
        this.setRotateAngle(leg_back_left_2, 0.4886921905584123F, 0.0F, 0.0F);
        this.storage_strap_right_holder = new PCModelRenderer(this, 109, 64);
        this.storage_strap_right_holder.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.storage_strap_right_holder.addBox(-2.0F, -2.0F, -2.0F, 2, 4, 4, 0.0F);
        this.storage_box_1 = new PCModelRenderer(this, 0, 218);
        this.storage_box_1.setRotationPoint(-4.5F, -1.0F, -17.5F);
        this.storage_box_1.addBox(-2.0F, -5.0F, -4.0F, 4, 5, 8, 0.0F);
        this.setRotateAngle(storage_box_1, 0.0F, -0.18203784098300857F, 0.0F);
        this.foot_back_left_base = new PCModelRenderer(this, 103, 50);
        this.foot_back_left_base.setRotationPoint(-1.5F, 11.0F, 0.0F);
        this.foot_back_left_base.addBox(-2.0F, 0.0F, -0.5F, 4, 3, 5, 0.0F);
        this.setRotateAngle(foot_back_left_base, -0.17453292519943295F, 0.0F, 0.0F);
        this.storage_metal_back_right = new PCModelRenderer(this, 0, 209);
        this.storage_metal_back_right.setRotationPoint(-4.0F, 0.7F, -0.8F);
        this.storage_metal_back_right.addBox(-1.5F, -2.0F, -1.0F, 3, 2, 2, 0.0F);
        this.back_top = new PCModelRenderer(this, 158, 67);
        this.back_top.setRotationPoint(0.0F, 0.2F, 30.0F);
        this.back_top.addBox(-7.0F, 0.0F, -3.0F, 14, 10, 3, 0.0F);
        this.setRotateAngle(back_top, 0.24434609527920614F, 0.0F, 0.0F);
        this.body_left = new PCModelRenderer(this, 183, 110);
        this.body_left.setRotationPoint(12.0F, 15.0F, 0.0F);
        this.body_left.addBox(-5.0F, -9.0F, 0.0F, 5, 18, 10, 0.0F);
        this.setRotateAngle(body_left, 0.0F, -0.45378560551852565F, 0.0F);
        this.storage_box_5_dec_2 = new PCModelRenderer(this, 41, 234);
        this.storage_box_5_dec_2.setRotationPoint(-1.8F, -3.0F, -2.1F);
        this.storage_box_5_dec_2.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.horn_right_2 = new PCModelRenderer(this, 214, 240);
        this.horn_right_2.setRotationPoint(-6.0F, 0.01F, 0.0F);
        this.horn_right_2.addBox(-7.0F, -1.5F, -3.0F, 7, 3, 3, 0.0F);
        this.setRotateAngle(horn_right_2, 0.0F, -0.6370451769779303F, 0.0F);
        this.body_top = new PCModelRenderer(this, 148, 53);
        this.body_top.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.body_top.addBox(-7.0F, 0.0F, 0.0F, 14, 5, 8, 0.0F);
        this.setRotateAngle(body_top, -0.5450663253978292F, 0.0F, 0.0F);
        this.smallstorage_back_support = new PCModelRenderer(this, 80, 111);
        this.smallstorage_back_support.setRotationPoint(0.0F, -1.0F, -13.0F);
        this.smallstorage_back_support.addBox(-5.5F, -6.0F, 0.0F, 11, 6, 2, 0.0F);
        this.front_strap_right_2 = new PCModelRenderer(this, 21, 106);
        this.front_strap_right_2.setRotationPoint(-1.0F, 26.0F, 0.01F);
        this.front_strap_right_2.addBox(0.0F, 0.0F, -1.0F, 1, 7, 2, 0.0F);
        this.setRotateAngle(front_strap_right_2, 0.0F, 0.0F, -0.5759586531581287F);
        this.seats_backpart_front = new PCModelRenderer(this, 0, 145);
        this.seats_backpart_front.setRotationPoint(0.0F, -4.5F, -1.3F);
        this.seats_backpart_front.addBox(-3.5F, 0.0F, 0.0F, 7, 4, 1, 0.0F);
        this.setRotateAngle(seats_backpart_front, -0.20943951023931953F, 0.0F, 0.0F);
        this.storage_rod_19 = new PCModelRenderer(this, 77, 243);
        this.storage_rod_19.setRotationPoint(16.94F, 0.0F, 0.0F);
        this.storage_rod_19.addBox(0.0F, 0.0F, -9.3F, 1, 1, 10, 0.0F);
        this.seat_back = new PCModelRenderer(this, 0, 41);
        this.seat_back.setRotationPoint(0.0F, 0.0F, -1.8F);
        this.seat_back.addBox(-4.5F, -4.0F, 0.0F, 9, 5, 4, 0.0F);
        this.setRotateAngle(seat_back, -0.2617993877991494F, 0.0F, 0.0F);
        this.storage_box_1_dec = new PCModelRenderer(this, 0, 222);
        this.storage_box_1_dec.setRotationPoint(1.5F, -2.8F, 0.0F);
        this.storage_box_1_dec.addBox(0.0F, -1.5F, -0.5F, 1, 2, 1, 0.0F);
        this.smallstorage_box_3_dec = new PCModelRenderer(this, 141, 89);
        this.smallstorage_box_3_dec.setRotationPoint(0.4F, -2.1F, 0.0F);
        this.smallstorage_box_3_dec.addBox(0.0F, -1.5F, -0.5F, 1, 1, 1, 0.0F);
        this.horn_base_right = new PCModelRenderer(this, 224, 224);
        this.horn_base_right.setRotationPoint(-7.0F, 4.0F, -1.0F);
        this.horn_base_right.addBox(-1.0F, -2.0F, -2.0F, 1, 4, 4, 0.0F);
        this.setRotateAngle(horn_base_right, 0.6283185307179586F, 0.0F, 0.0F);
        this.shoulder_strap_base = new PCModelRenderer(this, 0, 102);
        this.shoulder_strap_base.setRotationPoint(0.0F, 2.0F, 13.0F);
        this.shoulder_strap_base.addBox(-14.0F, 0.0F, 0.0F, 28, 2, 1, 0.0F);
        this.setRotateAngle(shoulder_strap_base, -2.4609142453120048F, 0.0F, 0.0F);
        this.storage_rod_12 = new PCModelRenderer(this, 71, 230);
        this.storage_rod_12.setRotationPoint(0.0F, 0.0F, 10.0F);
        this.storage_rod_12.addBox(0.0F, 0.0F, 0.0F, 1, 1, 11, 0.0F);
        this.nail_back_left = new PCModelRenderer(this, 98, 46);
        this.nail_back_left.setRotationPoint(0.0F, 2.0F, -0.5F);
        this.nail_back_left.addBox(-1.5F, 0.0F, -1.0F, 3, 1, 1, 0.0F);
        this.seat_front = new PCModelRenderer(this, 0, 51);
        this.seat_front.setRotationPoint(0.0F, -1.7F, -15.0F);
        this.seat_front.addBox(-4.5F, 0.0F, 0.0F, 9, 5, 3, 0.0F);
        this.setRotateAngle(seat_front, -0.40142572795869574F, 0.0F, 0.0F);
        this.shoulder_holder = new PCModelRenderer(this, 20, 118);
        this.shoulder_holder.setRotationPoint(0.0F, 1.2F, 1.2F);
        this.shoulder_holder.addBox(-2.0F, -2.0F, -2.0F, 4, 4, 2, 0.0F);
        this.storage_strap_back_right = new PCModelRenderer(this, 130, 73);
        this.storage_strap_back_right.setRotationPoint(0.0F, 2.0F, 1.6F);
        this.storage_strap_back_right.addBox(-1.4F, 0.0F, -2.0F, 1, 11, 2, 0.0F);
        this.setRotateAngle(storage_strap_back_right, -0.9075712110370513F, 0.0F, 0.0F);
        this.smallstorage_rod_5 = new PCModelRenderer(this, 73, 120);
        this.smallstorage_rod_5.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.smallstorage_rod_5.addBox(0.0F, -1.0F, -0.5F, 18, 1, 1, 0.0F);
        this.front_top = new PCModelRenderer(this, 118, 120);
        this.front_top.setRotationPoint(0.0F, 1.0F, -26.0F);
        this.front_top.addBox(-12.5F, 0.0F, 0.0F, 25, 10, 7, 0.0F);
        this.setRotateAngle(front_top, -0.5585053606381855F, 0.0F, 0.0F);
        this.smallstorage_seat_main = new PCModelRenderer(this, 80, 99);
        this.smallstorage_seat_main.setRotationPoint(0.0F, -1.0F, -0.5F);
        this.smallstorage_seat_main.addBox(-4.0F, -1.0F, -10.0F, 8, 1, 10, 0.0F);
        this.tail_4 = new PCModelRenderer(this, 214, 111);
        this.tail_4.setRotationPoint(0.0F, 3.0F, -0.5F);
        this.tail_4.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
        this.tail_base = new PCModelRenderer(this, 204, 106);
        this.tail_base.setRotationPoint(0.0F, 3.0F, -0.4F);
        this.tail_base.addBox(-1.5F, 0.0F, 0.0F, 3, 4, 1, 0.0F);
        this.setRotateAngle(tail_base, -0.1699950691442477F, 0.0F, 0.0F);
        this.shoulder_strap_mid = new PCModelRenderer(this, 0, 62);
        this.shoulder_strap_mid.setRotationPoint(0.0F, 2.0F, -1.6F);
        this.shoulder_strap_mid.addBox(-1.0F, 0.0F, 0.0F, 2, 11, 1, 0.0F);
        this.setRotateAngle(shoulder_strap_mid, 0.8726646259971648F, 0.0F, 0.0F);
        this.storage_rod_11 = new PCModelRenderer(this, 44, 169);
        this.storage_rod_11.setRotationPoint(0.0F, -5.0F, -2.0F);
        this.storage_rod_11.addBox(0.0F, -1.0F, -0.5F, 18, 1, 1, 0.0F);
        this.storage_holder_back_right = new PCModelRenderer(this, 47, 82);
        this.storage_holder_back_right.setRotationPoint(-7.6F, 0.5F, -3.0F);
        this.storage_holder_back_right.addBox(-2.0F, -2.0F, -2.0F, 2, 4, 4, 0.0F);
        this.nail_front_right_top = new PCModelRenderer(this, 34, 53);
        this.nail_front_right_top.setRotationPoint(-0.01F, 0.0F, -1.0F);
        this.nail_front_right_top.addBox(-1.5F, -2.0F, 0.0F, 4, 2, 1, 0.0F);
        this.setRotateAngle(nail_front_right_top, -0.5009094953223726F, 0.0F, 0.0F);
        this.head_front = new PCModelRenderer(this, 131, 179);
        this.head_front.setRotationPoint(0.0F, 1.0F, -5.0F);
        this.head_front.addBox(-6.0F, 0.0F, 0.0F, 12, 8, 5, 0.0F);
        this.setRotateAngle(head_front, -0.5574581630869889F, 0.0F, 0.0F);
        this.seats_backpart_back_front = new PCModelRenderer(this, 0, 145);
        this.seats_backpart_back_front.setRotationPoint(0.0F, -4.5F, -1.3F);
        this.seats_backpart_back_front.addBox(-3.5F, 0.0F, 0.0F, 7, 4, 1, 0.0F);
        this.setRotateAngle(seats_backpart_back_front, -0.20943951023931953F, 0.0F, 0.0F);
        this.head_strap_left_1 = new PCModelRenderer(this, 0, 118);
        this.head_strap_left_1.setRotationPoint(14.0F, 1.0F, 0.0F);
        this.head_strap_left_1.addBox(-1.0F, -1.0F, 0.0F, 1, 2, 17, 0.0F);
        this.nail_front_left = new PCModelRenderer(this, 66, 57);
        this.nail_front_left.setRotationPoint(-0.5F, 2.0F, -6.0F);
        this.nail_front_left.addBox(-1.5F, 0.0F, -1.0F, 4, 1, 1, 0.0F);
        this.storage_strap_left_1 = new PCModelRenderer(this, 59, 99);
        this.storage_strap_left_1.setRotationPoint(0.0F, 1.5F, 0.0F);
        this.storage_strap_left_1.addBox(0.4F, 0.0F, -1.0F, 1, 19, 2, 0.0F);
        this.leg_back_right_2 = new PCModelRenderer(this, 133, 32);
        this.leg_back_right_2.setRotationPoint(0.5F, 7.0F, -3.0F);
        this.leg_back_right_2.addBox(0.0F, 0.0F, 0.0F, 3, 13, 4, 0.0F);
        this.setRotateAngle(leg_back_right_2, 0.4886921905584123F, 0.0F, 0.0F);
        this.smallstorage_box_2_dec_2 = new PCModelRenderer(this, 5, 184);
        this.smallstorage_box_2_dec_2.setRotationPoint(-1.8F, -3.0F, -2.1F);
        this.smallstorage_box_2_dec_2.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.leg_back_left_1 = new PCModelRenderer(this, 97, 12);
        this.leg_back_left_1.setRotationPoint(-8.0F, 18.0F, 24.0F);
        this.leg_back_left_1.addBox(-4.0F, -4.0F, -4.0F, 4, 11, 8, 0.0F);
        this.setRotateAngle(leg_back_left_1, -0.17453292519943295F, 0.0F, 0.0F);
        this.head_bottom_decoration = new PCModelRenderer(this, 228, 181);
        this.head_bottom_decoration.setRotationPoint(0.0F, 10.0F, 2.0F);
        this.head_bottom_decoration.addBox(-2.5F, -8.0F, -3.0F, 5, 8, 3, 0.0F);
        this.setRotateAngle(head_bottom_decoration, -0.4553564018453205F, 0.0F, 0.0F);
        this.storage_rod_9 = new PCModelRenderer(this, 73, 218);
        this.storage_rod_9.setRotationPoint(-4.5F, -1.0F, 1.0F);
        this.storage_rod_9.addBox(0.0F, 0.0F, -0.5F, 1, 1, 10, 0.0F);
        this.storage_rod_15 = new PCModelRenderer(this, 59, 201);
        this.storage_rod_15.setRotationPoint(8.0F, 0.0F, -0.5F);
        this.storage_rod_15.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1, 0.0F);
        this.leg_front_right_1 = new PCModelRenderer(this, 33, 15);
        this.leg_front_right_1.setRotationPoint(-13.0F, 22.0F, -18.0F);
        this.leg_front_right_1.addBox(-5.0F, -5.0F, -5.0F, 5, 14, 10, 0.0F);
        this.setRotateAngle(leg_front_right_1, 0.5061454830783556F, 0.0F, 0.0F);
        this.smallstorage_rod_7 = new PCModelRenderer(this, 107, 111);
        this.smallstorage_rod_7.setRotationPoint(8.0F, 0.0F, -0.5F);
        this.smallstorage_rod_7.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1, 0.0F);
        this.storage_box_5_dec = new PCModelRenderer(this, 25, 241);
        this.storage_box_5_dec.setRotationPoint(0.01F, -2.3F, 0.0F);
        this.storage_box_5_dec.addBox(-2.5F, -1.0F, -2.0F, 5, 1, 4, 0.0F);
        this.leg_back_right_decoration_1 = new PCModelRenderer(this, 96, 32);
        this.leg_back_right_decoration_1.setRotationPoint(-0.5F, 8.0F, 4.0F);
        this.leg_back_right_decoration_1.addBox(-2.0F, -6.0F, -3.0F, 2, 6, 3, 0.0F);
        this.setRotateAngle(leg_back_right_decoration_1, -0.3141592653589793F, 0.0F, 0.0F);
        this.smallstorage_rod_4 = new PCModelRenderer(this, 117, 111);
        this.smallstorage_rod_4.setRotationPoint(0.0F, 0.0F, -9.0F);
        this.smallstorage_rod_4.addBox(0.0F, -5.0F, -0.5F, 1, 5, 1, 0.0F);
        this.storage_strap_front_right = new PCModelRenderer(this, 123, 73);
        this.storage_strap_front_right.setRotationPoint(0.0F, 2.0F, -1.6F);
        this.storage_strap_front_right.addBox(-1.4F, 0.0F, 0.0F, 1, 11, 2, 0.0F);
        this.setRotateAngle(storage_strap_front_right, 0.9075712110370513F, 0.0F, 0.0F);
        this.storage_rod_3.addChild(this.storage_rod_6);
        this.tail_1.addChild(this.tail_2);
        this.storage_base.addChild(this.storage_holder_mid_right);
        this.leg_front_left_2.addChild(this.leg_front_left_decoration);
        this.front_seat_base.addChild(this.front_strap_right_1);
        this.storage_rod_12.addChild(this.storage_rod_14);
        this.back_top.addChild(this.back_bottom_1);
        this.leg_front_right_1.addChild(this.leg_front_right_top);
        this.front_strap_right_1.addChild(this.front_holder_right);
        this.seats_base.addChild(this.seats_mid_metal_back);
        this.storage_rod_4.addChild(this.storage_rod_10);
        this.head_main.addChild(this.head_main_right);
        this.storage_holder_back_left.addChild(this.storage_strap_back_left);
        this.horn_left_1.addChild(this.horn_left_2);
        this.tail_base.addChild(this.tail_1);
        this.leg_back_left_1.addChild(this.leg_back_left_top);
        this.body_back.addChild(this.back_bottom);
        this.largestorage_base.addChild(this.storage_metal_front_left);
        this.storage_base.addChild(this.storage_holder_mid_left);
        this.front_seat_base.addChild(this.front_strap_bottom);
        this.front_seat_base.addChild(this.head_strap_base);
        this.seat_bottom.addChild(this.seat_top);
        this.nail_back_left.addChild(this.nail_back_left_top);
        this.storage_box_4.addChild(this.storage_box_4_dec);
        this.smallstorage_base.addChild(this.smallstorage_rod);
        this.smallstorage_box_2.addChild(this.smallstorage_box_2_dec);
        this.head_front.addChild(this.head_main);
        this.head_base.addChild(this.horn_base_left);
        this.front_seat_base.addChild(this.front_strap_left_1);
        this.smallstorage_rod_5.addChild(this.smallstorage_rod_6);
        this.largestorage_base.addChild(this.storage_box_6);
        this.storage_holder_front_left.addChild(this.storage_strap_front_left);
        this.front_strap_left_1.addChild(this.front_strap_left_2);
        this.leg_back_right_2.addChild(this.foot_back_right_base);
        this.body_back.addChild(this.storage_base);
        this.storage_strap_left_1.addChild(this.storage_strap_left_holder);
        this.body.addChild(this.body_right);
        this.storage_base.addChild(this.largestorage_base);
        this.storage_box_2.addChild(this.storage_box_2_dec_1);
        this.shoulder_strap_base.addChild(this.shoulder_strap_left_1);
        this.front_top.addChild(this.front_bottom);
        this.storage_strap_right_2.addChild(this.storage_strap_right_3);
        this.seats_base.addChild(this.seats_metal_plate);
        this.smallstorage_base.addChild(this.smallstorage_box_3);
        this.storage_box_6.addChild(this.storage_box_6_dec);
        this.storage_rod.addChild(this.storage_rod_4);
        this.leg_back_right_2.addChild(this.leg_back_right_decoration);
        this.nail_back_right.addChild(this.nail_back_right_top);
        this.smallstorage_base.addChild(this.smallstorage_metal_front_right);
        this.seats_metal_plate.addChild(this.seats_main_part);
        this.storage_holder_mid_right.addChild(this.storage_strap_right_1);
        this.smallstorage_rod_8.addChild(this.smallstorage_rod_9);
        this.seats_mid_metal.addChild(this.seats_backpart_back);
        this.smallstorage_rod_10.addChild(this.smallstorage_rod_11);
        this.front_strap_left_2.addChild(this.front_strap_left_3);
        this.shoulder_strap_base.addChild(this.shoulder_strap_right_1);
        this.storage_rod_5.addChild(this.storage_rod_13);
        this.storage_strap_left_1.addChild(this.storage_strap_left_2);
        this.largestorage_base.addChild(this.storage_box_3);
        this.head_front.addChild(this.head_front_decoration);
        this.storage_base.addChild(this.storage_holder_front_right);
        this.front_bottom.addChild(this.neck);
        this.nail_front_left.addChild(this.nail_front_left_top);
        this.storage_rod_6.addChild(this.storage_rod_7);
        this.body.addChild(this.body_bottom);
        this.storage_box_5.addChild(this.storage_box_5_dec_1);
        this.neck.addChild(this.head_base);
        this.storage_box_2.addChild(this.storage_box_2_dec_2);
        this.storage_base.addChild(this.smallstorage_base);
        this.smallstorage_rod_6.addChild(this.smallstorage_rod_8);
        this.smallstorage_box_2.addChild(this.smallstorage_box_2_dec_1);
        this.storage_base.addChild(this.storage_holder_back_left);
        this.largestorage_base.addChild(this.storage_rod);
        this.largestorage_base.addChild(this.storage_box_5);
        this.seats_base.addChild(this.seats_mid_metal);
        this.smallstorage_rod.addChild(this.smallstorage_rod_3);
        this.front_strap_left_1.addChild(this.front_holder_left);
        this.head_strap_base.addChild(this.head_strap_right_1);
        this.smallstorage_box_1.addChild(this.smallstorage_box_1_dec);
        this.head_base.addChild(this.head_bottom);
        this.largestorage_base.addChild(this.storage_metal_front_right);
        this.smallstorage_base.addChild(this.smallstorage_seat_metal);
        this.storage_rod_16.addChild(this.storage_rod_17);
        this.tail_2.addChild(this.tail_3);
        this.smallstorage_rod_4.addChild(this.smallstorage_rod_10);
        this.largestorage_base.addChild(this.storage_box_4);
        this.storage_rod_17.addChild(this.storage_rod_18);
        this.horn_base_right.addChild(this.horn_right_1);
        this.smallstorage_back_support.addChild(this.smallstorage_back_dec);
        this.foot_front_right_base.addChild(this.nail_front_right);
        this.front_strap_right_2.addChild(this.front_strap_right_3);
        this.leg_back_right_1.addChild(this.leg_back_right_top);
        this.leg_front_left_1.addChild(this.leg_front_left_2);
        this.storage_base.addChild(this.seats_base);
        this.body.addChild(this.leg_front_left_1);
        this.storage_base.addChild(this.storage_holder_front_left);
        this.largestorage_base.addChild(this.storage_rod_2);
        this.storage_rod.addChild(this.storage_rod_5);
        this.storage_box_2.addChild(this.storage_box_2_dec);
        this.largestorage_base.addChild(this.storage_box_2);
        this.storage_strap_right_1.addChild(this.storage_strap_right_2);
        this.horn_base_left.addChild(this.horn_left_1);
        this.head_main.addChild(this.head_main_left);
        this.body_back.addChild(this.leg_back_right_1);
        this.smallstorage_base.addChild(this.smallstorage_rod_2);
        this.storage_rod_7.addChild(this.storage_rod_8);
        this.foot_back_right_base.addChild(this.nail_back_right);
        this.smallstorage_base.addChild(this.smallstorage_metal_front_left);
        this.storage_box_3.addChild(this.storage_box_3_dec);
        this.storage_strap_left_2.addChild(this.storage_strap_left_3);
        this.storage_rod_13.addChild(this.storage_rod_16);
        this.body.addChild(this.front_seat_base);
        this.leg_front_left_2.addChild(this.foot_front_left_base);
        this.smallstorage_base.addChild(this.smallstorage_box_1);
        this.body.addChild(this.body_back);
        this.smallstorage_base.addChild(this.smallstorage_box_2);
        this.largestorage_base.addChild(this.storage_rod_1);
        this.storage_rod.addChild(this.storage_rod_3);
        this.leg_front_left_1.addChild(this.leg_front_left_top);
        this.storage_base.addChild(this.storage_base_holder_bottom);
        this.leg_front_right_1.addChild(this.leg_front_right_2);
        this.leg_front_right_2.addChild(this.foot_front_right_base);
        this.smallstorage_base.addChild(this.smallstorage_rod_1);
        this.largestorage_base.addChild(this.storage_metal_back_left);
        this.leg_front_right_2.addChild(this.leg_front_right_decoration);
        this.front_seat_base.addChild(this.seat_bottom);
        this.leg_back_left_1.addChild(this.leg_back_left_2);
        this.storage_strap_right_1.addChild(this.storage_strap_right_holder);
        this.largestorage_base.addChild(this.storage_box_1);
        this.leg_back_left_2.addChild(this.foot_back_left_base);
        this.largestorage_base.addChild(this.storage_metal_back_right);
        this.body_back.addChild(this.back_top);
        this.body.addChild(this.body_left);
        this.storage_box_5.addChild(this.storage_box_5_dec_2);
        this.horn_right_1.addChild(this.horn_right_2);
        this.body.addChild(this.body_top);
        this.smallstorage_base.addChild(this.smallstorage_back_support);
        this.front_strap_right_1.addChild(this.front_strap_right_2);
        this.seats_mid_metal.addChild(this.seats_backpart_front);
        this.storage_rod_18.addChild(this.storage_rod_19);
        this.seat_top.addChild(this.seat_back);
        this.storage_box_1.addChild(this.storage_box_1_dec);
        this.smallstorage_box_3.addChild(this.smallstorage_box_3_dec);
        this.head_base.addChild(this.horn_base_right);
        this.front_seat_base.addChild(this.shoulder_strap_base);
        this.storage_rod_5.addChild(this.storage_rod_12);
        this.foot_back_left_base.addChild(this.nail_back_left);
        this.seat_bottom.addChild(this.seat_front);
        this.shoulder_strap_base.addChild(this.shoulder_holder);
        this.storage_holder_back_right.addChild(this.storage_strap_back_right);
        this.smallstorage_rod_3.addChild(this.smallstorage_rod_5);
        this.body.addChild(this.front_top);
        this.smallstorage_seat_metal.addChild(this.smallstorage_seat_main);
        this.tail_3.addChild(this.tail_4);
        this.back_top.addChild(this.tail_base);
        this.shoulder_holder.addChild(this.shoulder_strap_mid);
        this.storage_rod_10.addChild(this.storage_rod_11);
        this.storage_base.addChild(this.storage_holder_back_right);
        this.nail_front_right.addChild(this.nail_front_right_top);
        this.head_base.addChild(this.head_front);
        this.seats_mid_metal_back.addChild(this.seats_backpart_back_front);
        this.head_strap_base.addChild(this.head_strap_left_1);
        this.foot_front_left_base.addChild(this.nail_front_left);
        this.storage_holder_mid_left.addChild(this.storage_strap_left_1);
        this.leg_back_right_1.addChild(this.leg_back_right_2);
        this.smallstorage_box_2.addChild(this.smallstorage_box_2_dec_2);
        this.body_back.addChild(this.leg_back_left_1);
        this.head_bottom.addChild(this.head_bottom_decoration);
        this.storage_rod_7.addChild(this.storage_rod_9);
        this.storage_rod_14.addChild(this.storage_rod_15);
        this.body.addChild(this.leg_front_right_1);
        this.smallstorage_rod_6.addChild(this.smallstorage_rod_7);
        this.storage_box_5.addChild(this.storage_box_5_dec);
        this.leg_back_left_2.addChild(this.leg_back_right_decoration_1);
        this.smallstorage_rod.addChild(this.smallstorage_rod_4);
        this.storage_holder_front_right.addChild(this.storage_strap_front_right);
        
        setDefaultBoxValues();
    }
    
    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha)
    {
    	this.animateModel(this.entity);
    	
    	matrixStackIn.push();
    	if(this.entity.isSitting() && !this.entity.isBeingRidden())
    	{
    		matrixStackIn.translate(0, 0.15F, 0);
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
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
    {
    	super.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
    	processShouldShowModelParts(entity);
    	
    	revertToDefaultBoxValues();
    	
    	if(entityIn.isAnimationPlaying(BufflonEntity.BLANK_ANIMATION) || entityIn.isAnimationPlaying(BufflonEntity.ATTACK_HEAD_ANIMATION))
    	{
    		if(entityIn.isSitting() && !entityIn.isBeingRidden())
    		{
    			body.rotateAngleX += Math.toRadians(-8);
    			body_back.rotateAngleX += Math.toRadians(-25);
    			
    			leg_back_right_1.rotateAngleX += Math.toRadians(-50);
    			leg_back_right_2.rotateAngleX += Math.toRadians(50);
    			foot_back_right_base.rotateAngleX += Math.toRadians(28);
    			leg_back_left_1.rotateAngleX += Math.toRadians(-50);
    			leg_back_left_2.rotateAngleX += Math.toRadians(50);
    			foot_back_left_base.rotateAngleX += Math.toRadians(28);
    			
    			tail_1.rotateAngleX += Math.toRadians(10);
    			tail_2.rotateAngleX += Math.toRadians(10);
    			tail_3.rotateAngleX += Math.toRadians(10);
    			
    			leg_front_left_1.rotateAngleX += Math.toRadians(5);
    			leg_front_right_1.rotateAngleX += Math.toRadians(5);
    			foot_front_left_base.rotateAngleX += Math.toRadians(3);
    			foot_front_right_base.rotateAngleX += Math.toRadians(3);
    			
    			if(netHeadYaw < -180)
    			{
    				netHeadYaw += 360;
    			}
    			else if(netHeadYaw > 180)
    			{
    				netHeadYaw -= 360;
    			}
	    		neck.rotateAngleY = (netHeadYaw * ((float)Math.PI / 180) / 2);
    			
    			float globalSpeed = 1.0F;
            	float globalHeight = 1.0F;
            	float globalDegree = 1.0F;
            	
            	limbSwing = entityIn.ticksExisted;
            	limbSwingAmount = 1;
            	
            	bounce(body, globalSpeed * 0.3F, globalHeight * 0.3F, false, limbSwing, limbSwingAmount);
            	swing(body_back, globalSpeed * 0.3F, globalDegree * 0.005F, true, 1.0F, 0.0F, limbSwing, limbSwingAmount);
            	
            	swing(neck, globalSpeed * 0.3F, globalDegree * 0.01F, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
            	swing(head_base, globalSpeed * 0.3F, globalDegree * 0.01F, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
            	
            	swing(tail_1, globalSpeed * 0.3F, globalDegree * 0.02F, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
            	swing(tail_2, globalSpeed * 0.3F, globalDegree * 0.02F, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
            	swing(tail_3, globalSpeed * 0.3F, globalDegree * 0.02F, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
            	swing(tail_4, globalSpeed * 0.3F, globalDegree * 0.02F, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
            	
            	swing(leg_back_right_1, globalSpeed * 0.3F, globalDegree * 0.03F, false, 1.0F, 0.0F, limbSwing, limbSwingAmount);
            	swing(leg_back_right_2, globalSpeed * 0.3F, globalDegree * 0.01F, true, 1.0F, 0.0F, limbSwing, limbSwingAmount);
            	swing(leg_back_left_1, globalSpeed * 0.3F, globalDegree * 0.03F, false, 1.0F, 0.0F, limbSwing, limbSwingAmount);
            	swing(leg_back_left_2, globalSpeed * 0.3F, globalDegree * 0.01F, true, 1.0F, 0.0F, limbSwing, limbSwingAmount);
            	
            	swing(leg_front_left_1, globalSpeed * 0.3F, globalDegree * 0.03F, true, 2.1F, 0.0F, limbSwing, limbSwingAmount);
            	swing(leg_front_left_2, globalSpeed * 0.3F, globalDegree * 0.03F, false, 2.1F, 0.0F, limbSwing, limbSwingAmount);
            	swing(foot_front_left_base, globalSpeed * 0.3F, globalDegree * 0.01F, false, 2.1F, 0.0F, limbSwing, limbSwingAmount);
            	swing(leg_front_right_1, globalSpeed * 0.3F, globalDegree * 0.03F, true, 2.1F, 0.0F, limbSwing, limbSwingAmount);
            	swing(leg_front_right_2, globalSpeed * 0.3F, globalDegree * 0.03F, false, 2.1F, 0.0F, limbSwing, limbSwingAmount);
            	swing(foot_front_right_base, globalSpeed * 0.3F, globalDegree * 0.01F, false, 2.1F, 0.0F, limbSwing, limbSwingAmount);
    		}
    		else
    		{
    			if(!entityIn.isMoving()) //Idle Animation
            	{
    				//Makes the Head Rotate where the Entity is Looking
    				if(netHeadYaw < -180)
        			{
        				netHeadYaw += 360;
        			}
        			else if(netHeadYaw > 180)
        			{
        				netHeadYaw -= 360;
        			}
    	    		neck.rotateAngleY += (netHeadYaw * ((float)Math.PI / 180) / 4);
    				
            		float globalSpeed = 0.8F;
                	float globalHeight = 1.0F;
                	float globalDegree = 1.0F;
                	
                	limbSwing = entityIn.ticksExisted;
                	limbSwingAmount = 1;
                	
                	bounce(body, globalSpeed * 0.3F, globalHeight * 0.5F, false, limbSwing, limbSwingAmount);
                	
                	swing(neck, globalSpeed * 0.3F, globalDegree * 0.03F, true, -0.5F, 0.0F, limbSwing, limbSwingAmount);
                	swing(body_back, globalSpeed * 0.3F, globalDegree * 0.01F, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
                	
                	bounce(leg_front_left_1, globalSpeed * 0.3F, globalHeight * -0.3F, false, limbSwing, limbSwingAmount);
                	swing(leg_front_left_1, globalSpeed * 0.3F, globalDegree * 0.01F, false, 1.0F, 0.0F, limbSwing, limbSwingAmount);
                	swing(leg_front_left_2, globalSpeed * 0.3F, globalDegree * 0.02F, false, 1.0F, 0.0F, limbSwing, limbSwingAmount);
                	swing(foot_front_left_base, globalSpeed * 0.3F, globalDegree * 0.04F, true, 1.0F, 0.0F, limbSwing, limbSwingAmount);
                	
                	bounce(leg_front_right_1, globalSpeed * 0.3F, globalHeight * -0.3F, false, limbSwing, limbSwingAmount);
                	swing(leg_front_right_1, globalSpeed * 0.3F, globalDegree * 0.01F, false, 1.0F, 0.0F, limbSwing, limbSwingAmount);
                	swing(leg_front_right_2, globalSpeed * 0.3F, globalDegree * 0.02F, false, 1.0F, 0.0F, limbSwing, limbSwingAmount);
                	swing(foot_front_right_base, globalSpeed * 0.3F, globalDegree * 0.04F, true, 1.0F, 0.0F, limbSwing, limbSwingAmount);
                	
                	bounce(leg_back_left_1, globalSpeed * 0.3F, globalHeight * -0.4F, false, limbSwing, limbSwingAmount);
                	swing(leg_back_left_1, globalSpeed * 0.3F, globalDegree * 0.01F, true, 1.0F, 0.0F, limbSwing, limbSwingAmount);
                	swing(leg_back_left_2, globalSpeed * 0.3F, globalDegree * 0.02F, true, 1.0F, 0.0F, limbSwing, limbSwingAmount);
                	swing(foot_back_left_base, globalSpeed * 0.3F, globalDegree * 0.04F, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
                	
                	bounce(leg_back_right_1, globalSpeed * 0.3F, globalHeight * -0.4F, false, limbSwing, limbSwingAmount);
                	swing(leg_back_right_1, globalSpeed * 0.3F, globalDegree * 0.01F, true, 1.0F, 0.0F, limbSwing, limbSwingAmount);
                	swing(leg_back_right_2, globalSpeed * 0.3F, globalDegree * 0.02F, true, 1.0F, 0.0F, limbSwing, limbSwingAmount);
                	swing(foot_back_right_base, globalSpeed * 0.3F, globalDegree * 0.04F, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
                	
                	swing(tail_1, globalSpeed * 0.3F, globalDegree * 0.02F, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
                	swing(tail_2, globalSpeed * 0.3F, globalDegree * 0.02F, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
                	swing(tail_3, globalSpeed * 0.3F, globalDegree * 0.02F, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
                	swing(tail_4, globalSpeed * 0.3F, globalDegree * 0.02F, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
            	}
        		else
        		{
        			float globalSpeed = 3.6F;
        			if(entityIn.isBeingRidden())
        			{
        				List<Entity> passengers = entityIn.getPassengers();
        				if(passengers.get(0).equals(Minecraft.getInstance().player))
        				{
        					globalSpeed = 1.5F;
        				}
        			}
                	float globalHeight = 1.0F;
                	float globalDegree = 1.0F;
                	
                	bounce(body, globalSpeed * 0.3F, globalHeight * 0.5F, false, limbSwing, limbSwingAmount);
                	swing(body, globalSpeed * 0.3F, globalDegree * 0.01F, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
                	swing(body_back, globalSpeed * 0.3F, globalDegree * 0.01F, true, -1.0F, 0.0F, limbSwing, limbSwingAmount);
                	
                	swing(neck, globalSpeed * 0.3F, globalDegree * 0.03F, true, 2.0F, 0.0F, limbSwing, limbSwingAmount);
                	swing(head_base, globalSpeed * 0.3F, globalDegree * 0.02F, false, 2.0F, 0.0F, limbSwing, limbSwingAmount);
                	
                	swing(leg_front_left_1, globalSpeed * 0.15F, globalDegree * 0.35F, true, 1.7F, 0.05F, limbSwing, limbSwingAmount);
                	swing(leg_front_left_2, globalSpeed * 0.15F, globalDegree * 0.3F, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
                	swing(foot_front_left_base, globalSpeed * 0.15F, globalDegree * 0.25F, false, 1.5F, -0.25F, limbSwing, limbSwingAmount);
                	
                	swing(leg_front_right_1, globalSpeed * 0.15F, globalDegree * 0.35F, false, 1.7F, 0.05F, limbSwing, limbSwingAmount);
                	swing(leg_front_right_2, globalSpeed * 0.15F, globalDegree * 0.3F, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
                	swing(foot_front_right_base, globalSpeed * 0.15F, globalDegree * 0.25F, true, 1.5F, -0.25F, limbSwing, limbSwingAmount);
                	
                	swing(leg_back_right_1, globalSpeed * 0.15F, globalDegree * 0.3F, false, -3.0F, -0.1F, limbSwing, limbSwingAmount);
                	swing(leg_back_right_2, globalSpeed * 0.15F, globalDegree * 0.3F, true, -2.0F, 0.2F, limbSwing, limbSwingAmount);
                	swing(foot_back_right_base, globalSpeed * 0.15F, globalDegree * 0.35F, false, 0.0F, 0.1F, limbSwing, limbSwingAmount);
                	
                	swing(leg_back_left_1, globalSpeed * 0.15F, globalDegree * 0.3F, true, -3.0F, -0.1F, limbSwing, limbSwingAmount);
                	swing(leg_back_left_2, globalSpeed * 0.15F, globalDegree * 0.3F, false, -2.0F, 0.2F, limbSwing, limbSwingAmount);
                	swing(foot_back_left_base, globalSpeed * 0.15F, globalDegree * 0.35F, true, 0.0F, 0.1F, limbSwing, limbSwingAmount);
                	
                	swing(tail_1, globalSpeed * 0.3F, globalDegree * 0.03F, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
                	swing(tail_2, globalSpeed * 0.3F, globalDegree * 0.03F, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
                	swing(tail_3, globalSpeed * 0.3F, globalDegree * 0.03F, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
                	swing(tail_4, globalSpeed * 0.3F, globalDegree * 0.03F, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
        		}
    		}
    	}
    }
    
    @Override
    public void animateModel(T animatedEntity)
    {
    	this.animator.updateAnimations(animatedEntity);
    	
    	if(animatedEntity.isAnimationPlaying(BufflonEntity.THROW_ANIMATION))
    	{
    		this.animator.setAnimationToPlay(BufflonEntity.THROW_ANIMATION);
    		
    		this.animator.startKeyframe(6);
    		this.animator.rotate(body, -0.2F, 0F, 0F);
    		this.animator.move(body, 0F, -3.0F, 0F);
    		this.animator.rotate(body_back, -0.2F, 0F, 0F);
    		
    		this.animator.rotate(leg_back_left_1, -0.6F, 0.0F, 0.0F);
    		this.animator.rotate(leg_back_right_1, -0.6F, 0.0F, 0.0F);
    		this.animator.rotate(leg_back_left_2, 1.0F, 0.0F, 0.0F);
    		this.animator.rotate(leg_back_right_2, 0.8F, 0.0F, 0.0F);
    		
    		this.animator.rotate(leg_front_left_1, 0.5F, 0.0F, 0.0F);
    		this.animator.rotate(leg_front_right_1, 0.8F, 0.0F, 0.0F);
    		this.animator.rotate(leg_front_left_2, -0.8F, 0.0F, 0.0F);
    		this.animator.rotate(leg_front_right_2, -0.8F, 0.0F, 0.0F);
    		
    		this.animator.rotate(tail_1, 0.5F, 0.0F, 0.0F);
    		this.animator.rotate(tail_2, 0.5F, 0.0F, 0.0F);
    		this.animator.rotate(tail_3, 0.5F, 0.0F, 0.0F);
    		
    		this.animator.rotate(neck, -0.2F, 0F, 0F);
    		this.animator.rotate(head_base, -0.3F, 0F, 0F);
    		this.animator.endKeyframe();
    		
    		this.animator.resetKeyframe(6);
    	}
    	
    	if(animatedEntity.isAnimationPlaying(BufflonEntity.ATTACK_HEAD_ANIMATION))
    	{
    		this.animator.setAnimationToPlay(BufflonEntity.ATTACK_HEAD_ANIMATION);
    		
    		this.animator.startKeyframe(5);
    		this.animator.rotate(neck, 0.3F, 0.2F, 0.0F);
    		this.animator.rotate(head_base, 0.3F, 0.2F, 0.0F);
    		this.animator.endKeyframe();
    		
    		this.animator.startKeyframe(2);
    		this.animator.rotate(neck, 0.0F, -0.3F, 0.2F);
    		this.animator.rotate(head_base, -0.1F, -0.2F, 0.2F);
    		this.animator.endKeyframe();
    		
    		this.animator.resetKeyframe(5);
    	}
    }
    
    /**
     * Determines which model parts to show and which not
     */
    private void processShouldShowModelParts(BufflonEntity entity)
    {
    	this.front_seat_base.showModel = entity.isSaddled();
    	this.storage_base.showModel = entity.hasBackAttachment(); 
    	//Sets all back attachment parts invisible before selecting which one to show
    	this.seats_base.showModel = false;
    	this.smallstorage_base.showModel = false;
    	this.largestorage_base.showModel = false;
    	
    	this.smallstorage_box_1.showModel = false;
		this.smallstorage_box_2.showModel = false;
		this.smallstorage_box_3.showModel = false;
    	
    	this.storage_box_1.showModel = false;
		this.storage_box_2.showModel = false;
		this.storage_box_3.showModel = false;
		this.storage_box_4.showModel = false;
		this.storage_box_5.showModel = false;
		this.storage_box_6.showModel = false;
    	
    	if(entity.hasBackAttachment())
    	{
    		switch(entity.getBackAttachmentType())
    		{
    			case 1:
    				this.seats_base.showModel = true;
    				break;
    			case 2:
    				this.smallstorage_base.showModel = true;
    				break;
    			case 3:
    				this.largestorage_base.showModel = true;
    				break;
    			default:
    				//Nothing as all model parts are hidden
    				break;
    		}
    	}
    	
    	processInventoryContentAmount(entity);
    }
    
    /**
     * Determines which model parts to show and which not
     */
    private void processInventoryContentAmount(BufflonEntity entity)
    {
    	if(entity.hasBackAttachment() && entity.getBackAttachmentType() != 1)
    	{
    		int itensInInventory = 0;
    		for(int i = 2; i < (6 * 9) + 2; i++)
    		{
    			if(entity.bufflonStorage.getStackInSlot(i).getItem() != Items.AIR)
    			{
    				itensInInventory++;
    			}
    		}
    		renderSmallStorageBoxes(entity, itensInInventory);
    		renderLargeStorageBoxes(entity, itensInInventory);
    	}
    }
    
    /**
     * Determines how many boxes to render in a Small Storage
     */
    private void renderSmallStorageBoxes(BufflonEntity entity, int itensInInventory)
    {
    	if(entity.bufflonStorage.getStackInSlot(1).getItem() == PCItems.BUFFLON_SMALL_STORAGE.get())
    	{
    		if(itensInInventory >= 5)
    		{
    			this.smallstorage_box_1.showModel = true;
    		}
    		if(itensInInventory >= 14)
    		{
    			this.smallstorage_box_2.showModel = true;
    		}
    		if(itensInInventory >= 23)
    		{
    			this.smallstorage_box_3.showModel = true;
    		}
    	}
    	else
    	{
    		this.smallstorage_box_1.showModel = false;
    		this.smallstorage_box_2.showModel = false;
    		this.smallstorage_box_3.showModel = false;
    	}
    }
    
    /**
     * Determines how many boxes to render in a Large Storage
     */
    private void renderLargeStorageBoxes(BufflonEntity entity, int itensInInventory)
    {
    	if(entity.bufflonStorage.getStackInSlot(1).getItem() == PCItems.BUFFLON_LARGE_STORAGE.get())
    	{
    		if(itensInInventory >= 5)
    		{
    			this.storage_box_1.showModel = true;
    		}
    		if(itensInInventory >= 14)
    		{
    			this.storage_box_2.showModel = true;
    		}
    		if(itensInInventory >= 23)
    		{
    			this.storage_box_3.showModel = true;
    		}
    		if(itensInInventory >= 32)
    		{
    			this.storage_box_4.showModel = true;
    		}
    		if(itensInInventory >= 41)
    		{
    			this.storage_box_5.showModel = true;
    		}
    		if(itensInInventory >= 50)
    		{
    			this.storage_box_6.showModel = true;
    		}
    	}
    	else
    	{
    		this.storage_box_1.showModel = false;
    		this.storage_box_2.showModel = false;
    		this.storage_box_3.showModel = false;
    		this.storage_box_4.showModel = false;
    		this.storage_box_5.showModel = false;
    		this.storage_box_6.showModel = false;
    	}
    }
}
