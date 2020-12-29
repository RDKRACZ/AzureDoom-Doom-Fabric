package mod.azure.doom.client.models.projectiles;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.projectiles.entity.ArchvileFiring;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ArchvileFiringModel extends AnimatedGeoModel<ArchvileFiring> {
	@Override
	public Identifier getModelLocation(ArchvileFiring object) {
		return new Identifier(DoomMod.MODID, "geo/archvilefiring.geo.json");
	}

	@Override
	public Identifier getTextureLocation(ArchvileFiring object) {
		return new Identifier(DoomMod.MODID, "textures/items/empty.png");
	}

	@Override
	public Identifier getAnimationFileLocation(ArchvileFiring animatable) {
		return new Identifier(DoomMod.MODID, "animations/archvilefiring.animation.json");
	}
}
