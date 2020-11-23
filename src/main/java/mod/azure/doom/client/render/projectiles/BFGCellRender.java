package mod.azure.doom.client.render.projectiles;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.projectiles.BFGEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Matrix3f;
import net.minecraft.util.math.Matrix4f;

public class BFGCellRender extends EntityRenderer<BFGEntity> {

	private static final Identifier BFG_CELL_TEXTURE = new Identifier(DoomMod.MODID,
			"textures/entity/projectiles/bfg.png");
	private static final RenderLayer LAYER = RenderLayer.getEntityCutoutNoCull(BFG_CELL_TEXTURE);
	private static final RenderLayer CRYSTAL_BEAM_LAYER = RenderLayer
			.getEntitySmoothCutout(new Identifier(DoomMod.MODID, "textures/entity/projectiles/bfg_beam.png"));

	public BFGCellRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn);
	}

	@Override
	public Identifier getTexture(BFGEntity entity) {
		return BFG_CELL_TEXTURE;
	}

	protected int getBlockLight(BFGEntity entityIn, BlockPos partialTicks) {
		return 15;
	}

	public void render(BFGEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStack,
			VertexConsumerProvider bufferIn, int packedLightIn) {
		matrixStack.push();
		float h = getYOffset(entityIn, partialTicks);
		matrixStack.scale(4.0F, 4.0F, 4.0F);
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
		LivingEntity blockPos = entityIn.getBeamTarget();
		if (blockPos != null) {
			float m = (float) blockPos.getX() + 0.5F;
			float n = (float) blockPos.getY() + 0.5F;
			float o = (float) blockPos.getZ() + 0.5F;
			float p = (float) ((double) m - entityIn.getX());
			float q = (float) ((double) n - entityIn.getY());
			float r = (float) ((double) o - entityIn.getZ());
			matrixStack.translate((double) p, (double) q, (double) r);
			renderCrystalBeam(-p, -q + h, -r, partialTicks, entityIn.age, matrixStack, bufferIn, packedLightIn);
		}
		super.render(entityIn, entityYaw, partialTicks, matrixStack, bufferIn, packedLightIn);
	}

	private static void produceVertex(VertexConsumer vertexConsumer, Matrix4f modelMatrix, Matrix3f normalMatrix,
			int light, float x, int y, int textureU, int textureV) {
		vertexConsumer.vertex(modelMatrix, x - 0.5F, (float) y - 0.25F, 0.0F).color(255, 255, 255, 255)
				.texture((float) textureU, (float) textureV).overlay(OverlayTexture.DEFAULT_UV).light(light)
				.normal(normalMatrix, 0.0F, 1.0F, 0.0F).next();
	}

	public static float getYOffset(BFGEntity crystal, float tickDelta) {
		float f = (float) crystal.age + tickDelta;
		float g = MathHelper.sin(f * 0.2F) / 2.0F + 0.5F;
		g = (g * g + g) * 0.4F;
		return g - 1.4F;
	}

	public static void renderCrystalBeam(float dx, float dy, float dz, float tickDelta, int age, MatrixStack matrices,
			VertexConsumerProvider vertexConsumers, int light) {
		float f = MathHelper.sqrt(dx * dx + dz * dz);
		float g = MathHelper.sqrt(dx * dx + dy * dy + dz * dz);
		matrices.push();
		matrices.translate(0.0D, 2.0D, 0.0D);
		matrices.multiply(
				Vector3f.POSITIVE_Y.getRadialQuaternion((float) (-Math.atan2((double) dz, (double) dx)) - 1.5707964F));
		matrices.multiply(
				Vector3f.POSITIVE_X.getRadialQuaternion((float) (-Math.atan2((double) f, (double) dy)) - 1.5707964F));
		VertexConsumer vertexConsumer = vertexConsumers.getBuffer(CRYSTAL_BEAM_LAYER);
		float h = 0.0F - ((float) age + tickDelta) * 0.01F;
		float i = MathHelper.sqrt(dx * dx + dy * dy + dz * dz) / 32.0F - ((float) age + tickDelta) * 0.01F;
		float k = 0.0F;
		float l = 0.75F;
		float m = 0.0F;
		MatrixStack.Entry entry = matrices.peek();
		Matrix4f matrix4f = entry.getModel();
		Matrix3f matrix3f = entry.getNormal();

		for (int n = 1; n <= 8; ++n) {
			float o = MathHelper.sin((float) n * 6.2831855F / 8.0F) * 0.75F;
			float p = MathHelper.cos((float) n * 6.2831855F / 8.0F) * 0.75F;
			float q = (float) n / 8.0F;
			vertexConsumer.vertex(matrix4f, k * 0.2F, l * 0.2F, 0.0F).color(0, 0, 0, 255).texture(m, h)
					.overlay(OverlayTexture.DEFAULT_UV).light(light).normal(matrix3f, 0.0F, -1.0F, 0.0F).next();
			vertexConsumer.vertex(matrix4f, k, l, g).color(255, 255, 255, 255).texture(m, i)
					.overlay(OverlayTexture.DEFAULT_UV).light(light).normal(matrix3f, 0.0F, -1.0F, 0.0F).next();
			vertexConsumer.vertex(matrix4f, o, p, g).color(255, 255, 255, 255).texture(q, i)
					.overlay(OverlayTexture.DEFAULT_UV).light(light).normal(matrix3f, 0.0F, -1.0F, 0.0F).next();
			vertexConsumer.vertex(matrix4f, o * 0.2F, p * 0.2F, 0.0F).color(0, 0, 0, 255).texture(q, h)
					.overlay(OverlayTexture.DEFAULT_UV).light(light).normal(matrix3f, 0.0F, -1.0F, 0.0F).next();
			k = o;
			l = p;
			m = q;
		}

		matrices.pop();
	}

}