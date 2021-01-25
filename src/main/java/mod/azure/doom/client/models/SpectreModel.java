package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.SpectreEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SpectreModel extends AnimatedGeoModel<SpectreEntity> {

	public SpectreModel() {
	}

	@Override
	public Identifier getModelLocation(SpectreEntity object) {
		return new Identifier(DoomMod.MODID, "geo/pinky.geo.json");
	}

	@Override
	public Identifier getTextureLocation(SpectreEntity object) {
		return new Identifier(DoomMod.MODID, "textures/entity/pinky-texturemap.png");
	}

	@Override
	public Identifier getAnimationFileLocation(SpectreEntity object) {
		return new Identifier(DoomMod.MODID, "animations/pinky_animation.json");
	}
}