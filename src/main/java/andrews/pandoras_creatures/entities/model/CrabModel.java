package andrews.pandoras_creatures.entities.model;

import andrews.pandoras_creatures.entities.CrabEntity;
import andrews.pandoras_creatures.util.animation.PCEntityModel;
import andrews.pandoras_creatures.util.animation.PCRendererModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CrabModel<T extends CrabEntity> extends PCEntityModel<T>
{
    public PCRendererModel Body;
    public PCRendererModel BodyBottom;
    public PCRendererModel ArmBackRight;
    public PCRendererModel ArmBackLeft;
    public PCRendererModel LegLeftFirst_1;
    public PCRendererModel LegLeftSecond_1;
    public PCRendererModel LegLeftThird_1;
    public PCRendererModel LegLeftFourth_1;
    public PCRendererModel LegRightFirst_1;
    public PCRendererModel LegRightSecond_1;
    public PCRendererModel LegRightThird_1;
    public PCRendererModel LegRightFourth_1;
    public PCRendererModel BodyTop;
    public PCRendererModel Hat;
    public PCRendererModel HatTop;
    public PCRendererModel ArmFrontRight;
    public PCRendererModel ScissorBigRight;
    public PCRendererModel ScissorSmallRight;
    public PCRendererModel ArmFrontLeft;
    public PCRendererModel ScissorBigLeft;
    public PCRendererModel ScissorSmallLeft;
    public PCRendererModel LegLeftFirst_2;
    public PCRendererModel LegLeftSecond_2;
    public PCRendererModel LegLeftThird_2;
    public PCRendererModel LegLeftFourth_2;
    public PCRendererModel LegRightFirst_2;
    public PCRendererModel LegRightSecond_2;
    public PCRendererModel LegRightThird_2;
    public PCRendererModel LegRightFourth_2;

    public CrabModel()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.LegLeftFourth_1 = new PCRendererModel(this, 15, 23);
        this.LegLeftFourth_1.setRotationPoint(2.2F, 1.0F, 6.2F);
        this.LegLeftFourth_1.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(LegLeftFourth_1, 0.0F, 0.0F, -2.0943951023931953F);
        this.ScissorSmallLeft = new PCRendererModel(this, 35, 16);
        this.ScissorSmallLeft.setRotationPoint(-0.8F, 0.0F, -0.1F);
        this.ScissorSmallLeft.addBox(-0.5F, -0.5F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(ScissorSmallLeft, 0.0F, 0.3490658503988659F, 0.0F);
        this.Hat = new PCRendererModel(this, 43, 0);
        this.Hat.setRotationPoint(0.0F, -0.4F, 2.2F);
        this.Hat.addBox(-2.0F, 0.0F, -2.0F, 4, 1, 4, 0.0F);
        this.LegRightSecond_2 = new PCRendererModel(this, 25, 28);
        this.LegRightSecond_2.setRotationPoint(-0.5F, 3.0F, 0.01F);
        this.LegRightSecond_2.addBox(-1.0F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
        this.setRotateAngle(LegRightSecond_2, 0.0F, 0.0F, -1.8325957145940461F);
        this.LegRightSecond_1 = new PCRendererModel(this, 25, 23);
        this.LegRightSecond_1.setRotationPoint(-2.2F, 1.0F, 2.6F);
        this.LegRightSecond_1.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(LegRightSecond_1, 0.0F, 0.0F, 2.0943951023931953F);
        this.LegRightThird_2 = new PCRendererModel(this, 30, 28);
        this.LegRightThird_2.setRotationPoint(-0.5F, 3.0F, 0.01F);
        this.LegRightThird_2.addBox(-1.0F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
        this.setRotateAngle(LegRightThird_2, 0.0F, 0.0F, -1.8325957145940461F);
        this.LegLeftSecond_2 = new PCRendererModel(this, 5, 28);
        this.LegLeftSecond_2.setRotationPoint(0.5F, 3.0F, 0.01F);
        this.LegLeftSecond_2.addBox(0.0F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
        this.setRotateAngle(LegLeftSecond_2, 0.0F, 0.0F, 1.8325957145940461F);
        this.LegRightFirst_2 = new PCRendererModel(this, 20, 28);
        this.LegRightFirst_2.setRotationPoint(-0.5F, 3.0F, 0.01F);
        this.LegRightFirst_2.addBox(-1.0F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
        this.setRotateAngle(LegRightFirst_2, 0.0F, 0.0F, -1.8325957145940461F);
        this.LegLeftFirst_2 = new PCRendererModel(this, 0, 28);
        this.LegLeftFirst_2.setRotationPoint(0.5F, 3.0F, 0.01F);
        this.LegLeftFirst_2.addBox(0.0F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
        this.setRotateAngle(LegLeftFirst_2, 0.0F, 0.0F, 1.8325957145940461F);
        this.ScissorBigRight = new PCRendererModel(this, 23, 10);
        this.ScissorBigRight.setRotationPoint(0.0F, 0.0F, -2.5F);
        this.ScissorBigRight.addBox(-1.0F, -1.0F, -2.5F, 2, 2, 3, 0.0F);
        this.LegRightFourth_2 = new PCRendererModel(this, 35, 28);
        this.LegRightFourth_2.setRotationPoint(-0.5F, 3.0F, 0.01F);
        this.LegRightFourth_2.addBox(-1.0F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
        this.setRotateAngle(LegRightFourth_2, 0.0F, 0.0F, -1.8325957145940461F);
        this.ArmFrontRight = new PCRendererModel(this, 26, 6);
        this.ArmFrontRight.setRotationPoint(-0.5F, 0.01F, -3.0F);
        this.ArmFrontRight.addBox(0.0F, -0.5F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(ArmFrontRight, 0.0F, -0.7853981633974483F, 0.0F);
        this.LegLeftThird_2 = new PCRendererModel(this, 10, 28);
        this.LegLeftThird_2.setRotationPoint(0.5F, 3.0F, 0.01F);
        this.LegLeftThird_2.addBox(0.0F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
        this.setRotateAngle(LegLeftThird_2, 0.0F, 0.0F, 1.8325957145940461F);
        this.LegRightFourth_1 = new PCRendererModel(this, 35, 23);
        this.LegRightFourth_1.setRotationPoint(-2.2F, 1.0F, 6.2F);
        this.LegRightFourth_1.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(LegRightFourth_1, 0.0F, 0.0F, 2.0943951023931953F);
        this.ScissorSmallRight = new PCRendererModel(this, 26, 16);
        this.ScissorSmallRight.setRotationPoint(0.8F, 0.0F, -0.1F);
        this.ScissorSmallRight.addBox(-0.5F, -0.5F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(ScissorSmallRight, 0.0F, -0.3490658503988659F, 0.0F);
        this.ScissorBigLeft = new PCRendererModel(this, 34, 10);
        this.ScissorBigLeft.setRotationPoint(0.0F, 0.0F, -2.5F);
        this.ScissorBigLeft.addBox(-1.0F, -1.0F, -2.5F, 2, 2, 3, 0.0F);
        this.LegLeftFourth_2 = new PCRendererModel(this, 15, 28);
        this.LegLeftFourth_2.setRotationPoint(0.5F, 3.0F, 0.01F);
        this.LegLeftFourth_2.addBox(0.0F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
        this.setRotateAngle(LegLeftFourth_2, 0.0F, 0.0F, 1.8325957145940461F);
        this.ArmBackLeft = new PCRendererModel(this, 34, 1);
        this.ArmBackLeft.setRotationPoint(2.3F, 0.5F, 0.5F);
        this.ArmBackLeft.addBox(-0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(ArmBackLeft, 0.0F, -0.6981317007977318F, 0.0F);
        this.BodyTop = new PCRendererModel(this, 0, 8);
        this.BodyTop.setRotationPoint(0.0F, -1.1F, 0.0F);
        this.BodyTop.addBox(-2.5F, 0.0F, 0.0F, 5, 1, 6, 0.0F);
        this.ArmFrontLeft = new PCRendererModel(this, 35, 6);
        this.ArmFrontLeft.setRotationPoint(0.5F, 0.01F, -3.0F);
        this.ArmFrontLeft.addBox(-1.0F, -0.5F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(ArmFrontLeft, 0.0F, 0.7853981633974483F, 0.0F);
        this.HatTop = new PCRendererModel(this, 45, 6);
        this.HatTop.setRotationPoint(0.0F, -3.3F, 0.0F);
        this.HatTop.addBox(-1.5F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
        this.Body = new PCRendererModel(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 21.0F, -0.5F);
        this.Body.addBox(-3.0F, 0.0F, 0.0F, 6, 1, 7, 0.0F);
        this.BodyBottom = new PCRendererModel(this, 0, 15);
        this.BodyBottom.setRotationPoint(0.0F, 0.5F, 0.5F);
        this.BodyBottom.addBox(-2.5F, 0.0F, 0.0F, 5, 1, 6, 0.0F);
        this.LegLeftFirst_1 = new PCRendererModel(this, 0, 23);
        this.LegLeftFirst_1.setRotationPoint(2.2F, 1.0F, 0.8F);
        this.LegLeftFirst_1.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(LegLeftFirst_1, 0.0F, 0.0F, -2.0943951023931953F);
        this.LegLeftSecond_1 = new PCRendererModel(this, 5, 23);
        this.LegLeftSecond_1.setRotationPoint(2.2F, 1.0F, 2.6F);
        this.LegLeftSecond_1.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(LegLeftSecond_1, 0.0F, 0.0F, -2.0943951023931953F);
        this.LegRightThird_1 = new PCRendererModel(this, 30, 23);
        this.LegRightThird_1.setRotationPoint(-2.2F, 1.0F, 4.4F);
        this.LegRightThird_1.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(LegRightThird_1, 0.0F, 0.0F, 2.0943951023931953F);
        this.LegLeftThird_1 = new PCRendererModel(this, 10, 23);
        this.LegLeftThird_1.setRotationPoint(2.2F, 1.0F, 4.4F);
        this.LegLeftThird_1.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(LegLeftThird_1, 0.0F, 0.0F, -2.0943951023931953F);
        this.ArmBackRight = new PCRendererModel(this, 25, 1);
        this.ArmBackRight.setRotationPoint(-2.3F, 0.5F, 0.5F);
        this.ArmBackRight.addBox(-0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(ArmBackRight, 0.0F, 0.6981317007977318F, 0.0F);
        this.LegRightFirst_1 = new PCRendererModel(this, 20, 23);
        this.LegRightFirst_1.setRotationPoint(-2.2F, 1.0F, 0.8F);
        this.LegRightFirst_1.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(LegRightFirst_1, 0.0F, 0.0F, 2.0943951023931953F);
        this.Body.addChild(this.LegLeftFourth_1);
        this.ScissorBigLeft.addChild(this.ScissorSmallLeft);
        this.BodyTop.addChild(this.Hat);
        this.LegRightSecond_1.addChild(this.LegRightSecond_2);
        this.Body.addChild(this.LegRightSecond_1);
        this.LegRightThird_1.addChild(this.LegRightThird_2);
        this.LegLeftSecond_1.addChild(this.LegLeftSecond_2);
        this.LegRightFirst_1.addChild(this.LegRightFirst_2);
        this.LegLeftFirst_1.addChild(this.LegLeftFirst_2);
        this.ArmFrontRight.addChild(this.ScissorBigRight);
        this.LegRightFourth_1.addChild(this.LegRightFourth_2);
        this.ArmBackRight.addChild(this.ArmFrontRight);
        this.LegLeftThird_1.addChild(this.LegLeftThird_2);
        this.Body.addChild(this.LegRightFourth_1);
        this.ScissorBigRight.addChild(this.ScissorSmallRight);
        this.ArmFrontLeft.addChild(this.ScissorBigLeft);
        this.LegLeftFourth_1.addChild(this.LegLeftFourth_2);
        this.Body.addChild(this.ArmBackLeft);
        this.BodyBottom.addChild(this.BodyTop);
        this.ArmBackLeft.addChild(this.ArmFrontLeft);
        this.Hat.addChild(this.HatTop);
        this.Body.addChild(this.BodyBottom);
        this.Body.addChild(this.LegLeftFirst_1);
        this.Body.addChild(this.LegLeftSecond_1);
        this.Body.addChild(this.LegRightThird_1);
        this.Body.addChild(this.LegLeftThird_1);
        this.Body.addChild(this.ArmBackRight);
        this.Body.addChild(this.LegRightFirst_1);
        
        bodyParts = new PCRendererModel[] {Body,BodyBottom,ArmBackRight,ArmBackLeft,LegLeftFirst_1,LegLeftSecond_1,LegLeftThird_1,LegLeftFourth_1,LegRightFirst_1,LegRightSecond_1,LegRightThird_1,LegRightFourth_1,BodyTop,Hat,HatTop,ArmFrontRight,ScissorBigRight,ScissorSmallRight,ArmFrontLeft,ScissorBigLeft,ScissorSmallLeft,LegLeftFirst_2,LegLeftSecond_2,LegLeftThird_2,LegLeftFourth_2,LegRightFirst_2,LegRightSecond_2,LegRightThird_2,LegRightFourth_2};
        saveAsDefaultPose();
    }

    @Override
    public void render(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
    	this.setRotationAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        if(entity.getName().getString().equals("fredrick")) {this.Hat.showModel = true;} else {this.Hat.showModel = false;}
        this.Body.render(scale);
    }

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
    	
    	if(entity.prevPosX != entity.posX || entity.prevPosY != entity.posY || entity.prevPosZ != entity.posZ) //Walk Animation
    	{
    		float globalSpeed = 2.0F;
        	float globalHeight = 1.0F;
        	float globalDegree = 1.0F;
        	
        	loadDefaultPose();
    		
        	bounce(Body, 2.0F * globalSpeed, 0.3F * globalHeight, false, limbSwing, limbSwingAmount);
        	swing(Body, 2.0F * globalSpeed, 0.05F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
        	
        	//Legs
        	swing(LegLeftFirst_1, 1.0F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
        	shake(LegLeftFirst_1, 1.0F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
        	flap(LegLeftFirst_1, 1.0F * globalSpeed, 0.2F * globalDegree, false, 2.0F, 0.0F, limbSwing, limbSwingAmount);
        	swing(LegLeftFirst_2, 1.0F * globalSpeed, 0.1F * globalDegree, false, 0.5F, 0.0F, limbSwing, limbSwingAmount);
        	flap(LegLeftFirst_2, 1.0F * globalSpeed, 0.1F * globalDegree, false, 1.5F, 0.0F, limbSwing, limbSwingAmount);
        	
        	swing(LegLeftSecond_1, 1.0F * globalSpeed, 0.1F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
        	shake(LegLeftSecond_1, 1.0F * globalSpeed, 0.1F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
        	flap(LegLeftSecond_1, 1.0F * globalSpeed, 0.2F * globalDegree, true, 2.0F, 0.0F, limbSwing, limbSwingAmount);
        	swing(LegLeftSecond_2, 1.0F * globalSpeed, 0.1F * globalDegree, true, 0.5F, 0.0F, limbSwing, limbSwingAmount);
        	flap(LegLeftSecond_2, 1.0F * globalSpeed, 0.1F * globalDegree, true, 1.5F, 0.0F, limbSwing, limbSwingAmount);
        	
        	swing(LegLeftThird_1, 1.0F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
        	shake(LegLeftThird_1, 1.0F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
        	flap(LegLeftThird_1, 1.0F * globalSpeed, 0.2F * globalDegree, false, 2.0F, 0.0F, limbSwing, limbSwingAmount);
        	swing(LegLeftThird_2, 1.0F * globalSpeed, 0.1F * globalDegree, false, 0.5F, 0.0F, limbSwing, limbSwingAmount);
        	flap(LegLeftThird_2, 1.0F * globalSpeed, 0.1F * globalDegree, false, 1.5F, 0.0F, limbSwing, limbSwingAmount);
        	
        	swing(LegLeftFourth_1, 1.0F * globalSpeed, 0.1F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
        	shake(LegLeftFourth_1, 1.0F * globalSpeed, 0.1F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
        	flap(LegLeftFourth_1, 1.0F * globalSpeed, 0.2F * globalDegree, true, 2.0F, 0.0F, limbSwing, limbSwingAmount);
        	swing(LegLeftFourth_2, 1.0F * globalSpeed, 0.1F * globalDegree, true, 0.5F, 0.0F, limbSwing, limbSwingAmount);
        	flap(LegLeftFourth_2, 1.0F * globalSpeed, 0.1F * globalDegree, true, 1.5F, 0.0F, limbSwing, limbSwingAmount);
        	
        	swing(LegRightFirst_1, 1.0F * globalSpeed, 0.1F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
        	shake(LegRightFirst_1, 1.0F * globalSpeed, 0.1F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
        	flap(LegRightFirst_1, 1.0F * globalSpeed, 0.2F * globalDegree, false, 2.0F, 0.0F, limbSwing, limbSwingAmount);
        	swing(LegRightFirst_2, 1.0F * globalSpeed, 0.1F * globalDegree, false, 0.5F, 0.0F, limbSwing, limbSwingAmount);
        	flap(LegRightFirst_2, 1.0F * globalSpeed, 0.1F * globalDegree, false, 1.5F, 0.0F, limbSwing, limbSwingAmount);
        	
        	swing(LegRightSecond_1, 1.0F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
        	shake(LegRightSecond_1, 1.0F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
        	flap(LegRightSecond_1, 1.0F * globalSpeed, 0.2F * globalDegree, true, 2.0F, 0.0F, limbSwing, limbSwingAmount);
        	swing(LegRightSecond_2, 1.0F * globalSpeed, 0.1F * globalDegree, true, 0.5F, 0.0F, limbSwing, limbSwingAmount);
        	flap(LegRightSecond_2, 1.0F * globalSpeed, 0.1F * globalDegree, true, 1.5F, 0.0F, limbSwing, limbSwingAmount);
        	
        	swing(LegRightThird_1, 1.0F * globalSpeed, 0.1F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
        	shake(LegRightThird_1, 1.0F * globalSpeed, 0.1F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
        	flap(LegRightThird_1, 1.0F * globalSpeed, 0.2F * globalDegree, false, 2.0F, 0.0F, limbSwing, limbSwingAmount);
        	swing(LegRightThird_2, 1.0F * globalSpeed, 0.1F * globalDegree, false, 0.5F, 0.0F, limbSwing, limbSwingAmount);
        	flap(LegRightThird_2, 1.0F * globalSpeed, 0.1F * globalDegree, false, 1.5F, 0.0F, limbSwing, limbSwingAmount);
        	
        	swing(LegRightFourth_1, 1.0F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
        	shake(LegRightFourth_1, 1.0F * globalSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
        	flap(LegRightFourth_1, 1.0F * globalSpeed, 0.2F * globalDegree, true, 2.0F, 0.0F, limbSwing, limbSwingAmount);
        	swing(LegRightFourth_2, 1.0F * globalSpeed, 0.1F * globalDegree, true, 0.5F, 0.0F, limbSwing, limbSwingAmount);
        	flap(LegRightFourth_2, 1.0F * globalSpeed, 0.1F * globalDegree, true, 1.5F, 0.0F, limbSwing, limbSwingAmount);
        	
        	//Claws
        	swing(ArmBackLeft, 2.0F * globalSpeed, 0.05F * globalDegree, true, 0.2F, 0.0F, limbSwing, limbSwingAmount);
        	swing(ArmBackRight, 2.0F * globalSpeed, 0.05F * globalDegree, true, 0.2F, 0.0F, limbSwing, limbSwingAmount);
        	
        	swing(ArmFrontLeft, 2.0F * globalSpeed, 0.05F * globalDegree, false, 0.2F, 0.0F, limbSwing, limbSwingAmount);
        	swing(ArmFrontRight, 2.0F * globalSpeed, 0.05F * globalDegree, false, 0.2F, 0.0F, limbSwing, limbSwingAmount);
        	shake(ArmFrontLeft, 2.0F * globalSpeed, 0.03F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
        	shake(ArmFrontRight, 2.0F * globalSpeed, 0.03F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
        	
        	shake(ScissorSmallLeft, 1.2F * globalSpeed, 0.2F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
        	shake(ScissorSmallRight, 1.2F * globalSpeed, 0.2F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
    	}
    	else
    	{
    		if(entity.isPartying())//Dance Animation
    		{
    			float globalSpeed = 0.6F;
	        	float globalHeight = 1.0F;
	        	float globalDegree = 1.0F;
	        	
	        	limbSwing = entity.ticksExisted;
	        	limbSwingAmount = 1;
	        	
	        	loadDefaultPose();
	        	
	        	this.Body.offsetY += Math.toRadians(-5);
	        	this.Body.rotateAngleX += Math.toRadians(-20);
	        	bounce(Body, 1.0F * globalSpeed, 0.8F * globalHeight, false, limbSwing, limbSwingAmount);
	        	swing(Body, 1.0F * globalSpeed, 0.1F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	        	shake(Body, 0.5F * globalSpeed, 0.3F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	        	
	        	this.ArmBackLeft.rotateAngleX += Math.toRadians(-60);
	        	this.ArmBackLeft.rotateAngleZ += Math.toRadians(20);
	        	flap(ArmBackLeft, 0.5F * globalSpeed, 0.6F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	        	swing(ArmFrontLeft, 0.5F * globalSpeed, 0.3F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	        	flap(ArmFrontLeft, 0.5F * globalSpeed, 0.5F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	        	
	        	this.ArmBackRight.rotateAngleX += Math.toRadians(-60);
	        	this.ArmBackRight.rotateAngleZ += Math.toRadians(-20);
	        	flap(ArmBackRight, 0.5F * globalSpeed, 0.6F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	        	swing(ArmFrontRight, 0.5F * globalSpeed, 0.3F * globalDegree, true, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	        	flap(ArmFrontRight, 0.5F * globalSpeed, 0.5F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	        	
	        	shake(ScissorSmallLeft, 1.2F * globalSpeed, 0.4F * globalDegree, false, 2.0F, 0.1F, limbSwing, limbSwingAmount);
	        	shake(ScissorSmallRight, 1.2F * globalSpeed, 0.4F * globalDegree, false, 2.0F, -0.1F, limbSwing, limbSwingAmount);
	        	
	        	flap(LegLeftFirst_1, 0.5F * globalSpeed, 0.3F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	        	flap(LegLeftFirst_2, 0.5F * globalSpeed, 0.3F * globalDegree, false, 0.0F, -0.3F, limbSwing, limbSwingAmount);
	        	flap(LegRightFirst_1, 0.5F * globalSpeed, 0.3F * globalDegree, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
	        	flap(LegRightFirst_2, 0.5F * globalSpeed, 0.3F * globalDegree, false, 0.0F, 0.3F, limbSwing, limbSwingAmount);
	        	
	        	flap(LegLeftSecond_1, 0.5F * globalSpeed, 0.3F * globalDegree, false, 1.0F, 0.0F, limbSwing, limbSwingAmount);
	        	flap(LegLeftSecond_2, 0.5F * globalSpeed, 0.3F * globalDegree, false, 1.0F, -0.3F, limbSwing, limbSwingAmount);
	        	flap(LegRightSecond_1, 0.5F * globalSpeed, 0.3F * globalDegree, false, 1.0F, 0.0F, limbSwing, limbSwingAmount);
	        	flap(LegRightSecond_2, 0.5F * globalSpeed, 0.3F * globalDegree, false, 1.0F, 0.3F, limbSwing, limbSwingAmount);
	        	
	        	this.LegLeftThird_1.rotateAngleY += Math.toRadians(17);
	        	this.LegLeftThird_1.rotateAngleX += Math.toRadians(-10);
	        	flap(LegLeftThird_1, 1.0F * globalSpeed, 0.4F * globalDegree, false, 2.0F, 0.0F, limbSwing, limbSwingAmount);
	        	flap(LegLeftThird_2, 1.0F * globalSpeed, 0.3F * globalDegree, true, 2.0F, 0.0F, limbSwing, limbSwingAmount);
	        	
	        	this.LegRightThird_1.rotateAngleY += Math.toRadians(-17);
	        	this.LegRightThird_1.rotateAngleX += Math.toRadians(-10);
	        	flap(LegRightThird_1, 1.0F * globalSpeed, 0.4F * globalDegree, true, 2.0F, 0.0F, limbSwing, limbSwingAmount);
	        	flap(LegRightThird_2, 1.0F * globalSpeed, 0.3F * globalDegree, false, 2.0F, 0.0F, limbSwing, limbSwingAmount);
	        	
	        	this.LegLeftFourth_1.rotateAngleY += Math.toRadians(17);
	        	this.LegLeftFourth_1.rotateAngleX += Math.toRadians(-10);
	        	flap(LegLeftFourth_1, 1.0F * globalSpeed, 0.4F * globalDegree, false, 2.0F, 0.0F, limbSwing, limbSwingAmount);
	        	flap(LegLeftFourth_2, 1.0F * globalSpeed, 0.3F * globalDegree, true, 2.0F, 0.0F, limbSwing, limbSwingAmount);
	        	
	        	this.LegRightFourth_1.rotateAngleY += Math.toRadians(-17);
	        	this.LegRightFourth_1.rotateAngleX += Math.toRadians(-10);
	        	flap(LegRightFourth_1, 1.0F * globalSpeed, 0.4F * globalDegree, true, 2.0F, 0.0F, limbSwing, limbSwingAmount);
	        	flap(LegRightFourth_2, 1.0F * globalSpeed, 0.3F * globalDegree, false, 2.0F, 0.0F, limbSwing, limbSwingAmount);
	        	
	        	swing(LegLeftThird_2, 1.0F * globalSpeed, 0.2F * globalDegree, true, 0.6F, 0.0F, limbSwing, limbSwingAmount);
	        	swing(LegLeftFourth_2, 1.0F * globalSpeed, 0.2F * globalDegree, true, 1.6F, 0.0F, limbSwing, limbSwingAmount);
	        	
	        	swing(LegLeftThird_2, 1.0F * globalSpeed, 0.2F * globalDegree, false, 0.6F, 0.0F, limbSwing, limbSwingAmount);
	        	swing(LegLeftFourth_2, 1.0F * globalSpeed, 0.2F * globalDegree, false, 1.6F, 0.0F, limbSwing, limbSwingAmount);
	        }
    		else//Idle Animation
    		{
	    		float globalSpeed = 0.4F;
	        	float globalHeight = 1.0F;
	        	float globalDegree = 1.0F;
	        	
	        	limbSwing = entity.ticksExisted;
	        	limbSwingAmount = 1;
	        	
	        	loadDefaultPose();
	        	
	        	bounce(Body, 1.0F * globalSpeed, 0.2F * globalHeight, false, limbSwing, limbSwingAmount);
	        	
	        	//Legs
	        	flap(LegLeftFirst_1, 1.0F * globalSpeed, 0.05F * globalDegree, false, 1.2F, 0.0F, limbSwing, limbSwingAmount);
	        	flap(LegLeftFirst_2, 1.0F * globalSpeed, 0.04F * globalDegree, true, 1.2F, 0.0F, limbSwing, limbSwingAmount);
	        	flap(LegLeftSecond_1, 1.0F * globalSpeed, 0.05F * globalDegree, false, 1.4F, 0.0F, limbSwing, limbSwingAmount);
	        	flap(LegLeftSecond_2, 1.0F * globalSpeed, 0.04F * globalDegree, true, 1.4F, 0.0F, limbSwing, limbSwingAmount);
	        	flap(LegLeftThird_1, 1.0F * globalSpeed, 0.05F * globalDegree, false, 1.2F, 0.0F, limbSwing, limbSwingAmount);
	        	flap(LegLeftThird_2, 1.0F * globalSpeed, 0.04F * globalDegree, true, 1.2F, 0.0F, limbSwing, limbSwingAmount);
	        	flap(LegLeftFourth_1, 1.0F * globalSpeed, 0.05F * globalDegree, false, 1.4F, 0.0F, limbSwing, limbSwingAmount);
	        	flap(LegLeftFourth_2, 1.0F * globalSpeed, 0.04F * globalDegree, true, 1.4F, 0.0F, limbSwing, limbSwingAmount);
	        	
	        	flap(LegRightFirst_1, 1.0F * globalSpeed, 0.05F * globalDegree, true, 1.2F, 0.0F, limbSwing, limbSwingAmount);
	        	flap(LegRightFirst_2, 1.0F * globalSpeed, 0.04F * globalDegree, false, 1.2F, 0.0F, limbSwing, limbSwingAmount);
	        	flap(LegRightSecond_1, 1.0F * globalSpeed, 0.05F * globalDegree, true, 1.4F, 0.0F, limbSwing, limbSwingAmount);
	        	flap(LegRightSecond_2, 1.0F * globalSpeed, 0.04F * globalDegree, false, 1.4F, 0.0F, limbSwing, limbSwingAmount);
	        	flap(LegRightThird_1, 1.0F * globalSpeed, 0.05F * globalDegree, true, 1.2F, 0.0F, limbSwing, limbSwingAmount);
	        	flap(LegRightThird_2, 1.0F * globalSpeed, 0.04F * globalDegree, false, 1.2F, 0.0F, limbSwing, limbSwingAmount);
	        	flap(LegRightFourth_1, 1.0F * globalSpeed, 0.05F * globalDegree, true, 1.4F, 0.0F, limbSwing, limbSwingAmount);
	        	flap(LegRightFourth_2, 1.0F * globalSpeed, 0.04F * globalDegree, false, 1.4F, 0.0F, limbSwing, limbSwingAmount);
	        	
	        	//Claws
	        	swing(ArmBackLeft, 1.0F * globalSpeed, 0.05F * globalDegree, true, 1.2F, 0.0F, limbSwing, limbSwingAmount);
	        	swing(ArmBackRight, 1.0F * globalSpeed, 0.05F * globalDegree, true, 1.2F, 0.0F, limbSwing, limbSwingAmount);
	        	
	        	swing(ArmFrontLeft, 1.0F * globalSpeed, 0.05F * globalDegree, false, 1.2F, 0.0F, limbSwing, limbSwingAmount);
	        	swing(ArmFrontRight, 1.0F * globalSpeed, 0.05F * globalDegree, false, 1.2F, 0.0F, limbSwing, limbSwingAmount);
	        	shake(ArmFrontLeft, 1.0F * globalSpeed, 0.03F * globalDegree, false, 1.0F, 0.0F, limbSwing, limbSwingAmount);
	        	shake(ArmFrontRight, 1.0F * globalSpeed, 0.03F * globalDegree, true, 1.0F, 0.0F, limbSwing, limbSwingAmount);
    		}
    	}
    }
}