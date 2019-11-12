package andrews.pandoras_creatures.registry;

import net.minecraft.item.Food;

public class PCFoods
{	
	//The Crab Meat ItemFood
	public static final Food CRAB_MEAT(boolean cooked)
	{
		return cooked ? new Food.Builder().hunger(8).saturation(0.8F).build() : new Food.Builder().hunger(3).saturation(0.3F).build();
	}
	
	//The Seahorse ItemFood
	public static final Food SEAHORSE(boolean cooked)
	{
		return cooked ? new Food.Builder().hunger(7).saturation(0.8F).build() : new Food.Builder().hunger(3).saturation(0.3F).build();
	}
}