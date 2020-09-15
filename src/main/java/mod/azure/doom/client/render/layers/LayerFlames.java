package mod.azure.doom.client.render.layers;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.LostSoulModel;
import mod.azure.doom.entity.projectiles.LostSoulEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class LayerFlames<T extends LostSoulEntity, M extends LostSoulModel<T>> extends FeatureRenderer<T, M> {
	private static final Identifier[] TEX = { new Identifier(DoomMod.MODID, "textures/entity/lost_soul_fire_1.png"),
			new Identifier(DoomMod.MODID, "textures/entity/lost_soul_fire_2.png"),
			new Identifier(DoomMod.MODID, "textures/entity/lost_soul_fire_3.png"),
			new Identifier(DoomMod.MODID, "textures/entity/lost_soul_fire_4.png"),
			new Identifier(DoomMod.MODID, "textures/entity/lost_soul_fire_5.png"),
			new Identifier(DoomMod.MODID, "textures/entity/lost_soul_fire_6.png"),
			new Identifier(DoomMod.MODID, "textures/entity/lost_soul_fire_7.png"),
			new Identifier(DoomMod.MODID, "textures/entity/lost_soul_fire_8.png") };

	public LayerFlames(FeatureRendererContext<T, M> featureRendererContext) {
		super(featureRendererContext);
	}

	@Override
	public void render(MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn,
			LostSoulEntity entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks,
			float ageInTicks, float netHeadYaw, float headPitch) {
		MinecraftClient.getInstance().getEntityRenderDispatcher().textureManager
				.bindTexture(TEX[(entitylivingbaseIn.getFlameTimer())]);
		matrixStackIn.push();
		matrixStackIn.translate(0.0D, 1.034D, 0.05D);
		VertexConsumer ivertexbuilder = bufferIn
				.getBuffer(RenderLayer.getEntityCutoutNoCull(TEX[(entitylivingbaseIn.getFlameTimer())]));
		this.getContextModel().renderFlame(matrixStackIn, ivertexbuilder, 100, 1);
		matrixStackIn.pop();
	}

}