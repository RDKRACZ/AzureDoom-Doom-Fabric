package mod.azure.doom.client.models;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.CrossbowPosing;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;

public class RevenantModel<T extends MobEntity & RangedAttackMob> extends BipedEntityModel<T> {
	public RevenantModel() {
		this(0.0F, false);
	}

	public RevenantModel(float modelSize, boolean p_i46303_2_) {
		super(modelSize);
		if (!p_i46303_2_) {
			this.rightArm = new ModelPart(this, 40, 16);
			this.rightArm.addCuboid(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, modelSize);
			this.rightArm.setPivot(-5.0F, 2.0F, 0.0F);
			this.leftArm = new ModelPart(this, 40, 16);
			this.leftArm.mirror = true;
			this.leftArm.addCuboid(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, modelSize);
			this.leftArm.setPivot(5.0F, 2.0F, 0.0F);
			this.rightLeg = new ModelPart(this, 0, 16);
			this.rightLeg.addCuboid(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, modelSize);
			this.rightLeg.setPivot(-2.0F, 12.0F, 0.0F);
			this.leftLeg = new ModelPart(this, 0, 16);
			this.leftLeg.mirror = true;
			this.leftLeg.addCuboid(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, modelSize);
			this.leftLeg.setPivot(2.0F, 12.0F, 0.0F);
		}

	}

	public void animateModel(T mobEntity, float f, float g, float h) {
		this.rightArmPose = BipedEntityModel.ArmPose.EMPTY;
		this.leftArmPose = BipedEntityModel.ArmPose.EMPTY;
		ItemStack itemStack = mobEntity.getStackInHand(Hand.MAIN_HAND);
		if (itemStack.getItem() == Items.BOW && mobEntity.isAttacking()) {
			if (mobEntity.getMainArm() == Arm.RIGHT) {
				this.rightArmPose = BipedEntityModel.ArmPose.BOW_AND_ARROW;
			} else {
				this.leftArmPose = BipedEntityModel.ArmPose.BOW_AND_ARROW;
			}
		}

		super.animateModel((T) mobEntity, f, g, h);
	}

	@Override
	public void setAngles(T mobEntity, float f, float g, float h, float i, float j) {
		super.setAngles((T) mobEntity, f, g, h, i, j);
		ItemStack itemStack = mobEntity.getMainHandStack();
		if (mobEntity.isAttacking() && (itemStack.isEmpty() || itemStack.getItem() != Items.BOW)) {
			float k = MathHelper.sin(this.handSwingProgress * 3.1415927F);
			float l = MathHelper
					.sin((1.0F - (1.0F - this.handSwingProgress) * (1.0F - this.handSwingProgress)) * 3.1415927F);
			this.rightArm.roll = 0.0F;
			this.leftArm.roll = 0.0F;
			this.rightArm.yaw = -(0.1F - k * 0.6F);
			this.leftArm.yaw = 0.1F - k * 0.6F;
			this.rightArm.pitch = -1.5707964F;
			this.leftArm.pitch = -1.5707964F;
			ModelPart var10000 = this.rightArm;
			var10000.pitch -= k * 1.2F - l * 0.4F;
			var10000 = this.leftArm;
			var10000.pitch -= k * 1.2F - l * 0.4F;
			CrossbowPosing.method_29350(this.rightArm, this.leftArm, h);
		}

	}

	public void translateHand(Arm sideIn, MatrixStack matrixStackIn) {
		float f = sideIn == Arm.RIGHT ? 1.0F : -1.0F;
		ModelPart ModelPart = this.getArm(sideIn);
		ModelPart.pivotX += f;
		ModelPart.rotate(matrixStackIn);
		ModelPart.pivotX -= f;
	}
}