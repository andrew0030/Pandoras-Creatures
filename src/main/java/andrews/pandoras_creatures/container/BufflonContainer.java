package andrews.pandoras_creatures.container;

import andrews.pandoras_creatures.entities.BufflonEntity;
import andrews.pandoras_creatures.registry.util.ModContainerTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.network.PacketBuffer;

public class BufflonContainer extends Container
{	
    // Inventory of Bufflon Entity
	private final Inventory bufflonStorge;
    //Instance of Bufflon Entity
    private final BufflonEntity bufflonEntity;
	
	public BufflonContainer(final int windowId, final PlayerInventory playerInventory, PacketBuffer data)
	{
//		super(ModContainerTypes.BUFFLON, windowId);
		this(windowId, playerInventory, data.readInt());
	}
	
	public BufflonContainer(int windowId, PlayerInventory playerInventory, int entityId)
	{
		super(ModContainerTypes.BUFFLON, windowId);
		
        this.bufflonEntity = (BufflonEntity) playerInventory.player.world.getEntityByID(entityId);
        this.bufflonStorge = bufflonEntity.bufflonStorage;

        bufflonStorge.openInventory(playerInventory.player);

//	        this.addSlot(new Slot(chest, 0, 8, 18)
//			{
//		    	public boolean isItemValid(ItemStack itemStack)
//				{
//		   			return saddleItems.contains(itemStack.getItem());
//		   		}
//			}
//	 	}
	}
	
	@Override
	public boolean canInteractWith(PlayerEntity playerIn)
	{
		return true;
	}
	
	/**
	 * Called when the container is closed.
	 */
	public void onContainerClosed(PlayerEntity playerIn)
	{
		super.onContainerClosed(playerIn);
		this.bufflonStorge.closeInventory(playerIn);
	}
}
