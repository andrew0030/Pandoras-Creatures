package andrews.pandoras_creatures.animation.system.core;

import andrews.pandoras_creatures.animation.system.core.types.EasingTypes;
import andrews.pandoras_creatures.animation.system.core.util.DynamicExpression;
import org.joml.Vector3f;

public class MolangKeyframe extends BasicKeyframe
{
    private final Vector3f vec = new Vector3f();
    private final DynamicExpression expressionX;
    private final DynamicExpression expressionY;
    private final DynamicExpression expressionZ;

    public MolangKeyframe(float timestamp, String rawX, String rawY, String rawZ, EasingTypes easingType)
    {
        super(timestamp, new Vector3f(), easingType);
        this.expressionX = new DynamicExpression(rawX);
        this.expressionY =  new DynamicExpression(rawY);
        this.expressionZ = new DynamicExpression(rawZ);
    }

    @Override
    public boolean isBasic()
    {
        return false;
    }

    @Override
    public Vector3f target(float elapsedSeconds)
    {
        // We update the necessary Queries
        this.expressionX.updateVariable(DynamicExpression.QueryTypes.ANIM_TIME, elapsedSeconds);
        this.expressionY.updateVariable(DynamicExpression.QueryTypes.ANIM_TIME, elapsedSeconds);
        this.expressionZ.updateVariable(DynamicExpression.QueryTypes.ANIM_TIME, elapsedSeconds);
        // We get the values
        double x = this.expressionX.getValue();
        double y = this.expressionY.getValue();
        double z = this.expressionZ.getValue();
        return this.vec.set(Math.toRadians(x), Math.toRadians(y), Math.toRadians(z));
    }

    @Override
    public Vector3f target()
    {
        return this.vec.set(0, 0, 0);
    }
}