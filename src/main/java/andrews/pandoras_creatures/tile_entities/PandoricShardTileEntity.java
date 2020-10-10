package andrews.pandoras_creatures.tile_entities;

import java.util.Random;

import andrews.pandoras_creatures.registry.PCTileEntities;
import net.minecraft.tileentity.TileEntity;

public class PandoricShardTileEntity extends TileEntity
{
	Random rand = new Random();
	private int animationDelay;
	
	public PandoricShardTileEntity()
	{
		super(PCTileEntities.PANDORIC_SHARD.get());
		this.animationDelay = this.rand.nextInt(60);
	}
	
	/**
	 * Called in PandoricShardTileEntityRenderer, to add some delay to the animations.
	 */
	public int getAnimationDelay()
	{
		return this.animationDelay;
	}
}
