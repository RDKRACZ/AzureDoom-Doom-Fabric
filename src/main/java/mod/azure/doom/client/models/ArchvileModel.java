package mod.azure.doom.client.models;

import mod.azure.doom.entity.ArchvileEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.BipedEntityModel;

public class ArchvileModel<T extends ArchvileEntity> extends BipedEntityModel<T> {
	public boolean isCarrying;
	public boolean isAttacking;

	public ModelPart torso_1;

	public ArchvileModel(float scale) {
		super(0.0F, -14.0F, 64, 32);
		this.helmet = new ModelPart(this, 0, 16);
		this.helmet.addCuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, scale - 0.5F);
		this.helmet.setPivot(0.0F, -14.0F, 0.0F);
		this.torso = new ModelPart(this, 32, 16);
		this.torso.addCuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, scale);
		this.torso.setPivot(0.0F, -14.0F, 0.0F);
		this.torso_1 = new ModelPart(this, 37, 19);
		this.torso_1.setPivot(0.0F, 0.0F, 0.0F);
		this.torso_1.setTextureOffset(4, 0).addCuboid(-4.0F, 9.9F, -2.0F, 8.0F, 0.1F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.rightArm = new ModelPart(this, 56, 0);
		this.rightArm.addCuboid(-1.0F, -2.0F, -1.0F, 2.0F, 30.0F, 2.0F, scale);
		this.rightArm.setPivot(-3.0F, -12.0F, 0.0F);
		this.leftArm = new ModelPart(this, 56, 0);
		this.leftArm.mirror = true;
		this.leftArm.addCuboid(-1.0F, -2.0F, -1.0F, 2.0F, 30.0F, 2.0F, scale);
		this.leftArm.setPivot(5.0F, -12.0F, 0.0F);
		this.rightLeg = new ModelPart(this, 56, 0);
		this.rightLeg.addCuboid(-1.0F, 0.5F, -1.0F, 2.0F, 30.0F, 2.0F, 0.0F, -1.5F, 0.0F);
		this.rightLeg.setPivot(-2.0F, -5.0F, 0.0F);
		this.leftLeg = new ModelPart(this, 56, 0);
		this.leftLeg.mirror = true;
		this.leftLeg.addCuboid(-1.0F, 0.5F, -1.0F, 2.0F, 30.0F, 2.0F, 0.0F, -1.5F, 0.0F);
		this.leftLeg.setPivot(2.0F, -5.0F, 0.0F);
		this.torso.addChild(this.torso_1);
	}

	public void setAngles(T livingEntity, float f, float g, float h, float i, float j) {
		super.setAngles(livingEntity, f, g, h, i, j);
		this.head.visible = true;
		this.torso.pitch = 0.0F;
		this.torso.pivotY = -14.0F;
		this.torso.pivotZ = -0.0F;
		ModelPart var10000 = this.rightLeg;
		var10000.pitch -= 0.0F;
		var10000 = this.leftLeg;
		var10000.pitch -= 0.0F;
		var10000 = this.rightArm;
		var10000.pitch = (float) ((double) var10000.pitch * 0.5D);
		var10000 = this.leftArm;
		var10000.pitch = (float) ((double) var10000.pitch * 0.5D);
		var10000 = this.rightLeg;
		var10000.pitch = (float) ((double) var10000.pitch * 0.5D);
		var10000 = this.leftLeg;
		var10000.pitch = (float) ((double) var10000.pitch * 0.5D);
		if (this.rightArm.pitch > 0.4F) {
			this.rightArm.pitch = 0.4F;
		}

		if (this.leftArm.pitch > 0.4F) {
			this.leftArm.pitch = 0.4F;
		}

		if (this.rightArm.pitch < -0.4F) {
			this.rightArm.pitch = -0.4F;
		}

		if (this.leftArm.pitch < -0.4F) {
			this.leftArm.pitch = -0.4F;
		}

		if (this.rightLeg.pitch > 0.4F) {
			this.rightLeg.pitch = 0.4F;
		}

		if (this.leftLeg.pitch > 0.4F) {
			this.leftLeg.pitch = 0.4F;
		}

		if (this.rightLeg.pitch < -0.4F) {
			this.rightLeg.pitch = -0.4F;
		}

		if (this.leftLeg.pitch < -0.4F) {
			this.leftLeg.pitch = -0.4F;
		}

		this.rightArm.pivotZ = 0.0F;
		this.leftArm.pivotZ = 0.0F;
		this.rightLeg.pivotZ = 0.0F;
		this.leftLeg.pivotZ = 0.0F;
		this.rightLeg.pivotY = -5.0F;
		this.leftLeg.pivotY = -5.0F;
		this.head.pivotZ = -0.0F;
		this.head.pivotY = -13.0F;
		this.helmet.pivotX = this.head.pivotX;
		this.helmet.pivotY = this.head.pivotY;
		this.helmet.pivotZ = this.head.pivotZ;
		this.helmet.pitch = this.head.pitch;
		this.helmet.yaw = this.head.yaw;
		this.helmet.roll = this.head.roll;
		this.rightArm.setPivot(-5.0F, -12.0F, 0.0F);
		this.leftArm.setPivot(5.0F, -12.0F, 0.0F);
	}
}