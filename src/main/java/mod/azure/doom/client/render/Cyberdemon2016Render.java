package mod.azure.doom.client.render;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.Cyberdemon2016Model;
import mod.azure.doom.entity.Cyberdemon2016Entity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class Cyberdemon2016Render
		extends MobEntityRenderer<Cyberdemon2016Entity, Cyberdemon2016Model<Cyberdemon2016Entity>> {

	protected static final Identifier TEXTURE = new Identifier(DoomMod.MODID, "textures/entity/cyberdemon2016.png");

	public Cyberdemon2016Render(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new Cyberdemon2016Model<Cyberdemon2016Entity>(0.5f, false), 0.5f);
	}

	@Override
	public Identifier getTexture(Cyberdemon2016Entity entity) {
		return TEXTURE;
	}

	@Override
	protected void scale(Cyberdemon2016Entity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
		matrixStackIn.scale(2.5F, 2.5F, 2.5F);
	}

}