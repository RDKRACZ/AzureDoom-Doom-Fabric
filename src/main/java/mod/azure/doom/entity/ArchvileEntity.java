package mod.azure.doom.entity;

import java.util.List;
import java.util.Random;

import mod.azure.doom.entity.projectiles.entity.ArchvileFiring;
import mod.azure.doom.util.ModSoundEvents;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.MerchantEntity;
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

public class ArchvileEntity extends DemonEntity {
	private static final TrackedData<Boolean> SHOOTING = DataTracker.registerData(ArchvileEntity.class,
			TrackedDataHandlerRegistry.BOOLEAN);

	public ArchvileEntity(EntityType<ArchvileEntity> entityType, World worldIn) {
		super(entityType, worldIn);
	}

	public static boolean spawning(EntityType<ArchvileEntity> p_223337_0_, World p_223337_1_, SpawnReason reason,
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
	protected void updatePostDeath() {
		++this.deathTime;
		if (!world.isClient) {
			float q = 200.0F;
			int k = MathHelper.floor(this.getX() - (double) q - 1.0D);
			int l = MathHelper.floor(this.getX() + (double) q + 1.0D);
			int t = MathHelper.floor(this.getY() - (double) q - 1.0D);
			int u = MathHelper.floor(this.getY() + (double) q + 1.0D);
			int v = MathHelper.floor(this.getZ() - (double) q - 1.0D);
			int w = MathHelper.floor(this.getZ() + (double) q + 1.0D);
			List<Entity> list = this.world.getOtherEntities(this,
					new Box((double) k, (double) t, (double) v, (double) l, (double) u, (double) w));
			for (int k2 = 0; k2 < list.size(); ++k2) {
				Entity entity = list.get(k2);
				if (entity.isAlive()) {
					entity.setGlowing(false);
				}
			}
		}
		if (this.deathTime == 50) {
			this.remove();
		}
	}

	public static DefaultAttributeContainer.Builder createMobAttributes() {
		return LivingEntity.createLivingAttributes().add(EntityAttributes.GENERIC_FOLLOW_RANGE, 25.0D)
				.add(EntityAttributes.GENERIC_MAX_HEALTH, 100.0D).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 7.0D)
				.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.15D)
				.add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 1.0D);
	}

	protected boolean shouldDrown() {
		return false;
	}

	protected boolean shouldBurnInDay() {
		return false;
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.add(8, new LookAroundGoal(this));
		this.goalSelector.add(5, new WanderAroundFarGoal(this, 0.8D));
		this.goalSelector.add(7, new ArchvileEntity.AttackGoal(this));
		this.targetSelector.add(2, new RevengeGoal(this).setGroupRevenge());
		this.targetSelector.add(2, new FollowTargetGoal<>(this, PlayerEntity.class, true));
		this.targetSelector.add(2, new FollowTargetGoal<>(this, MerchantEntity.class, true));
	}

	static class AttackGoal extends Goal {
		private final ArchvileEntity ghast;
		public int cooldown;

		public AttackGoal(ArchvileEntity ghast) {
			this.ghast = ghast;
		}

		public boolean canStart() {
			return this.ghast.getTarget() != null;
		}

		public void start() {
			this.cooldown = 0;
		}

		public void resetTask() {
			this.ghast.setShooting(false);
		}

		public void tick() {
			LivingEntity livingEntity = this.ghast.getTarget();
			if (this.ghast.canSee(livingEntity)) {
				this.ghast.getLookControl().lookAt(livingEntity, 90.0F, 30.0F);
				++this.cooldown;
				if (this.cooldown == 40) {
					if (!this.ghast.world.isClient) {
						float q = 24.0F;
						int k = MathHelper.floor(this.ghast.getX() - (double) q - 1.0D);
						int l = MathHelper.floor(this.ghast.getX() + (double) q + 1.0D);
						int t = MathHelper.floor(this.ghast.getY() - (double) q - 1.0D);
						int u = MathHelper.floor(this.ghast.getY() + (double) q + 1.0D);
						int v = MathHelper.floor(this.ghast.getZ() - (double) q - 1.0D);
						int w = MathHelper.floor(this.ghast.getZ() + (double) q + 1.0D);
						List<Entity> list = this.ghast.world.getOtherEntities(this.ghast,
								new Box((double) k, (double) t, (double) v, (double) l, (double) u, (double) w));
						Vec3d vec3d1 = new Vec3d(this.ghast.getX(), this.ghast.getY(), this.ghast.getZ());

						for (int x = 0; x < list.size(); ++x) {
							Entity entity = (Entity) list.get(x);
							if ((entity instanceof DemonEntity)) {
								double y = (double) (MathHelper.sqrt(entity.squaredDistanceTo(vec3d1)) / q);
								if (y <= 1.0D) {
									((DemonEntity) entity)
											.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 1000, 1));
									entity.setGlowing(true);
								}
							}
						}
						double d = Math.min(livingEntity.getY(), ghast.getY());
						double e = Math.max(livingEntity.getY(), ghast.getY()) + 1.0D;
						float f = (float) MathHelper.atan2(livingEntity.getZ() - ghast.getZ(),
								livingEntity.getX() - ghast.getX());
						int j;
						if (ghast.squaredDistanceTo(livingEntity) < 9.0D) {
							float h;
							for (j = 0; j < 5; ++j) {
								h = f + (float) j * 3.1415927F * 0.4F;
								ghast.conjureFangs(ghast.getX() + (double) MathHelper.cos(h) * 1.5D,
										ghast.getZ() + (double) MathHelper.sin(h) * 1.5D, d, e, h, 0);
							}

							for (j = 0; j < 8; ++j) {
								h = f + (float) j * 3.1415927F * 2.0F / 8.0F + 1.2566371F;
								ghast.conjureFangs(ghast.getX() + (double) MathHelper.cos(h) * 2.5D,
										ghast.getZ() + (double) MathHelper.sin(h) * 2.5D, d, e, h, 3);
							}
						} else {
							for (j = 0; j < 16; ++j) {
								double l1 = 1.25D * (double) (j + 1);
								int m = 1 * j;
								ghast.conjureFangs(ghast.getX() + (double) MathHelper.cos(f) * l1,
										ghast.getZ() + (double) MathHelper.sin(f) * l1, d, e, f, m);
							}
						}
					}
					this.ghast.getLookControl().lookAt(livingEntity, 30.0F, 30.0F);
					if (!(this.ghast.world.isClient)) {
						this.ghast.playSound(ModSoundEvents.ARCHVILE_SCREAM, 1.0F,
								1.2F / (this.ghast.random.nextFloat() * 0.2F + 0.9F));
					}
					this.cooldown = -80;
				}
			} else if (this.cooldown > 0) {
				--this.cooldown;
			}

			this.ghast.setShooting(this.cooldown > 10);
		}
	}

	private void conjureFangs(double x, double z, double maxY, double y, float yaw, int warmup) {
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

	protected void mobTick() {
		super.mobTick();
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return ModSoundEvents.ARCHVILE_AMBIENT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return ModSoundEvents.ARCHVILE_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return ModSoundEvents.ARCHVILE_DEATH;
	}
}