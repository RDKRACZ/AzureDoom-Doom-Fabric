package mod.azure.doom.client.models;

import com.google.common.collect.ImmutableList;

import mod.azure.doom.entity.LostSoulEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

/**
 * Lost Soul - Batpixxler Created using Tabula 8.0.0
 */

public class LostSoulModel<T extends LostSoulEntity> extends EntityModel<T> {
	public ModelPart head;
	public ModelPart smallFlame02;
	public ModelPart smallFlame04;
	public ModelPart flame01;
	public ModelPart flame02;
	public ModelPart smallFlame03;
	public ModelPart Jaw_flat;
	public ModelPart smallFlame05;
	public ModelPart smallFlame01;
	public ModelPart flame03;
	public ModelPart lHorn1;
	public ModelPart rHorn1;
	public ModelPart Jaw;
	public ModelPart lHorn2;
	public ModelPart lHorn3;
	public ModelPart lHorn4;
	public ModelPart rHorn2;
	public ModelPart rHorn3;
	public ModelPart rHorn4;

	public LostSoulModel() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.smallFlame04 = new ModelPart(this, 21, 40);
		this.smallFlame04.setPivot(1.8F, -1.4F, 0.3F);
		this.smallFlame04.addCuboid(-4.0F, 0.0F, 0.0F, 8.0F, 0.0F, 13.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(smallFlame04, 1.0471975511965976F, 0.0F, 0.6283185307179586F);
		this.lHorn3 = new ModelPart(this, 20, 14);
		this.lHorn3.mirror = true;
		this.lHorn3.setPivot(0.0F, 4.0F, 0.0F);
		this.lHorn3.addCuboid(-0.5F, 0.0F, -2.0F, 1.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lHorn3, -0.7428121536172364F, 0.0F, 0.0F);
		this.rHorn3 = new ModelPart(this, 20, 14);
		this.rHorn3.setPivot(0.0F, 4.0F, 0.0F);
		this.rHorn3.addCuboid(-0.5F, 0.0F, -2.0F, 1.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rHorn3, -0.7428121536172364F, 0.0F, 0.0F);
		this.flame01 = new ModelPart(this, -16, 22);
		this.flame01.setPivot(0.0F, 1.4F, 0.9F);
		this.flame01.addCuboid(-5.0F, 0.0F, 0.0F, 10.0F, 0.0F, 16.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(flame01, 1.3962634015954636F, -0.2617993877991494F, 0.15707963267948966F);
		this.smallFlame03 = new ModelPart(this, 21, 40);
		this.smallFlame03.setPivot(-0.7F, 1.5F, 3.1F);
		this.smallFlame03.addCuboid(-4.0F, 0.0F, 0.0F, 8.0F, 0.0F, 13.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(smallFlame03, 1.1616911075168483F, 0.0F, 0.0F);
		this.Jaw_flat = new ModelPart(this, 32, 0);
		this.Jaw_flat.setPivot(0.0F, 0.0F, 4.0F);
		this.Jaw_flat.addCuboid(-3.5F, 0.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
		this.lHorn1 = new ModelPart(this, 0, 13);
		this.lHorn1.mirror = true;
		this.lHorn1.setPivot(3.0F, -4.0F, 0.0F);
		this.lHorn1.addCuboid(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lHorn1, 0.3127630032889644F, 0.0F, -1.8769270935736684F);
		this.Jaw = new ModelPart(this, 32, 0);
		this.Jaw.setPivot(0.0F, 0.0F, 0.0F);
		this.Jaw.addCuboid(-3.5F, 0.0F, -8.0F, 7.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Jaw, 0.3909537457888271F, 0.0F, 0.0F);
		this.head = new ModelPart(this, 0, 0);
		this.head.setPivot(0.0F, 18.0F, 0.0F);
		this.head.addCuboid(-4.0F, -6.0F, -4.0F, 8.0F, 6.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.flame02 = new ModelPart(this, 6, 22);
		this.flame02.setPivot(0.0F, 1.4F, 0.9F);
		this.flame02.addCuboid(-5.0F, 0.0F, 0.0F, 10.0F, 0.0F, 16.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(flame02, 1.3962634015954636F, 0.2617993877991494F, -0.15707963267948966F);
		this.smallFlame01 = new ModelPart(this, -13, 40);
		this.smallFlame01.setPivot(-0.7F, -0.6F, -1.6F);
		this.smallFlame01.addCuboid(-4.0F, 0.0F, 0.0F, 8.0F, 0.0F, 13.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(smallFlame01, 1.3962634015954636F, -0.19198621771937624F, -0.15707963267948966F);
		this.flame03 = new ModelPart(this, 27, 22);
		this.flame03.setPivot(0.0F, -3.4F, 2.1F);
		this.flame03.addCuboid(-5.0F, 0.0F, 0.0F, 10.0F, 0.0F, 16.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(flame03, 1.1519173063162573F, 0.0F, 0.0F);
		this.rHorn4 = new ModelPart(this, 26, 14);
		this.rHorn4.setPivot(0.1F, 4.0F, 0.0F);
		this.rHorn4.addCuboid(-0.5F, 0.0F, -1.0F, 1.0F, 4.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rHorn4, -0.7819074915776542F, 0.0F, 0.0F);
		this.smallFlame05 = new ModelPart(this, -13, 40);
		this.smallFlame05.setPivot(-1.8F, -1.4F, 0.3F);
		this.smallFlame05.addCuboid(-4.0F, 0.0F, 0.0F, 8.0F, 0.0F, 13.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(smallFlame05, 1.0471975511965976F, 0.0F, -0.6283185307179586F);
		this.lHorn2 = new ModelPart(this, 12, 14);
		this.lHorn2.mirror = true;
		this.lHorn2.setPivot(0.0F, 4.0F, 1.5F);
		this.lHorn2.addCuboid(-1.0F, 0.0F, -2.0F, 2.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lHorn2, -0.7037167490777915F, 0.0F, 0.0F);
		this.lHorn4 = new ModelPart(this, 26, 14);
		this.lHorn4.mirror = true;
		this.lHorn4.setPivot(-0.1F, 4.0F, 0.0F);
		this.lHorn4.addCuboid(-0.5F, 0.0F, -1.0F, 1.0F, 4.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lHorn4, -0.7820820617871088F, 0.0F, 0.0F);
		this.rHorn1 = new ModelPart(this, 0, 13);
		this.rHorn1.setPivot(-2.0F, -4.0F, 0.0F);
		this.rHorn1.addCuboid(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rHorn1, 0.3127630032889644F, 0.0F, 1.8767525233642137F);
		this.smallFlame02 = new ModelPart(this, 4, 40);
		this.smallFlame02.setPivot(-0.7F, -0.6F, -1.6F);
		this.smallFlame02.addCuboid(-4.0F, 0.0F, 0.0F, 8.0F, 0.0F, 13.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(smallFlame02, 1.3962634015954636F, 0.19198621771937624F, 0.15707963267948966F);
		this.rHorn2 = new ModelPart(this, 12, 14);
		this.rHorn2.setPivot(0.0F, 4.0F, 1.5F);
		this.rHorn2.addCuboid(-1.0F, 0.0F, -2.0F, 2.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rHorn2, -0.7037167490777915F, 0.0F, 0.0F);
		this.head.addChild(this.smallFlame04);
		this.lHorn2.addChild(this.lHorn3);
		this.rHorn2.addChild(this.rHorn3);
		this.head.addChild(this.flame01);
		this.head.addChild(this.smallFlame03);
		this.head.addChild(this.Jaw_flat);
		this.head.addChild(this.lHorn1);
		this.Jaw_flat.addChild(this.Jaw);
		this.head.addChild(this.flame02);
		this.head.addChild(this.smallFlame01);
		this.head.addChild(this.flame03);
		this.rHorn3.addChild(this.rHorn4);
		this.head.addChild(this.smallFlame05);
		this.lHorn1.addChild(this.lHorn2);
		this.lHorn3.addChild(this.lHorn4);
		this.head.addChild(this.rHorn1);
		this.head.addChild(this.smallFlame02);
		this.rHorn1.addChild(this.rHorn2);
	}

	@Override
	public void render(MatrixStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		ImmutableList.of(this.head).forEach((ModelPart) -> {
			ModelPart.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	public void renderFlame(MatrixStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn,
			int packedOverlayIn) {
		this.smallFlame01.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
		this.smallFlame02.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
		this.smallFlame03.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
		this.smallFlame04.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
		this.smallFlame05.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
	}

	@Override
	public void setAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.Jaw_flat.pitch = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.4F * limbSwingAmount / 1.0F;
	}

	public void setRotateAngle(ModelPart ModelPart, float x, float y, float z) {
		ModelPart.pitch = x;
		ModelPart.yaw = y;
		ModelPart.roll = z;
	}
}