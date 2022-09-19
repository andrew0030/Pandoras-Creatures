package andrews.pandoras_creatures.entities.bases;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.level.*;

import java.util.Random;
import java.util.function.Predicate;

public abstract class AnimatedMonsterEntity extends AnimatedCreatureEntity implements Enemy
{
	public AnimatedMonsterEntity(EntityType<? extends AnimatedMonsterEntity> type, Level worldIn)
	{
		super(type, worldIn);
		this.xpReward = 5;
	}
	
	@Override
	public SoundSource getSoundSource()
	{
		return SoundSource.HOSTILE;
	}
	
	/**
	    * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
	    * use this to react to sunlight and start to burn.
	    */
	@Override
	public void aiStep()
	{
		this.updateSwingTime();
		this.lightBehaviourLogic();
		super.aiStep();
	}

	protected void lightBehaviourLogic()
	{
		float f = this.getLightLevelDependentMagicValue();
		if (f > 0.5F)
		{
			this.noActionTime += 2;
		}
	}
	
	@Override
	protected boolean isDespawnPeaceful()
	{
		return true;
	}
	
	@Override
	protected SoundEvent getSwimSound()
	{
		return SoundEvents.HOSTILE_SWIM;
	}
	
	@Override
	protected SoundEvent getSplashSound()
	{
		return SoundEvents.HOSTILE_SPLASH;
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn)
	{
		return SoundEvents.HOSTILE_HURT;
	}
	
	@Override
	protected SoundEvent getDeathSound()
	{
		return SoundEvents.HOSTILE_DEATH;
	}
	
	@Override
	protected SoundEvent getFallDamageSound(int heightIn)
	{
		return heightIn > 4 ? SoundEvents.HOSTILE_BIG_FALL : SoundEvents.HOSTILE_SMALL_FALL;
	}
	
	@Override
	public boolean hurt(DamageSource source, float amount)
	{
		return this.isInvulnerableTo(source) ? false : super.hurt(source, amount);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public float getBlockPathWeight(BlockPos pos, LevelReader worldIn)
	{
		return 0.5F - worldIn.getBrightness(pos);
	}
	
	/**
	 * Static predicate for determining if the current light level and environmental
	 * conditions allow for a monster to spawn.
	 */
	public static boolean isValidLightLevel(ServerLevelAccessor worldIn, BlockPos pos, Random randomIn)
	{
		if(worldIn.getBrightness(LightLayer.SKY, pos) > randomIn.nextInt(32))
		{
			return false;
		}
		else
		{
			int i = worldIn.getLevel().isThundering() ? worldIn.getMaxLocalRawBrightness(pos, 10) : worldIn.getMaxLocalRawBrightness(pos);
			return i <= randomIn.nextInt(8);
		}
	}
	
	/**
	 * Static predicate for determining whether or not a monster can spawn at the
	 * provided location, incorporating a check of the current light level at the
	 * location.
	 */
	public static boolean checkMonsterSpawnRules(EntityType<? extends Monster> type, ServerLevelAccessor worldIn, MobSpawnType reason, BlockPos pos, Random randomIn)
	{
		return worldIn.getDifficulty() != Difficulty.PEACEFUL && isValidLightLevel(worldIn, pos, randomIn) && checkMobSpawnRules(type, worldIn, reason, pos, randomIn);
	}

	/**
	 * Static predicate for determining whether or not a monster can spawn at the
	 * provided location.
	 */
	public static boolean checkAnyLightMonsterSpawnRules(EntityType<? extends Monster> type, LevelAccessor worldIn, MobSpawnType reason, BlockPos pos, Random randomIn)
	{
		return worldIn.getDifficulty() != Difficulty.PEACEFUL && checkMobSpawnRules(type, worldIn, reason, pos, randomIn);
	}
	
	@Override
	protected boolean shouldDropExperience()
	{
		return true;
	}

	public boolean isPreventingPlayerRest(Player playerIn)
	{
		return true;
	}
	
	@Override
	public ItemStack findAmmo(ItemStack shootable)
	{
		if(shootable.getItem() instanceof ProjectileWeaponItem)
		{
			Predicate<ItemStack> predicate = ((ProjectileWeaponItem) shootable.getItem()).getSupportedHeldProjectiles();
			ItemStack itemstack = ProjectileWeaponItem.getHeldProjectile(this, predicate);
			return itemstack.isEmpty() ? new ItemStack(Items.ARROW) : itemstack;
		}
		else
		{
			return ItemStack.EMPTY;
		}
	}
}
