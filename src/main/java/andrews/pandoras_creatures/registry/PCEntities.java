package andrews.pandoras_creatures.registry;

import java.util.function.BiFunction;

import andrews.pandoras_creatures.entities.AcidicArchvineEntity;
import andrews.pandoras_creatures.entities.ArachnonEntity;
import andrews.pandoras_creatures.entities.BufflonEntity;
import andrews.pandoras_creatures.entities.CrabEntity;
import andrews.pandoras_creatures.entities.EndTrollBulletDamageEntity;
import andrews.pandoras_creatures.entities.EndTrollBulletPoisonEntity;
import andrews.pandoras_creatures.entities.EndTrollBulletWitherEntity;
import andrews.pandoras_creatures.entities.EndTrollEntity;
import andrews.pandoras_creatures.entities.HellhoundEntity;
import andrews.pandoras_creatures.entities.SeahorseEntity;
import andrews.pandoras_creatures.entities.render.AcidicArchvineRenderer;
import andrews.pandoras_creatures.entities.render.ArachnonRenderer;
import andrews.pandoras_creatures.entities.render.BufflonRenderer;
import andrews.pandoras_creatures.entities.render.CrabRenderer;
import andrews.pandoras_creatures.entities.render.EndTrollBulletDamageRenderer;
import andrews.pandoras_creatures.entities.render.EndTrollBulletPoisonRenderer;
import andrews.pandoras_creatures.entities.render.EndTrollBulletWitherRenderer;
import andrews.pandoras_creatures.entities.render.EndTrollRenderer;
import andrews.pandoras_creatures.entities.render.HellhoundRenderer;
import andrews.pandoras_creatures.entities.render.SeahorseRenderer;
import andrews.pandoras_creatures.registry.util.SpawnConditions;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PCEntities
{
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Reference.MODID);
	
	public static final RegistryObject<EntityType<ArachnonEntity>> ARACHNON = ENTITY_TYPES.register("arachnon", () -> createLivingEntity(ArachnonEntity::new, EntityClassification.MONSTER, "arachnon", 2.8F, 1.8F));
	public static final RegistryObject<EntityType<HellhoundEntity>> HELLHOUND = ENTITY_TYPES.register("hellhound", () -> createLivingNetherEntity(HellhoundEntity::new, EntityClassification.MONSTER, "hellhound", 1.0F, 1.2F));
	public static final RegistryObject<EntityType<CrabEntity>> CRAB = ENTITY_TYPES.register("crab", () -> createLivingEntity(CrabEntity::new, EntityClassification.AMBIENT, "crab", 0.8F, 0.3F));
	public static final RegistryObject<EntityType<SeahorseEntity>> SEAHORSE = ENTITY_TYPES.register("seahorse", () -> createLivingEntity(SeahorseEntity::new, EntityClassification.AMBIENT, "seahorse", 0.4F, 0.8F));
	public static final RegistryObject<EntityType<AcidicArchvineEntity>> ACIDIC_ARCHVINE = ENTITY_TYPES.register("acidic_archvine", () -> createLivingEntity(AcidicArchvineEntity::new, EntityClassification.MONSTER, "acidic_archvine", 1.0F, 1.5F));
	public static final RegistryObject<EntityType<BufflonEntity>> BUFFLON = ENTITY_TYPES.register("bufflon", () -> createLivingEntity(BufflonEntity::new, EntityClassification.CREATURE, "bufflon", 2.4F, 3.0F));
	public static final RegistryObject<EntityType<EndTrollEntity>> END_TROLL = ENTITY_TYPES.register("end_troll", () -> createLivingEntity(EndTrollEntity::new, EntityClassification.MONSTER, "end_troll", 3.0F, 3.6F));
	public static final RegistryObject<EntityType<EndTrollBulletPoisonEntity>> END_TROLL_BULLET_POISON = ENTITY_TYPES.register("end_troll_bullet_poison", () -> createEntity(EndTrollBulletPoisonEntity::new, EndTrollBulletPoisonEntity::new, EntityClassification.MISC, "end_troll_bullet_poison", 0.3125F, 0.3125F));
	public static final RegistryObject<EntityType<EndTrollBulletWitherEntity>> END_TROLL_BULLET_WITHER = ENTITY_TYPES.register("end_troll_bullet_wither", () -> createEntity(EndTrollBulletWitherEntity::new, EndTrollBulletWitherEntity::new, EntityClassification.MISC, "end_troll_bullet_wither", 0.3125F, 0.3125F));
	public static final RegistryObject<EntityType<EndTrollBulletDamageEntity>> END_TROLL_BULLET_DAMAGE = ENTITY_TYPES.register("end_troll_bullet_damage", () -> createEntity(EndTrollBulletDamageEntity::new, EndTrollBulletDamageEntity::new, EntityClassification.MISC, "end_troll_bullet_damage", 0.3125F, 0.3125F));

	/**
     * Registers World Spawning for entities
     */
    public static void registerEntityPlacementLogics()
    {
    	EntitySpawnPlacementRegistry.register(ARACHNON.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnConditions::noDayLightMobCondition);
    	EntitySpawnPlacementRegistry.register(HELLHOUND.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnConditions::netherCondition);
    	EntitySpawnPlacementRegistry.register(CRAB.get(), EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnConditions::amphibianstMobCondition);
    	EntitySpawnPlacementRegistry.register(SEAHORSE.get(), EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnConditions::waterCondition);
    	EntitySpawnPlacementRegistry.register(ACIDIC_ARCHVINE.get(), EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnConditions::acidicArchvineCondition);
    	EntitySpawnPlacementRegistry.register(BUFFLON.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SpawnConditions::bufflonCondition);
    }

	/**
	 * Registers Model Rendering for entities
	 */
    @OnlyIn(Dist.CLIENT)
    public static void registerEntityRenders()
    {
		RenderingRegistry.registerEntityRenderingHandler(ARACHNON.get(), ArachnonRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(HELLHOUND.get(), HellhoundRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(CRAB.get(), CrabRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(SEAHORSE.get(), SeahorseRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ACIDIC_ARCHVINE.get(), AcidicArchvineRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(BUFFLON.get(), BufflonRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(END_TROLL.get(), EndTrollRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(END_TROLL_BULLET_POISON.get(), EndTrollBulletPoisonRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(END_TROLL_BULLET_WITHER.get(), EndTrollBulletWitherRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(END_TROLL_BULLET_DAMAGE.get(), EndTrollBulletDamageRenderer::new);
    }

    //LivingEntity Creation Method
  	private static <T extends LivingEntity> EntityType<T> createLivingEntity(EntityType.IFactory<T> factory, EntityClassification entityClassification, String name, float width, float height)
  	{
  		ResourceLocation location = new ResourceLocation(Reference.MODID, name);
  		EntityType<T> entity = EntityType.Builder.create(factory, entityClassification)
  			.size(width, height)
  			.setTrackingRange(64)
  			.setShouldReceiveVelocityUpdates(true)
  			.setUpdateInterval(3)
  			.build(location.toString()
  		);
  		return entity;
  	}
  	
  	//Entity Creation Method
  	private static <T extends Entity> EntityType<T> createEntity(EntityType.IFactory<T> factory, BiFunction<FMLPlayMessages.SpawnEntity, World, T> clientFactory, EntityClassification entityClassification, String name, float width, float height)
  	{
		ResourceLocation location = new ResourceLocation(Reference.MODID, name);
		EntityType<T> entity = EntityType.Builder.create(factory, entityClassification)
			.size(width, height)
			.setTrackingRange(64)
			.setShouldReceiveVelocityUpdates(true)
			.setUpdateInterval(3)
			.setCustomClientFactory(clientFactory)
			.build(location.toString()
		);
		return entity;
	}
  	
  	//Nether Entity Creation Method
  	private static <T extends LivingEntity> EntityType<T> createLivingNetherEntity(EntityType.IFactory<T> factory, EntityClassification entityClassification, String name, float width, float height)
  	{
  		ResourceLocation location = new ResourceLocation(Reference.MODID, name);
  		EntityType<T> entity = EntityType.Builder.create(factory, entityClassification)
  			.size(width, height)
  			.setTrackingRange(64)
  			.setShouldReceiveVelocityUpdates(true)
  			.setUpdateInterval(3)
  			.immuneToFire()
  			.build(location.toString()
  		);
  		return entity;
  	}
}