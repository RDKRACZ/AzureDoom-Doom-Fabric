package mod.azure.doom.util.registry;

import mod.azure.doom.DoomMod;
import mod.azure.doom.block.ArgentBlock;
import mod.azure.doom.block.ArgentLampBlock;
import mod.azure.doom.block.BarrelBlock;
import mod.azure.doom.block.DoomSandBlock;
import mod.azure.doom.block.DoomWallBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DoomBlocks {

	public static final Block DOOM_SAND = new DoomSandBlock();
	public static final Block ARGENT_BLOCK = new ArgentBlock();
	public static final Block BARREL_BLOCK = new BarrelBlock();
	public static final Block ARGENT_LAMP_BLOCK = new ArgentLampBlock();

	public static final Block DOOM_WALL1 = new DoomWallBlock();
	public static final Block DOOM_WALL2 = new DoomWallBlock();
	public static final Block DOOM_WALL3 = new DoomWallBlock();
	public static final Block DOOM_WALL4 = new DoomWallBlock();
	public static final Block DOOM_WALL5 = new DoomWallBlock();
	public static final Block DOOM_WALL6 = new DoomWallBlock();
	public static final Block DOOM_WALL7 = new DoomWallBlock();
	public static final Block DOOM_WALL8 = new DoomWallBlock();
	public static final Block DOOM_WALL9 = new DoomWallBlock();
	public static final Block DOOM_WALL10 = new DoomWallBlock();
	public static final Block DOOM_WALL11 = new DoomWallBlock();
	public static final Block DOOM_WALL12 = new DoomWallBlock();
	public static final Block DOOM_WALL13 = new DoomWallBlock();
	public static final Block DOOM_WALL14 = new DoomWallBlock();
	public static final Block DOOM_WALL15 = new DoomWallBlock();
	public static final Block DOOM_WALL16 = new DoomWallBlock();

	public static void init() {
		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "argent_block"), DoomBlocks.ARGENT_BLOCK);
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "argent_block"),
				new BlockItem(DoomBlocks.ARGENT_BLOCK, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));

		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "doom_sand"), DoomBlocks.DOOM_SAND);
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "doom_sand"),
				new BlockItem(DoomBlocks.DOOM_SAND, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));

		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "argent_lamp_block"),
				DoomBlocks.ARGENT_LAMP_BLOCK);
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "argent_lamp_block"),
				new BlockItem(DoomBlocks.ARGENT_LAMP_BLOCK, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));

		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "barrel"), DoomBlocks.BARREL_BLOCK);
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "barrel"),
				new BlockItem(DoomBlocks.BARREL_BLOCK, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));

		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "icon_wall1"), DoomBlocks.DOOM_WALL1);
		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "icon_wall2"), DoomBlocks.DOOM_WALL2);
		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "icon_wall3"), DoomBlocks.DOOM_WALL3);
		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "icon_wall4"), DoomBlocks.DOOM_WALL4);
		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "icon_wall5"), DoomBlocks.DOOM_WALL5);
		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "icon_wall6"), DoomBlocks.DOOM_WALL6);
		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "icon_wall7"), DoomBlocks.DOOM_WALL7);
		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "icon_wall8"), DoomBlocks.DOOM_WALL8);
		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "icon_wall9"), DoomBlocks.DOOM_WALL9);
		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "icon_wall10"), DoomBlocks.DOOM_WALL10);
		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "icon_wall11"), DoomBlocks.DOOM_WALL11);
		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "icon_wall12"), DoomBlocks.DOOM_WALL12);
		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "icon_wall13"), DoomBlocks.DOOM_WALL13);
		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "icon_wall14"), DoomBlocks.DOOM_WALL14);
		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "icon_wall15"), DoomBlocks.DOOM_WALL15);
		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "icon_wall16"), DoomBlocks.DOOM_WALL16);
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "icon_wall1"),
				new BlockItem(DoomBlocks.DOOM_WALL1, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "icon_wall2"),
				new BlockItem(DoomBlocks.DOOM_WALL2, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "icon_wall3"),
				new BlockItem(DoomBlocks.DOOM_WALL3, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "icon_wall4"),
				new BlockItem(DoomBlocks.DOOM_WALL4, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "icon_wall5"),
				new BlockItem(DoomBlocks.DOOM_WALL5, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "icon_wall6"),
				new BlockItem(DoomBlocks.DOOM_WALL6, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "icon_wall7"),
				new BlockItem(DoomBlocks.DOOM_WALL7, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "icon_wall8"),
				new BlockItem(DoomBlocks.DOOM_WALL8, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "icon_wall9"),
				new BlockItem(DoomBlocks.DOOM_WALL9, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "icon_wall10"),
				new BlockItem(DoomBlocks.DOOM_WALL10, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "icon_wall11"),
				new BlockItem(DoomBlocks.DOOM_WALL11, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "icon_wall12"),
				new BlockItem(DoomBlocks.DOOM_WALL12, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "icon_wall13"),
				new BlockItem(DoomBlocks.DOOM_WALL13, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "icon_wall14"),
				new BlockItem(DoomBlocks.DOOM_WALL14, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "icon_wall15"),
				new BlockItem(DoomBlocks.DOOM_WALL15, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "icon_wall16"),
				new BlockItem(DoomBlocks.DOOM_WALL16, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));
	}
}