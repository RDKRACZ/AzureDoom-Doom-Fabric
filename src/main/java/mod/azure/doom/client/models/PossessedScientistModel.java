package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.PossessedScientistEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PossessedScientistModel extends AnimatedGeoModel<PossessedScientistEntity> {

	public PossessedScientistModel() {
	}

	@Override
	public Identifier getModelLocation(PossessedScientistEntity object) {
		return new Identifier(DoomMod.MODID, "geo/scientistpossessed.geo.json");
	}

	@Override
	public Identifier getTextureLocation(PossessedScientistEntity object) {
		return new Identifier(DoomMod.MODID, "textures/entity/possessedscientist.png");
	}

	@Override
	public Identifier getAnimationFileLocation(PossessedScientistEntity object) {
		return new Identifier(DoomMod.MODID, "animations/possessed_scientist_animation.json");
	}
}