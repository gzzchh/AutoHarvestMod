package com.misakacloud.autoharvst;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

public class KeyPressListener {
    public static final KeyBinding toggleKey = new KeyBinding("key.toggleAutoharvest", Keyboard.KEY_H, "key.categories.misc");

    public KeyPressListener() {
        ClientRegistry.registerKeyBinding(toggleKey);
    }

    @SubscribeEvent
    public void onKeyPressed(InputEvent.KeyInputEvent event) {
        if (toggleKey.isPressed()) {
            AutoHarvest a = AutoHarvest.instance;
            String modeName = a.toNextMode().toString().toLowerCase();
            AutoHarvest.msg("notify.switch_to." + modeName);
        }
    }
}
