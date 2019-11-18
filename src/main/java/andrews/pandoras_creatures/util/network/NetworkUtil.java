package andrews.pandoras_creatures.util.network;

import org.apache.commons.lang3.ArrayUtils;

import andrews.pandoras_creatures.Main;
import andrews.pandoras_creatures.entities.BufflonEntity;
import andrews.pandoras_creatures.entities.bases.AnimatedCreatureEntity;
import andrews.pandoras_creatures.network.client.MessageClientAnimation;
import andrews.pandoras_creatures.network.server.MessageServerBufflonInventory;
import andrews.pandoras_creatures.util.animation.Animation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.PacketDistributor;

public class NetworkUtil
{
	/**
	 * Sends a message to the client, containing the animation the entity should start playing
	 * @param entity - The Entity that will be affected
	 * @param animationToPlay - The animation that will start playing
	 */
	public static void setPlayingAnimationMessage(AnimatedCreatureEntity entity, Animation animationToPlay)
	{
		if(!entity.getEntityWorld().isRemote)
		{
			Main.CHANNEL.send(PacketDistributor.TRACKING_ENTITY.with(() -> entity), new MessageClientAnimation(entity.getEntityId(), ArrayUtils.indexOf(entity.getAnimations(), animationToPlay)));
		}
	}
	
	/**
	 * Sends a message to the server that the player wants to open the Bufflon inventory
	 * @param bufflonEntity - The Bufflon Entity that owns the Inventory
	 */
	@OnlyIn(Dist.CLIENT)
	public static void openBufflonInventoryMessage(BufflonEntity bufflonEntity)
	{
		Main.CHANNEL.sendToServer(new MessageServerBufflonInventory(bufflonEntity.getEntityId()));
	}
}
