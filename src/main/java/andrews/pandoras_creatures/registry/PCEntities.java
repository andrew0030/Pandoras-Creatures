package andrews.pandoras_creatures.registry;

import java.util.Random;

import andrews.pandoras_creatures.entities.AcidicArchvineEntity;
import andrews.pandoras_creatures.entities.ArachnonEntity;
import andrews.pandoras_creatures.entities.BufflonEntity;
import andrews.pandoras_creatures.entities.CrabEntity;
import andrews.pandoras_creatures.entities.EndTrollEntity;
import andrews.pandoras_creatures.entities.HellhoundEntity;
import andrews.pandoras_creatures.entities.SeahorseEntity;
import andrews.pandoras_creatures.entities.render.AcidicArchvineRenderer;
import andrews.pandoras_creatures.entities.render.ArachnonRenderer;
import andrews.pandoras_creatures.entities.render.BufflonRenderer;
import andrews.pandoras_creatures.entities.render.CrabRenderer;
import andrews.pandoras_creatures.entities.render.EndTrollRenderer;
import andrews.pandoras_creatures.entities.render.HellhoundRenderer;
import andrews.pandoras_creatures.entities.render.SeahorseRenderer;
import andrews.pandoras_creatures.registry.util.SpawnConditions;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@EventBusSubscriber(modid = Reference.MODID, bus = EventBusSubscriber.Bus.MOD)
public class PCEntities
{
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, Reference.MODID);
	
	public static final RegistryObject<EntityType<ArachnonEntity>> ARACHNON = ENTITY_TYPES.register("arachnon", () -> createLivingEntity(ArachnonEntity::new, EntityClassification.MONSTER, "arachnon", 2.8F, 1.8F));
	public static final RegistryObject<EntityType<HellhoundEntity>> HELLHOUND = ENTITY_TYPES.register("hellhound", () -> createLivingNetherEntity(HellhoundEntity::new, EntityClassification.MONSTER, "hellhound", 1.0F, 1.2F));
	public static final RegistryObject<EntityType<CrabEntity>> CRAB = ENTITY_TYPES.register("crab", () -> createLivingEntity(CrabEntity::new, EntityClassification.AMBIENT, "crab", 0.8F, 0.3F));
	public static final RegistryObject<EntityType<SeahorseEntity>> SEAHORSE = ENTITY_TYPES.register("seahorse", () -> createLivingEntity(SeahorseEntity::new, EntityClassification.AMBIENT, "seahorse", 0.4F, 0.8F));
	public static final RegistryObject<EntityType<AcidicArchvineEntity>> ACIDIC_ARCHVINE = ENTITY_TYPES.register("acidic_archvine", () -> createLivingEntity(AcidicArchvineEntity::new, EntityClassification.MONSTER, "acidic_archvine", 1.0F, 1.5F));
	public static final RegistryObject<EntityType<BufflonEntity>> BUFFLON = ENTITY_TYPES.register("bufflon", () -> createLivingEntity(BufflonEntity::new, EntityClassification.CREATURE, "bufflon", 2.4F, 3.0F));
	public static final RegistryObject<EntityType<EndTrollEntity>> END_TROLL = ENTITY_TYPES.register("end_troll", () -> createLivingEntity(EndTrollEntity::new, EntityClassification.MONSTER, "end_troll", 3.0F, 3.0F));
	
	//=========================================================================================================================================================================================================================================
	//=========================================================================================================================================================================================================================================
	
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
	
	//=========================================================================================================================================================================================================================================
	//=========================================================================================================================================================================================================================================
	
	//Entity Registry
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void registerEntities(RegistryEvent.Register<EntityType<?>> event)
	{
    	EntitySpawnPlacementRegistry.register(ARACHNON.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, PCEntities::noDayLightMobCondition);
    	EntitySpawnPlacementRegistry.register(HELLHOUND.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, PCEntities::netherCondition);
    	EntitySpawnPlacementRegistry.register(CRAB.get(), EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.OCEAN_FLOOR, PCEntities::amphibianstMobCondition);
    	EntitySpawnPlacementRegistry.register(SEAHORSE.get(), EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, PCEntities::waterCondition);
    	EntitySpawnPlacementRegistry.register(ACIDIC_ARCHVINE.get(), EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, PCEntities::acidicArchvineCondition);
    	EntitySpawnPlacementRegistry.register(BUFFLON.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, PCEntities::bufflonCondition);
    	EntitySpawnPlacementRegistry.register(END_TROLL.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, PCEntities::noDayLightMobCondition); //TODO
    }
    
    //=========================================================================================================================================================================================================================================
    //=========================================================================================================================================================================================================================================
  	
	/**
	 * Registers Model Rendering for entities
	 */
    @OnlyIn(Dist.CLIENT)
    public static void registerEntityRenders()
    {
		RenderingRegistry.registerEntityRenderingHandler(ArachnonEntity.class, ArachnonRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(HellhoundEntity.class, HellhoundRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(CrabEntity.class, CrabRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(SeahorseEntity.class, SeahorseRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(AcidicArchvineEntity.class, AcidicArchvineRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(BufflonEntity.class, BufflonRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(EndTrollEntity.class, EndTrollRenderer::new);
    }
	
	//=========================================================================================================================================================================================================================================
    //=========================================================================================================================================================================================================================================
  	
  	//Entity Spawn Conditions
    private static boolean noDayLightMobCondition(EntityType<? extends MobEntity> entityType, IWorld world, SpawnReason spawnReason, BlockPos pos, Random random)
    {
    	return SpawnConditions.noDayLightMobCondition(entityType, world, spawnReason, pos, random);
    }
    
    public static boolean amphibianstMobCondition(EntityType<? extends MobEntity> entityType, IWorld world, SpawnReason spawnReason, BlockPos pos, Random random)
    {
    	return SpawnConditions.amphibianstMobCondition(entityType, world, spawnReason, pos, random);
    }
    private static boolean netherCondition(EntityType<? extends MobEntity> entityType, IWorld world, SpawnReason spawnReason, BlockPos pos, Random random)
    {
    	return SpawnConditions.netherCondition(entityType, world, spawnReason, pos, random);
    }
    private static boolean waterCondition(EntityType<? extends MobEntity> entityType, IWorld world, SpawnReason spawnReason, BlockPos pos, Random random)
    {
    	return SpawnConditions.waterCondition(entityType, world, spawnReason, pos, random);
    }
    private static boolean acidicArchvineCondition(EntityType<? extends MobEntity> entityType, IWorld world, SpawnReason spawnReason, BlockPos pos, Random random)
    {
    	return SpawnConditions.acidicArchvineCondition(entityType, world, spawnReason, pos, random);
    }
    private static boolean bufflonCondition(EntityType<? extends MobEntity> entityType, IWorld world, SpawnReason spawnReason, BlockPos pos, Random random)
    {
    	return SpawnConditions.bufflonCondition(entityType, world, spawnReason, pos, random);
    }
}