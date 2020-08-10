package mod.azure.doom.client.render.projectiles;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.projectiles.BulletEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;

public class BulletsRender extends ProjectileEntityRenderer<BulletEntity> {

	private static final Identifier SHOTGUN_SHELL_TEXTURE = new Identifier(DoomMod.MODID,
			"textures/entity/projectiles/shotgun_shell.png");

	public BulletsRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn);
	}

	@Override
	public Identifier getTexture(BulletEntity entity) {
		return SHOTGUN_SHELL_TEXTURE;
	}

}