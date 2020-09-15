package mod.azure.doom.client.render;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.LostSoulModel;
import mod.azure.doom.client.render.layers.LayerFlames;
import mod.azure.doom.entity.projectiles.LostSoulEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class LostSoulRender extends MobEntityRenderer<LostSoulEntity, LostSoulModel<LostSoulEntity>> {
	private static final Identifier TEXTURE = new Identifier(DoomMod.MODID, "textures/entity/lost_soul.png");

	public LostSoulRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new LostSoulModel<LostSoulEntity>(), 1.5F);
		this.addFeature(new LayerFlames(this));
	}

	@Override
	protected int getBlockLight(LostSoulEntity entity, BlockPos blockPos) {
		return 15;
	}

	@Override
	public Identifier getTexture(LostSoulEntity entity) {
		return TEXTURE;
	}
}