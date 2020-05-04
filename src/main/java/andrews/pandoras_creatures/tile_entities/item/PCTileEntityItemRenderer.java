package andrews.pandoras_creatures.tile_entities.item;

import java.util.Arrays;
import java.util.Comparator;

import com.mojang.blaze3d.matrix.MatrixStack;

import andrews.pandoras_creatures.objects.blocks.BlockEndTrollBox;
import andrews.pandoras_creatures.registry.PCTileEntities;
import andrews.pandoras_creatures.tile_entities.EndTrollBoxTileEntity;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class PCTileEntityItemRenderer extends ItemStackTileEntityRenderer
{	
//	private static final EndTrollBoxTileEntity END_TROLL_BOX = new EndTrollBoxTileEntity((DyeColor)null);
//	private static final EndTrollBoxTileEntity[] END_TROLL_BOXES = Arrays.stream(DyeColor.values())
//		.sorted(Comparator.comparingInt(DyeColor::getId))
//		.map(EndTrollBoxTileEntity::new).toArray((colorId) ->
//		{
//			return new EndTrollBoxTileEntity[colorId];
//		});
	
	@Override
	public void render(ItemStack itemStackIn, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn)
	{
		Item item = itemStackIn.getItem();
		
		if(Block.getBlockFromItem(item) instanceof BlockEndTrollBox)
		{
			TileEntity tileentity = null; //TODO Null was not here
			DyeColor dyecolor = BlockEndTrollBox.getColorFromItem(item);
			if(dyecolor == null)
			{
				//Makes Sure the Box TileEntity has been registered
				if(PCTileEntities.END_TROLL_BOX.get() != null)
				{
					tileentity = new EndTrollBoxTileEntity((DyeColor)null); //TODO somehow get this out of here cause it gets called WAY TO MUCH
				}
			}
			else
			{
				//Makes Sure the Box TileEntity has been registered
				if(PCTileEntities.END_TROLL_BOX.get() != null)
				{
					EndTrollBoxTileEntity[] END_TROLL_BOXES = Arrays.stream(DyeColor.values()) //TODO somehow get this out of here cause it gets called WAY TO MUCH
						.sorted(Comparator.comparingInt(DyeColor::getId))					   //TODO ALSO LOOK AT IT WTF
						.map(EndTrollBoxTileEntity::new).toArray((colorId) ->
						{
							return new EndTrollBoxTileEntity[colorId];
						});
					tileentity = END_TROLL_BOXES[dyecolor.getId()];
				}
			}
			if(tileentity != null)
			{
				TileEntityRendererDispatcher.instance.renderItem(tileentity, matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
			}
        }
//		else if(Block.getBlockFromItem(item) instanceof OTHERBLOCK)
//		{
//        	TileEntityRendererDispatcher.instance.renderAsItem(OTHERTILEENTITY);
//		}
	}
}
