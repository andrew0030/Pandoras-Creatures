package andrews.pandoras_creatures;

import andrews.pandoras_creatures.block_entities.model.TestAnimationModel;
import andrews.pandoras_creatures.entities.model.HellhoundModel;
import andrews.pandoras_creatures.entities.renderer.HellhoundRenderer;
import andrews.pandoras_creatures.registry.PCBlockEntities;
import andrews.pandoras_creatures.registry.PCEntities;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class PandorasCreaturesClient
{
    public static void setupClient()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(PandorasCreaturesClient::setup);
        modEventBus.addListener(PandorasCreaturesClient::registerLayerDefinitions);
        modEventBus.addListener(PandorasCreaturesClient::registerEntityRenderers);
    }

    public static void setup(FMLClientSetupEvent event)
    {
        event.enqueueWork(() -> {
            PCBlockEntities.registerBlockEntityRenderers();
        });
    }

    // Registers the LayerDefinitions
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(HellhoundModel.LAYER, HellhoundModel::createBodyLayer);
        event.registerLayerDefinition(TestAnimationModel.LAYER, TestAnimationModel::createBodyLayer);}

    // Registers the EntityRenderers
    private static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event)
    {
        event.registerEntityRenderer(PCEntities.HELLHOUND.get(), HellhoundRenderer::new);
    }
}