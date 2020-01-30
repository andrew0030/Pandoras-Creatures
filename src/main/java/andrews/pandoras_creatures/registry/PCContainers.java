package andrews.pandoras_creatures.registry;

import andrews.pandoras_creatures.container.BufflonContainer;
import andrews.pandoras_creatures.gui.screen.BufflonScreen;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PCContainers
{
    public static final DeferredRegister<ContainerType<?>> CONTAINERS = new DeferredRegister<>(ForgeRegistries.CONTAINERS, Reference.MODID);
    
    public static final RegistryObject<ContainerType<BufflonContainer>> BUFFLON = createContainer("bufflon_container", BufflonContainer::new);
    
	@OnlyIn(Dist.CLIENT)
	public static void screenSetup()
	{
	    ScreenManager.registerFactory(PCContainers.BUFFLON.get(), BufflonScreen::new);
	}
	
	private static <C extends Container> RegistryObject<ContainerType<C>> createContainer(String name, IContainerFactory<C> container)
	{
	    return CONTAINERS.register(name, () -> IForgeContainerType.create(container));
	}
}