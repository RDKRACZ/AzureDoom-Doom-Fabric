package mod.azure.doom.item.tools;

import java.util.List;

import me.crimsondawn45.fabricshieldlib.object.BasicShield;
import mod.azure.doom.DoomMod;
import mod.azure.doom.util.enums.DoomTier;
import mod.azure.doom.util.registry.DoomItems;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class ArgentShield extends BasicShield {

	public ArgentShield() {
		super(new Item.Settings().group(DoomMod.DoomWeaponItemGroup).maxCount(1), 100, 337, DoomItems.ARGENT_ENERGY);
	}

	@Override
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(new TranslatableText("doom.argent_powered.text").formatted(Formatting.RED)
				.formatted(Formatting.ITALIC));
		super.appendTooltip(stack, world, tooltip, context);
	}

	@Override
	public boolean canRepair(ItemStack stack, ItemStack ingredient) {
		return DoomTier.DOOM.getRepairIngredient().test(ingredient) || super.canRepair(stack, ingredient);
	}

}