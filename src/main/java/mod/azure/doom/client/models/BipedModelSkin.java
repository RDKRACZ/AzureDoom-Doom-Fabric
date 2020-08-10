package mod.azure.doom.client.models;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.item.CrossbowItem;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;

//Created by Marctron
public class BipedModelSkin<T extends LivingEntity> extends BipedEntityModel<T> {

	public final ModelPart bipedLeftArmwear;
	public final ModelPart bipedRightArmwear;
	public final ModelPart bipedLeftLegwear;
	public final ModelPart bipedRightLegwear;
	public final ModelPart torsoWear;

	private float remainingItemUseTime;

	public BipedModelSkin(float modelSize, boolean smallArmsIn) {
		super(modelSize, 0.0F, 64, 64);
		this.bipedLeftArmwear = new ModelPart(this, 48, 48);
		this.bipedLeftArmwear.addCuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSize + 0.26F);
		this.bipedLeftArmwear.setPivot(0.0F, 0.0F, 0.0F);
		this.bipedRightArmwear = new ModelPart(this, 40, 32);
		this.bipedRightArmwear.addCuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSize + 0.26F);
		this.bipedRightArmwear.setPivot(0.0F, 0.0F, 0.0F);
		this.leftLeg = new ModelPart(this, 16, 48);
		this.leftLeg.addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSize + 0.01F);
		this.leftLeg.setPivot(1.9F, 12.0F, 0.0F);
		this.bipedLeftLegwear = new ModelPart(this, 0, 48);
		this.bipedLeftLegwear.addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSize + 0.26F);
		this.bipedLeftLegwear.setPivot(0.0F, 0.0F, 0.0F);
		this.rightLeg = new ModelPart(this).setTextureOffset(0, 16);
		this.rightLeg.setPivot(-1.899999976158142F, 12.0F, 0.0F);
		this.rightLeg.addCuboid(-2.0F, 0.0F, -2.0F, 4, 12, 4, modelSize + 0.01F);
		this.bipedRightLegwear = new ModelPart(this, 0, 32);
		this.bipedRightLegwear.addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSize + 0.26F);
		this.bipedRightLegwear.setPivot(0.0F, 0.0F, 0.0F);
		this.head = new ModelPart(this).setTextureOffset(0, 0);
		this.head.setPivot(0.0F, 0.0F, 0.0F);
		this.head.addCuboid(-4.0F, -8.0F, -4.0F, 8, 8, 8, modelSize + 0.01F);
		this.torso = new ModelPart(this).setTextureOffset(16, 16);
		this.torso.setPivot(0.0F, 0.0F, 0.0F);
		this.torso.addCuboid(-4.0F, 0.0F, -2.0F, 8, 12, 4, modelSize + 0.01F);
		this.torsoWear = new ModelPart(this, 16, 32);
		this.torsoWear.addCuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, modelSize + 0.26F);
		this.torsoWear.setPivot(0.0F, 0.0F, 0.0F);
		this.helmet = new ModelPart(this).setTextureOffset(32, 0);
		this.helmet.setPivot(0.0F, 0.0F, 0.0F);
		this.helmet.addCuboid(-4.0F, -8.0F, -4.0F, 8, 8, 8, modelSize + 0.26F);
		// this.helmet.addChild(helmet);
		this.torso.addChild(torsoWear);
		this.leftArm.addChild(bipedLeftArmwear);
		this.rightArm.addChild(bipedRightArmwear);
		this.leftLeg.addChild(bipedLeftLegwear);
		this.rightLeg.addChild(bipedRightLegwear);
	}

	protected Iterable<ModelPart> getBodyParts() {
		return ImmutableList.of(this.leftLeg, this.rightLeg, this.leftArm, this.rightArm, this.torso, this.helmet);
	}

	public void setRotateAngle(ModelPart ModelPart, float x, float y, float z) {
		ModelPart.pivotX = x;
		ModelPart.pivotY = y;
		ModelPart.pivotZ = z;
	}

	@Override
	public void setVisible(boolean visible) {
		this.head.visible = false;
		this.helmet.visible = false;
		this.torso.visible = false;
		this.rightArm.visible = false;
		this.leftArm.visible = false;
		this.rightLeg.visible = false;
		this.leftLeg.visible = false;
	}

	@SuppressWarnings("incomplete-switch")
	@Override
	public void setAngles(T livingEntity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

		boolean flag = livingEntity.getRoll() > 4;
		boolean flag1 = livingEntity.isInSwimmingPose();
		this.head.pivotY = netHeadYaw * ((float) Math.PI / 180F);
		this.helmet.pivotY = netHeadYaw * ((float) Math.PI / 180F);
		this.head.pivotX = headPitch * ((float) Math.PI / 180F);
		this.helmet.pivotX = headPitch * ((float) Math.PI / 180F);

		if (flag) {
			this.head.pivotX = (-(float) Math.PI / 4F);
		} else if (this.leaningPitch > 0.0F) {
			if (flag1) {
				this.head.pivotX = this.lerpAngle(this.head.pivotX, (-(float) Math.PI / 4F), this.leaningPitch);
				this.head.pivotX = this.lerpAngle(this.head.pivotX, (-(float) Math.PI / 4F), this.leaningPitch);
				this.helmet.pivotX = this.lerpAngle(this.head.pivotX, (-(float) Math.PI / 4F), this.leaningPitch);
			} else {
				this.head.pivotX = this.lerpAngle(this.head.pivotX, headPitch * ((float) Math.PI / 180F),
						this.leaningPitch);
				this.head.pivotX = this.lerpAngle(this.head.pivotX, headPitch * ((float) Math.PI / 180F),
						this.leaningPitch);
				this.helmet.pivotX = this.lerpAngle(this.head.pivotX, headPitch * ((float) Math.PI / 180F),
						this.leaningPitch);
			}
		} else {
			this.head.pivotX = headPitch * ((float) Math.PI / 180F);
		}

		this.torso.pivotY = 0.0F;
		this.rightArm.pivotZ = 0.0F;
		this.rightArm.pivotX = -5.0F;
		this.leftArm.pivotZ = 0.0F;
		this.leftArm.pivotX = 5.0F;
		float f = 1.0F;
		if (flag) {
			f = (float) livingEntity.getVelocity().lengthSquared();
			f = f / 0.2F;
			f = f * f * f;
		}

		if (f < 1.0F) {
			f = 1.0F;
		}

		this.rightArm.pivotX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 2.0F * limbSwingAmount * 0.5F
				/ f;
		this.leftArm.pivotX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f;
		this.rightArm.pivotZ = 0.0F;
		this.leftArm.pivotZ = 0.0F;
		this.rightLeg.pivotX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
		this.leftLeg.pivotX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount / f;
		this.rightLeg.pivotY = 0.0F;
		this.leftLeg.pivotY = 0.0F;
		this.rightLeg.pivotZ = 0.0F;
		this.leftLeg.pivotZ = 0.0F;
		if (this.riding) {
			this.rightArm.pivotX += (-(float) Math.PI / 5F);
			this.leftArm.pivotX += (-(float) Math.PI / 5F);
			this.rightLeg.pivotX = -1.4137167F;
			this.rightLeg.pivotY = ((float) Math.PI / 10F);
			this.rightLeg.pivotZ = 0.07853982F;
			this.leftLeg.pivotX = -1.4137167F;
			this.leftLeg.pivotY = (-(float) Math.PI / 10F);
			this.leftLeg.pivotZ = -0.07853982F;
		}

		this.rightArm.pivotY = 0.0F;
		this.rightArm.pivotZ = 0.0F;
		switch (this.leftArmPose) {
		case EMPTY:
			this.leftArm.pivotY = 0.0F;
			break;
		case BLOCK:
			this.leftArm.pivotX = this.leftArm.pivotX * 0.5F - 0.9424779F;
			this.leftArm.pivotY = ((float) Math.PI / 6F);
			break;
		case ITEM:
			this.leftArm.pivotX = this.leftArm.pivotX * 0.5F - ((float) Math.PI / 10F);
			this.leftArm.pivotY = 0.0F;
		}

		switch (this.rightArmPose) {
		case EMPTY:
			this.rightArm.pivotY = 0.0F;
			break;
		case BLOCK:
			this.rightArm.pivotX = this.rightArm.pivotX * 0.5F - 0.9424779F;
			this.rightArm.pivotY = (-(float) Math.PI / 6F);
			break;
		case ITEM:
			this.rightArm.pivotX = this.rightArm.pivotX * 0.5F - ((float) Math.PI / 10F);
			this.rightArm.pivotY = 0.0F;
			break;
		case THROW_SPEAR:
			this.rightArm.pivotX = this.rightArm.pivotX * 0.5F - (float) Math.PI;
			this.rightArm.pivotY = 0.0F;
		}

		if (this.leftArmPose == BipedEntityModel.ArmPose.THROW_SPEAR
				&& this.rightArmPose != BipedEntityModel.ArmPose.BLOCK
				&& this.rightArmPose != BipedEntityModel.ArmPose.THROW_SPEAR
				&& this.rightArmPose != BipedEntityModel.ArmPose.BOW_AND_ARROW) {
			this.leftArm.pivotX = this.leftArm.pivotX * 0.5F - (float) Math.PI;
			this.leftArm.pivotY = 0.0F;
		}

		if (this.handSwingProgress > 0.0F) {
			float f1 = this.handSwingProgress;
			this.torso.pivotY = MathHelper.sin(MathHelper.sqrt(f1) * ((float) Math.PI * 2F)) * 0.2F;
			this.torso.pivotY *= -1.0F;

			this.rightArm.pivotZ = MathHelper.sin(this.torso.pivotY) * 5.0F;
			this.rightArm.pivotX = -MathHelper.cos(this.torso.pivotY) * 5.0F;
			this.leftArm.pivotZ = -MathHelper.sin(this.torso.pivotY) * 5.0F;
			this.leftArm.pivotX = MathHelper.cos(this.torso.pivotY) * 5.0F;
			this.rightArm.pivotY += this.torso.pivotY;
			this.leftArm.pivotY += this.torso.pivotY;
			this.leftArm.pivotX += this.torso.pivotY;
			f1 = 1.0F - this.handSwingProgress;
			f1 = f1 * f1;
			f1 = f1 * f1;
			f1 = 1.0F - f1;
		}

		if (this.isSneaking) {
			this.torso.pivotX = 0.5F;
			this.rightArm.pivotX += 0.4F;
			this.leftArm.pivotX += 0.4F;
			this.rightLeg.pivotZ = 4.0F;
			this.leftLeg.pivotZ = 4.0F;
			this.rightLeg.pivotY = 12.2F;
			this.leftLeg.pivotY = 12.2F;
			this.helmet.pivotY = 4.2F;
			this.helmet.pivotY = 4.2F;
			this.torso.pivotY = 3.2F;
			this.torsoWear.pivotY = 3.2F;
			this.leftArm.pivotY = 5.2F;
			this.rightArm.pivotY = 5.2F;
		} else {
			this.torso.pivotX = 0.0F;
			this.rightLeg.pivotZ = 0.1F;
			this.leftLeg.pivotZ = 0.1F;
			this.rightLeg.pivotY = 12.0F;
			this.leftLeg.pivotY = 12.0F;
			this.helmet.pivotY = 0.0F;
			this.torso.pivotY = 0.0F;
			this.leftArm.pivotY = 2.0F;
			this.rightArm.pivotY = 2.0F;
		}

		this.rightArm.pivotZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.leftArm.pivotZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.rightArm.pivotX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		this.leftArm.pivotX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		if (this.rightArmPose == BipedEntityModel.ArmPose.BOW_AND_ARROW) {
			this.rightArm.pivotY = -0.1F + this.helmet.pivotY;
			this.leftArm.pivotY = 0.1F + this.helmet.pivotY + 0.4F;
			this.rightArm.pivotX = (-(float) Math.PI / 2F) + this.helmet.pivotX;
			this.leftArm.pivotX = (-(float) Math.PI / 2F) + this.helmet.pivotX;
		} else if (this.leftArmPose == BipedEntityModel.ArmPose.BOW_AND_ARROW
				&& this.rightArmPose != BipedEntityModel.ArmPose.THROW_SPEAR
				&& this.rightArmPose != BipedEntityModel.ArmPose.BLOCK) {
			this.rightArm.pivotY = -0.1F + this.helmet.pivotY - 0.4F;
			this.leftArm.pivotY = 0.1F + this.helmet.pivotY;
			this.rightArm.pivotX = (-(float) Math.PI / 2F) + this.helmet.pivotX;
			this.leftArm.pivotX = (-(float) Math.PI / 2F) + this.helmet.pivotX;
		}

		if (this.rightArmPose == BipedEntityModel.ArmPose.CROSSBOW_HOLD && this.handSwingProgress <= 0.0F) {
			this.rightArm.pivotY = -0.3F + this.helmet.pivotY;
			this.leftArm.pivotY = 0.6F + this.helmet.pivotY;
			this.rightArm.pivotX = (-(float) Math.PI / 2F) + this.helmet.pivotX + 0.1F;
			this.leftArm.pivotX = -1.5F + this.helmet.pivotX;
		} else if (this.leftArmPose == BipedEntityModel.ArmPose.CROSSBOW_HOLD) {
			this.rightArm.pivotY = -0.6F + this.helmet.pivotY;
			this.leftArm.pivotY = 0.3F + this.helmet.pivotY;
			this.rightArm.pivotX = -1.5F + this.helmet.pivotX;
			this.leftArm.pivotX = (-(float) Math.PI / 2F) + this.helmet.pivotX + 0.1F;
		}

		if (this.leaningPitch > 0.0F) {
			float f7 = limbSwing % 26.0F;
			float f8 = this.handSwingProgress > 0.0F ? 0.0F : this.leaningPitch;
			if (f7 < 14.0F) {
				this.leftArm.pivotX = this.lerpAngle(this.leftArm.pivotX, 0.0F, this.leaningPitch);
				this.rightArm.pivotX = MathHelper.lerp(f8, this.rightArm.pivotX, 0.0F);
				this.leftArm.pivotY = this.lerpAngle(this.leftArm.pivotY, (float) Math.PI, this.leaningPitch);
				this.rightArm.pivotY = MathHelper.lerp(f8, this.rightArm.pivotY, (float) Math.PI);
				this.leftArm.pivotZ = this.lerpAngle(this.leftArm.pivotZ,
						(float) Math.PI + 1.8707964F * this.getArmAngleSq(f7) / this.getArmAngleSq(14.0F),
						this.leaningPitch);
				this.rightArm.pivotZ = MathHelper.lerp(f8, this.rightArm.pivotZ,
						(float) Math.PI - 1.8707964F * this.getArmAngleSq(f7) / this.getArmAngleSq(14.0F));
			} else if (f7 >= 14.0F && f7 < 22.0F) {
				float f10 = (f7 - 14.0F) / 8.0F;
				this.leftArm.pivotX = this.lerpAngle(this.leftArm.pivotX, ((float) Math.PI / 2F) * f10,
						this.leaningPitch);
				this.rightArm.pivotX = MathHelper.lerp(f8, this.rightArm.pivotX, ((float) Math.PI / 2F) * f10);
				this.leftArm.pivotY = this.lerpAngle(this.leftArm.pivotY, (float) Math.PI, this.leaningPitch);
				this.rightArm.pivotY = MathHelper.lerp(f8, this.rightArm.pivotY, (float) Math.PI);
				this.leftArm.pivotZ = this.lerpAngle(this.leftArm.pivotZ, 5.012389F - 1.8707964F * f10,
						this.leaningPitch);
				this.rightArm.pivotZ = MathHelper.lerp(f8, this.rightArm.pivotZ, 1.2707963F + 1.8707964F * f10);
			} else if (f7 >= 22.0F && f7 < 26.0F) {
				float f9 = (f7 - 22.0F) / 4.0F;
				this.leftArm.pivotX = this.lerpAngle(this.leftArm.pivotX,
						((float) Math.PI / 2F) - ((float) Math.PI / 2F) * f9, this.leaningPitch);
				this.rightArm.pivotX = MathHelper.lerp(f8, this.rightArm.pivotX,
						((float) Math.PI / 2F) - ((float) Math.PI / 2F) * f9);
				this.leftArm.pivotY = this.lerpAngle(this.leftArm.pivotY, (float) Math.PI, this.leaningPitch);
				this.rightArm.pivotY = MathHelper.lerp(f8, this.rightArm.pivotY, (float) Math.PI);
				this.leftArm.pivotZ = this.lerpAngle(this.leftArm.pivotZ, (float) Math.PI, this.leaningPitch);
				this.rightArm.pivotZ = MathHelper.lerp(f8, this.rightArm.pivotZ, (float) Math.PI);
			}

			@SuppressWarnings("unused")
			float f11 = 0.3F;
			@SuppressWarnings("unused")
			float f12 = 0.33333334F;
			this.leftLeg.pivotX = MathHelper.lerp(this.leaningPitch, this.leftLeg.pivotX,
					0.3F * MathHelper.cos(limbSwing * 0.33333334F + (float) Math.PI));
			this.rightLeg.pivotX = MathHelper.lerp(this.leaningPitch, this.rightLeg.pivotX,
					0.3F * MathHelper.cos(limbSwing * 0.33333334F));
		}

		if (livingEntity instanceof ArmorStandEntity) {
			// netHeadYaw = 0;
			ArmorStandEntity entityarmorstand = (ArmorStandEntity) livingEntity;
			this.helmet.pivotX = 0.0F * entityarmorstand.getHeadRotation().getRoll();
			this.helmet.pivotX = 0.0F * entityarmorstand.getHeadRotation().getPitch();
			this.helmet.pivotX = 0.0F * entityarmorstand.getHeadRotation().getYaw();

			this.leftArm.pivotX = 0.0F * entityarmorstand.getLeftArmRotation().getRoll();
			this.leftArm.pivotY = 0.0F * entityarmorstand.getLeftArmRotation().getPitch();
			this.leftArm.pivotZ = 0.0F * entityarmorstand.getLeftArmRotation().getYaw();

			this.rightArm.pivotX = 0.0F * entityarmorstand.getRightArmRotation().getRoll();
			this.rightArm.pivotY = 0.0F * entityarmorstand.getRightArmRotation().getPitch();
			this.rightArm.pivotZ = 0.0F * entityarmorstand.getRightArmRotation().getYaw();

			this.leftLeg.pivotX = 0.017453292F * entityarmorstand.getLeftLegRotation().getRoll();
			this.leftLeg.pivotY = 0.017453292F * entityarmorstand.getLeftLegRotation().getPitch();
			this.leftLeg.pivotZ = 0.017453292F * entityarmorstand.getLeftLegRotation().getYaw();
			this.leftLeg.setPivot(1.9F, 11.0F, 0.0F);

			this.rightLeg.pivotX = 0.017453292F * entityarmorstand.getRightLegRotation().getRoll();
			this.rightLeg.pivotY = 0.017453292F * entityarmorstand.getRightLegRotation().getPitch();
			this.rightLeg.pivotZ = 0.017453292F * entityarmorstand.getRightLegRotation().getYaw();
			this.rightLeg.setPivot(-1.9F, 11.0F, 0.0F);

		}

		float f4 = (float) CrossbowItem.getPullTime(livingEntity.getActiveItem());
		if (this.rightArmPose == BipedEntityModel.ArmPose.CROSSBOW_CHARGE) {
			this.rightArm.pivotY = -0.8F;
			this.rightArm.pivotX = -0.97079635F;
			this.leftArm.pivotX = -0.97079635F;
			float f5 = MathHelper.clamp(this.remainingItemUseTime, 0.0F, f4);
			this.leftArm.pivotY = MathHelper.lerp(f5 / f4, 0.4F, 0.85F);
			this.leftArm.pivotX = MathHelper.lerp(f5 / f4, this.leftArm.pivotX, (-(float) Math.PI / 2F));
		} else if (this.leftArmPose == BipedEntityModel.ArmPose.CROSSBOW_CHARGE) {
			this.leftArm.pivotY = 0.8F;
			this.rightArm.pivotX = -0.97079635F;
			this.leftArm.pivotX = -0.97079635F;
			float f6 = MathHelper.clamp(this.remainingItemUseTime, 0.0F, f4);
			this.rightArm.pivotY = MathHelper.lerp(f6 / f4, -0.4F, -0.85F);
			this.rightArm.pivotX = MathHelper.lerp(f6 / f4, this.rightArm.pivotX, (-(float) Math.PI / 2F));
		}

		helmet.pivotY = helmet.pivotY;
		helmet.visible = false;
		torso.visible = false;
		leftArm.visible = false;
		rightArm.visible = false;
		leftLeg.visible = false;
		rightLeg.visible = false;

	}

	private float getArmAngleSq(float limbSwing) {
		return -65.0F * limbSwing + limbSwing * limbSwing;
	}

	protected ModelPart getArmForSide(Hand side) {
		return side == Hand.OFF_HAND ? this.leftArm : this.rightArm;
	}
}