package andrews.pandoras_creatures.entities;

import java.util.List;
import java.util.UUID;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;

import andrews.pandoras_creatures.registry.PCEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.entity.projectile.ShulkerBulletEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.play.server.SSpawnObjectPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.Constants.NBT;
import net.minecraftforge.fml.network.FMLPlayMessages;

public class EndTrollBulletDamageEntity extends ShulkerBulletEntity
{
	private Entity target;
	@Nullable
	private Direction direction;
	private int steps;
	private double targetDeltaX;
	private double targetDeltaY;
	private double targetDeltaZ;
	@Nullable
	private UUID targetUniqueId;

	public EndTrollBulletDamageEntity(EntityType<? extends EndTrollBulletDamageEntity> entity, World world)
	{
		super(entity, world);
		this.noClip = true;
	}
	
	public EndTrollBulletDamageEntity(FMLPlayMessages.SpawnEntity spawnEntity, World world)
	{
		this(PCEntities.END_TROLL_BULLET_DAMAGE.get(), world);
	}

	@OnlyIn(Dist.CLIENT)
	public EndTrollBulletDamageEntity(World world, double x, double y, double z, double motionX, double motionY, double motionZ)
	{
		this(PCEntities.END_TROLL_BULLET_DAMAGE.get(), world);
		this.setLocationAndAngles(x, y, z, this.rotationYaw, this.rotationPitch);
		this.setMotion(motionX, motionY, motionZ);
	}

	public EndTrollBulletDamageEntity(World world, LivingEntity owner, Entity target, Direction.Axis direction)
	{
		this(PCEntities.END_TROLL_BULLET_DAMAGE.get(), world);
		this.setShooter(owner);
		BlockPos blockpos = owner.getPosition();
		double d0 = (double) blockpos.getX() + 0.5D;
		double d1 = (double) blockpos.getY() + 0.5D;
		double d2 = (double) blockpos.getZ() + 0.5D;
		this.setLocationAndAngles(d0, d1, d2, this.rotationYaw, this.rotationPitch);
		this.target = target;
		this.direction = Direction.UP;
		this.selectNextMoveDirection(direction);
	}

	@Override
	public SoundCategory getSoundCategory()
	{
		return SoundCategory.HOSTILE;
	}

	@Override
	protected void writeAdditional(CompoundNBT compound)
	{
		super.writeAdditional(compound);
		if(this.target != null)
		{
			compound.putUniqueId("Target", this.target.getUniqueID());
		}

		if(this.direction != null)
		{
			compound.putInt("Dir", this.direction.getIndex());
		}

		compound.putInt("Steps", this.steps);
		compound.putDouble("TXD", this.targetDeltaX);
		compound.putDouble("TYD", this.targetDeltaY);
		compound.putDouble("TZD", this.targetDeltaZ);
	}

	@Override
	protected void readAdditional(CompoundNBT compound)
	{
		super.readAdditional(compound);
		this.steps = compound.getInt("Steps");
		this.targetDeltaX = compound.getDouble("TXD");
		this.targetDeltaY = compound.getDouble("TYD");
		this.targetDeltaZ = compound.getDouble("TZD");
		if(compound.contains("Dir", NBT.TAG_ANY_NUMERIC))
		{
			this.direction = Direction.byIndex(compound.getInt("Dir"));
		}

		if(compound.hasUniqueId("Target"))
		{
			this.targetUniqueId = compound.getUniqueId("Target");
		}
	}

	@Override
	protected void registerData() {}

	private void setDirection(@Nullable Direction direction)
	{
		this.direction = direction;
	}

