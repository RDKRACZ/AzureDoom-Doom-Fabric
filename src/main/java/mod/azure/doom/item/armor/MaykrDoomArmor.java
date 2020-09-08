package mod.azure.doom.item.armor;

import java.util.List;

import mod.azure.doom.DoomMod;
import mod.azure.doom.item.armor.skin.SkinArmor;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

public class MaykrDoomArmor extends SkinArmor {

	public MaykrDoomArmor(ArmorMaterial materialIn, EquipmentSlot slot) {
		super(materialIn, slot, new Item.Settings().group(DoomMod.DoomArmorItemGroup).maxCount(1));

	}

	@Override
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(new TranslatableText(
				"\u00A7o" + "\u00A7e" + "The armor crafted from the fallen beings of the Aether."));
		super.appendTooltip(stack, world, tooltip, context);
	}

}