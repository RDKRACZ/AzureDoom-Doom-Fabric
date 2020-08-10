package mod.azure.doom.item.ammo;

import java.util.List;

import mod.azure.doom.entity.projectiles.ArgentBoltEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

public class ArgentBolt extends ArrowItem {

	public final float damage;

	public ArgentBolt(Settings properties, float damageIn) {
		super(properties);
		this.damage = damageIn;
	}

	@Override
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(new TranslatableText("\u00A7o" + "Powered by Argent. Used for Ballista."));
		super.appendTooltip(stack, world, tooltip, context);
	}

	public ArgentBoltEntity createArrow(World world, ItemStack stack, LivingEntity shooter) {
		ArgentBoltEntity arrowEntity = new ArgentBoltEntity(world, shooter);
		arrowEntity.initFromStack(stack);
		return arrowEntity;
	}

}