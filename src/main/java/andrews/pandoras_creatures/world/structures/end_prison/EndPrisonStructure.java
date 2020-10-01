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
            BlockPos blockpos = new BlockPos(x, 120, z);
            Rotation rotation = Rotation.randomRotation(this.rand);
            /*
             * this.components is an Array that stores all the pieces of a Structure, I used it in the old version, by passing it
             * here all the Pieces will be added to that Array.
             */
            EndPrisonPieces.addPieces(templateManager, blockpos, rotation, this.components, this.rand);
            this.recalculateStructureSize();
        }
    }
}