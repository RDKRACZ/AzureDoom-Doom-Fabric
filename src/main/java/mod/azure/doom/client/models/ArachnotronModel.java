package mod.azure.doom.client.models;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * Arachnotron - Batpixxler Created using Tabula 8.0.0
 */
public class ArachnotronModel<T extends Entity> extends EntityModel<T> {
	public ModelPart lLeg1_1_flat;
    public ModelPart lLeg2_1_flat;
    public ModelPart base;
    public ModelPart rLeg2_1_flat;
    public ModelPart rLeg1_1_flat;
    public ModelPart lLeg1_1;
    public ModelPart lArm;
    public ModelPart lLeg1_2;
    public ModelPart lLeg1_3;
    public ModelPart lLeg1_4;
    public ModelPart lLeg1_5;
    public ModelPart lLeg2_1;
    public ModelPart lLeg2_2;
    public ModelPart lLeg2_3;
    public ModelPart lLeg2_4;
    public ModelPart lLeg2_5;
    public ModelPart gunBase;
    public ModelPart body;
    public ModelPart gunBarrel;
    public ModelPart topR;
    public ModelPart head;
    public ModelPart topL;
    public ModelPart lowJaw;
    public ModelPart lEye;
    public ModelPart rEye;
    public ModelPart topJaw;
    public ModelPart lowTeeth;
    public ModelPart topTeeth;
    public ModelPart rLeg2_1;
    public ModelPart rLeg2_2;
    public ModelPart rLeg2_3;
    public ModelPart rLeg2_4;
    public ModelPart rLeg2_5;
    public ModelPart rLeg1_1;
    public ModelPart rLeg1_2;
    public ModelPart rArm;
    public ModelPart rLeg1_3;
    public ModelPart rLeg1_4;
    public ModelPart rLeg1_5;

