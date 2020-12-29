package mod.azure.doom.entity.projectiles.entity;

import mod.azure.doom.util.packets.EntityPacket;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.EvokerFangsEntity;
import net.minecraft.network.Packet;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class ArchvileFiring extends EvokerFangsEntity implements IAnimatable {

	public ArchvileFiring(EntityType<? extends EvokerFangsEntity> entityType, World world) {
		super(entityType, world);
	}

	public ArchvileFiring(World worldIn, double x, double y, double z, float p_i47276_8_, int p_i47276_9_,
			LivingEntity casterIn) {
		super(worldIn, x, y, z, p_i47276_8_, p_i47276_9_, casterIn);
	}

	private AnimationFactory factory = new AnimationFactory(this);

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		return PlayState.STOP;
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<ArchvileFiring>(this, "controller", 0, this::predicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}

	@Override
	public Packet<?> createSpawnPacket() {
		return EntityPacket.createPacket(this);
	}

}