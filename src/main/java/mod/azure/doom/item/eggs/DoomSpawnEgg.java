package mod.azure.doom.item.eggs;

import java.util.function.Supplier;

import mod.azure.doom.DoomMod;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;

public class DoomSpawnEgg extends SpawnEggItem {
	private Supplier<? extends EntityType<?>> typeGetter;

	public DoomSpawnEgg(Supplier<? extends EntityType<?>> typeIn, int primaryColorIn, int secondaryColorIn) {
		super(null, primaryColorIn, secondaryColorIn, new Item.Settings().maxCount(1).group(DoomMod.DoomItemGroup));
		typeGetter = typeIn;
	}

	public Supplier<? extends EntityType<?>> getTypeGetter() {
		return typeGetter;
	}

}