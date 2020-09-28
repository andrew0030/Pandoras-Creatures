package andrews.pandoras_creatures.registry.util;

import andrews.pandoras_creatures.registry.PCEntities;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.entity.EntityClassification;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.common.world.MobSpawnInfoBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@SuppressWarnings("unchecked")
@Mod.EventBusSubscriber(modid = Reference.MODID)
public class PCEntitySpawning
{	
	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void spawnEntities(BiomeLoadingEvent event)
	{
		//Arachnom
		if(doesNameMatchBiomes(event.getName(), Biomes.PLAINS, Biomes.MOUNTAINS, Biomes.GRAVELLY_MOUNTAINS))
		{	
			MobSpawnInfoBuilder spawnSettings = event.getSpawns();
			spawnSettings.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(PCEntities.ARACHNON.get(), 20, 1, 1));
		}
		
		//Hellhound
		if(doesNameMatchBiomes(event.getName(), Biomes.NETHER_WASTES, Biomes.SOUL_SAND_VALLEY))
		{	
			MobSpawnInfoBuilder spawnSettings = event.getSpawns();
			spawnSettings.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(PCEntities.HELLHOUND.get(), 30, 3, 6));
		}
		
		//Crab
		if(doesNameMatchBiomes(event.getName(), Biomes.BEACH, Biomes.WARM_OCEAN))
		{	
			MobSpawnInfoBuilder spawnSettings = event.getSpawns();
			spawnSettings.withSpawner(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(PCEntities.CRAB.get(), 500, 2, 5));//TODO make sure 500 isnt overkill
		}
		
		//Seahorse
		if(doesNameMatchBiomes(event.getName(), Biomes.WARM_OCEAN, Biomes.DEEP_WARM_OCEAN))
		{	
			MobSpawnInfoBuilder spawnSettings = event.getSpawns();
			spawnSettings.withSpawner(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(PCEntities.SEAHORSE.get(), 25, 3, 6));
		}
		if(doesNameMatchBiomes(event.getName(), Biomes.OCEAN, Biomes.LUKEWARM_OCEAN, Biomes.DEEP_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN))
		{	
			MobSpawnInfoBuilder spawnSettings = event.getSpawns();
			spawnSettings.withSpawner(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(PCEntities.SEAHORSE.get(), 10, 2, 3));
		}
		
		//Acidic Archvine
		if(doesNameMatchBiome(event.getName(), Biomes.NETHER_WASTES))
		{	
			MobSpawnInfoBuilder spawnSettings = event.getSpawns();
			spawnSettings.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(PCEntities.ACIDIC_ARCHVINE.get(), 30, 1, 1));
		}
		if(doesNameMatchBiome(event.getName(), Biomes.CRIMSON_FOREST))
		{	
			MobSpawnInfoBuilder spawnSettings = event.getSpawns();
			spawnSettings.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(PCEntities.ACIDIC_ARCHVINE.get(), 15, 1, 1));
		}
		if(doesNameMatchBiomes(event.getName(), Biomes.JUNGLE, Biomes.JUNGLE_EDGE, Biomes.JUNGLE_HILLS, Biomes.MODIFIED_JUNGLE, Biomes.MODIFIED_JUNGLE_EDGE))
		{
			MobSpawnInfoBuilder spawnSettings = event.getSpawns();
			spawnSettings.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(PCEntities.ACIDIC_ARCHVINE.get(), 110, 1, 1));
		}
		
		//Bufflon
		if(doesNameMatchBiomes(event.getName(), Biomes.SNOWY_TUNDRA, Biomes.FROZEN_RIVER, Biomes.SNOWY_MOUNTAINS))
		{
			MobSpawnInfoBuilder spawnSettings = event.getSpawns();
			spawnSettings.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PCEntities.BUFFLON.get(), 3, 1, 1));
		}
	}
	
	/**
	 * Helper method to determine the the given Name matches the name of the given Biome
	 * @param name - The Name that will be compared to the given Biomes name
	 * @param biome - The Biome that will be used for the check
	 */
	private static boolean doesNameMatchBiome(ResourceLocation name, RegistryKey<Biome> biome)
	{
		return name.toString().equals(biome.getLocation().toString());
	}
	
	/**
	 * Helper method to determine the the given Name matches that of any of the given Biomes
	 * @param name - The Name that will be compared to the given Biomes names
	 * @param biome - The Biome that will be used for the check
	 */
	private static boolean doesNameMatchBiomes(ResourceLocation name, RegistryKey<Biome>... biomes)
	{		
		for(RegistryKey<Biome> biome : biomes)
		{
	        if(biome.getLocation().equals(name))
	        {
	        	return true;
	        }
		}
	    return false;
	}
}
