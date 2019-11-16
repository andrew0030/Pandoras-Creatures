package andrews.pandoras_creatures.proxy;

import andrews.pandoras_creatures.entities.AcidicArchvineEntity;
import andrews.pandoras_creatures.entities.ArachnonEntity;
import andrews.pandoras_creatures.entities.BufflonEntity;
import andrews.pandoras_creatures.entities.CrabEntity;
import andrews.pandoras_creatures.entities.HellhoundEntity;
import andrews.pandoras_creatures.entities.SeahorseEntity;
import andrews.pandoras_creatures.entities.render.AcidicArchvineRenderer;
import andrews.pandoras_creatures.entities.render.ArachnonRenderer;
import andrews.pandoras_creatures.entities.render.BufflonRenderer;
import andrews.pandoras_creatures.entities.render.CrabRenderer;
import andrews.pandoras_creatures.entities.render.HellhoundRenderer;
import andrews.pandoras_creatures.entities.render.SeahorseRenderer;
import andrews.pandoras_creatures.gui.screen.BufflonScreen;
import andrews.pandoras_creatures.registry.PCContainers;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends ServerProxy
{
	@Override
	public void preInit()
	{
		super.preInit();
		//Tile Entities
//		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityElderEye.class, new TileEntityElderEyeRenderer());
		
		//Entities
		RenderingRegistry.registerEntityRenderingHandler(ArachnonEntity.class, manager -> new ArachnonRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(HellhoundEntity.class, manager -> new HellhoundRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(CrabEntity.class, manager -> new CrabRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(SeahorseEntity.class, manager -> new SeahorseRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(AcidicArchvineEntity.class, manager -> new AcidicArchvineRenderer(manager));
		RenderingRegistry.registerEntityRenderingHandler(BufflonEntity.class, manager -> new BufflonRenderer(manager));
		
		//ContainerScreens
		ScreenManager.registerFactory(PCContainers.BUFFLON, BufflonScreen::new);
	}
}
