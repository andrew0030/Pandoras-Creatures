package andrews.pandoras_creatures.tile_entities.item;

import java.util.Arrays;
import java.util.Comparator;

import andrews.pandoras_creatures.objects.blocks.BlockEndTrollBox;
import andrews.pandoras_creatures.tile_entities.EndTrollBoxTileEntity;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PCTileEntityItemRenderer extends ItemStackTileEntityRenderer
{	
	private static final EndTrollBoxTileEntity END_TROLL_BOX = new EndTrollBoxTileEntity((DyeColor)null);
	private static final EndTrollBoxTileEntity[] END_TROLL_BOXES = Arrays.stream(DyeColor.values())
		.sorted(Comparator.comparingInt(DyeColor::getId))
		.map(EndTrollBoxTileEntity::new).toArray((colorId) ->
		{
			return new EndTrollBoxTileEntity[colorId];
		});
	
	@Override
	public void renderByItem(ItemStack itemStackIn)
	{
		Item item = itemStackIn.getItem();
		
		if(Block.getBlockFromItem(item) instanceof BlockEndTrollBox)
		{
			DyeColor dyecolor = BlockEndTrollBox.getColorFromItem(item);
			if(dyecolor == null)
			{
				TileEntityRendererDispatcher.instance.renderAsItem(END_TROLL_BOX);
			}
			else
			{
				TileEntityRendererDispatcher.instance.renderAsItem(END_TROLL_BOXES[dyecolor.getId()]);
			}
        }
//		else if(Block.getBlockFromItem(item) instanceof OTHERBLOCK)
//		{
//        	TileEntityRendererDispatcher.instance.renderAsItem(OTHERTILEENTITY);
//      }
	}
}
