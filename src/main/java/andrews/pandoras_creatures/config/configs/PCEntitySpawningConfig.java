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
		public ConfigValueListener<String> arachnonDictionaryBiomeBlacklist;
		public ConfigValueListener<String> arachnonDictionaryTags;
		public ConfigValueListener<Integer> arachnonDictionaryWeight;
		public ConfigValueListener<Integer> arachnonDictionaryMinSpawns;
		public ConfigValueListener<Integer> arachnonDictionaryMaxSpawns;

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
			.push("Advanced");
				builder.push("Arachnon");
					arachnonSpawnBiomes = subscriber.subscribe(builder
					.define("arachnonSpawnBiomes", "minecraft:plains/20/1/1,minecraft:mountains/20/1/1,minecraft:gravelly_mountains/20/1/1"));
					arachnonDictionaryBiomeBlacklist = subscriber.subscribe(builder
					.define("arachnonDictionaryBiomeBlacklist", ""));
					builder.push("Dictionary");
						arachnonDictionaryTags = subscriber.subscribe(builder
						.define("arachnonDictionaryTags", "FOREST"));//TODO remove
						arachnonDictionaryWeight = subscriber.subscribe(builder
						.defineInRange("arachnonDictionaryWeight", 20, 1, 1000));
						arachnonDictionaryMinSpawns = subscriber.subscribe(builder
						.defineInRange("arachnonDictionaryMinSpawns", 1, 1, 100));
						arachnonDictionaryMaxSpawns = subscriber.subscribe(builder
						.defineInRange("arachnonDictionaryMaxSpawns", 1, 1, 100));
				builder.pop();
			builder.pop();
		}
	}
}