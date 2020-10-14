package andrews.pandoras_creatures.objects.items;

import java.util.List;
import java.util.function.Supplier;

import andrews.pandoras_creatures.PandorasCreatures;
import andrews.pandoras_creatures.entities.SeahorseEntity;
import andrews.pandoras_creatures.registry.PCEntities;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.Constants.NBT;

public class ItemSeahorseBucket extends ItemMobBucket
{
	public ItemSeahorseBucket(Supplier<? extends Fluid> supplier)
	{
		super(() -> PCEntities.SEAHORSE.get(), supplier, getProperties());
	}
	
	private static Properties getProperties()
	{
		Properties properties = new Properties();
		properties.group(PandorasCreatures.PANDORAS_CREATURES_GROUP);
		properties.maxStackSize(1);
		
		return properties;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	{
		CompoundNBT compoundnbt = stack.getTag();
		if(compoundnbt != null && compoundnbt.contains("BucketVariantTag", NBT.TAG_INT) && compoundnbt.contains("BucketSizeTag", NBT.TAG_INT))
		{
			int i = compoundnbt.getInt("BucketVariantTag");
			int size = compoundnbt.getInt("BucketSizeTag");
			TextFormatting[] atextformatting = new TextFormatting[] {TextFormatting.ITALIC, TextFormatting.GRAY};
			
			tooltip.add((new TranslationTextComponent(SeahorseEntity.getNameById(i)).mergeStyle(atextformatting)));
			tooltip.add((new TranslationTextComponent(SeahorseEntity.getSizeById(size)).mergeStyle(atextformatting)));
		}
	}
}