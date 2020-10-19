package mod.azure.doom.client.render;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.GoreNestModel;
import mod.azure.doom.entity.GoreNestEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import software.bernie.geckolib.forgetofabric.ResourceLocation;

public class GoreNestRender extends MobEntityRenderer<GoreNestEntity, GoreNestModel> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(DoomMod.MODID,
			"textures/entity/gore_nest.png");

	public GoreNestRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new GoreNestModel(), 0.5f);

	}

	protected void scale(GoreNestEntity entitylivingbaseIn, MatrixStack matrixStack, float f) {
		matrixStack.scale(1.5F, 1.5F, 1.5F);
	}

	@Override
	protected float getLyingAngle(GoreNestEntity entityLivingBaseIn) {
		return 0.0F;
	}

	@Override
	public ResourceLocation getTexture(GoreNestEntity entity) {
		return TEXTURE;
	}

}