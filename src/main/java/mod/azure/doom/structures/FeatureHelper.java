package mod.azure.doom.structures;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.structure.Structure;
import net.minecraft.structure.StructurePlacementData;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.chunk.Chunk;

public class FeatureHelper {

	public static void placeStructure(Identifier structureId, BlockPos pos, StructureWorldAccess world, Random random) {
		Structure structure = world.toServerWorld().getStructureManager().getStructureOrBlank(structureId);
		BlockRotation blockRotation = BlockRotation.random(random);
		StructurePlacementData structurePlacementData = (new StructurePlacementData()).setMirror(BlockMirror.NONE)
				.setRotation(blockRotation).setIgnoreEntities(true);
		structure.place(world, pos, pos, structurePlacementData, random, 2);
	}

	// Returns false if it can't generate, returns true if it can generate.
	public static boolean checkChunksForStructures(StructureWorldAccess world, BlockPos pos) {
		List<Chunk> chunksToScan = new ArrayList<>(9);
		chunksToScan.add(world.getChunk(pos));
		chunksToScan.add(world.getChunk(pos.add(16, 0, 16)));
		chunksToScan.add(world.getChunk(pos.add(-16, 0, -16)));
		chunksToScan.add(world.getChunk(pos.add(0, 0, 16)));
		chunksToScan.add(world.getChunk(pos.add(16, 0, 0)));
		chunksToScan.add(world.getChunk(pos.add(-16, 0, 0)));
		chunksToScan.add(world.getChunk(pos.add(0, 0, -16)));
		chunksToScan.add(world.getChunk(pos.add(16, 0, -16)));
		chunksToScan.add(world.getChunk(pos.add(-16, 0, 16)));
		for (Chunk chunk : chunksToScan) {
			if (!chunk.getStructureReferences(DoomConfiguredFeatures.PORTAL.feature).isEmpty()
					|| !chunk.getStructureReferences(DoomConfiguredFeatures.MAYKR.feature).isEmpty()
					|| !chunk.getStructureReferences(DoomConfiguredFeatures.TITAN_SKULL.feature).isEmpty()) {
				return false;
			}
		}

		return true;
	}
}
