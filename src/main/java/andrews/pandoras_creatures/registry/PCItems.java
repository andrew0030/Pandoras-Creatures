package andrews.pandoras_creatures.registry;

import andrews.pandoras_creatures.util.Reference;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PCItems
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MODID);

    public static final RegistryObject<Item> HELLHOUND_SPAWN_EGG    = ITEMS.register("hellhound_spawn_egg", () -> new ForgeSpawnEggItem(PCEntities.HELLHOUND, 0xf5f3f0, 0xfc750d, new Item.Properties()));
}