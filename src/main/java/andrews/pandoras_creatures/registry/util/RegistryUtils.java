package andrews.pandoras_creatures.registry.util;

import java.util.function.Supplier;

import javax.annotation.Nullable;

import andrews.pandoras_creatures.Main;
import andrews.pandoras_creatures.objects.items.PCSpawnEggItem;
import andrews.pandoras_creatures.objects.items.PCSpawnEggWithTooltipItem;
import andrews.pandoras_creatures.registry.PCBlocks;
import andrews.pandoras_creatures.registry.PCItems;
import andrews.pandoras_creatures.tile_entities.item.PCTileEntityItemRenderer;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

public class RegistryUtils
{	
	/**
	 * Creates Simple Item
	 */
	public static <I extends Item> RegistryObject<I> createItem(String name, Supplier<? extends I> supplier)
	{
		RegistryObject<I> item = PCItems.ITEMS.register(name, supplier);
		return item;
	}
	
	/**
	 * Creates Spawn Egg Item
	 */
	public static RegistryObject<Item> createSpawnEggItem(String entityName, Supplier<EntityType<?>> supplier, int primaryColor, int secondaryColor)
	{
		RegistryObject<Item> spawnEgg = PCItems.ITEMS.register(entityName + "_spawn_egg", () -> new PCSpawnEggItem(supplier, primaryColor, secondaryColor, new Item.Properties().group(Main.PANDORAS_CREATURES_GROUP)));
		PCItems.SPAWN_EGGS.add(spawnEgg);
		return spawnEgg;
	}
	
	/**
	 * Creates Spawn Egg Item With Tool Tip
	 */
	public static RegistryObject<Item> createSpawnEggWithToolTipItem(String entityName, Supplier<EntityType<?>> supplier, int primaryColor, int secondaryColor, String langPath)
	{
		RegistryObject<Item> spawnEgg = PCItems.ITEMS.register(entityName + "_spawn_egg", () -> new PCSpawnEggWithTooltipItem(supplier, primaryColor, secondaryColor, langPath, new Item.Properties().group(Main.PANDORAS_CREATURES_GROUP)));
		PCItems.SPAWN_EGGS.add(spawnEgg);
		return spawnEgg;
	}
	
	/**
	 * Creates a Block Without Item
	 */
	public static <B extends Block> RegistryObject<B> createBlockNoItem(String name, Supplier<? extends B> supplier)
	{
		RegistryObject<B> block = PCBlocks.BLOCKS.register(name, supplier);
		return block;
	}
	
	/**
	 * Creates a Block
	 */
	public static <B extends Block> RegistryObject<B> createBlock(String name, Supplier<? extends B> supplier, @Nullable ItemGroup group)
	{
		RegistryObject<B> block = PCBlocks.BLOCKS.register(name, supplier);
		PCItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().group(group)));
		return block;
	}
	
	/**
	 * Creates a Block that has a TESR
	 */
	public static <B extends Block> RegistryObject<B> createBlockWithTESIR(String name, Supplier<? extends B> supplier, boolean isItemStackable, @Nullable ItemGroup group)
	{
		RegistryObject<B> block = PCBlocks.BLOCKS.register(name, supplier);
		if(isItemStackable)
		{
			PCItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().group(group).setISTER(() -> PCTileEntityItemRenderer::new)));
		}
		else
		{
			PCItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().group(group).maxStackSize(1).setISTER(() -> PCTileEntityItemRenderer::new)));
		}
		return block;
	}
}