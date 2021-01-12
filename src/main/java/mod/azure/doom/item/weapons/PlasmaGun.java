package mod.azure.doom.item.weapons;

import java.util.function.Predicate;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.projectiles.EnergyCellEntity;
import mod.azure.doom.item.ammo.EnergyCell;
import mod.azure.doom.util.ModSoundEvents;
import mod.azure.doom.util.enums.DoomTier;
import mod.azure.doom.util.registry.DoomItems;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.RangedWeaponItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class PlasmaGun extends RangedWeaponItem implements IAnimatable {

	public AnimationFactory factory = new AnimationFactory(this);
	private String controllerName = "controller";

	private <P extends RangedWeaponItem & IAnimatable> PlayState predicate(AnimationEvent<P> event) {
		return PlayState.CONTINUE;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController(this, controllerName, 1, this::predicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}

	public PlasmaGun() {
		super(new Item.Settings().group(DoomMod.DoomWeaponItemGroup).maxCount(1).maxDamage(9000));
	}

	@Override
	public boolean hasGlint(ItemStack stack) {
		return false;
	}

	@Override
	public boolean canRepair(ItemStack stack, ItemStack ingredient) {
		return DoomTier.DOOM.getRepairIngredient().test(ingredient) || super.canRepair(stack, ingredient);
	}

	@Override
	public void usageTick(World worldIn, LivingEntity livingEntityIn, ItemStack stack, int count) {
		if (livingEntityIn instanceof PlayerEntity) {
			PlayerEntity playerentity = (PlayerEntity) livingEntityIn;
			boolean flag = playerentity.abilities.creativeMode
					|| EnchantmentHelper.getLevel(Enchantments.INFINITY, stack) > 0;
			ItemStack itemstack = playerentity.getArrowType(stack);

			if (!itemstack.isEmpty() || flag) {
				if (itemstack.isEmpty()) {
					itemstack = new ItemStack(DoomItems.ENERGY_CELLS);
				}

				if (playerentity.getMainHandStack().getCooldown() == 0) {

					if (!worldIn.isClient) {
						EnergyCell arrowitem = (EnergyCell) (itemstack.getItem() instanceof EnergyCell
								? itemstack.getItem()
								: DoomItems.ENERGY_CELLS);
						EnergyCellEntity abstractarrowentity = arrowitem.createArrow(worldIn, itemstack, playerentity);
						abstractarrowentity = customeArrow(abstractarrowentity);
						abstractarrowentity.setProperties(playerentity, playerentity.pitch, playerentity.yaw, 0.0F,
								0.15F * 3.0F, 1.0F);

						abstractarrowentity.setDamage(abstractarrowentity.getDamage() + 22.0);


						abstractarrowentity.hasNoGravity();

						stack.damage(1, livingEntityIn, p -> p.sendToolBreakStatus(livingEntityIn.getActiveHand()));
						worldIn.spawnEntity(abstractarrowentity);
					}
					worldIn.playSound((PlayerEntity) null, playerentity.getX(), playerentity.getY(),
							playerentity.getZ(), ModSoundEvents.PLASMA_FIRING, SoundCategory.PLAYERS, 1.0F,
							1.0F / (RANDOM.nextFloat() * 0.4F + 1.2F) + 0.10F * 0.5F);
					if (!playerentity.abilities.creativeMode) {
						itemstack.decrement(1);
						if (itemstack.isEmpty()) {
							playerentity.inventory.removeOne(itemstack);
						}
					}
					AnimationController<?> controller = GeckoLibUtil.getControllerForStack(this.factory, stack,
							controllerName);
					if (controller.getAnimationState() == AnimationState.Stopped) {
						controller.markNeedsReload();
						controller.setAnimation(new AnimationBuilder().addAnimation("firing", false));
					}
					playerentity.getMainHandStack().setCooldown(10);
				}
			}
		}
	}

	@Override
	public int getMaxUseTime(ItemStack stack) {
		return 72000;
	}

	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.BLOCK;
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
		return itemStack -> itemStack.getItem() instanceof EnergyCell;
	}

	@Override
	public Predicate<ItemStack> getHeldProjectiles() {
		return getProjectiles();
	}

	public EnergyCellEntity customeArrow(EnergyCellEntity arrow) {
		return arrow;
	}

	@Override
	public int getRange() {
		return 15;
	}
}