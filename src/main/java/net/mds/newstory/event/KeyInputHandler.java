package net.mds.newstory.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static final String KEY_CATEGORY_MENU = "key.category.newstory.menu";
    public static final String KEY_QUESTS = "key.newstory.quests";

    public static KeyBinding questsKey;

    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (questsKey.isPressed()) {
                client.player.sendMessage(Text.of("yes"));
            }
        });
    }

    public static void register() {
        questsKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_QUESTS,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_G,
                KEY_CATEGORY_MENU
        ));

        registerKeyInputs();
    }

}
