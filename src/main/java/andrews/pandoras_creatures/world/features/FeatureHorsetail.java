package andrews.pandoras_creatures.world.features;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.GrassFeatureConfig;

public class FeatureHorsetail extends Feature<GrassFeatureConfig>
{	
	public FeatureHorsetail(Function<Dynamic<?>, ? extends GrassFeatureConfig> config)
	{
		super(config);
	}

	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, GrassFeatureConfig config)
	{
		int i = 0;
		BlockState blockstate = config.state;

	  	for(int j = 0; j < 64; ++j)
	  	{
	  		BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
	        if(worldIn.isAirBlock(blockpos) && (!worldIn.getDimension().isNether() || blockpos.getY() < worldIn.getWorld().getDimension().getHeight()) && blockstate.isValidPosition(worldIn, blockpos))
	        {
	            worldIn.setBlockState(blockpos, blockstate, 2);
	            ++i;
	        }
	  	}
	  	return i > 0;
	}
}