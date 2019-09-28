package andrews.pandoras_creatures;

import andrews.pandoras_creatures.entities.ArachnonEntity;
import andrews.pandoras_creatures.entities.CrabEntity;
import andrews.pandoras_creatures.entities.HellhoundEntity;
import andrews.pandoras_creatures.entities.SeahorseEntity;
import andrews.pandoras_creatures.item_groups.PCItemGroup;
import andrews.pandoras_creatures.proxy.ClientProxy;
import andrews.pandoras_creatures.proxy.ServerProxy;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(value = Reference.MODID)
public class Main
{
	public static Main instance;
	public static ServerProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> ServerProxy::new);
	public static final ItemGroup PANDORAS_CREATURES_GROUP = new PCItemGroup();

	public Main()
	{
		instance = this;
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupCommon);
//		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::jarCheck);
	}
	
//	private void jarCheck(final FMLFingerprintViolationEvent event)
//	{
//		new RehostedJarHandler(event.getSource(), "pandoras_creatures-" + Reference.VERSION + ".jar");
//	}
	
	private void setupCommon(final FMLCommonSetupEvent event)
	{
		proxy.preInit();
		ArachnonEntity.addSpawn();
		HellhoundEntity.addSpawn();
		CrabEntity.addSpawn();
		SeahorseEntity.addSpawn();
	}
}