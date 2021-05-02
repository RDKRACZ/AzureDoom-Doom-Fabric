package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.tierheavy.BloodMaykrEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BloodMaykrModel extends AnimatedGeoModel<BloodMaykrEntity> {

	@Override
	public Identifier getModelLocation(BloodMaykrEntity object) {
		return new Identifier(DoomMod.MODID, "geo/bloodmaykr.geo.json");
	}

	@Override
	public Identifier getTextureLocation(BloodMaykrEntity object) {
		return new Identifier(DoomMod.MODID, "textures/entity/bloodmaykr.png");
	}

	@Override
	public Identifier getAnimationFileLocation(BloodMaykrEntity object) {
		return new Identifier(DoomMod.MODID, "animations/bloodmaykr.animation.json");
	}

}