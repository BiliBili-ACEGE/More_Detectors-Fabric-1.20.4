package net.ace.moredetectors.item;

import net.ace.moredetectors.item.custom.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.ace.moredetectors.moredetectors;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item Iron_Detector = registerItem("iron_detector",
            new IronDetectorItem(new FabricItemSettings().maxDamage(64)));
    public static final Item Diamond_Detector = registerItem("diamond_detector",
            new DiamondDetectorItem(new FabricItemSettings().maxDamage(64)));
    public static final Item Emerald_Detector = registerItem("emerald_detector",
            new Emerald_DetectorItem(new FabricItemSettings().maxDamage(64)));
    public static final Item Copper_Detector = registerItem("copper_detector",
            new Copper_DetectorItem(new FabricItemSettings().maxDamage(64)));
    public static final Item Gold_Detector = registerItem("gold_detector",
            new Gold_DetectorItem(new FabricItemSettings().maxDamage(64)));
    public static final Item Netherite_Detector = registerItem("netherite_detector",
            new Netherite_DetectorItem(new FabricItemSettings().maxDamage(64)));
    public static final Item Dye_Detector = registerItem("dye_detector",
            new Dye_DetectorItem(new FabricItemSettings().maxDamage(64)));


    private static void addItemsItemGroup(FabricItemGroupEntries entries) {
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(moredetectors.MOD_ID, name), item);
    }

    public static void registerModItems() {
        moredetectors.LOGGER.info("注册模组物品 " + moredetectors.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsItemGroup);
    }
}
