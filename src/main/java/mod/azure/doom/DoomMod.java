package mod.azure.doom;

import mod.azure.doom.client.DoomRenderRegistry;
import mod.azure.doom.util.DoomBlocks;
import mod.azure.doom.util.DoomItems;
import mod.azure.doom.util.MobAttributes;
import mod.azure.doom.util.MobEntityRegister;
import mod.azure.doom.util.MobSpawn;
import mod.azure.doom.util.ModSoundEvents;
import mod.azure.doom.util.ProjectilesEntityRegister;
import mod.azure.doom.util.packets.EntityPacket;
import mod.azure.doom.util.packets.EntityPacketOnClient;
import nerdhub.cardinal.components.api.event.ItemComponentCallbackV2;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.CuriosComponent;
import top.theillusivec4.curios.api.SlotTypeInfo.BuildScheme;
import top.theillusivec4.curios.api.SlotTypePreset;
import top.theillusivec4.curios.api.type.component.ICurio;

public class DoomMod implements ModInitializer {

	public static final String MODID = "doom";

	public static final ItemGroup DoomItemGroup = FabricItemGroupBuilder.create(new Identifier(MODID, "doomweapon"))
			.icon(() -> new ItemStack(DoomItems.ARGENT_AXE)).build();

	public static DoomBlocks BLOCKS;
	public static ModSoundEvents SOUNDS;
	public static DoomItems ITEMS;
	public static MobEntityRegister MOBS;
	public static ProjectilesEntityRegister PROJECTILES;

	@Override
	public void onInitialize() {
		DoomBlocks.init();
		ITEMS = new DoomItems();
		SOUNDS = new ModSoundEvents();
		PROJECTILES = new ProjectilesEntityRegister();
		MOBS = new MobEntityRegister();
		DoomRenderRegistry.init();
		MobAttributes.init();
		MobSpawn.init();
		FuelRegistry.INSTANCE.add(DoomItems.ARGENT_ENERGY, 100000);
		ClientSidePacketRegistry.INSTANCE.register(EntityPacket.ID, (ctx, buf) -> {
			EntityPacketOnClient.onPacket(ctx, buf);
		});
		CuriosApi.enqueueSlotType(BuildScheme.REGISTER, SlotTypePreset.BELT.getInfoBuilder().build());
		CuriosApi.enqueueSlotType(BuildScheme.REGISTER, SlotTypePreset.CHARM.getInfoBuilder().build());
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
	}
}
