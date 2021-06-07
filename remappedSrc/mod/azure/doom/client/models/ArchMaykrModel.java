package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.tierboss.ArchMakyrEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ArchMaykrModel extends AnimatedGeoModel<ArchMakyrEntity> {

	@Override
	public Identifier getModelLocation(ArchMakyrEntity object) {
		return new Identifier(DoomMod.MODID, "geo/archmaykr_" + object.getVariant() + ".geo.json");
	}

	@Override
	public Identifier getTextureLocation(ArchMakyrEntity object) {
		return new Identifier(DoomMod.MODID, "textures/entity/archmaykr_" + object.getVariant() + ".png");
	}

	@Override
	public Identifier getAnimationFileLocation(ArchMakyrEntity object) {
		return new Identifier(DoomMod.MODID, "animations/archmaykr.animation.json");
	}

}