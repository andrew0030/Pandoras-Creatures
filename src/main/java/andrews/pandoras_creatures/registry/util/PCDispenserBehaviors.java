package andrews.pandoras_creatures.registry.util;

import andrews.pandoras_creatures.objects.blocks.EndTrollBoxBlock;
import andrews.pandoras_creatures.objects.items.PCSpawnEggItem;
import andrews.pandoras_creatures.registry.PCBlocks;
import andrews.pandoras_creatures.registry.PCItems;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Direction;
import net.minecraftforge.fml.RegistryObject;

public class PCDispenserBehaviors
{
	static DefaultDispenseItemBehavior spawnEggItemBehavior = new DefaultDispenseItemBehavior()
	{
		public ItemStack dispenseStack(IBlockSource source, ItemStack stack)
		{
			Direction direction = source.getBlockState().get(DispenserBlock.FACING);
			EntityType<?> entitytype = ((SpawnEggItem) stack.getItem()).getType(stack.getTag());
			entitytype.spawn(source.getWorld(), stack, (PlayerEntity) null, source.getBlockPos().offset(direction), SpawnReason.DISPENSER, direction != Direction.UP, false);
			stack.shrink(1);
			return stack;
		}

	};

	public static void registerAll()
	{
		DispenserBlock.registerDispenseBehavior(PCBlocks.END_TROLL_BOX.get().asItem(), new EndTrollBoxBlock.EndTrollBoxDispenseBehavior());
		DispenserBlock.registerDispenseBehavior(PCBlocks.WHITE_END_TROLL_BOX.get().asItem(), new EndTrollBoxBlock.EndTrollBoxDispenseBehavior());
		DispenserBlock.registerDispenseBehavior(PCBlocks.ORANGE_END_TROLL_BOX.get().asItem(), new EndTrollBoxBlock.EndTrollBoxDispenseBehavior());
		DispenserBlock.registerDispenseBehavior(PCBlocks.MAGENTA_END_TROLL_BOX.get().asItem(), new EndTrollBoxBlock.EndTrollBoxDispenseBehavior());
		DispenserBlock.registerDispenseBehavior(PCBlocks.LIGHT_BLUE_END_TROLL_BOX.get().asItem(), new EndTrollBoxBlock.EndTrollBoxDispenseBehavior());
		DispenserBlock.registerDispenseBehavior(PCBlocks.YELLOW_END_TROLL_BOX.get().asItem(), new EndTrollBoxBlock.EndTrollBoxDispenseBehavior());
		DispenserBlock.registerDispenseBehavior(PCBlocks.LIME_END_TROLL_BOX.get().asItem(), new EndTrollBoxBlock.EndTrollBoxDispenseBehavior());
		DispenserBlock.registerDispenseBehavior(PCBlocks.PINK_END_TROLL_BOX.get().asItem(), new EndTrollBoxBlock.EndTrollBoxDispenseBehavior());
		DispenserBlock.registerDispenseBehavior(PCBlocks.GRAY_END_TROLL_BOX.get().asItem(), new EndTrollBoxBlock.EndTrollBoxDispenseBehavior());
		DispenserBlock.registerDispenseBehavior(PCBlocks.LIGHT_GRAY_END_TROLL_BOX.get().asItem(), new EndTrollBoxBlock.EndTrollBoxDispenseBehavior());
		DispenserBlock.registerDispenseBehavior(PCBlocks.CYAN_END_TROLL_BOX.get().asItem(), new EndTrollBoxBlock.EndTrollBoxDispenseBehavior());
		DispenserBlock.registerDispenseBehavior(PCBlocks.PURPLE_END_TROLL_BOX.get().asItem(), new EndTrollBoxBlock.EndTrollBoxDispenseBehavior());
		DispenserBlock.registerDispenseBehavior(PCBlocks.BLUE_END_TROLL_BOX.get().asItem(), new EndTrollBoxBlock.EndTrollBoxDispenseBehavior());
		DispenserBlock.registerDispenseBehavior(PCBlocks.BROWN_END_TROLL_BOX.get().asItem(), new EndTrollBoxBlock.EndTrollBoxDispenseBehavior());
		DispenserBlock.registerDispenseBehavior(PCBlocks.GREEN_END_TROLL_BOX.get().asItem(), new EndTrollBoxBlock.EndTrollBoxDispenseBehavior());
		DispenserBlock.registerDispenseBehavior(PCBlocks.RED_END_TROLL_BOX.get().asItem(), new EndTrollBoxBlock.EndTrollBoxDispenseBehavior());
		DispenserBlock.registerDispenseBehavior(PCBlocks.BLACK_END_TROLL_BOX.get().asItem(), new EndTrollBoxBlock.EndTrollBoxDispenseBehavior());
		
		for(RegistryObject<Item> items : PCItems.SPAWN_EGGS)
		{
    		Item item = items.get();
    		if(item instanceof PCSpawnEggItem)
    		{
    			DispenserBlock.registerDispenseBehavior(item, spawnEggItemBehavior);
    		}
    	}
	}
	
}