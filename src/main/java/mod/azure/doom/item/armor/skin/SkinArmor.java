package mod.azure.doom.item.armor.skin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Wearable;

public class SkinArmor extends ArmorItem implements Wearable {

	public SkinArmor(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
		super(material, slot, settings.maxDamageIfAbsent(material.getDurability(slot)));
	}
}