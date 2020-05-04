package andrews.pandoras_creatures.network.client;

import java.util.function.Supplier;

import andrews.pandoras_creatures.entities.bases.AnimatedCreatureEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.network.NetworkEvent;

public class MessageClientAnimation
{
	private int entityId;
	private int animationIndex;
	
	public MessageClientAnimation(int entityID, int animationIndex)
	{
        this.entityId = entityID;
        this.animationIndex = animationIndex;
    }
	
	public void serialize(PacketBuffer buf)
	{
		buf.writeInt(this.entityId);
		buf.writeInt(this.animationIndex);
	}
	
	public static MessageClientAnimation deserialize(PacketBuffer buf)
	{
		int entityId = buf.readInt();
		int animationIndex = buf.readInt();
		return new MessageClientAnimation(entityId, animationIndex);
	}
	
	public static void handle(MessageClientAnimation message, Supplier<NetworkEvent.Context> ctx)
	{
		NetworkEvent.Context context = ctx.get();
		AnimatedCreatureEntity animatedEntity = (AnimatedCreatureEntity) Minecraft.getInstance().player.getEntityWorld().getEntityByID(message.entityId);
		if(context.getDirection().getReceptionSide() == LogicalSide.CLIENT)
		{
			context.enqueueWork(() ->
			{
				if(animatedEntity != null)
				{
					if(message.animationIndex == -1)
					{
						animatedEntity.resetAnimation();
					}
					else
					{
						animatedEntity.setPlayingAnimation(animatedEntity.getAnimations()[message.animationIndex]);
					}
					animatedEntity.setAnimationTick(0);
				}
			});
			context.setPacketHandled(true);
		}
	}
}