package mod.azure.doom.client.render;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.DemonModel;
import mod.azure.doom.entity.BaronEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.HeldItemFeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class BaronRender extends MobEntityRenderer<BaronEntity, DemonModel<BaronEntity>> {

	protected static final Identifier TEXTURE = new Identifier(DoomMod.MODID, "textures/entity/barron-of-hell_new.png");

	public BaronRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new DemonModel<>(0.5f, false), 0.5f);
		this.addFeature(new HeldItemFeatureRenderer<>(this));
	}

	@Override
	public Identifier getTexture(BaronEntity entity) {
		return TEXTURE;
	}

	@Override
	protected void scale(BaronEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
		matrixStackIn.scale(2.0F, 2.0F, 2.0F);
	}

}