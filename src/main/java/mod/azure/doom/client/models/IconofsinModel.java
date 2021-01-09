package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.IconofsinEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class IconofsinModel extends AnimatedGeoModel<IconofsinEntity> {

	public IconofsinModel() {
	}

	@Override
	public Identifier getModelLocation(IconofsinEntity object) {
		return new Identifier(DoomMod.MODID, "geo/icon.geo.json");
	}

	@Override
	public Identifier getTextureLocation(IconofsinEntity object) {
		return new Identifier(DoomMod.MODID, "textures/entity/iconofsin.png");
	}

	@Override
	public Identifier getAnimationFileLocation(IconofsinEntity object) {
		return new Identifier(DoomMod.MODID, "animations/icon.animation.json");
	}
}