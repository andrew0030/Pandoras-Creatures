package andrews.pandoras_creatures.config;

import static andrews.pandoras_creatures.config.ConfigHolder.shouldShowUpdateMessage;
import static andrews.pandoras_creatures.config.ConfigHolder.shouldShowUpdateCheckFailedMessage;
import static andrews.pandoras_creatures.config.ConfigHolder.shouldShowInvalidJarMessage;

import net.minecraftforge.fml.config.ModConfig;

public class ConfigHelper
{	
	public static ModConfig clientConfig;

	public static void updateClientConfig(ModConfig config)
	{
		clientConfig = config;
		
		shouldShowUpdateMessage = Config.CLIENT.shouldShowUpdateMessage.get();
		shouldShowUpdateCheckFailedMessage = Config.CLIENT.shouldShowUpdateCheckFailedMessage.get();
		shouldShowInvalidJarMessage = Config.CLIENT.shouldShowInvalidJarMessage.get();
	}
	
}