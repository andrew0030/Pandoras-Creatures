package andrews.pandoras_creatures.entities.render;

import andrews.pandoras_creatures.entities.BufflonEntity;
import andrews.pandoras_creatures.entities.model.BufflonModel;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BufflonRenderer extends MobRenderer<BufflonEntity, BufflonModel<BufflonEntity>>
{
	public BufflonRenderer(EntityRendererManager renderManager)
	{
        super(renderManager, new BufflonModel<>(), 0.3F);
    }
	
	@Override
	protected ResourceLocation getEntityTexture(BufflonEntity entity)
	{
		return new ResourceLocation(Reference.MODID, "textures/entity/bufflon/bufflon_1.png");
	}
}
