package andrews.pandoras_creatures.container.slot;

import andrews.pandoras_creatures.entities.BufflonEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;

public class BufflonStorageSlot extends Slot
{
	private BufflonEntity bufflonEntity;
	private int index;

	public BufflonStorageSlot(BufflonEntity bufflonEntity, IInventory inventoryIn, int index, int xPosition, int yPosition)
	{
		super(inventoryIn, index, xPosition, yPosition);
		this.bufflonEntity = bufflonEntity;
		this.index = index;
	}
	
	@Override
	public boolean isEnabled()
	{
		if(bufflonEntity.hasBackAttachment())
		{
			//If the Bufflon Entity has a Small Storage
			if(bufflonEntity.getBackAttachmentType() == 2)
			{
				if(index < 29)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			//If the Bufflon Entity has a Large Storage
			if(bufflonEntity.getBackAttachmentType() == 3)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
}
