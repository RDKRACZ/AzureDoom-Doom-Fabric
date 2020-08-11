package mod.azure.doom.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import mod.azure.doom.util.MobEntityRegister;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.Heightmap;

@Mixin(SpawnRestriction.class)
public class SpawnRestrictionMixin {
	
	@Shadow
	static <T extends MobEntity> void register(EntityType<T> type, SpawnRestriction.Location location,
			Heightmap.Type heightmapType, SpawnRestriction.SpawnPredicate<T> predicate) {
		throw new UnsupportedOperationException();
	}
	
	static {
		register(MobEntityRegister.IMP, SpawnRestriction.Location.ON_GROUND,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canMobSpawn);

		register(MobEntityRegister.ARCHVILE, SpawnRestriction.Location.ON_GROUND,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canMobSpawn);

		register(MobEntityRegister.ZOMBIEMAN, SpawnRestriction.Location.ON_GROUND,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canMobSpawn);

//		register(MobEntityRegister.SPIDERDEMON, SpawnRestriction.Location.ON_GROUND,
//				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canMobSpawn);

		register(MobEntityRegister.MANCUBUS, SpawnRestriction.Location.ON_GROUND,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canMobSpawn);

		register(MobEntityRegister.BARON, SpawnRestriction.Location.ON_GROUND,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canMobSpawn);

		register(MobEntityRegister.REVENANT, SpawnRestriction.Location.ON_GROUND,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canMobSpawn);

//		register(MobEntityRegister.PINKY, SpawnRestriction.Location.ON_GROUND,
//				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canMobSpawn);

		register(MobEntityRegister.CACODEMON, SpawnRestriction.Location.IN_LAVA,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canMobSpawn);

		register(MobEntityRegister.LOST_SOUL, SpawnRestriction.Location.IN_LAVA,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canMobSpawn);

		register(MobEntityRegister.IMP2016, SpawnRestriction.Location.ON_GROUND,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canMobSpawn);

		register(MobEntityRegister.CHAINGUNNER, SpawnRestriction.Location.ON_GROUND,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canMobSpawn);

		register(MobEntityRegister.MARAUDER, SpawnRestriction.Location.ON_GROUND,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canMobSpawn);

		register(MobEntityRegister.SHOTGUNGUY, SpawnRestriction.Location.ON_GROUND,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canMobSpawn);

//		register(MobEntityRegister.PAIN, SpawnRestriction.Location.IN_LAVA,
//				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canMobSpawn);

		register(MobEntityRegister.HELLKNIGHT, SpawnRestriction.Location.ON_GROUND,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canMobSpawn);

		register(MobEntityRegister.CYBERDEMON, SpawnRestriction.Location.ON_GROUND,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canMobSpawn);

		register(MobEntityRegister.CYBERDEMON2016, SpawnRestriction.Location.ON_GROUND,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canMobSpawn);

		register(MobEntityRegister.UNWILLING, SpawnRestriction.Location.ON_GROUND,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canMobSpawn);

		register(MobEntityRegister.POSSESSEDSCIENTIST, SpawnRestriction.Location.ON_GROUND,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canMobSpawn);

		register(MobEntityRegister.POSSESSEDSOLDIER, SpawnRestriction.Location.ON_GROUND,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canMobSpawn);

		register(MobEntityRegister.ICONOFSIN, SpawnRestriction.Location.ON_GROUND,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canMobSpawn);
	}
}