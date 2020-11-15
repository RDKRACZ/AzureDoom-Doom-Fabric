package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.CacodemonEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CacodemonModel extends AnimatedGeoModel<CacodemonEntity> {

	public CacodemonModel() {
	}

	@Override
	public Identifier getModelLocation(CacodemonEntity object) {
		return new Identifier(DoomMod.MODID, "geo/cacodemon.geo.json");
	}

	@Override
	public Identifier getTextureLocation(CacodemonEntity object) {
		return new Identifier(DoomMod.MODID, "textures/entity/cacodemon.png");
	}

	@Override
	public Identifier getAnimationFileLocation(CacodemonEntity object) {
		return new Identifier(DoomMod.MODID, "animations/cacodemon_animation.json");
	}
}