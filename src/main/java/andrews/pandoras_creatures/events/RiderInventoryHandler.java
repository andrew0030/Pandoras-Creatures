package andrews.pandoras_creatures.events;

import andrews.pandoras_creatures.entities.BufflonEntity;
import andrews.pandoras_creatures.util.Reference;
import andrews.pandoras_creatures.util.network.NetworkUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.InventoryScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MODID, value = Dist.CLIENT)
public class RiderInventoryHandler
{	
	@SubscribeEvent
    public static void onOpenInventory(GuiOpenEvent event)
    {	
		if(event.getGui() != null && event.getGui() instanceof InventoryScreen)
		{
			PlayerEntity localPlayer = Minecraft.getInstance().player;
			if(localPlayer.isPassenger() && localPlayer.getRidingEntity() instanceof BufflonEntity)
			{
				event.setCanceled(true);
				//Sends a packet to the server, and notifies it of the player opening the inventory
				BufflonEntity bufflonEntity = (BufflonEntity) localPlayer.getRidingEntity();
				NetworkUtil.openBufflonInventoryMessage(bufflonEntity);
			}
		}
    }
}
