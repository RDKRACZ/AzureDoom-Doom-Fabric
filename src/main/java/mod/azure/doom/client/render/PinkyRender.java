package mod.azure.doom.client.render;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.PinkyModel;
import mod.azure.doom.entity.PinkyEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class PinkyRender extends MobEntityRenderer<PinkyEntity, PinkyModel<PinkyEntity>> {

	protected static final Identifier TEXTURE = new Identifier(DoomMod.MODID, "textures/entity/pinky-texturemap.png");

	public PinkyRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new PinkyModel<>(), 0.7F);
	}

	@Override
	public Identifier getTexture(PinkyEntity entity) {
		return TEXTURE;
	}

}