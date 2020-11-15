package mod.azure.doom.util;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.mob.HoglinEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.PhantomEntity;
import net.minecraft.entity.mob.ShulkerEntity;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class MyExplosion extends Explosion {

	private final World world;
	private final double x;
	private final double y;
	private final double z;
	@Nullable
	private final Entity entity;
	private final float power;

	public MyExplosion(World world, Entity entity, double d, double e, double f, float g) {
		super(world, entity, d, e, f, g, false, DestructionType.NONE);
		this.world = world;
		this.entity = entity;
		this.power = g;
		this.x = d;
		this.y = e;
		this.z = f;
	}

	public void collectBlocksAndDamageEntities() {
		float q = this.power * 2.0F;
		int k = MathHelper.floor(this.x - (double) q - 1.0D);
		int l = MathHelper.floor(this.x + (double) q + 1.0D);
		int t = MathHelper.floor(this.y - (double) q - 1.0D);
		int u = MathHelper.floor(this.y + (double) q + 1.0D);
		int v = MathHelper.floor(this.z - (double) q - 1.0D);
		int w = MathHelper.floor(this.z + (double) q + 1.0D);
		List<Entity> list = this.world.getOtherEntities(this.entity,
				new Box((double) k, (double) t, (double) v, (double) l, (double) u, (double) w));
		Vec3d vec3d = new Vec3d(this.x, this.y, this.z);

		for (int x = 0; x < list.size(); ++x) {
			Entity entity = (Entity) list.get(x);
			if (!(entity instanceof PlayerEntity) && (entity instanceof HostileEntity)
					|| (entity instanceof SlimeEntity) || (entity instanceof PhantomEntity)
					|| (entity instanceof ShulkerEntity) || (entity instanceof HoglinEntity)) {
				double y = (double) (MathHelper.sqrt(entity.squaredDistanceTo(vec3d)) / q);
				if (y <= 1.0D) {
					double z = entity.getX() - this.x;
					double aa = (entity instanceof TntEntity ? entity.getY() : entity.getEyeY()) - this.y;
					double ab = entity.getZ() - this.z;
					double ac = (double) MathHelper.sqrt(z * z + aa * aa + ab * ab);
					if (ac != 0.0D) {
						entity.damage(this.getDamageSource(), 100);
					}
				}
			}
		}

	}

}
