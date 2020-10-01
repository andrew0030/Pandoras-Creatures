package andrews.pandoras_creatures.world.structures.end_prison;

import java.util.List;
import java.util.Random;

import andrews.pandoras_creatures.entities.EndTrollEntity;
import andrews.pandoras_creatures.registry.PCEntities;
import andrews.pandoras_creatures.registry.PCStructures;
import andrews.pandoras_creatures.util.Reference;
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
	private static final ResourceLocation LOCATION_MAIN = new ResourceLocation(Reference.MODID, "end_prison/end_prison_main");
    private static final ResourceLocation LOCATION_BACK = new ResourceLocation(Reference.MODID, "end_prison/end_prison_back");
    private static final ResourceLocation LOCATION_FRONT = new ResourceLocation(Reference.MODID, "end_prison/end_prison_front");
    private static final ResourceLocation LOCATION_LEFT = new ResourceLocation(Reference.MODID, "end_prison/end_prison_left");
    private static final ResourceLocation LOCATION_RIGHT = new ResourceLocation(Reference.MODID, "end_prison/end_prison_right");
    private static final ResourceLocation LOCATION_SHIP = new ResourceLocation("end_city/ship");

	public static void addPieces(TemplateManager templateManager, BlockPos position, Rotation rotation, List<StructurePiece> pieces, Random random)
	{
		pieces.add(new EndPrisonPieces.Piece(templateManager, position, rotation, EndPrisonPiece.MAIN));
		pieces.add(new EndPrisonPieces.Piece(templateManager, getFrontBlockPos(position.getX(), position.getZ(), rotation), rotation, EndPrisonPiece.FRONT));
		pieces.add(new EndPrisonPieces.Piece(templateManager, getBackBlockPos(position.getX(), position.getZ(), rotation), rotation, EndPrisonPiece.BACK));
		pieces.add(new EndPrisonPieces.Piece(templateManager, getRightBlockPos(position.getX(), position.getZ(), rotation), rotation, EndPrisonPiece.RIGHT));
		pieces.add(new EndPrisonPieces.Piece(templateManager, getLeftBlockPos(position.getX(), position.getZ(), rotation), rotation, EndPrisonPiece.LEFT));
		if(random.nextInt(3) == 0)
		{
			pieces.add(new EndPrisonPieces.Piece(templateManager, getShipBlockPos(position.getX(), position.getZ(), rotation), getShipRotation(rotation), EndPrisonPiece.SHIP));
		}
	}

	public static class Piece extends TemplateStructurePiece
	{
	    protected final ResourceLocation structurePart;
	    protected final Rotation rotation;
	    
	    public Piece(TemplateManager templateManager, BlockPos position, Rotation rotation, EndPrisonPiece pieceType)
	    {
	    	super(PCStructures.END_PRISON_PIECE, 0);
	    	this.rotation = rotation;
	    	this.templatePosition = position;
	    	switch(pieceType)
            {
            default:
			case MAIN:
				this.structurePart = LOCATION_MAIN;
				break;
			case BACK:
				this.structurePart = LOCATION_BACK;
				break;
			case FRONT:
				this.structurePart = LOCATION_FRONT;
				break;
			case LEFT:
				this.structurePart = LOCATION_LEFT;
				break;
			case RIGHT:
				this.structurePart = LOCATION_RIGHT;
				break;
			case SHIP:
				this.structurePart = LOCATION_SHIP;
			}
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
			else if(function.startsWith("EndTroll"))
			{
				EndTrollEntity endTrollEntity = new EndTrollEntity(PCEntities.END_TROLL.get(), worldIn.getWorld());
				endTrollEntity.setPosition((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D);
				worldIn.addEntity(endTrollEntity);
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
			this.templatePosition = new BlockPos(this.templatePosition.getX(), 120, this.templatePosition.getZ());
			return super.func_230383_a_(seedReader, structureManager, chunkGenerator, randomIn, mutableBoundingBoxIn, chunkPosIn, blockPosIn);
		}
	}
	
	/**
	 * Used to get the correct position for the front piece of the End Prison.
	 */
	private static BlockPos getFrontBlockPos(int x, int z, Rotation rot)
	{
		switch(rot)
		{
		default:
		case NONE:
			return new BlockPos(x, 120, z + 31);
		case CLOCKWISE_90:
			return new BlockPos(x - 31, 120, z);
		case COUNTERCLOCKWISE_90:
			return new BlockPos(x + 31, 120, z);
		case CLOCKWISE_180:
			return new BlockPos(x, 120, z - 31);
		}
	}
	
	/**
	 * Used to get the correct position for the back piece of the End Prison.
	 */
	private static BlockPos getBackBlockPos(int x, int z, Rotation rot)
	{
		switch(rot)
		{
		default:
		case NONE:
			return new BlockPos(x, 120, z - 3);
		case CLOCKWISE_90:
			return new BlockPos(x + 3, 120, z);
		case COUNTERCLOCKWISE_90:
			return new BlockPos(x - 3, 120, z);
		case CLOCKWISE_180:
			return new BlockPos(x, 120, z + 3);
		}
	}
	
	/**
	 * Used to get the correct position for the right piece of the End Prison.
	 */
	private static BlockPos getRightBlockPos(int x, int z, Rotation rot)
	{
		switch(rot)
		{
		default:
		case NONE:
			return new BlockPos(x + 31, 120, z);
		case CLOCKWISE_90:
			return new BlockPos(x, 120, z + 31);
		case COUNTERCLOCKWISE_90:
			return new BlockPos(x, 120, z - 31);
		case CLOCKWISE_180:
			return new BlockPos(x - 31, 120, z);
		}
	}
	
	/**
	 * Used to get the correct position for the left piece of the End Prison.
	 */
	private static BlockPos getLeftBlockPos(int x, int z, Rotation rot)
	{
		switch(rot)
		{
		default:
		case NONE:
			return new BlockPos(x - 3, 120, z);
		case CLOCKWISE_90:
			return new BlockPos(x, 120, z - 3);
		case COUNTERCLOCKWISE_90:
			return new BlockPos(x, 120, z + 3);
		case CLOCKWISE_180:
			return new BlockPos(x + 3, 120, z);
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
			return new BlockPos(x + 1, 120, z + 57);
		case CLOCKWISE_90:
			return new BlockPos(x - 45, 120, z + 29);
		case COUNTERCLOCKWISE_90:
			return new BlockPos(x + 45, 120, z - 29);
		case CLOCKWISE_180:
			return new BlockPos(x - 1, 120, z - 57);
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
	
	/**
	 * The End Prison Piece Types
	 */
	public static enum EndPrisonPiece
	{
		MAIN, BACK, FRONT, LEFT, RIGHT, SHIP;
	}
}