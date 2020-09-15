package mod.azure.doom.entity.projectiles;

import java.util.EnumSet;
import java.util.Random;

import mod.azure.doom.entity.DemonEntity;
import mod.azure.doom.entity.PainEntity;
import mod.azure.doom.util.ModSoundEvents;
import mod.azure.doom.util.packets.EntityPacket;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.Packet;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.explosion.Explosion;

public class LostSoulEntity extends DemonEntity implements Monster {

	public int explosionPower = 1;
	public int flameTimer;

	public LostSoulEntity(EntityType<? extends LostSoulEntity> type, World worldIn) {
		super(type, worldIn);
		this.moveControl = new LostSoulEntity.GhastMoveControl(this);
	}

	public boolean handleFallDamage(float fallDistance, float damageMultiplier) {
		return false;
	}

	protected void fall(double heightDifference, boolean onGround, BlockState landedState, BlockPos landedPosition) {
	}

	public void travel(Vec3d movementInput) {
		if (this.isTouchingWater()) {
			this.updateVelocity(0.02F, movementInput);
			this.move(MovementType.SELF, this.getVelocity());
			this.setVelocity(this.getVelocity().multiply(0.800000011920929D));
		} else if (this.isInLava()) {
			this.updateVelocity(0.02F, movementInput);
			this.move(MovementType.SELF, this.getVelocity());
			this.setVelocity(this.getVelocity().multiply(0.5D));
		} else {
			float f = 0.91F;
			if (this.onGround) {
				f = this.world.getBlockState(new BlockPos(this.getX(), this.getY() - 1.0D, this.getZ())).getBlock()
						.getSlipperiness() * 0.91F;
			}

			float g = 0.16277137F / (f * f * f);
			f = 0.91F;
			if (this.onGround) {
				f = this.world.getBlockState(new BlockPos(this.getX(), this.getY() - 1.0D, this.getZ())).getBlock()
						.getSlipperiness() * 0.91F;
			}

			this.updateVelocity(this.onGround ? 0.1F * g : 0.02F, movementInput);
			this.move(MovementType.SELF, this.getVelocity());
			this.setVelocity(this.getVelocity().multiply((double) f));
		}

		this.method_29242(this, false);
	}

	public boolean isClimbing() {
		return false;
	}

	@Override
	public Packet<?> createSpawnPacket() {
		return EntityPacket.createPacket(this);
	}

	public static DefaultAttributeContainer.Builder createMobAttributes() {
		return LivingEntity.createLivingAttributes().add(EntityAttributes.GENERIC_FOLLOW_RANGE, 50.0D)
				.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.15D).add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0D)
				.add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 1.0D);
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(5, new LostSoulEntity.FlyRandomlyGoal(this));
		this.goalSelector.add(7, new LostSoulEntity.LookAtTargetGoal(this));
		this.goalSelector.add(5, new WanderAroundFarGoal(this, 0.8D));
		this.targetSelector.add(2, new FollowTargetGoal<>(this, PlayerEntity.class, true));
	}

	public static boolean canSpawn(EntityType<PainEntity> type, WorldAccess world, SpawnReason spawnReason,
			BlockPos pos, Random random) {
		return world.getDifficulty() != Difficulty.PEACEFUL && random.nextInt(20) == 0
				&& canMobSpawn(type, world, spawnReason, pos, random);
	}
	
	@Override
	public void tick() {
		super.tick();
		flameTimer = (flameTimer + 1) % 8;
	}

	static class LookAtTargetGoal extends Goal {
		private final LostSoulEntity ghast;

		public LookAtTargetGoal(LostSoulEntity ghast) {
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

	static class GhastMoveControl extends MoveControl {
		private final LostSoulEntity ghast;
		private int collisionCheckCooldown;

		public GhastMoveControl(LostSoulEntity ghast) {
			super(ghast);
			this.ghast = ghast;
		}

		public void tick() {
			if (this.state == MoveControl.State.MOVE_TO) {
				if (this.collisionCheckCooldown-- <= 0) {
					this.collisionCheckCooldown += this.ghast.getRandom().nextInt(5) + 2;
					Vec3d vec3d = new Vec3d(this.targetX - this.ghast.getX(), this.targetY - this.ghast.getY(),
							this.targetZ - this.ghast.getZ());
					double d = vec3d.length();
					vec3d = vec3d.normalize();
					if (this.willCollide(vec3d, MathHelper.ceil(d))) {
						this.ghast.setVelocity(this.ghast.getVelocity().add(vec3d.multiply(0.1D)));
					} else {
						this.state = MoveControl.State.WAIT;
					}
				}

			}
		}

		private boolean willCollide(Vec3d direction, int steps) {
			Box box = this.ghast.getBoundingBox();

			for (int i = 1; i < steps; ++i) {
				box = box.offset(direction);
				if (!this.ghast.world.isSpaceEmpty(this.ghast, box)) {
					return false;
				}
			}

			return true;
		}
	}

	static class FlyRandomlyGoal extends Goal {
		private final LostSoulEntity ghast;

		public FlyRandomlyGoal(LostSoulEntity ghast) {
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

	protected void explode() {
		this.world.createExplosion(this, this.getX(), this.getBodyY(0.0625D), this.getZ(), 1.0F,
				Explosion.DestructionType.NONE);
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

	public int getFlameTimer() {
		return flameTimer;
	}

}