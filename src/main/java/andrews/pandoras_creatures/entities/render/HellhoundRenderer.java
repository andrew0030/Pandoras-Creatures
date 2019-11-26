package andrews.pandoras_creatures.entities.render;

import andrews.pandoras_creatures.entities.HellhoundEntity;
import andrews.pandoras_creatures.entities.model.HellhoundModel;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HellhoundRenderer extends MobRenderer<HellhoundEntity, HellhoundModel<HellhoundEntity>>
{
	public HellhoundRenderer(EntityRendererManager renderManager)
	{
        super(renderManager, new HellhoundModel<>(), 0.6F);
    }
	
	@Override
	protected ResourceLocation getEntityTexture(HellhoundEntity entity)
	{
		return new ResourceLocation(Reference.MODID, "textures/entity/hellhound/hellhound_" + entity.getHellhoundType() + ".png");
	}
}