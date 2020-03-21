package andrews.pandoras_creatures.objects.blocks;

import java.util.List;

import javax.annotation.Nullable;

import andrews.pandoras_creatures.registry.PCBlocks;
import andrews.pandoras_creatures.tile_entities.EndTrollBoxTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.PushReaction;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootParameters;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.Constants.NBT;

public class BlockEndTrollBox extends Block
{
	public static final EnumProperty<Direction> FACING = DirectionalBlock.FACING;
	public static final ResourceLocation field_220169_b = new ResourceLocation("contents");
	@Nullable
	private final DyeColor color;

	public BlockEndTrollBox(@Nullable DyeColor color)
	{
		super(getProperties());
		this.color = color;
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.UP));
	}
	
	/**
	 * @return - The properties for this Block
	 */
	private static Properties getProperties()
	{
		Properties properties = Block.Properties.create(Material.SHULKER);
		properties.hardnessAndResistance(2.0F, 6.0F);
		
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
	public boolean causesSuffocation(BlockState state, IBlockReader worldIn, BlockPos pos)
	{
		return true;
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public boolean hasCustomBreakingProgress(BlockState state)
	{
		return true;
	}

	@Override
	public BlockRenderType getRenderType(BlockState state)
	{
		return BlockRenderType.ENTITYBLOCK_ANIMATED;
	}

	@Override
	public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit)
	{
		if(worldIn.isRemote)
		{
			return true;
		}
		else if(player.isSpectator())
		{
			return true;
		}
		else
		{
			TileEntity tileentity = worldIn.getTileEntity(pos);
			if(tileentity instanceof EndTrollBoxTileEntity)
			{
				EndTrollBoxTileEntity endTrollShulkerTileentity = (EndTrollBoxTileEntity) tileentity;
				player.openContainer(endTrollShulkerTileentity);
				player.addStat(Stats.OPEN_SHULKER_BOX); //TODO maybe replace with a End Troll Box stat

				return true;
			}
			else
			{
				return false;
			}
		}
	}
	

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context)
	{
		return this.getDefaultState().with(FACING, context.getFace());
	}

	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder)
	{
		builder.add(FACING);
	}

	/**
	 * Called before the Block is set to air in the world. Called regardless of if
	 * the player's tool can actually collect this block
	 */
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player)
	{
		TileEntity tileentity = worldIn.getTileEntity(pos);
		if(tileentity instanceof EndTrollBoxTileEntity)
		{
			EndTrollBoxTileEntity endTrollShulkerTileentity = (EndTrollBoxTileEntity) tileentity;
			if(!worldIn.isRemote && player.isCreative() && !endTrollShulkerTileentity.isEmpty())
			{
				ItemStack itemstack = getColoredItemStack(this.getColor());
				CompoundNBT compoundnbt = endTrollShulkerTileentity.saveToNbt(new CompoundNBT());
				if(!compoundnbt.isEmpty())
				{
					itemstack.setTagInfo("BlockEntityTag", compoundnbt);
				}

				if(endTrollShulkerTileentity.hasCustomName())
				{
					itemstack.setDisplayName(endTrollShulkerTileentity.getCustomName());
				}

				ItemEntity itementity = new ItemEntity(worldIn, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), itemstack);
				itementity.setDefaultPickupDelay();
				worldIn.addEntity(itementity);
			}
			else
			{
				endTrollShulkerTileentity.fillWithLoot(player);
			}
		}

		super.onBlockHarvested(worldIn, pos, state, player);
	}

	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder)
	{
		TileEntity tileentity = builder.get(LootParameters.BLOCK_ENTITY);
		if(tileentity instanceof EndTrollBoxTileEntity)
		{
			EndTrollBoxTileEntity endTrollShulkerTileentity = (EndTrollBoxTileEntity) tileentity;
			builder = builder.withDynamicDrop(field_220169_b, (p_220168_1_, p_220168_2_) ->
			{
				for(int i = 0; i < endTrollShulkerTileentity.getSizeInventory(); ++i)
				{
					p_220168_2_.accept(endTrollShulkerTileentity.getStackInSlot(i));
				}

			});
		}

		return super.getDrops(state, builder);
	}

	/**
	 * Called by ItemBlocks after a block is set in the world, to allow post-place
	 * logic
	 */
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
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	{
		super.addInformation(stack, worldIn, tooltip, flagIn);
		CompoundNBT compoundnbt = stack.getChildTag("BlockEntityTag");
		if(compoundnbt != null)
		{
			if(compoundnbt.contains("LootTable", NBT.TAG_STRING))
			{
				tooltip.add(new StringTextComponent("???????"));
			}

			if (compoundnbt.contains("Items", NBT.TAG_LIST))
			{
				NonNullList<ItemStack> nonnulllist = NonNullList.withSize(27, ItemStack.EMPTY);
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
							ITextComponent itextcomponent = itemstack.getDisplayName().deepCopy();
							itextcomponent.appendText(" x").appendText(String.valueOf(itemstack.getCount()));
							tooltip.add(itextcomponent);
						}
					}
				}

				if(j - i > 0)
				{
					tooltip.add((new TranslationTextComponent("container.shulkerBox.more", j - i)).applyTextStyle(TextFormatting.ITALIC));
				}
			}
		}
	}

	/**
	 * @deprecated call via {@link IBlockState#getMobilityFlag()} whenever possible.
	 *             Implementing/overriding is fine.
	 */
	public PushReaction getPushReaction(BlockState state)
	{
		return PushReaction.DESTROY;
	}

	public boolean isSolid(BlockState state)
	{
		return false;
	}

	/**
	 * @deprecated call via {@link IBlockState#hasComparatorInputOverride()}
	 *             whenever possible. Implementing/overriding is fine.
	 */
	public boolean hasComparatorInputOverride(BlockState state)
	{
		return true;
	}

	/**
	 * @deprecated call via
	 *             {@link IBlockState#getComparatorInputOverride(World,BlockPos)}
	 *             whenever possible. Implementing/overriding is fine.
	 */
	public int getComparatorInputOverride(BlockState blockState, World worldIn, BlockPos pos)
	{
		return Container.calcRedstoneFromInventory((IInventory) worldIn.getTileEntity(pos));
	}
	
	@Override
	public ItemStack getPickBlock(BlockState state, RayTraceResult target, IBlockReader world, BlockPos pos, PlayerEntity player)
	{
		ItemStack itemstack = super.getPickBlock(state, target, world, pos, player);
		EndTrollBoxTileEntity endTrollShulkerTileentity = (EndTrollBoxTileEntity) world.getTileEntity(pos);
		CompoundNBT compoundnbt = endTrollShulkerTileentity.saveToNbt(new CompoundNBT());
		if(!compoundnbt.isEmpty())
		{
			itemstack.setTagInfo("BlockEntityTag", compoundnbt);
		}

		return itemstack;
	}

	@Nullable
	@OnlyIn(Dist.CLIENT)
	public static DyeColor getColorFromItem(Item itemIn)
	{
		return getColorFromBlock(Block.getBlockFromItem(itemIn));
	}

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

	@Nullable
	public DyeColor getColor()
	{
		return this.color;
	}

	public static ItemStack getColoredItemStack(@Nullable DyeColor colorIn)
	{
		return new ItemStack(getBlockByColor(colorIn));
	}

	/**
	 * Returns the blockstate with the given rotation from the passed blockstate. If
	 * inapplicable, returns the passed blockstate.
	 * 
	 * @deprecated call via {@link IBlockState#withRotation(Rotation)} whenever
	 *             possible. Implementing/overriding is fine.
	 */
	public BlockState rotate(BlockState state, Rotation rot)
	{
		return state.with(FACING, rot.rotate(state.get(FACING)));
	}

	/**
	 * Returns the blockstate with the given mirror of the passed blockstate. If
	 * inapplicable, returns the passed blockstate.
	 * 
	 * @deprecated call via {@link IBlockState#withMirror(Mirror)} whenever
	 *             possible. Implementing/overriding is fine.
	 */
	public BlockState mirror(BlockState state, Mirror mirrorIn)
	{
		return state.rotate(mirrorIn.toRotation(state.get(FACING)));
	}
}