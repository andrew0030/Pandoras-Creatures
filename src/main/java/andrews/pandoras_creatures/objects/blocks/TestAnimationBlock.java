package andrews.pandoras_creatures.objects.blocks;

import andrews.pandoras_creatures.animation.system.base.AnimatedBlockEntity;
import andrews.pandoras_creatures.block_entities.TestAnimationBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;

public class TestAnimationBlock extends BaseEntityBlock
{
    public TestAnimationBlock()
    {
        super(getProperties());
    }

    private static Properties getProperties()
    {
        Properties properties = Block.Properties.of(Material.STONE);
        properties.strength(1.5F, 6.0F);
        properties.noOcclusion();

        return properties;
    }

    @SuppressWarnings("deprecation")
    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit)
    {
        if(level.getBlockEntity(pos) instanceof TestAnimationBlockEntity blockEntity)
        {
            if(player.getItemInHand(hand).is(Items.STICK))
            {
                if (blockEntity.testAnimationState.isStarted())
                {
                    blockEntity.testAnimationState.stop();
                }
                else
                {
                    blockEntity.testAnimationState.start(blockEntity.getTicksExisted());
                }
            }
            else if(player.getItemInHand(hand).is(Items.BLAZE_ROD))
            {
                if (blockEntity.altAnimationState.isStarted())
                {
                    blockEntity.altAnimationState.stop();
                }
                else
                {
                    blockEntity.altAnimationState.interpolateAndStart(2F, blockEntity.getTicksExisted());
                }
            }
        }
        return InteractionResult.SUCCESS;
    }

    @SuppressWarnings("deprecation")
    @Override
    public RenderShape getRenderShape(BlockState state)
    {
        return RenderShape.MODEL;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state)
    {
        return new TestAnimationBlockEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType)
    {
        return (level1, pos, state1, blockEntity) -> TestAnimationBlockEntity.tick(level1, pos, state1, (AnimatedBlockEntity) blockEntity);
    }
}