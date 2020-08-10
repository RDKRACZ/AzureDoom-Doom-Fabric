package mod.azure.doom.client.render;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.PainModel;
import mod.azure.doom.entity.PainEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class PainRender extends MobEntityRenderer<PainEntity, PainModel<PainEntity>> {
	private static final Identifier GHAST_TEXTURES = new Identifier(DoomMod.MODID,
			"textures/entity/pain_elemental.png");

	public PainRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new PainModel<PainEntity>(), 1.5F);
	}

	@Override
	public Identifier getTexture(PainEntity entity) {
		return GHAST_TEXTURES;
	}

	@Override
	protected void scale(PainEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
		matrixStackIn.scale(2.0F, 2.0F, 2.0F);
	}
}