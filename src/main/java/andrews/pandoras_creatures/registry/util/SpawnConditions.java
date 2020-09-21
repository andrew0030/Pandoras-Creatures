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
//    	if(world.getDimension().getType() != DimensionType.OVERWORLD) TODO I may not need these checks as mobs wont spawn in other dimensions on their own any ways
//    	{
//    		return false;
//    	}
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
//    	if(world.getDimension().getType() != DimensionType.OVERWORLD) TODO same as above
//    	{
//    		return false;
//    	}
    	else
    	{
    		if(world.getBlockState(pos.down()).getBlock() == Blocks.SAND)
    		{
    			return true;
    		}
    		else
    		{
    			return false;
    		}
    	}
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
//    	if(world.getDimension().getType() != DimensionType.THE_NETHER) TODO same as above
//    	{
//    		return false;
//    	}
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
//    	if(world.getDimension().getType() != DimensionType.OVERWORLD) TODO same as above
//    	{
//    		return false;
//    	}
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
    	
    	//TODO same as above
//    	if(world.getDimension().getType() == DimensionType.OVERWORLD && pos.getY() < 62)
//    	{
//    		return false;
//    	}
//    	if(world.getDimension().getType() == DimensionType.THE_NETHER && pos.getY() < 40)
//    	{
//    		return false;
//    	}
    	if(pos.getY() < 62)
    	{
    		return false;
    	}
    	if(pos.getY() < 40)
    	{
    		return false;
    	}
    	//I created the 2 checks above for temporary use TODO remove them and replace them with the real thing
    	
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
//    	if(world.getDimension().getType() != DimensionType.OVERWORLD) TODO same as above
//    	{
//    		return false;
//    	}
    	else
    	{
    		return world.getLightSubtracted(pos, 0) > 8 && world.getBlockState(pos.down()).getBlock() == Blocks.GRASS_BLOCK;
    	}
    }
}
