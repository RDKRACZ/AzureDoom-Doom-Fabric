package mod.azure.doom.config;

import io.github.prospector.modmenu.api.ConfigScreenFactory;
import io.github.prospector.modmenu.api.ModMenuApi;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import mod.azure.doom.DoomMod;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class ModMenuDoom implements ModMenuApi {
	@Override
	public ConfigScreenFactory<?> getModConfigScreenFactory() {
		return parent -> {
			return AutoConfig.getConfigScreen(DoomConfig.class, parent).get();
		};
	}

	@Override
	public String getModId() {
		return DoomMod.MODID;
	}
}
