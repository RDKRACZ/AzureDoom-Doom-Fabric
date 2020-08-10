package mod.azure.doom.item.armor;

import java.util.List;

import mod.azure.doom.DoomMod;
import mod.azure.doom.item.armor.skin.SkinArmor;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class PhobosDoomArmor extends SkinArmor {

	public PhobosDoomArmor(ArmorMaterial materialIn, EquipmentSlot slot) {
		super(materialIn, slot, new Item.Settings().group(DoomMod.DoomItemGroup).maxCount(1));

	}

	@Override

	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(new TranslatableText(
				"\u00A7o" + "\u00A7e" + "Only given those that process the will and might of a true Slayer."));
		super.appendTooltip(stack, world, tooltip, context);
	}

	@Override
	public void appendStacks(ItemGroup group, DefaultedList<ItemStack> stacks) {
		ItemStack stack = new ItemStack(this);
		stack.hasTag();
		stack.addEnchantment(Enchantments.BLAST_PROTECTION, 5);
		stack.addEnchantment(Enchantments.FEATHER_FALLING, 5);
		stack.addEnchantment(Enchantments.FIRE_PROTECTION, 5);
		stack.addEnchantment(Enchantments.THORNS, 5);
		if (group == DoomMod.DoomItemGroup) {
			stacks.add(stack);
		}
	}

	@Override
	public void onCraft(ItemStack stack, World world, PlayerEntity player) {
		stack.hasTag();
		stack.addEnchantment(Enchantments.BLAST_PROTECTION, 5);
		stack.addEnchantment(Enchantments.FEATHER_FALLING, 5);
		stack.addEnchantment(Enchantments.FIRE_PROTECTION, 5);
		stack.addEnchantment(Enchantments.THORNS, 5);
	}

}