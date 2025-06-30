package kaliah.betterthanbows.entity;

import kaliah.betterthanbows.utility.Utils;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.projectile.Projectile;
import net.minecraft.core.sound.SoundCategory;
import net.minecraft.core.util.helper.DamageType;
import net.minecraft.core.util.phys.HitResult;
import net.minecraft.core.world.World;

// TODO: Start slightly behind and to the right of the player, so it looks like it is shot from the slingshot
// TODO: Redo flight model

public class ProjectileSlingshot extends Projectile {
	private final float drawPercentage;

	public ProjectileSlingshot(World world, Mob owner, float drawPercentage) {
		super(world, owner);
		this.drawPercentage = drawPercentage;
		initProjectile();
	}

	public void initProjectile() {
		this.damage = drawPercentageToDamage(drawPercentage);
		this.defaultGravity = drawPercentageToGravity(drawPercentage);
		this.defaultProjectileSpeed = drawPercentageToSpeed(drawPercentage);
	}

	private int drawPercentageToDamage(float drawPercentage) {
		return Math.round(3 * drawPercentage);
	}

	private float drawPercentageToGravity(float drawPercentage) {
		return Utils.mapPercentage(drawPercentage, 0.1F, 0.015F);
	}

	private float drawPercentageToSpeed(float drawPercentage) {
		return Utils.mapPercentage(drawPercentage, 0.60F, 1.02F);
	}

	public void onHit(HitResult hitResult) {
		if (hitResult.entity != null) {
			hitResult.entity.hurt(this.owner, this.damage, DamageType.COMBAT);
			this.world.playSoundAtEntity(hitResult.entity, hitResult.entity, "random.glass", 0.8F, 3.0F / (random.nextFloat() * 0.4F + 0.8F));
		}
		else {
			this.world.playSoundEffect(null, SoundCategory.ENTITY_SOUNDS, hitResult.x, hitResult.y, hitResult.z, "random.glass", 0.8F, 3.0F / (random.nextFloat() * 0.4F + 0.8F));
		}

		this.remove();
	}
}
