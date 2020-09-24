package andrews.pandoras_creatures.registry;

import java.util.concurrent.Callable;

import andrews.pandoras_creatures.Main;
import andrews.pandoras_creatures.objects.blocks.BlockArachnonCrystal;
import andrews.pandoras_creatures.objects.blocks.BlockEndTrollBox;
import andrews.pandoras_creatures.objects.blocks.PCBlockBush;
import andrews.pandoras_creatures.registry.util.RegistryUtils;
import andrews.pandoras_creatures.tile_entities.EndTrollBoxTileEntity;
import andrews.pandoras_creatures.tile_entities.item.PCTileEntityItemRenderer;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.item.DyeColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PCBlocks
{
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Reference.MODID);
	
	public static final RegistryObject<Block> ARACHNON_CRYSTAL        	= RegistryUtils.createBlock("arachnon_crystal", () -> new BlockArachnonCrystal(), Main.PANDORAS_CREATURES_GROUP);
	public static final RegistryObject<Block> HORSETAIL         	  	= RegistryUtils.createBlock("horsetail", () -> new PCBlockBush(), Main.PANDORAS_CREATURES_GROUP);
	public static final RegistryObject<Block> DHANIA				 	= RegistryUtils.createBlock("dhania", () -> new PCBlockBush(), Main.PANDORAS_CREATURES_GROUP);
	public static final RegistryObject<Block> HILL_BLOOM			  	= RegistryUtils.createBlock("hill_bloom", () -> new PCBlockBush(), Main.PANDORAS_CREATURES_GROUP);
	
	//End Troll Boxes
	public static final RegistryObject<Block> END_TROLL_BOX	 		  	= RegistryUtils.createBlockWithTESIR("end_troll_box", () -> new BlockEndTrollBox(null), false, true, () -> endTrollBoxISTER(null), Main.PANDORAS_CREATURES_GROUP);
	public static final RegistryObject<Block> WHITE_END_TROLL_BOX	  	= RegistryUtils.createBlockWithTESIR("white_end_troll_box", () -> new BlockEndTrollBox(DyeColor.WHITE), false, true, () -> endTrollBoxISTER(DyeColor.WHITE), Main.PANDORAS_CREATURES_GROUP);
	public static final RegistryObject<Block> ORANGE_END_TROLL_BOX	  	= RegistryUtils.createBlockWithTESIR("orange_end_troll_box", () -> new BlockEndTrollBox(DyeColor.ORANGE), false, true, () -> endTrollBoxISTER(DyeColor.ORANGE), Main.PANDORAS_CREATURES_GROUP);
	public static final RegistryObject<Block> MAGENTA_END_TROLL_BOX	 	= RegistryUtils.createBlockWithTESIR("magenta_end_troll_box", () -> new BlockEndTrollBox(DyeColor.MAGENTA), false, true, () -> endTrollBoxISTER(DyeColor.MAGENTA), Main.PANDORAS_CREATURES_GROUP);
	public static final RegistryObject<Block> LIGHT_BLUE_END_TROLL_BOX	= RegistryUtils.createBlockWithTESIR("light_blue_end_troll_box", () -> new BlockEndTrollBox(DyeColor.LIGHT_BLUE), false, true, () -> endTrollBoxISTER(DyeColor.LIGHT_BLUE), Main.PANDORAS_CREATURES_GROUP);
	public static final RegistryObject<Block> YELLOW_END_TROLL_BOX		= RegistryUtils.createBlockWithTESIR("yellow_end_troll_box", () -> new BlockEndTrollBox(DyeColor.YELLOW), false, true, () -> endTrollBoxISTER(DyeColor.YELLOW), Main.PANDORAS_CREATURES_GROUP);
	public static final RegistryObject<Block> LIME_END_TROLL_BOX		= RegistryUtils.createBlockWithTESIR("lime_end_troll_box", () -> new BlockEndTrollBox(DyeColor.LIME), false, true, () -> endTrollBoxISTER(DyeColor.LIME), Main.PANDORAS_CREATURES_GROUP);
	public static final RegistryObject<Block> PINK_END_TROLL_BOX		= RegistryUtils.createBlockWithTESIR("pink_end_troll_box", () -> new BlockEndTrollBox(DyeColor.PINK), false, true, () -> endTrollBoxISTER(DyeColor.PINK), Main.PANDORAS_CREATURES_GROUP);
	public static final RegistryObject<Block> GRAY_END_TROLL_BOX		= RegistryUtils.createBlockWithTESIR("gray_end_troll_box", () -> new BlockEndTrollBox(DyeColor.GRAY), false, true, () -> endTrollBoxISTER(DyeColor.GRAY), Main.PANDORAS_CREATURES_GROUP);
	public static final RegistryObject<Block> LIGHT_GRAY_END_TROLL_BOX	= RegistryUtils.createBlockWithTESIR("light_gray_end_troll_box", () -> new BlockEndTrollBox(DyeColor.LIGHT_GRAY), false, true, () -> endTrollBoxISTER(DyeColor.LIGHT_GRAY), Main.PANDORAS_CREATURES_GROUP);
	public static final RegistryObject<Block> CYAN_END_TROLL_BOX		= RegistryUtils.createBlockWithTESIR("cyan_end_troll_box", () -> new BlockEndTrollBox(DyeColor.CYAN), false, true, () -> endTrollBoxISTER(DyeColor.CYAN), Main.PANDORAS_CREATURES_GROUP);
	public static final RegistryObject<Block> PURPLE_END_TROLL_BOX		= RegistryUtils.createBlockWithTESIR("purple_end_troll_box", () -> new BlockEndTrollBox(DyeColor.PURPLE), false, true, () -> endTrollBoxISTER(DyeColor.PURPLE), Main.PANDORAS_CREATURES_GROUP);
	public static final RegistryObject<Block> BLUE_END_TROLL_BOX		= RegistryUtils.createBlockWithTESIR("blue_end_troll_box", () -> new BlockEndTrollBox(DyeColor.BLUE), false, true, () -> endTrollBoxISTER(DyeColor.BLUE), Main.PANDORAS_CREATURES_GROUP);
	public static final RegistryObject<Block> BROWN_END_TROLL_BOX		= RegistryUtils.createBlockWithTESIR("brown_end_troll_box", () -> new BlockEndTrollBox(DyeColor.BROWN), false, true, () -> endTrollBoxISTER(DyeColor.BROWN), Main.PANDORAS_CREATURES_GROUP);
	public static final RegistryObject<Block> GREEN_END_TROLL_BOX		= RegistryUtils.createBlockWithTESIR("green_end_troll_box", () -> new BlockEndTrollBox(DyeColor.GREEN), false, true, () -> endTrollBoxISTER(DyeColor.GREEN), Main.PANDORAS_CREATURES_GROUP);
	public static final RegistryObject<Block> RED_END_TROLL_BOX			= RegistryUtils.createBlockWithTESIR("red_end_troll_box", () -> new BlockEndTrollBox(DyeColor.RED), false, true, () -> endTrollBoxISTER(DyeColor.RED), Main.PANDORAS_CREATURES_GROUP);
	public static final RegistryObject<Block> BLACK_END_TROLL_BOX		= RegistryUtils.createBlockWithTESIR("black_end_troll_box", () -> new BlockEndTrollBox(DyeColor.BLACK), false, true, () -> endTrollBoxISTER(DyeColor.BLACK), Main.PANDORAS_CREATURES_GROUP);
	
	@OnlyIn(Dist.CLIENT)
	private static Callable<ItemStackTileEntityRenderer> endTrollBoxISTER(DyeColor colorIn)
	{
		return () -> new PCTileEntityItemRenderer<TileEntity>(() -> new EndTrollBoxTileEntity(colorIn));
	}
}