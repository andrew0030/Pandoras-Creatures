package andrews.pandoras_creatures.registry;

import java.util.ArrayList;
import java.util.List;

import andrews.pandoras_creatures.container.BufflonContainer;
import andrews.pandoras_creatures.registry.util.PCContainerNames;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.IContainerFactory;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PCContainers
{   
	@ObjectHolder(PCContainerNames.BUFFLON)
    public static final ContainerType<BufflonContainer> BUFFLON = null;
    
    private static final List<ContainerType<?>> CONTAINER_TYPES = new ArrayList<>();
    
    @SubscribeEvent
    public static void registerContainerTypes(final RegistryEvent.Register<ContainerType<?>> event)
    {
        register(PCContainerNames.BUFFLON, BufflonContainer::new);
        
        CONTAINER_TYPES.forEach(container_type -> event.getRegistry().register(container_type));
    }
    
    private static <T extends Container> void register(String name, IContainerFactory<T> container)
    {
        ContainerType<T> type = IForgeContainerType.create(container);
        type.setRegistryName(name);
        CONTAINER_TYPES.add(type);
    }
}