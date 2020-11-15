package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.PainEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PainModel extends AnimatedGeoModel<PainEntity> {

	private static final Identifier NORMAL = new Identifier(DoomMod.MODID,
			"textures/entity/painelemental-normal.png");
	private static final Identifier ATTACKING = new Identifier(DoomMod.MODID,
			"textures/entity/painelemental-attacking.png");

	public PainModel() {
	}

	@Override
	public Identifier getModelLocation(PainEntity object) {
		return new Identifier(DoomMod.MODID, "geo/pain.geo.json");
	}

	@Override
	public Identifier getTextureLocation(PainEntity object) {
		return object.isAttacking() ? ATTACKING : NORMAL;
	}

	@Override
	public Identifier getAnimationFileLocation(PainEntity object) {
		return new Identifier(DoomMod.MODID, "animations/pain_animation.json");
	}
}