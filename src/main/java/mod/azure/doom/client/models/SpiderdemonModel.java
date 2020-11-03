package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.SpiderdemonEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.AnimatedGeoModel;

public class SpiderdemonModel extends AnimatedGeoModel<SpiderdemonEntity> {

	public SpiderdemonModel() {
	}

	@Override
	public Identifier getModelLocation(SpiderdemonEntity object) {
		return new Identifier(DoomMod.MODID, "geo/spidermastermind.geo.json");
	}

	@Override
	public Identifier getTextureLocation(SpiderdemonEntity object) {
		return new Identifier(DoomMod.MODID, "textures/entity/spidermastermind-texturemap.png");
	}

	@Override
	public Identifier getAnimationFileLocation(SpiderdemonEntity object) {
		return new Identifier(DoomMod.MODID, "animations/spidermastermind_animation.json");
	}
}