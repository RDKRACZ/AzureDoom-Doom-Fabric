package mod.azure.doom.item.weapons;

import java.util.List;

import io.netty.buffer.Unpooled;
import mod.azure.doom.DoomMod;
import mod.azure.doom.client.ClientInit;
import mod.azure.doom.util.enums.DoomTier;
import mod.azure.doom.util.registry.DoomBlocks;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class SwordCrucibleItem extends SwordItem {

	public SwordCrucibleItem() {
		super(DoomTier.DOOM_HIGHTEIR, 36, -2.4F, new Item.Settings().group(DoomMod.DoomWeaponItemGroup).maxCount(1));
	}

	@Override
	public boolean hasGlint(ItemStack stack) {
		return false;
	}

	@Override
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(new TranslatableText("doom.crucible_sword.text").formatted(Formatting.RED)
				.formatted(Formatting.ITALIC));
		tooltip.add(new TranslatableText(
				"Ammo: " + (stack.getMaxDamage() - stack.getDamage() - 1) + " / " + (stack.getMaxDamage() - 1))
						.formatted(Formatting.ITALIC));
		super.appendTooltip(stack, world, tooltip, context);
	}

	@Override
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		if (stack.getDamage() < (stack.getMaxDamage() - 1)) {
			stack.damage(1, target, p -> p.sendToolBreakStatus(target.getActiveHand()));
		}
		return (stack.getDamage() < (stack.getMaxDamage() - 1)) ? true : false;
	}

	public void reload(PlayerEntity user, Hand hand) {
		if (user.getStackInHand(hand).getItem() instanceof SwordCrucibleItem) {
			while (user.getStackInHand(hand).getDamage() != 0
					&& user.inventory.count(DoomBlocks.ARGENT_BLOCK.asItem()) > 0) {
				removeAmmo(DoomBlocks.ARGENT_BLOCK.asItem(), user);
				user.getStackInHand(hand).damage(-5, user, s -> user.sendToolBreakStatus(hand));
				user.getStackInHand(hand).setCooldown(3);
			}
		}
	}

	@Override
	public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
		if (world.isClient) {
			if (((PlayerEntity) entity).getMainHandStack().getItem() instanceof SwordCrucibleItem
					&& ClientInit.reload.isPressed() && selected) {
				PacketByteBuf passedData = new PacketByteBuf(Unpooled.buffer());
				passedData.writeBoolean(true);
				ClientPlayNetworking.send(DoomMod.CRUCIBLE, passedData);
			}
		}
	}

	private void removeAmmo(Item ammo, PlayerEntity playerEntity) {
		if (!playerEntity.isCreative()) {
			for (ItemStack item : playerEntity.inventory.main) {
				if (item.getItem() == DoomBlocks.ARGENT_BLOCK.asItem()) {
					item.decrement(1);
					break;
				}
			}
		}
	}

	@Override
	public void appendStacks(ItemGroup group, DefaultedList<ItemStack> stacks) {
		ItemStack stack = new ItemStack(this);
		stack.hasTag();
		stack.addEnchantment(Enchantments.SMITE, 10);
		stack.addEnchantment(Enchantments.LOOTING, 10);
		stack.addEnchantment(Enchantments.SHARPNESS, 10);
		stack.addEnchantment(Enchantments.SWEEPING, 10);
		if (group == DoomMod.DoomWeaponItemGroup) {
			stacks.add(stack);
		}
	}

	@Override
	public void onCraft(ItemStack stack, World world, PlayerEntity player) {
		stack.hasTag();
		stack.addEnchantment(Enchantments.SMITE, 10);
		stack.addEnchantment(Enchantments.LOOTING, 10);
		stack.addEnchantment(Enchantments.SHARPNESS, 10);
		stack.addEnchantment(Enchantments.SWEEPING, 10);
	}
}