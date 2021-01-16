package mod.azure.doom.client.render.armors;

import com.mojang.blaze3d.systems.RenderSystem;

import mod.azure.doom.client.models.armor.Mullet2Model;
import mod.azure.doom.item.armor.Mullet2DoomArmor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.DiffuseLighting;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import software.bernie.geckolib3.geo.render.built.GeoModel;
import software.bernie.geckolib3.renderer.geo.GeoArmorRenderer;

public class Mullet2Render extends GeoArmorRenderer<Mullet2DoomArmor> {
	public Mullet2Render() {
		super(new Mullet2Model());

		this.headBone = "armorHead";
		this.bodyBone = "armorBody";
		this.rightArmBone = "armorRightArm";
		this.leftArmBone = "armorLeftArm";
		this.rightLegBone = "armorLeftLeg";
		this.leftLegBone = "armorRightLeg";
		this.rightBootBone = "armorLeftBoot";
		this.leftBootBone = "armorRightBoot";
	}

	@Override
	public void render(GeoModel model, Mullet2DoomArmor animatable, float partialTicks, RenderLayer type,
			MatrixStack matrixStackIn, VertexConsumerProvider RenderLayerBuffer, VertexConsumer vertexBuilder,
			int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		super.render(model, animatable, partialTicks, type, matrixStackIn, RenderLayerBuffer, vertexBuilder,
				packedLightIn, packedOverlayIn, red, green, blue, alpha);
		matrixStackIn.push();
		VertexConsumerProvider.Immediate iRenderLayerbuffer$impl = MinecraftClient.getInstance().getBufferBuilders()
				.getEntityVertexConsumers();
		DiffuseLighting.disableGuiDepthLighting();
		iRenderLayerbuffer$impl.draw();
		RenderSystem.enableDepthTest();
		DiffuseLighting.enableGuiDepthLighting();
		matrixStackIn.pop();
	}
}