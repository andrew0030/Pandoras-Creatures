package andrews.pandoras_creatures.animation.system.core;

import org.joml.Vector3f;

public class MolangKeyframe extends BasicKeyframe
{
    private final String expression;

    public MolangKeyframe(float timestamp, String expression)
    {
        super(timestamp, new Vector3f());
        this.expression = expression;
    }

    public void getVectorFromExpression(Vector3f vectorCache, float elapsedSeconds)
    {
//        elapsedSeconds = (float) Math.round(elapsedSeconds * 100.0F) / 100.0F;



        double x = degreeCos(elapsedSeconds * 250) * 10;
        double y = 0.0;
        double z = 0.0;
        vectorCache.set(Math.toRadians(x), Math.toRadians(y), Math.toRadians(z));
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