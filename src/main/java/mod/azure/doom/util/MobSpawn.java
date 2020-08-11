package mod.azure.doom.util;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public class MobSpawn {

	private static void netherspawn(Biome biome) {
		if (biome.getCategory() == Biome.Category.NETHER) {
			biome.getEntitySpawnList(MobEntityRegister.ARCHVILE.getSpawnGroup())
					.add(new Biome.SpawnEntry(MobEntityRegister.ARCHVILE, 3, 1, 3));

			biome.getEntitySpawnList(MobEntityRegister.BARON.getSpawnGroup())
					.add(new Biome.SpawnEntry(MobEntityRegister.BARON, 3, 1, 3));
			biome.getEntitySpawnList(MobEntityRegister.CACODEMON.getSpawnGroup())
					.add(new Biome.SpawnEntry(MobEntityRegister.CACODEMON, 3, 1, 3));
			biome.getEntitySpawnList(MobEntityRegister.CHAINGUNNER.getSpawnGroup())
					.add(new Biome.SpawnEntry(MobEntityRegister.CHAINGUNNER, 3, 1, 3));
			biome.getEntitySpawnList(MobEntityRegister.CYBERDEMON.getSpawnGroup())
					.add(new Biome.SpawnEntry(MobEntityRegister.CYBERDEMON, 3, 1, 3));
			biome.getEntitySpawnList(MobEntityRegister.CYBERDEMON2016.getSpawnGroup())
					.add(new Biome.SpawnEntry(MobEntityRegister.CYBERDEMON2016, 3, 1, 3));
			biome.getEntitySpawnList(MobEntityRegister.HELLKNIGHT.getSpawnGroup())
					.add(new Biome.SpawnEntry(MobEntityRegister.HELLKNIGHT, 3, 1, 3));
			biome.getEntitySpawnList(MobEntityRegister.ICONOFSIN.getSpawnGroup())
					.add(new Biome.SpawnEntry(MobEntityRegister.ICONOFSIN, 1, 1, 1));
			biome.getEntitySpawnList(MobEntityRegister.IMP.getSpawnGroup())
					.add(new Biome.SpawnEntry(MobEntityRegister.IMP, 3, 1, 3));
			biome.getEntitySpawnList(MobEntityRegister.IMP2016.getSpawnGroup())
					.add(new Biome.SpawnEntry(MobEntityRegister.IMP2016, 3, 1, 3));
			biome.getEntitySpawnList(MobEntityRegister.LOST_SOUL.getSpawnGroup())
					.add(new Biome.SpawnEntry(MobEntityRegister.LOST_SOUL, 3, 1, 3));
			biome.getEntitySpawnList(MobEntityRegister.MANCUBUS.getSpawnGroup())
					.add(new Biome.SpawnEntry(MobEntityRegister.MANCUBUS, 3, 1, 3));
			biome.getEntitySpawnList(MobEntityRegister.MARAUDER.getSpawnGroup())
					.add(new Biome.SpawnEntry(MobEntityRegister.MARAUDER, 3, 1, 3));
//			biome.getEntitySpawnList(MobEntityRegister.PAIN.getSpawnGroup())
//					.add(new Biome.SpawnEntry(MobEntityRegister.PAIN, 3, 1, 3));
//			biome.getEntitySpawnList(MobEntityRegister.PINKY.getSpawnGroup())
//					.add(new Biome.SpawnEntry(MobEntityRegister.PINKY, 3, 1, 3));
			biome.getEntitySpawnList(MobEntityRegister.POSSESSEDSCIENTIST.getSpawnGroup())
					.add(new Biome.SpawnEntry(MobEntityRegister.POSSESSEDSCIENTIST, 3, 1, 3));
			biome.getEntitySpawnList(MobEntityRegister.POSSESSEDSOLDIER.getSpawnGroup())
					.add(new Biome.SpawnEntry(MobEntityRegister.POSSESSEDSOLDIER, 3, 1, 3));
			biome.getEntitySpawnList(MobEntityRegister.REVENANT.getSpawnGroup())
					.add(new Biome.SpawnEntry(MobEntityRegister.REVENANT, 3, 1, 3));
			biome.getEntitySpawnList(MobEntityRegister.SHOTGUNGUY.getSpawnGroup())
					.add(new Biome.SpawnEntry(MobEntityRegister.SHOTGUNGUY, 3, 1, 3));
//			biome.getEntitySpawnList(MobEntityRegister.SPIDERDEMON.getSpawnGroup())
//					.add(new Biome.SpawnEntry(MobEntityRegister.SPIDERDEMON, 3, 1, 3));
			biome.getEntitySpawnList(MobEntityRegister.UNWILLING.getSpawnGroup())
					.add(new Biome.SpawnEntry(MobEntityRegister.UNWILLING, 3, 1, 3));
			biome.getEntitySpawnList(MobEntityRegister.ZOMBIEMAN.getSpawnGroup())
					.add(new Biome.SpawnEntry(MobEntityRegister.ZOMBIEMAN, 3, 1, 3));
		}
	}

	public static void init() {
		Registry.BIOME.forEach(MobSpawn::netherspawn);
	}
}