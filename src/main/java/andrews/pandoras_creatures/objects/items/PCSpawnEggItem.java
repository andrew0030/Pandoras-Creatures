package andrews.pandoras_creatures.objects.items;

import java.util.function.Supplier;

import net.minecraft.entity.EntityType;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.Constants.NBT;

public class PCSpawnEggItem extends SpawnEggItem
{
	private final Supplier<EntityType<?>> entityType;

	public PCSpawnEggItem(Supplier<EntityType<?>> entityType, int primaryColor, int secondaryColor, Properties properties)
	{
		super(null, primaryColor, secondaryColor, properties);
		this.entityType = entityType;
	}

	@Override
	public EntityType<?> getType(CompoundNBT compound)
	{
		if(compound != null && compound.contains("EntityTag", NBT.TAG_COMPOUND))
		{
			CompoundNBT entityTag = compound.getCompound("EntityTag");

			if(entityTag.contains("id", NBT.TAG_STRING))
			{
				return EntityType.byKey(entityTag.getString("id")).orElse(this.entityType.get());
			}
		}

		return this.entityType.get();
	}
}