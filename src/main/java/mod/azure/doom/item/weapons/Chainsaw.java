package mod.azure.doom.item.weapons;

import mod.azure.doom.DoomMod;
import mod.azure.doom.util.enums.DoomTier;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class Chainsaw extends SwordItem {

	public Chainsaw() {
		super(DoomTier.DOOM, 2, -2.4F,
				new Item.Settings().group(DoomMod.DoomWeaponItemGroup).maxCount(1).maxDamage(600));
	}

	@Override
	public boolean hasGlint(ItemStack stack) {
		return false;
	}

	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		LivingEntity user = (LivingEntity) entityIn;
		PlayerEntity player = (PlayerEntity) entityIn;
		final Vec3d facing = Vec3d.fromPolar(user.getRotationClient()).normalize();
		if (player.getMainHandStack().isItemEqualIgnoreDamage(stack) && stack.getDamage() < 599) {
			final Box aabb = new Box(entityIn.getBlockPos().up()).expand(1D, 1D, 1D).offset(facing.multiply(1D));
			entityIn.getEntityWorld().getOtherEntities(user, aabb).forEach(e -> doDamage(user, e));
			entityIn.getEntityWorld().getOtherEntities(user, aabb)
					.forEach(e -> e.world.addParticle(DustParticleEffect.RED, user.getParticleX(0.5D),
							user.getRandomBodyY() - 0.25D, user.getParticleZ(0.5D), 0.0D, 0D, 0D));
			if (!player.abilities.creativeMode) {
				stack.setDamage(stack.getDamage() + 1);
			}
		}
	}

	private void doDamage(final LivingEntity user, final Entity target) {
		target.damage(DamageSource.thorns(target), 2F);
	}

}