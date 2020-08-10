package mod.azure.doom;

import mod.azure.doom.client.DoomRenderRegistry;
import mod.azure.doom.util.DoomItems;
import mod.azure.doom.util.ModRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class DoomMod implements ModInitializer {

	public static final String MODID = "doom";

	public static final ItemGroup DoomItemGroup = FabricItemGroupBuilder.create(new Identifier(MODID, "other"))
			.icon(() -> new ItemStack(DoomItems.ARGENT_AXE)).build();

	@Override
	public void onInitialize() {
		ModRegistry.init();
		DoomRenderRegistry.init();
	}
}
