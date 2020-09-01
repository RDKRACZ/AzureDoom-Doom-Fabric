package mod.azure.doom.client.models;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class CacodemonModel<T extends Entity> extends EntityModel<T> {
	public ModelPart leftHorn_top_front;
	public ModelPart rightHorn_bottom;
	public ModelPart leftHorn_top_back_1;
	public ModelPart field_228260_b__0;
	public ModelPart leftHorn_top_middle;
	public ModelPart leftHorn_top_front_1;
	public ModelPart leftHorn_bottom;
	public ModelPart leftHorn_top_back;
	public ModelPart leftHorn_top_middle_1;

	public CacodemonModel() {
		this.textureWidth = 128;
		this.textureHeight = 64;
		this.leftHorn_bottom = new ModelPart(this, 0, 6);
		this.leftHorn_bottom.setPivot(0.0F, 0.0F, 0.0F);
		this.leftHorn_bottom.addCuboid(-7.5F, -26.7F, -9.0F, 2.0F, 9.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(leftHorn_bottom, 2.548180707911721F, 0.0F, 0.0F);
		this.leftHorn_top_middle_1 = new ModelPart(this, 0, 6);
		this.leftHorn_top_middle_1.setPivot(0.0F, 0.0F, 0.0F);
		this.leftHorn_top_middle_1.addCuboid(-13.7F, -7.4F, -2.0F, 2.0F, 5.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(leftHorn_top_middle_1, 0.0F, 0.0F, -1.1344640137963142F);
		this.leftHorn_top_front = new ModelPart(this, 0, 6);
		this.leftHorn_top_front.setPivot(0.0F, 0.0F, 0.0F);
		this.leftHorn_top_front.addCuboid(-13.0F, -3.9F, -8.1F, 2.0F, 7.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(leftHorn_top_front, 0.0F, 0.0F, -0.7853981633974483F);
		this.leftHorn_top_back_1 = new ModelPart(this, 0, 6);
		this.leftHorn_top_back_1.setPivot(0.0F, 0.0F, 0.0F);
		this.leftHorn_top_back_1.addCuboid(5.8F, -8.9F, 5.0F, 2.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(leftHorn_top_back_1, 0.0F, 0.0F, 2.8679251547088147F);
		this.field_228260_b__0 = new ModelPart(this, 0, 0);
		this.field_228260_b__0.setPivot(0.0F, 0.0F, 0.0F);
		this.field_228260_b__0.addCuboid(-16.0F, 1.6F, -16.0F, 32.0F, 32.0F, 32.0F, -8.0F, -8.0F, -8.0F);
		this.leftHorn_top_front_1 = new ModelPart(this, 0, 16);
		this.leftHorn_top_front_1.setPivot(0.0F, 0.0F, 0.0F);
		this.leftHorn_top_front_1.addCuboid(-13.0F, -3.9F, -8.1F, 2.0F, 7.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(leftHorn_top_front_1, 0.0F, 0.0F, -2.356194490192345F);
		this.leftHorn_top_middle = new ModelPart(this, 0, 6);
		this.leftHorn_top_middle.setPivot(0.0F, 0.0F, 0.0F);
		this.leftHorn_top_middle.addCuboid(-13.7F, 2.4F, -2.0F, 2.0F, 5.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(leftHorn_top_middle, 0.0F, 0.0F, -2.007128639793479F);
		this.rightHorn_bottom = new ModelPart(this, 0, 6);
		this.rightHorn_bottom.setPivot(0.0F, 0.0F, 0.0F);
		this.rightHorn_bottom.addCuboid(5.8F, -26.7F, -9.0F, 2.0F, 9.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rightHorn_bottom, 2.548180707911721F, 0.0F, 0.0F);
		this.leftHorn_top_back = new ModelPart(this, 0, 6);
		this.leftHorn_top_back.setPivot(0.0F, 0.0F, 0.0F);
		this.leftHorn_top_back.addCuboid(-7.6F, -8.7F, 5.0F, 2.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(leftHorn_top_back, 0.0F, 0.0F, -2.8679251547088147F);
	}

	@Override
	public void render(MatrixStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		ImmutableList.of(this.leftHorn_bottom, this.leftHorn_top_middle_1, this.leftHorn_top_front,
				this.leftHorn_top_back_1, this.field_228260_b__0, this.leftHorn_top_front_1, this.leftHorn_top_middle,
				this.rightHorn_bottom, this.leftHorn_top_back).forEach((ModelPart) -> {
					ModelPart.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
				});
	}

	@Override
	public void setAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}

	public void setRotateAngle(ModelPart ModelPart, float x, float y, float z) {
		ModelPart.pitch = x;
		ModelPart.yaw = y;
		ModelPart.roll = z;
	}
}