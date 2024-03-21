package kaliah.better_than_bows.item;

import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.entity.projectile.EntityArrow;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class ItemSlingshot extends Item {
	public ItemSlingshot(String name, int id) {
		super(name, id);
		this.setMaxStackSize(1);
		this.setMaxDamage(1000);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		world.playSoundAtEntity(entityplayer, "random.bow", 0.3F, 1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));
		if (!world.isClientSide) {
			world.entityJoinedWorld(new EntityArrow(world, entityplayer, true, 0));
		}
		return itemstack;
	}
}
