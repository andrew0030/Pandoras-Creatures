package andrews.pandoras_creatures.entities.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EndTrollBulletModel<T extends Entity> extends SegmentedModel<T>
{
	public ModelRenderer renderer;

	public EndTrollBulletModel()
	{
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.renderer = new ModelRenderer(this);
		this.renderer.setTextureOffset(0, 0).addBox(-4.0F, -4.0F, -1.0F, 8, 8, 2, 0.0F);
		this.renderer.setTextureOffset(0, 10).addBox(-1.0F, -4.0F, -4.0F, 2, 8, 8, 0.0F);
		this.renderer.setTextureOffset(20, 0).addBox(-4.0F, -1.0F, -4.0F, 8, 2, 8, 0.0F);
		this.renderer.setRotationPoint(0.0F, 0.0F, 0.0F);
	}

	@Override
	public Iterable<ModelRenderer> getParts()
	{
		return ImmutableList.of(this.renderer);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
		this.renderer.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
		this.renderer.rotateAngleX = headPitch * ((float) Math.PI / 180F);
	}
}