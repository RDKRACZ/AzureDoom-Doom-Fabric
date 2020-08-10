package mod.azure.doom.client.models;

import com.google.common.collect.ImmutableList;

import mod.azure.doom.entity.HellknightEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.CompositeEntityModel;
import net.minecraft.util.math.MathHelper;

public class HellknightModel<T extends HellknightEntity> extends CompositeEntityModel<T> {
	private final ModelPart ironGolemHead;
	private final ModelPart ironGolemBody;
	private final ModelPart ironGolemRightArm;
	private final ModelPart ironGolemLeftArm;
	private final ModelPart ironGolemLeftLeg;
	private final ModelPart ironGolemRightLeg;

	public HellknightModel() {
		this.ironGolemHead = (new ModelPart(this)).setTextureSize(128, 128);
		this.ironGolemHead.setPivot(0.0F, -7.0F, -2.0F);
		this.ironGolemHead.setTextureOffset(0, 0).addCuboid(-4.0F, -12.0F, -5.5F, 8.0F, 10.0F, 8.0F, 0.0F);
		this.ironGolemHead.setTextureOffset(24, 0).addCuboid(-1.0F, -5.0F, -7.5F, 2.0F, 4.0F, 2.0F, 0.0F);
		this.ironGolemBody = (new ModelPart(this)).setTextureSize(128, 128);
		this.ironGolemBody.setPivot(0.0F, -7.0F, 0.0F);
		this.ironGolemBody.setTextureOffset(0, 40).addCuboid(-9.0F, -2.0F, -6.0F, 18.0F, 12.0F, 11.0F, 0.0F);
		this.ironGolemBody.setTextureOffset(0, 70).addCuboid(-4.5F, 10.0F, -3.0F, 9.0F, 5.0F, 6.0F, 0.5F);
		this.ironGolemRightArm = (new ModelPart(this)).setTextureSize(128, 128);
		this.ironGolemRightArm.setPivot(0.0F, -7.0F, 0.0F);
		this.ironGolemRightArm.setTextureOffset(60, 21).addCuboid(-13.0F, -2.5F, -3.0F, 4.0F, 30.0F, 6.0F, 0.0F);
		this.ironGolemLeftArm = (new ModelPart(this)).setTextureSize(128, 128);
		this.ironGolemLeftArm.setPivot(0.0F, -7.0F, 0.0F);
		this.ironGolemLeftArm.setTextureOffset(60, 58).addCuboid(9.0F, -2.5F, -3.0F, 4.0F, 30.0F, 6.0F, 0.0F);
		this.ironGolemLeftLeg = (new ModelPart(this, 0, 22)).setTextureSize(128, 128);
		this.ironGolemLeftLeg.setPivot(-4.0F, 11.0F, 0.0F);
		this.ironGolemLeftLeg.setTextureOffset(37, 0).addCuboid(-3.5F, -3.0F, -3.0F, 6.0F, 16.0F, 5.0F, 0.0F);
		this.ironGolemRightLeg = (new ModelPart(this, 0, 22)).setTextureSize(128, 128);
		this.ironGolemRightLeg.mirror = true;
		this.ironGolemRightLeg.setTextureOffset(60, 0).setPivot(5.0F, 11.0F, 0.0F);
		this.ironGolemRightLeg.addCuboid(-3.5F, -3.0F, -3.0F, 6.0F, 16.0F, 5.0F, 0.0F);
	}

	public Iterable<ModelPart> getParts() {
		return ImmutableList.of(this.ironGolemHead, this.ironGolemBody, this.ironGolemLeftLeg, this.ironGolemRightLeg,
				this.ironGolemRightArm, this.ironGolemLeftArm);
	}
	
	public void animateModel(T ironGolemEntity, float f, float g, float h) {
		this.ironGolemRightArm.pitch = (-0.2F + 1.5F * MathHelper.method_24504(f, 13.0F)) * g;
		this.ironGolemLeftArm.pitch = (-0.2F - 1.5F * MathHelper.method_24504(f, 13.0F)) * g;
	}


	private float triangleWave(float p_78172_1_, float p_78172_2_) {
		return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / (p_78172_2_ * 0.25F);
	}

	public ModelPart getArmHoldingRose() {
		return this.ironGolemRightArm;
	}
	
	@Override
	public void setAngles(T entity, float limbSwing, float limbSwingAmount, float animationProgress, float netHeadYaw,
			float headPitch) {
		this.ironGolemHead.pivotY = netHeadYaw * ((float) Math.PI / 180F);
		this.ironGolemHead.pivotX = headPitch * ((float) Math.PI / 180F);
		this.ironGolemLeftLeg.pivotX = -1.5F * this.triangleWave(limbSwing, 13.0F) * limbSwingAmount;
		this.ironGolemRightLeg.pivotX = 1.5F * this.triangleWave(limbSwing, 13.0F) * limbSwingAmount;
		this.ironGolemLeftLeg.pivotY = 0.0F;
		this.ironGolemRightLeg.pivotY = 0.0F;
	}
}