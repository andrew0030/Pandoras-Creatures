package andrews.pandoras_creatures.entities.model;

import com.mojang.blaze3d.platform.GlStateManager;

import andrews.pandoras_creatures.entities.SeahorseEntity;
import andrews.pandoras_creatures.util.entities.PCEntityModel;
import andrews.pandoras_creatures.util.entities.PCRendererModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * SeaHorse - andrew0030
 * Created using Tabula 7.0.0
 */
@OnlyIn(Dist.CLIENT)
public class SeahorseModel<T extends SeahorseEntity> extends PCEntityModel<T>
{
    public PCRendererModel body;
    public PCRendererModel back_bottom;
    public PCRendererModel neck_front;
    public PCRendererModel tail_1;
    public PCRendererModel back_wing;
    public PCRendererModel back_top;
    public PCRendererModel neck;
    public PCRendererModel head;
    public PCRendererModel face_top;
    public PCRendererModel ear_left;
    public PCRendererModel ear_right;
    public PCRendererModel horn;
    public PCRendererModel face_top_1;
    public PCRendererModel tail_2;
    public PCRendererModel tail_front;
    public PCRendererModel tail_left;
    public PCRendererModel tail_right;
    public PCRendererModel tail_3;
    public PCRendererModel tail_4;
    public PCRendererModel tail_5;
    public PCRendererModel tail_6;
    public PCRendererModel tail_7;
    public PCRendererModel tail_8;

