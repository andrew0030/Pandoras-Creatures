package andrews.pandoras_creatures.entities.render.layer;

import com.mojang.blaze3d.platform.GLX;
import com.mojang.blaze3d.platform.GlStateManager;

import andrews.pandoras_creatures.entities.ArachnonEntity;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderLayerArachnonEye<E extends ArachnonEntity, M extends EntityModel<E>> extends LayerRenderer<E, M>
{
	public static final ResourceLocation ARACHNON_EYE_LAYER = new ResourceLocation(Reference.MODID, "textures/entity/arachnon/arachnon_eye.png");
	
	public RenderLayerArachnonEye(IEntityRenderer<E, M> entityRenderer)
	{
		super(entityRenderer);
	}
	
	@Override
	public void render(E arachnon, float p_212842_2_, float p_212842_3_, float p_212842_4_, float p_212842_5_, float p_212842_6_, float p_212842_7_, float p_212842_8_)
	{
		this.bindTexture(this.getTexture(arachnon));
		
		GLX.glMultiTexCoord2f(GLX.GL_TEXTURE1, 240.0F, 240.0F);
		
		GlStateManager.disableLighting();
        
		this.getEntityModel().render(arachnon, p_212842_2_, p_212842_3_, p_212842_5_, p_212842_6_, p_212842_7_, p_212842_8_);
		
		GlStateManager.enableLighting();
		
		int i = arachnon.getBrightnessForRender();
		GLX.glMultiTexCoord2f(GLX.GL_TEXTURE1, i % 65536, i / 65536);
		this.func_215334_a(arachnon);
	}
	
	public ResourceLocation getTexture(E arachnon)
	{
		return ARACHNON_EYE_LAYER;
	}

	@Override
	public boolean shouldCombineTextures()
	{
		return false;
	}
}
