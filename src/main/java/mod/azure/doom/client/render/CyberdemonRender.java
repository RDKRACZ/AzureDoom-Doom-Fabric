package mod.azure.doom.client.render;

import software.bernie.geckolib3.renderer.geo.GeoEntityRenderer;
import mod.azure.doom.client.models.CyberdemonModel;
import mod.azure.doom.entity.CyberdemonEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class CyberdemonRender extends GeoEntityRenderer<CyberdemonEntity> {

	public CyberdemonRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new CyberdemonModel());
	}

	@Override
	public RenderLayer getRenderType(CyberdemonEntity animatable, float partialTicks, MatrixStack stack,
			VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
			Identifier textureLocation) {
		return RenderLayer.getEntityTranslucent(getTextureLocation(animatable));
	}
}