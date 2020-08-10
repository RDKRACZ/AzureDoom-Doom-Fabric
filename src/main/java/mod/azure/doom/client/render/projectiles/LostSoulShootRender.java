package mod.azure.doom.client.render.projectiles;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.projectiles.PainShootEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Matrix3f;
import net.minecraft.util.math.Matrix4f;

public class LostSoulShootRender extends EntityRenderer<PainShootEntity> {

	private static final Identifier ROCKET_TEXTURE = new Identifier(DoomMod.MODID,
			"textures/entity/projectiles/pain.png");
	private static final RenderLayer LAYER = RenderLayer.getEntityCutoutNoCull(ROCKET_TEXTURE);

	public LostSoulShootRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn);
	}

	@Override
	public Identifier getTexture(PainShootEntity entity) {
		return ROCKET_TEXTURE;
	}

	protected int getBlockLight(PainShootEntity entityIn, BlockPos partialTicks) {
		return 15;
	}

	public void render(PainShootEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStack,
			VertexConsumerProvider bufferIn, int packedLightIn) {
		matrixStack.push();
		matrixStack.scale(1.0F, 1.0F, 1.0F);
		matrixStack.multiply(this.dispatcher.getRotation());
		matrixStack.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(180.0F));
		MatrixStack.Entry entry = matrixStack.peek();
		Matrix4f matrix4f = entry.getModel();
		Matrix3f matrix3f = entry.getNormal();
		VertexConsumer ivertexbuilder = bufferIn.getBuffer(LAYER);
		produceVertex(ivertexbuilder, matrix4f, matrix3f, packedLightIn, 0.0F, 0, 0, 1);
		produceVertex(ivertexbuilder, matrix4f, matrix3f, packedLightIn, 1.0F, 0, 1, 1);
		produceVertex(ivertexbuilder, matrix4f, matrix3f, packedLightIn, 1.0F, 1, 1, 0);
		produceVertex(ivertexbuilder, matrix4f, matrix3f, packedLightIn, 0.0F, 1, 0, 0);
		matrixStack.pop();
		super.render(entityIn, entityYaw, partialTicks, matrixStack, bufferIn, packedLightIn);
	}

	private static void produceVertex(VertexConsumer vertexConsumer, Matrix4f modelMatrix, Matrix3f normalMatrix,
			int light, float x, int y, int textureU, int textureV) {
		vertexConsumer.vertex(modelMatrix, x - 0.5F, (float) y - 0.25F, 0.0F).color(255, 255, 255, 255)
				.texture((float) textureU, (float) textureV).overlay(OverlayTexture.DEFAULT_UV).light(light)
				.normal(normalMatrix, 0.0F, 1.0F, 0.0F).next();
	}
}