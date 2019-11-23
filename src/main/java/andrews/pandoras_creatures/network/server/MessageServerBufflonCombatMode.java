package andrews.pandoras_creatures.network.server;

import java.util.function.Supplier;

import andrews.pandoras_creatures.entities.BufflonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.network.NetworkEvent;

public class MessageServerBufflonCombatMode
{
	private int entityId;
	private boolean combatMode;
	
	public MessageServerBufflonCombatMode(int entityId, boolean combatMode)
	{
        this.entityId = entityId;
        this.combatMode = combatMode;
    }
	
	public void serialize(PacketBuffer buf)
	{
		buf.writeInt(this.entityId);
		buf.writeBoolean(this.combatMode);
	}
	
	public static MessageServerBufflonCombatMode deserialize(PacketBuffer buf)
	{
		int entityId = buf.readInt();
		boolean combatMode = buf.readBoolean();
		return new MessageServerBufflonCombatMode(entityId, combatMode);
	}
	
	public static void handle(MessageServerBufflonCombatMode message, Supplier<NetworkEvent.Context> ctx)
	{
		NetworkEvent.Context context = ctx.get();
		
		//The server Player
		PlayerEntity player = context.getSender();
		//The Bufflon entity
		BufflonEntity bufflonEntity = (BufflonEntity) player.getEntityWorld().getEntityByID(message.entityId);
		boolean combatMode = message.combatMode;
		
		if(context.getDirection().getReceptionSide() == LogicalSide.SERVER)
		{
			context.enqueueWork(() ->
			{
				if(bufflonEntity != null)
				{
					bufflonEntity.setIsInCombatMode(combatMode);
				}
			});
			context.setPacketHandled(true);
		}
	}
}