package mod.azure.doom.client.render;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.PossessedScientistModel;
import mod.azure.doom.entity.PossessedScientistEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class PossessedScientistRender
		extends MobEntityRenderer<PossessedScientistEntity, PossessedScientistModel> {

	protected static final Identifier TEXTURE = new Identifier(DoomMod.MODID, "textures/entity/possessedscientist.png");

	public PossessedScientistRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new PossessedScientistModel(), 0.5f);
	}

	protected void scale(PossessedScientistEntity entitylivingbaseIn, MatrixStack matrixStack, float f) {
		matrixStack.scale(0.625F, 0.6F, 0.625F);
	}
	
	@Override
	protected float getLyingAngle(PossessedScientistEntity entityLivingBaseIn) {
		return 0.0F;
	}

	@Override
	public Identifier getTexture(PossessedScientistEntity entity) {
		return TEXTURE;
	}

}