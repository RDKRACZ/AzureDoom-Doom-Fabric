package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.PinkyEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class Pinky2016Model extends AnimatedGeoModel<PinkyEntity> {

	public Pinky2016Model() {
	}

	@Override
	public Identifier getModelLocation(PinkyEntity object) {
		return new Identifier(DoomMod.MODID, "geo/pinky2016.geo.json");
	}

	@Override
	public Identifier getTextureLocation(PinkyEntity object) {
		return new Identifier(DoomMod.MODID, "textures/entity/pinky2016.png");
	}

	@Override
	public Identifier getAnimationFileLocation(PinkyEntity object) {
		return new Identifier(DoomMod.MODID, "animations/pinky2016.animation.json");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void setLivingAnimations(PinkyEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
		super.setLivingAnimations(entity, uniqueID, customPredicate);
		IBone head = this.getAnimationProcessor().getBone("neck");

		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
		if (head != null) {
			head.setRotationX((extraData.headPitch + 30) * ((float) Math.PI / 360F));
			head.setRotationY((extraData.netHeadYaw) * ((float) Math.PI / 500F));
		}
	}
}