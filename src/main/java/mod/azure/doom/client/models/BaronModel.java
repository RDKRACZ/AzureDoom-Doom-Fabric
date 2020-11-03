package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.BaronEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.AnimatedGeoModel;

public class BaronModel extends AnimatedGeoModel<BaronEntity> {

	public BaronModel() {
	}

	@Override
	public Identifier getModelLocation(BaronEntity object) {
		return new Identifier(DoomMod.MODID, "geo/baron.geo.json");
	}

	@Override
	public Identifier getTextureLocation(BaronEntity object) {
		return new Identifier(DoomMod.MODID, "textures/entity/baronofhell-texturemap.png");
	}

	@Override
	public Identifier getAnimationFileLocation(BaronEntity object) {
		return new Identifier(DoomMod.MODID, "animations/baron_hell_animation.json");
	}
}