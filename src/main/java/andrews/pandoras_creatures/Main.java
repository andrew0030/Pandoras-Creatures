package andrews.pandoras_creatures;

import andrews.pandoras_creatures.config.Config;
import andrews.pandoras_creatures.config.ConfigHelper;
import andrews.pandoras_creatures.entities.AcidicArchvineEntity;
import andrews.pandoras_creatures.entities.ArachnonEntity;
import andrews.pandoras_creatures.entities.BufflonEntity;
import andrews.pandoras_creatures.entities.CrabEntity;
import andrews.pandoras_creatures.entities.EndTrollEntity;
import andrews.pandoras_creatures.entities.HellhoundEntity;
import andrews.pandoras_creatures.entities.SeahorseEntity;
import andrews.pandoras_creatures.entities.render.AcidicArchvineRenderer;
import andrews.pandoras_creatures.entities.render.ArachnonRenderer;
import andrews.pandoras_creatures.entities.render.BufflonRenderer;
import andrews.pandoras_creatures.entities.render.CrabRenderer;
import andrews.pandoras_creatures.entities.render.EndTrollRenderer;
import andrews.pandoras_creatures.entities.render.HellhoundRenderer;
import andrews.pandoras_creatures.entities.render.SeahorseRenderer;
import andrews.pandoras_creatures.gui.screen.BufflonScreen;
import andrews.pandoras_creatures.item_groups.PCItemGroup;
import andrews.pandoras_creatures.network.client.MessageClientAnimation;
import andrews.pandoras_creatures.network.server.MessageServerBufflonCombatMode;
import andrews.pandoras_creatures.network.server.MessageServerBufflonFollow;
import andrews.pandoras_creatures.network.server.MessageServerBufflonInventory;
import andrews.pandoras_creatures.network.server.MessageServerBufflonSit;
import andrews.pandoras_creatures.objects.items.PCSpawnEggItem;
import andrews.pandoras_creatures.registry.PCBlocks;
import andrews.pandoras_creatures.registry.PCContainers;
import andrews.pandoras_creatures.registry.PCEntities;
import andrews.pandoras_creatures.registry.PCItems;
import andrews.pandoras_creatures.registry.PCSounds;
import andrews.pandoras_creatures.util.FeatureInjector;
import andrews.pandoras_creatures.util.Reference;
import andrews.pandoras_creatures.util.RehostedJarHandler;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.moddiscovery.ModFile;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

@Mod(value = Reference.MODID)
public class Main
{
	public static Main instance;
	public static final ItemGroup PANDORAS_CREATURES_GROUP = new PCItemGroup();
	public static final String NETWORK_PROTOCOL = "1";

