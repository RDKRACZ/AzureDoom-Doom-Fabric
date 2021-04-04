package mod.azure.doom;

import java.util.HashMap;
import java.util.Map;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import mod.azure.doom.config.DoomConfig;
import mod.azure.doom.entity.tileentity.IconBlockEntity;
import mod.azure.doom.mixin.StructuresConfigAccessor;
import mod.azure.doom.network.PacketHandler;
import mod.azure.doom.structures.DoomConfiguredStructures;
import mod.azure.doom.structures.DoomStructures;
import mod.azure.doom.util.DoomVillagerTrades;
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
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.ConstantLootTableRange;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.chunk.StructureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import software.bernie.geckolib3.GeckoLib;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.CuriosComponent;
import top.theillusivec4.curios.api.SlotTypeInfo.BuildScheme;
import top.theillusivec4.curios.api.SlotTypePreset;
import top.theillusivec4.curios.api.type.component.ICurio;

@SuppressWarnings("deprecation")
public class DoomMod implements ModInitializer {

	public static DoomItems ITEMS;
	public static DoomConfig config;
	public static ModSoundEvents SOUNDS;
	public static MobEntityRegister MOBS;
	public static final String MODID = "doom";
	public static BlockEntityType<IconBlockEntity> ICON;
	public static ProjectilesEntityRegister PROJECTILES;
	public static final Identifier BFG = new Identifier(MODID, "bfg");
	public static final Identifier PISTOL = new Identifier(MODID, "pistol");
	public static final Identifier PLASMA = new Identifier(MODID, "plamsa");
	public static final Identifier BFG9000 = new Identifier(MODID, "bfg9000");
	public static final Identifier SHOTGUN = new Identifier(MODID, "shotgun");
	public static final Identifier UNMAYKR = new Identifier(MODID, "unmaykr");
	public static final Identifier BALLISTA = new Identifier(MODID, "ballista");
	public static final Identifier CHAINGUN = new Identifier(MODID, "chaingun");
	public static final Identifier CHAINSAW = new Identifier(MODID, "chainsaw");
	public static final Identifier CRUCIBLE = new Identifier(MODID, "crucible");
	public static final Identifier RELOAD_GUN = new Identifier(MODID, "gun_reload");
	public static final Identifier HEAVYCANNON = new Identifier(MODID, "heavycannon");
	public static final Identifier SUPERSHOTGUN = new Identifier(MODID, "supershotgun");
	public static final Identifier ROCKETLAUNCHER = new Identifier(MODID, "rocketlauncher");
	public static final Identifier CHAINSAW_ETERNAL = new Identifier(MODID, "chainsaweternal");
	public static final Identifier FALL_DISTANCE_PACKET_ID = new Identifier(MODID, "falldistance");
	public static final ItemGroup DoomEggItemGroup = FabricItemGroupBuilder.create(new Identifier(MODID, "eggs"))
			.icon(() -> new ItemStack(DoomItems.IMP_SPAWN_EGG)).build();
	public static final ItemGroup DoomArmorItemGroup = FabricItemGroupBuilder.create(new Identifier(MODID, "armor"))
			.icon(() -> new ItemStack(DoomItems.DOOM_HELMET)).build();
	public static final ItemGroup DoomBlockItemGroup = FabricItemGroupBuilder.create(new Identifier(MODID, "blocks"))
			.icon(() -> new ItemStack(DoomBlocks.BARREL_BLOCK)).build();
	public static final ItemGroup DoomWeaponItemGroup = FabricItemGroupBuilder.create(new Identifier(MODID, "weapons"))
			.icon(() -> new ItemStack(DoomItems.BFG_ETERNAL)).build();
	public static final ItemGroup DoomPowerUPItemGroup = FabricItemGroupBuilder.create(new Identifier(MODID, "powerup"))
			.icon(() -> new ItemStack(DoomItems.INMORTAL)).build();

	@Override
	public void onInitialize() {
		AutoConfig.register(DoomConfig.class, Toml4jConfigSerializer::new);
		config = AutoConfig.getConfigHolder(DoomConfig.class).getConfig();
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
		RegistryEntryAddedCallback.event(BuiltinRegistries.BIOME).register((i, id, biome) -> {
			MobSpawn.addSpawnEntries();
		});
		ServerLifecycleEvents.SERVER_STARTED.register(minecraftServer -> DoomVillagerTrades.addTrades());
		MobAttributes.init();
		GeckoLib.initialize();
		if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
			DoomStructures.setupAndRegisterStructureFeatures();
			DoomConfiguredStructures.registerConfiguredStructures();
			BiomeModifications.create(new Identifier(MODID, "doom_end")).add(ModificationPhase.ADDITIONS,
					BiomeSelectors.all(), context -> {
						context.getGenerationSettings().addBuiltInStructure(DoomConfiguredStructures.CONFIGURED_DOOM1);
					});
			removeStructureSpawningFromSelectedDimension();
		}
		CuriosApi.enqueueSlotType(BuildScheme.REGISTER, SlotTypePreset.BELT.getInfoBuilder().build());
		CuriosApi.enqueueSlotType(BuildScheme.REGISTER, SlotTypePreset.CHARM.getInfoBuilder().build());
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
		PacketHandler.registerMessages();
	}

	public static void removeStructureSpawningFromSelectedDimension() {
		ServerWorldEvents.LOAD.register((MinecraftServer minecraftServer, ServerWorld serverWorld) -> {
			Map<StructureFeature<?>, StructureConfig> tempMap = new HashMap<>(
					serverWorld.getChunkManager().getChunkGenerator().getStructuresConfig().getStructures());
			if (!serverWorld.getRegistryKey().getValue().getNamespace().equals("minecraft")) {
				tempMap.keySet().remove(DoomStructures.DOOM1);
			}
			if (!serverWorld.getRegistryKey().getValue().getPath().equals("the_end")) {
				tempMap.keySet().remove(DoomStructures.DOOM1);
			}

			((StructuresConfigAccessor) serverWorld.getChunkManager().getChunkGenerator().getStructuresConfig())
					.setStructures(tempMap);
		});
	}
}
