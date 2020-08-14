package mod.azure.doom.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.SpawnSettings;

public class BiomeSpawnHelper {

	private static final String[] NETHER = new String[] { "minecraft:crimson_forest", "minecraft:basalt_deletas",
			"minecraft:nether_wastes", "minecraft:soul_sand_valley", "minecraft:warped_forest" };
	public static final String[] DEMON_SPAWN_BIOMES = getBiomesListFromBiomes(NETHER);

	private BiomeSpawnHelper() {
	}

	public static String[] getBiomesListFromBiomes(String[]... biomes) {
		return Stream.of(biomes).flatMap(Stream::of).toArray(String[]::new);
	}

	public static String[] getBiomesListFromBiomeCategories(Biome.Category... types) {
		return Stream.of(types).flatMap(Stream::of).map(Biome.Category::getName).toArray(String[]::new);
	}

	private static void setSpawnBiomes(EntityType<?> entity, String[] spawnBiomes, int weight, int minGroupSize,
			int maxGroupSize, SpawnGroup classification) {
		List<String> blackList = Arrays.stream(spawnBiomes).filter(id -> id.contains("!")).collect(Collectors.toList());
		List<String> spawnList = expandSpawnList(
				Arrays.stream(spawnBiomes).filter(id -> !id.contains("!")).collect(Collectors.toList()));
		blackList.replaceAll(s -> s.replace("!", ""));
		spawnList.removeAll(blackList);
		addEntityToBiomes(entity, spawnList, minGroupSize, maxGroupSize, classification, weight);
	}

	private static List<String> expandSpawnList(List<String> spawnList) {
		List<String> biomes = new ArrayList<>(Collections.emptyList());
		List<String> biomeCategories = new ArrayList<>(Collections.emptyList());
		List<String> biomesFromCategories = new ArrayList<>(Collections.emptyList());
		spawnList.forEach(identifier -> {
			if (isBiomeCategory(identifier)) {
				biomeCategories.add(identifier);
			} else {
				biomes.add(identifier);
			}
		});
		for (String biomeCategory : biomeCategories) {
			BuiltinRegistries.BIOME.forEach(biome -> {
				if (biome.getCategory().toString().toUpperCase().equals(biomeCategory.toUpperCase())) {
					biomesFromCategories.add(BuiltinRegistries.BIOME.getId(biome).toString());
				}
			});
		}
		return Stream.concat(biomes.stream(), biomesFromCategories.stream()).collect(Collectors.toList());
	}

	private static boolean isBiomeCategory(String identifier) {
		return identifier.split(":").length == 1;
	}

	private static void addEntityToBiomes(EntityType<?> entity, List<String> spawnList, int minGroupSize,
			int maxGroupSize, SpawnGroup classification, int weight) {
		for (String identifier : spawnList) {
			String[] splitted = identifier.split(":");
			if (splitted.length == 2) {
				BuiltinRegistries.BIOME.forEach(biome -> {
					if (BuiltinRegistries.BIOME.getId(biome).toString().equals(identifier)) {
						addToBiome(biome, entity, weight, minGroupSize, maxGroupSize, classification);
					}
				});
				RegistryEntryAddedCallback.event(BuiltinRegistries.BIOME).register((i, registryName, biome) -> {
					if (registryName.toString().equals(identifier)) {
						addToBiome(biome, entity, weight, minGroupSize, maxGroupSize, classification);
					}
				});
			}
			if (splitted.length == 1) {
				BuiltinRegistries.BIOME.forEach(biome -> addToBiomeCategory(biome, identifier, entity, weight,
						minGroupSize, maxGroupSize, classification));
				RegistryEntryAddedCallback.event(BuiltinRegistries.BIOME)
						.register((i, registryName, biome) -> addToBiomeCategory(biome, identifier, entity, weight,
								minGroupSize, maxGroupSize, classification));
			}
		}
	}

	private static void addToBiomeCategory(Biome biome, String identifier, EntityType<?> entity, int weight,
			int minGroupSize, int maxGroupSize, SpawnGroup classification) {
		if (biome.getCategory().toString().toUpperCase().equals(identifier.toUpperCase())) {
			addToBiome(biome, entity, weight, minGroupSize, maxGroupSize, classification);
		}
	}

	private static void addToBiome(Biome biome, EntityType<?> entity, int weight, int minGroupSize, int maxGroupSize,
			SpawnGroup spawnGroup) {
		SpawnSettings spawnSettings = biome.getSpawnSettings();

		((ExtendedSpawnSettings) spawnSettings).addToSpawner(spawnGroup,
				new SpawnSettings.SpawnEntry(entity, weight, minGroupSize, maxGroupSize));

	}

	public static <T extends AnimalEntity> void setCreatureSpawnBiomes(EntityType<T> entity, String[] spawnBiomes,
			int weight, int minGroupCountIn, int maxGroupCountIn) {
		setSpawnBiomes(entity, spawnBiomes, weight, minGroupCountIn, maxGroupCountIn, SpawnGroup.CREATURE);
	}

	public static <T extends WaterCreatureEntity> void setWaterCreatureSpawnBiomes(EntityType<T> entity,
			String[] spawnBiomes, int weight, int minGroupCountIn, int maxGroupCountIn) {
		setSpawnBiomes(entity, spawnBiomes, weight, minGroupCountIn, maxGroupCountIn, SpawnGroup.WATER_CREATURE);
	}

	public static <T extends HostileEntity> void setMonsterSpawnBiomes(EntityType<T> entity, String[] spawnBiomes,
			int weight, int minGroupCountIn, int maxGroupCountIn) {
		setSpawnBiomes(entity, spawnBiomes, weight, minGroupCountIn, maxGroupCountIn, SpawnGroup.MONSTER);
	}

	public static <T extends MobEntity> void setMobSpawnBiomes(EntityType<T> entity, String[] spawnBiomes, int weight,
			int minGroupCountIn, int maxGroupCountIn) {
		setSpawnBiomes(entity, spawnBiomes, weight, minGroupCountIn, maxGroupCountIn, SpawnGroup.MISC);
	}

	public static List<String> convertForConfig(String[] ary) {
		return Arrays.stream(ary).collect(Collectors.toList());
	}

}