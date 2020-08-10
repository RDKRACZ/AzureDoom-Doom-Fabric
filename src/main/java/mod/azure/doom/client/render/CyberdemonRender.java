package mod.azure.doom.client.render;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.CyberdemonModel;
import mod.azure.doom.entity.CyberdemonEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class CyberdemonRender extends MobEntityRenderer<CyberdemonEntity, CyberdemonModel<CyberdemonEntity>> {

	protected static final Identifier TEXTURE = new Identifier(DoomMod.MODID, "textures/entity/cyberdemon.png");

	public CyberdemonRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new CyberdemonModel<CyberdemonEntity>(0.5f, false), 0.5f);
	}

	@Override
	public Identifier getTexture(CyberdemonEntity entity) {
		return TEXTURE;
	}

	@Override
	protected void scale(CyberdemonEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
		matrixStackIn.scale(2.5F, 2.5F, 2.5F);
	}

}