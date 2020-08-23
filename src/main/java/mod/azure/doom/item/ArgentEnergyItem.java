package mod.azure.doom.item;

import java.util.List;

import mod.azure.doom.DoomMod;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

public class ArgentEnergyItem extends Item {

	public ArgentEnergyItem() {
		super(new Item.Settings().group(DoomMod.DoomPowerUPItemGroup));
	}

	@Override
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(new TranslatableText("\u00A7c" + "\u00A7o" + "Created by combining the tortured"));
		tooltip.add(new TranslatableText("\u00A7c" + "\u00A7o" + "souls of the Nether and the power"));
		tooltip.add(new TranslatableText("\u00A7c" + "\u00A7o" + "of the Aether."));
		super.appendTooltip(stack, world, tooltip, context);
	}

	@Override
	public boolean hasGlint(ItemStack stack) {
		return false;
	}
}