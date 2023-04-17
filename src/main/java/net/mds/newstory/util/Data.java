package net.mds.newstory.util;

import net.minecraft.nbt.NbtCompound;

public class Data {
    public static int add(IEntityDataSaver player, int amount, String key,int max) {
        NbtCompound nbt = player.getPersistentData();
        int NBT = nbt.getInt(key);

        if (NBT + amount >= max) {
            NBT = max;
        } else {
            NBT += amount;
        }

        nbt.putInt(key, NBT);

        return NBT;
    }

    public static int Remove(IEntityDataSaver player, int amount, String key) {
        NbtCompound nbt = player.getPersistentData();
        int NBT = nbt.getInt(key);

        if (NBT - amount <= 0) {
            NBT = 0;
        } else {
            NBT -= amount;
        }

        nbt.putInt(key, NBT);

        return NBT;
    }
}
