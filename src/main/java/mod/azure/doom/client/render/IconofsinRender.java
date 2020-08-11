package mod.azure.doom.client.render;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.DemonModel;
import mod.azure.doom.entity.IconofsinEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class IconofsinRender extends MobEntityRenderer<IconofsinEntity, DemonModel<IconofsinEntity>> {

	protected static final Identifier TEXTURE = new Identifier(DoomMod.MODID, "textures/entity/iconofsin.png");

	public IconofsinRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new DemonModel<IconofsinEntity>(0.5f, false), 0.5f);

	}

	@Override
	public Identifier getTexture(IconofsinEntity entity) {
		return TEXTURE;
	}

	@Override
	protected void scale(IconofsinEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
		matrixStackIn.scale(5.0F, 5.0F, 5.0F);
	}

}