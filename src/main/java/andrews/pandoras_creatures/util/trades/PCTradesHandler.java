package andrews.pandoras_creatures.util.trades;

import java.util.Random;

import andrews.pandoras_creatures.registry.PCItems;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.merchant.villager.VillagerTrades.ITrade;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class PCTradesHandler
{
	@SubscribeEvent
	public static void onVillagerTradesEvent(VillagerTradesEvent event)
	{
		/**
		 * The Leather Worker Villager Trades
		 */
		if(event.getType() == VillagerProfession.LEATHERWORKER)
		{
			//Adds the Bufflon Hide
			event.getTrades().get(3).add(new EmeraldForItemsTrade(PCItems.BUFFLON_HIDE.get(), 3, 5, 12, 20));
			//Adds the Bufflon Saddle
			event.getTrades().get(4).add(new ItemsForEmeraldsTrade(PCItems.BUFFLON_SADDLE.get(), 25, 1, 3, 30));
			//Adds the Bufflon Back Attachments
			event.getTrades().get(5).add(new ItemsForEmeraldsTrade(PCItems.BUFFLON_PLAYER_SEATS.get(), 34, 1, 3, 32));
			event.getTrades().get(5).add(new ItemsForEmeraldsTrade(PCItems.BUFFLON_SMALL_STORAGE.get(), 34, 1, 3, 32));
			event.getTrades().get(5).add(new ItemsForEmeraldsTrade(PCItems.BUFFLON_LARGE_STORAGE.get(), 34, 1, 3, 32));
		}
		
		/**
		 * The Butcher Villager Trades
		 */
		if(event.getType() == VillagerProfession.BUTCHER)
		{
			//Adds the Bufflon Beef
			event.getTrades().get(3).add(new EmeraldForItemsTrade(PCItems.BUFFLON_BEEF.get(), 4, 10, 12, 20));
		}
	}
	
	public static class ItemsForEmeraldsTrade implements ITrade
	{
		private final ItemStack stack;
		private final int stackSize;
		private final int recievedSize;
		private final int maxUses;
	    private final int givenExp;
	    private final float priceMultiplier;
	    
	    /**
	     * @param block - The block that can be bought
	     * @param stackSize - The price of the item
	     * @param recievedSize - The amount of items you get
	     * @param maxUses - How many times the Item can be bought before the Villager stops selling it
	     * @param givenExp - The amount of experience you get
	     */
	    public ItemsForEmeraldsTrade(Block block, int stackSize, int recievedSize, int maxUses, int givenExp)
	    {
	    	this(new ItemStack(block), stackSize, recievedSize, maxUses, givenExp);
	    }

	    /**
	     * This method does not ask for "maxUses" and sets it to the default of 12
	     * @param item - The item that can be bought
	     * @param stackSize - The price of the item
	     * @param recievedSize - The amount of items you get
	     * @param givenExp - The amount of experience you get
	     */
	    public ItemsForEmeraldsTrade(Item item, int stackSize, int recievedSize, int givenExp)
	    {
	    	this(new ItemStack(item), stackSize, recievedSize, 12, givenExp);
	    }

	    /**
	     * @param item - The item that can be bought
	     * @param stackSize - The price of the item
	     * @param recievedSize - The amount of items you get
	     * @param maxUses - How many times the Item can be bought before the Villager stops selling it
	     * @param givenExp - The amount of experience you get
	     */
	    public ItemsForEmeraldsTrade(Item item, int stackSize, int recievedSize, int maxUses, int givenExp)
	    {
	    	this(new ItemStack(item), stackSize, recievedSize, maxUses, givenExp);
	    }

	    /**
	     * @param stack - The ItemStack that can be bought
	     * @param stackSize - The price of the item
	     * @param recievedSize - The amount of items you get
	     * @param maxUses - How many times the Item can be bought before the Villager stops selling it
	     * @param givenExp - The amount of experience you get
	     */
	    public ItemsForEmeraldsTrade(ItemStack stack, int stackSize, int recievedSize, int maxUses, int givenExp)
	    {
	    	this(stack, stackSize, recievedSize, maxUses, givenExp, 0.05F);
	    }

	    /**
	     * @param stack - The ItemStack that can be bought
	     * @param stackSize - How many Items you have to give
	     * @param recievedSize - The amount of items you get
	     * @param maxUses - How many times the Item can be bought before the Villager stops selling it
	     * @param givenExp - The amount of experience you get
	     * @param priceMultiplier - The price multiplier for this trade offer
	     */
	    public ItemsForEmeraldsTrade(ItemStack stack, int stackSize, int recievedSize, int maxUses, int givenExp, float priceMultiplier)
	    {
	    	this.stack = stack;
	    	this.stackSize = stackSize;
	    	this.recievedSize = recievedSize;
	    	this.maxUses = maxUses;
	    	this.givenExp = givenExp;
	    	this.priceMultiplier = priceMultiplier;
	    }

		@Override
	    public MerchantOffer getOffer(Entity entity, Random rand)
	    {
	    	return new MerchantOffer(new ItemStack(Items.EMERALD, this.stackSize), new ItemStack(this.stack.getItem(), this.recievedSize), this.maxUses, this.givenExp, this.priceMultiplier);
	    }
	}
	
	public static class EmeraldForItemsTrade implements ITrade
	{
		private final Item item;
		private final int stackSize;
		private final int emeraldAmount;
		private final int maxUses;
		private final int givenExp;
		private final float priceMultiplier;

		/**
		 * @param item - The Item the villager buys
		 * @param stackSize - The amount of the Items the villager buys
		 * @param emeraldAmount - The amount of emeralds the villager will give
		 * @param maxUses - How many times this this trade can be performed
		 * @param givenExp - The amount of experience the player gets for this trade
		 */
		public EmeraldForItemsTrade(Item item, int stackSize, int emeraldAmount, int maxUses, int givenExp)
		{
			this.item = item;
			this.stackSize = stackSize;
			this.emeraldAmount = emeraldAmount;
			this.maxUses = maxUses;
			this.givenExp = givenExp;
			this.priceMultiplier = 0.05F;
		}

		@Override
		public MerchantOffer getOffer(Entity entity, Random rand)
		{
			ItemStack itemstack = new ItemStack(this.item, this.stackSize);
			ItemStack emeralds = new ItemStack(Items.EMERALD, this.emeraldAmount);
         	return new MerchantOffer(itemstack, emeralds, this.maxUses, this.givenExp, this.priceMultiplier);
      	}
	}
}