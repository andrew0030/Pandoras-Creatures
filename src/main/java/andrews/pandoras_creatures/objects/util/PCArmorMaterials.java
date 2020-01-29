package andrews.pandoras_creatures.objects.util;

import andrews.pandoras_creatures.registry.PCItems;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public enum PCArmorMaterials implements IArmorMaterial
{
	PLANT_HAT("plant_hat", new int[] {30, 30, 30, 30}, new int[] {1, 1, 1, 1}, 15, PCItems.ACIDIC_ARCHVINE_TONGUE.get(), SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
	
	private int[] durabilities, damageReduction;
	private int enchantability;
	private SoundEvent sound;
	private Item repairItem;
	private String name;
	private float toughness;
	
	private PCArmorMaterials(String name, int[] durabilities, int[] damageReduction, int enchantability, Item repairItem, SoundEvent sound, float toughness)
	{
		this.durabilities = durabilities;
		this.damageReduction = damageReduction;
		this.enchantability = enchantability;
		this.sound = sound;
		this.repairItem = repairItem;
		this.name = name;
		this.toughness = toughness;
	}
	
	@Override
	public int getDurability(EquipmentSlotType slotIn)
	{
		return this.durabilities[slotIn.getIndex()];
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slotIn)
	{
		return this.damageReduction[slotIn.getIndex()];
	}

	@Override
	public int getEnchantability()
	{
		return this.enchantability;
	}

	@Override
	public SoundEvent getSoundEvent()
	{
		return this.sound;
	}

	@Override
	public Ingredient getRepairMaterial()
	{
		return Ingredient.fromItems(this.repairItem);
	}

	@Override
	public String getName()
	{
		return this.name;
	}

	@Override
	public float getToughness()
	{
		return this.toughness;
	}
}
