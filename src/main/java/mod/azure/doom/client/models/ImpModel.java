package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.ImpEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ImpModel extends AnimatedGeoModel<ImpEntity> {

	public ImpModel() {
	}

	@Override
	public Identifier getModelLocation(ImpEntity object) {
		return new Identifier(DoomMod.MODID, "geo/imp.geo.json");
	}

	@Override
	public Identifier getTextureLocation(ImpEntity object) {
		return new Identifier(DoomMod.MODID, "textures/entity/imp-texturemap.png");
	}

	@Override
	public Identifier getAnimationFileLocation(ImpEntity object) {
		return new Identifier(DoomMod.MODID, "animations/imp_animation.json");
	}
}