	private void selectNextMoveDirection(@Nullable Direction.Axis directionAxis)
	{
		double hightModifier = 0.5D;
		BlockPos blockpos;
		if(this.target == null)
		{
			blockpos = this.getPosition().down();
		}
		else
		{
			hightModifier = (double) this.target.getHeight() * 0.5D;
			blockpos = new BlockPos(this.target.getPosX(), this.target.getPosY() + hightModifier, this.target.getPosZ());
		}

		double posX = (double) blockpos.getX() + 0.5D;
		double posY = (double) blockpos.getY() + hightModifier;
		double posZ = (double) blockpos.getZ() + 0.5D;
		Direction direction = null;
		if(!blockpos.withinDistance(this.getPositionVec(), 2.0D))
		{
			BlockPos blockpos1 = this.getPosition();
			List<Direction> list = Lists.newArrayList();
			if(directionAxis != Direction.Axis.X)
			{
				if(blockpos1.getX() < blockpos.getX() && this.world.isAirBlock(blockpos1.east()))
				{
					list.add(Direction.EAST);
				}
				else if(blockpos1.getX() > blockpos.getX() && this.world.isAirBlock(blockpos1.west()))
				{
					list.add(Direction.WEST);
				}
			}

			if(directionAxis != Direction.Axis.Y)
			{
				if(blockpos1.getY() < blockpos.getY() && this.world.isAirBlock(blockpos1.up()))
				{
					list.add(Direction.UP);
				}
				else if(blockpos1.getY() > blockpos.getY() && this.world.isAirBlock(blockpos1.down()))
				{
					list.add(Direction.DOWN);
				}
			}

			if(directionAxis != Direction.Axis.Z)
			{
				if(blockpos1.getZ() < blockpos.getZ() && this.world.isAirBlock(blockpos1.south()))
				{
					list.add(Direction.SOUTH);
				}
				else if(blockpos1.getZ() > blockpos.getZ() && this.world.isAirBlock(blockpos1.north()))
				{
					list.add(Direction.NORTH);
				}
			}

			direction = Direction.getRandomDirection(this.rand);
			if(list.isEmpty())
			{
				for(int i = 5; !this.world.isAirBlock(blockpos1.offset(direction)) && i > 0; --i)
				{
					direction = Direction.getRandomDirection(this.rand);
				}
			}
			else
			{
				direction = list.get(this.rand.nextInt(list.size()));
			}

			posX = this.getPosX() + (double) direction.getXOffset();
			posY = this.getPosY() + (double) direction.getYOffset();
			posZ = this.getPosZ() + (double) direction.getZOffset();
		}

		this.setDirection(direction);
		double totalPosX = posX - this.getPosX();
		double totalPosY = posY - this.getPosY();
		double totalPosZ = posZ - this.getPosZ();
		double deltaTotal = (double) MathHelper.sqrt(totalPosX * totalPosX + totalPosY * totalPosY + totalPosZ * totalPosZ);
		if(deltaTotal == 0.0D)
		{
			this.targetDeltaX = 0.0D;
			this.targetDeltaY = 0.0D;
			this.targetDeltaZ = 0.0D;
		}
		else
		{
			this.targetDeltaX = totalPosX / deltaTotal * 0.15D;
			this.targetDeltaY = totalPosY / deltaTotal * 0.15D;
			this.targetDeltaZ = totalPosZ / deltaTotal * 0.15D;
		}

		this.isAirBorne = true;
		this.steps = 10 + this.rand.nextInt(5) * 10;
	}

	@Override
	public void checkDespawn()
	{
		if(this.world.getDifficulty() == Difficulty.PEACEFUL)
		{
			this.remove();
		}
	}

	@Override
	public void tick()
	{
		super.tick();
		if(!this.world.isRemote)
		{
			if(this.target == null && this.targetUniqueId != null)
			{
				this.target = ((ServerWorld) this.world).getEntityByUuid(this.targetUniqueId);
				if(this.target == null)
				{
					this.targetUniqueId = null;
				}
			}

			if(this.target == null || !this.target.isAlive() || this.target instanceof PlayerEntity && ((PlayerEntity) this.target).isSpectator())
			{
				if(!this.hasNoGravity())
				{
					this.setMotion(this.getMotion().add(0.0D, -0.04D, 0.0D));
				}
			}
			else
			{
				this.targetDeltaX = MathHelper.clamp(this.targetDeltaX * 1.025D, -1.0D, 1.0D);
				this.targetDeltaY = MathHelper.clamp(this.targetDeltaY * 1.025D, -1.0D, 1.0D);
				this.targetDeltaZ = MathHelper.clamp(this.targetDeltaZ * 1.025D, -1.0D, 1.0D);
				Vector3d vector3d = this.getMotion();
				this.setMotion(vector3d.add((this.targetDeltaX - vector3d.x) * 0.2D, (this.targetDeltaY - vector3d.y) * 0.2D, (this.targetDeltaZ - vector3d.z) * 0.2D));
			}

			RayTraceResult raytraceresult = ProjectileHelper.func_234618_a_(this, this::func_230298_a_, RayTraceContext.BlockMode.COLLIDER);
			if(raytraceresult.getType() != RayTraceResult.Type.MISS && !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, raytraceresult))
			{
				this.onImpact(raytraceresult);
			}
		}

