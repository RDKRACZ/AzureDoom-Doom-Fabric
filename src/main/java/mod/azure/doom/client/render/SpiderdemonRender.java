package mod.azure.doom.client.render;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.SpiderdemonModel;
import mod.azure.doom.entity.SpiderdemonEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class SpiderdemonRender extends MobEntityRenderer<SpiderdemonEntity, SpiderdemonModel<SpiderdemonEntity>> {

	protected static final Identifier TEXTURE = new Identifier(DoomMod.MODID, "textures/entity/spiderdemon.png");

	public SpiderdemonRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new SpiderdemonModel<>(), 0.8F);
	}

	@Override
	public Identifier getTexture(SpiderdemonEntity entity) {
		return TEXTURE;
	}

}