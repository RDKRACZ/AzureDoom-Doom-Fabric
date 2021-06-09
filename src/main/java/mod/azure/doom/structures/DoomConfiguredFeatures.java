package mod.azure.doom.structures;

import mod.azure.doom.DoomMod;
import mod.azure.doom.structures.generator.MaykrGenerator;
import mod.azure.doom.structures.generator.PortalGenerator;
import mod.azure.doom.structures.generator.TitanSkullGenerator;
import mod.azure.doom.util.RegistrationHelper;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;

public class DoomConfiguredFeatures {
	public static final ConfiguredStructureFeature<StructurePoolFeatureConfig, ?> PORTAL = DoomStructures.PORTAL
			.configure(new StructurePoolFeatureConfig(RegistrationHelper.pool(PortalGenerator.STARTING_POOL), 2));

	public static final ConfiguredStructureFeature<StructurePoolFeatureConfig, ?> TITAN_SKULL = DoomStructures.TITAN_SKULL
			.configure(new StructurePoolFeatureConfig(RegistrationHelper.pool(TitanSkullGenerator.STARTING_POOL), 2));

	public static final ConfiguredStructureFeature<StructurePoolFeatureConfig, ?> MAYKR = DoomStructures.MAYKR
			.configure(new StructurePoolFeatureConfig(RegistrationHelper.pool(MaykrGenerator.STARTING_POOL), 2));

	public static void registerConfiguredFeatures() {
		Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, new Identifier(DoomMod.MODID, "doom_portal"),
				PORTAL);
		Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, new Identifier(DoomMod.MODID, "doom_skull"),
				TITAN_SKULL);
		Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, new Identifier(DoomMod.MODID, "doom_maykr"),
				MAYKR);
	}
}
