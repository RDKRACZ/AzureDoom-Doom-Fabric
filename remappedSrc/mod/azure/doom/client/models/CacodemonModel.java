package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.tierheavy.CacodemonEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3f;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class CacodemonModel extends AnimatedGeoModel<CacodemonEntity> {

	public CacodemonModel() {
	}

	@Override
	public Identifier getModelLocation(CacodemonEntity object) {
		return new Identifier(DoomMod.MODID, "geo/cacodemon.geo.json");
	}

	@Override
	public Identifier getTextureLocation(CacodemonEntity object) {
		return new Identifier(DoomMod.MODID, "textures/entity/cacodemon.png");
	}

	@Override
	public Identifier getAnimationFileLocation(CacodemonEntity object) {
		return new Identifier(DoomMod.MODID, "animations/cacodemon_animation.json");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void setLivingAnimations(CacodemonEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
		super.setLivingAnimations(entity, uniqueID, customPredicate);
		IBone head = this.getAnimationProcessor().getBone("body");

		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
		if (head != null) {
			head.setRotationX(
					Vec3f.POSITIVE_X.getRadialQuaternion(extraData.headPitch * ((float) Math.PI / 180F)).getX());
			head.setRotationY(
					Vec3f.POSITIVE_Y.getRadialQuaternion(extraData.netHeadYaw * ((float) Math.PI / 180F)).getY());
		}
	}
}