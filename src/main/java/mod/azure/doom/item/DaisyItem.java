package mod.azure.doom.item;

import java.util.List;

import mod.azure.doom.DoomMod;
import net.minecraft.client.item.TooltipContext;
//import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

public class DaisyItem extends Item {

	public DaisyItem() {
		super(new Item.Settings().group(DoomMod.DoomItemGroup).maxCount(1));
	}

	@Override
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(new TranslatableText("\u00A7o" + "\u00A7e" + "For Daisy. Rip and Tear."));
		tooltip.add(new TranslatableText("\u00A7o" + "Grants the Player unlimited Speed 3 when worn."));
		super.appendTooltip(stack, world, tooltip, context);
	}
}