package andrews.pandoras_creatures.block_entities;

import andrews.pandoras_creatures.animation.system.base.AnimatedBlockEntity;
import andrews.pandoras_creatures.animation.system.core.AdvancedAnimationState;
import andrews.pandoras_creatures.block_entities.animations.TestAnimationAnimations;
import andrews.pandoras_creatures.registry.PCBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class TestAnimationBlockEntity extends AnimatedBlockEntity
{
    public final List<AdvancedAnimationState> lingeringStates = new ArrayList<>();
    public final AdvancedAnimationState testAnimationState = new AdvancedAnimationState(new AtomicReference<>());
    public final AdvancedAnimationState altAnimationState = new AdvancedAnimationState(new AtomicReference<>());

    public TestAnimationBlockEntity(BlockPos pos, BlockState state)
    {
        this(PCBlockEntities.TEST_ANIMATION.get(), pos, state);
    }

    public TestAnimationBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState)
    {
        super(type, pos, blockState);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
            testAnimationState.setAnimation(TestAnimationAnimations.MY_ANIMATION);
            altAnimationState.setAnimation(TestAnimationAnimations.MY_ALT_ANIMATION);
        });
    }

    public static void tick(Level level, BlockPos pos, BlockState state, AnimatedBlockEntity blockEntity)
    {
        blockEntity.incTicksExisted();
    }
}