package andrews.pandoras_creatures.world.structures.end_prison;

import java.util.List;
import java.util.Random;

import andrews.pandoras_creatures.registry.PCStructures;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.ItemFrameEntity;
import net.minecraft.entity.monster.ShulkerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTables;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.structure.TemplateStructurePiece;
import net.minecraft.world.gen.feature.template.BlockIgnoreStructureProcessor;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class EndPrisonPieces
{
    private static final ResourceLocation LOCATION_SHIP = new ResourceLocation("end_city/ship");

	public static void addPieces(TemplateManager templateManager, BlockPos position, Rotation rotation, List<StructurePiece> pieces, Random random)
	{
		if(random.nextInt(3) == 0)
		{
			pieces.add(new EndPrisonPieces.Piece(templateManager, getShipBlockPos(position.getX(), position.getZ(), rotation), getShipRotation(rotation)));
		}
	}

	public static class Piece extends TemplateStructurePiece
	{
	    protected final ResourceLocation structurePart;
	    protected final Rotation rotation;
	    
	    public Piece(TemplateManager templateManager, BlockPos position, Rotation rotation)
	    {
	    	super(PCStructures.END_PRISON_PIECE, 0);
	    	this.rotation = rotation;
	    	this.templatePosition = position;
			this.structurePart = LOCATION_SHIP;
            this.loadTemplate(templateManager);
        }
	    
	    public Piece(TemplateManager templateManager, CompoundNBT nbt)
	    {
	    	super(PCStructures.END_PRISON_PIECE, nbt);
            this.structurePart = new ResourceLocation(nbt.getString("Template"));
            this.rotation = Rotation.valueOf(nbt.getString("Rot"));
	        this.loadTemplate(templateManager);
		}

	    /**
	     * Handles the Template loading
	     */
	    private void loadTemplate(TemplateManager templateManager)
	    {
	    	Template template = templateManager.getTemplateDefaulted(this.structurePart);
	    	PlacementSettings placementsettings = (new PlacementSettings()).setRotation(this.rotation).setMirror(Mirror.NONE).addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_BLOCK);
	    	this.setup(template, this.templatePosition, placementsettings);
	    }
		
		/**
		 * (abstract) Helper method to read subclass data from NBT
		 */
		@Override
		protected void readAdditional(CompoundNBT tagCompound)
		{
			super.readAdditional(tagCompound);
	        tagCompound.putString("Template", this.structurePart.toString());
	        tagCompound.putString("Rot", this.rotation.name());
		}
		
		/**
		 * Basically this checks the Structure Piece for DataMarker blocks and does the specified action when finding one
		 */
		@Override
		protected void handleDataMarker(String function, BlockPos pos, IServerWorld worldIn, Random rand, MutableBoundingBox sbb)
		{
			if(function.startsWith("Chest"))
			{
				BlockPos blockpos = pos.down();
				if(sbb.isVecInside(blockpos))
				{
					LockableLootTileEntity.setLootTable(worldIn, rand, blockpos, LootTables.CHESTS_END_CITY_TREASURE);
				}
			}
			else if(function.startsWith("Sentry"))
			{
				ShulkerEntity shulkerentity = EntityType.SHULKER.create(worldIn.getWorld());
				shulkerentity.setPosition((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D);
				shulkerentity.setAttachmentPos(pos);
				worldIn.addEntity(shulkerentity);
			}
			else if(function.startsWith("Elytra"))
			{
				ItemFrameEntity itemframeentity = new ItemFrameEntity(worldIn.getWorld(), pos, this.rotation.rotate(Direction.SOUTH));
				itemframeentity.setDisplayedItemWithUpdate(new ItemStack(Items.ELYTRA), false);
				worldIn.addEntity(itemframeentity);
			}
		}
		
		/**
    	 * This method is something like:
    	 * place
    	 */
		@Override
		public boolean func_230383_a_(ISeedReader seedReader, StructureManager structureManager, ChunkGenerator chunkGenerator, Random randomIn, MutableBoundingBox mutableBoundingBoxIn, ChunkPos chunkPosIn, BlockPos blockPosIn)
		{
			this.templatePosition = new BlockPos(this.templatePosition.getX(), 123, this.templatePosition.getZ());
			return super.func_230383_a_(seedReader, structureManager, chunkGenerator, randomIn, mutableBoundingBoxIn, chunkPosIn, blockPosIn);
		}
	}
	
	/**
	 * Used to get the correct position for the ship piece of the End Prison.
	 */
	private static BlockPos getShipBlockPos(int x, int z, Rotation rot)
	{
		switch(rot)
		{
		default:
		case NONE:
			return new BlockPos(x + 5, 123, z - 8);
		case CLOCKWISE_90:
			return new BlockPos(x + 20, 123, z + 33);
		case COUNTERCLOCKWISE_90:
			return new BlockPos(x - 20, 123, z - 33);
		case CLOCKWISE_180:
			return new BlockPos(x - 5, 123, z + 8);
		}
	}
	
	/**
	 * Used to adjust the rotation of the ship.
	 * @param rot - The Rotation of the End Prison
	 */
	private static Rotation getShipRotation(Rotation rot)
	{
		switch(rot)
		{
		default:
		case NONE:
			return Rotation.COUNTERCLOCKWISE_90;
		case CLOCKWISE_90:
			return Rotation.CLOCKWISE_180;
		case COUNTERCLOCKWISE_90:
			return Rotation.NONE;
		case CLOCKWISE_180:
			return Rotation.CLOCKWISE_90;
		}
	}
}