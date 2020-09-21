package andrews.pandoras_creatures.registry;

import andrews.pandoras_creatures.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;

public class PCTags
{
	public static class Items
	{
		public static final ITag.INamedTag<Item> VANILLA_SHULKER_BOXES = createTag("vanilla_shulker_boxes");
		public static final ITag.INamedTag<Item> END_TROLL_BOXES = createTag("end_troll_boxes");
		
		private static ITag.INamedTag<Item> createTag(String name)
		{
			return ItemTags.makeWrapperTag(Reference.MODID + ":" + name);
		}
	}
	
	public static class Blocks
	{	
		@SuppressWarnings("unused")
		private static ITag.INamedTag<Block> createTag(String name)
		{
			return BlockTags.makeWrapperTag(Reference.MODID + ":" + name);
		}
	}
}