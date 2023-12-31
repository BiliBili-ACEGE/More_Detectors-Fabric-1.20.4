package net.ace.moredetectors.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.ace.moredetectors.moredetectors;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup Mod_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(moredetectors.MOD_ID, "moredetector"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.moredetector"))
                    .icon(() -> new ItemStack(ModItems.Iron_Detector)).entries((displayContext, entries) -> {
                        entries.add(ModItems.Copper_Detector);
                        entries.add(ModItems.Dye_Detector);
                        entries.add(ModItems.Iron_Detector);
                        entries.add(ModItems.Gold_Detector);
                        entries.add(ModItems.Diamond_Detector);
                        entries.add(ModItems.Emerald_Detector);
                        entries.add(ModItems.Netherite_Detector);





                    }).build());


    public static void registerItemGroups() {
        moredetectors.LOGGER.info("注册模组物品组 " + moredetectors.MOD_ID);
    }
}