	public ArachnotronModel() {
		this.textureWidth = 100;
        this.textureHeight = 130;
        this.lLeg1_5 = new ModelPart(this, 36, 33);
        this.lLeg1_5.setPivot(0.0F, 5.2F, 0.0F);
        this.lLeg1_5.addCuboid(-4.0F, 0.0F, -4.0F, 8.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lLeg1_5, 0.27314400463445304F, 0.0F, 0.0F);
        this.lLeg2_1_flat = new ModelPart(this, 0, 33);
        this.lLeg2_1_flat.setPivot(8.0F, 10.0F, 9.0F);
        this.lLeg2_1_flat.addCuboid(-2.0F, 0.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.topL = new ModelPart(this, 0, 55);
        this.topL.setPivot(-1.0F, -10.5F, 0.0F);
        this.topL.addCuboid(-9.0F, -5.0F, -9.5F, 10.0F, 5.0F, 19.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(topL, 0.0F, 0.0F, -0.27314400463445304F);
        this.lLeg2_1 = new ModelPart(this, 0, 33);
        this.lLeg2_1.setPivot(0.0F, 0.0F, 0.0F);
        this.lLeg2_1.addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 22.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lLeg2_1, 1.921607479814146F, 0.591841146688116F, 0.0F);
        this.lowJaw = new ModelPart(this, 0, 59);
        this.lowJaw.setPivot(0.0F, 6.0F, 0.0F);
        this.lowJaw.addCuboid(-2.5F, 0.0F, -2.0F, 5.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lowJaw, 0.591841146688116F, 0.0F, 0.0F);
        this.rLeg1_1 = new ModelPart(this, 0, 33);
        this.rLeg1_1.setPivot(0.0F, 0.0F, 0.0F);
        this.rLeg1_1.addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 22.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rLeg1_1, -1.921607479814146F, 0.591841146688116F, 0.0F);
        this.body = new ModelPart(this, 0, 0);
        this.body.setPivot(0.0F, -2.0F, 0.0F);
        this.body.addCuboid(-10.5F, -11.0F, -10.0F, 21.0F, 13.0F, 20.0F, 0.0F, 0.0F, 0.0F);
        this.lLeg1_1_flat = new ModelPart(this, 0, 33);
        this.lLeg1_1_flat.setPivot(8.0F, 10.5F, -9.0F);
        this.lLeg1_1_flat.addCuboid(-2.0F, 0.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.rLeg1_1_flat = new ModelPart(this, 0, 33);
        this.rLeg1_1_flat.setPivot(-7.0F, 10.5F, -9.0F);
        this.rLeg1_1_flat.addCuboid(-2.0F, 0.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.lArm = new ModelPart(this, 27, 44);
        this.lArm.setPivot(0.0F, 10.0F, -1.0F);
        this.lArm.addCuboid(-1.0F, -1.0F, -9.0F, 2.0F, 2.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lArm, -0.956091342937205F, 0.0F, 0.0F);
        this.rLeg2_1 = new ModelPart(this, 0, 33);
        this.rLeg2_1.setPivot(0.0F, 0.0F, 0.0F);
        this.rLeg2_1.addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 22.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rLeg2_1, 1.921607479814146F, -0.591841146688116F, 0.0F);
        this.rArm = new ModelPart(this, 27, 44);
        this.rArm.setPivot(0.0F, 10.0F, -1.0F);
        this.rArm.addCuboid(-1.0F, -1.0F, -9.0F, 2.0F, 2.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rArm, -0.956091342937205F, 0.0F, 0.0F);
        this.lEye = new ModelPart(this, 0, 0);
        this.lEye.mirror = true;
        this.lEye.setPivot(2.5F, 5.0F, -0.9F);
        this.lEye.addCuboid(0.0F, -5.0F, 0.0F, 7.0F, 5.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lEye, 0.0F, 0.0F, -0.6373942508178124F);
        this.rLeg1_3 = new ModelPart(this, 0, 33);
        this.rLeg1_3.setPivot(0.0F, 3.0F, 0.0F);
        this.rLeg1_3.addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 22.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rLeg1_3, 0.6829473549475088F, 0.0F, 0.0F);
        this.rLeg2_1_flat = new ModelPart(this, 0, 33);
        this.rLeg2_1_flat.setPivot(-7.0F, 10.0F, 9.0F);
        this.rLeg2_1_flat.addCuboid(-2.0F, 0.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.lLeg1_3 = new ModelPart(this, 0, 33);
        this.lLeg1_3.setPivot(0.0F, 3.0F, 0.0F);
        this.lLeg1_3.addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 22.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lLeg1_3, 0.6829473549475088F, 0.0F, 0.0F);
        this.rLeg1_2 = new ModelPart(this, 16, 33);
        this.rLeg1_2.setPivot(0.0F, 21.0F, 0.0F);
        this.rLeg1_2.addCuboid(-2.5F, 0.0F, -2.5F, 5.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rLeg1_2, 0.4098033003787853F, 0.0F, 0.0F);
        this.rLeg2_2 = new ModelPart(this, 16, 33);
        this.rLeg2_2.setPivot(0.0F, 21.0F, 0.0F);
        this.rLeg2_2.addCuboid(-2.5F, 0.0F, -2.5F, 5.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rLeg2_2, -0.4098033003787853F, 0.0F, 0.0F);
        this.rLeg2_3 = new ModelPart(this, 0, 33);
        this.rLeg2_3.setPivot(0.0F, 3.0F, 0.0F);
        this.rLeg2_3.addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 22.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rLeg2_3, -0.6829473549475088F, 0.0F, 0.0F);
        this.lLeg2_5 = new ModelPart(this, 36, 33);
        this.lLeg2_5.setPivot(0.0F, 5.2F, 0.0F);
        this.lLeg2_5.addCuboid(-4.0F, 0.0F, -4.0F, 8.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lLeg2_5, -0.27314400463445304F, 0.0F, 0.0F);
        this.lLeg2_2 = new ModelPart(this, 16, 33);
        this.lLeg2_2.setPivot(0.0F, 21.0F, 0.0F);
        this.lLeg2_2.addCuboid(-2.5F, 0.0F, -2.5F, 5.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lLeg2_2, -0.4098033003787853F, 0.0F, 0.0F);
        this.topJaw = new ModelPart(this, 0, 11);
        this.topJaw.setPivot(0.0F, 4.0F, 0.0F);
        this.topJaw.addCuboid(-2.5F, 0.0F, -2.0F, 5.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.rLeg2_5 = new ModelPart(this, 36, 33);
        this.rLeg2_5.setPivot(0.0F, 5.2F, 0.0F);
        this.rLeg2_5.addCuboid(-4.0F, 0.0F, -4.0F, 8.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rLeg2_5, -0.27314400463445304F, 0.0F, 0.0F);
        this.head = new ModelPart(this, 0, 6);
        this.head.setPivot(0.0F, -8.3F, -10.0F);
        this.head.addCuboid(-2.0F, 0.0F, -1.0F, 4.0F, 4.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.topR = new ModelPart(this, 0, 55);
        this.topR.setPivot(1.0F, -10.5F, 0.0F);
        this.topR.addCuboid(-1.0F, -5.0F, -9.5F, 10.0F, 5.0F, 19.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(topR, 0.0F, 0.0F, 0.27314400463445304F);
        this.topTeeth = new ModelPart(this, 0, 15);
        this.topTeeth.setPivot(0.0F, 1.4F, -1.9F);
        this.topTeeth.addCuboid(-2.0F, 0.0F, 0.0F, 4.0F, 1.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.rLeg1_4 = new ModelPart(this, 16, 42);
        this.rLeg1_4.setPivot(0.0F, 21.0F, 0.0F);
        this.rLeg1_4.addCuboid(-2.5F, 0.0F, -2.5F, 5.0F, 6.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rLeg1_4, 0.5462880092689061F, 0.0F, 0.0F);
        this.lLeg2_4 = new ModelPart(this, 16, 42);
        this.lLeg2_4.setPivot(0.0F, 21.0F, 0.0F);
        this.lLeg2_4.addCuboid(-2.5F, 0.0F, -2.5F, 5.0F, 6.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lLeg2_4, -0.5462880092689061F, 0.0F, 0.0F);
        this.rEye = new ModelPart(this, 0, 0);
        this.rEye.setPivot(-2.0F, 5.0F, -0.9F);
        this.rEye.addCuboid(-7.0F, -5.0F, 0.0F, 7.0F, 5.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rEye, 0.0F, 0.0F, 0.6373942508178124F);
        this.lowTeeth = new ModelPart(this, 0, 64);
        this.lowTeeth.setPivot(-1.5F, -0.4F, -1.6F);
        this.lowTeeth.addCuboid(0.0F, 0.0F, 0.0F, 3.0F, 1.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.gunBarrel = new ModelPart(this, 54, 43);
        this.gunBarrel.setPivot(0.0F, 0.5F, 0.0F);
        this.gunBarrel.addCuboid(-2.0F, 0.0F, -4.0F, 4.0F, 4.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.lLeg1_2 = new ModelPart(this, 16, 33);
        this.lLeg1_2.setPivot(0.0F, 21.0F, 0.0F);
        this.lLeg1_2.addCuboid(-2.5F, 0.0F, -2.5F, 5.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lLeg1_2, 0.4098033003787853F, 0.0F, 0.0F);
        this.rLeg2_4 = new ModelPart(this, 16, 42);
        this.rLeg2_4.setPivot(0.0F, 21.0F, 0.0F);
        this.rLeg2_4.addCuboid(-2.5F, 0.0F, -2.5F, 5.0F, 6.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rLeg2_4, -0.5462880092689061F, 0.0F, 0.0F);
        this.lLeg1_4 = new ModelPart(this, 16, 42);
        this.lLeg1_4.setPivot(0.0F, 21.0F, 0.0F);
        this.lLeg1_4.addCuboid(-2.5F, 0.0F, -2.5F, 5.0F, 6.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lLeg1_4, 0.5462880092689061F, 0.0F, 0.0F);
        this.base = new ModelPart(this, 0, 79);
        this.base.setPivot(0.0F, 7.5F, 0.0F);
        this.base.addCuboid(-11.5F, 0.0F, -11.5F, 23.0F, 7.0F, 23.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(base, 0.0F, 0.0F, -0.006283185556850939F);
        this.lLeg2_3 = new ModelPart(this, 0, 33);
        this.lLeg2_3.setPivot(0.0F, 3.0F, 0.0F);
        this.lLeg2_3.addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 22.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lLeg2_3, -0.6829473549475088F, 0.0F, 0.0F);
        this.lLeg1_1 = new ModelPart(this, 0, 33);
        this.lLeg1_1.setPivot(0.0F, 0.0F, 0.0F);
        this.lLeg1_1.addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 22.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lLeg1_1, -1.9228292049642197F, -0.591841146688116F, 0.0F);
        this.gunBase = new ModelPart(this, 40, 43);
        this.gunBase.setPivot(0.0F, 0.2F, -13.0F);
        this.gunBase.addCuboid(-2.5F, 0.0F, 0.0F, 5.0F, 5.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.rLeg1_5 = new ModelPart(this, 36, 33);
        this.rLeg1_5.setPivot(0.0F, 5.2F, 0.0F);
        this.rLeg1_5.addCuboid(-4.0F, 0.0F, -4.0F, 8.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rLeg1_5, 0.27314400463445304F, 0.0F, 0.0F);
        this.lLeg1_4.addChild(this.lLeg1_5);
        this.body.addChild(this.topL);
        this.lLeg2_1_flat.addChild(this.lLeg2_1);
        this.head.addChild(this.lowJaw);
        this.rLeg1_1_flat.addChild(this.rLeg1_1);
        this.base.addChild(this.body);
        this.lLeg1_1.addChild(this.lArm);
        this.rLeg2_1_flat.addChild(this.rLeg2_1);
        this.rLeg1_1.addChild(this.rArm);
        this.head.addChild(this.lEye);
        this.rLeg1_2.addChild(this.rLeg1_3);
        this.lLeg1_2.addChild(this.lLeg1_3);
        this.rLeg1_1.addChild(this.rLeg1_2);
        this.rLeg2_1.addChild(this.rLeg2_2);
        this.rLeg2_2.addChild(this.rLeg2_3);
        this.lLeg2_4.addChild(this.lLeg2_5);
        this.lLeg2_1.addChild(this.lLeg2_2);
        this.head.addChild(this.topJaw);
        this.rLeg2_4.addChild(this.rLeg2_5);
        this.body.addChild(this.head);
        this.body.addChild(this.topR);
        this.topJaw.addChild(this.topTeeth);
        this.rLeg1_3.addChild(this.rLeg1_4);
        this.lLeg2_3.addChild(this.lLeg2_4);
        this.head.addChild(this.rEye);
        this.lowJaw.addChild(this.lowTeeth);
        this.gunBase.addChild(this.gunBarrel);
        this.lLeg1_1.addChild(this.lLeg1_2);
        this.rLeg2_3.addChild(this.rLeg2_4);
        this.lLeg1_3.addChild(this.lLeg1_4);
        this.lLeg2_2.addChild(this.lLeg2_3);
        this.lLeg1_1_flat.addChild(this.lLeg1_1);
        this.base.addChild(this.gunBase);
        this.rLeg1_4.addChild(this.rLeg1_5);
	}
	
	@Override
    public void render(MatrixStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.lLeg2_1_flat, this.lLeg1_1_flat, this.rLeg1_1_flat, this.rLeg2_1_flat, this.base).forEach((ModelPart) -> { 
					ModelPart.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

	@Override
	public void setAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.rLeg1_1_flat.pitch = MathHelper.cos(limbSwing * 0.6662F) * 0.4F * limbSwingAmount / 1.0F;
		this.lLeg1_1_flat.pitch = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.4F * limbSwingAmount
				/ 1.0F;
		this.rLeg1_1_flat.pitch = MathHelper.cos(limbSwing * 0.6662F) * 0.4F * limbSwingAmount / 1.0F;
		this.lLeg2_1_flat.pitch = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.4F * limbSwingAmount
				/ 1.0F;
	}

	public void setRotateAngle(ModelPart ModelPart, float x, float y, float z) {
		ModelPart.pitch = x;
		ModelPart.yaw = y;
		ModelPart.roll = z;
	}
}