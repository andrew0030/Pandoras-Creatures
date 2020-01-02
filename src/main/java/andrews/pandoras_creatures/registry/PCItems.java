package andrews.pandoras_creatures.registry;

import andrews.pandoras_creatures.Main;
import andrews.pandoras_creatures.objects.items.ItemArachnonHammer;
import andrews.pandoras_creatures.objects.items.ItemCrabBucket;
import andrews.pandoras_creatures.objects.items.ItemPlantHat;
import andrews.pandoras_creatures.objects.items.ItemSeahorseBucket;
import andrews.pandoras_creatures.objects.util.PCArmorMaterials;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PCItems
{
	public static Item ARACHNON_HAMMER                        = new ItemArachnonHammer().setRegistryName(Reference.MODID, "arachnon_hammer");
	public static Item CRAB_MEAT               	   			  = new Item(new Item.Properties().group(Main.PANDORAS_CREATURES_GROUP).food(PCFoods.CRAB_MEAT(false))).setRegistryName(Reference.MODID, "crab_meat");
	public static Item CRAB_MEAT_COOKED             		  = new Item(new Item.Properties().group(Main.PANDORAS_CREATURES_GROUP).food(PCFoods.CRAB_MEAT(true))).setRegistryName(Reference.MODID, "crab_meat_cooked");
	public static Item CRAB_BUCKET                			  = new ItemCrabBucket(PCEntities.CRAB, () -> Fluids.WATER).setRegistryName(Reference.MODID, "crab_bucket");
	public static Item SEAHORSE_BUCKET                		  = new ItemSeahorseBucket(PCEntities.SEAHORSE, () -> Fluids.WATER).setRegistryName(Reference.MODID, "seahorse_bucket");
	public static Item SEAHORSE               	   			  = new Item(new Item.Properties().group(Main.PANDORAS_CREATURES_GROUP).food(PCFoods.SEAHORSE(false))).setRegistryName(Reference.MODID, "seahorse");
	public static Item SEAHORSE_COOKED             		 	  = new Item(new Item.Properties().group(Main.PANDORAS_CREATURES_GROUP).food(PCFoods.CRAB_MEAT(true))).setRegistryName(Reference.MODID, "seahorse_cooked");
	public static Item ACIDIC_ARCHVINE_TONGUE                 = new Item(new Item.Properties().group(Main.PANDORAS_CREATURES_GROUP)).setRegistryName(Reference.MODID, "acidic_archvine_tongue");
	public static Item HERB_BUNDLE                 			  = new Item(new Item.Properties().group(Main.PANDORAS_CREATURES_GROUP)).setRegistryName(Reference.MODID, "herb_bundle");
	public static Item BUFFLON_BEEF                 		  = new Item(new Item.Properties().group(Main.PANDORAS_CREATURES_GROUP).food(PCFoods.BUFFLON_BEEF(false))).setRegistryName(Reference.MODID, "bufflon_beef");
	public static Item BUFFLON_BEEF_COOKED                 	  = new Item(new Item.Properties().group(Main.PANDORAS_CREATURES_GROUP).food(PCFoods.BUFFLON_BEEF(true))).setRegistryName(Reference.MODID, "bufflon_beef_cooked");
	public static Item BUFFLON_HIDE                			  = new Item(new Item.Properties().group(Main.PANDORAS_CREATURES_GROUP)).setRegistryName(Reference.MODID, "bufflon_hide");
	public static Item BUFFLON_SADDLE                 		  = new Item(new Item.Properties().group(Main.PANDORAS_CREATURES_GROUP).maxStackSize(1)).setRegistryName(Reference.MODID, "bufflon_saddle");
	public static Item BUFFLON_PLAYER_SEATS                   = new Item(new Item.Properties().group(Main.PANDORAS_CREATURES_GROUP).maxStackSize(1)).setRegistryName(Reference.MODID, "bufflon_player_seats");
	public static Item BUFFLON_SMALL_STORAGE                  = new Item(new Item.Properties().group(Main.PANDORAS_CREATURES_GROUP).maxStackSize(1)).setRegistryName(Reference.MODID, "bufflon_small_storage");
	public static Item BUFFLON_LARGE_STORAGE                  = new Item(new Item.Properties().group(Main.PANDORAS_CREATURES_GROUP).maxStackSize(1)).setRegistryName(Reference.MODID, "bufflon_large_storage");
	public static Item PLANT_HAT                			  = new ItemPlantHat(PCArmorMaterials.PLANT_HAT, EquipmentSlotType.HEAD).setRegistryName(Reference.MODID, "plant_hat");
	
	@SubscribeEvent
	public static void onRegisterItems(RegistryEvent.Register<Item> event)
	{
		final Item[] items =
		{
			ARACHNON_HAMMER,
			CRAB_MEAT,
			CRAB_MEAT_COOKED,
			CRAB_BUCKET,
			SEAHORSE_BUCKET,
			SEAHORSE,
			SEAHORSE_COOKED,
			ACIDIC_ARCHVINE_TONGUE,
			HERB_BUNDLE,
			BUFFLON_BEEF,
			BUFFLON_BEEF_COOKED,
			BUFFLON_HIDE,
			BUFFLON_SADDLE,
			BUFFLON_PLAYER_SEATS,
			BUFFLON_SMALL_STORAGE,
			BUFFLON_LARGE_STORAGE,
			PLANT_HAT
		};
		event.getRegistry().registerAll(items);
	}
}