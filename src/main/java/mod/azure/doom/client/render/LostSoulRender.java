package mod.azure.doom.client.render;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.LostSoulModel;
import mod.azure.doom.entity.LostSoulEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class LostSoulRender extends MobEntityRenderer<LostSoulEntity, LostSoulModel<LostSoulEntity>> {

	protected static final Identifier TEXTURE = new Identifier(DoomMod.MODID, "textures/entity/lost_soul_backup.png");

	public LostSoulRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new LostSoulModel<LostSoulEntity>(), 0.5f);
	}

	@Override
	public Identifier getTexture(LostSoulEntity entity) {
		return TEXTURE;
	}

	@Override
	protected void scale(LostSoulEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
		matrixStackIn.scale(1.5F, 1.5F, 1.5F);
	}
}