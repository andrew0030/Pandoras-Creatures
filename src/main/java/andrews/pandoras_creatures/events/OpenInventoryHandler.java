package andrews.pandoras_creatures.events;

//@Mod.EventBusSubscriber(modid = Reference.MODID)
//public class OpenInventoryHandler
//{	
//	private static boolean shouldOpenBufflonMenu = false;
//	
//	@SubscribeEvent
//    public static void onOpenInventory(GuiOpenEvent event)
//    {	
//		if(event.getGui() != null && event.getGui() instanceof InventoryScreen)
//		{
//			PlayerEntity localPlayer = Minecraft.getInstance().player;
//			if(localPlayer.isPassenger() && localPlayer.getRidingEntity() instanceof BufflonEntity)
//			{
//				if(shouldOpenBufflonMenu == false)
//				{
//					shouldOpenBufflonMenu = true;
//				}
//				event.setCanceled(true);
//			}
//		}
//    }
//	
//	@SubscribeEvent
//    public static void onPlayerTick(TickEvent.PlayerTickEvent event)
//    {	
//        if(shouldOpenBufflonMenu == false)
//        {
//            return;
//        }
//        if(event.side != LogicalSide.SERVER)
//        {
//            return;
//        }
//        if(event.type != Type.PLAYER)
//        {
//            return;
//        }
//        if(event.phase != Phase.END)
//        {
//            return;
//        }
//        
//        PlayerEntity player = event.player;
//        if(!player.getEntityWorld().isRemote() && player.isPassenger() && player.getRidingEntity() instanceof BufflonEntity)
//        {
//        	BufflonEntity bufflonEntity = (BufflonEntity) player.getRidingEntity();
//        	
//        	ITextComponent bufflonDisplayName = bufflonEntity.getName();
//    		int id = bufflonEntity.getEntityId();
//            NetworkHooks.openGui((ServerPlayerEntity) player, new INamedContainerProvider()
//            {
//            	@Override
//                public ITextComponent getDisplayName()
//            	{
//                    return bufflonDisplayName;
//                }
//    
//                @Nullable
//                @Override
//                public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity)
//                {
//                	return new BufflonContainer(i, playerInventory, id);
//                }
//            }, buf -> buf.writeInt(id));
//            
//            shouldOpenBufflonMenu = false;
//        }
//    }
//}