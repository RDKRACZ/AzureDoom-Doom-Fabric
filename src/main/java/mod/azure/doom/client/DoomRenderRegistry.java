package mod.azure.doom.client;

import mod.azure.doom.client.render.ArachonotronRender;
import mod.azure.doom.client.render.ArchvileRender;
import mod.azure.doom.client.render.BaronRender;
import mod.azure.doom.client.render.BarrelRender;
import mod.azure.doom.client.render.CacodemonRender;
import mod.azure.doom.client.render.ChaingunnerRender;
import mod.azure.doom.client.render.Cyberdemon2016Render;
import mod.azure.doom.client.render.CyberdemonRender;
import mod.azure.doom.client.render.GargoyleRender;
import mod.azure.doom.client.render.GoreNestRender;
import mod.azure.doom.client.render.Hellknight2016Render;
import mod.azure.doom.client.render.HellknightRender;
import mod.azure.doom.client.render.IconofsinRender;
import mod.azure.doom.client.render.Imp2016Render;
import mod.azure.doom.client.render.ImpRender;
import mod.azure.doom.client.render.LostSoulRender;
import mod.azure.doom.client.render.MancubusRender;
import mod.azure.doom.client.render.MarauderRender;
import mod.azure.doom.client.render.MechaZombieRender;
import mod.azure.doom.client.render.NightmareImpRender;
import mod.azure.doom.client.render.PainRender;
import mod.azure.doom.client.render.PinkyRender;
import mod.azure.doom.client.render.PossessedScientistRender;
import mod.azure.doom.client.render.PossessedSoldierRender;
import mod.azure.doom.client.render.RevenantRender;
import mod.azure.doom.client.render.ShotgunguyRender;
import mod.azure.doom.client.render.SpiderdemonRender;
import mod.azure.doom.client.render.UnwillingRender;
import mod.azure.doom.client.render.ZombiemanRender;
import mod.azure.doom.client.render.armors.AstroRender;
import mod.azure.doom.client.render.armors.BronzeRender;
import mod.azure.doom.client.render.armors.ClassicBronzeRender;
import mod.azure.doom.client.render.armors.ClassicIndigoRender;
import mod.azure.doom.client.render.armors.ClassicRedRender;
import mod.azure.doom.client.render.armors.ClassicRender;
import mod.azure.doom.client.render.armors.CrimsonRender;
import mod.azure.doom.client.render.armors.CultistRender;
import mod.azure.doom.client.render.armors.DemoncideRender;
import mod.azure.doom.client.render.armors.DemonicRender;
import mod.azure.doom.client.render.armors.DoomRender;
import mod.azure.doom.client.render.armors.DoomicornRender;
import mod.azure.doom.client.render.armors.EmberRender;
import mod.azure.doom.client.render.armors.GoldRender;
import mod.azure.doom.client.render.armors.HotrodRender;
import mod.azure.doom.client.render.armors.MaykrRender;
import mod.azure.doom.client.render.armors.MidnightRender;
import mod.azure.doom.client.render.armors.Mullet1Render;
import mod.azure.doom.client.render.armors.Mullet2Render;
import mod.azure.doom.client.render.armors.Mullet3Render;
import mod.azure.doom.client.render.armors.NightmareRender;
import mod.azure.doom.client.render.armors.PainterRender;
import mod.azure.doom.client.render.armors.PhobosRender;
import mod.azure.doom.client.render.armors.PraetorRender;
import mod.azure.doom.client.render.armors.PurplePonyRender;
import mod.azure.doom.client.render.armors.SantaRender;
import mod.azure.doom.client.render.armors.SentinelRender;
import mod.azure.doom.client.render.armors.TwentyFiveRender;
import mod.azure.doom.client.render.armors.ZombieRender;
import mod.azure.doom.client.render.projectiles.ArgentBoltRender;
import mod.azure.doom.client.render.projectiles.BFGCellRender;
import mod.azure.doom.client.render.projectiles.BarenBlastRender;
import mod.azure.doom.client.render.projectiles.BulletsRender;
import mod.azure.doom.client.render.projectiles.ChaingunBulletRender;
import mod.azure.doom.client.render.projectiles.EnergyCellRender;
import mod.azure.doom.client.render.projectiles.RocketRender;
import mod.azure.doom.client.render.projectiles.ShotgunShellRender;
import mod.azure.doom.client.render.projectiles.UnmaykrBulletRender;
import mod.azure.doom.client.render.projectiles.entity.ArchvileFiringRender;
import mod.azure.doom.client.render.projectiles.entity.ChaingunMobRender;
import mod.azure.doom.client.render.projectiles.entity.EnergyCellMobRender;
import mod.azure.doom.client.render.projectiles.entity.RocketMobRender;
import mod.azure.doom.item.armor.AstroDoomArmor;
import mod.azure.doom.item.armor.BronzeDoomArmor;
import mod.azure.doom.item.armor.ClassicBronzeDoomArmor;
import mod.azure.doom.item.armor.ClassicDoomArmor;
import mod.azure.doom.item.armor.ClassicIndigoDoomArmor;
import mod.azure.doom.item.armor.ClassicRedDoomArmor;
import mod.azure.doom.item.armor.CrimsonDoomArmor;
import mod.azure.doom.item.armor.CultistDoomArmor;
import mod.azure.doom.item.armor.DemoncideDoomArmor;
import mod.azure.doom.item.armor.DemonicDoomArmor;
import mod.azure.doom.item.armor.DoomArmor;
import mod.azure.doom.item.armor.DoomicornDoomArmor;
import mod.azure.doom.item.armor.EmberDoomArmor;
import mod.azure.doom.item.armor.GoldDoomArmor;
import mod.azure.doom.item.armor.HotrodDoomArmor;
import mod.azure.doom.item.armor.MaykrDoomArmor;
import mod.azure.doom.item.armor.MidnightDoomArmor;
import mod.azure.doom.item.armor.Mullet2DoomArmor;
import mod.azure.doom.item.armor.Mullet3DoomArmor;
import mod.azure.doom.item.armor.MulletDoomArmor;
import mod.azure.doom.item.armor.NightmareDoomArmor;
import mod.azure.doom.item.armor.PainterDoomArmor;
import mod.azure.doom.item.armor.PhobosDoomArmor;
import mod.azure.doom.item.armor.PraetorDoomArmor;
import mod.azure.doom.item.armor.PurplePonyDoomArmor;
import mod.azure.doom.item.armor.SantaDoomArmor;
import mod.azure.doom.item.armor.SentinelDoomArmor;
import mod.azure.doom.item.armor.TwentyFiveDoomArmor;
import mod.azure.doom.item.armor.ZombieDoomArmor;
import mod.azure.doom.util.registry.MobEntityRegister;
import mod.azure.doom.util.registry.ProjectilesEntityRegister;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import software.bernie.geckolib3.renderer.geo.GeoArmorRenderer;

