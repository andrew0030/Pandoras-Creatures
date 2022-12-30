package andrews.pandoras_creatures.animation;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.AnimationState;

public class AdvancedAnimationState extends AnimationState
{
    private float tickDelay = 0;

    @Override
    public void updateTime(float ageInTicks, float speed)
    {
        if(tickDelay != 0) {
            if((tickDelay - Mth.floor(ageInTicks)) <= 0) {
                this.startIfStopped(Mth.floor(ageInTicks));
                tickDelay = 0;
            }
        }
        super.updateTime(ageInTicks, speed);
    }

    public void startLater(int tickDelay, int ageInTicks)
    {
        this.tickDelay = tickDelay + ageInTicks;
    }
}