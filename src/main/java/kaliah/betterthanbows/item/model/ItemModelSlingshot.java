package kaliah.betterthanbows.item.model;

import net.minecraft.client.render.Font;
import net.minecraft.client.render.ItemRenderer;
import net.minecraft.client.render.TextureManager;
import net.minecraft.client.render.item.model.ItemModelStandard;
import net.minecraft.client.render.tessellator.Tessellator;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class ItemModelSlingshot extends ItemModelStandard {
	public ItemModelSlingshot(Item item, String namespace) {
		super(item, namespace);
	}

	@Override
	public void renderItem(Tessellator tessellator, ItemRenderer renderer, ItemStack itemstack, @Nullable Entity entity, float brightness, boolean handheldTransform) {
		super.renderItem(tessellator, renderer, itemstack, entity, brightness, handheldTransform);
	}

	@Override
	public void renderItemIntoGui(Tessellator tessellator, Font font, TextureManager textureManager, ItemStack itemStack, int x, int y, float brightness, float alpha) {
		super.renderItemIntoGui(tessellator, font, textureManager, itemStack, x, y, brightness, alpha);
	}

	@Override
	public void renderItemFirstPerson(Tessellator tessellator, ItemRenderer renderer, Player player, ItemStack stack, float partialTick) {
		super.renderItemFirstPerson(tessellator, renderer, player, stack, partialTick);
	}

	@Override
	public void renderItemThirdPerson(Tessellator tessellator, ItemRenderer renderer, Entity entity, ItemStack itemstack, boolean handheldTransform) {
		super.renderItemThirdPerson(tessellator, renderer, entity, itemstack, handheldTransform);
	}

	@Override
	public void renderItemInWorld(Tessellator tessellator, Entity entity, ItemStack itemStack, float brightness, float alpha, boolean worldTransform) {
		super.renderItemInWorld(tessellator, entity, itemStack, brightness, alpha, worldTransform);
	}

	@Override
	public void heldTransformFirstPerson(ItemRenderer renderer, Entity entity, ItemStack itemStack) {
		super.heldTransformFirstPerson(renderer, entity, itemStack);
	}

	@Override
	public void heldTransformThirdPerson(ItemRenderer renderer, Entity entity, ItemStack itemStack) {
		super.heldTransformThirdPerson(renderer, entity, itemStack);
	}
}
