package mod.azure.doom.entity;

import java.util.Random;

import org.jetbrains.annotations.Nullable;

import mod.azure.doom.util.ModSoundEvents;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
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
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import net.minecraft.world.explosion.ExplosionBehavior;

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
		this.targetSelector.add(2, new RevengeGoal(this));
		this.targetSelector.add(3, new FollowTargetGoal<>(this, HostileEntity.class, true));
		this.targetSelector.add(3, new FollowTargetGoal<>(this, MobEntity.class, true));
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
						this.ghast.createExplosion(this.ghast, DamageSource.LIGHTNING_BOLT, (ExplosionBehavior) null,
								this.ghast.getTarget().getX(), this.ghast.getTarget().getEyeY(),
								this.ghast.getTarget().getZ(), 1.0F, true, Explosion.DestructionType.NONE);
					}
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

	public Explosion createExplosion(@Nullable Entity entity, @Nullable DamageSource damageSource,
			@Nullable ExplosionBehavior explosionBehavior, double d, double e, double f, float g, boolean bl,
			Explosion.DestructionType destructionType) {
		Explosion explosion = new Explosion(this.world, entity, damageSource, explosionBehavior, d, e, f, g, bl,
				destructionType);
		explosion.collectBlocksAndDamageEntities();
		explosion.affectWorld(false);
		return explosion;
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