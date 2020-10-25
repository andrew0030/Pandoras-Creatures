package andrews.pandoras_creatures.registry.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.print.attribute.SetOfIntegerSyntax;

import andrews.pandoras_creatures.config.PCConfigs;
import andrews.pandoras_creatures.registry.PCEntities;
import andrews.pandoras_creatures.registry.PCFeatures;
import andrews.pandoras_creatures.registry.PCStructures;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.FlatChunkGenerator;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
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
		String arachnonSpawnBiomes = PCConfigs.PCEntitySpawningConfig.arachnonSpawnBiomes.get();
		String arachnonSpawnTags = PCConfigs.PCEntitySpawningConfig.arachnonDictionaryTags.get();
		String arachnonDictionaryBiomeBlacklist = PCConfigs.PCEntitySpawningConfig.arachnonDictionaryBiomeBlacklist.get();
		int arachnonWeight = PCConfigs.PCEntitySpawningConfig.arachnonDictionaryWeight.get();
		int arachnonMinSpawns = PCConfigs.PCEntitySpawningConfig.arachnonDictionaryMinSpawns.get();
		int arachnonMaxSpawns = PCConfigs.PCEntitySpawningConfig.arachnonDictionaryMaxSpawns.get();
		addEntitySpawnsToBiomes(event, PCEntities.ARACHNON.get(), EntityClassification.MONSTER, arachnonSpawnBiomes, arachnonSpawnTags, arachnonDictionaryBiomeBlacklist, arachnonWeight, arachnonMinSpawns, arachnonMaxSpawns);
	}
	
	private static void addEntitySpawnsToBiomes(BiomeLoadingEvent event, EntityType<?> entity, EntityClassification entityClassification, String entitySpawnBiomes, String entitySpawnTags, String entityDictionaryBiomeBlacklist, int entitySpawnWeight, int entityMinSpawns, int entityMaxSpawns)
	{	
		//Gets all the biomes from the Config and separates them
		List<String> foundBiomes = Arrays.asList(entitySpawnBiomes.replaceAll(" ", "").split(","));
		//We go through all found Biomes and split up the information
		for(int i = 0; i < foundBiomes.size(); i++)
		{
			List<String> entityBiomeSpawnValues = Arrays.asList(foundBiomes.get(i).replaceAll(" ", "").split("/"));
			if(entityBiomeSpawnValues.get(0).equals(event.getName().toString()))
			{
				Integer weight = null;
				Integer minSpawns = null;
				Integer maxSpawns = null;
				
				try
				{
					if(entityBiomeSpawnValues.get(1) != null && entityBiomeSpawnValues.get(2) != null && entityBiomeSpawnValues.get(3) != null)
					{
						try
						{
							weight = Integer.parseInt(entityBiomeSpawnValues.get(1));
							minSpawns = Integer.parseInt(entityBiomeSpawnValues.get(2));
							maxSpawns = Integer.parseInt(entityBiomeSpawnValues.get(3));
						}
						catch(NumberFormatException e)
						{
							System.out.println();
							System.out.println("Pandoras Creatures has detected a problem in the entity-spawning config");
							System.out.println("The Entity with the problem is: " + entity.getName().getString());
							System.out.println("One of the 3 Values for Biome: " + entityBiomeSpawnValues.get(0) + " was invalid");
							System.out.println(e.toString());
						}
					}
				}
				catch(IndexOutOfBoundsException e)
				{
					System.out.println();
					System.out.println("Pandoras Creatures has detected a problem in the entity-spawning config");
					System.out.println("The Entity with the problem is: " + entity.getName().getString());
					System.out.println("One (or more), of the 3 Values for Biome: " + entityBiomeSpawnValues.get(0) + " was not found");
				}
				
				//We make sure all needed values have been found
				if(weight != null && minSpawns != null && maxSpawns != null)
				{
					event.getSpawns().withSpawner(entityClassification, new MobSpawnInfo.Spawners(entity, MathHelper.clamp(weight, 1, 1000), MathHelper.clamp(minSpawns, 1, 100), MathHelper.clamp(maxSpawns, 1, 100)));
					System.out.println("Added " + entity.getName().getString() + " to: " + entityBiomeSpawnValues.get(0) + " weight: " + weight + " min: " + minSpawns + " max: " + maxSpawns);//TODO remove
				}
			}
		}
		
		List<String> foundTags = Arrays.asList(entitySpawnTags.replaceAll(" ", "").toUpperCase().split(","));
		for(int i = 0; i < foundTags.size(); i++)
		{
			for(RegistryKey<Biome> biome : BiomeDictionary.getBiomes(Type.getType(foundTags.get(i))))
			{
				if(biome.getLocation().toString().equals(event.getName().toString()))
				{
					List<String> blackListedBiomes = Arrays.asList(entityDictionaryBiomeBlacklist.replaceAll(" ", "").split(","));
					if(!blackListedBiomes.contains(biome.getLocation().toString()))
					{
						List<String> biomesNames = new ArrayList<String>();
						
						for(int j = 0; j < foundBiomes.size(); j++)
						{
							List<String> biomesInfo = Arrays.asList(foundBiomes.get(j).replaceAll(" ", "").split("/"));
							biomesNames.add(biomesInfo.get(0));
						}
						
						if(!biomesNames.contains(biome.getLocation().toString()))
						{
							event.getSpawns().withSpawner(entityClassification, new MobSpawnInfo.Spawners(entity, entitySpawnWeight, entityMinSpawns, entityMaxSpawns));
							System.out.println("Added " + entity.getName().getString() + " to: " + biome.getLocation().toString() + " weight: " + entitySpawnWeight + " min: " + entityMinSpawns + " max: " + entityMaxSpawns);//TODO remove
						}
					}
				}
			}
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
