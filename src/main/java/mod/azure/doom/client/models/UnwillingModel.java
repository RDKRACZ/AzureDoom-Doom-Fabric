package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.UnwillingEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class UnwillingModel extends AnimatedGeoModel<UnwillingEntity> {

	public UnwillingModel() {
	}

	@Override
	public Identifier getModelLocation(UnwillingEntity object) {
		return new Identifier(DoomMod.MODID, "geo/shotgunzombie.geo.json");
	}

	@Override
	public Identifier getTextureLocation(UnwillingEntity object) {
		return new Identifier(DoomMod.MODID, "textures/entity/unwilling.png");
	}

	@Override
	public Identifier getAnimationFileLocation(UnwillingEntity object) {
		return new Identifier(DoomMod.MODID, "animations/shotgunzombie.animation.json");
	}

}