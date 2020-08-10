package mod.azure.doom.client;

import mod.azure.doom.client.render.ArchvileRender;
import mod.azure.doom.client.render.BarrelRender;
import mod.azure.doom.util.ModEntityTypes;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

public class DoomRenderRegistry {

	public static void init() {
		EntityRendererRegistry.INSTANCE.register(ModEntityTypes.ARCHVILE, (dispatcher, context) -> {
			return new ArchvileRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(ModEntityTypes.BARREL, (dispatcher, context) -> {
			return new BarrelRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(ModEntityTypes.SHOTGUN_SHELL, (dispatcher, context) -> {
			return new ArchvileRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(ModEntityTypes.ARGENT_BOLT, (dispatcher, context) -> {
			return new ArchvileRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(ModEntityTypes.ENERGY_CELL, (dispatcher, context) -> {
			return new ArchvileRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(ModEntityTypes.BULLETS, (dispatcher, context) -> {
			return new ArchvileRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(ModEntityTypes.BFG_CELL, (dispatcher, context) -> {
			return new ArchvileRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(ModEntityTypes.ROCKET, (dispatcher, context) -> {
			return new ArchvileRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(ModEntityTypes.CHAINGUN_BULLET, (dispatcher, context) -> {
			return new ArchvileRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(ModEntityTypes.BARENBLAST, (dispatcher, context) -> {
			return new ArchvileRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(ModEntityTypes.LOST_SOUL_SHOOT, (dispatcher, context) -> {
			return new ArchvileRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(ModEntityTypes.IMP, (dispatcher, context) -> {
			return new ArchvileRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(ModEntityTypes.PINKY, (dispatcher, context) -> {
			return new ArchvileRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(ModEntityTypes.LOST_SOUL, (dispatcher, context) -> {
			return new ArchvileRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(ModEntityTypes.CACODEMON, (dispatcher, context) -> {
			return new ArchvileRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(ModEntityTypes.BARON, (dispatcher, context) -> {
			return new ArchvileRender(dispatcher);
		});
//		EntityRendererRegistry.INSTANCE.register(ModEntityTypes.MANCUBUS, MancubusRender::new);
//		EntityRendererRegistry.INSTANCE.register(ModEntityTypes.SPIDERDEMON, SpiderdemonRender::new);
//		EntityRendererRegistry.INSTANCE.register(ModEntityTypes.ZOMBIEMAN, ZombiemanRender::new);
//		EntityRendererRegistry.INSTANCE.register(ModEntityTypes.REVENANT, RevenantRender::new);
//		EntityRendererRegistry.INSTANCE.register(ModEntityTypes.IMP2016, Imp2016Render::new);
//		EntityRendererRegistry.INSTANCE.register(ModEntityTypes.CHAINGUNNER, ChaingunnerRender::new);
//		EntityRendererRegistry.INSTANCE.register(ModEntityTypes.SHOTGUNGUY, ShotgunguyRender::new);
//		EntityRendererRegistry.INSTANCE.register(ModEntityTypes.MARAUDER, MarauderRender::new);
//		EntityRendererRegistry.INSTANCE.register(ModEntityTypes.PAIN, PainRender::new);
//		EntityRendererRegistry.INSTANCE.register(ModEntityTypes.HELLKNIGHT, HellknightRender::new);
//		EntityRendererRegistry.INSTANCE.register(ModEntityTypes.CYBERDEMON, CyberdemonRender::new);
//		EntityRendererRegistry.INSTANCE.register(ModEntityTypes.UNWILLING, UnwillingRender::new);
//		EntityRendererRegistry.INSTANCE.register(ModEntityTypes.CYBERDEMON2016, Cyberdemon2016Render::new);
//		EntityRendererRegistry.INSTANCE.register(ModEntityTypes.ICONOFSIN, IconofsinRender::new);
//		EntityRendererRegistry.INSTANCE.register(ModEntityTypes.POSSESSEDSCIENTIST, PossessedScientistRender::new);
//		EntityRendererRegistry.INSTANCE.register(ModEntityTypes.POSSESSEDSOLDIER, PossessedSoldierRender::new);

	}
}