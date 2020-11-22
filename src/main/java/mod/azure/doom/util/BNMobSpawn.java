package mod.azure.doom.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.google.common.collect.ImmutableMap;

import mod.azure.doom.util.registry.MobEntityRegister;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.SpawnSettings;

public class BNMobSpawn {

	/* Major fucking thanks to Corgi Taco for figuring this shit out */
	public static void addSpawnEntries() {
		for (Biome biome : BuiltinRegistries.BIOME) {
			if (biome.getCategory().equals(Biome.Category.NETHER)) {
				addMobSpawnToBiome(biome, SpawnGroup.MONSTER,
						new SpawnSettings.SpawnEntry(MobEntityRegister.IMP, 30, 1, 4),
						new SpawnSettings.SpawnEntry(MobEntityRegister.PINKY, 12, 2, 4),
						new SpawnSettings.SpawnEntry(MobEntityRegister.LOST_SOUL, 8, 1, 3),
						new SpawnSettings.SpawnEntry(MobEntityRegister.CACODEMON, 8, 1, 2),
						new SpawnSettings.SpawnEntry(MobEntityRegister.ARCHVILE, 4, 1, 2),
						new SpawnSettings.SpawnEntry(MobEntityRegister.BARON, 10, 1, 1),
						new SpawnSettings.SpawnEntry(MobEntityRegister.MANCUBUS, 10, 1, 1),
						new SpawnSettings.SpawnEntry(MobEntityRegister.REVENANT, 10, 1, 1),
						new SpawnSettings.SpawnEntry(MobEntityRegister.SPIDERDEMON, 10, 1, 1),
						new SpawnSettings.SpawnEntry(MobEntityRegister.ZOMBIEMAN, 30, 1, 4),
						new SpawnSettings.SpawnEntry(MobEntityRegister.ARACHNOTRON, 30, 1, 4),
						new SpawnSettings.SpawnEntry(MobEntityRegister.IMP2016, 30, 1, 4),
						new SpawnSettings.SpawnEntry(MobEntityRegister.NIGHTMARE_IMP, 30, 1, 4),
						new SpawnSettings.SpawnEntry(MobEntityRegister.CHAINGUNNER, 30, 1, 4),
						new SpawnSettings.SpawnEntry(MobEntityRegister.SHOTGUNGUY, 30, 1, 4),
						new SpawnSettings.SpawnEntry(MobEntityRegister.MARAUDER, 15, 1, 1),
						new SpawnSettings.SpawnEntry(MobEntityRegister.PAIN, 8, 1, 2),
						new SpawnSettings.SpawnEntry(MobEntityRegister.HELLKNIGHT, 10, 1, 1),
						new SpawnSettings.SpawnEntry(MobEntityRegister.CYBERDEMON, 10, 1, 1),
						new SpawnSettings.SpawnEntry(MobEntityRegister.UNWILLING, 30, 1, 4),
						new SpawnSettings.SpawnEntry(MobEntityRegister.POSSESSEDSCIENTIST, 30, 1, 4),
						new SpawnSettings.SpawnEntry(MobEntityRegister.POSSESSEDSOLDIER, 30, 1, 4),
						new SpawnSettings.SpawnEntry(MobEntityRegister.MECHAZOMBIE, 30, 1, 4),
						new SpawnSettings.SpawnEntry(MobEntityRegister.GORE_NEST, 30, 1, 1),
						new SpawnSettings.SpawnEntry(MobEntityRegister.CYBERDEMON2016, 10, 1, 1));
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