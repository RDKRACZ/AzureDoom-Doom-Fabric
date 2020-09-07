package mod.azure.doom.client.render;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.CyberdemonModel;
import mod.azure.doom.entity.CyberdemonEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class CyberdemonRender extends MobEntityRenderer<CyberdemonEntity, CyberdemonModel<CyberdemonEntity>> {

	protected static final Identifier TEXTURE = new Identifier(DoomMod.MODID,
			"textures/entity/cyberdemon-texturemap.png");

	public CyberdemonRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new CyberdemonModel<CyberdemonEntity>(0.5f, false), 0.5f);
	}

	@Override
	public Identifier getTexture(CyberdemonEntity entity) {
		return TEXTURE;
	}

}