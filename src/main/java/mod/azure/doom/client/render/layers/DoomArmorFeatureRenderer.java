package mod.azure.doom.client.render.layers;

import java.util.Map;

import com.google.common.collect.Maps;

import me.sargunvohra.mcmods.autoconfig1u.shadowed.blue.endless.jankson.annotation.Nullable;
import mod.azure.doom.client.models.BipedModelSkin;
import mod.azure.doom.item.armor.skin.SkinArmor;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class DoomArmorFeatureRenderer<T extends LivingEntity, M extends BipedModelSkin<T>, A extends BipedModelSkin<T>>
		extends FeatureRenderer<T, M> {
	private static final Map<String, Identifier> ARMOR_TEXTURE_CACHE = Maps.newHashMap();
	private final A leggingsModel;
	private final A bodyModel;

	public DoomArmorFeatureRenderer(FeatureRendererContext<T, M> context, A leggingsModel, A bodyModel) {
		super(context);
		this.leggingsModel = leggingsModel;
		this.bodyModel = bodyModel;
	}

	public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity,
			float f, float g, float h, float j, float k, float l) {
		this.renderArmor(matrixStack, vertexConsumerProvider, livingEntity, EquipmentSlot.CHEST, i,
				this.getArmor(EquipmentSlot.CHEST));
		this.renderArmor(matrixStack, vertexConsumerProvider, livingEntity, EquipmentSlot.LEGS, i,
				this.getArmor(EquipmentSlot.LEGS));
		this.renderArmor(matrixStack, vertexConsumerProvider, livingEntity, EquipmentSlot.FEET, i,
				this.getArmor(EquipmentSlot.FEET));
		this.renderArmor(matrixStack, vertexConsumerProvider, livingEntity, EquipmentSlot.HEAD, i,
				this.getArmor(EquipmentSlot.HEAD));
	}

	private void renderArmor(MatrixStack matrices, VertexConsumerProvider vertexConsumers, T livingEntity,
			EquipmentSlot equipmentSlot, int i, A BipedModelSkin) {
		ItemStack itemStack = livingEntity.getEquippedStack(equipmentSlot);
		if (itemStack.getItem() instanceof SkinArmor) {
			SkinArmor armorItem = (SkinArmor) itemStack.getItem();
			if (armorItem.getSlotType() == equipmentSlot) {
				this.setVisible(BipedModelSkin, equipmentSlot);
				boolean bl = this.usesSecondLayer(equipmentSlot);
				boolean bl2 = itemStack.hasGlint();
				this.renderArmorParts(matrices, vertexConsumers, i, armorItem, bl2, BipedModelSkin, bl, 1.0F, 1.0F,
						1.0F, (String) null);

			}
		}
	}

	@SuppressWarnings("incomplete-switch")
	protected void setVisible(A bipedModel, EquipmentSlot slot) {
		bipedModel.setVisible(false);
		switch (slot) {
		case HEAD:
			bipedModel.head.visible = true;
			bipedModel.helmet.visible = true;
			break;
		case CHEST:
			bipedModel.torso.visible = true;
			bipedModel.rightArm.visible = true;
			bipedModel.leftArm.visible = true;
			break;
		case LEGS:
			bipedModel.torso.visible = true;
			bipedModel.rightLeg.visible = true;
			bipedModel.leftLeg.visible = true;
			break;
		case FEET:
			bipedModel.rightLeg.visible = true;
			bipedModel.leftLeg.visible = true;
		}

	}

	private void renderArmorParts(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i,
			SkinArmor armorItem, boolean bl, A BipedModelSkin, boolean bl2, float f, float g, float h,
			@Nullable String string) {
		VertexConsumer vertexConsumer = ItemRenderer.getArmorVertexConsumer(vertexConsumerProvider,
				RenderLayer.getArmorCutoutNoCull(this.getArmorTexture(armorItem, bl2, string)), false, bl);
		BipedModelSkin.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, f, g, h, 1.0F);
	}

	private A getArmor(EquipmentSlot slot) {
		return this.usesSecondLayer(slot) ? this.leggingsModel : this.bodyModel;
	}

	private boolean usesSecondLayer(EquipmentSlot slot) {
		return slot == EquipmentSlot.LEGS;
	}

	private Identifier getArmorTexture(SkinArmor armorItem, boolean bl, @Nullable String string) {
		String string2 = "textures/models/armor/" + armorItem.getMaterial().getName() + "_layer_" + (bl ? 2 : 1)
				+ (string == null ? "" : "_" + string) + ".png";
		return (Identifier) ARMOR_TEXTURE_CACHE.computeIfAbsent(string2, Identifier::new);
	}
}