    public SeahorseModel()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.back_wing = new PCRendererModel(this, 55, 27);
        this.back_wing.setRotationPoint(0.0F, 1.5F, 1.0F);
        this.back_wing.addBox(-1.0F, -1.5F, 0.0F, 1, 3, 2, 0.0F);
        this.tail_5 = new PCRendererModel(this, 15, 30);
        this.tail_5.setRotationPoint(0.01F, 1.0F, 0.0F);
        this.tail_5.addBox(-0.5F, 0.0F, -1.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(tail_5, -0.593411945678072F, 0.0F, 0.0F);
        this.face_top_1 = new PCRendererModel(this, 33, 5);
        this.face_top_1.setRotationPoint(0.01F, 0.0F, 0.0F);
        this.face_top_1.addBox(-0.5F, 0.0F, -2.3F, 1, 1, 3, 0.0F);
        this.setRotateAngle(face_top_1, 0.22689280275926282F, 0.0F, 0.0F);
        this.horn = new PCRendererModel(this, 33, 10);
        this.horn.setRotationPoint(0.0F, -1.4F, -1.3F);
        this.horn.addBox(-1.0F, -3.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(horn, 0.36425021489121656F, 0.0F, 0.0F);
        this.tail_4 = new PCRendererModel(this, 20, 30);
        this.tail_4.setRotationPoint(0.01F, 1.0F, 0.0F);
        this.tail_4.addBox(-0.5F, 0.0F, -1.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(tail_4, -0.593411945678072F, 0.0F, 0.0F);
        this.head = new PCRendererModel(this, 42, 0);
        this.head.setRotationPoint(0.0F, 0.5F, -0.5F);
        this.head.addBox(-1.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(head, -0.08726646259971647F, 0.0F, 0.0F);
        this.tail_front = new PCRendererModel(this, 40, 29);
        this.tail_front.setRotationPoint(0.01F, 1.5F, -1.0F);
        this.tail_front.addBox(-0.5F, -2.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(tail_front, 0.3141592653589793F, 0.0F, 0.0F);
        this.tail_1 = new PCRendererModel(this, 35, 28);
        this.tail_1.setRotationPoint(0.0F, 1.7F, 1.0F);
        this.tail_1.addBox(-0.5F, -1.0F, -1.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(tail_1, 0.17453292519943295F, 0.0F, 0.0F);
        this.face_top = new PCRendererModel(this, 33, 0);
        this.face_top.setRotationPoint(0.0F, -1.5F, -0.8F);
        this.face_top.addBox(-0.5F, 0.0F, -2.3F, 1, 1, 3, 0.0F);
        this.setRotateAngle(face_top, 0.091106186954104F, 0.0F, 0.0F);
        this.ear_right = new PCRendererModel(this, 5, 0);
        this.ear_right.setRotationPoint(-1.0F, -1.2F, 0.4F);
        this.ear_right.addBox(-1.0F, -1.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(ear_right, 0.08726646259971647F, -0.3141592653589793F, 0.0F);
        this.tail_8 = new PCRendererModel(this, 0, 30);
        this.tail_8.setRotationPoint(0.01F, 1.0F, 0.0F);
        this.tail_8.addBox(-0.5F, 0.0F, -1.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(tail_8, -0.593411945678072F, 0.0F, 0.0F);
        this.tail_right = new PCRendererModel(this, 50, 29);
        this.tail_right.setRotationPoint(-0.5F, 1.5F, -0.01F);
        this.tail_right.addBox(0.0F, -2.0F, -1.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(tail_right, 0.0F, 0.0F, -0.22689280275926282F);
        this.body = new PCRendererModel(this, 56, 0);
        this.body.setRotationPoint(0.0F, 18.3F, 0.0F);
        this.body.addBox(-1.0F, -1.5F, -1.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(body, 0.17453292519943295F, 0.0F, 0.0F);
        this.back_top = new PCRendererModel(this, 55, 6);
        this.back_top.setRotationPoint(0.01F, -3.0F, 0.0F);
        this.back_top.addBox(-0.5F, -3.0F, -1.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(back_top, 0.4363323129985824F, 0.0F, 0.0F);
        this.tail_7 = new PCRendererModel(this, 5, 30);
        this.tail_7.setRotationPoint(0.01F, 1.0F, 0.0F);
        this.tail_7.addBox(-0.5F, 0.0F, -1.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(tail_7, -0.593411945678072F, 0.0F, 0.0F);
        this.back_bottom = new PCRendererModel(this, 60, 6);
        this.back_bottom.setRotationPoint(0.0F, 1.2F, 1.0F);
        this.back_bottom.addBox(-0.5F, -3.0F, -1.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(back_bottom, -0.3141592653589793F, 0.0F, 0.0F);
        this.tail_6 = new PCRendererModel(this, 10, 30);
        this.tail_6.setRotationPoint(0.01F, 1.0F, 0.0F);
        this.tail_6.addBox(-0.5F, 0.0F, -1.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(tail_6, -0.593411945678072F, 0.0F, 0.0F);
        this.neck = new PCRendererModel(this, 51, 0);
        this.neck.setRotationPoint(0.01F, -2.0F, -0.8F);
        this.neck.addBox(-0.5F, 0.0F, -1.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(neck, -0.136659280431156F, 0.0F, 0.0F);
        this.neck_front = new PCRendererModel(this, 50, 5);
        this.neck_front.setRotationPoint(-0.01F, -1.5F, -1.0F);
        this.neck_front.addBox(-0.5F, -2.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(neck_front, -0.5462880558742251F, 0.0F, 0.0F);
        this.tail_2 = new PCRendererModel(this, 30, 30);
        this.tail_2.setRotationPoint(0.01F, 2.0F, 0.0F);
        this.tail_2.addBox(-0.5F, 0.0F, -1.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(tail_2, -0.3141592653589793F, 0.0F, 0.0F);
        this.ear_left = new PCRendererModel(this, 0, 0);
        this.ear_left.setRotationPoint(1.0F, -1.2F, 0.4F);
        this.ear_left.addBox(-1.0F, -1.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(ear_left, 0.08726646259971647F, 0.3141592653589793F, 0.0F);
        this.tail_3 = new PCRendererModel(this, 25, 30);
        this.tail_3.setRotationPoint(0.01F, 1.0F, 0.0F);
        this.tail_3.addBox(-0.5F, 0.0F, -1.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(tail_3, -0.593411945678072F, 0.0F, 0.0F);
        this.tail_left = new PCRendererModel(this, 45, 29);
        this.tail_left.setRotationPoint(0.5F, 1.5F, -0.01F);
        this.tail_left.addBox(-1.0F, -2.0F, -1.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(tail_left, 0.0F, 0.0F, 0.22689280275926282F);
        this.body.addChild(this.back_wing);
        this.tail_4.addChild(this.tail_5);
        this.face_top.addChild(this.face_top_1);
        this.head.addChild(this.horn);
        this.tail_3.addChild(this.tail_4);
        this.neck.addChild(this.head);
        this.tail_1.addChild(this.tail_front);
        this.body.addChild(this.tail_1);
        this.head.addChild(this.face_top);
        this.head.addChild(this.ear_right);
        this.tail_7.addChild(this.tail_8);
        this.tail_1.addChild(this.tail_right);
        this.back_bottom.addChild(this.back_top);
        this.tail_6.addChild(this.tail_7);
        this.body.addChild(this.back_bottom);
        this.tail_5.addChild(this.tail_6);
        this.back_top.addChild(this.neck);
        this.body.addChild(this.neck_front);
        this.tail_1.addChild(this.tail_2);
        this.head.addChild(this.ear_left);
        this.tail_2.addChild(this.tail_3);
        this.tail_1.addChild(this.tail_left);
        
        bodyParts = new PCRendererModel[] {body, back_bottom, neck_front, tail_1, back_wing, back_top, neck, head, face_top, ear_left, ear_right, horn, face_top_1, tail_2, tail_front, tail_left, tail_right, tail_3, tail_4, tail_5, tail_6, tail_7, tail_8};
        saveAsDefaultPose();
    }

    @Override
    public void render(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
    	double size = 1.0D + (((entity.getSeahorseSize() - 3) * 2) * 0.07D);
    	if(entity.getName().getString().equals("Mr.Sparkles")) {this.horn.showModel = true;} else {this.horn.showModel = false;}
    	GlStateManager.pushMatrix();
        GlStateManager.translated(this.body.offsetX, this.body.offsetY, this.body.offsetZ);
        GlStateManager.translated(this.body.rotationPointX * scale, this.body.rotationPointY * scale, this.body.rotationPointZ * scale);
        if(!entity.isInWater())
        {
        	GlStateManager.translated(0, 0.3D, 0);
        }
        else
        {
        	GlStateManager.translated(0, -((entity.getSeahorseSize() - 3) * 0.05D), 0);
        }
        GlStateManager.scaled(size, size, size);
        GlStateManager.translated(-this.body.offsetX, -this.body.offsetY, -this.body.offsetZ);
        GlStateManager.translated(-this.body.rotationPointX * scale, -this.body.rotationPointY * scale, -this.body.rotationPointZ * scale);
        this.body.render(scale);
        GlStateManager.popMatrix();
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(RendererModel modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    @Override
    public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor)
    {
    	super.setRotationAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
    	
    	if(!entity.isInWater())//Outside Water Animation
    	{
    		limbSwing = entity.ticksExisted;
    		limbSwingAmount = 1;
    		
    		float globalSpeed = 0.5F;
    		float globalDegree = 1.0F;
    		
    		loadDefaultPose();
    		
    		this.body.rotateAngleZ = (float) Math.toRadians(90);
    		
    		flap(body, 0.7F * globalSpeed, 0.3F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
    		shake(ear_left, 0.7F * globalSpeed, 0.2F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
			shake(ear_right, 0.7F * globalSpeed, 0.2F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
    		
			swing(back_bottom, 0.7F * globalSpeed, 0.12F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
			swing(back_top, 0.7F * globalSpeed, 0.12F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
			swing(neck_front, 0.7F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
			swing(head, 0.7F * globalSpeed, 0.3F * globalDegree, true, -0.2F, -0.1F, limbSwing, limbSwingAmount);
			
			flap(back_bottom, 0.7F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
			flap(back_top, 0.7F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
			
			swing(tail_1, 0.7F * globalSpeed, 0.2F * globalDegree, false, 0.2F, 0.0F, limbSwing, limbSwingAmount);
			flap(tail_1, 0.7F * globalSpeed, 0.3F * globalDegree, false, 0.2F, 0.0F, limbSwing, limbSwingAmount);
			swing(tail_2, 0.7F * globalSpeed, 0.1F * globalDegree, false, 0.2F, 0.0F, limbSwing, limbSwingAmount);
			flap(tail_2, 0.7F * globalSpeed, 0.2F * globalDegree, false, 0.2F, 0.0F, limbSwing, limbSwingAmount);
			swing(tail_3, 0.7F * globalSpeed, 0.1F * globalDegree, false, 0.2F, 0.0F, limbSwing, limbSwingAmount);
			flap(tail_3, 0.7F * globalSpeed, 0.2F * globalDegree, false, 0.2F, 0.0F, limbSwing, limbSwingAmount);
			swing(tail_4, 0.7F * globalSpeed, 0.1F * globalDegree, false, 0.2F, 0.0F, limbSwing, limbSwingAmount);
			flap(tail_4, 0.7F * globalSpeed, 0.2F * globalDegree, false, 0.2F, 0.0F, limbSwing, limbSwingAmount);
			swing(tail_5, 0.7F * globalSpeed, 0.05F * globalDegree, false, 0.2F, 0.0F, limbSwing, limbSwingAmount);
			flap(tail_5, 0.7F * globalSpeed, 0.2F * globalDegree, false, 0.2F, 0.0F, limbSwing, limbSwingAmount);
			swing(tail_6, 0.7F * globalSpeed, 0.05F * globalDegree, false, 0.2F, 0.0F, limbSwing, limbSwingAmount);
			flap(tail_6, 0.7F * globalSpeed, 0.1F * globalDegree, false, 0.2F, 0.0F, limbSwing, limbSwingAmount);
			swing(tail_7, 0.7F * globalSpeed, 0.05F * globalDegree, false, 0.2F, 0.0F, limbSwing, limbSwingAmount);
			flap(tail_7, 0.7F * globalSpeed, 0.1F * globalDegree, false, 0.2F, 0.0F, limbSwing, limbSwingAmount);
			swing(tail_8, 0.7F * globalSpeed, 0.05F * globalDegree, false, 0.2F, 0.0F, limbSwing, limbSwingAmount);
			flap(tail_8, 0.7F * globalSpeed, 0.1F * globalDegree, false, 0.2F, 0.0F, limbSwing, limbSwingAmount);
    	}
    	else
    	{
	    	if(entity.prevPosX != entity.posX || entity.prevPosZ != entity.posZ) //Move Animation
	    	{
				float globalSpeed = 5.0F;
				float globalDegree = 2.0F;
				
				loadDefaultPose();
				
				this.head.rotateAngleY = (netHeadYaw * ((float)Math.PI / 180) / 1.8F);
				
				swing(body, 0.3F * globalSpeed, 0.2F * globalDegree, false, 0.0F, 0.2F, limbSwing, limbSwingAmount);
				
				shake(ear_left, 0.3F * globalSpeed, 0.2F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
				shake(ear_right, 0.3F * globalSpeed, 0.2F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
				
				swing(face_top_1, 0.4F * globalSpeed, 0.05F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
				
				swing(back_bottom, 0.3F * globalSpeed, 0.12F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
				swing(back_top, 0.3F * globalSpeed, 0.12F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
				swing(neck_front, 0.3F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
				swing(head, 0.3F * globalSpeed, 0.3F * globalDegree, true, -0.2F, -0.1F, limbSwing, limbSwingAmount);
				
				swing(back_wing, 0.3F * globalSpeed, 0.2F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
				
				swing(tail_1, 0.3F * globalSpeed, 0.2F * globalDegree, false, 0.2F, 0.0F, limbSwing, limbSwingAmount);
				swing(tail_2, 0.3F * globalSpeed, 0.1F * globalDegree, false, 0.2F, 0.0F, limbSwing, limbSwingAmount);
				swing(tail_3, 0.3F * globalSpeed, 0.1F * globalDegree, false, 0.2F, 0.0F, limbSwing, limbSwingAmount);
				swing(tail_4, 0.3F * globalSpeed, 0.1F * globalDegree, false, 0.2F, 0.0F, limbSwing, limbSwingAmount);
				swing(tail_5, 0.3F * globalSpeed, 0.05F * globalDegree, false, 0.2F, 0.0F, limbSwing, limbSwingAmount);
				swing(tail_6, 0.3F * globalSpeed, 0.05F * globalDegree, false, 0.2F, 0.0F, limbSwing, limbSwingAmount);
				swing(tail_7, 0.3F * globalSpeed, 0.05F * globalDegree, false, 0.2F, 0.0F, limbSwing, limbSwingAmount);
				swing(tail_8, 0.3F * globalSpeed, 0.05F * globalDegree, false, 0.2F, 0.0F, limbSwing, limbSwingAmount);
	    	}
	    	else//Idle Animation
	    	{
	    		limbSwing = entity.ticksExisted;
	        	limbSwingAmount = 1;
	    		
	    		float globalSpeed = 0.8F;
				float globalDegree = 1.0F;
				float globalHeight = 1.0F;
				
				loadDefaultPose();
				
				this.head.rotateAngleY = (netHeadYaw * ((float)Math.PI / 180) / 1.8F);
	    		
	        	bounce(body, 0.4F * globalSpeed, 0.4F * globalHeight, false, limbSwing, limbSwingAmount);
	        	
	        	shake(ear_left, 0.4F * globalSpeed, 0.2F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	        	shake(ear_right, 0.4F * globalSpeed, 0.2F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	        	
	        	swing(face_top_1, 0.4F * globalSpeed, 0.05F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	        	
	        	swing(back_bottom, 0.4F * globalSpeed, 0.08F * globalDegree, true, -1.0F, 0.0F, limbSwing, limbSwingAmount);
	        	swing(back_top, 0.4F * globalSpeed, 0.08F * globalDegree, false, -1.0F, 0.0F, limbSwing, limbSwingAmount);
	        	swing(neck_front, 0.4F * globalSpeed, 0.1F * globalDegree, true, -1.0F, 0.0F, limbSwing, limbSwingAmount);
	        	
	        	swing(body, 0.4F * globalSpeed, 0.03F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	        	
	        	swing(back_wing, 0.4F * globalSpeed, 0.05F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	        	
	        	swing(tail_1, 0.4F * globalSpeed, 0.1F * globalDegree, true, -0.6F, -0.05F, limbSwing, limbSwingAmount);
	        	swing(tail_2, 0.4F * globalSpeed, 0.1F * globalDegree, true, -0.6F, 0.0F, limbSwing, limbSwingAmount);
	        	swing(tail_3, 0.4F * globalSpeed, 0.05F * globalDegree, true, -0.6F, 0.0F, limbSwing, limbSwingAmount);
	        	swing(tail_4, 0.4F * globalSpeed, 0.05F * globalDegree, true, -0.6F, 0.0F, limbSwing, limbSwingAmount);
	        	swing(tail_5, 0.4F * globalSpeed, 0.05F * globalDegree, true, -0.6F, 0.0F, limbSwing, limbSwingAmount);
	        	swing(tail_6, 0.4F * globalSpeed, 0.05F * globalDegree, true, -0.6F, 0.0F, limbSwing, limbSwingAmount);
	        	swing(tail_7, 0.4F * globalSpeed, 0.05F * globalDegree, true, -0.6F, 0.0F, limbSwing, limbSwingAmount);
	        	swing(tail_8, 0.4F * globalSpeed, 0.05F * globalDegree, true, -0.6F, 0.0F, limbSwing, limbSwingAmount);
	    	}
	    }
    }
}