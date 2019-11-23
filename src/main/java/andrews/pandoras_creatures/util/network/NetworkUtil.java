package andrews.pandoras_creatures.util.network;

import org.apache.commons.lang3.ArrayUtils;

import andrews.pandoras_creatures.Main;
import andrews.pandoras_creatures.entities.BufflonEntity;
import andrews.pandoras_creatures.entities.bases.AnimatedCreatureEntity;
import andrews.pandoras_creatures.network.client.MessageClientAnimation;
import andrews.pandoras_creatures.network.server.MessageServerBufflonCombatMode;
import andrews.pandoras_creatures.network.server.MessageServerBufflonFollow;
import andrews.pandoras_creatures.network.server.MessageServerBufflonInventory;
import andrews.pandoras_creatures.network.server.MessageServerBufflonSit;
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
	
	/**
	 * Sends a message to the server that the player pressed the Bufflon sit button and tells the server whether the Bufflon should sit or not
	 * @param bufflonEntity - The Bufflon Entity that owns the Inventory
	 * @param shouldSit - Whether or not the entity should sit
	 */
	@OnlyIn(Dist.CLIENT)
	public static void setBufflonSittingMessage(BufflonEntity bufflonEntity, boolean shouldSit)
	{
		Main.CHANNEL.sendToServer(new MessageServerBufflonSit(bufflonEntity.getEntityId(), shouldSit));
	}
	
	/**
	 * Sends a message to the server that the player pressed the Bufflon follow button and tells the server whether the Bufflon should follow its owner or not
	 * @param bufflonEntity - The Bufflon Entity that owns the Inventory
	 * @param shouldFollow - Whether or not the entity should sit
	 */
	@OnlyIn(Dist.CLIENT)
	public static void setBufflonFollowingMessage(BufflonEntity bufflonEntity, boolean shouldFollow)
	{
		Main.CHANNEL.sendToServer(new MessageServerBufflonFollow(bufflonEntity.getEntityId(), shouldFollow));
	}
	
	/**
	 * Sends a message to the server that the player pressed one of the Bufflon combat buttons and tells the server whether the Bufflon should enable its combat logic or not
	 * @param bufflonEntity - The Bufflon Entity that owns the Inventory
	 * @param combatMode - Whether or not the entity should sit
	 */
	@OnlyIn(Dist.CLIENT)
	public static void setBufflonCombatMode(BufflonEntity bufflonEntity, boolean combatMode)
	{
		Main.CHANNEL.sendToServer(new MessageServerBufflonCombatMode(bufflonEntity.getEntityId(), combatMode));
	}
}
