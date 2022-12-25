package andrews.pandoras_creatures.util;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;

import java.util.OptionalDouble;

public class PCRenderTypes extends RenderType
{
    public PCRenderTypes(String name, VertexFormat format, VertexFormat.Mode mode, int bufferSize, boolean affectsCrumbling, boolean sortOnUpload, Runnable setupState, Runnable clearState)
    {
        super(name, format, mode, bufferSize, affectsCrumbling, sortOnUpload, setupState, clearState);
    }

    public static RenderType skeletonDebugLines()
    {
        RenderType.CompositeState state = RenderType.CompositeState.builder()
                .setShaderState(POSITION_COLOR_SHADER) // The used Shader
                .setCullState(NO_CULL) // No Cull so we see it from everywhere
                .setDepthTestState(NO_DEPTH_TEST) // We render over everything
                .createCompositeState(false);

        return RenderType.create(Reference.MODID+":skeleton_debug_lines", DefaultVertexFormat.POSITION_COLOR, VertexFormat.Mode.DEBUG_LINES, TRANSIENT_BUFFER_SIZE, false, false, state);
    };
}