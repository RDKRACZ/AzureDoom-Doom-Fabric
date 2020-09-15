package mod.azure.doom.client.render;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.CacodemonModel;
import mod.azure.doom.entity.CacodemonEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class CacodemonRender extends MobEntityRenderer<CacodemonEntity, CacodemonModel<CacodemonEntity>> {
	private static final Identifier GHAST_TEXTURES = new Identifier(DoomMod.MODID, "textures/entity/cacodemon.png");

	public CacodemonRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new CacodemonModel<CacodemonEntity>(), 1.5F);
	}

	@Override
	public Identifier getTexture(CacodemonEntity entity) {
		return GHAST_TEXTURES;
	}

	@Override
	protected void scale(CacodemonEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
		matrixStackIn.scale(2.0F, 2.0F, 2.0F);
	}
}