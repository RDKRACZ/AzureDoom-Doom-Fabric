package mod.azure.doom.structures;

import mod.azure.doom.DoomMod;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;

public class DoomConfiguredStructures {

	public static ConfiguredStructureFeature<?, ?> CONFIGURED_DOOM1 = DoomStructures.DOOM1.configure(DefaultFeatureConfig.DEFAULT);


    public static void registerConfiguredStructures() {
        Registry<ConfiguredStructureFeature<?, ?>> registry = BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE;
        Registry.register(registry, new Identifier(DoomMod.MODID, "configured_doom1"), CONFIGURED_DOOM1);
    }
}
