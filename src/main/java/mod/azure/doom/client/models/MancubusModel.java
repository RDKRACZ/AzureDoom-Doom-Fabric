package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.MancubusEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.AnimatedGeoModel;

public class MancubusModel extends AnimatedGeoModel<MancubusEntity> {

	public MancubusModel() {
	}

	@Override
	public Identifier getModelLocation(MancubusEntity object) {
		return new Identifier(DoomMod.MODID, "geo/mancubus.geo.json");
	}

	@Override
	public Identifier getTextureLocation(MancubusEntity object) {
		return new Identifier(DoomMod.MODID, "textures/entity/mancubus.png");
	}

	@Override
	public Identifier getAnimationFileLocation(MancubusEntity object) {
		return new Identifier(DoomMod.MODID, "animations/mancubus_animation.json");
	}
}