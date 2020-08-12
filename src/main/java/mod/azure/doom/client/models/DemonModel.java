package mod.azure.doom.client.models;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import mod.azure.doom.entity.DemonEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.CrossbowPosing;
import net.minecraft.util.Arm;
import net.minecraft.util.math.MathHelper;

public class DemonModel<T extends DemonEntity> extends BipedEntityModel<T> {
	private List<ModelPart> ModelParts = Lists.newArrayList();

	public DemonModel(float modelSize, boolean smallArmsIn) {
		super(modelSize, 0.0F, 64, 64);
		this.leftArm = new ModelPart(this, 32, 48);
		this.leftArm.addCuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSize);
		this.leftArm.setPivot(5.0F, 2.0F, 0.0F);
		this.leftLeg = new ModelPart(this, 16, 48);
		this.leftLeg.addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSize);
		this.leftLeg.setPivot(1.9F, 12.0F, 0.0F);
	}

	@SuppressWarnings("unchecked")
	protected Iterable<ModelPart> getBodyParts() {
		return Iterables.concat(super.getBodyParts());
	}

	public void setAngles(T livingEntity, float f, float g, float h, float i, float j) {
		boolean bl = livingEntity.getRoll() > 4;
		boolean bl2 = livingEntity.isInSwimmingPose();
		this.head.yaw = i * 0.017453292F;
		if (bl) {
			this.head.pitch = -0.7853982F;
		} else if (this.leaningPitch > 0.0F) {
			if (bl2) {
				this.head.pitch = this.lerpAngle(this.leaningPitch, this.head.pitch, -0.7853982F);
			} else {
				this.head.pitch = this.lerpAngle(this.leaningPitch, this.head.pitch, j * 0.017453292F);
			}
		} else {
			this.head.pitch = j * 0.017453292F;
		}

		this.torso.yaw = 0.0F;
		this.rightArm.pivotZ = 0.0F;
		this.rightArm.pivotX = -5.0F;
		this.leftArm.pivotZ = 0.0F;
		this.leftArm.pivotX = 5.0F;
		float k = 1.0F;
		if (bl) {
			k = (float) livingEntity.getVelocity().lengthSquared();
			k /= 0.2F;
			k *= k * k;
		}

		if (k < 1.0F) {
			k = 1.0F;
		}

		this.rightArm.pitch = MathHelper.cos(f * 0.6662F + 3.1415927F) * 2.0F * g * 0.5F / k;
		this.leftArm.pitch = MathHelper.cos(f * 0.6662F) * 2.0F * g * 0.5F / k;
		this.rightArm.roll = 0.0F;
		this.leftArm.roll = 0.0F;
		this.rightLeg.pitch = MathHelper.cos(f * 0.6662F) * 1.4F * g / k;
		this.leftLeg.pitch = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * g / k;
		this.rightLeg.yaw = 0.0F;
		this.leftLeg.yaw = 0.0F;
		this.rightLeg.roll = 0.0F;
		this.leftLeg.roll = 0.0F;
		ModelPart var10000;
		if (this.riding) {
			var10000 = this.rightArm;
			var10000.pitch += -0.62831855F;
			var10000 = this.leftArm;
			var10000.pitch += -0.62831855F;
			this.rightLeg.pitch = -1.4137167F;
			this.rightLeg.yaw = 0.31415927F;
			this.rightLeg.roll = 0.07853982F;
			this.leftLeg.pitch = -1.4137167F;
			this.leftLeg.yaw = -0.31415927F;
			this.leftLeg.roll = -0.07853982F;
		}

		this.rightArm.yaw = 0.0F;
		this.leftArm.yaw = 0.0F;
		boolean bl3 = livingEntity.getMainArm() == Arm.RIGHT;
		boolean bl4 = bl3 ? this.leftArmPose.method_30156() : this.rightArmPose.method_30156();
		if (bl3 != bl4) {
			this.method_30155(livingEntity);
			this.method_30154(livingEntity);
		} else {
			this.method_30154(livingEntity);
			this.method_30155(livingEntity);
		}

		this.method_29353(livingEntity, h);
		if (this.sneaking) {
			this.torso.pitch = 0.5F;
			var10000 = this.rightArm;
			var10000.pitch += 0.4F;
			var10000 = this.leftArm;
			var10000.pitch += 0.4F;
			this.rightLeg.pivotZ = 4.0F;
			this.leftLeg.pivotZ = 4.0F;
			this.rightLeg.pivotY = 12.2F;
			this.leftLeg.pivotY = 12.2F;
			this.head.pivotY = 4.2F;
			this.torso.pivotY = 3.2F;
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

		CrossbowPosing.method_29350(this.rightArm, this.leftArm, h);
		if (this.leaningPitch > 0.0F) {
			float l = f % 26.0F;
			Arm arm = this.getPreferredArm(livingEntity);
			float m = arm == Arm.RIGHT && this.handSwingProgress > 0.0F ? 0.0F : this.leaningPitch;
			float n = arm == Arm.LEFT && this.handSwingProgress > 0.0F ? 0.0F : this.leaningPitch;
			float p;
			if (l < 14.0F) {
				this.leftArm.pitch = this.lerpAngle(n, this.leftArm.pitch, 0.0F);
				this.rightArm.pitch = MathHelper.lerp(m, this.rightArm.pitch, 0.0F);
				this.leftArm.yaw = this.lerpAngle(n, this.leftArm.yaw, 3.1415927F);
				this.rightArm.yaw = MathHelper.lerp(m, this.rightArm.yaw, 3.1415927F);
				this.leftArm.roll = this.lerpAngle(n, this.leftArm.roll,
						3.1415927F + 1.8707964F * this.method_2807(l) / this.method_2807(14.0F));
				this.rightArm.roll = MathHelper.lerp(m, this.rightArm.roll,
						3.1415927F - 1.8707964F * this.method_2807(l) / this.method_2807(14.0F));
			} else if (l >= 14.0F && l < 22.0F) {
				p = (l - 14.0F) / 8.0F;
				this.leftArm.pitch = this.lerpAngle(n, this.leftArm.pitch, 1.5707964F * p);
				this.rightArm.pitch = MathHelper.lerp(m, this.rightArm.pitch, 1.5707964F * p);
				this.leftArm.yaw = this.lerpAngle(n, this.leftArm.yaw, 3.1415927F);
				this.rightArm.yaw = MathHelper.lerp(m, this.rightArm.yaw, 3.1415927F);
				this.leftArm.roll = this.lerpAngle(n, this.leftArm.roll, 5.012389F - 1.8707964F * p);
				this.rightArm.roll = MathHelper.lerp(m, this.rightArm.roll, 1.2707963F + 1.8707964F * p);
			} else if (l >= 22.0F && l < 26.0F) {
				p = (l - 22.0F) / 4.0F;
				this.leftArm.pitch = this.lerpAngle(n, this.leftArm.pitch, 1.5707964F - 1.5707964F * p);
				this.rightArm.pitch = MathHelper.lerp(m, this.rightArm.pitch, 1.5707964F - 1.5707964F * p);
				this.leftArm.yaw = this.lerpAngle(n, this.leftArm.yaw, 3.1415927F);
				this.rightArm.yaw = MathHelper.lerp(m, this.rightArm.yaw, 3.1415927F);
				this.leftArm.roll = this.lerpAngle(n, this.leftArm.roll, 3.1415927F);
				this.rightArm.roll = MathHelper.lerp(m, this.rightArm.roll, 3.1415927F);
			}

			p = 0.3F;
			this.leftLeg.pitch = MathHelper.lerp(this.leaningPitch, this.leftLeg.pitch,
					0.3F * MathHelper.cos(f * 0.33333334F + 3.1415927F));
			this.rightLeg.pitch = MathHelper.lerp(this.leaningPitch, this.rightLeg.pitch,
					0.3F * MathHelper.cos(f * 0.33333334F));
		}

		this.helmet.copyPositionAndRotation(this.head);
	}

	private void method_30154(T livingEntity) {
		switch (this.rightArmPose) {
		case EMPTY:
			this.rightArm.yaw = 0.0F;
			break;
		case BLOCK:
			this.rightArm.pitch = this.rightArm.pitch * 0.5F - 0.9424779F;
			this.rightArm.yaw = -0.5235988F;
			break;
		case ITEM:
			this.rightArm.pitch = this.rightArm.pitch * 0.5F - 0.31415927F;
			this.rightArm.yaw = 0.0F;
			break;
		case THROW_SPEAR:
			this.rightArm.pitch = this.rightArm.pitch * 0.5F - 3.1415927F;
			this.rightArm.yaw = 0.0F;
			break;
		case BOW_AND_ARROW:
			this.rightArm.yaw = -0.1F + this.head.yaw;
			this.leftArm.yaw = 0.1F + this.head.yaw + 0.4F;
			this.rightArm.pitch = -1.5707964F + this.head.pitch;
			this.leftArm.pitch = -1.5707964F + this.head.pitch;
			break;
		case CROSSBOW_CHARGE:
			CrossbowPosing.charge(this.rightArm, this.leftArm, livingEntity, true);
			break;
		case CROSSBOW_HOLD:
			CrossbowPosing.hold(this.rightArm, this.leftArm, this.head, true);
		}

	}

	private void method_30155(T livingEntity) {
		switch (this.leftArmPose) {
		case EMPTY:
			this.leftArm.yaw = 0.0F;
			break;
		case BLOCK:
			this.leftArm.pitch = this.leftArm.pitch * 0.5F - 0.9424779F;
			this.leftArm.yaw = 0.5235988F;
			break;
		case ITEM:
			this.leftArm.pitch = this.leftArm.pitch * 0.5F - 0.31415927F;
			this.leftArm.yaw = 0.0F;
			break;
		case THROW_SPEAR:
			this.leftArm.pitch = this.leftArm.pitch * 0.5F - 3.1415927F;
			this.leftArm.yaw = 0.0F;
			break;
		case BOW_AND_ARROW:
			this.rightArm.yaw = -0.1F + this.head.yaw - 0.4F;
			this.leftArm.yaw = 0.1F + this.head.yaw;
			this.rightArm.pitch = -1.5707964F + this.head.pitch;
			this.leftArm.pitch = -1.5707964F + this.head.pitch;
			break;
		case CROSSBOW_CHARGE:
			CrossbowPosing.charge(this.rightArm, this.leftArm, livingEntity, false);
			break;
		case CROSSBOW_HOLD:
			CrossbowPosing.hold(this.rightArm, this.leftArm, this.head, false);
		}

	}

	private float method_2807(float f) {
		return -65.0F * f + f * f;
	}

	protected void method_29353(T livingEntity, float f) {
		if (this.handSwingProgress > 0.0F) {
			Arm arm = this.getPreferredArm(livingEntity);
			ModelPart modelPart = this.getArm(arm);
			float g = this.handSwingProgress;
			this.torso.yaw = MathHelper.sin(MathHelper.sqrt(g) * 6.2831855F) * 0.2F;
			ModelPart var10000;
			if (arm == Arm.LEFT) {
				var10000 = this.torso;
				var10000.yaw *= -1.0F;
			}

			this.rightArm.pivotZ = MathHelper.sin(this.torso.yaw) * 5.0F;
			this.rightArm.pivotX = -MathHelper.cos(this.torso.yaw) * 5.0F;
			this.leftArm.pivotZ = -MathHelper.sin(this.torso.yaw) * 5.0F;
			this.leftArm.pivotX = MathHelper.cos(this.torso.yaw) * 5.0F;
			var10000 = this.rightArm;
			var10000.yaw += this.torso.yaw;
			var10000 = this.leftArm;
			var10000.yaw += this.torso.yaw;
			var10000 = this.leftArm;
			var10000.pitch += this.torso.yaw;
			g = 1.0F - this.handSwingProgress;
			g *= g;
			g *= g;
			g = 1.0F - g;
			float h = MathHelper.sin(g * 3.1415927F);
			float i = MathHelper.sin(this.handSwingProgress * 3.1415927F) * -(this.head.pitch - 0.7F) * 0.75F;
			modelPart.pitch = (float) ((double) modelPart.pitch - ((double) h * 1.2D + (double) i));
			modelPart.yaw += this.torso.yaw * 2.0F;
			modelPart.roll += MathHelper.sin(this.handSwingProgress * 3.1415927F) * -0.4F;
		}
	}

	public void setVisible(boolean visible) {
		super.setVisible(visible);
	}

	public ModelPart getRandomModelPart(Random randomIn) {
		return this.ModelParts.get(randomIn.nextInt(this.ModelParts.size()));
	}

	public void accept(ModelPart p_accept_1_) {
		if (this.ModelParts == null) {
			this.ModelParts = Lists.newArrayList();
		}

		this.ModelParts.add(p_accept_1_);
	}
}