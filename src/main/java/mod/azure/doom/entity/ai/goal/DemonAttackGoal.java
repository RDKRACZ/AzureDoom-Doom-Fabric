package mod.azure.doom.entity.ai.goal;

import mod.azure.doom.entity.DemonEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;

public class DemonAttackGoal extends MeleeAttackGoal {
	private final DemonEntity actor;
	private int ticks;

	public DemonAttackGoal(DemonEntity zombie, double speed, boolean pauseWhenMobIdle) {
		super(zombie, speed, pauseWhenMobIdle);
		this.actor = zombie;
	}

	public void start() {
		super.start();
		this.ticks = 0;
	}

	public void stop() {
		super.stop();
		this.actor.setAttacking(false);
	}

	@Override
	public boolean shouldContinue() {
		return super.shouldContinue();
	}

	public void tick() {
		super.tick();
		++this.ticks;
		LivingEntity livingEntity = this.actor.getTarget();
		if (livingEntity != null) {
			this.actor.getLookControl().lookAt(livingEntity, 90.0F, 30.0F);
			if (livingEntity.squaredDistanceTo(this.actor) < 4.0D) {
				if (this.ticks >= 5 && this.getCooldown() < this.getMaxCooldown() / 2) {
					this.actor.setAttacking(true);
					this.actor.setMeleeAttacking(true);
				} else {
					this.actor.setAttacking(false);
					this.actor.setMeleeAttacking(false);
				}
			}
		}
	}

	@Override
	protected double getSquaredMaxAttackDistance(LivingEntity entity) {
		return (double) (this.mob.getWidth() * 1.0F * this.mob.getWidth() * 1.0F + entity.getWidth());
	}

}