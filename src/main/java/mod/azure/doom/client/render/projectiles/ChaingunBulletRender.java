package mod.azure.doom.client.render.projectiles;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.projectiles.ChaingunBulletEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;

public class ChaingunBulletRender extends ProjectileEntityRenderer<ChaingunBulletEntity> {

	private static final Identifier SHOTGUN_SHELL_TEXTURE = new Identifier(DoomMod.MODID,
			"textures/entity/projectiles/shotgun_shell.png");

	public ChaingunBulletRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn);
	}

	@Override
	public Identifier getTexture(ChaingunBulletEntity entity) {
		return SHOTGUN_SHELL_TEXTURE;
	}

}