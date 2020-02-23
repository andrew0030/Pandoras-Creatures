package andrews.pandoras_creatures.world.structures;

//public class EndPrisonStructure extends Structure<NoFeatureConfig>
//{
//	public EndPrisonStructure(Function<Dynamic<?>, ? extends NoFeatureConfig> noFeatureConfig)
//	{
//		super(noFeatureConfig);
//	}
//
//	@Override
//	public boolean hasStartAt(ChunkGenerator<?> chunkGen, Random rand, int chunkPosX, int chunkPosZ)
//	{
//		return false;
//	}
//
//	@Override
//	public IStartFactory getStartFactory()
//	{
//		return null;
//	}
//
//	/**
//	 * The Structure Name
//	 */
//	@Override
//	public String getStructureName()
//	{
//		return "EndPrison";
//	}
//
//	@Override
//	public int getSize()
//	{
//		return 8;//TODO figure out what the fuck this is for
//	}
//	
//	private static int getYPosForStructure(int chunkX, int chunkY, ChunkGenerator<?> generatorIn)
//	{
//		Random random = new Random((long)(chunkX + chunkY * 10387313));
//		Rotation rotation = Rotation.values()[random.nextInt(Rotation.values().length)];
//      int i = 5;
//      int j = 5;
//      if (rotation == Rotation.CLOCKWISE_90) {
//         i = -5;
//      } else if (rotation == Rotation.CLOCKWISE_180) {
//         i = -5;
//         j = -5;
//      } else if (rotation == Rotation.COUNTERCLOCKWISE_90) {
//         j = -5;
//      }
//
//      int k = (chunkX << 4) + 7;
//      int l = (chunkY << 4) + 7;
//      int i1 = generatorIn.func_222531_c(k, l, Heightmap.Type.WORLD_SURFACE_WG);
//      int j1 = generatorIn.func_222531_c(k, l + j, Heightmap.Type.WORLD_SURFACE_WG);
//      int k1 = generatorIn.func_222531_c(k + i, l, Heightmap.Type.WORLD_SURFACE_WG);
//      int l1 = generatorIn.func_222531_c(k + i, l + j, Heightmap.Type.WORLD_SURFACE_WG);
//      return Math.min(Math.min(i1, j1), Math.min(k1, l1));
//   }
//
//	public static class Start extends StructureStart
//	{
//		public Start(Structure<?> structure, int chunkX, int chunkZ, Biome biome, MutableBoundingBox mutableBB, int p_i50437_6_, long p_i50437_7_)
//		{
//			super(structure, chunkX, chunkZ, biome, mutableBB, p_i50437_6_, p_i50437_7_);
//		}
//
//		public void init(ChunkGenerator<?> generator, TemplateManager templateManagerIn, int chunkX, int chunkZ, Biome biomeIn)
//		{
//			Rotation rotation = Rotation.values()[this.rand.nextInt(Rotation.values().length)];
//			int i = EndPrisonStructure.getYPosForStructure(chunkX, chunkZ, generator);
//			if(i >= 60)
//			{
//				BlockPos blockpos = new BlockPos(chunkX * 16 + 8, i, chunkZ * 16 + 8);
//				EndPrisonPieces.startHouseTower(templateManagerIn, blockpos, rotation, this.components, this.rand);
//				this.recalculateStructureSize();
//			}
//		}
//	}
//}
