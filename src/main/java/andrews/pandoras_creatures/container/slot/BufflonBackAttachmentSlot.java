package andrews.pandoras_creatures.container.slot;

import java.util.Arrays;

import andrews.pandoras_creatures.entities.BufflonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class BufflonBackAttachmentSlot extends Slot
{
	private BufflonEntity bufflonEntity;
	private IInventory bufflonInventory;
	
	public BufflonBackAttachmentSlot(BufflonEntity bufflonEntity, IInventory inventoryIn, int index, int xPosition, int yPosition)
	{
		super(inventoryIn, index, xPosition, yPosition);
		this.bufflonEntity = bufflonEntity;
		this.bufflonInventory = inventoryIn;
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
		return Arrays.asList(BufflonEntity.VALID_BACK_ATTACHMENTS).contains(stack.getItem());
	}
	
	/**
	 * Return whether this slot's stack can be taken from this slot.
	 */
	@Override
	public boolean canTakeStack(PlayerEntity playerIn)
	{
		if(bufflonEntity.isBeingRidden())
		{
			if(bufflonEntity.getPassengers().size() > 1)
			{
				return false;
			}
		}
		return hasItemsInInventory();
	}

	private boolean hasItemsInInventory()
	{
		int slotsWithItems = 0;
		
		for(int i = 2; i < bufflonInventory.getSizeInventory(); i++)
		{
			if(!bufflonInventory.getStackInSlot(i).isEmpty())
			{
				slotsWithItems++;
			}
		}
		
		if(slotsWithItems != 0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}
