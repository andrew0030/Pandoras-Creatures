package andrews.pandoras_creatures.registry;

import com.google.common.collect.Sets;

import andrews.pandoras_creatures.tile_entities.EndTrollBoxTileEntity;
import andrews.pandoras_creatures.tile_entities.PandoricShardTileEntity;
import andrews.pandoras_creatures.tile_entities.render.EndTrollBoxTileEntityRenderer;
import andrews.pandoras_creatures.tile_entities.render.PandoricShardTileEntityRenderer;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PCTileEntities
{
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Reference.MODID);
	
	public static final RegistryObject<TileEntityType<EndTrollBoxTileEntity>> END_TROLL_BOX = TILE_ENTITY_TYPES.register("end_troll_shulker", () -> new TileEntityType<>(EndTrollBoxTileEntity::new, Sets.newHashSet(PCBlocks.END_TROLL_BOX.get(), PCBlocks.WHITE_END_TROLL_BOX.get(), PCBlocks.ORANGE_END_TROLL_BOX.get(), PCBlocks.MAGENTA_END_TROLL_BOX.get(), PCBlocks.LIGHT_BLUE_END_TROLL_BOX.get(), PCBlocks.YELLOW_END_TROLL_BOX.get(), PCBlocks.LIME_END_TROLL_BOX.get(), PCBlocks.PINK_END_TROLL_BOX.get(), PCBlocks.GRAY_END_TROLL_BOX.get(), PCBlocks.LIGHT_GRAY_END_TROLL_BOX.get(), PCBlocks.CYAN_END_TROLL_BOX.get(), PCBlocks.PURPLE_END_TROLL_BOX.get(), PCBlocks.BLUE_END_TROLL_BOX.get(), PCBlocks.BROWN_END_TROLL_BOX.get(), PCBlocks.GREEN_END_TROLL_BOX.get(), PCBlocks.RED_END_TROLL_BOX.get(), PCBlocks.BLACK_END_TROLL_BOX.get()), null));
//	public static final RegistryObject<TileEntityType<PandoricShardTileEntity>> PANDORIC_SHARD_TILE_ENTITY = TILE_ENTITY_TYPES.register("pandoric_shard", () -> new TileEntityType<>(PandoricShardTileEntity::new, Sets.newHashSet(PCBlocks.PANDORIC_SHARD.get()), null));
	public static final RegistryObject<TileEntityType<PandoricShardTileEntity>> PANDORIC_SHARD = TILE_ENTITY_TYPES.register("pandoric_shard", () -> new TileEntityType<>(PandoricShardTileEntity::new, Sets.newHashSet(PCBlocks.PANDORIC_SHARD.get()), null));
	
    @OnlyIn(Dist.CLIENT)
    public static void registerTileRenders()
    {
    	ClientRegistry.bindTileEntityRenderer(END_TROLL_BOX.get(), EndTrollBoxTileEntityRenderer::new);
    	ClientRegistry.bindTileEntityRenderer(PANDORIC_SHARD.get(), PandoricShardTileEntityRenderer::new);
    }
}