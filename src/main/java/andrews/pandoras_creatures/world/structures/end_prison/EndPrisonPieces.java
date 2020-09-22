package andrews.pandoras_creatures.world.structures.end_prison;

public class EndPrisonPieces
{
//	private static final ResourceLocation LOCATION_MAIN = new ResourceLocation(Reference.MODID, "end_prison/end_prison_main");
//    private static final ResourceLocation LOCATION_BACK = new ResourceLocation(Reference.MODID, "end_prison/end_prison_back");
//    private static final ResourceLocation LOCATION_FRONT = new ResourceLocation(Reference.MODID, "end_prison/end_prison_front");
//    private static final ResourceLocation LOCATION_LEFT = new ResourceLocation(Reference.MODID, "end_prison/end_prison_left");
//    private static final ResourceLocation LOCATION_RIGHT = new ResourceLocation(Reference.MODID, "end_prison/end_prison_right");
//    private static final ResourceLocation LOCATION_SHIP = new ResourceLocation("end_city/ship");
//
//    public static class Piece extends TemplateStructurePiece
//    {
//        private final ResourceLocation templateLocation;
//        private final Rotation rotation;
//
//        public Piece(TemplateManager templateManager, BlockPos position, Rotation rotation, EndPrisonPiece pieceType)
//        {
//        	super(PCStructurePieces.END_PRISON_PIECE_TYPE, 0);
//            this.rotation = rotation;
//            this.templatePosition = position;
//            switch(pieceType)
//            {
//            default:
//			case MAIN:
//				this.templateLocation = LOCATION_MAIN;
//				break;
//			case BACK:
//				this.templateLocation = LOCATION_BACK;
//				break;
//			case FRONT:
//				this.templateLocation = LOCATION_FRONT;
//				break;
//			case LEFT:
//				this.templateLocation = LOCATION_LEFT;
//				break;
//			case RIGHT:
//				this.templateLocation = LOCATION_RIGHT;
//				break;
//			case SHIP:
//				this.templateLocation = LOCATION_SHIP;
//				break;
//			}
//            this.setup(templateManager, pieceType);
//        }
//
//        public Piece(TemplateManager templateManager, CompoundNBT compound)
//        {
//            super(PCStructurePieces.END_PRISON_PIECE_TYPE, compound);
//            this.templateLocation = new ResourceLocation(compound.getString("Template"));
//            this.rotation = Rotation.valueOf(compound.getString("Rot"));
//            this.setup(templateManager, null);
//        }
//
//        private void setup(TemplateManager templateManager, @Nullable EndPrisonPiece pieceType)
//        {
//            Template template = templateManager.getTemplateDefaulted(this.templateLocation);
//            PlacementSettings placementsettings = (new PlacementSettings()).setRotation(this.rotation).addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_BLOCK).addProcessor(JigsawReplacementStructureProcessor.INSTANCE);
//            this.setup(template, this.templatePosition, placementsettings);
//        }
//
//        @Override
//        protected void readAdditional(CompoundNBT compound)
//        {
//            super.readAdditional(compound);
//            compound.putString("Template", this.templateLocation.toString());
//            compound.putString("Rot", this.rotation.name());
//        }
//
//        @Override
//        protected void handleDataMarker(String function, BlockPos pos, IWorld worldIn, Random rand, MutableBoundingBox sbb)
//        {
//			if(function.startsWith("Chest"))
//			{
//				BlockPos blockpos = pos.down();
//				if(sbb.isVecInside(blockpos))
//				{
//					LockableLootTileEntity.setLootTable(worldIn, rand, blockpos, LootTables.CHESTS_END_CITY_TREASURE);
//				}
//			}
//			else if(function.startsWith("EndTroll"))
//			{
//				EndTrollEntity endTrollEntity = new EndTrollEntity(PCEntities.END_TROLL.get(), worldIn.getWorld());
//				endTrollEntity.setPosition((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D);
//				worldIn.addEntity(endTrollEntity);
//			}
//			else if(function.startsWith("Sentry"))
//			{
//				ShulkerEntity shulkerentity = EntityType.SHULKER.create(worldIn.getWorld());
//				shulkerentity.setPosition((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D);
//				shulkerentity.setAttachmentPos(pos);
//				worldIn.addEntity(shulkerentity);
//			}
//			else if(function.startsWith("Elytra"))
//			{
//				ItemFrameEntity itemframeentity = new ItemFrameEntity(worldIn.getWorld(), pos, this.rotation.rotate(Direction.SOUTH));
//				itemframeentity.setDisplayedItemWithUpdate(new ItemStack(Items.ELYTRA), false);
//				worldIn.addEntity(itemframeentity);
//			}
//        }
//
//        @Override
//        public boolean func_225577_a_(IWorld world, ChunkGenerator<?> generator, Random rand, MutableBoundingBox bounds, ChunkPos chunkPos)
//        {
//            this.templatePosition = new BlockPos(this.templatePosition.getX(), 120, this.templatePosition.getZ());
//            
//            return super.func_225577_a_(world, generator, rand, bounds, chunkPos);
//        }
//    }
}