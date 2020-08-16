package mod.azure.doom.entity;

import java.util.EnumSet;
import java.util.Random;

import mod.azure.doom.util.ModSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.goal.AttackGoal;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.goal.UniversalAngerGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

public class ArchvileEntity extends DemonEntity {

	public ArchvileEntity(EntityType<ArchvileEntity> entityType, World worldIn) {
		super(entityType, worldIn);
	}

	public static boolean spawning(EntityType<ArchvileEntity> p_223337_0_, World p_223337_1_, SpawnReason reason,
			BlockPos p_223337_3_, Random p_223337_4_) {
		return p_223337_1_.getDifficulty() != Difficulty.PEACEFUL;
	}

	public static DefaultAttributeContainer.Builder createMobAttributes() {
		return LivingEntity.createLivingAttributes().add(EntityAttributes.GENERIC_FOLLOW_RANGE, 25.0D)
				.add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0D).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 7.0D)
				.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.15D);
	}

	protected boolean shouldDrown() {
		return false;
	}

	protected boolean shouldBurnInDay() {
		return false;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected void initGoals() {
		this.goalSelector.add(1, new ArchvileEntity.ChasePlayerGoal(this));
		this.goalSelector.add(2, new AttackGoal(this));
		this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.add(8, new LookAroundGoal(this));
		this.targetSelector.add(2, new ArchvileEntity.TeleportTowardsPlayerGoal(this));
		this.targetSelector.add(2, new RevengeGoal(this));
		this.targetSelector.add(5, new UniversalAngerGoal(this, false));
	}

	protected boolean teleportRandomly() {
		if (!this.world.isClient() && this.isAlive()) {
			double d = this.getX() + (this.random.nextDouble() - 0.5D) * 64.0D;
			double e = this.getY() + (double) (this.random.nextInt(64) - 32);
			double f = this.getZ() + (this.random.nextDouble() - 0.5D) * 64.0D;
			return this.teleportTo(d, e, f);
		} else {
			return false;
		}
	}

	private boolean teleportTo(Entity entity) {
		Vec3d vec3d = new Vec3d(this.getX() - entity.getX(), this.getBodyY(0.5D) - entity.getEyeY(),
				this.getZ() - entity.getZ());
		vec3d = vec3d.normalize();
		double e = this.getX() + (this.random.nextDouble() - 0.5D) * 8.0D - vec3d.x * 16.0D;
		double f = this.getY() + (double) (this.random.nextInt(16) - 8) - vec3d.y * 16.0D;
		double g = this.getZ() + (this.random.nextDouble() - 0.5D) * 8.0D - vec3d.z * 16.0D;
		return this.teleportTo(e, f, g);
	}

	private boolean teleportTo(double x, double y, double z) {
		BlockPos.Mutable mutable = new BlockPos.Mutable(x, y, z);

		while (mutable.getY() > 0 && !this.world.getBlockState(mutable).getMaterial().blocksMovement()) {
			mutable.move(Direction.DOWN);
		}

		BlockState blockState = this.world.getBlockState(mutable);
		boolean bl = blockState.getMaterial().blocksMovement();
		boolean bl2 = blockState.getFluidState().isIn(FluidTags.WATER);
		if (bl && !bl2) {
			boolean bl3 = this.teleport(x, y, z, true);
			if (bl3 && !this.isSilent()) {
				this.world.playSound((PlayerEntity) null, this.prevX, this.prevY, this.prevZ,
						SoundEvents.ENTITY_ENDERMAN_TELEPORT, this.getSoundCategory(), 1.0F, 1.0F);
				this.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.0F);
			}

			return bl3;
		} else {
			return false;
		}
	}

	protected void mobTick() {
		if (this.world.isDay()) {
			float f = this.getBrightnessAtEyes();
			if (f > 0.5F && this.world.isSkyVisible(this.getBlockPos())
					&& this.random.nextFloat() * 30.0F < (f - 0.4F) * 2.0F) {
				this.setTarget((LivingEntity) null);
				this.teleportRandomly();
			}
		}

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

	private boolean isPlayerStaring(PlayerEntity player) {
		ItemStack itemStack = (ItemStack) player.inventory.armor.get(3);
		if (itemStack.getItem() == Blocks.CARVED_PUMPKIN.asItem()) {
			return false;
		} else {
			Vec3d vec3d = player.getRotationVec(1.0F).normalize();
			Vec3d vec3d2 = new Vec3d(this.getX() - player.getX(), this.getEyeY() - player.getEyeY(),
					this.getZ() - player.getZ());
			double d = vec3d2.length();
			vec3d2 = vec3d2.normalize();
			double e = vec3d.dotProduct(vec3d2);
			return e > 1.0D - 0.025D / d ? player.canSee(this) : false;
		}
	}

	static class ChasePlayerGoal extends Goal {
		private final ArchvileEntity enderman;
		private LivingEntity target;

		public ChasePlayerGoal(ArchvileEntity enderman) {
			this.enderman = enderman;
			this.setControls(EnumSet.of(Goal.Control.JUMP, Goal.Control.MOVE));
		}

		public boolean canStart() {
			this.target = this.enderman.getTarget();
			if (!(this.target instanceof PlayerEntity)) {
				return false;
			} else {
				double d = this.target.squaredDistanceTo(this.enderman);
				return d > 256.0D ? false : this.enderman.isPlayerStaring((PlayerEntity) this.target);
			}
		}

		public void start() {
			this.enderman.getNavigation().stop();
		}

		public void tick() {
			this.enderman.getLookControl().lookAt(this.target.getX(), this.target.getEyeY(), this.target.getZ());
		}
	}

	static class TeleportTowardsPlayerGoal extends FollowTargetGoal<PlayerEntity> {
		private final ArchvileEntity enderman;
		private PlayerEntity targetPlayer;
		private int lookAtPlayerWarmup;
		private int ticksSinceUnseenTeleport;
		private final TargetPredicate staringPlayerPredicate;
		private final TargetPredicate validTargetPredicate = (new TargetPredicate()).includeHidden();

		public TeleportTowardsPlayerGoal(ArchvileEntity enderman) {
			super(enderman, PlayerEntity.class, false);
			this.enderman = enderman;
			this.staringPlayerPredicate = (new TargetPredicate()).setBaseMaxDistance(this.getFollowRange())
					.setPredicate((playerEntity) -> {
						return enderman.isPlayerStaring((PlayerEntity) playerEntity);
					});
		}

		public boolean canStart() {
			this.targetPlayer = this.enderman.world.getClosestPlayer(this.staringPlayerPredicate, this.enderman);
			return this.targetPlayer != null;
		}

		public void start() {
			this.lookAtPlayerWarmup = 5;
			this.ticksSinceUnseenTeleport = 0;
		}

		public void stop() {
			this.targetPlayer = null;
			super.stop();
		}

		public boolean shouldContinue() {
			if (this.targetPlayer != null) {
				if (!this.enderman.isPlayerStaring(this.targetPlayer)) {
					return false;
				} else {
					this.enderman.lookAtEntity(this.targetPlayer, 10.0F, 10.0F);
					return true;
				}
			} else {
				return this.targetEntity != null && this.validTargetPredicate.test(this.enderman, this.targetEntity)
						? true
						: super.shouldContinue();
			}
		}

		public void tick() {
			if (this.enderman.getTarget() == null) {
				super.setTargetEntity((LivingEntity) null);
			}

			if (this.targetPlayer != null) {
				if (--this.lookAtPlayerWarmup <= 0) {
					this.targetEntity = this.targetPlayer;
					this.targetPlayer = null;
					super.start();
				}
			} else {
				if (this.targetEntity != null && !this.enderman.hasVehicle()) {
					if (this.enderman.isPlayerStaring((PlayerEntity) this.targetEntity)) {
						if (this.targetEntity.squaredDistanceTo(this.enderman) < 16.0D) {
							this.enderman.teleportRandomly();
						}

						this.ticksSinceUnseenTeleport = 0;
					} else if (this.targetEntity.squaredDistanceTo(this.enderman) > 256.0D
							&& this.ticksSinceUnseenTeleport++ >= 30 && this.enderman.teleportTo(this.targetEntity)) {
						this.ticksSinceUnseenTeleport = 0;
					}
				}

				super.tick();
			}

		}
	}
}