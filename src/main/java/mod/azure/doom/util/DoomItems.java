package mod.azure.doom.util;

import mod.azure.doom.DoomMod;
import mod.azure.doom.item.ArgentEnergyItem;
import mod.azure.doom.item.DaisyItem;
import mod.azure.doom.item.E1M1MusicDisc;
import mod.azure.doom.item.UnopenedItem;
import mod.azure.doom.item.ammo.ArgentBolt;
import mod.azure.doom.item.ammo.BFGCell;
import mod.azure.doom.item.ammo.ChaingunAmmo;
import mod.azure.doom.item.ammo.ClipAmmo;
import mod.azure.doom.item.ammo.EnergyCell;
import mod.azure.doom.item.ammo.Rocket;
import mod.azure.doom.item.ammo.ShellAmmo;
import mod.azure.doom.item.entityweapons.BarenBlastItem;
import mod.azure.doom.item.entityweapons.CyberdemonAttackItem;
import mod.azure.doom.item.entityweapons.SpiderdemonAttackItem;
import mod.azure.doom.item.powerup.InmortalSphereItem;
import mod.azure.doom.item.powerup.InvisibleSphereItem;
import mod.azure.doom.item.powerup.MegaSphereItem;
import mod.azure.doom.item.powerup.PowerSphereItem;
import mod.azure.doom.item.powerup.SoulCubeItem;
import mod.azure.doom.item.tools.ArgentAxe;
import mod.azure.doom.item.tools.ArgentHoe;
import mod.azure.doom.item.tools.ArgentPaxel;
import mod.azure.doom.item.tools.ArgentPickaxe;
import mod.azure.doom.item.tools.ArgentShovel;
import mod.azure.doom.item.weapons.ArgentSword;
import mod.azure.doom.item.weapons.AxeMarauderItem;
import mod.azure.doom.item.weapons.BFG;
import mod.azure.doom.item.weapons.Ballista;
import mod.azure.doom.item.weapons.Chaingun;
import mod.azure.doom.item.weapons.Chainsaw;
import mod.azure.doom.item.weapons.PistolItem;
import mod.azure.doom.item.weapons.PlasmaGun;
import mod.azure.doom.item.weapons.RocketLauncher;
import mod.azure.doom.item.weapons.Shotgun;
import mod.azure.doom.item.weapons.SuperShotgun;
import mod.azure.doom.item.weapons.SwordCrucibleItem;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DoomItems {

	public static Item BARREL = station(ModRegistry.BLOCKS.BARREL_BLOCK);

	// AMMO
	public static Item SHOTGUN_SHELLS = item(new ShellAmmo(new Item.Settings().group(DoomMod.DoomItemGroup), 2.0F), "");
	public static Item ARGENT_BOLT = item(new ArgentBolt(new Item.Settings().group(DoomMod.DoomItemGroup), 2.7F), "");
	public static Item ENERGY_CELLS = item(new EnergyCell(new Item.Settings().group(DoomMod.DoomItemGroup), 10.0F), "");
	public static Item CHAINGUN_BULLETS = item(
			new ChaingunAmmo(new Item.Settings().group(DoomMod.DoomItemGroup), 10.0F), "");
	public static Item BULLETS = item(new ClipAmmo(new Item.Settings().group(DoomMod.DoomItemGroup), 1.2F), "");
	public static Item BFG_CELL = item(new BFGCell(new Item.Settings().group(DoomMod.DoomItemGroup), 1.2F), "");
	public static Item ROCKET = item(new Rocket(new Item.Settings().group(DoomMod.DoomItemGroup), 1.2F), "");
	// MISC
	public static Item ARGENT_ENERGY = item(new ArgentEnergyItem(), "");
	public static Item DAISY = item(new DaisyItem(), "");
	public static Item E1M1_MUSIC_DISC = item(new E1M1MusicDisc(), "");
	public static Item INMORTAL = item(new InmortalSphereItem(), "");
	public static Item INVISIBLE = item(new InvisibleSphereItem(), "");
	public static Item MEGA = item(new MegaSphereItem(), "");
	public static Item POWER = item(new PowerSphereItem(), "");
	public static Item SOULCUBE = item(new SoulCubeItem(), "");
	// WEAPONS AND TOOLS
	public static Item CRUCIBLESWORD = item(new SwordCrucibleItem(), "");
	public static Item ARGENT_AXE = item(new ArgentAxe(), "");
	public static Item ARGENT_HOE = item(new ArgentHoe(), "");
	public static Item ARGENT_PAXEL = item(new ArgentPaxel(), "");
	public static Item ARGENT_PICKAXE = item(new ArgentPickaxe(), "");
	public static Item ARGENT_SHOVEL = item(new ArgentShovel(), "");
	public static Item ARGENT_SWORD = item(new ArgentSword(), "");
	// public static Item ARGENT_SHIELD =
	// argent_shield",
	public static Item CHAINSAW = item(new Chainsaw(), "");
	public static Item SWORD_CLOSED = item(new UnopenedItem(), "");
	public static Item AXE_OPEN = item(new AxeMarauderItem(), "");
	public static Item AXE_CLOSED = item(new UnopenedItem(), "");
	public static Item SSG = item(new SuperShotgun(), "");
	public static Item SG = item(new Shotgun(), "");
	public static Item BFG = item(new BFG(), "");
	public static Item PLASMAGUN = item(new PlasmaGun(), "");
	public static Item ROCKETLAUNCHER = item(new RocketLauncher(), "");
//	public static Item UNMAYKR = item(new Unmaykr(), "");
	public static Item BALLISTA = item(new Ballista(), "");
	public static Item CHAINGUN = item(new Chaingun(), "");
	public static Item PISTOL = item(new PistolItem(), "");
	// MOB WEAPONS
	public static Item CYBERDEMONATTACK = item(new CyberdemonAttackItem(), "");
	public static Item SPIDERDEMONATTACK = item(new SpiderdemonAttackItem(), "");
	public static Item BARENBLAST = item(new BarenBlastItem(2.0F), "");

	// ARMOR THIS WON'T BE DONE FOR SOME TIME
//	public static Item DOOM_HELMET = item(new DoomArmor(DoomArmorMaterial.DOOM_ARMOR, EquipmentSlotType.HEAD);
//	public static Item DOOM_CHESTPLATE = item(new DoomArmor(DoomArmorMaterial.DOOM_ARMOR, EquipmentSlotType.CHEST);
//	public static Item DOOM_LEGGINGS = item(new DoomArmor(DoomArmorMaterial.DOOM_ARMOR, EquipmentSlotType.LEGS);
//	public static Item DOOM_BOOTS = item(new DoomArmor(DoomArmorMaterial.DOOM_ARMOR, EquipmentSlotType.FEET);
//	public static Item PRAETOR_DOOM_HELMET = item(new PraetorDoomArmor(DoomArmorMaterial.PRAETOR_DOOM_ARMOR,
//			EquipmentSlotType.HEAD);
//	public static Item PRAETOR_DOOM_CHESTPLATE = item(new PraetorDoomArmor(DoomArmorMaterial.PRAETOR_DOOM_ARMOR,
//			EquipmentSlotType.CHEST);
//	public static Item PRAETOR_DOOM_LEGGINGS = item(new PraetorDoomArmor(DoomArmorMaterial.PRAETOR_DOOM_ARMOR,
//			EquipmentSlotType.LEGS);
//	public static Item PRAETOR_DOOM_BOOTS = item(new PraetorDoomArmor(DoomArmorMaterial.PRAETOR_DOOM_ARMOR,
//			EquipmentSlotType.FEET);
//	public static Item ASTRO_DOOM_HELMET = item(new AstroDoomArmor(DoomArmorMaterial.ASTRO_DOOM_ARMOR,
//			EquipmentSlotType.HEAD);
//	public static Item ASTRO_DOOM_CHESTPLATE = item(new AstroDoomArmor(DoomArmorMaterial.ASTRO_DOOM_ARMOR,
//			EquipmentSlotType.CHEST);
//	public static Item ASTRO_DOOM_LEGGINGS = item(new AstroDoomArmor(DoomArmorMaterial.ASTRO_DOOM_ARMOR,
//			EquipmentSlotType.LEGS);
//	public static Item ASTRO_DOOM_BOOTS = item(new AstroDoomArmor(DoomArmorMaterial.ASTRO_DOOM_ARMOR,
//			EquipmentSlotType.FEET);
//	public static Item CRIMSON_DOOM_HELMET = item(new CrimsonDoomArmor(DoomArmorMaterial.CRIMSON_DOOM_ARMOR,
//			EquipmentSlotType.HEAD);
//	public static Item CRIMSON_DOOM_CHESTPLATE = item(new CrimsonDoomArmor(DoomArmorMaterial.CRIMSON_DOOM_ARMOR,
//			EquipmentSlotType.CHEST);
//	public static Item CRIMSON_DOOM_LEGGINGS = item(new CrimsonDoomArmor(DoomArmorMaterial.CRIMSON_DOOM_ARMOR,
//			EquipmentSlotType.LEGS);
//	public static Item CRIMSON_DOOM_BOOTS = item(new CrimsonDoomArmor(DoomArmorMaterial.CRIMSON_DOOM_ARMOR,
//			EquipmentSlotType.FEET);
//	public static Item MIDNIGHT_DOOM_HELMET = item(new MidnightDoomArmor(DoomArmorMaterial.MIDNIGHT_DOOM_ARMOR,
//			EquipmentSlotType.HEAD);
//	public static Item MIDNIGHT_DOOM_CHESTPLATE = item(new MidnightDoomArmor(DoomArmorMaterial.MIDNIGHT_DOOM_ARMOR,
//			EquipmentSlotType.CHEST);
//	public static Item MIDNIGHT_DOOM_LEGGINGS = item(new MidnightDoomArmor(DoomArmorMaterial.MIDNIGHT_DOOM_ARMOR,
//			EquipmentSlotType.LEGS);
//	public static Item MIDNIGHT_DOOM_BOOTS = item(new MidnightDoomArmor(DoomArmorMaterial.MIDNIGHT_DOOM_ARMOR,
//			EquipmentSlotType.FEET);
//	public static Item DEMONIC_DOOM_HELMET = item(new DemonicDoomArmor(DoomArmorMaterial.DEMONIC_DOOM_ARMOR,
//			EquipmentSlotType.HEAD);
//	public static Item DEMONIC_DOOM_CHESTPLATE = item(new DemonicDoomArmor(DoomArmorMaterial.DEMONIC_DOOM_ARMOR,
//			EquipmentSlotType.CHEST);
//	public static Item DEMONIC_DOOM_LEGGINGS = item(new DemonicDoomArmor(DoomArmorMaterial.DEMONIC_DOOM_ARMOR,
//			EquipmentSlotType.LEGS);
//	public static Item DEMONIC_DOOM_BOOTS = item(new DemonicDoomArmor(DoomArmorMaterial.DEMONIC_DOOM_ARMOR,
//			EquipmentSlotType.FEET);
//	public static Item SENTINEL_DOOM_HELMET = item(new SentinelDoomArmor(DoomArmorMaterial.SENTINEL_DOOM_ARMOR,
//			EquipmentSlotType.HEAD);
//	public static Item SENTINEL_DOOM_CHESTPLATE = item(new SentinelDoomArmor(DoomArmorMaterial.SENTINEL_DOOM_ARMOR,
//			EquipmentSlotType.CHEST);
//	public static Item SENTINEL_DOOM_LEGGINGS = item(new SentinelDoomArmor(DoomArmorMaterial.SENTINEL_DOOM_ARMOR,
//			EquipmentSlotType.LEGS);
//	public static Item SENTINEL_DOOM_BOOTS = item(new SentinelDoomArmor(DoomArmorMaterial.SENTINEL_DOOM_ARMOR,
//			EquipmentSlotType.FEET);
//	public static Item EMBER_DOOM_HELMET = item(new EmberDoomArmor(DoomArmorMaterial.EMBER_DOOM_ARMOR,
//			EquipmentSlotType.HEAD);
//	public static Item EMBER_DOOM_CHESTPLATE = item(new EmberDoomArmor(DoomArmorMaterial.EMBER_DOOM_ARMOR,
//			EquipmentSlotType.CHEST);
//	public static Item EMBER_DOOM_LEGGINGS = item(new EmberDoomArmor(DoomArmorMaterial.EMBER_DOOM_ARMOR,
//			EquipmentSlotType.LEGS);
//	public static Item EMBER_DOOM_BOOTS = item(new EmberDoomArmor(DoomArmorMaterial.EMBER_DOOM_ARMOR,
//			EquipmentSlotType.FEET);
//	public static Item ZOMBIE_DOOM_HELMET = item(new ZombieDoomArmor(DoomArmorMaterial.ZOMBIE_DOOM_ARMOR,
//			EquipmentSlotType.HEAD);
//	public static Item ZOMBIE_DOOM_CHESTPLATE = item(new ZombieDoomArmor(DoomArmorMaterial.ZOMBIE_DOOM_ARMOR,
//			EquipmentSlotType.CHEST);
//	public static Item ZOMBIE_DOOM_LEGGINGS = item(new ZombieDoomArmor(DoomArmorMaterial.ZOMBIE_DOOM_ARMOR,
//			EquipmentSlotType.LEGS);
//	public static Item ZOMBIE_DOOM_BOOTS = item(new ZombieDoomArmor(DoomArmorMaterial.ZOMBIE_DOOM_ARMOR,
//			EquipmentSlotType.FEET);
//	public static Item PHOBOS_DOOM_HELMET = item(new PhobosDoomArmor(DoomArmorMaterial.PHOBOS_DOOM_ARMOR,
//			EquipmentSlotType.HEAD);
//	public static Item PHOBOS_DOOM_CHESTPLATE = item(new PhobosDoomArmor(DoomArmorMaterial.PHOBOS_DOOM_ARMOR,
//			EquipmentSlotType.CHEST);
//	public static Item PHOBOS_DOOM_LEGGINGS = item(new PhobosDoomArmor(DoomArmorMaterial.PHOBOS_DOOM_ARMOR,
//			EquipmentSlotType.LEGS);
//	public static Item PHOBOS_DOOM_BOOTS = item(new PhobosDoomArmor(DoomArmorMaterial.PHOBOS_DOOM_ARMOR,
//			EquipmentSlotType.FEET);
//	public static Item NIGHTMARE_DOOM_HELMET = item(new NightmareDoomArmor(DoomArmorMaterial.NIGHTMARE_DOOM_ARMOR,
//			EquipmentSlotType.HEAD);
//	public static Item NIGHTMARE_DOOM_CHESTPLATE = item(new NightmareDoomArmor(DoomArmorMaterial.NIGHTMARE_DOOM_ARMOR,
//			EquipmentSlotType.CHEST);
//	public static Item NIGHTMARE_DOOM_LEGGINGS = item(new NightmareDoomArmor(DoomArmorMaterial.NIGHTMARE_DOOM_ARMOR,
//			EquipmentSlotType.LEGS);
//	public static Item NIGHTMARE_DOOM_BOOTS = item(new NightmareDoomArmor(DoomArmorMaterial.NIGHTMARE_DOOM_ARMOR,
//			EquipmentSlotType.FEET);
//	public static Item PURPLEPONY_DOOM_HELMET = item(new PurplePonyDoomArmor(DoomArmorMaterial.PURPLEPONY_DOOM_ARMOR,
//			EquipmentSlotType.HEAD);
//	public static Item PURPLEPONY_DOOM_CHESTPLATE = item(new PurplePonyDoomArmor(
//			DoomArmorMaterial.PURPLEPONY_DOOM_ARMOR, EquipmentSlotType.CHEST);
//	public static Item PURPLEPONY_DOOM_LEGGINGS = item(new PurplePonyDoomArmor(DoomArmorMaterial.PURPLEPONY_DOOM_ARMOR,
//			EquipmentSlotType.LEGS);
//	public static Item PURPLEPONY_DOOM_BOOTS = item(new PurplePonyDoomArmor(DoomArmorMaterial.PURPLEPONY_DOOM_ARMOR,
//			EquipmentSlotType.FEET);
//	public static Item DOOMICORN_DOOM_HELMET = item(new DoomicornDoomArmor(DoomArmorMaterial.DOOMICORN_DOOM_ARMOR,
//			EquipmentSlotType.HEAD);
//	public static Item DOOMICORN_DOOM_CHESTPLATE = item(new DoomicornDoomArmor(DoomArmorMaterial.DOOMICORN_DOOM_ARMOR,
//			EquipmentSlotType.CHEST);
//	public static Item DOOMICORN_DOOM_LEGGINGS = item(new DoomicornDoomArmor(DoomArmorMaterial.DOOMICORN_DOOM_ARMOR,
//			EquipmentSlotType.LEGS);
//	public static Item DOOMICORN_DOOM_BOOTS = item(new DoomicornDoomArmor(DoomArmorMaterial.DOOMICORN_DOOM_ARMOR,
//			EquipmentSlotType.FEET);
//	public static Item GOLD_DOOM_HELMET = item(new GoldDoomArmor(DoomArmorMaterial.GOLD_ARMOR, EquipmentSlotType.HEAD);
//	public static Item GOLD_DOOM_CHESTPLATE = item(new GoldDoomArmor(DoomArmorMaterial.GOLD_ARMOR,
//			EquipmentSlotType.CHEST);
//	public static Item GOLD_DOOM_LEGGINGS = item(new GoldDoomArmor(DoomArmorMaterial.GOLD_ARMOR,
//			EquipmentSlotType.LEGS);
//	public static Item GOLD_DOOM_BOOTS = item(new GoldDoomArmor(DoomArmorMaterial.GOLD_ARMOR, EquipmentSlotType.FEET);
//	public static Item TWENTY_FIVE_DOOM_HELMET = item(new DoomArmor(DoomArmorMaterial.TWENTY_FIVE_ARMOR,
//			EquipmentSlotType.HEAD);
//	public static Item TWENTY_FIVE_DOOM_CHESTPLATE = item(new DoomArmor(DoomArmorMaterial.TWENTY_FIVE_ARMOR,
//			EquipmentSlotType.CHEST);
//	public static Item TWENTY_FIVE_DOOM_LEGGINGS = item(new DoomArmor(DoomArmorMaterial.TWENTY_FIVE_ARMOR,
//			EquipmentSlotType.LEGS);
//	public static Item TWENTY_FIVE_DOOM_BOOTS = item(new DoomArmor(DoomArmorMaterial.TWENTY_FIVE_ARMOR,
//			EquipmentSlotType.FEET);
//	public static Item BRONZE_DOOM_HELMET = item(new DoomArmor(DoomArmorMaterial.BRONZE_DOOM_ARMOR,
//			EquipmentSlotType.HEAD);
//	public static Item BRONZE_DOOM_CHESTPLATE = item(new DoomArmor(DoomArmorMaterial.BRONZE_DOOM_ARMOR,
//			EquipmentSlotType.CHEST);
//	public static Item BRONZE_DOOM_LEGGINGS = item(new DoomArmor(DoomArmorMaterial.BRONZE_DOOM_ARMOR,
//			EquipmentSlotType.LEGS);
//	public static Item BRONZE_DOOM_BOOTS = item(new DoomArmor(DoomArmorMaterial.BRONZE_DOOM_ARMOR,
//			EquipmentSlotType.FEET);
//	public static Item CULTIST_DOOM_HELMET = item(new CultistDoomArmor(DoomArmorMaterial.CULTIST_DOOM_ARMOR,
//			EquipmentSlotType.HEAD);
//	public static Item CULTIST_DOOM_CHESTPLATE = item(new CultistDoomArmor(DoomArmorMaterial.CULTIST_DOOM_ARMOR,
//			EquipmentSlotType.CHEST);
//	public static Item CULTIST_DOOM_LEGGINGS = item(new CultistDoomArmor(DoomArmorMaterial.CULTIST_DOOM_ARMOR,
//			EquipmentSlotType.LEGS);
//	public static Item CULTIST_DOOM_BOOTS = item(new CultistDoomArmor(DoomArmorMaterial.CULTIST_DOOM_ARMOR,
//			EquipmentSlotType.FEET);
//	public static Item MAYKR_DOOM_HELMET = item(new MaykrDoomArmor(DoomArmorMaterial.MAYKR_DOOM_ARMOR,
//			EquipmentSlotType.HEAD);
//	public static Item MAYKR_DOOM_CHESTPLATE = item(new MaykrDoomArmor(DoomArmorMaterial.MAYKR_DOOM_ARMOR,
//			EquipmentSlotType.CHEST);
//	public static Item MAYKR_DOOM_LEGGINGS = item(new MaykrDoomArmor(DoomArmorMaterial.MAYKR_DOOM_ARMOR,
//			EquipmentSlotType.LEGS);
//	public static Item MAYKR_DOOM_BOOTS = item(new MaykrDoomArmor(DoomArmorMaterial.MAYKR_DOOM_ARMOR,
//			EquipmentSlotType.FEET);
//	public static Item PAINTER_DOOM_HELMET = item(new PainterDoomArmor(DoomArmorMaterial.PAINTER_DOOM_ARMOR,
//			EquipmentSlotType.HEAD);
//	public static Item PAINTER_DOOM_CHESTPLATE = item(new PainterDoomArmor(DoomArmorMaterial.PAINTER_DOOM_ARMOR,
//			EquipmentSlotType.CHEST);
//	public static Item PAINTER_DOOM_LEGGINGS = item(new PainterDoomArmor(DoomArmorMaterial.PAINTER_DOOM_ARMOR,
//			EquipmentSlotType.LEGS);
//	public static Item PAINTER_DOOM_BOOTS = item(new PainterDoomArmor(DoomArmorMaterial.PAINTER_DOOM_ARMOR,
//			EquipmentSlotType.FEET);
//	public static Item CLASSIC_DOOM_HELMET = item(new ClassicDoomArmor(DoomArmorMaterial.CLASSIC_DOOM_ARMOR,
//			EquipmentSlotType.HEAD);
//	public static Item CLASSIC_DOOM_CHESTPLATE = item(new ClassicDoomArmor(DoomArmorMaterial.CLASSIC_DOOM_ARMOR,
//			EquipmentSlotType.CHEST);
//	public static Item CLASSIC_DOOM_LEGGINGS = item(new ClassicDoomArmor(DoomArmorMaterial.CLASSIC_DOOM_ARMOR,
//			EquipmentSlotType.LEGS);
//	public static Item CLASSIC_RED_DOOM_CHESTPLATE = item(new ClassicDoomArmor(DoomArmorMaterial.CLASSIC_RED_ARMOR,
//			EquipmentSlotType.CHEST);
//	public static Item CLASSIC_RED_DOOM_LEGGINGS = item(new ClassicDoomArmor(DoomArmorMaterial.CLASSIC_RED_ARMOR,
//			EquipmentSlotType.LEGS);
//	public static Item CLASSIC_INDIGO_DOOM_CHESTPLATE = item(new ClassicDoomArmor(
//			DoomArmorMaterial.CLASSIC_INDIGO_ARMOR, EquipmentSlotType.CHEST);
//	public static Item CLASSIC_INDIGO_DOOM_LEGGINGS = item(new ClassicDoomArmor(DoomArmorMaterial.CLASSIC_INDIGO_ARMOR,
//			EquipmentSlotType.LEGS);
//	public static Item CLASSIC_BRONZE_DOOM_CHESTPLATE = item(new ClassicDoomArmor(
//			DoomArmorMaterial.CLASSIC_BRONZE_ARMOR, EquipmentSlotType.CHEST);
//	public static Item CLASSIC_BRONZE_DOOM_LEGGINGS = item(new ClassicDoomArmor(DoomArmorMaterial.CLASSIC_BRONZE_ARMOR,
//			EquipmentSlotType.LEGS);
//	public static Item CLASSIC_DOOM_BOOTS = item(new ClassicDoomArmor(DoomArmorMaterial.CLASSIC_DOOM_ARMOR,
//			EquipmentSlotType.FEET);
//	public static Item MULLET_DOOM_HELMET1 = item(new MulletDoomArmor(DoomArmorMaterial.REDNECK1_ARMOR,
//			EquipmentSlotType.HEAD);
//	public static Item MULLET_DOOM_HELMET2 = item(new MulletDoomArmor(DoomArmorMaterial.REDNECK2_ARMOR,
//			EquipmentSlotType.HEAD);
//	public static Item MULLET_DOOM_HELMET3 = item(new MulletDoomArmor(DoomArmorMaterial.REDNECK3_ARMOR,
//			EquipmentSlotType.HEAD);
//	public static Item MULLET_DOOM_CHESTPLATE1 = item(new MulletDoomArmor(DoomArmorMaterial.REDNECK1_ARMOR,
//			EquipmentSlotType.CHEST);
//	public static Item MULLET_DOOM_CHESTPLATE2 = item(new MulletDoomArmor(DoomArmorMaterial.REDNECK2_ARMOR,
//			EquipmentSlotType.CHEST);
//	public static Item MULLET_DOOM_CHESTPLATE3 = item(new MulletDoomArmor(DoomArmorMaterial.REDNECK3_ARMOR,
//			EquipmentSlotType.CHEST);
//	public static Item MULLET_DOOM_LEGGINGS1 = item(new MulletDoomArmor(DoomArmorMaterial.REDNECK1_ARMOR,
//			EquipmentSlotType.LEGS);
//	public static Item MULLET_DOOM_LEGGINGS2 = item(new MulletDoomArmor(DoomArmorMaterial.REDNECK2_ARMOR,
//			EquipmentSlotType.LEGS);
//	public static Item MULLET_DOOM_LEGGINGS3 = item(new MulletDoomArmor(DoomArmorMaterial.REDNECK3_ARMOR,
//			EquipmentSlotType.LEGS);
//	public static Item MULLET_DOOM_BOOTS1 = item(new MulletDoomArmor(DoomArmorMaterial.REDNECK1_ARMOR,
//			EquipmentSlotType.FEET);
//	public static Item MULLET_DOOM_BOOTS2 = item(new MulletDoomArmor(DoomArmorMaterial.REDNECK2_ARMOR,
//			EquipmentSlotType.FEET);
//	public static Item MULLET_DOOM_BOOTS3 = item(new MulletDoomArmor(DoomArmorMaterial.REDNECK3_ARMOR,
//			EquipmentSlotType.FEET);

	static Item.Settings stationProp = new Item.Settings().group(DoomMod.DoomItemGroup);

	static <T extends Item> T item(T c, String id) {
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, id), c);
		return c;
	}

	static <T extends Block> Item station(T block) {
		return item(new BlockItem(block, stationProp), Registry.BLOCK.getId(block).getPath());
	}
}