package mod.azure.doom.structures;

import mod.azure.doom.DoomMod;
import mod.azure.doom.structures.templates.MaykrStructure;
import mod.azure.doom.structures.templates.PortalStructure;
import mod.azure.doom.structures.templates.TitanSkullStructure;
import net.fabricmc.fabric.api.structure.v1.FabricStructureBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.chunk.StructureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;

public class DoomStructures {

	public static StructureFeature<StructurePoolFeatureConfig> MAYKR = new MaykrStructure();

	public static StructureFeature<StructurePoolFeatureConfig> TITAN_SKULL = new TitanSkullStructure();

	public static StructureFeature<StructurePoolFeatureConfig> PORTAL = new PortalStructure();

	public static void setupAndRegisterStructureFeatures() {

		FabricStructureBuilder.create(new Identifier(DoomMod.MODID, "maykr"), MAYKR)
				.step(GenerationStep.Feature.SURFACE_STRUCTURES).defaultConfig(new StructureConfig(20, 11, 1234567890))
				.superflatFeature(DoomConfiguredFeatures.MAYKR).adjustsSurface().register();

		FabricStructureBuilder.create(new Identifier(DoomMod.MODID, "titan_skull"), TITAN_SKULL)
				.step(GenerationStep.Feature.UNDERGROUND_DECORATION).defaultConfig(new StructureConfig(80, 20, 1234567890))
				.superflatFeature(DoomConfiguredFeatures.TITAN_SKULL).adjustsSurface().register();

		FabricStructureBuilder.create(new Identifier(DoomMod.MODID, "portal"), PORTAL)
				.step(GenerationStep.Feature.SURFACE_STRUCTURES).defaultConfig(new StructureConfig(80, 20, 1234567890))
				.superflatFeature(DoomConfiguredFeatures.PORTAL).adjustsSurface().register();
	}
}