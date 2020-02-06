package andrews.pandoras_creatures.registry;

import java.util.List;

import com.google.common.collect.Lists;

import andrews.pandoras_creatures.Main;
import andrews.pandoras_creatures.objects.items.ItemArachnonHammer;
import andrews.pandoras_creatures.objects.items.ItemCrabBucket;
import andrews.pandoras_creatures.objects.items.ItemPlantHat;
import andrews.pandoras_creatures.objects.items.ItemSeahorseBucket;
import andrews.pandoras_creatures.objects.util.PCArmorMaterials;
import andrews.pandoras_creatures.registry.util.RegistryUtils;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PCItems
{
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Reference.MODID);
	public static final List<RegistryObject<Item>> SPAWN_EGGS = Lists.newArrayList();
	/*
	 * Items
	 */
	public static final RegistryObject<Item> ARACHNON_HAMMER			= RegistryUtils.createItem("arachnon_hammer", () -> new ItemArachnonHammer());
	public static final RegistryObject<Item> CRAB_MEAT					= RegistryUtils.createItem("crab_meat", () -> new Item(new Item.Properties().group(Main.PANDORAS_CREATURES_GROUP).food(PCFoods.CRAB_MEAT(false))));
	public static final RegistryObject<Item> CRAB_MEAT_COOKED			= RegistryUtils.createItem("crab_meat_cooked", () -> new Item(new Item.Properties().group(Main.PANDORAS_CREATURES_GROUP).food(PCFoods.CRAB_MEAT(true))));
	public static final RegistryObject<Item> CRAB_BUCKET                = RegistryUtils.createItem("crab_bucket", () -> new ItemCrabBucket(() -> PCEntities.CRAB.get(), () -> Fluids.WATER));
	public static final RegistryObject<Item> SEAHORSE_BUCKET            = RegistryUtils.createItem("seahorse_bucket", () -> new ItemSeahorseBucket(() -> PCEntities.SEAHORSE.get(), () -> Fluids.WATER));
	public static final RegistryObject<Item> SEAHORSE               	= RegistryUtils.createItem("seahorse", () -> new Item(new Item.Properties().group(Main.PANDORAS_CREATURES_GROUP).food(PCFoods.SEAHORSE(false))));
	public static final RegistryObject<Item> SEAHORSE_COOKED            = RegistryUtils.createItem("seahorse_cooked", () -> new Item(new Item.Properties().group(Main.PANDORAS_CREATURES_GROUP).food(PCFoods.SEAHORSE(true))));
	public static final RegistryObject<Item> ACIDIC_ARCHVINE_TONGUE     = RegistryUtils.createItem("acidic_archvine_tongue", () -> new Item(new Item.Properties().group(Main.PANDORAS_CREATURES_GROUP)));
	public static final RegistryObject<Item> HERB_BUNDLE                = RegistryUtils.createItem("herb_bundle", () -> new Item(new Item.Properties().group(Main.PANDORAS_CREATURES_GROUP)));
	public static final RegistryObject<Item> BUFFLON_BEEF               = RegistryUtils.createItem("bufflon_beef", () -> new Item(new Item.Properties().group(Main.PANDORAS_CREATURES_GROUP).food(PCFoods.BUFFLON_BEEF(false))));
	public static final RegistryObject<Item> BUFFLON_BEEF_COOKED        = RegistryUtils.createItem("bufflon_beef_cooked", () -> new Item(new Item.Properties().group(Main.PANDORAS_CREATURES_GROUP).food(PCFoods.BUFFLON_BEEF(true))));
	public static final RegistryObject<Item> BUFFLON_HIDE               = RegistryUtils.createItem("bufflon_hide", () -> new Item(new Item.Properties().group(Main.PANDORAS_CREATURES_GROUP)));
	public static final RegistryObject<Item> BUFFLON_SADDLE             = RegistryUtils.createItem("bufflon_saddle", () -> new Item(new Item.Properties().group(Main.PANDORAS_CREATURES_GROUP).maxStackSize(1)));
	public static final RegistryObject<Item> BUFFLON_PLAYER_SEATS       = RegistryUtils.createItem("bufflon_player_seats", () -> new Item(new Item.Properties().group(Main.PANDORAS_CREATURES_GROUP).maxStackSize(1)));
	public static final RegistryObject<Item> BUFFLON_SMALL_STORAGE      = RegistryUtils.createItem("bufflon_small_storage", () -> new Item(new Item.Properties().group(Main.PANDORAS_CREATURES_GROUP).maxStackSize(1)));
	public static final RegistryObject<Item> BUFFLON_LARGE_STORAGE      = RegistryUtils.createItem("bufflon_large_storage", () -> new Item(new Item.Properties().group(Main.PANDORAS_CREATURES_GROUP).maxStackSize(1)));
	public static final RegistryObject<Item> PLANT_HAT                	= RegistryUtils.createItem("plant_hat", () -> new ItemPlantHat(PCArmorMaterials.PLANT_HAT, EquipmentSlotType.HEAD));
	
	/*
	 * Spawn Eggs
	 */
	public static final RegistryObject<Item> ARACHNON_SPAWN_EGG			= RegistryUtils.createSpawnEggItem("arachnon", () -> PCEntities.ARACHNON.get(), 5394534, 12257023);
	public static final RegistryObject<Item> HELLHOUND_SPAWN_EGG		= RegistryUtils.createSpawnEggItem("hellhound", () -> PCEntities.HELLHOUND.get(), 0xf5f3f0, 0xfc750d);
	public static final RegistryObject<Item> CRAB_SPAWN_EGG				= RegistryUtils.createSpawnEggItem("crab", () -> PCEntities.CRAB.get(), 0xf79811, 0xffde3b);
	public static final RegistryObject<Item> SEAHORSE_SPAWN_EGG			= RegistryUtils.createSpawnEggItem("seahorse", () -> PCEntities.SEAHORSE.get(), 0x38d1d1, 0xd98f27);
	public static final RegistryObject<Item> ACIDIC_ARCHVINE_SPAWN_EGG	= RegistryUtils.createSpawnEggWithToolTipItem("acidic_archvine", () -> PCEntities.ACIDIC_ARCHVINE.get(), 0x14661f, 0x7b34ad, "item.pandoras_creatures.acidic_archvine_spawn_egg.tooltip");
	public static final RegistryObject<Item> BUFFLON_SPAWN_EGG			= RegistryUtils.createSpawnEggItem("bufflon", () -> PCEntities.BUFFLON.get(), 0x4f3914, 0x1a1d29);
	public static final RegistryObject<Item> END_TROLL_SPAWN_EGG		= RegistryUtils.createSpawnEggItem("end_troll", () -> PCEntities.END_TROLL.get(), 0x2a234d, 0x4db4bf);
}