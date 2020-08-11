package mod.azure.doom.client.models;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.CompositeEntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class SpiderdemonModel<T extends Entity> extends CompositeEntityModel<T> {
	public ModelPart spiderBody;
	public ModelPart spiderLLegF;
	public ModelPart spiderRLegR;
	public ModelPart spiderLLegR;
	public ModelPart spiderRLegF;
	public ModelPart spiderLLegF_1;
	public ModelPart spiderRLegR_1;
	public ModelPart spiderLLegR_1;
	public ModelPart spiderRLegF_1;

	public SpiderdemonModel() {
		this.spiderLLegF_1 = new ModelPart(this, 18, 0);
		this.spiderLLegF_1.setPivot(0.0F, 0.0F, 0.0F);
		this.spiderLLegF_1.addCuboid(0.5F, -4.0F, -4.1F, 8.0F, 2.0F, 2.0F, 0.5F, 0.0F, -0.1F);
		this.spiderRLegR = new ModelPart(this, 18, 0);
		this.spiderRLegR.setPivot(-4.0F, 15.0F, 2.0F);
		this.spiderRLegR.addCuboid(-4.0F, 1.4F, 1.0F, 8.0F, 2.0F, 2.0F, -1.8F, 0.0F, 0.0F);
		this.spiderRLegF_1 = new ModelPart(this, 18, 0);
		this.spiderRLegF_1.setPivot(0.0F, 0.0F, 0.0F);
		this.spiderRLegF_1.addCuboid(-8.5F, -4.0F, -5.0F, 8.0F, 2.0F, 2.0F, 0.5F, 0.0F, -0.1F);
		this.spiderLLegR_1 = new ModelPart(this, 18, 0);
		this.spiderLLegR_1.setPivot(0.0F, 0.0F, 0.0F);
		this.spiderLLegR_1.addCuboid(0.5F, -4.0F, 2.1F, 8.0F, 2.0F, 2.0F, 0.5F, 0.0F, -0.1F);
		this.spiderLLegF = new ModelPart(this, 18, 0);
		this.spiderLLegF.setPivot(4.0F, 15.0F, -1.0F);
		this.spiderLLegF.addCuboid(-4.0F, 1.4F, -4.1F, 8.0F, 2.0F, 2.0F, -1.8F, 0.0F, 0.0F);
		this.spiderBody = new ModelPart(this, 0, 12);
		this.spiderBody.setPivot(0.0F, 15.0F, 0.0F);
		this.spiderBody.addCuboid(-5.0F, -4.2F, -6.0F, 10.0F, 8.0F, 12.0F, 0.0F, 0.0F, -0.7F);
		this.spiderRLegF = new ModelPart(this, 18, 0);
		this.spiderRLegF.setPivot(-4.0F, 15.0F, 0.0F);
		this.spiderRLegF.addCuboid(-4.0F, 1.4F, -5.0F, 8.0F, 2.0F, 2.0F, -1.8F, 0.0F, 0.0F);
		this.spiderLLegR = new ModelPart(this, 18, 0);
		this.spiderLLegR.setPivot(4.0F, 15.0F, 1.0F);
		this.spiderLLegR.addCuboid(-4.0F, 1.4F, 2.1F, 8.0F, 2.0F, 2.0F, -1.8F, 0.0F, 0.0F);
		this.spiderRLegR_1 = new ModelPart(this, 18, 0);
		this.spiderRLegR_1.setPivot(0.0F, 0.0F, 0.0F);
		this.spiderRLegR_1.addCuboid(-8.5F, -4.0F, 1.0F, 8.0F, 2.0F, 2.0F, 0.5F, 0.0F, -0.1F);
		this.spiderLLegF.addChild(this.spiderLLegF_1);
		this.spiderRLegF.addChild(this.spiderRLegF_1);
		this.spiderLLegR.addChild(this.spiderLLegR_1);
		this.spiderRLegR.addChild(this.spiderRLegR_1);
	}

	public Iterable<ModelPart> getParts() {
		return ImmutableList.of(this.spiderBody, this.spiderRLegR, this.spiderLLegR, this.spiderRLegF,
				this.spiderLLegF);
	}

	@Override
	public void setAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.spiderLLegF_1.yaw = 2.399827721492203F;
		this.spiderRLegR.yaw = 0.8192575269176885F;
		this.spiderRLegF_1.yaw = -2.399827721492203F;
		this.spiderLLegR_1.yaw = 2.399827721492203F;
		this.spiderLLegF.yaw = 0.8192575269176885F;
		this.spiderLLegR.yaw = -0.8192575269176885F;
		this.spiderRLegR_1.yaw = -2.399827721492203F;
	}

	@Override
	public void animateModel(T entity, float limbAngle, float limbDistance, float tickDelta) {
		this.spiderLLegF.yaw = MathHelper.cos(limbAngle) * 0.2F * limbDistance;
		this.spiderLLegR.yaw = MathHelper.cos(limbAngle + (float) Math.PI) * 0.2F * limbDistance;
		this.spiderRLegF.yaw = MathHelper.cos(limbAngle) * 0.2F * limbDistance;
		this.spiderRLegR.yaw = MathHelper.cos(limbAngle + (float) Math.PI) * 0.2F * limbDistance;
	}
}