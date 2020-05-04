package andrews.pandoras_creatures.world.features;

public class FeatureDhania// extends Feature<GrassFeatureConfig> TODO EVERYTHING
{	
//	public FeatureDhania(Function<Dynamic<?>, ? extends GrassFeatureConfig> config)
//	{
//		super(config);
//	}
//
//	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, GrassFeatureConfig config)
//	{
//		for(BlockState blockstate = worldIn.getBlockState(pos); (blockstate.getBlock().equals(Blocks.AIR) || blockstate.isIn(BlockTags.LEAVES)) && pos.getY() > 0; blockstate = worldIn.getBlockState(pos))
//		{
//			pos = pos.down();
//		}
//		
//		int i = 0;
//		for(int j = 0; j < 16; ++j)
//		{
//	    	BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
//	        if(worldIn.isAirBlock(blockpos) && config.state.isValidPosition(worldIn, blockpos))
//	        {
//	        	worldIn.setBlockState(blockpos, config.state, 2);
//	        	++i;
//	     	}
//		}
//	  		return i > 0;
//	}
}