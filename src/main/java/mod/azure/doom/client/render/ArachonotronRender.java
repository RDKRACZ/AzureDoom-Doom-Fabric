package mod.azure.doom.client.render;

import mod.azure.doom.client.DoomGeoEntityRenderer;
import mod.azure.doom.client.models.ArachnotronModel;
import mod.azure.doom.entity.ArachnotronEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class ArachonotronRender extends DoomGeoEntityRenderer<ArachnotronEntity> {

	public ArachonotronRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new ArachnotronModel());
		this.shadowRadius = 0.7F;
	}

	@Override
	public RenderLayer getRenderType(ArachnotronEntity animatable, float partialTicks, MatrixStack stack,
			VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
			Identifier textureLocation) {
		return RenderLayer.getEntityTranslucent(getTextureLocation(animatable));
	}

}