package andrews.pandoras_creatures.registry;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;

public class PCRenderLayers
{
	private static final RenderType CUTOUT = RenderType.getCutout();
	//May need these in the future.
//	private static final RenderType CUTOUT_MIPPED = RenderType.getCutoutMipped();
//	private static final RenderType TRANSLUSCENT = RenderType.getTranslucent();
	
	public static void setBlockRenderLayers()
	{
		RenderTypeLookup.setRenderLayer(PCBlocks.ARACHNON_CRYSTAL.get(), CUTOUT);
		RenderTypeLookup.setRenderLayer(PCBlocks.HORSETAIL.get(), CUTOUT);
		RenderTypeLookup.setRenderLayer(PCBlocks.DHANIA.get(), CUTOUT);
		RenderTypeLookup.setRenderLayer(PCBlocks.HILL_BLOOM.get(), CUTOUT);
	}
}