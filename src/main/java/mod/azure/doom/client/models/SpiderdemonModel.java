package mod.azure.doom.client.models;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.CompositeEntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class SpiderdemonModel<T extends Entity> extends CompositeEntityModel<T> {
	public ModelPart spiderNeck;
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
		this.setRotateAngle(spiderLLegF_1, 0.0F, 0.0F, 2.399827721492203F);
		this.spiderRLegR = new ModelPart(this, 18, 0);
		this.spiderRLegR.setPivot(-4.0F, 15.0F, 2.0F);
		this.spiderRLegR.addCuboid(-4.0F, 1.4F, 1.0F, 8.0F, 2.0F, 2.0F, -1.8F, 0.0F, 0.0F);
		this.setRotateAngle(spiderRLegR, 0.0F, 0.0F, 0.8192575269176885F);
		this.spiderRLegF_1 = new ModelPart(this, 18, 0);
		this.spiderRLegF_1.setPivot(0.0F, 0.0F, 0.0F);
		this.spiderRLegF_1.addCuboid(-8.5F, -4.0F, -5.0F, 8.0F, 2.0F, 2.0F, 0.5F, 0.0F, -0.1F);
		this.setRotateAngle(spiderRLegF_1, 0.0F, 0.0F, -2.399827721492203F);
		this.spiderLLegR_1 = new ModelPart(this, 18, 0);
		this.spiderLLegR_1.setPivot(0.0F, 0.0F, 0.0F);
		this.spiderLLegR_1.addCuboid(0.5F, -4.0F, 2.1F, 8.0F, 2.0F, 2.0F, 0.5F, 0.0F, -0.1F);
		this.setRotateAngle(spiderLLegR_1, 0.0F, 0.0F, 2.399827721492203F);
		this.spiderLLegF = new ModelPart(this, 18, 0);
		this.spiderLLegF.setPivot(4.0F, 15.0F, -1.0F);
		this.spiderLLegF.addCuboid(-4.0F, 1.4F, -4.1F, 8.0F, 2.0F, 2.0F, -1.8F, 0.0F, 0.0F);
		this.setRotateAngle(spiderLLegF, 0.0F, 0.0F, -0.8192575269176885F);
		this.spiderNeck = new ModelPart(this, 0, 12);
		this.spiderNeck.setPivot(0.0F, 15.0F, 0.0F);
		this.spiderNeck.addCuboid(-5.0F, -4.2F, -6.0F, 10.0F, 8.0F, 12.0F, 0.0F, 0.0F, -0.7F);
		this.spiderRLegF = new ModelPart(this, 18, 0);
		this.spiderRLegF.setPivot(-4.0F, 15.0F, 0.0F);
		this.spiderRLegF.addCuboid(-4.0F, 1.4F, -5.0F, 8.0F, 2.0F, 2.0F, -1.8F, 0.0F, 0.0F);
		this.setRotateAngle(spiderRLegF, 0.0F, 0.0F, 0.8192575269176885F);
		this.spiderLLegR = new ModelPart(this, 18, 0);
		this.spiderLLegR.setPivot(4.0F, 15.0F, 1.0F);
		this.spiderLLegR.addCuboid(-4.0F, 1.4F, 2.1F, 8.0F, 2.0F, 2.0F, -1.8F, 0.0F, 0.0F);
		this.setRotateAngle(spiderLLegR, 0.0F, 0.0F, -0.8192575269176885F);
		this.spiderRLegR_1 = new ModelPart(this, 18, 0);
		this.spiderRLegR_1.setPivot(0.0F, 0.0F, 0.0F);
		this.spiderRLegR_1.addCuboid(-8.5F, -4.0F, 1.0F, 8.0F, 2.0F, 2.0F, 0.5F, 0.0F, -0.1F);
		this.setRotateAngle(spiderRLegR_1, 0.0F, 0.0F, -2.399827721492203F);
		this.spiderLLegF.addChild(this.spiderLLegF_1);
		this.spiderRLegF.addChild(this.spiderRLegF_1);
		this.spiderLLegR.addChild(this.spiderLLegR_1);
		this.spiderRLegR.addChild(this.spiderRLegR_1);
	}

	public Iterable<ModelPart> getParts() {
		return ImmutableList.of(this.spiderNeck, this.spiderRLegR, this.spiderLLegR, this.spiderRLegF,
				this.spiderLLegF);
	}

	public void setRotateAngle(ModelPart ModelPart, float x, float y, float z) {
		ModelPart.pivotX = x;
		ModelPart.pivotY = y;
		ModelPart.pivotZ = z;
	}

	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw,
			float headPitch) {
		this.spiderLLegF.pivotX = MathHelper.cos(limbAngle) * 0.2F * animationProgress;
		this.spiderLLegR.pivotX = MathHelper.cos(limbAngle + (float) Math.PI) * 0.2F * animationProgress;
		this.spiderRLegF.pivotX = MathHelper.cos(limbAngle) * 0.2F * animationProgress;
		this.spiderRLegR.pivotX = MathHelper.cos(limbAngle + (float) Math.PI) * 0.2F * animationProgress;
		
	}
}