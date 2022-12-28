package andrews.pandoras_creatures.entities.renderer.layers;

import andrews.pandoras_creatures.entities.Hellhound;
import andrews.pandoras_creatures.entities.model.HellhoundModel;
import andrews.pandoras_creatures.util.Reference;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class HellhoundGlowLayer<T extends Hellhound> extends RenderLayer<T, HellhoundModel<T>>
{
    private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(Reference.MODID, "textures/entity/hellhound_e.png"));

    public HellhoundGlowLayer(RenderLayerParent<T, HellhoundModel<T>> layerParent)
    {
        super(layerParent);
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, T entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch)
    {
        VertexConsumer vertexconsumer = buffer.getBuffer(TEXTURE);
        this.getParentModel().renderToBuffer(poseStack, vertexconsumer, 15728640, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
    }
}