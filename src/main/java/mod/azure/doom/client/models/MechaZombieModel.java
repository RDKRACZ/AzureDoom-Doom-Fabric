package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.MechaZombieEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MechaZombieModel extends AnimatedGeoModel<MechaZombieEntity> {

	public MechaZombieModel() {
	}

//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	@Override
//	public void setLivingAnimations(MechaZombieEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
//		super.setLivingAnimations(entity, uniqueID, customPredicate);
//		IBone head = this.getAnimationProcessor().getBone("head");
//
//		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
//		head.setRotationX(extraData.headPitch / 180F);
//		head.setRotationY(extraData.netHeadYaw / 180F);
//	}

	@Override
	public void setLivingAnimations(MechaZombieEntity entity, Integer uniqueID) {
		super.setLivingAnimations(entity, uniqueID);
	}

	@Override
	public Identifier getModelLocation(MechaZombieEntity object) {
		return new Identifier(DoomMod.MODID, "geo/mechazombie.geo.json");
	}

	@Override
	public Identifier getTextureLocation(MechaZombieEntity object) {
		return new Identifier(DoomMod.MODID, "textures/entity/mechazombie.png");
	}

	@Override
	public Identifier getAnimationFileLocation(MechaZombieEntity object) {
		return new Identifier(DoomMod.MODID, "animations/mechazombie_animation.json");
	}
}