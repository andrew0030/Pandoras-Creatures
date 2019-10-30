package andrews.pandoras_creatures.entities;

import java.util.Arrays;

import andrews.pandoras_creatures.entities.bases.AnimatedCreatureEntity;
import andrews.pandoras_creatures.registry.PCEntities;
import andrews.pandoras_creatures.util.animation.Animation;
import andrews.pandoras_creatures.util.network.NetworkUtil;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.registries.ForgeRegistries;

public class BufflonEntity extends AnimatedCreatureEntity
{
	private static Biome[] biomes = new Biome[] {Biomes.TAIGA, Biomes.TAIGA_HILLS, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA_HILLS};
	
	public static final Animation TEST_ANIMATION = new Animation(100);
	
    public BufflonEntity(EntityType<? extends BufflonEntity> type, World worldIn)
    {
        super(type, worldIn);
    }

    public BufflonEntity(World world, double posX, double posY, double posZ)
    {
        this(PCEntities.BUFFLON, world);
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
//      this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.0D);
    }
    
    @Override
	protected void registerData()
    {
		super.registerData();
    }
    
    @Override
    protected boolean processInteract(PlayerEntity player, Hand hand)
    {
    	ItemStack itemstack = player.getHeldItem(hand);
        if(itemstack.getItem() == Items.STICK)
        {
        	if(this.isAnimationPlaying(BLANK_ANIMATION) && !this.getEntityWorld().isRemote())
        	{
        		System.out.println("Interacted");
        		NetworkUtil.setPlayingAnimationMessage(this, TEST_ANIMATION);
        	}
        	return true;
        }
        else
        {
        	return super.processInteract(player, hand);
        }
    }
    
    @Override
	public Animation[] getAnimations()
    {
		return new Animation[] {TEST_ANIMATION};
	}
    
//    @Override
//    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn)
//    {
//        return sizeIn.height * 0.8F;
//    }
    
    public static void addSpawn()
    {
		ForgeRegistries.BIOMES.getValues().stream().forEach(BufflonEntity::processSpawning);
	}
	
    private static void processSpawning(Biome biome)
    {
		if(Arrays.asList(biomes).contains(biome))
		{
			biome.addSpawn(EntityClassification.AMBIENT, new Biome.SpawnListEntry(PCEntities.BUFFLON, 40, 2, 5));
		}
    }
}
