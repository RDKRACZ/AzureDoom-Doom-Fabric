package mod.azure.doom.client;

import mod.azure.doom.client.render.ArchvileRender;
import mod.azure.doom.client.render.BaronRender;
import mod.azure.doom.client.render.BarrelRender;
import mod.azure.doom.client.render.CacodemonRender;
import mod.azure.doom.client.render.ChaingunnerRender;
import mod.azure.doom.client.render.Cyberdemon2016Render;
import mod.azure.doom.client.render.CyberdemonRender;
import mod.azure.doom.client.render.HellknightRender;
import mod.azure.doom.client.render.IconofsinRender;
import mod.azure.doom.client.render.Imp2016Render;
import mod.azure.doom.client.render.ImpRender;
import mod.azure.doom.client.render.LostSoulRender;
import mod.azure.doom.client.render.MancubusRender;
import mod.azure.doom.client.render.MarauderRender;
import mod.azure.doom.client.render.PainRender;
import mod.azure.doom.client.render.PinkyRender;
import mod.azure.doom.client.render.PossessedScientistRender;
import mod.azure.doom.client.render.PossessedSoldierRender;
import mod.azure.doom.client.render.RevenantRender;
import mod.azure.doom.client.render.ShotgunguyRender;
import mod.azure.doom.client.render.SpiderdemonRender;
import mod.azure.doom.client.render.UnwillingRender;
import mod.azure.doom.client.render.ZombiemanRender;
import mod.azure.doom.util.MobEntityRegister;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

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
		EntityRendererRegistry.INSTANCE.register(MobEntityRegister.ZOMBIEMAN, (dispatcher, context) -> {
			return new ZombiemanRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(MobEntityRegister.REVENANT, (dispatcher, context) -> {
			return new RevenantRender(dispatcher);
		});
		EntityRendererRegistry.INSTANCE.register(MobEntityRegister.IMP2016, (dispatcher, context) -> {
			return new Imp2016Render(dispatcher);
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
	}
}