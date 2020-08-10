package mod.azure.doom.item;

import java.util.List;

import mod.azure.doom.DoomMod;
import net.minecraft.client.item.TooltipContext;
//import net.minecraft.entity.LivingEntity;
//import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
//import top.theillusivec4.curios.api.CuriosApi;
//import top.theillusivec4.curios.api.CuriosCapability;
//import top.theillusivec4.curios.api.type.capability.ICurio;

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

//	@Override
//	public ICapabilityProvider initCapabilities(final ItemStack stack, CompoundNBT unused) {
//		ICurio curio = new ICurio() {
//			@Override
//			public boolean canRightClickEquip() {
//				return true;
//			}
//
//			@Override
//			public void onEquip(String identifier, int index, LivingEntity livingEntity) {
//				if (livingEntity instanceof PlayerEntity) {
//					startPowers((PlayerEntity) livingEntity);
//				}
//			}
//
//			@Override
//			public void onUnequip(String identifier, int index, LivingEntity livingEntity) {
//				if (livingEntity instanceof PlayerEntity) {
//					stopPowers((PlayerEntity) livingEntity);
//				}
//			}
//
//			private void startPowers(PlayerEntity player) {
//				player.addPotionEffect(new EffectInstance(Effects.SPEED, 10000000, 2));
//			}
//
//			private void stopPowers(PlayerEntity player) {
//				player.removePotionEffect(Effects.SPEED);
//			}
//
//			@Override
//			public void curioTick(String identifier, int index, LivingEntity livingEntity) {
//				if (livingEntity instanceof PlayerEntity) {
//					PlayerEntity player = ((PlayerEntity) livingEntity);
//					startPowers(player);
//				}
//			}
//
//			@Override
//			public boolean canEquip(String identifier, LivingEntity entityLivingBase) {
//				return !CuriosApi.getCuriosHelper().findEquippedCurio(DoomItems.DAISY.get(), entityLivingBase)
//						.isPresent();
//			}
//		};
//
//		return new ICapabilityProvider() {
//			private final LazyOptional<ICurio> curioOpt = LazyOptional.of(() -> curio);
//
//			@Nonnull
//			@Override
//			public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
//
//				return CuriosCapability.ITEM.orEmpty(cap, curioOpt);
//			}
//		};
//	}
//
//	public static boolean isRingInCuriosSlot(ItemStack belt, LivingEntity player) {
//		return CuriosApi.getCuriosHelper().findEquippedCurio(belt.getItem(), player).isPresent();
//	}
}