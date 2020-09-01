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
	public ModelPart bipedLeftLeg;
	public ModelPart bipedHeadwear;
	public ModelPart bipedLeftArm;
	public ModelPart bipedBody;
	public ModelPart bipedHead;
	public ModelPart bipedRightLeg;
	public ModelPart bipedRightArm_1;
	public ModelPart bipedLeftLeg_1;
	public ModelPart bipedLeftLeg_2;
	public ModelPart bipedLeftLeg_3;
	public ModelPart bipedLeftArm_1;
	public ModelPart bipedBody_1;
	public ModelPart baronHornL;
	public ModelPart baronHornR;
	public ModelPart baronHornL_1;
	public ModelPart baronHornR_1;
	public ModelPart bipedRightLeg_1;
	public ModelPart bipedRightLeg_2;
	public ModelPart bipedRightLeg_3;

	public BaronModel() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.baronHornR_1 = new ModelPart(this, 0, 53);
		this.baronHornR_1.setPivot(0.0F, 0.0F, 0.0F);
		this.baronHornR_1.addCuboid(7.3F, -8.0F, -5.0F, 2.0F, 10.0F, 2.0F, 0.0F, -2.6F, -0.099999905F);
		this.setRotateAngle(baronHornR_1, 1.5707963267948966F, 0.0F, -1.5707963267948966F);
		this.bipedLeftLeg_2 = new ModelPart(this, 0, 16);
		this.bipedLeftLeg_2.mirror = true;
		this.bipedLeftLeg_2.setPivot(0.0F, 0.0F, 0.0F);
		this.bipedLeftLeg_2.addCuboid(0.0F, 4.6F, -1.0F, 4.0F, 6.8F, 4.0F, 0.6F, -1.5F, 0.6F);
		this.bipedLeftLeg_3 = new ModelPart(this, 0, 26);
		this.bipedLeftLeg_3.mirror = true;
		this.bipedLeftLeg_3.setPivot(0.0F, 0.0F, 0.0F);
		this.bipedLeftLeg_3.addCuboid(0.0F, 10.0F, -1.0F, 4.0F, 2.0F, 4.0F, 0.6F, 0.1F, 0.6F);
		this.bipedRightLeg_3 = new ModelPart(this, 0, 26);
		this.bipedRightLeg_3.mirror = true;
		this.bipedRightLeg_3.setPivot(0.0F, 0.0F, 0.0F);
		this.bipedRightLeg_3.addCuboid(0.0F, 10.0F, -1.0F, 4.0F, 2.0F, 4.0F, 0.6F, 0.1F, 0.6F);
		this.bipedHeadwear = new ModelPart(this, 32, 0);
		this.bipedHeadwear.setPivot(0.0F, 0.0F, 0.0F);
		this.bipedHeadwear.addCuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 1.0F, 1.0F, 1.0F);
		this.bipedLeftLeg_1 = new ModelPart(this, 0, 16);
		this.bipedLeftLeg_1.mirror = true;
		this.bipedLeftLeg_1.setPivot(0.0F, 0.0F, 0.0F);
		this.bipedLeftLeg_1.addCuboid(0.0F, 0.9F, -5.5F, 4.0F, 8.0F, 4.0F, 0.5F, -2.0F, 0.5F);
		this.setRotateAngle(bipedLeftLeg_1, 0.6646214111173737F, 0.0F, 0.0F);
		this.bipedLeftLeg = new ModelPart(this, 0, 16);
		this.bipedLeftLeg.mirror = true;
		this.bipedLeftLeg.setPivot(1.1F, 12.0F, 0.1F);
		this.bipedLeftLeg.addCuboid(0.0F, -2.6F, -2.1F, 4.0F, 9.9F, 4.0F, 0.6F, -1.5F, 0.6F);
		this.bipedLeftArm = new ModelPart(this, 40, 16);
		this.bipedLeftArm.mirror = true;
		this.bipedLeftArm.setPivot(6.8F, 2.0F, 0.0F);
		this.bipedLeftArm.addCuboid(-1.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, 1.0F, 0.5F, 1.0F);
		this.setRotateAngle(bipedLeftArm, -1.0555751236166873F, 0.0F, 0.0F);
		this.bipedRightArm = new ModelPart(this, 40, 16);
		this.bipedRightArm.setPivot(-6.8F, 2.0F, 0.0F);
		this.bipedRightArm.addCuboid(-3.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, 1.0F, 0.5F, 1.0F);
		this.setRotateAngle(bipedRightArm, -1.0555751236166873F, 0.0F, 0.0F);
		this.bipedBody = new ModelPart(this, 16, 16);
		this.bipedBody.setPivot(0.0F, 0.0F, 0.0F);
		this.bipedBody.addCuboid(-4.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, 0.8F, 0.5F, 0.7F);
		this.bipedBody_1 = new ModelPart(this, 16, 16);
		this.bipedBody_1.setPivot(0.0F, 0.0F, 0.0F);
		this.bipedBody_1.addCuboid(-4.0F, 6.0F, -2.0F, 8.0F, 6.0F, 4.0F, 0.4F, 0.5F, 0.4F);
		this.baronHornL_1 = new ModelPart(this, 0, 53);
		this.baronHornL_1.setPivot(0.0F, 0.0F, 0.0F);
		this.baronHornL_1.addCuboid(7.3F, -8.0F, 3.0F, 2.0F, 10.0F, 2.0F, 0.0F, -2.6F, -0.099999905F);
		this.setRotateAngle(baronHornL_1, 1.5707963267948966F, 0.0F, -1.5707963267948966F);
		this.bipedRightLeg_2 = new ModelPart(this, 0, 16);
		this.bipedRightLeg_2.mirror = true;
		this.bipedRightLeg_2.setPivot(0.0F, 0.0F, 0.0F);
		this.bipedRightLeg_2.addCuboid(0.0F, 4.6F, -1.0F, 4.0F, 6.8F, 4.0F, 0.6F, -1.5F, 0.6F);
		this.bipedRightLeg = new ModelPart(this, 0, 16);
		this.bipedRightLeg.mirror = true;
		this.bipedRightLeg.setPivot(-5.1F, 12.0F, 0.1F);
		this.bipedRightLeg.addCuboid(0.0F, -2.6F, -2.1F, 4.0F, 9.9F, 4.0F, 0.6F, -1.5F, 0.6F);
		this.bipedRightArm_1 = new ModelPart(this, 40, 22);
		this.bipedRightArm_1.setPivot(0.0F, 0.0F, 0.0F);
		this.bipedRightArm_1.addCuboid(-3.0F, 5.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.5F, 0.5F, 0.5F);
		this.bipedLeftArm_1 = new ModelPart(this, 40, 22);
		this.bipedLeftArm_1.mirror = true;
		this.bipedLeftArm_1.setPivot(0.0F, 0.0F, 0.0F);
		this.bipedLeftArm_1.addCuboid(-1.0F, 5.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.5F, 0.5F, 0.5F);
		this.baronHornR = new ModelPart(this, 0, 53);
		this.baronHornR.setPivot(0.0F, 0.0F, 0.0F);
		this.baronHornR.addCuboid(3.0F, -12.0F, -1.5F, 2.0F, 10.0F, 2.0F, 0.0F, -2.6000001F, 0.0F);
		this.setRotateAngle(baronHornR, 0.0F, 0.0F, -1.4161601444155547F);
		this.bipedHead = new ModelPart(this, 0, 0);
		this.bipedHead.setPivot(0.0F, 0.0F, 0.0F);
		this.bipedHead.addCuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.5F, 0.5F, 0.5F);
		this.bipedRightLeg_1 = new ModelPart(this, 0, 16);
		this.bipedRightLeg_1.mirror = true;
		this.bipedRightLeg_1.setPivot(0.0F, 0.0F, 0.0F);
		this.bipedRightLeg_1.addCuboid(0.0F, 0.9F, -5.5F, 4.0F, 8.0F, 4.0F, 0.5F, -2.0F, 0.2F);
		this.setRotateAngle(bipedRightLeg_1, 0.6646214111173737F, 0.0F, 0.0F);
		this.baronHornL = new ModelPart(this, 0, 53);
		this.baronHornL.setPivot(0.0F, 0.0F, 0.0F);
		this.baronHornL.addCuboid(-5.0F, -12.0F, -1.5F, 2.0F, 10.0F, 2.0F, 0.0F, -2.6000001F, 0.0F);
		this.setRotateAngle(baronHornL, 0.0F, 0.0F, 1.4161601444155547F);
		this.baronHornR.addChild(this.baronHornR_1);
		this.bipedLeftLeg.addChild(this.bipedLeftLeg_2);
		this.bipedLeftLeg_2.addChild(this.bipedLeftLeg_3);
		this.bipedRightLeg_2.addChild(this.bipedRightLeg_3);
		this.bipedLeftLeg.addChild(this.bipedLeftLeg_1);
		this.bipedBody.addChild(this.bipedBody_1);
		this.baronHornL.addChild(this.baronHornL_1);
		this.bipedRightLeg.addChild(this.bipedRightLeg_2);
		this.bipedRightArm.addChild(this.bipedRightArm_1);
		this.bipedLeftArm.addChild(this.bipedLeftArm_1);
		this.bipedHead.addChild(this.baronHornR);
		this.bipedRightLeg.addChild(this.bipedRightLeg_1);
		this.bipedHead.addChild(this.baronHornL);
	}

	@Override
	public void render(MatrixStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		ImmutableList.of(this.bipedHeadwear, this.bipedHead, this.bipedRightArm, this.bipedLeftLeg, this.bipedRightLeg,
				this.bipedLeftArm, this.bipedBody).forEach((ModelPart) -> {
					ModelPart.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
				});
	}

	@Override
	public void setAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.bipedRightLeg.pitch = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / 1.0F;
		this.bipedLeftLeg.pitch = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount / 1.0F;
	}

	public void setRotateAngle(ModelPart ModelPart, float x, float y, float z) {
		ModelPart.pitch = x;
		ModelPart.yaw = y;
		ModelPart.roll = z;
	}
}