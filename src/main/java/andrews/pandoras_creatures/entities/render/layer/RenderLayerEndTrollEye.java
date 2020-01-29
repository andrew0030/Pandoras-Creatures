package andrews.pandoras_creatures.entities.render.layer;

import com.mojang.blaze3d.platform.GLX;
import com.mojang.blaze3d.platform.GlStateManager;

import andrews.pandoras_creatures.entities.EndTrollEntity;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderLayerEndTrollEye<E extends EndTrollEntity, M extends EntityModel<E>> extends LayerRenderer<E, M>
{
	public static final ResourceLocation END_TROLL_EYE_LAYER = new ResourceLocation(Reference.MODID, "textures/entity/end_troll/end_troll_eye_1.png");
	
	public RenderLayerEndTrollEye(IEntityRenderer<E, M> entityRenderer)
	{
		super(entityRenderer);
	}
	
	@Override
	public void render(E endTroll, float p_212842_2_, float p_212842_3_, float p_212842_4_, float p_212842_5_, float p_212842_6_, float p_212842_7_, float p_212842_8_)
	{
		this.bindTexture(this.getTexture(endTroll));
		
		GLX.glMultiTexCoord2f(GLX.GL_TEXTURE1, 240.0F, 240.0F);
		
		GlStateManager.disableLighting();
        
		this.getEntityModel().render(endTroll, p_212842_2_, p_212842_3_, p_212842_5_, p_212842_6_, p_212842_7_, p_212842_8_);
		
		GlStateManager.enableLighting();
		
		int i = endTroll.getBrightnessForRender();
		GLX.glMultiTexCoord2f(GLX.GL_TEXTURE1, i % 65536, i / 65536);
		this.func_215334_a(endTroll);
	}
	
	public ResourceLocation getTexture(E endTroll)
	{
		return END_TROLL_EYE_LAYER;
	}

	@Override
	public boolean shouldCombineTextures()
	{
		return false;
	}
}