package andrews.pandoras_creatures.registry;

import net.minecraft.item.Food;

public class PCFoods
{	
	//The Crab Meat ItemFood
	public static final Food CRAB_MEAT(boolean cooked)
	{
		return cooked ? new Food.Builder().hunger(6).saturation(0.6F).build() : new Food.Builder().hunger(3).saturation(0.3F).build();
	}
	
	//The Seahorse ItemFood
	public static final Food SEAHORSE(boolean cooked)
	{
		return cooked ? new Food.Builder().hunger(6).saturation(0.6F).build() : new Food.Builder().hunger(3).saturation(0.3F).build();
	}
	
	//The Bufflon Beef ItemFood
	public static final Food BUFFLON_BEEF(boolean cooked)
	{
		return cooked ? new Food.Builder().hunger(10).saturation(0.9F).build() : new Food.Builder().hunger(4).saturation(0.4F).build();
	}
}