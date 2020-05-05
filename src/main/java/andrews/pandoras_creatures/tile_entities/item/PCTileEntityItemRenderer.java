package andrews.pandoras_creatures.tile_entities.item;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Supplier;

import com.mojang.blaze3d.matrix.MatrixStack;

import andrews.pandoras_creatures.objects.blocks.BlockEndTrollBox;
import andrews.pandoras_creatures.tile_entities.EndTrollBoxTileEntity;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class PCTileEntityItemRenderer<T extends TileEntity> extends ItemStackTileEntityRenderer
{	
	private final Supplier<T> te;
	private EndTrollBoxTileEntity END_TROLL_BOX;
	private EndTrollBoxTileEntity[] END_TROLL_BOXES;
	boolean hasLoadedEndTrollBoxes = false;
	
	public PCTileEntityItemRenderer(Supplier<T> te)
	{
		this.te = te;
	}
	
	@Override
	public void render(ItemStack itemStackIn, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn)
	{
		Item item = itemStackIn.getItem();
		
		//Used to create the End Troll Box Tile Entity after it has been registered
		if(hasLoadedEndTrollBoxes == false) //Makes sure it only get loaded once
		{
			this.END_TROLL_BOX = new EndTrollBoxTileEntity((DyeColor)null);
			this.END_TROLL_BOXES = Arrays.stream(DyeColor.values())
				.sorted(Comparator.comparingInt(DyeColor::getId))
				.map(EndTrollBoxTileEntity::new).toArray((colorId) ->
				{
					return new EndTrollBoxTileEntity[colorId];
				});
			hasLoadedEndTrollBoxes = true;
		}
		
		if(Block.getBlockFromItem(item) instanceof BlockEndTrollBox)
		{
			TileEntity tileentity;
			DyeColor dyecolor = BlockEndTrollBox.getColorFromItem(item);
			if(dyecolor == null)
			{
				tileentity = this.END_TROLL_BOX;
			}
			else
			{
				tileentity = END_TROLL_BOXES[dyecolor.getId()];
			}
			
			TileEntityRendererDispatcher.instance.renderItem(tileentity, matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
        }
		else
		{
			TileEntityRendererDispatcher.instance.renderItem(this.te.get(), matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
		}
	}
}
