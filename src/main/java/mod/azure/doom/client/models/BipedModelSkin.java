package mod.azure.doom.client.models;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.item.CrossbowItem;
import net.minecraft.util.Arm;
import net.minecraft.util.math.MathHelper;

//Created by Marctron
public class BipedModelSkin<T extends LivingEntity> extends BipedEntityModel<T> {

	public final ModelPart leftArmwear;
	public final ModelPart rightArmwear;
	public final ModelPart leftLegwear;
	public final ModelPart rightLegwear;
	public final ModelPart torsoWear;

	private float remainingItemUseTime;

	public BipedModelSkin(float modelSize) {
		super(modelSize, 0.0F, 64, 64);
		this.leftArmwear = new ModelPart(this, 48, 48);
		this.leftArmwear.addCuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSize + 0.26F);
		this.leftArmwear.setPivot(0.0F, 0.0F, 0.0F);
		this.rightArmwear = new ModelPart(this, 40, 32);
		this.rightArmwear.addCuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSize + 0.26F);
		this.rightArmwear.setPivot(0.0F, 0.0F, 0.0F);
		this.leftLeg = new ModelPart(this, 16, 48);
		this.leftLeg.addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSize + 0.01F);
		this.leftLeg.setPivot(1.9F, 12.0F, 0.0F);
		this.leftLegwear = new ModelPart(this, 0, 48);
		this.leftLegwear.addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSize + 0.26F);
		this.leftLegwear.setPivot(0.0F, 0.0F, 0.0F);
		this.rightLeg = new ModelPart(this).setTextureOffset(0, 16);
		this.rightLeg.setPivot(-1.899999976158142F, 12.0F, 0.0F);
		this.rightLeg.addCuboid(-2.0F, 0.0F, -2.0F, 4, 12, 4, modelSize + 0.01F);
		this.rightLegwear = new ModelPart(this, 0, 32);
		this.rightLegwear.addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSize + 0.26F);
		this.rightLegwear.setPivot(0.0F, 0.0F, 0.0F);
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
		// this.head.addChild(helmet);
		this.torso.addChild(torsoWear);
		this.leftArm.addChild(leftArmwear);
		this.rightArm.addChild(rightArmwear);
		this.leftLeg.addChild(leftLegwear);
		this.rightLeg.addChild(rightLegwear);
	}

	protected Iterable<ModelPart> getBodyParts() {
		return ImmutableList.of(this.leftLeg, this.rightLeg, this.leftArm, this.rightArm, this.torso, this.helmet);
	}

	public void setRotateAngle(ModelPart ModelPart, float x, float y, float z) {
		ModelPart.pitch = x;
		ModelPart.yaw = y;
		ModelPart.roll = z;
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
	public void setAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

		boolean flag = entityIn.getRoll() > 4;
		boolean flag1 = entityIn.isSwimming();
		this.head.yaw = netHeadYaw * ((float) Math.PI / 180F);
		this.helmet.yaw = netHeadYaw * ((float) Math.PI / 180F);
		this.head.pitch = headPitch * ((float) Math.PI / 180F);
		this.helmet.pitch = headPitch * ((float) Math.PI / 180F);

		if (flag) {
			this.head.pitch = (-(float) Math.PI / 4F);
		} else if (this.leaningPitch > 0.0F) {
			if (flag1) {
				this.head.pitch = this.lerpAngle(this.head.pitch, (-(float) Math.PI / 4F), this.leaningPitch);
				this.head.pitch = this.lerpAngle(this.head.pitch, (-(float) Math.PI / 4F), this.leaningPitch);
				this.helmet.pitch = this.lerpAngle(this.head.pitch, (-(float) Math.PI / 4F), this.leaningPitch);
			} else {
				this.head.pitch = this.lerpAngle(this.head.pitch, headPitch * ((float) Math.PI / 180F),
						this.leaningPitch);
				this.head.pitch = this.lerpAngle(this.head.pitch, headPitch * ((float) Math.PI / 180F),
						this.leaningPitch);
				this.helmet.pitch = this.lerpAngle(this.head.pitch, headPitch * ((float) Math.PI / 180F),
						this.leaningPitch);
			}
		} else {
			this.head.pitch = headPitch * ((float) Math.PI / 180F);
		}

		this.torso.yaw = 0.0F;
		this.rightArm.pivotZ = 0.0F;
		this.rightArm.pivotX = -5.0F;
		this.leftArm.pivotZ = 0.0F;
		this.leftArm.pivotX = 5.0F;
		float f = 1.0F;
		if (flag) {
			f = (float) entityIn.getVelocity().lengthSquared();
			f = f / 0.2F;
			f = f * f * f;
		}

		if (f < 1.0F) {
			f = 1.0F;
		}

		this.rightArm.pitch = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 2.0F * limbSwingAmount * 0.5F / f;
		this.leftArm.pitch = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f;
		this.rightArm.roll = 0.0F;
		this.leftArm.roll = 0.0F;
		this.rightLeg.pitch = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
		this.leftLeg.pitch = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount / f;
		this.rightLeg.yaw = 0.0F;
		this.leftLeg.yaw = 0.0F;
		this.rightLeg.roll = 0.0F;
		this.leftLeg.roll = 0.0F;
		if (this.riding) {
			this.rightArm.pitch += (-(float) Math.PI / 5F);
			this.leftArm.pitch += (-(float) Math.PI / 5F);
			this.rightLeg.pitch = -1.4137167F;
			this.rightLeg.yaw = ((float) Math.PI / 10F);
			this.rightLeg.roll = 0.07853982F;
			this.leftLeg.pitch = -1.4137167F;
			this.leftLeg.yaw = (-(float) Math.PI / 10F);
			this.leftLeg.roll = -0.07853982F;
		}

		this.rightArm.yaw = 0.0F;
		this.rightArm.roll = 0.0F;
		switch (this.leftArmPose) {
		case EMPTY:
			this.leftArm.yaw = 0.0F;
			break;
		case BLOCK:
			this.leftArm.pitch = this.leftArm.pitch * 0.5F - 0.9424779F;
			this.leftArm.yaw = ((float) Math.PI / 6F);
			break;
		case ITEM:
			this.leftArm.pitch = this.leftArm.pitch * 0.5F - ((float) Math.PI / 10F);
			this.leftArm.yaw = 0.0F;
		}

		switch (this.rightArmPose) {
		case EMPTY:
			this.rightArm.yaw = 0.0F;
			break;
		case BLOCK:
			this.rightArm.pitch = this.rightArm.pitch * 0.5F - 0.9424779F;
			this.rightArm.yaw = (-(float) Math.PI / 6F);
			break;
		case ITEM:
			this.rightArm.pitch = this.rightArm.pitch * 0.5F - ((float) Math.PI / 10F);
			this.rightArm.yaw = 0.0F;
			break;
		case THROW_SPEAR:
			this.rightArm.pitch = this.rightArm.pitch * 0.5F - (float) Math.PI;
			this.rightArm.yaw = 0.0F;
		}

		if (this.leftArmPose == BipedEntityModel.ArmPose.THROW_SPEAR
				&& this.rightArmPose != BipedEntityModel.ArmPose.BLOCK
				&& this.rightArmPose != BipedEntityModel.ArmPose.THROW_SPEAR
				&& this.rightArmPose != BipedEntityModel.ArmPose.BOW_AND_ARROW) {
			this.leftArm.pitch = this.leftArm.pitch * 0.5F - (float) Math.PI;
			this.leftArm.yaw = 0.0F;
		}

		if (this.handSwingProgress > 0.0F) {
			Arm Arm = this.getPreferredArm(entityIn);
			ModelPart ModelPart = this.getArmForSide(Arm);
			float f1 = this.handSwingProgress;
			this.torso.yaw = MathHelper.sin(MathHelper.sqrt(f1) * ((float) Math.PI * 2F)) * 0.2F;
			if (Arm == net.minecraft.util.Arm.LEFT) {
				this.torso.yaw *= -1.0F;
			}

			this.rightArm.pivotZ = MathHelper.sin(this.torso.yaw) * 5.0F;
			this.rightArm.pivotX = -MathHelper.cos(this.torso.yaw) * 5.0F;
			this.leftArm.pivotZ = -MathHelper.sin(this.torso.yaw) * 5.0F;
			this.leftArm.pivotX = MathHelper.cos(this.torso.yaw) * 5.0F;
			this.rightArm.yaw += this.torso.yaw;
			this.leftArm.yaw += this.torso.yaw;
			this.leftArm.pitch += this.torso.yaw;
			f1 = 1.0F - this.handSwingProgress;
			f1 = f1 * f1;
			f1 = f1 * f1;
			f1 = 1.0F - f1;
			float f2 = MathHelper.sin(f1 * (float) Math.PI);
			float f3 = MathHelper.sin(this.handSwingProgress * (float) Math.PI) * -(this.head.pitch - 0.7F) * 0.75F;
			ModelPart.pitch = (float) ((double) ModelPart.pitch - ((double) f2 * 1.2D + (double) f3));
			ModelPart.yaw += this.torso.yaw * 2.0F;
			ModelPart.roll += MathHelper.sin(this.handSwingProgress * (float) Math.PI) * -0.4F;
		}

		if (this.sneaking) {
			this.torso.pitch = 0.5F;
			this.rightArm.pitch += 0.4F;
			this.leftArm.pitch += 0.4F;
			this.rightLeg.pivotZ = 4.0F;
			this.leftLeg.pivotZ = 4.0F;
			this.rightLeg.pivotY = 12.2F;
			this.leftLeg.pivotY = 12.2F;
			this.head.pivotY = 4.2F;
			this.helmet.pivotY = 4.2F;
			this.torso.pivotY = 3.2F;
			this.torsoWear.pivotY = 3.2F;
			this.leftArm.pivotY = 5.2F;
			this.rightArm.pivotY = 5.2F;
		} else {
			this.torso.pitch = 0.0F;
			this.rightLeg.pivotZ = 0.1F;
			this.leftLeg.pivotZ = 0.1F;
			this.rightLeg.pivotY = 12.0F;
			this.leftLeg.pivotY = 12.0F;
			this.head.pivotY = 0.0F;
			this.torso.pivotY = 0.0F;
			this.leftArm.pivotY = 2.0F;
			this.rightArm.pivotY = 2.0F;
		}

		this.rightArm.roll += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.leftArm.roll -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.rightArm.pitch += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		this.leftArm.pitch -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		if (this.rightArmPose == BipedEntityModel.ArmPose.BOW_AND_ARROW) {
			this.rightArm.yaw = -0.1F + this.head.yaw;
			this.leftArm.yaw = 0.1F + this.head.yaw + 0.4F;
			this.rightArm.pitch = (-(float) Math.PI / 2F) + this.head.pitch;
			this.leftArm.pitch = (-(float) Math.PI / 2F) + this.head.pitch;
		} else if (this.leftArmPose == BipedEntityModel.ArmPose.BOW_AND_ARROW
				&& this.rightArmPose != BipedEntityModel.ArmPose.THROW_SPEAR
				&& this.rightArmPose != BipedEntityModel.ArmPose.BLOCK) {
			this.rightArm.yaw = -0.1F + this.head.yaw - 0.4F;
			this.leftArm.yaw = 0.1F + this.head.yaw;
			this.rightArm.pitch = (-(float) Math.PI / 2F) + this.head.pitch;
			this.leftArm.pitch = (-(float) Math.PI / 2F) + this.head.pitch;
		}

		if (this.rightArmPose == BipedEntityModel.ArmPose.CROSSBOW_HOLD && this.handSwingProgress <= 0.0F) {
			this.rightArm.yaw = -0.3F + this.head.yaw;
			this.leftArm.yaw = 0.6F + this.head.yaw;
			this.rightArm.pitch = (-(float) Math.PI / 2F) + this.head.pitch + 0.1F;
			this.leftArm.pitch = -1.5F + this.head.pitch;
		} else if (this.leftArmPose == BipedEntityModel.ArmPose.CROSSBOW_HOLD) {
			this.rightArm.yaw = -0.6F + this.head.yaw;
			this.leftArm.yaw = 0.3F + this.head.yaw;
			this.rightArm.pitch = -1.5F + this.head.pitch;
			this.leftArm.pitch = (-(float) Math.PI / 2F) + this.head.pitch + 0.1F;
		}

		if (this.leaningPitch > 0.0F) {
			float f7 = limbSwing % 26.0F;
			float f8 = this.handSwingProgress > 0.0F ? 0.0F : this.leaningPitch;
			if (f7 < 14.0F) {
				this.leftArm.pitch = this.lerpAngle(this.leftArm.pitch, 0.0F, this.leaningPitch);
				this.rightArm.pitch = MathHelper.lerp(f8, this.rightArm.pitch, 0.0F);
				this.leftArm.yaw = this.lerpAngle(this.leftArm.yaw, (float) Math.PI, this.leaningPitch);
				this.rightArm.yaw = MathHelper.lerp(f8, this.rightArm.yaw, (float) Math.PI);
				this.leftArm.roll = this.lerpAngle(this.leftArm.roll,
						(float) Math.PI + 1.8707964F * this.getArmAngleSq(f7) / this.getArmAngleSq(14.0F),
						this.leaningPitch);
				this.rightArm.roll = MathHelper.lerp(f8, this.rightArm.roll,
						(float) Math.PI - 1.8707964F * this.getArmAngleSq(f7) / this.getArmAngleSq(14.0F));
			} else if (f7 >= 14.0F && f7 < 22.0F) {
				float f10 = (f7 - 14.0F) / 8.0F;
				this.leftArm.pitch = this.lerpAngle(this.leftArm.pitch, ((float) Math.PI / 2F) * f10,
						this.leaningPitch);
				this.rightArm.pitch = MathHelper.lerp(f8, this.rightArm.pitch, ((float) Math.PI / 2F) * f10);
				this.leftArm.yaw = this.lerpAngle(this.leftArm.yaw, (float) Math.PI, this.leaningPitch);
				this.rightArm.yaw = MathHelper.lerp(f8, this.rightArm.yaw, (float) Math.PI);
				this.leftArm.roll = this.lerpAngle(this.leftArm.roll, 5.012389F - 1.8707964F * f10, this.leaningPitch);
				this.rightArm.roll = MathHelper.lerp(f8, this.rightArm.roll, 1.2707963F + 1.8707964F * f10);
			} else if (f7 >= 22.0F && f7 < 26.0F) {
				float f9 = (f7 - 22.0F) / 4.0F;
				this.leftArm.pitch = this.lerpAngle(this.leftArm.pitch,
						((float) Math.PI / 2F) - ((float) Math.PI / 2F) * f9, this.leaningPitch);
				this.rightArm.pitch = MathHelper.lerp(f8, this.rightArm.pitch,
						((float) Math.PI / 2F) - ((float) Math.PI / 2F) * f9);
				this.leftArm.yaw = this.lerpAngle(this.leftArm.yaw, (float) Math.PI, this.leaningPitch);
				this.rightArm.yaw = MathHelper.lerp(f8, this.rightArm.yaw, (float) Math.PI);
				this.leftArm.roll = this.lerpAngle(this.leftArm.roll, (float) Math.PI, this.leaningPitch);
				this.rightArm.roll = MathHelper.lerp(f8, this.rightArm.roll, (float) Math.PI);
			}

			@SuppressWarnings("unused")
			float f11 = 0.3F;
			@SuppressWarnings("unused")
			float f12 = 0.33333334F;
			this.leftLeg.pitch = MathHelper.lerp(this.leaningPitch, this.leftLeg.pitch,
					0.3F * MathHelper.cos(limbSwing * 0.33333334F + (float) Math.PI));
			this.rightLeg.pitch = MathHelper.lerp(this.leaningPitch, this.rightLeg.pitch,
					0.3F * MathHelper.cos(limbSwing * 0.33333334F));
		}

		if (entityIn instanceof ArmorStandEntity) {
			// netHeadYaw = 0;
			ArmorStandEntity entityarmorstand = (ArmorStandEntity) entityIn;
			this.head.pitch = 0.0F * entityarmorstand.getHeadRotation().getPitch();
			this.head.pitch = 0.0F * entityarmorstand.getHeadRotation().getYaw();
			this.head.pitch = 0.0F * entityarmorstand.getHeadRotation().getRoll();

			this.leftArm.pitch = 0.0F * entityarmorstand.getLeftArmRotation().getPitch();
			this.leftArm.yaw = 0.0F * entityarmorstand.getLeftArmRotation().getYaw();
			this.leftArm.roll = 0.0F * entityarmorstand.getLeftArmRotation().getRoll();

			this.rightArm.pitch = 0.0F * entityarmorstand.getRightArmRotation().getPitch();
			this.rightArm.yaw = 0.0F * entityarmorstand.getRightArmRotation().getYaw();
			this.rightArm.roll = 0.0F * entityarmorstand.getRightArmRotation().getRoll();

			this.leftLeg.pitch = 0.017453292F * entityarmorstand.getLeftLegRotation().getPitch();
			this.leftLeg.yaw = 0.017453292F * entityarmorstand.getLeftLegRotation().getYaw();
			this.leftLeg.roll = 0.017453292F * entityarmorstand.getLeftLegRotation().getRoll();
			this.leftLeg.setPivot(1.9F, 11.0F, 0.0F);

			this.rightLeg.pitch = 0.017453292F * entityarmorstand.getRightLegRotation().getPitch();
			this.rightLeg.yaw = 0.017453292F * entityarmorstand.getRightLegRotation().getYaw();
			this.rightLeg.roll = 0.017453292F * entityarmorstand.getRightLegRotation().getRoll();
			this.rightLeg.setPivot(-1.9F, 11.0F, 0.0F);

		}

		float f4 = (float) CrossbowItem.getPullTime(entityIn.getActiveItem());
		if (this.rightArmPose == BipedEntityModel.ArmPose.CROSSBOW_CHARGE) {
			this.rightArm.yaw = -0.8F;
			this.rightArm.pitch = -0.97079635F;
			this.leftArm.pitch = -0.97079635F;
			float f5 = MathHelper.clamp(this.remainingItemUseTime, 0.0F, f4);
			this.leftArm.yaw = MathHelper.lerp(f5 / f4, 0.4F, 0.85F);
			this.leftArm.pitch = MathHelper.lerp(f5 / f4, this.leftArm.pitch, (-(float) Math.PI / 2F));
		} else if (this.leftArmPose == BipedEntityModel.ArmPose.CROSSBOW_CHARGE) {
			this.leftArm.yaw = 0.8F;
			this.rightArm.pitch = -0.97079635F;
			this.leftArm.pitch = -0.97079635F;
			float f6 = MathHelper.clamp(this.remainingItemUseTime, 0.0F, f4);
			this.rightArm.yaw = MathHelper.lerp(f6 / f4, -0.4F, -0.85F);
			this.rightArm.pitch = MathHelper.lerp(f6 / f4, this.rightArm.pitch, (-(float) Math.PI / 2F));
		}

		head.pivotY = head.pivotY;
		head.visible = false;
		torso.visible = false;
		leftArm.visible = false;
		rightArm.visible = false;
		leftLeg.visible = false;
		rightLeg.visible = false;

	}

	@Override
	public void animateModel(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		this.leaningPitch = entityIn.getLeaningPitch(partialTick);
		this.remainingItemUseTime = (float) entityIn.getMaxHealth();
		super.animateModel(entityIn, limbSwing, limbSwingAmount, partialTick);
	}

	private float getArmAngleSq(float limbSwing) {
		return -65.0F * limbSwing + limbSwing * limbSwing;
	}

	protected ModelPart getArmForSide(Arm side) {
		return side == Arm.LEFT ? this.leftArm : this.rightArm;
	}
}