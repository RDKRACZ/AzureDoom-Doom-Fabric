package mod.azure.doom.structures.generator;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;

import mod.azure.doom.DoomMod;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.structure.pool.StructurePools;
import net.minecraft.util.Identifier;

public class MaykrGenerator {

	public static final StructurePool STARTING_POOL = StructurePools
			.register(new StructurePool(new Identifier(DoomMod.MODID, "maykr/start_pools"), new Identifier("empty"),
					ImmutableList
							.of(new Pair<>(StructurePoolElement.method_30425(DoomMod.MODID + ":maykr"), 1)),
					StructurePool.Projection.RIGID));

	public static void init() {

	}
}
