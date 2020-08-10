package mod.azure.doom.entity.projectiles;

import java.util.List;

import mod.azure.doom.EntityPacket;
import mod.azure.doom.util.DoomItems;
import mod.azure.doom.util.ProjectilesEntityRegister;
import mod.azure.doom.util.ModSoundEvents;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Packet;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class BFGEntity extends PersistentProjectileEntity {

	protected int timeInAir;
	protected boolean inAir;
	private int ticksInAir;

	public BFGEntity(EntityType<? extends BFGEntity> entityType, World world) {
		super(entityType, world);
		this.pickupType = PersistentProjectileEntity.PickupPermission.DISALLOWED;
	}

	public BFGEntity(World world, LivingEntity owner) {
		super(ProjectilesEntityRegister.BFG_CELL, owner, world);
	}

	protected BFGEntity(EntityType<? extends BFGEntity> type, double x, double y, double z, World world) {
		this(type, world);
	}

	protected BFGEntity(EntityType<? extends BFGEntity> type, LivingEntity owner, World world) {
		this(type, owner.getX(), owner.getEyeY() - 0.10000000149011612D, owner.getZ(), world);
		this.setOwner(owner);
		if (owner instanceof PlayerEntity) {
			this.pickupType = PersistentProjectileEntity.PickupPermission.ALLOWED;
		}

	}

	protected void func_225516_i_() {
		++this.ticksInAir;
		if (this.ticksInAir >= 40) {
			this.remove();
		}
	}

	@Override
	public Packet<?> createSpawnPacket() {
		return EntityPacket.createPacket(this);
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
		if (this.inGround && this.inGroundTime != 0 && this.ticksInAir >= 40) {
			this.world.sendEntityStatus(this, (byte) 0);
		}
	}

	public void initFromStack(ItemStack stack) {
		if (stack.getItem() == DoomItems.BFG_CELL) {
		}
	}

	@Override
	public ItemStack asItemStack() {
		return new ItemStack(DoomItems.BFG_CELL);
	}

	@Override
	public boolean hasNoGravity() {
		if (this.isSubmergedInWater()) {
			return false;
		} else {
			return true;
		}
	}

	protected ParticleEffect getParticleType() {
		return ParticleTypes.TOTEM_OF_UNDYING;
	}

	@Override
	protected void onBlockHit(BlockHitResult blockHitResult) {
		super.onBlockHit(blockHitResult);
		Entity entity = this.getOwner();
		if (!this.world.isClient) {
			List<LivingEntity> list = this.world.getNonSpectatingEntities(LivingEntity.class,
					this.getBoundingBox().expand(4.0D, 2.0D, 4.0D));
			AreaEffectCloudEntity areaeffectcloudentity = new AreaEffectCloudEntity(this.world, this.getX(),
					this.getY(), this.getZ());
			if (entity instanceof LivingEntity) {
				areaeffectcloudentity.setOwner((LivingEntity) entity);
			}

			areaeffectcloudentity.setParticleType(ParticleTypes.TOTEM_OF_UNDYING);
			areaeffectcloudentity.setRadius(1.0F);
			areaeffectcloudentity.setDuration(10);
			areaeffectcloudentity.setRadiusGrowth(
					(7.0F - areaeffectcloudentity.getRadius()) / (float) areaeffectcloudentity.getDuration());
			areaeffectcloudentity.addEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1, 1));
			if (!list.isEmpty()) {
				for (LivingEntity livingentity : list) {
					double d0 = this.squaredDistanceTo(livingentity);
					if (d0 < 16.0D) {
						areaeffectcloudentity.updatePosition(livingentity.getX(), livingentity.getY(),
								livingentity.getZ());
						break;
					}
				}
			}

			this.world.syncWorldEvent(2006, this.getBlockPos(), this.isSilent() ? -1 : 1);
			this.world.spawnEntity(areaeffectcloudentity);
			this.explode();
			this.remove();
		}
		this.playSound(ModSoundEvents.ROCKET_HIT, 1.0F, 1.0F);
	}

	@Override
	protected void onEntityHit(EntityHitResult entityHitResult) {
		super.onEntityHit(entityHitResult);
		Entity entity = this.getOwner();
		if (entityHitResult.getType() != HitResult.Type.ENTITY
				|| !((EntityHitResult) entityHitResult).getEntity().isPartOf(entity)) {
			if (!this.world.isClient) {
				List<LivingEntity> list = this.world.getNonSpectatingEntities(LivingEntity.class,
						this.getBoundingBox().expand(4.0D, 2.0D, 4.0D));
				AreaEffectCloudEntity areaeffectcloudentity = new AreaEffectCloudEntity(this.world, this.getX(),
						this.getY(), this.getZ());
				if (entity instanceof LivingEntity) {
					areaeffectcloudentity.setOwner((LivingEntity) entity);
				}

				areaeffectcloudentity.setParticleType(ParticleTypes.TOTEM_OF_UNDYING);
				areaeffectcloudentity.setRadius(1.0F);
				areaeffectcloudentity.setDuration(10);
				areaeffectcloudentity.setRadiusGrowth(
						(7.0F - areaeffectcloudentity.getRadius()) / (float) areaeffectcloudentity.getDuration());
				areaeffectcloudentity.addEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1, 1));
				if (!list.isEmpty()) {
					for (LivingEntity livingentity : list) {
						double d0 = this.squaredDistanceTo(livingentity);
						if (d0 < 16.0D) {
							areaeffectcloudentity.updatePosition(livingentity.getX(), livingentity.getY(),
									livingentity.getZ());
							break;
						}
					}
				}

				this.world.syncWorldEvent(2006, this.getBlockPos(), this.isSilent() ? -1 : 1);
				this.world.spawnEntity(areaeffectcloudentity);
				this.explode();
				this.remove();
			}
		}
		this.playSound(ModSoundEvents.ROCKET_HIT, 1.0F, 1.0F);
	}

	protected void explode() {
		this.world.createExplosion(this, this.getX(), this.getBodyY(0.0625D), this.getZ(), 12.0F,
				Explosion.DestructionType.NONE);
	}
}