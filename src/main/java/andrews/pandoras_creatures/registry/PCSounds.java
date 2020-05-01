package andrews.pandoras_creatures.registry;

import andrews.pandoras_creatures.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PCSounds
{
	public static final DeferredRegister<SoundEvent> SOUNDS = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS, Reference.MODID);
	
	public static final RegistryObject<SoundEvent> ARACHNON_AMBIENT = createSoundEvent("entity.arachnon.ambient");
	public static final RegistryObject<SoundEvent> ARACHNON_HURT = createSoundEvent("entity.arachnon.hurt");
	public static final RegistryObject<SoundEvent> ARACHNON_DEATH = createSoundEvent("entity.arachnon.death");
	public static final RegistryObject<SoundEvent> HELLHOUND_AMBIENT = createSoundEvent("entity.hellhound.ambient");
	public static final RegistryObject<SoundEvent> HELLHOUND_HURT = createSoundEvent("entity.hellhound.hurt");
	public static final RegistryObject<SoundEvent> HELLHOUND_DEATH = createSoundEvent("entity.hellhound.death");
	public static final RegistryObject<SoundEvent> CRAB_HURT = createSoundEvent("entity.crab.hurt");
	public static final RegistryObject<SoundEvent> CRAB_DEATH = createSoundEvent("entity.crab.death");
	public static final RegistryObject<SoundEvent> ACIDIC_ARCHVINE_ATTACK = createSoundEvent("entity.acidic_archvine.attack");
	public static final RegistryObject<SoundEvent> BUFFLON_AMBIENT = createSoundEvent("entity.bufflon.ambient");
	public static final RegistryObject<SoundEvent> BUFFLON_HURT = createSoundEvent("entity.bufflon.hurt");
	public static final RegistryObject<SoundEvent> BUFFLON_DEATH = createSoundEvent("entity.bufflon.death");
	public static final RegistryObject<SoundEvent> BUFFLON_ATTACK = createSoundEvent("entity.bufflon.attack");
	public static final RegistryObject<SoundEvent> END_TROLL_SCREAM = createSoundEvent("entity.end_troll.scream");
	public static final RegistryObject<SoundEvent> END_TROLL_ATTACK = createSoundEvent("entity.end_troll.attack");
	public static final RegistryObject<SoundEvent> END_TROLL_DEATH = createSoundEvent("entity.end_troll.death");
	
	private static RegistryObject<SoundEvent> createSoundEvent(String name)
	{
		return SOUNDS.register(name, () -> new SoundEvent(new ResourceLocation(Reference.MODID, name)));
	}
}