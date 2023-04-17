package net.mds.newstory.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.mds.newstory.util.IEntityDataSaver;
import net.mds.newstory.util.ManaData;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.profiling.jfr.event.ServerTickTimeEvent;

public class PlayerTickHandler implements ServerTickEvents.StartTick {

    public static int tick = 0;

    @Override
    public void onStartTick(MinecraftServer server) {
        tick++;
        for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
            //IEntityDataSaver dataSaver = ((IEntityDataSaver) player);
            //ManaData.addMana(dataSaver,1);
           // player.sendMessage(Text.of(String.valueOf(dataSaver.getPersistentData().getInt("mana"))));
        }
    }
}
