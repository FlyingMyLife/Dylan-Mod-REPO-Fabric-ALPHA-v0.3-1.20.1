package net.packages.flying_machines.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.packages.flying_machines.flying_machines;
import net.packages.flying_machines.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ItemGroups {
    public static final ItemGroup DYLAN_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(flying_machines.MOD_ID, "unactivated_dylan"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.titanium_ingot"))
                    .icon(() -> new ItemStack(Items.TITANIUM_INGOT)).entries((displayContext, entries) -> {
                        entries.add(Items.RAW_TITANIUM);
                        entries.add(Items.CRUSHED_RAW_TITANIUM);
                        entries.add(Items.TITANIUM_INGOT);
                        entries.add(Items.TITANIUM_NUGGET);
                        entries.add(Items.TITANIUM_SHEET);
                        entries.add(Blocks.TITANIUM_BLOCK);
                        entries.add(Blocks.TITANIUM_ORE);
                        entries.add(Blocks.DEEPSLATE_TITANIUM_ORE);
                        entries.add(Items.GRADE_5_TITANIUM_INGOT);
                        entries.add(Items.GRADE_5_TITANIUM_SHEET);
                        entries.add(Items.RAW_ALUMINIUM);
                        entries.add(Items.CRUSHED_RAW_ALUMINIUM);
                        entries.add(Items.ALUMINIUM_INGOT);
                        entries.add(Blocks.ALUMINIUM_ORE);
                        entries.add(Items.RAW_SILICON);
                        entries.add(Items.PURIFIED_SILICON);
                        entries.add(Blocks.DEEPSLATE_ALUMINIUM_ORE);
                        entries.add(Items.UNACTIVATED_DYLAN);
                        entries.add(Items.SOLID_AUTOMATON_CASING);
                        entries.add(Items.CENTRAL_AI_PROCESSOR);
                        entries.add(Items.DYLAN_MK1_SCHEME);
                        entries.add(Items.BEEF_TARTARE);
                    }).build());


    public static void registerItemGroups() {
        flying_machines.LOGGER.info("Registering Item Groups for " + flying_machines.MOD_ID);
    }
}
