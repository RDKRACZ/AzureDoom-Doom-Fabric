package mod.azure.doom.entity.projectiles.entity;

import mod.azure.doom.util.packets.EntityPacket;
import mod.azure.doom.util.registry.ProjectilesEntityRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ExplosiveProjectileEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Packet;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class ShotgunMobEntity extends ExplosiveProjectileEntity {

	public int explosionPower = 1;
	protected int timeInAir;
	protected boolean inAir;
	private int ticksInAir;

	public ShotgunMobEntity(EntityType<? extends ShotgunMobEntity> p_i50160_1_, World p_i50160_2_) {
		super(p_i50160_1_, p_i50160_2_);
	}

	public ShotgunMobEntity(World worldIn, LivingEntity shooter, double accelX, double accelY, double accelZ) {
		super(ProjectilesEntityRegister.BULLETS_MOB, shooter, accelX, accelY, accelZ, worldIn);
	}

	public ShotgunMobEntity(World worldIn, double x, double y, double z, double accelX, double accelY, double accelZ) {
		super(ProjectilesEntityRegister.BULLETS_MOB, x, y, z, accelX, accelY, accelZ, worldIn);
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
		Entity entity = this.getOwner();
		if (p_213868_1_.getType() != EntityHitResult.Type.ENTITY
				|| !((EntityHitResult) p_213868_1_).getEntity().isPartOf(entity)) {
			if (!this.world.isClient) {
				this.remove();
			}
		}
	}

	@Override
	protected void onCollision(HitResult hitResult) {
		super.onCollision(hitResult);
		Entity entity = this.getOwner();
		if (hitResult.getType() != EntityHitResult.Type.ENTITY
				|| !((EntityHitResult) hitResult).getEntity().isPartOf(entity)) {
			if (!this.world.isClient) {
				this.remove();
			}
		}
	}

}