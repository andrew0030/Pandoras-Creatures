package andrews.pandoras_creatures.crafting;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;

import andrews.pandoras_creatures.objects.blocks.EndTrollBoxBlock;
import andrews.pandoras_creatures.registry.PCCrafting;
import andrews.pandoras_creatures.registry.PCTags;
import net.minecraft.block.Block;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class EndTrollBoxRecipe extends ShapedRecipe
{
	public EndTrollBoxRecipe(ResourceLocation id, String group, int width, int height, NonNullList<Ingredient> ingredients, ItemStack output)
	{
		super(id, group, width, height, ingredients, output);
	}
	
	@Override
	public ItemStack getCraftingResult(CraftingInventory inventory)
	{
		final ItemStack craftingResult = super.getCraftingResult(inventory);
		boolean shulkerPresent = false;
		
		for(int index = 0; index < inventory.getSizeInventory(); ++index) // Checks all Slots in Crafting table
		{
			final ItemStack slotStack = inventory.getStackInSlot(index); //Gets the ItemStack for each Slot
			if(!slotStack.isEmpty()) // Makes sure there is an ItemStack in the given Slot
			{
				final Item item = slotStack.getItem();
				if(item.isIn(PCTags.Items.VANILLA_SHULKER_BOXES))
				{
					if(shulkerPresent) // Does not allow multiple shulker boxes, if somebody changed the recipe to be so
					{
						return ItemStack.EMPTY;
					}
					shulkerPresent = true;
					
					ShulkerBoxBlock shulkerBoxBlock = (ShulkerBoxBlock) Block.getBlockFromItem(item);
					DyeColor color = shulkerBoxBlock.getColor();
					if(color != null) // Checks if the item is a colored shulker (has a color)
					{
						final ItemStack coloredEndTrollBox = new ItemStack(Item.BLOCK_TO_ITEM.get(EndTrollBoxBlock.getBlockByColor(color)));
						
						if(slotStack.hasTag())
						{
							coloredEndTrollBox.setTag(slotStack.getTag().copy()); // Copy tag from shulker
						}
						return coloredEndTrollBox;
					}
					else
					{
						if(slotStack.hasTag())
						{
							craftingResult.setTag(slotStack.getTag().copy()); // Copy tag from shulker
						}
					}
				}
			}
		}
		return craftingResult;
	}
	
	@Override
	public IRecipeSerializer<?> getSerializer()
	{
		return PCCrafting.END_TROLL_BOX_RECIPE.get();
	}
	
	public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<EndTrollBoxRecipe>
	{
        @Override
        public EndTrollBoxRecipe read(ResourceLocation recipeId, JsonObject json)
        {
            ShapedRecipe recipe = IRecipeSerializer.CRAFTING_SHAPED.read(recipeId, json);
            return new EndTrollBoxRecipe(recipeId, recipe.getGroup(), recipe.getRecipeWidth(), recipe.getRecipeHeight(), recipe.getIngredients(), recipe.getRecipeOutput());
        }

        @Nullable
        @Override
        public EndTrollBoxRecipe read(ResourceLocation recipeId, PacketBuffer buffer)
        {
            ShapedRecipe recipe = IRecipeSerializer.CRAFTING_SHAPED.read(recipeId, buffer);
            return new EndTrollBoxRecipe(recipeId, recipe.getGroup(), recipe.getRecipeWidth(), recipe.getRecipeHeight(), recipe.getIngredients(), recipe.getRecipeOutput());
        }

        @Override
        public void write(PacketBuffer buffer, EndTrollBoxRecipe recipe)
        {
            IRecipeSerializer.CRAFTING_SHAPED.write(buffer, recipe);
        }
    }
}