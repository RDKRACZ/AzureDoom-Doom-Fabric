package mod.azure.doom.client.models;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;

public class UnarmedModel<T extends LivingEntity> extends BipedEntityModel<T> {
	public ModelPart bipedRightLeg_flat;
	public ModelPart bipedRightArm_flat;
	public ModelPart bipedBody;
	public ModelPart bipedHead;
	public ModelPart bipedLeftArm_flat;
	public ModelPart bipedLeftLeg_flat;
	public ModelPart bipedRightLeg;
	public ModelPart bipedRightLegwear;
	public ModelPart bipedRightLeg_1;
	public ModelPart bipedRightLegwear_1;
	public ModelPart bipedRightArm;
	public ModelPart bipedRightArmwear;
	public ModelPart bipedRightArm_1;
	public ModelPart bipedBodyWear;
	public ModelPart bipedHeadwear;
	public ModelPart bipedLeftArm;
	public ModelPart bipedLeftArmwear;
	public ModelPart bipedLeftArm_1;
	public ModelPart bipedLeftLeg;
	public ModelPart bipedLeftLegwear;
	public ModelPart bipedLeftLeg_1;
	public ModelPart bipedLeftLegwear_1;

	public UnarmedModel(float modelSize, boolean smallArmsIn) {
		super(modelSize, 0.0F, 64, 64);
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.bipedBody = new ModelPart(this, 16, 16);
		this.bipedBody.setPivot(0.0F, 0.0F, 0.0F);
		this.bipedBody.addCuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.5F, 0.5F, 0.5F);
		this.bipedRightLeg_1 = new ModelPart(this, 0, 22);
		this.bipedRightLeg_1.setPivot(0.0F, 6.0F, 0.0F);
		this.bipedRightLeg_1.addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, -0.1F, 0.5F, 0.4F);
		this.setRotateAngle(bipedRightLeg_1, 0.0781907508222411F, 0.0F, 0.0F);
		this.bipedLeftLeg = new ModelPart(this, 16, 48);
		this.bipedLeftLeg.setPivot(0.0F, 0.0F, 0.0F);
		this.bipedLeftLeg.addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, 0.5F, 0.5F);
		this.setRotateAngle(bipedLeftLeg, -0.07330382525481048F, 0.0F, 0.0F);
		this.bipedRightArm = new ModelPart(this, 40, 16);
		this.bipedRightArm.setPivot(0.0F, 0.0F, 0.0F);
		this.bipedRightArm.addCuboid(-3.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.5F, 0.5F, 0.5F);
		this.setRotateAngle(bipedRightArm, 0.0F, 0.0F, 0.10000736647217022F);
		this.bipedRightArm_flat = new ModelPart(this, 40, 16);
		this.bipedRightArm_flat.setPivot(-6.4F, 2.0F, 0.0F);
		this.bipedRightArm_flat.addCuboid(-3.0F, -2.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.5F, 0.5F, 0.5F);
		this.bipedRightLeg = new ModelPart(this, 0, 16);
		this.bipedRightLeg.setPivot(0.0F, 0.0F, 0.0F);
		this.bipedRightLeg.addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, 0.5F, 0.5F);
		this.setRotateAngle(bipedRightLeg, -0.07330382525481048F, 0.0F, 0.0F);
		this.bipedHead = new ModelPart(this, 0, 0);
		this.bipedHead.setPivot(0.0F, 0.0F, 0.0F);
		this.bipedHead.addCuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.5F, 0.5F, 0.5F);
		this.bipedRightLegwear = new ModelPart(this, 0, 32);
		this.bipedRightLegwear.setPivot(0.0F, 0.0F, 0.0F);
		this.bipedRightLegwear.addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.25F, 0.75F, 0.75F);
		this.bipedRightLeg_flat = new ModelPart(this, 0, 16);
		this.bipedRightLeg_flat.setPivot(-2.2F, 11.3F, -0.3F);
		this.bipedRightLeg_flat.addCuboid(-2.0F, 0.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.5F, 0.5F);
		this.bipedLeftArm_flat = new ModelPart(this, 32, 48);
		this.bipedLeftArm_flat.setPivot(6.4F, 2.0F, 0.0F);
		this.bipedLeftArm_flat.addCuboid(-1.0F, -2.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.5F, 0.5F, 0.5F);
		this.bipedLeftArm_1 = new ModelPart(this, 32, 53);
		this.bipedLeftArm_1.setPivot(0.0F, 5.0F, -1.2F);
		this.bipedLeftArm_1.addCuboid(-1.0F, -2.0F, -2.0F, 4.0F, 7.0F, 4.0F, 0.4F, 1.0F, 0.4F);
		this.setRotateAngle(bipedLeftArm_1, -0.7037167490777915F, 0.0F, 0.0F);
		this.bipedRightArmwear = new ModelPart(this, 40, 32);
		this.bipedRightArmwear.setPivot(0.0F, 0.0F, 0.0F);
		this.bipedRightArmwear.addCuboid(-3.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.75F, 0.75F, 0.75F);
		this.bipedBodyWear = new ModelPart(this, 16, 32);
		this.bipedBodyWear.setPivot(0.0F, 0.0F, 0.0F);
		this.bipedBodyWear.addCuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.75F, 0.75F, 0.75F);
		this.bipedLeftLegwear_1 = new ModelPart(this, 0, 54);
		this.bipedLeftLegwear_1.setPivot(0.0F, 0.0F, 0.0F);
		this.bipedLeftLegwear_1.addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.15F, 0.75F, 0.65F);
		this.bipedRightLegwear_1 = new ModelPart(this, 0, 38);
		this.bipedRightLegwear_1.setPivot(0.0F, 0.0F, 0.0F);
		this.bipedRightLegwear_1.addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.15F, 0.75F, 0.65F);
		this.bipedLeftLegwear = new ModelPart(this, 0, 48);
		this.bipedLeftLegwear.setPivot(0.0F, 0.0F, 0.0F);
		this.bipedLeftLegwear.addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.25F, 0.75F, 0.75F);
		this.bipedLeftArm = new ModelPart(this, 32, 48);
		this.bipedLeftArm.setPivot(0.0F, 0.0F, 0.0F);
		this.bipedLeftArm.addCuboid(-1.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.5F, 0.5F, 0.5F);
		this.setRotateAngle(bipedLeftArm, 0.0F, 0.0F, -0.10000736647217022F);
		this.bipedLeftArmwear = new ModelPart(this, 48, 48);
		this.bipedLeftArmwear.setPivot(0.0F, 0.0F, 0.0F);
		this.bipedLeftArmwear.addCuboid(-1.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.75F, 0.75F, 0.75F);
		this.bipedLeftLeg_flat = new ModelPart(this, 16, 48);
		this.bipedLeftLeg_flat.setPivot(2.5F, 11.3F, 0.1F);
		this.bipedLeftLeg_flat.addCuboid(-2.0F, 0.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.5F, 0.5F);
		this.bipedRightArm_1 = new ModelPart(this, 40, 20);
		this.bipedRightArm_1.setPivot(0.0F, 5.0F, -1.2F);
		this.bipedRightArm_1.addCuboid(-3.0F, -1.9F, -2.0F, 4.0F, 7.0F, 4.0F, 0.4F, 1.0F, 0.4F);
		this.setRotateAngle(bipedRightArm_1, -0.7037167490777915F, 0.0F, 0.0F);
		this.bipedHeadwear = new ModelPart(this, 32, 0);
		this.bipedHeadwear.setPivot(0.0F, 0.0F, 0.0F);
		this.bipedHeadwear.addCuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 1.0F, 1.0F, 1.0F);
		this.bipedLeftLeg_1 = new ModelPart(this, 16, 54);
		this.bipedLeftLeg_1.setPivot(0.0F, 6.0F, 0.0F);
		this.bipedLeftLeg_1.addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, 0.5F, 0.5F);
		this.setRotateAngle(bipedLeftLeg_1, 0.0781907508222411F, 0.0F, 0.0F);
		this.bipedRightLeg.addChild(this.bipedRightLeg_1);
		this.bipedLeftLeg_flat.addChild(this.bipedLeftLeg);
		this.bipedRightArm_flat.addChild(this.bipedRightArm);
		this.bipedRightLeg_flat.addChild(this.bipedRightLeg);
		this.bipedRightLeg.addChild(this.bipedRightLegwear);
		this.bipedLeftArm.addChild(this.bipedLeftArm_1);
		this.bipedRightArm.addChild(this.bipedRightArmwear);
		this.bipedBody.addChild(this.bipedBodyWear);
		this.bipedLeftLeg_1.addChild(this.bipedLeftLegwear_1);
		this.bipedRightLeg_1.addChild(this.bipedRightLegwear_1);
		this.bipedLeftLeg.addChild(this.bipedLeftLegwear);
		this.bipedLeftArm_flat.addChild(this.bipedLeftArm);
		this.bipedLeftArm.addChild(this.bipedLeftArmwear);
		this.bipedRightArm.addChild(this.bipedRightArm_1);
		this.bipedHead.addChild(this.bipedHeadwear);
		this.bipedLeftLeg.addChild(this.bipedLeftLeg_1);
	}

	@Override
	public void render(MatrixStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		ImmutableList.of(this.bipedBody, this.bipedRightArm_flat, this.bipedHead, this.bipedRightLeg_flat,
				this.bipedLeftArm_flat, this.bipedLeftLeg_flat).forEach((modelRenderer) -> {
					modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue,
							alpha);
				});
	}

	public void setRotateAngle(ModelPart ModelPart, float x, float y, float z) {
		ModelPart.pitch = x;
		ModelPart.yaw = y;
		ModelPart.roll = z;
	}

	@Override
	public void setAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.bipedRightArm_flat.pitch = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / 1.0F;
		this.bipedLeftArm_flat.pitch = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount
				/ 1.0F;
		if (this.handSwingProgress > 0.0F) {
			Arm handside = this.getPreferredArm(entityIn);
			ModelPart modelrenderer = this.getArm(handside);
			float f1 = this.handSwingProgress;
			if (handside == Arm.LEFT) {
				this.bipedBody.yaw *= -1.0F;
			}

			f1 = 1.0F - this.handSwingProgress;
			float f2 = MathHelper.sin(f1 * (float) Math.PI);
			float f3 = MathHelper.sin(this.handSwingProgress * (float) Math.PI) * -(this.bipedHead.pitch - 0.7F)
					* 0.75F;
			modelrenderer.pitch = (float) ((double) modelrenderer.pitch - ((double) f2 * 1.2D + (double) f3));
			modelrenderer.yaw += this.bipedBody.yaw * 2.0F;
			modelrenderer.roll += MathHelper.sin(this.handSwingProgress * (float) Math.PI) * -0.4F;
		}
		this.bipedRightLeg_flat.pitch = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / 1.0F;
		this.bipedLeftLeg_flat.pitch = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount
				/ 1.0F;
	}

	@Override
	public void setArmAngle(Arm arm, MatrixStack matrices) {
		this.getArm(arm).rotate(matrices);
		matrices.translate(-0.4D, -0.2D, 0.1D);
		matrices.multiply(Vector3f.POSITIVE_Z.getDegreesQuaternion(4.0F));
	}

	@Override
	protected ModelPart getArm(Arm arm) {
		return arm == Arm.LEFT ? this.bipedLeftArm_1 : this.bipedRightArm_1;
	}

	protected Arm getPreferredArm(T entity) {
		Arm arm = entity.getMainArm();
		return entity.preferredHand == Hand.MAIN_HAND ? arm : arm.getOpposite();
	}
}