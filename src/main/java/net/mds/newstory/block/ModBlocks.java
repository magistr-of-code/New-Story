package net.mds.newstory.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.mds.newstory.NewStoryMod;
import net.mds.newstory.block.custom.Cauldron;
import net.mds.newstory.block.custom.DoorLock;
import net.mds.newstory.block.custom.FallingGravel;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    private static  Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block,tab);
        return Registry.register(Registry.BLOCK, new Identifier(NewStoryMod.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        NewStoryMod.LOGGER.debug("Registering Mod Blocks for " + NewStoryMod.MOD_ID);
    }

    private static Item registerBlockItem(String name, Block block,ItemGroup tab) {
        return Registry.register(Registry.ITEM, new Identifier(NewStoryMod.MOD_ID, name), new BlockItem(block, new  FabricItemSettings().group(tab)));
    }
    public static final Block STEEL_BLOCK = registerBlock("steel_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(2f)), ItemGroup.DECORATIONS);
    public static final Block CAULDRON = registerBlock("cauldron",
              new Cauldron(FabricBlockSettings.of(Material.METAL).strength(2f)), ItemGroup.DECORATIONS);
    public static final Block DOOR_LOCK = registerBlock("door_lock",
            new DoorLock(FabricBlockSettings.of(Material.METAL).strength(2f)), ItemGroup.DECORATIONS);
    public static final Block FALLING_GRAVEL = registerBlock("falling_gravel",
            new FallingGravel(FabricBlockSettings.of(Material.METAL).strength(2f)), ItemGroup.REDSTONE);

}
