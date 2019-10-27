package andrews.pandoras_creatures.item_groups;

import andrews.pandoras_creatures.registry.PCItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class PCItemGroup extends ItemGroup
{

	public PCItemGroup()
	{
		super("pandoras_creatures");
	}

	@Override
	public ItemStack createIcon()
	{
		return new ItemStack(PCItems.SEAHORSE);
	}
}
