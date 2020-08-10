package mod.azure.doom.client.render;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.PossessedSoldierModel;
import mod.azure.doom.entity.PossessedSoldierEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class PossessedSoldierRender
		extends MobEntityRenderer<PossessedSoldierEntity, PossessedSoldierModel<PossessedSoldierEntity>> {

	protected static final Identifier TEXTURE = new Identifier(DoomMod.MODID, "textures/entity/possessedsoldier.png");

	public PossessedSoldierRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new PossessedSoldierModel<PossessedSoldierEntity>(0.5f, false), 0.5f);

	}

	@Override
	public Identifier getTexture(PossessedSoldierEntity entity) {
		return TEXTURE;
	}

}