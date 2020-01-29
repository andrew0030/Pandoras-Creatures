package andrews.pandoras_creatures.registry;

import andrews.pandoras_creatures.Main;
import andrews.pandoras_creatures.objects.blocks.BlockArachnonCrystal;
import andrews.pandoras_creatures.objects.blocks.PCBlockBush;
import andrews.pandoras_creatures.registry.util.RegistryUtils;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PCBlocks
{
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Reference.MODID);
	
	public static final RegistryObject<Block> ARACHNON_CRYSTAL        = RegistryUtils.createBlock("arachnon_crystal", () -> new BlockArachnonCrystal(), Main.PANDORAS_CREATURES_GROUP);
	public static final RegistryObject<Block> HORSETAIL         	  = RegistryUtils.createBlock("horsetail", () -> new PCBlockBush(), Main.PANDORAS_CREATURES_GROUP);
	public static final RegistryObject<Block> DHANIA				  = RegistryUtils.createBlock("dhania", () -> new PCBlockBush(), Main.PANDORAS_CREATURES_GROUP);
	public static final RegistryObject<Block> HILL_BLOOM			  = RegistryUtils.createBlock("hill_bloom", () -> new PCBlockBush(), Main.PANDORAS_CREATURES_GROUP);
}