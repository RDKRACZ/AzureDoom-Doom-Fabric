package mod.azure.doom.client.render;

import mod.azure.doom.client.DoomGeoEntityRenderer;
import mod.azure.doom.client.models.SpiderdemonModel;
import mod.azure.doom.entity.SpiderdemonEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class SpiderdemonRender extends DoomGeoEntityRenderer<SpiderdemonEntity> {

	public SpiderdemonRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new SpiderdemonModel());
	}

	@Override
	public RenderLayer getRenderType(SpiderdemonEntity animatable, float partialTicks, MatrixStack stack,
			VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
			Identifier textureLocation) {
		return RenderLayer.getEntityTranslucent(getTextureLocation(animatable));
	}

}