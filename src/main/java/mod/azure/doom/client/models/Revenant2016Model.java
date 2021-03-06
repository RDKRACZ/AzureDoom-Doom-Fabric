package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.tierheavy.Revenant2016Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3f;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class Revenant2016Model extends AnimatedGeoModel<Revenant2016Entity> {

	private static final Identifier[] TEX = { new Identifier(DoomMod.MODID, "textures/entity/revenant.png"),
			new Identifier(DoomMod.MODID, "textures/entity/revenant_1.png"),
			new Identifier(DoomMod.MODID, "textures/entity/revenant_2.png"),
			new Identifier(DoomMod.MODID, "textures/entity/revenant_3.png"),
			new Identifier(DoomMod.MODID, "textures/entity/revenant_4.png"),
			new Identifier(DoomMod.MODID, "textures/entity/revenant_5.png"),
			new Identifier(DoomMod.MODID, "textures/entity/revenant_6.png"),
			new Identifier(DoomMod.MODID, "textures/entity/revenant_7.png") };

	@Override
	public Identifier getModelLocation(Revenant2016Entity object) {
		return new Identifier(DoomMod.MODID, "geo/revenant.geo.json");
	}

	@Override
	public Identifier getTextureLocation(Revenant2016Entity object) {
		return TEX[(object.getFlameTimer())];
	}

	@Override
	public Identifier getAnimationFileLocation(Revenant2016Entity object) {
		return new Identifier(DoomMod.MODID, "animations/revenant.animation.json");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void setLivingAnimations(Revenant2016Entity entity, Integer uniqueID, AnimationEvent customPredicate) {
		super.setLivingAnimations(entity, uniqueID, customPredicate);
		IBone head = this.getAnimationProcessor().getBone("head");

		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
		if (head != null) {
			head.setRotationX(
					Vec3f.POSITIVE_X.getRadialQuaternion(extraData.headPitch * ((float) Math.PI / 180F)).getX());
			head.setRotationY(
					Vec3f.POSITIVE_Y.getRadialQuaternion(extraData.netHeadYaw * ((float) Math.PI / 180F)).getY());
		}
	}
}