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

public class DoomConfiguredStructures {

	public static ConfiguredStructureFeature<?, ?> CONFIGURED_MAYKR = DoomStructures.MAYKR
			.configure(new StructurePoolFeatureConfig(RegistrationHelper.pool(MaykrGenerator.STARTING_POOL), 2));
	public static ConfiguredStructureFeature<?, ?> CONFIGURED_TITAN_SKULL = DoomStructures.TITAN_SKULL
			.configure(new StructurePoolFeatureConfig(RegistrationHelper.pool(TitanSkullGenerator.STARTING_POOL), 2));
	public static ConfiguredStructureFeature<?, ?> CONFIGURED_PORTAL = DoomStructures.PORTAL
			.configure(new StructurePoolFeatureConfig(RegistrationHelper.pool(PortalGenerator.STARTING_POOL), 2));

	public static void registerConfiguredStructures() {
		Registry<ConfiguredStructureFeature<?, ?>> registry = BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE;
		Registry.register(registry, new Identifier(DoomMod.MODID, "configured_maykr"), CONFIGURED_MAYKR);
		Registry.register(registry, new Identifier(DoomMod.MODID, "configured_titan_skull"), CONFIGURED_TITAN_SKULL);
		Registry.register(registry, new Identifier(DoomMod.MODID, "configured_portal"), CONFIGURED_PORTAL);
	}

}
