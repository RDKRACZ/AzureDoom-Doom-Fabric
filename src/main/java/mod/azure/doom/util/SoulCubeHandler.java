package mod.azure.doom.util;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;

public class SoulCubeHandler {

	ClientWorld world;

//	public void attachCapabilities(AttachCapabilitiesEvent<ItemStack> evt) {
//		if (evt.getObject().getItem() != DoomItems.SOULCUBE) {
//			return;
//		}
//		ICurio curio = new ICurio() {
//
//			@Override
//			public boolean canRightClickEquip() {
//				return true;
//			}
//		};
//
//		ICapabilityProvider provider = new ICapabilityProvider() {
//			private final LazyOptional<ICurio> curioOpt = LazyOptional.of(() -> curio);
//
//			@Nonnull
//			@Override
//			public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
//				return CuriosCapability.ITEM.orEmpty(cap, curioOpt);
//			}
//		};
//		evt.addCapability(CuriosCapability.ID_ITEM, provider);
//	}
//
//	private boolean soulCube(LivingEntity livingEntity, DamageSource source) {
//		if (source.isSourceCreativePlayer()) {
//			return false;
//		}
//		for (ItemStack held : livingEntity.getItemsEquipped()) {
//			if (held.getItem() == DoomItems.SOULCUBE) {
//				return false;
//			}
//		}
//		return CuriosApi.getCuriosHelper().findEquippedCurio(DoomItems.SOULCUBE, livingEntity).map(soulcube -> {
//			this.activateSoulCube(livingEntity, soulcube.getRight());
//			return true;
//		}).orElse(false);
//	}

	private void activateSoulCube(LivingEntity livingEntity, ItemStack soulcube) {
		ItemStack copy = soulcube.copy();
		soulcube.decrement(1);

		if (livingEntity instanceof ServerPlayerEntity) {
			ServerPlayerEntity serverPlayer = (ServerPlayerEntity) livingEntity;
			Criteria.USED_TOTEM.trigger(serverPlayer, copy);
		}
		if (livingEntity instanceof PlayerEntity) {
			livingEntity.setHealth(20.0F);
			livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 100, 4));
			livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 100, 4));
			this.world.sendEntityStatus(livingEntity, (byte) 35);
		}
	}
}