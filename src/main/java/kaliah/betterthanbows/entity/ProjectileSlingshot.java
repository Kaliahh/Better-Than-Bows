package kaliah.betterthanbows.entity;

import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.projectile.Projectile;
import net.minecraft.core.util.helper.DamageType;
import net.minecraft.core.util.phys.HitResult;
import net.minecraft.core.world.World;

// TODO: Start slightly behind and to the right of the player, so it looks like it is shot from the slingshot
// TODO: Tweak flight model
// TODO: Why does it disappear so quickly?

public class ProjectileSlingshot extends Projectile {
	public ProjectileSlingshot(World world) {
		super(world);
	}

	public ProjectileSlingshot(World world, Mob owner) {
		super(world, owner);
	}

	public ProjectileSlingshot(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	public void initProjectile() {
		super.initProjectile();
		this.damage = 3;
		this.defaultGravity = 0.02F;
		this.defaultProjectileSpeed = 1.01F;
	}

	public void onHit(HitResult hitResult) {
		if (hitResult.entity != null) {
			hitResult.entity.hurt(this.owner, this.damage, DamageType.COMBAT);
		}

		this.remove();
	}
}
