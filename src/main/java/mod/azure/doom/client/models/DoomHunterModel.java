package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.DoomHunterEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DoomHunterModel extends AnimatedGeoModel<DoomHunterEntity> {

	@Override
	public Identifier getModelLocation(DoomHunterEntity object) {
		return new Identifier(DoomMod.MODID, "geo/doomhunter.geo.json");
	}

	@Override
	public Identifier getTextureLocation(DoomHunterEntity object) {
		return new Identifier(DoomMod.MODID, "textures/entity/doomhunter.png");
	}

	@Override
	public Identifier getAnimationFileLocation(DoomHunterEntity object) {
		return new Identifier(DoomMod.MODID, "animations/doomhunter.animation.json");
	}

}