package mod.azure.doom.client.render;

import software.bernie.geckolib3.renderer.geo.GeoEntityRenderer;
import mod.azure.doom.client.models.UnwillingModel;
import mod.azure.doom.entity.UnwillingEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class UnwillingRender extends GeoEntityRenderer<UnwillingEntity> {

	public UnwillingRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new UnwillingModel());
	}

	@Override
	public RenderLayer getRenderType(UnwillingEntity animatable, float partialTicks, MatrixStack stack,
			VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
			Identifier textureLocation) {
		return RenderLayer.getEntityTranslucent(getTextureLocation(animatable));
	}

}