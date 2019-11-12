package andrews.pandoras_creatures.world;

import java.util.List;

import com.google.common.collect.Lists;

import andrews.pandoras_creatures.util.Reference;
import andrews.pandoras_creatures.world.features.FeatureDhania;
import andrews.pandoras_creatures.world.features.FeatureHillBloom;
import andrews.pandoras_creatures.world.features.FeatureHorsetail;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.GrassFeatureConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@SuppressWarnings({"rawtypes", "unchecked"})
public class PCFeatures
{
	private static List<Feature<?>> features = Lists.newArrayList();
	
	public static final Feature<GrassFeatureConfig> HORSETAIL		= registerFeature("horsetail", new FeatureHorsetail(GrassFeatureConfig::deserialize));
	public static final Feature<GrassFeatureConfig> DHANIA   		= registerFeature("dhania", new FeatureDhania(GrassFeatureConfig::deserialize));
	public static final Feature<GrassFeatureConfig> HILL_BLOOM    	= registerFeature("hill_bloom", new FeatureHillBloom(GrassFeatureConfig::deserialize));
	
	private static Feature registerFeature(String name, Feature feature)
	{
		feature.setRegistryName(Reference.MODID, name);
		features.add(feature);
		return feature;
	}
	
	@SubscribeEvent
	public static void registerFeatures(RegistryEvent.Register<Feature<?>> event)
	{
		for(Feature features : features)
		{
			event.getRegistry().register(features);
		}
	}
}