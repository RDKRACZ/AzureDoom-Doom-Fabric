package mod.azure.doom.item.weapons;

import java.util.List;

import mod.azure.doom.DoomMod;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

public class DoomBlade extends Item {

	public DoomBlade() {
		super(new Item.Settings().group(DoomMod.DoomWeaponItemGroup).maxCount(1).maxDamage(9000));
	}

	@Override
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(new TranslatableText("\u00A7c" + "\u00A7o" + "A modification to the Praetor suit,"));
		tooltip.add(new TranslatableText("\u00A7c" + "\u00A7o" + "the arm-mounted Doomblade is designed"));
		tooltip.add(
				new TranslatableText("\u00A7c" + "\u00A7o" + "to increase the Slayer's short-range striking power."));
		super.appendTooltip(stack, world, tooltip, context);
	}
}