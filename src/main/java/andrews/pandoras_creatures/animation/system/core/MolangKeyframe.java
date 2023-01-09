package andrews.pandoras_creatures.animation.system.core;

import andrews.pandoras_creatures.animation.system.core.types.EasingTypes;
import org.joml.Vector3f;

public class MolangKeyframe extends BasicKeyframe
{
    private final Vector3f emptyVec = new Vector3f();
    private final String expression;

    public MolangKeyframe(float timestamp, String expression, EasingTypes easingType)
    {
        super(timestamp, new Vector3f(), easingType);
        this.expression = expression;
    }

    @Override
    public boolean isBasic()
    {
        return false;
    }

    @Override
    public Vector3f target(float elapsedSeconds)
    {
        Vector3f vec = new Vector3f();//TODO maybe make this a final
        double x = degreeCos(elapsedSeconds * 400) * 15;
        double y = 0.0;
        double z = 0.0;
        return vec.set(Math.toRadians(x), Math.toRadians(y), Math.toRadians(z));
    }

    @Override
    public Vector3f target()
    {
        return this.emptyVec;
    }

    private double degreeSin(double elapsedSeconds)
    {
        return Math.sin(elapsedSeconds / 180 * Math.PI);
    }

    private double degreeCos(double elapsedSeconds)
    {
        return Math.cos(elapsedSeconds / 180 * Math.PI);
    }
}