package mod.azure.doom.entity;

import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.world.World;

public class DemonEntity extends HostileEntity {

	protected DemonEntity(EntityType<? extends HostileEntity> type, World worldIn) {
		super(type, worldIn);
	}
	
	@Override
	public Packet<?> createSpawnPacket() {
		return new EntitySpawnS2CPacket(this);
	}
	
	@Override
	public EntityGroup getGroup() {
		return EntityGroup.UNDEAD;
	}

}