package mod.azure.doom.client.models;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class PainModel<T extends Entity> extends EntityModel<T> {
	public ModelPart painBody;
	public ModelPart painArmR;
	public ModelPart painArmL;
	public ModelPart painHornL;
	public ModelPart painHornR;
	public ModelPart painArmR_1;
	public ModelPart painArmL_1;

	public PainModel() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.painArmL = new ModelPart(this, 0, 18);
		this.painArmL.setPivot(0.0F, 0.0F, 0.0F);
		this.painArmL.addCuboid(17.9F, -11.0F, -7.7F, 3.0F, 10.0F, 3.0F, 0.0F, -2.6F, 0.0F);
		this.setRotateAngle(painArmL, 0.0F, 0.0F, 1.3638002668557248F);
		this.painArmL_1 = new ModelPart(this, 0, 18);
		this.painArmL_1.setPivot(0.0F, 0.0F, 0.0F);
		this.painArmL_1.addCuboid(5.3F, -14.1F, -20.9F, 3.0F, 10.0F, 3.0F, 0.0F, -2.6F, -0.1F);
		this.setRotateAngle(painArmL_1, 1.5707963267948966F, 0.0F, -1.5707963267948966F);
		this.painHornL = new ModelPart(this, 0, 0);
		this.painHornL.setPivot(0.0F, 0.0F, 0.0F);
		this.painHornL.addCuboid(-7.0F, -15.6F, -7.8F, 2.0F, 10.0F, 2.0F, 0.0F, -2.6F, 0.0F);
		this.setRotateAngle(painHornL, 0.0F, 0.0F, 1.4161601444155547F);
		this.painArmR = new ModelPart(this, 0, 18);
		this.painArmR.setPivot(0.0F, 17.6F, 0.0F);
		this.painArmR.addCuboid(-2.9F, -14.8F, -7.7F, 3.0F, 10.0F, 3.0F, 0.0F, -2.6F, 0.0F);
		this.setRotateAngle(painArmR, 0.0F, 0.0F, -1.3638002668557248F);
		this.painBody = new ModelPart(this, 0, 0);
		this.painBody.setPivot(0.0F, 17.6F, 0.0F);
		this.painBody.addCuboid(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, 0.0F, 0.0F, 0.0F);
		this.painHornR = new ModelPart(this, 0, 0);
		this.painHornR.setPivot(0.0F, 0.0F, 0.0F);
		this.painHornR.addCuboid(5.0F, -15.6F, -7.7F, 2.0F, 10.0F, 2.0F, 0.0F, -2.6F, 0.0F);
		this.setRotateAngle(painHornR, 0.0F, 0.0F, -1.4161601444155547F);
		this.painArmR_1 = new ModelPart(this, 0, 18);
		this.painArmR_1.setPivot(0.0F, 0.0F, 0.0F);
		this.painArmR_1.addCuboid(9.0F, -14.5F, -0.1F, 3.0F, 10.0F, 3.0F, 0.0F, -2.6F, -0.1F);
		this.setRotateAngle(painArmR_1, 1.5707963267948966F, 0.0F, -1.5707963267948966F);
		this.painArmL.addChild(this.painArmL_1);
		this.painBody.addChild(this.painHornL);
		this.painBody.addChild(this.painHornR);
		this.painArmR.addChild(this.painArmR_1);
	}

	public void setRotateAngle(ModelPart ModelPart, float x, float y, float z) {
		ModelPart.pivotX = x;
		ModelPart.pivotY = y;
		ModelPart.pivotZ = z;
	}

	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw,
			float headPitch) {
		this.painArmR.pivotX = MathHelper.cos(limbAngle) * -0.7819074915776542F * limbDistance;
		this.painArmL.pivotX = MathHelper.cos(limbAngle + (float) Math.PI) * -0.7819074915776542F * limbDistance;
		this.painArmR.pivotX = MathHelper.cos(limbAngle) * 0.2F * limbDistance;
		this.painArmL.pivotX = MathHelper.cos(limbAngle) * 0.2F * limbDistance;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green,
			float blue, float alpha) {
		ImmutableList.of(this.painArmL, this.painArmR, this.painBody).forEach((ModelPart) -> {
			ModelPart.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		});

	}
}