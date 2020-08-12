package mod.azure.doom.util;

import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.SpawnSettings.SpawnEntry;

public class MobSpawn {

	private static void netherspawn(Biome biome) {
		for (Biome biome1 : BuiltinRegistries.BIOME) {
			if (biome1.getCategory() == Biome.Category.NETHER) {
				biome1.getSpawnSettings().getSpawnEntry(MobEntityRegister.ARCHVILE.getSpawnGroup())
						.add(new SpawnEntry(MobEntityRegister.ARCHVILE, 3, 1, 3));
				biome1.getSpawnSettings().getSpawnEntry(MobEntityRegister.BARON.getSpawnGroup())
						.add(new SpawnEntry(MobEntityRegister.BARON, 3, 1, 3));
				biome1.getSpawnSettings().getSpawnEntry(MobEntityRegister.CACODEMON.getSpawnGroup())
						.add(new SpawnEntry(MobEntityRegister.CACODEMON, 3, 1, 3));
				biome1.getSpawnSettings().getSpawnEntry(MobEntityRegister.CHAINGUNNER.getSpawnGroup())
						.add(new SpawnEntry(MobEntityRegister.CHAINGUNNER, 3, 1, 3));
				biome1.getSpawnSettings().getSpawnEntry(MobEntityRegister.CYBERDEMON.getSpawnGroup())
						.add(new SpawnEntry(MobEntityRegister.CYBERDEMON, 3, 1, 3));
				biome1.getSpawnSettings().getSpawnEntry(MobEntityRegister.CYBERDEMON2016.getSpawnGroup())
						.add(new SpawnEntry(MobEntityRegister.CYBERDEMON2016, 3, 1, 3));
				biome1.getSpawnSettings().getSpawnEntry(MobEntityRegister.HELLKNIGHT.getSpawnGroup())
						.add(new SpawnEntry(MobEntityRegister.HELLKNIGHT, 3, 1, 3));
				biome1.getSpawnSettings().getSpawnEntry(MobEntityRegister.ICONOFSIN.getSpawnGroup())
						.add(new SpawnEntry(MobEntityRegister.ICONOFSIN, 1, 1, 1));
				biome1.getSpawnSettings().getSpawnEntry(MobEntityRegister.IMP.getSpawnGroup())
						.add(new SpawnEntry(MobEntityRegister.IMP, 3, 1, 3));
				biome1.getSpawnSettings().getSpawnEntry(MobEntityRegister.IMP2016.getSpawnGroup())
						.add(new SpawnEntry(MobEntityRegister.IMP2016, 3, 1, 3));
				biome1.getSpawnSettings().getSpawnEntry(MobEntityRegister.LOST_SOUL.getSpawnGroup())
						.add(new SpawnEntry(MobEntityRegister.LOST_SOUL, 3, 1, 3));
				biome1.getSpawnSettings().getSpawnEntry(MobEntityRegister.MANCUBUS.getSpawnGroup())
						.add(new SpawnEntry(MobEntityRegister.MANCUBUS, 3, 1, 3));
				biome1.getSpawnSettings().getSpawnEntry(MobEntityRegister.MARAUDER.getSpawnGroup())
						.add(new SpawnEntry(MobEntityRegister.MARAUDER, 3, 1, 3));
//			biome.getSpawnSettings().getSpawnEntry(MobEntityRegister.PAIN.getSpawnGroup())
//					.add(new SpawnEntry(MobEntityRegister.PAIN, 3, 1, 3));
//			biome.getSpawnSettings().getSpawnEntry(MobEntityRegister.PINKY.getSpawnGroup())
//					.add(new SpawnEntry(MobEntityRegister.PINKY, 3, 1, 3));
				biome1.getSpawnSettings().getSpawnEntry(MobEntityRegister.POSSESSEDSCIENTIST.getSpawnGroup())
						.add(new SpawnEntry(MobEntityRegister.POSSESSEDSCIENTIST, 3, 1, 3));
				biome1.getSpawnSettings().getSpawnEntry(MobEntityRegister.POSSESSEDSOLDIER.getSpawnGroup())
						.add(new SpawnEntry(MobEntityRegister.POSSESSEDSOLDIER, 3, 1, 3));
				biome1.getSpawnSettings().getSpawnEntry(MobEntityRegister.REVENANT.getSpawnGroup())
						.add(new SpawnEntry(MobEntityRegister.REVENANT, 3, 1, 3));
				biome1.getSpawnSettings().getSpawnEntry(MobEntityRegister.SHOTGUNGUY.getSpawnGroup())
						.add(new SpawnEntry(MobEntityRegister.SHOTGUNGUY, 3, 1, 3));
//			biome.getSpawnSettings().getSpawnEntry(MobEntityRegister.SPIDERDEMON.getSpawnGroup())
//					.add(new SpawnEntry(MobEntityRegister.SPIDERDEMON, 3, 1, 3));
				biome1.getSpawnSettings().getSpawnEntry(MobEntityRegister.UNWILLING.getSpawnGroup())
						.add(new SpawnEntry(MobEntityRegister.UNWILLING, 3, 1, 3));
				biome1.getSpawnSettings().getSpawnEntry(MobEntityRegister.ZOMBIEMAN.getSpawnGroup())
						.add(new SpawnEntry(MobEntityRegister.ZOMBIEMAN, 3, 1, 3));
			}
		}
	}

	public static void init() {
//		BuiltinRegistries.BIOME.forEach(MobSpawn::netherspawn);
	}

}