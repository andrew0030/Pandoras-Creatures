package andrews.pandoras_creatures.objects.items;

import java.util.List;

import andrews.pandoras_creatures.util.TranslationHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SpawnEggItemWithTooltip extends SpawnEggItem
{
	private String langPath;
	
	/**
	 * Creates a spawn egg with a tooltip
	 * @param typeIn - The entity type this egg belongs to
	 * @param primaryColorIn - The eggs primary color
	 * @param secondaryColorIn - The eggs secondary color
	 * @param langPath - The path to the lang file
	 * @param builder - The Item properties
	 */
	public SpawnEggItemWithTooltip(EntityType<?> typeIn, int primaryColorIn, int secondaryColorIn, String langPath, Properties builder)
	{
		super(typeIn, primaryColorIn, secondaryColorIn, builder);
		this.langPath = langPath;
	}
	
	@OnlyIn(Dist.CLIENT)
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	{
		TranslationHelper.getTooltipFromLang(tooltip, langPath, stack);
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
}
