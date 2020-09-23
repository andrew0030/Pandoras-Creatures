package andrews.pandoras_creatures.registry.util;

import java.util.List;

import andrews.pandoras_creatures.registry.PCEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;

public class AdvancedSpawnRegistry
{
	public static void registerAdvancedBiomeSpawnEntry(EntityType<?> entity, List<Biome> biomes)
    {
		/*
		 * The Seahorse Spawning
		 */
		if(entity == PCEntities.SEAHORSE.get())
		{
			for(Biome biome : biomes)
			{
				if(biome == Biomes.WARM_OCEAN || biome == Biomes.DEEP_WARM_OCEAN)
				{
					biome.getSpawns(entity.getClassification()).add(new Biome.SpawnListEntry(entity, 25, 3, 6));
				}
				else
				{
					biome.getSpawns(entity.getClassification()).add(new Biome.SpawnListEntry(entity, 10, 2, 3));
				}
			}
		}
		
		/*
		 * The Acidic Archvine Spawning
		 */
		if(entity == PCEntities.ACIDIC_ARCHVINE.get())
		{
			for(Biome biome : biomes)
			{
				if(biome == Biomes.NETHER_WASTES)
				{
					biome.getSpawns(entity.getClassification()).add(new Biome.SpawnListEntry(entity, 30, 1, 1));
				}
				else if(biome == Biomes.CRIMSON_FOREST)
				{
					biome.getSpawns(entity.getClassification()).add(new Biome.SpawnListEntry(entity, 15, 1, 1));
				}
				else
				{
					biome.getSpawns(entity.getClassification()).add(new Biome.SpawnListEntry(entity, 110, 1, 1));
				}
			}
		}
    }
}
