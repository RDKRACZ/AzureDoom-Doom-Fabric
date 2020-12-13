package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.RevenantEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class RevenantModel extends AnimatedGeoModel<RevenantEntity> {

	public RevenantModel() {
	}

	@Override
	public Identifier getModelLocation(RevenantEntity object) {
		return new Identifier(DoomMod.MODID, "geo/revenant.geo.json");
	}

	@Override
	public Identifier getTextureLocation(RevenantEntity object) {
		return new Identifier(DoomMod.MODID, "textures/entity/revenant.png");
	}

	@Override
	public Identifier getAnimationFileLocation(RevenantEntity object) {
		return new Identifier(DoomMod.MODID, "animations/revenant.animation.json");
	}
}