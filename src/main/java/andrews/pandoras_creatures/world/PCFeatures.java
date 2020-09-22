package andrews.pandoras_creatures.world;

import andrews.pandoras_creatures.util.Reference;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PCFeatures
{
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Reference.MODID);
	
//	public static final RegistryObject<Structure<NoFeatureConfig>> END_PRISON 		 = createFeature("end_prison", () -> new EndPrisonStructure(NoFeatureConfig::deserialize)); TODO fix structures
	
//	private static <F extends Feature<?>> RegistryObject<F> createFeature(String name, Supplier<F> feature)
//	{
//		return FEATURES.register(name, feature);
//	}
}