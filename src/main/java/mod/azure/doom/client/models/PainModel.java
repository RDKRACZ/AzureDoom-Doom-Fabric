package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.tierheavy.PainEntity;
import net.minecraft.util.math.Vec3f;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class PainModel extends AnimatedGeoModel<PainEntity> {

	private static final Identifier NORMAL = new Identifier(DoomMod.MODID, "textures/entity/painelemental-normal.png");
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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void setLivingAnimations(PainEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
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