package mod.azure.doom.util;

import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.SpawnSettings;

public interface ExtendedSpawnSettings {
	void addToSpawner(SpawnGroup spawnGroup, SpawnSettings.SpawnEntry spawnEntry);
}