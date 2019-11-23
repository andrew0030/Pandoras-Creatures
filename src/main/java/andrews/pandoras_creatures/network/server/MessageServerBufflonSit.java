package andrews.pandoras_creatures.network.server;

import java.util.function.Supplier;

import andrews.pandoras_creatures.entities.BufflonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.network.NetworkEvent;

public class MessageServerBufflonSit
{
	private int entityId;
	private boolean shouldSit;
	
	public MessageServerBufflonSit(int entityId, boolean shouldSit)
	{
        this.entityId = entityId;
        this.shouldSit = shouldSit;
    }
	
	public void serialize(PacketBuffer buf)
	{
		buf.writeInt(this.entityId);
		buf.writeBoolean(this.shouldSit);
	}
	
	public static MessageServerBufflonSit deserialize(PacketBuffer buf)
	{
		int entityId = buf.readInt();
		boolean shouldSit = buf.readBoolean();
		return new MessageServerBufflonSit(entityId, shouldSit);
	}
	
	public static void handle(MessageServerBufflonSit message, Supplier<NetworkEvent.Context> ctx)
	{
		NetworkEvent.Context context = ctx.get();
		
		//The server Player
		PlayerEntity player = context.getSender();
		//The Bufflon entity
		BufflonEntity bufflonEntity = (BufflonEntity) player.getEntityWorld().getEntityByID(message.entityId);
		boolean shouldSit = message.shouldSit;
		
		if(context.getDirection().getReceptionSide() == LogicalSide.SERVER)
		{
			context.enqueueWork(() ->
			{
				if(bufflonEntity != null)
				{
					bufflonEntity.bufflonSitGoal.setSitting(shouldSit);
				}
			});
			context.setPacketHandled(true);
		}
	}
}