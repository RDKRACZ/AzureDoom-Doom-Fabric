package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.CyberdemonEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CyberdemonModel extends AnimatedGeoModel<CyberdemonEntity> {

	public CyberdemonModel() {
	}

	@Override
	public Identifier getModelLocation(CyberdemonEntity object) {
		return new Identifier(DoomMod.MODID, "geo/cyberdemon.geo.json");
	}

	@Override
	public Identifier getTextureLocation(CyberdemonEntity object) {
		return new Identifier(DoomMod.MODID, "textures/entity/cyberdemon-texturemap.png");
	}

	@Override
	public Identifier getAnimationFileLocation(CyberdemonEntity object) {
		return new Identifier(DoomMod.MODID, "animations/cyberdemon_animation.json");
	}
}