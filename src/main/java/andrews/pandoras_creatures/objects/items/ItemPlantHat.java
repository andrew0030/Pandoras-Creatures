package andrews.pandoras_creatures.objects.items;

import java.util.List;

import andrews.pandoras_creatures.PandorasCreatures;
import andrews.pandoras_creatures.objects.armors.PlantHatModel;
import andrews.pandoras_creatures.util.Reference;
import andrews.pandoras_creatures.util.TranslationHelper;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemPlantHat extends ArmorItem
{

	public ItemPlantHat(IArmorMaterial materialIn, EquipmentSlotType slot)
	{
		super(materialIn, slot, getProperties());
	}
	
	private static Properties getProperties()
	{
		Properties properties = new Properties();
		properties.group(PandorasCreatures.PANDORAS_CREATURES_GROUP);
		properties.maxStackSize(1);
		
		return properties;
	}
	
	@OnlyIn(Dist.CLIENT)
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	{
		TranslationHelper.getTooltipFromLang(tooltip, "item.pandoras_creatures.plant_hat.tooltip", stack);
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type)
	{
		return Reference.MODID + ":textures/models/armor/plant_hat.png";
	}
	
	@SuppressWarnings({"unchecked", "rawtypes"})
	@Override
	@OnlyIn(Dist.CLIENT)
	public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack stack, EquipmentSlotType armorSlot, A _default)
	{
		PlantHatModel plantHatModel = new PlantHatModel(entityLiving, 1.0F);
		plantHatModel.setRotationAngles(entityLiving, entityLiving.limbSwing, entityLiving.limbSwingAmount, entityLiving.ticksExisted, entityLiving.rotationYaw, entityLiving.rotationPitch);
		return (A) plantHatModel;
	}
}
