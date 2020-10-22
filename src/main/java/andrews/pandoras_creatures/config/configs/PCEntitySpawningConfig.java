package andrews.pandoras_creatures.config.configs;

import andrews.pandoras_creatures.config.util.ConfigHelper;
import andrews.pandoras_creatures.config.util.ConfigHelper.ConfigValueListener;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class PCEntitySpawningConfig
{
	public static class PCEntitySpawningConfigValues
	{
		public ConfigValueListener<Boolean> arachnonSpawning;
		public ConfigValueListener<Boolean> hellhoundSpawning;
		public ConfigValueListener<Boolean> crabSpawning;
		public ConfigValueListener<Boolean> seahorseSpawning;
		public ConfigValueListener<Boolean> acidicArchvineSpawning;
		public ConfigValueListener<Boolean> bufflonSpawning;
		
		public ConfigValueListener<String> arachnonSpawnBiomes;
		public ConfigValueListener<String> arachnonSpawnBiomesDictionary;
		public ConfigValueListener<String> arachnonSpawnBiomesBlacklist;

		public PCEntitySpawningConfigValues(ForgeConfigSpec.Builder builder, ConfigHelper.Subscriber subscriber)
		{
			builder.comment(" You can prevent Entities from spawning in these settings, keep in mind if you disable"
						   +"\r\n an Entity, it will not spawn regardless of its Advanced Entity Spawn Settings")
			.push("Toggle Entity Spawning Settings");
				arachnonSpawning = subscriber.subscribe(builder
				.comment(" Toggle Arachnon Spawning")
				.define("arachnonSpawning", true));
				hellhoundSpawning = subscriber.subscribe(builder
				.comment(" Toggle Hellhound Spawning")
				.define("hellhoundSpawning", true));
				crabSpawning = subscriber.subscribe(builder
				.comment(" Toggle Crab Spawning")
				.define("crabSpawning", true));
				seahorseSpawning = subscriber.subscribe(builder
				.comment(" Toggle Seahorse Spawning")
				.define("seahorseSpawning", true));
				acidicArchvineSpawning = subscriber.subscribe(builder
				.comment(" Toggle Acidic Archvine Spawning")
				.define("acidicArchvineSpawning", true));
				bufflonSpawning = subscriber.subscribe(builder
				.comment(" Toggle Bufflon Spawning")
				.define("bufflonSpawning", true));	
			builder.pop();
			
			builder.comment(" TODO Explain how to use")
			.push("Advanced Entity Spawn Settings");
				builder.push("Arachnon");
					arachnonSpawnBiomes = subscriber.subscribe(builder
					.define("arachnonSpawnBiomes", "minecraft:plains/20/1/1,minecraft:mountains/20/1/1,minecraft:gravelly_mountains/20/1/1"));
					arachnonSpawnBiomesDictionary = subscriber.subscribe(builder
					.define("arachnonSpawnBiomesDictionary", ""));
					arachnonSpawnBiomesBlacklist = subscriber.subscribe(builder
					.define("arachnonSpawnBiomesBlacklist", ""));
				builder.pop();
			builder.pop();
		}
	}
}