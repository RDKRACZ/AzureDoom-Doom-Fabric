package mod.azure.doom.client.render;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.RevenantModel;
import mod.azure.doom.entity.RevenantEntity;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.util.Identifier;

public class RevenantRender extends BipedEntityRenderer<RevenantEntity, RevenantModel<RevenantEntity>> {

	protected static final Identifier TEXTURE = new Identifier(DoomMod.MODID, "textures/entity/revenant.png");

	public RevenantRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new RevenantModel<>(), 0.5F);
	}

	@Override
	public Identifier getTexture(RevenantEntity entity) {
		return TEXTURE;
	}

}