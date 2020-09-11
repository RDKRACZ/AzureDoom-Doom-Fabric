package mod.azure.doom.entity.projectiles;

import java.util.Iterator;
import java.util.List;

import mod.azure.doom.util.ModSoundEvents;
import mod.azure.doom.util.ProjectilesEntityRegister;
import mod.azure.doom.util.packets.EntityPacket;
import mod.azure.doom.util.registry.DoomItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.HostileEntity;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.RaycastContext;
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

	@SuppressWarnings("rawtypes")
	@Override
	public void tick() {
		super.tick();
		boolean bl = this.isNoClip();
		Vec3d vec3d = this.getVelocity();
		if (this.prevPitch == 0.0F && this.prevYaw == 0.0F) {
			float f = MathHelper.sqrt(squaredHorizontalLength(vec3d));
			this.yaw = (float) (MathHelper.atan2(vec3d.x, vec3d.z) * 57.2957763671875D);
			this.pitch = (float) (MathHelper.atan2(vec3d.y, (double) f) * 57.2957763671875D);
			this.prevYaw = this.yaw;
			this.prevPitch = this.pitch;
		}

		BlockPos blockPos = this.getBlockPos();
		BlockState blockState = this.world.getBlockState(blockPos);
		Vec3d vec3d4;
		if (!blockState.isAir() && !bl) {
			VoxelShape voxelShape = blockState.getCollisionShape(this.world, blockPos);
			if (!voxelShape.isEmpty()) {
				vec3d4 = this.getPos();
				Iterator var7 = voxelShape.getBoundingBoxes().iterator();

				while (var7.hasNext()) {
					Box box = (Box) var7.next();
					if (box.offset(blockPos).contains(vec3d4)) {
						this.inGround = true;
						break;
					}
				}
			}
		}

		if (this.shake > 0) {
			--this.shake;
		}

		if (this.isTouchingWaterOrRain()) {
			this.extinguish();
		}

		if (this.inAir && !bl) {
			this.method_26352();

			++this.timeInAir;
		} else {
			this.timeInAir = 0;
			Vec3d vec3d3 = this.getPos();
			vec3d4 = vec3d3.add(vec3d);
			HitResult hitResult = this.world.raycast(new RaycastContext(vec3d3, vec3d4,
					RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, this));
			if (((HitResult) hitResult).getType() != HitResult.Type.MISS) {
				vec3d4 = ((HitResult) hitResult).getPos();
			}

			while (!this.removed) {
				EntityHitResult entityHitResult = this.getEntityCollision(vec3d3, vec3d4);
				if (entityHitResult != null) {
					hitResult = entityHitResult;
				}

				if (hitResult != null && ((HitResult) hitResult).getType() == HitResult.Type.ENTITY) {
					Entity entity = ((EntityHitResult) hitResult).getEntity();
					Entity entity2 = this.getOwner();
					if (entity instanceof PlayerEntity && entity2 instanceof PlayerEntity
							&& !((PlayerEntity) entity2).shouldDamagePlayer((PlayerEntity) entity)) {
						hitResult = null;
						entityHitResult = null;
					}
				}

				if (hitResult != null && !bl) {
					this.onCollision((HitResult) hitResult);
					this.velocityDirty = true;
				}

				if (entityHitResult == null || this.getPierceLevel() <= 0) {
					break;
				}

				hitResult = null;
			}

			vec3d = this.getVelocity();
			double d = vec3d.x;
			double e = vec3d.y;
			double g = vec3d.z;
			if (this.isCritical()) {
				for (int i = 0; i < 4; ++i) {
					this.world.addParticle(ParticleTypes.CRIT, this.getX() + d * (double) i / 4.0D,
							this.getY() + e * (double) i / 4.0D, this.getZ() + g * (double) i / 4.0D, -d, -e + 0.2D,
							-g);
				}
			}

			double h = this.getX() + d;
			double j = this.getY() + e;
			double k = this.getZ() + g;
			float l = MathHelper.sqrt(squaredHorizontalLength(vec3d));
			if (bl) {
				this.yaw = (float) (MathHelper.atan2(-d, -g) * 57.2957763671875D);
			} else {
				this.yaw = (float) (MathHelper.atan2(d, g) * 57.2957763671875D);
			}

			this.pitch = (float) (MathHelper.atan2(e, (double) l) * 57.2957763671875D);
			this.pitch = updateRotation(this.prevPitch, this.pitch);
			this.yaw = updateRotation(this.prevYaw, this.yaw);
			float m = 0.99F;
			if (this.isTouchingWater()) {
				for (int o = 0; o < 4; ++o) {
					this.world.addParticle(ParticleTypes.BUBBLE, h - d * 0.25D, j - e * 0.25D, k - g * 0.25D, d, e, g);
				}

				m = this.getDragInWater();
			}

			this.setVelocity(vec3d.multiply((double) m));
			if (!this.hasNoGravity() && !bl) {
				Vec3d vec3d5 = this.getVelocity();
				this.setVelocity(vec3d5.x, vec3d5.y - 0.05000000074505806D, vec3d5.z);
			}

			this.updatePosition(h, j, k);
			this.checkBlockCollision();
		}
	}

	private void method_26352() {
		this.inGround = false;
		Vec3d vec3d = this.getVelocity();
		this.setVelocity(vec3d.multiply((double) (this.random.nextFloat() * 0.2F),
				(double) (this.random.nextFloat() * 0.2F), (double) (this.random.nextFloat() * 0.2F)));
		this.ticksInAir = 0;
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
			List<LivingEntity> list = this.world.getEntitiesIncludingUngeneratedChunks(HostileEntity.class,
					this.getBoundingBox().expand(15.0D, 15.0D, 15.0D));
			AreaEffectCloudEntity areaeffectcloudentity = new AreaEffectCloudEntity(this.world, this.getX(),
					this.getY(), this.getZ());
			if (entity instanceof LivingEntity) {
				areaeffectcloudentity.setOwner((LivingEntity) entity);
			}

			areaeffectcloudentity.setParticleType(this.getParticleType());
			areaeffectcloudentity.setRadius(1.0F);
			areaeffectcloudentity.setDuration(10);
			areaeffectcloudentity.setRadiusGrowth(
					(7.0F - areaeffectcloudentity.getRadius()) / (float) areaeffectcloudentity.getDuration());
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
		this.playSound(ModSoundEvents.BFG_HIT, 1.0F, 1.0F);
	}

	@Override
	protected void onEntityHit(EntityHitResult entityHitResult) {
		super.onEntityHit(entityHitResult);
		Entity entity = this.getOwner();
		if (entityHitResult.getType() != HitResult.Type.ENTITY
				|| !((EntityHitResult) entityHitResult).getEntity().isPartOf(entity)) {
			if (!this.world.isClient) {
				List<LivingEntity> list = this.world.getEntitiesIncludingUngeneratedChunks(HostileEntity.class,
						this.getBoundingBox().expand(15.0D, 15.0D, 15.0D));
				AreaEffectCloudEntity areaeffectcloudentity = new AreaEffectCloudEntity(this.world, this.getX(),
						this.getY(), this.getZ());
				if (entity instanceof LivingEntity) {
					areaeffectcloudentity.setOwner((LivingEntity) entity);
				}

				areaeffectcloudentity.setParticleType(this.getParticleType());
				areaeffectcloudentity.setRadius(1.0F);
				areaeffectcloudentity.setDuration(10);
				areaeffectcloudentity.setRadiusGrowth(
						(7.0F - areaeffectcloudentity.getRadius()) / (float) areaeffectcloudentity.getDuration());
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
		this.playSound(ModSoundEvents.BFG_HIT, 1.0F, 1.0F);
	}

	protected void explode() {
		this.world.createExplosion(this, this.getX(), this.getBodyY(0.0625D), this.getZ(), 12.0F, false,
				Explosion.DestructionType.NONE);
	}

	@Override
	@Environment(EnvType.CLIENT)
	public boolean shouldRender(double distance) {
		return true;
	}
}