package mod.azure.doom.entity;

import java.util.Random;

import mod.azure.doom.entity.ai.goal.DemonAttackGoal;
import mod.azure.doom.entity.projectiles.entity.ArchvileFiring;
import mod.azure.doom.entity.projectiles.entity.BarenBlastEntity;
import mod.azure.doom.util.ModSoundEvents;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class MancubusEntity extends DemonEntity implements IAnimatable {
	private static final TrackedData<Boolean> SHOOTING = DataTracker.registerData(MancubusEntity.class,
			TrackedDataHandlerRegistry.BOOLEAN);

	public MancubusEntity(EntityType<MancubusEntity> entityType, World worldIn) {
		super(entityType, worldIn);
	}

	private AnimationFactory factory = new AnimationFactory(this);

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		if (!(lastLimbDistance > -0.15F && lastLimbDistance < 0.15F) && !this.dataTracker.get(SHOOTING)) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("walking", true));
			return PlayState.CONTINUE;
		}
		if ((this.dead || this.getHealth() < 0.01 || this.isDead())) {
			if (world.isClient) {
				event.getController().setAnimation(new AnimationBuilder().addAnimation("death", false));
				return PlayState.CONTINUE;
			}
		}
		if (this.dataTracker.get(SHOOTING)) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("attacking", true));
			return PlayState.CONTINUE;
		}
		event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));
		return PlayState.CONTINUE;
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<MancubusEntity>(this, "controller", 0, this::predicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}

	@Override
	protected void updatePostDeath() {
		++this.deathTime;
		if (this.deathTime == 80) {
			this.remove();
			for (int i = 0; i < 20; ++i) {
				if (world.isClient) {
				}
			}
		}
	}

	public static boolean spawning(EntityType<MancubusEntity> p_223337_0_, World p_223337_1_, SpawnReason reason,
			BlockPos p_223337_3_, Random p_223337_4_) {
		return p_223337_1_.getDifficulty() != Difficulty.PEACEFUL;
	}

	@Environment(EnvType.CLIENT)
	public boolean isShooting() {
		return (Boolean) this.dataTracker.get(SHOOTING);
	}

	public void setShooting(boolean shooting) {
		this.dataTracker.set(SHOOTING, shooting);
	}

	protected void initDataTracker() {
		super.initDataTracker();
		this.dataTracker.startTracking(SHOOTING, false);
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.add(8, new LookAroundGoal(this));
		this.goalSelector.add(5, new WanderAroundFarGoal(this, 0.8D));
		this.initCustomGoals();
	}

	protected void initCustomGoals() {
		this.goalSelector.add(7, new MancubusEntity.ShootFireballGoal(this));
		this.goalSelector.add(7, new DemonAttackGoal(this, 1.0D, false));
		this.targetSelector.add(2, new FollowTargetGoal<>(this, PlayerEntity.class, true));
		this.targetSelector.add(3, new FollowTargetGoal<>(this, HostileEntity.class, true));
		this.targetSelector.add(3, new FollowTargetGoal<>(this, MobEntity.class, true));
	}

	static class ShootFireballGoal extends Goal {
		private final MancubusEntity parentEntity;
		public int cooldown;

		public ShootFireballGoal(MancubusEntity parentEntity) {
			this.parentEntity = parentEntity;
		}

		public boolean canStart() {
			return this.parentEntity.getTarget() != null;
		}

		public void start() {
			this.cooldown = 0;
		}

		public void resetTask() {
			this.parentEntity.setShooting(false);
		}

		public void tick() {
			LivingEntity livingEntity = this.parentEntity.getTarget();
			if (livingEntity.squaredDistanceTo(this.parentEntity) < 4096.0D && this.parentEntity.canSee(livingEntity)) {
				this.parentEntity.getLookControl().lookAt(livingEntity, 90.0F, 30.0F);
				World world = this.parentEntity.world;
				Vec3d vec3d = this.parentEntity.getRotationVec(1.0F);
				++this.cooldown;
				double f = livingEntity.getX() - (this.parentEntity.getX() + vec3d.x * 2.0D);
				double g = livingEntity.getBodyY(0.5D) - (0.5D + this.parentEntity.getBodyY(0.5D));
				double h = livingEntity.getZ() - (this.parentEntity.getZ() + vec3d.z * 4.0D);
				BarenBlastEntity fireballEntity = new BarenBlastEntity(world, this.parentEntity, f, g, h);
				double d = Math.min(livingEntity.getY(), parentEntity.getY());
				double e1 = Math.max(livingEntity.getY(), parentEntity.getY()) + 1.0D;
				float f2 = (float) MathHelper.atan2(livingEntity.getZ() - parentEntity.getZ(),
						livingEntity.getX() - parentEntity.getX());
				int j;
				final Vec3d facing = Vec3d.fromPolar(parentEntity.getRotationClient()).normalize();
				final Box aabb = new Box(parentEntity.getBlockPos().up()).expand(1D, 1D, 1D)
						.offset(facing.multiply(1D));
				if (this.cooldown == 15) {
					if (parentEntity.distanceTo(livingEntity) < 3.0D) {
						parentEntity.getEntityWorld().getOtherEntities(parentEntity, aabb)
								.forEach(e -> e.setFireTicks(5));
					} else if (parentEntity.distanceTo(livingEntity) < 13.0D) {
						for (j = 0; j < 16; ++j) {
							double l1 = 1.25D * (double) (j + 1);
							int m = 1 * j;
							parentEntity.spawnFlames(parentEntity.getX() + (double) MathHelper.cos(f2) * l1,
									parentEntity.getZ() + (double) MathHelper.sin(f2) * l1, d, e1, f2, m);
						}
					} else {
						fireballEntity.updatePosition(this.parentEntity.getX() + vec3d.x * 1.0D,
								this.parentEntity.getBodyY(0.5D), fireballEntity.getZ() + 1.0D);
						world.spawnEntity(fireballEntity);
					}
				}
				if (this.cooldown == 20) {
					if (parentEntity.distanceTo(livingEntity) < 3.0D) {
						parentEntity.getEntityWorld().getOtherEntities(parentEntity, aabb)
								.forEach(e -> e.setFireTicks(5));
					} else if (parentEntity.distanceTo(livingEntity) < 13.0D) {
						for (j = 0; j < 16; ++j) {
							double l1 = 1.25D * (double) (j + 1);
							int m = 1 * j;
							parentEntity.spawnFlames(parentEntity.getX() + (double) MathHelper.cos(f2) * l1,
									parentEntity.getZ() + (double) MathHelper.sin(f2) * l1, d, e1, f2, m);
						}
					} else {
						fireballEntity.updatePosition(this.parentEntity.getX() + vec3d.x * 1.0D,
								this.parentEntity.getBodyY(0.5D), fireballEntity.getZ() + 1.0D);
						world.spawnEntity(fireballEntity);
					}
					this.cooldown = -100;
				}
			} else if (this.cooldown > 0) {
				--this.cooldown;
			}

			this.parentEntity.setShooting(this.cooldown > 10);
		}
	}

	public void spawnFlames(double x, double z, double maxY, double y, float yaw, int warmup) {
		BlockPos blockPos = new BlockPos(x, y, z);
		boolean bl = false;
		double d = 0.0D;
		do {
			BlockPos blockPos2 = blockPos.down();
			BlockState blockState = this.world.getBlockState(blockPos2);
			if (blockState.isSideSolidFullSquare(this.world, blockPos2, Direction.UP)) {
				if (!this.world.isAir(blockPos)) {
					BlockState blockState2 = this.world.getBlockState(blockPos);
					VoxelShape voxelShape = blockState2.getCollisionShape(this.world, blockPos);
					if (!voxelShape.isEmpty()) {
						d = voxelShape.getMax(Direction.Axis.Y);
					}
				}
				bl = true;
				break;
			}
			blockPos = blockPos.down();
		} while (blockPos.getY() >= MathHelper.floor(maxY) - 1);

		if (bl) {
			ArchvileFiring fang = new ArchvileFiring(this.world, x, (double) blockPos.getY() + d, z, yaw, warmup, this);
			fang.setFireTicks(age);
			fang.isInvisible();
			this.world.spawnEntity(fang);
		}

	}

	public static DefaultAttributeContainer.Builder createMobAttributes() {
		return LivingEntity.createLivingAttributes().add(EntityAttributes.GENERIC_FOLLOW_RANGE, 50.0D)
				.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.15D).add(EntityAttributes.GENERIC_MAX_HEALTH, 40.0D)
				.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 8.0D).add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 1.0D);
	}

	protected boolean shouldDrown() {
		return false;
	}

	protected boolean shouldBurnInDay() {
		return false;
	}

	@Override
	protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
		return 2.80F;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return ModSoundEvents.MANCUBUS_AMBIENT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return ModSoundEvents.MANCUBUS_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return ModSoundEvents.MANCUBUS_DEATH;
	}

	protected SoundEvent getStepSound() {
		return ModSoundEvents.MANCUBUS_STEP;
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(this.getStepSound(), 0.15F, 1.0F);
	}
}