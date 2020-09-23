package andrews.pandoras_creatures.objects.blocks;

import java.util.List;

import javax.annotation.Nullable;

import andrews.pandoras_creatures.registry.PCBlocks;
import andrews.pandoras_creatures.tile_entities.EndTrollBoxTileEntity;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.PushReaction;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.OptionalDispenseBehavior;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.DirectionalPlaceContext;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameters;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.util.Constants.NBT;

public class BlockEndTrollBox extends ShulkerBoxBlock implements IWaterLoggable
{
	protected static final VoxelShape FLOOR_AABB = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 14.0D, 15.0D);
	protected static final VoxelShape CEILING_AABB = Block.makeCuboidShape(1.0D, 2.0D, 1.0D, 15.0D, 16.0D, 15.0D);
	protected static final VoxelShape NORTH_AABB = Block.makeCuboidShape(1.0D, 1.0D, 2.0D, 15.0D, 15.0D, 16.0D);
	protected static final VoxelShape SOUTH_AABB = Block.makeCuboidShape(1.0D, 1.0D, 0.0D, 15.0D, 15.0D, 14.0D);
	protected static final VoxelShape WEST_AABB = Block.makeCuboidShape(2.0D, 1.0D, 1.0D, 16.0D, 15.0D, 15.0D);
	protected static final VoxelShape EAST_AABB = Block.makeCuboidShape(0.0D, 1.0D, 1.0D, 14.0D, 15.0D, 15.0D);
	
	protected static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	public static final EnumProperty<Direction> FACING = DirectionalBlock.FACING;
	public static final ResourceLocation location = new ResourceLocation("contents");
	@Nullable
	private final DyeColor color;

	public BlockEndTrollBox(@Nullable DyeColor color)
	{
		super(null, getProperties());
		this.color = color;
		this.setDefaultState(this.stateContainer.getBaseState().with(WATERLOGGED, false).with(FACING, Direction.UP));
	}
	
	/**
	 * @return - The properties for this Block
	 */
	private static Properties getProperties()
	{
		AbstractBlock.IPositionPredicate shouldSuffocate = (state, reader, pos) ->
		{
			TileEntity tileentity = reader.getTileEntity(pos);
			if(!(tileentity instanceof EndTrollBoxTileEntity))
			{
				return true;
			}
			else
			{
				EndTrollBoxTileEntity endTrollBoxTileEntity = (EndTrollBoxTileEntity) tileentity;
				return endTrollBoxTileEntity.isBoxClosed();
			}
		};
		
		Properties properties = Block.Properties.create(Material.SHULKER);
		properties.hardnessAndResistance(2.0F);
		properties.setSuffocates(shouldSuffocate);
		properties.harvestTool(ToolType.PICKAXE);
		
		return properties;
	}
	
	@Override
	public boolean hasTileEntity(BlockState state)
	{
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world)
	{
		return new EndTrollBoxTileEntity(this.color);
	}
	
	@Override
    public boolean eventReceived(BlockState state, World worldIn, BlockPos pos, int id, int param)
    {
        TileEntity tileentity = worldIn.getTileEntity(pos);
        return tileentity == null ? false : tileentity.receiveClientEvent(id, param);
    }

	@Override
	public BlockRenderType getRenderType(BlockState state)
	{
		return BlockRenderType.ENTITYBLOCK_ANIMATED;
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit)
	{
		if(worldIn.isRemote)
		{
			return ActionResultType.SUCCESS;
		}
		else if(player.isSpectator())
		{
			return ActionResultType.SUCCESS;
		}
		else
		{
			TileEntity tileentity = worldIn.getTileEntity(pos);
			if(tileentity instanceof EndTrollBoxTileEntity)
			{
				EndTrollBoxTileEntity endTrollShulkerTileentity = (EndTrollBoxTileEntity) tileentity;
				player.openContainer(endTrollShulkerTileentity);

				return ActionResultType.SUCCESS;
			}
			else
			{
				return ActionResultType.PASS;
			}
		}
	}
	

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context)
	{
		FluidState fluidState = context.getWorld().getFluidState(context.getPos());
		return this.getDefaultState().with(FACING, context.getFace()).with(WATERLOGGED, fluidState.isTagged(FluidTags.WATER) && fluidState.getLevel() >= 8);
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
		builder.add(WATERLOGGED, FACING);
	}

	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player)
	{
		TileEntity tileentity = worldIn.getTileEntity(pos);
		if(tileentity instanceof EndTrollBoxTileEntity)
		{
			EndTrollBoxTileEntity endTrollBoxTileentity = (EndTrollBoxTileEntity) tileentity;
			if(!worldIn.isRemote && player.isCreative() && !endTrollBoxTileentity.isEmpty())
			{
				ItemStack itemstack = getColoredItemStack(this.getColor());
				CompoundNBT compoundnbt = endTrollBoxTileentity.saveToNbt(new CompoundNBT());
				if(!compoundnbt.isEmpty())
				{
					itemstack.setTagInfo("BlockEntityTag", compoundnbt);
				}

				if(endTrollBoxTileentity.hasCustomName())
				{
					itemstack.setDisplayName(endTrollBoxTileentity.getCustomName());
				}

				ItemEntity itementity = new ItemEntity(worldIn, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), itemstack);
				itementity.setDefaultPickupDelay();
				worldIn.addEntity(itementity);
			}
			else
			{
				endTrollBoxTileentity.fillWithLoot(player);
			}
		}
		super.onBlockHarvested(worldIn, pos, state, player);
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder)
	{
		TileEntity tileentity = builder.get(LootParameters.BLOCK_ENTITY);
		if(tileentity instanceof EndTrollBoxTileEntity)
		{
			EndTrollBoxTileEntity endTrollBoxTileentity = (EndTrollBoxTileEntity) tileentity;
			builder = builder.withDynamicDrop(location, (lootContext, consumer) ->
			{
				for(int i = 0; i < endTrollBoxTileentity.getSizeInventory(); ++i)
				{
					consumer.accept(endTrollBoxTileentity.getStackInSlot(i));
				}

			});
		}
		return super.getDrops(state, builder);
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack)
	{
		if(stack.hasDisplayName())
		{
			TileEntity tileentity = worldIn.getTileEntity(pos);
			if(tileentity instanceof EndTrollBoxTileEntity)
			{
				((EndTrollBoxTileEntity) tileentity).setCustomName(stack.getDisplayName());
			}
		}
	}

	@Override
	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving)
	{
		if(state.getBlock() != newState.getBlock())
		{
			TileEntity tileentity = worldIn.getTileEntity(pos);
			if(tileentity instanceof EndTrollBoxTileEntity)
			{
				worldIn.updateComparatorOutputLevel(pos, state.getBlock());
			}
			
			super.onReplaced(state, worldIn, pos, newState, isMoving);
		}
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	{
		CompoundNBT compoundnbt = stack.getChildTag("BlockEntityTag");
		if(compoundnbt != null)
		{
			if(compoundnbt.contains("LootTable", NBT.TAG_STRING))
			{
				tooltip.add(new StringTextComponent("???????"));
			}

			if (compoundnbt.contains("Items", NBT.TAG_LIST))
			{
				NonNullList<ItemStack> nonnulllist = NonNullList.withSize(54, ItemStack.EMPTY);
				ItemStackHelper.loadAllItems(compoundnbt, nonnulllist);
				int i = 0;
				int j = 0;

				for(ItemStack itemstack : nonnulllist)
				{
					if(!itemstack.isEmpty())
					{
						++j;
						if(i <= 4)
						{
							++i;
							IFormattableTextComponent itextcomponent = itemstack.getDisplayName().deepCopy();
							itextcomponent.appendString(" x").appendString(String.valueOf(itemstack.getCount()));
							tooltip.add(itextcomponent);
						}
					}
				}

				if(j - i > 0)
				{
					tooltip.add((new TranslationTextComponent("block." + Reference.MODID + ".end_troll_box.tooltip", j - i)).mergeStyle(TextFormatting.ITALIC));
				}
			}
		}
	}

	@Override
	public PushReaction getPushReaction(BlockState state)
	{
		return PushReaction.DESTROY;
	}

	@Override
	public boolean hasComparatorInputOverride(BlockState state)
	{
		return true;
	}

	@Override
	public int getComparatorInputOverride(BlockState blockState, World worldIn, BlockPos pos)
	{
		return Container.calcRedstoneFromInventory((IInventory) worldIn.getTileEntity(pos));
	}
	
	@Override
	public ItemStack getPickBlock(BlockState state, RayTraceResult target, IBlockReader world, BlockPos pos, PlayerEntity player)
	{
		ItemStack itemstack = new ItemStack(this.getBlock().asItem());
		EndTrollBoxTileEntity endTrollShulkerTileentity = (EndTrollBoxTileEntity) world.getTileEntity(pos);
		CompoundNBT compoundnbt = endTrollShulkerTileentity.saveToNbt(new CompoundNBT());
		if(!compoundnbt.isEmpty())
		{
			itemstack.setTagInfo("BlockEntityTag", compoundnbt);
		}

		return itemstack;
	}

	/**
	 * Gets the color from the given Item.
	 */
	@Nullable
	@OnlyIn(Dist.CLIENT)
	public static DyeColor getColorFromItem(Item itemIn)
	{
		return getColorFromBlock(Block.getBlockFromItem(itemIn));
	}

	/**
	 * Gets the color from the given Block.
	 */
	@Nullable
	@OnlyIn(Dist.CLIENT)
	public static DyeColor getColorFromBlock(Block block)
	{
		if(block instanceof BlockEndTrollBox)
		{
			return ((BlockEndTrollBox) block).getColor();
		}
		return null;
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
	{
		switch((Direction)state.get(FACING))
		{
     		case UP:
     		default:
     			return FLOOR_AABB;
     		case DOWN:
     			return CEILING_AABB;
     		case SOUTH:
     			return SOUTH_AABB;
     		case NORTH:
     			return NORTH_AABB;
     		case EAST:
     			return EAST_AABB;
     		case WEST:
     			return WEST_AABB;
		}
	}

	/**
	 * Get an End TRoll Box variant that depends on the given color.
	 */
	public static Block getBlockByColor(@Nullable DyeColor colorIn)
	{
		if(colorIn == null)
		{
			return PCBlocks.END_TROLL_BOX.get();
		}
		else
		{
			switch(colorIn)
			{
	         case WHITE:
	         default:
	        	 return PCBlocks.WHITE_END_TROLL_BOX.get();
	         case ORANGE:
	        	 return PCBlocks.ORANGE_END_TROLL_BOX.get();
	         case MAGENTA:
	        	 return PCBlocks.MAGENTA_END_TROLL_BOX.get();
	         case LIGHT_BLUE:
	        	 return PCBlocks.LIGHT_BLUE_END_TROLL_BOX.get();
	         case YELLOW:
	        	 return PCBlocks.YELLOW_END_TROLL_BOX.get();
	         case LIME:
	        	 return PCBlocks.LIME_END_TROLL_BOX.get();
	         case PINK:
	        	 return PCBlocks.PINK_END_TROLL_BOX.get();
	         case GRAY:
	        	 return PCBlocks.GRAY_END_TROLL_BOX.get();
	         case LIGHT_GRAY:
	        	 return PCBlocks.LIGHT_GRAY_END_TROLL_BOX.get();
	         case CYAN:
	        	 return PCBlocks.CYAN_END_TROLL_BOX.get();
	         case PURPLE:
	        	 return PCBlocks.PURPLE_END_TROLL_BOX.get();
	         case BLUE:
	        	 return PCBlocks.BLUE_END_TROLL_BOX.get();
	         case BROWN:
	        	 return PCBlocks.BROWN_END_TROLL_BOX.get();
	         case GREEN:
	        	 return PCBlocks.GREEN_END_TROLL_BOX.get();
	         case RED:
	        	 return PCBlocks.RED_END_TROLL_BOX.get();
	         case BLACK:
	        	 return PCBlocks.BLACK_END_TROLL_BOX.get();
			}
		}
	}

	/**
	 * @return - The color of this {@link BlockEndTrollBox}
	 */
	@Nullable
	public DyeColor getColor()
	{
		return this.color;
	}

	/**
	 * Returns a colored ItemStack.
	 */
	public static ItemStack getColoredItemStack(@Nullable DyeColor colorIn)
	{
		return new ItemStack(getBlockByColor(colorIn));
	}
	
	public static class EndTrollBoxDispenseBehavior extends OptionalDispenseBehavior
	{
		@Override
		protected ItemStack dispenseStack(IBlockSource source, ItemStack stack)
		{
			World world = source.getWorld();
			this.setSuccessful(true);
            BlockPos blockpos = source.getBlockPos().offset(source.getBlockState().get(DispenserBlock.FACING));
            BlockState blockstate = world.getBlockState(blockpos);
            if(!blockstate.getMaterial().isReplaceable())
            {
            	this.setSuccessful(false);
            }
            else
            {
            	this.setSuccessful(true);
            }
            
            if(this.isSuccessful())
            {
            	Item item = stack.getItem();
            	Direction direction = source.getBlockState().get(DispenserBlock.FACING);
            	this.setSuccessful(((BlockItem)item).tryPlace(new DirectionalPlaceContext(source.getWorld(), blockpos, direction, stack, direction)) == ActionResultType.SUCCESS);
            }
            
            return stack;
		}
	}
}