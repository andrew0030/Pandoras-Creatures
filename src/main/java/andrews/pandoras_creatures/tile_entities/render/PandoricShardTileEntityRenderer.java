package andrews.pandoras_creatures.tile_entities.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.vertex.VertexBuilderUtils;

import andrews.pandoras_creatures.entities.render.util.PCRenderTypes;
import andrews.pandoras_creatures.objects.blocks.PandoricShardBlock;
import andrews.pandoras_creatures.tile_entities.PandoricShardTileEntity;
import andrews.pandoras_creatures.tile_entities.model.pandoric_shard.CoreModel;
import andrews.pandoras_creatures.tile_entities.model.pandoric_shard.PandoricShardMediumBase2Model;
import andrews.pandoras_creatures.tile_entities.model.pandoric_shard.PandoricShardMediumBase3Model;
import andrews.pandoras_creatures.tile_entities.model.pandoric_shard.PandoricShardMediumBase4Model;
import andrews.pandoras_creatures.tile_entities.model.pandoric_shard.PandoricShardMediumBaseModel;
import andrews.pandoras_creatures.tile_entities.model.pandoric_shard.PandoricShardSmallBase2Model;
import andrews.pandoras_creatures.tile_entities.model.pandoric_shard.PandoricShardSmallBase3Model;
import andrews.pandoras_creatures.tile_entities.model.pandoric_shard.PandoricShardSmallBase4Model;
import andrews.pandoras_creatures.tile_entities.model.pandoric_shard.PandoricShardSmallBaseModel;
import andrews.pandoras_creatures.tile_entities.model.pandoric_shard.PumpModel;
import andrews.pandoras_creatures.tile_entities.model.pandoric_shard.gears.BigGearModel;
import andrews.pandoras_creatures.tile_entities.model.pandoric_shard.gears.BigThinGearModel;
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
public class PandoricShardTileEntityRenderer extends TileEntityRenderer<PandoricShardTileEntity>
{
	public static final ResourceLocation SMALL_GEAR_TEXTURE = new ResourceLocation(Reference.MODID, "textures/tile/pandoric_shard/small_gear.png");
	public static final ResourceLocation MEDIUM_GEAR_TEXTURE = new ResourceLocation(Reference.MODID, "textures/tile/pandoric_shard/medium_gear.png");
	public static final ResourceLocation BIG_GEAR_TEXTURE = new ResourceLocation(Reference.MODID, "textures/tile/pandoric_shard/big_gear.png");
	public static final ResourceLocation BIG_THIN_GEAR_TEXTURE = new ResourceLocation(Reference.MODID, "textures/tile/pandoric_shard/big_thin_gear.png");
	public static final ResourceLocation CORE_TEXTURE = new ResourceLocation(Reference.MODID, "textures/tile/pandoric_shard/pandoric_shard_core.png");
	public static final ResourceLocation PUMP_TEXTURE = new ResourceLocation(Reference.MODID, "textures/tile/pandoric_shard/pandoric_shard_pump.png");
	public static final ResourceLocation BASE_TEXTURE = new ResourceLocation(Reference.MODID, "textures/tile/pandoric_shard/pandoric_shard_small_base.png");
	public static final ResourceLocation BASE_TEXTURE2 = new ResourceLocation(Reference.MODID, "textures/tile/pandoric_shard/pandoric_shard_small_base2.png");
	public static final ResourceLocation BASE_TEXTURE3 = new ResourceLocation(Reference.MODID, "textures/tile/pandoric_shard/pandoric_shard_small_base3.png");//TODO rename this shit
	public static final ResourceLocation BASE_TEXTURE4 = new ResourceLocation(Reference.MODID, "textures/tile/pandoric_shard/pandoric_shard_small_base4.png");
	public static final ResourceLocation MEDIUM_BASE_TEXTURE = new ResourceLocation(Reference.MODID, "textures/tile/pandoric_shard/pandoric_shard_medium_base.png");
	public static final ResourceLocation MEDIUM_BASE_TEXTURE2 = new ResourceLocation(Reference.MODID, "textures/tile/pandoric_shard/pandoric_shard_medium_base2.png");
	public static final ResourceLocation MEDIUM_BASE_TEXTURE3 = new ResourceLocation(Reference.MODID, "textures/tile/pandoric_shard/pandoric_shard_medium_base3.png");
	public static final ResourceLocation MEDIUM_BASE_TEXTURE4 = new ResourceLocation(Reference.MODID, "textures/tile/pandoric_shard/pandoric_shard_medium_base4.png");
	private static PandoricShardSmallBaseModel pandoricShardBaseModelSmall;
	private static PandoricShardSmallBase2Model pandoricShardBaseModel2Small;
	private static PandoricShardSmallBase3Model pandoricShardBaseModel3Small;
	private static PandoricShardSmallBase4Model pandoricShardBaseModel4Small;
	private static PandoricShardMediumBaseModel pandoricShardBaseModelMedium;
	private static PandoricShardMediumBase2Model pandoricShardBaseModel2Medium;
	private static PandoricShardMediumBase3Model pandoricShardBaseModel3Medium;
	private static PandoricShardMediumBase4Model pandoricShardBaseModel4Medium;
	private static SmallGearModel smallGearModel;
	private static MediumGearModel mediumGearModel;
	private static BigGearModel bigGearModel;
	private static BigThinGearModel bigThinGearModel;
	private static CoreModel coreModel;
	private static PumpModel pumpModel;

