package andrews.pandoras_creatures.entities.render;

import andrews.pandoras_creatures.entities.SeahorseEntity;
import andrews.pandoras_creatures.entities.model.SeahorseModel;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SeahorseRenderer extends MobRenderer<SeahorseEntity, SeahorseModel<SeahorseEntity>>
{
	public SeahorseRenderer(EntityRendererManager renderManager)
	{
        super(renderManager, new SeahorseModel<>(), 0.2F);
    }
	
	@Override
	public ResourceLocation getEntityTexture(SeahorseEntity entity)
	{
		if(entity.getName().getString().equals("Mr.Sparkles"))
		{
			return new ResourceLocation(Reference.MODID, "textures/entity/seahorse/unicorn.png");
		}
		else
		{
			return new ResourceLocation(Reference.MODID, "textures/entity/seahorse/seahorse_" + entity.getSeahorseType() + ".png");
		}
	}
}