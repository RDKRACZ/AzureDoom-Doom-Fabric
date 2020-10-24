package mod.azure.doom.client.render;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.ImpNightmareModel;
import mod.azure.doom.entity.NightmareImpEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class NightmareImpRender extends MobEntityRenderer<NightmareImpEntity, ImpNightmareModel> {

	protected static final Identifier TEXTURE = new Identifier(DoomMod.MODID,
			"textures/entity/nightmareimp-texture.png");

	public NightmareImpRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new ImpNightmareModel(), 0.5f);
	}

	@Override
	protected float getLyingAngle(NightmareImpEntity entityLivingBaseIn) {
		return 0.0F;
	}

	@Override
	public Identifier getTexture(NightmareImpEntity entity) {
		return TEXTURE;
	}

}