package mod.azure.doom.client.render;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.UnarmedModel;
import mod.azure.doom.entity.ZombiemanEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.HeldItemFeatureRenderer;
import net.minecraft.util.Identifier;

public class ZombiemanRender extends MobEntityRenderer<ZombiemanEntity, UnarmedModel<ZombiemanEntity>> {

	protected static final Identifier TEXTURE = new Identifier(DoomMod.MODID, "textures/entity/eternalzombiemen.png");

	public ZombiemanRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new UnarmedModel<ZombiemanEntity>(0.5f, false), 0.5f);
		this.addFeature(new HeldItemFeatureRenderer<>(this));
	}

	@Override
	public Identifier getTexture(ZombiemanEntity entity) {
		return TEXTURE;
	}

}