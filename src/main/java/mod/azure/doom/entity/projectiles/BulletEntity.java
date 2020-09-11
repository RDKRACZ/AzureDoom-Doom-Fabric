package mod.azure.doom.entity.projectiles;

import java.util.Iterator;

import mod.azure.doom.util.ProjectilesEntityRegister;
import mod.azure.doom.util.packets.EntityPacket;
import mod.azure.doom.util.registry.DoomItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Packet;
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

public class BulletEntity extends PersistentProjectileEntity {

	protected int timeInAir;
	protected boolean inAir;
	private int ticksInAir;

	public BulletEntity(EntityType<? extends BulletEntity> entityType, World world) {
		super(entityType, world);
		this.pickupType = PersistentProjectileEntity.PickupPermission.DISALLOWED;
	}

	public BulletEntity(World world, LivingEntity owner) {
		super(ProjectilesEntityRegister.BULLETS, owner, world);
	}

	protected BulletEntity(EntityType<? extends BulletEntity> type, double x, double y, double z, World world) {
		this(type, world);
	}

	protected BulletEntity(EntityType<? extends BulletEntity> type, LivingEntity owner, World world) {
		this(type, owner.getX(), owner.getEyeY() - 0.10000000149011612D, owner.getZ(), world);
		this.setOwner(owner);
		if (owner instanceof PlayerEntity) {
			this.pickupType = PersistentProjectileEntity.PickupPermission.ALLOWED;
		}

	}

	@Override
	public Packet<?> createSpawnPacket() {
		return EntityPacket.createPacket(this);
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
		if (stack.getItem() == DoomItems.ARGENT_BOLT) {
		}
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
	protected void onBlockHit(BlockHitResult blockHitResult) {
		super.onBlockHit(blockHitResult);
		if (!this.world.isClient) {
			this.remove();
		}
	}

	@Override
	protected void onEntityHit(EntityHitResult entityHitResult) {
		super.onEntityHit(entityHitResult);
		if (!this.world.isClient) {
			this.remove();
		}
	}

	@Override
	public ItemStack asItemStack() {
		return new ItemStack(DoomItems.ARGENT_BOLT);
	}

	@Override
	@Environment(EnvType.CLIENT)
	public boolean shouldRender(double distance) {
		return true;
	}

}