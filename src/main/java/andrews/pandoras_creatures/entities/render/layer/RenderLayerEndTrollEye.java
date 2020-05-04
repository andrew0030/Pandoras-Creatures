package andrews.pandoras_creatures.entities.render.layer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import andrews.pandoras_creatures.entities.EndTrollEntity;
import andrews.pandoras_creatures.entities.render.util.PCRenderTypes;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
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
	public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, E adolescent, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		Minecraft.getInstance().getTextureManager().bindTexture(END_TROLL_EYE_LAYER);

		IVertexBuilder ivertexbuilder = bufferIn.getBuffer(PCRenderTypes.getEmissiveEntity(END_TROLL_EYE_LAYER));
		
		this.getEntityModel().setRotationAngles(adolescent, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		this.getEntityModel().render(matrixStackIn, ivertexbuilder, 240, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	}
}