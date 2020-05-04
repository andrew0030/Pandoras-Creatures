package andrews.pandoras_creatures.util.animation;

import java.util.List;

import com.google.common.collect.Lists;

import andrews.pandoras_creatures.entities.bases.IAnimatedEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public abstract class PCEntityModel<E extends Entity & IAnimatedEntity> extends EntityModel<E>
{
	protected List<PCModelRenderer> cuboids = Lists.newArrayList();
	private PCModelRenderer scaleController;
	protected Animator animator = new Animator();
	protected E entity;

//	protected PCModelRenderer[] bodyParts;
//	private float movementScale = 1.0F;       //TODO update this shit
	
	//======================================================================================================================================================
	//======================================================================================================================================================
	//======================================================================================================================================================
	//======================================================================================================================================================
	
	/**
	 * Saves all needed information for both the loop animation system and the keyframe system
	 */
	public void saveAllDefaultValues()
	{
		saveDefaultBoxValues();
//		saveAsDefaultPose();
	}
	
	/**
	 * Loads all needed information for both the loop animation system and the keyframe system
	 */
	public void loadAllDefaultValues()
	{
		loadDefaultBoxValues();
//		loadDefaultPose();
	}
	
	//======================================================================================================================================================
	
	/**
	 * This will go through all body parts saved in the bodyParts array, and then save their information (rotation point. rotation angle, offset) as the default options
	 */
	public void saveDefaultBoxValues()
	{
		this.cuboids.forEach((rendererModel) ->
		{
			if(rendererModel instanceof PCModelRenderer)
			{
				((PCModelRenderer) rendererModel).saveDefaultBoxValues();
			}
		});
//		for(PCModelRenderer bodyPart : bodyParts)
//        {
//        	bodyPart.saveDefaultBoxValues();
//        }
	}
	
	/**
     * This will go through all body parts saved in the bodyParts array, and then load their information (rotation point. rotation angle, offset) from the default options
     */
	public void loadDefaultBoxValues()
	{
		this.cuboids.forEach((rendererModel) ->
		{
			if(rendererModel instanceof PCModelRenderer)
			{
				((PCModelRenderer) rendererModel).loadDefaultBoxValues();
			}
		});
//		for(PCModelRenderer bodyPart : bodyParts)
//        {
//        	bodyPart.loadDefaultBoxValues();
//        }
	}
	
	/**
	 * This will go through all body parts saved in the bodyParts array, and then save their information (position. rotation, offset) as the default options
	 */
//    public void saveAsDefaultPose()
//    {
//        for(PCModelRenderer bodyPart : bodyParts)
//        {
//        	bodyPart.saveAsDefaultPose();
//        }
//    }

    /**
     * This will go through all body parts saved in the bodyParts array, and then load their information (position. rotation, offset) from the default options
     */
//    public void loadDefaultPose()
//    {
//    	for(PCModelRenderer bodyPart : bodyParts)
//        {
//    		bodyPart.loadDefaultPose();
//        }
//    }
    
    //======================================================================================================================================================
    //======================================================================================================================================================
    //======================================================================================================================================================
    //======================================================================================================================================================

    public void animateModel(E animatedEntity) {}
    
    @Override
    public void setRotationAngles(E entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
    {
    	this.entity = entity;
    }
    
    public void addCuboid(PCModelRenderer cuboid)
    {
		this.cuboids.add(cuboid);
	}
    
    public void createScaleController()
    {
		this.scaleController = new PCModelRenderer(this, 0, 0);
		this.scaleController.showModel = false;
		this.scaleController.setRotationPoint(1, 1, 1);
	}
	
	public PCModelRenderer getScaleController()
	{
		return this.scaleController;
	}

    //##########################################################################################################################################
    //##########################################################################################################################################
    //##########################################################################################################################################
    
    /**
     * Rotates this box back and forth (rotateAngleX)
     */
    public void swing(PCModelRenderer box, float speed, float degree, boolean invert, float delay, float weight, float limbSwing, float limbSwingAmount)
    {
        box.swing(speed, degree, invert, delay, weight, limbSwing, limbSwingAmount);
    }

    /**
     * Rotates this box right and left (rotateAngleZ)
     */
    public void flap(PCModelRenderer box, float speed, float degree, boolean invert, float delay, float weight, float limbSwing, float limbSwingAmount)
    {
        box.flap(speed, degree, invert, delay, weight, limbSwing, limbSwingAmount);
    }

    /**
     * Rotates this box side to side (rotateAngleY)
     */
    public void shake(PCModelRenderer box, float speed, float degree, boolean invert, float delay, float weight, float limbSwing, float limbSwingAmount)
    {
        box.shake(speed, degree, invert, delay, weight, limbSwing, limbSwingAmount);
    }

    /**
     * This makes the given Box move Up and Down on the Y Axis
     */
    public void bounce(PCModelRenderer box, float speed, float height, boolean extraBouncy, float limbSwing, float limbSwingAmount)
    {
        box.bounce(speed, height, extraBouncy, limbSwing, limbSwingAmount);
    }
}
