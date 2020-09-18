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

public class MobSpawn {

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
						new SpawnSettings.SpawnEntry(MobEntityRegister.CYBERDEMON2016, 10, 1, 1),
						new SpawnSettings.SpawnEntry(MobEntityRegister.ICONOFSIN, 1, 1, 1));
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

	public static void SpawnRestriction() {
//		SpawnRestriction.register(MobEntityRegister.ARCHVILE, SpawnRestriction.Location.ON_GROUND,
//				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
//		SpawnRestriction.register(MobEntityRegister.ZOMBIEMAN, SpawnRestriction.Location.ON_GROUND,
//				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
//		SpawnRestriction.register(MobEntityRegister.SPIDERDEMON, SpawnRestriction.Location.ON_GROUND,
//				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
//		SpawnRestriction.register(MobEntityRegister.ARACHNOTRON, SpawnRestriction.Location.ON_GROUND,
//				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
//		SpawnRestriction.register(MobEntityRegister.MANCUBUS, SpawnRestriction.Location.ON_GROUND,
//				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
//		SpawnRestriction.register(MobEntityRegister.BARON, SpawnRestriction.Location.ON_GROUND,
//				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
//		SpawnRestriction.register(MobEntityRegister.REVENANT, SpawnRestriction.Location.ON_GROUND,
//				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
//		SpawnRestriction.register(MobEntityRegister.IMP, SpawnRestriction.Location.ON_GROUND,
//				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
//		SpawnRestriction.register(MobEntityRegister.PINKY, SpawnRestriction.Location.ON_GROUND,
//				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
//		SpawnRestriction.register(MobEntityRegister.CACODEMON, SpawnRestriction.Location.IN_LAVA,
//				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
//		SpawnRestriction.register(MobEntityRegister.LOST_SOUL, SpawnRestriction.Location.IN_LAVA,
//				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
//		SpawnRestriction.register(MobEntityRegister.IMP2016, SpawnRestriction.Location.ON_GROUND,
//				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
//		SpawnRestriction.register(MobEntityRegister.NIGHTMARE_IMP, SpawnRestriction.Location.ON_GROUND,
//				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
//		SpawnRestriction.register(MobEntityRegister.CHAINGUNNER, SpawnRestriction.Location.ON_GROUND,
//				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
//		SpawnRestriction.register(MobEntityRegister.MARAUDER, SpawnRestriction.Location.ON_GROUND,
//				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
//		SpawnRestriction.register(MobEntityRegister.SHOTGUNGUY, SpawnRestriction.Location.ON_GROUND,
//				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
//		SpawnRestriction.register(MobEntityRegister.PAIN, SpawnRestriction.Location.IN_LAVA,
//				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
//		SpawnRestriction.register(MobEntityRegister.HELLKNIGHT, SpawnRestriction.Location.ON_GROUND,
//				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
//		SpawnRestriction.register(MobEntityRegister.CYBERDEMON, SpawnRestriction.Location.ON_GROUND,
//				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
//		SpawnRestriction.register(MobEntityRegister.CYBERDEMON2016, SpawnRestriction.Location.ON_GROUND,
//				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
//		SpawnRestriction.register(MobEntityRegister.UNWILLING, SpawnRestriction.Location.ON_GROUND,
//				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
//		SpawnRestriction.register(MobEntityRegister.POSSESSEDSCIENTIST, SpawnRestriction.Location.ON_GROUND,
//				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
//		SpawnRestriction.register(MobEntityRegister.POSSESSEDSOLDIER, SpawnRestriction.Location.ON_GROUND,
//				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
//		SpawnRestriction.register(MobEntityRegister.ICONOFSIN, SpawnRestriction.Location.ON_GROUND,
//				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
	}

}