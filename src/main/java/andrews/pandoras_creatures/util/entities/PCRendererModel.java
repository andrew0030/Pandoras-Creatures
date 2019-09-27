package andrews.pandoras_creatures.util.entities;

import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PCRendererModel extends RendererModel
{
    public float defaultRotationX, defaultRotationY, defaultRotationZ;
    public float defaultdelayX, defaultdelayY, defaultdelayZ;
    public float defaultPositionX, defaultPositionY, defaultPositionZ;
    public float scaleX = 1.0F, scaleY = 1.0F, scaleZ = 1.0F;
    public int texturedelayX, texturedelayY;
    public boolean scaleChildren;
    private PCEntityModel<?> model;

    public PCRendererModel(PCEntityModel<?> model, String name)
    {
        super(model, name);
        this.model = model;
    }

    public PCRendererModel(PCEntityModel<?> model)
    {
        this(model, null);
    }

    public PCRendererModel(PCEntityModel<?> model, int texturedelayX, int texturedelayY)
    {
        this(model);
        this.setTextureDelay(texturedelayX, texturedelayY);
    }
    
    public PCRendererModel setTextureDelay(int x, int y)
    {
        this.texturedelayX = x;
        this.texturedelayY = y;
        return this;
    }

    @Override
    public RendererModel addBox(float offX, float offY, float offZ, int width, int height, int depth)
    {
        this.cubeList.add(new ModelBox(this, this.texturedelayX, this.texturedelayY, offX, offY, offZ, width, height, depth, 0.0F));
        return this;
    }

    @Override
    public RendererModel addBox(float offX, float offY, float offZ, int width, int height, int depth, boolean mirrored)
    {
        this.cubeList.add(new ModelBox(this, this.texturedelayX, this.texturedelayY, offX, offY, offZ, width, height, depth, 0.0F, mirrored));
        return this;
    }

    /**
     * Creates a textured box.
     */
    @Override
    public void addBox(float offX, float offY, float offZ, int width, int height, int depth, float scaleFactor)
    {
        this.cubeList.add(new ModelBox(this, this.texturedelayX, this.texturedelayY, offX, offY, offZ, width, height, depth, scaleFactor));
    }

    /**
     * Sets this ModelRenderer's default pose to the current pose.
     */
    public void saveAsDefaultPose()
    {
        this.defaultRotationX = this.rotateAngleX;
        this.defaultRotationY = this.rotateAngleY;
        this.defaultRotationZ = this.rotateAngleZ;

        this.defaultdelayX = this.offsetX;
        this.defaultdelayY = this.offsetY;
        this.defaultdelayZ = this.offsetZ;

        this.defaultPositionX = this.rotationPointX;
        this.defaultPositionY = this.rotationPointY;
        this.defaultPositionZ = this.rotationPointZ;
    }

    /**
     * Sets the current pose to the previously set default pose.
     */
    public void loadDefaultPose()
    {
        this.rotateAngleX = this.defaultRotationX;
        this.rotateAngleY = this.defaultRotationY;
        this.rotateAngleZ = this.defaultRotationZ;

        this.offsetX = this.defaultdelayX;
        this.offsetY = this.defaultdelayY;
        this.offsetZ = this.defaultdelayZ;

        this.rotationPointX = this.defaultPositionX;
        this.rotationPointY = this.defaultPositionY;
        this.rotationPointZ = this.defaultPositionZ;
    }

    private float calculateRotation(float speed, float degree, boolean invert, float delay, float weight, float limbSwing, float limbSwingAmount)
    {
        float movementScale = this.model.getMovementScale();
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

    /**
     * Rotates this box back and forth (rotateAngleX)
     */
    public void swing(float speed, float degree, boolean invert, float delay, float weight, float limbSwing, float limbSwingAmount)
    {
        this.rotateAngleX += this.calculateRotation(speed, degree, invert, delay, weight, limbSwing, limbSwingAmount);
    }

    /**
     * Rotates this box right and left (rotateAngleZ)
     */
    public void flap(float speed, float degree, boolean invert, float delay, float weight, float limbSwing, float limbSwingAmount)
    {
        this.rotateAngleZ += this.calculateRotation(speed, degree, invert, delay, weight, limbSwing, limbSwingAmount);
    }

    /**
     * Rotates this box side to side (rotateAngleY)
     */
    public void shake(float speed, float degree, boolean invert, float delay, float weight, float limbSwing, float limbSwingAmount)
    {
        this.rotateAngleY += this.calculateRotation(speed, degree, invert, delay, weight, limbSwing, limbSwingAmount);
    }

    /**
     * This makes the given Box move Up and Down on the Y Axis
     */
    public void bounce(float speed, float height, boolean extraBouncy, float limbSwing, float limbSwingAmount)
    {
        float movementScale = this.model.getMovementScale();
        height *= movementScale;
        speed *= movementScale;
        float bounce = (float) (Math.sin(limbSwing * speed) * limbSwingAmount * height - limbSwingAmount * height);
        if(extraBouncy == true)
        {
        	bounce = (float) -Math.abs((Math.sin(limbSwing * speed) * limbSwingAmount * height));
        }
        this.rotationPointY += bounce;
    }
    
    /**
     * Rotates this box on the X axis until it reached the target
     */
    public void moveOnAxisX(float speed, float targetRotation)
    {
    	if(Math.toDegrees(this.rotateAngleX) < targetRotation)
    	{
    		this.rotateAngleX += Math.toRadians(speed);
    	}
    	else
    	{
    		this.rotateAngleX -= Math.toRadians(speed);
    	}
    }
    
    /**
     * Rotates this box on the X axis until it reached the default rotation
     */
    public void moveAxisXToDefault(float speed)
    {
    	if(this.rotateAngleX < this.defaultRotationX)
    	{
    		this.rotateAngleX += Math.toRadians(speed);
    	}
    	else
    	{
    		this.rotateAngleX -= Math.toRadians(speed);
    	}
    }
    
    /**
     * Rotates this box on the Y axis until it reached the target
     */
    public void moveOnAxisY(float speed, float targetRotation)
    {
    	if(Math.toDegrees(this.rotateAngleY) < targetRotation)
    	{
    		this.rotateAngleY += Math.toRadians(speed);
    	}
    	else
    	{
    		this.rotateAngleY -= Math.toRadians(speed);
    	}
    }
    
    /**
     * Rotates this box on the Y axis until it reached the default rotation
     */
    public void moveAxisYToDefault(float speed)
    {
    	if(this.rotateAngleY < this.defaultRotationY)
    	{
    		this.rotateAngleY += Math.toRadians(speed);
    	}
    	else
    	{
    		this.rotateAngleY -= Math.toRadians(speed);
    	}
    }
    
    /**
     * Rotates this box on the Z axis until it reached the target
     */
    public void moveOnAxisZ(float speed, float targetRotation)
    {
    	if(Math.toDegrees(this.rotateAngleZ) < targetRotation)
    	{
    		this.rotateAngleZ += Math.toRadians(speed);
    	}
    	else
    	{
    		this.rotateAngleZ -= Math.toRadians(speed);
    	}
    }
    
    /**
     * Rotates this box on the Z axis until it reached the default rotation
     */
    public void moveAxisZToDefault(float speed)
    {
    	if(this.rotateAngleZ < this.defaultRotationZ)
    	{
    		this.rotateAngleZ += Math.toRadians(speed);
    	}
    	else
    	{
    		this.rotateAngleZ -= Math.toRadians(speed);
    	}
    }
}