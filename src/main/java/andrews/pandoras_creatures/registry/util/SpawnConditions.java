package andrews.pandoras_creatures.registry.util;

import java.util.Random;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.dimension.DimensionType;

public class SpawnConditions
{
	public static boolean noDayLightMobCondition(EntityType<? extends MobEntity> entityType, IWorld world, SpawnReason spawnReason, BlockPos pos, Random random)
    {
    	if(world.getDimension().getType() != DimensionType.OVERWORLD)
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
    	if(world.getDimension().getType() != DimensionType.OVERWORLD)
    	{
    		return false;
    	}
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
    	if(world.getDimension().getType() != DimensionType.THE_NETHER)
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
    	if(world.getDimension().getType() != DimensionType.OVERWORLD)
    	{
    		return false;
    	}
    	else
    	{
    		return true;
    	}
    }
}
