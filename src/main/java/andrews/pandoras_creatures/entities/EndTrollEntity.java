package andrews.pandoras_creatures.entities;

import java.util.Arrays;

import andrews.pandoras_creatures.entities.bases.AnimatedCreatureEntity;
import andrews.pandoras_creatures.registry.PCEntities;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.registries.ForgeRegistries;

public class EndTrollEntity extends AnimatedCreatureEntity
{
	private static Biome[] biomes = new Biome[] {Biomes.NETHER};
	
    public EndTrollEntity(EntityType<? extends EndTrollEntity> type, World worldIn)
    {
        super(type, worldIn);
    }

    public EndTrollEntity(World world, double posX, double posY, double posZ)
    {
        this(PCEntities.END_TROLL.get(), world);
        this.setPosition(posX, posY, posZ);
    }
    
    @Override
    protected void registerGoals()
    {

    }

    @Override
    protected void registerAttributes()
    {
        super.registerAttributes();
//      this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(14.0D); //TODO
    }
    
    @Override
    protected int getExperiencePoints(PlayerEntity player)  //TODO
    {
    	this.experienceValue = (int)((float)this.experienceValue * 2.0F);
    	return super.getExperiencePoints(player);
    }
    
    public static void addSpawn()
    {
		ForgeRegistries.BIOMES.getValues().stream().forEach(EndTrollEntity::processSpawning);
	}
	
    private static void processSpawning(Biome biome)
    {
		if(Arrays.asList(biomes).contains(biome))
		{
			biome.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(PCEntities.END_TROLL.get(), 30, 1, 1));
        }
	}
}