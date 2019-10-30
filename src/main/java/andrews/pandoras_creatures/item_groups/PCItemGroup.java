package andrews.pandoras_creatures.item_groups;

import andrews.pandoras_creatures.registry.PCItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class PCItemGroup extends ItemGroup
{
	/**
	 * The Pandoras Creatures Creative Tab
	 */
	public PCItemGroup()
	{
		super("pandoras_creatures");
	}

	/**
	 * Used to get the ItemStack that will be rendered as tab icon
	 */
	@Override
	public ItemStack createIcon()
	{
		return new ItemStack(PCItems.SEAHORSE);
	}
}
