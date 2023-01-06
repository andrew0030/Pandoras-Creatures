package andrews.pandoras_creatures.animation.system.base;

import andrews.pandoras_creatures.animation.system.custom.KeyframeGroup;
import com.google.common.collect.Maps;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.joml.Vector3f;

import java.util.Map;

public class AnimatedBlockEntity extends BlockEntity
{
    public Map<String, Vector3f> rotationCache = Maps.newHashMap();
    public String cachedLastPart;
    public Map<KeyframeGroup, Integer> cachedKeyframeIdx = Maps.newHashMap();
    private int ticksExisted;

    public AnimatedBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState)
    {
        super(type, pos, blockState);
    }

    /**
     * This method needs to be called inside the tick() method
     */
    public void incTicksExisted()
    {
        this.ticksExisted++;
    }

    public int getTicksExisted()
    {
        return this.ticksExisted;
    }
}