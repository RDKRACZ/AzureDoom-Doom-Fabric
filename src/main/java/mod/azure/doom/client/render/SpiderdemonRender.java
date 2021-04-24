package mod.azure.doom.client.render;

import mod.azure.doom.client.models.SpiderdemonModel;
import mod.azure.doom.entity.tierboss.SpiderMastermindEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderer.geo.GeoEntityRenderer;

public class SpiderdemonRender extends GeoEntityRenderer<SpiderMastermindEntity> {

	public SpiderdemonRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new SpiderdemonModel());
	}

	@Override
	public RenderLayer getRenderType(SpiderMastermindEntity animatable, float partialTicks, MatrixStack stack,
			VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
			Identifier textureLocation) {
		return RenderLayer.getEntityTranslucent(getTextureLocation(animatable));
	}

	protected float getLyingAngle(SpiderMastermindEntity entityLivingBaseIn) {
		return 0.0F;
	}

}