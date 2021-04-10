package mod.azure.doom.util;

import mod.azure.doom.entity.ArachnotronEntity;
import mod.azure.doom.entity.ArchvileEntity;
import mod.azure.doom.entity.BaronEntity;
import mod.azure.doom.entity.CacodemonEntity;
import mod.azure.doom.entity.ChaingunnerEntity;
import mod.azure.doom.entity.CueBallEntity;
import mod.azure.doom.entity.Cyberdemon2016Entity;
import mod.azure.doom.entity.CyberdemonEntity;
import mod.azure.doom.entity.GargoyleEntity;
import mod.azure.doom.entity.GoreNestEntity;
import mod.azure.doom.entity.Hellknight2016Entity;
import mod.azure.doom.entity.HellknightEntity;
import mod.azure.doom.entity.IconofsinEntity;
import mod.azure.doom.entity.Imp2016Entity;
import mod.azure.doom.entity.ImpEntity;
import mod.azure.doom.entity.LostSoulEntity;
import mod.azure.doom.entity.MancubusEntity;
import mod.azure.doom.entity.MarauderEntity;
import mod.azure.doom.entity.MechaZombieEntity;
import mod.azure.doom.entity.NightmareImpEntity;
import mod.azure.doom.entity.PainEntity;
import mod.azure.doom.entity.PinkyEntity;
import mod.azure.doom.entity.PossessedScientistEntity;
import mod.azure.doom.entity.PossessedSoldierEntity;
import mod.azure.doom.entity.ProwlerEntity;
import mod.azure.doom.entity.RevenantEntity;
import mod.azure.doom.entity.ShotgunguyEntity;
import mod.azure.doom.entity.SpectreEntity;
import mod.azure.doom.entity.SpiderdemonEntity;
import mod.azure.doom.entity.UnwillingEntity;
import mod.azure.doom.entity.ZombiemanEntity;
import mod.azure.doom.util.registry.ModEntityTypes;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

public class MobAttributes {

	public static void init() {
		FabricDefaultAttributeRegistry.register(ModEntityTypes.ARCHVILE, ArchvileEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntityTypes.BARON, BaronEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntityTypes.CACODEMON, CacodemonEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntityTypes.CHAINGUNNER, ChaingunnerEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntityTypes.CYBERDEMON2016,
				Cyberdemon2016Entity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntityTypes.CYBERDEMON, CyberdemonEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntityTypes.HELLKNIGHT, HellknightEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntityTypes.HELLKNIGHT2016,
				Hellknight2016Entity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntityTypes.ICONOFSIN, IconofsinEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntityTypes.IMP2016, Imp2016Entity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntityTypes.IMP, ImpEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntityTypes.NIGHTMARE_IMP,
				NightmareImpEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntityTypes.ARACHNOTRON, ArachnotronEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntityTypes.LOST_SOUL, LostSoulEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntityTypes.MANCUBUS, MancubusEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntityTypes.MARAUDER, MarauderEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntityTypes.PAIN, PainEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntityTypes.PINKY, PinkyEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntityTypes.SPECTRE, SpectreEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntityTypes.POSSESSEDSCIENTIST,
				PossessedScientistEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntityTypes.POSSESSEDSOLDIER,
				PossessedSoldierEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntityTypes.MECHAZOMBIE, MechaZombieEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntityTypes.REVENANT, RevenantEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntityTypes.SHOTGUNGUY, ShotgunguyEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntityTypes.SPIDERDEMON, SpiderdemonEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntityTypes.UNWILLING, UnwillingEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntityTypes.ZOMBIEMAN, ZombiemanEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntityTypes.GORE_NEST, GoreNestEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntityTypes.GARGOYLE, GargoyleEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntityTypes.CUEBALL, CueBallEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntityTypes.PROWLER, ProwlerEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntityTypes.DREADKNIGHT,
				Hellknight2016Entity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntityTypes.TYRANT, Cyberdemon2016Entity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(ModEntityTypes.POSSESSEDWORKER, PossessedScientistEntity.createMobAttributes());
//		FabricDefaultAttributeRegistry.register(ModEntityTypes.DOOMHUNTER,
//		 DoomHunterEntity.createAttributes());
//		FabricDefaultAttributeRegistry.register(ModEntityTypes.WHIPLASH,
//				 WhiplashEntity.createAttributes());
//				 FabricDefaultAttributeRegistry.register(ModEntityTypes.PINKY2016,
//				 PinkyEntity.createAttributes());
//				 FabricDefaultAttributeRegistry.register(ModEntityTypes.BARON2016,
//				 BaronEntity.createAttributes());
//				 FabricDefaultAttributeRegistry.register(ModEntityTypes.ARMORBARON,
//				 ArmorBaronEntity.createAttributes());
//				 FabricDefaultAttributeRegistry.register(ModEntityTypes.MAYKRDRONE,
//				 MaykrDroneEntity.createAttributes());
//				 FabricDefaultAttributeRegistry.register(ModEntityTypes.BLOODMAYKR,
//				 BloodMaykrEntity.createAttributes());
//				 FabricDefaultAttributeRegistry.register(ModEntityTypes.KHANMAKER,
//				 KhanMakyrEntity.createAttributes());
//				 FabricDefaultAttributeRegistry.register(ModEntityTypes.FIREBARON,
//				 FireBaronEntity.createAttributes());
	}
}