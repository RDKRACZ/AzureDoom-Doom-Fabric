package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.HellknightEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.AnimatedGeoModel;

public class HellknightModel extends AnimatedGeoModel<HellknightEntity> {

	public HellknightModel() {
	}

	@Override
	public Identifier getModelLocation(HellknightEntity object) {
		return new Identifier(DoomMod.MODID, "geo/hellknight.geo.json");
	}

	@Override
	public Identifier getTextureLocation(HellknightEntity object) {
		return new Identifier(DoomMod.MODID, "textures/entity/hellknight-texturemap.png");
	}

	@Override
	public Identifier getAnimationFileLocation(HellknightEntity object) {
		return new Identifier(DoomMod.MODID, "animations/baron_hell_animation.json");
	}
}