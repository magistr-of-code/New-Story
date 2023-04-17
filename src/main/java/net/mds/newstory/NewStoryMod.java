package net.mds.newstory;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.mds.newstory.block.ModBlocks;
import net.mds.newstory.event.PlayerTickHandler;
import net.mds.newstory.item.ModItems;
import net.mds.newstory.networking.ModMessages;
import net.mds.newstory.story.MainStory;
import net.mds.newstory.world.dimension.ModDimensions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.GeckoLib;

public class NewStoryMod implements ModInitializer {
	public static final String MOD_ID = "newstory";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		MainStory.registerMainStory();
		ModDimensions.register();
		ModMessages.registerC2S();

		GeckoLib.initialize();

		ServerTickEvents.START_SERVER_TICK.register(new PlayerTickHandler());

		LOGGER.info("Hello Fabric world!");
	}
}
