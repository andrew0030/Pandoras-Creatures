package andrews.pandoras_creatures.registry;

import andrews.pandoras_creatures.capability.pandoric_shard.IPandoricShard;
import andrews.pandoras_creatures.capability.pandoric_shard.PandoricShardFactory;
import andrews.pandoras_creatures.capability.pandoric_shard.PandoricShardProvider;
import andrews.pandoras_creatures.capability.pandoric_shard.PandoricShardStorage;
import andrews.pandoras_creatures.objects.items.ItemPandoricShard;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class PCCapabilities
{
	@CapabilityInject(IPandoricShard.class) 
	public static final Capability<IPandoricShard> PANDORIC_SHARD_CAP = null;
	
	public static void registerAll()
	{
		 CapabilityManager.INSTANCE.register(IPandoricShard.class, new PandoricShardStorage(), new PandoricShardFactory());
	}
	
	@SubscribeEvent
	public static void onAttachItemCapabilities(AttachCapabilitiesEvent<ItemStack> event)
	{
		if(event.getObject().getItem() instanceof ItemPandoricShard)
		{
			event.addCapability(new ResourceLocation(Reference.MODID, "pandoric_shard_cap"), new PandoricShardProvider());
		}
	}
}