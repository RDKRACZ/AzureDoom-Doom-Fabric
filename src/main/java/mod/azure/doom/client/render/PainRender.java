package mod.azure.doom.client.render;

import mod.azure.doom.client.models.PainModel;
import mod.azure.doom.entity.PainEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderer.geo.GeoEntityRenderer;

public class PainRender extends GeoEntityRenderer<PainEntity> {

	public PainRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new PainModel());
	}

	@Override
	public RenderLayer getRenderType(PainEntity animatable, float partialTicks, MatrixStack stack,
			VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
			Identifier textureLocation) {
		return RenderLayer.getEntityTranslucent(getTextureLocation(animatable));
	}

}