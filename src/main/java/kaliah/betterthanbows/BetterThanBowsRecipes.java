package kaliah.betterthanbows;

import net.minecraft.core.item.Items;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.util.RecipeEntrypoint;

import static kaliah.betterthanbows.BetterThanBows.MOD_ID;
import static kaliah.betterthanbows.BetterThanBowsItems.*;

public class BetterThanBowsRecipes implements RecipeEntrypoint {
	@Override
	public void onRecipesReady() {
		RecipeBuilder.Shaped(MOD_ID)
			.setShape(
				"SLS",
				"W W",
				" W "
			)
			.addInput('S', Items.STRING)
			.addInput('L', Items.LEATHER)
			.addInput('W', Items.STICK)
			.create("slingshotRecipe", slingshot.getDefaultStack());

		RecipeBuilder.addItemsToGroup("minecraft", slingshot.getKey(), Items.TOOL_BOW);
	}

	@Override
	public void initNamespaces() {
		RecipeBuilder.initNameSpace(MOD_ID);
	}
}
