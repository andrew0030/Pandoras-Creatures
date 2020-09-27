package andrews.pandoras_creatures.util;

import andrews.pandoras_creatures.registry.PCBlocks;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;

public class FeatureInjector
{
	public static final BlockClusterFeatureConfig HORSETAIL_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PCBlocks.HORSETAIL.get().getDefaultState()), new SimpleBlockPlacer())).tries(8).build();
	public static final BlockClusterFeatureConfig DHANIA_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PCBlocks.DHANIA.get().getDefaultState()), new SimpleBlockPlacer())).tries(8).build();
	public static final BlockClusterFeatureConfig HILL_BLOOM_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PCBlocks.HILL_BLOOM.get().getDefaultState()), new SimpleBlockPlacer())).tries(8).build();
	
	/**
	 * Adds features to Vanilla Biomes
	 */
	public static void addFeaturesToBiomes()
	{
		//Bufflon related plants
		//TODO figure out how to register these plants now
//		Biomes.PLAINS.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(HORSETAIL_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
//		Biomes.SUNFLOWER_PLAINS.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(HORSETAIL_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
//		Biomes.SWAMP.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DHANIA_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
//		Biomes.MOUNTAINS.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(HILL_BLOOM_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
		
		//End Prison
//		for(Biome biome : BiomeDictionary.getBiomes(Type.END))
//		{
//			addStructure(biome, PCStructures.END_PRISON.get());
//		}
		
//		Biomes.END_MIDLANDS.addStructure(PCFeatures.END_PRISON.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
//		Biomes.END_HIGHLANDS.addStructure(PCFeatures.END_PRISON.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));// TODO fix the structure injection
//		addStructure(Biomes.PLAINS, PCStructures.END_PRISON.get());
	} 
	
	/**
	 * Adds the given Structure to the given Biome
	 * @param biome - The Biome the structure should be added to
	 * @param structure - The Structure that is being added
	 */
//	private static void addStructure(Biome biome, Structure<NoFeatureConfig> structure) TODO make sure this is still needed
//	{
//		//   .addStructure            .withConfiguration			 .NoFeatureConfig
//		biome.func_235063_a_(structure.func_236391_a_(NoFeatureConfig.field_236559_b_));
//    }
}
