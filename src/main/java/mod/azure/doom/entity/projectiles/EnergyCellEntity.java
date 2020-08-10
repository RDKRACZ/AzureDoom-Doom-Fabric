package mod.azure.doom.entity.projectiles;

import mod.azure.doom.EntityPacket;
import mod.azure.doom.util.DoomItems;
import mod.azure.doom.util.ProjectilesEntityRegister;
import mod.azure.doom.util.ModSoundEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Packet;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class EnergyCellEntity extends PersistentProjectileEntity {

	protected int timeInAir;
	protected boolean inAir;
	private int ticksInAir;

	public EnergyCellEntity(EntityType<? extends EnergyCellEntity> entityType, World world) {
		super(entityType, world);
		this.pickupType = PersistentProjectileEntity.PickupPermission.DISALLOWED;
	}

	public EnergyCellEntity(World world, LivingEntity owner) {
		super(ProjectilesEntityRegister.ARGENT_BOLT, owner, world);
	}

	protected EnergyCellEntity(EntityType<? extends EnergyCellEntity> type, double x, double y, double z, World world) {
		this(type, world);
	}

	protected EnergyCellEntity(EntityType<? extends EnergyCellEntity> type, LivingEntity owner, World world) {
		this(type, owner.getX(), owner.getEyeY() - 0.10000000149011612D, owner.getZ(), world);
		this.setOwner(owner);
		if (owner instanceof PlayerEntity) {
			this.pickupType = PersistentProjectileEntity.PickupPermission.ALLOWED;
		}

	}

	@Override
	public Packet<?> createSpawnPacket() {
		return EntityPacket.createPacket(this);
	}

	protected void func_225516_i_() {
		++this.ticksInAir;
		if (this.ticksInAir >= 40) {
			this.remove();
		}
	}

	@Override
	public void writeCustomDataToTag(CompoundTag tag) {
		super.writeCustomDataToTag(tag);
		tag.putShort("life", (short) this.ticksInAir);
	}

	@Override
	public void readCustomDataFromTag(CompoundTag tag) {
		super.readCustomDataFromTag(tag);
		this.ticksInAir = tag.getShort("life");
	}

	@Override
	public void tick() {
		super.tick();
		if (this.inGround && this.inGroundTime != 0 && this.ticksInAir >= 40) {
			this.world.sendEntityStatus(this, (byte) 0);
		}
	}

	public void initFromStack(ItemStack stack) {
		if (stack.getItem() == DoomItems.ARGENT_BOLT) {
		}
	}

	@Override
	public boolean hasNoGravity() {
		if (this.isSubmergedInWater()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	protected void onBlockHit(BlockHitResult blockHitResult) {
		super.onBlockHit(blockHitResult);
		if (!this.world.isClient) {
			this.explode();
			this.remove();
		}
		this.playSound(ModSoundEvents.PLASMA_HIT, 1.0F, 1.0F);
	}

	@Override
	protected void onEntityHit(EntityHitResult entityHitResult) {
		super.onEntityHit(entityHitResult);
		if (!this.world.isClient) {
			this.explode();
			this.remove();
		}
		this.playSound(ModSoundEvents.PLASMA_HIT, 1.0F, 1.0F);
	}

	@Override
	public ItemStack asItemStack() {
		return new ItemStack(DoomItems.ENERGY_CELLS);
	}

	protected void explode() {
		this.world.createExplosion(this, this.getX(), this.getBodyY(0.0625D), this.getZ(), 0.01F,
				Explosion.DestructionType.NONE);
	}
}