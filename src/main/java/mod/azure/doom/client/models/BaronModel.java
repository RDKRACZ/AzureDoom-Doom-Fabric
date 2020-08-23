package mod.azure.doom.client.models;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class BaronModel<T extends Entity> extends EntityModel<T> {
	public ModelPart bipedRightArm;
	public ModelPart bipedRightLeg;
	public ModelPart bipedLeftLeg;
	public ModelPart bipedHeadwear;
	public ModelPart bipedLeftArm;
	public ModelPart bipedBody;
	public ModelPart bipedHead;
	public ModelPart pinkyHornL;
	public ModelPart pinkyHornR;
	public ModelPart pinkyHornL_1;
	public ModelPart pinkyHornR_1;

	public BaronModel() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.bipedHeadwear = new ModelPart(this, 32, 0);
		this.bipedHeadwear.setPivot(0.0F, 0.0F, 0.0F);
		this.bipedHeadwear.addCuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 1.0F, 1.0F, 1.0F);
		this.bipedHead = new ModelPart(this, 0, 0);
		this.bipedHead.setPivot(0.0F, 0.0F, 0.0F);
		this.bipedHead.addCuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.5F, 0.5F, 0.5F);
		this.bipedRightArm = new ModelPart(this, 40, 16);
		this.bipedRightArm.setPivot(-5.0F, 2.0F, 0.0F);
		this.bipedRightArm.addCuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.5F, 0.5F, 0.5F);
		this.setRotateAngle(bipedRightArm, -1.3962635347535182F, -0.10000000116728046F, 0.10000000116728046F);
		this.pinkyHornL = new ModelPart(this, 0, 53);
		this.pinkyHornL.setPivot(0.0F, 0.0F, 0.0F);
		this.pinkyHornL.addCuboid(-5.0F, -12.0F, -1.5F, 2.0F, 10.0F, 2.0F, 0.0F, -2.6F, 0.0F);
		this.setRotateAngle(pinkyHornL, 0.0F, 0.0F, 1.4161601444155547F);
		this.pinkyHornR = new ModelPart(this, 0, 53);
		this.pinkyHornR.setPivot(0.0F, 0.0F, 0.0F);
		this.pinkyHornR.addCuboid(3.0F, -12.0F, -1.5F, 2.0F, 10.0F, 2.0F, 0.0F, -2.6F, 0.0F);
		this.setRotateAngle(pinkyHornR, 0.0F, 0.0F, -1.4161601444155547F);
		this.pinkyHornL_1 = new ModelPart(this, 0, 53);
		this.pinkyHornL_1.setPivot(0.0F, 0.0F, 0.0F);
		this.pinkyHornL_1.addCuboid(7.3F, -8.0F, 3.0F, 2.0F, 10.0F, 2.0F, 0.0F, -2.6F, -0.1F);
		this.setRotateAngle(pinkyHornL_1, 1.5707963267948966F, 0.0F, -1.5707963267948966F);
		this.bipedLeftLeg = new ModelPart(this, 0, 16);
		this.bipedLeftLeg.mirror = true;
		this.bipedLeftLeg.setPivot(1.9F, 12.0F, 0.1F);
		this.bipedLeftLeg.addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.5F, 0.5F, 0.5F);
		this.bipedRightLeg = new ModelPart(this, 0, 16);
		this.bipedRightLeg.setPivot(-1.9F, 12.0F, 0.1F);
		this.bipedRightLeg.addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.5F, 0.5F, 0.5F);
		this.bipedLeftArm = new ModelPart(this, 40, 16);
		this.bipedLeftArm.mirror = true;
		this.bipedLeftArm.setPivot(5.0F, 2.0F, 0.0F);
		this.bipedLeftArm.addCuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.5F, 0.5F, 0.5F);
		this.setRotateAngle(bipedLeftArm, -1.3962635347535182F, 0.10000000116728046F, -0.10000000116728046F);
		this.pinkyHornR_1 = new ModelPart(this, 0, 53);
		this.pinkyHornR_1.setPivot(0.0F, 0.0F, 0.0F);
		this.pinkyHornR_1.addCuboid(7.3F, -8.0F, -5.0F, 2.0F, 10.0F, 2.0F, 0.0F, -2.6F, -0.1F);
		this.setRotateAngle(pinkyHornR_1, 1.5707963267948966F, 0.0F, -1.5707963267948966F);
		this.bipedBody = new ModelPart(this, 16, 16);
		this.bipedBody.setPivot(0.0F, 0.0F, 0.0F);
		this.bipedBody.addCuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.5F, 0.5F, 0.5F);
		this.bipedHead.addChild(this.pinkyHornL);
		this.bipedHead.addChild(this.pinkyHornR);
		this.pinkyHornL.addChild(this.pinkyHornL_1);
		this.pinkyHornR.addChild(this.pinkyHornR_1);
	}

	@Override
	public void render(MatrixStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		ImmutableList.of(this.bipedHeadwear, this.bipedHead, this.bipedRightArm, this.bipedLeftLeg, this.bipedRightLeg,
				this.bipedLeftArm, this.bipedBody).forEach((ModelPart) -> {
					ModelPart.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue,
							alpha);
				});
	}

	@Override
	public void setAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		this.bipedRightLeg.pitch = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / 1.0F;
		this.bipedLeftLeg.pitch = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount
				/ 1.0F;
	}

	public void setRotateAngle(ModelPart ModelPart, float x, float y, float z) {
		ModelPart.pitch = x;
		ModelPart.yaw = y;
		ModelPart.roll = z;
	}
}