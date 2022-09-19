package andrews.pandoras_creatures.container;

import andrews.pandoras_creatures.container.slot.EndTrollBoxSlot;
import andrews.pandoras_creatures.registry.PCContainers;
import net.minecraft.entity.player.Player;
import net.minecraft.entity.player.Inventory;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class EndTrollBoxContainer extends AbstractContainerMenu
{
	private final Container inventory;

	public EndTrollBoxContainer(final int windowId, final Inventory playerInventory, FriendlyByteBuf data)
	{
		this(windowId, playerInventory);
	}
	
	public EndTrollBoxContainer(int windowId, Inventory playerInv)
	{
		this(windowId, playerInv, new Inventory(54));
	}

	public EndTrollBoxContainer(int windowId, Inventory playerInv, Container inventory)
	{
		super(PCContainers.END_TROLL_BOX.get(), windowId);
		checkContainerSize(inventory, 54);
		this.inventory = inventory;
		inventory.startOpen(playerInv.player);

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
	public boolean stillValid(Player playerIn)
	{
		return this.inventory.stillValid(playerIn);
	}

	@Override
	public ItemStack quickMoveStack(Player playerIn, int index)
	{
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.slots.get(index);
		if(slot != null && slot.hasItem())
		{
			ItemStack stackInSlot = slot.getItem();
			itemstack = stackInSlot.copy();
			if(index < this.inventory.getContainerSize())
			{
				if(!this.moveItemStackTo(stackInSlot, this.inventory.getContainerSize(), this.slots.size(), true))
				{
					return ItemStack.EMPTY;
				}
			}
			else if(!this.moveItemStackTo(stackInSlot, 0, this.inventory.getContainerSize(), false))
			{
				return ItemStack.EMPTY;
			}

			if(stackInSlot.isEmpty())
			{
				slot.set(ItemStack.EMPTY);
			}
			else
			{
				slot.setChanged();
			}
		}
		
		return itemstack;
	}
	
	@Override
	public void removed(Player playerIn)
	{
		super.removed(playerIn);
		this.inventory.stopOpen(playerIn);
	}
}