		Vector3d vector3d1 = this.getMotion();
		this.setPosition(this.getPosX() + vector3d1.x, this.getPosY() + vector3d1.y, this.getPosZ() + vector3d1.z);
		ProjectileHelper.rotateTowardsMovement(this, 0.5F);
		if(this.world.isRemote)
		{
			this.world.addParticle(new RedstoneParticleData(141, 0, 0, 1.0F), this.getPosX() - vector3d1.x, this.getPosY() - vector3d1.y + 0.15D, this.getPosZ() - vector3d1.z, 0.0D, 0.0D, 0.0D);
		}
		else if(this.target != null && this.target.isAlive())
		{
			if(this.steps > 0)
			{
				--this.steps;
				if(this.steps == 0)
				{
					this.selectNextMoveDirection(this.direction == null ? null : this.direction.getAxis());
				}
			}

			if(this.direction != null)
			{
				BlockPos blockpos = this.getPosition();
				Direction.Axis direction$axis = this.direction.getAxis();
				if(this.world.isTopSolid(blockpos.offset(this.direction), this))
				{
					this.selectNextMoveDirection(direction$axis);
				}
				else
				{
					BlockPos blockpos1 = this.target.getPosition();
					if(direction$axis == Direction.Axis.X && blockpos.getX() == blockpos1.getX() || direction$axis == Direction.Axis.Z && blockpos.getZ() == blockpos1.getZ() || direction$axis == Direction.Axis.Y && blockpos.getY() == blockpos1.getY())
					{
						this.selectNextMoveDirection(direction$axis);
					}
				}
			}
		}
	}

	@Override
	protected boolean func_230298_a_(Entity entity)
	{
		return super.func_230298_a_(entity) && !entity.noClip;
	}

	@Override
	public boolean isBurning()
	{
		return false;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isInRangeToRenderDist(double distance)
	{
		return distance < 16384.0D;
	}

	@Override
	public float getBrightness()
	{
		return 1.0f;
	}

	@Override
	protected void onEntityHit(EntityRayTraceResult result)
	{
		super.onEntityHit(result); //TODO maybe remove this to get rid of possible levitation effect?
		Entity entity = result.getEntity();
		Entity entity1 = this.func_234616_v_();
		LivingEntity livingentity = entity1 instanceof LivingEntity ? (LivingEntity) entity1 : null;
		boolean flag = entity.attackEntityFrom(DamageSource.causeIndirectDamage(this, livingentity).setProjectile(), 4.0F);
		if(flag)
		{
			this.applyEnchantments(livingentity, entity);
			if(entity instanceof LivingEntity)
			{
				((LivingEntity)entity).attackEntityFrom(DamageSource.causeIndirectDamage(this, livingentity).setProjectile(), 8.0F); //TODO "livingentity" may cause a funny chat death message or worse TEST IT!
			}
		}
	}

	@Override
	protected void func_230299_a_(BlockRayTraceResult result)
	{
		super.func_230299_a_(result);
		((ServerWorld) this.world).spawnParticle(ParticleTypes.EXPLOSION, this.getPosX(), this.getPosY(), this.getPosZ(), 2, 0.2D, 0.2D, 0.2D, 0.0D);
		this.playSound(SoundEvents.ENTITY_SHULKER_BULLET_HIT, 1.0F, 1.0F);
	}

	@Override
	protected void onImpact(RayTraceResult result)
	{
		super.onImpact(result);
		this.remove();
	}

	@Override
	public boolean canBeCollidedWith()
	{
		return true;
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount)
	{
		if(!this.world.isRemote)
		{
			this.playSound(SoundEvents.ENTITY_SHULKER_BULLET_HURT, 1.0F, 1.0F);
			((ServerWorld) this.world).spawnParticle(ParticleTypes.CRIT, this.getPosX(), this.getPosY(), this.getPosZ(), 15, 0.2D, 0.2D, 0.2D, 0.0D);
			this.remove();
		}

		return true;
	}

	public IPacket<?> createSpawnPacket()
	{
		return new SSpawnObjectPacket(this);
	}
}