package mod.azure.doom.client.models;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class PinkyModel<T extends Entity> extends EntityModel<T> {
	public ModelPart thighs;
	public ModelPart chest;
	public ModelPart lLeg1;
	public ModelPart rLeg1;
	public ModelPart neck;
	public ModelPart lShoulder;
	public ModelPart rShoulder;
	public ModelPart head;
	public ModelPart topJaw;
	public ModelPart lowJaw;
	public ModelPart lEye;
	public ModelPart rEye;
	public ModelPart lHorn1;
	public ModelPart rHorn1;
	public ModelPart snout;
	public ModelPart topTeeth;
	public ModelPart lowTeeth;
	public ModelPart lHorn2;
	public ModelPart lHorn3;
	public ModelPart rHorn2;
	public ModelPart rHorn3;
	public ModelPart lArm1;
	public ModelPart lArm2;
	public ModelPart rArm1;
	public ModelPart rArm2;
	public ModelPart lLeg2;
	public ModelPart lLeg3;
	public ModelPart lFoot;
	public ModelPart rLeg2;
	public ModelPart rLeg3;
	public ModelPart rFoot;

	public PinkyModel() {
		this.textureWidth = 60;
		this.textureHeight = 120;
		this.lHorn1 = new ModelPart(this, 20, 96);
		this.lHorn1.setPivot(3.0F, 1.0F, -2.0F);
		this.lHorn1.addCuboid(-1.5F, 0.0F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lHorn1, 0.2275909337942703F, 0.0F, -2.2764328155444717F);
		this.head = new ModelPart(this, 0, 51);
		this.head.setPivot(0.0F, 1.0F, -10.8F);
		this.head.addCuboid(-4.5F, -1.0F, -5.0F, 9.0F, 6.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(head, -0.13665927909957545F, 0.0F, 0.0F);
		this.rEye = new ModelPart(this, 21, 62);
		this.rEye.setPivot(-1.8F, 1.0F, -3.7F);
		this.rEye.addCuboid(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rEye, 0.13665927909957545F, 0.2275909337942703F, 0.0F);
		this.rLeg2 = new ModelPart(this, 22, 84);
		this.rLeg2.setPivot(0.0F, 5.7F, -2.5F);
		this.rLeg2.addCuboid(-2.5F, 0.0F, 0.0F, 5.0F, 8.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rLeg2, 0.956091342937205F, 0.0F, 0.0F);
		this.thighs = new ModelPart(this, 0, 18);
		this.thighs.setPivot(0.0F, 1.6F, 3.0F);
		this.thighs.addCuboid(-5.0F, 0.0F, -5.0F, 10.0F, 7.0F, 6.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(thighs, 0.18203784630933073F, 0.0F, 0.0F);
		this.rLeg1 = new ModelPart(this, 0, 83);
		this.rLeg1.setPivot(-3.0F, 5.1F, -2.0F);
		this.rLeg1.addCuboid(-3.0F, 0.0F, -2.5F, 6.0F, 6.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rLeg1, -0.6646214111173737F, 0.0F, 0.0F);
		this.rArm2 = new ModelPart(this, 36, 72);
		this.rArm2.setPivot(0.0F, 8.0F, 2.0F);
		this.rArm2.addCuboid(-2.0F, 0.0F, -4.0F, 4.0F, 10.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rArm2, -0.3642502295386026F, 0.0F, 0.0F);
		this.lFoot = new ModelPart(this, 0, 94);
		this.lFoot.setPivot(0.0F, 5.5F, 0.0F);
		this.lFoot.addCuboid(-2.5F, 0.0F, -5.0F, 5.0F, 3.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lFoot, 0.3642502295386026F, 0.0F, 0.0F);
		this.snout = new ModelPart(this, 0, 0);
		this.snout.setPivot(0.0F, 0.0F, -1.9F);
		this.snout.addCuboid(-3.5F, 0.0F, 0.0F, 7.0F, 2.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(snout, 1.1383037594559906F, 0.0F, 0.0F);
		this.lHorn2 = new ModelPart(this, 32, 96);
		this.lHorn2.setPivot(0.0F, 2.5F, 0.0F);
		this.lHorn2.addCuboid(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lHorn2, -0.3642502295386026F, 0.0F, 0.0F);
		this.lLeg1 = new ModelPart(this, 0, 83);
		this.lLeg1.setPivot(3.0F, 5.1F, -2.0F);
		this.lLeg1.addCuboid(-3.0F, 0.0F, -2.5F, 6.0F, 6.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lLeg1, -0.6646214111173737F, 0.0F, 0.0F);
		this.lShoulder = new ModelPart(this, 0, 72);
		this.lShoulder.setPivot(4.0F, -9.0F, -3.9F);
		this.lShoulder.addCuboid(-1.0F, -2.0F, -2.0F, 5.0F, 6.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lShoulder, -0.0F, 0.0F, -0.3642502295386026F);
		this.lowTeeth = new ModelPart(this, 28, 32);
		this.lowTeeth.setPivot(0.0F, 0.3F, -6.9F);
		this.lowTeeth.addCuboid(-3.0F, -2.0F, 0.0F, 6.0F, 2.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.lArm2 = new ModelPart(this, 36, 72);
		this.lArm2.setPivot(0.0F, 8.0F, 2.0F);
		this.lArm2.addCuboid(-2.0F, 0.0F, -4.0F, 4.0F, 10.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lArm2, -0.3642502295386026F, 0.0F, 0.0F);
		this.lArm1 = new ModelPart(this, 20, 72);
		this.lArm1.setPivot(1.5F, 2.0F, 0.5F);
		this.lArm1.addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.chest = new ModelPart(this, 15, 0);
		this.chest.setPivot(0.0F, 0.5F, 0.1F);
		this.chest.addCuboid(-6.0F, -10.0F, -7.0F, 12.0F, 10.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(chest, 0.2275909337942703F, 0.0F, 0.0F);
		this.lowJaw = new ModelPart(this, 0, 62);
		this.lowJaw.setPivot(0.0F, 4.0F, -0.5F);
		this.lowJaw.addCuboid(-3.5F, 0.0F, -7.0F, 7.0F, 3.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lowJaw, 0.8651597048872669F, 0.0F, 0.0F);
		this.rArm1 = new ModelPart(this, 20, 72);
		this.rArm1.setPivot(-1.5F, 2.0F, 0.5F);
		this.rArm1.addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.topJaw = new ModelPart(this, 23, 51);
		this.topJaw.setPivot(0.0F, 2.5F, -4.0F);
		this.topJaw.addCuboid(-4.0F, 0.0F, -2.0F, 8.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(topJaw, 0.2275909337942703F, 0.0F, 0.0F);
		this.rLeg3 = new ModelPart(this, 40, 86);
		this.rLeg3.setPivot(0.0F, 8.0F, 4.0F);
		this.rLeg3.addCuboid(-2.0F, 0.0F, -3.0F, 4.0F, 7.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rLeg3, -0.8651597048872669F, 0.0F, 0.0F);
		this.lHorn3 = new ModelPart(this, 40, 96);
		this.lHorn3.setPivot(0.0F, 2.5F, 0.0F);
		this.lHorn3.addCuboid(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lHorn3, -0.7285004590772052F, 0.0F, 0.0F);
		this.rHorn1 = new ModelPart(this, 20, 96);
		this.rHorn1.setPivot(-3.0F, 1.0F, -2.0F);
		this.rHorn1.addCuboid(-1.5F, 0.0F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rHorn1, 0.2275909337942703F, 0.0F, 2.2764328155444717F);
		this.lLeg2 = new ModelPart(this, 22, 84);
		this.lLeg2.setPivot(0.0F, 5.7F, -2.5F);
		this.lLeg2.addCuboid(-2.5F, 0.0F, 0.0F, 5.0F, 8.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lLeg2, 0.956091342937205F, 0.0F, 0.0F);
		this.rFoot = new ModelPart(this, 0, 94);
		this.rFoot.setPivot(0.0F, 5.5F, 0.0F);
		this.rFoot.addCuboid(-2.5F, 0.0F, -5.0F, 5.0F, 3.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rFoot, 0.3642502295386026F, 0.0F, 0.0F);
		this.neck = new ModelPart(this, 0, 31);
		this.neck.setPivot(0.0F, -10.0F, 1.0F);
		this.neck.addCuboid(-4.0F, 0.0F, -12.0F, 8.0F, 8.0F, 12.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(neck, -0.0911061832922575F, 0.0F, 0.0F);
		this.rHorn2 = new ModelPart(this, 32, 96);
		this.rHorn2.setPivot(0.0F, 2.5F, 0.0F);
		this.rHorn2.addCuboid(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rHorn2, -0.3642502295386026F, 0.0F, 0.0F);
		this.rShoulder = new ModelPart(this, 0, 72);
		this.rShoulder.setPivot(-4.0F, -9.0F, -3.8F);
		this.rShoulder.addCuboid(-4.0F, -2.0F, -2.0F, 5.0F, 6.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rShoulder, 0.0F, 0.0F, 0.3642502295386026F);
		this.topTeeth = new ModelPart(this, 26, 20);
		this.topTeeth.setPivot(0.0F, 1.8F, -1.8F);
		this.topTeeth.addCuboid(-4.0F, 0.0F, 0.0F, 8.0F, 2.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.lLeg3 = new ModelPart(this, 40, 86);
		this.lLeg3.setPivot(0.0F, 8.0F, 4.0F);
		this.lLeg3.addCuboid(-2.0F, 0.0F, -3.0F, 4.0F, 7.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lLeg3, -0.8651597048872669F, 0.0F, 0.0F);
		this.lEye = new ModelPart(this, 21, 62);
		this.lEye.setPivot(1.8F, 1.0F, -3.7F);
		this.lEye.addCuboid(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lEye, 0.13665927909957545F, -0.2275909337942703F, 0.0F);
		this.rHorn3 = new ModelPart(this, 40, 96);
		this.rHorn3.setPivot(0.0F, 2.5F, 0.0F);
		this.rHorn3.addCuboid(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rHorn3, -0.7285004590772052F, 0.0F, 0.0F);
		this.head.addChild(this.lHorn1);
		this.neck.addChild(this.head);
		this.head.addChild(this.rEye);
		this.rLeg1.addChild(this.rLeg2);
		this.thighs.addChild(this.rLeg1);
		this.rArm1.addChild(this.rArm2);
		this.lLeg3.addChild(this.lFoot);
		this.topJaw.addChild(this.snout);
		this.lHorn1.addChild(this.lHorn2);
		this.thighs.addChild(this.lLeg1);
		this.chest.addChild(this.lShoulder);
		this.lowJaw.addChild(this.lowTeeth);
		this.lArm1.addChild(this.lArm2);
		this.lShoulder.addChild(this.lArm1);
		this.thighs.addChild(this.chest);
		this.head.addChild(this.lowJaw);
		this.rShoulder.addChild(this.rArm1);
		this.head.addChild(this.topJaw);
		this.rLeg2.addChild(this.rLeg3);
		this.lHorn2.addChild(this.lHorn3);
		this.head.addChild(this.rHorn1);
		this.lLeg1.addChild(this.lLeg2);
		this.rLeg3.addChild(this.rFoot);
		this.chest.addChild(this.neck);
		this.rHorn1.addChild(this.rHorn2);
		this.chest.addChild(this.rShoulder);
		this.topJaw.addChild(this.topTeeth);
		this.lLeg2.addChild(this.lLeg3);
		this.head.addChild(this.lEye);
		this.rHorn2.addChild(this.rHorn3);
	}

	@Override
	public void render(MatrixStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		ImmutableList.of(this.thighs).forEach((ModelPart) -> {
			ModelPart.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	@Override
	public void setAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.thighs.pitch = -0.4F;
		this.chest.pitch = 0.7F;
		this.neck.yaw = 0.0F;
		this.rShoulder.pitch = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / 1.0F;
		this.lShoulder.pitch = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount
				/ 1.0F;
		this.rLeg1.pitch = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / 1.0F;
		this.lLeg1.pitch = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount / 1.0F;
	}

	public void setRotateAngle(ModelPart ModelPart, float x, float y, float z) {
		ModelPart.pitch = x;
		ModelPart.yaw = y;
		ModelPart.roll = z;
	}
}