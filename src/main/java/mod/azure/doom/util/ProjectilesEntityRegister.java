package mod.azure.doom.util;

import java.util.LinkedList;
import java.util.List;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.projectiles.ArgentBoltEntity;
import mod.azure.doom.entity.projectiles.BFGEntity;
import mod.azure.doom.entity.projectiles.BarenBlastEntity;
import mod.azure.doom.entity.projectiles.BulletEntity;
import mod.azure.doom.entity.projectiles.ChaingunBulletEntity;
import mod.azure.doom.entity.projectiles.EnergyCellEntity;
import mod.azure.doom.entity.projectiles.PainShootEntity;
import mod.azure.doom.entity.projectiles.RocketEntity;
import mod.azure.doom.entity.projectiles.ShotgunShellEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ProjectilesEntityRegister {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<EntityType<? extends Entity>> ENTITY_TYPES = new LinkedList();
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<EntityType<? extends Entity>> ENTITY_THAT_USE_ITEM_RENDERS = new LinkedList();

	public static EntityType<ArgentBoltEntity> ARGENT_BOLT = projectile(ArgentBoltEntity::new, "argent_bolt");
	public static EntityType<ShotgunShellEntity> SHOTGUN_SHELL = projectile(ShotgunShellEntity::new, "shotgun_shell");
	public static EntityType<EnergyCellEntity> ENERGY_CELL = projectile(EnergyCellEntity::new, "energy_cell");
	public static EntityType<BFGEntity> BFG_CELL = projectile(BFGEntity::new, "bfg_cell");
	public static EntityType<RocketEntity> ROCKET = projectile(RocketEntity::new, "rocket");
	public static EntityType<PainShootEntity> LOST_SOUL_SHOOT = projectile(PainShootEntity::new, "lost_soul_shot");
	public static EntityType<BarenBlastEntity> BARENBLAST = projectile(BarenBlastEntity::new, "barenblast");
	public static EntityType<BulletEntity> BULLETS = projectile(BulletEntity::new, "bullets");
	public static EntityType<ChaingunBulletEntity> CHAINGUN_BULLET = projectile(ChaingunBulletEntity::new, "chaingunbullets");

	private static <T extends Entity> EntityType<T> projectile(EntityType.EntityFactory<T> factory, String id) {
		return projectile(factory, id, true);

	}

	private static <T extends Entity> EntityType<T> projectile(EntityType.EntityFactory<T> factory, String id,
			boolean itemRender) {

		EntityType<T> type = FabricEntityTypeBuilder.<T>create(SpawnGroup.MISC, factory)
				.dimensions(new EntityDimensions(0.5F, 0.5F, true)).disableSummon().spawnableFarFromPlayer().trackable(90, 4).build();

		Registry.register(Registry.ENTITY_TYPE, new Identifier(DoomMod.MODID, id), type);

		ENTITY_TYPES.add(type);

		if (itemRender) {
			ENTITY_THAT_USE_ITEM_RENDERS.add(type);
		}

		return type;
	}
}