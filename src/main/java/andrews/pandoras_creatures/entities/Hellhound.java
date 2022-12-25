package andrews.pandoras_creatures.entities;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.level.Level;

public class Hellhound extends Wolf
{
    public Hellhound(EntityType<? extends Wolf> entityType, Level level)
    {
        super(entityType, level);
    }

    @Override
    protected void registerGoals()
    {

    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return null;
    }
}