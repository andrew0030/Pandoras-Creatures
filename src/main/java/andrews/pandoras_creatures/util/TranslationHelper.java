package andrews.pandoras_creatures.util;

import java.util.List;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class TranslationHelper
{
	/**
	 * Adds the lines it gets to the tool tip list, used for Item tool tips
	 * @param tooltip - An ITextComponent List, simply put in the one from the method
	 * @param langPath - The path for the lang file 
	 * @param stack - The ItemStack
	 */
	public static void getTooltipFromLang(List<ITextComponent> tooltip, String langPath, ItemStack stack)
	{
		String rawText = new TranslationTextComponent(langPath).getString();
		rawText = rawText.replace("#c", "§");
		if(rawText.contains("\n"))
		{
			String[] textList = rawText.split("\n");
			for(String text : textList)
			{
				tooltip.add(new StringTextComponent(text));
			}
		}
		else
		{
			tooltip.add(new StringTextComponent(rawText));
		}
		
		//Renders another "empty" line if the item is enchanted, so the enchantments are easier to read
		if(!EnchantmentHelper.getEnchantments(stack).isEmpty())
		{
			tooltip.add(new StringTextComponent(""));
		}
	}
}
