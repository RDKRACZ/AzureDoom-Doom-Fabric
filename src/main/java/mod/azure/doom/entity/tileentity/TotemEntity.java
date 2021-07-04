package mod.azure.doom.entity.tileentity;

import java.util.List;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.DemonEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class TotemEntity extends BlockEntity implements IAnimatable {
	private final AnimationFactory factory = new AnimationFactory(this);

	private <E extends BlockEntity & IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));
		return PlayState.CONTINUE;
	}

	public TotemEntity(BlockPos pos, BlockState state) {
		super(DoomMod.TOTEM, pos, state);
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<TotemEntity>(this, "controller", 0, this::predicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return factory;
	}

	public static void tick(World world, BlockPos pos, BlockState state, TotemEntity blockEntity) {
		if (blockEntity.world.getTime() % 80L == 0L) {
			blockEntity.applyEffects();
		}
	}

	@Override
	public void markRemoved() {
		this.removeEffects();
		super.markRemoved();
	}

	private void applyEffects() {
		if (!this.world.isClient()) {
			Box axisalignedbb = (new Box(this.pos)).expand(40).stretch(0.0D, (double) this.world.getHeight(), 0.0D);
			List<DemonEntity> list = this.world.getNonSpectatingEntities(DemonEntity.class, axisalignedbb);
			for (DemonEntity entity : list) {
				entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 1000, 1));
				entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 1000, 1));
				entity.setGlowing(true);
			}
		}
	}

	private void removeEffects() {
		if (!this.world.isClient()) {
			Box axisalignedbb = (new Box(this.pos)).expand(40).stretch(0.0D, (double) this.world.getHeight(), 0.0D);
			List<DemonEntity> list = this.world.getNonSpectatingEntities(DemonEntity.class, axisalignedbb);
			for (DemonEntity entity : list) {
				entity.setGlowing(false);
				entity.clearStatusEffects();
			}
		}
	}
}