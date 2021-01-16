package mod.azure.doom.client.render;

import mod.azure.doom.client.DoomGeoEntityRenderer;
import mod.azure.doom.client.models.RevenantModel;
import mod.azure.doom.entity.RevenantEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class RevenantRender extends DoomGeoEntityRenderer<RevenantEntity> {

	public RevenantRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new RevenantModel());
	}

	@Override
	public RenderLayer getRenderType(RevenantEntity animatable, float partialTicks, MatrixStack stack,
			VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
			Identifier textureLocation) {
		return RenderLayer.getEntityTranslucent(getTextureLocation(animatable));
	}

}