package net.packages.flying_machines;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.packages.flying_machines.block.Blocks;
import net.packages.flying_machines.entity.Entities;
import net.packages.flying_machines.entity.custom.DylanEntity;
import net.packages.flying_machines.gui.DylanScreen;
import net.packages.flying_machines.gui.DylanScreenHandler;
import net.packages.flying_machines.item.ItemGroups;
import net.packages.flying_machines.item.Items;
import net.packages.flying_machines.sound.Sounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class flying_machines implements ModInitializer {
	public static final ScreenHandlerType<DylanScreenHandler> DYLAN_SCREEN_HANDLER;

	static {
		DYLAN_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier("flying_machines", "dylan_screen"), DylanScreenHandler::new);
	}

	public static final RegistryKey<PlacedFeature> LARGE_TITANIUM_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier("flying_machines","ore_titanium_large"));
	public static final RegistryKey<PlacedFeature> SMALL_TITANIUM_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier("flying_machines","ore_titanium_small"));
	public static final RegistryKey<PlacedFeature> LARGE_ALUMINIUM_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier("flying_machines","ore_aluminium_large"));
	public static final RegistryKey<PlacedFeature> SMALL_ALUMINIUM_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier("flying_machines","ore_aluminium_small"));
	public static final String MOD_ID = "flying_machines";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	@Override
	public void onInitialize() {
		ScreenRegistry.register(DYLAN_SCREEN_HANDLER, DylanScreen::new);
		Sounds.registerSounds();
		ItemGroups.registerItemGroups();
		Items.registerModItems();
		Blocks.registerModBlocks();
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, LARGE_TITANIUM_ORE_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, SMALL_TITANIUM_ORE_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, LARGE_ALUMINIUM_ORE_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, SMALL_ALUMINIUM_ORE_PLACED_KEY);
		FabricDefaultAttributeRegistry.register((EntityType<? extends LivingEntity>) Entities.DYLAN, DylanEntity.createDylanAttributes());

	}
}