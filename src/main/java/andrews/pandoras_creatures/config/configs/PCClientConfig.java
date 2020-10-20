package andrews.pandoras_creatures.config.configs;

import andrews.pandoras_creatures.config.util.ConfigHelper;
import andrews.pandoras_creatures.config.util.ConfigHelper.ConfigValueListener;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class PCClientConfig
{
	public static class PCClientConfigValues
	{
		public ConfigValueListener<Boolean> shouldShowUpdateMessage;
		public ConfigValueListener<Boolean> shouldShowUpdateCheckFailedMessage;
		public ConfigValueListener<Boolean> shouldShowInvalidJarMessage;
		public ConfigValueListener<Boolean> shouldButtonsInCreativeTabBeEnabled;
		
		public ConfigValueListener<Integer> buttonDiscordOffsetX;
		public ConfigValueListener<Integer> buttonDiscordOffsetY;
		public ConfigValueListener<Integer> buttonCurseForgeOffsetX;
		public ConfigValueListener<Integer> buttonCurseForgeOffsetY;
		public ConfigValueListener<Integer> buttonYouTubeOffsetX;
		public ConfigValueListener<Integer> buttonYouTubeOffsetY;
		public ConfigValueListener<Integer> buttonTwitchOffsetX;
		public ConfigValueListener<Integer> buttonTwitchOffsetY;
		public ConfigValueListener<Integer> buttonPatreonOffsetX;
		public ConfigValueListener<Integer> buttonPatreonOffsetY;
		
		public ConfigValueListener<Integer> buttonFadeInTime;

		public PCClientConfigValues(ForgeConfigSpec.Builder builder, ConfigHelper.Subscriber subscriber)
		{
			builder.comment("Settings for Pandoras Creatures")
            .push("chat");
			
				shouldShowUpdateMessage = subscriber.subscribe(builder
					.comment("Turn the notification the player gets when joining and a new update has been found on and off.")
					.define("shouldShowUpdateMessage", true));
				shouldShowUpdateCheckFailedMessage = subscriber.subscribe(builder
					.comment("Turn the notification the player gets when joining and a the mod wasnt able to check for a new version on and off.")
					.define("shouldShowUpdateCheckFailedMessage", true));
				shouldShowInvalidJarMessage = subscriber.subscribe(builder
					.comment("Turn the notification the player gets when joining and the mod detected an invalid .jar on and off.")
					.define("shouldShowInvalidJarMessage", true));
				
			builder.pop();
			
			builder.push("creativeTabButtonsGeneral");
			
				shouldButtonsInCreativeTabBeEnabled = subscriber.subscribe(builder
					.comment("Choose if the buttons that get rendered in the Pandoras Creatures Creative Tab should be disabled or enabled.")
					.define("shouldButtonsInCreativeTabBeEnabled", true));
				buttonFadeInTime = subscriber.subscribe(builder
					.comment("The amount of seconds it takes for the buttons to fully appear. Set it to 0 in order to disable the fading")
					.defineInRange("buttonFadeInTime", 1, 0, 5));
				
			builder.pop();
				
			builder.push("creativeTabButtonsOffset");
				
				buttonDiscordOffsetX = subscriber.subscribe(builder
					.comment("Offset the Discord Button on the X axis")
					.define("buttonDiscordOffsetX", 0));
				buttonDiscordOffsetY = subscriber.subscribe(builder
					.comment("Offset the Discord Button on the Y axis")
					.define("buttonDiscordOffsetY", 0));
				buttonCurseForgeOffsetX = subscriber.subscribe(builder
					.comment("Offset the CurseForge Button on the X axis")
					.define("buttonCurseForgeOffsetX", 0));
				buttonCurseForgeOffsetY = subscriber.subscribe(builder
					.comment("Offset the CurseForge Button on the Y axis")
					.define("buttonCurseForgeOffsetY", 0));
				buttonYouTubeOffsetX = subscriber.subscribe(builder
					.comment("Offset the YouTube Button on the X axis")
					.define("buttonYouTubeOffsetX", 0));
				buttonYouTubeOffsetY = subscriber.subscribe(builder
					.comment("Offset the YouTube Button on the Y axis")
					.define("buttonYouTubeOffsetY", 0));
				buttonTwitchOffsetX = subscriber.subscribe(builder
					.comment("Offset the Twitch Button on the X axis")
					.define("buttonTwitchOffsetX", 0));
				buttonTwitchOffsetY = subscriber.subscribe(builder
					.comment("Offset the Twitch Button on the Y axis")
					.define("buttonTwitchOffsetY", 0));
				buttonPatreonOffsetX = subscriber.subscribe(builder
					.comment("Offset the Patreon Button on the X axis")
					.define("buttonPatreonOffsetX", 0));
				buttonPatreonOffsetY = subscriber.subscribe(builder
					.comment("Offset the Patreon Button on the Y axis")
					.define("buttonPatreonOffsetY", 0));
				
			builder.pop();
		}
	}
}
