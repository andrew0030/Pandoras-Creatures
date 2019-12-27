package andrews.pandoras_creatures.events;


import andrews.pandoras_creatures.config.Config;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.TickEvent.Type;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.VersionChecker;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class EventHandler
{	
	private static boolean hasAllreadySentMessage = false;
	
	@SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event)
    {	
        if(hasAllreadySentMessage == true)
        {
            return;
        }
        if(event.side != LogicalSide.CLIENT)
        {
            return;
        }
        if(event.type != Type.PLAYER)
        {
            return;
        }
        if(event.phase != Phase.END)
        {
            return;
        }
        
        PlayerEntity player = event.player;
        
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
        hasAllreadySentMessage = true;
    }
	
	/**
	 * Sends a message to the player that the Mod found a new version
	 * @param player - The player the message will be sent to
	 */
	private static void outdatedMessage(PlayerEntity player)
	{	
		TranslationTextComponent downloadLink = new TranslationTextComponent("chat.pandoras_creatures.newVersionDownload");
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
