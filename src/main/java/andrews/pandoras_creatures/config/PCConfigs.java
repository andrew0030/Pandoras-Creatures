package andrews.pandoras_creatures.config;

import andrews.pandoras_creatures.config.configs.PCClientConfig;
import andrews.pandoras_creatures.config.configs.PCClientConfig.PCClientConfigValues;
import andrews.pandoras_creatures.config.configs.PCCommonConfig;
import andrews.pandoras_creatures.config.configs.PCCommonConfig.PCCommonConfigValues;
import andrews.pandoras_creatures.config.util.ConfigHelper;
import andrews.pandoras_creatures.util.Reference;
import net.minecraftforge.fml.config.ModConfig;

public class PCConfigs
{
	public static PCClientConfig.PCClientConfigValues PCClientConfig = null;
	public static PCCommonConfig.PCCommonConfigValues PCCommonConfig = null;
	
	public static void registerConfigs()
	{
		PCClientConfig = ConfigHelper.register(ModConfig.Type.CLIENT, PCClientConfigValues::new, createConfigName("client"));
		PCCommonConfig = ConfigHelper.register(ModConfig.Type.COMMON, PCCommonConfigValues::new, createConfigName("common"));
	}
	
	/**
	 * Helper method to make registering Config names easier
	 */
	private static String createConfigName(String name)
	{
		return Reference.MODID + "-" + name + ".toml";
	}
}
