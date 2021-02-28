package mod.azure.doom.client.models;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import mod.azure.doom.entity.Cyberdemon2016Entity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Arm;

public class Cyberdemon2016Model<T extends Cyberdemon2016Entity> extends BipedEntityModel<T> {
	private List<ModelPart> ModelParts = Lists.newArrayList();
	public final ModelPart hornLeft;
	public final ModelPart hornLeft_1;
	public final ModelPart hornLeft_2;
	public final ModelPart hornRight;
	public final ModelPart hornRight_1;

	public Cyberdemon2016Model(float modelSize, boolean smallArmsIn) {
		super(RenderLayer::getEntityTranslucent, modelSize, 0.0F, 64, 64);
		this.leftArm = new ModelPart(this, 32, 48);
		this.leftArm.addCuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSize);
		this.leftArm.setPivot(5.0F, 2.0F, 0.0F);
		this.leftLeg = new ModelPart(this, 16, 48);
		this.leftLeg.addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSize);
		this.leftLeg.setPivot(1.9F, 12.0F, 0.0F);
		this.hornLeft_2 = new ModelPart(this, 40, 2);
		this.hornLeft_2.setPivot(0.0F, 0.0F, 0.0F);
		this.hornLeft_2.addCuboid(3.1F, -9.0F, 9.0F, 0.5F, 0.6F, 0.5F, 1.0F, 1.0F, 1.0F);
		this.hornLeft_1 = new ModelPart(this, 40, 2);
		this.hornLeft_1.setPivot(0.0F, 0.0F, 0.0F);
		this.hornLeft_1.addCuboid(3.1F, -8.0F, 6.5F, 0.5F, 0.6F, 0.5F, 1.0F, 2.0F, 1.0F);
		this.hornLeft = new ModelPart(this, 40, 2);
		this.hornLeft.setPivot(0.0F, 0.0F, 0.0F);
		this.hornLeft.addCuboid(3.1F, -4.7F, 6.5F, 0.5F, 0.6F, 0.5F, 0.8F, 1.0F, 0.8F);
		this.setRotateAngle(hornLeft, 1.3484414173750743F, 1.5707963267948966F, 0.0F);
		this.hornRight = new ModelPart(this, 40, 2);
		this.hornRight.setPivot(0.0F, 0.0F, 0.0F);
		this.hornRight.addCuboid(-3.6F, -4.7F, 6.5F, 0.5F, 0.6F, 0.5F, 0.8F, 1.0F, 0.8F);
		this.setRotateAngle(hornRight, 1.3484414173750743F, -1.5707963267948966F, 0.0F);
		this.hornRight_1 = new ModelPart(this, 40, 2);
		this.hornRight_1.setPivot(0.0F, 0.0F, 0.0F);
		this.hornRight_1.addCuboid(-3.6F, -8.0F, 6.5F, 0.5F, 0.6F, 0.5F, 0.7F, 2.0F, 0.8F);
		this.head.addChild(this.hornRight);
		this.hornLeft_1.addChild(this.hornLeft_2);
		this.hornLeft.addChild(this.hornLeft_1);
		this.head.addChild(this.hornLeft);
		this.hornRight.addChild(this.hornRight_1);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Iterable<ModelPart> getBodyParts() {
		return Iterables.concat(super.getBodyParts());
	}

	@Override
	public void setAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		super.setAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
	}

	public void setRotateAngle(ModelPart ModelPart, float x, float y, float z) {
		ModelPart.pitch = x;
		ModelPart.yaw = y;
		ModelPart.roll = z;
	}

	public void translateHand(Arm sideIn, MatrixStack matrixStackIn) {
		ModelPart ModelPart = this.getArm(sideIn);
		ModelPart.rotate(matrixStackIn);
	}

	public ModelPart getRandomModelPart(Random randomIn) {
		return this.ModelParts.get(randomIn.nextInt(this.ModelParts.size()));
	}

	@Override
	public void accept(ModelPart p_accept_1_) {
		if (this.ModelParts == null) {
			this.ModelParts = Lists.newArrayList();
		}

		this.ModelParts.add(p_accept_1_);
	}
}