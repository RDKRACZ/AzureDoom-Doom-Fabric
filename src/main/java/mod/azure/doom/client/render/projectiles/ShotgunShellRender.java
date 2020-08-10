package mod.azure.doom.client.render.projectiles;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.projectiles.ShotgunShellEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;

public class ShotgunShellRender extends ProjectileEntityRenderer<ShotgunShellEntity> {

	private static final Identifier SHOTGUN_SHELL_TEXTURE = new Identifier(DoomMod.MODID,
			"textures/entity/projectiles/shotgun_shell.png");

	public ShotgunShellRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn);
	}

	@Override
	public Identifier getTexture(ShotgunShellEntity entity) {
		return SHOTGUN_SHELL_TEXTURE;
	}

}