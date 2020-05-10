package andrews.pandoras_creatures.capability.pandoric_shard;

public class PandoricShardCapability implements IPandoricShard
{	
	//Chaos Shard
	private int maxChaosCharge = 0;
	private int chaosCharge = 0;
	//Creation Shard
	private int maxCreationCharge = 0;
	private int creationCharge = 0;
	//Decay Shard
	private int maxDecayCharge = 0;
	private int decayCharge = 0;
	//Psychotic Shard
	private int maxPsychoticCharge = 0;
	private int psychoticCharge = 0;
	//Radiation Shard
	private int maxRadiationCharge = 0;
	private int radiationCharge = 0;
	
	/*
	 * Chaos Shard
	 */
	@Override
	public void setMaxChaosCharge(int maxChaosCharge)
	{
		this.maxChaosCharge = maxChaosCharge;
	}

	@Override
	public void setChaosCharge(int charge)
	{
		if(charge < 0)
		{
			this.chaosCharge = 0;
		}
		else if(charge > this.maxChaosCharge)
		{
			this.chaosCharge = this.maxChaosCharge;
		}
		
	}

	@Override
	public void incrementChaosCharge(int amount)
	{
		if(this.chaosCharge + amount > this.maxChaosCharge)
		{
			this.chaosCharge = this.maxChaosCharge;
		}
		else
		{
			this.chaosCharge += amount;
		}
	}

	@Override
	public void decrementChaosCharge(int amount)
	{
		if(this.chaosCharge - amount < 0)
		{
			this.chaosCharge = 0;
		}
		else
		{
			this.chaosCharge -= amount;
		}
	}

	@Override
	public int getMaxChaosCharge()
	{
		return this.maxChaosCharge;
	}
	
	@Override
	public int getChaosCharge()
	{
		return this.chaosCharge;
	}
	
	/*
	 * Creation Shard
	 */
	@Override
	public void setMaxCreationCharge(int maxCreationCharge)
	{
		this.maxCreationCharge = maxCreationCharge;
	}

	@Override
	public void setCreationCharge(int charge)
	{
		if(charge < 0)
		{
			this.creationCharge = 0;
		}
		else if(charge > this.maxCreationCharge)
		{
			this.creationCharge = this.maxCreationCharge;
		}
		
	}

	@Override
	public void incrementCreationCharge(int amount)
	{
		if(this.creationCharge + amount > this.maxCreationCharge)
		{
			this.creationCharge = this.maxCreationCharge;
		}
		else
		{
			this.creationCharge += amount;
		}
	}

	@Override
	public void decrementCreationCharge(int amount)
	{
		if(this.creationCharge - amount < 0)
		{
			this.creationCharge = 0;
		}
		else
		{
			this.creationCharge -= amount;
		}
	}

	@Override
	public int getMaxCreationCharge()
	{
		return this.maxCreationCharge;
	}
	
	@Override
	public int getCreationCharge()
	{
		return this.creationCharge;
	}
	
	/*
	 * Decay Shard
	 */
	@Override
	public void setMaxDecayCharge(int maxDecayCharge)
	{
		this.maxDecayCharge = maxDecayCharge;
	}

	@Override
	public void setDecayCharge(int charge)
	{
		if(charge < 0)
		{
			this.decayCharge = 0;
		}
		else if(charge > this.maxDecayCharge)
		{
			this.decayCharge = this.maxDecayCharge;
		}
		
	}

	@Override
	public void incrementDecayCharge(int amount)
	{
		if(this.decayCharge + amount > this.maxDecayCharge)
		{
			this.decayCharge = this.maxDecayCharge;
		}
		else
		{
			this.decayCharge += amount;
		}
	}

	@Override
	public void decrementDecayCharge(int amount)
	{
		if(this.decayCharge - amount < 0)
		{
			this.decayCharge = 0;
		}
		else
		{
			this.decayCharge -= amount;
		}
	}

	@Override
	public int getMaxDecayCharge()
	{
		return this.maxDecayCharge;
	}
	
	@Override
	public int getDecayCharge()
	{
		return this.decayCharge;
	}
	
	/*
	 * Psychotic Shard
	 */
	@Override
	public void setMaxPsychoticCharge(int maxPsychoticCharge)
	{
		this.maxPsychoticCharge = maxPsychoticCharge;
	}

	@Override
	public void setPsychoticCharge(int charge)
	{
		if(charge < 0)
		{
			this.psychoticCharge = 0;
		}
		else if(charge > this.maxPsychoticCharge)
		{
			this.psychoticCharge = this.maxPsychoticCharge;
		}
		
	}

	@Override
	public void incrementPsychoticCharge(int amount)
	{
		if(this.psychoticCharge + amount > this.maxPsychoticCharge)
		{
			this.psychoticCharge = this.maxPsychoticCharge;
		}
		else
		{
			this.psychoticCharge += amount;
		}
	}

	@Override
	public void decrementPsychoticCharge(int amount)
	{
		if(this.psychoticCharge - amount < 0)
		{
			this.psychoticCharge = 0;
		}
		else
		{
			this.psychoticCharge -= amount;
		}
	}

	@Override
	public int getMaxPsychoticCharge()
	{
		return this.maxPsychoticCharge;
	}
	
	@Override
	public int getPsychoticCharge()
	{
		return this.psychoticCharge;
	}
	
	/*
	 * Radiation Shard
	 */
	@Override
	public void setMaxRadiationCharge(int maxRadiationCharge)
	{
		this.maxRadiationCharge = maxRadiationCharge;
	}

	@Override
	public void setRadiationCharge(int charge)
	{
		if(charge < 0)
		{
			this.radiationCharge = 0;
		}
		else if(charge > this.maxRadiationCharge)
		{
			this.radiationCharge = this.maxRadiationCharge;
		}
		
	}

	@Override
	public void incrementRadiationCharge(int amount)
	{
		if(this.radiationCharge + amount > this.maxRadiationCharge)
		{
			this.radiationCharge = this.maxRadiationCharge;
		}
		else
		{
			this.radiationCharge += amount;
		}
	}

	@Override
	public void decrementRadiationCharge(int amount)
	{
		if(this.radiationCharge - amount < 0)
		{
			this.radiationCharge = 0;
		}
		else
		{
			this.radiationCharge -= amount;
		}
	}

	@Override
	public int getMaxRadiationCharge()
	{
		return this.maxRadiationCharge;
	}
	
	@Override
	public int getRadiationCharge()
	{
		return this.radiationCharge;
	}
}