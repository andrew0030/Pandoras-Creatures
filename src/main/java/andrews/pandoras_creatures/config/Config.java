package andrews.pandoras_creatures.config;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.config.ModConfig;

public class Config
{
	/**
     * Server specific configuration
     */
	public static class Client
	{
		public final ConfigValue<Boolean> shouldShowUpdateMessage;
		public final ConfigValue<Boolean> shouldShowUpdateCheckFailedMessage;
		public final ConfigValue<Boolean> shouldShowInvalidJarMessage;
		
		Client(ForgeConfigSpec.Builder builder)
		{
			builder.comment("Settings for Pandoras Creatures")
            .push("chat");
			
			shouldShowUpdateMessage = builder
				.comment("Turn the notification the player gets when joining and a new update has been found on and off.")
				.define("shouldShowUpdateMessage", true);
			
			shouldShowUpdateCheckFailedMessage = builder
				.comment("Turn the notification the player gets when joining and a the mod wasnt able to check for a new version on and off.")
				.define("shouldShowUpdateCheckFailedMessage", true);
			
			shouldShowInvalidJarMessage = builder
				.comment("Turn the notification the player gets when joining and the mod detected an invalid .jar on and off.")
				.define("shouldShowInvalidJarMessage", true);
			
			builder.pop();
		}
		
	}
	
	public static final ForgeConfigSpec CLIENTSPEC;
	public static final Client CLIENT;
	static
	{
		final Pair<Client, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Client::new);
		CLIENTSPEC = specPair.getRight();
		CLIENT = specPair.getLeft();
	}
    
    @SubscribeEvent
    public static void onLoad(final ModConfig.Loading configEvent) {}

    @SubscribeEvent
    public static void onFileChange(final ModConfig.ConfigReloading configEvent) {}  
}