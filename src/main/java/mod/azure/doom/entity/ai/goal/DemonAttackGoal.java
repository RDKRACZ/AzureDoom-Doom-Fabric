package mod.azure.doom.entity.ai.goal;

import mod.azure.doom.entity.DemonEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;

public class DemonAttackGoal extends MeleeAttackGoal {
	private final DemonEntity zombie;
	private int ticks;

	public DemonAttackGoal(DemonEntity zombie, double speed, boolean pauseWhenMobIdle) {
		super(zombie, speed, pauseWhenMobIdle);
		this.zombie = zombie;
	}

	public void start() {
		super.start();
		this.ticks = 0;
	}

	public void stop() {
		super.stop();
		this.zombie.setAttacking(false);
	}

	@Override
	public boolean shouldContinue() {
		return super.shouldContinue();
	}

	public void tick() {
		super.tick();
		++this.ticks;
		LivingEntity livingEntity = this.zombie.getTarget();
		this.zombie.getLookControl().lookAt(livingEntity, 90.0F, 30.0F);
		if (livingEntity.squaredDistanceTo(this.zombie) < 8.0D) {
			if (this.ticks >= 5 && this.method_28348() < this.method_28349() / 2) {
				this.zombie.setAttacking(true);
			} else {
				this.zombie.setAttacking(false);
			}
		}

	}

}