package andrews.pandoras_creatures.util;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

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

    public static RenderType skeletonDebugQuad()
    {
        RenderType.CompositeState state = RenderType.CompositeState.builder()
                .setShaderState(POSITION_COLOR_SHADER) // The used Shader
                .setDepthTestState(NO_DEPTH_TEST) // We render over everything
                .createCompositeState(false);
        return RenderType.create(Reference.MODID+":skeleton_debug_quad", DefaultVertexFormat.POSITION_COLOR, VertexFormat.Mode.QUADS, TRANSIENT_BUFFER_SIZE, false, false, state);
    };

    public static RenderType eyesNoCull(ResourceLocation location)
    {
        RenderType.CompositeState state = RenderType.CompositeState.builder()
                .setShaderState(RENDERTYPE_EYES_SHADER)
                .setTextureState(new RenderStateShard.TextureStateShard(location, false, false))
                .setTransparencyState(ADDITIVE_TRANSPARENCY)
                .setWriteMaskState(COLOR_WRITE)
                .setCullState(NO_CULL)
                .createCompositeState(false);
        return create(Reference.MODID+"eyes_no_cull", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, TRANSIENT_BUFFER_SIZE, false, true, state);
    }
}