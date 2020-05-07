package andrews.pandoras_creatures.util;

import andrews.pandoras_creatures.registry.PCBlocks;
import andrews.pandoras_creatures.world.PCFeatures;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;

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
		Biomes.PLAINS.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(HORSETAIL_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
		Biomes.SUNFLOWER_PLAINS.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(HORSETAIL_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
		Biomes.SWAMP.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DHANIA_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
		Biomes.MOUNTAINS.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(HILL_BLOOM_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
		
		//End Prison
		Biomes.SMALL_END_ISLANDS.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, PCFeatures.END_PRISON.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
		Biomes.END_BARRENS.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, PCFeatures.END_PRISON.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
		Biomes.END_MIDLANDS.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, PCFeatures.END_PRISON.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
		Biomes.END_HIGHLANDS.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, PCFeatures.END_PRISON.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
		Biomes.END_MIDLANDS.addStructure(PCFeatures.END_PRISON.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
		Biomes.END_HIGHLANDS.addStructure(PCFeatures.END_PRISON.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
		
		
		//End Prison
//		Biomes.SMALL_END_ISLANDS.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Biome.createDecoratedFeature(PCFeatures.END_PRISON.get(), IFeatureConfig.NO_FEATURE_CONFIG, Placement.NOPE, IPlacementConfig.NO_PLACEMENT_CONFIG));
//		Biomes.END_BARRENS.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Biome.createDecoratedFeature(PCFeatures.END_PRISON.get(), IFeatureConfig.NO_FEATURE_CONFIG, Placement.NOPE, IPlacementConfig.NO_PLACEMENT_CONFIG));
//		Biomes.END_MIDLANDS.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Biome.createDecoratedFeature(PCFeatures.END_PRISON.get(), IFeatureConfig.NO_FEATURE_CONFIG, Placement.NOPE, IPlacementConfig.NO_PLACEMENT_CONFIG));
//		Biomes.END_HIGHLANDS.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Biome.createDecoratedFeature(PCFeatures.END_PRISON.get(), IFeatureConfig.NO_FEATURE_CONFIG, Placement.NOPE, IPlacementConfig.NO_PLACEMENT_CONFIG));
//		Biomes.END_MIDLANDS.addStructure(PCFeatures.END_PRISON.get(), IFeatureConfig.NO_FEATURE_CONFIG);
//		Biomes.END_HIGHLANDS.addStructure(PCFeatures.END_PRISON.get(), IFeatureConfig.NO_FEATURE_CONFIG);
	}
}
