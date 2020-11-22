package mod.azure.doom;

import mod.azure.doom.entity.tileentity.IconBlockEntity;
import mod.azure.doom.util.MobAttributes;
import mod.azure.doom.util.MobSpawn;
import mod.azure.doom.util.ModSoundEvents;
import mod.azure.doom.util.registry.DoomBlocks;
import mod.azure.doom.util.registry.DoomEnchantments;
import mod.azure.doom.util.registry.DoomItems;
import mod.azure.doom.util.registry.DoomLoot;
import mod.azure.doom.util.registry.MobEntityRegister;
import mod.azure.doom.util.registry.ProjectilesEntityRegister;
import nerdhub.cardinal.components.api.event.ItemComponentCallbackV2;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.ConstantLootTableRange;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import software.bernie.geckolib3.GeckoLib;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.CuriosComponent;
import top.theillusivec4.curios.api.SlotTypeInfo.BuildScheme;
import top.theillusivec4.curios.api.SlotTypePreset;
import top.theillusivec4.curios.api.type.component.ICurio;

@SuppressWarnings("deprecation")
public class DoomMod implements ModInitializer {

	public static DoomItems ITEMS;
	public static ModSoundEvents SOUNDS;
	public static MobEntityRegister MOBS;
	public static final String MODID = "doom";
	public static ProjectilesEntityRegister PROJECTILES;
	public static BlockEntityType<IconBlockEntity> ICON;
	public static final Identifier FALL_DISTANCE_PACKET_ID = new Identifier("walljump", "falldistance");
	public static final ItemGroup DoomEggItemGroup = FabricItemGroupBuilder.create(new Identifier(MODID, "eggs"))
			.icon(() -> new ItemStack(DoomItems.IMP_SPAWN_EGG)).build();
	public static final ItemGroup DoomArmorItemGroup = FabricItemGroupBuilder.create(new Identifier(MODID, "armor"))
			.icon(() -> new ItemStack(DoomItems.DOOM_HELMET)).build();
	public static final ItemGroup DoomBlockItemGroup = FabricItemGroupBuilder.create(new Identifier(MODID, "blocks"))
			.icon(() -> new ItemStack(DoomBlocks.BARREL_BLOCK)).build();
	public static final ItemGroup DoomWeaponItemGroup = FabricItemGroupBuilder.create(new Identifier(MODID, "weapons"))
			.icon(() -> new ItemStack(DoomItems.CRUCIBLESWORD)).build();
	public static final ItemGroup DoomPowerUPItemGroup = FabricItemGroupBuilder.create(new Identifier(MODID, "powerup"))
			.icon(() -> new ItemStack(DoomItems.INMORTAL)).build();

