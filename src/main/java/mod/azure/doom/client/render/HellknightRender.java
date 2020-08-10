package mod.azure.doom.client.render;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.HellknightModel;
import mod.azure.doom.entity.HellknightEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.util.Identifier;

public class HellknightRender extends MobEntityRenderer<HellknightEntity, HellknightModel<HellknightEntity>> {

	protected static final Identifier TEXTURE = new Identifier(DoomMod.MODID, "textures/entity/hellknight.png");

	public HellknightRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new HellknightModel<>(), 0.7F);
	}

	@Override
	public Identifier getTexture(HellknightEntity entity) {
		return TEXTURE;
	}

	@Override
	protected void setupTransforms(HellknightEntity ironGolemEntity, MatrixStack matrixStack, float f, float g,
			float h) {
		super.setupTransforms(ironGolemEntity, matrixStack, f, g, h);
		if ((double) ironGolemEntity.limbDistance >= 0.01D) {
			float j = ironGolemEntity.limbAngle - ironGolemEntity.limbDistance * (1.0F - h) + 6.0F;
			float k = (Math.abs(j % 13.0F - 6.5F) - 3.25F) / 3.25F;
			matrixStack.multiply(Vector3f.POSITIVE_Z.getDegreesQuaternion(6.5F * k));
		}
	}

	@Override
	protected void scale(HellknightEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
		matrixStackIn.scale(1.0F, 1.0F, 1.0F);
	}

}