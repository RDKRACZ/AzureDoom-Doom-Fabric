package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.Hellknight2016Entity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class Hellknight2016Model extends AnimatedGeoModel<Hellknight2016Entity> {

	public Hellknight2016Model() {
	}

	@Override
	public Identifier getModelLocation(Hellknight2016Entity object) {
		return new Identifier(DoomMod.MODID, "geo/hellknight2016.geo.json");
	}

	@Override
	public Identifier getTextureLocation(Hellknight2016Entity object) {
		return new Identifier(DoomMod.MODID, "textures/entity/hellknight2016.png");
	}

	@Override
	public Identifier getAnimationFileLocation(Hellknight2016Entity object) {
		return new Identifier(DoomMod.MODID, "animations/hellknight2016_animation.json");
	}
}