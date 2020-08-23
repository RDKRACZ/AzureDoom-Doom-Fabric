package mod.azure.doom.item.armor.skin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Wearable;

//created by Marctron
public class SkinArmor extends ArmorItem implements Wearable {

	public SkinArmor(ArmorMaterial materialIn, EquipmentSlot slot, Settings builder) {
		super(materialIn, slot, builder);
	}

	@Override
	public boolean hasGlint(ItemStack stack) {
		return false;
	}
	
//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	public final BipedEntityModel getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot,
//			BipedEntityModel _default) {
//		final BipedModelSkin model = new BipedModelSkin(0f, false);
//		if (!itemStack.isEmpty()) {
//			if (itemStack.getItem() instanceof ArmorItem) {
//				model.helmet.visible = armorSlot == EquipmentSlot.HEAD;
//				model.torso.visible = armorSlot == EquipmentSlot.CHEST;
//				model.rightArm.visible = armorSlot == EquipmentSlot.CHEST;
//				model.leftArm.visible = armorSlot == EquipmentSlot.CHEST;
//				model.rightLeg.visible = armorSlot == EquipmentSlot.LEGS;
//				model.leftLeg.visible = armorSlot == EquipmentSlot.LEGS;
//				model.head.visible = armorSlot == EquipmentSlot.HEAD;
//				model.torsoWear.visible = armorSlot == EquipmentSlot.CHEST;
//				model.bipedRightArmwear.visible = armorSlot == EquipmentSlot.CHEST;
//				model.bipedLeftArmwear.visible = armorSlot == EquipmentSlot.CHEST;
//				model.bipedRightLegwear.visible = (armorSlot == EquipmentSlot.LEGS);
//				model.bipedLeftLegwear.visible = (armorSlot == EquipmentSlot.LEGS);
//				model.sneaking = _default.sneaking;
//				model.riding = _default.riding;
//				model.child = _default.child;
//				model.rightArmPose = _default.rightArmPose;
//				model.leftArmPose = _default.leftArmPose;
//				return model;
//			}
//		}
//		return null;
//	}

}