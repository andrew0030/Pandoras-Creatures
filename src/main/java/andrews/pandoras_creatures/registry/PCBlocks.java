package andrews.pandoras_creatures.registry;

import andrews.pandoras_creatures.Main;
import andrews.pandoras_creatures.objects.blocks.BlockArachnonCrystal;
import andrews.pandoras_creatures.objects.blocks.PCBlockBush;
import andrews.pandoras_creatures.registry.util.RegistryUtils;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PCBlocks
{
	public static Block ARACHNON_CRYSTAL         			  = new BlockArachnonCrystal().setRegistryName(Reference.MODID, "arachnon_crystal");
	public static Block HORSETAIL         			 		  = new PCBlockBush().setRegistryName(Reference.MODID, "horsetail");
	public static Block DHANIA								  = new PCBlockBush().setRegistryName(Reference.MODID, "dhania");
	public static Block HILL_BLOOM							  = new PCBlockBush().setRegistryName(Reference.MODID, "hill_bloom");
	
	@SubscribeEvent
	public static void onRegisterBlocks(RegistryEvent.Register<Block> event)
	{
		final Block blocks[] =
		{
			ARACHNON_CRYSTAL,
			HORSETAIL,
			DHANIA,
			HILL_BLOOM
		};
		event.getRegistry().registerAll(blocks);
	}
	
	@SubscribeEvent
	public static void onRegisterItemBlocks(RegistryEvent.Register<Item> event)
	{
		final IForgeRegistry<Item> registry = event.getRegistry();
		
		registry.register(RegistryUtils.createSimpleItemBlock(ARACHNON_CRYSTAL, Main.PANDORAS_CREATURES_GROUP));
		registry.register(RegistryUtils.createSimpleItemBlock(HORSETAIL, Main.PANDORAS_CREATURES_GROUP));
		registry.register(RegistryUtils.createSimpleItemBlock(DHANIA, Main.PANDORAS_CREATURES_GROUP));
		registry.register(RegistryUtils.createSimpleItemBlock(HILL_BLOOM, Main.PANDORAS_CREATURES_GROUP));
	}	
}

