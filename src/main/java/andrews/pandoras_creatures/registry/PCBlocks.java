package andrews.pandoras_creatures.registry;

import andrews.pandoras_creatures.objects.blocks.TestAnimationBlock;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class PCBlocks
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Reference.MODID);

    public static final RegistryObject<Block> TEST_ANIMATION = createBlock("test_animation", TestAnimationBlock::new);

    private static <B extends Block> RegistryObject<B> createBlock(String name, Supplier<? extends B> supplier)
    {
        RegistryObject<B> block = BLOCKS.register(name, supplier);
        PCItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }
}