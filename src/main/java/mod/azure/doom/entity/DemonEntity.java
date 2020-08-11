package mod.azure.doom.entity;

import mod.azure.doom.util.packets.EntityPacket;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.network.Packet;
import net.minecraft.world.World;

public class DemonEntity extends HostileEntity {

	protected DemonEntity(EntityType<? extends HostileEntity> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	public Packet<?> createSpawnPacket() {
		return EntityPacket.createPacket(this);
	}

	@Override
	public EntityGroup getGroup() {
		return EntityGroup.UNDEAD;
	}

	@Override
	@Environment(EnvType.CLIENT)
	public boolean shouldRender(double distance) {
		return true;
	}

}