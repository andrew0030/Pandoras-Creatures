package andrews.pandoras_creatures.world;

import java.util.function.Supplier;

import andrews.pandoras_creatures.util.Reference;
import andrews.pandoras_creatures.world.features.FeatureDhania;
import andrews.pandoras_creatures.world.features.FeatureHillBloom;
import andrews.pandoras_creatures.world.features.FeatureHorsetail;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.GrassFeatureConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PCFeatures
{
	public static final DeferredRegister<Feature<?>> FEATURES = new DeferredRegister<>(ForgeRegistries.FEATURES, Reference.MODID);
	
	public static final RegistryObject<Feature<GrassFeatureConfig>> HORSETAIL    = createFeature("horsetail", () -> new FeatureHorsetail(GrassFeatureConfig::deserialize));
	public static final RegistryObject<Feature<GrassFeatureConfig>> DHANIA = createFeature("dhania", () -> new FeatureDhania(GrassFeatureConfig::deserialize));
	public static final RegistryObject<Feature<GrassFeatureConfig>> HILL_BLOOM     = createFeature("hill_bloom", () -> new FeatureHillBloom(GrassFeatureConfig::deserialize));
	
	private static <F extends Feature<?>> RegistryObject<F> createFeature(String name, Supplier<F> feature)
	{
		return FEATURES.register(name, feature);
	}
}