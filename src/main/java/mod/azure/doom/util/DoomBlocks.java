package mod.azure.doom.util;

import mod.azure.doom.DoomMod;
import mod.azure.doom.block.BarrelBlock;
import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DoomBlocks {

	public static BarrelBlock BARREL_BLOCK = of("barrel", new BarrelBlock(
			Settings.of(Material.METAL).sounds(BlockSoundGroup.METAL).nonOpaque()));

	static <T extends Block> T of(String id, T c) {
		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, id), c);
		return c;
	}
}