package andrews.pandoras_creatures.util.biome_utils;

import java.util.Optional;
import java.util.Set;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.biome.Biome;

public class PCBiomeUtils
{
	/**
	 * Helper method to determine if the Biome at the given BlockPos is equal to the specified Biome
	 * @param biome - The Biome that will be checked for, at the BlockPos
	 * @param world - The ServerWorld
	 * @param pos - The BlockPos to check for the Biome
	 * @return - Whether or not the Biome at the BlockPos matches the specified Biome
	 */
	public static boolean isBiomeEqualTo(RegistryKey<Biome> biome, IServerWorld world, BlockPos pos)
	{
		Optional<RegistryKey<Biome>> optional = world.func_241828_r().getRegistry(Registry.BIOME_KEY).getOptionalKey(world.getBiome(pos));
		
		if(optional.isPresent())
		{
			return optional.get().equals(biome);
		}
		return false;
	}

	/**
	 * Helper method to determine if the Biome at the given BlockPos is equal to one of the Biomes in the given Biome List
	 * @param biomeList - The Biome List that contains the Biomes that should be checked for, at the BlockPos
	 * @param world - The ServerWorld
	 * @param pos - The BlockPos to check for the Biome
	 * @return - Whether or not the Biome at the given BlockPos matches one of the Biomes in the List
	 */
	public static boolean isBiomeEqualTo(Set<RegistryKey<Biome>> biomeList, IServerWorld world, BlockPos pos)
	{
		Optional<RegistryKey<Biome>> optional = world.func_241828_r().getRegistry(Registry.BIOME_KEY).getOptionalKey(world.getBiome(pos));
		
		if(optional.isPresent())
		{
			return biomeList.contains(optional.get());
		}
		return false;
	}
}
