package andrews.pandoras_creatures.world;

import andrews.pandoras_creatures.util.Reference;
import andrews.pandoras_creatures.world.structures.end_prison.EndPrisonPieces;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;

public class PCStructurePieces
{
	public static final IStructurePieceType END_PRISON_PIECE_TYPE = register(EndPrisonPieces.Piece::new, Reference.MODID + ":end_prison_piece");

    public static void init() {} //Force static fields to initialize

    private static IStructurePieceType register(IStructurePieceType type, String key)
    {
        return Registry.register(Registry.STRUCTURE_PIECE, new ResourceLocation(key), type);
    }
}
