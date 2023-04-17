package net.mds.newstory.world.dimension;

import net.mds.newstory.NewStoryMod;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class ModDimensions {
    public static final RegistryKey<World> SPAWN_DIMENSION_KEY = RegistryKey.of(Registry.WORLD_KEY,
            new Identifier(NewStoryMod.MOD_ID, "spawn"));
    public static final RegistryKey<DimensionType> SPAWN_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY,
            SPAWN_DIMENSION_KEY.getValue());
    public static final RegistryKey<World> END_DIMENSION_KEY = RegistryKey.of(Registry.WORLD_KEY,
            new Identifier(NewStoryMod.MOD_ID, "end"));
    public static final RegistryKey<DimensionType> END_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY,
            END_DIMENSION_KEY.getValue());


    public static void register() {
        NewStoryMod.LOGGER.debug("Registering ModDimensions for " + NewStoryMod.MOD_ID);
    }
}