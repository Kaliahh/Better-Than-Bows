package kaliah.betterthanbows.item;

import kaliah.betterthanbows.entity.ProjectileSlingshot;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class ItemSlingshot extends Item {
	public ItemSlingshot(String translationKey, String namespaceId, int id) {
		super(translationKey, namespaceId, id);
	}

	@Override
	public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slotId, boolean flag) {
		super.inventoryTick(itemstack, world, entity, slotId, flag);
	}

	@Override
	public ItemStack onUseItem(ItemStack itemstack, World world, Player entityplayer) {
		world.playSoundAtEntity(entityplayer, entityplayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		if (!world.isClientSide) {
			world.entityJoinedWorld(new ProjectileSlingshot(world, entityplayer));
		}

		return itemstack;
	}
}
