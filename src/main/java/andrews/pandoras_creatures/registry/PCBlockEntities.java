package andrews.pandoras_creatures.registry;

import andrews.pandoras_creatures.block_entities.TestAnimationBlockEntity;
import andrews.pandoras_creatures.block_entities.render.TestAnimationBlockEntityRenderer;
import andrews.pandoras_creatures.util.Reference;
import com.google.common.collect.Sets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PCBlockEntities
{
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Reference.MODID);

    public static final RegistryObject<BlockEntityType<TestAnimationBlockEntity>> TEST_ANIMATION = BLOCK_ENTITY_TYPES.register("test_animation", () -> new BlockEntityType<>(TestAnimationBlockEntity::new, Sets.newHashSet(PCBlocks.TEST_ANIMATION.get()), null));

    public static void registerBlockEntityRenderers()
    {
        BlockEntityRenderers.register(TEST_ANIMATION.get(), TestAnimationBlockEntityRenderer::new);
    }
}