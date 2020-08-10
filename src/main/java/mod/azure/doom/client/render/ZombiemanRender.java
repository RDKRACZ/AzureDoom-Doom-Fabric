package mod.azure.doom.client.render;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.ZombiemanModel;
import mod.azure.doom.entity.ZombiemanEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class ZombiemanRender extends MobEntityRenderer<ZombiemanEntity, ZombiemanModel<ZombiemanEntity>> {

	protected static final Identifier TEXTURE = new Identifier(DoomMod.MODID, "textures/entity/eternalzombiemen.png");

	public ZombiemanRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new ZombiemanModel<ZombiemanEntity>(0.5f, false), 0.5f);
	}

	@Override
	public Identifier getTexture(ZombiemanEntity entity) {
		return TEXTURE;
	}

}