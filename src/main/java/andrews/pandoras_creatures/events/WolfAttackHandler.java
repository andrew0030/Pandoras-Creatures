package andrews.pandoras_creatures.events;

import andrews.pandoras_creatures.entities.BufflonEntity;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class WolfAttackHandler
{
	@SubscribeEvent
	public static void onEntitySetAttackTarget(LivingSetAttackTargetEvent event)
	{
		if(event.getEntityLiving() != null && event.getTarget() != null)
		{
			if(event.getEntityLiving() instanceof WolfEntity)
			{	
				if(event.getTarget() instanceof BufflonEntity)
				{
					WolfEntity wolf = (WolfEntity) event.getEntityLiving();
					BufflonEntity bufflon = (BufflonEntity) event.getTarget();
					
					if(wolf.isTamed() && bufflon.isTamed())
					{
						if(wolf.getOwner() == bufflon.getOwner())
						{
							wolf.setAttackTarget(null);
						}
					}
				}
			}
		}
	}
}