package andrews.pandoras_creatures.registry;

import andrews.pandoras_creatures.entities.Hellhound;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PCEntities
{
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Reference.MODID);

    public static final RegistryObject<EntityType<Hellhound>> HELLHOUND     = ENTITIES.register("hellhound", () -> EntityType.Builder.of(Hellhound::new, MobCategory.CREATURE).sized(0.8F, 1.25F).clientTrackingRange(10).build(new ResourceLocation(Reference.MODID, "hellhound").toString()));

//    public static void registerSpawnPlacements() TODO add spawning
//    {
//        SpawnPlacements.register(DRAGONFLY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Dragonfly::checkDragonflySpawnRules);
//    }
}