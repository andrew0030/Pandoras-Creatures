package andrews.pandoras_creatures.registry;

import andrews.pandoras_creatures.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;

public class PCTags
{
	public static class Items
	{
		public static final Tag<Item> VANILLA_SHULKER_BOXES = createTag("vanilla_shulker_boxes");
		public static final Tag<Item> END_TROLL_BOXES = createTag("end_troll_boxes");
		
		private static Tag<Item> createTag(String name)
		{
			return new ItemTags.Wrapper(new ResourceLocation(Reference.MODID, name));
		}
	}
	
	public static class Blocks
	{
		@SuppressWarnings("unused")
		private static Tag<Block> createTag(String name)
		{
			return new BlockTags.Wrapper(new ResourceLocation(Reference.MODID, name));
		}
	}
}