package net.packages.flying_machines.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.text.Text;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import net.packages.flying_machines.entity.Entities;
import net.packages.flying_machines.flying_machines;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.List;

public class Items {
    public static final Item DYLAN_MK1_SCHEME = registerItem("dylan_mk1_scheme", new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item CENTRAL_AI_PROCESSOR = registerItem("central_ai_processor", new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE).fireproof()));
    public static final Item TITANIUM_INGOT = registerItem("titanium_ingot", new Item(new FabricItemSettings()));
    public static final Item GRADE_5_TITANIUM_INGOT = registerItem("grade_5_titanium_ingot", new Item(new FabricItemSettings()));
    public static final Item GRADE_5_TITANIUM_SHEET = registerItem("grade_5_titanium_sheet", new Item(new FabricItemSettings()));
    public static final Item SOLID_AUTOMATON_CASING = registerItem("solid_automaton_casing", new Item(new FabricItemSettings()));
    public static final Item TITANIUM_NUGGET = registerItem("titanium_nugget", new Item(new FabricItemSettings()));
    public static final Item TITANIUM_SHEET = registerItem("titanium_sheet", new Item(new FabricItemSettings()));
    public static final Item RAW_TITANIUM = registerItem("raw_titanium", new Item(new FabricItemSettings()));
    public static final Item CRUSHED_RAW_TITANIUM = registerItem("crushed_raw_titanium", new Item(new FabricItemSettings()));
    public static final Item RAW_SILICON = registerItem("raw_silicon", new Item(new FabricItemSettings()));
    public static final Item PURIFIED_SILICON = registerItem("purified_silicon", new Item(new FabricItemSettings()));
    public static final Item ALUMINIUM_INGOT = registerItem("aluminium_ingot", new Item(new FabricItemSettings()));
    public static final Item RAW_ALUMINIUM = registerItem("raw_aluminium", new Item(new FabricItemSettings()));
    public static final Item CRUSHED_RAW_ALUMINIUM = registerItem("crushed_raw_aluminium", new Item(new FabricItemSettings()));
    public static final Item UNACTIVATED_DYLAN = registerItem("unactivated_dylan", new SpawnEggItem(Entities.DYLAN, 0x86518, 0x3b260f, new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC).fireproof()));
    public static final Item BEEF_TARTARE = registerItem("beef_tartare", new Item(new FabricItemSettings().food(FoodComponents.BEEF_TARTARE)));
    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(flying_machines.MOD_ID, name), item);
    }

    public static void registerModItems() {
        flying_machines.LOGGER.info("Registering Mod Items for " + flying_machines.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(Items::addItemsToIngredientItemGroup);

    }
}