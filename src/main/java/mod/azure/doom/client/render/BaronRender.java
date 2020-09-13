package mod.azure.doom.client.render;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.BaronModel;
import mod.azure.doom.entity.BaronEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class BaronRender extends MobEntityRenderer<BaronEntity, BaronModel<BaronEntity>> {

	protected static final Identifier TEXTURE = new Identifier(DoomMod.MODID,
			"textures/entity/baronofhell-texturemap.png");

	public BaronRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new BaronModel<>(), 0.5f);
	}

	@Override
	public Identifier getTexture(BaronEntity entity) {
		return TEXTURE;
	}

}