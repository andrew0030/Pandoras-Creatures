package andrews.pandoras_creatures.network.server;

import java.util.function.Supplier;

import javax.annotation.Nullable;

import andrews.pandoras_creatures.container.BufflonContainer;
import andrews.pandoras_creatures.entities.BufflonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.NetworkHooks;

public class MessageServerBufflonInventory
{
	private int entityId;
	
	public MessageServerBufflonInventory(int entityId)
	{
        this.entityId = entityId;
    }
	
	public void serialize(PacketBuffer buf)
	{
		buf.writeInt(this.entityId);
	}
	
	public static MessageServerBufflonInventory deserialize(PacketBuffer buf)
	{
		int entityId = buf.readInt();
		return new MessageServerBufflonInventory(entityId);
	}
	
	public static void handle(MessageServerBufflonInventory message, Supplier<NetworkEvent.Context> ctx)
	{
		NetworkEvent.Context context = ctx.get();
		
		//The server Player
		PlayerEntity player = context.getSender();
		//The Bufflon entity
		BufflonEntity bufflonEntity = (BufflonEntity) player.getEntityWorld().getEntityByID(message.entityId);
		
		if(context.getDirection().getReceptionSide() == LogicalSide.SERVER)
		{
			context.enqueueWork(() ->
			{
				if(bufflonEntity != null)
				{
					if(!player.getEntityWorld().isRemote() && player.isPassenger() && player.getRidingEntity() instanceof BufflonEntity)
					{ 	
				      	ITextComponent bufflonDisplayName = bufflonEntity.getName();
				  		int id = bufflonEntity.getEntityId();
				  		NetworkHooks.openGui((ServerPlayerEntity) player, new INamedContainerProvider()
				  		{
				  			@Override
				  			public ITextComponent getDisplayName()
				  			{
				  				return bufflonDisplayName;
				  			}
				  
				  			@Nullable
				  			@Override
				  			public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity)
				  			{
				  				return new BufflonContainer(i, playerInventory, id);
				  			}
				  		}, buf -> buf.writeInt(id));
					}
				}
			});
			context.setPacketHandled(true);
		}
	}
}