package andrews.pandoras_creatures.objects.items;

import java.util.List;
import java.util.function.Supplier;

import andrews.pandoras_creatures.util.TranslationHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class PCSpawnEggWithTooltipItem extends PCSpawnEggItem
{
	private String langPath;
	
	/**
	 * Creates a spawn egg with a tooltip
	 * @param entityType - The entity type this egg belongs to
	 * @param primaryColor - The eggs primary color
	 * @param secondaryColor - The eggs secondary color
	 * @param langPath - The path to the lang file
	 * @param properties - The Item properties
	 */
	public PCSpawnEggWithTooltipItem(Supplier<EntityType<?>> entityType, int primaryColor, int secondaryColor, String langPath, Properties properties)
	{
		super(entityType, primaryColor, secondaryColor, properties);
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
