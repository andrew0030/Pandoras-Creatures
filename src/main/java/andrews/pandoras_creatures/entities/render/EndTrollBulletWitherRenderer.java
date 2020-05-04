package andrews.pandoras_creatures.entities.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import andrews.pandoras_creatures.entities.EndTrollBulletWitherEntity;
import andrews.pandoras_creatures.entities.model.EndTrollBulletModel;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EndTrollBulletWitherRenderer extends EntityRenderer<EndTrollBulletWitherEntity>
{
	private static final ResourceLocation END_TROLL_BULLET_TEXTURE = new ResourceLocation(Reference.MODID, "textures/entity/end_troll/bullets/end_troll_bullet_2.png");
	private static final RenderType END_TROLL_BULLET_RENDER_TYPE = RenderType.getEntityTranslucent(END_TROLL_BULLET_TEXTURE);
	public EndTrollBulletModel<EndTrollBulletWitherEntity> model;

	public EndTrollBulletWitherRenderer(EntityRendererManager manager)
	{
		super(manager);
		this.model = new EndTrollBulletModel<EndTrollBulletWitherEntity>();
	}
	
	@Override
	protected int getBlockLight(EndTrollBulletWitherEntity entityIn, float partialTicks)
	{
		return 15;
	}

	@Override
	public void render(EndTrollBulletWitherEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn)
	{
		matrixStackIn.push();
		float f = rotLerp(entityIn.prevRotationYaw, entityIn.rotationYaw, partialTicks);
		float f1 = MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch);
		float f2 = (float) entityIn.ticksExisted + partialTicks;
		matrixStackIn.translate(0.0D, (double) 0.15F, 0.0D);
		matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.sin(f2 * 0.1F) * 180.0F));
		matrixStackIn.rotate(Vector3f.XP.rotationDegrees(MathHelper.cos(f2 * 0.1F) * 180.0F));
		matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(MathHelper.sin(f2 * 0.15F) * 360.0F));
		matrixStackIn.scale(-0.5F, -0.5F, 0.5F);
		this.model.setRotationAngles(entityIn, 0.0F, 0.0F, 0.0F, f, f1);
		IVertexBuilder ivertexbuilder = bufferIn.getBuffer(this.model.getRenderType(END_TROLL_BULLET_TEXTURE));
		this.model.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		matrixStackIn.scale(1.5F, 1.5F, 1.5F);
		IVertexBuilder ivertexbuilder1 = bufferIn.getBuffer(END_TROLL_BULLET_RENDER_TYPE);
		this.model.render(matrixStackIn, ivertexbuilder1, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 0.15F);
		matrixStackIn.pop();
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getEntityTexture(EndTrollBulletWitherEntity entity)
	{
		return END_TROLL_BULLET_TEXTURE;
	}
	
	/**
	 * A helper method to do some Math Magic
	 */
	private float rotLerp(float prevRotation, float rotation, float partialTicks)
	{
		float f;
		for(f = rotation - prevRotation; f < -180.0F; f += 360.0F)
		{
			;
		}

		while(f >= 180.0F)
		{
			f -= 360.0F;
		}

		return prevRotation + partialTicks * f;
	}
}