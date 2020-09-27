package andrews.pandoras_creatures.registry.util;

import java.util.Random;

import andrews.pandoras_creatures.config.Config;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.IWorld;

public class SpawnConditions
{
	//TODO find a replacement for the system bellow
//	private static Biome[] acidicArchvineBiomesOverworld = {Biomes.JUNGLE, Biomes.JUNGLE_EDGE, Biomes.JUNGLE_HILLS, Biomes.MODIFIED_JUNGLE, Biomes.MODIFIED_JUNGLE_EDGE};
//	private static Biome[] acidicArchvineBiomesNether = {Biomes.NETHER_WASTES, Biomes.CRIMSON_FOREST};
	
	public static boolean noDayLightMobCondition(EntityType<? extends MobEntity> entityType, IWorld world, SpawnReason spawnReason, BlockPos pos, Random random)
    {
		if(!Config.COMMON.arachnonSpawning.get())
		{
			return false;
		}
		if(world.getDifficulty() == Difficulty.PEACEFUL)
		{
			return false;
		}
    	else
    	{
    		if(world.getLight(pos) > 7)
    		{
    			return false;
    		}
    		else
    		{
    			return true;
    		}
    	}
    }
	
	public static boolean amphibianstMobCondition(EntityType<? extends MobEntity> entityType, IWorld world, SpawnReason spawnReason, BlockPos pos, Random random)
    {
		if(!Config.COMMON.crabSpawning.get())
		{
			return false;
		}
		if(world.getBlockState(pos).getBlock() != Blocks.WATER && world.getBlockState(pos).getBlock() != Blocks.AIR)
		{
			return false;
		}
		return world.getBlockState(pos.down()).getBlock().equals(Blocks.SAND);
    }
    
    public static boolean netherCondition(EntityType<? extends MobEntity> entityType, IWorld world, SpawnReason spawnReason, BlockPos pos, Random random)
    {
    	if(!Config.COMMON.hellhoundSpawning.get())
		{
			return false;
		}
    	if(world.getDifficulty() == Difficulty.PEACEFUL)
		{
			return false;
		}
    	else
    	{
    		return true;
    	}
    }
    
    public static boolean waterCondition(EntityType<? extends MobEntity> entityType, IWorld world, SpawnReason spawnReason, BlockPos pos, Random random)
    {
    	if(!Config.COMMON.seahorseSpawning.get())
		{
			return false;
		}
    	else
    	{
    		return true;
    	}
    }
    
    public static boolean acidicArchvineCondition(EntityType<? extends MobEntity> entityType, IWorld world, SpawnReason spawnReason, BlockPos pos, Random random)
    {	
    	if(!Config.COMMON.acidicArchvineSpawning.get())
		{
			return false;
		}
    	if(world.getDifficulty() == Difficulty.PEACEFUL)
		{
			return false;
		}
//    	if(Arrays.asList(acidicArchvineBiomesOverworld).contains(world.getBiome(pos)) && pos.getY() < 62) TODO find a replacement for this
//    	{
//    		return false;
//    	}
//    	if(Arrays.asList(acidicArchvineBiomesNether).contains(world.getBiome(pos)) && pos.getY() < 40)
//    	{
//    		return false;
//    	}
    	if(!world.getBlockState(pos).getBlock().equals(Blocks.AIR))
    	{
    		return false;
    	}
    	if(!(world.getBlockState(pos.up()).getBlock().equals(Blocks.AIR) && (world.getBlockState(pos.up(2)).getBlock().equals(Blocks.JUNGLE_LEAVES) || world.getBlockState(pos.up(2)).getBlock().equals(Blocks.NETHERRACK))))
    	{
    		return false;
    	}
    	//Checks for 8 Air Blocks
    	int airBlocks = 0;
    	for(int i = 0; i < 8; i++)
    	{
    		if(world.getBlockState(pos.down(i)).getBlock().equals(Blocks.AIR))
    		{
    			airBlocks++;
    		}
    		else
    		{
    			airBlocks--;
    		}
    	}
    	if(airBlocks < 8)
    	{
    		return false;
    	}
    	return true;
    }
    
    public static boolean bufflonCondition(EntityType<? extends MobEntity> entityType, IWorld world, SpawnReason spawnReason, BlockPos pos, Random random)
    {
    	if(!Config.COMMON.bufflonSpawning.get())
		{
			return false;
		}
    	else
    	{
    		return world.getLightSubtracted(pos, 0) > 8 && world.getBlockState(pos.down()).getBlock() == Blocks.GRASS_BLOCK;
    	}
    }
}
