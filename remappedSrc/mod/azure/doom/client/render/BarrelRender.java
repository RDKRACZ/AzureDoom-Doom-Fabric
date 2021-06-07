package mod.azure.doom.client.render;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.projectiles.BarrelEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.util.Identifier;

public class BarrelRender extends EntityRenderer<BarrelEntity> {

	protected static final Identifier TEXTURE = new Identifier(DoomMod.MODID, "textures/blocks/barrel_explode.png");

	public BarrelRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn);
		this.shadowRadius = 0.5F;
	}

	public void render(BarrelEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
			VertexConsumerProvider bufferIn, int packedLightIn) {
		matrixStackIn.push();
		matrixStackIn.translate(0.0D, 0.5D, 0.0D);

		matrixStackIn.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(-90.0F));
		matrixStackIn.translate(-0.5D, -0.5D, 0.5D);
		matrixStackIn.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(90.0F));
		matrixStackIn.pop();
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Override
	public Identifier getTexture(BarrelEntity entity) {
		return TEXTURE;
	}
}