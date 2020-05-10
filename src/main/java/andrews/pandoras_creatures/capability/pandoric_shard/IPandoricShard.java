package andrews.pandoras_creatures.capability.pandoric_shard;

public interface IPandoricShard
{
	//Chaos
	public void setMaxChaosCharge(int maxCharge);
	public void setChaosCharge(int charge);
	public void incrementChaosCharge(int amount);
	public void decrementChaosCharge(int amount);
	public int getMaxChaosCharge();
	public int getChaosCharge();
	
	//Creation
	public void setMaxCreationCharge(int maxCharge);
	public void setCreationCharge(int charge);
	public void incrementCreationCharge(int amount);
	public void decrementCreationCharge(int amount);
	public int getMaxCreationCharge();
	public int getCreationCharge();
	
	//Decay
	public void setMaxDecayCharge(int maxCharge);
	public void setDecayCharge(int charge);
	public void incrementDecayCharge(int amount);
	public void decrementDecayCharge(int amount);
	public int getMaxDecayCharge();
	public int getDecayCharge();
	
	//Psychotic
	public void setMaxPsychoticCharge(int maxCharge);
	public void setPsychoticCharge(int charge);
	public void incrementPsychoticCharge(int amount);
	public void decrementPsychoticCharge(int amount);
	public int getMaxPsychoticCharge();
	public int getPsychoticCharge();
	
	//Radiation
	public void setMaxRadiationCharge(int maxCharge);
	public void setRadiationCharge(int charge);
	public void incrementRadiationCharge(int amount);
	public void decrementRadiationCharge(int amount);
	public int getMaxRadiationCharge();
	public int getRadiationCharge();
}
