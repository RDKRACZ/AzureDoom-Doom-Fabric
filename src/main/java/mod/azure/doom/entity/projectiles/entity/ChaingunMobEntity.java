package mod.azure.doom.entity.projectiles.entity;

import java.util.List;

import mod.azure.doom.util.ModSoundEvents;
import mod.azure.doom.util.packets.EntityPacket;
import mod.azure.doom.util.registry.ProjectilesEntityRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.ExplosiveProjectileEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Packet;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ChaingunMobEntity extends ExplosiveProjectileEntity {

	public int explosionPower = 1;
	protected int timeInAir;
	protected boolean inAir;
	private int ticksInAir;

	public ChaingunMobEntity(EntityType<? extends ChaingunMobEntity> p_i50160_1_, World p_i50160_2_) {
		super(p_i50160_1_, p_i50160_2_);
	}

	public ChaingunMobEntity(World worldIn, LivingEntity shooter, double accelX, double accelY, double accelZ) {
		super(ProjectilesEntityRegister.CHAINGUN_MOB, shooter, accelX, accelY, accelZ, worldIn);
	}

	public ChaingunMobEntity(World worldIn, double x, double y, double z, double accelX, double accelY, double accelZ) {
		super(ProjectilesEntityRegister.CHAINGUN_MOB, x, y, z, accelX, accelY, accelZ, worldIn);
	}

	@Override
	public void writeCustomDataToTag(CompoundTag compound) {
		super.writeCustomDataToTag(compound);
		compound.putShort("life", (short) this.ticksInAir);
	}

	@Override
	public void readCustomDataFromTag(CompoundTag compound) {
		super.readCustomDataFromTag(compound);
		this.ticksInAir = compound.getShort("life");
	}

	protected boolean isFireballFiery() {
		return false;
	}

	@Override
	public Packet<?> createSpawnPacket() {
		return EntityPacket.createPacket(this);
	}

	@Override
	public boolean hasNoGravity() {
		if (this.isSubmergedInWater()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	protected void onEntityHit(EntityHitResult p_213868_1_) {
		super.onEntityHit(p_213868_1_);
		if (!this.world.isClient) {
			this.doDamage();
			this.remove();
		}
		this.playSound(ModSoundEvents.CHAINGUN_SHOOT, 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
	}

	public void doDamage() {
		float f2 = 24.0F;
		int k1 = MathHelper.floor(this.getX() - (double) f2 - 1.0D);
		int l1 = MathHelper.floor(this.getX() + (double) f2 + 1.0D);
		int i2 = MathHelper.floor(this.getY() - (double) f2 - 1.0D);
		int i1 = MathHelper.floor(this.getY() + (double) f2 + 1.0D);
		int j2 = MathHelper.floor(this.getZ() - (double) f2 - 1.0D);
		int j1 = MathHelper.floor(this.getZ() + (double) f2 + 1.0D);
		List<Entity> list = this.world.getOtherEntities(this,
				new Box((double) k1, (double) i2, (double) j2, (double) l1, (double) i1, (double) j1));
		Vec3d vector3d = new Vec3d(this.getX(), this.getY(), this.getZ());
		for (int k2 = 0; k2 < list.size(); ++k2) {
			Entity entity = list.get(k2);
			double d12 = (double) (MathHelper.sqrt(entity.squaredDistanceTo(vector3d)) / f2);
			if (d12 <= 1.0D) {
				entity.damage(DamageSource.thrownProjectile(this, this), 3);
			}
		}
	}
}