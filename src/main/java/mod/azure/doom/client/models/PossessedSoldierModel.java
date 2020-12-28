package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.PossessedSoldierEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PossessedSoldierModel extends AnimatedGeoModel<PossessedSoldierEntity> {

	public PossessedSoldierModel() {
	}

	@Override
	public Identifier getModelLocation(PossessedSoldierEntity object) {
		return new Identifier(DoomMod.MODID, "geo/shotgunzombie.geo.json");
	}

	@Override
	public Identifier getTextureLocation(PossessedSoldierEntity object) {
		return new Identifier(DoomMod.MODID, "textures/entity/possessedsoldier.png");
	}

	@Override
	public Identifier getAnimationFileLocation(PossessedSoldierEntity object) {
		return new Identifier(DoomMod.MODID, "animations/shotgunzombie.animation.json");
	}
}