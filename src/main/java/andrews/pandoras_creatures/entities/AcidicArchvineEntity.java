package andrews.pandoras_creatures.entities;

import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableSet;

import andrews.pandoras_creatures.entities.bases.AnimatedMonsterEntity;
import andrews.pandoras_creatures.entities.goals.acidic_archvine.TargetUnderneathGoal;
import andrews.pandoras_creatures.registry.PCEntities;
import andrews.pandoras_creatures.registry.PCItems;
import andrews.pandoras_creatures.util.animation.Animation;
import andrews.pandoras_creatures.util.biome_utils.PCBiomeUtils;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.Constants.NBT;

public class AcidicArchvineEntity extends AnimatedMonsterEntity
{
	private static final DataParameter<Integer> ARCHVINE_TYPE = EntityDataManager.createKey(AcidicArchvineEntity.class, DataSerializers.VARINT);
	private static final DataParameter<Integer> TARGET_ENTITY = EntityDataManager.createKey(AcidicArchvineEntity.class, DataSerializers.VARINT);
	private LivingEntity targetedEntity;
	private int attackState;
	private static final Set<RegistryKey<Biome>> NETHER_BIOMES = ImmutableSet.of(Biomes.NETHER_WASTES, Biomes.SOUL_SAND_VALLEY, Biomes.WARPED_FOREST, Biomes.BASALT_DELTAS);
	
    public AcidicArchvineEntity(EntityType<? extends AcidicArchvineEntity> type, World worldIn)
    {
        super(type, worldIn);
    }

    public AcidicArchvineEntity(World world, double posX, double posY, double posZ)
    {
        this(PCEntities.ACIDIC_ARCHVINE.get(), world);
        this.setPosition(posX, posY, posZ);
    }

    @Override
    protected void registerGoals()
    {
    	this.targetSelector.addGoal(1, new TargetUnderneathGoal<>(this, PlayerEntity.class, true));
    }
    
    @Override
    protected void registerData()
    {
    	super.registerData();
        this.dataManager.register(TARGET_ENTITY, 0);
        this.dataManager.register(ARCHVINE_TYPE, 0);
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
    	return new ItemStack(PCItems.ACIDIC_ARCHVINE_SPAWN_EGG.get());
    }
    
    @Override
	public Animation[] getAnimations()
    {
		return null;
	}
    
    @Override
	public void writeAdditional(CompoundNBT compound)
    {
		super.writeAdditional(compound);
		compound.putInt("ArchvineType", this.getArchvineType());
	}
	
	@Override
	public void readAdditional(CompoundNBT compound)
	{
		super.readAdditional(compound);
		this.setArchvineType(compound.getInt("ArchvineType"));
	}
    
    public void setTargetedEntity(int entityId)
    {
    	this.dataManager.set(TARGET_ENTITY, entityId);
    }

    public boolean hasTargetedEntity()
    {
    	return this.dataManager.get(TARGET_ENTITY) != 0;
    }

    @Nullable
    public LivingEntity getTargetedEntity()
    {
    	if(!this.hasTargetedEntity())
    	{
    		return null;
    	}
    	else if(this.world.isRemote)
    	{
    		if(this.targetedEntity != null)
    		{
    			return this.targetedEntity;
    		} 
    		else
    		{
    			Entity entity = this.world.getEntityByID(this.dataManager.get(TARGET_ENTITY));
    			if(entity instanceof LivingEntity)
    			{
    				this.targetedEntity = (LivingEntity)entity;
    				return this.targetedEntity;
    			}
    			else
    			{
    				return null;
    			}
    		}
    	}
    	else
    	{
    		return this.getAttackTarget();
    	}
    }
    
