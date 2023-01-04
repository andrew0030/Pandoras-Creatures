package andrews.pandoras_creatures.block_entities;

import andrews.pandoras_creatures.animation.system.base.AnimatedBlockEntity;
import andrews.pandoras_creatures.animation.system.wrap.AdvancedAnimationState;
import andrews.pandoras_creatures.block_entities.animations.TestAnimationAnimations;
import andrews.pandoras_creatures.registry.PCBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class TestAnimationBlockEntity extends AnimatedBlockEntity
{
    public final AdvancedAnimationState testAnimationState = new AdvancedAnimationState(TestAnimationAnimations.TEST_ANIMATION, this.rotationCache, this.cachedKeyframeIdx);

    public TestAnimationBlockEntity(BlockPos pos, BlockState state)
    {
        this(PCBlockEntities.TEST_ANIMATION.get(), pos, state);
    }

    public TestAnimationBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState)
    {
        super(type, pos, blockState);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, AnimatedBlockEntity blockEntity)
    {
        blockEntity.incTicksExisted();
    }
}