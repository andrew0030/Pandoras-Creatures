package andrews.pandoras_creatures;

import andrews.pandoras_creatures.registry.PCEntities;
import andrews.pandoras_creatures.util.Reference;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(value = Reference.MODID)
public class PandorasCreatures
{
    public PandorasCreatures()
    {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

//        PCItems.ITEMS.register(modEventBus);
//        PCBlocks.BLOCKS.register(modEventBus);
        PCEntities.ENTITIES.register(modEventBus);

        DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {
            modEventBus.addListener(this::setupClient);
        });
        modEventBus.addListener(this::setupCommon);

//        PCConfigs.registerConfigs();
    }

    void setupCommon(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
//            PCEntities.registerSpawnPlacements();
        });
        //Thread Safe Stuff Bellow
//        PCNetwork.setupMessages();
    }

    void setupClient(final FMLClientSetupEvent event)
    {
        event.enqueueWork(() -> {});
        // Thread Safe Stuff Bellow
    }
}