package mod.azure.doom.item.armor.skin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Wearable;

public class SkinArmor extends ArmorItem implements Wearable {

	public SkinArmor(ArmorMaterial materialIn, EquipmentSlot slot, Settings builder) {
		super(materialIn, slot, builder);
	}

	@Override
	public boolean hasGlint(ItemStack stack) {
		return false;
	}

	@Override
	public boolean isNetworkSynced() {
		return true;
	}

}