package net.mds.newstory;


import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.mds.newstory.block.ModBlocks;
import net.mds.newstory.event.KeyInputHandler;
import net.mds.newstory.networking.ModMessages;
import net.minecraft.client.network.ClientLoginNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.world.tick.Tick;

public class NewStoryClient implements ClientModInitializer {


    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DOOR_LOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CAULDRON, RenderLayer.getTranslucent());

        KeyInputHandler.register();
        ModMessages.registerS2C();


    }
}
