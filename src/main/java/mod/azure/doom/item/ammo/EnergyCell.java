package mod.azure.doom.item.ammo;

import java.util.List;

import mod.azure.doom.entity.projectiles.EnergyCellEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

public class EnergyCell extends ArrowItem {

	public final float damage;

	public EnergyCell(Settings properties, float damageIn) {
		super(properties);
		this.damage = damageIn;
	}

	@Override
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(new TranslatableText("\u00A7o" + "Used for the Plasma Gun."));
		super.appendTooltip(stack, world, tooltip, context);
	}

	@Override
	public EnergyCellEntity createArrow(World worldIn, ItemStack stack, LivingEntity shooter) {
		EnergyCellEntity arrowentity = new EnergyCellEntity(worldIn, shooter);
		arrowentity.setDamage(this.damage);
		return arrowentity;
	}

}