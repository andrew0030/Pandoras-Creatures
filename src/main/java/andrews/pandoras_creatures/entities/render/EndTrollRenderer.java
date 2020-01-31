package andrews.pandoras_creatures.entities.render;

import andrews.pandoras_creatures.entities.EndTrollEntity;
import andrews.pandoras_creatures.entities.model.EndTrollModel;
import andrews.pandoras_creatures.entities.render.layer.RenderLayerEndTrollEye;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EndTrollRenderer extends MobRenderer<EndTrollEntity, EndTrollModel<EndTrollEntity>>
{
	public EndTrollRenderer(EntityRendererManager renderManager)
	{
        super(renderManager, new EndTrollModel<>(), 2.0F);
        this.addLayer(new RenderLayerEndTrollEye<>(this));
    }
	
	@Override
	protected ResourceLocation getEntityTexture(EndTrollEntity entity)
	{
		return new ResourceLocation(Reference.MODID, "textures/entity/end_troll/end_troll_1.png");
	}
}