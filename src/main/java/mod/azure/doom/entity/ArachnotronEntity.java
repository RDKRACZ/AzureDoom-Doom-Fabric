package mod.azure.doom.entity;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Random;

import me.sargunvohra.mcmods.autoconfig1u.shadowed.blue.endless.jankson.annotation.Nullable;
import mod.azure.doom.entity.projectiles.entity.EnergyCellMobEntity;
import mod.azure.doom.util.ModSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
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
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import software.bernie.geckolib.animation.builder.AnimationBuilder;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;

public class ArachnotronEntity extends DemonEntity implements IAnimatedEntity {

	EntityAnimationManager manager = new EntityAnimationManager();
	EntityAnimationController<ArachnotronEntity> controller = new EntityAnimationController<ArachnotronEntity>(this,
			"walkController", 0.09F, this::animationPredicate);

	public ArachnotronEntity(EntityType<ArachnotronEntity> entityType, World worldIn) {
		super(entityType, worldIn);
		manager.addAnimationController(controller);
	}

	private <E extends Entity> boolean animationPredicate(AnimationTestEvent<E> event) {
		if (!(lastLimbDistance > -0.15F && this.lastLimbDistance < 0.15F)) {
			controller.setAnimation(new AnimationBuilder().addAnimation("walking", true));
			return true;
		}
		return false;
	}

	@Override
	public EntityAnimationManager getAnimationManager() {
		return manager;
	}

	public static boolean spawning(EntityType<BaronEntity> p_223337_0_, World p_223337_1_, SpawnReason reason,
			BlockPos p_223337_3_, Random p_223337_4_) {
		return p_223337_1_.getDifficulty() != Difficulty.PEACEFUL;
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.add(6, new LookAroundGoal(this));
		this.goalSelector.add(5, new WanderAroundFarGoal(this, 0.8D));
		this.goalSelector.add(7, new ArachnotronEntity.ShootFireballGoal(this));
		this.targetSelector.add(1, new RevengeGoal(this, new Class[0]));
		this.targetSelector.add(2, new FollowTargetGoal<>(this, PlayerEntity.class, true));
		this.targetSelector.add(3, new FollowTargetGoal<>(this, HostileEntity.class, true));
		this.targetSelector.add(3, new FollowTargetGoal<>(this, MobEntity.class, true));
	}

	static class ShootFireballGoal extends Goal {
		private final ArachnotronEntity ghast;
		public int cooldown;

		public ShootFireballGoal(ArachnotronEntity ghast) {
			this.ghast = ghast;
		}

		public boolean canStart() {
			return this.ghast.getTarget() != null;
		}

		public void start() {
			this.cooldown = 0;
		}

		public void tick() {
			LivingEntity livingEntity = this.ghast.getTarget();
			if (livingEntity.squaredDistanceTo(this.ghast) < 4096.0D && this.ghast.canSee(livingEntity)) {
				World world = this.ghast.world;
				++this.cooldown;
				if (this.cooldown == 20) {
					Vec3d vec3d = this.ghast.getRotationVec(1.0F);
					double f = livingEntity.getX() - (this.ghast.getX() + vec3d.x * 4.0D);
					double g = livingEntity.getBodyY(0.5D) - (0.5D + this.ghast.getBodyY(0.5D));
					double h = livingEntity.getZ() - (this.ghast.getZ() + vec3d.z * 4.0D);
					EnergyCellMobEntity fireballEntity = new EnergyCellMobEntity(world, this.ghast, f, g, h);
					fireballEntity.updatePosition(this.ghast.getX() + vec3d.x * 1.0D, this.ghast.getBodyY(0.5D) + 0.5D,
							fireballEntity.getZ() + vec3d.z * 2.0D);
					world.spawnEntity(fireballEntity);
					this.cooldown = -40;
				}
			} else if (this.cooldown > 0) {
				--this.cooldown;
			}
		}
	}

	public static DefaultAttributeContainer.Builder createMobAttributes() {
		return LivingEntity.createLivingAttributes().add(EntityAttributes.GENERIC_FOLLOW_RANGE, 50.0D)
				.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.15D).add(EntityAttributes.GENERIC_MAX_HEALTH, 90.0D)
				.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 8.0D).add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 1.0D);
	}

	@Nullable
	@Override
	public EntityData initialize(ServerWorldAccess serverWorldAccess, LocalDifficulty difficulty,
			SpawnReason spawnReason, EntityData entityData, CompoundTag entityTag) {
		entityData = super.initialize(serverWorldAccess, difficulty, spawnReason, entityData, entityTag);
		if (this.getEquippedStack(EquipmentSlot.HEAD).isEmpty()) {
			LocalDate localDate = LocalDate.now();
			int i = localDate.get(ChronoField.DAY_OF_MONTH);
			int j = localDate.get(ChronoField.MONTH_OF_YEAR);
			if (j == 10 && i == 31 && this.random.nextFloat() < 0.25F) {
				this.equipStack(EquipmentSlot.HEAD,
						new ItemStack(this.random.nextFloat() < 0.1F ? Blocks.JACK_O_LANTERN : Blocks.CARVED_PUMPKIN));
				this.armorDropChances[EquipmentSlot.HEAD.getEntitySlotId()] = 0.0F;
			}
		}

		return entityData;
	}

	public void readCustomDataFromTag(CompoundTag tag) {
		super.readCustomDataFromTag(tag);
	}

	@Override
	protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
		return 1.0F;
	}

	protected boolean shouldDrown() {
		return false;
	}

	protected boolean shouldBurnInDay() {
		return false;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return ModSoundEvents.ARACHNOTRON_AMBIENT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return ModSoundEvents.ARACHNOTRON_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return ModSoundEvents.ARACHNOTRON_DEATH;
	}

	protected SoundEvent getStepSound() {
		return ModSoundEvents.ARACHNOTRON_AMBIENT;
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(this.getStepSound(), 0.15F, 1.0F);
	}
}