package andrews.pandoras_creatures.tile_entities.render;

import com.mojang.blaze3d.platform.GlStateManager;

import andrews.pandoras_creatures.objects.blocks.BlockEndTrollBox;
import andrews.pandoras_creatures.tile_entities.EndTrollBoxTileEntity;
import andrews.pandoras_creatures.tile_entities.model.EndTrollBoxModel;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.DyeColor;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EndTrollBoxTileEntityRenderer extends TileEntityRenderer<EndTrollBoxTileEntity>
{
	private EndTrollBoxModel blockModel;
	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID, "textures/tile/end_troll_box.png");
	public static final ResourceLocation[] COLORED_END_TROLL_BOX_TEXTURE = new ResourceLocation[]{new ResourceLocation(Reference.MODID, "textures/tile/white_end_troll_box.png"), new ResourceLocation(Reference.MODID, "textures/tile/orange_end_troll_box.png"), new ResourceLocation(Reference.MODID, "textures/tile/magenta_end_troll_box.png"), new ResourceLocation(Reference.MODID, "textures/tile/light_blue_end_troll_box.png"), new ResourceLocation(Reference.MODID, "textures/tile/yellow_end_troll_box.png"), new ResourceLocation(Reference.MODID, "textures/tile/lime_end_troll_box.png"), new ResourceLocation(Reference.MODID, "textures/tile/pink_end_troll_box.png"), new ResourceLocation(Reference.MODID, "textures/tile/gray_end_troll_box.png"), new ResourceLocation(Reference.MODID, "textures/tile/light_gray_end_troll_box.png"), new ResourceLocation(Reference.MODID, "textures/tile/cyan_end_troll_box.png"), new ResourceLocation(Reference.MODID, "textures/tile/purple_end_troll_box.png"), new ResourceLocation(Reference.MODID, "textures/tile/blue_end_troll_box.png"), new ResourceLocation(Reference.MODID, "textures/tile/brown_end_troll_box.png"), new ResourceLocation(Reference.MODID, "textures/tile/green_end_troll_box.png"), new ResourceLocation(Reference.MODID, "textures/tile/red_end_troll_box.png"), new ResourceLocation(Reference.MODID, "textures/tile/black_end_troll_box.png")};
	
	public EndTrollBoxTileEntityRenderer()
	{
		this.blockModel = new EndTrollBoxModel();
	}
	
	@Override
	public void render(EndTrollBoxTileEntity tileEntityIn, double x, double y, double z, float partialTicks, int destroyStage)
	{
		Direction direction = Direction.UP;
		float pixelSize = 0.0625F;
		
		if(tileEntityIn.hasWorld())
		{
			BlockState blockstate = this.getWorld().getBlockState(tileEntityIn.getPos());
			if(blockstate.getBlock() instanceof BlockEndTrollBox)
			{
				direction = blockstate.get(BlockEndTrollBox.FACING);
			}
		}

		GlStateManager.enableDepthTest();
		GlStateManager.depthFunc(515);
		GlStateManager.depthMask(true);
		GlStateManager.disableCull();
		if(destroyStage >= 0)
		{
			this.bindTexture(DESTROY_STAGES[destroyStage]);
			GlStateManager.matrixMode(5890);
			GlStateManager.pushMatrix();
			GlStateManager.scalef(4.0F, 4.0F, 1.0F);
			GlStateManager.translatef(0.0625F, 0.0625F, 0.0625F);
			GlStateManager.matrixMode(5888);
		}
		else
		{
			DyeColor dyecolor = tileEntityIn.getColor();
			if(dyecolor == null)
			{
				this.bindTexture(EndTrollBoxTileEntityRenderer.TEXTURE);
			}
			else
			{
				this.bindTexture(EndTrollBoxTileEntityRenderer.COLORED_END_TROLL_BOX_TEXTURE[dyecolor.getId()]);
			}
		}

		GlStateManager.pushMatrix();
		GlStateManager.enableRescaleNormal();
		if(destroyStage < 0)
		{
			GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		}

		GlStateManager.translatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GlStateManager.scalef(1.0F, -1.0F, -1.0F);
		GlStateManager.translatef(0.0F, 1.0F, 0.0F);
		GlStateManager.scalef(0.9995F, 0.9995F, 0.9995F);
		GlStateManager.translatef(0.0F, -1.0F, 0.0F);
		switch (direction)
		{
		case DOWN:
			GlStateManager.translatef(0.0F, 2.0F, 0.0F);
			GlStateManager.rotatef(180.0F, 1.0F, 0.0F, 0.0F);
		case UP:
		default:
			break;
		case NORTH:
			GlStateManager.translatef(0.0F, 1.0F, 1.0F);
			GlStateManager.rotatef(90.0F, 1.0F, 0.0F, 0.0F);
			GlStateManager.rotatef(180.0F, 0.0F, 0.0F, 1.0F);
			break;
		case SOUTH:
			GlStateManager.translatef(0.0F, 1.0F, -1.0F);
			GlStateManager.rotatef(90.0F, 1.0F, 0.0F, 0.0F);
			break;
		case WEST:
			GlStateManager.translatef(-1.0F, 1.0F, 0.0F);
			GlStateManager.rotatef(90.0F, 1.0F, 0.0F, 0.0F);
			GlStateManager.rotatef(-90.0F, 0.0F, 0.0F, 1.0F);
			break;
		case EAST:
			GlStateManager.translatef(1.0F, 1.0F, 0.0F);
			GlStateManager.rotatef(90.0F, 1.0F, 0.0F, 0.0F);
			GlStateManager.rotatef(90.0F, 0.0F, 0.0F, 1.0F);
		}
		
		//Bottom Front Left
		GlStateManager.pushMatrix();
		GlStateManager.translatef(tileEntityIn.getProgress(partialTicks) * (pixelSize * 1.5F), 0.0F, -tileEntityIn.getProgress(partialTicks) * (pixelSize * 1.5F));
		this.blockModel.bottom_front_left.render(pixelSize);
		GlStateManager.popMatrix();
		//Bottom Front Right
		GlStateManager.pushMatrix();
		GlStateManager.translatef(-tileEntityIn.getProgress(partialTicks) * (pixelSize * 1.5F), 0.0F, -tileEntityIn.getProgress(partialTicks) * (pixelSize * 1.5F));
		this.blockModel.bottom_front_right.render(pixelSize);
		GlStateManager.popMatrix();
		//Bottom Back Left
		GlStateManager.pushMatrix();
		GlStateManager.translatef(tileEntityIn.getProgress(partialTicks) * (pixelSize * 1.5F), 0.0F, tileEntityIn.getProgress(partialTicks) * (pixelSize * 1.5F));
		this.blockModel.bottom_back_left.render(pixelSize);
		GlStateManager.popMatrix();
		//Bottom Back Right
		GlStateManager.pushMatrix();
		GlStateManager.translatef(-tileEntityIn.getProgress(partialTicks) * (pixelSize * 1.5F), 0.0F, tileEntityIn.getProgress(partialTicks) * (pixelSize * 1.5F));
		this.blockModel.bottom_back_right.render(pixelSize);
		GlStateManager.popMatrix();
		
		GlStateManager.pushMatrix();
		GlStateManager.translatef(0.0F, -tileEntityIn.getProgress(partialTicks) * (pixelSize * 1.5F), 0.0F);
		this.blockModel.base.render(pixelSize);
		//Decorations
		this.blockModel.decoration_front_left.render(pixelSize);
		this.blockModel.decoration_front_right.render(pixelSize);
		this.blockModel.decoration_back_left.render(pixelSize);
		this.blockModel.decoration_back_right.render(pixelSize);
		
		//Lid Front
		GlStateManager.pushMatrix();
		GlStateManager.translatef(0.0F, (pixelSize * 13.5F), (pixelSize * -6.0F));
		GlStateManager.rotatef(30.0F * tileEntityIn.getProgress(partialTicks), 1.0F, 0.0F, 0.0F);
		GlStateManager.translatef(-0.0F, -(pixelSize * 13.5F), -(pixelSize * -6.0F));
		this.blockModel.lid_front.render(pixelSize);
		GlStateManager.popMatrix();
		//Lid Back
		GlStateManager.pushMatrix();
		GlStateManager.translatef(0.0F, (pixelSize * 13.5F), (pixelSize * 6.0F));
		GlStateManager.rotatef(-30.0F * tileEntityIn.getProgress(partialTicks), 1.0F, 0.0F, 0.0F);
		GlStateManager.translatef(-0.0F, -(pixelSize * 13.5F), -(pixelSize * 6.0F));
		this.blockModel.lid_back.render(pixelSize);
		GlStateManager.popMatrix();
		//Lid Left
		GlStateManager.pushMatrix();
		GlStateManager.translatef((pixelSize * 6.0F), (pixelSize * 13.5F), 0.0F);
		GlStateManager.rotatef(10.0F * tileEntityIn.getProgress(partialTicks), 0.0F, 0.0F, 1.0F);
		GlStateManager.translatef(-(pixelSize * 6.0F), -(pixelSize * 13.5F), 0.0F);
		this.blockModel.lid_left.render(pixelSize);
			GlStateManager.pushMatrix();
			GlStateManager.translatef((pixelSize * 6.0F), (pixelSize * 11.5F), 0.0F);
			GlStateManager.rotatef(-65.0F * tileEntityIn.getProgress(partialTicks), 0.0F, 0.0F, 1.0F);
			GlStateManager.translatef(-(pixelSize * 6.0F), -(pixelSize * 11.5F), 0.0F);
			this.blockModel.lid_top_left.render(pixelSize);
			GlStateManager.popMatrix();
		GlStateManager.popMatrix();
		//Lid Right
		GlStateManager.pushMatrix();
		GlStateManager.translatef((pixelSize * -6.0F), (pixelSize * 13.5F), 0.0F);
		GlStateManager.rotatef(-10.0F * tileEntityIn.getProgress(partialTicks), 0.0F, 0.0F, 1.0F);
		GlStateManager.translatef(-(pixelSize * -6.0F), -(pixelSize * 13.5F), 0.0F);
		this.blockModel.lid_right.render(pixelSize);
			GlStateManager.pushMatrix();
			GlStateManager.translatef((pixelSize * -6.0F), (pixelSize * 11.5F), 0.0F);
			GlStateManager.rotatef(65.0F * tileEntityIn.getProgress(partialTicks), 0.0F, 0.0F, 1.0F);
			GlStateManager.translatef(-(pixelSize * -6.0F), -(pixelSize * 11.5F), 0.0F);
			this.blockModel.lid_top_right.render(pixelSize);
			GlStateManager.popMatrix();
		GlStateManager.popMatrix();
		
		//Top Cubes
		GlStateManager.pushMatrix();
		GlStateManager.translatef(0.0F, -tileEntityIn.getProgress(partialTicks) * (pixelSize * 1.5F), 0.0F);
			//Top Front Left
			GlStateManager.pushMatrix();
			GlStateManager.translatef(tileEntityIn.getProgress(partialTicks) * (pixelSize * 1.5F), 0.0F, -tileEntityIn.getProgress(partialTicks) * (pixelSize * 1.5F));
			this.blockModel.top_front_left_1.render(pixelSize);
			GlStateManager.popMatrix();
			//Top Front Right
			GlStateManager.pushMatrix();
			GlStateManager.translatef(-tileEntityIn.getProgress(partialTicks) * (pixelSize * 1.5F), 0.0F, -tileEntityIn.getProgress(partialTicks) * (pixelSize * 1.5F));
			this.blockModel.top_front_left.render(pixelSize);
			GlStateManager.popMatrix();
			//Top Back Left
			GlStateManager.pushMatrix();
			GlStateManager.translatef(tileEntityIn.getProgress(partialTicks) * (pixelSize * 1.5F), 0.0F, tileEntityIn.getProgress(partialTicks) * (pixelSize * 1.5F));
			this.blockModel.top_back_left.render(pixelSize);
			GlStateManager.popMatrix();
			//Top Back Right
			GlStateManager.pushMatrix();
			GlStateManager.translatef(-tileEntityIn.getProgress(partialTicks) * (pixelSize * 1.5F), 0.0F, tileEntityIn.getProgress(partialTicks) * (pixelSize * 1.5F));
			this.blockModel.top_back_right.render(pixelSize);
			GlStateManager.popMatrix();
		GlStateManager.popMatrix();
		
		GlStateManager.popMatrix();
		
		GlStateManager.enableCull();
		GlStateManager.disableRescaleNormal();
		GlStateManager.popMatrix();
		GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		if(destroyStage >= 0)
		{
			GlStateManager.matrixMode(5890);
			GlStateManager.popMatrix();
			GlStateManager.matrixMode(5888);
		}
	}
}
