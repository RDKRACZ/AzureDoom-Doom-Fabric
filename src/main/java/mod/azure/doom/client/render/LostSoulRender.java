package mod.azure.doom.client.render;

import mod.azure.doom.client.models.LostSoulModel;
import mod.azure.doom.entity.LostSoulEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.geo.GeoEntityRenderer;

public class LostSoulRender extends GeoEntityRenderer<LostSoulEntity> {

	public LostSoulRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new LostSoulModel());
	}

	@Override
	public RenderLayer getRenderType(LostSoulEntity animatable, float partialTicks, MatrixStack stack,
			VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
			Identifier textureLocation) {
		return RenderLayer.getEntityTranslucent(getTextureLocation(animatable));
	}
}