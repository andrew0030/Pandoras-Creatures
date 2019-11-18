package andrews.pandoras_creatures.container.slot;

import andrews.pandoras_creatures.entities.BufflonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class BufflonSaddleSlot extends Slot
{
	private BufflonEntity bufflonEntity;
	
	public BufflonSaddleSlot(BufflonEntity bufflonEntity, IInventory inventoryIn, int index, int xPosition, int yPosition)
	{
		super(inventoryIn, index, xPosition, yPosition);
		this.bufflonEntity = bufflonEntity;
	}
	
	//This sets the item limit to 1 as you can not have multiple Saddles in a Saddle Slot
	@Override
	public int getSlotStackLimit()
	{
		return 1;
	}
	
	/**
	 * Return whether this slot's stack can be taken from this slot.
	 */
	@Override
	public boolean canTakeStack(PlayerEntity playerIn)
	{
		return !bufflonEntity.isBeingRidden();
	}
	
	//Makes it so you can only put a Bufflon Saddle into the slot
	@Override
	public boolean isItemValid(ItemStack stack)
	{
		return stack.getItem().equals(BufflonEntity.SADDLE_ITEM);
	}
}
