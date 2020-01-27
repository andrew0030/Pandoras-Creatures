package andrews.pandoras_creatures.objects.armors;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelPlayer - Either Mojang or a mod author
 * Created using Tabula 7.1.0
 */
public class PlantHatModel<T extends LivingEntity> extends BipedModel<T>
{
    public RendererModel hat_base;
    public RendererModel wood_beam;
    public RendererModel wood_beam_1;
    public RendererModel wood_beam_2;
    public RendererModel wood_beam_3;
    public RendererModel wood_beam_4;
    public RendererModel wood_beam_5;
    public RendererModel wood_beam_6;
    public RendererModel wood_beam_7;
    public RendererModel plants;
    public RendererModel plants_1;
    public RendererModel plants_2;
    public RendererModel plants_3;
    public RendererModel plants_4;
    public RendererModel plants_5;
    public RendererModel plants_6;
    public RendererModel plants_7;
    public RendererModel top_plants;
    public RendererModel top_plants_1;
    public RendererModel top_plants_2;
    public RendererModel top_plants_3;
    public RendererModel hanging_plants;
    public RendererModel hanging_plants_1;
    public RendererModel hanging_plants_2;
    public RendererModel strap;
    public RendererModel strap_1;
    public RendererModel strap_2;

    public PlantHatModel(float scale)
    {
    	super(scale, 0, 128, 64);
    	this.top_plants_1 = new RendererModel(this, 52, 14);
        this.top_plants_1.setRotationPoint(0.0F, -13.0F, 3.0F);
        this.top_plants_1.addBox(-6.0F, 0.0F, -2.0F, 12, 0, 12, 0.0F);
        this.setRotateAngle(top_plants_1, -0.619591884457987F, 0.0F, 0.0F);
        this.top_plants_3 = new RendererModel(this, 92, 26);
        this.top_plants_3.setRotationPoint(-3.0F, -13.0F, 0.0F);
        this.top_plants_3.addBox(-10.0F, 0.0F, -6.0F, 12, 0, 12, 0.0F);
        this.setRotateAngle(top_plants_3, 0.0F, 0.0F, -0.6283185307179586F);
        this.wood_beam_2 = new RendererModel(this, 106, 2);
        this.wood_beam_2.setRotationPoint(3.0F, -9.0F, 0.0F);
        this.wood_beam_2.addBox(0.0F, 0.0F, -0.5F, 10, 1, 1, 0.0F);
        this.setRotateAngle(wood_beam_2, 0.0F, 0.0F, 0.2181661564992912F);
        this.wood_beam_5 = new RendererModel(this, 108, 10);
        this.wood_beam_5.setRotationPoint(-3.0F, -9.01F, -3.0F);
        this.wood_beam_5.addBox(-1.0F, 0.0F, -0.5F, 9, 1, 1, 0.0F);
        this.setRotateAngle(wood_beam_5, 0.0F, 2.356194490192345F, 0.0F);
        this.plants_3 = new RendererModel(this, 71, 45);
        this.plants_3.setRotationPoint(-0.2F, -8.7F, 3.0F);
        this.plants_3.addBox(-8.0F, 0.0F, 0.0F, 8, 0, 10, 0.0F);
        this.setRotateAngle(plants_3, -0.22689280275926282F, 0.0F, 0.08726646259971647F);
        this.wood_beam = new RendererModel(this, 94, 2);
        this.wood_beam.setRotationPoint(0.0F, -9.0F, -2.8F);
        this.wood_beam.addBox(-0.5F, 0.0F, -10.0F, 1, 1, 10, 0.0F);
        this.setRotateAngle(wood_beam, -0.148352986419518F, 0.0F, 0.0F);
        this.plants_7 = new RendererModel(this, 90, 38);
        this.plants_7.setRotationPoint(-3.0F, -8.7F, -0.3F);
        this.plants_7.addBox(-10.0F, 0.0F, -8.0F, 10, 0, 8, 0.0F);
        this.setRotateAngle(plants_7, -0.10471975511965977F, 0.0F, -0.22689280275926282F);
        this.hanging_plants_1 = new RendererModel(this, 94, 1);
        this.hanging_plants_1.setRotationPoint(0.0F, -7.3F, 5.3F);
        this.hanging_plants_1.addBox(0.0F, 0.0F, 0.0F, 0, 6, 5, 0.0F);
        this.plants_2 = new RendererModel(this, 54, 43);
        this.plants_2.setRotationPoint(0.2F, -8.7F, 3.0F);
        this.plants_2.addBox(0.0F, 0.0F, 0.0F, 8, 0, 10, 0.0F);
        this.setRotateAngle(plants_2, -0.22689280275926282F, 0.0F, -0.08726646259971647F);
        this.plants_4 = new RendererModel(this, 94, 56);
        this.plants_4.setRotationPoint(3.0F, -8.8F, 0.3F);
        this.plants_4.addBox(0.0F, 0.0F, 0.0F, 10, 0, 8, 0.0F);
        this.setRotateAngle(plants_4, 0.06981317007977318F, 0.0F, 0.22689280275926282F);
        this.strap_1 = new RendererModel(this, 119, 39);
        this.strap_1.setRotationPoint(4.5F, 0.0F, 0.0F);
        this.strap_1.addBox(-1.0F, -8.0F, 0.0F, 1, 8, 1, 0.0F);
        this.plants = new RendererModel(this, 54, 54);
        this.plants.setRotationPoint(0.2F, -8.8F, -3.0F);
        this.plants.addBox(0.0F, 0.0F, -10.0F, 8, 0, 10, 0.0F);
        this.setRotateAngle(plants, -0.1361356816555577F, 0.0F, 0.1361356816555577F);
        this.strap_2 = new RendererModel(this, 124, 39);
        this.strap_2.setRotationPoint(-4.5F, 0.0F, 0.0F);
        this.strap_2.addBox(0.0F, -8.0F, 0.0F, 1, 8, 1, 0.0F);
        this.wood_beam_1 = new RendererModel(this, 82, 3);
        this.wood_beam_1.setRotationPoint(0.0F, -9.0F, 3.0F);
        this.wood_beam_1.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 10, 0.0F);
        this.setRotateAngle(wood_beam_1, -0.2181661564992912F, 0.0F, 0.0F);
        this.wood_beam_6 = new RendererModel(this, 108, 4);
        this.wood_beam_6.setRotationPoint(3.0F, -9.01F, 3.0F);
        this.wood_beam_6.addBox(-1.0F, 0.0F, -0.5F, 9, 1, 1, 0.0F);
        this.setRotateAngle(wood_beam_6, 0.0F, -0.7853981633974483F, 0.08726646259971647F);
        this.wood_beam_7 = new RendererModel(this, 108, 6);
        this.wood_beam_7.setRotationPoint(-3.0F, -9.01F, 3.0F);
        this.wood_beam_7.addBox(-1.0F, 0.0F, -0.5F, 9, 1, 1, 0.0F);
        this.setRotateAngle(wood_beam_7, 0.0F, -2.356194490192345F, -0.08726646259971647F);
        this.hanging_plants = new RendererModel(this, 94, -5);
        this.hanging_plants.setRotationPoint(-8.0F, -8.4F, -8.0F);
        this.hanging_plants.addBox(0.0F, 0.0F, 0.0F, 0, 6, 5, 0.0F);
        this.setRotateAngle(hanging_plants, 0.0F, 0.7853981633974483F, 0.0F);
        this.plants_6 = new RendererModel(this, 90, 47);
        this.plants_6.setRotationPoint(-3.0F, -8.8F, 0.3F);
        this.plants_6.addBox(-10.0F, 0.0F, 0.0F, 10, 0, 8, 0.0F);
        this.setRotateAngle(plants_6, 0.06981317007977318F, 0.0F, -0.22689280275926282F);
        this.hat_base = new RendererModel(this, 104, 15);
        this.hat_base.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.hat_base.addBox(-3.0F, -13.0F, -3.0F, 6, 5, 6, 0.0F);
        this.setRotateAngle(hat_base, 0.0F, 0.0F, 0.012740903539558604F);
        this.hanging_plants_2 = new RendererModel(this, 89, 9);
        this.hanging_plants_2.setRotationPoint(4.0F, -8.0F, -4.0F);
        this.hanging_plants_2.addBox(0.0F, 0.0F, 0.0F, 0, 6, 6, 0.0F);
        this.setRotateAngle(hanging_plants_2, 0.0F, 2.356194490192345F, 0.0F);
        this.wood_beam_3 = new RendererModel(this, 106, 8);
        this.wood_beam_3.setRotationPoint(-3.0F, -9.0F, 0.0F);
        this.wood_beam_3.addBox(-10.0F, 0.0F, -0.5F, 10, 1, 1, 0.0F);
        this.setRotateAngle(wood_beam_3, 0.0F, 0.0F, -0.2181661564992912F);
        this.wood_beam_4 = new RendererModel(this, 108, 0);
        this.wood_beam_4.setRotationPoint(3.0F, -9.01F, -3.0F);
        this.wood_beam_4.addBox(-1.0F, 0.0F, -0.5F, 9, 1, 1, 0.0F);
        this.setRotateAngle(wood_beam_4, 0.0F, 0.7853981633974483F, 0.0F);
        this.plants_5 = new RendererModel(this, 73, 56);
        this.plants_5.setRotationPoint(3.0F, -8.7F, -0.3F);
        this.plants_5.addBox(0.0F, 0.0F, -8.0F, 10, 0, 8, 0.0F);
        this.setRotateAngle(plants_5, -0.10471975511965977F, 0.0F, 0.22689280275926282F);
        this.plants_1 = new RendererModel(this, 54, 32);
        this.plants_1.setRotationPoint(-0.2F, -8.8F, -3.0F);
        this.plants_1.addBox(-8.0F, 0.0F, -10.0F, 8, 0, 10, 0.0F);
        this.setRotateAngle(plants_1, -0.1361356816555577F, 0.0F, -0.1361356816555577F);
        this.strap = new RendererModel(this, 108, 13);
        this.strap.setRotationPoint(0.0F, -0.5F, -3.5F);
        this.strap.addBox(-4.5F, 0.0F, 0.0F, 9, 1, 1, 0.0F);
        this.setRotateAngle(strap, -0.3700098014227978F, 0.0F, 0.0F);
        this.top_plants_2 = new RendererModel(this, 68, 26);
        this.top_plants_2.setRotationPoint(3.0F, -13.0F, 0.0F);
        this.top_plants_2.addBox(-2.0F, 0.0F, -6.0F, 12, 0, 12, 0.0F);
        this.setRotateAngle(top_plants_2, 0.0F, 0.0F, 0.6283185307179586F);
        this.top_plants = new RendererModel(this, 52, 0);
        this.top_plants.setRotationPoint(0.0F, -13.0F, -3.0F);
        this.top_plants.addBox(-6.0F, 0.0F, -10.0F, 12, 0, 12, 0.0F);
        this.setRotateAngle(top_plants, 0.35779249665883756F, 0.0F, 0.0F);
        this.hat_base.addChild(this.top_plants_1);
        this.hat_base.addChild(this.top_plants_3);
        this.hat_base.addChild(this.wood_beam_2);
        this.hat_base.addChild(this.wood_beam_5);
        this.hat_base.addChild(this.plants_3);
        this.hat_base.addChild(this.wood_beam);
        this.hat_base.addChild(this.plants_7);
        this.hat_base.addChild(this.hanging_plants_1);
        this.hat_base.addChild(this.plants_2);
        this.hat_base.addChild(this.plants_4);
        this.strap.addChild(this.strap_1);
        this.hat_base.addChild(this.plants);
        this.strap.addChild(this.strap_2);
        this.hat_base.addChild(this.wood_beam_1);
        this.hat_base.addChild(this.wood_beam_6);
        this.hat_base.addChild(this.wood_beam_7);
        this.hat_base.addChild(this.hanging_plants);
        this.hat_base.addChild(this.plants_6);
        this.hat_base.addChild(this.hanging_plants_2);
        this.hat_base.addChild(this.wood_beam_3);
        this.hat_base.addChild(this.wood_beam_4);
        this.hat_base.addChild(this.plants_5);
        this.hat_base.addChild(this.plants_1);
        this.hat_base.addChild(this.strap);
        this.hat_base.addChild(this.top_plants_2);
        this.hat_base.addChild(this.top_plants);
        
