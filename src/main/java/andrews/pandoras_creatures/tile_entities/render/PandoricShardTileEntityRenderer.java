package andrews.pandoras_creatures.tile_entities.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.vertex.VertexBuilderUtils;

import andrews.pandoras_creatures.entities.render.util.PCRenderTypes;
import andrews.pandoras_creatures.objects.blocks.PandoricShardBlock;
import andrews.pandoras_creatures.tile_entities.PandoricShardTileEntity;
import andrews.pandoras_creatures.tile_entities.model.pandoric_shard.CoreModel;
import andrews.pandoras_creatures.tile_entities.model.pandoric_shard.PandoricShardSmallBaseModel;
import andrews.pandoras_creatures.tile_entities.model.pandoric_shard.gears.BigGearModel;
import andrews.pandoras_creatures.tile_entities.model.pandoric_shard.gears.MediumGearModel;
import andrews.pandoras_creatures.tile_entities.model.pandoric_shard.gears.SmallGearModel;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.state.properties.AttachFace;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PandoricShardTileEntityRenderer  extends TileEntityRenderer<PandoricShardTileEntity>
{
	public static final ResourceLocation SMALL_GEAR_TEXTURE = new ResourceLocation(Reference.MODID, "textures/tile/pandoric_shard/small_gear.png");
	public static final ResourceLocation MEDIUM_GEAR_TEXTURE = new ResourceLocation(Reference.MODID, "textures/tile/pandoric_shard/medium_gear.png");
	public static final ResourceLocation BIG_GEAR_TEXTURE = new ResourceLocation(Reference.MODID, "textures/tile/pandoric_shard/big_gear.png");
	public static final ResourceLocation CORE_TEXTURE = new ResourceLocation(Reference.MODID, "textures/tile/pandoric_shard/pandoric_shard_core.png");
	public static final ResourceLocation BASE_TEXTURE = new ResourceLocation(Reference.MODID, "textures/tile/pandoric_shard/pandoric_shard_small_base.png");
	private static PandoricShardSmallBaseModel pandoricShardBaseModelSmall;
	private static SmallGearModel smallGearModel;
	private static MediumGearModel mediumGearModel;
	private static BigGearModel bigGearModel;
	private static CoreModel coreModel;

	public PandoricShardTileEntityRenderer(TileEntityRendererDispatcher rendererDispatcherIn)
	{
		super(rendererDispatcherIn);
		pandoricShardBaseModelSmall = new PandoricShardSmallBaseModel();
		smallGearModel = new SmallGearModel();
		mediumGearModel = new MediumGearModel();
		bigGearModel = new BigGearModel();
		coreModel = new CoreModel();
	}
	
	@Override
	public void render(PandoricShardTileEntity tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn)
	{	
		renderPandoricShard(tileEntityIn, matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn, false);
	}
	
	public static void renderPandoricShard(PandoricShardTileEntity tileEntityIn, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn, boolean isRenderedInGUI)
	{
		double pixelSize = 0.0625D;
		float animationProgress = getAnimationProgress(tileEntityIn, isRenderedInGUI);
		Direction direction = Direction.NORTH;
		AttachFace face = AttachFace.FLOOR;
		if(tileEntityIn.hasWorld())
		{
			BlockState blockstate = tileEntityIn.getWorld().getBlockState(tileEntityIn.getPos());
			if(blockstate.getBlock() instanceof PandoricShardBlock)
			{
				direction = blockstate.get(PandoricShardBlock.HORIZONTAL_FACING);
				face = blockstate.get(PandoricShardBlock.FACE);
			}
		}
		
		matrixStackIn.push();
		matrixStackIn.translate(0.5D, 1.5D, 0.5D);
		matrixStackIn.scale(1.0F, -1.0F, -1.0F);
		
		switch(face)
		{
		default:
		case FLOOR:
			switch(direction)
			{
			default:
			case NORTH:
				break;
			case SOUTH:
				matrixStackIn.rotate(Vector3f.YN.rotationDegrees(180.0F));
				break;
			case WEST:
				matrixStackIn.rotate(Vector3f.YN.rotationDegrees(90.0F));
				break;
			case EAST:
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(90.0F));
			}
			break;
		case CEILING:
			matrixStackIn.translate(0.0F, 2.0F, 0.0F);
			matrixStackIn.rotate(Vector3f.XP.rotationDegrees(180.0F));
			
			switch(direction)
			{
			default:
			case NORTH:
				matrixStackIn.rotate(Vector3f.YN.rotationDegrees(180.0F));
				break;
			case SOUTH:
				break;
			case WEST:
				matrixStackIn.rotate(Vector3f.YN.rotationDegrees(90.0F));
				break;
			case EAST:
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(90.0F));
			}
			break;
		case WALL:
			matrixStackIn.translate(0.0F, 1.0F, -1.0F);
			matrixStackIn.rotate(Vector3f.XP.rotationDegrees(90.0F));
			
			switch(direction)
			{
			default:
			case NORTH:
				matrixStackIn.translate(0.0F, 2.0F, 0.0F);
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(180.0F));
				break;
			case SOUTH:
				break;
			case WEST:
				matrixStackIn.translate(-1.0F, 1.0F, 0.0F);
				matrixStackIn.rotate(Vector3f.ZN.rotationDegrees(90.0F));
				break;
			case EAST:
				matrixStackIn.translate(1.0F, 1.0F, 0.0F);
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90.0F));
			}
		}
		
		matrixStackIn.push();
		pandoricShardBaseModelSmall.decoration.rotateAngleZ = (float) (Math.cos(animationProgress * 0.1D) * 0.1F + Math.toRadians(-25));
		pandoricShardBaseModelSmall.decoration_1.rotateAngleZ = (float) (Math.cos(animationProgress * 0.1D) * -0.1F + Math.toRadians(25));
		pandoricShardBaseModelSmall.decoration_2.rotateAngleX = (float) (Math.cos(animationProgress * 0.1D) * -0.1F + Math.toRadians(25));
		pandoricShardBaseModelSmall.decoration_3.rotateAngleX = (float) (Math.cos(animationProgress * 0.1D) * 0.1F + Math.toRadians(-25));
		IVertexBuilder builderBase = bufferIn.getBuffer(RenderType.getEntityCutoutNoCull(BASE_TEXTURE));
		pandoricShardBaseModelSmall.base.render(matrixStackIn, builderBase, combinedLightIn, combinedOverlayIn);
		matrixStackIn.pop();
		
		matrixStackIn.push();
		matrixStackIn.translate(pixelSize * 1.5D, pixelSize * 20.1D, pixelSize * 5.4D);
		matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (-animationProgress * (Math.PI * 6))));
		IVertexBuilder builderSmallGear = bufferIn.getBuffer(RenderType.getEntityCutoutNoCull(SMALL_GEAR_TEXTURE));
		smallGearModel.base.render(matrixStackIn, builderSmallGear, combinedLightIn, combinedOverlayIn);
		matrixStackIn.pop();
		
		matrixStackIn.push();
		matrixStackIn.translate(pixelSize * 4.5D, pixelSize * 20D, pixelSize * 3.4D);
		matrixStackIn.rotate(Vector3f.YN.rotationDegrees(90F));
		matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (animationProgress * (Math.PI * 2))));
		IVertexBuilder builderMediumGear = bufferIn.getBuffer(RenderType.getEntityCutoutNoCull(MEDIUM_GEAR_TEXTURE));
		mediumGearModel.base.render(matrixStackIn, builderMediumGear, combinedLightIn, combinedOverlayIn);
		matrixStackIn.pop();
		
		matrixStackIn.push();
		matrixStackIn.translate(pixelSize * 5.5D, pixelSize * 20D, pixelSize * -0.5D);
		matrixStackIn.rotate(Vector3f.YN.rotationDegrees(90F));
		matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (-animationProgress * (Math.PI * 2))));
		mediumGearModel.base.render(matrixStackIn, builderMediumGear, combinedLightIn, combinedOverlayIn);
		matrixStackIn.pop();
		
		matrixStackIn.push();
		matrixStackIn.translate(pixelSize * 1.3D, pixelSize * 22D, pixelSize * -3D);
		matrixStackIn.rotate(Vector3f.XN.rotationDegrees(90F));
		matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (animationProgress * (Math.PI))));
		IVertexBuilder builderBigGear = bufferIn.getBuffer(RenderType.getEntityCutoutNoCull(BIG_GEAR_TEXTURE));
		bigGearModel.center.render(matrixStackIn, builderBigGear, combinedLightIn, combinedOverlayIn);
		matrixStackIn.pop();
		
		matrixStackIn.push();
		matrixStackIn.translate(0.0D, (pixelSize * 14.5D) + Math.cos(animationProgress * 0.1D) * 0.05D, 0.0D);
		float coreScaleValue = (float) (Math.cos(animationProgress * 0.3F) * 0.1F + 1.1F);
		matrixStackIn.scale(coreScaleValue, coreScaleValue, coreScaleValue);
		matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (animationProgress * (Math.PI / 2))));
		matrixStackIn.rotate(Vector3f.XN.rotationDegrees((float) (animationProgress * (Math.PI / 2))));
		matrixStackIn.rotate(Vector3f.YN.rotationDegrees((float) (animationProgress * (Math.PI / 2))));
		IVertexBuilder builderCore = VertexBuilderUtils.newDelegate(bufferIn.getBuffer(RenderType.getEntityGlint()), bufferIn.getBuffer(PCRenderTypes.getEmissiveEntity(CORE_TEXTURE)));
		coreModel.base.render(matrixStackIn, builderCore, combinedLightIn, OverlayTexture.NO_OVERLAY);
		matrixStackIn.pop();
		
		matrixStackIn.pop();
	}
	
	private static float getAnimationProgress(PandoricShardTileEntity tileEntity, boolean isRenderedInGUI)
	{
		Minecraft minecraft = Minecraft.getInstance();
		int ticksExisted = minecraft.player.ticksExisted;
		float partialTicks = minecraft.getRenderPartialTicks();
		float partialTicksPaused = minecraft.renderPartialTicksPaused;
		int animationProgressDelay = tileEntity.getAnimationDelay();
		
		if(minecraft.player.isAlive())
		{
			if(isRenderedInGUI)
			{
				return minecraft.isGamePaused() ? ticksExisted + partialTicksPaused : ticksExisted + partialTicks;
			}
			return minecraft.isGamePaused() ? ticksExisted + animationProgressDelay + partialTicksPaused : ticksExisted + animationProgressDelay + partialTicks;
		}
		return 0;
	}
}