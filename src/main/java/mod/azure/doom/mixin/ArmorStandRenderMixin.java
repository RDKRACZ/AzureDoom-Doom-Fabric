package mod.azure.doom.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import mod.azure.doom.client.models.BipedModelSkin;
import mod.azure.doom.client.render.layers.DoomArmorFeatureRenderer;
import net.minecraft.client.render.entity.ArmorStandEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.model.ArmorStandEntityModel;
import net.minecraft.entity.decoration.ArmorStandEntity;

@Mixin(ArmorStandEntityRenderer.class)
public abstract class ArmorStandRenderMixin extends LivingEntityRenderer<ArmorStandEntity, ArmorStandEntityModel> {
	public ArmorStandRenderMixin(EntityRenderDispatcher entityRenderDispatcher, ArmorStandEntityModel model,
			float shadowSize) {
		super(entityRenderDispatcher, model, shadowSize);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Inject(at = @At("RETURN"), method = "<init>")
	public void onConstruct(EntityRenderDispatcher dispatcher, CallbackInfo info) {
		this.addFeature(new DoomArmorFeatureRenderer(this, new BipedModelSkin(0.5F), new BipedModelSkin(1.0F)));
	}
}