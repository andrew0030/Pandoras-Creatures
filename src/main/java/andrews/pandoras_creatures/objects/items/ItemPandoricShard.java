package andrews.pandoras_creatures.objects.items;

import andrews.pandoras_creatures.Main;
import net.minecraft.item.Item;

public class ItemPandoricShard extends Item
{

	public ItemPandoricShard()
	{
		super(getProperties());
	}
	
	private static Properties getProperties()
	{
		Properties properties = new Properties();
		properties.group(Main.PANDORAS_CREATURES_GROUP);
		properties.maxStackSize(1);
		
		return properties;
	}
	
//	@Override
//	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
//	{
//		ItemStack itemstack = playerIn.getHeldItem(handIn);
//		IPandoricShard pandoricShardCap = itemstack.getCapability(PCCapabilities.PANDORIC_SHARD_CAP, null).orElse(null);
//		
//		if(playerIn.isSneaking())
//		{
//			pandoricShardCap.setMaxChaosCharge(300);
//			System.out.println(pandoricShardCap.getMaxChaosCharge());
//		}
//		else
//		{
//			pandoricShardCap.incrementChaosCharge(10);
//			System.out.println(pandoricShardCap.getChaosCharge());
//		}
//		return super.onItemRightClick(worldIn, playerIn, handIn);
//	}
}
