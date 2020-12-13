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

	public static final Block E1M1_1 = new ArgentBlock();
	public static final Block E1M1_2 = new ArgentBlock();
	public static final Block E1M1_3 = new ArgentBlock();
	public static final Block E1M1_4 = new ArgentBlock();
	public static final Block E1M1_5 = new ArgentBlock();
	public static final Block E1M1_6 = new ArgentBlock();
	public static final Block DOOM_SAND = new DoomSandBlock();
	public static final Block ARGENT_BLOCK = new ArgentBlock();
	public static final Block BARREL_BLOCK = new BarrelBlock();
	public static final Block ICON_WALL1 = new DoomWallBlock();
	public static final Block ICON_WALL2 = new DoomWallBlock();
	public static final Block ICON_WALL3 = new DoomWallBlock();
	public static final Block ICON_WALL4 = new DoomWallBlock();
	public static final Block ICON_WALL5 = new DoomWallBlock();
	public static final Block ICON_WALL6 = new DoomWallBlock();
	public static final Block ICON_WALL7 = new DoomWallBlock();
	public static final Block ICON_WALL8 = new DoomWallBlock();
	public static final Block ICON_WALL9 = new DoomWallBlock();
	public static final Block ICON_WALL10 = new DoomWallBlock();
	public static final Block ICON_WALL11 = new DoomWallBlock();
	public static final Block ICON_WALL12 = new DoomWallBlock();
	public static final Block ICON_WALL13 = new DoomWallBlock();
	public static final Block ICON_WALL14 = new DoomWallBlock();
	public static final Block ICON_WALL15 = new DoomWallBlock();
	public static final Block ICON_WALL16 = new DoomWallBlock();
	public static final Block ARGENT_LAMP_BLOCK = new ArgentLampBlock();

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

		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "icon_wall1"), DoomBlocks.ICON_WALL1);
		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "icon_wall2"), DoomBlocks.ICON_WALL2);
		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "icon_wall3"), DoomBlocks.ICON_WALL3);
		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "icon_wall4"), DoomBlocks.ICON_WALL4);
		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "icon_wall5"), DoomBlocks.ICON_WALL5);
		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "icon_wall6"), DoomBlocks.ICON_WALL6);
		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "icon_wall7"), DoomBlocks.ICON_WALL7);
		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "icon_wall8"), DoomBlocks.ICON_WALL8);
		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "icon_wall9"), DoomBlocks.ICON_WALL9);
		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "icon_wall10"), DoomBlocks.ICON_WALL10);
		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "icon_wall11"), DoomBlocks.ICON_WALL11);
		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "icon_wall12"), DoomBlocks.ICON_WALL12);
		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "icon_wall13"), DoomBlocks.ICON_WALL13);
		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "icon_wall14"), DoomBlocks.ICON_WALL14);
		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "icon_wall15"), DoomBlocks.ICON_WALL15);
		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "icon_wall16"), DoomBlocks.ICON_WALL16);
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "icon_wall1"),
				new BlockItem(DoomBlocks.ICON_WALL1, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "icon_wall2"),
				new BlockItem(DoomBlocks.ICON_WALL2, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "icon_wall3"),
				new BlockItem(DoomBlocks.ICON_WALL3, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "icon_wall4"),
				new BlockItem(DoomBlocks.ICON_WALL4, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "icon_wall5"),
				new BlockItem(DoomBlocks.ICON_WALL5, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "icon_wall6"),
				new BlockItem(DoomBlocks.ICON_WALL6, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "icon_wall7"),
				new BlockItem(DoomBlocks.ICON_WALL7, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "icon_wall8"),
				new BlockItem(DoomBlocks.ICON_WALL8, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "icon_wall9"),
				new BlockItem(DoomBlocks.ICON_WALL9, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "icon_wall10"),
				new BlockItem(DoomBlocks.ICON_WALL10, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "icon_wall11"),
				new BlockItem(DoomBlocks.ICON_WALL11, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "icon_wall12"),
				new BlockItem(DoomBlocks.ICON_WALL12, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "icon_wall13"),
				new BlockItem(DoomBlocks.ICON_WALL13, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "icon_wall14"),
				new BlockItem(DoomBlocks.ICON_WALL14, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "icon_wall15"),
				new BlockItem(DoomBlocks.ICON_WALL15, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "icon_wall16"),
				new BlockItem(DoomBlocks.ICON_WALL16, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));

		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "e1m1_block1"), DoomBlocks.E1M1_1);
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "e1m1_block1"),
				new BlockItem(DoomBlocks.E1M1_1, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));

		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "e1m1_block2"), DoomBlocks.E1M1_2);
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "e1m1_block2"),
				new BlockItem(DoomBlocks.E1M1_2, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));

		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "e1m1_block3"), DoomBlocks.E1M1_3);
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "e1m1_block3"),
				new BlockItem(DoomBlocks.E1M1_3, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));

		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "e1m1_block4"), DoomBlocks.E1M1_4);
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "e1m1_block4"),
				new BlockItem(DoomBlocks.E1M1_4, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));

		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "e1m1_block5"), DoomBlocks.E1M1_5);
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "e1m1_block5"),
				new BlockItem(DoomBlocks.E1M1_5, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));

		Registry.register(Registry.BLOCK, new Identifier(DoomMod.MODID, "e1m1_block6"), DoomBlocks.E1M1_6);
		Registry.register(Registry.ITEM, new Identifier(DoomMod.MODID, "e1m1_block6"),
				new BlockItem(DoomBlocks.E1M1_6, new Item.Settings().group(DoomMod.DoomBlockItemGroup)));
	}
}