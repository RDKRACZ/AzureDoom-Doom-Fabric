package mod.azure.doom.util;

import java.util.List;

import mod.azure.doom.mixin.SpawnRestrictionAccessor;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.Heightmap;

public class MobSpawn {

	public static void init() {
		manageMonsterEntities();
	}

	private static void manageMonsterEntities() {
		registerMonsterEntitySpawn(MobEntityRegister.ARCHVILE,
				new EntityConfig(BiomeSpawnHelper.DEMON_SPAWN_BIOMES, 10).spawnBiomes.toArray(new String[0]), 10, 1, 1);
		registerMonsterEntitySpawn(MobEntityRegister.BARON,
				new EntityConfig(BiomeSpawnHelper.DEMON_SPAWN_BIOMES, 10).spawnBiomes.toArray(new String[0]), 10, 1, 1);
		registerMonsterEntitySpawn(MobEntityRegister.REVENANT,
				new EntityConfig(BiomeSpawnHelper.DEMON_SPAWN_BIOMES, 10).spawnBiomes.toArray(new String[0]), 10, 1, 1);
		registerMonsterEntitySpawn(MobEntityRegister.MANCUBUS,
				new EntityConfig(BiomeSpawnHelper.DEMON_SPAWN_BIOMES, 10).spawnBiomes.toArray(new String[0]), 10, 1, 1);
		registerMonsterEntitySpawn(MobEntityRegister.MARAUDER,
				new EntityConfig(BiomeSpawnHelper.DEMON_SPAWN_BIOMES, 10).spawnBiomes.toArray(new String[0]), 10, 1, 1);
		registerMonsterEntitySpawn(MobEntityRegister.CYBERDEMON2016,
				new EntityConfig(BiomeSpawnHelper.DEMON_SPAWN_BIOMES, 10).spawnBiomes.toArray(new String[0]), 10, 1, 1);
		registerMonsterEntitySpawn(MobEntityRegister.CYBERDEMON,
				new EntityConfig(BiomeSpawnHelper.DEMON_SPAWN_BIOMES, 10).spawnBiomes.toArray(new String[0]), 10, 1, 1);
		registerMonsterEntitySpawn(MobEntityRegister.ICONOFSIN,
				new EntityConfig(BiomeSpawnHelper.DEMON_SPAWN_BIOMES, 10).spawnBiomes.toArray(new String[0]), 1, 1, 1);
		registerMonsterEntitySpawn(MobEntityRegister.UNWILLING,
				new EntityConfig(BiomeSpawnHelper.DEMON_SPAWN_BIOMES, 10).spawnBiomes.toArray(new String[0]), 30, 1, 4);
		registerMonsterEntitySpawn(MobEntityRegister.POSSESSEDSOLDIER,
				new EntityConfig(BiomeSpawnHelper.DEMON_SPAWN_BIOMES, 10).spawnBiomes.toArray(new String[0]), 30, 1, 4);
		registerMonsterEntitySpawn(MobEntityRegister.POSSESSEDSCIENTIST,
				new EntityConfig(BiomeSpawnHelper.DEMON_SPAWN_BIOMES, 10).spawnBiomes.toArray(new String[0]), 30, 1, 4);
		registerMonsterEntitySpawn(MobEntityRegister.LOST_SOUL,
				new EntityConfig(BiomeSpawnHelper.DEMON_SPAWN_BIOMES, 10).spawnBiomes.toArray(new String[0]), 30, 1, 4);
		registerMonsterEntitySpawn(MobEntityRegister.SHOTGUNGUY,
				new EntityConfig(BiomeSpawnHelper.DEMON_SPAWN_BIOMES, 10).spawnBiomes.toArray(new String[0]), 30, 1, 4);
		registerMonsterEntitySpawn(MobEntityRegister.ZOMBIEMAN,
				new EntityConfig(BiomeSpawnHelper.DEMON_SPAWN_BIOMES, 10).spawnBiomes.toArray(new String[0]), 30, 1, 4);
		registerMonsterEntitySpawn(MobEntityRegister.IMP2016,
				new EntityConfig(BiomeSpawnHelper.DEMON_SPAWN_BIOMES, 10).spawnBiomes.toArray(new String[0]), 30, 1, 4);
		registerMonsterEntitySpawn(MobEntityRegister.IMP,
				new EntityConfig(BiomeSpawnHelper.DEMON_SPAWN_BIOMES, 10).spawnBiomes.toArray(new String[0]), 30, 1, 4);
		registerMonsterEntitySpawn(MobEntityRegister.HELLKNIGHT,
				new EntityConfig(BiomeSpawnHelper.DEMON_SPAWN_BIOMES, 10).spawnBiomes.toArray(new String[0]), 30, 1, 4);
		registerMonsterEntitySpawn(MobEntityRegister.CHAINGUNNER,
				new EntityConfig(BiomeSpawnHelper.DEMON_SPAWN_BIOMES, 10).spawnBiomes.toArray(new String[0]), 30, 1, 4);
		registerMonsterEntitySpawn(MobEntityRegister.CACODEMON,
				new EntityConfig(BiomeSpawnHelper.DEMON_SPAWN_BIOMES, 10).spawnBiomes.toArray(new String[0]), 30, 1, 4);
	}

	private static <T extends HostileEntity> void registerMonsterEntitySpawn(EntityType<T> entity, String[] spawnBiomes,
			int weight, int minGroupCountIn, int maxGroupCountIn) {
		BiomeSpawnHelper.setMonsterSpawnBiomes(entity, spawnBiomes, weight, minGroupCountIn, maxGroupCountIn);
		SpawnRestrictionAccessor.callRegister(entity, SpawnRestriction.Location.ON_GROUND,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
	}

	public static class EntityConfig {
		public int weight;
		public int groupMin;
		public int groupMax;
		public List<String> spawnBiomes;

		EntityConfig(String[] spawnBiomes, int weight, int groupMin, int groupMax) {
			this.spawnBiomes = BiomeSpawnHelper.convertForConfig(spawnBiomes);
			this.weight = weight;
			this.groupMin = groupMin;
			this.groupMax = groupMax;
		}

		EntityConfig(String[] spawnBiomes, int weight) {
			this(spawnBiomes, weight, 2, 4);
		}
	}

}