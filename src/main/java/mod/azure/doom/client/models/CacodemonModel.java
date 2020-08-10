package mod.azure.doom.client.models;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.CompositeEntityModel;
import net.minecraft.entity.Entity;

public class CacodemonModel<T extends Entity> extends CompositeEntityModel<T> {
	private final ImmutableList<ModelPart> field_228260_b_;

	public CacodemonModel() {
		Builder<ModelPart> builder = ImmutableList.builder();
		ModelPart ModelPart = new ModelPart(this, 0, 0);
		ModelPart.addCuboid(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F);
		ModelPart.pivotY = 17.6F;
		builder.add(ModelPart);

		this.field_228260_b_ = builder.build();
	}



	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw,
			float headPitch) {
		
	}

	public Iterable<ModelPart> getParts() {
		return this.field_228260_b_;
	}
}