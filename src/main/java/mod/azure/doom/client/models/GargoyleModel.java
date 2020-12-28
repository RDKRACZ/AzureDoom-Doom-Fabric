package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.GargoyleEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GargoyleModel extends AnimatedGeoModel<GargoyleEntity> {

	public GargoyleModel() {
	}

	@Override
	public Identifier getModelLocation(GargoyleEntity object) {
		return new Identifier(DoomMod.MODID, "geo/gargoyleimp.geo.json");
	}

	@Override
	public Identifier getTextureLocation(GargoyleEntity object) {
		return new Identifier(DoomMod.MODID, "textures/entity/gargoyleimp.png");
	}

	@Override
	public Identifier getAnimationFileLocation(GargoyleEntity object) {
		return new Identifier(DoomMod.MODID, "animations/gargoyleimp.animation.json");
	}
}