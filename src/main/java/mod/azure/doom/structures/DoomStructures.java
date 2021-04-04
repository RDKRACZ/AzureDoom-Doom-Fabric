package mod.azure.doom.structures;

import mod.azure.doom.DoomMod;
import net.fabricmc.fabric.api.structure.v1.FabricStructureBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.chunk.StructureConfig;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

public class DoomStructures {

	public static StructureFeature<DefaultFeatureConfig> DOOM1 = new DoomStructure(DefaultFeatureConfig.CODEC);

	public static void setupAndRegisterStructureFeatures() {

		FabricStructureBuilder.create(new Identifier(DoomMod.MODID, "doom1"), DOOM1)
				.step(GenerationStep.Feature.SURFACE_STRUCTURES).defaultConfig(new StructureConfig(20, 11, 1234567890))
				.superflatFeature(DOOM1.configure(FeatureConfig.DEFAULT)).adjustsSurface().register();
	}
}