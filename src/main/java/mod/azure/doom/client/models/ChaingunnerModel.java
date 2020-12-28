package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.ChaingunnerEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ChaingunnerModel extends AnimatedGeoModel<ChaingunnerEntity> {

	public ChaingunnerModel() {
	}

	@Override
	public Identifier getModelLocation(ChaingunnerEntity object) {
		return new Identifier(DoomMod.MODID, "geo/chaingunner.geo.json");
	}

	@Override
	public Identifier getTextureLocation(ChaingunnerEntity object) {
		return new Identifier(DoomMod.MODID, "textures/entity/chaingunner.png");
	}

	@Override
	public Identifier getAnimationFileLocation(ChaingunnerEntity object) {
		return new Identifier(DoomMod.MODID, "animations/chaingunner.animation.json");
	}
}