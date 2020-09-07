package mod.azure.doom.client.render;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.HellknightModel;
import mod.azure.doom.entity.HellknightEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class HellknightRender extends MobEntityRenderer<HellknightEntity, HellknightModel<HellknightEntity>> {

	protected static final Identifier TEXTURE = new Identifier(DoomMod.MODID, "textures/entity/hellknight.png");

	public HellknightRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new HellknightModel<>(), 0.7F);
	}

	@Override
	public Identifier getTexture(HellknightEntity entity) {
		return TEXTURE;
	}

}