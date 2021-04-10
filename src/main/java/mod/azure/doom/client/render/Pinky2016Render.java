package mod.azure.doom.client.render;

import mod.azure.doom.client.models.Pinky2016Model;
import mod.azure.doom.entity.PinkyEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderer.geo.GeoEntityRenderer;

public class Pinky2016Render extends GeoEntityRenderer<PinkyEntity> {

	public Pinky2016Render(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new Pinky2016Model());
	}

	@Override
	public RenderLayer getRenderType(PinkyEntity animatable, float partialTicks, MatrixStack stack,
			VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
			Identifier textureLocation) {
		return RenderLayer.getEntityTranslucent(getTextureLocation(animatable));
	}

	protected float getLyingAngle(PinkyEntity entityLivingBaseIn) {
		return 0.0F;
	}

}