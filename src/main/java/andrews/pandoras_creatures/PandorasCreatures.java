package andrews.pandoras_creatures;

import andrews.pandoras_creatures.registry.PCBlockEntities;
import andrews.pandoras_creatures.registry.PCBlocks;
import andrews.pandoras_creatures.registry.PCEntities;
import andrews.pandoras_creatures.registry.PCItems;
import andrews.pandoras_creatures.util.Reference;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(value = Reference.MODID)
public class PandorasCreatures
{
    public PandorasCreatures()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(PCEntities::registerEntityAttributes);

        PCItems.ITEMS.register(modEventBus);
        PCBlocks.BLOCKS.register(modEventBus);
        PCBlockEntities.BLOCK_ENTITY_TYPES.register(modEventBus);
        PCEntities.ENTITIES.register(modEventBus);

        // Client Setup
        if (FMLEnvironment.dist == Dist.CLIENT) {
            PandorasCreaturesClient.setupClient();
        }
    }

    void setup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
//            PCEntities.registerSpawnPlacements();
        });
//        PCNetwork.setupMessages();
    }
}