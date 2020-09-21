package andrews.pandoras_creatures.tile_entities.render;

import java.util.List;
import java.util.stream.Stream;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import andrews.pandoras_creatures.objects.blocks.BlockEndTrollBox;
import andrews.pandoras_creatures.tile_entities.EndTrollBoxTileEntity;
import andrews.pandoras_creatures.tile_entities.model.EndTrollBoxModel;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.DyeColor;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EndTrollBoxTileEntityRenderer extends TileEntityRenderer<EndTrollBoxTileEntity>
{
	private EndTrollBoxModel blockModel;
	public static final ResourceLocation DEFAULT_END_TROLL_BOX_TEXTURE = new ResourceLocation(Reference.MODID, "textures/tile/end_troll_box.png");
	public static final List<ResourceLocation> END_TROLL_BOX_TEXTURE = Stream.of("white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black").map((color) ->
	{
		return new ResourceLocation(Reference.MODID, "textures/tile/" + color + "_end_troll_box.png");
	}).collect(ImmutableList.toImmutableList());
	
	public EndTrollBoxTileEntityRenderer(TileEntityRendererDispatcher dispatcher)
	{
		super(dispatcher);
		this.blockModel = new EndTrollBoxModel();
	}
	
	@Override
	public void render(EndTrollBoxTileEntity tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn)
	{
		Direction direction = Direction.UP;
		float pixelSize = 0.0625F;
		
		if(tileEntityIn.hasWorld())
		{
			BlockState blockstate = tileEntityIn.getWorld().getBlockState(tileEntityIn.getPos());
			if(blockstate.getBlock() instanceof BlockEndTrollBox)
			{
				direction = blockstate.get(BlockEndTrollBox.FACING);
			}
		}

		DyeColor dyecolor = tileEntityIn.getColor();
		ResourceLocation texture;
		if(dyecolor == null)
		{
			texture = DEFAULT_END_TROLL_BOX_TEXTURE;
		}
		else
		{
			texture = END_TROLL_BOX_TEXTURE.get(dyecolor.getId());
		}
		
		matrixStackIn.push();
		
		IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEntityCutoutNoCull(texture));
		
		matrixStackIn.translate(0.5D, 1.5D, 0.5D);
		matrixStackIn.scale(1.0F, -1.0F, -1.0F);
		switch(direction)
		{
		case DOWN:
			matrixStackIn.translate(0.0F, 2.0F, 0.0F);
			matrixStackIn.rotate(Vector3f.XP.rotationDegrees(180.0F));
			break;
		case UP:
		default:
			break;
		case NORTH:
			matrixStackIn.translate(0.0F, 1.0F, 1.0F);
			matrixStackIn.rotate(Vector3f.XP.rotationDegrees(90.0F));
			matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(180.0F));
			break;
		case SOUTH:
			matrixStackIn.translate(0.0F, 1.0F, -1.0F);
			matrixStackIn.rotate(Vector3f.XP.rotationDegrees(90.0F));
			break;
		case WEST:
			matrixStackIn.translate(-1.0F, 1.0F, 0.0F);
			matrixStackIn.rotate(Vector3f.XP.rotationDegrees(90.0F));
			matrixStackIn.rotate(Vector3f.ZN.rotationDegrees(90.0F));
			break;
		case EAST:
			matrixStackIn.translate(1.0F, 1.0F, 0.0F);
			matrixStackIn.rotate(Vector3f.XP.rotationDegrees(90.0F));
			matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90.0F));
		}
		
		//Bottom Front Left
		matrixStackIn.push();
		matrixStackIn.translate(tileEntityIn.getProgress(partialTicks) * (pixelSize * 1.5F), 0.0F, -tileEntityIn.getProgress(partialTicks) * (pixelSize * 1.5F));
		this.blockModel.bottom_front_left.render(matrixStackIn, ivertexbuilder, combinedLightIn, combinedOverlayIn);
		matrixStackIn.pop();
		//Bottom Front Right
		matrixStackIn.push();
		matrixStackIn.translate(-tileEntityIn.getProgress(partialTicks) * (pixelSize * 1.5F), 0.0F, -tileEntityIn.getProgress(partialTicks) * (pixelSize * 1.5F));
		this.blockModel.bottom_front_right.render(matrixStackIn, ivertexbuilder, combinedLightIn, combinedOverlayIn);
		matrixStackIn.pop();
		//Bottom Back Left
		matrixStackIn.push();
		matrixStackIn.translate(tileEntityIn.getProgress(partialTicks) * (pixelSize * 1.5F), 0.0F, tileEntityIn.getProgress(partialTicks) * (pixelSize * 1.5F));
		this.blockModel.bottom_back_left.render(matrixStackIn, ivertexbuilder, combinedLightIn, combinedOverlayIn);
		matrixStackIn.pop();
		//Bottom Back Right
		matrixStackIn.push();
		matrixStackIn.translate(-tileEntityIn.getProgress(partialTicks) * (pixelSize * 1.5F), 0.0F, tileEntityIn.getProgress(partialTicks) * (pixelSize * 1.5F));
		this.blockModel.bottom_back_right.render(matrixStackIn, ivertexbuilder, combinedLightIn, combinedOverlayIn);
		matrixStackIn.pop();
		
		
		matrixStackIn.push();
		matrixStackIn.translate(0.0F, -tileEntityIn.getProgress(partialTicks) * (pixelSize * 1.5F), 0.0F);
		this.blockModel.base.render(matrixStackIn, ivertexbuilder, combinedLightIn, combinedOverlayIn);
		//Decorations
		this.blockModel.decoration_front_left.render(matrixStackIn, ivertexbuilder, combinedLightIn, combinedOverlayIn);
		this.blockModel.decoration_front_right.render(matrixStackIn, ivertexbuilder, combinedLightIn, combinedOverlayIn);
		this.blockModel.decoration_back_left.render(matrixStackIn, ivertexbuilder, combinedLightIn, combinedOverlayIn);
		this.blockModel.decoration_back_right.render(matrixStackIn, ivertexbuilder, combinedLightIn, combinedOverlayIn);
		
			//Lid Front
			matrixStackIn.push();
			matrixStackIn.translate(0.0F, (pixelSize * 13.5F), (pixelSize * -6.0F));
			matrixStackIn.rotate(Vector3f.XP.rotationDegrees(30.0F * tileEntityIn.getProgress(partialTicks)));
			matrixStackIn.translate(-0.0F, -(pixelSize * 13.5F), -(pixelSize * -6.0F));
			this.blockModel.lid_front.render(matrixStackIn, ivertexbuilder, combinedLightIn, combinedOverlayIn);
			matrixStackIn.pop();
			//Lid Back
			matrixStackIn.push();
			matrixStackIn.translate(0.0F, (pixelSize * 13.5F), (pixelSize * 6.0F));
			matrixStackIn.rotate(Vector3f.XN.rotationDegrees(30.0F * tileEntityIn.getProgress(partialTicks)));
			matrixStackIn.translate(-0.0F, -(pixelSize * 13.5F), -(pixelSize * 6.0F));
			this.blockModel.lid_back.render(matrixStackIn, ivertexbuilder, combinedLightIn, combinedOverlayIn);
			matrixStackIn.pop();
			//Lid Left
			matrixStackIn.push();
			matrixStackIn.translate((pixelSize * 6.0F), (pixelSize * 13.5F), 0.0F);
			matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(10.0F * tileEntityIn.getProgress(partialTicks)));
			matrixStackIn.translate(-(pixelSize * 6.0F), -(pixelSize * 13.5F), 0.0F);
			this.blockModel.lid_left.render(matrixStackIn, ivertexbuilder, combinedLightIn, combinedOverlayIn);
				matrixStackIn.push();
				matrixStackIn.translate((pixelSize * 6.0F), (pixelSize * 11.5F), 0.0F);
				matrixStackIn.rotate(Vector3f.ZN.rotationDegrees(65.0F * tileEntityIn.getProgress(partialTicks)));
				matrixStackIn.translate(-(pixelSize * 6.0F), -(pixelSize * 11.5F), 0.0F);
				this.blockModel.lid_top_left.render(matrixStackIn, ivertexbuilder, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
			matrixStackIn.pop();
			//Lid Right
			matrixStackIn.push();
			matrixStackIn.translate((pixelSize * -6.0F), (pixelSize * 13.5F), 0.0F);
			matrixStackIn.rotate(Vector3f.ZN.rotationDegrees(10.0F * tileEntityIn.getProgress(partialTicks)));
			matrixStackIn.translate(-(pixelSize * -6.0F), -(pixelSize * 13.5F), 0.0F);
			this.blockModel.lid_right.render(matrixStackIn, ivertexbuilder, combinedLightIn, combinedOverlayIn);
				matrixStackIn.push();
				matrixStackIn.translate((pixelSize * -6.0F), (pixelSize * 11.5F), 0.0F);
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(65.0F * tileEntityIn.getProgress(partialTicks)));
				matrixStackIn.translate(-(pixelSize * -6.0F), -(pixelSize * 11.5F), 0.0F);
				this.blockModel.lid_top_right.render(matrixStackIn, ivertexbuilder, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
			matrixStackIn.pop();
			//Top Cubes
			matrixStackIn.push();
			matrixStackIn.translate(0.0F, -tileEntityIn.getProgress(partialTicks) * (pixelSize * 1.5F), 0.0F);
				//Top Front Left
				matrixStackIn.push();
				matrixStackIn.translate(tileEntityIn.getProgress(partialTicks) * (pixelSize * 1.5F), 0.0F, -tileEntityIn.getProgress(partialTicks) * (pixelSize * 1.5F));
				this.blockModel.top_front_left_1.render(matrixStackIn, ivertexbuilder, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				//Top Front Right
				matrixStackIn.push();
				matrixStackIn.translate(-tileEntityIn.getProgress(partialTicks) * (pixelSize * 1.5F), 0.0F, -tileEntityIn.getProgress(partialTicks) * (pixelSize * 1.5F));
				this.blockModel.top_front_left.render(matrixStackIn, ivertexbuilder, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				//Top Back Left
				matrixStackIn.push();
				matrixStackIn.translate(tileEntityIn.getProgress(partialTicks) * (pixelSize * 1.5F), 0.0F, tileEntityIn.getProgress(partialTicks) * (pixelSize * 1.5F));
				this.blockModel.top_back_left.render(matrixStackIn, ivertexbuilder, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
				//Top Back Right
				matrixStackIn.push();
				matrixStackIn.translate(-tileEntityIn.getProgress(partialTicks) * (pixelSize * 1.5F), 0.0F, tileEntityIn.getProgress(partialTicks) * (pixelSize * 1.5F));
				this.blockModel.top_back_right.render(matrixStackIn, ivertexbuilder, combinedLightIn, combinedOverlayIn);
				matrixStackIn.pop();
			matrixStackIn.pop();
		matrixStackIn.pop();
		matrixStackIn.pop();
	}
}
