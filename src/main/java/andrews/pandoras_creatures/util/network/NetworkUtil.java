package andrews.pandoras_creatures.util.network;

import org.apache.commons.lang3.ArrayUtils;

import andrews.pandoras_creatures.Main;
import andrews.pandoras_creatures.entities.bases.AnimatedCreatureEntity;
import andrews.pandoras_creatures.network.client.MessageClientAnimation;
import andrews.pandoras_creatures.util.animation.Animation;
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
}
