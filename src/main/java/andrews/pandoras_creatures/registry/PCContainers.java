package andrews.pandoras_creatures.registry;

import andrews.pandoras_creatures.container.BufflonContainer;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PCContainers
{	
	@SuppressWarnings("unchecked")
	public static final ContainerType<BufflonContainer> BUFFLON = (ContainerType<BufflonContainer>) IForgeContainerType.create(BufflonContainer::new).setRegistryName(new ResourceLocation(Reference.MODID, "bufflon_container"));
	
	@SubscribeEvent
	public void registerContainers(RegistryEvent.Register<ContainerType<?>> event)
	{
//		event.getRegistry().register(IForgeContainerType.create(BufflonContainer::new).setRegistryName(new ResourceLocation(Reference.MODID, "bufflon_container")));
		event.getRegistry().register(BUFFLON);
	}
}