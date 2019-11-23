package andrews.pandoras_creatures.util.loot_table;

import java.util.Set;

import com.google.common.collect.Sets;

import andrews.pandoras_creatures.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTables;
import net.minecraft.world.storage.loot.TableLootEntry;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class PCLootTableHandler
{
	private static final Set<ResourceLocation> JUNGLE_TEMPLE_INJECTIONS = Sets.newHashSet(LootTables.CHESTS_JUNGLE_TEMPLE);
	private static final Set<ResourceLocation> SIMPLE_DUNGEON_INJECTIONS = Sets.newHashSet(LootTables.CHESTS_SIMPLE_DUNGEON);
	private static final Set<ResourceLocation> DESERT_PYRAMID_INJECTIONS = Sets.newHashSet(LootTables.CHESTS_DESERT_PYRAMID);
	private static final Set<ResourceLocation> END_CITY_INJECTIONS = Sets.newHashSet(LootTables.CHESTS_END_CITY_TREASURE);
	private static final Set<ResourceLocation> NETHER_BRIDGE_INJECTIONS = Sets.newHashSet(LootTables.CHESTS_NETHER_BRIDGE);
	
	@SubscribeEvent
	public static void onInjectLoot(LootTableLoadEvent event)
	{
		if(JUNGLE_TEMPLE_INJECTIONS.contains(event.getName()))
		{
			LootPool pool = LootPool.builder().addEntry(TableLootEntry.builder(new ResourceLocation(Reference.MODID, "injections/bufflon_jungle_temple"))).name("bufflon_jungle_temple").build();
			event.getTable().addPool(pool);
		}
		if(SIMPLE_DUNGEON_INJECTIONS.contains(event.getName()))
		{
			LootPool pool = LootPool.builder().addEntry(TableLootEntry.builder(new ResourceLocation(Reference.MODID, "injections/bufflon_simple_dungeon"))).name("bufflon_simple_dungeon").build();
			event.getTable().addPool(pool);
		}
		if(DESERT_PYRAMID_INJECTIONS.contains(event.getName()))
		{
			LootPool pool = LootPool.builder().addEntry(TableLootEntry.builder(new ResourceLocation(Reference.MODID, "injections/bufflon_desert_pyramid"))).name("bufflon_desert_pyramid").build();
			event.getTable().addPool(pool);
		}
		if(END_CITY_INJECTIONS.contains(event.getName()))
		{
			LootPool pool = LootPool.builder().addEntry(TableLootEntry.builder(new ResourceLocation(Reference.MODID, "injections/bufflon_end_city"))).name("bufflon_end_city").build();
			event.getTable().addPool(pool);
		}
		if(NETHER_BRIDGE_INJECTIONS.contains(event.getName()))
		{
			LootPool pool = LootPool.builder().addEntry(TableLootEntry.builder(new ResourceLocation(Reference.MODID, "injections/bufflon_nether_bridge"))).name("bufflon_nether_bridge").build();
			event.getTable().addPool(pool);
		}
	}
}