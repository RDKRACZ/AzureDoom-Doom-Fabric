package mod.azure.doom.util;

import mod.azure.doom.util.packets.EntityPacket;
import mod.azure.doom.util.packets.EntityPacketOnClient;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;

public class ClientPacketRegister {
	public static void register() {
		ClientSidePacketRegistry.INSTANCE.register(EntityPacket.ID, (ctx, buf) -> {
            EntityPacketOnClient.onPacket(ctx, buf);
        });
	}
}
