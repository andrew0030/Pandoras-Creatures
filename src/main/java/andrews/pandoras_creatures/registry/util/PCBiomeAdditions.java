package andrews.pandoras_creatures.registry.util;

import andrews.pandoras_creatures.registry.PCEntities;
import andrews.pandoras_creatures.registry.PCFeatures;
import andrews.pandoras_creatures.registry.PCStructures;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.entity.EntityClassification;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.FlatChunkGenerator;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.common.world.MobSpawnInfoBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@SuppressWarnings("unchecked")
@Mod.EventBusSubscriber(modid = Reference.MODID)
public class PCBiomeAdditions
{	
	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void spawnEntities(BiomeLoadingEvent event)
	{
		addEntitiesToBiomes(event);
		addFeaturesToBiomes(event);
	}
	
	@SubscribeEvent
    public static void addDimensionalSpacing(final WorldEvent.Load event)
	{
		if(event.getWorld() instanceof ServerWorld)
		{
            ServerWorld serverWorld = (ServerWorld)event.getWorld();
            //Makes sure there aren't any StructureSeparationSettings being saved on SuperFlatWorlds
            if(serverWorld.getChunkProvider().getChunkGenerator() instanceof FlatChunkGenerator)
            {
				return;
			}
            
            serverWorld.getChunkProvider().getChunkGenerator().func_235957_b_().field_236193_d_.put(PCStructures.END_PRISON.get(), DimensionStructuresSettings.field_236191_b_.get(PCStructures.END_PRISON.get()));
        }
	}
	
	/**
	 * This method adds all the Entities to the Biomes
	 */
	private static void addEntitiesToBiomes(BiomeLoadingEvent event)
	{
		MobSpawnInfoBuilder spawnSettings = event.getSpawns();
		
		//Arachnom
		if(doesNameMatchBiomes(event.getName(), Biomes.PLAINS, Biomes.MOUNTAINS, Biomes.GRAVELLY_MOUNTAINS))
		{	
			spawnSettings.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(PCEntities.ARACHNON.get(), 20, 1, 1));
		}
		
		//Hellhound
		if(doesNameMatchBiomes(event.getName(), Biomes.NETHER_WASTES, Biomes.SOUL_SAND_VALLEY))
		{	
			spawnSettings.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(PCEntities.HELLHOUND.get(), 30, 3, 6));
		}
		
		//Crab
		if(doesNameMatchBiomes(event.getName(), Biomes.BEACH, Biomes.WARM_OCEAN))
		{	
			spawnSettings.withSpawner(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(PCEntities.CRAB.get(), 400, 2, 5));
		}
		
		//Seahorse
		if(doesNameMatchBiomes(event.getName(), Biomes.WARM_OCEAN, Biomes.DEEP_WARM_OCEAN))
		{	
			spawnSettings.withSpawner(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(PCEntities.SEAHORSE.get(), 25, 3, 6));
		}
		if(doesNameMatchBiomes(event.getName(), Biomes.OCEAN, Biomes.LUKEWARM_OCEAN, Biomes.DEEP_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN))
		{	
			spawnSettings.withSpawner(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(PCEntities.SEAHORSE.get(), 10, 2, 3));
		}
		
		//Acidic Archvine
		if(doesNameMatchBiome(event.getName(), Biomes.NETHER_WASTES))
		{	
			spawnSettings.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(PCEntities.ACIDIC_ARCHVINE.get(), 30, 1, 1));
		}
		if(doesNameMatchBiome(event.getName(), Biomes.CRIMSON_FOREST))
		{	
			spawnSettings.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(PCEntities.ACIDIC_ARCHVINE.get(), 10, 1, 1));
		}
		if(doesNameMatchBiomes(event.getName(), Biomes.JUNGLE, Biomes.JUNGLE_EDGE, Biomes.JUNGLE_HILLS, Biomes.MODIFIED_JUNGLE, Biomes.MODIFIED_JUNGLE_EDGE))
		{
			spawnSettings.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(PCEntities.ACIDIC_ARCHVINE.get(), 110, 1, 1));
		}
		
		//Bufflon
		if(doesNameMatchBiomes(event.getName(), Biomes.SNOWY_TUNDRA, Biomes.FROZEN_RIVER, Biomes.SNOWY_MOUNTAINS))
		{
			spawnSettings.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(PCEntities.BUFFLON.get(), 3, 1, 1));
		}
	}
	
	/**
	 * This method adds all the Features and Structures to the Biomes
	 */
	private static void addFeaturesToBiomes(BiomeLoadingEvent event)
	{
		BiomeGenerationSettingsBuilder genSettings = event.getGeneration();
		
		//Horsetail
		if(doesNameMatchBiomes(event.getName(), Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS))
		{
			genSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PCFeatures.HORSE_TAIL_CONFIGURED);
		}
		
		//Dhania
		if(doesNameMatchBiome(event.getName(), Biomes.SWAMP))
		{
			genSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PCFeatures.DHANIA_CONFIGURED);
		}
		
		//Hill Bloom
		if(doesNameMatchBiome(event.getName(), Biomes.MOUNTAINS))
		{
			genSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PCFeatures.HILL_BLOOM_CONFIGURED);
		}
		
		//End Prison
		if(doesNameMatchBiomes(event.getName(), Biomes.END_MIDLANDS, Biomes.END_HIGHLANDS, Biomes.END_BARRENS, Biomes.SMALL_END_ISLANDS))
		{
			genSettings.withStructure(PCStructures.END_PRISON_FEATURE);
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
