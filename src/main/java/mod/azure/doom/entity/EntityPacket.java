package mod.azure.doom.entity;

import java.util.UUID;

import io.netty.buffer.Unpooled;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;

/**
 * From UpcraftLP
 * https://discordapp.com/channels/507304429255393322/507982478276034570/625580783062482944
 * https://gitlab.com/biom4st3r/biow0rks/-/blob/master/src/main/java/com/biom4st3r/biow0rks/entities/EntityPacket.java
 */

public final class EntityPacket {
	private EntityPacket() {

	}

	/**
	 * Meant for overriding
	 * {@link net.minecraft.entity.LivingEntity#createSpawnPacket()}
	 */
	public static Packet<?> createSpawnPacket(Entity e, Identifier packetID) {
		PacketByteBuf pbb = new PacketByteBuf(Unpooled.buffer());
		pbb.writeVarInt(Registry.ENTITY_TYPE.getRawId(e.getType()));
		pbb.writeUuid(e.getUuid());
		pbb.writeVarInt(e.getEntityId());
		pbb.writeDouble(e.getX());
		pbb.writeDouble(e.getY());
		pbb.writeDouble(e.getZ());
		pbb.writeByte(MathHelper.floor(e.pitch * 256.0F / 360.0F));
		pbb.writeByte(MathHelper.floor(e.yaw * 256.0F / 360.0F));
		return ServerSidePacketRegistry.INSTANCE.toPacket(packetID, pbb);
	}

	@Environment(EnvType.CLIENT)
	public static void client_RegisterEntityPacket(Identifier packetID) {
		ClientSidePacketRegistry.INSTANCE.register(packetID, (context, pbb) -> {
			EntityType<?> et = Registry.ENTITY_TYPE.get(pbb.readVarInt());
			UUID uuid = pbb.readUuid();
			int entityId = pbb.readVarInt();
			double x = pbb.readDouble();
			double y = pbb.readDouble();
			double z = pbb.readDouble();
			float pitch = (pbb.readByte() * 360) / 256.0F;
			float yaw = (pbb.readByte() * 360) / 256.0F;
			context.getTaskQueue().execute(() -> {
				ClientWorld world = MinecraftClient.getInstance().world;
				Entity e = et.create(world);
				e.updateTrackedPosition(x, y, z);
				e.setPos(x, y, z);
				e.pitch = pitch;
				e.yaw = yaw;
				e.setEntityId(entityId);
				e.setUuid(uuid);
				world.addEntity(entityId, e);
			});
		});
	}

}
