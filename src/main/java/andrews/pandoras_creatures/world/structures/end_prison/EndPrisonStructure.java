package andrews.pandoras_creatures.world.structures.end_prison;

import com.mojang.serialization.Codec;

import andrews.pandoras_creatures.util.Reference;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class EndPrisonStructure extends Structure<NoFeatureConfig>
{	
	private static final int RARITY = 32; //TODO figure out a good value
	
	public EndPrisonStructure(Codec<NoFeatureConfig> codec)
	{
		super(codec);
	}

	@Override
	public String getStructureName()
	{
		return Reference.MODID + ":end_prison";
	}
	
	/**
	 * @return - The structure size
	 */
	private int getSize()
	{
		return 8;
	}
	
	@Override
	public Decoration func_236396_f_()
	{
		return GenerationStage.Decoration.SURFACE_STRUCTURES;
	}
	
	/**
	 * @return - The seed modifier
	 */
	protected int getSeedModifier()
	{
        return 0;
    }
	
	/**
	 * @return - The separation modifier
	 */
	protected int getSeparationModifier()
	{
        return 5;
    }
	
	@Override
	public IStartFactory<NoFeatureConfig> getStartFactory()
	{
		return Start::new;
	}
	
//	@Override
//    protected boolean func_230365_b_()//TODO figure out what this is
//	{
//        return false;
//    }
	
//	@Nullable
//    @Override
//    public BlockPos func_236388_a_(IWorldReader world, StructureManager manager, BlockPos pos, int radius, boolean skipExistingChunks, long seed, StructureSeparationSettings separationSettings)
//	{
//        return super.func_236388_a_(world, manager, pos, radius, skipExistingChunks, seed, new StructureSeparationSettings(RARITY, getSeparationModifier(), getSeedModifier()));//TODO replace first int (rarity)
//    }

	/**
	 * This method is something like:
	 * canBeGenerated
	 */
//    @Override
//    protected boolean func_230363_a_(ChunkGenerator generator, BiomeProvider provider, long seed, SharedSeedRandom rand, int x, int z, Biome biome, ChunkPos chunkPos, NoFeatureConfig config)
//    {
//        return isSurfaceFlat(generator, x, z);
//    }
//
//    protected boolean isSurfaceFlat(@Nonnull ChunkGenerator generator, int chunkX, int chunkZ)
//    {
//        // Size of the area to check.
//        int offset = getSize() * 16;
//
//        int xStart = (chunkX << 4);
//        int zStart = (chunkZ << 4);
//
//        int i1 = generator.getNoiseHeightMinusOne(xStart, zStart, Heightmap.Type.WORLD_SURFACE_WG);
//        int j1 = generator.getNoiseHeightMinusOne(xStart, zStart + offset, Heightmap.Type.WORLD_SURFACE_WG);
//        int k1 = generator.getNoiseHeightMinusOne(xStart + offset, zStart, Heightmap.Type.WORLD_SURFACE_WG);
//        int l1 = generator.getNoiseHeightMinusOne(xStart + offset, zStart + offset, Heightmap.Type.WORLD_SURFACE_WG);
//        int minHeight = Math.min(Math.min(i1, j1), Math.min(k1, l1));
//        int maxHeight = Math.max(Math.max(i1, j1), Math.max(k1, l1));
//        return Math.abs(maxHeight - minHeight) <= 20;
//    }

    /**
     * This method is something like:
     * getChunkPosForStructure
     */
//    @Override
//    public ChunkPos func_236392_a_(StructureSeparationSettings separationSettings, long seed, SharedSeedRandom rand, int x, int z)
//    {
//        int spacing = RARITY;
//        int gridX = ((x / spacing) * spacing);
//        int gridZ = ((z / spacing) * spacing);
//
//        int offset = getSeparationModifier() + 1;
//        rand.setLargeFeatureSeedWithSalt(seed, gridX, gridZ, this.getSeedModifier());
//        int offsetX = rand.nextInt(offset);
//        int offsetZ = rand.nextInt(offset);
//
//        int gridOffsetX = gridX + offsetX;
//        int gridOffsetZ = gridZ + offsetZ;
//
//        return new ChunkPos(gridOffsetX, gridOffsetZ);
//    }

    public static class Start extends StructureStart<NoFeatureConfig>
    {
    	public Start(Structure<NoFeatureConfig> structure, int x, int z, MutableBoundingBox boundingBox, int refCount, long seed)
    	{
            super(structure, x, z, boundingBox, refCount, seed);
        }

    	/**
    	 * This method is something like:
    	 * init
    	 */
        @Override
        public void func_230364_a_(DynamicRegistries dynamicRegistries, ChunkGenerator generator, TemplateManager templateManager, int chunkX, int chunkZ, Biome biomeIn, NoFeatureConfig config)
        {
            int x = chunkX * 16;
            int z = chunkZ * 16;
            BlockPos blockpos = new BlockPos(x, 120, z); //TODO figure out why this is 90??
            Rotation rotation = Rotation.values()[this.rand.nextInt(Rotation.values().length)];
            /*
             * this.components is an Array that stores all the pieces of a Structure, I used it in the old version, by passing it
             * here all the Pieces will be added to that Array.
             */
            EndPrisonPieces.addPieces(templateManager, blockpos, rotation, this.components, this.rand);
            this.recalculateStructureSize();
        }
    }
}