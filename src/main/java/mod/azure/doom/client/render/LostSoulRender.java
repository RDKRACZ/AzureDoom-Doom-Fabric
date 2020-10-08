package mod.azure.doom.client.render;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.LostSoulModel;
import mod.azure.doom.client.render.layers.LayerFlames;
import mod.azure.doom.entity.LostSoulEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class LostSoulRender extends MobEntityRenderer<LostSoulEntity, LostSoulModel> {
	private static final Identifier TEXTURE = new Identifier(DoomMod.MODID, "textures/entity/lost_soul.png");

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public LostSoulRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new LostSoulModel(), 1.5F);
		this.addFeature(new LayerFlames(this));
	}

	@Override
	protected int getBlockLight(LostSoulEntity entity, BlockPos blockPos) {
		return 10;
	}
	
	@Override
	protected float getLyingAngle(LostSoulEntity entity) {
		return 180.0F;
	}

	@Override
	public Identifier getTexture(LostSoulEntity entity) {
		return TEXTURE;
	}
}