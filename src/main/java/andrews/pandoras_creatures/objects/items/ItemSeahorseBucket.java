package andrews.pandoras_creatures.objects.items;

import java.util.List;
import java.util.function.Supplier;

import andrews.pandoras_creatures.Main;
import andrews.pandoras_creatures.entities.SeahorseEntity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemSeahorseBucket extends ItemMobBucket
{
	public ItemSeahorseBucket(EntityType<? extends SeahorseEntity> entityType, Supplier<? extends Fluid> supplier)
	{
		super(entityType, supplier, getProperties());
		this.addPropertyOverride(new ResourceLocation("variant"), (stack, world, entity) ->
		{
			CompoundNBT compoundnbt = stack.getTag();
			if(compoundnbt != null && compoundnbt.contains("BucketVariantTag", 3))
			{
				return compoundnbt.getInt("BucketVariantTag");
			}
			return 2;
		});
		this.addPropertyOverride(new ResourceLocation("size"), (stack, world, entity) ->
		{
			CompoundNBT compoundnbt = stack.getTag();
			if(compoundnbt != null && compoundnbt.contains("BucketSizeTag", 3))
			{
				return compoundnbt.getInt("BucketSizeTag");
			}
			return 2;
		});
	}
	
	private static Properties getProperties()
	{
		Properties properties = new Properties();
		properties.group(Main.PANDORAS_CREATURES_GROUP);
		properties.maxStackSize(1);
		
		return properties;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	{
		CompoundNBT compoundnbt = stack.getTag();
		if(compoundnbt != null && compoundnbt.contains("BucketVariantTag", 3) && compoundnbt.contains("BucketSizeTag", 3))
		{
			int i = compoundnbt.getInt("BucketVariantTag");
			int size = compoundnbt.getInt("BucketSizeTag");
			TextFormatting[] atextformatting = new TextFormatting[] {TextFormatting.ITALIC, TextFormatting.GRAY};
			
			tooltip.add((new TranslationTextComponent(SeahorseEntity.getNameById(i)).applyTextStyles(atextformatting)));
			tooltip.add((new TranslationTextComponent(SeahorseEntity.getSizeById(size)).applyTextStyles(atextformatting)));
		}
	}
}