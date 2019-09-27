package andrews.pandoras_creatures.registry;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

import andrews.pandoras_creatures.Main;
import andrews.pandoras_creatures.entities.ArachnonEntity;
import andrews.pandoras_creatures.entities.CrabEntity;
import andrews.pandoras_creatures.entities.HellhoundEntity;
import andrews.pandoras_creatures.entities.SeahorseEntity;
import andrews.pandoras_creatures.registry.util.RegistryUtils;
import andrews.pandoras_creatures.registry.util.SpawnConditions;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@SuppressWarnings("rawtypes")
public class PCEntities
{
	private static List<EntityType> entities = Lists.newArrayList();
	private static List<Item> spawnEggs = Lists.newArrayList();
	
	public static final EntityType<ArachnonEntity> ARACHNON = createEntity(ArachnonEntity.class, ArachnonEntity::new, EntityClassification.CREATURE, "arachnon", 2.8F, 1.8F, 5394534, 12257023);
	public static final EntityType<HellhoundEntity> HELLHOUND = createNetherEntity(HellhoundEntity.class, HellhoundEntity::new, EntityClassification.CREATURE, "hellhound", 0.9F, 1.3F, 0xf5f3f0, 0xfc750d);
	public static final EntityType<CrabEntity> CRAB = createEntity(CrabEntity.class, CrabEntity::new, EntityClassification.AMBIENT, "crab", 0.8F, 0.3F, 0xf79811, 0xffde3b);
	public static final EntityType<SeahorseEntity> SEAHORSE = createEntity(SeahorseEntity.class, SeahorseEntity::new, EntityClassification.AMBIENT, "seahorse", 0.4F, 0.8F, 0x38d1d1, 0xd98f27);
	
	//Entity Creation Method
	private static <T extends Entity> EntityType<T> createEntity(Class<T> entityClass, EntityType.IFactory<T> factory, EntityClassification entityClassification, String name, float width, float height, int eggPrimary, int eggSecondary)
	{
        ResourceLocation location = new ResourceLocation(Reference.MODID, name);
      
        EntityType<T> entity = EntityType.Builder.create(factory, entityClassification)
        	.size(width, height)
        	.setTrackingRange(20)
        	.build(location.toString());
        
        entity.setRegistryName(location);
        
        entities.add(entity);
        spawnEggs.add(RegistryUtils.createSpawnEggForEntity(entity, eggPrimary, eggSecondary, Main.PANDORAS_CREATURES_GROUP));
        return entity;
	}
	//Nether Entity Creation Method
	private static <T extends Entity> EntityType<T> createNetherEntity(Class<T> entityClass, EntityType.IFactory<T> factory, EntityClassification entityClassification, String name, float width, float height, int eggPrimary, int eggSecondary)
	{
        ResourceLocation location = new ResourceLocation(Reference.MODID, name);
      
        EntityType<T> entity = EntityType.Builder.create(factory, entityClassification)
        	.size(width, height)
        	.immuneToFire()
        	.setTrackingRange(16)
        	.build(location.toString());
        
        entity.setRegistryName(location);
        
        entities.add(entity);
        spawnEggs.add(RegistryUtils.createSpawnEggForEntity(entity, eggPrimary, eggSecondary, Main.PANDORAS_CREATURES_GROUP));
        return entity;
	}
    
	//Entity Registry
    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityType<?>> event)
    {
    	for (EntityType entity : entities)
    	{
    		event.getRegistry().register(entity);
    	}
    	EntitySpawnPlacementRegistry.register(ARACHNON, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, PCEntities::noDayLightMobCondition);
    	EntitySpawnPlacementRegistry.register(HELLHOUND, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, PCEntities::netherCondition);
    	EntitySpawnPlacementRegistry.register(CRAB, EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.OCEAN_FLOOR, PCEntities::amphibianstMobCondition);
    	EntitySpawnPlacementRegistry.register(SEAHORSE, EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, PCEntities::amphibianstMobCondition);
    }
    
    //Entity Spawn Egg Registry
    @SubscribeEvent
    public static void registerSpawnEggs(RegistryEvent.Register<Item> event)
    {
        for (Item spawnEgg : spawnEggs)
        {
            event.getRegistry().register(spawnEgg);
        }
    }
    
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
}