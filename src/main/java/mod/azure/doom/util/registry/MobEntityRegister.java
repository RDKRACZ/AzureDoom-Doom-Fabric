package mod.azure.doom.util.registry;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.ArachnotronEntity;
import mod.azure.doom.entity.ArchvileEntity;
import mod.azure.doom.entity.BaronEntity;
import mod.azure.doom.entity.CacodemonEntity;
import mod.azure.doom.entity.ChaingunnerEntity;
import mod.azure.doom.entity.Cyberdemon2016Entity;
import mod.azure.doom.entity.CyberdemonEntity;
import mod.azure.doom.entity.HellknightEntity;
import mod.azure.doom.entity.IconofsinEntity;
import mod.azure.doom.entity.Imp2016Entity;
import mod.azure.doom.entity.ImpEntity;
import mod.azure.doom.entity.LostSoulEntity;
import mod.azure.doom.entity.MancubusEntity;
import mod.azure.doom.entity.MarauderEntity;
import mod.azure.doom.entity.NightmareImpEntity;
import mod.azure.doom.entity.PainEntity;
import mod.azure.doom.entity.PinkyEntity;
import mod.azure.doom.entity.PossessedScientistEntity;
import mod.azure.doom.entity.PossessedSoldierEntity;
import mod.azure.doom.entity.RevenantEntity;
import mod.azure.doom.entity.ShotgunguyEntity;
import mod.azure.doom.entity.SpiderdemonEntity;
import mod.azure.doom.entity.UnwillingEntity;
import mod.azure.doom.entity.ZombiemanEntity;
import mod.azure.doom.entity.projectiles.BarrelEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MobEntityRegister {

	public static final EntityType<Entity> BARREL = Registry.register(Registry.ENTITY_TYPE,
			new Identifier(DoomMod.MODID, "barrel"),
			FabricEntityTypeBuilder.create(SpawnGroup.MISC, BarrelEntity::new)
					.dimensions(EntityDimensions.fixed(0.98F, 0.98F)).trackRangeBlocks(90).trackedUpdateRate(4)
					.build());

	public static final EntityType<ImpEntity> IMP = Registry.register(Registry.ENTITY_TYPE,
			new Identifier(DoomMod.MODID, "imp"),
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ImpEntity::new)
					.dimensions(EntityDimensions.fixed(0.6f, 1.95F)).fireImmune().trackRangeBlocks(90)
					.trackedUpdateRate(4).build());

	public static final EntityType<PinkyEntity> PINKY = Registry.register(Registry.ENTITY_TYPE,
			new Identifier(DoomMod.MODID, "pinky"),
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, PinkyEntity::new)
					.dimensions(EntityDimensions.fixed(1.7f, 2.2F)).fireImmune().trackRangeBlocks(90)
					.trackedUpdateRate(4).build());

	public static final EntityType<LostSoulEntity> LOST_SOUL = Registry.register(Registry.ENTITY_TYPE,
			new Identifier(DoomMod.MODID, "lost_soul"),
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, LostSoulEntity::new)
					.dimensions(EntityDimensions.fixed(1.0F, 1.0F)).fireImmune().trackRangeBlocks(90)
					.trackedUpdateRate(4).build());

	public static final EntityType<CacodemonEntity> CACODEMON = Registry.register(Registry.ENTITY_TYPE,
			new Identifier(DoomMod.MODID, "cacodemon"),
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, CacodemonEntity::new)
					.dimensions(EntityDimensions.fixed(2.0F, 2.0F)).fireImmune().trackRangeBlocks(90)
					.trackedUpdateRate(4).build());

	public static final EntityType<ArchvileEntity> ARCHVILE = Registry.register(Registry.ENTITY_TYPE,
			new Identifier(DoomMod.MODID, "archvile"),
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ArchvileEntity::new)
					.dimensions(EntityDimensions.fixed(0.6F, 2.9F)).fireImmune().trackRangeBlocks(90)
					.trackedUpdateRate(4).build());

	public static final EntityType<BaronEntity> BARON = Registry.register(Registry.ENTITY_TYPE,
			new Identifier(DoomMod.MODID, "baron"),
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, BaronEntity::new)
					.dimensions(EntityDimensions.fixed(1.3f, 3.9F)).fireImmune().trackRangeBlocks(90)
					.trackedUpdateRate(4).build());

	public static final EntityType<MancubusEntity> MANCUBUS = Registry.register(Registry.ENTITY_TYPE,
			new Identifier(DoomMod.MODID, "mancubus"),
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MancubusEntity::new)
					.dimensions(EntityDimensions.fixed(1.9F, 5.4F)).fireImmune().trackRangeBlocks(90)
					.trackedUpdateRate(4).build());

	public static final EntityType<SpiderdemonEntity> SPIDERDEMON = Registry.register(Registry.ENTITY_TYPE,
			new Identifier(DoomMod.MODID, "spiderdemon"),
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SpiderdemonEntity::new)
					.dimensions(EntityDimensions.fixed(6.0F, 4.0F)).fireImmune().trackRangeBlocks(90)
					.trackedUpdateRate(4).build());

	public static final EntityType<ArachnotronEntity> ARACHNOTRON = Registry.register(Registry.ENTITY_TYPE,
			new Identifier(DoomMod.MODID, "arachnotron"),
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ArachnotronEntity::new)
					.dimensions(EntityDimensions.fixed(5.0F, 2.0F)).fireImmune().trackRangeBlocks(90)
					.trackedUpdateRate(4).build());

	public static final EntityType<ZombiemanEntity> ZOMBIEMAN = Registry.register(Registry.ENTITY_TYPE,
			new Identifier(DoomMod.MODID, "zombieman"),
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ZombiemanEntity::new)
					.dimensions(EntityDimensions.fixed(0.6f, 1.95F)).fireImmune().trackRangeBlocks(90)
					.trackedUpdateRate(4).build());

	public static final EntityType<RevenantEntity> REVENANT = Registry.register(Registry.ENTITY_TYPE,
			new Identifier(DoomMod.MODID, "revenant"),
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, RevenantEntity::new)
					.dimensions(EntityDimensions.fixed(0.6f, 1.95F)).fireImmune().trackRangeBlocks(90)
					.trackedUpdateRate(4).build());

	public static final EntityType<Imp2016Entity> IMP2016 = Registry.register(Registry.ENTITY_TYPE,
			new Identifier(DoomMod.MODID, "imp2016"),
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, Imp2016Entity::new)
					.dimensions(EntityDimensions.fixed(0.6f, 1.95F)).fireImmune().trackRangeBlocks(90)
					.trackedUpdateRate(4).build());

	public static final EntityType<NightmareImpEntity> NIGHTMARE_IMP = Registry.register(Registry.ENTITY_TYPE,
			new Identifier(DoomMod.MODID, "nightmare_imp"),
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, NightmareImpEntity::new)
					.dimensions(EntityDimensions.fixed(0.6f, 1.95F)).fireImmune().trackRangeBlocks(90)
					.trackedUpdateRate(4).build());

	public static final EntityType<ChaingunnerEntity> CHAINGUNNER = Registry.register(Registry.ENTITY_TYPE,
			new Identifier(DoomMod.MODID, "chaingunner"),
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ChaingunnerEntity::new)
					.dimensions(EntityDimensions.fixed(0.6f, 1.95F)).fireImmune().trackRangeBlocks(90)
					.trackedUpdateRate(4).build());

	public static final EntityType<MarauderEntity> MARAUDER = Registry.register(Registry.ENTITY_TYPE,
			new Identifier(DoomMod.MODID, "marauder"),
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MarauderEntity::new)
					.dimensions(EntityDimensions.fixed(0.6f, 1.95F)).fireImmune().trackRangeBlocks(90)
					.trackedUpdateRate(4).build());

	public static final EntityType<ShotgunguyEntity> SHOTGUNGUY = Registry.register(Registry.ENTITY_TYPE,
			new Identifier(DoomMod.MODID, "shotgunguy"),
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ShotgunguyEntity::new)
					.dimensions(EntityDimensions.fixed(0.6f, 1.95F)).fireImmune().trackRangeBlocks(90)
					.trackedUpdateRate(4).build());

	public static final EntityType<PainEntity> PAIN = Registry.register(Registry.ENTITY_TYPE,
			new Identifier(DoomMod.MODID, "painelemental"),
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, PainEntity::new)
					.dimensions(EntityDimensions.fixed(2.0F, 2.0F)).fireImmune().trackRangeBlocks(90)
					.trackedUpdateRate(4).build());

	public static final EntityType<HellknightEntity> HELLKNIGHT = Registry.register(Registry.ENTITY_TYPE,
			new Identifier(DoomMod.MODID, "hellknight"),
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, HellknightEntity::new)
					.dimensions(EntityDimensions.fixed(1.4F, 3.5F)).fireImmune().trackRangeBlocks(90)
					.trackedUpdateRate(4).build());

	public static final EntityType<CyberdemonEntity> CYBERDEMON = Registry.register(Registry.ENTITY_TYPE,
			new Identifier(DoomMod.MODID, "cyberdemon"),
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, CyberdemonEntity::new)
					.dimensions(EntityDimensions.fixed(1.6f, 4.75F)).fireImmune().trackRangeBlocks(90)
					.trackedUpdateRate(4).build());

	public static final EntityType<Cyberdemon2016Entity> CYBERDEMON2016 = Registry.register(Registry.ENTITY_TYPE,
			new Identifier(DoomMod.MODID, "cyberdemon2016"),
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, Cyberdemon2016Entity::new)
					.dimensions(EntityDimensions.fixed(1.6f, 4.75F)).fireImmune().trackRangeBlocks(90)
					.trackedUpdateRate(4).build());

	public static final EntityType<UnwillingEntity> UNWILLING = Registry.register(Registry.ENTITY_TYPE,
			new Identifier(DoomMod.MODID, "unwilling"),
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, UnwillingEntity::new)
					.dimensions(EntityDimensions.fixed(0.6f, 1.95F)).fireImmune().trackRangeBlocks(90)
					.trackedUpdateRate(4).build());

	public static final EntityType<PossessedSoldierEntity> POSSESSEDSOLDIER = Registry.register(Registry.ENTITY_TYPE,
			new Identifier(DoomMod.MODID, "possessed_soldier"),
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, PossessedSoldierEntity::new)
					.dimensions(EntityDimensions.fixed(0.6f, 1.95F)).fireImmune().trackRangeBlocks(90)
					.trackedUpdateRate(4).build());

	public static final EntityType<PossessedScientistEntity> POSSESSEDSCIENTIST = Registry.register(
			Registry.ENTITY_TYPE, new Identifier(DoomMod.MODID, "possessed_scientist"),
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, PossessedScientistEntity::new)
					.dimensions(EntityDimensions.fixed(0.6f, 1.95F)).fireImmune().trackRangeBlocks(90)
					.trackedUpdateRate(4).build());

	public static final EntityType<IconofsinEntity> ICONOFSIN = Registry.register(Registry.ENTITY_TYPE,
			new Identifier(DoomMod.MODID, "iconofsin"),
			FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, IconofsinEntity::new)
					.dimensions(EntityDimensions.fixed(2.4f, 10.0F)).fireImmune().trackRangeBlocks(90)
					.trackedUpdateRate(4).build());
}