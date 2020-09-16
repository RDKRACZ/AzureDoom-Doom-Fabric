package mod.azure.doom.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

import mod.azure.doom.client.models.BipedModelSkin;
import mod.azure.doom.client.render.layers.DoomArmorFeatureRenderer;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.model.PlayerEntityModel;

@Mixin(value = PlayerEntityRenderer.class, priority = 1500)
public abstract class PlayerRenderMixin
		extends LivingEntityRenderer<AbstractClientPlayerEntity, PlayerEntityModel<AbstractClientPlayerEntity>> {

	public boolean callAddFeature(
			FeatureRenderer<AbstractClientPlayerEntity, PlayerEntityModel<AbstractClientPlayerEntity>> renderer) {
		return false;
	}

	public PlayerRenderMixin(EntityRenderDispatcher dispatcher, PlayerEntityModel<AbstractClientPlayerEntity> model,
			float shadowRadius) {
		super(dispatcher, model, shadowRadius);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Inject(at = @At("PlayerEntityRenderer"), method = "<init>(Lnet.minecraft.client.render.entity.PlayerEntityRenderer;Z)V")
	public void PlayerEntityRenderer(EntityRenderDispatcher dispatcher, boolean bl) {
		this.addFeature(new DoomArmorFeatureRenderer(this, new BipedModelSkin(0.5F), new BipedModelSkin(1.0F)));
	}
}
