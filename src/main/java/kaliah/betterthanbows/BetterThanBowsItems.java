package kaliah.betterthanbows;

import kaliah.betterthanbows.item.ItemSlingshot;
import net.minecraft.core.item.Item;
import turniplabs.halplibe.helper.ItemBuilder;
import turniplabs.halplibe.util.ItemInitEntrypoint;

import java.util.HashMap;
import java.util.Map;

import static kaliah.betterthanbows.BetterThanBows.MOD_ID;

public class BetterThanBowsItems implements ItemInitEntrypoint {
	public static Map<Item, String> textures = new HashMap<>();
	int itemId = 26174;

	public static Item slingshot;

	@Override
	public void afterItemInit() {
		slingshot = createWeapon("slingshot", 50);
	}

	private Item createWeapon(String translationKey, int maxDamage) {
		return createItem(new ItemSlingshot(translationKey, formatNamespaceId(translationKey), itemId++), maxDamage, translationKey);
	}

	private String formatNamespaceId(String translationKey) {
		return String.format("%s:item/%s", MOD_ID, translationKey);
	}

	private Item createItem(Item item, int maxDamage, String texture) {
		textures.put(item, texture);
		return new ItemBuilder(MOD_ID)
			.setMaxDamage(maxDamage)
			.build(item);
	}
}
