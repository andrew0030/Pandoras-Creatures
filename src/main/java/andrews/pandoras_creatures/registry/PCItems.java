package andrews.pandoras_creatures.registry;

import andrews.pandoras_creatures.Main;
import andrews.pandoras_creatures.objects.items.ItemArachnonHammer;
import andrews.pandoras_creatures.objects.items.ItemCrabBucket;
import andrews.pandoras_creatures.objects.items.ItemSeahorseBucket;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PCItems
{
	public static Item ARACHNON_CRYSTAL                       = new Item(new Item.Properties().group(Main.PANDORAS_CREATURES_GROUP)).setRegistryName(Reference.MODID, "arachnon_crystal");
	public static Item ARACHNON_HAMMER                        = new ItemArachnonHammer().setRegistryName(Reference.MODID, "arachnon_hammer");
	public static Item CRAB_MEAT               	   			  = new Item(new Item.Properties().group(Main.PANDORAS_CREATURES_GROUP).food(PCFoods.CRAB_MEAT(false))).setRegistryName(Reference.MODID, "crab_meat");
	public static Item CRAB_MEAT_COOKED             		  = new Item(new Item.Properties().group(Main.PANDORAS_CREATURES_GROUP).food(PCFoods.CRAB_MEAT(true))).setRegistryName(Reference.MODID, "crab_meat_cooked");
	public static Item CRAB_BUCKET                			  = new ItemCrabBucket(PCEntities.CRAB, Fluids.WATER).setRegistryName(Reference.MODID, "crab_bucket");
	public static Item SEAHORSE_BUCKET                		  = new ItemSeahorseBucket(PCEntities.SEAHORSE, Fluids.WATER).setRegistryName(Reference.MODID, "seahorse_bucket");
	public static Item SEAHORSE               	   			  = new Item(new Item.Properties().group(Main.PANDORAS_CREATURES_GROUP).food(PCFoods.SEAHORSE(false))).setRegistryName(Reference.MODID, "seahorse");
	public static Item SEAHORSE_COOKED             		 	  = new Item(new Item.Properties().group(Main.PANDORAS_CREATURES_GROUP).food(PCFoods.CRAB_MEAT(true))).setRegistryName(Reference.MODID, "seahorse_cooked");
	
	@SubscribeEvent
	public static void onRegisterItems(RegistryEvent.Register<Item> event)
	{
		final Item[] items =
		{
			ARACHNON_CRYSTAL,
			ARACHNON_HAMMER,
			CRAB_MEAT,
			CRAB_MEAT_COOKED,
			CRAB_BUCKET,
			SEAHORSE_BUCKET,
			SEAHORSE,
			SEAHORSE_COOKED
		};
		event.getRegistry().registerAll(items);
	}
}