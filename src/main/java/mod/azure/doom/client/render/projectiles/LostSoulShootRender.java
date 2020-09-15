package mod.azure.doom.client.render.projectiles;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.LostSoulModel;
import mod.azure.doom.entity.LostSoulEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class LostSoulShootRender extends MobEntityRenderer<LostSoulEntity, LostSoulModel<LostSoulEntity>> {
	private static final Identifier TEXTURE = new Identifier(DoomMod.MODID, "textures/entity/lost_soul.png");

	public LostSoulShootRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new LostSoulModel<LostSoulEntity>(), 1.5F);
	}

	@Override
	protected int getBlockLight(LostSoulEntity entity, BlockPos blockPos) {
		return 5;
	}

	@Override
	public Identifier getTexture(LostSoulEntity entity) {
		return TEXTURE;
	}
}