    @Override
    public boolean attackEntityAsMob(Entity entityIn)
    {
    	float damage = (float)(4 + this.rand.nextInt(3));
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), damage);
        return flag;
    }

    public void notifyDataManagerChange(DataParameter<?> key)
    {
    	super.notifyDataManagerChange(key);
    	if(TARGET_ENTITY.equals(key))
    	{
    		this.targetedEntity = null;
    	}
    }
    
    //Moves the plant up or down by half a Block, depending on the position it got placed at.
    @Override
    public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, ILivingEntityData spawnDataIn, CompoundNBT dataTag)
    {	
    	spawnDataIn = super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    	int type = this.getTypeForBiome(worldIn);
    	if(dataTag != null && dataTag.contains("ArchvineType", NBT.TAG_INT))
		{
			this.setArchvineType(dataTag.getInt("ArchvineType"));
			return spawnDataIn;
		}
		this.setArchvineType(type);
    	
    	if((worldIn.getBlockState(this.getPosition().up(2)).getBlock() != Blocks.JUNGLE_LEAVES && worldIn.getBlockState(this.getPosition().up(2)).getBlock() != Blocks.NETHERRACK) && (worldIn.getBlockState(this.getPosition().up()).getBlock() != Blocks.JUNGLE_LEAVES && worldIn.getBlockState(this.getPosition().up()).getBlock() != Blocks.NETHERRACK))
    	{
    		this.damageEntity(DamageSource.CRAMMING, Float.MAX_VALUE);
    	}
    	else if(worldIn.getBlockState(this.getPosition().up()).getBlock() == Blocks.JUNGLE_LEAVES || worldIn.getBlockState(this.getPosition().up()).getBlock() == Blocks.NETHERRACK)
    	{
    		this.setPosition(this.getPosX(), this.getPosY() - 0.5, this.getPosZ());
    	}
    	else if(worldIn.getBlockState(this.getPosition().up()).getBlock() == Blocks.AIR && (worldIn.getBlockState(this.getPosition().up(2)).getBlock() == Blocks.JUNGLE_LEAVES || worldIn.getBlockState(this.getPosition().up(2)).getBlock() == Blocks.NETHERRACK))
    	{
    		this.setPosition(this.getPosX(), this.getPosY() + 0.5, this.getPosZ());
    	}
    	
    	return spawnDataIn;
    }
    
    private int getTypeForBiome(IServerWorld world)
    {
		if(PCBiomeUtils.isBiomeEqualTo(NETHER_BIOMES, world, this.getPosition()))
		{
			return 2;
		}
		else if(PCBiomeUtils.isBiomeEqualTo(Biomes.CRIMSON_FOREST, world, this.getPosition()))
		{
			return 3;
		}
		return 1;
	}
    
    @Override
    public void tick()
    {
    	super.tick();
    	if(this.getEntityWorld().getBlockState(this.getPosition().up(2)).getBlock().equals(Blocks.JUNGLE_LEAVES) || this.getEntityWorld().getBlockState(this.getPosition().up(2)).getBlock().equals(Blocks.NETHERRACK))
    	{
    		this.setMotion(Vector3d.ZERO);
    	}
    }
    
    @Override
    public void onDeath(DamageSource cause)
    {
    	super.onDeath(cause);
    	if(this.getAttackTarget() != null)
    	{
    		this.getAttackTarget().setNoGravity(false);
    		if(this.getAttackTarget() instanceof PlayerEntity)
    		{
    			PlayerEntity player = (PlayerEntity) this.getAttackTarget();
    			if(!player.isCreative())
    			{
    				player.abilities.allowFlying = false;
    			}
    		}
    	}
    }
    
    @Override
    public boolean canBePushed()
    {
    	return false;
    }

    @Override
    public void collideWithEntity(Entity entityIn) {}

    @Override
    public void collideWithNearbyEntities() {}

    @Override
    public int getMaxSpawnedInChunk()
    {
        return 1;
    }
    
    @Override
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn)
    {
    	return true;
    }
    
    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id)
    {
    	if(id == 4)
    	{
    		this.attackState = 0;
    	}
    	else if(id == 5)
    	{
    		this.attackState = 1;
    	}
    	else if(id == 6)
    	{
    		this.attackState = 2;
    	}
    	else
    	{
    		super.handleStatusUpdate(id);
    	}
    }
    
    @OnlyIn(Dist.CLIENT)
    public int getAttackState()
    {
       return this.attackState;
    }
    
    public int getArchvineType()
    {
    	if(this.dataManager.get(ARCHVINE_TYPE) == 0)
    	{
    		this.dataManager.set(ARCHVINE_TYPE, 1);
    		return this.dataManager.get(ARCHVINE_TYPE);
    	}
    	else
    	{
    		return this.dataManager.get(ARCHVINE_TYPE);
    	}
	}
	
	public void setArchvineType(int typeId)
	{
		this.dataManager.set(ARCHVINE_TYPE, typeId);
	}
    
    public void setAttackState(int value)
    {
       this.attackState = value;
    }
}
