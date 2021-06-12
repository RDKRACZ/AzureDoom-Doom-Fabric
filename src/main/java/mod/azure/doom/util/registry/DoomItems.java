package mod.azure.doom.util.registry;

import java.util.HashMap;
import java.util.Map;

import mod.azure.doom.DoomMod;
import mod.azure.doom.item.ArgentEnergyItem;
import mod.azure.doom.item.ArgentPlateItem;
import mod.azure.doom.item.E1M1MusicDisc;
import mod.azure.doom.item.UnopenedItem;
import mod.azure.doom.item.ammo.ArgentBolt;
import mod.azure.doom.item.ammo.BFGCell;
import mod.azure.doom.item.ammo.ChaingunAmmo;
import mod.azure.doom.item.ammo.ClipAmmo;
import mod.azure.doom.item.ammo.EnergyCell;
import mod.azure.doom.item.ammo.Rocket;
import mod.azure.doom.item.ammo.ShellAmmo;
import mod.azure.doom.item.ammo.UnmaykrBolt;
import mod.azure.doom.item.eggs.DoomSpawnEgg;
import mod.azure.doom.item.powerup.DaisyItem;
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
import mod.azure.doom.item.weapons.BFG9000;
import mod.azure.doom.item.weapons.Ballista;
import mod.azure.doom.item.weapons.Chaingun;
import mod.azure.doom.item.weapons.Chainsaw;
import mod.azure.doom.item.weapons.ChainsawAnimated;
import mod.azure.doom.item.weapons.HeavyCannon;
import mod.azure.doom.item.weapons.PistolItem;
import mod.azure.doom.item.weapons.PlasmaGun;
import mod.azure.doom.item.weapons.RocketLauncher;
import mod.azure.doom.item.weapons.Shotgun;
import mod.azure.doom.item.weapons.SuperShotgun;
import mod.azure.doom.item.weapons.SwordCrucibleItem;
import mod.azure.doom.item.weapons.Unmaykr;
import mod.azure.doom.util.ModSoundEvents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DoomItems {

	public static Shotgun SG = item(new Shotgun(), "shotgun");
	public static BFG9000 BFG = item(new BFG9000(), "bfg9000");
	public static BFG BFG_ETERNAL = item(new BFG(), "bfg_eternal");
	public static DaisyItem DAISY = item(new DaisyItem(), "daisy");
	public static Rocket ROCKET = item(new Rocket(2.2F), "rocket");
	public static Unmaykr UNMAYKR = item(new Unmaykr(), "unmaykr");
	public static Ballista BALLISTA = item(new Ballista(), "ballista");
	public static Chaingun CHAINGUN = item(new Chaingun(), "chaingun");
	public static Chainsaw CHAINSAW = item(new Chainsaw(), "chainsaw");
	public static PistolItem PISTOL = item(new PistolItem(), "pistol");
	public static ClipAmmo BULLETS = item(new ClipAmmo(1.2F), "bullets");
	public static BFGCell BFG_CELL = item(new BFGCell(10.2F), "bfg_cell");
	public static Chainsaw CHAINSAW64 = item(new Chainsaw(), "chainsaw64");
	public static PlasmaGun PLASMAGUN = item(new PlasmaGun(), "plasmagun");
	public static ArgentAxe ARGENT_AXE = item(new ArgentAxe(), "argent_axe");
	public static ArgentHoe ARGENT_HOE = item(new ArgentHoe(), "argent_hoe");
	public static SuperShotgun SSG = item(new SuperShotgun(), "supershotgun");
	public static SoulCubeItem SOULCUBE = item(new SoulCubeItem(), "soulcube");
	public static MegaSphereItem MEGA = item(new MegaSphereItem(), "megasphere");
	public static HeavyCannon HEAVYCANNON = item(new HeavyCannon(), "heavycannon");
	public static Item ICON_ICON = item(new Item(new Item.Settings()), "icon_icon");
	public static ArgentBolt ARGENT_BOLT = item(new ArgentBolt(1.7F), "argent_bolt");
	public static ArgentPaxel ARGENT_PAXEL = item(new ArgentPaxel(), "argent_paxel");
	public static ArgentSword ARGENT_SWORD = item(new ArgentSword(), "argent_sword");
	public static PowerSphereItem POWER = item(new PowerSphereItem(), "powersphere");
	public static EnergyCell ENERGY_CELLS = item(new EnergyCell(2.2F), "energy_cells");
	public static ArgentShovel ARGENT_SHOVEL = item(new ArgentShovel(), "argent_shovel");
	public static ShellAmmo SHOTGUN_SHELLS = item(new ShellAmmo(2.0F), "shotgun_shells");
	public static UnmaykrBolt UNMAKRY_BOLT = item(new UnmaykrBolt(10.2F), "unmaykr_bolt");
	public static UnopenedItem AXE_CLOSED = item(new UnopenedItem(), "axe_marauder_closed");
	public static ArgentPickaxe ARGENT_PICKAXE = item(new ArgentPickaxe(), "argent_pickaxe");
	public static ArgentPlateItem ARGENT_PLATE = item(new ArgentPlateItem(), "argent_plate");
	public static AxeMarauderItem AXE_OPEN = item(new AxeMarauderItem(), "axe_marauder_open");
	public static UnopenedItem SWORD_CLOSED = item(new UnopenedItem(), "cruciblesword_closed");
	public static RocketLauncher ROCKETLAUNCHER = item(new RocketLauncher(), "rocketlauncher");
	public static ArgentEnergyItem ARGENT_ENERGY = item(new ArgentEnergyItem(), "argent_energy");
	public static InmortalSphereItem INMORTAL = item(new InmortalSphereItem(), "inmortalsphere");
	public static ChaingunAmmo CHAINGUN_BULLETS = item(new ChaingunAmmo(10.0F), "chaingunbullets");
	public static SwordCrucibleItem CRUCIBLESWORD = item(new SwordCrucibleItem(), "cruciblesword");
	public static InvisibleSphereItem INVISIBLE = item(new InvisibleSphereItem(), "invisiblesphere");
	public static ChainsawAnimated CHAINSAW_ETERNAL = item(new ChainsawAnimated(), "chainsaweternal");
	public static E1M1MusicDisc E1M1_MUSIC_DISC = item(new E1M1MusicDisc(ModSoundEvents.E1M1), "e1m1_music_disc");
	public static Item GAS_BARREL = item(new Item(new Item.Settings().group(DoomMod.DoomWeaponItemGroup)),
			"gas_barrel");
	public static BlockItem GUN_TABLE = item(
			new BlockItem(DoomMod.GUN_TABLE, new Item.Settings().group(DoomMod.DoomWeaponItemGroup)), "gun_table");

	public static Item[] ITEMS = { CHAINSAW_ETERNAL, CRUCIBLESWORD, ROCKETLAUNCHER, AXE_OPEN, HEAVYCANNON, SSG,
			PLASMAGUN, CHAINSAW64, CHAINSAW, CHAINGUN, BALLISTA, UNMAYKR, BFG_ETERNAL, BFG, SG, PISTOL };

	public static Map<Item, Item> getItemMap() {
		Map<Item, Item> vanillaItemMap = new HashMap<>();
		for (Item i : DoomItems.ITEMS) {
			vanillaItemMap.put(Registry.ITEM.get(new Identifier(DoomMod.MODID, Registry.ITEM.getId(i).getPath())), i);
		}
		return vanillaItemMap;
	}

	// Spawn Eggs
	public static DoomSpawnEgg ARACHNOTRON_SPAWN_EGG = item(new DoomSpawnEgg(ModEntityTypes.ARACHNOTRON),
			"arachnotron_spawn_egg");
	public static DoomSpawnEgg NIGHTMARE_IMP_SPAWN_EGG = item(new DoomSpawnEgg(ModEntityTypes.NIGHTMARE_IMP),
			"nightmare_imp_spawn_egg");
	public static DoomSpawnEgg IMP_SPAWN_EGG = item(new DoomSpawnEgg(ModEntityTypes.IMP), "imp_spawn_egg");
	public static DoomSpawnEgg PINKY_SPAWN_EGG = item("pinky_spawn_egg", new DoomSpawnEgg(ModEntityTypes.PINKY));
	public static DoomSpawnEgg ARCHVILE_SPAWN_EGG = item("archvile_spawn_egg",
			new DoomSpawnEgg(ModEntityTypes.ARCHVILE));
	public static DoomSpawnEgg BARON_SPAWN_EGG = item("baron_spawn_egg", new DoomSpawnEgg(ModEntityTypes.BARON));
	public static DoomSpawnEgg CACODEMON_SPAWN_EGG = item("cacodemon_spawn_egg",
			new DoomSpawnEgg(ModEntityTypes.CACODEMON));
	public static DoomSpawnEgg MANCUBUS_SPAWN_EGG = item("mancubus_spawn_egg",
			new DoomSpawnEgg(ModEntityTypes.MANCUBUS));
	public static DoomSpawnEgg LOST_SOUL_SPAWN_EGG = item("lost_soul_spawn_egg",
			new DoomSpawnEgg(ModEntityTypes.LOST_SOUL));
	public static DoomSpawnEgg SPIDERMASTERMIND_SPAWN_EGG = item("spidermastermind_spawn_egg",
			new DoomSpawnEgg(ModEntityTypes.SPIDERMASTERMIND));
	public static DoomSpawnEgg ZOMBIEMAN_SPAWN_EGG = item("zombieman_spawn_egg",
			new DoomSpawnEgg(ModEntityTypes.ZOMBIEMAN));
	public static DoomSpawnEgg CHAINGUNNER_SPAWN_EGG = item("chaingunner_spawn_egg",
			new DoomSpawnEgg(ModEntityTypes.CHAINGUNNER));
	public static DoomSpawnEgg HELLKNIGHT_SPAWN_EGG = item("hellknight_spawn_egg",
			new DoomSpawnEgg(ModEntityTypes.HELLKNIGHT));
	public static DoomSpawnEgg IMP2016_SPAWN_EGG = item("imp2016_spawn_egg", new DoomSpawnEgg(ModEntityTypes.IMP2016));
	public static DoomSpawnEgg MARAUDER_SPAWN_EGG = item("marauder_spawn_egg",
			new DoomSpawnEgg(ModEntityTypes.MARAUDER));
	public static DoomSpawnEgg PAIN_SPAWN_EGG = item("pain_spawn_egg", new DoomSpawnEgg(ModEntityTypes.PAIN));
	public static DoomSpawnEgg REVENANT_SPAWN_EGG = item("revenant_spawn_egg",
			new DoomSpawnEgg(ModEntityTypes.REVENANT));
	public static DoomSpawnEgg SHOTGUNGUY_SPAWN_EGG = item("shotgunguy_spawn_egg",
			new DoomSpawnEgg(ModEntityTypes.SHOTGUNGUY));
	public static DoomSpawnEgg CYBERDEMON_SPAWN_EGG = item("cyberdemon_spawn_egg",
			new DoomSpawnEgg(ModEntityTypes.CYBERDEMON));
	public static DoomSpawnEgg CYBERDEMON2016_SPAWN_EGG = item("cyberdemon2016_spawn_egg",
			new DoomSpawnEgg(ModEntityTypes.CYBERDEMON2016));
	public static DoomSpawnEgg ICON_SPAWN_EGG = item("icon_of_sin_spawn_egg",
			new DoomSpawnEgg(ModEntityTypes.ICONOFSIN));
	public static DoomSpawnEgg UNWILLING_SPAWN_EGG = item("unwilling_spawn_egg",
			new DoomSpawnEgg(ModEntityTypes.UNWILLING));
	public static DoomSpawnEgg POSSESSED_SCIENTIST_SPAWN_EGG = item("possessed_scientist_spawn_egg",
			new DoomSpawnEgg(ModEntityTypes.POSSESSEDSCIENTIST));
	public static DoomSpawnEgg POSSESSED_SOLDIER_SPAWN_EGG = item("possessed_soldier_spawn_egg",
			new DoomSpawnEgg(ModEntityTypes.POSSESSEDSOLDIER));
	public static DoomSpawnEgg GORE_NEST_SPAWN_EGG = item("gorenest_spawn_egg",
			new DoomSpawnEgg(ModEntityTypes.GORE_NEST));
	public static DoomSpawnEgg MECH_ZOMBIE_SPAWN_EGG = item("mechazombie_spawn_egg",
			new DoomSpawnEgg(ModEntityTypes.MECHAZOMBIE));
	public static DoomSpawnEgg HELLKNIGHT2016_SPAWN_EGG = item("hellknight2016_spawn_egg",
			new DoomSpawnEgg(ModEntityTypes.HELLKNIGHT2016));
	public static DoomSpawnEgg GARGOYLE_SPAWN_EGG = item("gargoyle_spawn_egg",
			new DoomSpawnEgg(ModEntityTypes.GARGOYLE));
	public static DoomSpawnEgg SPECTRE_SPAWN_EGG = item("spectre_spawn_egg", new DoomSpawnEgg(ModEntityTypes.SPECTRE));
	public static DoomSpawnEgg CUEBALL_SPAWN_EGG = item("cueball_spawn_egg", new DoomSpawnEgg(ModEntityTypes.CUEBALL));
	public static DoomSpawnEgg PROWLER_SPAWN_EGG = item("prowler_spawn_egg", new DoomSpawnEgg(ModEntityTypes.PROWLER));
	public static DoomSpawnEgg DREADKNIGHT_SPAWN_EGG = item("dreadknight_spawn_egg",
			new DoomSpawnEgg(ModEntityTypes.DREADKNIGHT));
	public static DoomSpawnEgg STONEIMP_SPAWN_EGG = item("stoneimp_spawn_egg",
			new DoomSpawnEgg(ModEntityTypes.IMP_STONE));
	public static DoomSpawnEgg TYRANT_SPAWN_EGG = item("tyrant_spawn_egg", new DoomSpawnEgg(ModEntityTypes.TYRANT));
	public static DoomSpawnEgg POSSESSED_WORKER_SPAWN_EGG = item("possessed_worker_spawn_egg",
			new DoomSpawnEgg(ModEntityTypes.POSSESSEDWORKER));
	public static DoomSpawnEgg DOOMHUNTER_SPAWN_EGG = item("doom_hunter_spawn_egg",
			new DoomSpawnEgg(ModEntityTypes.DOOMHUNTER));
	public static DoomSpawnEgg PINKY2016_SPAWN_EGG = item("pinky2016_spawn_egg",
			new DoomSpawnEgg(ModEntityTypes.PINKY2016));
	public static DoomSpawnEgg WHIPLASH_SPAWN_EGG = item("whiplash_spawn_egg",
			new DoomSpawnEgg(ModEntityTypes.WHIPLASH));
	public static DoomSpawnEgg BARON2016_SPAWN_EGG = item("baron2016_spawn_egg",
			new DoomSpawnEgg(ModEntityTypes.BARON2016));
	public static DoomSpawnEgg FIREBORNE_BARON_SPAWN_EGG = item("firebronebaron_spawn_egg",
			new DoomSpawnEgg(ModEntityTypes.FIREBARON));
	public static DoomSpawnEgg ARMORED_BARON_SPAWN_EGG = item("armoredbaron_spawn_egg",
			new DoomSpawnEgg(ModEntityTypes.ARMORBARON));
	public static DoomSpawnEgg MAYKR_DRONE_SPAWN_EGG = item("maykr_drone_spawn_egg",
			new DoomSpawnEgg(ModEntityTypes.MAYKRDRONE));
	public static DoomSpawnEgg BLOOD_MAYKR_SPAWN_EGG = item("blood_maykr_spawn_egg",
			new DoomSpawnEgg(ModEntityTypes.BLOODMAYKR));
	public static DoomSpawnEgg ARCH_MAKYR_SPAWN_EGG = item("arch_maykr_spawn_egg",
			new DoomSpawnEgg(ModEntityTypes.ARCHMAKER));
	public static DoomSpawnEgg ARACHNOTRONETERNAL_SPAWN_EGG = item("arachnotroneternal_spawn_egg",
			new DoomSpawnEgg(ModEntityTypes.ARACHNOTRONETERNAL));
	public static DoomSpawnEgg SPIDERMASTERMIND2016_SPAWN_EGG = item("spidermastermind2016_spawn_egg",
			new DoomSpawnEgg(ModEntityTypes.SPIDERMASTERMIND2016));
	public static DoomSpawnEgg ARCHVILEETERNAL_SPAWN_EGG = item("archvileeternal_spawn_egg",
			new DoomSpawnEgg(ModEntityTypes.ARCHVILEETERNAL));
	public static DoomSpawnEgg TENTACLE_SPAWN_EGG = item("tentacle_spawn_egg",
			new DoomSpawnEgg(ModEntityTypes.TENTACLE));

	// Armor
	/**
	 * 
	 * Due to changes in 1.17, all armor is now gone from MC Doom.
	 */

	static <T extends Item> T item(T c, String id) {
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, id), c);
		return c;
	}

	static <T extends Item> T item(String id, T c) {
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, id), c);
		return c;
	}
}