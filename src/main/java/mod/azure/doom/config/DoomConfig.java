package mod.azure.doom.config;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;
import mod.azure.doom.DoomMod;

@Config(name = DoomMod.MODID)
public class DoomConfig implements ConfigData {

	@ConfigEntry.Gui.CollapsibleObject
	public int crucible_marauder_max_damage = 5;

	@ConfigEntry.Gui.CollapsibleObject
	public Spawning spawn = new Spawning();

	@ConfigEntry.Gui.CollapsibleObject
	public MobStats stats = new MobStats();

	public static class Weapons {
		public int crucible_marauder_max_damage = 5;

	}
	
	public static class Spawning {
		public int imp_spawn_weight = 30;
		public int imp_min_group = 1;
		public int imp_max_group = 4;

		public int pinky_spawn_weight = 20;
		public int pinky_min_group = 2;
		public int pinky_max_group = 4;

		public int lost_soul_spawn_weight = 25;
		public int lost_soul_min_group = 1;
		public int lost_soul_max_group = 3;

		public int cacodemon_spawn_weight = 10;
		public int cacodemon_min_group = 1;
		public int cacodemon_max_group = 2;

		public int archvile_spawn_weight = 4;
		public int archvile_min_group = 1;
		public int archvile_max_group = 2;

		public int baron_spawn_weight = 10;
		public int baron_min_group = 1;
		public int baron_max_group = 1;

		public int mancubus_spawn_weight = 10;
		public int mancubus_min_group = 1;
		public int mancubus_max_group = 1;

		public int revenant_spawn_weight = 10;
		public int revenant_min_group = 1;
		public int revenant_max_group = 4;

		public int spider_mastermind_spawn_weight = 10;
		public int spider_mastermind_min_group = 1;
		public int spider_mastermind_max_group = 1;

		public int zombieman_spawn_weight = 30;
		public int zombieman_min_group = 1;
		public int zombieman_max_group = 4;

		public int arachnotron_spawn_weight = 30;
		public int arachnotron_min_group = 1;
		public int arachnotron_max_group = 4;

		public int imp2016_spawn_weight = 30;
		public int imp2016_min_group = 1;
		public int imp2016_max_group = 4;

		public int gargoyle_spawn_weight = 30;
		public int gargoyle_min_group = 1;
		public int gargoyle_max_group = 4;

		public int nightmare_imp_spawn_weight = 30;
		public int nightmare_min_group = 1;
		public int nightmare_max_group = 4;

		public int chaingunner_spawn_weight = 30;
		public int chaingunner_min_group = 1;
		public int chaingunner_max_group = 4;

		public int shotgunguy_spawn_weight = 30;
		public int shotgunguy_min_group = 1;
		public int shotgunguy_max_group = 4;

		public int marauder_spawn_weight = 15;
		public int marauder_min_group = 1;
		public int marauder_max_group = 1;

		public int pain_spawn_weight = 10;
		public int pain_min_group = 1;
		public int pain_max_group = 2;

		public int hellknight_spawn_weight = 10;
		public int hellknight_min_group = 1;
		public int hellknight_max_group = 2;

		public int hellknight2016_spawn_weight = 10;
		public int hellknight2016_min_group = 1;
		public int hellknight2016_max_group = 2;

		public int cyberdemon_spawn_weight = 10;
		public int cyberdemon_min_group = 1;
		public int cyberdemon_max_group = 2;

		public int unwilling_spawn_weight = 30;
		public int unwilling_min_group = 1;
		public int unwilling_max_group = 4;

		public int possessed_scientist_spawn_weight = 30;
		public int possessed_scientist_min_group = 1;
		public int possessed_scientist_max_group = 4;

		public int possessed_soldier_spawn_weight = 30;
		public int possessed_soldier_min_group = 1;
		public int possessed_soldier_max_group = 4;

		public int mechazombie_spawn_weight = 30;
		public int mechazombie_min_group = 1;
		public int mechazombie_max_group = 4;

		public int gorenest_spawn_weight = 10;
		public int gorenest_min_group = 1;
		public int gorenest_max_group = 1;

		public int cyberdemon2016_spawn_weight = 10;
		public int cyberdemon2016_min_group = 1;
		public int cyberdemon2016_max_group = 1;
	}

	public static class MobStats {
		public double imp_health = 30;
		public float imp_ranged_damage = 8;
		public double imp_melee_damage = 4;

		public double pinky_health = 75;
		public double pinky_melee_damage = 6;

		public double lost_soul_health = 10;
		public double lost_soul_melee_damage = 1;

		public double cacodemon_health = 80;

		public double archvile_health = 100;
		public double archvile_melee_damage = 7;

		public double baron_health = 180;
		public float baron_ranged_damage = 12;
		public double baron_melee_damage = 15;

		public double mancubus_health = 80;
		public double mancubus_melee_damage = 8;

		public double revenant_health = 45;
		public float revenant_ranged_damage = 10;
		public double revenant_melee_damage = 6;

		public double spider_mastermind_health = 300;
		public float spider_mastermind_ranged_damage = 15;
		public double spider_mastermind_melee_damage = 8;

		public double zombieman_health = 15;
		public double zombieman_melee_damage = 4;

		public double arachnotron_health = 30;
		public float arachnotron_ranged_damage = 1;
		public double arachnotron_melee_damage = 4;

		public double imp2016_health = 30;
		public float imp2016_ranged_damage = 8;
		public double imp2016_melee_damage = 4;

		public double gargoyle_health = 30;
		public float gargoyle_ranged_damage = 10;
		public double gargoyle_melee_damage = 4;

		public double nightmare_imp_health = 30;
		public float nightmare_ranged_damage = 8;
		public double nightmare_melee_damage = 4;

		public double chaingunner_health = 15;
		public double chaingunner_melee_damage = 4;

		public double shotgunguy_health = 15;
		public double shotgunguy_melee_damage = 4;

		public double marauder_health = 300;
		public double marauder_melee_damage = 12;

		public double pain_health = 80;

		public double hellknight_health = 90;
		public float hellknight_ranged_damage = 12;
		public double hellknight_melee_damage = 8;

		public double hellknight2016_health = 90;
		public double hellknight2016_melee_damage = 8;

		public double cyberdemon_health = 300;
		public float cyberdemon_ranged_damage = 18;
		public double cyberdemon_melee_damage = 15;

		public double unwilling_health = 15;
		public double unwilling_melee_damage = 4;

		public double possessed_scientist_health = 15;
		public double possessed_scientist_melee_damage = 4;

		public double possessed_soldier_health = 15;
		public double possessed_soldier_melee_damage = 4;

		public double mechazombie_health = 25;
		public float mechazombie_ranged_damage = 3;
		public double mechazombie_melee_damage = 5;

		public double gorenest_health = 5;

		public double cyberdemon2016_health = 300;
		public float cyberdemon2016_ranged_damage = 18;
		public double cyberdemon2016_melee_damage = 15;
	}
}