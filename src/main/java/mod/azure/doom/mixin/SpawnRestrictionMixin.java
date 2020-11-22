package mod.azure.doom.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import mod.azure.doom.util.registry.MobEntityRegister;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.Heightmap;

@Mixin(SpawnRestriction.class)
public class SpawnRestrictionMixin {

	@Shadow
	private static <T extends MobEntity> void register(EntityType<T> type, SpawnRestriction.Location location,
			Heightmap.Type heightmapType, SpawnRestriction.SpawnPredicate<T> predicate) {
	}

	static {
		register(MobEntityRegister.ARCHVILE, SpawnRestriction.Location.ON_GROUND,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
		register(MobEntityRegister.ZOMBIEMAN, SpawnRestriction.Location.ON_GROUND,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
		register(MobEntityRegister.SPIDERDEMON, SpawnRestriction.Location.ON_GROUND,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
		register(MobEntityRegister.ARACHNOTRON, SpawnRestriction.Location.ON_GROUND,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
		register(MobEntityRegister.MANCUBUS, SpawnRestriction.Location.ON_GROUND,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
		register(MobEntityRegister.BARON, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				HostileEntity::canSpawnInDark);
		register(MobEntityRegister.REVENANT, SpawnRestriction.Location.ON_GROUND,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
		register(MobEntityRegister.IMP, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				HostileEntity::canSpawnInDark);
		register(MobEntityRegister.PINKY, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				HostileEntity::canSpawnInDark);
		register(MobEntityRegister.CACODEMON, SpawnRestriction.Location.IN_LAVA,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
		register(MobEntityRegister.LOST_SOUL, SpawnRestriction.Location.IN_LAVA,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
		register(MobEntityRegister.IMP2016, SpawnRestriction.Location.ON_GROUND,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
		register(MobEntityRegister.NIGHTMARE_IMP, SpawnRestriction.Location.ON_GROUND,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
		register(MobEntityRegister.CHAINGUNNER, SpawnRestriction.Location.ON_GROUND,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
		register(MobEntityRegister.MARAUDER, SpawnRestriction.Location.ON_GROUND,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
		register(MobEntityRegister.SHOTGUNGUY, SpawnRestriction.Location.ON_GROUND,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
		register(MobEntityRegister.PAIN, SpawnRestriction.Location.IN_LAVA, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				HostileEntity::canSpawnInDark);
		register(MobEntityRegister.HELLKNIGHT, SpawnRestriction.Location.ON_GROUND,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
		register(MobEntityRegister.HELLKNIGHT2016, SpawnRestriction.Location.ON_GROUND,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
		register(MobEntityRegister.CYBERDEMON, SpawnRestriction.Location.ON_GROUND,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
		register(MobEntityRegister.CYBERDEMON2016, SpawnRestriction.Location.ON_GROUND,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
		register(MobEntityRegister.UNWILLING, SpawnRestriction.Location.ON_GROUND,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
		register(MobEntityRegister.POSSESSEDSCIENTIST, SpawnRestriction.Location.ON_GROUND,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
		register(MobEntityRegister.POSSESSEDSOLDIER, SpawnRestriction.Location.ON_GROUND,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
		register(MobEntityRegister.ICONOFSIN, SpawnRestriction.Location.ON_GROUND,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
		register(MobEntityRegister.MECHAZOMBIE, SpawnRestriction.Location.ON_GROUND,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
		register(MobEntityRegister.GORE_NEST, SpawnRestriction.Location.ON_GROUND,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
	}
}