public class DoomRenderRegistry {

	public static void init() {
		EntityRendererRegistry.INSTANCE.register(MobEntityRegister.ARCHVILE, (dispatcher, context) -> {
			return new ArchvileRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(MobEntityRegister.BARREL, (dispatcher, context) -> {
			return new BarrelRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(MobEntityRegister.IMP, (dispatcher, context) -> {
			return new ImpRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(MobEntityRegister.PINKY, (dispatcher, context) -> {
			return new PinkyRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(MobEntityRegister.LOST_SOUL, (dispatcher, context) -> {
			return new LostSoulRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(MobEntityRegister.CACODEMON, (dispatcher, context) -> {
			return new CacodemonRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(MobEntityRegister.BARON, (dispatcher, context) -> {
			return new BaronRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(MobEntityRegister.MANCUBUS, (dispatcher, context) -> {
			return new MancubusRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(MobEntityRegister.SPIDERDEMON, (dispatcher, context) -> {
			return new SpiderdemonRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(MobEntityRegister.ARACHNOTRON, (dispatcher, context) -> {
			return new ArachonotronRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(MobEntityRegister.ZOMBIEMAN, (dispatcher, context) -> {
			return new ZombiemanRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(MobEntityRegister.REVENANT, (dispatcher, context) -> {
			return new RevenantRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(MobEntityRegister.IMP2016, (dispatcher, context) -> {
			return new Imp2016Render(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(MobEntityRegister.GORE_NEST, (dispatcher, context) -> {
			return new GoreNestRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(MobEntityRegister.NIGHTMARE_IMP, (dispatcher, context) -> {
			return new NightmareImpRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(MobEntityRegister.CHAINGUNNER, (dispatcher, context) -> {
			return new ChaingunnerRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(MobEntityRegister.SHOTGUNGUY, (dispatcher, context) -> {
			return new ShotgunguyRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(MobEntityRegister.MARAUDER, (dispatcher, context) -> {
			return new MarauderRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(MobEntityRegister.PAIN, (dispatcher, context) -> {
			return new PainRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(MobEntityRegister.HELLKNIGHT, (dispatcher, context) -> {
			return new HellknightRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(MobEntityRegister.HELLKNIGHT2016, (dispatcher, context) -> {
			return new Hellknight2016Render(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(MobEntityRegister.CYBERDEMON, (dispatcher, context) -> {
			return new CyberdemonRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(MobEntityRegister.UNWILLING, (dispatcher, context) -> {
			return new UnwillingRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(MobEntityRegister.CYBERDEMON2016, (dispatcher, context) -> {
			return new Cyberdemon2016Render(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(MobEntityRegister.ICONOFSIN, (dispatcher, context) -> {
			return new IconofsinRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(MobEntityRegister.POSSESSEDSCIENTIST, (dispatcher, context) -> {
			return new PossessedScientistRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(MobEntityRegister.POSSESSEDSOLDIER, (dispatcher, context) -> {
			return new PossessedSoldierRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(MobEntityRegister.GARGOYLE, (dispatcher, context) -> {
			return new GargoyleRender(dispatcher);
		});

		EntityRendererRegistry.INSTANCE.register(MobEntityRegister.MECHAZOMBIE, (dispatcher, context) -> {
			return new MechaZombieRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(ProjectilesEntityRegister.ARGENT_BOLT, (dispatcher, context) -> {
			return new ArgentBoltRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(ProjectilesEntityRegister.SHOTGUN_SHELL, (dispatcher, context) -> {
			return new ShotgunShellRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(ProjectilesEntityRegister.ENERGY_CELL, (dispatcher, context) -> {
			return new EnergyCellRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(ProjectilesEntityRegister.BFG_CELL, (dispatcher, context) -> {
			return new BFGCellRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(ProjectilesEntityRegister.ROCKET, (dispatcher, context) -> {
			return new RocketRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(ProjectilesEntityRegister.BARENBLAST, (dispatcher, context) -> {
			return new BarenBlastRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(ProjectilesEntityRegister.BULLETS, (dispatcher, context) -> {
			return new BulletsRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(ProjectilesEntityRegister.CHAINGUN_BULLET, (dispatcher, context) -> {
			return new ChaingunBulletRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(ProjectilesEntityRegister.UNMAYKR, (dispatcher, context) -> {
			return new UnmaykrBulletRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(ProjectilesEntityRegister.ROCKET_MOB, (dispatcher, context) -> {
			return new RocketMobRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(ProjectilesEntityRegister.ENERGY_CELL_MOB, (dispatcher, context) -> {
			return new EnergyCellMobRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(ProjectilesEntityRegister.CHAINGUN_MOB, (dispatcher, context) -> {
			return new ChaingunMobRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(ProjectilesEntityRegister.FIRING, (dispatcher, context) -> {
			return new ArchvileFiringRender(dispatcher);
		});

		GeoArmorRenderer.registerArmorRenderer(DoomicornDoomArmor.class, new DoomicornRender());
		GeoArmorRenderer.registerArmorRenderer(NightmareDoomArmor.class, new NightmareRender());
		GeoArmorRenderer.registerArmorRenderer(PurplePonyDoomArmor.class, new PurplePonyRender());
		GeoArmorRenderer.registerArmorRenderer(DoomArmor.class, new DoomRender());
		GeoArmorRenderer.registerArmorRenderer(AstroDoomArmor.class, new AstroRender());
		GeoArmorRenderer.registerArmorRenderer(BronzeDoomArmor.class, new BronzeRender());
		GeoArmorRenderer.registerArmorRenderer(CrimsonDoomArmor.class, new CrimsonRender());
		GeoArmorRenderer.registerArmorRenderer(DemoncideDoomArmor.class, new DemoncideRender());
		GeoArmorRenderer.registerArmorRenderer(DemonicDoomArmor.class, new DemonicRender());
		GeoArmorRenderer.registerArmorRenderer(EmberDoomArmor.class, new EmberRender());
		GeoArmorRenderer.registerArmorRenderer(GoldDoomArmor.class, new GoldRender());
		GeoArmorRenderer.registerArmorRenderer(HotrodDoomArmor.class, new HotrodRender());
		GeoArmorRenderer.registerArmorRenderer(MidnightDoomArmor.class, new MidnightRender());
		GeoArmorRenderer.registerArmorRenderer(PhobosDoomArmor.class, new PhobosRender());
		GeoArmorRenderer.registerArmorRenderer(PraetorDoomArmor.class, new PraetorRender());
		GeoArmorRenderer.registerArmorRenderer(TwentyFiveDoomArmor.class, new TwentyFiveRender());
		GeoArmorRenderer.registerArmorRenderer(ClassicBronzeDoomArmor.class, new ClassicBronzeRender());
		GeoArmorRenderer.registerArmorRenderer(ClassicDoomArmor.class, new ClassicRender());
		GeoArmorRenderer.registerArmorRenderer(ClassicIndigoDoomArmor.class, new ClassicIndigoRender());
		GeoArmorRenderer.registerArmorRenderer(ClassicRedDoomArmor.class, new ClassicRedRender());
		GeoArmorRenderer.registerArmorRenderer(MulletDoomArmor.class, new Mullet1Render());
		GeoArmorRenderer.registerArmorRenderer(Mullet2DoomArmor.class, new Mullet2Render());
		GeoArmorRenderer.registerArmorRenderer(Mullet3DoomArmor.class, new Mullet3Render());
		GeoArmorRenderer.registerArmorRenderer(PainterDoomArmor.class, new PainterRender());
		GeoArmorRenderer.registerArmorRenderer(CultistDoomArmor.class, new CultistRender());
		GeoArmorRenderer.registerArmorRenderer(MaykrDoomArmor.class, new MaykrRender());
		GeoArmorRenderer.registerArmorRenderer(SentinelDoomArmor.class, new SentinelRender());
		GeoArmorRenderer.registerArmorRenderer(ZombieDoomArmor.class, new ZombieRender());
		GeoArmorRenderer.registerArmorRenderer(SantaDoomArmor.class, new SantaRender());
	}
}