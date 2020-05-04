package andrews.pandoras_creatures.tile_entities;

import java.util.stream.IntStream;

import javax.annotation.Nullable;

import andrews.pandoras_creatures.container.EndTrollBoxContainer;
import andrews.pandoras_creatures.objects.blocks.BlockEndTrollBox;
import andrews.pandoras_creatures.registry.PCTileEntities;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.Constants.NBT;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;

public class EndTrollBoxTileEntity extends LockableLootTileEntity implements ISidedInventory, ITickableTileEntity
{
	private static final int[] SLOTS = IntStream.range(0, 54).toArray();
	private NonNullList<ItemStack> items = NonNullList.withSize(54, ItemStack.EMPTY);
	private int openCount;
	public EndTrollBoxTileEntity.AnimationStatus animationStatus = EndTrollBoxTileEntity.AnimationStatus.CLOSED;
	private float progress;
	private float progressOld;
	private DyeColor color;
	private boolean needsColorFromWorld;
	
	public EndTrollBoxTileEntity(@Nullable DyeColor colorIn)
	{
		super(PCTileEntities.END_TROLL_BOX.get());
		this.color = colorIn;
	}

	public EndTrollBoxTileEntity()
	{
		this((DyeColor) null);
		this.needsColorFromWorld = true;
	}

	@Override
	public void tick()
	{
		this.updateAnimation();
	}

	/**
	 * Handles all the Animation progression logic.
	 */
	protected void updateAnimation()
	{
		this.progressOld = this.progress;
		switch(this.animationStatus)
		{
		case CLOSED:
			this.progress = 0.0F;
			break;
		case OPENING:
			this.progress += 0.1F;
			if(this.progress >= 1.0F)
			{
				this.animationStatus = EndTrollBoxTileEntity.AnimationStatus.OPENED;
				this.progress = 1.0F;
				this.updateSurroundingBlocks();
			}
			break;
		case CLOSING:
			this.progress -= 0.1F;
			if(this.progress <= 0.0F)
			{
				this.animationStatus = EndTrollBoxTileEntity.AnimationStatus.CLOSED;
				this.progress = 0.0F;
				this.updateSurroundingBlocks();
			}
			break;
		case OPENED:
			this.progress = 1.0F;
		}
	}

	/**
	 * @return The current Animation Status of the Box
	 */
	public EndTrollBoxTileEntity.AnimationStatus getAnimationStatus()
	{
		return this.animationStatus;
	}

	@Override
	public int getSizeInventory()
	{
		return this.items.size();
	}
	
	@Override
	public boolean receiveClientEvent(int id, int type)
	{
		if(id == 1)
		{
			this.openCount = type;
			if(type == 0)
			{
				this.animationStatus = EndTrollBoxTileEntity.AnimationStatus.CLOSING;
				this.updateSurroundingBlocks();
			}

			if(type == 1)
			{
				this.animationStatus = EndTrollBoxTileEntity.AnimationStatus.OPENING;
				this.updateSurroundingBlocks();
			}

			return true;
		}
		else
		{
			return super.receiveClientEvent(id, type);
		}
	}

	@Override
	public void openInventory(PlayerEntity player)
	{
		if(!player.isSpectator())
		{
			if(this.openCount < 0)
			{
				this.openCount = 0;
			}

			++this.openCount;
			this.world.addBlockEvent(this.pos, this.getBlockState().getBlock(), 1, this.openCount);
			if(this.openCount == 1)
			{
				this.world.playSound((PlayerEntity) null, this.pos, SoundEvents.BLOCK_SHULKER_BOX_OPEN, SoundCategory.BLOCKS, 0.5F, this.world.rand.nextFloat() * 0.1F + 0.9F);
			}
		}
	}

	@Override
	public void closeInventory(PlayerEntity player)
	{
		if(!player.isSpectator())
		{
			--this.openCount;
			this.world.addBlockEvent(this.pos, this.getBlockState().getBlock(), 1, this.openCount);
			if(this.openCount <= 0)
			{
				this.world.playSound((PlayerEntity) null, this.pos, SoundEvents.BLOCK_SHULKER_BOX_CLOSE, SoundCategory.BLOCKS, 0.5F, this.world.rand.nextFloat() * 0.1F + 0.9F);
			}
		}
	}
	
	/**
	 * Makes surrounding Blocks potentially update their state if needed.
	 */
	private void updateSurroundingBlocks()
	{
		this.getBlockState().updateNeighbors(this.getWorld(), this.getPos(), 3);
	}

	@Override
	protected ITextComponent getDefaultName()
	{
		return new TranslationTextComponent("container." + Reference.MODID + ".end_troll_box");
	}

	@Override
	public void read(CompoundNBT compound)
	{
		super.read(compound);
		this.loadFromNbt(compound);
	}

	@Override
	public CompoundNBT write(CompoundNBT compound)
	{
		super.write(compound);
		return this.saveToNbt(compound);
	}

	/**
	 * Handles all the loading from NBT.
	 */
	public void loadFromNbt(CompoundNBT compound)
	{
		this.items = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
		if(!this.checkLootAndRead(compound) && compound.contains("Items", NBT.TAG_LIST))
		{
			ItemStackHelper.loadAllItems(compound, this.items);
		}
	}

	/**
	 * Handles all the saving to NBT.
	 */
	public CompoundNBT saveToNbt(CompoundNBT compound)
	{
		if(!this.checkLootAndWrite(compound))
		{
			ItemStackHelper.saveAllItems(compound, this.items, false);
		}

		return compound;
	}

	@Override
	protected NonNullList<ItemStack> getItems()
	{
		return this.items;
	}

	@Override
	protected void setItems(NonNullList<ItemStack> itemsIn)
	{
		this.items = itemsIn;
	}

	@Override
	public boolean isEmpty()
	{
		for(ItemStack itemstack : this.items)
		{
			if(!itemstack.isEmpty())
			{
				return false;
			}
		}

		return true;
	}

	@Override
	public int[] getSlotsForFace(Direction side)
	{
		return SLOTS;
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, Direction direction)
	{
		if(Block.getBlockFromItem(itemStackIn.getItem()) instanceof ShulkerBoxBlock)
		{
			return false;
		}
		else if(Block.getBlockFromItem(itemStackIn.getItem()) instanceof BlockEndTrollBox)
		{
			return false;
		}
		return true;
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, Direction direction)
	{
		return true;
	}

	/**
	 * Gets the Animation progress.
	 */
	public float getProgress(float progressStart)
	{
		return MathHelper.lerp(progressStart, this.progressOld, this.progress);
	}

	/**
	 * A getter for the Color.
	 */
	@OnlyIn(Dist.CLIENT)
	public DyeColor getColor()
	{
		if(this.needsColorFromWorld)
		{
			this.color = BlockEndTrollBox.getColorFromBlock(this.getBlockState().getBlock());
			this.needsColorFromWorld = false;
		}

		return this.color;
	}

	@Override
	protected Container createMenu(int id, PlayerInventory player)
	{
		return new EndTrollBoxContainer(id, player, this);
	}
	
	@Override
	protected IItemHandler createUnSidedHandler()
	{
		return new SidedInvWrapper(this, Direction.UP);
	}

	public static enum AnimationStatus
	{
		CLOSED, OPENING, OPENED, CLOSING;
	}
}