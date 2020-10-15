package andrews.pandoras_creatures.objects.blocks;

import java.util.Random;

import andrews.pandoras_creatures.tile_entities.PandoricShardTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.AttachFace;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

public class PandoricShardBlock extends Block  implements IWaterLoggable
{
	protected static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	public static final DirectionProperty HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;
	public static final EnumProperty<AttachFace> FACE = BlockStateProperties.FACE;
	
	public PandoricShardBlock()
	{
		super(getProperties());
		this.setDefaultState(this.stateContainer.getBaseState().with(WATERLOGGED, false).with(FACE, AttachFace.FLOOR).with(HORIZONTAL_FACING, Direction.NORTH));
	}
	
	/**
	 * @return - The properties for this Block
	 */
	private static Properties getProperties()
	{	
		Properties properties = Block.Properties.create(Material.SHULKER);//TODO maybe replace material
		properties.hardnessAndResistance(2.0F);
		properties.harvestTool(ToolType.PICKAXE);
		properties.setLightLevel(value -> 5);
		
		return properties;
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
	{
		return Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);
	}
	
	@Override
	public boolean hasTileEntity(BlockState state)
	{
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world)
	{
		return new PandoricShardTileEntity();
	}
	
	@Override
    public boolean eventReceived(BlockState state, World worldIn, BlockPos pos, int id, int param)
    {
        TileEntity tileentity = worldIn.getTileEntity(pos);
        return tileentity == null ? false : tileentity.receiveClientEvent(id, param);
    }
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context)
	{
		for(Direction direction : context.getNearestLookingDirections())
		{
			FluidState fluidState = context.getWorld().getFluidState(context.getPos());
			if(direction.getAxis() == Direction.Axis.Y)
			{
				return this.getDefaultState().with(FACE, direction == Direction.UP ? AttachFace.CEILING : AttachFace.FLOOR).with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing()).with(WATERLOGGED, fluidState.isTagged(FluidTags.WATER) && fluidState.getLevel() >= 8);
			}
			else
			{
				return this.getDefaultState().with(FACE, AttachFace.WALL).with(HORIZONTAL_FACING, direction.getOpposite()).with(WATERLOGGED, fluidState.isTagged(FluidTags.WATER) && fluidState.getLevel() >= 8);
			}
		}
		return null;
	}
	
	@SuppressWarnings("deprecation")
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
	public FluidState getFluidState(BlockState state)
	{
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : Fluids.EMPTY.getDefaultState();
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
	{
		builder.add(FACE, HORIZONTAL_FACING, WATERLOGGED);
	}
	
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState blockstate, World worldIn, BlockPos pos, Random rand)
	{
		AttachFace face = AttachFace.FLOOR;
		Direction direction = Direction.NORTH;
		if(blockstate.getBlock() instanceof PandoricShardBlock)
		{
			direction = blockstate.get(PandoricShardBlock.HORIZONTAL_FACING);
			face = blockstate.get(PandoricShardBlock.FACE);
		}
		
		if(worldIn.getTileEntity(pos) != null && worldIn.getTileEntity(pos) instanceof PandoricShardTileEntity)
		{
			switch(((PandoricShardTileEntity) worldIn.getTileEntity(pos)).getShardVariant())
			{
			default:
			case 1:
				Vector3d smokeParticlePos = new Vector3d(0.15D, 0.2D, 0.9D);
				smokeParticlePos = determineParticlePosition(smokeParticlePos, face, direction);
				worldIn.addParticle(ParticleTypes.SMOKE, pos.getX() + smokeParticlePos.getX(), pos.getY() + smokeParticlePos.getY(), pos.getZ() + smokeParticlePos.getZ(), 0.0D, 0.0D, 0.0D);
				break;
			case 2:
				Vector3d smokeParticlePos1 = new Vector3d(0.85D, 0.2D, 0.85D);
				smokeParticlePos1 = determineParticlePosition(smokeParticlePos1, face, direction);
				worldIn.addParticle(ParticleTypes.SMOKE, pos.getX() + smokeParticlePos1.getX(), pos.getY() + smokeParticlePos1.getY(), pos.getZ() + smokeParticlePos1.getZ(), 0.0D, 0.0D, 0.0D);
				break;
			case 3:
				Vector3d smokeParticlePos2 = new Vector3d(0.0D, 0.2D, 0.85D);
				smokeParticlePos2 = determineParticlePosition(smokeParticlePos2, face, direction);
				worldIn.addParticle(ParticleTypes.SMOKE, pos.getX() + smokeParticlePos2.getX(), pos.getY() + smokeParticlePos2.getY(), pos.getZ() + smokeParticlePos2.getZ(), 0.0D, 0.0D, 0.0D);
			}
		}
	}
	
	/**
	 * Helper method to determine the particle position on a block that is rotate able
	 */
	private Vector3d determineParticlePosition(Vector3d particlePos, AttachFace face, Direction direction)
	{
		double newX = particlePos.getX();
		double newY = particlePos.getY();
		double newZ = particlePos.getZ();
		
		switch(face)
		{
		default:
		case FLOOR:
			switch(direction)
			{
			default:
			case NORTH:
				break;
			case SOUTH:
				newX = 1D - particlePos.getX();
				newZ = 1D - particlePos.getZ();
				break;
			case WEST:
				newX = particlePos.getZ();
				newZ = 1D - particlePos.getX();
				break;
			case EAST:
				newX = 1D - particlePos.getZ();
				newZ = particlePos.getX();
			}
			break;
		case CEILING:
			switch(direction)
			{
			default:
			case NORTH:
				newY = 1D - particlePos.getY();
				newX = 1D - particlePos.getX();
				break;
			case SOUTH:
				newY = 1D - particlePos.getY();
				newZ = 1D - particlePos.getZ();
				break;
			case WEST:
				newY = 1D - particlePos.getY();
				newX = particlePos.getZ();
				newZ = particlePos.getX();
				break;
			case EAST:
				newY = 1D - particlePos.getY();
				newX = 1D - particlePos.getZ();
				newZ = 1D - particlePos.getX();
			}
			break;
		case WALL:
			switch(direction)
			{
			default:
			case NORTH:
				newY = 1D - particlePos.getZ();
				newX = 1D - particlePos.getX();
				newZ = 1D - particlePos.getY();
				break;
			case SOUTH:
				newY = 1D - particlePos.getZ();
				newX = particlePos.getX();
				newZ = particlePos.getY();
				break;
			case WEST:
				newY = 1D - particlePos.getZ();
				newZ = particlePos.getX();
				newX = 1D - particlePos.getY();
				break;
			case EAST:
				newY = 1D - particlePos.getZ();
				newZ = 1D - particlePos.getX();
				newX = particlePos.getY();
			}
		}
		return new Vector3d(newX, newY, newZ);
	}
}
