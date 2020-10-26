package andrews.pandoras_creatures.config.configs;

import andrews.pandoras_creatures.config.util.ConfigHelper;
import andrews.pandoras_creatures.config.util.ConfigHelper.ConfigValueListener;
import net.minecraftforge.common.ForgeConfigSpec;

public class PCCommonConfig
{
	public static class PCCommonConfigValues
	{
		public ConfigValueListener<Boolean> placeHolder;

		public PCCommonConfigValues(ForgeConfigSpec.Builder builder, ConfigHelper.Subscriber subscriber)
		{
			builder.comment("Common Settings for Pandoras Creatures, Entity Spawning has been moved to the new config file (entity-spawning.toml)")
            .push("Common");
				placeHolder = subscriber.subscribe(builder
				.comment(" This value does nothing, its just a placeholder")
				.define("placeHolder", true));
			builder.pop();
		}
	}
}
