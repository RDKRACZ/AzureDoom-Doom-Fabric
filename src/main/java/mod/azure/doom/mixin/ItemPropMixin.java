package mod.azure.doom.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import mod.azure.doom.item.weapons.SuperShotgun;
import mod.azure.doom.util.DoomItems;
import net.minecraft.client.item.ModelPredicateProvider;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

@Mixin(ModelPredicateProviderRegistry.class)
public class ItemPropMixin {
	@Invoker
	static void callRegister(Item item, Identifier id, ModelPredicateProvider provider) {
	}

	static {
		callRegister(DoomItems.SG, new Identifier("pull"), (itemStack, clientWorld, livingEntity) -> {
			if (livingEntity == null) {
				return 0.0F;
			} else {
				return livingEntity.getActiveItem() != itemStack ? 0.0F
						: (float) (itemStack.getMaxUseTime() - livingEntity.getItemUseTimeLeft()) / 20.0F;
			}
		});
		callRegister(DoomItems.SG, new Identifier("pulling"), (itemStack, clientWorld, livingEntity) -> {
			return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack
					? 1.0F
					: 0.0F;
		});
		callRegister(DoomItems.PISTOL, new Identifier("pull"), (itemStack, clientWorld, livingEntity) -> {
			if (livingEntity == null) {
				return 0.0F;
			} else {
				return livingEntity.getActiveItem() != itemStack ? 0.0F
						: (float) (itemStack.getMaxUseTime() - livingEntity.getItemUseTimeLeft()) / 20.0F;
			}
		});
		callRegister(DoomItems.PISTOL, new Identifier("pulling"), (itemStack, clientWorld, livingEntity) -> {
			return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack
					? 1.0F
					: 0.0F;
		});
		callRegister(DoomItems.PLASMAGUN, new Identifier("pull"), (itemStack, clientWorld, livingEntity) -> {
			if (livingEntity == null) {
				return 0.0F;
			} else {
				return livingEntity.getActiveItem() != itemStack ? 0.0F
						: (float) (itemStack.getMaxUseTime() - livingEntity.getItemUseTimeLeft()) / 20.0F;
			}
		});
		callRegister(DoomItems.PLASMAGUN, new Identifier("pulling"), (itemStack, clientWorld, livingEntity) -> {
			return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack
					? 1.0F
					: 0.0F;
		});

		callRegister(DoomItems.SSG, new Identifier("pull"), (itemStack, clientWorld, livingEntity) -> {
			if (livingEntity == null) {
				return 0.0F;
			} else {
				return SuperShotgun.isCharged(itemStack) ? 0.0F
						: (float) (itemStack.getMaxUseTime() - livingEntity.getItemUseTimeLeft())
								/ (float) SuperShotgun.getPullTime(itemStack);
			}
		});
		callRegister(DoomItems.SSG, new Identifier("pulling"), (itemStack, clientWorld, livingEntity) -> {
			return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack
					&& !SuperShotgun.isCharged(itemStack) ? 1.0F : 0.0F;
		});
		callRegister(DoomItems.SSG, new Identifier("charged"), (itemStack, clientWorld, livingEntity) -> {
			return livingEntity != null && SuperShotgun.isCharged(itemStack) ? 1.0F : 0.0F;
		});
		callRegister(DoomItems.SSG, new Identifier("firework"), (itemStack, clientWorld, livingEntity) -> {
			return livingEntity != null && SuperShotgun.isCharged(itemStack)
					&& SuperShotgun.hasProjectile(itemStack, Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
		});

		callRegister(DoomItems.BALLISTA, new Identifier("pull"), (itemStack, clientWorld, livingEntity) -> {
			if (livingEntity == null) {
				return 0.0F;
			} else {
				return SuperShotgun.isCharged(itemStack) ? 0.0F
						: (float) (itemStack.getMaxUseTime() - livingEntity.getItemUseTimeLeft())
								/ (float) SuperShotgun.getPullTime(itemStack);
			}
		});
		callRegister(DoomItems.BALLISTA, new Identifier("pulling"), (itemStack, clientWorld, livingEntity) -> {
			return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack
					&& !SuperShotgun.isCharged(itemStack) ? 1.0F : 0.0F;
		});
		callRegister(DoomItems.BALLISTA, new Identifier("charged"), (itemStack, clientWorld, livingEntity) -> {
			return livingEntity != null && SuperShotgun.isCharged(itemStack) ? 1.0F : 0.0F;
		});
		callRegister(DoomItems.BALLISTA, new Identifier("firework"), (itemStack, clientWorld, livingEntity) -> {
			return livingEntity != null && SuperShotgun.isCharged(itemStack)
					&& SuperShotgun.hasProjectile(itemStack, Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
		});
	}
}