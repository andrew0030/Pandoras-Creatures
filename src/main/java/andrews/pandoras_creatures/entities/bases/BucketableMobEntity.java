package andrews.pandoras_creatures.entities.bases;

import andrews.pandoras_creatures.util.interfaces.IBucketableEntity;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public abstract class BucketableMobEntity extends AnimatedWaterMobEntity implements IBucketableEntity
{
    private static final DataParameter<Boolean> FROM_BUCKET = EntityDataManager.createKey(BucketableMobEntity.class, DataSerializers.BOOLEAN);

    public BucketableMobEntity(EntityType<? extends BucketableMobEntity> type, World world)
    {
        super(type, world);
    }

    /**
     * Registers the data of the DataManager
     */
    protected void registerData()
    {
        super.registerData();
        this.dataManager.register(FROM_BUCKET, false);
    }

    /**
     * Sets the name of the bucket to the mobs name, if it had a custom one
     * @param bucket - The ItemBucket used
     */
    protected void setBucketData(ItemStack bucket)
    {
        if(this.hasCustomName())
        {
            bucket.setDisplayName(this.getCustomName());
        }
    }

    public void writeAdditional(CompoundNBT compound)
    {
        super.writeAdditional(compound);
        compound.putBoolean("FromBucket", this.isFromBucket());
    }

    public void readAdditional(CompoundNBT compound)
    {
        super.readAdditional(compound);
        this.setFromBucket(compound.getBoolean("FromBucket"));
    }

    /**
     * @return - Returns whether or not this entity is from a bucket
     */
    public boolean isFromBucket()
    {
        return this.dataManager.get(FROM_BUCKET);
    }

    /**
     * Sets if this entity should come from a bucket
     * @param value - True = Yes | False = No
     */
    public void setFromBucket(boolean value)
    {
        this.dataManager.set(FROM_BUCKET, value);
    }

    /**
     * Used to process all things that happen when this entity is interacted with
     * @param player - The player that interacted with this entity
     * @param hand - The players hand that got used to interact
     */
    @Override
    protected ActionResultType func_230254_b_(PlayerEntity player, Hand hand)
    {
        ItemStack itemstack = player.getHeldItem(hand);
        if(itemstack.getItem() == Items.WATER_BUCKET && this.isAlive())
        {
            this.playSound(SoundEvents.ITEM_BUCKET_FILL_FISH, 1.0F, 1.0F);
            itemstack.shrink(1);
            ItemStack itemstack1 = this.getBucket();
            this.setBucketData(itemstack1);
            if(!this.world.isRemote)
            {
                CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayerEntity)player, itemstack1);
            }

            if(itemstack.isEmpty())
            {
                player.setHeldItem(hand, itemstack1);
            }
            else if(!player.inventory.addItemStackToInventory(itemstack1))
            {
                player.dropItem(itemstack1, false);
            }
            this.remove();
            return ActionResultType.SUCCESS;
        }
        else
        {
            return super.func_230254_b_(player, hand);
        }
    }

    /**
     * Checks whether or not this entity can despawn
     * @param distanceToClosestPlayer - The distance to the closest player
     * @return - Returns if this entity can despawn
     */
    @Override
    public boolean canDespawn(double distanceToClosestPlayer)
    {
        return !this.isFromBucket() && !this.hasCustomName();
    }

    /**
     * Prevents this entity from despawning
     * @return - True if this entity is prevented from despawning
     */
    @Override
    public boolean preventDespawn()
    {
    	return this.isFromBucket();
    } 
}