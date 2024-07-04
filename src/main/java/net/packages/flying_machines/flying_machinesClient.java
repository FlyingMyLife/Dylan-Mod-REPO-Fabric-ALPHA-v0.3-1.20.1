package net.packages.flying_machines;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.packages.flying_machines.entity.Entities;
import net.packages.flying_machines.entity.client.ModelLayers;
import net.packages.flying_machines.entity.client.DylanModel;
import net.packages.flying_machines.entity.client.DylanRenderer;

public class flying_machinesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(Entities.DYLAN, DylanRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModelLayers.DYLAN, DylanModel::getTexturedModelData);

    }
}