package andrews.pandoras_creatures.container;

import andrews.pandoras_creatures.container.slot.EndTrollBoxSlot;
import andrews.pandoras_creatures.registry.PCContainers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;

public class EndTrollBoxContainer extends Container
{
	private final IInventory inventory;

	public EndTrollBoxContainer(final int windowId, final PlayerInventory playerInventory, PacketBuffer data)
	{
		this(windowId, playerInventory);
	}
	
	public EndTrollBoxContainer(int windowId, PlayerInventory playerInv)
	{
		this(windowId, playerInv, new Inventory(54));
	}

	public EndTrollBoxContainer(int windowId, PlayerInventory playerInv, IInventory inventory)
	{
		super(PCContainers.END_TROLL_BOX.get(), windowId);
		assertInventorySize(inventory, 54);
		this.inventory = inventory;
		inventory.openInventory(playerInv.player);

		//End Troll Box Slots
		for(int y = 0; y < 6; ++y)
		{
			for(int x = 0; x < 9; ++x)
			{
				this.addSlot(new EndTrollBoxSlot(inventory, x + y * 9, 8 + x * 18, 18 + y * 18));
			}
		}
		//Player Inventory Slots
		for(int y = 0; y < 3; ++y)
		{
			for(int x = 0; x < 9; ++x)
			{
				this.addSlot(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 138 + y * 18));
			}
		}
		//Player Hot Bar Slots
		for (int x = 0; x < 9; ++x)
		{
			this.addSlot(new Slot(playerInv, x, 8 + x * 18, 196));
		}
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn)
	{
		return this.inventory.isUsableByPlayer(playerIn);
	}

	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index)
	{
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		if(slot != null && slot.getHasStack())
		{
			ItemStack stackInSlot = slot.getStack();
			itemstack = stackInSlot.copy();
			if(index < this.inventory.getSizeInventory())
			{
				if(!this.mergeItemStack(stackInSlot, this.inventory.getSizeInventory(), this.inventorySlots.size(), true))
				{
					return ItemStack.EMPTY;
				}
			}
			else if(!this.mergeItemStack(stackInSlot, 0, this.inventory.getSizeInventory(), false))
			{
				return ItemStack.EMPTY;
			}

			if(stackInSlot.isEmpty())
			{
				slot.putStack(ItemStack.EMPTY);
			}
			else
			{
				slot.onSlotChanged();
			}
		}
		
		return itemstack;
	}
	
	@Override
	public void onContainerClosed(PlayerEntity playerIn)
	{
		super.onContainerClosed(playerIn);
		this.inventory.closeInventory(playerIn);
	}
}