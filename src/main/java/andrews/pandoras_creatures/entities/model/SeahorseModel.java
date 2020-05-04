package andrews.pandoras_creatures.entities.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import andrews.pandoras_creatures.entities.SeahorseEntity;
import andrews.pandoras_creatures.util.animation.PCEntityModel;
import andrews.pandoras_creatures.util.animation.PCModelRenderer;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * SeaHorse - andrew0030
 * Created using Tabula 7.0.0
 */
@OnlyIn(Dist.CLIENT)
public class SeahorseModel<T extends SeahorseEntity> extends PCEntityModel<T>
{
    public PCModelRenderer body;
    public PCModelRenderer back_bottom;
    public PCModelRenderer neck_front;
    public PCModelRenderer tail_1;
    public PCModelRenderer back_wing;
    public PCModelRenderer back_top;
    public PCModelRenderer neck;
    public PCModelRenderer head;
    public PCModelRenderer face_top;
    public PCModelRenderer ear_left;
    public PCModelRenderer ear_right;
    public PCModelRenderer horn;
    public PCModelRenderer face_top_1;
    public PCModelRenderer tail_2;
    public PCModelRenderer tail_front;
    public PCModelRenderer tail_left;
    public PCModelRenderer tail_right;
    public PCModelRenderer tail_3;
    public PCModelRenderer tail_4;
    public PCModelRenderer tail_5;
    public PCModelRenderer tail_6;
    public PCModelRenderer tail_7;
    public PCModelRenderer tail_8;

