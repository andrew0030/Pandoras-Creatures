package andrews.pandoras_creatures.objects.items;

import javax.annotation.Nullable;

import andrews.pandoras_creatures.entities.bases.BucketableMobEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class ItemMobBucket extends BucketItem
{
	private final EntityType<?> entityType;

	@SuppressWarnings("deprecation")
	public ItemMobBucket(EntityType<? extends BucketableMobEntity> entityType, Fluid fluid, Item.Properties builder)
	{
		super(fluid, builder);
		this.entityType = entityType;
	}

	/**
	 * Called when the buckets content gets placed
	 * @param worldIn - The world
	 * @param stack - The used ItemStack
	 * @param pos - The BlockPos
	 */
	public void onLiquidPlaced(World worldIn, ItemStack stack, BlockPos pos)
	{
		if(!worldIn.isRemote)
		{
			this.placeEntity(worldIn, stack, pos);
		}
	}
	
	/**
	 * The sound the item player when using it
	 * @param player - The player using the item
	 * @param worldIn - The world
	 * @param pos - The block position
	 */
	protected void playEmptySound(@Nullable PlayerEntity player, IWorld worldIn, BlockPos pos)
	{
		worldIn.playSound(player, pos, SoundEvents.ITEM_BUCKET_EMPTY_FISH, SoundCategory.NEUTRAL, 1.0F, 1.0F);
	}

	/**
	 * Places the entity in the world, if it isn't null
	 * @param worldIn - The world
	 * @param stack - The ItemStack
	 * @param pos - The BlockPos
	 */
	private void placeEntity(World worldIn, ItemStack stack, BlockPos pos)
	{
		Entity entity = this.entityType.spawn(worldIn, stack, (PlayerEntity)null, pos, SpawnReason.BUCKET, true, false);
		
		if(entity != null)
		{
			((BucketableMobEntity)entity).setFromBucket(true);
		}
	}
}