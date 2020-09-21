package andrews.pandoras_creatures.registry.util;

import andrews.pandoras_creatures.registry.PCEntities;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;

public class PCEntityAttributes
{
	
	/**
	 * Registration for all the Entity Attributes
	 */
	public static void putAttributes()
	{
		GlobalEntityTypeAttributes.put(PCEntities.ARACHNON.get(),
			MobEntity.func_233666_p_()
//			.createMutableAttribute(Attributes.ATTACK_DAMAGE, 7.0F) TODO make attack damage dynamic instead of hardcoded
			.createMutableAttribute(Attributes.MAX_HEALTH, 80.0D)
			.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.2D)
			.create()
		);
		GlobalEntityTypeAttributes.put(PCEntities.HELLHOUND.get(),
			MobEntity.func_233666_p_()
			.createMutableAttribute(Attributes.MAX_HEALTH, 14.0D)
			.create()
		);
		GlobalEntityTypeAttributes.put(PCEntities.CRAB.get(),
			MobEntity.func_233666_p_()
			.createMutableAttribute(Attributes.MAX_HEALTH, 6.0D)
			.create()
		);
		GlobalEntityTypeAttributes.put(PCEntities.SEAHORSE.get(),
			MobEntity.func_233666_p_()
			.createMutableAttribute(Attributes.MAX_HEALTH, 3.0D)
			.create()
		);
		GlobalEntityTypeAttributes.put(PCEntities.ACIDIC_ARCHVINE.get(),
			MobEntity.func_233666_p_()
			.createMutableAttribute(Attributes.MAX_HEALTH, 20.0D)
			.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
			.createMutableAttribute(Attributes.FOLLOW_RANGE, 30.0D)
			.create()
		);
		GlobalEntityTypeAttributes.put(PCEntities.BUFFLON.get(),
			MobEntity.func_233666_p_()
			.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.55D)
			.createMutableAttribute(Attributes.MAX_HEALTH, 60.0D)
			.createMutableAttribute(Attributes.ATTACK_DAMAGE, 10.0D)
			.create()
		);
		GlobalEntityTypeAttributes.put(PCEntities.END_TROLL.get(),
			MobEntity.func_233666_p_()
			.createMutableAttribute(Attributes.MAX_HEALTH, 200.0D)
			.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
			.createMutableAttribute(Attributes.FOLLOW_RANGE, 30.0D)
			.create()
		);
	}	
}