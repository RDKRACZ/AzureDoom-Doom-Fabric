package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.PinkyEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.AnimatedGeoModel;

public class PinkyModel extends AnimatedGeoModel<PinkyEntity> {

	public PinkyModel() {
	}

	@Override
	public Identifier getModelLocation(PinkyEntity object) {
		return new Identifier(DoomMod.MODID, "geo/pinky.geo.json");
	}

	@Override
	public Identifier getTextureLocation(PinkyEntity object) {
		return new Identifier(DoomMod.MODID, "textures/entity/pinky-texturemap.png");
	}

	@Override
	public Identifier getAnimationFileLocation(PinkyEntity object) {
		return new Identifier(DoomMod.MODID, "animations/pinky_animation.json");
	}
}