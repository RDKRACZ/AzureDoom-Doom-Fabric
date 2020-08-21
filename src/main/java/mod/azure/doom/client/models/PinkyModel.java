package mod.azure.doom.client.models;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class PinkyModel<T extends Entity> extends EntityModel<T> {
	public ModelPart pinkyLegL;
	public ModelPart pinkyArmL;
	public ModelPart pinkyLegR;
	public ModelPart pinkyBody;
	public ModelPart pinkyArmR;
	public ModelPart pinkyHead;
	public ModelPart pinkyHornR;
	public ModelPart pinkyHornL;

	public PinkyModel() {
		this.textureWidth = 128;
		this.textureHeight = 64;
		this.pinkyLegR = new ModelPart(this, 21, 45);
		this.pinkyLegR.setPivot(-5.0F, 13.0F, 10.0F);
		this.pinkyLegR.addCuboid(-2.5F, 0.0F, -2.5F, 5.0F, 11.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.pinkyBody = new ModelPart(this, 1, 1);
		this.pinkyBody.setPivot(0.0F, 7.0F, 0.0F);
		this.pinkyBody.addCuboid(-7.9F, -11.0F, -15.5F, 16.0F, 14.0F, 26.0F, 0.0F, 0.0F, 0.0F);
		this.pinkyHornL = new ModelPart(this, 1, 13);
		this.pinkyHornL.setPivot(7.0F, 2.0F, -12.0F);
		this.pinkyHornL.addCuboid(-2.8F, -8.7F, 15.1F, 2.0F, 11.0F, 2.0F, 0.0F, -2.4F, 0.0F);
		this.pinkyHornR = new ModelPart(this, 10, 13);
		this.pinkyHornR.setPivot(-7.0F, 2.0F, -12.0F);
		this.pinkyHornR.addCuboid(1.2F, -8.6F, 15.1F, 2.0F, 11.0F, 2.0F, 0.0F, -2.4F, 0.0F);
		this.pinkyLegL = new ModelPart(this, 0, 45);
		this.pinkyLegL.setPivot(5.0F, 13.0F, 10.0F);
		this.pinkyLegL.addCuboid(-2.5F, 0.0F, -2.5F, 5.0F, 11.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.pinkyArmL = new ModelPart(this, 41, 42);
		this.pinkyArmL.setPivot(4.0F, 10.0F, -8.5F);
		this.pinkyArmL.addCuboid(4.0F, -12.0F, 2.1F, 6.0F, 14.0F, 6.0F, 0.0F, 0.0F, 0.0F);
		this.pinkyArmR = new ModelPart(this, 66, 42);
		this.pinkyArmR.setPivot(-4.0F, 10.0F, -8.5F);
		this.pinkyArmR.addCuboid(-10.0F, -12.0F, 2.1F, 6.0F, 14.0F, 6.0F, 0.0F, 0.0F, 0.0F);
		this.pinkyHead = new ModelPart(this, 61, 1);
		this.pinkyHead.setPivot(0.0F, 2.0F, -12.0F);
		this.pinkyHead.addCuboid(-7.0F, -2.8F, -10.3F, 14.0F, 6.0F, 19.0F, 0.0F, 0.0F, 0.0F);
		this.pinkyHead.addChild(this.pinkyHornL);
		this.pinkyHead.addChild(this.pinkyHornR);
	}

	protected Iterable<ModelPart> getHeadParts() {
		return ImmutableList.of(this.pinkyHead);
	}

	protected Iterable<ModelPart> getBodyParts() {
		return ImmutableList.of(this.pinkyBody, this.pinkyArmR, this.pinkyArmL, this.pinkyLegR, this.pinkyLegL);
	}

	/**
	 * Sets this entity's model rotation angles
	 */
	@Override
	public void setAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.pinkyHead.pitch = 1.3418090809963408F;
		this.pinkyHornR.roll = -1.4161601444155547F;
		this.pinkyHornL.roll = 1.4161601444155547F;
		this.pinkyBody.pitch = -1.13376586611655F;
		this.pinkyArmR.pitch = MathHelper.cos(limbSwing) * -0.7819074915776542F * limbSwingAmount;
		this.pinkyArmL.pitch = MathHelper.cos(limbSwing + (float) Math.PI) * -0.7819074915776542F * limbSwingAmount;
		this.pinkyArmR.pitch = MathHelper.cos(limbSwing) * 0.2F * limbSwingAmount;
		this.pinkyArmL.pitch = MathHelper.cos(limbSwing) * 0.2F * limbSwingAmount;
		this.pinkyLegR.pitch = MathHelper.cos(limbSwing) * 0.2F * limbSwingAmount;
		this.pinkyLegL.pitch = MathHelper.cos(limbSwing + (float) Math.PI) * 0.2F * limbSwingAmount;
	}

	@Override
	public void render(MatrixStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		ImmutableList.of(this.pinkyArmL, this.pinkyBody, this.pinkyLegR, this.pinkyArmR, this.pinkyLegL, this.pinkyHead)
				.forEach((ModelPart) -> {
					ModelPart.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
				});
	}
}