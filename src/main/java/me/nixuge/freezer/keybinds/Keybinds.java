package me.nixuge.freezer.keybinds;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class Keybinds {
    public static KeyBinding altf4 = new KeyBinding("Crash", Keyboard.KEY_P, "Freezer");
    public static KeyBinding freezeGame = new KeyBinding("Freeze", Keyboard.KEY_H, "Freezer");
    public static void register() {
        ClientRegistry.registerKeyBinding(altf4);
        ClientRegistry.registerKeyBinding(freezeGame);
    }
}
