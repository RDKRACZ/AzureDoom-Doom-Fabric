package mod.azure.doom.client.render;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.UnarmedModel;
import mod.azure.doom.entity.ShotgunguyEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.HeldItemFeatureRenderer;
import net.minecraft.util.Identifier;

public class ShotgunguyRender extends MobEntityRenderer<ShotgunguyEntity, UnarmedModel<ShotgunguyEntity>> {

	protected static final Identifier TEXTURE = new Identifier(DoomMod.MODID, "textures/entity/shotgunguy.png");

	public ShotgunguyRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new UnarmedModel<ShotgunguyEntity>(0.5f, false), 0.5f);
		this.addFeature(new HeldItemFeatureRenderer<>(this));

	}

	@Override
	public Identifier getTexture(ShotgunguyEntity entity) {
		return TEXTURE;
	}

}