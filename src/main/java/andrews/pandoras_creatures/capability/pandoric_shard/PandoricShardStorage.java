package andrews.pandoras_creatures.capability.pandoric_shard;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class PandoricShardStorage implements IStorage<IPandoricShard>
{
	@Override
	public INBT writeNBT(Capability<IPandoricShard> capability, IPandoricShard instance, Direction side)
	{
		CompoundNBT compound = new CompoundNBT();
		compound.putInt("MaxChaosCharge", instance.getMaxChaosCharge());
		compound.putInt("ChaosCharge", instance.getChaosCharge());
		compound.putInt("MaxCreationCharge", instance.getMaxCreationCharge());
		compound.putInt("CreationCharge", instance.getCreationCharge());
		compound.putInt("MaxDecayCharge", instance.getMaxDecayCharge());
		compound.putInt("DecayCharge", instance.getDecayCharge());
		compound.putInt("MaxPsychoticCharge", instance.getMaxPsychoticCharge());
		compound.putInt("PsychoticCharge", instance.getPsychoticCharge());
		compound.putInt("MaxRadiationCharge", instance.getMaxRadiationCharge());
		compound.putInt("RadiationSharge", instance.getRadiationCharge());
		return compound;
	}

	@Override
	public void readNBT(Capability<IPandoricShard> capability, IPandoricShard instance, Direction side, INBT nbt)
	{
		CompoundNBT compound = (CompoundNBT) nbt;
		instance.setMaxChaosCharge(compound.getInt("MaxChaosCharge"));
		instance.setChaosCharge(compound.getInt("ChaosCharge"));
		instance.setMaxCreationCharge(compound.getInt("MaxCreationCharge"));
		instance.setCreationCharge(compound.getInt("CreationCharge"));
		instance.setMaxDecayCharge(compound.getInt("MaxDecayCharge"));
		instance.setDecayCharge(compound.getInt("DecayCharge"));
		instance.setMaxPsychoticCharge(compound.getInt("MaxPsychoticCharge"));
		instance.setPsychoticCharge(compound.getInt("PsychoticCharge"));
		instance.setMaxRadiationCharge(compound.getInt("MaxRadiationCharge"));
		instance.setRadiationCharge(compound.getInt("RadiationSharge"));
	}
}