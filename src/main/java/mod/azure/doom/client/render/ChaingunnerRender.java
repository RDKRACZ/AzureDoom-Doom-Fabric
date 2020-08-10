package mod.azure.doom.client.render;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.ChaingunnerModel;
import mod.azure.doom.entity.ChaingunnerEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class ChaingunnerRender extends MobEntityRenderer<ChaingunnerEntity, ChaingunnerModel<ChaingunnerEntity>> {

	protected static final Identifier TEXTURE = new Identifier(DoomMod.MODID, "textures/entity/chaingunner.png");

	public ChaingunnerRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new ChaingunnerModel<ChaingunnerEntity>(0.5f, false), 0.5f);
	}

	@Override
	public Identifier getTexture(ChaingunnerEntity entity) {
		return TEXTURE;
	}

}