package mod.azure.doom.item.entityweapons;

import java.util.function.Consumer;
import java.util.function.Predicate;

import mod.azure.doom.entity.projectiles.BarenBlastEntity;
import mod.azure.doom.util.DoomItems;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.RangedWeaponItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class BarenBlastItem extends RangedWeaponItem {

	public final float damage;

	public BarenBlastItem(float damageIn) {
		super(new Item.Settings().maxCount(1));
		this.damage = damageIn;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void usageTick(World worldIn, LivingEntity livingEntityIn, ItemStack stack, int count) {
		if (livingEntityIn instanceof PlayerEntity) {
			PlayerEntity playerEntity = (PlayerEntity) livingEntityIn;
			boolean bl = playerEntity.abilities.creativeMode
					|| EnchantmentHelper.getLevel(Enchantments.INFINITY, stack) > 0;
			ItemStack itemStack = playerEntity.getArrowType(stack);
			if (!itemStack.isEmpty() || bl) {
				if (itemStack.isEmpty()) {
					itemStack = new ItemStack(DoomItems.BARENBLAST);
				}
				boolean bl2 = bl && itemStack.getItem() == DoomItems.BARENBLAST;
				if (!worldIn.isClient) {
					BarenBlastItem arrowItem = (BarenBlastItem) ((BarenBlastItem) (itemStack
							.getItem() instanceof BarenBlastItem ? itemStack.getItem() : DoomItems.BARENBLAST));
					BarenBlastEntity persistentProjectileEntity = arrowItem.createArrow(worldIn, itemStack,
							playerEntity);
					persistentProjectileEntity.setProperties(playerEntity, playerEntity.pitch, playerEntity.yaw, 0.0F,
							0.25F * 3.0F, 1.0F);

					persistentProjectileEntity.setNoGravity(true);

					stack.damage(1, (LivingEntity) playerEntity, (Consumer) ((p) -> {
						((LivingEntity) p).sendToolBreakStatus(playerEntity.getActiveHand());
					}));
					if (bl2 || playerEntity.abilities.creativeMode && (itemStack.getItem() == Items.SPECTRAL_ARROW
							|| itemStack.getItem() == Items.TIPPED_ARROW)) {
						persistentProjectileEntity.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
					}
					worldIn.spawnEntity(persistentProjectileEntity);
				}
				worldIn.playSound((PlayerEntity) null, playerEntity.getX(), playerEntity.getY(), playerEntity.getZ(),
						SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F,
						1.0F / (RANDOM.nextFloat() * 0.4F + 1.2F) + 0.25F * 0.5F);
				if (!bl2 && !playerEntity.abilities.creativeMode) {
					itemStack.decrement(1);
					if (itemStack.isEmpty()) {
						playerEntity.inventory.removeOne(itemStack);
					}
				}
			}
		}
	}

	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.NONE;
	}

	@Override
	public int getMaxUseTime(ItemStack stack) {
		return 72000;
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
		return itemStack -> itemStack.getItem() instanceof BarenBlastItem;
	}

	public BarenBlastEntity customeArrow(BarenBlastEntity abstractarrowentity) {
		return abstractarrowentity;
	}

	@Override
	public int getRange() {
		return 15;
	}

	public BarenBlastEntity createArrow(World world, ItemStack stack, LivingEntity shooter) {
		BarenBlastEntity arrowentity = new BarenBlastEntity(world, shooter);
		return arrowentity;
	}

	public static float getPullProgress(int useTicks) {
		float f = (float) useTicks / 20.0F;
		f = (f * f + f * 2.0F) / 3.0F;
		if (f > 1.0F) {
			f = 1.0F;
		}

		return f;
	}

}