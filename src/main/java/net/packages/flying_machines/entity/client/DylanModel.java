// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package net.packages.flying_machines.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.packages.flying_machines.entity.animation.Animations;
import net.packages.flying_machines.entity.custom.DylanEntity;

public class DylanModel<T extends DylanEntity> extends SinglePartEntityModel<T> {
	private final ModelPart dylan;;
	private final ModelPart head;
	private final ModelPart body;

	public DylanModel(ModelPart dylan) {
		this.dylan = dylan.getChild("dylan");
		this.body = this.dylan.getChild("body");
		this.head = this.body.getChild("torso").getChild("head");
	}

    public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData dylan = modelPartData.addChild("dylan", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData body = dylan.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -18.0F, 0.0F));

		ModelPartData torso = body.addChild("torso", ModelPartBuilder.create().uv(19, 35).cuboid(-4.0F, -6.0F, -3.0F, 8.0F, 12.0F, 1.0F, new Dilation(0.0F))
		.uv(16, 16).cuboid(-4.0F, -6.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData head = torso.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -9.0F, 0.0F));

		ModelPartData head_r1 = head.addChild("head_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-7.0F, -6.0F, -3.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, 1.0F, -1.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData hood = head.addChild("hood", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData Bottom_r1 = hood.addChild("Bottom_r1", ModelPartBuilder.create().uv(48, 38).cuboid(-4.0F, -1.0F, 0.0F, 8.0F, 3.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 4.0F, 4.0F, -1.5708F, 0.0F, 0.0F));

		ModelPartData R4_r1 = hood.addChild("R4_r1", ModelPartBuilder.create().uv(52, 56).cuboid(-2.0F, 1.5F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-5.0F, 0.5F, 2.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData L4_r1 = hood.addChild("L4_r1", ModelPartBuilder.create().uv(52, 54).cuboid(-2.0F, 1.5F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, 0.5F, 2.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData L3_r1 = hood.addChild("L3_r1", ModelPartBuilder.create().uv(52, 61).cuboid(-2.0F, 0.5F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, 0.5F, 3.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData R3_r1 = hood.addChild("R3_r1", ModelPartBuilder.create().uv(52, 58).cuboid(-2.0F, 0.5F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-5.0F, 0.5F, 3.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData R2_r1 = hood.addChild("R2_r1", ModelPartBuilder.create().uv(56, 59).cuboid(-2.0F, -1.5F, -1.0F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-5.0F, 1.5F, 4.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData L2_r1 = hood.addChild("L2_r1", ModelPartBuilder.create().uv(60, 53).cuboid(-2.0F, -1.5F, -1.0F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, 1.5F, 4.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData L1_r1 = hood.addChild("L1_r1", ModelPartBuilder.create().uv(56, 53).cuboid(-2.0F, -2.5F, -1.0F, 1.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, 1.5F, 5.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData R1_r1 = hood.addChild("R1_r1", ModelPartBuilder.create().uv(60, 58).cuboid(-2.0F, -2.5F, -1.0F, 1.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-5.0F, 1.5F, 5.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData back_r1 = hood.addChild("back_r1", ModelPartBuilder.create().uv(42, 32).cuboid(-8.0F, -2.0F, 4.0F, 10.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData headphone = head.addChild("headphone", ModelPartBuilder.create().uv(32, 8).cuboid(-1.0F, -2.0F, -2.0F, 2.0F, 4.0F, 4.0F, new Dilation(0.0F))
		.uv(49, 12).cuboid(0.0F, -4.0F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(44, 12).cuboid(9.0F, -4.0F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(42, 0).cuboid(0.0F, -5.0F, -1.0F, 10.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(40, 4).cuboid(9.0F, -2.0F, -2.0F, 2.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, -1.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData lefthand = body.addChild("lefthand", ModelPartBuilder.create().uv(40, 16).cuboid(-2.0F, -3.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(6.0F, -3.0F, 0.0F));

		ModelPartData righthand = body.addChild("righthand", ModelPartBuilder.create().uv(32, 48).cuboid(-2.0F, -3.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-6.0F, -3.0F, 0.0F));

		ModelPartData rightleg = body.addChild("rightleg", ModelPartBuilder.create().uv(16, 48).cuboid(-2.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 8.0F, 0.0F));

		ModelPartData leftleg = body.addChild("leftleg", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, 8.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		dylan.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
	@Override
	public ModelPart getPart() {
		return dylan;
	}

	@Override
	public void setAngles(DylanEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
	this.getPart().traverse().forEach(ModelPart::resetTransform);
	this.setHeadAngles(headYaw, headPitch);
	this.animateMovement(Animations.WALK, limbAngle, limbDistance, 2f, 2.5f);
	this.updateAnimation(entity.attackAnimationState , Animations.ATTACK, entity.age, 1f);
	this.updateAnimation(entity.idleAnimationState , Animations.IDLE, entity.age, 1f);
	}
	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
	}
}