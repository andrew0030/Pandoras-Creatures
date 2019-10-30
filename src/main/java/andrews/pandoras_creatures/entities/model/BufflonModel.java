package andrews.pandoras_creatures.entities.model;

import andrews.pandoras_creatures.entities.BufflonEntity;
import andrews.pandoras_creatures.util.animation.ModelAnimator;
import andrews.pandoras_creatures.util.animation.PCEntityModel;
import andrews.pandoras_creatures.util.animation.PCRendererModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * TestModel - andrew0030
 * Created using Tabula 7.0.0
 */
@OnlyIn(Dist.CLIENT)
public class BufflonModel<T extends BufflonEntity> extends PCEntityModel<T>
{
    public PCRendererModel body;
    public PCRendererModel right_leg_top;
    public PCRendererModel left_leg_top;
    public PCRendererModel right_arm_top;
    public PCRendererModel left_arm_top;
    public PCRendererModel head;
    public PCRendererModel right_leg_bottom;
    public PCRendererModel left_leg_bottom;
    public PCRendererModel right_arm_bottom;
    public PCRendererModel left_arm_bottom;
    public PCRendererModel nose;
    
    public ModelAnimator animator = new ModelAnimator();

    public BufflonModel()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.left_leg_top = new PCRendererModel(this, 0, 0);
        this.left_leg_top.setRotationPoint(2.0F, 3.0F, 0.0F);
        this.left_leg_top.addBox(0.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.right_leg_bottom = new PCRendererModel(this, 0, 0);
        this.right_leg_bottom.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.right_leg_bottom.addBox(-2.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.left_arm_top = new PCRendererModel(this, 0, 0);
        this.left_arm_top.setRotationPoint(2.0F, -3.0F, 0.0F);
        this.left_arm_top.addBox(0.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(left_arm_top, 0.0F, 0.0F, -0.6108652381980153F);
        this.body = new PCRendererModel(this, 0, 0);
        this.body.setRotationPoint(0.0F, 13.0F, 0.0F);
        this.body.addBox(-2.0F, -4.0F, -1.5F, 4, 8, 3, 0.0F);
        this.right_leg_top = new PCRendererModel(this, 0, 0);
        this.right_leg_top.setRotationPoint(-2.0F, 3.0F, 0.0F);
        this.right_leg_top.addBox(-2.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.left_arm_bottom = new PCRendererModel(this, 0, 0);
        this.left_arm_bottom.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.left_arm_bottom.addBox(0.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(left_arm_bottom, 0.0F, 0.0F, 0.2617993877991494F);
        this.head = new PCRendererModel(this, 0, 0);
        this.head.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.head.addBox(-2.0F, -4.0F, -2.0F, 4, 4, 4, 0.0F);
        this.right_arm_bottom = new PCRendererModel(this, 0, 0);
        this.right_arm_bottom.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.right_arm_bottom.addBox(-2.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(right_arm_bottom, 0.0F, 0.0F, -0.2617993877991494F);
        this.nose = new PCRendererModel(this, 0, 0);
        this.nose.setRotationPoint(0.0F, -1.5F, -2.0F);
        this.nose.addBox(-0.5F, 0.0F, -1.0F, 1, 2, 1, 0.0F);
        this.right_arm_top = new PCRendererModel(this, 0, 0);
        this.right_arm_top.setRotationPoint(-2.0F, -3.0F, 0.0F);
        this.right_arm_top.addBox(-2.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(right_arm_top, 0.0F, 0.0F, 0.6108652381980153F);
        this.left_leg_bottom = new PCRendererModel(this, 0, 0);
        this.left_leg_bottom.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.left_leg_bottom.addBox(0.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.body.addChild(this.left_leg_top);
        this.right_leg_top.addChild(this.right_leg_bottom);
        this.body.addChild(this.left_arm_top);
        this.body.addChild(this.right_leg_top);
        this.left_arm_top.addChild(this.left_arm_bottom);
        this.body.addChild(this.head);
        this.right_arm_top.addChild(this.right_arm_bottom);
        this.head.addChild(this.nose);
        this.body.addChild(this.right_arm_top);
        this.left_leg_top.addChild(this.left_leg_bottom);
        
        bodyParts = new PCRendererModel[] {body,right_leg_top,left_leg_top,right_arm_top,left_arm_top,head,right_leg_bottom,left_leg_bottom,right_arm_bottom,left_arm_bottom,nose};
        saveAllDefaultValues();
    }

    @Override
    public void render(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
    	this.setRotationAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
    	this.animate(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.body.render(scale);
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
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor)
    {
    	super.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
    	
    }
    
    private void animate(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor)
    {
    	this.animator.updateAnimations(entityIn);
    	if(entityIn.isAnimationPlaying(BufflonEntity.TEST_ANIMATION))
    	{
    		this.animator.setAnimationToPlay(BufflonEntity.TEST_ANIMATION);
    		
    		this.animator.startKeyframe(10);
    		this.animator.rotate(right_arm_top, 0.3F, 0.0F, 0.0F);
    		this.animator.rotate(left_arm_top, -0.3F, 0.0F, 0.0F);
    		this.animator.endKeyframe();
  
    		this.animator.setStaticKeyframe(20);
    		
    		this.animator.startKeyframe(10);
    		this.animator.rotate(right_arm_top, -0.3F, 0.0F, 0.0F);
    		this.animator.rotate(left_arm_top, 0.3F, 0.0F, 0.0F);
    		this.animator.endKeyframe();

    		this.animator.setStaticKeyframe(20);
    		
    		this.animator.startKeyframe(10);
    		this.animator.rotate(right_arm_top, 0.3F, 0.0F, 0.0F);
    		this.animator.rotate(left_arm_top, -0.3F, 0.0F, 0.0F);
    		this.animator.endKeyframe();
    	}
    	else
    	{
    		loadDefaultBoxValues();
    	}
    }
}
