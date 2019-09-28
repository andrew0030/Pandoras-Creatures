package andrews.pandoras_creatures.events;

//@Mod.EventBusSubscriber(modid = Reference.MODID)
public class EventHandler
{
	
	
//	@SubscribeEvent
//	public static void onPlayerJoin(EntityJoinWorldEvent event)
//	{
//		if(event.getEntity() instanceof PlayerEntity)
//		{
//			if(UpdateChecker.isNewVersionAvailable())
//			{
//				PlayerEntity player = (PlayerEntity) event.getEntity();
//				
//				if(!player.getEntityWorld().isRemote)
//				{	
//					TranslationTextComponent downloadLink = new TranslationTextComponent("chat.pandoras_creatures.newVersionDownload", (Object)null);
//			        downloadLink.getStyle().setUnderlined(true);
//			        downloadLink.getStyle().setColor(TextFormatting.BLUE);
//			        downloadLink.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslationTextComponent("chat.pandoras_creatures.newVersionDownloadTooltip", (Object)null)));
//			        downloadLink.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://www.curseforge.com/minecraft/mc-mods/pandoras-creatures/files"));
//			        
//			        TranslationTextComponent warning = new TranslationTextComponent("chat.pandoras_creatures.newVersion", downloadLink);
//					warning.getStyle().setColor(TextFormatting.RED);
//			        player.sendMessage(warning);
//				}
//			}
//		}
//	}
}
