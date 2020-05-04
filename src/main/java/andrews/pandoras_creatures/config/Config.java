package andrews.pandoras_creatures.config;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.config.ModConfig;

public class Config
{
	/**
     * Common configuration
     */
	public static class Common
	{
		public final ConfigValue<Boolean> arachnonSpawning;
		public final ConfigValue<Boolean> hellhoundSpawning;
		public final ConfigValue<Boolean> crabSpawning;
		public final ConfigValue<Boolean> seahorseSpawning;
		public final ConfigValue<Boolean> acidicArchvineSpawning;
		public final ConfigValue<Boolean> bufflonSpawning;
		
		Common(ForgeConfigSpec.Builder builder)
		{
			builder.comment("Common Settings for Pandoras Creatures")
            .push("spawning");
			arachnonSpawning = builder
				.comment("Toggle Arachnon Spawning")
				.define("arachnonSpawning", true);
			hellhoundSpawning = builder
				.comment("Toggle Hellhound Spawning")
				.define("hellhoundSpawning", true);
			crabSpawning = builder
				.comment("Toggle Crab Spawning")
				.define("crabSpawning", true);
			seahorseSpawning = builder
				.comment("Toggle Seahorse Spawning")
				.define("seahorseSpawning", true);
			acidicArchvineSpawning = builder
				.comment("Toggle Acidic Archvine Spawning")
				.define("acidicArchvineSpawning", true);
			bufflonSpawning = builder
				.comment("Toggle Bufflon Spawning")
				.define("bufflonSpawning", true);
			builder.pop();
		}
	}
	
	/**
     * Client specific configuration
     */
	public static class Client
	{
		public final ConfigValue<Boolean> shouldShowUpdateMessage;
		public final ConfigValue<Boolean> shouldShowUpdateCheckFailedMessage;
		public final ConfigValue<Boolean> shouldShowInvalidJarMessage;
		public final ConfigValue<Boolean> shouldButtonsInCreativeTabBeEnabled;
		
		public final ConfigValue<Integer> buttonDiscordOffsetX;
		public final ConfigValue<Integer> buttonDiscordOffsetY;
		public final ConfigValue<Integer> buttonCurseForgeOffsetX;
		public final ConfigValue<Integer> buttonCurseForgeOffsetY;
		public final ConfigValue<Integer> buttonYouTubeOffsetX;
		public final ConfigValue<Integer> buttonYouTubeOffsetY;
		public final ConfigValue<Integer> buttonTwitchOffsetX;
		public final ConfigValue<Integer> buttonTwitchOffsetY;
		public final ConfigValue<Integer> buttonPatreonOffsetX;
		public final ConfigValue<Integer> buttonPatreonOffsetY;
		
		public final ConfigValue<Integer> buttonFadeInTime;
		
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
			
			builder.push("creativeTabOptions");
			shouldButtonsInCreativeTabBeEnabled = builder
				.comment("Choose if the buttons that get rendered in the Pandoras Creatures Creative Tab should be disabled or enabled.")
				.define("shouldButtonsInCreativeTabBeEnabled", true);
			buttonDiscordOffsetX = builder
				.comment("Offset the Discord Button on the X axis")
				.define("buttonDiscordOffsetX", 0);
			buttonDiscordOffsetY = builder
				.comment("Offset the Discord Button on the Y axis")
				.define("buttonDiscordOffsetY", 0);
			buttonCurseForgeOffsetX = builder
				.comment("Offset the CurseForge Button on the X axis")
				.define("buttonCurseForgeOffsetX", 0);
			buttonCurseForgeOffsetY = builder
				.comment("Offset the CurseForge Button on the Y axis")
				.define("buttonCurseForgeOffsetY", 0);
			buttonYouTubeOffsetX = builder
				.comment("Offset the YouTube Button on the X axis")
				.define("buttonYouTubeOffsetX", 0);
			buttonYouTubeOffsetY = builder
				.comment("Offset the YouTube Button on the Y axis")
				.define("buttonYouTubeOffsetY", 0);
			buttonTwitchOffsetX = builder
				.comment("Offset the Twitch Button on the X axis")
				.define("buttonTwitchOffsetX", 0);
			buttonTwitchOffsetY = builder
				.comment("Offset the Twitch Button on the Y axis")
				.define("buttonTwitchOffsetY", 0);
			buttonPatreonOffsetX = builder
				.comment("Offset the Patreon Button on the X axis")
				.define("buttonPatreonOffsetX", 0);
			buttonPatreonOffsetY = builder
				.comment("Offset the Patreon Button on the Y axis")
				.define("buttonPatreonOffsetY", 0);
			buttonFadeInTime = builder
				.comment("The amount of seconds it takes for the buttons to fully appear. Set it to 0 in order to disable the fading")
				.defineInRange("buttonFadeInTime", 1, 0, 5);	
			builder.pop();
		}
	}
	
	public static final ForgeConfigSpec COMMONSPEC;
	public static final Common COMMON;
	public static final ForgeConfigSpec CLIENTSPEC;
	public static final Client CLIENT;
	
	static
	{
		//Common
		final Pair<Common, ForgeConfigSpec> specPairCommon = new ForgeConfigSpec.Builder().configure(Common::new);
		COMMONSPEC = specPairCommon.getRight();
		COMMON = specPairCommon.getLeft();
		
		//Client
		final Pair<Client, ForgeConfigSpec> specPairClient = new ForgeConfigSpec.Builder().configure(Client::new);
		CLIENTSPEC = specPairClient.getRight();
		CLIENT = specPairClient.getLeft();
	}
    
    @SubscribeEvent
    public static void onLoad(final ModConfig.Loading configEvent) {}

    @SubscribeEvent
    public static void onFileChange(final ModConfig.Reloading configEvent) {}  
}