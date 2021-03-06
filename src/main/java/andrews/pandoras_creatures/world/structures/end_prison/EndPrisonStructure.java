package andrews.pandoras_creatures.world.structures.end_prison;

import com.mojang.serialization.Codec;

import andrews.pandoras_creatures.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.jigsaw.JigsawManager;
import net.minecraft.world.gen.feature.structure.AbstractVillagePiece;
import net.minecraft.world.gen.feature.structure.MarginedStructureStart;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraft.world.gen.settings.StructureSeparationSettings;

public class EndPrisonStructure extends Structure<NoFeatureConfig>
{	
	public EndPrisonStructure(Codec<NoFeatureConfig> codec)
	{
		super(codec);
	}
	
	@Override
	public String getStructureName()
	{
		return Reference.MODID + ":end_prison";
	}
	
	@Override
	public Decoration getDecorationStage()
	{
		return GenerationStage.Decoration.SURFACE_STRUCTURES;
	}
	
	@Override
	public IStartFactory<NoFeatureConfig> getStartFactory()
	{
		return EndPrisonStructure.Start::new;
	}
	
	@Override
	protected boolean func_230363_a_(ChunkGenerator generator, BiomeProvider provider, long seed, SharedSeedRandom random, int x, int z, Biome biome, ChunkPos chunkPos, NoFeatureConfig config)
	{
		int i = x >> 4;
		int j = z >> 4;
		random.setSeed((long) (i ^ j << 4) ^ seed);
		random.nextInt();
		return !this.isEndCityWithin(generator, seed, random, x, z, 6);
	}
	
	private boolean isEndCityWithin(ChunkGenerator generator, long seed, SharedSeedRandom random, int x, int z, int radius)
	{
		StructureSeparationSettings structureseparationsettings = generator.func_235957_b_().func_236197_a_(Structure.END_CITY);
		if(structureseparationsettings != null)
		{
			for(int surroundingX = x - radius; surroundingX <= x + radius; ++surroundingX)
			{
				for(int surroundingZ = z - radius; surroundingZ <= z + radius; ++surroundingZ)
				{
					ChunkPos chunkpos = Structure.END_CITY.getChunkPosForStructure(structureseparationsettings, seed, random, surroundingX, surroundingZ);
					if(surroundingX == chunkpos.x && surroundingZ == chunkpos.z)
					{
						return true;
					}
				}
			}
		}
		return false;
	}

    public static class Start extends MarginedStructureStart<NoFeatureConfig>
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
            BlockPos blockpos = new BlockPos(chunkX * 16, 120, chunkZ * 16);

            //jigsaw time!
			JigsawManager.func_242837_a(
				dynamicRegistries,
				new VillageConfig(() -> dynamicRegistries.getRegistry(Registry.JIGSAW_POOL_KEY)// VillageConfig is actually JigsawConfig
				.getOrDefault(new ResourceLocation(Reference.MODID,"end_prison")), // template pool to start at
				3), // maximum number of pieces outward from center piece the jigsaw can generate.
				AbstractVillagePiece::new,
				generator,
				templateManager,
				blockpos,
				this.components,
				this.rand,
				true, // allow if jigsaw pieces can be partially intersecting instead of only allowing being fully enclosed or not intersecting at all.
				false); // place structure at terrain height
			
			EndPrisonPieces.addPieces(templateManager, blockpos, this.components.get(0).getRotation(), this.components, this.rand);

			this.recalculateStructureSize();
        }
    }
}