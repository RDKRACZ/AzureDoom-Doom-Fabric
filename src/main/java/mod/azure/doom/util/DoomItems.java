package mod.azure.doom.util;

import mod.azure.doom.DoomMod;
import mod.azure.doom.item.ArgentEnergyItem;
import mod.azure.doom.item.DaisyItem;
import mod.azure.doom.item.E1M1MusicDisc;
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
import mod.azure.doom.item.weapons.BFG;
import mod.azure.doom.item.weapons.Ballista;
import mod.azure.doom.item.weapons.Chaingun;
import mod.azure.doom.item.weapons.Chainsaw;
import mod.azure.doom.item.weapons.PistolItem;
import mod.azure.doom.item.weapons.PlasmaGun;
import mod.azure.doom.item.weapons.RocketLauncher;
import mod.azure.doom.item.weapons.Shotgun;
import mod.azure.doom.item.weapons.SuperShotgun;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DoomItems {

	// AMMO
	public static Item SHOTGUN_SHELLS = item(new ShellAmmo(new Item.Settings().group(DoomMod.DoomItemGroup), 2.0F),
			"shotgun_shells");
	public static Item ARGENT_BOLT = item(new ArgentBolt(new Item.Settings().group(DoomMod.DoomItemGroup), 1.7F),
			"argent_bolt");
	public static Item ENERGY_CELLS = item(new EnergyCell(new Item.Settings().group(DoomMod.DoomItemGroup), 2.2F),
			"energy_cells");
	public static Item CHAINGUN_BULLETS = item(
			new ChaingunAmmo(new Item.Settings().group(DoomMod.DoomItemGroup), 10.0F), "chaingunbullets");
	public static Item BULLETS = item(new ClipAmmo(new Item.Settings().group(DoomMod.DoomItemGroup), 1.2F), "bullets");
	public static Item BFG_CELL = item(new BFGCell(new Item.Settings().group(DoomMod.DoomItemGroup), 10.2F),
			"bfg_cell");
	public static Item ROCKET = item(new Rocket(new Item.Settings().group(DoomMod.DoomItemGroup), 2.2F), "rocket");
	// MISC
	public static ArgentEnergyItem ARGENT_ENERGY = item(new ArgentEnergyItem(), "argent_energy");
	public static DaisyItem DAISY = item(new DaisyItem(), "daisy");
	public static E1M1MusicDisc E1M1_MUSIC_DISC = item(new E1M1MusicDisc(), "e1m1_music_disc");
	public static InmortalSphereItem INMORTAL = item(new InmortalSphereItem(), "inmortalsphere");
	public static InvisibleSphereItem INVISIBLE = item(new InvisibleSphereItem(), "invisiblesphere");
	public static MegaSphereItem MEGA = item(new MegaSphereItem(), "megasphere");
	public static PowerSphereItem POWER = item(new PowerSphereItem(), "powersphere");
	public static SoulCubeItem SOULCUBE = item(new SoulCubeItem(), "soulcube");
	// WEAPONS AND TOOLS
	public static ArgentAxe ARGENT_AXE = item(new ArgentAxe(), "argent_axe");
	public static ArgentHoe ARGENT_HOE = item(new ArgentHoe(), "argent_hoe");
	public static ArgentPaxel ARGENT_PAXEL = item(new ArgentPaxel(), "argent_paxel");
	public static ArgentPickaxe ARGENT_PICKAXE = item(new ArgentPickaxe(), "argent_pickaxe");
	public static ArgentShovel ARGENT_SHOVEL = item(new ArgentShovel(), "argent_shovel");
	public static ArgentSword ARGENT_SWORD = item(new ArgentSword(), "argent_sword");
	public static Chainsaw CHAINSAW = item(new Chainsaw(), "chainsaw");
	public static SuperShotgun SSG = item(new SuperShotgun(), "supershotgun");
	public static Shotgun SG = item(new Shotgun(), "shotgun");
	public static BFG BFG = item(new BFG(), "bfg9000");
	public static PlasmaGun PLASMAGUN = item(new PlasmaGun(), "plasmagun");
	public static RocketLauncher ROCKETLAUNCHER = item(new RocketLauncher(), "rocketlauncher");
	public static Ballista BALLISTA = item(new Ballista(), "ballista");
	public static Chaingun CHAINGUN = item(new Chaingun(), "chaingun");
	public static PistolItem PISTOL = item(new PistolItem(), "pistol");
	// MOB WEAPONS
	public static CyberdemonAttackItem CYBERDEMONATTACK = item(new CyberdemonAttackItem(), "cyberdemonattack");
	public static SpiderdemonAttackItem SPIDERDEMONATTACK = item(new SpiderdemonAttackItem(), "spiderdemonattack");
	public static BarenBlastItem BARENBLAST = item(new BarenBlastItem(2.0F), "barenblast");

	static <T extends Item> T item(T c, String id) {
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, id), c);
		return c;
	}
}