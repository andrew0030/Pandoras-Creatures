package andrews.pandoras_creatures.objects.items;

import java.util.List;

import andrews.pandoras_creatures.Main;
import andrews.pandoras_creatures.entities.CrabEntity;
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

public class ItemCrabBucket extends ItemMobBucket
{
	public ItemCrabBucket(EntityType<? extends CrabEntity> entityType, Fluid fluid)
	{
		super(entityType, fluid, getProperties());
		this.addPropertyOverride(new ResourceLocation("variant"), (stack, world, entity) ->
		{
			CompoundNBT compoundnbt = stack.getTag();
			if(compoundnbt != null && compoundnbt.contains("BucketVariantTag", 3))
			{
				return compoundnbt.getInt("BucketVariantTag");
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
		if(compoundnbt != null && compoundnbt.contains("BucketVariantTag", 3))
		{
			int i = compoundnbt.getInt("BucketVariantTag");
			TextFormatting[] atextformatting = new TextFormatting[] {TextFormatting.ITALIC, TextFormatting.GRAY};
			
			tooltip.add((new TranslationTextComponent(CrabEntity.getNameById(i)).applyTextStyles(atextformatting)));
		}
	}
}