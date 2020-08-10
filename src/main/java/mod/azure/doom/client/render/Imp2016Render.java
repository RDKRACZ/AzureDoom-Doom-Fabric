package mod.azure.doom.client.render;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.Imp2016Model;
import mod.azure.doom.entity.Imp2016Entity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class Imp2016Render extends MobEntityRenderer<Imp2016Entity, Imp2016Model<Imp2016Entity>> {

	protected static final Identifier TEXTURE = new Identifier(DoomMod.MODID, "textures/entity/imp2016.png");

	public Imp2016Render(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new Imp2016Model<Imp2016Entity>(0.5f, false), 0.5f);
	}

	@Override
	public Identifier getTexture(Imp2016Entity entity) {
		return TEXTURE;
	}

}