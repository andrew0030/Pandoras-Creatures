package andrews.pandoras_creatures.animation.system.core.types;

import net.minecraft.client.model.geom.ModelPart;
import org.joml.Vector3f;

public class TransformTypes
{
    private final TransformType transformType;
    // Transform Types
    public static final TransformTypes POSITION = new TransformTypes(TransformType.POSITION);
    public static final TransformTypes ROTATION = new TransformTypes(TransformType.ROTATION);
    public static final TransformTypes SCALE = new TransformTypes(TransformType.SCALE);

    private TransformTypes(TransformType transformType)
    {
        this.transformType = transformType;
    }

    /**
     * Based on the current TransformType the given Vector values will
     * be applied to the corresponding ModelPart's POSITION-ROTATION-SCALE
     * @param modelPart The ModelPart that will be offset
     * @param valuesToApply A Vector3f holding the X/Y/Z values to be applied
     */
    public void applyValues(ModelPart modelPart, Vector3f valuesToApply)
    {
        switch(this.transformType)
        {
            case POSITION -> modelPart.offsetPos(valuesToApply);
            case ROTATION -> modelPart.offsetRotation(valuesToApply);
            case SCALE -> modelPart.offsetScale(valuesToApply);
        }
    }

    private enum TransformType
    {
        POSITION,
        ROTATION,
        SCALE;
    }
}