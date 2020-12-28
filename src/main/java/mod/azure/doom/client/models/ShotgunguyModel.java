package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.ShotgunguyEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ShotgunguyModel extends AnimatedGeoModel<ShotgunguyEntity> {

	public ShotgunguyModel() {
	}

	@Override
	public Identifier getModelLocation(ShotgunguyEntity object) {
		return new Identifier(DoomMod.MODID, "geo/shotgunzombie.geo.json");
	}

	@Override
	public Identifier getTextureLocation(ShotgunguyEntity object) {
		return new Identifier(DoomMod.MODID, "textures/entity/shotgunguy.png");
	}

	@Override
	public Identifier getAnimationFileLocation(ShotgunguyEntity object) {
		return new Identifier(DoomMod.MODID, "animations/shotgunzombie.animation.json");
	}
}