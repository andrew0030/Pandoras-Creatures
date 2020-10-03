package andrews.pandoras_creatures.registry;

import java.util.function.Supplier;

import com.google.common.collect.ImmutableMap;

import andrews.pandoras_creatures.util.Reference;
import andrews.pandoras_creatures.world.structures.end_prison.EndPrisonPieces;
import andrews.pandoras_creatures.world.structures.end_prison.EndPrisonStructure;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.FlatGenerationSettings;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PCStructures
{
	public static final DeferredRegister<Structure<?>> STRUCTURE_FEATURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, Reference.MODID);
	
	//End Prison
    public static final RegistryObject<Structure<NoFeatureConfig>> END_PRISON = registerStructure("end_prison", () -> (new EndPrisonStructure(NoFeatureConfig.field_236558_a_)));
    public static StructureFeature<NoFeatureConfig, ? extends Structure<NoFeatureConfig>> END_PRISON_FEATURE;
    public static final IStructurePieceType END_PRISON_PIECE = EndPrisonPieces.Piece::new;

    /**
     * Registers the StructureFeatures and the StructureSeparationSettings
     */
    public static void registerStructureFeaturesAndSeparation()
    {
    	//End Prison
    	END_PRISON_FEATURE = WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, Reference.MODID + ":end_prison", END_PRISON.get().func_236391_a_(NoFeatureConfig.field_236559_b_));
    	DimensionStructuresSettings.field_236191_b_ = ImmutableMap.<Structure<?>, StructureSeparationSettings>builder().putAll(DimensionStructuresSettings.field_236191_b_).put(END_PRISON.get(), new StructureSeparationSettings(32, 26, 43650246)).build();
        FlatGenerationSettings.STRUCTURES.put(END_PRISON.get(), END_PRISON_FEATURE);
        Registry.register(Registry.STRUCTURE_PIECE, new ResourceLocation(Reference.MODID, "end_prison_piece"), END_PRISON_PIECE);
    }

    /**
     * Structure Feature registration
     */
    private static <T extends Structure<?>> RegistryObject<T> registerStructure(String name, Supplier<T> structure)
    {   
    	Structure.field_236365_a_.put(Reference.MODID + ":" + name, structure.get());
        return STRUCTURE_FEATURES.register(name, structure);
    }
}
