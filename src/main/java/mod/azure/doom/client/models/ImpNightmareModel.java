package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.NightmareImpEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.AnimatedGeoModel;

public class ImpNightmareModel extends AnimatedGeoModel<NightmareImpEntity> {

	public ImpNightmareModel() {
	}

	@Override
	public Identifier getModelLocation(NightmareImpEntity object) {
		return new Identifier(DoomMod.MODID, "geo/nightmareimp.geo.json");
	}

	@Override
	public Identifier getTextureLocation(NightmareImpEntity object) {
		return new Identifier(DoomMod.MODID, "textures/entity/nightmareimp-texture.png");
	}

	@Override
	public Identifier getAnimationFileLocation(NightmareImpEntity object) {
		return new Identifier(DoomMod.MODID, "animations/imp_animation.json");
	}
}