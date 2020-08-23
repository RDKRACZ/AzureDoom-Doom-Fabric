package mod.azure.doom.client.models;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class PinkyModel<T extends Entity> extends EntityModel<T> {
	public ModelPart pinkyArmR;
	public ModelPart pinkyHead;
	public ModelPart pinkyLegR;
	public ModelPart pinkyArmL;
	public ModelPart pinkyLegL;
	public ModelPart pinkyBody;
	public ModelPart pinkyArmR_1;
	public ModelPart pinkyHornL;
	public ModelPart pinkyHornR;
	public ModelPart pinkyLegR_1;
	public ModelPart pinkyLegR_2;
	public ModelPart pinkyArmL_1;
	public ModelPart pinkyLegL_1;
	public ModelPart pinkyLegL_2;
	public ModelPart pinkyBody_1;


	public PinkyModel() {
		this.textureWidth = 128;
		this.textureHeight = 64;
		this.pinkyLegR_1 = new ModelPart(this, 21, 45);
		this.pinkyLegR_1.setPivot(0.0F, 0.0F, 0.0F);
		this.pinkyLegR_1.addCuboid(-2.5F, 2.0F, -6.4F, 5.0F, 10.0F, 5.0F, -0.1F, 0.1F, -0.1F);
		this.setRotateAngle(pinkyLegR_1, -0.35185837453889574F, 0.0F, 0.0F);
		this.pinkyHead = new ModelPart(this, 61, 1);
		this.pinkyHead.setPivot(0.0F, 2.0F, -12.0F);
		this.pinkyHead.addCuboid(-7.0F, -2.8F, -10.3F, 14.0F, 6.0F, 19.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(pinkyHead, 1.3418090809963408F, 0.0F, 0.0F);
		this.pinkyArmL = new ModelPart(this, 41, 42);
		this.pinkyArmL.setPivot(4.0F, 10.0F, -8.5F);
		this.pinkyArmL.addCuboid(4.0F, 1.0F, 6.9F, 6.0F, 12.0F, 6.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(pinkyArmL, 0.0F, 0.0F, -1.4856243072344728F);
		this.pinkyHornR = new ModelPart(this, 10, 13);
		this.pinkyHornR.setPivot(-7.0F, 2.0F, -12.0F);
		this.pinkyHornR.addCuboid(1.2F, -8.6F, 15.1F, 2.0F, 11.0F, 2.0F, 0.0F, -2.4F, 0.0F);
		this.setRotateAngle(pinkyHornR, 0.0F, 0.0F, -1.4161601444155547F);
		this.pinkyHornL = new ModelPart(this, 1, 13);
		this.pinkyHornL.setPivot(7.0F, 2.0F, -12.0F);
		this.pinkyHornL.addCuboid(-2.8F, -8.7F, 15.1F, 2.0F, 11.0F, 2.0F, 0.0F, -2.4F, 0.0F);
		this.setRotateAngle(pinkyHornL, 0.0F, 0.0F, 1.4161601444155547F);
		this.pinkyBody_1 = new ModelPart(this, 43, 28);
		this.pinkyBody_1.setPivot(0.0F, 0.0F, 0.0F);
		this.pinkyBody_1.addCuboid(-2.1F, -10.3F, -8.8F, 5.0F, 5.0F, 5.0F, -8.0F, -5.0F, -6.0F);
		this.setRotateAngle(pinkyBody_1, 0.9756390784964412F, 0.0F, 0.0F);
		this.pinkyLegL = new ModelPart(this, 0, 45);
		this.pinkyLegL.setPivot(5.0F, 13.0F, 10.0F);
		this.pinkyLegL.addCuboid(-2.5F, -6.6F, -6.8F, 5.0F, 10.0F, 5.0F, 0.0F, -2.0F, 0.0F);
		this.pinkyArmR_1 = new ModelPart(this, 66, 42);
		this.pinkyArmR_1.setPivot(0.0F, 0.0F, 0.0F);
		this.pinkyArmR_1.addCuboid(-10.0F, -11.9F, 7.8F, 6.0F, 14.0F, 6.0F, -0.1F, 0.0F, -0.1F);
		this.setRotateAngle(pinkyArmR_1, -1.5707963267948966F, 0.0F, 0.0F);
		this.pinkyLegR_2 = new ModelPart(this, 21, 53);
		this.pinkyLegR_2.setPivot(0.0F, 0.0F, 0.0F);
		this.pinkyLegR_2.addCuboid(-2.5F, 8.0F, -9.7F, 5.0F, 3.0F, 5.0F, 0.5F, 0.0F, 0.5F);
		this.setRotateAngle(pinkyLegR_2, 0.35185837453889574F, 0.0F, 0.0F);
		this.pinkyLegR = new ModelPart(this, 21, 45);
		this.pinkyLegR.setPivot(-5.0F, 13.0F, 10.0F);
		this.pinkyLegR.addCuboid(-2.5F, -6.6F, -6.8F, 5.0F, 10.0F, 5.0F, 0.0F, -2.0F, 0.0F);
		this.pinkyLegL_1 = new ModelPart(this, 0, 45);
		this.pinkyLegL_1.setPivot(0.0F, 0.0F, 0.0F);
		this.pinkyLegL_1.addCuboid(-2.5F, 2.0F, -6.4F, 5.0F, 10.0F, 5.0F, -0.1F, 0.1F, -0.1F);
		this.setRotateAngle(pinkyLegL_1, -0.35185837453889574F, 0.0F, 0.0F);
		this.pinkyArmR = new ModelPart(this, 66, 42);
		this.pinkyArmR.setPivot(-4.0F, 10.0F, -8.5F);
		this.pinkyArmR.addCuboid(-10.0F, 0.8F, 6.9F, 6.0F, 12.0F, 6.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(pinkyArmR, -0.03909537541112055F, 0.0F, 1.4856243072344728F);
		this.pinkyLegL_2 = new ModelPart(this, 0, 53);
		this.pinkyLegL_2.setPivot(0.0F, 0.0F, 0.0F);
		this.pinkyLegL_2.addCuboid(-2.5F, 8.0F, -9.7F, 5.0F, 3.0F, 5.0F, 0.5F, 0.0F, 0.5F);
		this.setRotateAngle(pinkyLegL_2, 0.35185837453889574F, 0.0F, 0.0F);
		this.pinkyBody = new ModelPart(this, 1, 1);
		this.pinkyBody.setPivot(0.0F, 7.0F, 0.0F);
		this.pinkyBody.addCuboid(-7.9F, -11.0F, -15.5F, 16.0F, 14.0F, 26.0F, 0.0F, -1.8F, -5.0F);
		this.setRotateAngle(pinkyBody, -1.13376586611655F, 0.0F, 0.0F);
		this.pinkyArmL_1 = new ModelPart(this, 41, 42);
		this.pinkyArmL_1.setPivot(0.0F, 0.0F, 0.0F);
		this.pinkyArmL_1.addCuboid(4.0F, -12.0F, 7.8F, 6.0F, 14.0F, 6.0F, -0.1F, 0.0F, -0.1F);
		this.setRotateAngle(pinkyArmL_1, -1.5707963267948966F, 0.0F, 0.0F);
		this.pinkyLegR.addChild(this.pinkyLegR_1);
		this.pinkyHead.addChild(this.pinkyHornR);
		this.pinkyHead.addChild(this.pinkyHornL);
		this.pinkyBody.addChild(this.pinkyBody_1);
		this.pinkyArmR.addChild(this.pinkyArmR_1);
		this.pinkyLegR_1.addChild(this.pinkyLegR_2);
		this.pinkyLegL.addChild(this.pinkyLegL_1);
		this.pinkyLegL_1.addChild(this.pinkyLegL_2);
		this.pinkyArmL.addChild(this.pinkyArmL_1);
	}

	protected Iterable<ModelPart> getHeadParts() {
		return ImmutableList.of(this.pinkyHead);
	}

	protected Iterable<ModelPart> getBodyParts() {
		return ImmutableList.of(this.pinkyBody, this.pinkyArmR, this.pinkyArmL, this.pinkyLegR, this.pinkyLegL);
	}

	@Override
	public void setAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		
		this.pinkyHead.pitch = 1.3418090809963408F;
		this.pinkyHornR.roll = -1.4161601444155547F;
		this.pinkyHornL.roll = 1.4161601444155547F;
		this.pinkyBody.pitch = -1.13376586611655F;
		
		this.pinkyArmR.pitch = MathHelper.cos(limbSwing) * -0.7819074915776542F* limbSwingAmount;
		this.pinkyArmL.pitch = MathHelper.cos(limbSwing + (float)Math.PI) * -0.7819074915776542F * limbSwingAmount;
		this.pinkyArmR.pitch = MathHelper.cos(limbSwing) * 0.4F * limbSwingAmount;
		this.pinkyArmL.pitch = MathHelper.cos(limbSwing) * 0.4F * limbSwingAmount;
		
		this.pinkyLegR.pitch = MathHelper.cos(limbSwing) * 0.4F * limbSwingAmount;
		this.pinkyLegL.pitch = MathHelper.cos(limbSwing + (float) Math.PI) * 0.4F * limbSwingAmount;
	}
	
	@Override
	public void render(MatrixStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		ImmutableList.of(this.pinkyHead, this.pinkyArmL, this.pinkyLegL, this.pinkyLegR, this.pinkyArmR, this.pinkyBody)
				.forEach((ModelPart) -> {
					ModelPart.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue,
							alpha);
				});
	}

	public void setRotateAngle(ModelPart ModelPart, float x, float y, float z) {
		ModelPart.pitch = x;
		ModelPart.yaw = y;
		ModelPart.roll = z;
	}
}