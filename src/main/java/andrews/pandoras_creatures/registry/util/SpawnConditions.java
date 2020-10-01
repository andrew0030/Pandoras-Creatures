package andrews.pandoras_creatures.registry.util;

import java.util.Random;
import java.util.Set;

import com.google.common.collect.ImmutableSet;

import andrews.pandoras_creatures.config.PCConfig;
import andrews.pandoras_creatures.util.biome_utils.PCBiomeUtils;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;

public class SpawnConditions
{
	private static final Set<RegistryKey<Biome>> ACIDIC_ARCHVINE_OVERWORLD = ImmutableSet.of(Biomes.JUNGLE, Biomes.JUNGLE_EDGE, Biomes.JUNGLE_HILLS, Biomes.MODIFIED_JUNGLE, Biomes.MODIFIED_JUNGLE_EDGE);
	private static final Set<RegistryKey<Biome>> ACIDIC_ARCHVINE_NETHER = ImmutableSet.of(Biomes.NETHER_WASTES, Biomes.CRIMSON_FOREST);
	
	public static boolean noDayLightMobCondition(EntityType<? extends MobEntity> entityType, IWorld world, SpawnReason spawnReason, BlockPos pos, Random random)
    {
		if(!PCConfig.ValuesHolder.shouldArachnonSpawn())
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
		if(!PCConfig.ValuesHolder.shouldCrabSpawn())
		{
			return false;
		}
		if(!world.isRemote())
		{
			if(PCBiomeUtils.isBiomeEqualTo(Biomes.BEACH, (IServerWorld) world, pos))
			{
				if(pos.getY() > 70)
				{
					return false;
				}
				if(pos.getY() < 56)
				{
					return false;
				}
			}
			if(PCBiomeUtils.isBiomeEqualTo(Biomes.WARM_OCEAN, (IServerWorld) world, pos))
			{
				if(pos.getY() > 60)
				{
					return false;
				}
				if(pos.getY() < 30)
				{
					return false;
				}
			}
		}
		return world.getBlockState(pos.down()).getBlock().equals(Blocks.SAND);
    }
    
    public static boolean netherCondition(EntityType<? extends MobEntity> entityType, IWorld world, SpawnReason spawnReason, BlockPos pos, Random random)
    {
    	if(!PCConfig.ValuesHolder.shouldHellhoundSpawn())
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
    	if(!PCConfig.ValuesHolder.shouldSeahorseSpawn())
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
    	if(!PCConfig.ValuesHolder.shouldAcidicArchvineSpawn())
		{
			return false;
		}
    	if(world.getDifficulty() == Difficulty.PEACEFUL)
		{
			return false;
		}
    	if(!world.isRemote())
    	{
    		if(PCBiomeUtils.isBiomeEqualTo(ACIDIC_ARCHVINE_OVERWORLD, (IServerWorld) world, pos))
    		{
    			if(pos.getY() < 62)
    			{
    				return false;
    			}
    		}
    		if(PCBiomeUtils.isBiomeEqualTo(ACIDIC_ARCHVINE_NETHER, (IServerWorld) world, pos))
    		{
    			if(pos.getY() < 40)
    			{
    				return false;
    			}
    		}
    	}
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
    	if(!PCConfig.ValuesHolder.shouldBufflonSpawn())
		{
			return false;
		}
    	else
    	{
    		return world.getLightSubtracted(pos, 0) > 8 && world.getBlockState(pos.down()).getBlock() == Blocks.GRASS_BLOCK;
    	}
    }
}
