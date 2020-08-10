package mod.azure.doom.item.powerup;

import mod.azure.doom.DoomMod;
import net.minecraft.item.Item;

public class SoulCubeItem extends Item {

	public SoulCubeItem() {
		super(new Item.Settings().group(DoomMod.DoomItemGroup).maxCount(1).maxDamage(5));
	}
}