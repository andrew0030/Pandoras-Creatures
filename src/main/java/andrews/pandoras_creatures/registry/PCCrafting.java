package andrews.pandoras_creatures.registry;

import andrews.pandoras_creatures.crafting.EndTrollBoxColoringRecipe;
import andrews.pandoras_creatures.crafting.EndTrollBoxRecipe;
import andrews.pandoras_creatures.util.Reference;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PCCrafting
{
	public static final DeferredRegister<IRecipeSerializer<?>> RECIPES = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Reference.MODID);
	
	public static final RegistryObject<IRecipeSerializer<EndTrollBoxRecipe>> END_TROLL_BOX_RECIPE = RECIPES.register("end_troll_box", () -> new EndTrollBoxRecipe.Serializer());
	public static final RegistryObject<IRecipeSerializer<EndTrollBoxColoringRecipe>> END_TROLL_BOX_COLORING_RECIPE = RECIPES.register("end_troll_box_coloring", () -> new EndTrollBoxColoringRecipe.Serializer());
}