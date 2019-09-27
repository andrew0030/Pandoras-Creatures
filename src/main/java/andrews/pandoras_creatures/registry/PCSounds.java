package andrews.pandoras_creatures.registry;

import java.util.List;

import com.google.common.collect.Lists;

import andrews.pandoras_creatures.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

@EventBusSubscriber(modid = Reference.MODID, bus = EventBusSubscriber.Bus.MOD)
@ObjectHolder(Reference.MODID)
public class PCSounds
{
	private static List<SoundEvent> sounds = Lists.newArrayList();
	public static final SoundEvent ARACHNON_AMBIENT = createSound("entity.arachnon.ambient");
	public static final SoundEvent ARACHNON_HURT = createSound("entity.arachnon.hurt");
	public static final SoundEvent ARACHNON_DEATH = createSound("entity.arachnon.death");
	public static final SoundEvent HELLHOUND_AMBIENT = createSound("entity.hellhound.ambient");
	public static final SoundEvent HELLHOUND_HURT = createSound("entity.hellhound.hurt");
	public static final SoundEvent HELLHOUND_DEATH = createSound("entity.hellhound.death");
	public static final SoundEvent CRAB_HURT = createSound("entity.crab.hurt");
	public static final SoundEvent CRAB_DEATH = createSound("entity.crab.death");
	
	public static SoundEvent createSound(String name)
	{
		ResourceLocation location = new ResourceLocation(Reference.MODID, name);
		SoundEvent event = new SoundEvent(location);
		event.setRegistryName(name);
		ForgeRegistries.SOUND_EVENTS.register(event);
		return event;
	}
	
	@SubscribeEvent
    public static void registerSound(RegistryEvent.Register<SoundEvent> event)
	{
        for(SoundEvent sound : sounds)
        {
            event.getRegistry().register(sound);
        }
    }
}