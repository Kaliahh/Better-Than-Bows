package kaliah.better_than_bows;

import kaliah.better_than_bows.item.ItemSlingshot;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.block.Block;
import net.minecraft.core.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.ItemHelper;
import turniplabs.halplibe.helper.RecipeHelper;
import turniplabs.halplibe.util.ConfigHandler;

import java.util.Properties;

public class BetterThanBows implements ModInitializer {
	public static final String MOD_ID = "better_than_bows";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final ConfigHandler config;

	static {
		Properties properties = new Properties();
		properties.setProperty("ids.slingshot", "32495");
		config = new ConfigHandler(MOD_ID ,properties);
	}

	public static final Item slingshot = ItemHelper.createItem(MOD_ID, new ItemSlingshot("slingshot", config.getInt("ids.slingshot")), "slingshot", "slingshot.png");

	@Override
	public void onInitialize() {
		LOGGER.info("Better Than Bows initialized.");

		RecipeHelper.Crafting.createRecipe(slingshot, 1, new Object[] {
			"DDD",
			"DDD",
			"DDD",
			'D', Block.dirt
		});
	}
}
