package andrews.pandoras_creatures.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFaceBlock;
import net.minecraft.block.material.Material;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.AttachFace;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class BlockArachnonCrystal extends HorizontalFaceBlock
{	
	protected static final VoxelShape CRYSTAL_NORTH_AABB = Block.makeCuboidShape(4.0D, 4.0D, 7.0D, 12.0D, 12.0D, 16.0D);
	protected static final VoxelShape CRYSTAL_SOUTH_AABB = Block.makeCuboidShape(4.0D, 4.0D, 0.0D, 12.0D, 12.0D, 9.0D);
	protected static final VoxelShape CRYSTAL_WEST_AABB = Block.makeCuboidShape(7.0D, 4.0D, 4.0D, 16.0D, 12.0D, 12.0D);
	protected static final VoxelShape CRYSTAL_EAST_AABB = Block.makeCuboidShape(0.0D, 4.0D, 4.0D, 9.0D, 12.0D, 12.0D);
	protected static final VoxelShape FLOOR_Z_SHAPE = Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 9.0D, 12.0D);
	protected static final VoxelShape FLOOR_X_SHAPE = Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 9.0D, 12.0D);
	protected static final VoxelShape CEILING_Z_SHAPE = Block.makeCuboidShape(4.0D, 7.0D, 4.0D, 12.0D, 16.0D, 12.0D);
	protected static final VoxelShape CEILING_X_SHAPE = Block.makeCuboidShape(4.0D, 7.0D, 4.0D, 12.0D, 16.0D, 12.0D);
	
	public BlockArachnonCrystal()
	{
		super(getProperties());
		this.setDefaultState(this.stateContainer.getBaseState().with(HORIZONTAL_FACING, Direction.NORTH).with(FACE, AttachFace.WALL));
	}

	/**
	 * @return - The properties for this Block
	 */
	private static Properties getProperties()
	{
		Properties properties = Block.Properties.create(Material.ROCK);
		properties.hardnessAndResistance(1.5F, 6.0F);
		properties.lightValue(9);
		
		return properties;
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
	{
		switch((AttachFace)state.get(FACE))
		{
		case FLOOR:
			switch(state.get(HORIZONTAL_FACING).getAxis())
			{
				case X:
					return FLOOR_X_SHAPE;
				case Z:
				default:
					return FLOOR_Z_SHAPE;
			}
		case WALL:
			switch((Direction)state.get(HORIZONTAL_FACING))
			{
	     		case EAST:
	     			return CRYSTAL_EAST_AABB;
	     		case WEST:
	     			return CRYSTAL_WEST_AABB;
	     		case SOUTH:
	     			return CRYSTAL_SOUTH_AABB;
	     		case NORTH:
	     		default:
	     			return CRYSTAL_NORTH_AABB;
			}
		case CEILING:
		default:
			switch(state.get(HORIZONTAL_FACING).getAxis())
			{
				case X:
					return CEILING_X_SHAPE;
				case Z:
				default:
					return CEILING_Z_SHAPE;
			}
		}
	}
	
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
	{
		builder.add(FACE, HORIZONTAL_FACING);
	}
	
	@Override
	public BlockRenderLayer getRenderLayer()
	{
		return BlockRenderLayer.CUTOUT;
	}
}
