package mod.azure.doom.entity;

import java.util.EnumSet;
import java.util.Random;

import mod.azure.doom.entity.projectiles.PainShootEntity;
import mod.azure.doom.util.ModSoundEvents;
import mod.azure.doom.util.packets.EntityPacket;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.FlyingEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.Packet;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class PainEntity extends FlyingEntity implements Monster {
	private static final TrackedData<Boolean> SHOOTING;

	static {
		SHOOTING = DataTracker.registerData(PainEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
	}

	public PainEntity(EntityType<? extends PainEntity> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	public Packet<?> createSpawnPacket() {
		return EntityPacket.createPacket(this);
	}

	public static DefaultAttributeContainer.Builder createMobAttributes() {
		return LivingEntity.createLivingAttributes().add(EntityAttributes.GENERIC_FOLLOW_RANGE, 50.0D).add(EntityAttributes.GENERIC_MOVEMENT_SPEED,0.15D)
				.add(EntityAttributes.GENERIC_MAX_HEALTH, 19.0D);
	}

	@Override
	protected void initDataTracker() {
		super.initDataTracker();
		this.dataTracker.startTracking(SHOOTING, false);
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(5, new PainEntity.FlyRandomlyGoal(this));
		this.goalSelector.add(7, new PainEntity.LookAtTargetGoal(this));
		this.goalSelector.add(7, new PainEntity.ShootFireballGoal(this));
		this.targetSelector.add(2, new FollowTargetGoal<>(this, PlayerEntity.class, true));
	}

	public static boolean canSpawn(EntityType<PainEntity> type, WorldAccess world, SpawnReason spawnReason,
			BlockPos pos, Random random) {
		return world.getDifficulty() != Difficulty.PEACEFUL && random.nextInt(20) == 0
				&& canMobSpawn(type, world, spawnReason, pos, random);
	}

	public int getFireballStrength() {
		return 1;
	}

	@Override
	protected boolean isDisallowedInPeaceful() {
		return true;
	}

	@Environment(EnvType.CLIENT)
	public boolean isShooting() {
		return (Boolean) this.dataTracker.get(SHOOTING);
	}

	public void setShooting(boolean shooting) {
		this.dataTracker.set(SHOOTING, shooting);
	}

	static class ShootFireballGoal extends Goal {
		private final PainEntity ghast;
		public int cooldown;

		public ShootFireballGoal(PainEntity ghast) {
			this.ghast = ghast;
		}

		public boolean canStart() {
			return this.ghast.getTarget() != null;
		}

		public void start() {
			this.cooldown = 0;
		}

		public void stop() {
			this.ghast.setShooting(false);
		}

		public void tick() {
			LivingEntity livingEntity = this.ghast.getTarget();
			if (livingEntity.squaredDistanceTo(this.ghast) < 4096.0D && this.ghast.canSee(livingEntity)) {
				World world = this.ghast.world;
				++this.cooldown;
				if (this.cooldown == 10 && !this.ghast.isSilent()) {
					world.syncWorldEvent((PlayerEntity) null, 1015, this.ghast.getBlockPos(), 0);
				}

				if (this.cooldown == 20) {
					Vec3d vec3d = this.ghast.getRotationVec(1.0F);
					double f = livingEntity.getX() - (this.ghast.getX() + vec3d.x * 4.0D);
					double g = livingEntity.getBodyY(0.5D) - (0.5D + this.ghast.getBodyY(0.5D));
					double h = livingEntity.getZ() - (this.ghast.getZ() + vec3d.z * 4.0D);
					if (!this.ghast.isSilent()) {
						world.syncWorldEvent((PlayerEntity) null, 1016, this.ghast.getBlockPos(), 0);
					}

					PainShootEntity fireballEntity = new PainShootEntity(world, this.ghast, f, g, h);
					fireballEntity.explosionPower = this.ghast.getFireballStrength();
					fireballEntity.updatePosition(this.ghast.getX() + vec3d.x * 4.0D, this.ghast.getBodyY(0.5D) + 0.5D,
							fireballEntity.getZ() + vec3d.z * 4.0D);
					world.spawnEntity(fireballEntity);
					this.cooldown = -40;
				}
			} else if (this.cooldown > 0) {
				--this.cooldown;
			}

			this.ghast.setShooting(this.cooldown > 10);
		}
	}

	static class LookAtTargetGoal extends Goal {
		private final PainEntity ghast;

		public LookAtTargetGoal(PainEntity ghast) {
			this.ghast = ghast;
			this.setControls(EnumSet.of(Goal.Control.LOOK));
		}

		public boolean canStart() {
			return true;
		}

		public void tick() {
			if (this.ghast.getTarget() == null) {
				Vec3d vec3d = this.ghast.getVelocity();
				this.ghast.yaw = -((float) MathHelper.atan2(vec3d.x, vec3d.z)) * 57.295776F;
				this.ghast.bodyYaw = this.ghast.yaw;
			} else {
				LivingEntity livingEntity = this.ghast.getTarget();
				if (livingEntity.squaredDistanceTo(this.ghast) < 4096.0D) {
					double e = livingEntity.getX() - this.ghast.getX();
					double f = livingEntity.getZ() - this.ghast.getZ();
					this.ghast.yaw = -((float) MathHelper.atan2(e, f)) * 57.295776F;
					this.ghast.bodyYaw = this.ghast.yaw;
				}
			}

		}
	}

	static class FlyRandomlyGoal extends Goal {
		private final PainEntity ghast;

		public FlyRandomlyGoal(PainEntity ghast) {
			this.ghast = ghast;
			this.setControls(EnumSet.of(Goal.Control.MOVE));
		}

		public boolean canStart() {
			MoveControl moveControl = this.ghast.getMoveControl();
			if (!moveControl.isMoving()) {
				return true;
			} else {
				double d = moveControl.getTargetX() - this.ghast.getX();
				double e = moveControl.getTargetY() - this.ghast.getY();
				double f = moveControl.getTargetZ() - this.ghast.getZ();
				double g = d * d + e * e + f * f;
				return g < 1.0D || g > 3600.0D;
			}
		}

		public boolean shouldContinue() {
			return false;
		}

		public void start() {
			Random random = this.ghast.getRandom();
			double d = this.ghast.getX() + (double) ((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
			double e = this.ghast.getY() + (double) ((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
			double f = this.ghast.getZ() + (double) ((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
			this.ghast.getMoveControl().moveTo(d, e, f, 1.0D);
		}
	}

	@Override
	protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
		return 1.0F;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return ModSoundEvents.PAIN_AMBIENT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return ModSoundEvents.PAIN_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return ModSoundEvents.PAIN_DEATH;
	}

	@Override
	public EntityGroup getGroup() {
		return EntityGroup.UNDEAD;
	}

	@Override
	protected float getSoundVolume() {
		return 1.0F;
	}

	@Override
	@Environment(EnvType.CLIENT)
	public boolean shouldRender(double distance) {
		return true;
	}

}