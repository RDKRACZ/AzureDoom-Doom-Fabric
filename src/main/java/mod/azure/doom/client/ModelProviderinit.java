package mod.azure.doom.client;

import mod.azure.doom.item.weapons.SuperShotgun;
import mod.azure.doom.util.registry.DoomItems;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class ModelProviderinit {

	public static void init() {
		FabricModelPredicateProviderRegistry.register(DoomItems.PISTOL, new Identifier("pull"),
				(itemStack, clientWorld, livingEntity) -> {
					if (livingEntity == null) {
						return 0.0F;
					} else {
						return livingEntity.getActiveItem() != itemStack ? 0.0F
								: (float) (itemStack.getMaxUseTime() - livingEntity.getItemUseTimeLeft()) / 20.0F;
					}
				});
		FabricModelPredicateProviderRegistry.register(DoomItems.PISTOL, new Identifier("pulling"),
				(itemStack, clientWorld, livingEntity) -> {
					return livingEntity != null && livingEntity.isUsingItem()
							&& livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F;
				});
		FabricModelPredicateProviderRegistry.register(DoomItems.PLASMAGUN, new Identifier("pull"),
				(itemStack, clientWorld, livingEntity) -> {
					if (livingEntity == null) {
						return 0.0F;
					} else {
						return livingEntity.getActiveItem() != itemStack ? 0.0F
								: (float) (itemStack.getMaxUseTime() - livingEntity.getItemUseTimeLeft()) / 20.0F;
					}
				});
		FabricModelPredicateProviderRegistry.register(DoomItems.PLASMAGUN, new Identifier("pulling"),
				(itemStack, clientWorld, livingEntity) -> {
					return livingEntity != null && livingEntity.isUsingItem()
							&& livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F;
				});

		FabricModelPredicateProviderRegistry.register(DoomItems.SSG, new Identifier("pull"),
				(itemStack, clientWorld, livingEntity) -> {
					if (livingEntity == null) {
						return 0.0F;
					} else {
						return SuperShotgun.isCharged(itemStack) ? 0.0F
								: (float) (itemStack.getMaxUseTime() - livingEntity.getItemUseTimeLeft())
										/ (float) SuperShotgun.getPullTime(itemStack);
					}
				});
		FabricModelPredicateProviderRegistry.register(DoomItems.SSG, new Identifier("pulling"),
				(itemStack, clientWorld, livingEntity) -> {
					return livingEntity != null && livingEntity.isUsingItem()
							&& livingEntity.getActiveItem() == itemStack && !SuperShotgun.isCharged(itemStack) ? 1.0F
									: 0.0F;
				});
		FabricModelPredicateProviderRegistry.register(DoomItems.SSG, new Identifier("charged"),
				(itemStack, clientWorld, livingEntity) -> {
					return livingEntity != null && SuperShotgun.isCharged(itemStack) ? 1.0F : 0.0F;
				});
		FabricModelPredicateProviderRegistry.register(DoomItems.SSG, new Identifier("firework"),
				(itemStack, clientWorld, livingEntity) -> {
					return livingEntity != null && SuperShotgun.isCharged(itemStack)
							&& SuperShotgun.hasProjectile(itemStack, Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
				});

		FabricModelPredicateProviderRegistry.register(DoomItems.BALLISTA, new Identifier("pull"),
				(itemStack, clientWorld, livingEntity) -> {
					if (livingEntity == null) {
						return 0.0F;
					} else {
						return SuperShotgun.isCharged(itemStack) ? 0.0F
								: (float) (itemStack.getMaxUseTime() - livingEntity.getItemUseTimeLeft())
										/ (float) SuperShotgun.getPullTime(itemStack);
					}
				});
		FabricModelPredicateProviderRegistry.register(DoomItems.BALLISTA, new Identifier("pulling"),
				(itemStack, clientWorld, livingEntity) -> {
					return livingEntity != null && livingEntity.isUsingItem()
							&& livingEntity.getActiveItem() == itemStack && !SuperShotgun.isCharged(itemStack) ? 1.0F
									: 0.0F;
				});
		FabricModelPredicateProviderRegistry.register(DoomItems.BALLISTA, new Identifier("charged"),
				(itemStack, clientWorld, livingEntity) -> {
					return livingEntity != null && SuperShotgun.isCharged(itemStack) ? 1.0F : 0.0F;
				});
		FabricModelPredicateProviderRegistry.register(DoomItems.BALLISTA, new Identifier("firework"),
				(itemStack, clientWorld, livingEntity) -> {
					return livingEntity != null && SuperShotgun.isCharged(itemStack)
							&& SuperShotgun.hasProjectile(itemStack, Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
				});

		// Crucible
		FabricModelPredicateProviderRegistry.register(DoomItems.CRUCIBLESWORD, new Identifier("broken"),
				(itemStack, clientWorld, livingEntity) -> {
					return isUsable(itemStack) ? 0.0F : 1.0F;
				});
		// Marauder Axe
		FabricModelPredicateProviderRegistry.register(DoomItems.AXE_OPEN, new Identifier("broken"),
				(itemStack, clientWorld, livingEntity) -> {
					return itemStack.getDamage() < itemStack.getMaxDamage() - 1 ? 0.0F : 1.0F;
				});
	}

	private static boolean isUsable(ItemStack stack) {
		return stack.getDamage() < stack.getMaxDamage() - 1;
	}
}