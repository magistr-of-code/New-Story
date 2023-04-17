package net.mds.newstory.story;

import net.mds.newstory.NewStoryMod;
import net.mds.newstory.story.managers.EntryPoints;
import net.mds.newstory.story.managers.EntryPointsManager;
import net.mds.newstory.world.dimension.ModDimensions;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.lang.management.ManagementFactory;

public class MainStory{
    public static EntryPoints angel = new EntryPoints(1,false,"angel");
    public static EntryPoints spawn = new EntryPoints(2,false,"spawn");
    public static EntryPoints end = new EntryPoints(3,false,"end");
    public static EntryPoints guard = new EntryPoints(4,false,"guard");
    public static EntryPoints city = new EntryPoints(5,false,"city");
    public static EntryPoints wand = new EntryPoints(6,false,"wand");

    public static void registerMainStory() {
        NewStoryMod.LOGGER.debug("Registering Main story for " + NewStoryMod.MOD_ID);
    }

    public static class main extends Thread{
        PlayerEntity player; World world;
        public main(PlayerEntity player, World world) {
            this.world = world;
            this.player = player;
        }

        @Override
        public void run() {
            //start
            wand.setActive(true);
            EntryPointsManager.activeTimeTask(guard,1);
            while (!guard.getActive()){}
            player.sendMessage(Text.of("yes"));
            //end
        }
    }
}
