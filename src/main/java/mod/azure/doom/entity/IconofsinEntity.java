package mod.azure.doom.entity;

import java.util.Random;

import org.jetbrains.annotations.Nullable;

import mod.azure.doom.util.ModSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class IconofsinEntity extends DemonEntity implements IAnimatable {

	private final ServerBossBar bossBar = (ServerBossBar) (new ServerBossBar(this.getDisplayName(),
			BossBar.Color.PURPLE, BossBar.Style.PROGRESS)).setDarkenSky(true).setThickenFog(true);

	public IconofsinEntity(EntityType<IconofsinEntity> entityType, World worldIn) {
		super(entityType, worldIn);
	}

	public static boolean spawning(EntityType<IconofsinEntity> p_223337_0_, World p_223337_1_, SpawnReason reason,
			BlockPos p_223337_3_, Random p_223337_4_) {
		return p_223337_1_.getDifficulty() != Difficulty.PEACEFUL;
	}

	private AnimationFactory factory = new AnimationFactory(this);

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		if (event.isMoving()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("walking", true));
			return PlayState.CONTINUE;
		}
		if (this.isAttacking() && !(this.dead || this.getHealth() < 0.01 || this.isDead())) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("attack", true));
			return PlayState.CONTINUE;
		}
		if ((this.dead || this.getHealth() < 0.01 || this.isDead())) {
			if (world.isClient) {
				event.getController().setAnimation(new AnimationBuilder().addAnimation("death", false));
				return PlayState.CONTINUE;
			}
		}
		if (event.isMoving() && this.getHealth() < 500.0D) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("walking_nohelmet", true));
			return PlayState.CONTINUE;
		}
		if (this.getHealth() < 500.0D) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("idle_nohelmet", true));
			return PlayState.CONTINUE;
		}
		event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));
		return PlayState.CONTINUE;
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<IconofsinEntity>(this, "controller", 0, this::predicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}

	@Override
	protected void updatePostDeath() {
		++this.deathTime;
		if (this.deathTime == 50) {
			this.remove();
			if (world.isClient) {
			}
		}
	}

	@Override
	public boolean handleFallDamage(float fallDistance, float damageMultiplier) {
		return false;
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.add(8, new LookAroundGoal(this));
		this.goalSelector.add(5, new WanderAroundFarGoal(this, 0.8D));
		this.initCustomGoals();
	}

	protected void initCustomGoals() {
		this.goalSelector.add(2, new MeleeAttackGoal(this, 1.0D, false));
		this.targetSelector.add(2, new FollowTargetGoal<>(this, PlayerEntity.class, true));
		this.targetSelector.add(2, new FollowTargetGoal<>(this, MerchantEntity.class, true));
	}

	public static DefaultAttributeContainer.Builder createMobAttributes() {
		return LivingEntity.createLivingAttributes().add(EntityAttributes.GENERIC_FOLLOW_RANGE, 100.0D)
				.add(EntityAttributes.GENERIC_MAX_HEALTH, 1000.0D).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 30.0D)
				.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D)
				.add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 0.0D)
				.add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1000.0D);
	}

	@Override
	protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
		return 18.70F;
	}

	protected boolean shouldDrown() {
		return false;
	}

	protected boolean shouldBurnInDay() {
		return false;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return ModSoundEvents.ICON_AMBIENT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return ModSoundEvents.ICON_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return ModSoundEvents.ICON_DEATH;
	}

	protected SoundEvent getStepSound() {
		return SoundEvents.ENTITY_SKELETON_STEP;
	}

	public void onStartedTrackingBy(ServerPlayerEntity player) {
		super.onStartedTrackingBy(player);
		this.bossBar.addPlayer(player);
	}

	public void onStoppedTrackingBy(ServerPlayerEntity player) {
		super.onStoppedTrackingBy(player);
		this.bossBar.removePlayer(player);
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(this.getStepSound(), 0.15F, 1.0F);
	}

	@Override
	public void readCustomDataFromTag(CompoundTag tag) {
		super.readCustomDataFromTag(tag);
		if (this.hasCustomName()) {
			this.bossBar.setName(this.getDisplayName());
		}
	}

	@Override
	public void setCustomName(@Nullable Text name) {
		super.setCustomName(name);
		this.bossBar.setName(this.getDisplayName());
	}

	@Override
	protected void mobTick() {
		super.mobTick();
		this.bossBar.setPercent(this.getHealth() / this.getMaxHealth());
	}
	
	@Override
	public void tick() {
		super.tick();
		if (this.isAlive()) {
	         if (this.isInsideWall()) {
	             this.noClip = true;
	         }
	         if (!this.isInsideWall()) {
	             this.noClip = false;
	         }
		}
	}

	@Override
	public void tickMovement() {
		super.tickMovement();
		if (this.getHealth() > 500.0D) {
			if (!this.world.isClient) {
				this.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 1000000, 1));
			}
		}
		if (this.getHealth() < 500.0D) {
			if (!this.world.isClient) {
				this.removeStatusEffect(StatusEffects.STRENGTH);
				this.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 10000000, 2));
				this.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 10000000, 1));
			}
		}
		if (!this.world.getDimension().isRespawnAnchorWorking()) {
			if (!this.world.isClient) {
				this.setGlowing(true);
				this.addStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 10000000, this.age + 1));
				this.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 10000000, this.age/ 20 + 1));
			}
		}
	}
}