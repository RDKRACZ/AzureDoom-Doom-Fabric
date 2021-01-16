package mod.azure.doom.client.render;

import com.mojang.blaze3d.systems.RenderSystem;

import mod.azure.doom.client.models.CacodemonModel;
import mod.azure.doom.entity.CacodemonEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.DiffuseLighting;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.geo.render.built.GeoModel;
import software.bernie.geckolib3.renderer.geo.GeoEntityRenderer;

public class CacodemonRender extends GeoEntityRenderer<CacodemonEntity> {

	public CacodemonRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new CacodemonModel());
	}

	@Override
	public RenderLayer getRenderType(CacodemonEntity animatable, float partialTicks, MatrixStack stack,
			VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
			Identifier textureLocation) {
		return RenderLayer.getEntityTranslucent(getTextureLocation(animatable));
	}
	
	@Override
	public void render(GeoModel model, CacodemonEntity animatable, float partialTicks, RenderLayer type,
			MatrixStack matrixStackIn, VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
			int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		// TODO Auto-generated method stub
		super.render(model, animatable, partialTicks, type, matrixStackIn, renderTypeBuffer, vertexBuilder, packedLightIn,
				packedOverlayIn, red, green, blue, alpha);
		matrixStackIn.push();
		VertexConsumerProvider.Immediate irendertypebuffer$impl = MinecraftClient.getInstance().getBufferBuilders()
				.getEntityVertexConsumers();
		DiffuseLighting.disableGuiDepthLighting();
		irendertypebuffer$impl.draw();
		RenderSystem.enableDepthTest();
		DiffuseLighting.enableGuiDepthLighting();
		matrixStackIn.pop();
	}

	protected float getLyingAngle(CacodemonEntity entityLivingBaseIn) {
		return 0.0F;
	}

}