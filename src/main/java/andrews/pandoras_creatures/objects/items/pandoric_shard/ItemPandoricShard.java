package andrews.pandoras_creatures.objects.items.pandoric_shard;

import java.util.List;

import andrews.pandoras_creatures.PandorasCreatures;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class ItemPandoricShard extends Item//TODO remove
{	
	public ItemPandoricShard()
	{
		super(getProperties());
	}
	
	private static Properties getProperties()
	{
		Properties properties = new Properties();
		properties.group(PandorasCreatures.PANDORAS_CREATURES_GROUP);
		properties.maxStackSize(1);
		
		return properties;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
	{
		ItemStack stack = playerIn.getHeldItem(handIn);//Gets the affected ItemStack
		
		if(playerIn.isSneaking())
		{
			this.setupPandoricShardNBT(stack);
		}
		else
		{
			CompoundNBT nbt = stack.getOrCreateTag().getCompound("PandoricShardValues");
//			int value = nbt.getInt("ChaosCharge"); TODO work on the shard Item duh...
			nbt.putInt("ChaosCharge", nbt.getInt("ChaosCharge") + 10);
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	{
		super.addInformation(stack, worldIn, tooltip, flagIn);
		CompoundNBT nbt = stack.getOrCreateTag().getCompound("PandoricShardValues");
		
		tooltip.add(new StringTextComponent("Chaos Charge: " + Integer.toString(nbt.getInt("ChaosCharge"))));
		tooltip.add(new StringTextComponent("Creation Charge: " + Integer.toString(nbt.getInt("CreationCharge"))));
	}
	
	/**
	 * Creates all the shard values needed
	 */
	public void setupPandoricShardNBT(ItemStack stack)
	{
		CompoundNBT nbt = new CompoundNBT();
		nbt.putInt("MaxChaosCharge", 0);
		nbt.putInt("ChaosCharge", 0);
		nbt.putInt("MaxCreationCharge", 0);
		nbt.putInt("CreationCharge", 0);
		stack.getOrCreateTag().put("PandoricShardValues", nbt);
	}

	
	
	
	
	
	
	
	
	
	
	
	/*
	 * Chaos Shard
	 */
//	public void setMaxChaosCharge(int maxChaosCharge)
//	{
//		this.stack.getOrCreateTag().putInt("MaxChaos", maxChaosCharge);
//	}
//
//	public void setChaosCharge(int charge)
//	{
//		if(charge < 0)
//		{
//			this.stack.getOrCreateTag().putInt("Chaos", 0);
//		}
//		else if(charge > this.getMaxChaosCharge())
//		{
//			this.stack.getOrCreateTag().putInt("Chaos", this.getMaxChaosCharge());
//		}
//		else
//		{
//			this.stack.getOrCreateTag().putInt("Chaos", this.getMaxChaosCharge());
//		}
//		
//	}

//	@Override
//	public void incrementChaosCharge(int amount)
//	{
//		if(this.chaosCharge + amount > this.maxChaosCharge)
//		{
//			this.chaosCharge = this.maxChaosCharge;
//		}
//		else
//		{
//			this.chaosCharge += amount;
//		}
//	}
//
//	@Override
//	public void decrementChaosCharge(int amount)
//	{
//		if(this.chaosCharge - amount < 0)
//		{
//			this.chaosCharge = 0;
//		}
//		else
//		{
//			this.chaosCharge -= amount;
//		}
//	}

//	public int getMaxChaosCharge()
//	{
//		return new ItemStack(this).getOrCreateTag().getInt("MaxChaos");
//	}
//	
//	public int getChaosCharge()
//	{
//		return new ItemStack(this).getOrCreateTag().getInt("Chaos");
//	}
}
