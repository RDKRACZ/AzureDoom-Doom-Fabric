package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.MechaZombieEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MechaZombieModel extends AnimatedGeoModel<MechaZombieEntity> {

	public MechaZombieModel() {
	}

	@Override
	public Identifier getModelLocation(MechaZombieEntity object) {
		return new Identifier(DoomMod.MODID, "geo/mechazombie.geo.json");
	}

	@Override
	public Identifier getTextureLocation(MechaZombieEntity object) {
		return new Identifier(DoomMod.MODID, "textures/entity/mechazombie.png");
	}

	@Override
	public Identifier getAnimationFileLocation(MechaZombieEntity object) {
		return new Identifier(DoomMod.MODID, "animations/mechazombie_animation.json");
	}
}