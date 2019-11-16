package andrews.pandoras_creatures.container.slot;

import andrews.pandoras_creatures.entities.BufflonEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class BufflonSaddleSlot extends Slot
{
	public BufflonSaddleSlot(IInventory inventoryIn, int index, int xPosition, int yPosition)
	{
		super(inventoryIn, index, xPosition, yPosition);
	}
	
	//This sets the item limit to 1 as you can not have multiple Saddles in a Saddle Slot
	@Override
	public int getSlotStackLimit()
	{
		return 1;
	}
	
	//Makes it so you can only put a Bufflon Saddle into the slot
	@Override
	public boolean isItemValid(ItemStack stack)
	{
		return stack.getItem().equals(BufflonEntity.SADDLE_ITEM);
	}
}
