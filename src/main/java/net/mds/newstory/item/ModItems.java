package net.mds.newstory.item;

import net.mds.newstory.NewStoryMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.mds.newstory.item.custom.*;
import net.minecraft.item.EnderPearlItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {


    public static final Item DIMENSION_POWDER = registerItem("dimension_powder",
            new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item DIMENSION_PEARL = registerItem("dimension_pearl",
            new EnderPearlItem(new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item STEEL = registerItem("steel",
            new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    public static final Item MANGROVE_STICK = registerItem("mangrove_stick",
            new Item(new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item WAND = registerItem("wand",
            new Wand(new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item TRAINING_WAND = registerItem("training_wand",
            new TrainingWand(new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item SCROLL_OF_FIRE = registerItem("scroll_of_fire",
            new ScrollOfFire(new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item SCROLL_OF_BREAK = registerItem("scroll_of_break",
            new ScrollOfBreak(new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item SCROLL_OF_CARRYING = registerItem("scroll_of_carrying",
            new ScrollOfCarrying(new FabricItemSettings().group(ItemGroup.COMBAT)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM,new Identifier(NewStoryMod.MOD_ID,name),item);
    }



    public static void registerModItems() {
        NewStoryMod.LOGGER.debug("Registering Mod Items for " + NewStoryMod.MOD_ID);
    }
}

