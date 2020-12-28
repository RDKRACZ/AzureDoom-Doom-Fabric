package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.ZombiemanEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ZombiemanModel extends AnimatedGeoModel<ZombiemanEntity> {

	public ZombiemanModel() {
	}

	@Override
	public Identifier getModelLocation(ZombiemanEntity object) {
		return new Identifier(DoomMod.MODID, "geo/shotgunzombie.geo.json");
	}

	@Override
	public Identifier getTextureLocation(ZombiemanEntity object) {
		return new Identifier(DoomMod.MODID, "textures/entity/eternalzombiemen.png");
	}

	@Override
	public Identifier getAnimationFileLocation(ZombiemanEntity object) {
		return new Identifier(DoomMod.MODID, "animations/shotgunzombie.animation.json");
	}
}