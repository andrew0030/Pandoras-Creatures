package andrews.pandoras_creatures.events;


import andrews.pandoras_creatures.config.Config;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.VersionChecker;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class EventHandler
{	
	@SubscribeEvent
	public static void onPlayerJoin(EntityJoinWorldEvent event)
	{	
		if(event.getEntity() instanceof PlayerEntity)
		{
			PlayerEntity player = (PlayerEntity) event.getEntity();
			
			if(player.getEntityWorld().isRemote)
			{
				switch(VersionChecker.getResult(ModList.get().getModFileById(Reference.MODID).getMods().get(0)).status)
				{
				case OUTDATED: //Found new Version
					if(Config.CLIENT.shouldShowUpdateMessage.get())
					{
						outdatedMessage(player);
					}
					break;
				case FAILED: //Not able to check for new Version
					if(Config.CLIENT.shouldShowUpdateCheckFailedMessage.get())
					{
						failedMessage(player);
					}
					break;
				default: //Do Nothing
				}
			}
		}
	}
	
	/**
	 * Sends a message to the player that the Mod found a new version
	 * @param player - The player the message will be sent to
	 */
	private static void outdatedMessage(PlayerEntity player)
	{	
		TranslationTextComponent downloadLink = new TranslationTextComponent("chat.pandoras_creatures.newVersionDownload", (Object)null);
        downloadLink.getStyle().setUnderlined(true);
        downloadLink.getStyle().setColor(TextFormatting.BLUE);
        downloadLink.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslationTextComponent("chat.pandoras_creatures.newVersionDownloadTooltip", (Object)null)));
        downloadLink.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://www.curseforge.com/minecraft/mc-mods/pandoras-creatures/files"));
        
        TranslationTextComponent warning = new TranslationTextComponent("chat.pandoras_creatures.newVersion", downloadLink);
		warning.getStyle().setColor(TextFormatting.YELLOW);
        player.sendMessage(warning);
	}
	
	/**
	 * Sends a message to the player that the Mod failed to check for a new version
	 * @param player - The player the message will be sent to
	 */
	private static void failedMessage(PlayerEntity player)
	{	
        TranslationTextComponent warning = new TranslationTextComponent("chat.pandoras_creatures.failedCheck");
		warning.getStyle().setColor(TextFormatting.RED);
        player.sendMessage(warning);
	}
}
