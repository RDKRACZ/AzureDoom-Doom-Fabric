package mod.azure.doom.util.enums;

import java.util.function.Supplier;

import mod.azure.doom.util.DoomItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

public enum DoomArmorMaterial implements ArmorMaterial {
	DOOM_ARMOR("doomweapon:doom_armor", 50, new int[] { 5, 8, 10, 5 }, 30, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 8.0F,
			0.4F, () -> {
				return Ingredient.ofItems(DoomItems.ARGENT_ENERGY);
			}),
	PRAETOR_DOOM_ARMOR("doomweapon:praetor_armor", 50, new int[] { 5, 8, 10, 5 }, 30,
			SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 8.0F, 0.4F, () -> {
				return Ingredient.ofItems(DoomItems.ARGENT_ENERGY);
			}),
	CLASSIC_DOOM_ARMOR("doomweapon:classic_armor", 50, new int[] { 5, 8, 10, 5 }, 30,
			SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 8.0F, 0.4F, () -> {
				return Ingredient.ofItems(DoomItems.ARGENT_ENERGY);
			}),
	MIDNIGHT_DOOM_ARMOR("doomweapon:midnight_armor", 50, new int[] { 5, 8, 10, 5 }, 30,
			SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 8.0F, 0.4F, () -> {
				return Ingredient.ofItems(DoomItems.ARGENT_ENERGY);
			}),
	ASTRO_DOOM_ARMOR("doomweapon:astro_armor", 50, new int[] { 5, 8, 10, 5 }, 30, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC,
			8.0F, 0.4F, () -> {
				return Ingredient.ofItems(DoomItems.ARGENT_ENERGY);
			}),
	DEMONIC_DOOM_ARMOR("doomweapon:demonic_armor", 50, new int[] { 5, 8, 10, 5 }, 30,
			SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 8.0F, 0.4F, () -> {
				return Ingredient.ofItems(DoomItems.ARGENT_ENERGY);
			}),
	SENTINEL_DOOM_ARMOR("doomweapon:sentinel_armor", 50, new int[] { 5, 8, 10, 5 }, 30,
			SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 8.0F, 0.4F, () -> {
				return Ingredient.ofItems(DoomItems.ARGENT_ENERGY);
			}),
	EMBER_DOOM_ARMOR("doomweapon:ember_armor", 50, new int[] { 5, 8, 10, 5 }, 30, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC,
			8.0F, 0.4F, () -> {
				return Ingredient.ofItems(DoomItems.ARGENT_ENERGY);
			}),
	ZOMBIE_DOOM_ARMOR("doomweapon:zombie_armor", 50, new int[] { 5, 8, 10, 5 }, 30,
			SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 8.0F, 0.4F, () -> {
				return Ingredient.ofItems(DoomItems.ARGENT_ENERGY);
			}),
	DOOMICORN_DOOM_ARMOR("doomweapon:doomicorn_armor", 50, new int[] { 5, 8, 10, 5 }, 30,
			SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 8.0F, 0.4F, () -> {
				return Ingredient.ofItems(DoomItems.ARGENT_ENERGY);
			}),
	PURPLEPONY_DOOM_ARMOR("doomweapon:purplepony_armor", 50, new int[] { 5, 8, 10, 5 }, 30,
			SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 8.0F, 0.4F, () -> {
				return Ingredient.ofItems(DoomItems.ARGENT_ENERGY);
			}),
	NIGHTMARE_DOOM_ARMOR("doomweapon:nightmare_armor", 50, new int[] { 5, 8, 10, 5 }, 30,
			SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 8.0F, 0.4F, () -> {
				return Ingredient.ofItems(DoomItems.ARGENT_ENERGY);
			}),
	PHOBOS_DOOM_ARMOR("doomweapon:phobos_armor", 50, new int[] { 5, 8, 10, 5 }, 30,
			SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 8.0F, 0.4F, () -> {
				return Ingredient.ofItems(DoomItems.ARGENT_ENERGY);
			}),
	CLASSIC_RED_ARMOR("doomweapon:classic_red_armor", 50, new int[] { 5, 8, 10, 5 }, 30,
			SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 8.0F, 0.4F, () -> {
				return Ingredient.ofItems(DoomItems.ARGENT_ENERGY);
			}),
	CLASSIC_INDIGO_ARMOR("doomweapon:classic_indigo_armor", 50, new int[] { 5, 8, 10, 5 }, 30,
			SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 8.0F, 0.4F, () -> {
				return Ingredient.ofItems(DoomItems.ARGENT_ENERGY);
			}),
	CLASSIC_BRONZE_ARMOR("doomweapon:classic_bronze_armor", 50, new int[] { 5, 8, 10, 5 }, 30,
			SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 8.0F, 0.4F, () -> {
				return Ingredient.ofItems(DoomItems.ARGENT_ENERGY);
			}),
	GOLD_ARMOR("doomweapon:gold_armor", 50, new int[] { 5, 8, 10, 5 }, 30, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 8.0F,
			0.4F, () -> {
				return Ingredient.ofItems(DoomItems.ARGENT_ENERGY);
			}),
	TWENTY_FIVE_ARMOR("doomweapon:twenty_five_armor", 50, new int[] { 5, 8, 10, 5 }, 30,
			SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 8.0F, 0.4F, () -> {
				return Ingredient.ofItems(DoomItems.ARGENT_ENERGY);
			}),
	REDNECK1_ARMOR("doomweapon:redneck1_armor", 50, new int[] { 5, 8, 10, 5 }, 30, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC,
			8.0F, 0.4F, () -> {
				return Ingredient.ofItems(DoomItems.ARGENT_ENERGY);
			}),
	REDNECK2_ARMOR("doomweapon:redneck2_armor", 50, new int[] { 5, 8, 10, 5 }, 30, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC,
			8.0F, 0.4F, () -> {
				return Ingredient.ofItems(DoomItems.ARGENT_ENERGY);
			}),
	REDNECK3_ARMOR("doomweapon:redneck3_armor", 50, new int[] { 5, 8, 10, 5 }, 30, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC,
			8.0F, 0.4F, () -> {
				return Ingredient.ofItems(DoomItems.ARGENT_ENERGY);
			}),
	BRONZE_DOOM_ARMOR("doomweapon:bronze_armor", 50, new int[] { 5, 8, 10, 5 }, 30,
			SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 8.0F, 0.4F, () -> {
				return Ingredient.ofItems(DoomItems.ARGENT_ENERGY);
			}),
	PAINTER_DOOM_ARMOR("doomweapon:painter_armor", 50, new int[] { 5, 8, 10, 5 }, 30,
			SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 8.0F, 0.4F, () -> {
				return Ingredient.ofItems(DoomItems.ARGENT_ENERGY);
			}),
	CULTIST_DOOM_ARMOR("doomweapon:cultist_armor", 50, new int[] { 5, 8, 10, 5 }, 30,
			SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 8.0F, 0.4F, () -> {
				return Ingredient.ofItems(DoomItems.ARGENT_ENERGY);
			}),
	MAYKR_DOOM_ARMOR("doomweapon:maykr_armor", 50, new int[] { 5, 8, 10, 5 }, 30, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC,
			8.0F, 0.4F, () -> {
				return Ingredient.ofItems(DoomItems.ARGENT_ENERGY);
			}),
	CRIMSON_DOOM_ARMOR("doomweapon:crimson_armor", 50, new int[] { 5, 8, 10, 5 }, 30,
			SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 8.0F, 0.4F, () -> {
				return Ingredient.ofItems(DoomItems.ARGENT_ENERGY);
			});

