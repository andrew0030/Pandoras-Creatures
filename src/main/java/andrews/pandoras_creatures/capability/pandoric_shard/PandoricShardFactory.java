package andrews.pandoras_creatures.capability.pandoric_shard;

import java.util.concurrent.Callable;

public class PandoricShardFactory implements Callable<IPandoricShard>
{
	@Override
	public IPandoricShard call() throws Exception
	{
		return new PandoricShardCapability();
	}
}