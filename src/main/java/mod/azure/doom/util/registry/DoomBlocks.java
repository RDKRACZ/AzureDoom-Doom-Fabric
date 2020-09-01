package mod.azure.doom.util.registry;

import mod.azure.doom.DoomMod;
import mod.azure.doom.block.ArgentBlock;
import mod.azure.doom.block.ArgentLampBlock;
import mod.azure.doom.block.BarrelBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DoomBlocks {

	public static final Block ARGENT_BLOCK = new ArgentBlock();
	public static final Block BARREL_BLOCK = new BarrelBlock();
	public static final Block ARGENT_LAMP_BLOCK = new ArgentLampBlock();

	public static void init() {
		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "argent_block"), DoomBlocks.ARGENT_BLOCK);
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "argent_block"),
				new BlockItem(DoomBlocks.ARGENT_BLOCK, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));

		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "argent_lamp_block"),
				DoomBlocks.ARGENT_LAMP_BLOCK);
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "argent_lamp_block"),
				new BlockItem(DoomBlocks.ARGENT_LAMP_BLOCK, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));

		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "barrel"), DoomBlocks.BARREL_BLOCK);
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "barrel"),
				new BlockItem(DoomBlocks.BARREL_BLOCK, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));
	}
}