package mod.azure.doom.block;

import mod.azure.doom.entity.projectiles.BarrelEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class BarrelBlock extends Block {

	public BarrelBlock(AbstractBlock.Settings properties) {
		super(properties);
	}

	@Override
	public boolean shouldDropItemsOnExplosion(Explosion explosion) {
		return false;
	}

	@Override
	public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
		if (world.isReceivingRedstonePower(pos)) {
			primeBlock(world, pos);
			world.removeBlock(pos, false);
		}
	}

	@Override
	public void neighborUpdate(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos,
			boolean isMoving) {
		primeBlock(worldIn, pos);
		worldIn.removeBlock(pos, false);
	}

	public void onExplosionDestroy(World world, BlockPos pos, Explosion explosionIn) {
		if (!world.isClient) {
			BarrelEntity tntentity = new BarrelEntity(world, (double) pos.getX() + 0.5D, (double) pos.getY(),
					(double) pos.getZ() + 0.5D, explosionIn.getCausingEntity());
			world.spawnEntity(tntentity);
		}
	}

	public static void primeBlock(World world, BlockPos pos) {
		primeBlock(world, pos, (LivingEntity) null);
	}

	private static void primeBlock(World world, BlockPos pos, LivingEntity igniter) {
		if (!world.isClient) {
			BarrelEntity tntEntity = new BarrelEntity(world, (double) pos.getX() + 0.5D, (double) pos.getY(),
					(double) pos.getZ() + 0.5D, igniter);
			world.spawnEntity(tntEntity);
			world.playSound((PlayerEntity) null, tntEntity.getX(), tntEntity.getY(), tntEntity.getZ(),
					SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
		}
	}

	@Override
	public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
		if (!world.isClient() && !player.isCreative()) {
			primeBlock(world, pos);
		}
		super.onBreak(world, pos, state, player);
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,
			BlockHitResult hit) {
		ItemStack itemStack = player.getStackInHand(hand);
		Item item = itemStack.getItem();
		if (item != Items.FLINT_AND_STEEL && item != Items.FIRE_CHARGE) {
			return super.onUse(state, world, pos, player, hand, hit);
		} else {
			primeBlock(world, pos, player);
			world.setBlockState(pos, Blocks.AIR.getDefaultState(), 11);
			return ActionResult.success(world.isClient);
		}
	}

	@Override
	public void onProjectileHit(World world, BlockState state, BlockHitResult hit, ProjectileEntity projectile) {
		if (!world.isClient) {
			Entity entity = projectile.getOwner();
			BlockPos blockPos = hit.getBlockPos();
			primeBlock(world, blockPos, entity instanceof LivingEntity ? (LivingEntity) entity : null);
			world.removeBlock(blockPos, false);
		}
	}

	@Override
	@Environment(EnvType.CLIENT)
	public float getAmbientOcclusionLightLevel(BlockState state, BlockView world, BlockPos pos) {
		return 10F;
	}

}