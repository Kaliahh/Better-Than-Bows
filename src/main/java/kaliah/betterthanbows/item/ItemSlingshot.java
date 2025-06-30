package kaliah.betterthanbows.item;

import kaliah.betterthanbows.entity.ProjectileSlingshot;
import kaliah.betterthanbows.utility.Utils;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.world.World;
import org.lwjgl.input.Mouse;

public class ItemSlingshot extends Item {
	public ItemSlingshot(String translationKey, String namespaceId, int id) {
		super(translationKey, namespaceId, id);
		resetDraw();
	}

	private int drawTicks;
	private final int fullDrawTicks = 10;
	private boolean isDrawing;

	@Override
	public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slotId, boolean flag) {
		super.inventoryTick(itemstack, world, entity, slotId, flag);

		if (isDrawing && Mouse.isButtonDown(1)) {
			draw(itemstack);
		}
		else if (isDrawing) {
			if (entity instanceof Player) {
				Player player = (Player) entity;

				if (player.getHeldItem() != null && player.getHeldItem().isItemEqual(itemstack)) {
					fire(itemstack, world, player);
				}

				resetDraw(itemstack);
			}
		}
	}

	private void draw(ItemStack itemstack) {
		drawTicks++;
		itemstack.getData().putInt("drawTicks", drawTicks);
		itemstack.getData().putBoolean("atFullDraw", atFullDraw());
	}

	private void resetDraw(ItemStack itemstack) {
		resetDraw();
		itemstack.getData().putBoolean("atFullDraw", false);
		itemstack.getData().putInt("drawTicks", 0);
	}

	private void resetDraw() {
		drawTicks = 0;
		isDrawing = false;
	}

	private boolean atFullDraw() {
		return drawTicks >= fullDrawTicks;
	}

	@Override
	public ItemStack onUseItem(ItemStack itemstack, World world, Player player) {
		if (player.hasItem(Items.AMMO_PEBBLE)) {
			isDrawing = true;
		}

		return itemstack;
	}

	private void fire(ItemStack itemstack, World world, Player player) {
		if (player.inventory.consumeInventoryItem(Items.AMMO_PEBBLE.id)) {
			itemstack.damageItem(1, player);
			float drawPercentage = getDrawPercentage();
			playRandomSound(player, world, "bow", 0.2F, drawPercentageToPitch(drawPercentage));
			if (!world.isClientSide) {
				world.entityJoinedWorld(new ProjectileSlingshot(world, player, drawPercentage));
			}
		}
	}

	private float drawPercentageToPitch(float drawPercentage) {
		return Utils.mapPercentage(drawPercentage, 0.5F, 1.5F);
	}

	private float getDrawPercentage() {
		return Math.min(drawTicks, fullDrawTicks) / (float) fullDrawTicks;
	}

	private void playRandomSound(Entity entity, World world, String sound, float volume, float pitch) {
		world.playSoundAtEntity(entity, entity, "random." + sound, volume, pitch / (itemRand.nextFloat() * 0.4F + 0.8F));
	}
}
