package andrews.pandoras_creatures.events;

import andrews.pandoras_creatures.objects.blocks.EndTrollBoxBlock;
import andrews.pandoras_creatures.registry.PCBlocks;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CauldronBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class BlockInteractionHandler
{
	@SubscribeEvent
    public static void onBlockInteract(PlayerInteractEvent.RightClickBlock event)
    {
		if(event.getWorld().getBlockState(event.getPos()).getBlock() instanceof CauldronBlock)
		{
			World world = event.getWorld();
			BlockState state = world.getBlockState(event.getPos());
			ItemStack heldItemStack = event.getPlayer().getHeldItem(event.getHand());
			int i = state.get(CauldronBlock.LEVEL);
			
			if(i > 0 && heldItemStack.getItem() instanceof BlockItem)
			{
				Block block = ((BlockItem)heldItemStack.getItem()).getBlock();
				if(block instanceof EndTrollBoxBlock && !world.isRemote())
				{
					event.setCanceled(true);
					ItemStack itemstack = new ItemStack(PCBlocks.END_TROLL_BOX.get(), 1);
					if(heldItemStack.hasTag())
					{
						itemstack.setTag(heldItemStack.getTag().copy());
					}

					event.getPlayer().setHeldItem(event.getHand(), itemstack);
					((CauldronBlock) state.getBlock()).setWaterLevel(world, event.getPos(), state, i - 1);
				}
			}
		}
    }
}
