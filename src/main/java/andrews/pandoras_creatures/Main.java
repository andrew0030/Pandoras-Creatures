package andrews.pandoras_creatures;

import andrews.pandoras_creatures.config.Config;
import andrews.pandoras_creatures.config.ConfigHelper;
import andrews.pandoras_creatures.item_groups.PCItemGroup;
import andrews.pandoras_creatures.network.PCNetwork;
import andrews.pandoras_creatures.objects.items.PCSpawnEggItem;
import andrews.pandoras_creatures.registry.PCBlocks;
import andrews.pandoras_creatures.registry.PCContainers;
import andrews.pandoras_creatures.registry.PCCrafting;
import andrews.pandoras_creatures.registry.PCEntities;
import andrews.pandoras_creatures.registry.PCItems;
import andrews.pandoras_creatures.registry.PCRenderLayers;
import andrews.pandoras_creatures.registry.PCSounds;
import andrews.pandoras_creatures.registry.PCTileEntities;
import andrews.pandoras_creatures.registry.util.PCDispenserBehaviors;
import andrews.pandoras_creatures.registry.util.PCEntityAttributes;
import andrews.pandoras_creatures.util.FeatureInjector;
import andrews.pandoras_creatures.util.Reference;
import andrews.pandoras_creatures.util.RehostedJarHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.moddiscovery.ModFile;

@Mod(value = Reference.MODID)
@SuppressWarnings("deprecation")
public class Main
{
	public static Main instance;
	public static final ItemGroup PANDORAS_CREATURES_GROUP = new PCItemGroup();

	public Main()
	{
		instance = this;
		
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		
		PCItems.ITEMS.register(modEventBus);
		PCBlocks.BLOCKS.register(modEventBus);
		PCSounds.SOUNDS.register(modEventBus);
		PCTileEntities.TILE_ENTITY_TYPES.register(modEventBus);
		PCContainers.CONTAINERS.register(modEventBus);
		PCEntities.ENTITY_TYPES.register(modEventBus);
//		PCFeatures.FEATURES.register(modEventBus); // TODO replace with the new method from the new Registry Class for structures
//		PCStructurePieces.init();// TODO replace with the new method from the new Registry Class for structures
		PCCrafting.RECIPES.register(modEventBus);
		
		DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {modEventBus.addListener(EventPriority.LOWEST, this::registerItemColors);});
		
		FMLJavaModLoadingContext.get().getModEventBus().register(Main.class);
		
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
	
	//Setup Common
	@SubscribeEvent
	public static void setupCommon(final FMLCommonSetupEvent event)
	{
		DeferredWorkQueue.runLater(() ->
		{
			PCEntityAttributes.putAttributes();
		});
		
		PCDispenserBehaviors.registerAll();
		PCNetwork.setupMessages();
		
		ModFile file = ModList.get().getModFileById(Reference.MODID).getFile();
		new RehostedJarHandler(file, "pandoras_creatures-" + Reference.VERSION + ".jar");
		
		FeatureInjector.addFeaturesToBiomes();
		
		DeferredWorkQueue.runLater(PCEntities::registerEntityWorldSpawns);
	}
	
	//Setup Client
	@SubscribeEvent
	public static void setupClient(final FMLClientSetupEvent event)
	{
		DeferredWorkQueue.runLater(() ->
		{
			PCItems.setupItemProperties();
		});
		
		//Block Render Layers
		PCRenderLayers.setBlockRenderLayers();
		//Tile Entities
		PCTileEntities.registerTileRenders();
		//Entities
		PCEntities.registerEntityRenders();
		//ContainerScreens
		PCContainers.screenSetup();
	}
	
	//Item Colors
	@OnlyIn(Dist.CLIENT)
	public void registerItemColors(ColorHandlerEvent.Item event)
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
}