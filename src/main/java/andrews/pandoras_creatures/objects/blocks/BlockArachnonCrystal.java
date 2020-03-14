package andrews.pandoras_creatures.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFaceBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.AttachFace;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

public class BlockArachnonCrystal extends HorizontalFaceBlock implements IWaterLoggable
{	
	protected static final VoxelShape CRYSTAL_NORTH_AABB = Block.makeCuboidShape(4.0D, 4.0D, 7.0D, 12.0D, 12.0D, 16.0D);
	protected static final VoxelShape CRYSTAL_SOUTH_AABB = Block.makeCuboidShape(4.0D, 4.0D, 0.0D, 12.0D, 12.0D, 9.0D);
	protected static final VoxelShape CRYSTAL_WEST_AABB = Block.makeCuboidShape(7.0D, 4.0D, 4.0D, 16.0D, 12.0D, 12.0D);
	protected static final VoxelShape CRYSTAL_EAST_AABB = Block.makeCuboidShape(0.0D, 4.0D, 4.0D, 9.0D, 12.0D, 12.0D);
	protected static final VoxelShape FLOOR_Z_SHAPE = Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 9.0D, 12.0D);
	protected static final VoxelShape FLOOR_X_SHAPE = Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 9.0D, 12.0D);
	protected static final VoxelShape CEILING_Z_SHAPE = Block.makeCuboidShape(4.0D, 7.0D, 4.0D, 12.0D, 16.0D, 12.0D);
	protected static final VoxelShape CEILING_X_SHAPE = Block.makeCuboidShape(4.0D, 7.0D, 4.0D, 12.0D, 16.0D, 12.0D);
	
	protected static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	
	public BlockArachnonCrystal()
	{
		super(getProperties());
		this.setDefaultState(this.stateContainer.getBaseState().with(WATERLOGGED, false).with(HORIZONTAL_FACING, Direction.NORTH).with(FACE, AttachFace.WALL));
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
	public BlockState getStateForPlacement(BlockItemUseContext context)
	{
		for(Direction direction : context.getNearestLookingDirections())
		{
			IFluidState fluidState = context.getWorld().getFluidState(context.getPos());
			BlockState blockstate;
			if(direction.getAxis() == Direction.Axis.Y)
			{
				blockstate = this.getDefaultState().with(FACE, direction == Direction.UP ? AttachFace.CEILING : AttachFace.FLOOR).with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing()).with(WATERLOGGED, fluidState.isTagged(FluidTags.WATER) && fluidState.getLevel() >= 8);
			}
			else
			{
				blockstate = this.getDefaultState().with(FACE, AttachFace.WALL).with(HORIZONTAL_FACING, direction.getOpposite()).with(WATERLOGGED, fluidState.isTagged(FluidTags.WATER) && fluidState.getLevel() >= 8);
			}

			if(blockstate.isValidPosition(context.getWorld(), context.getPos()))
			{
				return blockstate;
			}
		}
		return null;
	}
	
	@Override
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld world, BlockPos currentPos, BlockPos facingPos)
	{
		if(state.get(WATERLOGGED))
		{
			world.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(world));
		}
		return super.updatePostPlacement(state, facing, facingState, world, currentPos, facingPos);
	}
	
	@Override
	public IFluidState getFluidState(BlockState state)
	{
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : Fluids.EMPTY.getDefaultState();
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
		builder.add(FACE, HORIZONTAL_FACING, WATERLOGGED);
	}
	
	@Override
	public BlockRenderLayer getRenderLayer()
	{
		return BlockRenderLayer.CUTOUT;
	}
}
