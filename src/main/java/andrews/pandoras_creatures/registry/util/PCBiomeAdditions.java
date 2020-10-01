package andrews.pandoras_creatures.registry.util;

import java.util.HashMap;
import java.util.Map;

import andrews.pandoras_creatures.registry.PCBlocks;
import andrews.pandoras_creatures.registry.PCEntities;
import andrews.pandoras_creatures.registry.PCStructures;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.entity.EntityClassification;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.Lazy;
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
	private static final Lazy<BlockClusterFeatureConfig> HORSETAIL_CONFIG = Lazy.of(() -> (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PCBlocks.HORSETAIL.get().getDefaultState()), SimpleBlockPlacer.PLACER)).tries(64).build());
	private static final Lazy<BlockClusterFeatureConfig> DHANIA_CONFIG = Lazy.of(() -> (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PCBlocks.DHANIA.get().getDefaultState()), SimpleBlockPlacer.PLACER)).tries(64).build());
	private static final Lazy<BlockClusterFeatureConfig> HILL_BLOOM_CONFIG = Lazy.of(() -> (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PCBlocks.HILL_BLOOM.get().getDefaultState()), SimpleBlockPlacer.PLACER)).tries(64).build());
	
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
            Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(serverWorld.getChunkProvider().generator.func_235957_b_().func_236195_a_());
            tempMap.put(PCStructures.END_PRISON.get(), DimensionStructuresSettings.field_236191_b_.get(PCStructures.END_PRISON.get()));
            serverWorld.getChunkProvider().generator.func_235957_b_().field_236193_d_ = tempMap;
        }
	}
	
	/**
	 * This method adds all the Entities to the Biomes
	 */
	private static void addEntitiesToBiomes(BiomeLoadingEvent event)
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
			spawnSettings.withSpawner(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(PCEntities.CRAB.get(), 400, 2, 5));
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
			spawnSettings.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(PCEntities.ACIDIC_ARCHVINE.get(), 10, 1, 1));
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
	 * This method adds all the Features and Structures to the Biomes
	 */
	private static void addFeaturesToBiomes(BiomeLoadingEvent event)
	{
		//Horsetail
		if(doesNameMatchBiomes(event.getName(), Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS))
		{
			BiomeGenerationSettingsBuilder genSettings = event.getGeneration();
			genSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FLOWER.withConfiguration(HORSETAIL_CONFIG.get()).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242731_b(3));//func_242731_b = spreadBase
		}
		
		//Dhania
		if(doesNameMatchBiome(event.getName(), Biomes.SWAMP))
		{
			BiomeGenerationSettingsBuilder genSettings = event.getGeneration();
			genSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FLOWER.withConfiguration(DHANIA_CONFIG.get()).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242731_b(3));
		}
		
		//Hill Bloom
		if(doesNameMatchBiome(event.getName(), Biomes.MOUNTAINS))
		{
			BiomeGenerationSettingsBuilder genSettings = event.getGeneration();
			genSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FLOWER.withConfiguration(HILL_BLOOM_CONFIG.get()).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242731_b(3));
		}
		
		//End Prison
		if(doesNameMatchBiomes(event.getName(), Biomes.SMALL_END_ISLANDS, Biomes.END_BARRENS, Biomes.END_MIDLANDS, Biomes.END_HIGHLANDS))
		{
			BiomeGenerationSettingsBuilder genSettings = event.getGeneration();
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
