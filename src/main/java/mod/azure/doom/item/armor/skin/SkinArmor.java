package mod.azure.doom.item.armor.skin;

import mod.azure.doom.client.models.BipedModelSkin;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;

//created by Marctron
public class SkinArmor extends ArmorItem {

	public SkinArmor(ArmorMaterial materialIn, EquipmentSlot slot, Settings builder) {
		super(materialIn, slot, builder);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public final BipedEntityModel getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot,
			BipedEntityModel _default) {
		final BipedModelSkin model = new BipedModelSkin(0f, false);
		if (!itemStack.isEmpty()) {
			if (itemStack.getItem() instanceof ArmorItem) {
				model.helmet.visible = armorSlot == EquipmentSlot.HEAD;
				model.torso.visible = armorSlot == EquipmentSlot.CHEST;
				model.rightArm.visible = armorSlot == EquipmentSlot.CHEST;
				model.leftArm.visible = armorSlot == EquipmentSlot.CHEST;
				model.rightLeg.visible = armorSlot == EquipmentSlot.LEGS;
				model.leftLeg.visible = armorSlot == EquipmentSlot.LEGS;
				model.head.visible = armorSlot == EquipmentSlot.HEAD;
				model.torsoWear.visible = armorSlot == EquipmentSlot.CHEST;
				model.bipedRightArmwear.visible = armorSlot == EquipmentSlot.CHEST;
				model.bipedLeftArmwear.visible = armorSlot == EquipmentSlot.CHEST;
				model.bipedRightLegwear.visible = (armorSlot == EquipmentSlot.LEGS);
				model.bipedLeftLegwear.visible = (armorSlot == EquipmentSlot.LEGS);
				model.isSneaking = _default.isSneaking;
				model.riding = _default.riding;
				model.child = _default.child;
				model.rightArmPose = _default.rightArmPose;
				model.leftArmPose = _default.leftArmPose;
				return model;
			}
		}
		return null;
	}

}