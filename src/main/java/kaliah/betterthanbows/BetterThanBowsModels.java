package kaliah.betterthanbows;

import kaliah.betterthanbows.entity.ProjectileSlingshot;
import kaliah.betterthanbows.item.model.ItemModelSlingshot;
import net.minecraft.client.render.EntityRenderDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.entity.EntityRendererSprite;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelStandard;
import net.minecraft.core.item.Items;
import net.minecraft.core.util.collection.NamespaceID;
import turniplabs.halplibe.helper.EntityHelper;
import turniplabs.halplibe.helper.ModelHelper;
import turniplabs.halplibe.util.ModelEntrypoint;

import static kaliah.betterthanbows.BetterThanBows.MOD_ID;
import static kaliah.betterthanbows.BetterThanBowsItems.textures;

public class BetterThanBowsModels implements ModelEntrypoint {
	@Override
	public void initBlockModels(BlockModelDispatcher blockModelDispatcher) {

	}

	@Override
	public void initItemModels(ItemModelDispatcher itemModelDispatcher) {
		BetterThanBows.LOGGER.info(("Initializing item models"));

		textures.forEach((item, texture) -> ModelHelper.setItemModel(item, () -> {
			ItemModelStandard model = new ItemModelSlingshot(item, MOD_ID);
//			model.setRotateWhenRendering();
			model.setFull3D();
			model.setIcon(NamespaceID.getTemp(MOD_ID, "item/" + texture));
			return model;
		}));

	}

	@Override
	public void initEntityModels(EntityRenderDispatcher entityRenderDispatcher) {
		BetterThanBows.LOGGER.info(("Initializing entity models"));
		ModelHelper.setEntityModel(ProjectileSlingshot.class, () -> new EntityRendererSprite<>(Items.AMMO_PEBBLE));
	}

	@Override
	public void initTileEntityModels(TileEntityRenderDispatcher tileEntityRenderDispatcher) {

	}

	@Override
	public void initBlockColors(BlockColorDispatcher blockColorDispatcher) {

	}
}
