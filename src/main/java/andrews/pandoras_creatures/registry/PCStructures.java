package andrews.pandoras_creatures.registry;

import java.util.function.Supplier;

import andrews.pandoras_creatures.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PCStructures
{
	public static final DeferredRegister<Structure<?>> STRUCTURE_FEATURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, Reference.MODID);
	
	//Structures
    public static final RegistryObject<Structure<NoFeatureConfig>> END_PRISON = registerStructure("end_prison", () -> (new EndPrisonStructure(NoFeatureConfig.field_236558_a_)));

    //Structure Pieces
    public static final IStructurePieceType END_PRISON_PIECE = EndPrisonPieces.Piece::new;
    
    /**
     * Structure Feature registration
     */
    private static <T extends Structure<?>> RegistryObject<T> registerStructure(String name, Supplier<T> structure)
    {
        Structure.field_236365_a_.put(Reference.MODID + ":" + name, structure.get());
        Structure.field_236385_u_.put(structure.get(), GenerationStage.Decoration.SURFACE_STRUCTURES);
        
        return STRUCTURE_FEATURES.register(name, structure);
    }
    
    /**
     * Registers all StructurePieces
     */
    public static void registerPieces()
    {
        registerPiece("end_prison_piece", END_PRISON_PIECE);
    }

    /**
     * Method to register a StructurePiece
     * @param key - The name of the StructurePiece
     * @param type - The StructurePieceType of the StructurePiece
     */
    private static void registerPiece(String key, IStructurePieceType type)
    {
        Registry.register(Registry.STRUCTURE_PIECE, new ResourceLocation(Reference.MODID, key), type);
    }
}
