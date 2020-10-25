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
		public ConfigValueListener<Boolean> isDebugModeEnabled;
		
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
			isDebugModeEnabled = subscriber.subscribe(builder
			.comment(" Enable debug mode to print out all the information about Mobs being added to Biomes")
			.define("isDebugModeEnabled", false));
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
			
			builder.comment(" Tutorial on how to use the Advanced Entity Spawn Settings:"
					   +"\r\n Lets start by explaining what each value does, and how to properly use it."
					   +"\r\n"
					   +"\r\n entitySpawnBiomes - This is a list that allows adding Biomes to Mobs one by one, and to have different spawn values for each"
					   +"\r\n entry. This option is ideal to add Mobs to a small amount of Biomes or to fine tune the spawn values, as it has priority over the"
					   +"\r\n dictionary system (more on that later). The way you add a Biome to a Mob is by first writing the Biome id, for example:"
					   +"\r\n \"minecraft:plains\" or \"minecraft:flower_forest\" or \"epicmod:cool_biome\". Afterwards you have to write 3 values that are separated"
					   +"\r\n with a \" / \", these values represent \"Weight\", \"MinSpawns\" and \"MaxSpawns\". Here are a few examples:"
					   +"\r\n \"minecraft:warped_forest/30/2/5\" or \"minecraft:birch_forest/14/1/3\" or \"epic_mod:cool_biome/40/2/7\""
					   +"\r\n The way you add multiple Biomes is to separate them with a \" , \" here is an example:"
					   +"\r\n entitySpawnBiomes = \"minecraft:warped_forest/30/2/5,minecraft:flower_forest/50/2/8,epic_mod:cool_biome/40/2/7\""
					   +"\r\n"
					   +"\r\n Weight - This value is used to determine how likely it is for the entity to be picked in the spawn process, note that having a big"
					   +"\r\n value doesn't mean more will spawn, it just increases the chance for it to spawn. Also try to avoid using really big values as it could"
					   +"\r\n affect the spawn rates of other Mobs."
					   +"\r\n"
					   +"\r\n MinSpawns - This value is used to determine, how many Mobs will be attempted to be spawned in a cluster. An example of this"
					   +"\r\n would be a cluster of horses in a plains Biome. Note that this affects the attempts, meaning even if the value is set to 8, it may still"
					   +"\r\n only spawn 3 if the terrain does not allow for 8 to be spawned."
					   +"\r\n"
					   +"\r\n MaxSpawns - This is the counter part to MinSpawns, it is used to create a random range of spawn attempts between MinSpawns"
					   +"\r\n and MaxSpawns. Note you may enter the same value into MinSpawns and MaxSpawns but DO NOT enter a smaller value into"
					   +"\r\n MaxSpawns"
					   +"\r\n"
					   +"\r\n entityDictionaryTags - This is a list of BiomeDictionaryTags that allows adding a Mob to a huge amount of Biomes easily. Keep in"
					   +"\r\n mind that Biomes added by other mods, need to support BiomeDictionary for them to be detected/In the list. The way this is used is"
					   +"\r\n to write the Tags and to separate them with a \" , \" here is an example: entityDictionaryTags = \"FOREST,PLAINS\""
					   +"\r\n This would add the entity to all Biomes marked as a FOREST or as a PLAINS Biome, using the spawn values found in the"
					   +"\r\n Dictionary section of the Mobs spawn config. The 3 values are the same as the ones described above, the only difference being"
					   +"\r\n that you can not have different spawn values between the Biomes the Mob gets added to through the DictionarySystem. If you"
					   +"\r\n would prefer different values for a certain Biome, simply add it to the \"entitySpawnBiomes\" list with the values you want it to have."
					   +"\r\n The \"entitySpawnBiomes\" list has priority over the Dictionary system, meaning the values in it, will get picked instead of the ones"
					   +"\r\n from the Dictionary system. Here is a list of all the Tags you can use:"
					   +"\r\n HOT, COLD, SPARSE, DENSE, WET, DRY, SAVANNA, CONIFEROUS, JUNGLE, SPOOKY, DEAD, LUSH, MUSHROOM, MAGICAL,"
					   +"\r\n RARE, PLATEAU, MODIFIED, OCEAN, RIVER, WATER, MESA, FOREST, PLAINS, MOUNTAIN, HILLS, SWAMP, SANDY, SNOWY,"
					   +"\r\n WASTELAND, BEACH, VOID, OVERWORLD, NETHER, END"
					   +"\r\n"
					   +"\r\n entityDictionaryBiomeBlacklist - This is a list of Biomes used to remove said Biomes from the list of Biomes added by the Dictionary"
					   +"\r\n system. The way this would be used is to simply write the Biome names and to separate them with a \" , \" here is an example:"
					   +"\r\n entityDictionaryBiomeBlacklist  = \"minecraft:river,minecraft:plains,epic_mod:cool_biome\""
					   +"\r\n You can use this list to remove the entity from certain Biomes it may have been added to by the Dictionary system, for an example"
					   +"\r\n if you have added the Mob to all End Biomes but you don't want it  to spawn in the center, you could just exclude that Biome"
					   +"\r\n through using this list. Note that this will only affect the Dictionary system, it will not remove Biomes from the \"entitySpawnBiomes\""
					   +"\r\n"
					   +"\r\n If you have any questions, feel free to ask for help on my Discord server"
					   +"\r\n")
			.push("Advanced");
				builder.push("Arachnon");
					arachnonSpawnBiomes = subscriber.subscribe(builder
					.define("arachnonSpawnBiomes", "minecraft:plains/20/1/1,minecraft:mountains/20/1/1,minecraft:gravelly_mountains/20/1/1"));
					arachnonDictionaryBiomeBlacklist = subscriber.subscribe(builder
					.define("arachnonDictionaryBiomeBlacklist", ""));
					arachnonDictionaryTags = subscriber.subscribe(builder
					.define("arachnonDictionaryTags", ""));
					builder.push("Dictionary");
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