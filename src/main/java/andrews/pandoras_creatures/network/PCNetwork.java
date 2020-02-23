package andrews.pandoras_creatures.network;

import andrews.pandoras_creatures.network.client.MessageClientAnimation;
import andrews.pandoras_creatures.network.server.MessageServerBufflonCombatMode;
import andrews.pandoras_creatures.network.server.MessageServerBufflonFollow;
import andrews.pandoras_creatures.network.server.MessageServerBufflonInventory;
import andrews.pandoras_creatures.network.server.MessageServerBufflonSit;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class PCNetwork
{
	public static final String NETWORK_PROTOCOL = "1";
	
	public static final SimpleChannel CHANNEL = NetworkRegistry.ChannelBuilder.named(new ResourceLocation(Reference.MODID, "net"))
		.networkProtocolVersion(() -> NETWORK_PROTOCOL)
		.clientAcceptedVersions(NETWORK_PROTOCOL::equals)
		.serverAcceptedVersions(NETWORK_PROTOCOL::equals)
		.simpleChannel();
	
	/**
	 * Used to set up all the Messages
	 */
	public static void setupMessages()
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
