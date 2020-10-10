package andrews.pandoras_creatures.container.slot;

import andrews.pandoras_creatures.objects.blocks.EndTrollBoxBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class EndTrollBoxSlot extends Slot
{
	public EndTrollBoxSlot(IInventory inventory, int slotIndexIn, int xPosition, int yPosition)
	{
		super(inventory, slotIndexIn, xPosition, yPosition);
	}

	@Override
	public boolean isItemValid(ItemStack stack)
	{
		if(Block.getBlockFromItem(stack.getItem()) instanceof ShulkerBoxBlock)
		{
			return false;
		}
		else if(Block.getBlockFromItem(stack.getItem()) instanceof EndTrollBoxBlock)
		{
			return false;
		}
		return true;
	}
}