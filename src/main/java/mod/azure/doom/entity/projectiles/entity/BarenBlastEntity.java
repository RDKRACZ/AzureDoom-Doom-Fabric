package mod.azure.doom.entity.projectiles.entity;

import mod.azure.doom.util.ModSoundEvents;
import mod.azure.doom.util.packets.EntityPacket;
import mod.azure.doom.util.registry.ProjectilesEntityRegister;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ExplosiveProjectileEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Packet;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class BarenBlastEntity extends ExplosiveProjectileEntity {

	public int explosionPower = 1;
	protected int timeInAir;
	protected boolean inAir;
	private int ticksInAir;

	public BarenBlastEntity(EntityType<? extends BarenBlastEntity> p_i50160_1_, World p_i50160_2_) {
		super(p_i50160_1_, p_i50160_2_);
	}

	public BarenBlastEntity(World worldIn, LivingEntity shooter, double accelX, double accelY, double accelZ) {
		super(ProjectilesEntityRegister.BARENBLAST, shooter, accelX, accelY, accelZ, worldIn);
	}

	public BarenBlastEntity(World worldIn, double x, double y, double z, double accelX, double accelY, double accelZ) {
		super(ProjectilesEntityRegister.BARENBLAST, x, y, z, accelX, accelY, accelZ, worldIn);
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
	protected void onCollision(HitResult result) {
		super.onCollision(result);
		if (!this.world.isClient) {
			this.explode();
			this.remove();
		}
		this.playSound(ModSoundEvents.ROCKET_HIT, 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));

	}

	@Override
	protected void onEntityHit(EntityHitResult p_213868_1_) {
		super.onEntityHit(p_213868_1_);
		if (!this.world.isClient) {
			this.explode();
			this.remove();
		}
		this.playSound(ModSoundEvents.ROCKET_HIT, 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
	}

	protected void explode() {
		this.world.createExplosion(this, this.getX(), this.getBodyY(0.0625D), this.getZ(), 1.0F, false,
				Explosion.DestructionType.NONE);
	}

}