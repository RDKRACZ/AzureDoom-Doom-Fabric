package mod.azure.doom.client.render;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.ArachnotronModel;
import mod.azure.doom.entity.ArachnotronEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class ArachonotronRender extends MobEntityRenderer<ArachnotronEntity, ArachnotronModel> {

	protected static final Identifier TEXTURE = new Identifier(DoomMod.MODID,
			"textures/entity/arachnotron-texturemap.png");

	public ArachonotronRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new ArachnotronModel(), 0.8F);
	}

	@Override
	public Identifier getTexture(ArachnotronEntity entity) {
		return TEXTURE;
	}

}