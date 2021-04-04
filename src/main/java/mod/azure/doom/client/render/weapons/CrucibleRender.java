package mod.azure.doom.client.render.weapons;

import mod.azure.doom.client.models.weapons.CrucibleModel;
import mod.azure.doom.item.weapons.SwordCrucibleItem;
import software.bernie.geckolib3.renderer.geo.GeoItemRenderer;

public class CrucibleRender extends GeoItemRenderer<SwordCrucibleItem> {
	public CrucibleRender() {
		super(new CrucibleModel());
	}
}