	private static final int[] BASE_DURABILITY = new int[] { 13, 15, 16, 11 };
	private final String name;
	private final int durabilityMultiplier;
	private final int[] protectionAmounts;
	private final int enchantability;
	private final SoundEvent equipSound;
	private final float toughness;
	private final float knockbackResistance;
	private final Lazy<Ingredient> repairIngredientSupplier;

	private DoomArmorMaterial(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability,
			SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> supplier) {
		this.name = name;
		this.durabilityMultiplier = durabilityMultiplier;
		this.protectionAmounts = protectionAmounts;
		this.enchantability = enchantability;
		this.equipSound = equipSound;
		this.toughness = toughness;
		this.knockbackResistance = knockbackResistance;
		this.repairIngredientSupplier = new Lazy<Ingredient>(supplier);
	}

	public int getDurability(EquipmentSlot slot) {
		return BASE_DURABILITY[slot.getEntitySlotId()] * this.durabilityMultiplier;
	}

	public int getProtectionAmount(EquipmentSlot slot) {
		return this.protectionAmounts[slot.getEntitySlotId()];
	}

	public int getEnchantability() {
		return this.enchantability;
	}

	public SoundEvent getEquipSound() {
		return this.equipSound;
	}

	public Ingredient getRepairIngredient() {
		return (Ingredient) this.repairIngredientSupplier.get();
	}

	@Environment(EnvType.CLIENT)
	public String getName() {
		return this.name;
	}

	public float getToughness() {
		return this.toughness;
	}

	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}
}