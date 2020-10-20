package andrews.pandoras_creatures.config.configs;

import andrews.pandoras_creatures.config.util.ConfigHelper;
import andrews.pandoras_creatures.config.util.ConfigHelper.ConfigValueListener;
import net.minecraftforge.common.ForgeConfigSpec;

public class PCCommonConfig
{
	public static class PCCommonConfigValues
	{
		public ConfigValueListener<Boolean> arachnonSpawning;
		public ConfigValueListener<Boolean> hellhoundSpawning;
		public ConfigValueListener<Boolean> crabSpawning;
		public ConfigValueListener<Boolean> seahorseSpawning;
		public ConfigValueListener<Boolean> acidicArchvineSpawning;
		public ConfigValueListener<Boolean> bufflonSpawning;

		public PCCommonConfigValues(ForgeConfigSpec.Builder builder, ConfigHelper.Subscriber subscriber)
		{
			builder.comment("Common Settings for Pandoras Creatures")
            .push("spawning");
			
				arachnonSpawning = subscriber.subscribe(builder
					.comment("Toggle Arachnon Spawning")
					.define("arachnonSpawning", true));
				hellhoundSpawning = subscriber.subscribe(builder
					.comment("Toggle Hellhound Spawning")
					.define("hellhoundSpawning", true));
				crabSpawning = subscriber.subscribe(builder
					.comment("Toggle Crab Spawning")
					.define("crabSpawning", true));
				seahorseSpawning = subscriber.subscribe(builder
					.comment("Toggle Seahorse Spawning")
					.define("seahorseSpawning", true));
				acidicArchvineSpawning = subscriber.subscribe(builder
					.comment("Toggle Acidic Archvine Spawning")
					.define("acidicArchvineSpawning", true));
				bufflonSpawning = subscriber.subscribe(builder
					.comment("Toggle Bufflon Spawning")
					.define("bufflonSpawning", true));
				
			builder.pop();
		}
	}
}
