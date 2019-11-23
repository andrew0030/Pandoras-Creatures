package andrews.pandoras_creatures.network.server;

import java.util.function.Supplier;

import andrews.pandoras_creatures.entities.BufflonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.network.NetworkEvent;

public class MessageServerBufflonFollow
{
	private int entityId;
	private boolean shouldFollow;
	
	public MessageServerBufflonFollow(int entityId, boolean shouldFollow)
	{
        this.entityId = entityId;
        this.shouldFollow = shouldFollow;
    }
	
	public void serialize(PacketBuffer buf)
	{
		buf.writeInt(this.entityId);
		buf.writeBoolean(this.shouldFollow);
	}
	
	public static MessageServerBufflonFollow deserialize(PacketBuffer buf)
	{
		int entityId = buf.readInt();
		boolean shouldFollow = buf.readBoolean();
		return new MessageServerBufflonFollow(entityId, shouldFollow);
	}
	
	public static void handle(MessageServerBufflonFollow message, Supplier<NetworkEvent.Context> ctx)
	{
		NetworkEvent.Context context = ctx.get();
		
		//The server Player
		PlayerEntity player = context.getSender();
		//The Bufflon entity
		BufflonEntity bufflonEntity = (BufflonEntity) player.getEntityWorld().getEntityByID(message.entityId);
		boolean shouldFollow = message.shouldFollow;
		
		if(context.getDirection().getReceptionSide() == LogicalSide.SERVER)
		{
			context.enqueueWork(() ->
			{
				if(bufflonEntity != null)
				{
					bufflonEntity.setFollowingOwner(shouldFollow);
				}
			});
			context.setPacketHandled(true);
		}
	}
}