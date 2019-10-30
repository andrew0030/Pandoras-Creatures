package andrews.pandoras_creatures;

import andrews.pandoras_creatures.config.Config;
import andrews.pandoras_creatures.config.ConfigHelper;
import andrews.pandoras_creatures.entities.AcidicArchvineEntity;
import andrews.pandoras_creatures.entities.ArachnonEntity;
import andrews.pandoras_creatures.entities.CrabEntity;
import andrews.pandoras_creatures.entities.HellhoundEntity;
import andrews.pandoras_creatures.entities.SeahorseEntity;
import andrews.pandoras_creatures.item_groups.PCItemGroup;
import andrews.pandoras_creatures.network.client.MessageClientAnimation;
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
				ConfigHelper.updateClientConfig(config);
			}
		});
		
		ModLoadingContext modLoadingContext = ModLoadingContext.get();
		modLoadingContext.registerConfig(ModConfig.Type.CLIENT, Config.CLIENTSPEC);
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
		
		ArachnonEntity.addSpawn();
		HellhoundEntity.addSpawn();
		CrabEntity.addSpawn();
		SeahorseEntity.addSpawn();
		AcidicArchvineEntity.addSpawn();
		
		FeatureInjector.addFeaturesToBiomes();
	}
	
	void setupMessages()
	{
		int id = -1;
		CHANNEL.messageBuilder(MessageClientAnimation.class, id++)
		.encoder(MessageClientAnimation::serialize)
		.decoder(MessageClientAnimation::deserialize)
		.consumer(MessageClientAnimation::handle).add();
	}
}