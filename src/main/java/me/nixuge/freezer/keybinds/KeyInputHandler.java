package me.nixuge.freezer.keybinds;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

// Unneeded as used in a ticker in MinecraftMixin.java
public class KeyInputHandler {
    @SubscribeEvent
    public void onKeyInput(KeyInputEvent event) {
        if (Keybinds.freezeGame.isPressed()) {
            //
        } else if(Keybinds.altf4.isPressed()) {
            //
        }
    }
}