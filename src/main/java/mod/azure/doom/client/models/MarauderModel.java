package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.MarauderEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MarauderModel extends AnimatedGeoModel<MarauderEntity> {

	public MarauderModel() {
	}

	@Override
	public Identifier getModelLocation(MarauderEntity object) {
		return new Identifier(DoomMod.MODID, "geo/shotgunzombie.geo.json");
	}

	@Override
	public Identifier getTextureLocation(MarauderEntity object) {
		return new Identifier(DoomMod.MODID, "textures/entity/marauder.png");
	}

	@Override
	public Identifier getAnimationFileLocation(MarauderEntity object) {
		return new Identifier(DoomMod.MODID, "animations/shotgunzombie.animation.json");
	}
}