package andrews.pandoras_creatures.registry;

import java.util.function.Supplier;

import andrews.pandoras_creatures.util.Reference;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DefaultFlowersFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PCFeatures
{
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Reference.MODID);
	
	//Feature Configs
	private static final Lazy<BlockClusterFeatureConfig> HORSETAIL_CONFIG = Lazy.of(() -> (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PCBlocks.HORSETAIL.get().getDefaultState()), SimpleBlockPlacer.PLACER)).tries(64).build());
	private static final Lazy<BlockClusterFeatureConfig> DHANIA_CONFIG = Lazy.of(() -> (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PCBlocks.DHANIA.get().getDefaultState()), SimpleBlockPlacer.PLACER)).tries(64).build());
	private static final Lazy<BlockClusterFeatureConfig> HILL_BLOOM_CONFIG = Lazy.of(() -> (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PCBlocks.HILL_BLOOM.get().getDefaultState()), SimpleBlockPlacer.PLACER)).tries(64).build());
    
	//Features
	public static final RegistryObject<Feature<BlockClusterFeatureConfig>> HORSE_TAIL = createFeature("horse_tail", () -> new DefaultFlowersFeature(BlockClusterFeatureConfig.field_236587_a_));
	public static ConfiguredFeature<?, ? extends Feature<?>> HORSE_TAIL_CONFIGURED;
	public static final RegistryObject<Feature<BlockClusterFeatureConfig>> DHANIA = createFeature("dhania", () -> new DefaultFlowersFeature(BlockClusterFeatureConfig.field_236587_a_));
	public static ConfiguredFeature<?, ? extends Feature<?>> DHANIA_CONFIGURED;
	public static final RegistryObject<Feature<BlockClusterFeatureConfig>> HILL_BLOOM = createFeature("hill_bloom", () -> new DefaultFlowersFeature(BlockClusterFeatureConfig.field_236587_a_));
	public static ConfiguredFeature<?, ? extends Feature<?>> HILL_BLOOM_CONFIGURED;
	
	/**
     * Registers the ConfiguredStructures
     */
	public static void registerConfiguredFeatures()
    {
		HORSE_TAIL_CONFIGURED = WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE, Reference.MODID + ":horse_tail_configured", Feature.FLOWER.withConfiguration(HORSETAIL_CONFIG.get()).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242731_b(3));
		DHANIA_CONFIGURED = WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE, Reference.MODID + ":dhania_configured", Feature.FLOWER.withConfiguration(DHANIA_CONFIG.get()).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242731_b(3));
		HILL_BLOOM_CONFIGURED = WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_FEATURE, Reference.MODID + ":hill_bloom_configured", Feature.FLOWER.withConfiguration(HILL_BLOOM_CONFIG.get()).withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242731_b(3));
    }
	
    private static <F extends Feature<?>> RegistryObject<F> createFeature(String name, Supplier<F> feature)
    {
		return FEATURES.register(name, feature);
	}
}
