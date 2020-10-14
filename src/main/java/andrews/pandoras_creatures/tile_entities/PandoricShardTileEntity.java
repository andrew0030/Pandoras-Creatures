package andrews.pandoras_creatures.tile_entities;

import java.util.Random;

import andrews.pandoras_creatures.registry.PCTileEntities;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;

public class PandoricShardTileEntity extends TileEntity
{
	Random rand = new Random();
	private int animationDelay;
	public int shardVariant;
	
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
	
	//Used to synchronize the TileEntity with the client onBlockUpdate
	@Override
	public SUpdateTileEntityPacket getUpdatePacket()
	{
		CompoundNBT compound = new CompoundNBT();
		this.saveToNBT(compound);
		return new SUpdateTileEntityPacket(this.getPos(), -1, compound);
	}
	
	//Used to synchronize the TileEntity with the client onBlockUpdate
	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt)
	{
		CompoundNBT compound = pkt.getNbtCompound();
	    this.loadFromNBT(compound);
	}
	
	//Used to synchronize the TileEntity with the client when the chunk it is in is loaded
	@Override
	public CompoundNBT getUpdateTag()
	{
		return this.write(new CompoundNBT());
	}
	
	//Used to synchronize the TileEntity with the client when the chunk it is in is loaded
	@Override
	public void handleUpdateTag(BlockState state, CompoundNBT compound)
	{
		this.read(state, compound);
	}
	
	@Override
	public CompoundNBT write(CompoundNBT compound)
	{
		super.write(compound);
		return this.saveToNBT(compound);
	}
	
	@Override
	public void read(BlockState state, CompoundNBT compound)
	{
		super.read(state, compound);
		this.loadFromNBT(compound);
	}
	
	/**
	 * Used to load data from the NBT
	 */
	private CompoundNBT saveToNBT(CompoundNBT compound)
	{
		CompoundNBT shardNBT = new CompoundNBT();
		shardNBT.putInt("ShardVariant", this.getShardVariant());
//		nbt.putInt("MaxChaosCharge", 0);
//		nbt.putInt("ChaosCharge", 0);
//		nbt.putInt("MaxCreationCharge", 0);
//		nbt.putInt("CreationCharge", 0);
		compound.put("PandoricShardValues", shardNBT);
		return compound;
	}
	
	/**
	 * Used to load data from the NBT
	 */
	private void loadFromNBT(CompoundNBT compound)
	{
		CompoundNBT shardNBT = compound.getCompound("PandoricShardValues");
		shardVariant = shardNBT.getInt("ShardVariant");
	}
	
	public int getShardVariant()
    {
    	if(shardVariant == 0)
    	{
    		Random rand = new Random();
    		//The check bellow makes sure a variant is only set server side, this way the first ticks during rendering (until synchronized)
    		//the client variant will be 0 meaning it wont render anything. This is used to prevent visual glitches.
    		if(!this.world.isRemote)
    		{
    			this.setShardVariant(rand.nextInt(2) + 1);
    			System.out.println(shardVariant);//TODO
    		}
    		return shardVariant;
    	}
    	else
    	{
    		return shardVariant;
    	}
	}
	
	public void setShardVariant(int variant)
	{
		shardVariant = variant;
		markDirty();
	}
}
