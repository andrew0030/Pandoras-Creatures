package andrews.pandoras_creatures.entities.bases;

import andrews.pandoras_creatures.util.interfaces.IBucketableEntity;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public abstract class BucketableMobEntity extends AnimatedWaterMobEntity implements IBucketableEntity
{
    private static final EntityDataAccessor<Boolean> FROM_BUCKET = SynchedEntityData.defineId(BucketableMobEntity.class, EntityDataSerializers.BOOLEAN);

    public BucketableMobEntity(EntityType<? extends BucketableMobEntity> type, Level world)
    {
        super(type, world);
    }

    /**
     * Registers the data of the DataManager
     */
    protected void defineSynchedData()
    {
        super.defineSynchedData();
        this.entityData.define(FROM_BUCKET, false);
    }

    /**
     * Sets the name of the bucket to the mobs name, if it had a custom one
     * @param bucket - The ItemBucket used
     */
    protected void setBucketData(ItemStack bucket)
    {
        if(this.hasCustomName())
        {
            bucket.setHoverName(this.getCustomName());
        }
    }

    public void addAdditionalSaveData(CompoundTag compound)
    {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("FromBucket", this.isFromBucket());
    }

    public void readAdditionalSaveData(CompoundTag compound)
    {
        super.readAdditionalSaveData(compound);
        this.setFromBucket(compound.getBoolean("FromBucket"));
    }

    /**
     * @return - Returns whether or not this entity is from a bucket
     */
    public boolean isFromBucket()
    {
        return this.entityData.get(FROM_BUCKET);
    }

    /**
     * Sets if this entity should come from a bucket
     * @param value - True = Yes | False = No
     */
    public void setFromBucket(boolean value)
    {
        this.entityData.set(FROM_BUCKET, value);
    }

    /**
     * Used to process all things that happen when this entity is interacted with
     * @param player - The player that interacted with this entity
     * @param hand - The players hand that got used to interact
     */
    @Override
    protected InteractionResult mobInteract(Player player, InteractionHand hand)
    {
        ItemStack itemstack = player.getItemInHand(hand);
        if(itemstack.getItem() == Items.WATER_BUCKET && this.isAlive())
        {
            this.playSound(SoundEvents.BUCKET_FILL_FISH, 1.0F, 1.0F);
            itemstack.shrink(1);
            ItemStack itemstack1 = this.getBucket();
            this.setBucketData(itemstack1);
            if(!this.level.isClientSide)
            {
                CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayer)player, itemstack1);
            }

            if(itemstack.isEmpty())
            {
                player.setItemInHand(hand, itemstack1);
            }
            else if(!player.addItem(itemstack1))
            {
                player.drop(itemstack1, false);
            }
            this.remove();
            return InteractionResult.SUCCESS;
        }
        else
        {
            return super.mobInteract(player, hand);
        }
    }

    /**
     * Checks whether or not this entity can despawn
     * @param distanceToClosestPlayer - The distance to the closest player
     * @return - Returns if this entity can despawn
     */
    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer)
    {
        return !this.isFromBucket() && !this.hasCustomName();
    }

    /**
     * Prevents this entity from despawning
     * @return - True if this entity is prevented from despawning
     */
    @Override
    public boolean requiresCustomPersistence()
    {
    	return this.isFromBucket();
    } 
}
