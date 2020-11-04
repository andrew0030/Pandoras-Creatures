package andrews.pandoras_creatures.tile_entities.item;

import java.util.function.Supplier;

import com.mojang.blaze3d.matrix.MatrixStack;

import andrews.pandoras_creatures.registry.PCBlocks;
import andrews.pandoras_creatures.tile_entities.PandoricShardTileEntity;
import andrews.pandoras_creatures.tile_entities.render.PandoricShardTileEntityRenderer;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class PCTileEntityItemRenderer<T extends TileEntity> extends ItemStackTileEntityRenderer
{	
	private final Supplier<T> te;
	
	public PCTileEntityItemRenderer(Supplier<T> te)
	{
		this.te = te;
	}
	
	/**
	 * The render method
	 */
	@Override
	public void func_239207_a_(ItemStack itemStack, TransformType type, MatrixStack matrixStack, IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay)
	{
		if(itemStack.getItem() == PCBlocks.PANDORIC_SHARD.get().asItem())
		{
			if(this.te.get() instanceof PandoricShardTileEntity)
			{
				PandoricShardTileEntity shardTileEntity = (PandoricShardTileEntity) this.te.get();
				shardTileEntity.setShardSize(1);
				shardTileEntity.setShardVariant(1);
				
				PandoricShardTileEntityRenderer.renderPandoricShard(shardTileEntity, matrixStack, buffer, combinedLight, combinedOverlay, true);
			}
		}
		else
		{
			TileEntityRendererDispatcher.instance.renderItem(this.te.get(), matrixStack, buffer, combinedLight, combinedOverlay);
		}
	}
}