    public SeahorseModel()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.back_wing = new PCModelRenderer(this, 55, 27);
        this.back_wing.setRotationPoint(0.0F, 1.5F, 1.0F);
        this.back_wing.addBox(-1.0F, -1.5F, 0.0F, 1, 3, 2, 0.0F);
        this.tail_5 = new PCModelRenderer(this, 15, 30);
        this.tail_5.setRotationPoint(0.01F, 1.0F, 0.0F);
        this.tail_5.addBox(-0.5F, 0.0F, -1.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(tail_5, -0.593411945678072F, 0.0F, 0.0F);
        this.face_top_1 = new PCModelRenderer(this, 33, 5);
        this.face_top_1.setRotationPoint(0.01F, 0.0F, 0.0F);
        this.face_top_1.addBox(-0.5F, 0.0F, -2.3F, 1, 1, 3, 0.0F);
        this.setRotateAngle(face_top_1, 0.22689280275926282F, 0.0F, 0.0F);
        this.horn = new PCModelRenderer(this, 33, 10);
        this.horn.setRotationPoint(0.0F, -1.4F, -1.3F);
        this.horn.addBox(-1.0F, -3.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(horn, 0.36425021489121656F, 0.0F, 0.0F);
        this.tail_4 = new PCModelRenderer(this, 20, 30);
        this.tail_4.setRotationPoint(0.01F, 1.0F, 0.0F);
        this.tail_4.addBox(-0.5F, 0.0F, -1.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(tail_4, -0.593411945678072F, 0.0F, 0.0F);
        this.head = new PCModelRenderer(this, 42, 0);
        this.head.setRotationPoint(0.0F, 0.5F, -0.5F);
        this.head.addBox(-1.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(head, -0.08726646259971647F, 0.0F, 0.0F);
        this.tail_front = new PCModelRenderer(this, 40, 29);
        this.tail_front.setRotationPoint(0.01F, 1.5F, -1.0F);
        this.tail_front.addBox(-0.5F, -2.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(tail_front, 0.3141592653589793F, 0.0F, 0.0F);
        this.tail_1 = new PCModelRenderer(this, 35, 28);
        this.tail_1.setRotationPoint(0.0F, 1.7F, 1.0F);
        this.tail_1.addBox(-0.5F, -1.0F, -1.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(tail_1, 0.17453292519943295F, 0.0F, 0.0F);
        this.face_top = new PCModelRenderer(this, 33, 0);
        this.face_top.setRotationPoint(0.0F, -1.5F, -0.8F);
        this.face_top.addBox(-0.5F, 0.0F, -2.3F, 1, 1, 3, 0.0F);
        this.setRotateAngle(face_top, 0.091106186954104F, 0.0F, 0.0F);
        this.ear_right = new PCModelRenderer(this, 5, 0);
        this.ear_right.setRotationPoint(-1.0F, -1.2F, 0.4F);
        this.ear_right.addBox(-1.0F, -1.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(ear_right, 0.08726646259971647F, -0.3141592653589793F, 0.0F);
        this.tail_8 = new PCModelRenderer(this, 0, 30);
        this.tail_8.setRotationPoint(0.01F, 1.0F, 0.0F);
        this.tail_8.addBox(-0.5F, 0.0F, -1.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(tail_8, -0.593411945678072F, 0.0F, 0.0F);
        this.tail_right = new PCModelRenderer(this, 50, 29);
        this.tail_right.setRotationPoint(-0.5F, 1.5F, -0.01F);
        this.tail_right.addBox(0.0F, -2.0F, -1.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(tail_right, 0.0F, 0.0F, -0.22689280275926282F);
        this.body = new PCModelRenderer(this, 56, 0);
        this.body.setRotationPoint(0.0F, 18.3F, 0.0F);
        this.body.addBox(-1.0F, -1.5F, -1.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(body, 0.17453292519943295F, 0.0F, 0.0F);
        this.back_top = new PCModelRenderer(this, 55, 6);
        this.back_top.setRotationPoint(0.01F, -3.0F, 0.0F);
        this.back_top.addBox(-0.5F, -3.0F, -1.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(back_top, 0.4363323129985824F, 0.0F, 0.0F);
        this.tail_7 = new PCModelRenderer(this, 5, 30);
        this.tail_7.setRotationPoint(0.01F, 1.0F, 0.0F);
        this.tail_7.addBox(-0.5F, 0.0F, -1.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(tail_7, -0.593411945678072F, 0.0F, 0.0F);
        this.back_bottom = new PCModelRenderer(this, 60, 6);
        this.back_bottom.setRotationPoint(0.0F, 1.2F, 1.0F);
        this.back_bottom.addBox(-0.5F, -3.0F, -1.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(back_bottom, -0.3141592653589793F, 0.0F, 0.0F);
        this.tail_6 = new PCModelRenderer(this, 10, 30);
        this.tail_6.setRotationPoint(0.01F, 1.0F, 0.0F);
        this.tail_6.addBox(-0.5F, 0.0F, -1.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(tail_6, -0.593411945678072F, 0.0F, 0.0F);
        this.neck = new PCModelRenderer(this, 51, 0);
        this.neck.setRotationPoint(0.01F, -2.0F, -0.8F);
        this.neck.addBox(-0.5F, 0.0F, -1.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(neck, -0.136659280431156F, 0.0F, 0.0F);
        this.neck_front = new PCModelRenderer(this, 50, 5);
        this.neck_front.setRotationPoint(-0.01F, -1.5F, -1.0F);
        this.neck_front.addBox(-0.5F, -2.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(neck_front, -0.5462880558742251F, 0.0F, 0.0F);
        this.tail_2 = new PCModelRenderer(this, 30, 30);
        this.tail_2.setRotationPoint(0.01F, 2.0F, 0.0F);
        this.tail_2.addBox(-0.5F, 0.0F, -1.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(tail_2, -0.3141592653589793F, 0.0F, 0.0F);
        this.ear_left = new PCModelRenderer(this, 0, 0);
        this.ear_left.setRotationPoint(1.0F, -1.2F, 0.4F);
        this.ear_left.addBox(-1.0F, -1.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(ear_left, 0.08726646259971647F, 0.3141592653589793F, 0.0F);
        this.tail_3 = new PCModelRenderer(this, 25, 30);
        this.tail_3.setRotationPoint(0.01F, 1.0F, 0.0F);
        this.tail_3.addBox(-0.5F, 0.0F, -1.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(tail_3, -0.593411945678072F, 0.0F, 0.0F);
        this.tail_left = new PCModelRenderer(this, 45, 29);
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
        
        setDefaultBoxValues();
    }
    
    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha)
    {
    	matrixStackIn.push();
    	float size = 1.0F + (((entity.getSeahorseSize() - 3) * 2) * 0.07F);
    	
    	matrixStackIn.translate(0, -((entity.getSeahorseSize() - 3) * 0.18D), 0);
    	
    	if(!this.entity.isInWater())
    	{
    		matrixStackIn.translate(0, 0.3F, 0);
    	}
    	
    	matrixStackIn.scale(size, size, size);
    	
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
    	
    	if(entity.getName().getString().equals("Mr.Sparkles")) {this.horn.showModel = true;} else {this.horn.showModel = false;}
    	
    	if(!entity.isInWater())//Outside Water Animation
    	{
    		limbSwing = entity.ticksExisted;
    		limbSwingAmount = 1;
    		
    		float globalSpeed = 0.5F;
    		float globalDegree = 1.0F;
    		
    		revertToDefaultBoxValues();
    		
    		if(entity.isAlive())
    		{
    			this.body.rotateAngleZ = (float) Math.toRadians(90);
    		}
    		
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
	    	if(entity.isEntityMovingHorizontaly()) //Move Animation
	    	{
				float globalSpeed = 5.0F;
				float globalDegree = 2.0F;
				
				revertToDefaultBoxValues();
				
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
				
				revertToDefaultBoxValues();
				
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