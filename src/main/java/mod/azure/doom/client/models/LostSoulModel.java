package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.LostSoulEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

/**
 * LostSoul - __Botmon__
 */
public class LostSoulModel extends AnimatedGeoModel<LostSoulEntity> {

	private static final Identifier[] TEX = { new Identifier(DoomMod.MODID, "textures/entity/lost_soul_fire_1.png"),
			new Identifier(DoomMod.MODID, "textures/entity/lost_soul_fire_2.png"),
			new Identifier(DoomMod.MODID, "textures/entity/lost_soul_fire_3.png"),
			new Identifier(DoomMod.MODID, "textures/entity/lost_soul_fire_4.png"),
			new Identifier(DoomMod.MODID, "textures/entity/lost_soul_fire_5.png"),
			new Identifier(DoomMod.MODID, "textures/entity/lost_soul_fire_6.png"),
			new Identifier(DoomMod.MODID, "textures/entity/lost_soul_fire_7.png"),
			new Identifier(DoomMod.MODID, "textures/entity/lost_soul_fire_8.png") };

	public LostSoulModel() {
	}

	@Override
	public Identifier getModelLocation(LostSoulEntity object) {
		return new Identifier(DoomMod.MODID, "geo/lostsoul.geo.json");
	}

	@Override
	public Identifier getTextureLocation(LostSoulEntity object) {
		return TEX[(object.getFlameTimer())];
	}

	@Override
	public Identifier getAnimationFileLocation(LostSoulEntity object) {
		return new Identifier(DoomMod.MODID, "animations/lostsoul_animation.json");
	}
}