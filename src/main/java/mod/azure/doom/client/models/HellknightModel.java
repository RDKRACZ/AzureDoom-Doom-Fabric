package mod.azure.doom.client.models;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class HellknightModel<T extends Entity> extends EntityModel<T> {
	public ModelPart thighs;
	public ModelPart rLeg1_flat;
	public ModelPart lLeg1_flat;
	public ModelPart chest;
	public ModelPart neck;
	public ModelPart rShoulder;
	public ModelPart rightPec;
	public ModelPart leftPec;
	public ModelPart lShoulder;
	public ModelPart head;
	public ModelPart lHorn1;
	public ModelPart rHorn1;
	public ModelPart topJaw;
	public ModelPart lowJaw;
	public ModelPart lHorn2;
	public ModelPart lHorn3;
	public ModelPart lHorn4;
	public ModelPart rHorn2;
	public ModelPart rHorn3;
	public ModelPart rHorn4;
	public ModelPart snout;
	public ModelPart rMHorn1;
	public ModelPart lMHorn1;
	public ModelPart rMHorn2;
	public ModelPart lMHorn2;
	public ModelPart rArm1;
	public ModelPart rArm2;
	public ModelPart lArm1;
	public ModelPart lArm2;
	public ModelPart rLeg1;
	public ModelPart rLeg2;
	public ModelPart rLeg3;
	public ModelPart rFoot;
	public ModelPart lLeg1;
	public ModelPart lLeg2;
	public ModelPart lLeg3;
	public ModelPart lFoot;

	public HellknightModel() {
		this.textureWidth = 60;
		this.textureHeight = 150;
		this.neck = new ModelPart(this, 0, 36);
		this.neck.setPivot(0.0F, -8.6F, -1.1F);
		this.neck.addCuboid(-4.0F, -7.0F, -6.0F, 8.0F, 7.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(neck, -0.04555309164612875F, 0.0F, 0.0F);
		this.lowJaw = new ModelPart(this, 0, 123);
		this.lowJaw.setPivot(0.0F, -1.0F, -6.5F);
		this.lowJaw.addCuboid(-3.0F, -1.0F, -5.0F, 6.0F, 2.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lowJaw, -0.04555309164612875F, 0.0F, 0.0F);
		this.rHorn3 = new ModelPart(this, 16, 131);
		this.rHorn3.setPivot(0.0F, -4.0F, 0.0F);
		this.rHorn3.addCuboid(-1.5F, -4.0F, -3.0F, 3.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rHorn3, 0.500909508638178F, 0.0F, 0.0F);
		this.lHorn1 = new ModelPart(this, 26, 121);
		this.lHorn1.setPivot(3.0F, -9.0F, -2.5F);
		this.lHorn1.addCuboid(-2.5F, -3.0F, -2.5F, 5.0F, 3.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lHorn1, 0.0F, 0.0F, 0.5462880092689061F);
		this.rLeg1_flat = new ModelPart(this, 20, 62);
		this.rLeg1_flat.setPivot(-3.5F, -0.3F, 3.0F);
		this.rLeg1_flat.addCuboid(-3.0F, 0.0F, -3.5F, 2.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.rShoulder = new ModelPart(this, 0, 51);
		this.rShoulder.mirror = true;
		this.rShoulder.setPivot(-7.0F, -7.5F, -4.0F);
		this.rShoulder.addCuboid(-5.0F, -2.0F, -3.5F, 6.0F, 6.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rShoulder, 0.0F, 0.0F, 0.0911061832922575F);
		this.lLeg3 = new ModelPart(this, 25, 67);
		this.lLeg3.setPivot(0.0F, 9.0F, 4.5F);
		this.lLeg3.addCuboid(-2.5F, 0.0F, -4.0F, 5.0F, 10.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lLeg3, -0.9105382388075086F, 0.0F, 0.0F);
		this.lHorn3 = new ModelPart(this, 16, 131);
		this.lHorn3.setPivot(0.0F, -4.0F, 0.0F);
		this.lHorn3.addCuboid(-1.5F, -4.0F, -3.0F, 3.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lHorn3, 0.500909508638178F, 0.0F, 0.0F);
		this.lMHorn1 = new ModelPart(this, 0, 102);
		this.lMHorn1.setPivot(1.5F, 0.1F, -4.0F);
		this.lMHorn1.addCuboid(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lMHorn1, -0.3186971254089062F, -0.45535640450848164F, 0.0F);
		this.rArm2 = new ModelPart(this, 0, 64);
		this.rArm2.setPivot(0.0F, 5.8F, 2.5F);
		this.rArm2.addCuboid(-2.5F, 0.0F, -4.0F, 5.0F, 11.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rArm2, -0.27314400463445304F, 0.0F, -0.0911061832922575F);
		this.rHorn2 = new ModelPart(this, 0, 131);
		this.rHorn2.setPivot(0.0F, -2.0F, 2.0F);
		this.rHorn2.addCuboid(-2.0F, -4.0F, -4.0F, 4.0F, 4.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rHorn2, 0.6829473549475088F, 0.0F, -0.4098033003787853F);
		this.rHorn4 = new ModelPart(this, 28, 131);
		this.rHorn4.setPivot(0.0F, -4.0F, 0.0F);
		this.rHorn4.addCuboid(-1.0F, -4.0F, -2.0F, 2.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rHorn4, 0.6373942508178124F, 0.0F, 0.0F);
		this.lMHorn2 = new ModelPart(this, 0, 107);
		this.lMHorn2.setPivot(0.0F, 1.0F, -2.9F);
		this.lMHorn2.addCuboid(-0.5F, -2.0F, -3.0F, 1.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lMHorn2, -0.956091342937205F, 0.0F, 0.0F);
		this.lHorn4 = new ModelPart(this, 28, 131);
		this.lHorn4.setPivot(0.0F, -4.0F, 0.0F);
		this.lHorn4.addCuboid(-1.0F, -4.0F, -2.0F, 2.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lHorn4, 0.6373942508178124F, 0.0F, 0.0F);
		this.rLeg2 = new ModelPart(this, 0, 79);
		this.rLeg2.setPivot(0.0F, 10.5F, -3.0F);
		this.rLeg2.addCuboid(-3.0F, 0.0F, -0.5F, 6.0F, 9.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rLeg2, 1.092750655326294F, 0.0F, -0.04555309164612875F);
		this.head = new ModelPart(this, 13, 94);
		this.head.setPivot(0.0F, -2.8F, 0.5F);
		this.head.addCuboid(-5.0F, -11.0F, -7.0F, 10.0F, 11.0F, 9.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(head, 0.0911061832922575F, 0.0F, 0.0F);
		this.rightPec = new ModelPart(this, 32, 36);
		this.rightPec.mirror = true;
		this.rightPec.setPivot(-3.8F, -5.5F, -6.5F);
		this.rightPec.addCuboid(-3.5F, -3.5F, -3.0F, 7.0F, 7.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rightPec, 0.0F, 0.0F, -0.08726646259971647F);
		this.rLeg3 = new ModelPart(this, 25, 67);
		this.rLeg3.setPivot(0.0F, 9.0F, 4.5F);
		this.rLeg3.addCuboid(-2.5F, 0.0F, -4.0F, 5.0F, 10.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rLeg3, -0.9105382388075086F, 0.0F, 0.0F);
		this.thighs = new ModelPart(this, 0, 18);
		this.thighs.setPivot(0.0F, -7.0F, 5.0F);
		this.thighs.addCuboid(-5.5F, 0.0F, -7.0F, 11.0F, 10.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.rArm1 = new ModelPart(this, 26, 51);
		this.rArm1.mirror = true;
		this.rArm1.setPivot(-2.0F, 4.0F, 0.0F);
		this.rArm1.addCuboid(-2.5F, 0.0F, -2.5F, 5.0F, 6.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.lArm1 = new ModelPart(this, 26, 51);
		this.lArm1.mirror = true;
		this.lArm1.setPivot(2.0F, 4.0F, 0.0F);
		this.lArm1.addCuboid(-2.5F, 0.0F, -2.5F, 5.0F, 6.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.rMHorn1 = new ModelPart(this, 0, 102);
		this.rMHorn1.setPivot(-1.5F, 0.1F, -4.0F);
		this.rMHorn1.addCuboid(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rMHorn1, -0.3186971254089062F, 0.45535640450848164F, 0.0F);
		this.rMHorn2 = new ModelPart(this, 0, 107);
		this.rMHorn2.setPivot(0.0F, 1.0F, -2.9F);
		this.rMHorn2.addCuboid(-0.5F, -2.0F, -3.0F, 1.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rMHorn2, -0.956091342937205F, 0.0F, 0.0F);
		this.chest = new ModelPart(this, 0, 0);
		this.chest.setPivot(0.0F, 1.2F, 0.2F);
		this.chest.addCuboid(-7.0F, -9.0F, -9.0F, 14.0F, 8.0F, 10.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(chest, 0.13665927909957545F, 0.0F, 0.0F);
		this.rFoot = new ModelPart(this, 0, 93);
		this.rFoot.setPivot(0.0F, 9.0F, -2.0F);
		this.rFoot.addCuboid(-3.0F, 0.0F, -3.0F, 6.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rFoot, 0.2275909337942703F, 0.0F, 0.0F);
		this.rHorn1 = new ModelPart(this, 26, 121);
		this.rHorn1.setPivot(-3.0F, -9.0F, -2.5F);
		this.rHorn1.addCuboid(-2.5F, -3.0F, -2.5F, 5.0F, 3.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rHorn1, 0.0F, 0.0F, -0.5462880092689061F);
		this.snout = new ModelPart(this, 24, 114);
		this.snout.setPivot(0.0F, -2.0F, -5.0F);
		this.snout.addCuboid(-3.0F, 0.0F, 0.0F, 6.0F, 2.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(snout, 0.27314400463445304F, 0.0F, 0.0F);
		this.lLeg1 = new ModelPart(this, 20, 62);
		this.lLeg1.setPivot(0.0F, 0.0F, 0.0F);
		this.lLeg1.addCuboid(-3.5F, 0.0F, -3.5F, 7.0F, 11.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lLeg1, -0.4098033003787853F, 0.0F, -0.04555309164612875F);
		this.lLeg2 = new ModelPart(this, 0, 79);
		this.lLeg2.setPivot(0.0F, 10.5F, -3.0F);
		this.lLeg2.addCuboid(-3.0F, 0.0F, -0.5F, 6.0F, 9.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lLeg2, 1.092750655326294F, 0.0F, 0.04555309164612875F);
		this.lLeg1_flat = new ModelPart(this, 20, 62);
		this.lLeg1_flat.setPivot(3.5F, -0.3F, 3.0F);
		this.lLeg1_flat.addCuboid(-3.5F, 0.0F, -3.5F, 7.0F, 11.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.leftPec = new ModelPart(this, 32, 36);
		this.leftPec.setPivot(3.8F, -5.5F, -6.5F);
		this.leftPec.addCuboid(-3.5F, -3.5F, -3.0F, 7.0F, 7.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(leftPec, 0.0F, 0.0F, 0.08726646259971647F);
		this.lFoot = new ModelPart(this, 0, 93);
		this.lFoot.setPivot(0.0F, 9.0F, -2.0F);
		this.lFoot.addCuboid(-3.0F, 0.0F, -3.0F, 6.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lFoot, 0.2275909337942703F, 0.0F, 0.0F);
		this.lHorn2 = new ModelPart(this, 0, 131);
		this.lHorn2.setPivot(0.0F, -2.0F, 2.0F);
		this.lHorn2.addCuboid(-2.0F, -4.0F, -4.0F, 4.0F, 4.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lHorn2, 0.6829473549475088F, 0.0F, 0.4098033003787853F);
		this.lArm2 = new ModelPart(this, 0, 64);
		this.lArm2.setPivot(0.0F, 5.8F, 2.5F);
		this.lArm2.addCuboid(-2.5F, 0.0F, -4.0F, 5.0F, 11.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lArm2, -0.27314400463445304F, 0.0F, 0.0911061832922575F);
		this.lShoulder = new ModelPart(this, 0, 51);
		this.lShoulder.mirror = true;
		this.lShoulder.setPivot(7.0F, -7.5F, -4.0F);
		this.lShoulder.addCuboid(-1.0F, -2.0F, -3.5F, 6.0F, 6.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lShoulder, -0.0F, 0.0F, -0.0911061832922575F);
		this.rLeg1 = new ModelPart(this, 20, 62);
		this.rLeg1.setPivot(0.0F, 0.0F, 0.0F);
		this.rLeg1.addCuboid(-3.5F, 0.0F, -3.5F, 7.0F, 11.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rLeg1, -0.4098033003787853F, 0.0F, 0.04555309164612875F);
		this.topJaw = new ModelPart(this, 0, 114);
		this.topJaw.setPivot(0.0F, -4.0F, -6.8F);
		this.topJaw.addCuboid(-3.5F, -2.0F, -5.0F, 7.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.chest.addChild(this.neck);
		this.head.addChild(this.lowJaw);
		this.rHorn2.addChild(this.rHorn3);
		this.head.addChild(this.lHorn1);
		this.chest.addChild(this.rShoulder);
		this.lLeg2.addChild(this.lLeg3);
		this.lHorn2.addChild(this.lHorn3);
		this.lowJaw.addChild(this.lMHorn1);
		this.rArm1.addChild(this.rArm2);
		this.rHorn1.addChild(this.rHorn2);
		this.rHorn3.addChild(this.rHorn4);
		this.lMHorn1.addChild(this.lMHorn2);
		this.lHorn3.addChild(this.lHorn4);
		this.rLeg1.addChild(this.rLeg2);
		this.neck.addChild(this.head);
		this.chest.addChild(this.rightPec);
		this.rLeg2.addChild(this.rLeg3);
		this.rShoulder.addChild(this.rArm1);
		this.lShoulder.addChild(this.lArm1);
		this.lowJaw.addChild(this.rMHorn1);
		this.rMHorn1.addChild(this.rMHorn2);
		this.thighs.addChild(this.chest);
		this.rLeg3.addChild(this.rFoot);
		this.head.addChild(this.rHorn1);
		this.topJaw.addChild(this.snout);
		this.lLeg1_flat.addChild(this.lLeg1);
		this.lLeg1.addChild(this.lLeg2);
		this.chest.addChild(this.leftPec);
		this.lLeg3.addChild(this.lFoot);
		this.lHorn1.addChild(this.lHorn2);
		this.lArm1.addChild(this.lArm2);
		this.chest.addChild(this.lShoulder);
		this.rLeg1_flat.addChild(this.rLeg1);
		this.head.addChild(this.topJaw);
	}

	@Override
	public void render(MatrixStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		ImmutableList.of(this.rLeg1_flat, this.thighs, this.lLeg1_flat).forEach((ModelPart) -> {
			ModelPart.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	@Override
	public void setAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.rShoulder.pitch = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / 1.0F;
		this.lShoulder.pitch = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount / 1.0F;
		this.rLeg1_flat.pitch = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / 1.0F;
		this.lLeg1_flat.pitch = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount / 1.0F;
	}

	public void setRotateAngle(ModelPart ModelPart, float x, float y, float z) {
		ModelPart.pitch = x;
		ModelPart.yaw = y;
		ModelPart.roll = z;
	}

}