	public Main()
	{
		instance = this;
		
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		
		PCItems.ITEMS.register(modEventBus);
		PCBlocks.BLOCKS.register(modEventBus);
		PCEntities.ENTITY_TYPES.register(modEventBus);
		PCSounds.SOUNDS.register(modEventBus);
		
		DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {modEventBus.addListener(EventPriority.LOWEST, this::registerItemColors);});
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(EventPriority.LOWEST, this::setupCommon);
		DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {modEventBus.addListener(this::setupClient);});
		
		//Configs
		modEventBus.addListener((ModConfig.ModConfigEvent event) ->
		{
			final ModConfig config = event.getConfig();
			if(config.getSpec() == Config.CLIENTSPEC)
			{
				ConfigHelper.updateClientConfig(config);
			}
			if(config.getSpec() == Config.COMMONSPEC)
			{
				ConfigHelper.updateCommonConfig(config);
			}
		});
		
		ModLoadingContext modLoadingContext = ModLoadingContext.get();
		modLoadingContext.registerConfig(ModConfig.Type.CLIENT, Config.CLIENTSPEC);
		modLoadingContext.registerConfig(ModConfig.Type.COMMON, Config.COMMONSPEC);
	}
	
	//Networking
	public static final SimpleChannel CHANNEL = NetworkRegistry.ChannelBuilder.named(new ResourceLocation(Reference.MODID, "net"))
		.networkProtocolVersion(() -> NETWORK_PROTOCOL)
		.clientAcceptedVersions(NETWORK_PROTOCOL::equals)
		.serverAcceptedVersions(NETWORK_PROTOCOL::equals)
		.simpleChannel();
	
	//Setup Common
	private void setupCommon(final FMLCommonSetupEvent event)
	{
		this.setupMessages();
		
		ModFile file = ModList.get().getModFileById(Reference.MODID).getFile();
		new RehostedJarHandler(file, "pandoras_creatures-" + Reference.VERSION + ".jar");
		
		FeatureInjector.addFeaturesToBiomes();
		
		ArachnonEntity.addSpawn();
		HellhoundEntity.addSpawn();
		CrabEntity.addSpawn();
		SeahorseEntity.addSpawn();
		AcidicArchvineEntity.addSpawn();
		BufflonEntity.addSpawn();
		EndTrollEntity.addSpawn();
	}
	
	//Setup Client
	@OnlyIn(Dist.CLIENT)
	private void setupClient(final FMLClientSetupEvent event)
	{
		//Tile Entities
//		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityElderEye.class, new TileEntityElderEyeRenderer());
		
		//Entities
		RenderingRegistry.registerEntityRenderingHandler(ArachnonEntity.class, manager -> new ArachnonRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(HellhoundEntity.class, manager -> new HellhoundRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(CrabEntity.class, manager -> new CrabRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(SeahorseEntity.class, manager -> new SeahorseRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(AcidicArchvineEntity.class, manager -> new AcidicArchvineRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(BufflonEntity.class, manager -> new BufflonRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(EndTrollEntity.class, manager -> new EndTrollRenderer(manager));
		
		//ContainerScreens
		ScreenManager.registerFactory(PCContainers.BUFFLON, BufflonScreen::new);
	}
	
	//Item Colors
	@OnlyIn(Dist.CLIENT)
	private void registerItemColors(ColorHandlerEvent.Item event)
	{
		for(RegistryObject<Item> items : PCItems.SPAWN_EGGS)
		{
			Item item = items.get();
			if(item instanceof PCSpawnEggItem)
			{
				event.getItemColors().register((itemColor, itemsIn) ->
				{
					return ((PCSpawnEggItem) item).getColor(itemsIn);
				}, item);
			}
		}
	}
	
	//Setup Messages
	void setupMessages()
	{
		int id = -1;
		//Client Messages
		CHANNEL.messageBuilder(MessageClientAnimation.class, id++)
		.encoder(MessageClientAnimation::serialize)
		.decoder(MessageClientAnimation::deserialize)
		.consumer(MessageClientAnimation::handle).add();
		
		//Server Messages
		CHANNEL.messageBuilder(MessageServerBufflonInventory.class, id++)
		.encoder(MessageServerBufflonInventory::serialize).decoder(MessageServerBufflonInventory::deserialize)
		.consumer(MessageServerBufflonInventory::handle)
		.add();
		CHANNEL.messageBuilder(MessageServerBufflonSit.class, id++)
		.encoder(MessageServerBufflonSit::serialize).decoder(MessageServerBufflonSit::deserialize)
		.consumer(MessageServerBufflonSit::handle)
		.add();
		CHANNEL.messageBuilder(MessageServerBufflonFollow.class, id++)
		.encoder(MessageServerBufflonFollow::serialize).decoder(MessageServerBufflonFollow::deserialize)
		.consumer(MessageServerBufflonFollow::handle)
		.add();
		CHANNEL.messageBuilder(MessageServerBufflonCombatMode.class, id++)
		.encoder(MessageServerBufflonCombatMode::serialize).decoder(MessageServerBufflonCombatMode::deserialize)
		.consumer(MessageServerBufflonCombatMode::handle)
		.add();
	}
}