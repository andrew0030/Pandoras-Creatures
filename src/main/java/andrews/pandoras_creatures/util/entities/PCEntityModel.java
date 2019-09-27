package andrews.pandoras_creatures.util.entities;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PCEntityModel<entity extends Entity> extends EntityModel<entity>
{
	protected PCRendererModel[] bodyParts;
	private float movementScale = 1.0F;
	
	/**
	 * This will go through all body parts saved in the bodyParts
	 * array, and then save their information (position. rotation, offset)
	 * as the default options
	 */
    public void saveAsDefaultPose()
    {
        for(PCRendererModel bodyPart : bodyParts)
        {
        	bodyPart.saveAsDefaultPose();
        }
    }

    /**
     * This will go through all body parts saved in the bodyParts
     * array, and then load their information (position. rotation, offset)
	 * from the default options
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
    
    /**
     * Rotates this box on the X axis until it reached the target
     */
    public void moveOnAxisX(PCRendererModel box, float speed, float targetRotation)
    {
        box.moveOnAxisX(speed, targetRotation);
    }
    
    /**
     * Rotates this box on the X axis until it reached the default rotation
     */
    public void moveAxisXToDefault(PCRendererModel box, float speed)
    {
    	box.moveAxisXToDefault(speed);
    }
    
    /**
     * Rotates this box on the Y axis until it reached the target
     */
    public void moveOnAxisY(PCRendererModel box, float speed, float targetRotation)
    {
        box.moveOnAxisY(speed, targetRotation);
    }
    
    /**
     * Rotates this box on the Y axis until it reached the default rotation
     */
    public void moveAxisYToDefault(PCRendererModel box, float speed)
    {
    	box.moveAxisYToDefault(speed);
    }
    
    /**
     * Rotates this box on the Z axis until it reached the target
     */
    public void moveOnAxisZ(PCRendererModel box, float speed, float targetRotation)
    {
        box.moveOnAxisZ(speed, targetRotation);
    }
    
    /**
     * Rotates this box on the Z axis until it reached the default rotation
     */
    public void moveAxisZToDefault(PCRendererModel box, float speed)
    {
    	box.moveAxisZToDefault(speed);
    }
}
