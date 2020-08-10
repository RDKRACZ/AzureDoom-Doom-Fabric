package mod.azure.doom.util;

public class ModRegistry {

	public static DoomBlocks BLOCKS;
	public static ModSoundEvents SOUNDS;
	public static DoomItems ITEMS;
	public static ModEntityTypes MOBS;

	public static void init() {

		BLOCKS = new DoomBlocks();
		ITEMS = new DoomItems();
		SOUNDS = new ModSoundEvents();
		MOBS = new ModEntityTypes();

	}
}