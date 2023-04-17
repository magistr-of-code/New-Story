package net.mds.newstory.story.managers;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

import java.util.concurrent.atomic.AtomicInteger;

public class EntryPointsManager {
    public static boolean[] taskReady;
    public static void activeTimeTask(EntryPoints point,int time){
        AtomicInteger ticks = new AtomicInteger();
        while (ticks.get() != time * 20) {
            ClientTickEvents.END_CLIENT_TICK.register(client -> {
                ticks.getAndIncrement();
            });
        }
        point.setActive(true);
    }
}
