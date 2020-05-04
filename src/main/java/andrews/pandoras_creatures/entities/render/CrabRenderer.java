package andrews.pandoras_creatures.entities.render;

import andrews.pandoras_creatures.entities.CrabEntity;
import andrews.pandoras_creatures.entities.model.CrabModel;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CrabRenderer extends MobRenderer<CrabEntity, CrabModel<CrabEntity>>
{
	public CrabRenderer(EntityRendererManager renderManager)
	{
        super(renderManager, new CrabModel<>(), 0.3F);
    }
	
	@Override
	public ResourceLocation getEntityTexture(CrabEntity entity)
	{
		return new ResourceLocation(Reference.MODID, "textures/entity/crab/crab_" + entity.getCrabType() + ".png");
	}
}