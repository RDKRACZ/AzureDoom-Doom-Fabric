package mod.azure.doom.util;

import mod.azure.doom.structures.generator.MaykrGenerator;
import mod.azure.doom.structures.generator.PortalGenerator;

public class StructureHelper {

	public static void initOverworldPools() {
		PortalGenerator.init();
	}

	public static void initNetherPools() {
		MaykrGenerator.init();
	}

	public static void initEndPools() {
		MaykrGenerator.init();
	}
}
