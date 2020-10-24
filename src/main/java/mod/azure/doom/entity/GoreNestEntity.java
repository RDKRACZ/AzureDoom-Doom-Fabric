package mod.azure.doom.entity;

import java.util.Random;

import me.sargunvohra.mcmods.autoconfig1u.shadowed.blue.endless.jankson.annotation.Nullable;
import mod.azure.doom.util.registry.MobEntityRegister;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import software.bernie.geckolib.animation.builder.AnimationBuilder;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;

public class GoreNestEntity extends DemonEntity implements IAnimatedEntity {

	private final GoreNestEntity parentEntity;

	EntityAnimationManager manager = new EntityAnimationManager();
	EntityAnimationController<GoreNestEntity> controller = new EntityAnimationController<GoreNestEntity>(this,
			"walkController", 0.09F, this::animationPredicate);

	public GoreNestEntity(EntityType<? extends GoreNestEntity> entityType, World worldIn) {
		super(entityType, worldIn);
		manager.addAnimationController(controller);
		this.parentEntity = GoreNestEntity.this;
	}

	private <E extends Entity> boolean animationPredicate(AnimationTestEvent<E> event) {

		if (this.dead) {
			if (world.isClient) {
				controller.setAnimation(new AnimationBuilder().addAnimation("death", false));
				return true;
			}
		}
		controller.setAnimation(new AnimationBuilder().addAnimation("idle", true));
		return true;
	}

	@Override
	public EntityAnimationManager getAnimationManager() {
		return manager;
	}

	public static boolean spawning(EntityType<GoreNestEntity> p_223337_0_, World p_223337_1_, SpawnReason reason,
			BlockPos p_223337_3_, Random p_223337_4_) {
		return p_223337_1_.getDifficulty() != Difficulty.PEACEFUL;
	}

	@Override
	protected void updatePostDeath() {
		++this.deathTime;
		if (this.deathTime == 80) {
			this.remove();
			HellknightEntity fireballentity = MobEntityRegister.HELLKNIGHT.create(world);
			fireballentity.setPos(this.parentEntity.getX() + 2.0D, this.parentEntity.getY() + 0.5D,
					this.parentEntity.getZ() + 2.0D);
			world.spawnEntity(fireballentity);

			PossessedScientistEntity fireballentity1 = MobEntityRegister.POSSESSEDSCIENTIST.create(world);
			fireballentity1.setPos(this.parentEntity.getX() + -2.0D, this.parentEntity.getY() + 0.5D,
					this.parentEntity.getZ() + -2.0D);
			world.spawnEntity(fireballentity1);

			ImpEntity fireballentity11 = MobEntityRegister.IMP.create(world);
			fireballentity11.setPos(this.parentEntity.getX() + 1.0D, this.parentEntity.getY() + 0.5D,
					this.parentEntity.getZ() + 1.0D);
			world.spawnEntity(fireballentity11);

			NightmareImpEntity fireballentity111 = MobEntityRegister.NIGHTMARE_IMP.create(world);
			fireballentity111.setPos(this.parentEntity.getX() + -1.0D, this.parentEntity.getY() + 0.5D,
					this.parentEntity.getZ() + -1.0D);
			world.spawnEntity(fireballentity111);
		}

	}

	public static DefaultAttributeContainer.Builder createMobAttributes() {
		return LivingEntity.createLivingAttributes().add(EntityAttributes.GENERIC_FOLLOW_RANGE, 50.0D)
				.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.15D).add(EntityAttributes.GENERIC_MAX_HEALTH, 5.0D)
				.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 0.0D).add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 1.0D);
	}

	@Nullable
	@Override
	public EntityData initialize(ServerWorldAccess serverWorldAccess, LocalDifficulty difficulty,
			SpawnReason spawnReason, EntityData entityData, CompoundTag entityTag) {
		entityData = super.initialize(serverWorldAccess, difficulty, spawnReason, entityData, entityTag);
		return entityData;
	}

	protected boolean shouldDrown() {
		return false;
	}

	protected boolean shouldBurnInDay() {
		return false;
	}

	@Override
	@Environment(EnvType.CLIENT)
	public boolean shouldRender(double distance) {
		return true;
	}
}