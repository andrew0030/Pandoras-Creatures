package andrews.pandoras_creatures;

import andrews.pandoras_creatures.config.Config;
import andrews.pandoras_creatures.config.ConfigHelper;
import andrews.pandoras_creatures.entities.AcidicArchvineEntity;
import andrews.pandoras_creatures.entities.ArachnonEntity;
import andrews.pandoras_creatures.entities.BufflonEntity;
import andrews.pandoras_creatures.entities.CrabEntity;
import andrews.pandoras_creatures.entities.HellhoundEntity;
import andrews.pandoras_creatures.entities.SeahorseEntity;
import andrews.pandoras_creatures.item_groups.PCItemGroup;
import andrews.pandoras_creatures.network.client.MessageClientAnimation;
import andrews.pandoras_creatures.network.server.MessageServerBufflonCombatMode;
import andrews.pandoras_creatures.network.server.MessageServerBufflonFollow;
import andrews.pandoras_creatures.network.server.MessageServerBufflonInventory;
import andrews.pandoras_creatures.network.server.MessageServerBufflonSit;
import andrews.pandoras_creatures.proxy.ClientProxy;
import andrews.pandoras_creatures.proxy.ServerProxy;
import andrews.pandoras_creatures.util.FeatureInjector;
import andrews.pandoras_creatures.util.Reference;
import andrews.pandoras_creatures.util.RehostedJarHandler;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.moddiscovery.ModFile;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

@Mod(value = Reference.MODID)
public class Main
{
	public static Main instance;
	public static ServerProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> ServerProxy::new);
	public static final ItemGroup PANDORAS_CREATURES_GROUP = new PCItemGroup();
	public static final String NETWORK_PROTOCOL = "1";

	public Main()
	{
		instance = this;
		
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupCommon);
		
		modEventBus.addListener((ModConfig.ModConfigEvent event) ->
		{
			final ModConfig config = event.getConfig();
			if(config.getSpec() == Config.CLIENTSPEC)
			{
				System.out.println("CLIENT CONFIG REEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
				ConfigHelper.updateClientConfig(config);
			}
			if(config.getSpec() == Config.COMMONSPEC)
			{
				System.out.println("COMMON CONFIG OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
				ConfigHelper.updateCommonConfig(config);
			}
		});
		
		ModLoadingContext modLoadingContext = ModLoadingContext.get();
		modLoadingContext.registerConfig(ModConfig.Type.CLIENT, Config.CLIENTSPEC);
		modLoadingContext.registerConfig(ModConfig.Type.COMMON, Config.COMMONSPEC);
	}
	
	public static final SimpleChannel CHANNEL = NetworkRegistry.ChannelBuilder.named(new ResourceLocation(Reference.MODID, "net"))
		.networkProtocolVersion(() -> NETWORK_PROTOCOL)
		.clientAcceptedVersions(NETWORK_PROTOCOL::equals)
		.serverAcceptedVersions(NETWORK_PROTOCOL::equals)
		.simpleChannel();
	
	private void setupCommon(final FMLCommonSetupEvent event)
	{
		this.setupMessages();
		proxy.preInit();
		
		ModFile file = ModList.get().getModFileById(Reference.MODID).getFile();
		new RehostedJarHandler(file, "pandoras_creatures-" + Reference.VERSION + ".jar");
		
		FeatureInjector.addFeaturesToBiomes();
		
		ArachnonEntity.addSpawn();
		HellhoundEntity.addSpawn();
		CrabEntity.addSpawn();
		SeahorseEntity.addSpawn();
		AcidicArchvineEntity.addSpawn();
		BufflonEntity.addSpawn();
	}
	
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