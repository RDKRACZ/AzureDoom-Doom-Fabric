package mod.azure.doom.client.render;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.ArchvileModel;
import mod.azure.doom.entity.ArchvileEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;

public class ArchvileRender extends MobEntityRenderer<ArchvileEntity, ArchvileModel<ArchvileEntity>> {

	protected static final Identifier TEXTURE = new Identifier(DoomMod.MODID, "textures/entity/archvile.png");

	public ArchvileRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new ArchvileModel<>(0.0F), 0.5F);
	}

	@Override
	public void render(ArchvileEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStack,
			VertexConsumerProvider vertexConsumerProvider, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStack, vertexConsumerProvider, packedLightIn);
	}

	@Override
	public Vec3d getPositionOffset(ArchvileEntity entityIn, float partialTicks) {
		return super.getPositionOffset(entityIn, partialTicks);
	}

	@Override
	public Identifier getTexture(ArchvileEntity entity) {
		return TEXTURE;
	}

}