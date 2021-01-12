package mod.azure.doom.item.weapons;

import java.util.function.Predicate;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.projectiles.UnmaykrBoltEntity;
import mod.azure.doom.item.ammo.UnmaykrBolt;
import mod.azure.doom.util.ModSoundEvents;
import mod.azure.doom.util.enums.DoomTier;
import mod.azure.doom.util.registry.DoomItems;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.RangedWeaponItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class Unmaykr extends RangedWeaponItem {

	public Unmaykr() {
		super(new Item.Settings().group(DoomMod.DoomWeaponItemGroup).maxCount(1).maxDamage(9000));
	}

	@Override
	public boolean hasGlint(ItemStack stack) {
		return false;
	}

	@Override
	public void appendStacks(ItemGroup group, DefaultedList<ItemStack> stacks) {
		ItemStack stack = new ItemStack(this);
		stack.hasTag();
		stack.addEnchantment(Enchantments.INFINITY, 1);
		if (group == DoomMod.DoomWeaponItemGroup) {
			stacks.add(stack);
		}
	}

	@Override
	public void onCraft(ItemStack stack, World world, PlayerEntity player) {
		stack.hasTag();
		stack.addEnchantment(Enchantments.INFINITY, 1);
	}

	@Override
	public boolean canRepair(ItemStack stack, ItemStack ingredient) {
		return DoomTier.DOOM.getRepairIngredient().test(ingredient) || super.canRepair(stack, ingredient);
	}

	@Override
	public void usageTick(World worldIn, LivingEntity entityLiving, ItemStack stack, int count) {
		if (entityLiving instanceof PlayerEntity) {
			PlayerEntity playerentity = (PlayerEntity) entityLiving;
			boolean flag = playerentity.abilities.creativeMode
					|| EnchantmentHelper.getLevel(Enchantments.INFINITY, stack) > 0;
			ItemStack itemstack = playerentity.getArrowType(stack);

			if (!itemstack.isEmpty() || flag) {
				if (itemstack.isEmpty()) {
					itemstack = new ItemStack(DoomItems.UNMAKRY_BOLT);
				}

				if (playerentity.getMainHandStack().getCooldown() == 0) {
					if (!worldIn.isClient) {
						UnmaykrBolt arrowitem = (UnmaykrBolt) (itemstack.getItem() instanceof UnmaykrBolt
								? itemstack.getItem()
								: DoomItems.UNMAKRY_BOLT);
						UnmaykrBoltEntity abstractarrowentity = arrowitem.createArrow(worldIn, itemstack, playerentity);
						abstractarrowentity = customeArrow(abstractarrowentity);
						abstractarrowentity.setProperties(playerentity, playerentity.pitch, playerentity.yaw, 0.0F,
								1.0F * 3.0F, 1.0F);

						abstractarrowentity.setDamage(abstractarrowentity.getDamage() + 1.5);

						abstractarrowentity.hasNoGravity();

						stack.damage(1, entityLiving, p -> p.sendToolBreakStatus(entityLiving.getActiveHand()));
						worldIn.spawnEntity(abstractarrowentity);
					}
					worldIn.playSound((PlayerEntity) null, playerentity.getX(), playerentity.getY(),
							playerentity.getZ(), ModSoundEvents.UNMAKYR_FIRE, SoundCategory.PLAYERS, 1.0F,
							1.0F / (RANDOM.nextFloat() * 0.4F + 1.2F) + 0.25F * 0.5F);
					if (!playerentity.abilities.creativeMode) {
						itemstack.decrement(1);
						if (itemstack.isEmpty()) {
							playerentity.inventory.removeOne(itemstack);
						}
					}
					playerentity.getMainHandStack().setCooldown(20);
				}
			}
		}
	}

	public static float getArrowVelocity(int charge) {
		return 1.0F;
	}

	@Override
	public int getMaxUseTime(ItemStack stack) {
		return 72000;
	}

	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.NONE;
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack itemStack = user.getStackInHand(hand);
		boolean bl = !user.getArrowType(itemStack).isEmpty();
		if (!user.abilities.creativeMode && !bl) {
			return TypedActionResult.fail(itemStack);
		} else {
			user.setCurrentHand(hand);
			return TypedActionResult.consume(itemStack);
		}
	}

	@Override
	public Predicate<ItemStack> getProjectiles() {
		return itemStack -> itemStack.getItem() instanceof UnmaykrBolt;
	}

	@Override
	public Predicate<ItemStack> getHeldProjectiles() {
		return getProjectiles();
	}

	public UnmaykrBoltEntity customeArrow(UnmaykrBoltEntity arrow) {
		return arrow;
	}

	@Override
	public int getRange() {
		return 15;
	}
}