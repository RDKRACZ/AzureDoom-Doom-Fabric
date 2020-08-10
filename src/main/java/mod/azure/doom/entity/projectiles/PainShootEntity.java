package mod.azure.doom.entity.projectiles;

import mod.azure.doom.util.ModEntityTypes;
import mod.azure.doom.util.ModSoundEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ExplosiveProjectileEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class PainShootEntity extends ExplosiveProjectileEntity {

	public int explosionPower = 1;
	protected int timeInAir;
	protected boolean inAir;
	private int ticksInAir;

	@SuppressWarnings("unchecked")
	public PainShootEntity(EntityType<?> type, World world) {
		super((EntityType<? extends ExplosiveProjectileEntity>) type, world);
	}

	public PainShootEntity(World worldIn, double x, double y, double z, double accelX, double accelY, double accelZ) {
		super(ModEntityTypes.LOST_SOUL_SHOOT, x, y, z, accelX, accelY, accelZ, worldIn);
	}

	public PainShootEntity(World worldIn, LivingEntity shooter, double accelX, double accelY, double accelZ) {
		super(ModEntityTypes.LOST_SOUL_SHOOT, shooter, accelX, accelY, accelZ, worldIn);
	}

	protected void func_225516_i_() {
		++this.ticksInAir;
		if (this.ticksInAir >= 40) {
			this.remove();
		}
	}

	@Override
	public void writeCustomDataToTag(CompoundTag tag) {
		super.writeCustomDataToTag(tag);
		tag.putShort("life", (short) this.ticksInAir);
	}

	@Override
	public void readCustomDataFromTag(CompoundTag tag) {
		super.readCustomDataFromTag(tag);
		this.ticksInAir = tag.getShort("life");
	}

	@Override
	public void tick() {
		super.tick();
		this.world.sendEntityStatus(this, (byte) 0);
	}

	@Override
	protected boolean isBurning() {
		return false;
	}

	@Override
	protected ParticleEffect getParticleType() {
		return ParticleTypes.CRIT;
	}

	@Override
	public Packet<?> createSpawnPacket() {
		return new EntitySpawnS2CPacket(this);
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
	public boolean collides() {
		return true;
	}

	@Override
	protected void onBlockHit(BlockHitResult blockHitResult) {
		super.onBlockHit(blockHitResult);
		if (!this.world.isClient) {
			this.explode();
			this.remove();
		}
		this.playSound(ModSoundEvents.LOST_SOUL_AMBIENT, 1.0F, 1.0F);

	}

	@Override
	protected void onEntityHit(EntityHitResult entityHitResult) {
		super.onEntityHit(entityHitResult);
		if (!this.world.isClient) {
			this.explode();
			this.remove();
		}
		this.playSound(ModSoundEvents.LOST_SOUL_AMBIENT, 1.0F, 1.0F);
	}

	protected void explode() {
		this.world.createExplosion(this, this.getX(), this.getBodyY(0.0625D), this.getZ(), 1.0F,
				Explosion.DestructionType.NONE);
	}

}