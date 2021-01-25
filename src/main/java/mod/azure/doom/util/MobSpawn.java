package mod.azure.doom.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.google.common.collect.ImmutableMap;

import mod.azure.doom.DoomMod;
import mod.azure.doom.config.DoomConfig.Spawning;
import mod.azure.doom.util.registry.MobEntityRegister;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.SpawnSettings;

public class MobSpawn {

	private static Spawning config = DoomMod.config.spawn;

	/* Major fucking thanks to Corgi Taco for figuring this shit out */
	public static void addSpawnEntries() {
		for (Biome biome : BuiltinRegistries.BIOME) {
			if (biome.getCategory().equals(Biome.Category.NETHER)) {
				addMobSpawnToBiome(biome, SpawnGroup.MONSTER,
						new SpawnSettings.SpawnEntry(MobEntityRegister.IMP, config.imp_spawn_weight,
								config.imp_min_group, config.imp_max_group),
						new SpawnSettings.SpawnEntry(MobEntityRegister.PINKY, config.pinky_spawn_weight,
								config.pinky_min_group, config.pinky_max_group),
						new SpawnSettings.SpawnEntry(MobEntityRegister.SPECTRE, config.spectre_spawn_weight,
								config.spectre_min_group, config.spectre_max_group),
						new SpawnSettings.SpawnEntry(MobEntityRegister.LOST_SOUL, config.lost_soul_spawn_weight,
								config.lost_soul_min_group, config.lost_soul_max_group),
						new SpawnSettings.SpawnEntry(MobEntityRegister.CACODEMON, config.cacodemon_spawn_weight,
								config.cacodemon_min_group, config.cacodemon_max_group),
						new SpawnSettings.SpawnEntry(MobEntityRegister.ARCHVILE, config.archvile_spawn_weight,
								config.archvile_min_group, config.archvile_max_group),
						new SpawnSettings.SpawnEntry(MobEntityRegister.BARON, config.baron_spawn_weight,
								config.baron_min_group, config.baron_max_group),
						new SpawnSettings.SpawnEntry(MobEntityRegister.MANCUBUS, config.mancubus_spawn_weight,
								config.mancubus_min_group, config.mancubus_max_group),
						new SpawnSettings.SpawnEntry(MobEntityRegister.REVENANT, config.revenant_spawn_weight,
								config.revenant_min_group, config.revenant_max_group),
						new SpawnSettings.SpawnEntry(MobEntityRegister.SPIDERDEMON,
								config.spider_mastermind_spawn_weight, config.spider_mastermind_min_group,
								config.spider_mastermind_max_group),
						new SpawnSettings.SpawnEntry(MobEntityRegister.ZOMBIEMAN, config.zombieman_spawn_weight,
								config.zombieman_min_group, config.zombieman_max_group),
						new SpawnSettings.SpawnEntry(MobEntityRegister.ARACHNOTRON, config.arachnotron_spawn_weight,
								config.arachnotron_min_group, config.arachnotron_max_group),
						new SpawnSettings.SpawnEntry(MobEntityRegister.IMP2016, config.imp2016_spawn_weight,
								config.imp2016_min_group, config.imp2016_min_group),
						new SpawnSettings.SpawnEntry(MobEntityRegister.GARGOYLE, config.gargoyle_spawn_weight,
								config.gargoyle_min_group, config.gargoyle_max_group),
						new SpawnSettings.SpawnEntry(MobEntityRegister.NIGHTMARE_IMP, config.nightmare_imp_spawn_weight,
								config.nightmare_min_group, config.nightmare_max_group),
						new SpawnSettings.SpawnEntry(MobEntityRegister.CHAINGUNNER, config.chaingunner_spawn_weight,
								config.chaingunner_min_group, config.chaingunner_max_group),
						new SpawnSettings.SpawnEntry(MobEntityRegister.SHOTGUNGUY, config.shotgunguy_spawn_weight,
								config.shotgunguy_min_group, config.shotgunguy_max_group),
						new SpawnSettings.SpawnEntry(MobEntityRegister.MARAUDER, config.marauder_spawn_weight,
								config.marauder_min_group, config.marauder_max_group),
						new SpawnSettings.SpawnEntry(MobEntityRegister.PAIN, config.pain_spawn_weight,
								config.pain_min_group, config.pain_max_group),
						new SpawnSettings.SpawnEntry(MobEntityRegister.HELLKNIGHT, config.hellknight_spawn_weight,
								config.hellknight_min_group, config.hellknight_max_group),
						new SpawnSettings.SpawnEntry(MobEntityRegister.HELLKNIGHT2016,
								config.hellknight2016_spawn_weight, config.hellknight2016_min_group,
								config.hellknight2016_max_group),
						new SpawnSettings.SpawnEntry(MobEntityRegister.CYBERDEMON, config.cyberdemon_spawn_weight,
								config.cyberdemon_min_group, config.cyberdemon_max_group),
						new SpawnSettings.SpawnEntry(MobEntityRegister.UNWILLING, config.unwilling_spawn_weight,
								config.unwilling_min_group, config.unwilling_max_group),
						new SpawnSettings.SpawnEntry(MobEntityRegister.POSSESSEDSCIENTIST,
								config.possessed_scientist_spawn_weight, config.possessed_scientist_min_group,
								config.possessed_scientist_max_group),
						new SpawnSettings.SpawnEntry(MobEntityRegister.POSSESSEDSOLDIER,
								config.possessed_soldier_spawn_weight, config.possessed_soldier_min_group,
								config.possessed_soldier_max_group),
						new SpawnSettings.SpawnEntry(MobEntityRegister.MECHAZOMBIE, config.mechazombie_spawn_weight,
								config.mechazombie_min_group, config.mechazombie_max_group),
						new SpawnSettings.SpawnEntry(MobEntityRegister.GORE_NEST, config.gorenest_spawn_weight,
								config.gorenest_min_group, config.gorenest_max_group),
						new SpawnSettings.SpawnEntry(MobEntityRegister.CYBERDEMON2016,
								config.cyberdemon2016_spawn_weight, config.cyberdemon2016_min_group,
								config.cyberdemon2016_max_group));
			}
		}
	}

	public static void addMobSpawnToBiome(Biome biome, SpawnGroup classification,
			SpawnSettings.SpawnEntry... spawnInfos) {
		convertImmutableSpawners(biome);
		List<SpawnSettings.SpawnEntry> spawnersList = new ArrayList<>(
				biome.getSpawnSettings().spawners.get(classification));
		spawnersList.addAll(Arrays.asList(spawnInfos));
		biome.getSpawnSettings().spawners.put(classification, spawnersList);
	}

	private static void convertImmutableSpawners(Biome biome) {
		if (biome.getSpawnSettings().spawners instanceof ImmutableMap) {
			biome.getSpawnSettings().spawners = new HashMap<>(biome.getSpawnSettings().spawners);
		}
	}

}