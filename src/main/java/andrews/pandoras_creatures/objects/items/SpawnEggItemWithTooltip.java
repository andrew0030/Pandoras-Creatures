package andrews.pandoras_creatures.objects.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SpawnEggItemWithTooltip extends SpawnEggItem
{
	private TranslationTextComponent text;
	
	public SpawnEggItemWithTooltip(EntityType<?> typeIn, int primaryColorIn, int secondaryColorIn, TranslationTextComponent text, Properties builder)
	{
		super(typeIn, primaryColorIn, secondaryColorIn, builder);
		this.text = text;
	}
	
	@OnlyIn(Dist.CLIENT)
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	{
		tooltip.add(text);
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
}
