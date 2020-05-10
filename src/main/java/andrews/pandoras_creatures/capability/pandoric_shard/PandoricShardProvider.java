package andrews.pandoras_creatures.capability.pandoric_shard;

import andrews.pandoras_creatures.registry.PCCapabilities;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class PandoricShardProvider implements ICapabilitySerializable<INBT>
{
	private LazyOptional<IPandoricShard> instance = LazyOptional.of(PCCapabilities.PANDORIC_SHARD_CAP::getDefaultInstance);

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side)
	{
		return cap == PCCapabilities.PANDORIC_SHARD_CAP ? instance.cast() : LazyOptional.empty();
	}

	@Override
	public INBT serializeNBT()
	{
		return PCCapabilities.PANDORIC_SHARD_CAP.getStorage().writeNBT(PCCapabilities.PANDORIC_SHARD_CAP, this.instance.orElseThrow(() -> new IllegalArgumentException("Lazy Optional cannot be empty")), null);
	}

	@Override
	public void deserializeNBT(INBT nbt)
	{
		PCCapabilities.PANDORIC_SHARD_CAP.getStorage().readNBT(PCCapabilities.PANDORIC_SHARD_CAP, this.instance.orElseThrow(() -> new IllegalArgumentException("Lazy Optional cannot be empty")), null, nbt);
	}
}