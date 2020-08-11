package mod.azure.doom.util;

import mod.azure.doom.DoomMod;
import mod.azure.doom.block.BarrelBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DoomBlocks {

	public static final Block BARREL_BLOCK = new BarrelBlock(
			FabricBlockSettings.of(Material.METAL).sounds(BlockSoundGroup.METAL).nonOpaque());

	static <T extends Block> T of(String id, T c) {
		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, id), c);
		return c;
	}
}