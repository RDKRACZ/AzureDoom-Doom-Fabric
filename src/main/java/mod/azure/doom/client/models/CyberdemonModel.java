package mod.azure.doom.client.models;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class CyberdemonModel<T extends Entity> extends EntityModel<T> {
	public ModelPart field_178723_h;
	public ModelPart field_178721_j;
	public ModelPart field_78116_c;
	public ModelPart field_78115_e;
	public ModelPart field_178724_i;
	public ModelPart field_178722_k;
	public ModelPart hornLeft;
	public ModelPart hornRight;
	public ModelPart hornLeft_1;
	public ModelPart hornLeft_2;
	public ModelPart hornRight_1;
	public ModelPart hornRight_2;
	public ModelPart field_78115_e_1;
	public ModelPart field_78115_e_2;
    public ModelPart field_78115_reversed;

	public CyberdemonModel(float modelSize, boolean smallArmsIn) {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.hornRight_1 = new ModelPart(this, 0, 10);
		this.hornRight_1.setPivot(0.0F, 0.0F, 0.0F);
		this.hornRight_1.addCuboid(-6.6F, -5.6F, -3.1F, 1.0F, 2.0F, 1.0F, 0.7F, 0.6F, 1.1F);
		this.setRotateAngle(hornRight_1, -0.35185837453889574F, 0.0F, 0.0F);
		this.field_178723_h = new ModelPart(this, 40, 16);
		this.field_178723_h.setPivot(-5.0F, 2.0F, 0.0F);
		this.field_178723_h.addCuboid(-4.7F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.5F, 0.5F, 0.5F);
		this.setRotateAngle(field_178723_h, 0.0F, 0.0F, 0.10000000116728046F);
		this.field_78116_c = new ModelPart(this, 0, 0);
		this.field_78116_c.setPivot(0.0F, 0.0F, 0.0F);
		this.field_78116_c.addCuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.5F, 0.5F, 0.5F);
		this.field_78115_e_1 = new ModelPart(this, 16, 22);
		this.field_78115_e_1.setPivot(0.0F, 0.0F, 0.0F);
		this.field_78115_e_1.addCuboid(-3.6F, 5.8F, -2.1F, 8.0F, 5.0F, 4.0F, 1.1F, 0.5F, 0.0F);
        this.field_78115_reversed = new ModelPart(this, 16, 22);
        this.field_78115_reversed.setPivot(0.0F, 0.0F, 0.0F);
        this.field_78115_reversed.addCuboid(-4.4F, 5.8F, -2.1F, 8.0F, 5.0F, 4.0F, 1.2F, 0.5F, 0.0F);
        this.setRotateAngle(field_78115_reversed, 0.0F, 3.141592653589793F, 0.0F);
		this.field_178724_i = new ModelPart(this, 32, 48);
		this.field_178724_i.setPivot(5.0F, 2.0F, 0.0F);
		this.field_178724_i.addCuboid(1.4F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.5F, 0.5F, 0.5F);
		this.setRotateAngle(field_178724_i, 0.0F, 0.0F, -0.10000000116728046F);
		this.hornRight = new ModelPart(this, 0, 10);
		this.hornRight.setPivot(12.2F, 0.0F, 0.0F);
		this.hornRight.addCuboid(-6.6F, -5.6F, 1.0F, 1.0F, 2.0F, 1.0F, 1.1F, 0.7F, 1.2F);
		this.hornLeft_1 = new ModelPart(this, 0, 10);
		this.hornLeft_1.setPivot(0.0F, 0.0F, 0.0F);
		this.hornLeft_1.addCuboid(-6.6F, -5.6F, -3.1F, 1.0F, 2.0F, 1.0F, 0.7F, 0.6F, 1.1F);
		this.setRotateAngle(hornLeft_1, -0.35185837453889574F, 0.0F, 0.0F);
		this.field_178721_j = new ModelPart(this, 0, 16);
		this.field_178721_j.setPivot(-1.9F, 12.0F, 0.1F);
		this.field_178721_j.addCuboid(-2.5F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.5F, 0.5F, 0.5F);
		this.field_78115_e = new ModelPart(this, 16, 16);
		this.field_78115_e.setPivot(0.0F, 0.0F, 0.0F);
		this.field_78115_e.addCuboid(-3.6F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, 1.5F, 0.5F, 0.5F);
		this.field_178722_k = new ModelPart(this, 16, 48);
		this.field_178722_k.setPivot(1.9F, 12.0F, 0.1F);
		this.field_178722_k.addCuboid(-0.5F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.5F, 0.5F, 0.5F);
		this.field_78115_e_2 = new ModelPart(this, 16, 27);
		this.field_78115_e_2.setPivot(0.0F, 0.0F, 0.0F);
		this.field_78115_e_2.addCuboid(-3.6F, 11.0F, -2.0F, 8.0F, 1.0F, 4.0F, 1.5F, 0.5F, 0.7F);
		this.hornRight_2 = new ModelPart(this, 0, 10);
		this.hornRight_2.setPivot(0.0F, 0.0F, 0.0F);
		this.hornRight_2.addCuboid(-6.6F, -4.0F, -7.4F, 1.0F, 2.0F, 1.0F, 0.6F, 0.3F, 2.1F);
		this.setRotateAngle(hornRight_2, -0.35185837453889574F, 0.0F, 0.0F);
		this.hornLeft = new ModelPart(this, 0, 10);
		this.hornLeft.setPivot(0.0F, 0.0F, 0.0F);
		this.hornLeft.addCuboid(-6.6F, -5.6F, 1.2F, 1.0F, 2.0F, 1.0F, 1.1F, 0.7F, 1.2F);
		this.hornLeft_2 = new ModelPart(this, 0, 10);
		this.hornLeft_2.setPivot(0.0F, 0.0F, 0.0F);
		this.hornLeft_2.addCuboid(-6.6F, -4.0F, -7.4F, 1.0F, 2.0F, 1.0F, 0.6F, 0.3F, 2.1F);
		this.setRotateAngle(hornLeft_2, -0.35185837453889574F, 0.0F, 0.0F);
		this.hornRight.addChild(this.hornRight_1);
		this.field_78115_e.addChild(this.field_78115_e_1);
		this.field_78116_c.addChild(this.hornRight);
		this.hornLeft.addChild(this.hornLeft_1);
        this.field_78115_e.addChild(this.field_78115_reversed);
		this.field_78115_e.addChild(this.field_78115_e_2);
		this.hornRight_1.addChild(this.hornRight_2);
		this.field_78116_c.addChild(this.hornLeft);
		this.hornLeft_1.addChild(this.hornLeft_2);
	}

	@Override
	public void render(MatrixStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		ImmutableList.of(this.field_178723_h, this.field_78116_c, this.field_178724_i, this.field_178721_j,
				this.field_78115_e, this.field_178722_k).forEach((ModelPart) -> {
					ModelPart.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue,
							alpha);
				});
	}

	public void setRotateAngle(ModelPart ModelPart, float x, float y, float z) {
		ModelPart.pitch = x;
		ModelPart.yaw = y;
		ModelPart.roll = z;
	}
	
	@Override
	public void setAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.field_178723_h.pitch = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 2.0F
				* limbSwingAmount * 0.5F / 1.0F;
		this.field_178724_i.pitch = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / 1.0F;
		this.field_178723_h.roll = 0.0F;
		this.field_178724_i.roll = 0.0F;
		this.field_178721_j.pitch = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / 1.0F;
		this.field_178722_k.pitch = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F
				* limbSwingAmount / 1.0F;
		this.field_178721_j.yaw = 0.0F;
		this.field_178722_k.yaw = 0.0F;
		this.field_178721_j.roll = 0.0F;
		this.field_178722_k.roll = 0.0F;
	}
}