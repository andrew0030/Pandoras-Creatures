package andrews.pandoras_creatures.crafting;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;

import andrews.pandoras_creatures.objects.blocks.BlockEndTrollBox;
import andrews.pandoras_creatures.registry.PCCrafting;
import andrews.pandoras_creatures.registry.PCTags;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapelessRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class EndTrollBoxColoringRecipe extends ShapelessRecipe
{
	public EndTrollBoxColoringRecipe(ResourceLocation id, String group, ItemStack output, NonNullList<Ingredient> ingredients)
	{
		super(id, group, output, ingredients);
	}
	
	@Override
	public ItemStack getCraftingResult(CraftingInventory inventory)
	{
		final ItemStack craftingResult = super.getCraftingResult(inventory);
		boolean endTrollBoxPresent = false;
		boolean dyeItemPresent = false;
		DyeColor colorItem = null;
		
		for(int index = 0; index < inventory.getSizeInventory(); ++index) // Checks all Slots in Crafting table
		{
			final ItemStack slotStack = inventory.getStackInSlot(index); //Gets the ItemStack for each Slot
			if(!slotStack.isEmpty()) // Makes sure there is an ItemStack in the given Slot
			{
				final Item item = slotStack.getItem();
				
				if(item.isIn(Tags.Items.DYES))
				{
					if(dyeItemPresent) // Does not allow multiple End Troll Boxes, if somebody changed the recipe to be so
					{
						return ItemStack.EMPTY;
					}
					dyeItemPresent = true;
					
					colorItem = DyeColor.getColor(new ItemStack(item));
				}
			}
		}
		
		for(int index = 0; index < inventory.getSizeInventory(); ++index) // Checks all Slots in Crafting table
		{
			final ItemStack slotStack = inventory.getStackInSlot(index); //Gets the ItemStack for each Slot
			if(!slotStack.isEmpty()) // Makes sure there is an ItemStack in the given Slot
			{
				final Item item = slotStack.getItem();
				
				if(item.isIn(PCTags.Items.END_TROLL_BOXES))
				{
					if(endTrollBoxPresent) // Does not allow multiple End Troll Boxes, if somebody changed the recipe to be so
					{
						return ItemStack.EMPTY;
					}
					endTrollBoxPresent = true;
					
					final ItemStack coloredEndTrollBox = new ItemStack(Item.BLOCK_TO_ITEM.get(BlockEndTrollBox.getBlockByColor(colorItem)));
					
					if(slotStack.hasTag())
					{
						coloredEndTrollBox.setTag(slotStack.getTag().copy()); // Copy tag from shulker
					}
					return coloredEndTrollBox;
				}
			}
		}
		return craftingResult;
	}

	@Override
	public IRecipeSerializer<?> getSerializer()
	{
		return PCCrafting.END_TROLL_BOX_COLORING_RECIPE.get();
	}

	public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<EndTrollBoxColoringRecipe>
	{
        @Override
        public EndTrollBoxColoringRecipe read(ResourceLocation recipeId, JsonObject json)
        {
            ShapelessRecipe recipe = IRecipeSerializer.CRAFTING_SHAPELESS.read(recipeId, json);
            return new EndTrollBoxColoringRecipe(recipeId, recipe.getGroup(), recipe.getRecipeOutput(), recipe.getIngredients());
        }

        @Nullable
        @Override
        public EndTrollBoxColoringRecipe read(ResourceLocation recipeId, PacketBuffer buffer)
        {
        	ShapelessRecipe recipe = IRecipeSerializer.CRAFTING_SHAPELESS.read(recipeId, buffer);
            return new EndTrollBoxColoringRecipe(recipeId, recipe.getGroup(), recipe.getRecipeOutput(), recipe.getIngredients());
        }

        @Override
        public void write(PacketBuffer buffer, EndTrollBoxColoringRecipe recipe)
        {
            IRecipeSerializer.CRAFTING_SHAPELESS.write(buffer, recipe);
        }
    }
}