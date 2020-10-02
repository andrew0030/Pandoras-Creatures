package andrews.pandoras_creatures.world.structures.end_prison;

import com.mojang.serialization.Codec;

import andrews.pandoras_creatures.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.jigsaw.JigsawManager;
import net.minecraft.world.gen.feature.structure.*;
import net.minecraft.world.gen.feature.template.TemplateManager;

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
	
	@Override		//getDecorationStage
	public Decoration func_236396_f_()
	{
		return GenerationStage.Decoration.SURFACE_STRUCTURES;
	}
	
	@Override
	public IStartFactory<NoFeatureConfig> getStartFactory()
	{
		return Start::new;
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
					new VillageConfig(() -> dynamicRegistries.getRegistry(Registry.JIGSAW_POOL_KEY)
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

			this.recalculateStructureSize();
        }
    }
}