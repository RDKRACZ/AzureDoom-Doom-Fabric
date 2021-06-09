package mod.azure.doom.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import mod.azure.doom.util.StructureHelper;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePools;

@Mixin(StructurePools.class)
public class StructurePoolsMixin {
	@Inject(at = @At("TAIL"), method = "initDefaultPools", cancellable = true)
	private static void initModPools(CallbackInfoReturnable<StructurePool> info) {
		StructureHelper.initEndPools();
		StructureHelper.initOverworldPools();
		StructureHelper.initNetherPools();
	}
}
