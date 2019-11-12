package andrews.pandoras_creatures.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.IPlantable;

public class PCBlockBush extends Block implements IPlantable
{
	protected static final VoxelShape BOX = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 14.0D, 14.0D);
	
	public PCBlockBush()
	{
		super(getProperties());
	}

	private static Properties getProperties()
	{
		Properties properties = Block.Properties.create(Material.PLANTS);
		properties.sound(SoundType.PLANT);
		
		return properties;
	}
	
	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos)
	{
		BlockPos blockpos = pos.down();
		if(state.getBlock() == this)//Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
		{
	    	return worldIn.getBlockState(blockpos).canSustainPlant(worldIn, blockpos, Direction.UP, this);
		}
		return this.isValidGround(worldIn.getBlockState(blockpos), worldIn, blockpos);
	}
	
	private boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos)
	{
		Block block = state.getBlock();
		return block == Blocks.GRASS_BLOCK || block == Blocks.DIRT || block == Blocks.COARSE_DIRT || block == Blocks.PODZOL || block == Blocks.FARMLAND;
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
	{
		return BOX;
	}
	
	@Override
	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
	{
		return VoxelShapes.empty();
	}
	
	/**
	 * Gets the render layer this block will render on. SOLID for solid blocks, CUTOUT or CUTOUT_MIPPED for on-off
	 * transparency (glass, reeds), TRANSLUCENT for fully blended transparency (stained glass)
	 */
	@Override
	public BlockRenderLayer getRenderLayer()
	{
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos)
	{
		return true;
	}

	@Override
	public BlockState getPlant(IBlockReader world, BlockPos pos)
	{
		BlockState state = world.getBlockState(pos);
		if (state.getBlock() != this) 
		{
			return getDefaultState();
		}
	   	return state;
	}
}