        this.bipedHead.addChild(this.hat_base);
    }

    @Override
    public void render(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
    	super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
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
    	if(!(entityIn instanceof ArmorStandEntity))
    	{
    		super.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
    	}
    	
    	//Moves the Hat slightly down on armor stands so it doesnt float in the air
    	if(entityIn instanceof ArmorStandEntity)
    	{
    		this.hat_base.offsetY = 0.12F;
    	}
    	
    	//Some movement to make the hat look better
    	if(entityIn.posX != entityIn.prevPosX || entityIn.posZ != entityIn.prevPosZ)
    	{
    		//Moves the hanging grass parts on the right side of the hat
    		this.hanging_plants.rotateAngleZ += calculateRotation(0.4F, 0.12F, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
    		this.hanging_plants.rotateAngleY += calculateRotation(0.4F, 0.1F, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
    		
    		//Moves the hanging grass parts on the back side of the hat
    		this.hanging_plants_1.rotateAngleZ += calculateRotation(0.4F, 0.12F, false, 0.0F, 0.05F, limbSwing, limbSwingAmount);
    		this.hanging_plants_1.rotateAngleY += calculateRotation(0.4F, 0.1F, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
    		
    		//Moves the hanging grass parts on the left side of the hat
    		this.hanging_plants_2.rotateAngleZ += calculateRotation(0.4F, 0.02F, false, 0.0F, -0.1F, limbSwing, limbSwingAmount);
    		this.hanging_plants_2.rotateAngleY += calculateRotation(0.4F, 0.04F, false, 0.0F, 0.0F, limbSwing, limbSwingAmount);
    	}
    }
    
    /**
     * Helper Method used to calculate rotation for moving model parts
     */
    private float calculateRotation(float speed, float degree, boolean invert, float delay, float weight, float limbSwing, float limbSwingAmount)
    {
        float movementScale = 1.0F;
        if(invert == true)
        {
        	float rotation = (MathHelper.cos(limbSwing * (speed * movementScale) + delay) * (degree * movementScale) * limbSwingAmount) - (weight * limbSwingAmount);
        	return -rotation;
        }
        else
        {
        	float rotation = (MathHelper.cos(limbSwing * (speed * movementScale) + delay) * (degree * movementScale) * limbSwingAmount) + (weight * limbSwingAmount);
        	return rotation;
        }
    }
}