package mod.azure.doom.util;

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
import mod.azure.doom.entity.PainEntity;
import mod.azure.doom.entity.PinkyEntity;
import mod.azure.doom.entity.PossessedScientistEntity;
import mod.azure.doom.entity.PossessedSoldierEntity;
import mod.azure.doom.entity.RevenantEntity;
import mod.azure.doom.entity.ShotgunguyEntity;
import mod.azure.doom.entity.SpiderdemonEntity;
import mod.azure.doom.entity.UnwillingEntity;
import mod.azure.doom.entity.ZombiemanEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

public class MobAttributes {

	public static void init() {
		FabricDefaultAttributeRegistry.register(MobEntityRegister.ARCHVILE, ArchvileEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(MobEntityRegister.BARON, BaronEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(MobEntityRegister.CACODEMON, CacodemonEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(MobEntityRegister.CHAINGUNNER, ChaingunnerEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(MobEntityRegister.CYBERDEMON2016,
				Cyberdemon2016Entity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(MobEntityRegister.CYBERDEMON, CyberdemonEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(MobEntityRegister.HELLKNIGHT, HellknightEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(MobEntityRegister.ICONOFSIN, IconofsinEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(MobEntityRegister.IMP2016, Imp2016Entity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(MobEntityRegister.IMP, ImpEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(MobEntityRegister.LOST_SOUL, LostSoulEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(MobEntityRegister.MANCUBUS, MancubusEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(MobEntityRegister.MARAUDER, MarauderEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(MobEntityRegister.PAIN, PainEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(MobEntityRegister.PINKY, PinkyEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(MobEntityRegister.POSSESSEDSCIENTIST,
				PossessedScientistEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(MobEntityRegister.POSSESSEDSOLDIER,
				PossessedSoldierEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(MobEntityRegister.REVENANT, RevenantEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(MobEntityRegister.SHOTGUNGUY, ShotgunguyEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(MobEntityRegister.SPIDERDEMON, SpiderdemonEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(MobEntityRegister.UNWILLING, UnwillingEntity.createMobAttributes());
		FabricDefaultAttributeRegistry.register(MobEntityRegister.ZOMBIEMAN, ZombiemanEntity.createMobAttributes());
	}
}