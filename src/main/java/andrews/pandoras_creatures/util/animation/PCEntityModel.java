package andrews.pandoras_creatures.util.animation;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PCEntityModel<entity extends Entity> extends EntityModel<entity>
{
	/**
	 * An array containing all the body parts of the model
	 */
	protected PCRendererModel[] bodyParts;
	private float movementScale = 1.0F;
	
	/**
	 * Saves all needed information for both the loop animation system and the keyframe system
	 */
	public void saveAllDefaultValues()
	{
		saveDefaultBoxValues();
		saveAsDefaultPose();
	}
	
	/**
	 * This will go through all body parts saved in the bodyParts array, and then save their information (rotation point. rotation angle, offset) as the default options
	 */
	public void saveDefaultBoxValues()
	{
		for(PCRendererModel bodyPart : bodyParts)
        {
        	bodyPart.saveDefaultBoxValues();
        }
	}
	
	/**
     * This will go through all body parts saved in the bodyParts array, and then load their information (rotation point. rotation angle, offset) from the default options
     */
	public void loadDefaultBoxValues()
	{
		for(PCRendererModel bodyPart : bodyParts)
        {
        	bodyPart.loadDefaultBoxValues();
        }
	}
	
	/**
	 * This will go through all body parts saved in the bodyParts array, and then save their information (position. rotation, offset) as the default options
	 */
    public void saveAsDefaultPose()
    {
        for(PCRendererModel bodyPart : bodyParts)
        {
        	bodyPart.saveAsDefaultPose();
        }
    }

    /**
     * This will go through all body parts saved in the bodyParts array, and then load their information (position. rotation, offset) from the default options
     */
    public void loadDefaultPose()
    {
    	for(PCRendererModel bodyPart : bodyParts)
        {
    		bodyPart.loadDefaultPose();
        }
    }

    /**
     * @return the movement scale of this Model
     */
    public float getMovementScale()
    {
        return this.movementScale;
    }

    /**
     * Multiplies all rotation and position changes by this value
     */
    public void setMovementScale(float movementScale)
    {
        this.movementScale = movementScale;
    }

    //##########################################################################################################################################
    //##########################################################################################################################################
    //##########################################################################################################################################
    
    /**
     * Rotates this box back and forth (rotateAngleX)
     */
    public void swing(PCRendererModel box, float speed, float degree, boolean invert, float delay, float weight, float limbSwing, float limbSwingAmount)
    {
        box.swing(speed, degree, invert, delay, weight, limbSwing, limbSwingAmount);
    }

    /**
     * Rotates this box right and left (rotateAngleZ)
     */
    public void flap(PCRendererModel box, float speed, float degree, boolean invert, float delay, float weight, float limbSwing, float limbSwingAmount)
    {
        box.flap(speed, degree, invert, delay, weight, limbSwing, limbSwingAmount);
    }

    /**
     * Rotates this box side to side (rotateAngleY)
     */
    public void shake(PCRendererModel box, float speed, float degree, boolean invert, float delay, float weight, float limbSwing, float limbSwingAmount)
    {
        box.shake(speed, degree, invert, delay, weight, limbSwing, limbSwingAmount);
    }

    /**
     * This makes the given Box move Up and Down on the Y Axis
     */
    public void bounce(PCRendererModel box, float speed, float height, boolean extraBouncy, float limbSwing, float limbSwingAmount)
    {
        box.bounce(speed, height, extraBouncy, limbSwing, limbSwingAmount);
    }
}
