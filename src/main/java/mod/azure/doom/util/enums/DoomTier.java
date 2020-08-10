package mod.azure.doom.util.enums;

import java.util.function.Supplier;

import mod.azure.doom.util.DoomItems;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

public enum DoomTier implements ToolMaterial {
	DOOM(18, 1561, 3.0F, 16.0F, 30, () -> {
		return Ingredient.ofItems(DoomItems.ARGENT_ENERGY);
	});

	private final int miningLevel;
	private final int itemDurability;
	private final float miningSpeed;
	private final float attackDamage;
	private final int enchantability;
	private final Lazy<Ingredient> repairIngredient;

	private DoomTier(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability,
			Supplier<Ingredient> repairIngredient) {

		this.miningLevel = miningLevel;
		this.itemDurability = itemDurability;
		this.miningSpeed = miningSpeed;
		this.attackDamage = attackDamage;
		this.enchantability = enchantability;
		this.repairIngredient = new Lazy<Ingredient>(repairIngredient);
	}

	public int getDurability() {
		return this.itemDurability;
	}

	public float getMiningSpeedMultiplier() {
		return this.miningSpeed;
	}

	public float getAttackDamage() {
		return this.attackDamage;
	}

	public int getMiningLevel() {
		return this.miningLevel;
	}

	public int getEnchantability() {
		return this.enchantability;
	}

	public Ingredient getRepairIngredient() {
		return (Ingredient) this.repairIngredient.get();
	}

}