	public PandoricShardTileEntityRenderer(TileEntityRendererDispatcher rendererDispatcherIn)
	{
		super(rendererDispatcherIn);
		pandoricShardBaseModelSmall = new PandoricShardSmallBaseModel();
		pandoricShardBaseModel2Small = new PandoricShardSmallBase2Model();
		pandoricShardBaseModel3Small = new PandoricShardSmallBase3Model();
		pandoricShardBaseModel4Small = new PandoricShardSmallBase4Model();
		pandoricShardBaseModelMedium = new PandoricShardMediumBaseModel();
		pandoricShardBaseModel2Medium = new PandoricShardMediumBase2Model();
		pandoricShardBaseModel3Medium = new PandoricShardMediumBase3Model();
		pandoricShardBaseModel4Medium = new PandoricShardMediumBase4Model();
		smallGearModel = new SmallGearModel();
		mediumGearModel = new MediumGearModel();
		bigGearModel = new BigGearModel();
		bigThinGearModel = new BigThinGearModel();
		coreModel = new CoreModel();
		pumpModel = new PumpModel();
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
		float coreScaleValue = (float) (Math.cos(animationProgress * 0.3F) * 0.1F + 1.1F);
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
		
		switch(tileEntityIn.getShardSize())
		{
		default:
			//This only gets called when the value is 0, meaning the shard type hasn't been synchronized yet.
			//This is used to prevent it from rendering a different variant for 1 tick and then change it.
			break;
		case 1:
			switch(tileEntityIn.getShardVariant())
			{
			default:
				break;
			case 1:
				matrixStackIn.push();
				pandoricShardBaseModelSmall.decoration.rotateAngleZ = (float) (Math.cos(animationProgress * 0.1D) * 0.1F + Math.toRadians(-25));
				pandoricShardBaseModelSmall.decoration_1.rotateAngleZ = (float) (Math.cos(animationProgress * 0.1D) * -0.1F + Math.toRadians(25));
				pandoricShardBaseModelSmall.decoration_2.rotateAngleX = (float) (Math.cos(animationProgress * 0.1D) * -0.1F + Math.toRadians(25));
				pandoricShardBaseModelSmall.decoration_3.rotateAngleX = (float) (Math.cos(animationProgress * 0.1D) * 0.1F + Math.toRadians(-25));
				IVertexBuilder builderBase1 = bufferIn.getBuffer(RenderType.getEntityCutoutNoCull(BASE_TEXTURE));
				pandoricShardBaseModelSmall.base.render(matrixStackIn, builderBase1, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate(pixelSize * 1.5D, pixelSize * 20.1D, pixelSize * 5.4D);
				matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (-animationProgress * (Math.PI * 6))));
				renderSmallGear(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate(pixelSize * 4.5D, pixelSize * 20D, pixelSize * 3.4D);
				matrixStackIn.rotate(Vector3f.YN.rotationDegrees(90F));
				matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (animationProgress * (Math.PI * 2))));
				renderMediumGear(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate(pixelSize * 5.5D, pixelSize * 20D, pixelSize * -0.5D);
				matrixStackIn.rotate(Vector3f.YN.rotationDegrees(90F));
				matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (-animationProgress * (Math.PI * 2))));
				renderMediumGear(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate(pixelSize * 1.3D, pixelSize * 22D, pixelSize * -3D);
				matrixStackIn.rotate(Vector3f.XN.rotationDegrees(90F));
				matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (animationProgress * (Math.PI))));
				renderBigGear(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate(0.0D, (pixelSize * 14.5D) + Math.cos(animationProgress * 0.1D) * 0.05D, 0.0D);
				matrixStackIn.scale(coreScaleValue, coreScaleValue, coreScaleValue);
				matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (animationProgress * (Math.PI / 2))));
				matrixStackIn.rotate(Vector3f.XN.rotationDegrees((float) (animationProgress * (Math.PI / 2))));
				matrixStackIn.rotate(Vector3f.YN.rotationDegrees((float) (animationProgress * (Math.PI / 2))));
				renderCore(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				break;
			case 2:
				matrixStackIn.push();
				IVertexBuilder builderBase = bufferIn.getBuffer(RenderType.getEntityCutoutNoCull(BASE_TEXTURE2));
				pandoricShardBaseModel2Small.base.render(matrixStackIn, builderBase, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate((pixelSize * 3.5D), (pixelSize * 19.5D), (pixelSize * -1.0D) + Math.cos(animationProgress * 0.1D) * 0.05D);
				matrixStackIn.scale(coreScaleValue, coreScaleValue, coreScaleValue);
				matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (animationProgress * (Math.PI / 2))));
				matrixStackIn.rotate(Vector3f.XN.rotationDegrees((float) (animationProgress * (Math.PI / 2))));
				matrixStackIn.rotate(Vector3f.YN.rotationDegrees((float) (animationProgress * (Math.PI / 2))));
				renderCore(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate(pixelSize * 1.7D, pixelSize * 18D, pixelSize * 5.5D);
				matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (animationProgress * (Math.PI))));
				renderBigGear(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate(pixelSize * -1.4D, pixelSize * 22.5D, pixelSize * 0.2D);
				matrixStackIn.rotate(Vector3f.XP.rotationDegrees(90F));
				matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (animationProgress * (Math.PI * 2))));
				renderMediumGear(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate(pixelSize * -1.2D, pixelSize * 21.0D, pixelSize * 0.4D);
				matrixStackIn.rotate(Vector3f.XP.rotationDegrees(90F));
				matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (-animationProgress * (Math.PI * 6))));
				renderSmallGear(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate(pixelSize * -3.9D, pixelSize * 20.0D, pixelSize * 2.5D);
				matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (-animationProgress * (Math.PI * 6))));
				renderSmallGear(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				break;
			case 3:
				matrixStackIn.push();
				IVertexBuilder builderBase2 = bufferIn.getBuffer(RenderType.getEntityCutoutNoCull(BASE_TEXTURE3));
				pandoricShardBaseModel3Small.base.render(matrixStackIn, builderBase2, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate((pixelSize * -3.5D), (pixelSize * 15.5D) + Math.cos(animationProgress * 0.1D) * 0.05D, (pixelSize * 3.5D));
				matrixStackIn.scale(coreScaleValue, coreScaleValue, coreScaleValue);
				matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (animationProgress * (Math.PI / 2))));
				matrixStackIn.rotate(Vector3f.XN.rotationDegrees((float) (animationProgress * (Math.PI / 2))));
				matrixStackIn.rotate(Vector3f.YN.rotationDegrees((float) (animationProgress * (Math.PI / 2))));
				renderCore(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate(pixelSize * 0.5D, pixelSize * 19D, pixelSize * 2.5D);
				matrixStackIn.rotate(Vector3f.YN.rotationDegrees(90F));
				matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (animationProgress * (Math.PI))));
				renderBigThinGear(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate(pixelSize * 4.5D, pixelSize * 19D, pixelSize * 4.6D);
				matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (animationProgress * (Math.PI * 2))));
				renderMediumGear(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate(pixelSize * -3.2D, pixelSize * 22.5D, pixelSize * -2.9D);
				matrixStackIn.rotate(Vector3f.XN.rotationDegrees(90F));
				matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (-animationProgress * (Math.PI * 6))));
				renderSmallGear(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate(pixelSize * -1.8D, pixelSize * 21.5D, pixelSize * -2.9D);
				matrixStackIn.rotate(Vector3f.XN.rotationDegrees(90F));
				matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (animationProgress * (Math.PI * 6))));
				renderSmallGear(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				break;
			case 4:
				matrixStackIn.push();
				pandoricShardBaseModel4Small.decoration.rotateAngleZ = (float) (Math.cos(animationProgress * 0.1D) * 0.1F + Math.toRadians(-25));
				pandoricShardBaseModel4Small.decoration_1.rotateAngleZ = (float) (Math.cos(animationProgress * 0.1D) * -0.1F + Math.toRadians(25));
				pandoricShardBaseModel4Small.decoration_2.rotateAngleX = (float) (Math.cos(animationProgress * 0.1D) * -0.1F + Math.toRadians(25));
				pandoricShardBaseModel4Small.decoration_3.rotateAngleX = (float) (Math.cos(animationProgress * 0.1D) * 0.1F + Math.toRadians(-25));
				IVertexBuilder builderBase3 = bufferIn.getBuffer(RenderType.getEntityCutoutNoCull(BASE_TEXTURE4));
				pandoricShardBaseModel4Small.base.render(matrixStackIn, builderBase3, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate(pixelSize * -4.0D, pixelSize * 23.0D, pixelSize * -4.0D);
				renderPump(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn, animationProgress);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate(pixelSize * 3.5D, pixelSize * 22.0D, pixelSize * -2.0D);
				matrixStackIn.scale(0.9F, 1.0F, 0.9F);
				matrixStackIn.rotate(Vector3f.XN.rotationDegrees(90F));
				matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (-animationProgress * (Math.PI))));
				renderBigGear(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate(pixelSize * -3.5D, pixelSize * 18D, pixelSize * 4.5D);
				matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (-animationProgress * (Math.PI * 2))));
				renderMediumGear(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate(pixelSize * 0.0D, pixelSize * 22.5D, pixelSize * 6.0D);
				matrixStackIn.rotate(Vector3f.XN.rotationDegrees(90F));
				matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (animationProgress * (Math.PI * 6))));
				renderSmallGear(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate((pixelSize * 3.5D), (pixelSize * 14.5D) + Math.cos(animationProgress * 0.1D) * 0.05D, (pixelSize * 1.5D));
				matrixStackIn.scale(coreScaleValue, coreScaleValue, coreScaleValue);
				matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (animationProgress * (Math.PI / 2))));
				matrixStackIn.rotate(Vector3f.XN.rotationDegrees((float) (animationProgress * (Math.PI / 2))));
				matrixStackIn.rotate(Vector3f.YN.rotationDegrees((float) (animationProgress * (Math.PI / 2))));
				renderCore(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
			}
			break;
		case 2:
			switch(tileEntityIn.getShardVariant())
			{
			default:
				break;
			case 1:
				matrixStackIn.push();
				IVertexBuilder builderBase = bufferIn.getBuffer(RenderType.getEntityCutoutNoCull(MEDIUM_BASE_TEXTURE));
				pandoricShardBaseModelMedium.base.render(matrixStackIn, builderBase, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate((pixelSize * 3.5D), (pixelSize * 19.5D), (pixelSize * -3.0D) + Math.cos(animationProgress * 0.1D) * 0.05D);
				matrixStackIn.scale(coreScaleValue, coreScaleValue, coreScaleValue);
				matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (animationProgress * (Math.PI / 2))));
				matrixStackIn.rotate(Vector3f.XN.rotationDegrees((float) (animationProgress * (Math.PI / 2))));
				matrixStackIn.rotate(Vector3f.YN.rotationDegrees((float) (animationProgress * (Math.PI / 2))));
				renderCore(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate(pixelSize * -3.5D, pixelSize * 20.0D, pixelSize * -0.5D);
				renderPump(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn, animationProgress);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate(pixelSize * -3.3D, pixelSize * 22D, pixelSize * -3.4D);
				matrixStackIn.rotate(Vector3f.XN.rotationDegrees(90F));
				matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (animationProgress * (Math.PI))));
				renderBigGear(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate(pixelSize * -1.0D, pixelSize * 13.5D, pixelSize * 3.5D);
				matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (animationProgress * (Math.PI * 2))));
				renderMediumGear(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate(pixelSize * -6.5D, pixelSize * 16.5D, pixelSize * 4.5D);
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(90F));
				matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (-animationProgress * (Math.PI * 6))));
				renderSmallGear(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate(pixelSize * -1.5D, pixelSize * 12.5D, pixelSize * -2.5D);
				matrixStackIn.rotate(Vector3f.XN.rotationDegrees(90F));
				matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (animationProgress * (Math.PI * 6))));
				renderSmallGear(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				break;
			case 2:
				matrixStackIn.push();
				pandoricShardBaseModel2Medium.decoration.rotateAngleZ = (float) (Math.cos(animationProgress * 0.1D) * 0.1F + Math.toRadians(-25));
				pandoricShardBaseModel2Medium.decoration_1.rotateAngleZ = (float) (Math.cos(animationProgress * 0.1D) * -0.1F + Math.toRadians(25));
				pandoricShardBaseModel2Medium.decoration_2.rotateAngleX = (float) (Math.cos(animationProgress * 0.1D) * -0.1F + Math.toRadians(25));
				pandoricShardBaseModel2Medium.decoration_3.rotateAngleX = (float) (Math.cos(animationProgress * 0.1D) * 0.1F + Math.toRadians(-25));
				IVertexBuilder builderBase1 = bufferIn.getBuffer(RenderType.getEntityCutoutNoCull(MEDIUM_BASE_TEXTURE2));
				pandoricShardBaseModel2Medium.base.render(matrixStackIn, builderBase1, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate(pixelSize * 1.0D, (pixelSize * 14.5D) + Math.cos(animationProgress * 0.1D) * 0.05D, pixelSize * -3.0D);
				matrixStackIn.scale(coreScaleValue, coreScaleValue, coreScaleValue);
				matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (animationProgress * (Math.PI / 2))));
				matrixStackIn.rotate(Vector3f.XN.rotationDegrees((float) (animationProgress * (Math.PI / 2))));
				matrixStackIn.rotate(Vector3f.YN.rotationDegrees((float) (animationProgress * (Math.PI / 2))));
				renderCore(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate(pixelSize * -2.6D, pixelSize * 17.8D, pixelSize * 5.0D);
				matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (animationProgress * (Math.PI))));
				renderBigGear(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate(pixelSize * 3.0D, pixelSize * 17.8D, pixelSize * 6.45D);
				matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (-animationProgress * (Math.PI * 2))));
				renderMediumGear(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate(pixelSize * 6.55D, pixelSize * 17.55D, pixelSize * 2.5D);
				matrixStackIn.rotate(Vector3f.YN.rotationDegrees(90F));
				matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (-animationProgress * (Math.PI))));
				renderBigThinGear(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate(pixelSize * -1.5D, pixelSize * 14.5D, pixelSize * 2.0D);
				matrixStackIn.rotate(Vector3f.YN.rotationDegrees(90F));
				matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (animationProgress * (Math.PI * 6))));
				renderSmallGear(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				break;
			case 3:
				matrixStackIn.push();
				IVertexBuilder builderBase2 = bufferIn.getBuffer(RenderType.getEntityCutoutNoCull(MEDIUM_BASE_TEXTURE3));
				pandoricShardBaseModel3Medium.base.render(matrixStackIn, builderBase2, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate(pixelSize * 1.5D, (pixelSize * 14.5D) + Math.cos(animationProgress * 0.1D) * 0.05D, pixelSize * 1.5D);
				matrixStackIn.scale(coreScaleValue, coreScaleValue, coreScaleValue);
				matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (animationProgress * (Math.PI / 2))));
				matrixStackIn.rotate(Vector3f.XN.rotationDegrees((float) (animationProgress * (Math.PI / 2))));
				matrixStackIn.rotate(Vector3f.YN.rotationDegrees((float) (animationProgress * (Math.PI / 2))));
				renderCore(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate(pixelSize * 0.5D, pixelSize * 23.0D, pixelSize * -4.5D);
				renderPump(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn, animationProgress);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate(pixelSize * 2.0D, pixelSize * 22.0D, pixelSize * 2.35D);
				matrixStackIn.rotate(Vector3f.XN.rotationDegrees(90F));
				matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (animationProgress * (Math.PI))));
				renderBigGear(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate(pixelSize * -2.5D, pixelSize * 17.8D, pixelSize * 4.5D);
				matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (-animationProgress * (Math.PI * 2))));
				renderMediumGear(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate(pixelSize * -4.5D, pixelSize * 15.5D, pixelSize * 2.0D);
				matrixStackIn.rotate(Vector3f.YN.rotationDegrees(90F));
				matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (animationProgress * (Math.PI * 6))));
				renderSmallGear(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate(pixelSize * 0.5D, pixelSize * 19.1D, pixelSize * 5.5D);
				matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (animationProgress * (Math.PI * 6))));
				renderSmallGear(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				break;
			case 4:
				matrixStackIn.push();
				pandoricShardBaseModel4Medium.decoration.rotateAngleZ = (float) (Math.cos(animationProgress * 0.1D) * 0.1F + Math.toRadians(-25));
				pandoricShardBaseModel4Medium.decoration_1.rotateAngleZ = (float) (Math.cos(animationProgress * 0.1D) * -0.1F + Math.toRadians(25));
				pandoricShardBaseModel4Medium.decoration_2.rotateAngleX = (float) (Math.cos(animationProgress * 0.1D) * -0.1F + Math.toRadians(25));
				pandoricShardBaseModel4Medium.decoration_3.rotateAngleX = (float) (Math.cos(animationProgress * 0.1D) * 0.1F + Math.toRadians(-25));
				IVertexBuilder builderBase3 = bufferIn.getBuffer(RenderType.getEntityCutoutNoCull(MEDIUM_BASE_TEXTURE4));
				pandoricShardBaseModel4Medium.base.render(matrixStackIn, builderBase3, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate(pixelSize * -1.5D, (pixelSize * 14.5D) + Math.cos(animationProgress * 0.1D) * 0.05D, pixelSize * -3.5D);
				matrixStackIn.scale(coreScaleValue, coreScaleValue, coreScaleValue);
				matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (animationProgress * (Math.PI / 2))));
				matrixStackIn.rotate(Vector3f.XN.rotationDegrees((float) (animationProgress * (Math.PI / 2))));
				matrixStackIn.rotate(Vector3f.YN.rotationDegrees((float) (animationProgress * (Math.PI / 2))));
				renderCore(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate(pixelSize * 3.5D, pixelSize * 18.0D, pixelSize * 3.5D);
				renderPump(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn, animationProgress);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate(pixelSize * -6.5D, pixelSize * 16.55D, pixelSize * 2.3D);
				matrixStackIn.rotate(Vector3f.YN.rotationDegrees(90F));
				matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (-animationProgress * (Math.PI))));
				renderBigThinGear(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate(pixelSize * -2.5D, pixelSize * 14.8D, pixelSize * 4.5D);
				matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (animationProgress * (Math.PI * 2))));
				renderMediumGear(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate(pixelSize * 4.5D, pixelSize * 22.5D, pixelSize * -1.5D);
				matrixStackIn.rotate(Vector3f.XP.rotationDegrees(90F));
				matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (animationProgress * (Math.PI * 2))));
				renderMediumGear(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				
				matrixStackIn.push();
				matrixStackIn.translate(pixelSize * 4.5D, pixelSize * 21.5D, pixelSize * -4.0D);
				matrixStackIn.rotate(Vector3f.XP.rotationDegrees(90F));
				matrixStackIn.rotate(Vector3f.ZN.rotationDegrees((float) (-animationProgress * (Math.PI * 6))));
				renderSmallGear(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
			}
		}
		
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
	
	/**
	 * Renders a Small Gear
	 */
	private static void renderSmallGear(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn)
	{
		IVertexBuilder builderSmallGear = bufferIn.getBuffer(RenderType.getEntityCutoutNoCull(SMALL_GEAR_TEXTURE));
		smallGearModel.base.render(matrixStackIn, builderSmallGear, combinedLightIn, combinedOverlayIn);
	}
	
	/**
	 * Renders a Medium Gear
	 */
	private static void renderMediumGear(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn)
	{
		IVertexBuilder builderMediumGear = bufferIn.getBuffer(RenderType.getEntityCutoutNoCull(MEDIUM_GEAR_TEXTURE));
		mediumGearModel.base.render(matrixStackIn, builderMediumGear, combinedLightIn, combinedOverlayIn);
	}
	
	/**
	 * Renders a Big Gear
	 */
	private static void renderBigGear(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn)
	{
		IVertexBuilder builderBigGear = bufferIn.getBuffer(RenderType.getEntityCutoutNoCull(BIG_GEAR_TEXTURE));
		bigGearModel.center.render(matrixStackIn, builderBigGear, combinedLightIn, combinedOverlayIn);
	}
	
	/**
	 * Renders a Big Thin Gear
	 */
	private static void renderBigThinGear(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn)
	{
		IVertexBuilder builderBigThinGear = bufferIn.getBuffer(RenderType.getEntityCutoutNoCull(BIG_THIN_GEAR_TEXTURE));
		bigThinGearModel.base.render(matrixStackIn, builderBigThinGear, combinedLightIn, combinedOverlayIn);
	}
	
	/**
	 * Renders a Core
	 */
	private static void renderCore(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn)
	{
		IVertexBuilder builderCore = VertexBuilderUtils.newDelegate(bufferIn.getBuffer(RenderType.getEntityGlint()), bufferIn.getBuffer(PCRenderTypes.getEmissiveEntity(CORE_TEXTURE)));
		coreModel.base.render(matrixStackIn, builderCore, combinedLightIn, OverlayTexture.NO_OVERLAY);
	}
	
	/**
	 * Renders a Pump
	 */
	private static void renderPump(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn, float animationProgress)
	{
		IVertexBuilder builderPump = bufferIn.getBuffer(RenderType.getEntityCutoutNoCull(PUMP_TEXTURE));
		pumpModel.base.render(matrixStackIn, builderPump, combinedLightIn, OverlayTexture.NO_OVERLAY);
		matrixStackIn.push();
		matrixStackIn.translate(0, Math.abs(Math.sin(animationProgress / 10F) / 20F), 0);
		matrixStackIn.scale(1.0F, (float) Math.abs(Math.sin(animationProgress / 10F)) + 0.24F, 1.0F);
		pumpModel.center.render(matrixStackIn, builderPump, combinedLightIn, OverlayTexture.NO_OVERLAY);
		matrixStackIn.pop();
		pumpModel.top.render(matrixStackIn, builderPump, combinedLightIn, OverlayTexture.NO_OVERLAY);
	}
}