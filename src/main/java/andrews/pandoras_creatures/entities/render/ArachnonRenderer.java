package andrews.pandoras_creatures.entities.render;

import andrews.pandoras_creatures.entities.ArachnonEntity;
import andrews.pandoras_creatures.entities.model.ArachnonModel;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ArachnonRenderer extends MobRenderer<ArachnonEntity, ArachnonModel<ArachnonEntity>>
{
	public ArachnonRenderer(EntityRendererManager renderManager)
	{
        super(renderManager, new ArachnonModel<>(), 1.5F);
    }
	
	@Override
	protected ResourceLocation getEntityTexture(ArachnonEntity entity)
	{
		return new ResourceLocation(Reference.MODID, "textures/entity/arachnon.png");
	}
}