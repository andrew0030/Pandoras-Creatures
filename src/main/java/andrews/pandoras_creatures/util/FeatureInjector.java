package andrews.pandoras_creatures.util;

import andrews.pandoras_creatures.registry.PCBlocks;
import andrews.pandoras_creatures.world.PCFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.GrassFeatureConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;

public class FeatureInjector
{
	/**
	 * Adds features to Vanilla Biomes
	 */
	public static void addFeaturesToBiomes()
	{
		Biomes.PLAINS.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(PCFeatures.HORSETAIL, new GrassFeatureConfig(PCBlocks.HORSETAIL.getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(2)));
		Biomes.SUNFLOWER_PLAINS.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(PCFeatures.HORSETAIL, new GrassFeatureConfig(PCBlocks.HORSETAIL.getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(1)));
		Biomes.SWAMP.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(PCFeatures.DHANIA, new GrassFeatureConfig(PCBlocks.DHANIA.getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(1)));
		Biomes.MOUNTAINS.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(PCFeatures.HILL_BLOOM, new GrassFeatureConfig(PCBlocks.HILL_BLOOM.getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(1)));
	}
}