	@Override
	public void onInitialize() {
		DoomBlocks.init();
		ITEMS = new DoomItems();
		SOUNDS = new ModSoundEvents();
		MOBS = new MobEntityRegister();
		PROJECTILES = new ProjectilesEntityRegister();
		DoomEnchantments.init();
		FuelRegistry.INSTANCE.add(DoomItems.ARGENT_ENERGY, 32767);
		ICON = Registry.register(Registry.BLOCK_ENTITY_TYPE, MODID + ":icon",
				BlockEntityType.Builder.create(IconBlockEntity::new, DoomBlocks.ICON_WALL1).build(null));
		MobSpawn.addSpawnEntries();
//		if (FabricLoader.getInstance().isModLoaded("string")) {
//			BNCompat.addSpawnEntries;
//		}
		RegistryEntryAddedCallback.event(BuiltinRegistries.BIOME).register((i, id, biome) -> {
			MobSpawn.addSpawnEntries();
		});
		MobAttributes.init();
		GeckoLib.initialize();
		CuriosApi.enqueueSlotType(BuildScheme.REGISTER, SlotTypePreset.BELT.getInfoBuilder().build());
		CuriosApi.enqueueSlotType(BuildScheme.REGISTER, SlotTypePreset.CHARM.getInfoBuilder().build());
		CuriosApi.enqueueSlotType(BuildScheme.REGISTER, SlotTypePreset.BRACELET.getInfoBuilder().build());
		LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
			if (DoomLoot.BASTION_BRIDGE.equals(id) || DoomLoot.BASTION_HOGLIN_STABLE.equals(id)
					|| DoomLoot.BASTION_OTHER.equals(id) || DoomLoot.BASTION_TREASURE.equals(id)
					|| DoomLoot.NETHER_BRIDGE.equals(id) || DoomLoot.RUINED_PORTAL.equals(id)
					|| DoomLoot.SPAWN_BONUS_CHEST.equals(id)) {
				FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
						.rolls(ConstantLootTableRange.create(1))
						.withEntry(ItemEntry.builder(DoomItems.INMORTAL).build())
						.withEntry(ItemEntry.builder(DoomItems.INVISIBLE).build())
						.withEntry(ItemEntry.builder(DoomItems.MEGA).build())
						.withEntry(ItemEntry.builder(DoomItems.POWER).build())
						.withEntry(ItemEntry.builder(DoomItems.SOULCUBE).build())
						.withEntry(ItemEntry.builder(DoomItems.DAISY).build());
				supplier.pool(poolBuilder);
			}
		});
		ItemComponentCallbackV2.event(DoomItems.SOULCUBE).register(
				((item, itemStack, componentContainer) -> componentContainer.put(CuriosComponent.ITEM, new ICurio() {
					@Override
					public boolean canRightClickEquip() {
						return true;
					}
				})));
		ItemComponentCallbackV2.event(DoomItems.DOOM_BLADE).register(
				((item, itemStack, componentContainer) -> componentContainer.put(CuriosComponent.ITEM, new ICurio() {
					@Override
					public boolean canRightClickEquip() {
						return true;
					}

					@Override
					public void onEquip(String identifier, int index, LivingEntity livingEntity) {
						if (livingEntity instanceof PlayerEntity) {
							startPowers((PlayerEntity) livingEntity);
						}
					}

					@Override
					public void onUnequip(String identifier, int index, LivingEntity livingEntity) {
						if (livingEntity instanceof PlayerEntity) {
							stopPowers((PlayerEntity) livingEntity);
						}
					}

					private void startPowers(PlayerEntity player) {
						player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 10000000, 0));
					}

					private void stopPowers(PlayerEntity player) {
						player.removeStatusEffect(StatusEffects.STRENGTH);
					}

					@Override
					public void curioTick(String identifier, int index, LivingEntity livingEntity) {
						if (livingEntity instanceof PlayerEntity) {
							PlayerEntity player = ((PlayerEntity) livingEntity);
							startPowers(player);
						}
					}

					@Override
					public boolean canEquip(String identifier, LivingEntity entityLivingBase) {
						return !CuriosApi.getCuriosHelper().findEquippedCurio(DoomItems.DAISY, entityLivingBase)
								.isPresent();
					}
				})));
		ItemComponentCallbackV2.event(DoomItems.DAISY).register(
				((item, itemStack, componentContainer) -> componentContainer.put(CuriosComponent.ITEM, new ICurio() {
					@Override
					public boolean canRightClickEquip() {
						return true;
					}

					@Override
					public void onEquip(String identifier, int index, LivingEntity livingEntity) {
						if (livingEntity instanceof PlayerEntity) {
							startPowers((PlayerEntity) livingEntity);
						}
					}

					@Override
					public void onUnequip(String identifier, int index, LivingEntity livingEntity) {
						if (livingEntity instanceof PlayerEntity) {
							stopPowers((PlayerEntity) livingEntity);
						}
					}

					private void startPowers(PlayerEntity player) {
						player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 10000000, 2));
					}

					private void stopPowers(PlayerEntity player) {
						player.removeStatusEffect(StatusEffects.SPEED);
					}

					@Override
					public void curioTick(String identifier, int index, LivingEntity livingEntity) {
						if (livingEntity instanceof PlayerEntity) {
							PlayerEntity player = ((PlayerEntity) livingEntity);
							startPowers(player);
						}
					}

					@Override
					public boolean canEquip(String identifier, LivingEntity entityLivingBase) {
						return !CuriosApi.getCuriosHelper().findEquippedCurio(DoomItems.DAISY, entityLivingBase)
								.isPresent();
					}
				})));

		// Packets
		ServerSidePacketRegistry.INSTANCE.register(FALL_DISTANCE_PACKET_ID, ((packetContext, packetByteBuf) -> {
			float fallDistance = packetByteBuf.readFloat();
			packetContext.getTaskQueue().execute(() -> {
				packetContext.getPlayer().fallDistance = fallDistance;
			});
		}));
	}
}
